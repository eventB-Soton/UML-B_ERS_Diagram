package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Convergence;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Parameter;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;



public class TR_leaf6_sLeaf_rEve extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		if(sourceLeaf.getName().equals("a4")){
			System.out.println(sourceLeaf.getDecompose().size());
		}
		return sourceLeaf.getDecompose().isEmpty() &&
				(sourceLeaf.isRef() || //leaf with a solid line (it can be a xor leaf or an one leaf)
				(!sourceLeaf.isRef() && Utils.getParentFlow(sourceLeaf).isCopy()));
				 
				
	}

		
	/**
	 * TR_leaf6, Transform a solid leaf to a refining event with parameters
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		String name = sourceLeaf.getName();
		Event newEvent;
		List<String> refineNames = new ArrayList<String>();
		
		//--------------------------------------------------------------
	
	     if(sourceLeaf.isRef()){
	    	 String parentName = ((Leaf)Utils.getParentFlow(sourceLeaf).eContainer()).getName();
	    	 Event oldEvent = (Event) Find.named(container.getEvents(), parentName);
	    	 if(oldEvent != null){
	    		 refineNames.add(parentName);
		    	 
	    	 }
	    	 //To deal with the case if generateEvent-B is done more than once
	    	 else{
	    		 oldEvent =  (Event)Find.named(container.getEvents(), name);
	    		 if (oldEvent != null)
	    		  refineNames = oldEvent.getRefinesNames();
	    	 }
	    		 
	    	 newEvent = (Event) Make.event(name, false, Convergence.ORDINARY, refineNames, "");
    		 if (oldEvent != null)
	    	  copyNonGeneratedAttributes(oldEvent, newEvent, ret); 
     		 ret.add(Make.descriptor(container, events, newEvent, -10, true));//editable
	    	 container.getEvents().remove(oldEvent);   	
	     }
	     else{
	    	 
	    	 refineNames.add(name);
	    		
	    	 newEvent = (Event) Make.event(name, false, Convergence.ORDINARY, refineNames, "");
	    	
	    	 Event oldEvent = (Event) Find.named(container.getEvents(), name);
	    	 if(oldEvent != null)
	    		 copyNonGeneratedAttributes(oldEvent, newEvent, ret);
	    	 ret.add(Make.descriptor(container, events, newEvent, -10, true));//editable
	    	 container.getEvents().remove(oldEvent);
	     }
	    	 		
		
		for(TypedParameter tp : Utils.getParentFlow(sourceLeaf).getParameters()){
			Parameter p = (Parameter) Make.parameter(tp.getName());
			ret.add(Make.descriptor(newEvent, parameters, p, -10));
		}
		
		if(sourceLeaf.eContainer() instanceof One){
			Parameter p = (Parameter) Make.parameter(((One)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, -10));

		}
       
		//Dana: I added the other replicator parameters in case an event is copied  and not refined
		else if(sourceLeaf.eContainer() instanceof All){
			Parameter p = (Parameter) Make.parameter(((All)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));		
		}
		else if(sourceLeaf.eContainer() instanceof Some){
			Parameter p = (Parameter) Make.parameter(((Some)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));
		}

		else if(sourceLeaf.eContainer() instanceof Par){
			Parameter p = (Parameter) Make.parameter(((Par)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));

		}
	
		return ret;
	
	}
	
    
	private void copyNonGeneratedAttributes(Event oldEvent, Event newEvent, List<GenerationDescriptor> ret ){
		
		Event e = oldEvent.getRefines().get(0);
		for(int i = 0; i < e.getActions().size(); i++){
		
			if(!e.getActions().get(i).isLocalGenerated())
				//newEvent.getActions().add(e.getActions().get(i));
				ret.add(Make.descriptor(newEvent, actions, e.getActions().get(i), -10, true));
			
				
			
		}
		for(int i = 0; i < e.getGuards().size(); i++){
			
			if(!e.getGuards().get(i).isLocalGenerated())
				//newEvent.getGuards().add(e.getGuards().get(i));
				ret.add(Make.descriptor(newEvent, guards, e.getGuards().get(i), -10, true)); //Dana fixed previously copying only first one
			
		}
		for(int i = 0; i < e.getParameters().size(); i++){
			
			if(!e.getParameters().get(i).isLocalGenerated())
				//newEvent.getParameters().add(e.getParameters().get(i));
				ret.add(Make.descriptor(newEvent, parameters, e.getParameters().get(i), -10, true));
			
		}
		for(int i = 0; i < e.getWitnesses().size(); i++){
			
			if(!e.getWitnesses().get(i).isLocalGenerated())
				//newEvent.getWitnesses().add(e.getWitnesses().get(i));
			    ret.add(Make.descriptor(newEvent, witnesses, e.getWitnesses().get(i), -10, true));
			
		}
	}
	
}
