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

import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagram2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryInterruptingLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryInterruptingLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryNormalLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryNormalLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramRefineEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class RetryItemSemanticEditPolicy extends
		AtomicitydecompositionBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RetryItemSemanticEditPolicy() {
		super(AtomicitydecompositionElementTypes.Retry_2013);
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
					.getVisualID(incomingLink) == FlowDiagramRefineEditPart.VISUAL_ID) {
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
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(incomingLink) == FlowDiagram3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(outgoingLink) == RetryRetryNormalLinkEditPart.VISUAL_ID) {
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
					.getVisualID(outgoingLink) == RetryRetryInterruptingLinkEditPart.VISUAL_ID) {
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
		if (AtomicitydecompositionElementTypes.FlowDiagramRefine_4014 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.FlowDiagram_4015 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021 == req
				.getElementType()) {
			return getGEFWrapper(new RetryRetryNormalLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022 == req
				.getElementType()) {
			return getGEFWrapper(new RetryRetryInterruptingLinkCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
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
		if (AtomicitydecompositionElementTypes.RetryRetryNormalLink_4021 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.RetryRetryInterruptingLink_4022 == req
				.getElementType()) {
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
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return getGEFWrapper(new FlowDiagramRefineReorientCommand(req));
		case RetryRetryNormalLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new RetryRetryNormalLinkReorientCommand(req));
		case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new RetryRetryInterruptingLinkReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
