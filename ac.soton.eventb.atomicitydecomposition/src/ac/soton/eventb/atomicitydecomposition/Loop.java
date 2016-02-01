/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.Loop#getLoopLink <em>Loop Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getLoop()
 * @model annotation="gmf.node figure='ellipse' label.placement='none'"
 *        annotation="gmf.label label.text='*'"
 * @generated
 */
public interface Loop extends Constructor {
	/**
	 * Returns the value of the '<em><b>Loop Link</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.atomicitydecomposition.Leaf}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Link</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Link</em>' containment reference list.
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getLoop_LoopLink()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	EList<Leaf> getLoopLink();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validate(DiagnosticChain diagnostic, Map<?, ?> context);

} // Loop
