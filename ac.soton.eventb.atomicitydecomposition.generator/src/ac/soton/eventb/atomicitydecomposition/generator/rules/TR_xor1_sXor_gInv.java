package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_xor1_sXor_gInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Xor sourceXor = (Xor) sourceElement;
		List<Leaf> nonDecomposedLeafs = new ArrayList<Leaf>();
		for(Leaf l : sourceXor.getXorLink()){
			if(l.getDecompose().isEmpty())
				nonDecomposedLeafs.add(l);
		}
		
		
		return sourceXor.isRef() && //Xor with a solid line
				nonDecomposedLeafs.size() == sourceXor.getXorLink().size() && //all xor children are leaves, otherwise TR_xor2
				!(sourceXor.eContainer().eContainer().eContainer() instanceof Loop); //its parent is not a loop 
						
				
	}
	
	
	/**
	 * TR_xor1, Transform a solid xor-constructor to a gluing invariant
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Xor sourceXor = (Xor) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		
		String name =  Utils.getInvXorGluName(sourceXor, generatedElements);
		String predicate = generateInvariant(sourceXor);

		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 2));

		
		return ret;
		
	}


	private String generateInvariant(Xor x) {
		String str = "";
		//SI case
		if(((FlowDiagram)x.eContainer()).getParameters().isEmpty()){
			str = Strings.B_PARTITION;
			List<String> expressions = new ArrayList<String>();
			if(x.eContainer().eContainer() instanceof Machine)
				expressions.add(Strings.B_LBRC + ((EventBNamed)x.eContainer().eContainer()).getName() + Strings.B_RBRC + Strings.B_INTER + 
					Strings.B_LBRC + Strings.B_TRUE + Strings.B_RBRC);
			else
				expressions.add(Strings.B_LBRC + ((Leaf)x.eContainer().eContainer()).getName() + Strings.B_RBRC + Strings.B_INTER + 
						Strings.B_LBRC + Strings.B_TRUE + Strings.B_RBRC);
			
			for(Leaf l : x.getXorLink()){
				expressions.add(Strings.B_LBRC + l.getName() + Strings.B_RBRC + Strings.B_INTER + Strings.B_LBRC + Strings.B_TRUE + Strings.B_RBRC);
			}
			str = str.concat(Utils.parenthesize(Utils.toString(expressions, Strings.B_COM)));
			
		}
		//MI case
		else{
			str = Strings.B_PARTITION;
			List<String> expressions = new ArrayList<String>();
			if(x.eContainer().eContainer() instanceof Machine)
				expressions.add(((EventBNamed)x.eContainer().eContainer()).getName());
			else
				expressions.add(((Leaf)x.eContainer().eContainer()).getName());
			
			for(Leaf l : x.getXorLink()){
				expressions.add(l.getName());
			}
			
			str = str.concat(Utils.parenthesize(Utils.toString(expressions, Strings.B_COM)));// Dana, fixed by adding str=str.concat..
		}
		return str;
	}

}
	