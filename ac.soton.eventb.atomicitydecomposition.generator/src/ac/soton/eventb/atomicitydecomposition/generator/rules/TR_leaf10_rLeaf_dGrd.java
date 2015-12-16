package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf10_rLeaf_dGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() && (
				(sourceLeaf.eContainer() instanceof All) || //non All leaf
				(sourceLeaf.eContainer() instanceof Some) || //non some leaf
				(sourceLeaf.eContainer() instanceof One) || //non one leaf
				(sourceLeaf.eContainer() instanceof Par)); //non par leaf
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
	 *	TR_leaf10, Transform a replicator leaf to a disabling guard in the equivalent event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		
		String name = Strings.GRD_SELF;
		String predicate = generatePredicate(sourceLeaf);
		Guard grd = (Guard) Make.guard(name, predicate);
		
		Event eve = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		
		
		ret.add(Make.descriptor(eve, guards, grd, 1));
		
		return ret;
	}

	private String generatePredicate(Leaf leaf) {
		FlowDiagram parentFlow = Utils.getParentFlow(leaf);
		if(parentFlow.getParameters().isEmpty()){
			if(leaf.eContainer() instanceof All){
				return ((All)leaf.eContainer()).getNewParameter().getName() + Strings.B_NOTIN + leaf.getName();
			}
			else if (leaf.eContainer() instanceof Some){
				return ((Some)leaf.eContainer()).getNewParameter().getName() + Strings.B_NOTIN + leaf.getName();
			}
			else if(leaf.eContainer() instanceof One){
				return ((One)leaf.eContainer()).getNewParameter().getName() + Strings.B_NOTIN + leaf.getName();
			}
			else{ //if(leaf.eContainer() instanceof Par){
				return ((Par)leaf.eContainer()).getNewParameter().getName() + Strings.B_NOTIN + leaf.getName();
			}
		}
		else
			if(leaf.eContainer() instanceof All){
				return Utils.getParMaplet(Utils.getParentFlow(leaf).getParameters()) + Strings.B_MAPLET + ((All)leaf.eContainer()).getNewParameter().getName() + 
					       Strings.B_NOTIN + leaf.getName();
			}
			else if (leaf.eContainer() instanceof Some){
				return Utils.getParMaplet(Utils.getParentFlow(leaf).getParameters()) + Strings.B_MAPLET + ((Some)leaf.eContainer()).getNewParameter().getName() + 
					       Strings.B_NOTIN + leaf.getName();
			}
			else if(leaf.eContainer() instanceof One){
				return Utils.getParMaplet(Utils.getParentFlow(leaf).getParameters()) + Strings.B_MAPLET + ((One)leaf.eContainer()).getNewParameter().getName() + 
					       Strings.B_NOTIN + leaf.getName();
			}
			else{ //if(leaf.eContainer() instanceof Par){
				return Utils.getParMaplet(Utils.getParentFlow(leaf).getParameters()) + Strings.B_MAPLET + ((Par)leaf.eContainer()).getNewParameter().getName() + 
					       Strings.B_NOTIN + leaf.getName();
			}
		
	}	
}
