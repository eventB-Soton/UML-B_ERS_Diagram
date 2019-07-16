package ac.soton.eventb.atomicitydecomposition.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionElementTypes;
import ac.soton.eventb.atomicitydecomposition.diagram.providers.AtomicitydecompositionModelingAssistantProvider;

/**
 * @generated
 */
public class AtomicitydecompositionModelingAssistantProviderOfFlowDiagramEditPart
		extends AtomicitydecompositionModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(13);
		types.add(AtomicitydecompositionElementTypes.Leaf_2001);
		types.add(AtomicitydecompositionElementTypes.And_2002);
		types.add(AtomicitydecompositionElementTypes.Loop_2003);
		types.add(AtomicitydecompositionElementTypes.All_2004);
		types.add(AtomicitydecompositionElementTypes.Some_2005);
		types.add(AtomicitydecompositionElementTypes.Or_2006);
		types.add(AtomicitydecompositionElementTypes.Xor_2007);
		types.add(AtomicitydecompositionElementTypes.One_2008);
		types.add(AtomicitydecompositionElementTypes.Par_2009);
		types.add(AtomicitydecompositionElementTypes.Leaf_2010);
		types.add(AtomicitydecompositionElementTypes.FlowDiagram_2011);
		types.add(AtomicitydecompositionElementTypes.Interrupt_2012);
		types.add(AtomicitydecompositionElementTypes.Retry_2013);
		return types;
	}

}
