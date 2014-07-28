package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.atomicitydecomposition.generator.utils.Utils;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;


//TODO CHECK THIS RULE!!!
public class TR_xor2_sxor_xInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Xor sourceXor = (Xor) sourceElement;
		List<EObject> nonLeafs = new ArrayList<EObject>();
		//TODO This is how it is done in the old code, should it be souceXor.getExtensions()?

//		for(Leaf l : sourceXor.getXorLink()){
//			if(l instanceof Leaf)
//				nonLeafs.add(l);
//		}

		//XXX My suggestion
		for(AbstractExtension abs : sourceXor.getExtensions()){
			if(abs instanceof FlowDiagram){
				nonLeafs.add(abs);
			
			}
		}
		
		//OR
		
//		List<Leaf> nonDecomposedLeafs = new ArrayList<Leaf>();
//		for(Leaf l : sourceXor.getXorLink()){
//			if(l.getDecompose().isEmpty())
//				nonDecomposedLeafs.add(l);
//		}
		
		
		
		
		return (sourceXor.isRef() && //Xor with a solid line
				//nonLeafs.size() != sourceXor.getXorLink().size()) || //all xor children are leaves, otherwise TR_xor2
				nonLeafs.size() > 0) || //My suggestion
				//or nonDecomposedLeafs.size() > 0 ||
				!sourceXor.isRef();	// xor with a dashed line		
	}
	
	/**
	 * TR_xor2, Transform a xor-constructor to a exclusive property invariant
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Xor sourceXor = (Xor) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		
		int index = Utils.getInvXorIndex(generatedElements);
		
		String name = Strings.INV + (index+1) + Strings._XOR;
		String predicate = generateInvariant(sourceXor);

		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 10));

		
		return ret;
		
	}


	private String generateInvariant(Xor x) {
		String str = "";
		//SI case
		if(((FlowDiagram)x.eContainer()).getParameters().isEmpty()){
			List<String> expressions = new ArrayList<String>();
			
			for(Leaf l : x.getXorLink()){ //TODO check if the intended is not actually all the flow diagrams and the leafs
											//TO do so, needs another situation on disjunction of leaves
				expressions.add(Utils.disjunction_of_leaves(l, 0));
			}
			str = str.concat(Utils.toString(expressions, Strings.B_XOR));
		}
		//MI case
		else{
			str = str.concat(Strings.B_PARTITION);
			List<String> expressions = new ArrayList<String>();
			List<String> parts = new ArrayList<String>();
			for(Leaf l : x.getXorLink()){
				String union = Utils.union_of_leaves(l, 0);
				expressions.add(union);
				parts.add(union);
			}
			parts.add(0, Utils.parenthesize(Utils.toString(expressions, Strings.B_UNION)));
			str = str.concat(Utils.parenthesize(Utils.toString(parts, Strings.B_COM)));
			
		}
		return str;
	}
	
//	private List<EObject> descendants(Xor sourceXor){
//		List<EObject> desc = new ArrayList<EObject>();
//		desc.addAll(sourceXor.getXorLink());
//		for(AbstractExtension abs : sourceXor.getExtensions()){
//			if(abs instanceof FlowDiagram)
//				desc.add(abs);
//		}
//		return desc;
//	}

}
	