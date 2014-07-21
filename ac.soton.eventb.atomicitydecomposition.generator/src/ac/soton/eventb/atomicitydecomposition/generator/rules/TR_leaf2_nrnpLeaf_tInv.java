package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf2_nrnpLeaf_tInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		FlowDiagram parentFlow = Utils.getParentFlow(sourceLeaf);
		return sourceLeaf.getDecompose().isEmpty() &&
				!(sourceLeaf.eContainer() instanceof All) && //non All leaf
				!(sourceLeaf.eContainer() instanceof Some) && //non some leaf
				!(sourceLeaf.eContainer() instanceof One) && //non one leaf
				!(sourceLeaf.eContainer() instanceof Par) && //non par leaf
				!(sourceLeaf.eContainer() instanceof Loop) && //non loop leaf
				Utils.predecessor(sourceLeaf, parentFlow.getParameters(), parentFlow.isSw()) == null;
	}

	
	/**
	 * TR_leaf2, Transform a non-replicator leaf without a predecessor node to a typing invariant
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;
		String name = Strings.INV_ + sourceLeaf.getName() + Strings._TYPE; 
		String predicate = generateInvariant(sourceLeaf);
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 1));
		
		return ret;
		
	}
	
	private String generateInvariant(Leaf l){
		FlowDiagram parentFlow = Utils.getParentFlow(l);
		// SI case
		if(parentFlow.getParameters().isEmpty())
			return l.getName() + Strings.B_IN + Strings.B_BOOL;
		//MI case
		else
			return l.getName() + Strings.B_SUBSETEQ + Utils.getParTypeCartesian(parentFlow.getParameters());
			
	}
	
	
}
