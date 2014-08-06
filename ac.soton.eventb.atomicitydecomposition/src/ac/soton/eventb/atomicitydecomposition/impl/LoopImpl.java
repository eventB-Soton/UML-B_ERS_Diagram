/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.LoopImpl#getLoopLink <em>Loop Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopImpl extends ConstructorImpl implements Loop {
	/**
	 * The cached value of the '{@link #getLoopLink() <em>Loop Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf loopLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getLoopLink() {
		return loopLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopLink(Leaf newLoopLink, NotificationChain msgs) {
		Leaf oldLoopLink = loopLink;
		loopLink = newLoopLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.LOOP__LOOP_LINK, oldLoopLink, newLoopLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopLink(Leaf newLoopLink) {
		if (newLoopLink != loopLink) {
			NotificationChain msgs = null;
			if (loopLink != null)
				msgs = ((InternalEObject)loopLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.LOOP__LOOP_LINK, null, msgs);
			if (newLoopLink != null)
				msgs = ((InternalEObject)newLoopLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.LOOP__LOOP_LINK, null, msgs);
			msgs = basicSetLoopLink(newLoopLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.LOOP__LOOP_LINK, newLoopLink, newLoopLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.LOOP__LOOP_LINK:
				return basicSetLoopLink(null, msgs);
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
			case AtomicitydecompositionPackage.LOOP__LOOP_LINK:
				return getLoopLink();
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
			case AtomicitydecompositionPackage.LOOP__LOOP_LINK:
				setLoopLink((Leaf)newValue);
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
			case AtomicitydecompositionPackage.LOOP__LOOP_LINK:
				setLoopLink((Leaf)null);
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
			case AtomicitydecompositionPackage.LOOP__LOOP_LINK:
				return loopLink != null;
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl
