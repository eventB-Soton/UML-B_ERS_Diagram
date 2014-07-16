package ac.soton.eventb.atomicitydecomposition.generator.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
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
	
	/**
	 * return a set containing the non-loop predecessor child as first item and the list of its parameters as second item
	 * @param ch
	 * @param parList
	 * @param sw
	 * @return
	 */
	public static List<EObject> predecessor(Child ch, List<TypedParameterExpression> parList, boolean sw){
		FlowDiagram parent = getParentFlow(ch);
		List<Child> sibiling = parent.getRefine();
		int i = sibiling.indexOf(getParentChild(ch));
		
		if(i > 0){
			Child prev = sibiling.get(i-1);
			if(!((prev instanceof Loop) || (prev instanceof Par))){
				List<EObject> list = new ArrayList<EObject>();
				list.add(prev);
				list.addAll(parent.getParameters());
				return list;
			}
			else{
				return predecessor(prev, parList, sw);
			}
		}
		else{
			if(!sw)
				return null;
			else{
				if(isAbstractFlow(parent))
					return null;
				else{
					if ((parent instanceof All) || (parent instanceof Some) || (parent instanceof One)){
						ArrayList<TypedParameterExpression> noNewPar = new ArrayList<TypedParameterExpression>();
						if(parent instanceof All){
							All allParent = (All) parent;
							for(TypedParameterExpression p : parList){
								if(!p.equals(allParent.getNewParameter()))
									noNewPar.add(p);
							}						
						}
						else if(parent instanceof Some){
							Some someParent = (Some) parent;
							for(TypedParameterExpression p : parList){
								if(!p.equals(someParent.getNewParameter()))
									noNewPar.add(p);
							}
						}
						else if(parent instanceof One){
							One oneParent = (One) parent;
							for(TypedParameterExpression p : parList){
								if(!p.equals(oneParent.getNewParameter()))
									noNewPar.add(p);
							}
						}						
						return predecessor((Child)parent.eContainer(), noNewPar, sw);
					}
					else{
						return predecessor((Child)parent.eContainer(), parList, sw);
					}
				}			
			}
		}		
	}
	
	public static boolean isAbstractFlow(FlowDiagram flow){
		for(Child ch : flow.getRefine()){
			if(ch.isRef())
				return false;
		}
		return true;
	}

	
	/**
	 * Returns string representation of a sequence of strings, separated by separator.
	 * @param inStr
	 * @param separator
	 * @return
	 */
	public static String toString(List<String> inStr, String separator){
		String ret = "";
		for(int i = 0 ; i < inStr.size() ; i++){
			ret += inStr.get(i);
			if (i != inStr.size() -1 ) ret += separator;
		}
		return ret;
	}
	
	
	public static String getParTypeCartesian(List<TypedParameterExpression> parList){
		List<String> partTypes = new ArrayList<String>();
		
		//return cartesian product of the parameter types
		for(TypedParameterExpression tp : parList){
			partTypes.add(tp.getType());
		}
		
		return toString(partTypes, Strings.B_CPROD);
	}
	
	
}
