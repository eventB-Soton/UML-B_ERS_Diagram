package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf1_nlLeaf_var extends AbstractRule implements IRule {
	
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return (!(sourceLeaf.eContainer() instanceof Loop))  &&
				(sourceLeaf.getDecompose().isEmpty());
	}

	
	/**
	 * Transforms leaf to variable
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);	
		ret.add(Make.descriptor(container, variables, Make.variable(sourceLeaf.getName(), ""), 10));	
		return ret;
		
	}
	

}
