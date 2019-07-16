package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
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
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_one2_oLeaf_oInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		
		return sourceLeaf.getDecompose().isEmpty() &&
				!(Utils.oneAncestors(sourceLeaf).isEmpty());
						
				
	}
	
	
	/**
	 * TR_one2, Transform a proper one leaf to the one property invariant
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		int index = Utils.getPrevOneInvIndex(sourceLeaf, generatedElements);
		
		for(One o : Utils.oneAncestors(sourceLeaf)){
			index++;
			String name = Strings.INV + index + Strings.UNDERSC + Strings.ONE + "_" +Utils.getRootFlowDiagramName(sourceLeaf);
			
			int m = Utils.getParNumAfterOnePar(sourceLeaf, o);
			ArrayList<TypedParameterExpression> par = new ArrayList<TypedParameterExpression>();
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
			String ss = Utils.getParList(par.subList(0, n));
			String predicate = "";
			if(n != 0 && m != 0)
				predicate = predicate.concat(Strings.B_FORALL + ss + Strings.B_MIDDOT + Strings.B_CARD +
						Utils.parenthesize(Utils.getDomainStr(sourceLeaf.getName(), 0, m) +  Strings.B_LSQBRC + Strings.B_LBRC +
								s + Strings.B_RBRC + Strings.B_RSQBRC) + Strings.B_LTEQ + 1);
			else if(n == 0 && m == 0)
				predicate = predicate.concat(Strings.B_CARD + Utils.parenthesize(sourceLeaf.getName()) + Strings.B_LTEQ + 1);
			else if(n == 0 && m != 0)
				predicate = predicate.concat(Strings.B_CARD + Utils.parenthesize(Utils.getDomainStr(sourceLeaf.getName(), 0, m)) +  Strings.B_LTEQ + 1);
			else//if (n != 0 && m == 0)
				predicate = predicate.concat(Strings.B_FORALL + ss + Strings.B_MIDDOT + Strings.B_CARD +
						Utils.parenthesize(sourceLeaf.getName() +  Strings.B_LSQBRC + Strings.B_LBRC +
								s + Strings.B_RBRC + Strings.B_RSQBRC) + Strings.B_LTEQ + 1);
			
			
			ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 3));
		}
			
		
		return ret;
		
	}

}
	