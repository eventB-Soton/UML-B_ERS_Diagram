/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;

import ac.soton.eventb.emf.core.extension.coreextension.impl.TypedParameterImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Parameter Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.TypedParameterExpressionImpl#getInputExpression <em>Input Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypedParameterExpressionImpl extends TypedParameterImpl implements TypedParameterExpression {
	/**
	 * The default value of the '{@link #getInputExpression() <em>Input Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_EXPRESSION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getInputExpression() <em>Input Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputExpression()
	 * @generated
	 * @ordered
	 */
	protected String inputExpression = INPUT_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedParameterExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.TYPED_PARAMETER_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputExpression() {
		return inputExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputExpression(String newInputExpression) {
		String oldInputExpression = inputExpression;
		inputExpression = newInputExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION, oldInputExpression, inputExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION:
				return getInputExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION:
				setInputExpression((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION:
				setInputExpression(INPUT_EXPRESSION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION:
				return INPUT_EXPRESSION_EDEFAULT == null ? inputExpression != null : !INPUT_EXPRESSION_EDEFAULT.equals(inputExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (InputExpression: ");
		result.append(inputExpression);
		result.append(')');
		return result.toString();
	}

} //TypedParameterExpressionImpl
