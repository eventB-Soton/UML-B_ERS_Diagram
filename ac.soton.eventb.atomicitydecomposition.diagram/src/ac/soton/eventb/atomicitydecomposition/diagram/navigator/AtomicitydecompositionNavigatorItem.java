package ac.soton.eventb.atomicitydecomposition.diagram.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class AtomicitydecompositionNavigatorItem extends
		AtomicitydecompositionAbstractNavigatorItem {

	/**
	 * @generated
	 */
	static {
		final Class[] supportedTypes = new Class[] { View.class, EObject.class };
		Platform.getAdapterManager().registerAdapters(
				new IAdapterFactory() {

					public Object getAdapter(Object adaptableObject,
							Class adapterType) {
						if (adaptableObject instanceof ac.soton.eventb.atomicitydecomposition.diagram.navigator.AtomicitydecompositionNavigatorItem
								&& (adapterType == View.class || adapterType == EObject.class)) {
							return ((ac.soton.eventb.atomicitydecomposition.diagram.navigator.AtomicitydecompositionNavigatorItem) adaptableObject)
									.getView();
						}
						return null;
					}

					public Class[] getAdapterList() {
						return supportedTypes;
					}
				},
				ac.soton.eventb.atomicitydecomposition.diagram.navigator.AtomicitydecompositionNavigatorItem.class);
	}

	/**
	 * @generated
	 */
	private View myView;

	/**
	 * @generated
	 */
	private boolean myLeaf = false;

	/**
	 * @generated
	 */
	public AtomicitydecompositionNavigatorItem(View view, Object parent,
			boolean isLeaf) {
		super(parent);
		myView = view;
		myLeaf = isLeaf;
	}

	/**
	 * @generated
	 */
	public View getView() {
		return myView;
	}

	/**
	 * @generated
	 */
	public boolean isLeaf() {
		return myLeaf;
	}

	/**
	 * @generated
	 */
	public boolean equals(Object obj) {
		if (obj instanceof ac.soton.eventb.atomicitydecomposition.diagram.navigator.AtomicitydecompositionNavigatorItem) {
			return EcoreUtil
					.getURI(getView())
					.equals(EcoreUtil
							.getURI(((ac.soton.eventb.atomicitydecomposition.diagram.navigator.AtomicitydecompositionNavigatorItem) obj)
									.getView()));
		}
		return super.equals(obj);
	}

	/**
	 * @generated
	 */
	public int hashCode() {
		return EcoreUtil.getURI(getView()).hashCode();
	}

}
