/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition.impl;

import ac.soton.eventb.atomicitydecomposition.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AtomicitydecompositionFactoryImpl extends EFactoryImpl implements AtomicitydecompositionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AtomicitydecompositionFactory init() {
		try {
			AtomicitydecompositionFactory theAtomicitydecompositionFactory = (AtomicitydecompositionFactory)EPackage.Registry.INSTANCE.getEFactory(AtomicitydecompositionPackage.eNS_URI);
			if (theAtomicitydecompositionFactory != null) {
				return theAtomicitydecompositionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AtomicitydecompositionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicitydecompositionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AtomicitydecompositionPackage.FLOW_DIAGRAM: return createFlowDiagram();
			case AtomicitydecompositionPackage.LEAF: return createLeaf();
			case AtomicitydecompositionPackage.AND: return createAnd();
			case AtomicitydecompositionPackage.LOOP: return createLoop();
			case AtomicitydecompositionPackage.ALL: return createAll();
			case AtomicitydecompositionPackage.SOME: return createSome();
			case AtomicitydecompositionPackage.OR: return createOr();
			case AtomicitydecompositionPackage.XOR: return createXor();
			case AtomicitydecompositionPackage.ONE: return createOne();
			case AtomicitydecompositionPackage.TYPED_PARAMETER_EXPRESSION: return createTypedParameterExpression();
			case AtomicitydecompositionPackage.PAR: return createPar();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowDiagram createFlowDiagram() {
		FlowDiagramImpl flowDiagram = new FlowDiagramImpl();
		return flowDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leaf createLeaf() {
		LeafImpl leaf = new LeafImpl();
		return leaf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Loop createLoop() {
		LoopImpl loop = new LoopImpl();
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public All createAll() {
		AllImpl all = new AllImpl();
		return all;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Some createSome() {
		SomeImpl some = new SomeImpl();
		return some;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xor createXor() {
		XorImpl xor = new XorImpl();
		return xor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public One createOne() {
		OneImpl one = new OneImpl();
		return one;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedParameterExpression createTypedParameterExpression() {
		TypedParameterExpressionImpl typedParameterExpression = new TypedParameterExpressionImpl();
		return typedParameterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Par createPar() {
		ParImpl par = new ParImpl();
		return par;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicitydecompositionPackage getAtomicitydecompositionPackage() {
		return (AtomicitydecompositionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AtomicitydecompositionPackage getPackage() {
		return AtomicitydecompositionPackage.eINSTANCE;
	}

} //AtomicitydecompositionFactoryImpl
