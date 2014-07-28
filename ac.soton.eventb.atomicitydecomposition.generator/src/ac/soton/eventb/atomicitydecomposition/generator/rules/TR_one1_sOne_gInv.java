package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_one1_sOne_gInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		One sourceOne = (One) sourceElement;
		return sourceOne.isRef() && //one with a solif line
				sourceOne.getOneLink().getDecompose().isEmpty() && //One child as leaf
				!(sourceOne.eContainer().eContainer().eContainer() instanceof Loop); 
	}
	
	/**
	 *	TR_one1, Transform a solid one-replicator to a gluing invariant
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		One sourceOne = (One) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		String name = Strings.INV + (Utils.getPrevOneGluInvIndex(generatedElements) + 1) + Strings.ONE + Strings._GLU;
		String predicate = generatePredicate(sourceOne);
		
		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 2));
		
		return ret;
	} 

	private String generatePredicate(One o) {
		FlowDiagram parentFlow = Utils.getParentFlow(o);
		//SI case
		if(parentFlow.getParameters().isEmpty()){
			if(o.eContainer().eContainer() instanceof Machine)
				return  o.getOneLink().getName() + Strings.B_NEQ  + Strings.B_EMPTYSET + Strings.B_EQUIV + ((Machine)o.eContainer().eContainer()).getName() +
						Strings.B_EQ + Strings.B_TRUE;
			else if (o.eContainer().eContainer() instanceof Leaf)
				return  o.getOneLink().getName() + Strings.B_NEQ  + Strings.B_EMPTYSET + Strings.B_EQUIV + ((Leaf)o.eContainer().eContainer()).getName() +
						Strings.B_EQ + Strings.B_TRUE;
		}
				
		//MI case
		else{
			if(o.eContainer().eContainer() instanceof Machine)
				return Strings.B_DOM + Utils.parenthesize(o.getOneLink().getName()) + Strings.B_EQ + ((Machine)o.eContainer().eContainer()).getName();
			else if (o.eContainer().eContainer() instanceof Leaf){
				return Strings.B_DOM + Utils.parenthesize(o.getOneLink().getName()) + Strings.B_EQ + ((Leaf)o.eContainer().eContainer()).getName();
			}
		}
		return "Parent of one should be either a leaf or a Machine";
	}	
}
