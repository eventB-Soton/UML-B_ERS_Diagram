/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Or#getOrLink <em>Or Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getOr()
 * @model annotation="gmf.node label.placement='none' label.text='OR'"
 * @generated
 */
public interface Or extends Constructor {
	/**
	 * Returns the value of the '<em><b>Or Link</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.atomicitydecomposition.Leaf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Or Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Or Link</em>' containment reference list.
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getOr_OrLink()
	 * @model containment="true" lower="2"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	EList<Leaf> getOrLink();

} // Or
