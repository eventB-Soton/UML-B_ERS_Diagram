package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
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

public class TR_leaf12_rLeaf_dAct extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				((sourceLeaf.eContainer() instanceof All) || 
						(sourceLeaf.eContainer() instanceof Some) ||
						(sourceLeaf.eContainer() instanceof One) ||
						(sourceLeaf.eContainer() instanceof Par));
						
				
	}


	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null;
	}

	
	
	
	/**
	 * TR_leaf11, Transform a non-relicator leaf to a disabling action in the quivalent event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		String name = Strings.ACT;
		String action = generateAction(sourceLeaf);

		ret.add(Make.descriptor(equivalent, actions, Make.action(name, action), 1));

		
		return ret;
		
	}


	private String generateAction(Leaf l) {
		FlowDiagram parentFlow = Utils.getParentFlow(l);
		//SI case
		if(parentFlow.getParameters().isEmpty()){
			if(l.eContainer() instanceof All)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + ((All)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			else if(l.eContainer() instanceof Some)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + ((Some)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			else if(l.eContainer() instanceof One)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + ((One)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			else //if(l.eContainer() instanceof Par)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + ((Par)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			
		}
		//MI case
		else{
			if(l.eContainer() instanceof All)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + Utils.getParMaplet(parentFlow.getParameters()) 
						+ Strings.B_MAPLET + ((All)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			else if(l.eContainer() instanceof Some)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + Utils.getParMaplet(parentFlow.getParameters()) 
						+ Strings.B_MAPLET + ((Some)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			else if(l.eContainer() instanceof One)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + Utils.getParMaplet(parentFlow.getParameters()) 
						+ Strings.B_MAPLET + ((One)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			else //if(l.eContainer() instanceof Par)
				return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION +Strings.B_LBRC + Utils.getParMaplet(parentFlow.getParameters()) 
						+ Strings.B_MAPLET + ((Par)l.eContainer()).getNewParameter().getName() + Strings.B_RBRC;
			
		}
			
		
	}
	

	
	
}

