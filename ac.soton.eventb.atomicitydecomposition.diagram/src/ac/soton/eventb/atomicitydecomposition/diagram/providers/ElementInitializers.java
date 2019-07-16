package ac.soton.eventb.atomicitydecomposition.diagram.providers;

import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = AtomicitydecompositionDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			AtomicitydecompositionDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
