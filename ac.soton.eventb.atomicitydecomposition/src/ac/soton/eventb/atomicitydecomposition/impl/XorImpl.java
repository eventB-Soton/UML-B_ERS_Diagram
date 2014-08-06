/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Xor;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.XorImpl#getXorLink <em>Xor Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XorImpl extends ConstructorImpl implements Xor {
	/**
	 * The cached value of the '{@link #getXorLink() <em>Xor Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXorLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Leaf> xorLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.XOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Leaf> getXorLink() {
		if (xorLink == null) {
			xorLink = new EObjectContainmentEList<Leaf>(Leaf.class, this, AtomicitydecompositionPackage.XOR__XOR_LINK);
		}
		return xorLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.XOR__XOR_LINK:
				return ((InternalEList<?>)getXorLink()).basicRemove(otherEnd, msgs);
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
			case AtomicitydecompositionPackage.XOR__XOR_LINK:
				return getXorLink();
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
			case AtomicitydecompositionPackage.XOR__XOR_LINK:
				getXorLink().clear();
				getXorLink().addAll((Collection<? extends Leaf>)newValue);
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
			case AtomicitydecompositionPackage.XOR__XOR_LINK:
				getXorLink().clear();
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
			case AtomicitydecompositionPackage.XOR__XOR_LINK:
				return xorLink != null && !xorLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XorImpl
