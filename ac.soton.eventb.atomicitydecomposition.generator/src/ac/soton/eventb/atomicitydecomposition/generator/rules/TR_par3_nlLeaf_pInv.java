package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Find;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_par3_nlLeaf_pInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Par parRep = (Par) sourceElement;
		return !parRep.getParLink().getDecompose().isEmpty();
	}
	

	@Override
	public boolean dependenciesOK(EventBElement sourceElement, final List<GenerationDescriptor> generatedElements) throws Exception  {
		return true;
	}
	
	/**
	 * Dana: TR_par3, Transform a proper next child after a par-rep to an invariant related to TR_par2
	 * We consider the restriction that the successor of the par-rep if  wasn't a leaf then the first
	 * child of the flow must be solid i.e., one, xor or leaf
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		Child parChild = ((Par) sourceElement).getParLink();
	    String strParRef = Utils.build_par_ref_grd(parChild);
		if(!strParRef.equals("")){
			List <TypedParameterExpression> pars = Utils.getParentFlow(parChild).getParameters();
			int parNum = pars.size();
			Child succ = (Child) Utils.successor(parChild, parNum).get(0);
			String str1 = "";
			// SI
			if(parNum == 0){
				str1= Utils.build_succ_SI_inv(succ, parNum);
			}
			
			//MI
			else{
				str1 = Strings.B_FORALL + Utils.getParList(pars) + Strings.B_MIDDOT + Utils.getParMaplet(pars) + Strings.B_IN + Utils.union_of_leaves(succ, 0); 
				
			}
			
			String invStr = str1 + Strings.B_IMPL + strParRef;
			Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
			int index = Utils.getPrevParInvIndex(parChild, generatedElements);
			String name = Strings.INV + index +Strings._PAR + "_" +Utils.getRootFlowDiagramName(parChild);
			ret.add(Make.descriptor(container, invariants,Make.invariant(name, invStr, ""), 3));
			
		}
		
		
		return ret;
	}
	
}
