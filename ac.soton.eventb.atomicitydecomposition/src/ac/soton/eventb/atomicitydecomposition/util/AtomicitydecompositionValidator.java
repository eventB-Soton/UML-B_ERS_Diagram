/**
 */
package ac.soton.eventb.atomicitydecomposition.util;

import ac.soton.eventb.atomicitydecomposition.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage
 * @generated
 */
public class AtomicitydecompositionValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AtomicitydecompositionValidator INSTANCE = new AtomicitydecompositionValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ac.soton.eventb.atomicitydecomposition";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate' of 'Flow Diagram'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FLOW_DIAGRAM__VALIDATE = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate' of 'Loop'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int LOOP__VALIDATE = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 2;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicitydecompositionValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return AtomicitydecompositionPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case AtomicitydecompositionPackage.FLOW_DIAGRAM:
				return validateFlowDiagram((FlowDiagram)value, diagnostics, context);
			case AtomicitydecompositionPackage.CHILD:
				return validateChild((Child)value, diagnostics, context);
			case AtomicitydecompositionPackage.LEAF:
				return validateLeaf((Leaf)value, diagnostics, context);
			case AtomicitydecompositionPackage.CONSTRUCTOR:
				return validateConstructor((Constructor)value, diagnostics, context);
			case AtomicitydecompositionPackage.AND:
				return validateAnd((And)value, diagnostics, context);
			case AtomicitydecompositionPackage.LOOP:
				return validateLoop((Loop)value, diagnostics, context);
			case AtomicitydecompositionPackage.ALL:
				return validateAll((All)value, diagnostics, context);
			case AtomicitydecompositionPackage.SOME:
				return validateSome((Some)value, diagnostics, context);
			case AtomicitydecompositionPackage.OR:
				return validateOr((Or)value, diagnostics, context);
			case AtomicitydecompositionPackage.XOR:
				return validateXor((Xor)value, diagnostics, context);
			case AtomicitydecompositionPackage.ONE:
				return validateOne((One)value, diagnostics, context);
			case AtomicitydecompositionPackage.MULTI_FLOW:
				return validateMultiFlow((MultiFlow)value, diagnostics, context);
			case AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION:
				return validateTypedParameterExpression((TypedParameterExpression)value, diagnostics, context);
			case AtomicitydecompositionPackage.PAR:
				return validatePar((Par)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowDiagram(FlowDiagram flowDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(flowDiagram, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(flowDiagram, diagnostics, context);
		if (result || diagnostics != null) result &= validateFlowDiagram_validate(flowDiagram, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validate constraint of '<em>Flow Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFlowDiagram_validate(FlowDiagram flowDiagram, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return flowDiagram.validate(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChild(Child child, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(child, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLeaf(Leaf leaf, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(leaf, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstructor(Constructor constructor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(constructor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnd(And and, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(and, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoop(Loop loop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(loop, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(loop, diagnostics, context);
		if (result || diagnostics != null) result &= validateLoop_validate(loop, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validate constraint of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLoop_validate(Loop loop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return loop.validate(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAll(All all, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(all, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSome(Some some, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(some, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOr(Or or, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(or, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateXor(Xor xor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(xor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOne(One one, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(one, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMultiFlow(MultiFlow multiFlow, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(multiFlow, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTypedParameterExpression(TypedParameterExpression typedParameterExpression, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(typedParameterExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePar(Par par, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(par, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //AtomicitydecompositionValidator
