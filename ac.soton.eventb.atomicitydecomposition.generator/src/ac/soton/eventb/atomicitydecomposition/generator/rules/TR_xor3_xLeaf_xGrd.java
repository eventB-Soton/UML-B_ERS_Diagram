package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_xor3_xLeaf_xGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		if(sourceLeaf.getName().equals("g"))
			System.out.println("g ->" + (sourceLeaf.getDecompose().isEmpty() &&
				!Utils.xorAncestors(sourceLeaf).isEmpty()));
		return sourceLeaf.getDecompose().isEmpty() &&
				!Utils.xorAncestors(sourceLeaf).isEmpty();
						
				
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
	 * TR_xor3, Transform a proper xor leaf to a exclusive property guard in the quivalent event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		int index = 0;
		
		for(Xor x : Utils.xorAncestors(sourceLeaf)){
			index++;
			String name = Strings.GRD + index + Strings._XOR;
			
			String predicate = "";
			//SI case
			if(((FlowDiagram)x.eContainer()).getParameters().isEmpty()){
				List<String> expressions =  new ArrayList<String>();
				for(Leaf ch : x.getXorLink()){
					if(ch != Utils.xorAncestorChild(x,sourceLeaf)){
						expressions.add(Utils.conjunction_of_leaves(ch, 0));
					}
				}
				predicate = Utils.toString(expressions, Strings.B_AND);
				
			}
			else{
				predicate = predicate.concat(Utils.getParMaplet(((FlowDiagram)x.eContainer()).getParameters()) + Strings.B_NOTIN); 
				List<String> expressions =  new ArrayList<String>();
				for(Leaf ch : x.getXorLink())
					if(ch != Utils.xorAncestorChild(x,sourceLeaf)){
						expressions.add(Utils.union_of_leaves(ch, 0));
					}
				predicate = predicate.concat(Utils.toString(expressions, Strings.B_UNION));
			}
			System.out.println(sourceLeaf.getName() + ": " + name + "-> " + predicate);
			
			ret.add(Make.descriptor(equivalent, guards, Make.guard(name, predicate), 1));	
		}
		
				
				
		return ret;
		
	}


	

}
	