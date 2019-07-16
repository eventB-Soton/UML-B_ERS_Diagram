package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.RetryRetryInterruptingLinkItemSemanticEditPolicy;

/**
 * @generated
 */
public class RetryRetryInterruptingLinkEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4022;

	/**
	 * @generated
	 */
	public RetryRetryInterruptingLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RetryRetryInterruptingLinkItemSemanticEditPolicy());
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
		return new RetryInterruptingLinkFigure();
	}

	/**
	 * @generated
	 */
	public RetryInterruptingLinkFigure getPrimaryShape() {
		return (RetryInterruptingLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class RetryInterruptingLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public RetryInterruptingLinkFigure() {
			this.setLineWidth(3);
			this.setLineStyle(Graphics.LINE_DASH);

		}

	}

}
