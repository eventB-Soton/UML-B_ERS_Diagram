package ac.soton.eventb.atomicitydecomposition.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllAllLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AllNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndAndLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.AndEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagram3EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.FlowDiagramRefineEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.InterruptInterruptNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Leaf2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LeafEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.LoopLoopLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.MultiFlowDecomposeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.One2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OneOneLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.OrOrLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Par2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.ParParLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryInterruptingLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.RetryRetryNormalLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeNewParameterEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.SomeSomeLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.Xor2EditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.edit.parts.XorXorLinkEditPart;
import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;
import ac.soton.eventb.atomicitydecomposition.diagram.part.Messages;

/**
 * @generated
 */
public class AtomicitydecompositionNavigatorContentProvider implements
		ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public AtomicitydecompositionNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						unloadAllResources();
						asyncRefresh();
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		myViewer = null;
		unloadAllResources();
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	void unloadAllResources() {
		for (Resource nextResource : myEditingDomain.getResourceSet()
				.getResources()) {
			nextResource.unload();
		}
	}

	/**
	 * @generated
	 */
	void asyncRefresh() {
		if (myViewer != null && !myViewer.getControl().isDisposed()) {
			myViewer.getControl().getDisplay()
					.asyncExec(myViewerRefreshRunnable);
		}
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			ArrayList<AtomicitydecompositionNavigatorItem> result = new ArrayList<AtomicitydecompositionNavigatorItem>();
			ArrayList<View> topViews = new ArrayList<View>(resource
					.getContents().size());
			for (EObject o : resource.getContents()) {
				if (o instanceof View) {
					topViews.add((View) o);
				}
			}
			result.addAll(createNavigatorItems(
					selectViewsByType(topViews, FlowDiagramEditPart.MODEL_ID),
					file, false));
			return result.toArray();
		}

		if (parentElement instanceof AtomicitydecompositionNavigatorGroup) {
			AtomicitydecompositionNavigatorGroup group = (AtomicitydecompositionNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof AtomicitydecompositionNavigatorItem) {
			AtomicitydecompositionNavigatorItem navigatorItem = (AtomicitydecompositionNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (AtomicitydecompositionVisualIDRegistry.getVisualID(view)) {

		case FlowDiagramEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Diagram sv = (Diagram) view;
			AtomicitydecompositionNavigatorGroup links = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagram_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndAndLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopLoopLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllAllLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllNewParameterEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeSomeLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeNewParameterEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrOrLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorXorLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneOneLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneNewParameterEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParParLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(MultiFlowDecomposeEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Xor2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(One2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Par2EditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptNormalLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptInterruptingLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryNormalLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			connectedViews = getDiagramLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryInterruptingLinkEditPart.VISUAL_ID));
			links.addChildren(createNavigatorItems(connectedViews, links, false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case LeafEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Leaf_2001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Leaf_2001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndAndLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopLoopLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllAllLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeSomeLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrOrLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorXorLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneOneLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParParLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(MultiFlowDecomposeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Xor2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(One2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Par2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptNormalLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptInterruptingLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryNormalLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryInterruptingLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AndEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_And_2002_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_And_2002_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndAndLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case LoopEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Loop_2003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Loop_2003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopLoopLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case AllEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_All_2004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_All_2004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllAllLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllNewParameterEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case SomeEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Some_2005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Some_2005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeSomeLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeNewParameterEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OrEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Or_2006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Or_2006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrOrLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case XorEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Xor_2007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Xor_2007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorXorLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case OneEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_One_2008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_One_2008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneOneLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneNewParameterEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case ParEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Par_2009_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Par_2009_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParParLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			return result.toArray();
		}

		case Leaf2EditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Leaf_2010_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Leaf_2010_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndAndLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopLoopLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllAllLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeSomeLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrOrLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorXorLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneOneLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParParLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(MultiFlowDecomposeEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Xor2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(One2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Par2EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptNormalLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptInterruptingLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryNormalLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryInterruptingLinkEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FlowDiagram2EditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagram_2011_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagram_2011_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(MultiFlowDecomposeEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Xor2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(One2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Par2EditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case InterruptEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Interrupt_2012_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Interrupt_2012_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptNormalLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptInterruptInterruptingLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case RetryEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Node sv = (Node) view;
			AtomicitydecompositionNavigatorGroup incominglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Retry_2013_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Retry_2013_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagramRefineEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getIncomingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram3EditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryNormalLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryRetryInterruptingLinkEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case AndAndLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_AndAndLink_4002_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_AndAndLink_4002_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case LoopLoopLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_LoopLoopLink_4003_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_LoopLoopLink_4003_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AllAllLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_AllAllLink_4004_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_AllAllLink_4004_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case AllNewParameterEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_AllNewParameter_4005_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SomeSomeLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_SomeSomeLink_4006_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_SomeSomeLink_4006_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case SomeNewParameterEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_SomeNewParameter_4007_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case OrOrLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_OrOrLink_4008_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_OrOrLink_4008_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case XorXorLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_XorXorLink_4009_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_XorXorLink_4009_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case OneOneLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_OneOneLink_4010_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_OneOneLink_4010_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case OneNewParameterEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_OneNewParameter_4011_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case ParParLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_ParParLink_4012_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_ParParLink_4012_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case MultiFlowDecomposeEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_MultiFlowDecompose_4013_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_MultiFlowDecompose_4013_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FlowDiagramRefineEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagramRefine_4014_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagramRefine_4014_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case FlowDiagram3EditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagram_4015_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagram_4015_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup outgoinglinks = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_FlowDiagram_4015_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AndEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LoopEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(AllEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(SomeEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OrEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(XorEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(OneEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(ParEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Xor2EditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Xor_4016_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Xor_4016_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case One2EditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_One_4017_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_One_4017_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case Par2EditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Par_4018_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_Par_4018_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(FlowDiagram2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case InterruptInterruptNormalLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_InterruptInterruptNormalLink_4019_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_InterruptInterruptNormalLink_4019_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case InterruptInterruptInterruptingLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_InterruptInterruptInterruptingLink_4020_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_InterruptInterruptInterruptingLink_4020_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(InterruptEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RetryRetryNormalLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_RetryRetryNormalLink_4021_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_RetryRetryNormalLink_4021_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}

		case RetryRetryInterruptingLinkEditPart.VISUAL_ID: {
			LinkedList<AtomicitydecompositionAbstractNavigatorItem> result = new LinkedList<AtomicitydecompositionAbstractNavigatorItem>();
			Edge sv = (Edge) view;
			AtomicitydecompositionNavigatorGroup target = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_RetryRetryInterruptingLink_4022_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			AtomicitydecompositionNavigatorGroup source = new AtomicitydecompositionNavigatorGroup(
					Messages.NavigatorGroupName_RetryRetryInterruptingLink_4022_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection<View> connectedViews;
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(LeafEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(Leaf2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(sv),
					AtomicitydecompositionVisualIDRegistry
							.getType(RetryEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksSourceByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getLinksTargetByType(Collection<Edge> edges,
			String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (Edge nextEdge : edges) {
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getOutgoingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getIncomingLinksByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getChildrenByType(
			Collection<? extends View> nodes, String type) {
		LinkedList<View> result = new LinkedList<View>();
		for (View nextNode : nodes) {
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection<View> getDiagramLinksByType(
			Collection<Diagram> diagrams, String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (Diagram nextDiagram : diagrams) {
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	// TODO refactor as static method
	/**
	 * @generated
	 */
	private Collection<View> selectViewsByType(Collection<View> views,
			String type) {
		ArrayList<View> result = new ArrayList<View>();
		for (View nextView : views) {
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return FlowDiagramEditPart.MODEL_ID
				.equals(AtomicitydecompositionVisualIDRegistry.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection<AtomicitydecompositionNavigatorItem> createNavigatorItems(
			Collection<View> views, Object parent, boolean isLeafs) {
		ArrayList<AtomicitydecompositionNavigatorItem> result = new ArrayList<AtomicitydecompositionNavigatorItem>(
				views.size());
		for (View nextView : views) {
			result.add(new AtomicitydecompositionNavigatorItem(nextView,
					parent, isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof AtomicitydecompositionAbstractNavigatorItem) {
			AtomicitydecompositionAbstractNavigatorItem abstractNavigatorItem = (AtomicitydecompositionAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
