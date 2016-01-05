/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;

import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.util.AtomicitydecompositionValidator;
import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBNamedCommentedDataElaborationElementImpl;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.core.extension.coreextension.Type;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.impl.EventBNamedImpl;
import org.eventb.emf.core.impl.StringToAttributeMapEntryImpl;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.impl.AbstractExtensionImpl;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#getExtensionId <em>Extension Id</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#getRefine <em>Refine</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#isSw <em>Sw</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl#isCopy <em>Copy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowDiagramImpl extends EventBNamedCommentedDataElaborationElementImpl implements FlowDiagram {
	/**
	 * The default value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated
	 * @ordered
	 */
	protected String extensionId = EXTENSION_ID_EDEFAULT;

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
	 * @generated NOT
	 */
	public String getExtensionId() {
		return this.extensionId;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionId(String newExtensionId) {
		String oldExtensionId = extensionId;
		extensionId = newExtensionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID, oldExtensionId, extensionId));
	}


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

	
	private EList<TypedParameterExpression> getAbstractParametersCopies(){
		EList<TypedParameterExpression> ret = new EObjectContainmentEList<TypedParameterExpression>(TypedParameterExpression.class, this, AtomicitydecompositionPackage.FLOW_DIAGRAM__PARAMETERS);
		EObject temp = this.eContainer();
		while(temp != null && !(temp instanceof Machine)){
			if(temp instanceof FlowDiagram){
				for(TypedParameterExpression tp : ((FlowDiagram) temp).getParameters()){
					TypedParameterExpression newTp = AtomicitydecompositionFactory.eINSTANCE.createTypedParameterExpression();
					newTp.setName(tp.getName());
					newTp.setInputExpression(tp.getInputExpression());
					newTp.setType(tp.getType());
					ret.add(newTp);
				}
			}
			temp = temp.eContainer();
		}
		
		return ret;
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
	 * @generated NOT
	 */
	public boolean validate(DiagnosticChain diagnostic, Map<Object, Object> context) {
		boolean status = true;
		if (diagnostic != null) {
			List<Child> refChild = new ArrayList<Child>();
			for(Child ch : this.getRefine()){
				if(ch.isRef())
					refChild.add(ch);
			}
			if(!isRootFlowDiagram()){
				if(refChild.size() != 1){
					diagnostic.add
					(new BasicDiagnostic
							(Diagnostic.ERROR,
									AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
									AtomicitydecompositionValidator.FLOW_DIAGRAM__VALIDATE,
									"FlowDiagram needs to have exactly 1 child with a solid line (ref == true)",
									new Object [] { this }));

					status = false;
				}
			}
			else{
				if(refChild.size() != 0){
					diagnostic.add
					(new BasicDiagnostic
							(Diagnostic.ERROR,
									AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
									AtomicitydecompositionValidator.FLOW_DIAGRAM__VALIDATE,
									"Root FlowDiagram cannot have a ref node (ref == true)",
									new Object [] { this }));

					status = false;
				}

			}
		}
		
		
		List<TypedParameterExpression> par = getAbstractParameters();
		//List<TypedParameterExpression> missingPars = new ArrayList<TypedParameterExpression>();
		for(TypedParameterExpression ipar : par){
			boolean contains = false;
			for(TypedParameterExpression thisPar : this.getParameters()){
				if(thisPar.getName().equals(ipar.getName())){
					contains = true;
					if(!thisPar.getType().equals(ipar.getType())){
						diagnostic.add
						(new BasicDiagnostic
								(Diagnostic.ERROR,
										AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
										AtomicitydecompositionValidator.FLOW_DIAGRAM__VALIDATE,
										"Parameter " + ipar.getName()  + " with different types in different refinement levels"  ,
										new Object [] { this }));

						status = false;
					}
					if(!thisPar.getInputExpression().equals(ipar.getInputExpression())){
						diagnostic.add
						(new BasicDiagnostic
								(Diagnostic.ERROR,
										AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
										AtomicitydecompositionValidator.FLOW_DIAGRAM__VALIDATE,
										"Parameter " + ipar.getName()  + " with different input expressions in different levels"  ,
										new Object [] { this }));

						status = false;
					}
					
					break;				
				}
			}
			if(!contains){
				diagnostic.add
				(new BasicDiagnostic
						(Diagnostic.ERROR,
								AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
								AtomicitydecompositionValidator.FLOW_DIAGRAM__VALIDATE,
								"Parameter " + ipar.getName()  + " not copied to the next refinement level"  ,
								new Object [] { this }));

				status = false;
			}
			
		}
		
		
		for(int i = 0 ; i < this.getParameters().size() ; i++){
			for(int j = i+1 ; j < this.getParameters().size() ; j++){
				if(this.getParameters().get(i).getName().equals(this.getParameters().get(j).getName())){
					diagnostic.add
					(new BasicDiagnostic
							(Diagnostic.ERROR,
									AtomicitydecompositionValidator.DIAGNOSTIC_SOURCE,
									AtomicitydecompositionValidator.FLOW_DIAGRAM__VALIDATE,
									"Parameters should have unique names"  ,
									new Object [] { this }));

					status = false;
				}
			}
		}
		
		
		return status;
	}
	
	
	private List<TypedParameterExpression> getAbstractParameters(){
		List<TypedParameterExpression> ret = new ArrayList<TypedParameterExpression>();
		EObject container = this.eContainer();
		while(container != null && !(container instanceof Machine) && !(container instanceof FlowDiagram)){
			container = container.eContainer();
		}
		
		if(container instanceof FlowDiagram){
			ret.addAll(((FlowDiagramImpl)container).getAbstractParameters());
			for(TypedParameterExpression par : this.getParameters()){
				boolean contains = false;
				for(TypedParameterExpression retPar : ret){
					if(retPar.getName().equals(par.getName())){
						contains = true;
						break;
					}
				}
				if(!contains)
					ret.add(par);
			}
			
		}
		else{
			ret.addAll(this.getParameters());
		}
		return ret;
	}
	

	private boolean isRootFlowDiagram(){
		return this.eContainer == null || this.eContainer instanceof Machine;
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID:
				return getExtensionId();
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID:
				setExtensionId((String)newValue);
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID:
				setExtensionId(EXTENSION_ID_EDEFAULT);
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
			case AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID:
				return EXTENSION_ID_EDEFAULT == null ? extensionId != null : !EXTENSION_ID_EDEFAULT.equals(extensionId);
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
		if (baseClass == Diagram.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractExtension.class) {
			switch (derivedFeatureID) {
				case AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID: return CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;
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
		if (baseClass == Diagram.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == AbstractExtension.class) {
			switch (baseFeatureID) {
				case CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID: return AtomicitydecompositionPackage.FLOW_DIAGRAM__EXTENSION_ID;
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
		result.append(" (extensionId: ");
		result.append(extensionId);
		result.append(", sw: ");
		result.append(sw);
		result.append(", copy: ");
		result.append(copy);
		result.append(')');
		return result.toString();
	}

} //FlowDiagramImpl
