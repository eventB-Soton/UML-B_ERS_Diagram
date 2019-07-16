package ac.soton.eventb.atomicitydecomposition.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.policies.AtomicitydecompositionBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class OneReorientCommand extends EditElementCommand {

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
	public OneReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof One) {
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
		if (!(oldEnd instanceof FlowDiagram && newEnd instanceof FlowDiagram)) {
			return false;
		}
		Leaf target = getLink().getOneLink();
		return AtomicitydecompositionBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistOne_4017(getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Leaf && newEnd instanceof Leaf)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof FlowDiagram)) {
			return false;
		}
		FlowDiagram source = (FlowDiagram) getLink().eContainer();
		return AtomicitydecompositionBaseItemSemanticEditPolicy
				.getLinkConstraints().canExistOne_4017(getLink(), source,
						getNewTarget());
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
		getOldSource().getRefine().remove(getLink());
		getNewSource().getRefine().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setOneLink(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected One getLink() {
		return (One) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected FlowDiagram getOldSource() {
		return (FlowDiagram) oldEnd;
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
	protected Leaf getOldTarget() {
		return (Leaf) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Leaf getNewTarget() {
		return (Leaf) newEnd;
	}
}
