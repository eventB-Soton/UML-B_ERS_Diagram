package ac.soton.eventb.atomicitydecomposition.generator.rules;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_loop4_loop_rInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Loop sourceLoop  = (Loop) sourceElement;
		return !Utils.getLoopRefinedChildren(sourceLoop).isEmpty();
				
	}
	

	
	/**
	 * Dana: TR_loop4: will generate 1* invariant(s) if one of the loop children is refined, 
	 * the invariant is related to TR_loop2 
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Loop sourceLoop = (Loop) sourceElement;
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		List <TypedParameterExpression> pars =  Utils.getParentFlow(sourceLoop).getParameters();
	    List <Child> loopLinks = Utils.getLoopRefinedChildren(sourceLoop);
		Child succ = (Child) Utils.successor(sourceLoop, pars.size()).get(0);
		int index = Utils.getPrevLoopInvIndex(sourceLoop, generatedElements);
		for(Child ch: loopLinks){
			String invStr = "";
			//SI
			if(pars.isEmpty())
				invStr = Utils.build_succ_SI_inv(succ, 0)+ Strings.B_IMPL + Utils.conjunction_of_leaves(ch, 0);
			
			//MI
			else
				invStr = Strings.B_FORALL + Utils.getParList(pars) + Strings.B_MIDDOT + Utils.getParMaplet(pars) + Strings.B_IN + Utils.union_of_leaves(succ, 0)
				+ Strings.B_IMPL + Utils.getParMaplet(pars) + Strings.B_NOTIN + Utils.union_of_leaves(ch, 0) ;
			
			String name = Strings.INV + index +Strings._LOOP + "_" +Utils.getRootFlowDiagramName(sourceLoop);
			ret.add(Make.descriptor(container, invariants, Make.invariant(name, invStr, ""), 3));
			index++;
		}
		
		return ret;
	}	
	

}
