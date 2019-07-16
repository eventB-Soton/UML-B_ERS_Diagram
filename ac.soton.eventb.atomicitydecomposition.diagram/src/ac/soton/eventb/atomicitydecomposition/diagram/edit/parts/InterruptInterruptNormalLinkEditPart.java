package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.InterruptInterruptNormalLinkItemSemanticEditPolicy;

/**
 * @generated
 */
public class InterruptInterruptNormalLinkEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4019;

	/**
	 * @generated
	 */
	public InterruptInterruptNormalLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InterruptInterruptNormalLinkItemSemanticEditPolicy());
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
		return new InterruptNormalLinkFigure();
	}

	/**
	 * @generated
	 */
	public InterruptNormalLinkFigure getPrimaryShape() {
		return (InterruptNormalLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class InterruptNormalLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public InterruptNormalLinkFigure() {
			this.setLineWidth(3);
			this.setLineStyle(Graphics.LINE_DASH);

		}

	}

}
