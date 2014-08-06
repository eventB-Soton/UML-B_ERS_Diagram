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
 * A representation of the model object '<em><b>One</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.One#getOneLink <em>One Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.One#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getOne()
 * @model annotation="gmf.node label.placement='none'"
 * @generated
 */
public interface One extends Constructor {
	/**
	 * Returns the value of the '<em><b>One Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Link</em>' containment reference.
	 * @see #setOneLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getOne_OneLink()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	Leaf getOneLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.One#getOneLink <em>One Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Link</em>' containment reference.
	 * @see #getOneLink()
	 * @generated
	 */
	void setOneLink(Leaf value);

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
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getOne_NewParameter()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	TypedParameterExpression getNewParameter();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.One#getNewParameter <em>New Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Parameter</em>' containment reference.
	 * @see #getNewParameter()
	 * @generated
	 */
	void setNewParameter(TypedParameterExpression value);

} // One
