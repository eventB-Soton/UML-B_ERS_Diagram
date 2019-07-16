package ac.soton.eventb.atomicitydecomposition.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Interrupt;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
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
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabel6EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.WrappingLabelEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Xor2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorXorLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionParserProvider;

/**
 * @generated
 */
public class AtomicitydecompositionNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		AtomicitydecompositionDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		AtomicitydecompositionDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof AtomicitydecompositionNavigatorItem
				&& !isOwnView(((AtomicitydecompositionNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof AtomicitydecompositionNavigatorGroup) {
			AtomicitydecompositionNavigatorGroup group = (AtomicitydecompositionNavigatorGroup) element;
			return AtomicitydecompositionDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof AtomicitydecompositionNavigatorItem) {
			AtomicitydecompositionNavigatorItem navigatorItem = (AtomicitydecompositionNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {
		case FlowDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://soton.ac.uk/models/eventb/atomicitydecomposition?FlowDiagram", AtomicitydecompositionElementTypes.FlowDiagram_1000); //$NON-NLS-1$
		case LeafEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Leaf", AtomicitydecompositionElementTypes.Leaf_2001); //$NON-NLS-1$
		case AndEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?And", AtomicitydecompositionElementTypes.And_2002); //$NON-NLS-1$
		case LoopEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Loop", AtomicitydecompositionElementTypes.Loop_2003); //$NON-NLS-1$
		case AllEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?All", AtomicitydecompositionElementTypes.All_2004); //$NON-NLS-1$
		case SomeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Some", AtomicitydecompositionElementTypes.Some_2005); //$NON-NLS-1$
		case OrEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Or", AtomicitydecompositionElementTypes.Or_2006); //$NON-NLS-1$
		case XorEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Xor", AtomicitydecompositionElementTypes.Xor_2007); //$NON-NLS-1$
		case OneEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?One", AtomicitydecompositionElementTypes.One_2008); //$NON-NLS-1$
		case ParEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Par", AtomicitydecompositionElementTypes.Par_2009); //$NON-NLS-1$
		case Leaf2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Leaf", AtomicitydecompositionElementTypes.Leaf_2010); //$NON-NLS-1$
		case FlowDiagram2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?FlowDiagram", AtomicitydecompositionElementTypes.FlowDiagram_2011); //$NON-NLS-1$
		case InterruptEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Interrupt", AtomicitydecompositionElementTypes.Interrupt_2012); //$NON-NLS-1$
		case RetryEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://soton.ac.uk/models/eventb/atomicitydecomposition?Retry", AtomicitydecompositionElementTypes.Retry_2013); //$NON-NLS-1$
		case AndAndLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?And?andLink", AtomicitydecompositionElementTypes.AndAndLink_4002); //$NON-NLS-1$
		case LoopLoopLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Loop?loopLink", AtomicitydecompositionElementTypes.LoopLoopLink_4003); //$NON-NLS-1$
		case AllAllLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?All?allLink", AtomicitydecompositionElementTypes.AllAllLink_4004); //$NON-NLS-1$
		case AllNewParameterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?All?newParameter", AtomicitydecompositionElementTypes.AllNewParameter_4005); //$NON-NLS-1$
		case SomeSomeLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Some?someLink", AtomicitydecompositionElementTypes.SomeSomeLink_4006); //$NON-NLS-1$
		case SomeNewParameterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Some?newParameter", AtomicitydecompositionElementTypes.SomeNewParameter_4007); //$NON-NLS-1$
		case OrOrLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Or?orLink", AtomicitydecompositionElementTypes.OrOrLink_4008); //$NON-NLS-1$
		case XorXorLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Xor?xorLink", AtomicitydecompositionElementTypes.XorXorLink_4009); //$NON-NLS-1$
		case OneOneLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?One?oneLink", AtomicitydecompositionElementTypes.OneOneLink_4010); //$NON-NLS-1$
		case OneNewParameterEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?One?newParameter", AtomicitydecompositionElementTypes.OneNewParameter_4011); //$NON-NLS-1$
		case ParParLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Par?parLink", AtomicitydecompositionElementTypes.ParParLink_4012); //$NON-NLS-1$
		case MultiFlowDecomposeEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?MultiFlow?decompose", AtomicitydecompositionElementTypes.MultiFlowDecompose_4013); //$NON-NLS-1$
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?FlowDiagram?refine", AtomicitydecompositionElementTypes.FlowDiagramRefine_4014); //$NON-NLS-1$
		case FlowDiagram3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?FlowDiagram", AtomicitydecompositionElementTypes.FlowDiagram_4015); //$NON-NLS-1$
		case Xor2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Xor", AtomicitydecompositionElementTypes.Xor_4016); //$NON-NLS-1$
		case One2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?One", AtomicitydecompositionElementTypes.One_4017); //$NON-NLS-1$
		case Par2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Par", AtomicitydecompositionElementTypes.Par_4018); //$NON-NLS-1$
		case InterruptInterruptNormalLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Interrupt?interruptNormalLink", AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019); //$NON-NLS-1$
		case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Interrupt?interruptInterruptingLink", AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020); //$NON-NLS-1$
		case RetryRetryNormalLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Retry?retryNormalLink", AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021); //$NON-NLS-1$
		case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://soton.ac.uk/models/eventb/atomicitydecomposition?Retry?retryInterruptingLink", AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = AtomicitydecompositionDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& AtomicitydecompositionElementTypes
						.isKnownElementType(elementType)) {
			image = AtomicitydecompositionElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof AtomicitydecompositionNavigatorGroup) {
			AtomicitydecompositionNavigatorGroup group = (AtomicitydecompositionNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof AtomicitydecompositionNavigatorItem) {
			AtomicitydecompositionNavigatorItem navigatorItem = (AtomicitydecompositionNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {
		case FlowDiagramEditPart.VISUAL_ID:
			return getFlowDiagram_1000Text(view);
		case LeafEditPart.VISUAL_ID:
			return getLeaf_2001Text(view);
		case AndEditPart.VISUAL_ID:
			return getAnd_2002Text(view);
		case LoopEditPart.VISUAL_ID:
			return getLoop_2003Text(view);
		case AllEditPart.VISUAL_ID:
			return getAll_2004Text(view);
		case SomeEditPart.VISUAL_ID:
			return getSome_2005Text(view);
		case OrEditPart.VISUAL_ID:
			return getOr_2006Text(view);
		case XorEditPart.VISUAL_ID:
			return getXor_2007Text(view);
		case OneEditPart.VISUAL_ID:
			return getOne_2008Text(view);
		case ParEditPart.VISUAL_ID:
			return getPar_2009Text(view);
		case Leaf2EditPart.VISUAL_ID:
			return getLeaf_2010Text(view);
		case FlowDiagram2EditPart.VISUAL_ID:
			return getFlowDiagram_2011Text(view);
		case InterruptEditPart.VISUAL_ID:
			return getInterrupt_2012Text(view);
		case RetryEditPart.VISUAL_ID:
			return getRetry_2013Text(view);
		case AndAndLinkEditPart.VISUAL_ID:
			return getAndAndLink_4002Text(view);
		case LoopLoopLinkEditPart.VISUAL_ID:
			return getLoopLoopLink_4003Text(view);
		case AllAllLinkEditPart.VISUAL_ID:
			return getAllAllLink_4004Text(view);
		case AllNewParameterEditPart.VISUAL_ID:
			return getAllNewParameter_4005Text(view);
		case SomeSomeLinkEditPart.VISUAL_ID:
			return getSomeSomeLink_4006Text(view);
		case SomeNewParameterEditPart.VISUAL_ID:
			return getSomeNewParameter_4007Text(view);
		case OrOrLinkEditPart.VISUAL_ID:
			return getOrOrLink_4008Text(view);
		case XorXorLinkEditPart.VISUAL_ID:
			return getXorXorLink_4009Text(view);
		case OneOneLinkEditPart.VISUAL_ID:
			return getOneOneLink_4010Text(view);
		case OneNewParameterEditPart.VISUAL_ID:
			return getOneNewParameter_4011Text(view);
		case ParParLinkEditPart.VISUAL_ID:
			return getParParLink_4012Text(view);
		case MultiFlowDecomposeEditPart.VISUAL_ID:
			return getMultiFlowDecompose_4013Text(view);
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return getFlowDiagramRefine_4014Text(view);
		case FlowDiagram3EditPart.VISUAL_ID:
			return getFlowDiagram_4015Text(view);
		case Xor2EditPart.VISUAL_ID:
			return getXor_4016Text(view);
		case One2EditPart.VISUAL_ID:
			return getOne_4017Text(view);
		case Par2EditPart.VISUAL_ID:
			return getPar_4018Text(view);
		case InterruptInterruptNormalLinkEditPart.VISUAL_ID:
			return getInterruptInterruptNormalLink_4019Text(view);
		case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID:
			return getInterruptInterruptInterruptingLink_4020Text(view);
		case RetryRetryNormalLinkEditPart.VISUAL_ID:
			return getRetryRetryNormalLink_4021Text(view);
		case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
			return getRetryRetryInterruptingLink_4022Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getFlowDiagram_1000Text(View view) {
		FlowDiagram domainModelElement = (FlowDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLeaf_2001Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Leaf_2001,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(LeafNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAnd_2002Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.And_2002,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(WrappingLabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoop_2003Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Loop_2003,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(WrappingLabel2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAll_2004Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.All_2004,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(LabelEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSome_2005Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Some_2005,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(Label2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOr_2006Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Or_2006,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(Label3EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getXor_2007Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Xor_2007,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(Label4EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOne_2008Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.One_2008,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(Label5EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPar_2009Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Par_2009,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(Label6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLeaf_2010Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Leaf_2010,
				view.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(LeafName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFlowDiagram_2011Text(View view) {
		FlowDiagram domainModelElement = (FlowDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterrupt_2012Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Interrupt_2012,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRetry_2013Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.Retry_2013, view
						.getElement() != null ? view.getElement() : view,
				AtomicitydecompositionVisualIDRegistry
						.getType(WrappingLabel6EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAndAndLink_4002Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.AndAndLink_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getLoopLoopLink_4003Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.LoopLoopLink_4003,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAllAllLink_4004Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.AllAllLink_4004,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getAllNewParameter_4005Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.AllNewParameter_4005,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSomeSomeLink_4006Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.SomeSomeLink_4006,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSomeNewParameter_4007Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.SomeNewParameter_4007,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOrOrLink_4008Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.OrOrLink_4008,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getXorXorLink_4009Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.XorXorLink_4009,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOneOneLink_4010Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.OneOneLink_4010,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOneNewParameter_4011Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.OneNewParameter_4011,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getParParLink_4012Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.ParParLink_4012,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getMultiFlowDecompose_4013Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFlowDiagramRefine_4014Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getFlowDiagram_4015Text(View view) {
		FlowDiagram domainModelElement = (FlowDiagram) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getXor_4016Text(View view) {
		Xor domainModelElement = (Xor) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getOne_4017Text(View view) {
		One domainModelElement = (One) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4017); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPar_4018Text(View view) {
		Par domainModelElement = (Par) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getReference();
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 4018); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterruptInterruptNormalLink_4019Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider
				.getParser(
						AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6013); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getInterruptInterruptInterruptingLink_4020Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider
				.getParser(
						AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6014); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRetryRetryNormalLink_4021Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider.getParser(
				AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6015); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRetryRetryInterruptingLink_4022Text(View view) {
		IParser parser = AtomicitydecompositionParserProvider
				.getParser(
						AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			AtomicitydecompositionDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6016); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return FlowDiagramEditPart.MODEL_ID
				.equals(AtomicitydecompositionVisualIDRegistry.getModelID(view));
	}

}
