/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage
 * @generated
 */
public interface AtomicitydecompositionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AtomicitydecompositionFactory eINSTANCE = ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Flow Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Diagram</em>'.
	 * @generated
	 */
	FlowDiagram createFlowDiagram();

	/**
	 * Returns a new object of class '<em>Leaf</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Leaf</em>'.
	 * @generated
	 */
	Leaf createLeaf();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop</em>'.
	 * @generated
	 */
	Loop createLoop();

	/**
	 * Returns a new object of class '<em>All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All</em>'.
	 * @generated
	 */
	All createAll();

	/**
	 * Returns a new object of class '<em>Some</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Some</em>'.
	 * @generated
	 */
	Some createSome();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Xor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xor</em>'.
	 * @generated
	 */
	Xor createXor();

	/**
	 * Returns a new object of class '<em>One</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>One</em>'.
	 * @generated
	 */
	One createOne();

	/**
	 * Returns a new object of class '<em>Typed Parameter Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Parameter Expression</em>'.
	 * @generated
	 */
	TypedParameterExpression createTypedParameterExpression();

	/**
	 * Returns a new object of class '<em>Par</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Par</em>'.
	 * @generated
	 */
	Par createPar();

	/**
	 * Returns a new object of class '<em>Interrupt</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interrupt</em>'.
	 * @generated
	 */
	Interrupt createInterrupt();

	/**
	 * Returns a new object of class '<em>Retry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Retry</em>'.
	 * @generated
	 */
	Retry createRetry();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AtomicitydecompositionPackage getAtomicitydecompositionPackage();

} //AtomicitydecompositionFactory
