/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;

import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.impl.AbstractExtensionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#getRefine <em>Refine</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#isSw <em>Sw</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#isCopy <em>Copy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowDiagramImpl extends AbstractExtensionImpl implements FlowDiagram {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedParameterExpression> parameters;

	/**
	 * The cached value of the '{@link #getRefine() <em>Refine</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefine()
	 * @generated
	 * @ordered
	 */
	protected EList<Child> refine;

	/**
	 * The default value of the '{@link #isSw() <em>Sw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSw()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SW_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isSw() <em>Sw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSw()
	 * @generated
	 * @ordered
	 */
	protected boolean sw = SW_EDEFAULT;

	/**
	 * The default value of the '{@link #isCopy() <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCopy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COPY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCopy() <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCopy()
	 * @generated
	 * @ordered
	 */
	protected boolean copy = COPY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AtomicitydecompositionPackage.Literals.FLOW_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		//return name;
		if (this.eIsProxy()){
			String fragment = ((InternalEObject)this).eProxyURI().fragment();
			int ind = fragment.lastIndexOf("::");
			if (ind>-1) fragment = fragment.substring(ind+2);
			fragment = fragment.substring(fragment.lastIndexOf('.')+1);
			return fragment;
		}else{
			return name;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * Set the name attribute.
	 * Since : and . are used as delimiters in references which are formed from name, 
	 * these characters are not permitted and are changed automatically
	 * to ; and , respectively.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName.replaceAll("\\.", ",").replaceAll(":", ";");
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EVENT_BNAMED__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedParameterExpression> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<TypedParameterExpression>(TypedParameterExpression.class, this, AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Child> getRefine() {
		if (refine == null) {
			refine = new EObjectContainmentEList<Child>(Child.class, this, AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE);
		}
		return refine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSw() {
		return sw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSw(boolean newSw) {
		boolean oldSw = sw;
		sw = newSw;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.FLOW_DIAGRAM__SW, oldSw, sw));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCopy() {
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopy(boolean newCopy) {
		boolean oldCopy = copy;
		copy = newCopy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.FLOW_DIAGRAM__COPY, oldCopy, copy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String doGetName() {
		if (this.eIsProxy()){
			String fragment = ((InternalEObject)this).eProxyURI().fragment();
			int ind = fragment.lastIndexOf("::");
			if (ind>-1) fragment = fragment.substring(ind+2);
			fragment = fragment.substring(fragment.lastIndexOf('.')+1);
			return fragment;
		}else{
			return name;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE:
				return ((InternalEList<?>)getRefine()).basicRemove(otherEnd, msgs);
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__NAME:
				return getName();
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS:
				return getParameters();
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE:
				return getRefine();
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__SW:
				return isSw();
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__COPY:
				return isCopy();
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends TypedParameterExpression>)newValue);
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE:
				getRefine().clear();
				getRefine().addAll((Collection<? extends Child>)newValue);
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__SW:
				setSw((Boolean)newValue);
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__COPY:
				setCopy((Boolean)newValue);
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS:
				getParameters().clear();
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE:
				getRefine().clear();
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__SW:
				setSw(SW_EDEFAULT);
				return;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__COPY:
				setCopy(COPY_EDEFAULT);
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__REFINE:
				return refine != null && !refine.isEmpty();
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__SW:
				return sw != SW_EDEFAULT;
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__COPY:
				return copy != COPY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EventBNamed.class) {
			switch (derivedFeatureID) {
				case AtomicitydecompositionPackage.FLOW_DIAGRAM__NAME: return CorePackage.EVENT_BNAMED__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EventBNamed.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BNAMED__NAME: return AtomicitydecompositionPackage.FLOW_DIAGRAM__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", sw: ");
		result.append(sw);
		result.append(", copy: ");
		result.append(copy);
		result.append(')');
		return result.toString();
	}

} //FlowDiagramImpl
