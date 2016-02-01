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
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;

import ac.soton.eventb.atomicitydecomposition.util.AtomicitydecompositionValidator;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

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
	 * The cached value of the '{@link #getLoopLink() <em>Loop Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopLink()
	 * @generated
	 * @ordered
	 */
	protected EList<Leaf> loopLink;

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
	public EList<Leaf> getLoopLink() {
		if (loopLink == null) {
			loopLink = new EObjectContainmentEList<Leaf>(Leaf.class, this, AtomicitydecompositionPackage.LOOP__LOOP_LINK);
		}
		return loopLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate(DiagnosticChain diagnostic, Map<?, ?> context) {
		if (diagnostic != null) {
			int position = ((FlowDiagram)this.eContainer()).getRefine().indexOf(this);
			if(position == 0 || position == ((FlowDiagram)this.eContainer()).getRefine().size() - 1)
			diagnostic.add
			(new BasicDiagnostic
					(Diagnostic.ERROR,
							AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
							AtomicitydecompositionValidator.LOOP__VALIDATE,
							"Loops cannot be neither the first or the last child of a FlowDiagram",
							new Object [] { this }));

			return false;
		}
		return true;
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
				return ((InternalEList<?>)getLoopLink()).basicRemove(otherEnd, msgs);
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AtomicitydecompositionPackage.LOOP__LOOP_LINK:
				getLoopLink().clear();
				getLoopLink().addAll((Collection<? extends Leaf>)newValue);
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
				getLoopLink().clear();
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
				return loopLink != null && !loopLink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void setRef(boolean newRef){
		super.setRef(false);
	}
	
} //LoopImpl
