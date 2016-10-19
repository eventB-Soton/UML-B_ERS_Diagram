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
		/*Leaf sourceLeaf = (Leaf) sourceElement;
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
         */
		// Dana: Rule Updated to include non-leaf children
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.getDecompose().isEmpty() &&
				!Utils.repAncestorFirstChild(sourceLeaf).isEmpty();
				
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
		
		if(predicate != "")
		 ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 10));
		
		
		return ret;
		
	}

   // Dana: Updated the invariant 22-09-2016
	private String generatePredicate(Leaf l) {
		//-------------------------------------------------------
		List<TypedParameterExpression> par = Utils.getParentFlow(l).getParameters();
		List<TypedParameterExpression> par2 = new ArrayList<TypedParameterExpression>();;
		String predicate = "";
		TypedParameterExpression lastParam = null;
		if(l.eContainer() instanceof All){
			
			if(!((All)l.eContainer()).getNewParameter().getInputExpression().isEmpty()){
				lastParam = ((All)l.eContainer()).getNewParameter();
				par2 = par;
			}
				
		}
		else if(l.eContainer() instanceof Some){
			if(!((Some)l.eContainer()).getNewParameter().getInputExpression().isEmpty()){
				lastParam = ((Some)l.eContainer()).getNewParameter();
				par2 = par;
			}
				
		}
		else if(l.eContainer() instanceof One){
			if(!((One)l.eContainer()).getNewParameter().getInputExpression().isEmpty()){
				lastParam = ((One)l.eContainer()).getNewParameter();
				par2 = par;
			}
				
		}
		else if(l.eContainer() instanceof Par){ 
			if(!((Par)l.eContainer()).getNewParameter().getInputExpression().isEmpty()){
				lastParam = ((Par)l.eContainer()).getNewParameter();
				par2 = par;
			}
				
		}
		else{
			if(!par.get(par.size()-1).getInputExpression().isEmpty()){
				 lastParam = par.get(par.size()-1);
				 //par.remove(par.size()-1);	
				 if (par.size() > 1)
					  par2 = par.subList(0, par.size()-1);
			}	       
		}
        
		if(lastParam == null) 
			return predicate;
		else{
		
			if(!par2.isEmpty()){
				String parList = Utils.getParList(par2);
				predicate = predicate.concat(Strings.B_FORALL + parList + Strings.B_MIDDOT);
				for(TypedParameterExpression p : par2){
					if(par2.indexOf(p) == par2.size()-1){
						if(p.getInputExpression().isEmpty())
							predicate = predicate.concat(p.getName() + Strings.B_IN + p.getType() + Strings.B_IMPL);
						else
							predicate = predicate.concat(p.getName() + Strings.B_IN + p.getInputExpression() + Strings.B_IMPL);
					}
					else{
						if(p.getInputExpression().isEmpty())
							predicate = predicate.concat(p.getName() + Strings.B_IN + p.getType() + Strings.B_AND);
						else
							predicate = predicate.concat(p.getName() + Strings.B_IN + p.getInputExpression() + Strings.B_AND);
					}
				}
			}
			if(par2.size() == 0)
				predicate = predicate.concat(l.getName() + Strings.B_SUBSETEQ + lastParam.getInputExpression());
			else if(par2.size() > 1)
		    	predicate = predicate.concat(l.getName() + Strings.B_LSQBRC + Strings.B_LBRC + Utils.getParMaplet(par2) + Strings.B_RBRC + Strings.B_RSQBRC +
						Strings.B_SUBSETEQ + lastParam.getInputExpression());
		    else //if(par2.size() == 1)
		    	predicate = predicate.concat(l.getName() + Strings.B_LSQBRC + Strings.B_LBRC + par2.get(par2.size()-1).getName() + Strings.B_RBRC + Strings.B_RSQBRC +
						Strings.B_SUBSETEQ + lastParam.getInputExpression());
		    return predicate;
		}

			
		
		
		//--------------------------------------------------------
	}		
}

