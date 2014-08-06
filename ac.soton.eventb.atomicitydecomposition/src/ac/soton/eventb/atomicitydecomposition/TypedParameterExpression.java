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
 * A representation of the model object '<em><b>Typed Parameter Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression#getInputExpression <em>Input Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getTypedParameterExpression()
 * @model
 * @generated
 */
public interface TypedParameterExpression extends TypedParameter {
	/**
	 * Returns the value of the '<em><b>Input Expression</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Expression</em>' attribute.
	 * @see #setInputExpression(String)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getTypedParameterExpression_InputExpression()
	 * @model default="" required="true"
	 * @generated
	 */
	String getInputExpression();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression#getInputExpression <em>Input Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Expression</em>' attribute.
	 * @see #getInputExpression()
	 * @generated
	 */
	void setInputExpression(String value);

} // TypedParameterExpression
