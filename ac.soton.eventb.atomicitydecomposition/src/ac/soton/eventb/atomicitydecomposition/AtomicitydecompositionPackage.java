/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ac.soton.eventb.atomicitydecomposition;

import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eventb.emf.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ac.soton.eventb.atomicitydecomposition.AtomicitydecompositionFactory
 * @model kind="package"
 * @generated
 */
public interface AtomicitydecompositionPackage extends EPackage {
	/**
	 * Statemachines extension ID, assigned to statemachines extensions to Event-B,
	 * as well as used by transformation to Event-B.
	 */
	String FLOWDIAGRAMS_EXTENSION_ID = "ac.soton.eventb.atomicitydecomposition";
	
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "atomicitydecomposition";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://soton.ac.uk/models/eventb/atomicitydecomposition";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "atomicitydecomposition";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AtomicitydecompositionPackage eINSTANCE = ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl.init();

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl <em>Flow Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getFlowDiagram()
	 * @generated
	 */
	int FLOW_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__ANNOTATIONS = CorePackage.ABSTRACT_EXTENSION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__EXTENSIONS = CorePackage.ABSTRACT_EXTENSION__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__ATTRIBUTES = CorePackage.ABSTRACT_EXTENSION__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__REFERENCE = CorePackage.ABSTRACT_EXTENSION__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__GENERATED = CorePackage.ABSTRACT_EXTENSION__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__LOCAL_GENERATED = CorePackage.ABSTRACT_EXTENSION__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__INTERNAL_ID = CorePackage.ABSTRACT_EXTENSION__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Extension Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__EXTENSION_ID = CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__NAME = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__PARAMETERS = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refine</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__REFINE = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sw</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__SW = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM__COPY = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Flow Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_DIAGRAM_FEATURE_COUNT = CorePackage.ABSTRACT_EXTENSION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.ChildImpl <em>Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.ChildImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getChild()
	 * @generated
	 */
	int CHILD = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__ANNOTATIONS = CorePackage.EVENT_BELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__EXTENSIONS = CorePackage.EVENT_BELEMENT__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__ATTRIBUTES = CorePackage.EVENT_BELEMENT__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__REFERENCE = CorePackage.EVENT_BELEMENT__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__GENERATED = CorePackage.EVENT_BELEMENT__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__LOCAL_GENERATED = CorePackage.EVENT_BELEMENT__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__INTERNAL_ID = CorePackage.EVENT_BELEMENT__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD__REF = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_FEATURE_COUNT = CorePackage.EVENT_BELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.LeafImpl <em>Leaf</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.LeafImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getLeaf()
	 * @generated
	 */
	int LEAF = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__ANNOTATIONS = CHILD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__EXTENSIONS = CHILD__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__ATTRIBUTES = CHILD__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__REFERENCE = CHILD__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__GENERATED = CHILD__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__LOCAL_GENERATED = CHILD__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__INTERNAL_ID = CHILD__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__REF = CHILD__REF;

	/**
	 * The feature id for the '<em><b>Decompose</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__DECOMPOSE = CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF__NAME = CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Leaf</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_FEATURE_COUNT = CHILD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.ConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.ConstructorImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getConstructor()
	 * @generated
	 */
	int CONSTRUCTOR = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__ANNOTATIONS = CHILD__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__EXTENSIONS = CHILD__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__ATTRIBUTES = CHILD__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__REFERENCE = CHILD__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__GENERATED = CHILD__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__LOCAL_GENERATED = CHILD__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__INTERNAL_ID = CHILD__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__REF = CHILD__REF;

	/**
	 * The number of structural features of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_FEATURE_COUNT = CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AndImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>And Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__AND_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.LoopImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>Loop Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__LOOP_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.AllImpl <em>All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AllImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getAll()
	 * @generated
	 */
	int ALL = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>All Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__ALL_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__NEW_PARAMETER = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.SomeImpl <em>Some</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.SomeImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getSome()
	 * @generated
	 */
	int SOME = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>Some Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__SOME_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME__NEW_PARAMETER = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Some</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOME_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.OrImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getOr()
	 * @generated
	 */
	int OR = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>Or Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__OR_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.XorImpl <em>Xor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.XorImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getXor()
	 * @generated
	 */
	int XOR = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>Xor Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__XOR_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.OneImpl <em>One</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.OneImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getOne()
	 * @generated
	 */
	int ONE = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>One Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__ONE_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE__NEW_PARAMETER = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>One</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.MultiFlowImpl <em>Multi Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.MultiFlowImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getMultiFlow()
	 * @generated
	 */
	int MULTI_FLOW = 11;

	/**
	 * The feature id for the '<em><b>Decompose</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_FLOW__DECOMPOSE = 0;

	/**
	 * The number of structural features of the '<em>Multi Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_FLOW_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.TypedParameterExpressionImpl <em>Typed Parameter Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.TypedParameterExpressionImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getTypedParameterExpression()
	 * @generated
	 */
	int TYPED_PARAMETER_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__ANNOTATIONS = CoreextensionPackage.TYPED_PARAMETER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__EXTENSIONS = CoreextensionPackage.TYPED_PARAMETER__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__ATTRIBUTES = CoreextensionPackage.TYPED_PARAMETER__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__REFERENCE = CoreextensionPackage.TYPED_PARAMETER__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__GENERATED = CoreextensionPackage.TYPED_PARAMETER__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__LOCAL_GENERATED = CoreextensionPackage.TYPED_PARAMETER__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__INTERNAL_ID = CoreextensionPackage.TYPED_PARAMETER__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__COMMENT = CoreextensionPackage.TYPED_PARAMETER__COMMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__NAME = CoreextensionPackage.TYPED_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__TYPE = CoreextensionPackage.TYPED_PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Input Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION = CoreextensionPackage.TYPED_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Parameter Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PARAMETER_EXPRESSION_FEATURE_COUNT = CoreextensionPackage.TYPED_PARAMETER_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link ac.soton.eventb.atomicitydecomposition.impl.ParImpl <em>Par</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ac.soton.eventb.atomicitydecomposition.impl.ParImpl
	 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getPar()
	 * @generated
	 */
	int PAR = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__ANNOTATIONS = CONSTRUCTOR__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__EXTENSIONS = CONSTRUCTOR__EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__ATTRIBUTES = CONSTRUCTOR__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__REFERENCE = CONSTRUCTOR__REFERENCE;

	/**
	 * The feature id for the '<em><b>Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__GENERATED = CONSTRUCTOR__GENERATED;

	/**
	 * The feature id for the '<em><b>Local Generated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__LOCAL_GENERATED = CONSTRUCTOR__LOCAL_GENERATED;

	/**
	 * The feature id for the '<em><b>Internal Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__INTERNAL_ID = CONSTRUCTOR__INTERNAL_ID;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__REF = CONSTRUCTOR__REF;

	/**
	 * The feature id for the '<em><b>Par Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__PAR_LINK = CONSTRUCTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR__NEW_PARAMETER = CONSTRUCTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Par</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAR_FEATURE_COUNT = CONSTRUCTOR_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram <em>Flow Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Diagram</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.FlowDiagram
	 * @generated
	 */
	EClass getFlowDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.FlowDiagram#getParameters()
	 * @see #getFlowDiagram()
	 * @generated
	 */
	EReference getFlowDiagram_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#getRefine <em>Refine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refine</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.FlowDiagram#getRefine()
	 * @see #getFlowDiagram()
	 * @generated
	 */
	EReference getFlowDiagram_Refine();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#isSw <em>Sw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sw</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.FlowDiagram#isSw()
	 * @see #getFlowDiagram()
	 * @generated
	 */
	EAttribute getFlowDiagram_Sw();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.atomicitydecomposition.FlowDiagram#isCopy <em>Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copy</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.FlowDiagram#isCopy()
	 * @see #getFlowDiagram()
	 * @generated
	 */
	EAttribute getFlowDiagram_Copy();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Child <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Child
	 * @generated
	 */
	EClass getChild();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.atomicitydecomposition.Child#isRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ref</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Child#isRef()
	 * @see #getChild()
	 * @generated
	 */
	EAttribute getChild_Ref();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Leaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Leaf
	 * @generated
	 */
	EClass getLeaf();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.atomicitydecomposition.Leaf#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Leaf#getName()
	 * @see #getLeaf()
	 * @generated
	 */
	EAttribute getLeaf_Name();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Constructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Constructor
	 * @generated
	 */
	EClass getConstructor();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.atomicitydecomposition.And#getAndLink <em>And Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>And Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.And#getAndLink()
	 * @see #getAnd()
	 * @generated
	 */
	EReference getAnd_AndLink();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.Loop#getLoopLink <em>Loop Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Loop#getLoopLink()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_LoopLink();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.All <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.All
	 * @generated
	 */
	EClass getAll();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.All#getAllLink <em>All Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>All Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.All#getAllLink()
	 * @see #getAll()
	 * @generated
	 */
	EReference getAll_AllLink();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.All#getNewParameter <em>New Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Parameter</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.All#getNewParameter()
	 * @see #getAll()
	 * @generated
	 */
	EReference getAll_NewParameter();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Some <em>Some</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Some</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Some
	 * @generated
	 */
	EClass getSome();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.Some#getSomeLink <em>Some Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Some Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Some#getSomeLink()
	 * @see #getSome()
	 * @generated
	 */
	EReference getSome_SomeLink();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.Some#getNewParameter <em>New Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Parameter</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Some#getNewParameter()
	 * @see #getSome()
	 * @generated
	 */
	EReference getSome_NewParameter();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.atomicitydecomposition.Or#getOrLink <em>Or Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Or Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Or#getOrLink()
	 * @see #getOr()
	 * @generated
	 */
	EReference getOr_OrLink();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Xor
	 * @generated
	 */
	EClass getXor();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.atomicitydecomposition.Xor#getXorLink <em>Xor Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Xor Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Xor#getXorLink()
	 * @see #getXor()
	 * @generated
	 */
	EReference getXor_XorLink();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.One <em>One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>One</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.One
	 * @generated
	 */
	EClass getOne();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.One#getOneLink <em>One Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.One#getOneLink()
	 * @see #getOne()
	 * @generated
	 */
	EReference getOne_OneLink();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.One#getNewParameter <em>New Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Parameter</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.One#getNewParameter()
	 * @see #getOne()
	 * @generated
	 */
	EReference getOne_NewParameter();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.MultiFlow <em>Multi Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Flow</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.MultiFlow
	 * @generated
	 */
	EClass getMultiFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link ac.soton.eventb.atomicitydecomposition.MultiFlow#getDecompose <em>Decompose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decompose</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.MultiFlow#getDecompose()
	 * @see #getMultiFlow()
	 * @generated
	 */
	EReference getMultiFlow_Decompose();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression <em>Typed Parameter Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Parameter Expression</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.TypedParameterExpression
	 * @generated
	 */
	EClass getTypedParameterExpression();

	/**
	 * Returns the meta object for the attribute '{@link ac.soton.eventb.atomicitydecomposition.TypedParameterExpression#getInputExpression <em>Input Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Expression</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.TypedParameterExpression#getInputExpression()
	 * @see #getTypedParameterExpression()
	 * @generated
	 */
	EAttribute getTypedParameterExpression_InputExpression();

	/**
	 * Returns the meta object for class '{@link ac.soton.eventb.atomicitydecomposition.Par <em>Par</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Par</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Par
	 * @generated
	 */
	EClass getPar();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.Par#getParLink <em>Par Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Par Link</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Par#getParLink()
	 * @see #getPar()
	 * @generated
	 */
	EReference getPar_ParLink();

	/**
	 * Returns the meta object for the containment reference '{@link ac.soton.eventb.atomicitydecomposition.Par#getNewParameter <em>New Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Parameter</em>'.
	 * @see ac.soton.eventb.atomicitydecomposition.Par#getNewParameter()
	 * @see #getPar()
	 * @generated
	 */
	EReference getPar_NewParameter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AtomicitydecompositionFactory getAtomicitydecompositionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl <em>Flow Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.FlowDiagramImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getFlowDiagram()
		 * @generated
		 */
		EClass FLOW_DIAGRAM = eINSTANCE.getFlowDiagram();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_DIAGRAM__PARAMETERS = eINSTANCE.getFlowDiagram_Parameters();

		/**
		 * The meta object literal for the '<em><b>Refine</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_DIAGRAM__REFINE = eINSTANCE.getFlowDiagram_Refine();

		/**
		 * The meta object literal for the '<em><b>Sw</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_DIAGRAM__SW = eINSTANCE.getFlowDiagram_Sw();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_DIAGRAM__COPY = eINSTANCE.getFlowDiagram_Copy();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.ChildImpl <em>Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.ChildImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getChild()
		 * @generated
		 */
		EClass CHILD = eINSTANCE.getChild();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD__REF = eINSTANCE.getChild_Ref();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.LeafImpl <em>Leaf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.LeafImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getLeaf()
		 * @generated
		 */
		EClass LEAF = eINSTANCE.getLeaf();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEAF__NAME = eINSTANCE.getLeaf_Name();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.ConstructorImpl <em>Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.ConstructorImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getConstructor()
		 * @generated
		 */
		EClass CONSTRUCTOR = eINSTANCE.getConstructor();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AndImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '<em><b>And Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND__AND_LINK = eINSTANCE.getAnd_AndLink();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.LoopImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Loop Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__LOOP_LINK = eINSTANCE.getLoop_LoopLink();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.AllImpl <em>All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AllImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getAll()
		 * @generated
		 */
		EClass ALL = eINSTANCE.getAll();

		/**
		 * The meta object literal for the '<em><b>All Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL__ALL_LINK = eINSTANCE.getAll_AllLink();

		/**
		 * The meta object literal for the '<em><b>New Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALL__NEW_PARAMETER = eINSTANCE.getAll_NewParameter();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.SomeImpl <em>Some</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.SomeImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getSome()
		 * @generated
		 */
		EClass SOME = eINSTANCE.getSome();

		/**
		 * The meta object literal for the '<em><b>Some Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOME__SOME_LINK = eINSTANCE.getSome_SomeLink();

		/**
		 * The meta object literal for the '<em><b>New Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOME__NEW_PARAMETER = eINSTANCE.getSome_NewParameter();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.OrImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '<em><b>Or Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR__OR_LINK = eINSTANCE.getOr_OrLink();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.XorImpl <em>Xor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.XorImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getXor()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXor();

		/**
		 * The meta object literal for the '<em><b>Xor Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XOR__XOR_LINK = eINSTANCE.getXor_XorLink();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.OneImpl <em>One</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.OneImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getOne()
		 * @generated
		 */
		EClass ONE = eINSTANCE.getOne();

		/**
		 * The meta object literal for the '<em><b>One Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONE__ONE_LINK = eINSTANCE.getOne_OneLink();

		/**
		 * The meta object literal for the '<em><b>New Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONE__NEW_PARAMETER = eINSTANCE.getOne_NewParameter();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.MultiFlowImpl <em>Multi Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.MultiFlowImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getMultiFlow()
		 * @generated
		 */
		EClass MULTI_FLOW = eINSTANCE.getMultiFlow();

		/**
		 * The meta object literal for the '<em><b>Decompose</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_FLOW__DECOMPOSE = eINSTANCE.getMultiFlow_Decompose();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.TypedParameterExpressionImpl <em>Typed Parameter Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.TypedParameterExpressionImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getTypedParameterExpression()
		 * @generated
		 */
		EClass TYPED_PARAMETER_EXPRESSION = eINSTANCE.getTypedParameterExpression();

		/**
		 * The meta object literal for the '<em><b>Input Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_PARAMETER_EXPRESSION__INPUT_EXPRESSION = eINSTANCE.getTypedParameterExpression_InputExpression();

		/**
		 * The meta object literal for the '{@link ac.soton.eventb.atomicitydecomposition.impl.ParImpl <em>Par</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ac.soton.eventb.atomicitydecomposition.impl.ParImpl
		 * @see ac.soton.eventb.atomicitydecomposition.impl.AtomicitydecompositionPackageImpl#getPar()
		 * @generated
		 */
		EClass PAR = eINSTANCE.getPar();

		/**
		 * The meta object literal for the '<em><b>Par Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAR__PAR_LINK = eINSTANCE.getPar_ParLink();

		/**
		 * The meta object literal for the '<em><b>New Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAR__NEW_PARAMETER = eINSTANCE.getPar_NewParameter();

	}

} //AtomicitydecompositionPackage
