/**
 */
package ac.soton.eventb.atomicitydecomposition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Retry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Retry#getRetryNormalLink <em>Retry Normal Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Retry#getRetryInterruptingLink <em>Retry Interrupting Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getRetry()
 * @model
 * @generated
 */
public interface Retry extends Constructor {
	/**
	 * Returns the value of the '<em><b>Retry Normal Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry Normal Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Normal Link</em>' containment reference.
	 * @see #setRetryNormalLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getRetry_RetryNormalLink()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Leaf getRetryNormalLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Retry#getRetryNormalLink <em>Retry Normal Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Normal Link</em>' containment reference.
	 * @see #getRetryNormalLink()
	 * @generated
	 */
	void setRetryNormalLink(Leaf value);

	/**
	 * Returns the value of the '<em><b>Retry Interrupting Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retry Interrupting Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry Interrupting Link</em>' containment reference.
	 * @see #setRetryInterruptingLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getRetry_RetryInterruptingLink()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Leaf getRetryInterruptingLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Retry#getRetryInterruptingLink <em>Retry Interrupting Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Interrupting Link</em>' containment reference.
	 * @see #getRetryInterruptingLink()
	 * @generated
	 */
	void setRetryInterruptingLink(Leaf value);

} // Retry
