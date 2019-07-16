package ac.soton.eventb.atomicitydecomposition.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;

/**
 * @generated
 */
public class AtomicitydecompositionEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {

			case FlowDiagramEditPart.VISUAL_ID:
				return new FlowDiagramEditPart(view);

			case LeafEditPart.VISUAL_ID:
				return new LeafEditPart(view);

			case LeafNameEditPart.VISUAL_ID:
				return new LeafNameEditPart(view);

			case AndEditPart.VISUAL_ID:
				return new AndEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case LoopEditPart.VISUAL_ID:
				return new LoopEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case AllEditPart.VISUAL_ID:
				return new AllEditPart(view);

			case LabelEditPart.VISUAL_ID:
				return new LabelEditPart(view);

			case SomeEditPart.VISUAL_ID:
				return new SomeEditPart(view);

			case Label2EditPart.VISUAL_ID:
				return new Label2EditPart(view);

			case OrEditPart.VISUAL_ID:
				return new OrEditPart(view);

			case Label3EditPart.VISUAL_ID:
				return new Label3EditPart(view);

			case XorEditPart.VISUAL_ID:
				return new XorEditPart(view);

			case Label4EditPart.VISUAL_ID:
				return new Label4EditPart(view);

			case OneEditPart.VISUAL_ID:
				return new OneEditPart(view);

			case Label5EditPart.VISUAL_ID:
				return new Label5EditPart(view);

			case ParEditPart.VISUAL_ID:
				return new ParEditPart(view);

			case Label6EditPart.VISUAL_ID:
				return new Label6EditPart(view);

			case Leaf2EditPart.VISUAL_ID:
				return new Leaf2EditPart(view);

			case LeafName2EditPart.VISUAL_ID:
				return new LeafName2EditPart(view);

			case FlowDiagram2EditPart.VISUAL_ID:
				return new FlowDiagram2EditPart(view);

			case InterruptEditPart.VISUAL_ID:
				return new InterruptEditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case RetryEditPart.VISUAL_ID:
				return new RetryEditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case AndAndLinkEditPart.VISUAL_ID:
				return new AndAndLinkEditPart(view);

			case AndAndLinkExternalLabelEditPart.VISUAL_ID:
				return new AndAndLinkExternalLabelEditPart(view);

			case LoopLoopLinkEditPart.VISUAL_ID:
				return new LoopLoopLinkEditPart(view);

			case LoopLoopLinkExternalLabelEditPart.VISUAL_ID:
				return new LoopLoopLinkExternalLabelEditPart(view);

			case AllAllLinkEditPart.VISUAL_ID:
				return new AllAllLinkEditPart(view);

			case AllAllLinkExternalLabelEditPart.VISUAL_ID:
				return new AllAllLinkExternalLabelEditPart(view);

			case AllNewParameterEditPart.VISUAL_ID:
				return new AllNewParameterEditPart(view);

			case AllNewParameterExternalLabelEditPart.VISUAL_ID:
				return new AllNewParameterExternalLabelEditPart(view);

			case SomeSomeLinkEditPart.VISUAL_ID:
				return new SomeSomeLinkEditPart(view);

			case SomeSomeLinkExternalLabelEditPart.VISUAL_ID:
				return new SomeSomeLinkExternalLabelEditPart(view);

			case SomeNewParameterEditPart.VISUAL_ID:
				return new SomeNewParameterEditPart(view);

			case SomeNewParameterExternalLabelEditPart.VISUAL_ID:
				return new SomeNewParameterExternalLabelEditPart(view);

			case OrOrLinkEditPart.VISUAL_ID:
				return new OrOrLinkEditPart(view);

			case OrOrLinkExternalLabelEditPart.VISUAL_ID:
				return new OrOrLinkExternalLabelEditPart(view);

			case XorXorLinkEditPart.VISUAL_ID:
				return new XorXorLinkEditPart(view);

			case XorXorLinkExternalLabelEditPart.VISUAL_ID:
				return new XorXorLinkExternalLabelEditPart(view);

			case OneOneLinkEditPart.VISUAL_ID:
				return new OneOneLinkEditPart(view);

			case OneOneLinkExternalLabelEditPart.VISUAL_ID:
				return new OneOneLinkExternalLabelEditPart(view);

			case OneNewParameterEditPart.VISUAL_ID:
				return new OneNewParameterEditPart(view);

			case OneNewParameterExternalLabelEditPart.VISUAL_ID:
				return new OneNewParameterExternalLabelEditPart(view);

			case ParParLinkEditPart.VISUAL_ID:
				return new ParParLinkEditPart(view);

			case ParParLinkExternalLabelEditPart.VISUAL_ID:
				return new ParParLinkExternalLabelEditPart(view);

			case MultiFlowDecomposeEditPart.VISUAL_ID:
				return new MultiFlowDecomposeEditPart(view);

			case FlowDiagramRefineEditPart.VISUAL_ID:
				return new FlowDiagramRefineEditPart(view);

			case FlowDiagram3EditPart.VISUAL_ID:
				return new FlowDiagram3EditPart(view);

			case Xor2EditPart.VISUAL_ID:
				return new Xor2EditPart(view);

			case One2EditPart.VISUAL_ID:
				return new One2EditPart(view);

			case Par2EditPart.VISUAL_ID:
				return new Par2EditPart(view);

			case InterruptInterruptNormalLinkEditPart.VISUAL_ID:
				return new InterruptInterruptNormalLinkEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID:
				return new InterruptInterruptInterruptingLinkEditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case RetryRetryNormalLinkEditPart.VISUAL_ID:
				return new RetryRetryNormalLinkEditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
				return new RetryRetryInterruptingLinkEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
