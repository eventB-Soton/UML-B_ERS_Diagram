/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Some;

import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Some</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.SomeImpl#getSomeLink <em>Some Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.SomeImpl#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SomeImpl extends ConstructorImpl implements Some {
	/**
	 * The cached value of the '{@link #getSomeLink() <em>Some Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSomeLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf someLink;

	/**
	 * The cached value of the '{@link #getNewParameter() <em>New Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewParameter()
	 * @generated
	 * @ordered
	 */
	protected TypedParameterExpression newParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SomeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.SOME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getSomeLink() {
		return someLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSomeLink(Leaf newSomeLink, NotificationChain msgs) {
		Leaf oldSomeLink = someLink;
		someLink = newSomeLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.SOME__SOME_LINK, oldSomeLink, newSomeLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSomeLink(Leaf newSomeLink) {
		if (newSomeLink != someLink) {
			NotificationChain msgs = null;
			if (someLink != null)
				msgs = ((InternalEObject)someLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.SOME__SOME_LINK, null, msgs);
			if (newSomeLink != null)
				msgs = ((InternalEObject)newSomeLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.SOME__SOME_LINK, null, msgs);
			msgs = basicSetSomeLink(newSomeLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.SOME__SOME_LINK, newSomeLink, newSomeLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedParameterExpression getNewParameter() {
		return newParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewParameter(TypedParameterExpression newNewParameter, NotificationChain msgs) {
		TypedParameterExpression oldNewParameter = newParameter;
		newParameter = newNewParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.SOME__NEW_PARAMETER, oldNewParameter, newNewParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewParameter(TypedParameterExpression newNewParameter) {
		if (newNewParameter != newParameter) {
			NotificationChain msgs = null;
			if (newParameter != null)
				msgs = ((InternalEObject)newParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.SOME__NEW_PARAMETER, null, msgs);
			if (newNewParameter != null)
				msgs = ((InternalEObject)newNewParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.SOME__NEW_PARAMETER, null, msgs);
			msgs = basicSetNewParameter(newNewParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.SOME__NEW_PARAMETER, newNewParameter, newNewParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.SOME__SOME_LINK:
				return basicSetSomeLink(null, msgs);
			case AtomicitydecompositionPackage.SOME__NEW_PARAMETER:
				return basicSetNewParameter(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AtomicitydecompositionPackage.SOME__SOME_LINK:
				return getSomeLink();
			case AtomicitydecompositionPackage.SOME__NEW_PARAMETER:
				return getNewParameter();
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
			case AtomicitydecompositionPackage.SOME__SOME_LINK:
				setSomeLink((Leaf)newValue);
				return;
			case AtomicitydecompositionPackage.SOME__NEW_PARAMETER:
				setNewParameter((TypedParameterExpression)newValue);
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
			case AtomicitydecompositionPackage.SOME__SOME_LINK:
				setSomeLink((Leaf)null);
				return;
			case AtomicitydecompositionPackage.SOME__NEW_PARAMETER:
				setNewParameter((TypedParameterExpression)null);
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
			case AtomicitydecompositionPackage.SOME__SOME_LINK:
				return someLink != null;
			case AtomicitydecompositionPackage.SOME__NEW_PARAMETER:
				return newParameter != null;
		}
		return super.eIsSet(featureID);
	}

	
	@Override
	public void setRef(boolean newRef){
		super.setRef(false);
	}
} //SomeImpl
