package ac.soton.eventb.atomicitydecomposition.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import ac.soton.eventb.atomicitydecomposition.diagram.part.AtomicitydecompositionVisualIDRegistry;

/**
 * @generated
 */
public class AtomicitydecompositionNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 4024;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof AtomicitydecompositionNavigatorItem) {
			AtomicitydecompositionNavigatorItem item = (AtomicitydecompositionNavigatorItem) element;
			return AtomicitydecompositionVisualIDRegistry.getVisualID(item
					.getView());
		}
		return GROUP_CATEGORY;
	}

}
