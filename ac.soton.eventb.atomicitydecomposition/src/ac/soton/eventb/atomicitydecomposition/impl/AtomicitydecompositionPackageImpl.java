/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory;
import ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.Constructor;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.MultiFlow;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.Xor;

import ac.soton.eventb.atomicitydecomposition.util.AtomicitydecompositionValidator;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

import ac.soton.eventb.emf.diagrams.DiagramsPackage;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eventb.emf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AtomicitydecompositionPackageImpl extends EPackageImpl implements AtomicitydecompositionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leafEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass someEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedParameterExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AtomicitydecompositionPackageImpl() {
		super(eNS_URI, AtomicitydecompositionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AtomicitydecompositionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AtomicitydecompositionPackage init() {
		if (isInited) return (AtomicitydecompositionPackage)EPackage.Registry.INSTANCE.getEPackage(AtomicitydecompositionPackage.eNS_URI);

		// Obtain or create and register package
		AtomicitydecompositionPackageImpl theAtomicitydecompositionPackage = (AtomicitydecompositionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AtomicitydecompositionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AtomicitydecompositionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramsPackage.eINSTANCE.eClass();
		CoreextensionPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAtomicitydecompositionPackage.createPackageContents();

		// Initialize created meta-data
		theAtomicitydecompositionPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theAtomicitydecompositionPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return AtomicitydecompositionValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theAtomicitydecompositionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AtomicitydecompositionPackage.eNS_URI, theAtomicitydecompositionPackage);
		return theAtomicitydecompositionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowDiagram() {
		return flowDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowDiagram_Parameters() {
		return (EReference)flowDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowDiagram_Refine() {
		return (EReference)flowDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowDiagram_Sw() {
		return (EAttribute)flowDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFlowDiagram_Copy() {
		return (EAttribute)flowDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChild() {
		return childEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChild_Ref() {
		return (EAttribute)childEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeaf() {
		return leafEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLeaf_Name() {
		return (EAttribute)leafEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructor() {
		return constructorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnd_AndLink() {
		return (EReference)andEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoop() {
		return loopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_LoopLink() {
		return (EReference)loopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAll() {
		return allEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAll_AllLink() {
		return (EReference)allEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAll_NewParameter() {
		return (EReference)allEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSome() {
		return someEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSome_SomeLink() {
		return (EReference)someEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSome_NewParameter() {
		return (EReference)someEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOr_OrLink() {
		return (EReference)orEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXor() {
		return xorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXor_XorLink() {
		return (EReference)xorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOne() {
		return oneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOne_OneLink() {
		return (EReference)oneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOne_NewParameter() {
		return (EReference)oneEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiFlow() {
		return multiFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiFlow_Decompose() {
		return (EReference)multiFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedParameterExpression() {
		return typedParameterExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedParameterExpression_InputExpression() {
		return (EAttribute)typedParameterExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPar() {
		return parEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPar_ParLink() {
		return (EReference)parEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPar_NewParameter() {
		return (EReference)parEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicitydecompositionFactory getAtomicitydecompositionFactory() {
		return (AtomicitydecompositionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		flowDiagramEClass = createEClass(FLOW_DIAGRAM);
		createEReference(flowDiagramEClass, FLOW_DIAGRAM__PARAMETERS);
		createEReference(flowDiagramEClass, FLOW_DIAGRAM__REFINE);
		createEAttribute(flowDiagramEClass, FLOW_DIAGRAM__SW);
		createEAttribute(flowDiagramEClass, FLOW_DIAGRAM__COPY);

		childEClass = createEClass(CHILD);
		createEAttribute(childEClass, CHILD__REF);

		leafEClass = createEClass(LEAF);
		createEAttribute(leafEClass, LEAF__NAME);

		constructorEClass = createEClass(CONSTRUCTOR);

		andEClass = createEClass(AND);
		createEReference(andEClass, AND__AND_LINK);

		loopEClass = createEClass(LOOP);
		createEReference(loopEClass, LOOP__LOOP_LINK);

		allEClass = createEClass(ALL);
		createEReference(allEClass, ALL__ALL_LINK);
		createEReference(allEClass, ALL__NEW_PARAMETER);

		someEClass = createEClass(SOME);
		createEReference(someEClass, SOME__SOME_LINK);
		createEReference(someEClass, SOME__NEW_PARAMETER);

		orEClass = createEClass(OR);
		createEReference(orEClass, OR__OR_LINK);

		xorEClass = createEClass(XOR);
		createEReference(xorEClass, XOR__XOR_LINK);

		oneEClass = createEClass(ONE);
		createEReference(oneEClass, ONE__ONE_LINK);
		createEReference(oneEClass, ONE__NEW_PARAMETER);

		multiFlowEClass = createEClass(MULTI_FLOW);
		createEReference(multiFlowEClass, MULTI_FLOW__DECOMPOSE);

		typedParameterExpressionEClass = createEClass(TYPED_PARAMETER_EXPRESSION);
		createEAttribute(typedParameterExpressionEClass, TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION);

		parEClass = createEClass(PAR);
		createEReference(parEClass, PAR__PAR_LINK);
		createEReference(parEClass, PAR__NEW_PARAMETER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CoreextensionPackage theCoreextensionPackage = (CoreextensionPackage)EPackage.Registry.INSTANCE.getEPackage(CoreextensionPackage.eNS_URI);
		DiagramsPackage theDiagramsPackage = (DiagramsPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramsPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		flowDiagramEClass.getESuperTypes().add(theCoreextensionPackage.getEventBNamedCommentedDataElaborationElement());
		flowDiagramEClass.getESuperTypes().add(theDiagramsPackage.getDiagram());
		flowDiagramEClass.getESuperTypes().add(theCorePackage.getAbstractExtension());
		childEClass.getESuperTypes().add(theCorePackage.getEventBElement());
		leafEClass.getESuperTypes().add(this.getChild());
		leafEClass.getESuperTypes().add(this.getMultiFlow());
		constructorEClass.getESuperTypes().add(this.getChild());
		andEClass.getESuperTypes().add(this.getConstructor());
		loopEClass.getESuperTypes().add(this.getConstructor());
		allEClass.getESuperTypes().add(this.getConstructor());
		someEClass.getESuperTypes().add(this.getConstructor());
		orEClass.getESuperTypes().add(this.getConstructor());
		xorEClass.getESuperTypes().add(this.getConstructor());
		oneEClass.getESuperTypes().add(this.getConstructor());
		typedParameterExpressionEClass.getESuperTypes().add(theCoreextensionPackage.getTypedParameter());
		parEClass.getESuperTypes().add(this.getConstructor());

		// Initialize classes and features; add operations and parameters
		initEClass(flowDiagramEClass, FlowDiagram.class, "FlowDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowDiagram_Parameters(), this.getTypedParameterExpression(), null, "parameters", null, 0, -1, FlowDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowDiagram_Refine(), this.getChild(), null, "refine", null, 1, -1, FlowDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowDiagram_Sw(), ecorePackage.getEBoolean(), "sw", "true", 1, 1, FlowDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFlowDiagram_Copy(), ecorePackage.getEBoolean(), "copy", "false", 1, 1, FlowDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(flowDiagramEClass, theEcorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDiagnosticChain(), "diagnostic", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(theEcorePackage.getEMap());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(childEClass, Child.class, "Child", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChild_Ref(), ecorePackage.getEBoolean(), "ref", "false", 1, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(leafEClass, Leaf.class, "Leaf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLeaf_Name(), ecorePackage.getEString(), "name", null, 1, 1, Leaf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructorEClass, Constructor.class, "Constructor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnd_AndLink(), this.getLeaf(), null, "andLink", null, 2, -1, And.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopEClass, Loop.class, "Loop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoop_LoopLink(), this.getLeaf(), null, "loopLink", null, 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(loopEClass, theEcorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEDiagnosticChain(), "diagnostic", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theEcorePackage.getEMap());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(allEClass, All.class, "All", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAll_AllLink(), this.getLeaf(), null, "allLink", null, 1, 1, All.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAll_NewParameter(), this.getTypedParameterExpression(), null, "newParameter", null, 1, 1, All.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(someEClass, Some.class, "Some", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSome_SomeLink(), this.getLeaf(), null, "someLink", null, 1, 1, Some.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSome_NewParameter(), this.getTypedParameterExpression(), null, "newParameter", null, 1, 1, Some.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOr_OrLink(), this.getLeaf(), null, "orLink", null, 2, -1, Or.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xorEClass, Xor.class, "Xor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXor_XorLink(), this.getLeaf(), null, "xorLink", null, 2, -1, Xor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oneEClass, One.class, "One", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOne_OneLink(), this.getLeaf(), null, "oneLink", null, 1, 1, One.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOne_NewParameter(), this.getTypedParameterExpression(), null, "newParameter", null, 1, 1, One.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiFlowEClass, MultiFlow.class, "MultiFlow", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiFlow_Decompose(), this.getFlowDiagram(), null, "decompose", null, 0, -1, MultiFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedParameterExpressionEClass, TypedParameterExpression.class, "TypedParameterExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypedParameterExpression_InputExpression(), theEcorePackage.getEString(), "InputExpression", "", 1, 1, TypedParameterExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parEClass, Par.class, "Par", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPar_ParLink(), this.getLeaf(), null, "parLink", null, 1, 1, Par.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPar_NewParameter(), this.getTypedParameterExpression(), null, "newParameter", null, 1, 1, Par.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.eventb.emf.core.extendedMetaClasses
		createOrgAnnotations();
		// gmf.diagram
		createGmfAnnotations();
		// gmf.link
		createGmf_1Annotations();
		// gmf.node
		createGmf_2Annotations();
		// gmf.label
		createGmf_3Annotations();
	}

	/**
	 * Initializes the annotations for <b>org.eventb.emf.core.extendedMetaClasses</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.eventb.emf.core.extendedMetaClasses";		
		addAnnotation
		  (flowDiagramEClass, 
		   source, 
		   new String[] {
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//machine/Machine")
		   });																								
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf.diagram";			
		addAnnotation
		  (flowDiagramEClass, 
		   source, 
		   new String[] {
		   });																							
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.link";				
		addAnnotation
		  (getFlowDiagram_Refine(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });				
		addAnnotation
		  (getAnd_AndLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });				
		addAnnotation
		  (getLoop_LoopLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });			
		addAnnotation
		  (getAll_AllLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });		
		addAnnotation
		  (getAll_NewParameter(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });			
		addAnnotation
		  (getSome_SomeLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });		
		addAnnotation
		  (getSome_NewParameter(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });			
		addAnnotation
		  (getOr_OrLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });			
		addAnnotation
		  (getXor_XorLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });			
		addAnnotation
		  (getOne_OneLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });		
		addAnnotation
		  (getOne_NewParameter(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });		
		addAnnotation
		  (getMultiFlow_Decompose(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });			
		addAnnotation
		  (getPar_ParLink(), 
		   source, 
		   new String[] {
			 "label", "",
			 "style", "dash"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.node";					
		addAnnotation
		  (leafEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "color", "0,189,15"
		   });		
		addAnnotation
		  (andEClass, 
		   source, 
		   new String[] {
			 "label.text", "AND",
			 "label.placement", "none"
		   });			
		addAnnotation
		  (loopEClass, 
		   source, 
		   new String[] {
			 "figure", "ellipse",
			 "label.placement", "none"
		   });				
		addAnnotation
		  (allEClass, 
		   source, 
		   new String[] {
			 "label.text", "ALL",
			 "label.placement", "none"
		   });				
		addAnnotation
		  (someEClass, 
		   source, 
		   new String[] {
			 "label.text", "SOME",
			 "label.placement", "none"
		   });				
		addAnnotation
		  (orEClass, 
		   source, 
		   new String[] {
			 "label.placement", "none",
			 "label.text", "OR"
		   });			
		addAnnotation
		  (xorEClass, 
		   source, 
		   new String[] {
			 "label.placement", "none"
		   });			
		addAnnotation
		  (oneEClass, 
		   source, 
		   new String[] {
			 "label.placement", "none"
		   });					
		addAnnotation
		  (parEClass, 
		   source, 
		   new String[] {
			 "label.placement", "none"
		   });	
	}

	/**
	 * Initializes the annotations for <b>gmf.label</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.label";									
		addAnnotation
		  (loopEClass, 
		   source, 
		   new String[] {
			 "label.text", "*"
		   });																	
	}

} //AtomicitydecompositionPackageImpl
