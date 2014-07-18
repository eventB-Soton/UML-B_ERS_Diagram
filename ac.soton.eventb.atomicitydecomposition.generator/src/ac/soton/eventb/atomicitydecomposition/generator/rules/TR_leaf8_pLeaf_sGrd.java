package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf8_pLeaf_sGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				//!(sourceLeaf.eContainer() instanceof Loop)  &&
				Utils.predecessor(sourceLeaf, Utils.getParentFlow(sourceLeaf).getParameters(), Utils.getParentFlow(sourceLeaf).isSw()) != null; // Predecessor 
				
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
	 * TR_leaf8, Transform a leaf with a predecessor node to a sequencing guard in the equivalent event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		FlowDiagram parentFlow = Utils.getParentFlow(sourceLeaf);
		
		List<Object> pred = Utils.predecessor(sourceLeaf, parentFlow.getParameters(), parentFlow.isSw());
		
		String name = Strings.GRD_SEQ;
		@SuppressWarnings("unchecked")
		String predicate = Utils.build_seq_grd((Child)pred.get(0), (List<TypedParameterExpression>) pred.get(1), sourceLeaf, parentFlow.getParameters(), false);
		
		
		Guard grd = (Guard) Make.guard(name, predicate);
		
		Event eve = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		ret.add(Make.descriptor(eve, guards, grd, 1));
		
		return ret;
	}	
}
