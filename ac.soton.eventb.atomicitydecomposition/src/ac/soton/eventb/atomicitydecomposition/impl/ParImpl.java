/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Par</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.ParImpl#getParLink <em>Par Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.ParImpl#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParImpl extends ConstructorImpl implements Par {
	/**
	 * The cached value of the '{@link #getParLink() <em>Par Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf parLink;

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
	protected ParImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.PAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getParLink() {
		return parLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParLink(Leaf newParLink, NotificationChain msgs) {
		Leaf oldParLink = parLink;
		parLink = newParLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.PAR__PAR_LINK, oldParLink, newParLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParLink(Leaf newParLink) {
		if (newParLink != parLink) {
			NotificationChain msgs = null;
			if (parLink != null)
				msgs = ((InternalEObject)parLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.PAR__PAR_LINK, null, msgs);
			if (newParLink != null)
				msgs = ((InternalEObject)newParLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.PAR__PAR_LINK, null, msgs);
			msgs = basicSetParLink(newParLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.PAR__PAR_LINK, newParLink, newParLink));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.PAR__NEW_PARAMETER, oldNewParameter, newNewParameter);
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
				msgs = ((InternalEObject)newParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.PAR__NEW_PARAMETER, null, msgs);
			if (newNewParameter != null)
				msgs = ((InternalEObject)newNewParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.PAR__NEW_PARAMETER, null, msgs);
			msgs = basicSetNewParameter(newNewParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.PAR__NEW_PARAMETER, newNewParameter, newNewParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.PAR__PAR_LINK:
				return basicSetParLink(null, msgs);
			case AtomicitydecompositionPackage.PAR__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.PAR__PAR_LINK:
				return getParLink();
			case AtomicitydecompositionPackage.PAR__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.PAR__PAR_LINK:
				setParLink((Leaf)newValue);
				return;
			case AtomicitydecompositionPackage.PAR__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.PAR__PAR_LINK:
				setParLink((Leaf)null);
				return;
			case AtomicitydecompositionPackage.PAR__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.PAR__PAR_LINK:
				return parLink != null;
			case AtomicitydecompositionPackage.PAR__NEW_PARAMETER:
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
		this.getParLink().setRef(newRef);
	}

} //ParImpl
