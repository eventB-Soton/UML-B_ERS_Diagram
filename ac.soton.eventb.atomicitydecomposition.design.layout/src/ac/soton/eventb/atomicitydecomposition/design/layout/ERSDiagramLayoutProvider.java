

package ac.soton.eventb.atomicitydecomposition.design.layout;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.providers.TopDownProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNode;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;


/**
 * Provides the layout algorithm for the Sirius based ERS Diagram Editor.
 * This Class thus describes the way that graphical element are organized in an ERS Diagram.
 * Its implementation is heavily inspired by the layout algorithm that existed for the GMF-based diagram editor.
 * @see ac.soton.eventb.atomicitydecomposition.diagram.layout.SquareLayoutProvider
 */
public class ERSDiagramLayoutProvider extends TopDownProvider{

	/**
	 * Vertical spacing (in levels) left free to display the root of the tree.
	 * To get that spacing in pixels, simply multiply LEVEL_Y_SPACING by that number.
	 */
	protected static final Float INITIAL_ROOT_SPACING = (float) 2;

	/**
	 * Vertical position (in pixels) at which the root of the tree will be positioned
	 * Note that this spacing is applied without considering the value of INITIAL_ROOT_SPACING
	 * i.e : the "real" spacing between the root and the first level will be :
	 * (INITIAL_ROOT_SPACING) * LEVEL_Y_SPACING - ROOT_INITIAL_Y_POSITION
	 */
	protected static final int ROOT_INITIAL_Y_POSITION = 10;
	
	/**
	 * Space left free to the left of the diagram, in pixels
	 * Note that the root node is placed at the "center" of the diagram.
	 * This value is an offset to place the root node somewhere else, if you feel like it.
	 */
	protected static final float HORIZONTAL_SPACNG = 0;
	
	/**
	 * Horizontal spacing between two elements located on the same level, in pixels
	 */
	private static final int LEVEL_X_SPACING = 10;
	
	/**
	 * Vertical spacing between two levels of the tree, in pixels
	 */
	private static final int LEVEL_Y_SPACING = 70;
	 
	@Override
	public boolean provides(IOperation operation) {
		
		if (operation instanceof ILayoutNodeOperation) {
			Iterator nodes = ((ILayoutNodeOperation)operation).getLayoutNodes().listIterator();
			
			if (nodes.hasNext()) { 
				//we access the first node of the diagram to check that its linked semantic element is contained in a FlowDiagram or represents a FlowDiagram
				Node node = ((ILayoutNode)nodes.next()).getNode();
				if(node.getElement() instanceof DNode) {
					EList<EObject> linkedSemanticElements = ((DNode) node.getElement()).getSemanticElements();
					if(linkedSemanticElements != null && linkedSemanticElements.size() > 0) {
						EObject semanticElement = linkedSemanticElements.get(0);
						//we check that the semantic element is a FlowDiagram
						boolean semanticElementIsERSRoot = semanticElement instanceof FlowDiagram;
						//or is contained in a FlowDiagram
						boolean semanticElementIsChildofERSRoot = semanticElement instanceof Child && semanticElement.eContainer() instanceof FlowDiagram;
						
						if(semanticElementIsERSRoot || semanticElementIsChildofERSRoot) {
							//we check that the current diagram is not an Activity Diagram View (which must be "layouted" using Sirius default algorithm)
							DiagramElementMapping nodeMapping = ((DNode)node.getElement()).getDiagramElementMapping();
							//XXX : This if condition is not that great : it is simple, but it might become false if the Activity Diagram Specification is changed
							//XXX : if you notice that the layout of the Activity Diagram View is messed up, this check being false is 99% the cause
							if(nodeMapping.getName().equals("InitialNode")) {
								//An Activity Diagram View must not be "layouted" using this algorithm, so we return false
								return false;
							}
						}//else
						return semanticElementIsERSRoot || semanticElementIsChildofERSRoot;
					}
				}
			} 
		} //else
		return false;
	}
	
	@Override
	public Runnable layoutLayoutNodes(List layoutNodes,
			boolean offsetFromBoundingBox, IAdaptable layoutHint) {
		
		final List lnodes = layoutNodes;
		
		return new Runnable() {
			
			private HashMap<EObject, ILayoutNode> object2node;
			//private HashMap<EObject, Float> object2offset;
			private EObject topLevelElement;
			
			public void run() {
				ILayoutNode topLNode = null;
				object2node = new HashMap<EObject, ILayoutNode>();
				//object2offset = new HashMap<EObject, Float>();
				int topLevel = -1;
				ListIterator li = lnodes.listIterator();
				while (li.hasNext()) {
					ILayoutNode lnode = (ILayoutNode)li.next();
					EObject semanticElement = null;
					if(lnode.getNode().getElement() instanceof DNode) {
						EList<EObject> linkedSemanticElements = ((DNode) lnode.getNode().getElement()).getSemanticElements();
						if(linkedSemanticElements != null && linkedSemanticElements.size() > 0) {
							//we get the first (and only) semantic element linked to this DNode
							semanticElement = linkedSemanticElements.get(0);
							object2node.put(semanticElement, lnode);
							
							int level = findLevel(semanticElement);
							if(level < topLevel || topLevel == -1){
								topLevel = level;
								topLevelElement = semanticElement;
								topLNode = lnode;
							}
						}
					}//else we ignore the node				
				}
				Float finalOffset = positionTree(topLevelElement);

				if(topLNode != null) {
					//Finally after the whole tree has been positioned, we reposition the root of the tree, so that it is centered
					Bounds bounds = (Bounds)topLNode.getNode().getLayoutConstraint();
					bounds.setY(ROOT_INITIAL_Y_POSITION);
					bounds.setX((int) Math.round(finalOffset/2));
					topLNode.getNode().setLayoutConstraint(bounds);
				}
			}
			
			/**
			 * Returns the level of a semantic element in the hierarchy of the tree. <br>
			 * The root element (the root FlowDiagram in the case of an ERS Diagram) 
			 * is considered to be of level 1, its direct children of level 2, and so on. <br>
			 * This level is then used to display elements as a tree.
			 * @param eobj semantic element
			 * @return level of a semantic element in the hierarchy of the tree.
			 */
			private int findLevel(EObject eobj){
				if(eobj.eContainer() == null || eobj.eContainer() instanceof Machine) {
					return 1;
				} else {
					int level = findLevel(eobj.eContainer()) + 1;
					return level;
				}
			}
			
			/**
			 * Positions the Diagram as a Tree, starting from its root
			 * @param obj root of the tree
			 * @return the final offset
			 */
			private Float positionTree(EObject root){
				Float offset = (float) HORIZONTAL_SPACNG; //Horizontal spacing left of the 1st element
				for(EObject content : root.eContents()){
					if(object2node.get(content) == null) {
						continue;
					}
					offset = positionSubtree(content, offset, INITIAL_ROOT_SPACING);
				}
				return offset; //we return the offset of the last element which will be used to center the root of the tree
			}
			
			
			private Float positionSubtree(EObject branchRoot, Float Xoffset, Float level){
				ILayoutNode ln = object2node.get(branchRoot);
				
				Float initialXOffset = Xoffset;
				
				if(branchRoot instanceof Leaf && branchRoot.eContainer() instanceof FlowDiagram &&
						!(branchRoot.eContainer().equals(topLevelElement))) {
					level += 1;
				}
				
				for(EObject eobj : branchRoot.eContents()){
					if(eobj instanceof TypedParameterExpression || object2node.get(eobj) == null) {
						continue;
					}
					Xoffset = positionSubtree(eobj, Xoffset, level + 1);
				}
				
				Bounds bounds = (Bounds)ln.getNode().getLayoutConstraint();
				if(branchRoot.eContents().size() == 0 || (branchRoot.eContents().size() == 1 && branchRoot.eContents().size() == 0)) {
					bounds.setX( (int) Math.round(initialXOffset)) ;
				} else {
					bounds.setX(  (int) (Math.round(initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(branchRoot).getWidth()/2)) > initialXOffset ? (int) Math.round(initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(branchRoot).getWidth()/2)) : initialXOffset) ) ;
				}

				bounds.setY( (int) Math.round(level * LEVEL_Y_SPACING));
				ln.getNode().setLayoutConstraint(bounds);

				if(branchRoot.eContents().size() == 0  || Math.round(initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(branchRoot).getWidth()/2)) < initialXOffset ) {
					return initialXOffset + object2node.get(branchRoot).getWidth() + LEVEL_X_SPACING;
				}
				
				Float abstractEnd = initialXOffset + (Xoffset - initialXOffset)/2 - (object2node.get(branchRoot).getWidth()/2) 
						+ object2node.get(branchRoot).getWidth() + LEVEL_X_SPACING;
				Float subtreeEnd = Xoffset;
				
				return abstractEnd > subtreeEnd ? abstractEnd : subtreeEnd;
				
			}
					
		};
	}
}

	