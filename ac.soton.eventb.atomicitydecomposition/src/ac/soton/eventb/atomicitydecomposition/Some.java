/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Some</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Some#getSomeLink <em>Some Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Some#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getSome()
 * @model annotation="gmf.node label.text='SOME' label.placement='none'"
 * @generated
 */
public interface Some extends Constructor {
	/**
	 * Returns the value of the '<em><b>Some Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Some Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Some Link</em>' containment reference.
	 * @see #setSomeLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getSome_SomeLink()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	Leaf getSomeLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Some#getSomeLink <em>Some Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Some Link</em>' containment reference.
	 * @see #getSomeLink()
	 * @generated
	 */
	void setSomeLink(Leaf value);

	/**
	 * Returns the value of the '<em><b>New Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Parameter</em>' containment reference.
	 * @see #setNewParameter(TypedParameterExpression)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getSome_NewParameter()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	TypedParameterExpression getNewParameter();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Some#getNewParameter <em>New Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Parameter</em>' containment reference.
	 * @see #getNewParameter()
	 * @generated
	 */
	void setNewParameter(TypedParameterExpression value);

} // Some
