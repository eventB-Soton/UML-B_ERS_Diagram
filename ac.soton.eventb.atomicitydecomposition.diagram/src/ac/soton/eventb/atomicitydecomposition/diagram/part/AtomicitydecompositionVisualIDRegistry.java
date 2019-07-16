package ac.soton.eventb.atomicitydecomposition.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllAllLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllAllLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllNewParameterExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndAndLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndAndLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Label2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Label3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Label4EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Label5EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Label6EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafName2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafNameEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopLoopLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopLoopLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.One2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneNewParameterExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneOneLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneOneLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrOrLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrOrLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Par2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParParLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParParLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeNewParameterExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeSomeLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeSomeLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel4EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel5EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel6EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel7EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel8EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Xor2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorXorLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorXorLinkExternalLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.expressions.AtomicitydecompositionOCLFactory;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class AtomicitydecompositionVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "ac.soton.eventb.atomicitydecomposition.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (FlowDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return FlowDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				AtomicitydecompositionDiagramEditorPlugin.getInstance()
						.logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram()
				.isSuperTypeOf(domainElement.eClass())
				&& isDiagram((FlowDiagram) domainElement)) {
			return FlowDiagramEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
				.getModelID(containerView);
		if (!FlowDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (FlowDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FlowDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case FlowDiagramEditPart.VISUAL_ID:
			if (AtomicitydecompositionPackage.eINSTANCE.getLeaf()
					.isSuperTypeOf(domainElement.eClass())
					&& isLeaf_2001((Leaf) domainElement)) {
				return LeafEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getAnd().isSuperTypeOf(
					domainElement.eClass())) {
				return AndEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getLoop()
					.isSuperTypeOf(domainElement.eClass())) {
				return LoopEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getAll().isSuperTypeOf(
					domainElement.eClass())) {
				return AllEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getSome()
					.isSuperTypeOf(domainElement.eClass())) {
				return SomeEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getOr().isSuperTypeOf(
					domainElement.eClass())) {
				return OrEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getXor().isSuperTypeOf(
					domainElement.eClass())) {
				return XorEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getOne().isSuperTypeOf(
					domainElement.eClass())) {
				return OneEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getPar().isSuperTypeOf(
					domainElement.eClass())) {
				return ParEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getLeaf()
					.isSuperTypeOf(domainElement.eClass())
					&& isLeaf_2010((Leaf) domainElement)) {
				return Leaf2EditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram()
					.isSuperTypeOf(domainElement.eClass())) {
				return FlowDiagram2EditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getInterrupt()
					.isSuperTypeOf(domainElement.eClass())) {
				return InterruptEditPart.VISUAL_ID;
			}
			if (AtomicitydecompositionPackage.eINSTANCE.getRetry()
					.isSuperTypeOf(domainElement.eClass())) {
				return RetryEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
				.getModelID(containerView);
		if (!FlowDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (FlowDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FlowDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case FlowDiagramEditPart.VISUAL_ID:
			if (LeafEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AndEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LoopEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AllEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SomeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OrEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (XorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OneEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ParEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Leaf2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FlowDiagram2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InterruptEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RetryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LeafEditPart.VISUAL_ID:
			if (LeafNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AndEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AllEditPart.VISUAL_ID:
			if (LabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SomeEditPart.VISUAL_ID:
			if (Label2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OrEditPart.VISUAL_ID:
			if (Label3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case XorEditPart.VISUAL_ID:
			if (Label4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OneEditPart.VISUAL_ID:
			if (Label5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ParEditPart.VISUAL_ID:
			if (Label6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Leaf2EditPart.VISUAL_ID:
			if (LeafName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterruptEditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RetryEditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AndAndLinkEditPart.VISUAL_ID:
			if (AndAndLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LoopLoopLinkEditPart.VISUAL_ID:
			if (LoopLoopLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AllAllLinkEditPart.VISUAL_ID:
			if (AllAllLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AllNewParameterEditPart.VISUAL_ID:
			if (AllNewParameterExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SomeSomeLinkEditPart.VISUAL_ID:
			if (SomeSomeLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SomeNewParameterEditPart.VISUAL_ID:
			if (SomeNewParameterExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OrOrLinkEditPart.VISUAL_ID:
			if (OrOrLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case XorXorLinkEditPart.VISUAL_ID:
			if (XorXorLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OneOneLinkEditPart.VISUAL_ID:
			if (OneOneLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OneNewParameterEditPart.VISUAL_ID:
			if (OneNewParameterExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ParParLinkEditPart.VISUAL_ID:
			if (ParParLinkExternalLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterruptInterruptNormalLinkEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RetryRetryNormalLinkEditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram()
				.isSuperTypeOf(domainElement.eClass())
				&& isFlowDiagram_4015((FlowDiagram) domainElement)) {
			return FlowDiagram3EditPart.VISUAL_ID;
		}
		if (AtomicitydecompositionPackage.eINSTANCE.getXor().isSuperTypeOf(
				domainElement.eClass())
				&& isXor_4016((Xor) domainElement)) {
			return Xor2EditPart.VISUAL_ID;
		}
		if (AtomicitydecompositionPackage.eINSTANCE.getOne().isSuperTypeOf(
				domainElement.eClass())
				&& isOne_4017((One) domainElement)) {
			return One2EditPart.VISUAL_ID;
		}
		if (AtomicitydecompositionPackage.eINSTANCE.getPar().isSuperTypeOf(
				domainElement.eClass())
				&& isPar_4018((Par) domainElement)) {
			return Par2EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(FlowDiagram element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isLeaf_2001(Leaf domainElement) {
		Object result = AtomicitydecompositionOCLFactory.getExpression(0,
				AtomicitydecompositionPackage.eINSTANCE.getLeaf(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isLeaf_2010(Leaf domainElement) {
		Object result = AtomicitydecompositionOCLFactory.getExpression(1,
				AtomicitydecompositionPackage.eINSTANCE.getLeaf(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isFlowDiagram_4015(FlowDiagram domainElement) {
		Object result = AtomicitydecompositionOCLFactory.getExpression(2,
				AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isXor_4016(Xor domainElement) {
		Object result = AtomicitydecompositionOCLFactory.getExpression(3,
				AtomicitydecompositionPackage.eINSTANCE.getXor(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isOne_4017(One domainElement) {
		Object result = AtomicitydecompositionOCLFactory.getExpression(4,
				AtomicitydecompositionPackage.eINSTANCE.getOne(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isPar_4018(Par domainElement) {
		Object result = AtomicitydecompositionOCLFactory.getExpression(5,
				AtomicitydecompositionPackage.eINSTANCE.getPar(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case FlowDiagramEditPart.VISUAL_ID:
			return false;
		case LeafEditPart.VISUAL_ID:
		case AndEditPart.VISUAL_ID:
		case LoopEditPart.VISUAL_ID:
		case AllEditPart.VISUAL_ID:
		case SomeEditPart.VISUAL_ID:
		case OrEditPart.VISUAL_ID:
		case XorEditPart.VISUAL_ID:
		case OneEditPart.VISUAL_ID:
		case ParEditPart.VISUAL_ID:
		case Leaf2EditPart.VISUAL_ID:
		case FlowDiagram2EditPart.VISUAL_ID:
		case InterruptEditPart.VISUAL_ID:
		case RetryEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
