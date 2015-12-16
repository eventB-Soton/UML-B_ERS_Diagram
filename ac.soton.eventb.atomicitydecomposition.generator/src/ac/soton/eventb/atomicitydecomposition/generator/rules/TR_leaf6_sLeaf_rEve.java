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

import org.eventb.emf.core.machine.Action;

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
		 List <Action> a = new ArrayList<Action>();
	     if(sourceLeaf.isRef()){
	    	 String parentName = ((Leaf)Utils.getParentFlow(sourceLeaf).eContainer()).getName();
	    	
	    	 refineNames.add(parentName);
	    		
	    	 newEvent = (Event) Make.event(name, false, Convergence.ORDINARY, refineNames, "");
	    	 //---------------------------------------------------------------------------------------------
	    	 // Dana: under testing in case the user decided to translate again after adding some manual  stuff
	    	// Event dupEvent = (Event) Find.named(container.getEvents(), name);
	    	// if(dupEvent != null){
	    		// copyNonGeneratedAttributes(dupEvent, newEvent);
	    		 //container.getEvents().remove(dupEvent);
	    	 //}
	    		 
	    	 //------------------------------------------------------------------------------------------------
	    	 Event oldEvent = (Event) Find.named(container.getEvents(), parentName);
	    	 if(oldEvent != null)
	    		 copyNonGeneratedAttributes(oldEvent, newEvent);
	    	 ret.add(Make.descriptor(container, events, newEvent, -10, true));//editable
	    	 
	    	 container.getEvents().remove(oldEvent);
	     }
	     else{
	    	 
	    	 refineNames.add(name);
	    		
	    	 newEvent = (Event) Make.event(name, false, Convergence.ORDINARY, refineNames, "");
	    	
	    	 Event oldEvent = (Event) Find.named(container.getEvents(), name);
	    	 if(oldEvent != null)
	    		 copyNonGeneratedAttributes(oldEvent, newEvent);
	    	 ret.add(Make.descriptor(container, events, newEvent, -10, true));//editable
	    	 container.getEvents().remove(oldEvent);
	     }
	    	 
	    	
	
		
		
	
		
	/*	
		Event newEvent = (Event) Find.named(container.getEvents(), name);//if copied
		if (newEvent == null){
			String parentName = ((Leaf)Utils.getParentFlow(sourceLeaf).eContainer()).getName();// if solid name
			newEvent = (Event) Find.named(container.getEvents(), parentName);
		 
			newEvent.setName(name);
			
		    
		
		}*/
		// try to find the old event in the machine and delete it 
	    //---------------------------------------------------
		//Event newEvent = (Event) Make.event(name);//commented by dana
		//ret.add(Make.descriptor(container, events, newEvent, -10, true));//editable

//		
//		if(sourceLeaf.isRef()){
//			ret.add(Make.descriptor(newEvent, refinesNames, ((Leaf)Utils.getParentFlow(sourceLeaf).eContainer()).getName(), -2));
//		}
	/*	if(!sourceLeaf.isRef() || (Utils.getParentFlow(sourceLeaf).isCopy() &&sourceLeaf.getDecompose().isEmpty())){
			ret.add(Make.descriptor(newEvent, refinesNames, sourceLeaf.getName(), -2));//-10
		
		}*/
		
		
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
	
    
	private void copyNonGeneratedAttributes(Event oldEvent, Event newEvent){
		Event e = oldEvent.getRefines().get(0);
		for(int i = 0; i < e.getActions().size(); i++){
		
			if(!e.getActions().get(i).isLocalGenerated())
				newEvent.getActions().add(e.getActions().get(i));
			
		}
		for(int i = 0; i < e.getGuards().size(); i++){
			
			if(!e.getGuards().get(i).isLocalGenerated())
				newEvent.getGuards().add(e.getGuards().get(i));
			
		}
		for(int i = 0; i < e.getParameters().size(); i++){
			
			if(!e.getParameters().get(i).isLocalGenerated())
				newEvent.getParameters().add(e.getParameters().get(i));
			
		}
		for(int i = 0; i < e.getWitnesses().size(); i++){
			
			if(!e.getWitnesses().get(i).isLocalGenerated())
				newEvent.getWitnesses().add(e.getWitnesses().get(i));
			
		}
	}
	
}
