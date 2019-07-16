package ac.soton.eventb.atomicitydecomposition.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionModelingAssistantProvider;

/**
 * @generated
 */
public class AtomicitydecompositionModelingAssistantProviderOfXorEditPart
		extends AtomicitydecompositionModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((XorEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(XorEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AtomicitydecompositionElementTypes.XorXorLink_4009);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((XorEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			XorEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.XorXorLink_4009);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.XorXorLink_4009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((XorEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(XorEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.XorXorLink_4009) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((XorEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(XorEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		types.add(AtomicitydecompositionElementTypes.FlowDiagram_4015);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((XorEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(XorEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.FlowDiagramRefine_4014) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagram_2011);
		} else if (relationshipType == AtomicitydecompositionElementTypes.FlowDiagram_4015) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		}
		return types;
	}

}
