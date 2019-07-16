/**
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Retry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Retry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.RetryImpl#getRetryNormalLink <em>Retry Normal Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.RetryImpl#getRetryInterruptingLink <em>Retry Interrupting Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RetryImpl extends ConstructorImpl implements Retry {
	/**
	 * The cached value of the '{@link #getRetryNormalLink() <em>Retry Normal Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryNormalLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf retryNormalLink;

	/**
	 * The cached value of the '{@link #getRetryInterruptingLink() <em>Retry Interrupting Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRetryInterruptingLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf retryInterruptingLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RetryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.RETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getRetryNormalLink() {
		return retryNormalLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRetryNormalLink(Leaf newRetryNormalLink, NotificationChain msgs) {
		Leaf oldRetryNormalLink = retryNormalLink;
		retryNormalLink = newRetryNormalLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK, oldRetryNormalLink, newRetryNormalLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryNormalLink(Leaf newRetryNormalLink) {
		if (newRetryNormalLink != retryNormalLink) {
			NotificationChain msgs = null;
			if (retryNormalLink != null)
				msgs = ((InternalEObject)retryNormalLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK, null, msgs);
			if (newRetryNormalLink != null)
				msgs = ((InternalEObject)newRetryNormalLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK, null, msgs);
			msgs = basicSetRetryNormalLink(newRetryNormalLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK, newRetryNormalLink, newRetryNormalLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getRetryInterruptingLink() {
		return retryInterruptingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRetryInterruptingLink(Leaf newRetryInterruptingLink, NotificationChain msgs) {
		Leaf oldRetryInterruptingLink = retryInterruptingLink;
		retryInterruptingLink = newRetryInterruptingLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK, oldRetryInterruptingLink, newRetryInterruptingLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRetryInterruptingLink(Leaf newRetryInterruptingLink) {
		if (newRetryInterruptingLink != retryInterruptingLink) {
			NotificationChain msgs = null;
			if (retryInterruptingLink != null)
				msgs = ((InternalEObject)retryInterruptingLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK, null, msgs);
			if (newRetryInterruptingLink != null)
				msgs = ((InternalEObject)newRetryInterruptingLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK, null, msgs);
			msgs = basicSetRetryInterruptingLink(newRetryInterruptingLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK, newRetryInterruptingLink, newRetryInterruptingLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK:
				return basicSetRetryNormalLink(null, msgs);
			case AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK:
				return basicSetRetryInterruptingLink(null, msgs);
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
			case AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK:
				return getRetryNormalLink();
			case AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK:
				return getRetryInterruptingLink();
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
			case AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK:
				setRetryNormalLink((Leaf)newValue);
				return;
			case AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK:
				setRetryInterruptingLink((Leaf)newValue);
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
			case AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK:
				setRetryNormalLink((Leaf)null);
				return;
			case AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK:
				setRetryInterruptingLink((Leaf)null);
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
			case AtomicitydecompositionPackage.RETRY__RETRY_NORMAL_LINK:
				return retryNormalLink != null;
			case AtomicitydecompositionPackage.RETRY__RETRY_INTERRUPTING_LINK:
				return retryInterruptingLink != null;
		}
		return super.eIsSet(featureID);
	}

} //RetryImpl
