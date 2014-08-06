/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Loop#getLoopLink <em>Loop Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getLoop()
 * @model annotation="gmf.node figure='ellipse' label.placement='none'"
 *        annotation="gmf.label label.text='*'"
 * @generated
 */
public interface Loop extends Constructor {
	/**
	 * Returns the value of the '<em><b>Loop Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Link</em>' containment reference.
	 * @see #setLoopLink(Leaf)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getLoop_LoopLink()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	Leaf getLoopLink();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Loop#getLoopLink <em>Loop Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Link</em>' containment reference.
	 * @see #getLoopLink()
	 * @generated
	 */
	void setLoopLink(Leaf value);

} // Loop
