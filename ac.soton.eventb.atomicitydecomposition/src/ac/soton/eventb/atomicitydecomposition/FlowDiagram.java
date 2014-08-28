/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import ac.soton.eventb.emf.diagrams.Diagram;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

import org.eclipse.emf.common.util.EList;

import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBNamed;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#getParameters <em>Parameters</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#getRefine <em>Refine</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#isSw <em>Sw</em>}</li>
 *   <li>{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#isCopy <em>Copy</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getFlowDiagram()
 * @model
 * @generated
 */
public interface FlowDiagram extends EventBNamedCommentedDataElaborationElement, Diagram, AbstractExtension {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getFlowDiagram_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedParameterExpression> getParameters();

	/**
	 * Returns the value of the '<em><b>Refine</b></em>' containment reference list.
	 * The list contents are of type {@link ac.soton.eventb.atomicitydecomposition.Child}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refine</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refine</em>' containment reference list.
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getFlowDiagram_Refine()
	 * @model containment="true" required="true"
	 *        annotation="gmf.link label='' style='dash'"
	 * @generated
	 */
	EList<Child> getRefine();

	/**
	 * Returns the value of the '<em><b>Sw</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sw</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sw</em>' attribute.
	 * @see #setSw(boolean)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getFlowDiagram_Sw()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isSw();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#isSw <em>Sw</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sw</em>' attribute.
	 * @see #isSw()
	 * @generated
	 */
	void setSw(boolean value);

	/**
	 * Returns the value of the '<em><b>Copy</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy</em>' attribute.
	 * @see #setCopy(boolean)
	 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionPackage#getFlowDiagram_Copy()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isCopy();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#isCopy <em>Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copy</em>' attribute.
	 * @see #isCopy()
	 * @generated
	 */
	void setCopy(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated NOT
	 */
	boolean validate(DiagnosticChain diagnostic, Map<Object, Object> context);

} // FlowDiagram
