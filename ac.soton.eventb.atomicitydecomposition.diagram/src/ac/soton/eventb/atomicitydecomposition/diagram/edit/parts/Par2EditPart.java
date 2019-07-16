package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.Par2ItemSemanticEditPolicy;

/**
 * @generated
 */
public class Par2EditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4018;

	/**
	 * @generated
	 */
	public Par2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Par2ItemSemanticEditPolicy());
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
		return new ParParLinkIsRefFigure();
	}

	/**
	 * @generated
	 */
	public ParParLinkIsRefFigure getPrimaryShape() {
		return (ParParLinkIsRefFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ParParLinkIsRefFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public ParParLinkIsRefFigure() {
			this.setLineWidth(3);

		}

	}

}
