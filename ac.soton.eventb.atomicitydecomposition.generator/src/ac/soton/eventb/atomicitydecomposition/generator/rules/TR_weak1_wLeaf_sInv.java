package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_weak1_wLeaf_sInv extends AbstractRule  implements IRule {
	

	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		System.out.println(sourceLeaf.getName() + " -> " + Utils.weakAncestor(sourceLeaf));
		return sourceLeaf.getDecompose().isEmpty() &&
				Utils.weakAncestor(sourceLeaf) != null &&
				Utils.predecessor(Utils.weakAncestor(sourceLeaf), Utils.getParentFlow(Utils.weakAncestor(sourceLeaf)).getParameters(), false) != null;
				
				
	}
	
	
	/**
	 * TR_weak1, Transform a proper weak leaf to the seq invariant 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Leaf sourceLeaf = (Leaf) sourceElement;
		
		String name = Strings.INV_ + sourceLeaf.getName() + Strings._INSEQ;
		String predicate = "";
		
		Child w = Utils.weakAncestor(sourceLeaf);
		List<Object> pred = Utils.predecessor(w, Utils.getParentFlow(w).getParameters(), false);
		
		predicate = Utils.build_seq_inv_string(Utils.build_seq_inv((Child)pred.get(0), (List<TypedParameterExpression>)pred.get(1), sourceLeaf, Utils.getParentFlow(sourceLeaf).getParameters() ));
		
		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 2));
		
		
		return ret;
	}	
	
	
	
}
