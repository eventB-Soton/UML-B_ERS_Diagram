package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
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
		//-----------------------------------------------------------------------------------
		//Dana test
	  /*  if (Find.named(container.getEvents(), ((Leaf)sourceElement).getName())  != null)
	    	return true;
	    else
	    	return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null; */
		//-----------------------------------------------------------------------------------
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
		
		//-------------------------------------------------------------------------------------
		//Added by Dana 15/10/2015
		Child parentChild = Utils.getParentChild(sourceLeaf);
		List<TypedParameterExpression> par = new ArrayList<TypedParameterExpression>();
        par.addAll(parentFlow.getParameters());
		
		if(parentChild instanceof All){
			par.add( ((All)parentChild).getNewParameter() );
		}
		else if(parentChild instanceof Some){
			par.add( ((Some)parentChild).getNewParameter() );
		}
		else if(parentChild instanceof One){
			par.add( ((One)parentChild).getNewParameter() );
		}
		else if(parentChild instanceof Par){
			par.add( ((Par)parentChild).getNewParameter() );
		}
		//-------------------------------------------------------------------------------------
		
		//String name = Strings.GRD_SEQ;
		String name = Strings.GRD_SEQ.concat("_" + parentFlow.getName());// fixed by dana to allow more than 1 diagram
		
		@SuppressWarnings("unchecked")
		//Changed by Dana 
		//String predicate = Utils.build_seq_grd((Child)pred.get(0), (List<TypedParameterExpression>) pred.get(1), sourceLeaf, parentFlow.getParameters(), false);
		String predicate = Utils.build_seq_grd((Child)pred.get(0), (List<TypedParameterExpression>) pred.get(1), sourceLeaf, par, false);
		
		Guard grd = (Guard) Make.guard(name, predicate);
		
		Event eve = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		ret.add(Make.descriptor(eve, guards, grd, 1));
		
		return ret;
	}	
}
