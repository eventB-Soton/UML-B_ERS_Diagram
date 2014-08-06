/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.AndImpl#getAndLink <em>And Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndImpl extends ConstructorImpl implements And {
	/**
	 * The cached value of the '{@link #getAndLink() <em>And Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAndLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Leaf> andLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.AND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Leaf> getAndLink() {
		if (andLink == null) {
			andLink = new EObjectContainmentEList<Leaf>(Leaf.class, this, AtomicitydecompositionPackage.AND__AND_LINK);
		}
		return andLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.AND__AND_LINK:
				return ((InternalEList<?>)getAndLink()).basicRemove(otherEnd, msgs);
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
			case AtomicitydecompositionPackage.AND__AND_LINK:
				return getAndLink();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AtomicitydecompositionPackage.AND__AND_LINK:
				getAndLink().clear();
				getAndLink().addAll((Collection<? extends Leaf>)newValue);
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
			case AtomicitydecompositionPackage.AND__AND_LINK:
				getAndLink().clear();
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
			case AtomicitydecompositionPackage.AND__AND_LINK:
				return andLink != null && !andLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AndImpl
