package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf3_rLeaf_tInv extends AbstractRule implements IRule {
	
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		
	//Dana: fixed to add type during refinement
	 
		return sourceLeaf.getDecompose().isEmpty() &&
				!Utils.repAncestorFirstChild(sourceLeaf).isEmpty();
	}

	
	/**
	 * TR_leaf3, Transform a replicator leaf to a typing invariant
	 * Dana: This is updated to cover the refinement of a replicator
	 * The only case that still needs to add additional type invariants manually 
	 * if the first child is par that is also the child of a replicator
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);	
		
		String name = Strings.INV_ + sourceLeaf.getName() + Strings._TYPE;
		
		String predicate = generatePredicate(sourceLeaf);
		
		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 1));	
	
		return ret;
		
		
	}


	private String generatePredicate(Leaf l) {
		String pred = "";
		FlowDiagram parentFlow = Utils.getParentFlow(l);
		List<TypedParameterExpression> pars = new ArrayList<TypedParameterExpression>();
		pars.addAll(parentFlow.getParameters());
		if(l.eContainer() instanceof All)
			pars.add(((All) l.eContainer()).getNewParameter());
		else if(l.eContainer() instanceof Some)
			pars.add(((Some) l.eContainer()).getNewParameter());
		else if(l.eContainer() instanceof One)
			pars.add(((One) l.eContainer()).getNewParameter());
		else if(l.eContainer() instanceof Par)
			pars.add(((Par) l.eContainer()).getNewParameter());
	
		// SI case
		if(pars.size() == 1)
			pred = l.getName() + Strings.B_SUBSETEQ + pars.get(0).getType();
		//MI case
		else if (pars.size() > 1)
			pred = l.getName() + Strings.B_SUBSETEQ + Utils.getParTypeCartesian(pars);
		else 
			pred = "Should not reach this case";
	


		return pred;
	}
	

}
