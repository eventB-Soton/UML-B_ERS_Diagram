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
 * A representation of the model object '<em><b>Xor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Xor#getXorLink <em>Xor Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getXor()
 * @model annotation="gmf.node label.placement='none'"
 * @generated
 */
public interface Xor extends Constructor {
	/**
	 * Returns the value of the '<em><b>Xor Link</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.atomicitydecomposition.Leaf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xor Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xor Link</em>' containment reference list.
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getXor_XorLink()
	 * @model containment="true" lower="2"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	EList<Leaf> getXorLink();

} // Xor
