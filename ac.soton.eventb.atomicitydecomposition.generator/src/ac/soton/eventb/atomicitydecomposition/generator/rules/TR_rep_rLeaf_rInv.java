package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_rep_rLeaf_rInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		if(!sourceLeaf.getDecompose().isEmpty()) return false;
		
		if((sourceLeaf.eContainer() instanceof All)){
			
			return !((All)sourceLeaf.eContainer()).getNewParameter().getInputExpression().isEmpty();
		}
		else if((sourceLeaf.eContainer() instanceof Some))
			return !((Some)sourceLeaf.eContainer()).getNewParameter().getInputExpression().isEmpty();
		else if((sourceLeaf.eContainer() instanceof One))
			return !((One)sourceLeaf.eContainer()).getNewParameter().getInputExpression().isEmpty();
		else if((sourceLeaf.eContainer() instanceof Par))
			return !((Par)sourceLeaf.eContainer()).getNewParameter().getInputExpression().isEmpty();

		return false;
		/*if(!Utils.repAncestor(sourceLeaf).isEmpty())
			return*/
				
	}

		
	/**
	 * TR_rep, Transform a replicator leaf to the rep property invariant to include the input expression:Dana
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		String name = Strings.INV_ + sourceLeaf.getName() + Strings._REP;
		String predicate =  generatePredicate(sourceLeaf);
		
		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 10));
		
		
		return ret;
		
	}


	private String generatePredicate(Leaf l) {
		List<TypedParameterExpression> par = Utils.getParentFlow(l).getParameters();
		String predicate = "";
		if(!par.isEmpty()){
			String parList = Utils.getParList(par);
			predicate = predicate.concat(Strings.B_FORALL + parList + Strings.B_MIDDOT);
			
			int n = 0;
			for(TypedParameterExpression p : par){
				n++;
				if(p.getInputExpression().isEmpty())
					predicate = predicate.concat(p.getName() + Strings.B_IN + p.getType() + Strings.B_IMPL);
				else
					//XXX on original par.sublist(0,n), but what is n my guess?
					predicate = predicate.concat(p.getName() + Strings.B_IN + p.getInputExpression() + Strings.B_LSQBRC + Strings.B_LBRC +
							Utils.getParMaplet(par.subList(0, n)) + Strings.B_RBRC + Strings.B_RSQBRC + Strings.B_IMPL);					
			}
			predicate = predicate.concat(l.getName() + Strings.B_LSQBRC + Strings.B_LBRC + Utils.getParMaplet(par) + Strings.B_RBRC + Strings.B_RSQBRC +
					Strings.B_SUBSETEQ);
			

			
		}
		else{
			predicate = predicate.concat(l.getName() + Strings.B_SUBSETEQ);
		}
		
		
		if(l.eContainer() instanceof All){
			predicate = predicate.concat(((All)l.eContainer()).getNewParameter().getInputExpression());
		}
		else if(l.eContainer() instanceof Some){
			predicate = predicate.concat(((Some)l.eContainer()).getNewParameter().getInputExpression());
		}
		else if(l.eContainer() instanceof One){
			predicate = predicate.concat(((One)l.eContainer()).getNewParameter().getInputExpression());
		}
		else{ //if(l.eContainer() instanceof Par){
			predicate = predicate.concat(((Par)l.eContainer()).getNewParameter().getInputExpression());
		}
		
		return predicate;
	}
	
	

	
	
}

