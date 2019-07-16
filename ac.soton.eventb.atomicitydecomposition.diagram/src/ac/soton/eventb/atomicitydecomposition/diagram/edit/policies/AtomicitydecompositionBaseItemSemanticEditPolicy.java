package ac.soton.eventb.atomicitydecomposition.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Interrupt;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.MultiFlow;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Retry;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionDiagramEditorPlugin;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;

/**
 * @generated
 */
public class AtomicitydecompositionBaseItemSemanticEditPolicy extends
		SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final IElementType myElementType;

	/**
	 * @generated
	 */
	protected AtomicitydecompositionBaseItemSemanticEditPolicy(
			IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id.
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart()
					.getModel();
			if (view instanceof View) {
				Integer id = new Integer(
						AtomicitydecompositionVisualIDRegistry
								.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest,
				semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(
					semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand,
			DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(
				getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand
				.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request,
			Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
					.getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND,
					command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE,
				requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, null);
		request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(),
						command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * @generated
	 */
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = AtomicitydecompositionElementTypes
				.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType
				: myElementType;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for (Iterator it = view.getDiagram().getChildren().iterator(); it
				.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	 * @generated
	 */
	public static LinkConstraints getLinkConstraints() {
		LinkConstraints cached = AtomicitydecompositionDiagramEditorPlugin
				.getInstance().getLinkConstraints();
		if (cached == null) {
			AtomicitydecompositionDiagramEditorPlugin.getInstance()
					.setLinkConstraints(cached = new LinkConstraints());
		}
		return cached;
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * @generated
		 */
		public boolean canCreateAndAndLink_4002(And source, Leaf target) {
			if (source != null) {
				if (source.getAndLink().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistAndAndLink_4002(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateLoopLoopLink_4003(Loop source, Leaf target) {
			if (source != null) {
				if (source.getLoopLink().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistLoopLoopLink_4003(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateAllAllLink_4004(All source, Leaf target) {
			if (source != null) {
				if (source.getAllLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistAllAllLink_4004(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateAllNewParameter_4005(All source,
				TypedParameterExpression target) {
			if (source != null) {
				if (source.getNewParameter() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistAllNewParameter_4005(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateSomeSomeLink_4006(Some source, Leaf target) {
			if (source != null) {
				if (source.getSomeLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistSomeSomeLink_4006(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateSomeNewParameter_4007(Some source,
				TypedParameterExpression target) {
			if (source != null) {
				if (source.getNewParameter() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistSomeNewParameter_4007(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateOrOrLink_4008(Or source, Leaf target) {
			if (source != null) {
				if (source.getOrLink().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistOrOrLink_4008(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateXorXorLink_4009(Xor source, Leaf target) {
			if (source != null) {
				if (source.getXorLink().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistXorXorLink_4009(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateOneOneLink_4010(One source, Leaf target) {
			if (source != null) {
				if (source.getOneLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistOneOneLink_4010(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateOneNewParameter_4011(One source,
				TypedParameterExpression target) {
			if (source != null) {
				if (source.getNewParameter() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistOneNewParameter_4011(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateParParLink_4012(Par source, Leaf target) {
			if (source != null) {
				if (source.getParLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistParParLink_4012(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateMultiFlowDecompose_4013(MultiFlow source,
				FlowDiagram target) {
			if (source != null) {
				if (source.getDecompose().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistMultiFlowDecompose_4013(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFlowDiagramRefine_4014(FlowDiagram source,
				Child target) {
			if (source != null) {
				if (source.getRefine().contains(target)) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistFlowDiagramRefine_4014(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateFlowDiagram_4015(MultiFlow source, Child target) {
			return canExistFlowDiagram_4015(null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateXor_4016(FlowDiagram source, Leaf target) {
			return canExistXor_4016(null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateOne_4017(FlowDiagram source, Leaf target) {
			return canExistOne_4017(null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreatePar_4018(FlowDiagram source, Leaf target) {
			return canExistPar_4018(null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateInterruptInterruptNormalLink_4019(
				Interrupt source, Leaf target) {
			if (source != null) {
				if (source.getInterruptNormalLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistInterruptInterruptNormalLink_4019(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateInterruptInterruptInterruptingLink_4020(
				Interrupt source, Leaf target) {
			if (source != null) {
				if (source.getInterruptInterruptingLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistInterruptInterruptInterruptingLink_4020(source,
					target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRetryRetryNormalLink_4021(Retry source,
				Leaf target) {
			if (source != null) {
				if (source.getRetryNormalLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistRetryRetryNormalLink_4021(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateRetryRetryInterruptingLink_4022(Retry source,
				Leaf target) {
			if (source != null) {
				if (source.getRetryInterruptingLink() != null) {
					return false;
				}
				if (source == target) {
					return false;
				}
			}

			return canExistRetryRetryInterruptingLink_4022(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canExistAndAndLink_4002(And source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistLoopLoopLink_4003(Loop source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistAllAllLink_4004(All source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistAllNewParameter_4005(All source,
				TypedParameterExpression target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistSomeSomeLink_4006(Some source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistSomeNewParameter_4007(Some source,
				TypedParameterExpression target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistOrOrLink_4008(Or source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistXorXorLink_4009(Xor source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistOneOneLink_4010(One source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistOneNewParameter_4011(One source,
				TypedParameterExpression target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistParParLink_4012(Par source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistMultiFlowDecompose_4013(MultiFlow source,
				FlowDiagram target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFlowDiagramRefine_4014(FlowDiagram source,
				Child target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistFlowDiagram_4015(FlowDiagram linkInstance,
				MultiFlow source, Child target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistXor_4016(Xor linkInstance, FlowDiagram source,
				Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistOne_4017(One linkInstance, FlowDiagram source,
				Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistPar_4018(Par linkInstance, FlowDiagram source,
				Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistInterruptInterruptNormalLink_4019(
				Interrupt source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistInterruptInterruptInterruptingLink_4020(
				Interrupt source, Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRetryRetryNormalLink_4021(Retry source,
				Leaf target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistRetryRetryInterruptingLink_4022(Retry source,
				Leaf target) {
			return true;
		}
	}

}
