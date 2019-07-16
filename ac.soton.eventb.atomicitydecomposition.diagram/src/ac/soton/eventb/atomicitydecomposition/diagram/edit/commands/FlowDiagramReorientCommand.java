package ac.soton.eventb.atomicitydecomposition.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.MultiFlow;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.AtomicitydecompositionBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class FlowDiagramReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

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
	public FlowDiagramReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof FlowDiagram) {
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
		if (!(oldEnd instanceof MultiFlow && newEnd instanceof MultiFlow)) {
			return false;
		}
		if (getLink().getRefine().size() != 1) {
			return false;
		}
		Child target = (Child) getLink().getRefine().get(0);
		return AtomicitydecompositionBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistFlowDiagram_4015(getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Child && newEnd instanceof Child)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof MultiFlow)) {
			return false;
		}
		MultiFlow source = (MultiFlow) getLink().eContainer();
		return AtomicitydecompositionBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistFlowDiagram_4015(getLink(),
						source, getNewTarget());
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
		getOldSource().getDecompose().remove(getLink());
		getNewSource().getDecompose().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getRefine().remove(getOldTarget());
		getLink().getRefine().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected FlowDiagram getLink() {
		return (FlowDiagram) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected MultiFlow getOldSource() {
		return (MultiFlow) oldEnd;
	}

	/**
	 * @generated
	 */
	protected MultiFlow getNewSource() {
		return (MultiFlow) newEnd;
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
