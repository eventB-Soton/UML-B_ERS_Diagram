package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.RetryRetryNormalLinkItemSemanticEditPolicy;

/**
 * @generated
 */
public class RetryRetryNormalLinkEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4021;

	/**
	 * @generated
	 */
	public RetryRetryNormalLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RetryRetryNormalLinkItemSemanticEditPolicy());
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
		return new RetryNormalLinkFigure();
	}

	/**
	 * @generated
	 */
	public RetryNormalLinkFigure getPrimaryShape() {
		return (RetryNormalLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class RetryNormalLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public RetryNormalLinkFigure() {
			this.setLineWidth(3);
			this.setLineStyle(Graphics.LINE_DASH);

		}

	}

}
