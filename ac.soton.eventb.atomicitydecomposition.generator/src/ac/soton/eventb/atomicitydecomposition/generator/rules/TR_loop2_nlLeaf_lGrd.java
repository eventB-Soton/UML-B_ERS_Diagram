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

public class TR_loop2_nlLeaf_lGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		FlowDiagram parentFlow = Utils.getParentFlow(sourceLeaf);
		Child ch = Utils.predecessorLoop(sourceLeaf, parentFlow.isSw());
		return sourceLeaf.getDecompose().isEmpty() &&
				(ch instanceof Loop) &&
				!((Loop)ch).getLoopLink().getDecompose().isEmpty();
				
	}
	
	/**
	 * The event which will receive the guard has already been generated
	 */
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null;
	}
	
	/**
	 * TR_loop2, Transform a proper next leaf after a loop to a guard in the quivalent event (ensures that next child does not execute in the middle of loop execution)
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		int index = Utils.getPrevLoopGrdIndex(equivalent, generatedElements);
		String name = Strings.GRD + (index+1) + Strings._LOOP;
		FlowDiagram parentFlow = Utils.getParentFlow(sourceLeaf);
		Loop lo = (Loop) Utils.predecessorLoop(sourceLeaf, parentFlow.isSw());
		List<TypedParameterExpression> pars = ((FlowDiagram)lo.eContainer()).getParameters();
		
		String predicate = "";
		if(pars.isEmpty())
			predicate = Utils.conjunction_of_leaves(lo.getLoopLink(), 0);
		else
			predicate = Utils.getParMaplet(pars) + Strings.B_NOTIN + Utils.union_of_leaves(lo.getLoopLink(), 0);
		
		ret.add(Make.descriptor(equivalent, guards, Make.guard(name, predicate), 5));
		return ret;
	}	
}
