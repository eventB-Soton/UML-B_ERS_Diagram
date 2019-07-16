/**
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Interrupt;
import ac.soton.eventb.atomicitydecomposition.Leaf;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interrupt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.InterruptImpl#getInterruptNormalLink <em>Interrupt Normal Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.InterruptImpl#getInterruptInterruptingLink <em>Interrupt Interrupting Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterruptImpl extends ConstructorImpl implements Interrupt {
	/**
	 * The cached value of the '{@link #getInterruptNormalLink() <em>Interrupt Normal Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterruptNormalLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf interruptNormalLink;

	/**
	 * The cached value of the '{@link #getInterruptInterruptingLink() <em>Interrupt Interrupting Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterruptInterruptingLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf interruptInterruptingLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterruptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.INTERRUPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getInterruptNormalLink() {
		return interruptNormalLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterruptNormalLink(Leaf newInterruptNormalLink, NotificationChain msgs) {
		Leaf oldInterruptNormalLink = interruptNormalLink;
		interruptNormalLink = newInterruptNormalLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK, oldInterruptNormalLink, newInterruptNormalLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterruptNormalLink(Leaf newInterruptNormalLink) {
		if (newInterruptNormalLink != interruptNormalLink) {
			NotificationChain msgs = null;
			if (interruptNormalLink != null)
				msgs = ((InternalEObject)interruptNormalLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK, null, msgs);
			if (newInterruptNormalLink != null)
				msgs = ((InternalEObject)newInterruptNormalLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK, null, msgs);
			msgs = basicSetInterruptNormalLink(newInterruptNormalLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK, newInterruptNormalLink, newInterruptNormalLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getInterruptInterruptingLink() {
		return interruptInterruptingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterruptInterruptingLink(Leaf newInterruptInterruptingLink, NotificationChain msgs) {
		Leaf oldInterruptInterruptingLink = interruptInterruptingLink;
		interruptInterruptingLink = newInterruptInterruptingLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK, oldInterruptInterruptingLink, newInterruptInterruptingLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterruptInterruptingLink(Leaf newInterruptInterruptingLink) {
		if (newInterruptInterruptingLink != interruptInterruptingLink) {
			NotificationChain msgs = null;
			if (interruptInterruptingLink != null)
				msgs = ((InternalEObject)interruptInterruptingLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK, null, msgs);
			if (newInterruptInterruptingLink != null)
				msgs = ((InternalEObject)newInterruptInterruptingLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK, null, msgs);
			msgs = basicSetInterruptInterruptingLink(newInterruptInterruptingLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK, newInterruptInterruptingLink, newInterruptInterruptingLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK:
				return basicSetInterruptNormalLink(null, msgs);
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK:
				return basicSetInterruptInterruptingLink(null, msgs);
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
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK:
				return getInterruptNormalLink();
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK:
				return getInterruptInterruptingLink();
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
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK:
				setInterruptNormalLink((Leaf)newValue);
				return;
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK:
				setInterruptInterruptingLink((Leaf)newValue);
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
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK:
				setInterruptNormalLink((Leaf)null);
				return;
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK:
				setInterruptInterruptingLink((Leaf)null);
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
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_NORMAL_LINK:
				return interruptNormalLink != null;
			case AtomicitydecompositionPackage.INTERRUPT__INTERRUPT_INTERRUPTING_LINK:
				return interruptInterruptingLink != null;
		}
		return super.eIsSet(featureID);
	}

} //InterruptImpl
