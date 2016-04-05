/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>One</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.OneImpl#getOneLink <em>One Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.OneImpl#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OneImpl extends ConstructorImpl implements One {
	/**
	 * The cached value of the '{@link #getOneLink() <em>One Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf oneLink;

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
	protected OneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.ONE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getOneLink() {
		return oneLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneLink(Leaf newOneLink, NotificationChain msgs) {
		Leaf oldOneLink = oneLink;
		oneLink = newOneLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ONE__ONE_LINK, oldOneLink, newOneLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneLink(Leaf newOneLink) {
		if (newOneLink != oneLink) {
			NotificationChain msgs = null;
			if (oneLink != null)
				msgs = ((InternalEObject)oneLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ONE__ONE_LINK, null, msgs);
			if (newOneLink != null)
				msgs = ((InternalEObject)newOneLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ONE__ONE_LINK, null, msgs);
			msgs = basicSetOneLink(newOneLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ONE__ONE_LINK, newOneLink, newOneLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedParameterExpression getNewParameter() {// Dana: This is overriden to fix parameter addition for replicators
		if (newParameter == null) {
			newParameter = new TypedParameterExpressionImpl();
		}
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ONE__NEW_PARAMETER, oldNewParameter, newNewParameter);
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
				msgs = ((InternalEObject)newParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ONE__NEW_PARAMETER, null, msgs);
			if (newNewParameter != null)
				msgs = ((InternalEObject)newNewParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ONE__NEW_PARAMETER, null, msgs);
			msgs = basicSetNewParameter(newNewParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ONE__NEW_PARAMETER, newNewParameter, newNewParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.ONE__ONE_LINK:
				return basicSetOneLink(null, msgs);
			case AtomicitydecompositionPackage.ONE__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ONE__ONE_LINK:
				return getOneLink();
			case AtomicitydecompositionPackage.ONE__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ONE__ONE_LINK:
				setOneLink((Leaf)newValue);
				return;
			case AtomicitydecompositionPackage.ONE__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ONE__ONE_LINK:
				setOneLink((Leaf)null);
				return;
			case AtomicitydecompositionPackage.ONE__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ONE__ONE_LINK:
				return oneLink != null;
			case AtomicitydecompositionPackage.ONE__NEW_PARAMETER:
				return newParameter != null;
		}
		return super.eIsSet(featureID);
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setRef(boolean newRef) {
		super.setRef(newRef);
		this.oneLink.setRef(newRef);		
	}
} //OneImpl
