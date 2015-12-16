package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf6_sLeaf_rEve_addRefines extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		/*Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().size() == 0 
				&& sourceLeaf.isRef() && !Utils.getParentFlow(sourceLeaf).isCopy();// ||
			//	((sourceLeaf.isRef() == false) && Utils.getParentFlow(sourceLeaf).isCopy());*/
		return false; //test
				
	}
	
	/**
	 * 
	 */
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		System.out.println("***>" + ((Leaf)sourceElement).getName() + "->" + (Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null));
		return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null;
		//return Find.named(container.getEvents(), ((Leaf)sourceElement).getName()) != null;//Dana
	}
	
	/**
	 *	Complementary to TR_leaf6. Simply makes the solid line event concrete event refine the abstract one
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		
		Event eve = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		//Event eve = (Event) Find.named(container.getEvents(), ((Leaf)sourceElement).getName());//Dana
		ret.add(Make.descriptor(eve, refinesNames, ((Leaf)Utils.getParentFlow(sourceLeaf).eContainer()).getName(), -2));		
		
		return ret;
	}

}
