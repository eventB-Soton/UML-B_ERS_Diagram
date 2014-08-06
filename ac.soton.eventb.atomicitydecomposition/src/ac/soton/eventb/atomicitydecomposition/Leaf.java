/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leaf</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Leaf#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getLeaf()
 * @model annotation="gmf.node label='name' color='0,189,15'"
 * @generated
 */
public interface Leaf extends Child, MultiFlow {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getLeaf_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Leaf#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Leaf
