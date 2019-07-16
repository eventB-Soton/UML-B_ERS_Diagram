package ac.soton.eventb.atomicitydecomposition.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagram2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParParLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParParLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramRefineEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParParLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class Par2ItemSemanticEditPolicy extends
		AtomicitydecompositionBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Par2ItemSemanticEditPolicy() {
		super(AtomicitydecompositionElementTypes.Par_4018);
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
		if (AtomicitydecompositionElementTypes.ParParLink_4012 == req
				.getElementType()) {
			return getGEFWrapper(new ParParLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.FlowDiagramRefine_4014 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.FlowDiagram_4015 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (AtomicitydecompositionElementTypes.ParParLink_4012 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.FlowDiagramRefine_4014 == req
				.getElementType()) {
			return getGEFWrapper(new FlowDiagramRefineCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.FlowDiagram_4015 == req
				.getElementType()) {
			return getGEFWrapper(new FlowDiagram2CreateCommand(req,
					req.getSource(), req.getTarget()));
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
		case FlowDiagram3EditPart.VISUAL_ID:
			return getGEFWrapper(new FlowDiagramReorientCommand(req));
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
		case ParParLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new ParParLinkReorientCommand(req));
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return getGEFWrapper(new FlowDiagramRefineReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
