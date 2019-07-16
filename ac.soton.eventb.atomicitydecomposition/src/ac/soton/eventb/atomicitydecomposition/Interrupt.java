/**
 */
package ac.soton.eventb.atomicitydecomposition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interrupt</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Interrupt#getInterruptNormalLink <em>Interrupt Normal Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Interrupt#getInterruptInterruptingLink <em>Interrupt Interrupting Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getInterrupt()
 * @model
 * @generated
 */
public interface Interrupt extends Constructor {
	/**
	 * Returns the value of the '<em><b>Interrupt Normal Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interrupt Normal Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interrupt Normal Link</em>' containment reference.
	 * @see #setInterruptNormalLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getInterrupt_InterruptNormalLink()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Leaf getInterruptNormalLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Interrupt#getInterruptNormalLink <em>Interrupt Normal Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interrupt Normal Link</em>' containment reference.
	 * @see #getInterruptNormalLink()
	 * @generated
	 */
	void setInterruptNormalLink(Leaf value);

	/**
	 * Returns the value of the '<em><b>Interrupt Interrupting Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interrupt Interrupting Link</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interrupt Interrupting Link</em>' containment reference.
	 * @see #setInterruptInterruptingLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getInterrupt_InterruptInterruptingLink()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Leaf getInterruptInterruptingLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Interrupt#getInterruptInterruptingLink <em>Interrupt Interrupting Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interrupt Interrupting Link</em>' containment reference.
	 * @see #getInterruptInterruptingLink()
	 * @generated
	 */
	void setInterruptInterruptingLink(Leaf value);

} // Interrupt
