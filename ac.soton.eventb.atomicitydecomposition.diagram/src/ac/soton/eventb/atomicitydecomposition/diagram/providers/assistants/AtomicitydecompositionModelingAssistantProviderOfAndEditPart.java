package ac.soton.eventb.atomicitydecomposition.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionModelingAssistantProvider;

/**
 * @generated
 */
public class AtomicitydecompositionModelingAssistantProviderOfAndEditPart
		extends AtomicitydecompositionModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((AndEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(AndEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AtomicitydecompositionElementTypes.AndAndLink_4002);
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
		return doGetRelTypesOnSourceAndTarget((AndEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			AndEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.AndAndLink_4002);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.AndAndLink_4002);
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
		return doGetTypesForTarget((AndEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(AndEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.AndAndLink_4002) {
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
		return doGetRelTypesOnTarget((AndEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(AndEditPart target) {
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
		return doGetTypesForSource((AndEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(AndEditPart target,
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
