package ac.soton.eventb.atomicity.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.Constructor;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Xor;

public class ActivityDiagramViewServices {

	/**
	 * HashMap that contains the visibility properties of ActivityNode > DecomposeSubNode Nodes <br> <br>
	 * 
	 * The entries of this map are as follows : 
	 * <ul>
	 * <li> <b> Key :</b> id of the Leaf whose decomposition's visibility property is stored by this entry </li>
	 * <li> <b> Value : </b> Value of the display property, true if the ActivityNode > DecomposeSubNode 
	 *      that represents the FlowDiagrams that decompose the Leaf must be displayed, false otherwise </li>
	 * </ul>
	 * 
	 * Note that, currently, this map is shared among various views of a single model. <br>
	 * That implies that if you show decompositions of a specific Leaf, 
	 * these decompositions will be shown on all views that contains that Leaf. <br>
	 * If that is an issue for you, this could be worked around by making 
	 * the key a couple which would contain the id of the diagram's view (idOfDiagramView, idOfLeaf) for example.
	 */
	private static HashMap<String, Boolean> mapofLeafDecompositionVisibilityProperty = new HashMap<String, Boolean>();

	/**
	 * Returns the list of Leaves to render in the activity diagram representing the given FlowDiagram.
	 * A Leaf is rendered/displayed if :
	 * <ul>
	 * 		<li> It is a direct Child of the FlowDiagram </li>
	 * 		<li> It is a child of a Xor node who is a direct Child of the FlowDiagram </li>
	 * 		<li> It is a child of a And node who is a direct Child of the FlowDiagram </li>
	 * 		<li> It is a child of a Or node who is a direct Child of the FlowDiagram </li>
	 *		<li> It is a child of a Loop node who is a direct Child of the FlowDiagram </li>
	 * </ul>
	 *
	 * @param rootElement FlowDiagram for which we want the list of Leaves to render
	 * @return list of leaves to render.
	 */
	public List<Child> getLeavesToRenderInActivityDiagram(FlowDiagram rootElement){
		LinkedList<Child> leavesToRender = new LinkedList<>();

		for(Child child : getDirectChildrenOfFlowDiagram(rootElement)) {
			//All direct children that are Leaves will be rendered in the Activity Diagram view
			//(allows for basic Leaf sequence in the Activity Diagram)
			if(child instanceof Leaf) {
				leavesToRender.add(child);
			}
			//if a Xor, or And, Or, or Loop node is a direct child of the flowDiagram
			//and has Leaves as his child, then those Leaves will be rendered too
			//(allows for decision nodes to have leaves in their branches)
			else if (child instanceof Xor || child instanceof And || child instanceof Or | child instanceof Loop) {
				leavesToRender.addAll(Services.getLinkedLeavesFromConstructor((Constructor) child));
			}
		}
		return leavesToRender;
	}

	/**
	 * Returns the direct children of a FlowDiagram.
	 * @param rootElement Flow diagram whose we want the direct children
	 * @return list of found children
	 */
	public List<Child> getDirectChildrenOfFlowDiagram(FlowDiagram rootElement){
		List<Child> children;
    	children = ((FlowDiagram) rootElement).getRefine();
    	return children;
    }

	/**
	 * Returns the Child located to the left of the given node in the ERS Diagram.
	 * ie : the returned Child is the one following the one passed in parameter.
	 * This Service is used in the ERS Diagram Activity View to display and link Leaves in a
	 * Top-Down way instead of Left to Right (as in the ERS Diagram).
	 * More specifically, this service is used to draw SequenceEdges.
	 * @param node node of which we want the next node.
	 * @return Child located to the left of the given node in the ERS Diagram
	 * 		   or null if node's parent is not a FlowDiagram
	 *        (or if node is not contained in his parent's refine attribute)
	 */
	public Child getFollowingChild(Child node) {
		Child wantedBrother = null;
		EObject parent = node.eContainer();
		if(parent instanceof FlowDiagram) {
			//we look for the element located after "node" in his parent's refine list
			EList<Child> children = ((FlowDiagram) parent).getRefine();
			wantedBrother = getNextBrother(children, node);
		} else if(parent instanceof Loop) {
			//we look for the element located after "node" in his parent's loopLink list
			EList<Leaf> children = ((Loop) parent).getLoopLink();
			wantedBrother = getNextBrother(children, node);
		} else {
			//TODO : log properly
			System.err.println("Warning : wrong parent type in getFollowingChild. "
					+ "You're probably using this service in a wrong way. "
					+ "ParentType :"+parent.getClass());
		}
		return wantedBrother;
	}
	/**
	 * Returns the element located just after node in the list children
	 * @param children list in which we look for the node and its next brother
	 * @param node the node for which we want the next brother
	 * @return the element located right after node in children,
	 *         or null if node is the last element of children or if node is not an element of children
	 */
	private Child getNextBrother(EList<? extends Child> children, Child node) {
		Child wantedBrother = null;
		boolean nextChildWanted = false;
		//We search "node" in the list of children
		//when we find it, it means that the next one is the Child that we're looking for
		//(the Child located to the left of "node" in the ERS Diagram)
		for(Child child : children) {
			if(nextChildWanted) {
				wantedBrother = child;
				break;
			} else if(child.equals(node)) {
				//then his next brother is the following node
				nextChildWanted = true;
			}
		}
		return wantedBrother;
	}

	/**
	 * Returns the list of direct children of the given flowDiag,
	 * whose representation in the Activity diagram view contains a MergeNode
	 * @param flowDiag the FlowDiagram for which we want the direct children with a Merge Node in their representation
	 * @return list of direct children of the given flowDiag,
	 *         whose representation in the Activity diagram view contains a MergeNode
	 *         the list can be empty, but never null
	 */
	public List<EObject> getElementsWithMergeNodeRepresentation(FlowDiagram flowDiag) {
		List<Child> children = getDirectChildrenOfFlowDiagram(flowDiag);
		//list of elements that whose representation contains a MergeNode in the Activity Diagram view
		LinkedList<EObject> elementsWithMergeNodeRepresentation = new LinkedList<EObject>();

		for(Child child : children) {
			boolean representationContainsMergeNode = child instanceof Xor
												   || child instanceof Or;
			if(representationContainsMergeNode) {
				elementsWithMergeNodeRepresentation.add(child);
			}//else no op
		}
		return elementsWithMergeNodeRepresentation;
	}


	/**
	 * Returns the list of direct children of the given flowDiag,
	 * whose representation in the Activity diagram view contains a ForkNode
	 * @param flowDiag the FlowDiagram for which we want the direct children with a Fork Node in their representation
	 * @return list of direct children of the given flowDiag,
	 *         whose representation in the Activity diagram view contains a ForkNode
	 *         the list can be empty, but never null
	 */
	public List<EObject> getElementsWithForkNodeRepresentation(FlowDiagram flowDiag) {
		List<Child> children = getDirectChildrenOfFlowDiagram(flowDiag);
		//list of elements that whose representation contains a ForkNode in the Activity Diagram view
		LinkedList<EObject> elementsWithForkNodeRepresentation = new LinkedList<EObject>();

		for(Child child : children) {
			boolean representationContainsForkNode = child instanceof And
												   || child instanceof Or;
			if(representationContainsForkNode) {
				elementsWithForkNodeRepresentation.add(child);
			}//else no op
		}
		return elementsWithForkNodeRepresentation;
	}


	/**
	 * Returns the list of direct children of the given flowDiag,
	 * whose representation in the Activity diagram view contains a DecisionNode
	 * @param flowDiag the FlowDiagram for which we want the direct children with a Decision Node in their representation
	 * @return list of direct children of the given flowDiag,
	 *         whose representation in the Activity diagram view contains a DecisionNode
	 *         the list can be empty, but never null
	 */
	public List<EObject> getElementsWithDecisionNodeRepresentation(FlowDiagram flowDiag) {
		List<Child> children = getDirectChildrenOfFlowDiagram(flowDiag);
		//list of elements that whose representation contains a DecisionNode in the Activity Diagram view
		LinkedList<EObject> elementsWithDecisionNodeRepresentation = new LinkedList<EObject>();

		for(Child child : children) {
			boolean representationContainsDecisionNode = child instanceof Xor;
			if(representationContainsDecisionNode) {
				elementsWithDecisionNodeRepresentation.add(child);
			}//else no op
		}
		return elementsWithDecisionNodeRepresentation;
	}
	
	/**
	 * Precondition used to check if ActivityNode > DecomposeSubNode elements must be shown
	 * This is done simply by accessing the content of the mapofSubDiagramVisibilityProperty Map.
	 */
	public Boolean getDisplayLeafDecompositionsProperty(EventBElement leaf) {
		if(mapofLeafDecompositionVisibilityProperty.containsKey(leaf.getInternalId())) {
			//if the diagram is known, get its registered visibilityProperty
			return mapofLeafDecompositionVisibilityProperty.get(leaf.getInternalId());
		} else {
			//if the subDiagram is not yet known
			//register it in the map with the value false
			mapofLeafDecompositionVisibilityProperty.put(leaf.getInternalId(), false);
			return false;
		}
	}
	
	/**
	 * Sets the leaf decomposition's visibility property into value
	 * @param leaf leaf for which we want to set the visibility of its decompositions (sub-flowDiagrams)
	 * @param value value to which the property must be set
	 */
	public void setSubDiagramVisibility(Leaf leaf, Boolean value) {
		//register the value with subDiagram as the key
		mapofLeafDecompositionVisibilityProperty.put(leaf.getInternalId(), value);
	}
	
	/**
	 * Service that calls Sirius's "arrange-all" feature
	 */
	public void relayoutDiagram(EObject unused) {
		try {
			// trigger 'Arrange All' on the whole diagram
			DiagramEditPart diagramEditPart = null;
			IEditorPart editor = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();

			if (editor instanceof DiagramEditor) {
				DiagramEditor diagramEditor = (DiagramEditor) editor;
				diagramEditPart = diagramEditor.getDiagramEditPart();
			}

			ArrangeRequest arrangeRequest = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
			List<Object> partsToArrange = new ArrayList<Object>();
			//add the diagram to elements to rearrange
			partsToArrange.add(diagramEditPart);
			//add the diagram to elements to rearrange
			partsToArrange.add(diagramEditPart);
			arrangeRequest.setPartsToArrange(partsToArrange);
			diagramEditPart.performRequest(arrangeRequest);
		} catch (Exception e) {
			SiriusPlugin.getDefault().error("Error while arrange elements", e);
		}
	}

	/**
	 * Checks if a leaf has a non-empty decompose reference set.
	 * @param leaf a leaf
	 * @return ! leaf.getDecompose().isEmpty()
	 */
	public Boolean hasDecompose(Leaf leaf) {
		return ! leaf.getDecompose().isEmpty();
	}
}
