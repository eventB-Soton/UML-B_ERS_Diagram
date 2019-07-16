package ac.soton.eventb.atomicitydecomposition.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.AllCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.AndCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.InterruptCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.Leaf2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.LeafCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.LoopCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OneCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OrCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.SomeCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.XorCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class FlowDiagramItemSemanticEditPolicy extends
		AtomicitydecompositionBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FlowDiagramItemSemanticEditPolicy() {
		super(AtomicitydecompositionElementTypes.FlowDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (AtomicitydecompositionElementTypes.Leaf_2001 == req
				.getElementType()) {
			return getGEFWrapper(new LeafCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.And_2002 == req.getElementType()) {
			return getGEFWrapper(new AndCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Loop_2003 == req
				.getElementType()) {
			return getGEFWrapper(new LoopCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.All_2004 == req.getElementType()) {
			return getGEFWrapper(new AllCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Some_2005 == req
				.getElementType()) {
			return getGEFWrapper(new SomeCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Or_2006 == req.getElementType()) {
			return getGEFWrapper(new OrCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Xor_2007 == req.getElementType()) {
			return getGEFWrapper(new XorCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.One_2008 == req.getElementType()) {
			return getGEFWrapper(new OneCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Par_2009 == req.getElementType()) {
			return getGEFWrapper(new ParCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Leaf_2010 == req
				.getElementType()) {
			return getGEFWrapper(new Leaf2CreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.FlowDiagram_2011 == req
				.getElementType()) {
			return getGEFWrapper(new FlowDiagramCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Interrupt_2012 == req
				.getElementType()) {
			return getGEFWrapper(new InterruptCreateCommand(req));
		}
		if (AtomicitydecompositionElementTypes.Retry_2013 == req
				.getElementType()) {
			return getGEFWrapper(new RetryCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
