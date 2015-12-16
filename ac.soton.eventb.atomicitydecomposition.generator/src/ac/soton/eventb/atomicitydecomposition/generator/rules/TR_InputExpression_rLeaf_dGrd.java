/**
 * 
 */
package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
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

/**
 * @author matheus
 *
 */
public class TR_InputExpression_rLeaf_dGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				!Utils.repAncestor(sourceLeaf).isEmpty();
	}


	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null;
	}

	
	
	
	/**
	 * Dana: TR_inputExpression, Transform a parameter inputexpression in a replicator leaf to a type guard in the quivalent event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		String name = Strings.GRD_INPUTEXPRESSION;

		//SI case
		if(Utils.getParentFlow(sourceLeaf).getParameters().isEmpty()){
			EObject i = sourceLeaf.eContainer();
			int j = 0;
			while(! (i instanceof Machine)){
				
				if(( i instanceof All ) || (i instanceof Some) || (i instanceof One) || (i instanceof Par)){
					String inputExpression;
					String newParameterName;
					if(i instanceof All){
						inputExpression = ((All) i).getNewParameter().getInputExpression();
						newParameterName = ((All) i).getNewParameter().getName();
					}
					else if (i instanceof Some){
						inputExpression = ((Some) i).getNewParameter().getInputExpression();
						newParameterName = ((Some) i).getNewParameter().getName();
					}
					else if(i instanceof One){
						inputExpression = ((One) i).getNewParameter().getInputExpression();
						newParameterName = ((One) i).getNewParameter().getName();
					}
					else{ //i instanceof Par
						inputExpression = ((Par) i).getNewParameter().getInputExpression(); 
						newParameterName = ((Par) i).getNewParameter().getName();
					}
					if(!inputExpression.isEmpty()){
						j++;
						String predicate = newParameterName + Strings.B_IN + inputExpression;
						ret.add(Make.descriptor(equivalent, guards, Make.guard(name + j, predicate), 1));
					}		
				}
				i = i.eContainer();
			}
		}
		else{
			EObject i = sourceLeaf.eContainer();
			int j = 0;
			while(! (i instanceof Machine)){ // Dana: Fixed the loop was missing
				if(( i instanceof All ) || (i instanceof Some) || (i instanceof One) || (i instanceof Par)){
					String inputExpression;
					String newParameterName;
					if(i instanceof All){
						inputExpression = ((All) i).getNewParameter().getInputExpression();
						newParameterName = ((All) i).getNewParameter().getName();
					}
					else if (i instanceof Some){
						inputExpression = ((Some) i).getNewParameter().getInputExpression();
						newParameterName = ((Some) i).getNewParameter().getName();
					}
					else if(i instanceof One){
						inputExpression = ((One) i).getNewParameter().getInputExpression();
						newParameterName = ((One) i).getNewParameter().getName();
					}
					else{ //i instanceof Par
						inputExpression = ((Par) i).getNewParameter().getInputExpression(); 
						newParameterName = ((Par) i).getNewParameter().getName();
					}
					if(!inputExpression.isEmpty()){
						j++;
						String predicate = newParameterName + Strings.B_IN + inputExpression;
						//g.predicate = getParMaplet(getParentFlow(l).parameters) + Strings.B_MAPLET +  l.eContainer().newParameter.name + 
					       //Strings.B_IN+ l.eContainer().newParameter.InputExpression;
						ret.add(Make.descriptor(equivalent, guards, Make.guard(name + j, predicate), 1));
					}		
				}
				i = i.eContainer();
			}
		}
		
		return ret;
		
	}
	

	
	
}
