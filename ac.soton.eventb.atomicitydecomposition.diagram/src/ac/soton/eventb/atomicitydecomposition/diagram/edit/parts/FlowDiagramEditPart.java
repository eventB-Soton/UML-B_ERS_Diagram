package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.FlowDiagramCanonicalEditPolicy;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.FlowDiagramItemSemanticEditPolicy;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;

/**
 * @generated
 */
public class FlowDiagramEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Atomicitydecomposition"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	/**
	 * @generated
	 */
	public FlowDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new FlowDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new FlowDiagramCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(
						AtomicitydecompositionVisualIDRegistry.TYPED_INSTANCE));
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
