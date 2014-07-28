package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.emf.diagrams.generator.AbstractRule;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;
import ac.soton.eventb.emf.diagrams.generator.IRule;
import ac.soton.eventb.emf.diagrams.generator.utils.Make;

public class TR_leaf5_sLeaf_gInv extends AbstractRule  implements IRule {
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Leaf sourceLeaf = (Leaf) sourceElement;
		return sourceLeaf.isRef() && //leaf with a solid line
				!(sourceLeaf.eContainer() instanceof Xor) && //not a xor leaf (TR_xor1)
				!(sourceLeaf.eContainer() instanceof One) && //not an one leaf (TR_one1)
				!(sourceLeaf.eContainer().eContainer().eContainer() instanceof Loop); //its parent is not a loop 
				// other constructors come only with dashed lines
	}

		
	/**
	 * TR_leaf5, Transform a solid leaf to a gluing invariant
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		Leaf sourceLeaf = (Leaf) sourceElement;		
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		String name = Strings.INV_ + sourceLeaf.getName() + Strings._GLU;
		String predicate = sourceLeaf.getName() + Strings.B_EQ + ((Leaf)sourceLeaf.eContainer().eContainer()).getName();
		ret.add(Make.descriptor(container, invariants, Make.invariant(name, predicate, ""), 2));
		
		return ret;
		
	}
	

	
	
}
