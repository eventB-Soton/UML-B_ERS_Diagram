/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Par</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Par#getParLink <em>Par Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Par#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getPar()
 * @model annotation="gmf.node label.placement='none'"
 * @generated
 */
public interface Par extends Constructor {
	/**
	 * Returns the value of the '<em><b>Par Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Par Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Par Link</em>' containment reference.
	 * @see #setParLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getPar_ParLink()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	Leaf getParLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Par#getParLink <em>Par Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Par Link</em>' containment reference.
	 * @see #getParLink()
	 * @generated
	 */
	void setParLink(Leaf value);

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
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getPar_NewParameter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypedParameterExpression getNewParameter();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Par#getNewParameter <em>New Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Parameter</em>' containment reference.
	 * @see #getNewParameter()
	 * @generated
	 */
	void setNewParameter(TypedParameterExpression value);

} // Par
