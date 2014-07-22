package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_one3_oLeaf_oGrd extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		System.out.println(sourceLeaf.getName() + " -> " + (sourceLeaf.getDecompose().isEmpty() && !(Utils.oneAncestors(sourceLeaf).isEmpty())));
		return sourceLeaf.getDecompose().isEmpty() &&
				!(Utils.oneAncestors(sourceLeaf).isEmpty());
						
				
	}
	
	
	/**
	 * The event which will receive the guard has already been generated
	 */
	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		return Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName()) != null;
	}
	
	
	/**
	 * TR_one3, Transform a proper one leaf to the one property guard in the quivalent event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		Event equivalent = (Event) Find.generatedElement(generatedElements, container, events, ((Leaf)sourceElement).getName());
		
		int index = 0;
		
		for(One o : Utils.oneAncestors(sourceLeaf)){
			index++;
			String name = Strings.GRD + index + Strings._ONE;
			int m = Utils.getParNumAfterOnePar(sourceLeaf, o);
			List<TypedParameterExpression> par =  new ArrayList<TypedParameterExpression>();
			par.addAll(Utils.getParentFlow(sourceLeaf).getParameters());
			
			if((sourceLeaf.eContainer() instanceof All) || (sourceLeaf.eContainer() instanceof Some) ||(sourceLeaf.eContainer() instanceof One) )
				if(sourceLeaf.eContainer() instanceof All)
					par.add(((All)sourceLeaf.eContainer()).getNewParameter());
				else if(sourceLeaf.eContainer() instanceof Some)
					par.add(((Some)sourceLeaf.eContainer()).getNewParameter());
				else if(sourceLeaf.eContainer() instanceof One)
					par.add(((One)sourceLeaf.eContainer()).getNewParameter());
			
			int n = par.size() - (m+1);
			String s = Utils.getParMaplet(par.subList(0, n));
			
			String predicate = "";
			if(n != 0 && m != 0)
				predicate = predicate.concat(Utils.getDomainStr(sourceLeaf.getName(), 0, m) + Strings.B_LSQBRC + Strings.B_LBRC + s + Strings.B_RBRC + Strings.B_RSQBRC +
							Strings.B_NEQ + Strings.B_EMPTYSET + Strings.B_IMPL + o.getNewParameter().getName() + Strings.B_IN +
							Utils.getDomainStr(sourceLeaf.getName(), 0, m) + Strings.B_LSQBRC + Strings.B_LBRC + s + Strings.B_RBRC + Strings.B_RSQBRC);
			else if(n == 0 && m == 0)
				predicate = predicate.concat(sourceLeaf.getName() + Strings.B_EQ + Strings.B_EMPTYSET);
			else if(n == 0 && m != 0)
				predicate = predicate.concat(sourceLeaf.getName() + Strings.B_NEQ + Strings.B_EMPTYSET + Strings.B_IMPL + o.getNewParameter().getName() +
						Strings.B_IN + Utils.getDomainStr(sourceLeaf.getName(), 0, m));
			else//if (n != 0 && m == 0)
				predicate = predicate.concat(s + Strings.B_NOTIN + Strings.B_DOM + Utils.parenthesize(sourceLeaf.getName()));
			System.out.println(equivalent.getName() + ": " + predicate);
			ret.add(Make.descriptor(equivalent, guards, Make.guard(name, predicate), 10));
			
			
			
		}
			
		
		return ret;
		
	}

}
	