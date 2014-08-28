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
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_par2_nlLeaf_lGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		FlowDiagram parentFlow = Utils.getParentFlow(sourceLeaf);
		return sourceLeaf.getDecompose().isEmpty() &&
				(Utils.predecessorLoop(sourceLeaf, parentFlow.isSw()) instanceof Par) &&
				!((Par)Utils.predecessorLoop(sourceLeaf, parentFlow.isSw())).getParLink().getDecompose().isEmpty();
				
	}
	
	/**
	 * Dana: TR_par2, Transform a proper next leaf after a par-rep to a guard in the equivalent event (ensures that next child does not execute in the middle of par-rep execution if refined)
	 * predecessorLoop gets any predecessor whether it's a loop or par-rep
	 */
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null;
	}
	
	/**
	 * Dana: TR_par2, Transform a proper next leaf after a par-rep to a guard in the equivalent event (ensures that next child does not execute in the middle of par-rep execution if refined)
	 * predecessorLoop gets any predecessor whether it's a loop or par-rep
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		FlowDiagram parentFlow = Utils.getParentFlow(sourceLeaf);
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		Par par_rep = (Par) Utils.predecessorLoop(sourceLeaf, parentFlow.isSw());
		Child par_child = par_rep.getParLink();
		//List<TypedParameterExpression> pars = ((FlowDiagram)par_rep.eContainer()).getParameters();
		
		String predicate = "";
		predicate = Utils.build_par_ref_grd(par_child);
		
		if(predicate != ""){
			String name = Utils.getPrevParGrdName(sourceLeaf, equivalent, generatedElements);
			ret.add(Make.descriptor(equivalent, guards, Make.guard(name, predicate), 10));
		}
		
		
		
		return ret;
	}	
}
