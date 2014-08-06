/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.AbstractExtension;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Child#isRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getChild()
 * @model abstract="true"
 * @generated
 */
public interface Child extends EventBElement {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' attribute.
	 * @see #setRef(boolean)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getChild_Ref()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isRef();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.Child#isRef <em>Ref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' attribute.
	 * @see #isRef()
	 * @generated
	 */
	void setRef(boolean value);

} // Child
