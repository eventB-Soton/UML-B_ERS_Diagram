package ac.soton.eventb.atomicitydecomposition.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.AtomicitydecompositionBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class FlowDiagramRefineReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public FlowDiagramRefineReorientCommand(
			ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof FlowDiagram) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Child && newEnd instanceof FlowDiagram)) {
			return false;
		}
		return AtomicitydecompositionBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistFlowDiagramRefine_4014(
						getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Child && newEnd instanceof Child)) {
			return false;
		}
		return AtomicitydecompositionBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistFlowDiagramRefine_4014(
						getOldSource(), getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getRefine().remove(getOldTarget());
		getNewSource().getRefine().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getRefine().remove(getOldTarget());
		getOldSource().getRefine().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected FlowDiagram getOldSource() {
		return (FlowDiagram) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected FlowDiagram getNewSource() {
		return (FlowDiagram) newEnd;
	}

	/**
	 * @generated
	 */
	protected Child getOldTarget() {
		return (Child) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Child getNewTarget() {
		return (Child) newEnd;
	}
}
