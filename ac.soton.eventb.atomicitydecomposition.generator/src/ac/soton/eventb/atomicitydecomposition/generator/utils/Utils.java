package ac.soton.eventb.atomicitydecomposition.generator.utils;

import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;

public class Utils {
	
	/**
	 * return the parent flow of a child
	 * @param ch
	 * @return
	 */
	public static FlowDiagram getParentFlow(Child ch) {
		
		if (ch instanceof Leaf) {
			
			if (ch.eContainer() instanceof FlowDiagram)
				return (FlowDiagram) ch.eContainer();
			else // a constructor leaf
				return (FlowDiagram) ch.eContainer().eContainer();
		}
		
		else // ch is a constructor
			return (FlowDiagram) ch.eContainer();
		
	}

	/**
	 * return the parent child of a leaf constructor
	 * @param ch
	 * @return
	 */
	public static Child getParentChild(Child ch){

		if (ch.eContainer() instanceof FlowDiagram)
			return ch;

		else // ch is a leaf constructor
		return (Child) ch.eContainer();

	}
	
	/**
	 * Returns the Initialisation event of a given machine (n
	 * @param m
	 * @return
	 */
	public static Event getInitialisationEvent(Machine m){
		for(Event e : m.getEvents()){
			if(e.getName().equals(Strings.INIT))
				return e;
		}
		return null;
	}
	

}
