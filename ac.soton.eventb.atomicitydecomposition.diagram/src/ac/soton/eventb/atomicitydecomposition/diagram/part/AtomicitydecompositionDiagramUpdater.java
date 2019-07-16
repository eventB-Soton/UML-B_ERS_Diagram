package ac.soton.eventb.atomicitydecomposition.diagram.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Interrupt;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.MultiFlow;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Retry;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllAllLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndAndLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramRefineEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopLoopLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.MultiFlowDecomposeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.One2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneOneLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrOrLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Par2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParParLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeSomeLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Xor2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorXorLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class AtomicitydecompositionDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionNodeDescriptor> getSemanticChildren(
			View view) {
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {
		case FlowDiagramEditPart.VISUAL_ID:
			return getFlowDiagram_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated false
	 */
	public static List<AtomicitydecompositionNodeDescriptor> getFlowDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		List<EObject> alreadyAdded = new ArrayList<EObject>();

		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		LinkedList<AtomicitydecompositionNodeDescriptor> result = new LinkedList<AtomicitydecompositionNodeDescriptor>();
		for (Iterator<?> it = modelElement.getRefine().iterator(); it.hasNext();) {
			Child childElement = (Child) it.next();
			alreadyAdded.add(childElement);
			int visualID = AtomicitydecompositionVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == LeafEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == AndEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == LoopEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == AllEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == SomeEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == OrEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == XorEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == OneEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == ParEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == InterruptEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == RetryEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, visualID));
				continue;
			}

			alreadyAdded.remove(childElement);
		}
		Resource resource = modelElement.eResource();
		for (Iterator<EObject> it = getPhantomNodesIterator(resource); it
				.hasNext();) {

			EObject childElement = it.next();

			if (childElement == modelElement
					|| (childElement instanceof FlowDiagram && childElement
							.eContainer() instanceof Machine)
					|| !isDescendantOf(childElement, modelElement)) {
				continue;
			}
			if (alreadyAdded.contains(childElement))
				continue;

			alreadyAdded.add(childElement);
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == LeafEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, LeafEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == Leaf2EditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, Leaf2EditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == FlowDiagram2EditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, FlowDiagram2EditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == AndEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, AndEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == LoopEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, LoopEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == AllEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, AllEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == SomeEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, SomeEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == OrEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, OrEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == XorEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, XorEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == OneEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, OneEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == ParEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, ParEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == InterruptEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, InterruptEditPart.VISUAL_ID));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry.getNodeVisualID(view,
					childElement) == RetryEditPart.VISUAL_ID) {
				result.add(new AtomicitydecompositionNodeDescriptor(
						childElement, RetryEditPart.VISUAL_ID));
				continue;
			}
			alreadyAdded.remove(childElement);
		}
		return result;
	}

	private static boolean isDescendantOf(EObject child, EObject parent) {
		EObject temp = child.eContainer();
		while (temp != null && !(temp instanceof Machine)) {
			if (temp.equals(parent))
				return true;
			temp = temp.eContainer();
		}

		return false;
	}

	/**
	 * @generated
	 */
	private static Iterator<EObject> getPhantomNodesIterator(Resource resource) {
		return resource.getAllContents();
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getContainedLinks(
			View view) {
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {
		case FlowDiagramEditPart.VISUAL_ID:
			return getFlowDiagram_1000ContainedLinks(view);
		case LeafEditPart.VISUAL_ID:
			return getLeaf_2001ContainedLinks(view);
		case AndEditPart.VISUAL_ID:
			return getAnd_2002ContainedLinks(view);
		case LoopEditPart.VISUAL_ID:
			return getLoop_2003ContainedLinks(view);
		case AllEditPart.VISUAL_ID:
			return getAll_2004ContainedLinks(view);
		case SomeEditPart.VISUAL_ID:
			return getSome_2005ContainedLinks(view);
		case OrEditPart.VISUAL_ID:
			return getOr_2006ContainedLinks(view);
		case XorEditPart.VISUAL_ID:
			return getXor_2007ContainedLinks(view);
		case OneEditPart.VISUAL_ID:
			return getOne_2008ContainedLinks(view);
		case ParEditPart.VISUAL_ID:
			return getPar_2009ContainedLinks(view);
		case Leaf2EditPart.VISUAL_ID:
			return getLeaf_2010ContainedLinks(view);
		case FlowDiagram2EditPart.VISUAL_ID:
			return getFlowDiagram_2011ContainedLinks(view);
		case InterruptEditPart.VISUAL_ID:
			return getInterrupt_2012ContainedLinks(view);
		case RetryEditPart.VISUAL_ID:
			return getRetry_2013ContainedLinks(view);
		case FlowDiagram3EditPart.VISUAL_ID:
			return getFlowDiagram_4015ContainedLinks(view);
		case Xor2EditPart.VISUAL_ID:
			return getXor_4016ContainedLinks(view);
		case One2EditPart.VISUAL_ID:
			return getOne_4017ContainedLinks(view);
		case Par2EditPart.VISUAL_ID:
			return getPar_4018ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getIncomingLinks(
			View view) {
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {
		case LeafEditPart.VISUAL_ID:
			return getLeaf_2001IncomingLinks(view);
		case AndEditPart.VISUAL_ID:
			return getAnd_2002IncomingLinks(view);
		case LoopEditPart.VISUAL_ID:
			return getLoop_2003IncomingLinks(view);
		case AllEditPart.VISUAL_ID:
			return getAll_2004IncomingLinks(view);
		case SomeEditPart.VISUAL_ID:
			return getSome_2005IncomingLinks(view);
		case OrEditPart.VISUAL_ID:
			return getOr_2006IncomingLinks(view);
		case XorEditPart.VISUAL_ID:
			return getXor_2007IncomingLinks(view);
		case OneEditPart.VISUAL_ID:
			return getOne_2008IncomingLinks(view);
		case ParEditPart.VISUAL_ID:
			return getPar_2009IncomingLinks(view);
		case Leaf2EditPart.VISUAL_ID:
			return getLeaf_2010IncomingLinks(view);
		case FlowDiagram2EditPart.VISUAL_ID:
			return getFlowDiagram_2011IncomingLinks(view);
		case InterruptEditPart.VISUAL_ID:
			return getInterrupt_2012IncomingLinks(view);
		case RetryEditPart.VISUAL_ID:
			return getRetry_2013IncomingLinks(view);
		case FlowDiagram3EditPart.VISUAL_ID:
			return getFlowDiagram_4015IncomingLinks(view);
		case Xor2EditPart.VISUAL_ID:
			return getXor_4016IncomingLinks(view);
		case One2EditPart.VISUAL_ID:
			return getOne_4017IncomingLinks(view);
		case Par2EditPart.VISUAL_ID:
			return getPar_4018IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {
		case LeafEditPart.VISUAL_ID:
			return getLeaf_2001OutgoingLinks(view);
		case AndEditPart.VISUAL_ID:
			return getAnd_2002OutgoingLinks(view);
		case LoopEditPart.VISUAL_ID:
			return getLoop_2003OutgoingLinks(view);
		case AllEditPart.VISUAL_ID:
			return getAll_2004OutgoingLinks(view);
		case SomeEditPart.VISUAL_ID:
			return getSome_2005OutgoingLinks(view);
		case OrEditPart.VISUAL_ID:
			return getOr_2006OutgoingLinks(view);
		case XorEditPart.VISUAL_ID:
			return getXor_2007OutgoingLinks(view);
		case OneEditPart.VISUAL_ID:
			return getOne_2008OutgoingLinks(view);
		case ParEditPart.VISUAL_ID:
			return getPar_2009OutgoingLinks(view);
		case Leaf2EditPart.VISUAL_ID:
			return getLeaf_2010OutgoingLinks(view);
		case FlowDiagram2EditPart.VISUAL_ID:
			return getFlowDiagram_2011OutgoingLinks(view);
		case InterruptEditPart.VISUAL_ID:
			return getInterrupt_2012OutgoingLinks(view);
		case RetryEditPart.VISUAL_ID:
			return getRetry_2013OutgoingLinks(view);
		case FlowDiagram3EditPart.VISUAL_ID:
			return getFlowDiagram_4015OutgoingLinks(view);
		case Xor2EditPart.VISUAL_ID:
			return getXor_4016OutgoingLinks(view);
		case One2EditPart.VISUAL_ID:
			return getOne_4017OutgoingLinks(view);
		case Par2EditPart.VISUAL_ID:
			return getPar_4018OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_1000ContainedLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_FlowDiagram_Refine_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Xor_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_One_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Par_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLeaf_2001ContainedLinks(
			View view) {
		Leaf modelElement = (Leaf) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MultiFlow_Decompose_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_FlowDiagram_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getAnd_2002ContainedLinks(
			View view) {
		And modelElement = (And) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_And_AndLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLoop_2003ContainedLinks(
			View view) {
		Loop modelElement = (Loop) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Loop_LoopLink_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getAll_2004ContainedLinks(
			View view) {
		All modelElement = (All) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_All_AllLink_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_All_NewParameter_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getSome_2005ContainedLinks(
			View view) {
		Some modelElement = (Some) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Some_SomeLink_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Some_NewParameter_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOr_2006ContainedLinks(
			View view) {
		Or modelElement = (Or) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Or_OrLink_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getXor_2007ContainedLinks(
			View view) {
		Xor modelElement = (Xor) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Xor_XorLink_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOne_2008ContainedLinks(
			View view) {
		One modelElement = (One) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_One_OneLink_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_One_NewParameter_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getPar_2009ContainedLinks(
			View view) {
		Par modelElement = (Par) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Par_ParLink_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLeaf_2010ContainedLinks(
			View view) {
		Leaf modelElement = (Leaf) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MultiFlow_Decompose_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_FlowDiagram_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_2011ContainedLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_FlowDiagram_Refine_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Xor_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_One_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Par_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getInterrupt_2012ContainedLinks(
			View view) {
		Interrupt modelElement = (Interrupt) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interrupt_InterruptNormalLink_4019(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interrupt_InterruptInterruptingLink_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getRetry_2013ContainedLinks(
			View view) {
		Retry modelElement = (Retry) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Retry_RetryNormalLink_4021(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Retry_RetryInterruptingLink_4022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_4015ContainedLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_FlowDiagram_Refine_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Xor_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_One_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Par_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getXor_4016ContainedLinks(
			View view) {
		Xor modelElement = (Xor) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Xor_XorLink_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOne_4017ContainedLinks(
			View view) {
		One modelElement = (One) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_One_OneLink_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_One_NewParameter_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getPar_4018ContainedLinks(
			View view) {
		Par modelElement = (Par) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Par_ParLink_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLeaf_2001IncomingLinks(
			View view) {
		Leaf modelElement = (Leaf) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_And_AndLink_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Loop_LoopLink_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_All_AllLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Some_SomeLink_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Or_OrLink_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Xor_XorLink_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_One_OneLink_4010(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Par_ParLink_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Xor_4016(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_One_4017(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Par_4018(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interrupt_InterruptNormalLink_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interrupt_InterruptInterruptingLink_4020(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Retry_RetryNormalLink_4021(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Retry_RetryInterruptingLink_4022(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getAnd_2002IncomingLinks(
			View view) {
		And modelElement = (And) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLoop_2003IncomingLinks(
			View view) {
		Loop modelElement = (Loop) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getAll_2004IncomingLinks(
			View view) {
		All modelElement = (All) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getSome_2005IncomingLinks(
			View view) {
		Some modelElement = (Some) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOr_2006IncomingLinks(
			View view) {
		Or modelElement = (Or) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getXor_2007IncomingLinks(
			View view) {
		Xor modelElement = (Xor) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOne_2008IncomingLinks(
			View view) {
		One modelElement = (One) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getPar_2009IncomingLinks(
			View view) {
		Par modelElement = (Par) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLeaf_2010IncomingLinks(
			View view) {
		Leaf modelElement = (Leaf) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_And_AndLink_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Loop_LoopLink_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_All_AllLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Some_SomeLink_4006(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Or_OrLink_4008(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Xor_XorLink_4009(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_One_OneLink_4010(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Par_ParLink_4012(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Xor_4016(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_One_4017(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Par_4018(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interrupt_InterruptNormalLink_4019(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Interrupt_InterruptInterruptingLink_4020(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Retry_RetryNormalLink_4021(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Retry_RetryInterruptingLink_4022(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_2011IncomingLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MultiFlow_Decompose_4013(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getInterrupt_2012IncomingLinks(
			View view) {
		Interrupt modelElement = (Interrupt) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getRetry_2013IncomingLinks(
			View view) {
		Retry modelElement = (Retry) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_4015IncomingLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MultiFlow_Decompose_4013(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getXor_4016IncomingLinks(
			View view) {
		Xor modelElement = (Xor) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOne_4017IncomingLinks(
			View view) {
		One modelElement = (One) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getPar_4018IncomingLinks(
			View view) {
		Par modelElement = (Par) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_FlowDiagram_4015(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLeaf_2001OutgoingLinks(
			View view) {
		Leaf modelElement = (Leaf) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MultiFlow_Decompose_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_FlowDiagram_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getAnd_2002OutgoingLinks(
			View view) {
		And modelElement = (And) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_And_AndLink_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLoop_2003OutgoingLinks(
			View view) {
		Loop modelElement = (Loop) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Loop_LoopLink_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getAll_2004OutgoingLinks(
			View view) {
		All modelElement = (All) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_All_AllLink_4004(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_All_NewParameter_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getSome_2005OutgoingLinks(
			View view) {
		Some modelElement = (Some) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Some_SomeLink_4006(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Some_NewParameter_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOr_2006OutgoingLinks(
			View view) {
		Or modelElement = (Or) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Or_OrLink_4008(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getXor_2007OutgoingLinks(
			View view) {
		Xor modelElement = (Xor) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Xor_XorLink_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOne_2008OutgoingLinks(
			View view) {
		One modelElement = (One) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_One_OneLink_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_One_NewParameter_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getPar_2009OutgoingLinks(
			View view) {
		Par modelElement = (Par) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Par_ParLink_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getLeaf_2010OutgoingLinks(
			View view) {
		Leaf modelElement = (Leaf) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MultiFlow_Decompose_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_FlowDiagram_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_2011OutgoingLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_FlowDiagram_Refine_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Xor_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_One_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Par_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getInterrupt_2012OutgoingLinks(
			View view) {
		Interrupt modelElement = (Interrupt) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Interrupt_InterruptNormalLink_4019(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Interrupt_InterruptInterruptingLink_4020(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getRetry_2013OutgoingLinks(
			View view) {
		Retry modelElement = (Retry) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Retry_RetryNormalLink_4021(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Retry_RetryInterruptingLink_4022(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getFlowDiagram_4015OutgoingLinks(
			View view) {
		FlowDiagram modelElement = (FlowDiagram) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_FlowDiagram_Refine_4014(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Xor_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_One_4017(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Par_4018(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getXor_4016OutgoingLinks(
			View view) {
		Xor modelElement = (Xor) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Xor_XorLink_4009(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getOne_4017OutgoingLinks(
			View view) {
		One modelElement = (One) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_One_OneLink_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_One_NewParameter_4011(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<AtomicitydecompositionLinkDescriptor> getPar_4018OutgoingLinks(
			View view) {
		Par modelElement = (Par) view.getElement();
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Par_ParLink_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getContainedTypeModelFacetLinks_FlowDiagram_4015(
			MultiFlow container) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		for (Iterator<?> links = container.getDecompose().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof FlowDiagram) {
				continue;
			}
			FlowDiagram link = (FlowDiagram) linkObject;
			if (FlowDiagram3EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getRefine();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Child) {
				continue;
			}
			Child dst = (Child) theTarget;
			result.add(new AtomicitydecompositionLinkDescriptor(container, dst,
					link, AtomicitydecompositionElementTypes.FlowDiagram_4015,
					FlowDiagram3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated false
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getContainedTypeModelFacetLinks_Xor_4016(
			FlowDiagram container) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		if (container == null)
			return Collections.EMPTY_LIST;
		for (Iterator<?> links = container.getRefine().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Xor) {
				continue;
			}
			Xor link = (Xor) linkObject;
			if (Xor2EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getXorLink();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof Leaf) {
				continue;
			}
			Leaf dst = (Leaf) theTarget;
			result.add(new AtomicitydecompositionLinkDescriptor(container, dst,
					link, AtomicitydecompositionElementTypes.Xor_4016,
					Xor2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated false
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getContainedTypeModelFacetLinks_One_4017(
			FlowDiagram container) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		if (container == null)
			return Collections.EMPTY_LIST;
		for (Iterator<?> links = container.getRefine().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof One) {
				continue;
			}
			One link = (One) linkObject;
			if (One2EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Leaf dst = link.getOneLink();
			result.add(new AtomicitydecompositionLinkDescriptor(container, dst,
					link, AtomicitydecompositionElementTypes.One_4017,
					One2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated not
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getContainedTypeModelFacetLinks_Par_4018(
			FlowDiagram container) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		try {
			for (Iterator<?> links = container.getRefine().iterator(); links
					.hasNext();) {
				EObject linkObject = (EObject) links.next();
				if (false == linkObject instanceof Par) {
					continue;
				}
				Par link = (Par) linkObject;
				if (Par2EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
						.getLinkWithClassVisualID(link)) {
					continue;
				}
				Leaf dst = link.getParLink();
				result.add(new AtomicitydecompositionLinkDescriptor(container,
						dst, link, AtomicitydecompositionElementTypes.Par_4018,
						Par2EditPart.VISUAL_ID));
			}
		} catch (Exception e) {
			;
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_And_AndLink_4002(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getAnd_AndLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.AndAndLink_4002,
						AndAndLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Loop_LoopLink_4003(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getLoop_LoopLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.LoopLoopLink_4003,
						LoopLoopLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_All_AllLink_4004(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getAll_AllLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.AllAllLink_4004,
						AllAllLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Some_SomeLink_4006(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getSome_SomeLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.SomeSomeLink_4006,
						SomeSomeLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Or_OrLink_4008(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getOr_OrLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.OrOrLink_4008,
						OrOrLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Xor_XorLink_4009(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getXor_XorLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.XorXorLink_4009,
						XorXorLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_One_OneLink_4010(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getOne_OneLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.OneOneLink_4010,
						OneOneLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Par_ParLink_4012(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getPar_ParLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(setting
						.getEObject(), target,
						AtomicitydecompositionElementTypes.ParParLink_4012,
						ParParLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_MultiFlow_Decompose_4013(
			FlowDiagram target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getMultiFlow_Decompose()) {
				result.add(new AtomicitydecompositionLinkDescriptor(
						setting.getEObject(),
						target,
						AtomicitydecompositionElementTypes.MultiFlowDecompose_4013,
						MultiFlowDecomposeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
			Child target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getFlowDiagram_Refine()) {
				result.add(new AtomicitydecompositionLinkDescriptor(
						setting.getEObject(),
						target,
						AtomicitydecompositionElementTypes.FlowDiagramRefine_4014,
						FlowDiagramRefineEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingTypeModelFacetLinks_FlowDiagram_4015(
			Child target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AtomicitydecompositionPackage.eINSTANCE
					.getFlowDiagram_Refine()
					|| false == setting.getEObject() instanceof FlowDiagram) {
				continue;
			}
			FlowDiagram link = (FlowDiagram) setting.getEObject();
			if (FlowDiagram3EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof MultiFlow) {
				continue;
			}
			MultiFlow container = (MultiFlow) link.eContainer();
			result.add(new AtomicitydecompositionLinkDescriptor(container,
					target, link,
					AtomicitydecompositionElementTypes.FlowDiagram_4015,
					FlowDiagram3EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingTypeModelFacetLinks_Xor_4016(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AtomicitydecompositionPackage.eINSTANCE
					.getXor_XorLink()
					|| false == setting.getEObject() instanceof Xor) {
				continue;
			}
			Xor link = (Xor) setting.getEObject();
			if (Xor2EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof FlowDiagram) {
				continue;
			}
			FlowDiagram container = (FlowDiagram) link.eContainer();
			result.add(new AtomicitydecompositionLinkDescriptor(container,
					target, link, AtomicitydecompositionElementTypes.Xor_4016,
					Xor2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingTypeModelFacetLinks_One_4017(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AtomicitydecompositionPackage.eINSTANCE
					.getOne_OneLink()
					|| false == setting.getEObject() instanceof One) {
				continue;
			}
			One link = (One) setting.getEObject();
			if (One2EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof FlowDiagram) {
				continue;
			}
			FlowDiagram container = (FlowDiagram) link.eContainer();
			result.add(new AtomicitydecompositionLinkDescriptor(container,
					target, link, AtomicitydecompositionElementTypes.One_4017,
					One2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingTypeModelFacetLinks_Par_4018(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != AtomicitydecompositionPackage.eINSTANCE
					.getPar_ParLink()
					|| false == setting.getEObject() instanceof Par) {
				continue;
			}
			Par link = (Par) setting.getEObject();
			if (Par2EditPart.VISUAL_ID != AtomicitydecompositionVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof FlowDiagram) {
				continue;
			}
			FlowDiagram container = (FlowDiagram) link.eContainer();
			result.add(new AtomicitydecompositionLinkDescriptor(container,
					target, link, AtomicitydecompositionElementTypes.Par_4018,
					Par2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Interrupt_InterruptNormalLink_4019(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getInterrupt_InterruptNormalLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(
						setting.getEObject(),
						target,
						AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019,
						InterruptInterruptNormalLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Interrupt_InterruptInterruptingLink_4020(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getInterrupt_InterruptInterruptingLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(
						setting.getEObject(),
						target,
						AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020,
						InterruptInterruptInterruptingLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Retry_RetryNormalLink_4021(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getRetry_RetryNormalLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(
						setting.getEObject(),
						target,
						AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021,
						RetryRetryNormalLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getIncomingFeatureModelFacetLinks_Retry_RetryInterruptingLink_4022(
			Leaf target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == AtomicitydecompositionPackage.eINSTANCE
					.getRetry_RetryInterruptingLink()) {
				result.add(new AtomicitydecompositionLinkDescriptor(
						setting.getEObject(),
						target,
						AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022,
						RetryRetryInterruptingLinkEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_And_AndLink_4002(
			And source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		for (Iterator<?> destinations = source.getAndLink().iterator(); destinations
				.hasNext();) {
			Leaf destination = (Leaf) destinations.next();
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination,
					AtomicitydecompositionElementTypes.AndAndLink_4002,
					AndAndLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Loop_LoopLink_4003(
			Loop source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		for (Iterator<?> destinations = source.getLoopLink().iterator(); destinations
				.hasNext();) {
			Leaf destination = (Leaf) destinations.next();
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination,
					AtomicitydecompositionElementTypes.LoopLoopLink_4003,
					LoopLoopLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_All_AllLink_4004(
			All source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getAllLink();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(source,
				destination,
				AtomicitydecompositionElementTypes.AllAllLink_4004,
				AllAllLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_All_NewParameter_4005(
			All source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		TypedParameterExpression destination = source.getNewParameter();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(source,
				destination,
				AtomicitydecompositionElementTypes.AllNewParameter_4005,
				AllNewParameterEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Some_SomeLink_4006(
			Some source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getSomeLink();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(source,
				destination,
				AtomicitydecompositionElementTypes.SomeSomeLink_4006,
				SomeSomeLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Some_NewParameter_4007(
			Some source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		TypedParameterExpression destination = source.getNewParameter();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(source,
				destination,
				AtomicitydecompositionElementTypes.SomeNewParameter_4007,
				SomeNewParameterEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Or_OrLink_4008(
			Or source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		for (Iterator<?> destinations = source.getOrLink().iterator(); destinations
				.hasNext();) {
			Leaf destination = (Leaf) destinations.next();
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination,
					AtomicitydecompositionElementTypes.OrOrLink_4008,
					OrOrLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated false
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Xor_XorLink_4009(
			Xor source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		if (source == null)
			return result;
		for (Iterator<?> destinations = source.getXorLink().iterator(); destinations
				.hasNext();) {
			Leaf destination = (Leaf) destinations.next();
			if (!source.isRef())
				result.add(new AtomicitydecompositionLinkDescriptor(source,
						destination,
						AtomicitydecompositionElementTypes.XorXorLink_4009,
						XorXorLinkEditPart.VISUAL_ID));
			else
				result.add(new AtomicitydecompositionLinkDescriptor(source,
						destination,
						AtomicitydecompositionElementTypes.Xor_4016,
						Xor2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated false
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_One_OneLink_4010(
			One source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getOneLink();
		if (destination == null) {
			return result;
		}
		if (!source.isRef())
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination,
					AtomicitydecompositionElementTypes.OneOneLink_4010,
					OneOneLinkEditPart.VISUAL_ID));
		else
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination, AtomicitydecompositionElementTypes.One_4017,
					One2EditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_One_NewParameter_4011(
			One source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		TypedParameterExpression destination = source.getNewParameter();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(source,
				destination,
				AtomicitydecompositionElementTypes.OneNewParameter_4011,
				OneNewParameterEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated false
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Par_ParLink_4012(
			Par source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getParLink();
		if (destination == null) {
			return result;
		}
		if (!source.isRef())
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination,
					AtomicitydecompositionElementTypes.ParParLink_4012,
					ParParLinkEditPart.VISUAL_ID));
		else
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination, AtomicitydecompositionElementTypes.Par_4018,
					Par2EditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_MultiFlow_Decompose_4013(
			MultiFlow source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		for (Iterator<?> destinations = source.getDecompose().iterator(); destinations
				.hasNext();) {
			FlowDiagram destination = (FlowDiagram) destinations.next();
			result.add(new AtomicitydecompositionLinkDescriptor(source,
					destination,
					AtomicitydecompositionElementTypes.MultiFlowDecompose_4013,
					MultiFlowDecomposeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated false
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_FlowDiagram_Refine_4014(
			FlowDiagram source) {
		if (source == null)
			return Collections.EMPTY_LIST;
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		for (Iterator<?> destinations = source.getRefine().iterator(); destinations
				.hasNext();) {
			Child destination = (Child) destinations.next();
			if (!destination.isRef())
				result.add(new AtomicitydecompositionLinkDescriptor(
						source,
						destination,
						AtomicitydecompositionElementTypes.FlowDiagramRefine_4014,
						FlowDiagramRefineEditPart.VISUAL_ID));
			else
				result.add(new AtomicitydecompositionLinkDescriptor(source,
						destination,
						AtomicitydecompositionElementTypes.FlowDiagram_4015,
						FlowDiagram3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Interrupt_InterruptNormalLink_4019(
			Interrupt source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getInterruptNormalLink();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(
				source,
				destination,
				AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019,
				InterruptInterruptNormalLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Interrupt_InterruptInterruptingLink_4020(
			Interrupt source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getInterruptInterruptingLink();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(
				source,
				destination,
				AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020,
				InterruptInterruptInterruptingLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Retry_RetryNormalLink_4021(
			Retry source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getRetryNormalLink();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(source,
				destination,
				AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021,
				RetryRetryNormalLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<AtomicitydecompositionLinkDescriptor> getOutgoingFeatureModelFacetLinks_Retry_RetryInterruptingLink_4022(
			Retry source) {
		LinkedList<AtomicitydecompositionLinkDescriptor> result = new LinkedList<AtomicitydecompositionLinkDescriptor>();
		Leaf destination = source.getRetryInterruptingLink();
		if (destination == null) {
			return result;
		}
		result.add(new AtomicitydecompositionLinkDescriptor(
				source,
				destination,
				AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022,
				RetryRetryInterruptingLinkEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<AtomicitydecompositionNodeDescriptor> getSemanticChildren(
				View view) {
			return AtomicitydecompositionDiagramUpdater
					.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<AtomicitydecompositionLinkDescriptor> getContainedLinks(
				View view) {
			return AtomicitydecompositionDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<AtomicitydecompositionLinkDescriptor> getIncomingLinks(
				View view) {
			return AtomicitydecompositionDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<AtomicitydecompositionLinkDescriptor> getOutgoingLinks(
				View view) {
			return AtomicitydecompositionDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
