package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
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



public class TR_leaf7_dLeaf_nrEve extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				!sourceLeaf.isRef() && //leaf with a solid line (it can be a xor leaf or an one leaf)
				!Utils.getParentFlow(sourceLeaf).isCopy();
	}

		
	/**
	 * TR_leaf7, Transform a dashed leaf to a non-refining event with parameters
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		String name = sourceLeaf.getName();
		//--------------------------------------------------------------
		//Dana: Fixed to allow the reuse of already created events
		
	
		Event newEvent = (Event) Find.named(container.getEvents(), ((Leaf)sourceElement).getName());
		if (newEvent == null){
			newEvent = (Event) Make.event(name);
			
		}
	    //---------------------------------------------------
	    
		//Event newEvent = (Event) Make.event(name); //this will be commented if we allowreuse of events
	
		//newEvent.setGenerated(false);

		ret.add(Make.descriptor(container, events, newEvent, -1, true));
	   
		
		// parameters
		for(TypedParameter tp : Utils.getParentFlow(sourceLeaf).getParameters()){
			Parameter p = (Parameter) Make.parameter(tp.getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));
//			String grdName = Strings.TYPEOF_ + tp.getName();
//			String grdPredicate = tp.getName() + Strings.B_IN + tp.getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
		}
		
		//replicator parameter
		if(sourceLeaf.eContainer() instanceof All){
			Parameter p = (Parameter) Make.parameter(((All)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));
//			String grdName = Strings.TYPEOF_ + p.getName();
//			String grdPredicate = p.getName() + Strings.B_IN + ((All)sourceLeaf.eContainer()).getNewParameter().getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
			
		}
		else if(sourceLeaf.eContainer() instanceof Some){
			Parameter p = (Parameter) Make.parameter(((Some)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));
//			String grdName = Strings.TYPEOF_ + p.getName();
//			String grdPredicate = p.getName() + Strings.B_IN + ((Some)sourceLeaf.eContainer()).getNewParameter().getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
		}
		else if (sourceLeaf.eContainer() instanceof One){
			Parameter p = (Parameter) Make.parameter(((One)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));
//			String grdName = Strings.TYPEOF_ + p.getName();
//			String grdPredicate = p.getName() + Strings.B_IN + ((One)sourceLeaf.eContainer()).getNewParameter().getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
		}
		else if(sourceLeaf.eContainer() instanceof Par){
			Parameter p = (Parameter) Make.parameter(((Par)sourceLeaf.eContainer()).getNewParameter().getName());
			ret.add(Make.descriptor(newEvent, parameters, p, 1));
//			String grdName = Strings.TYPEOF_ + p.getName();
//			String grdPredicate = p.getName() + Strings.B_IN + ((Par)sourceLeaf.eContainer()).getNewParameter().getType();
//			ret.add(Make.descriptor(newEvent, guards, Make.guard(grdName, grdPredicate), 1));
		}
	
		return ret;
	}
	

	
	
}
