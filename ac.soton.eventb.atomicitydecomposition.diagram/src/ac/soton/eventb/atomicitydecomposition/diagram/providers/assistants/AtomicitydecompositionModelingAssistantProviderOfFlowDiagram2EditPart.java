package ac.soton.eventb.atomicitydecomposition.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionModelingAssistantProvider;

/**
 * @generated
 */
public class AtomicitydecompositionModelingAssistantProviderOfFlowDiagram2EditPart
		extends AtomicitydecompositionModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((FlowDiagram2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(FlowDiagram2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(4);
		types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		types.add(AtomicitydecompositionElementTypes.Xor_4016);
		types.add(AtomicitydecompositionElementTypes.One_4017);
		types.add(AtomicitydecompositionElementTypes.Par_4018);
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
		return doGetRelTypesOnSourceAndTarget(
				(FlowDiagram2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			FlowDiagram2EditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof AndEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof LoopEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof AllEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof SomeEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof OrEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof XorEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof OneEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof ParEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof InterruptEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof RetryEditPart) {
			types.add(AtomicitydecompositionElementTypes.FlowDiagramRefine_4014);
		}
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.Xor_4016);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.Xor_4016);
		}
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.One_4017);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.One_4017);
		}
		if (targetEditPart instanceof LeafEditPart) {
			types.add(AtomicitydecompositionElementTypes.Par_4018);
		}
		if (targetEditPart instanceof Leaf2EditPart) {
			types.add(AtomicitydecompositionElementTypes.Par_4018);
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
		return doGetTypesForTarget((FlowDiagram2EditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(FlowDiagram2EditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.FlowDiagramRefine_4014) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.And_2002);
			types.add(AtomicitydecompositionElementTypes.Loop_2003);
			types.add(AtomicitydecompositionElementTypes.All_2004);
			types.add(AtomicitydecompositionElementTypes.Some_2005);
			types.add(AtomicitydecompositionElementTypes.Or_2006);
			types.add(AtomicitydecompositionElementTypes.Xor_2007);
			types.add(AtomicitydecompositionElementTypes.One_2008);
			types.add(AtomicitydecompositionElementTypes.Par_2009);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
			types.add(AtomicitydecompositionElementTypes.Interrupt_2012);
			types.add(AtomicitydecompositionElementTypes.Retry_2013);
		} else if (relationshipType == AtomicitydecompositionElementTypes.Xor_4016) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		} else if (relationshipType == AtomicitydecompositionElementTypes.One_4017) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		} else if (relationshipType == AtomicitydecompositionElementTypes.Par_4018) {
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
		return doGetRelTypesOnTarget((FlowDiagram2EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(FlowDiagram2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(AtomicitydecompositionElementTypes.MultiFlowDecompose_4013);
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
		return doGetTypesForSource((FlowDiagram2EditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(FlowDiagram2EditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == AtomicitydecompositionElementTypes.MultiFlowDecompose_4013) {
			types.add(AtomicitydecompositionElementTypes.Leaf_2001);
			types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		}
		return types;
	}

}
