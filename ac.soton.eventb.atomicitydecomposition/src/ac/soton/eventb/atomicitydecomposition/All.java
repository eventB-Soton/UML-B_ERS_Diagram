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
 * A representation of the model object '<em><b>All</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.All#getAllLink <em>All Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.All#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getAll()
 * @model annotation="gmf.node label.text='ALL' label.placement='none'"
 * @generated
 */
public interface All extends Constructor {
	/**
	 * Returns the value of the '<em><b>All Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All Link</em>' containment reference.
	 * @see #setAllLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getAll_AllLink()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	Leaf getAllLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.All#getAllLink <em>All Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Link</em>' containment reference.
	 * @see #getAllLink()
	 * @generated
	 */
	void setAllLink(Leaf value);

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
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getAll_NewParameter()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	TypedParameterExpression getNewParameter();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.All#getNewParameter <em>New Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Parameter</em>' containment reference.
	 * @see #getNewParameter()
	 * @generated
	 */
	void setNewParameter(TypedParameterExpression value);

} // All
