package ac.soton.eventb.atomicitydecomposition.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AtomicitydecompositionEditPartFactory;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;

/**
 * @generated
 */
public class AtomicitydecompositionEditPartProvider extends
		DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public AtomicitydecompositionEditPartProvider() {
		super(new AtomicitydecompositionEditPartFactory(),
				AtomicitydecompositionVisualIDRegistry.TYPED_INSTANCE,
				FlowDiagramEditPart.MODEL_ID);
	}

}
