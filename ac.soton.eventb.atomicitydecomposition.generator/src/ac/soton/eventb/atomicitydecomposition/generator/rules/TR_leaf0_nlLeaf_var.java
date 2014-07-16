package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Child;
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

public class TR_leaf0_nlLeaf_var extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return (!(sourceLeaf.eContainer() instanceof Loop))  &&
				(sourceLeaf.getDecompose().isEmpty());
	}

	
	/**
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;
		System.out.println("I am here");
		String name = Strings.ACT_ + sourceLeaf.getName(); 
		String action = generateAction(sourceLeaf);
		
		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		System.out.println(Utils.getInitialisationEvent(container));
		ret.add(Make.descriptor(Utils.getInitialisationEvent(container), actions, Make.action(name, action), 10));
		
		return ret;
		
	}
	
	private String generateAction(Leaf l){
		Child parentChild = Utils.getParentChild(l);
		FlowDiagram parentFlow = Utils.getParentFlow(l);
		if(parentFlow.getParameters().isEmpty() && 
				!(parentChild instanceof All) &&
				!(parentChild instanceof Some) &&
				!(parentChild instanceof One) &&
				!(parentChild instanceof Par))
			return l.getName() + Strings.B_BEQ + Strings.B_FALSE;
		else
			return l.getName() + Strings.B_BEQ + Strings.B_EMPTYSET;
			
	}
	
	
}
