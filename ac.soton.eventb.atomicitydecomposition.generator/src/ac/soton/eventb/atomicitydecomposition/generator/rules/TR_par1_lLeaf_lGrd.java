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
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_par1_lLeaf_lGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				!Utils.getAncestorsAncestorsOfClass(sourceLeaf, Par.class).isEmpty(); 
				
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
	 * Dana: TR_par1, Transform a proper par-rep leaf to a guard in the equivalent event (ensures that next child has not executed yet)
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		int index = 0;
		for(EventBElement ee : Utils.getAncestorsAncestorsOfClass(sourceLeaf, Par.class)){
			Par p = (Par)ee;
			String name = Strings.GRD + index + Strings._PAR;
			List<TypedParameterExpression> pars = ((FlowDiagram)p.eContainer()).getParameters();
			
			List<Object> suc = Utils.successor(p, pars.size());
			
			String predicate = "";
			//SI case
			if(pars.isEmpty())
				predicate = Utils.conjunction_of_leaves((Child) suc.get(0), 0);
			//MI case
			else
				predicate = Utils.getParMaplet(pars) + Strings.B_NOTIN + Utils.union_of_leaves((Child) suc.get(0), 0);
			
			
			ret.add(Make.descriptor(equivalent, guards, Make.guard(name, predicate), 5));
		}
		
		return ret;
	}	
}
