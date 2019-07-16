package ac.soton.eventb.atomicitydecomposition.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

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
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class FlowDiagram2ItemSemanticEditPolicy extends
		AtomicitydecompositionBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FlowDiagram2ItemSemanticEditPolicy() {
		super(AtomicitydecompositionElementTypes.FlowDiagram_2011);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(incomingLink) == MultiFlowDecomposeEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(
							IProgressMonitor progressMonitor, IAdaptable info)
							throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(
								progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(outgoingLink) == FlowDiagramRefineEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r) {
					protected CommandResult doExecuteWithResult(
							IProgressMonitor progressMonitor, IAdaptable info)
							throws ExecutionException {
						EObject referencedObject = getReferencedObject();
						Resource resource = referencedObject.eResource();
						CommandResult result = super.doExecuteWithResult(
								progressMonitor, info);
						if (resource != null) {
							resource.getContents().add(referencedObject);
						}
						return result;
					}
				});
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(outgoingLink) == Xor2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(outgoingLink) == One2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(outgoingLink) == Par2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
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
