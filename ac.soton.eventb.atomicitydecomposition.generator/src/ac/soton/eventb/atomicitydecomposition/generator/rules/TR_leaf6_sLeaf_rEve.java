package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.Parameter;

import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf6_sLeaf_rEve extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
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
		Event newEvent = (Event) Make.event(name);
		newEvent.setGenerated(false);
		//newEvent.setExtended(true);
		ret.add(Make.descriptor(container, events, newEvent, -10));
//		
//		if(sourceLeaf.isRef()){
//			ret.add(Make.descriptor(newEvent, refinesNames, ((Leaf)Utils.getParentFlow(sourceLeaf).eContainer()).getName(), -2));
//		}
		if(!sourceLeaf.isRef()){
			ret.add(Make.descriptor(newEvent, refinesNames, sourceLeaf.getName(), -10));
		}
		
		for(TypedParameter tp : Utils.getParentFlow(sourceLeaf).getParameters()){
			Parameter p = (Parameter) Make.parameter(tp.getName());
			ret.add(Make.descriptor(newEvent, parameters, p, -10));
//			String grdName = Strings.TYPEOF_ + tp.getName();
//			String grdPredicate = tp.getName() + Strings.B_IN + tp.getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
		}
		
		if(sourceLeaf.eContainer() instanceof One){
			Parameter p = (Parameter) Make.parameter(((One)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, -10));
//			String grdName = Strings.TYPEOF_ + p.getName();
//			String grdPredicate = p.getName() + Strings.B_IN + ((One)sourceLeaf.eContainer()).getNewParameter().getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
		}
		
		return ret;
		
	}
	

	
	
}
