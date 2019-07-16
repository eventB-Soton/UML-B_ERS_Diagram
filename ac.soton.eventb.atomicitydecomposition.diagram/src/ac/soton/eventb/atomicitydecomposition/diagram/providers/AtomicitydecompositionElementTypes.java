package ac.soton.eventb.atomicitydecomposition.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
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
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;

/**
 * @generated
 */
public class AtomicitydecompositionElementTypes {

	/**
	 * @generated
	 */
	private AtomicitydecompositionElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			AtomicitydecompositionDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType FlowDiagram_1000 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.FlowDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Leaf_2001 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Leaf_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType And_2002 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.And_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Loop_2003 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Loop_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType All_2004 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.All_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Some_2005 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Some_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Or_2006 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Or_2006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Xor_2007 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Xor_2007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType One_2008 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.One_2008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Par_2009 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Par_2009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Leaf_2010 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Leaf_2010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FlowDiagram_2011 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.FlowDiagram_2011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Interrupt_2012 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Interrupt_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Retry_2013 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Retry_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType AndAndLink_4002 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.AndAndLink_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LoopLoopLink_4003 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.LoopLoopLink_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AllAllLink_4004 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.AllAllLink_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType AllNewParameter_4005 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.AllNewParameter_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SomeSomeLink_4006 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.SomeSomeLink_4006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SomeNewParameter_4007 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.SomeNewParameter_4007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OrOrLink_4008 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.OrOrLink_4008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType XorXorLink_4009 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.XorXorLink_4009"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OneOneLink_4010 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.OneOneLink_4010"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType OneNewParameter_4011 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.OneNewParameter_4011"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ParParLink_4012 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.ParParLink_4012"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MultiFlowDecompose_4013 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.MultiFlowDecompose_4013"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FlowDiagramRefine_4014 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.FlowDiagramRefine_4014"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FlowDiagram_4015 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.FlowDiagram_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Xor_4016 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Xor_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType One_4017 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.One_4017"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Par_4018 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.Par_4018"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterruptInterruptNormalLink_4019 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.InterruptInterruptNormalLink_4019"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType InterruptInterruptInterruptingLink_4020 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.InterruptInterruptInterruptingLink_4020"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RetryRetryNormalLink_4021 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.RetryRetryNormalLink_4021"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType RetryRetryInterruptingLink_4022 = getElementType("ac.soton.eventb.atomicitydecomposition.diagram.RetryRetryInterruptingLink_4022"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(FlowDiagram_1000,
					AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram());

			elements.put(Leaf_2001,
					AtomicitydecompositionPackage.eINSTANCE.getLeaf());

			elements.put(And_2002,
					AtomicitydecompositionPackage.eINSTANCE.getAnd());

			elements.put(Loop_2003,
					AtomicitydecompositionPackage.eINSTANCE.getLoop());

			elements.put(All_2004,
					AtomicitydecompositionPackage.eINSTANCE.getAll());

			elements.put(Some_2005,
					AtomicitydecompositionPackage.eINSTANCE.getSome());

			elements.put(Or_2006,
					AtomicitydecompositionPackage.eINSTANCE.getOr());

			elements.put(Xor_2007,
					AtomicitydecompositionPackage.eINSTANCE.getXor());

			elements.put(One_2008,
					AtomicitydecompositionPackage.eINSTANCE.getOne());

			elements.put(Par_2009,
					AtomicitydecompositionPackage.eINSTANCE.getPar());

			elements.put(Leaf_2010,
					AtomicitydecompositionPackage.eINSTANCE.getLeaf());

			elements.put(FlowDiagram_2011,
					AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram());

			elements.put(Interrupt_2012,
					AtomicitydecompositionPackage.eINSTANCE.getInterrupt());

			elements.put(Retry_2013,
					AtomicitydecompositionPackage.eINSTANCE.getRetry());

			elements.put(AndAndLink_4002,
					AtomicitydecompositionPackage.eINSTANCE.getAnd_AndLink());

			elements.put(LoopLoopLink_4003,
					AtomicitydecompositionPackage.eINSTANCE.getLoop_LoopLink());

			elements.put(AllAllLink_4004,
					AtomicitydecompositionPackage.eINSTANCE.getAll_AllLink());

			elements.put(AllNewParameter_4005,
					AtomicitydecompositionPackage.eINSTANCE
							.getAll_NewParameter());

			elements.put(SomeSomeLink_4006,
					AtomicitydecompositionPackage.eINSTANCE.getSome_SomeLink());

			elements.put(SomeNewParameter_4007,
					AtomicitydecompositionPackage.eINSTANCE
							.getSome_NewParameter());

			elements.put(OrOrLink_4008,
					AtomicitydecompositionPackage.eINSTANCE.getOr_OrLink());

			elements.put(XorXorLink_4009,
					AtomicitydecompositionPackage.eINSTANCE.getXor_XorLink());

			elements.put(OneOneLink_4010,
					AtomicitydecompositionPackage.eINSTANCE.getOne_OneLink());

			elements.put(OneNewParameter_4011,
					AtomicitydecompositionPackage.eINSTANCE
							.getOne_NewParameter());

			elements.put(ParParLink_4012,
					AtomicitydecompositionPackage.eINSTANCE.getPar_ParLink());

			elements.put(MultiFlowDecompose_4013,
					AtomicitydecompositionPackage.eINSTANCE
							.getMultiFlow_Decompose());

			elements.put(FlowDiagramRefine_4014,
					AtomicitydecompositionPackage.eINSTANCE
							.getFlowDiagram_Refine());

			elements.put(FlowDiagram_4015,
					AtomicitydecompositionPackage.eINSTANCE.getFlowDiagram());

			elements.put(Xor_4016,
					AtomicitydecompositionPackage.eINSTANCE.getXor());

			elements.put(One_4017,
					AtomicitydecompositionPackage.eINSTANCE.getOne());

			elements.put(Par_4018,
					AtomicitydecompositionPackage.eINSTANCE.getPar());

			elements.put(InterruptInterruptNormalLink_4019,
					AtomicitydecompositionPackage.eINSTANCE
							.getInterrupt_InterruptNormalLink());

			elements.put(InterruptInterruptInterruptingLink_4020,
					AtomicitydecompositionPackage.eINSTANCE
							.getInterrupt_InterruptInterruptingLink());

			elements.put(RetryRetryNormalLink_4021,
					AtomicitydecompositionPackage.eINSTANCE
							.getRetry_RetryNormalLink());

			elements.put(RetryRetryInterruptingLink_4022,
					AtomicitydecompositionPackage.eINSTANCE
							.getRetry_RetryInterruptingLink());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(FlowDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Leaf_2001);
			KNOWN_ELEMENT_TYPES.add(And_2002);
			KNOWN_ELEMENT_TYPES.add(Loop_2003);
			KNOWN_ELEMENT_TYPES.add(All_2004);
			KNOWN_ELEMENT_TYPES.add(Some_2005);
			KNOWN_ELEMENT_TYPES.add(Or_2006);
			KNOWN_ELEMENT_TYPES.add(Xor_2007);
			KNOWN_ELEMENT_TYPES.add(One_2008);
			KNOWN_ELEMENT_TYPES.add(Par_2009);
			KNOWN_ELEMENT_TYPES.add(Leaf_2010);
			KNOWN_ELEMENT_TYPES.add(FlowDiagram_2011);
			KNOWN_ELEMENT_TYPES.add(Interrupt_2012);
			KNOWN_ELEMENT_TYPES.add(Retry_2013);
			KNOWN_ELEMENT_TYPES.add(AndAndLink_4002);
			KNOWN_ELEMENT_TYPES.add(LoopLoopLink_4003);
			KNOWN_ELEMENT_TYPES.add(AllAllLink_4004);
			KNOWN_ELEMENT_TYPES.add(AllNewParameter_4005);
			KNOWN_ELEMENT_TYPES.add(SomeSomeLink_4006);
			KNOWN_ELEMENT_TYPES.add(SomeNewParameter_4007);
			KNOWN_ELEMENT_TYPES.add(OrOrLink_4008);
			KNOWN_ELEMENT_TYPES.add(XorXorLink_4009);
			KNOWN_ELEMENT_TYPES.add(OneOneLink_4010);
			KNOWN_ELEMENT_TYPES.add(OneNewParameter_4011);
			KNOWN_ELEMENT_TYPES.add(ParParLink_4012);
			KNOWN_ELEMENT_TYPES.add(MultiFlowDecompose_4013);
			KNOWN_ELEMENT_TYPES.add(FlowDiagramRefine_4014);
			KNOWN_ELEMENT_TYPES.add(FlowDiagram_4015);
			KNOWN_ELEMENT_TYPES.add(Xor_4016);
			KNOWN_ELEMENT_TYPES.add(One_4017);
			KNOWN_ELEMENT_TYPES.add(Par_4018);
			KNOWN_ELEMENT_TYPES.add(InterruptInterruptNormalLink_4019);
			KNOWN_ELEMENT_TYPES.add(InterruptInterruptInterruptingLink_4020);
			KNOWN_ELEMENT_TYPES.add(RetryRetryNormalLink_4021);
			KNOWN_ELEMENT_TYPES.add(RetryRetryInterruptingLink_4022);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case FlowDiagramEditPart.VISUAL_ID:
			return FlowDiagram_1000;
		case LeafEditPart.VISUAL_ID:
			return Leaf_2001;
		case AndEditPart.VISUAL_ID:
			return And_2002;
		case LoopEditPart.VISUAL_ID:
			return Loop_2003;
		case AllEditPart.VISUAL_ID:
			return All_2004;
		case SomeEditPart.VISUAL_ID:
			return Some_2005;
		case OrEditPart.VISUAL_ID:
			return Or_2006;
		case XorEditPart.VISUAL_ID:
			return Xor_2007;
		case OneEditPart.VISUAL_ID:
			return One_2008;
		case ParEditPart.VISUAL_ID:
			return Par_2009;
		case Leaf2EditPart.VISUAL_ID:
			return Leaf_2010;
		case FlowDiagram2EditPart.VISUAL_ID:
			return FlowDiagram_2011;
		case InterruptEditPart.VISUAL_ID:
			return Interrupt_2012;
		case RetryEditPart.VISUAL_ID:
			return Retry_2013;
		case AndAndLinkEditPart.VISUAL_ID:
			return AndAndLink_4002;
		case LoopLoopLinkEditPart.VISUAL_ID:
			return LoopLoopLink_4003;
		case AllAllLinkEditPart.VISUAL_ID:
			return AllAllLink_4004;
		case AllNewParameterEditPart.VISUAL_ID:
			return AllNewParameter_4005;
		case SomeSomeLinkEditPart.VISUAL_ID:
			return SomeSomeLink_4006;
		case SomeNewParameterEditPart.VISUAL_ID:
			return SomeNewParameter_4007;
		case OrOrLinkEditPart.VISUAL_ID:
			return OrOrLink_4008;
		case XorXorLinkEditPart.VISUAL_ID:
			return XorXorLink_4009;
		case OneOneLinkEditPart.VISUAL_ID:
			return OneOneLink_4010;
		case OneNewParameterEditPart.VISUAL_ID:
			return OneNewParameter_4011;
		case ParParLinkEditPart.VISUAL_ID:
			return ParParLink_4012;
		case MultiFlowDecomposeEditPart.VISUAL_ID:
			return MultiFlowDecompose_4013;
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return FlowDiagramRefine_4014;
		case FlowDiagram3EditPart.VISUAL_ID:
			return FlowDiagram_4015;
		case Xor2EditPart.VISUAL_ID:
			return Xor_4016;
		case One2EditPart.VISUAL_ID:
			return One_4017;
		case Par2EditPart.VISUAL_ID:
			return Par_4018;
		case InterruptInterruptNormalLinkEditPart.VISUAL_ID:
			return InterruptInterruptNormalLink_4019;
		case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID:
			return InterruptInterruptInterruptingLink_4020;
		case RetryRetryNormalLinkEditPart.VISUAL_ID:
			return RetryRetryNormalLink_4021;
		case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
			return RetryRetryInterruptingLink_4022;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
