/**
 */
package ac.soton.eventb.atomicitydecomposition.provider;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;

import ac.soton.eventb.atomicitydecomposition.util.AtomicitydecompositionAdapterFactory;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup;

import ac.soton.eventb.emf.core.extension.coreextension.util.CoreextensionSwitch;

import ac.soton.eventb.emf.diagrams.DiagramOwner;
import ac.soton.eventb.emf.diagrams.DiagramsPackage;

import ac.soton.eventb.emf.diagrams.util.DiagramsSwitch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;

import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.MachinePackage;

import org.eventb.emf.core.machine.util.MachineSwitch;

import org.eventb.emf.core.util.CoreSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AtomicitydecompositionItemProviderAdapterFactory extends AtomicitydecompositionAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicitydecompositionItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.FlowDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowDiagramItemProvider flowDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.FlowDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFlowDiagramAdapter() {
		if (flowDiagramItemProvider == null) {
			flowDiagramItemProvider = new FlowDiagramItemProvider(this);
		}

		return flowDiagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Leaf} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LeafItemProvider leafItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Leaf}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLeafAdapter() {
		if (leafItemProvider == null) {
			leafItemProvider = new LeafItemProvider(this);
		}

		return leafItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.And} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndItemProvider andItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.And}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAndAdapter() {
		if (andItemProvider == null) {
			andItemProvider = new AndItemProvider(this);
		}

		return andItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Loop} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopItemProvider loopItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Loop}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLoopAdapter() {
		if (loopItemProvider == null) {
			loopItemProvider = new LoopItemProvider(this);
		}

		return loopItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.All} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllItemProvider allItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.All}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAllAdapter() {
		if (allItemProvider == null) {
			allItemProvider = new AllItemProvider(this);
		}

		return allItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Some} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SomeItemProvider someItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Some}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSomeAdapter() {
		if (someItemProvider == null) {
			someItemProvider = new SomeItemProvider(this);
		}

		return someItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Or} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrItemProvider orItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Or}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOrAdapter() {
		if (orItemProvider == null) {
			orItemProvider = new OrItemProvider(this);
		}

		return orItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Xor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XorItemProvider xorItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Xor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createXorAdapter() {
		if (xorItemProvider == null) {
			xorItemProvider = new XorItemProvider(this);
		}

		return xorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.One} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OneItemProvider oneItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.One}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOneAdapter() {
		if (oneItemProvider == null) {
			oneItemProvider = new OneItemProvider(this);
		}

		return oneItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedParameterExpressionItemProvider typedParameterExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypedParameterExpressionAdapter() {
		if (typedParameterExpressionItemProvider == null) {
			typedParameterExpressionItemProvider = new TypedParameterExpressionItemProvider(this);
		}

		return typedParameterExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Par} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParItemProvider parItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Par}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParAdapter() {
		if (parItemProvider == null) {
			parItemProvider = new ParItemProvider(this);
		}

		return parItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Interrupt} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterruptItemProvider interruptItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Interrupt}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInterruptAdapter() {
		if (interruptItemProvider == null) {
			interruptItemProvider = new InterruptItemProvider(this);
		}

		return interruptItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link ac.soton.eventb.atomicitydecomposition.Retry} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RetryItemProvider retryItemProvider;

	/**
	 * This creates an adapter for a {@link ac.soton.eventb.atomicitydecomposition.Retry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRetryAdapter() {
		if (retryItemProvider == null) {
			retryItemProvider = new RetryItemProvider(this);
		}

		return retryItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (flowDiagramItemProvider != null) flowDiagramItemProvider.dispose();
		if (leafItemProvider != null) leafItemProvider.dispose();
		if (andItemProvider != null) andItemProvider.dispose();
		if (loopItemProvider != null) loopItemProvider.dispose();
		if (allItemProvider != null) allItemProvider.dispose();
		if (someItemProvider != null) someItemProvider.dispose();
		if (orItemProvider != null) orItemProvider.dispose();
		if (xorItemProvider != null) xorItemProvider.dispose();
		if (oneItemProvider != null) oneItemProvider.dispose();
		if (typedParameterExpressionItemProvider != null) typedParameterExpressionItemProvider.dispose();
		if (parItemProvider != null) parItemProvider.dispose();
		if (interruptItemProvider != null) interruptItemProvider.dispose();
		if (retryItemProvider != null) retryItemProvider.dispose();
	}

	/**
	 * A child creation extender for the {@link DiagramsPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class DiagramsChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends DiagramsSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseDiagramOwner(DiagramOwner object) {
				newChildDescriptors.add
					(createChildParameter
						(DiagramsPackage.Literals.DIAGRAM_OWNER__DIAGRAMS,
						 AtomicitydecompositionFactory.eINSTANCE.createFlowDiagram()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return AtomicitydecompositionEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link CorePackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class CoreChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends CoreSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseEventBElement(EventBElement object) {
				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
						 AtomicitydecompositionFactory.eINSTANCE.createFlowDiagram()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseAnnotation(Annotation object) {
				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createFlowDiagram()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createLeaf()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createAnd()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createLoop()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createAll()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createSome()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createOr()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createXor()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createOne()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createPar()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createInterrupt()));

				newChildDescriptors.add
					(createChildParameter
						(CorePackage.Literals.ANNOTATION__CONTENTS,
						 AtomicitydecompositionFactory.eINSTANCE.createRetry()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return AtomicitydecompositionEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link MachinePackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class MachineChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends MachineSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseEvent(Event object) {
				newChildDescriptors.add
					(createChildParameter
						(MachinePackage.Literals.EVENT__PARAMETERS,
						 AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return AtomicitydecompositionEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link CoreextensionPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class CoreextensionChildCreationExtender implements IChildCreationExtender {
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends CoreextensionSwitch<Object> {
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseEventBEventGroup(EventBEventGroup object) {
				newChildDescriptors.add
					(createChildParameter
						(CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__PARAMETERS,
						 AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child) {
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public ResourceLocator getResourceLocator() {
			return AtomicitydecompositionEditPlugin.INSTANCE;
		}
	}

}
