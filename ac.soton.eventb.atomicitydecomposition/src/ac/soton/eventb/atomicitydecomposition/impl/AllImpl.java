/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.AllImpl#getAllLink <em>All Link</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.AllImpl#getNewParameter <em>New Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllImpl extends ConstructorImpl implements All {
	/**
	 * The cached value of the '{@link #getAllLink() <em>All Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllLink()
	 * @generated
	 * @ordered
	 */
	protected Leaf allLink;

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
	protected AllImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.ALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf getAllLink() {
		return allLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAllLink(Leaf newAllLink, NotificationChain msgs) {
		Leaf oldAllLink = allLink;
		allLink = newAllLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ALL__ALL_LINK, oldAllLink, newAllLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllLink(Leaf newAllLink) {
		if (newAllLink != allLink) {
			NotificationChain msgs = null;
			if (allLink != null)
				msgs = ((InternalEObject)allLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ALL__ALL_LINK, null, msgs);
			if (newAllLink != null)
				msgs = ((InternalEObject)newAllLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ALL__ALL_LINK, null, msgs);
			msgs = basicSetAllLink(newAllLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ALL__ALL_LINK, newAllLink, newAllLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public TypedParameterExpression getNewParameter() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ALL__NEW_PARAMETER, oldNewParameter, newNewParameter);
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
				msgs = ((InternalEObject)newParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ALL__NEW_PARAMETER, null, msgs);
			if (newNewParameter != null)
				msgs = ((InternalEObject)newNewParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AtomicitydecompositionPackage.ALL__NEW_PARAMETER, null, msgs);
			msgs = basicSetNewParameter(newNewParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.ALL__NEW_PARAMETER, newNewParameter, newNewParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.ALL__ALL_LINK:
				return basicSetAllLink(null, msgs);
			case AtomicitydecompositionPackage.ALL__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ALL__ALL_LINK:
				return getAllLink();
			case AtomicitydecompositionPackage.ALL__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ALL__ALL_LINK:
				setAllLink((Leaf)newValue);
				return;
			case AtomicitydecompositionPackage.ALL__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ALL__ALL_LINK:
				setAllLink((Leaf)null);
				return;
			case AtomicitydecompositionPackage.ALL__NEW_PARAMETER:
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
			case AtomicitydecompositionPackage.ALL__ALL_LINK:
				return allLink != null;
			case AtomicitydecompositionPackage.ALL__NEW_PARAMETER:
				return newParameter != null;
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public void setRef(boolean newRef){
		super.setRef(false);
	}

} //AllImpl
