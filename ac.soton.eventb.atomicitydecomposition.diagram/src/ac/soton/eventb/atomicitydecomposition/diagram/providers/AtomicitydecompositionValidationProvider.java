package ac.soton.eventb.atomicitydecomposition.diagram.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;

/**
 * @generated
 */
public class AtomicitydecompositionValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
	 */
	public static void runWithConstraints(
			TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if (editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				AtomicitydecompositionDiagramEditorPlugin.getInstance()
						.logError("Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive
					&& FlowDiagramEditPart.MODEL_ID
							.equals(AtomicitydecompositionVisualIDRegistry
									.getModelID((View) object));
		}
		return true;
	}

}
