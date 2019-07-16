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

import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.AllAllLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.AllAllLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.AndAndLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.AndAndLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagram2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramRefineReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.FlowDiagramReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.InterruptInterruptInterruptingLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.InterruptInterruptInterruptingLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.InterruptInterruptNormalLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.InterruptInterruptNormalLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.LoopLoopLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.LoopLoopLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.MultiFlowDecomposeCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.MultiFlowDecomposeReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.One2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OneOneLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OneOneLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OneReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OrOrLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.OrOrLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.Par2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParParLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParParLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.ParReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryInterruptingLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryInterruptingLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryNormalLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.RetryRetryNormalLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.SomeSomeLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.SomeSomeLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.Xor2CreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.XorReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.XorXorLinkCreateCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.commands.XorXorLinkReorientCommand;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllAllLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndAndLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramRefineEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopLoopLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.MultiFlowDecomposeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.One2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneOneLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrOrLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Par2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParParLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeSomeLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Xor2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorXorLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class LeafItemSemanticEditPolicy extends
		AtomicitydecompositionBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public LeafItemSemanticEditPolicy() {
		super(AtomicitydecompositionElementTypes.Leaf_2001);
	}

	/**
	 * @generated false
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(incomingLink) == AndAndLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == LoopLoopLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == AllAllLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == SomeSomeLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == OrOrLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == XorXorLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == OneOneLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == ParParLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == InterruptInterruptNormalLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == InterruptInterruptInterruptingLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == RetryRetryNormalLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == RetryRetryInterruptingLinkEditPart.VISUAL_ID) {
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
					.getVisualID(incomingLink) == FlowDiagram3EditPart.VISUAL_ID
					&& incomingLink.getElement() != null) {

				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(incomingLink) == Xor2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (AtomicitydecompositionVisualIDRegistry
					.getVisualID(incomingLink) == One2EditPart.VISUAL_ID) {
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
					.getVisualID(outgoingLink) == MultiFlowDecomposeEditPart.VISUAL_ID) {
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
					.getVisualID(outgoingLink) == FlowDiagram3EditPart.VISUAL_ID) {
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
		if (AtomicitydecompositionElementTypes.AndAndLink_4002 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.LoopLoopLink_4003 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.AllAllLink_4004 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.SomeSomeLink_4006 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.OrOrLink_4008 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.XorXorLink_4009 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.OneOneLink_4010 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.ParParLink_4012 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.MultiFlowDecompose_4013 == req
				.getElementType()) {
			return getGEFWrapper(new MultiFlowDecomposeCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.FlowDiagramRefine_4014 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.FlowDiagram_4015 == req
				.getElementType()) {
			return getGEFWrapper(new FlowDiagram2CreateCommand(req,
					req.getSource(), req.getTarget()));
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
		if (AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019 == req
				.getElementType()) {
			return null;
		}
		if (AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020 == req
				.getElementType()) {
			return null;
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
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (AtomicitydecompositionElementTypes.AndAndLink_4002 == req
				.getElementType()) {
			return getGEFWrapper(new AndAndLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.LoopLoopLink_4003 == req
				.getElementType()) {
			return getGEFWrapper(new LoopLoopLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.AllAllLink_4004 == req
				.getElementType()) {
			return getGEFWrapper(new AllAllLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.SomeSomeLink_4006 == req
				.getElementType()) {
			return getGEFWrapper(new SomeSomeLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.OrOrLink_4008 == req
				.getElementType()) {
			return getGEFWrapper(new OrOrLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.XorXorLink_4009 == req
				.getElementType()) {
			return getGEFWrapper(new XorXorLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.OneOneLink_4010 == req
				.getElementType()) {
			return getGEFWrapper(new OneOneLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.ParParLink_4012 == req
				.getElementType()) {
			return getGEFWrapper(new ParParLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.MultiFlowDecompose_4013 == req
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
		if (AtomicitydecompositionElementTypes.InterruptInterruptNormalLink_4019 == req
				.getElementType()) {
			return getGEFWrapper(new InterruptInterruptNormalLinkCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (AtomicitydecompositionElementTypes.InterruptInterruptInterruptingLink_4020 == req
				.getElementType()) {
			return getGEFWrapper(new InterruptInterruptInterruptingLinkCreateCommand(
					req, req.getSource(), req.getTarget()));
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
		case AndAndLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new AndAndLinkReorientCommand(req));
		case LoopLoopLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new LoopLoopLinkReorientCommand(req));
		case AllAllLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new AllAllLinkReorientCommand(req));
		case SomeSomeLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new SomeSomeLinkReorientCommand(req));
		case OrOrLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new OrOrLinkReorientCommand(req));
		case XorXorLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new XorXorLinkReorientCommand(req));
		case OneOneLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new OneOneLinkReorientCommand(req));
		case ParParLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new ParParLinkReorientCommand(req));
		case MultiFlowDecomposeEditPart.VISUAL_ID:
			return getGEFWrapper(new MultiFlowDecomposeReorientCommand(req));
		case FlowDiagramRefineEditPart.VISUAL_ID:
			return getGEFWrapper(new FlowDiagramRefineReorientCommand(req));
		case InterruptInterruptNormalLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new InterruptInterruptNormalLinkReorientCommand(
					req));
		case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new InterruptInterruptInterruptingLinkReorientCommand(
					req));
		case RetryRetryNormalLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new RetryRetryNormalLinkReorientCommand(req));
		case RetryRetryInterruptingLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new RetryRetryInterruptingLinkReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
