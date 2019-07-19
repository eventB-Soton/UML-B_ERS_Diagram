package ac.soton.eventb.atomicity.design;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Xor;

public class ActivityDiagramViewServices {


	/**
	 * Returns the list of Leaves to render in the activity diagram representing the given FlowDiagram.
	 * A Leaf is rendered/displayed if :
	 * <ul>
	 * 		<li> It is a direct Child of the FlowDiagram </li>
	 * 		<li> It is a child of a Xor node who is a direct Child of the FlowDiagram </li>
	 * 		//TODO complete this list when other parts of Activity Diagrams will be rendered
	 * </ul>
	 *
	 * @param rootElement FlowDiagram for which we want the list of Leaves to render
	 * @return list of leaves to render.
	 */
	public List<Child> getLeavesToRenderinActivityDiagram(FlowDiagram rootElement){
		LinkedList<Child> leavesToRender = new LinkedList<>();

		for(Child child : getDirectChildrenOfFlowDiagram(rootElement)) {
			//All direct children that are Leaves will be rendered in the Activity Diagram view
			//(allows for basic Leaf sequence in the Activity Diagram)
			if(child instanceof Leaf) {
				leavesToRender.add(child);
			}
			//if a Xor node is a direct child of the flowDiagram
			//and has Leaves as his child, then those Leaves will be rendered too
			//(allows for decision nodes to have leaves in their branches)
			else if (child instanceof Xor) {
				leavesToRender.addAll(Services.getLinkedLeavesFromConstructor((Xor) child));
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
	 * @param node node of which we want the next node.
	 * @return Child located to the left of the given node in the ERS Diagram
	 * 		   or null if node's parent is not a FlowDiagram
	 *        (or if node is not contained in his parent's refine attribute)
	 */
	public Child getFollowingChild(Child node) {
		Child wantedBrother = null;
		//we look for the element located after "node" in his parent's refine list
		EObject parent = node.eContainer();
		if(parent instanceof FlowDiagram) {
			EList<Child> children = ((FlowDiagram) parent).getRefine();
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
		} else {
			//TODO : log properly
			System.err.println("Warning : wrong parent type in getFollowingChild. "
					+ "You're probably using this service in a wrong way. "
					+ "ParentType :"+parent.getClass());
		}
		return wantedBrother;
	}
}
