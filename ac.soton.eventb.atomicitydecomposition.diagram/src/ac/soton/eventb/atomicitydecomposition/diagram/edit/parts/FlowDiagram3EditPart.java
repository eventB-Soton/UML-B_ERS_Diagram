package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.FlowDiagram3ItemSemanticEditPolicy;

/**
 * @generated
 */
public class FlowDiagram3EditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4015;

	/**
	 * @generated
	 */
	public FlowDiagram3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FlowDiagram3ItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new FlowDiagramRefineIsRefFigure();
	}

	/**
	 * @generated
	 */
	public FlowDiagramRefineIsRefFigure getPrimaryShape() {
		return (FlowDiagramRefineIsRefFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class FlowDiagramRefineIsRefFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public FlowDiagramRefineIsRefFigure() {
			this.setLineWidth(3);

		}

	}

}
