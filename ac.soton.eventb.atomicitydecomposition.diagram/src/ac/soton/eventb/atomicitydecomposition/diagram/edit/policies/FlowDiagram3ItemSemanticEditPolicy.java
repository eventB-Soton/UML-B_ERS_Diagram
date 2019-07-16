package ac.soton.eventb.atomicitydecomposition.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.MultiFlowDecomposeCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.MultiFlowDecomposeReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.One2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OneReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.Par2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.Xor2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.XorReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramRefineEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.MultiFlowDecomposeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.One2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Par2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Xor2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class FlowDiagram3ItemSemanticEditPolicy extends
		AtomicitydecompositionBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FlowDiagram3ItemSemanticEditPolicy() {
		super(AtomicitydecompositionElementTypes.FlowDiagram_4015);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (AtomicitydecompositionElementTypes.MultiFlowDecompose_4013 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.FlowDiagramRefine_4014 == req
				.getElementType()) {
			return getGEFWrapper(new FlowDiagramRefineCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.Xor_4016 == req.getElementType()) {
			return getGEFWrapper(new Xor2CreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.One_4017 == req.getElementType()) {
			return getGEFWrapper(new One2CreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.Par_4018 == req.getElementType()) {
			return getGEFWrapper(new Par2CreateCommand(req, req.getSource(),
					req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (AtomicitydecompositionElementTypes.MultiFlowDecompose_4013 == req
				.getElementType()) {
			return getGEFWrapper(new MultiFlowDecomposeCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.FlowDiagramRefine_4014 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.Xor_4016 == req.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.One_4017 == req.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.Par_4018 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case Xor2EditPart.VISUAL_ID:
			return getGEFWrapper(new XorReorientCommand(req));
		case One2EditPart.VISUAL_ID:
			return getGEFWrapper(new OneReorientCommand(req));
		case Par2EditPart.VISUAL_ID:
			return getGEFWrapper(new ParReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case MultiFlowDecomposeEditPart.VISUAL_ID:
			return getGEFWrapper(new MultiFlowDecomposeReorientCommand(req));
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return getGEFWrapper(new FlowDiagramRefineReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
