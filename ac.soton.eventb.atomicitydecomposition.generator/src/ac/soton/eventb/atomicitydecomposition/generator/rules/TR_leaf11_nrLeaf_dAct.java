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
import ac.soton.eventb.atomicitydecomposition.Loop;
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

public class TR_leaf11_nrLeaf_dAct extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				!(sourceLeaf.eContainer() instanceof All) && //non All leaf
				!(sourceLeaf.eContainer() instanceof Some) && //non some leaf
				!(sourceLeaf.eContainer() instanceof One) && //non one leaf
				!(sourceLeaf.eContainer() instanceof Par) && //non par leaf
				!(sourceLeaf.eContainer() instanceof Loop); //non loop leaf
				
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
			return l.getName() + Strings.B_BEQ + Strings.B_TRUE;
		}
		//MI case
		else
			return l.getName() + Strings.B_BEQ + l.getName() + Strings.B_UNION + Strings.B_LBRC + Utils.getParMaplet(parentFlow.getParameters()) + Strings.B_RBRC;
		
	}
	

	
	
}

