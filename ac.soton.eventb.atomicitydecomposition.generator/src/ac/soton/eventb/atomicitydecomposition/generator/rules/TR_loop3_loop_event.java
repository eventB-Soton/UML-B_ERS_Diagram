package ac.soton.eventb.atomicitydecomposition.generator.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
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

public class TR_loop3_loop_event extends AbstractRule  implements IRule {
	
	private FlowDiagram parentFlow;
	private Event e;
	private Loop sourceLoop;
	
	@Override
	public boolean enabled(EventBElement sourceElement) throws Exception  {
		Loop sourceLoop = (Loop) sourceElement;
		
		return !sourceLoop.getLoopLink().getDecompose().isEmpty();
				
				
	}
	
	
	/**
	 * TR_loop3, Transform a loop to a resetting event
	 */
	@Override
	public List<GenerationDescriptor> fire(EventBElement sourceElement, List<GenerationDescriptor> generatedElements) throws Exception {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		sourceLoop = (Loop) sourceElement;	
		Machine	container = (Machine)EcoreUtil.getRootContainer(sourceElement);
		parentFlow = Utils.getParentFlow(sourceLoop);
		
		e = (Event) Make.event( Utils.getLoopResetName(sourceLoop, generatedElements));
		
		
		ret.add(Make.descriptor(container, events, e, -10));
		ret.addAll(makePars());
		ret.add(makeGrd());
		ret.addAll(makeActions());
		
		
		return ret;
	}	
	
	
	private Collection<GenerationDescriptor> makeActions() {
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		for(Leaf l : Utils.getNonDecomposedLeafDescendants(sourceLoop)){
			FlowDiagram lParentFlow = Utils.getParentFlow(l);
			Child lParentChild = Utils.getParentChild(l);
			List<TypedParameterExpression> lpars = lParentFlow.getParameters();
			
			String name = Strings.ACT_ + l.getName() + Strings._RESET;
			String action = "";
			
			//SI Case
			if(parentFlow.getParameters().isEmpty()){
				if(lpars.isEmpty() && !(lParentChild instanceof All) && !(lParentChild instanceof Some) && !(lParentChild instanceof One) && !(lParentChild instanceof Par)){
					action = l.getName() + Strings.B_BEQ + Strings.B_FALSE;
				}
				else
					action = l.getName() + Strings.B_BEQ + Strings.B_EMPTYSET;
			}
			//MI case
			else{
				if(lpars.size() == parentFlow.getParameters().size() && !(lParentChild instanceof All) && !(lParentChild instanceof Some) && !(lParentChild instanceof One) && !(lParentChild instanceof Par)){
					action = l.getName() + Strings.B_BEQ + l.getName() + Strings.B_SETMINUS + Strings.B_LBRC +
							Utils.getParMaplet(parentFlow.getParameters()) + Strings.B_RBRC;
				}
				else{
					action = l.getName() + Strings.B_BEQ + Strings.B_LBRC + Utils.getParMaplet(parentFlow.getParameters()) +
							Strings.B_RBRC +  Strings.B_DOMRES + l.getName();
				}
			}
			ret.add(Make.descriptor(e, actions, Make.action(name, action), 1));
		}
		return ret;
	}


	private GenerationDescriptor makeGrd() {
		String name = Strings.GRD_RESET;
		String predicate = "";
		
		if(parentFlow.getParameters().isEmpty()){
			predicate = Utils.build_seq_grd(sourceLoop.getLoopLink(), parentFlow.getParameters(), null, new ArrayList<TypedParameterExpression>(), false);
		}
		else
			predicate = Utils.build_seq_grd(sourceLoop.getLoopLink(), parentFlow.getParameters(), (Leaf) parentFlow.getRefine().get(parentFlow.getRefine().indexOf(sourceLoop) + 1), parentFlow.getParameters(), true);
		return Make.descriptor(e, guards, Make.guard(name, predicate), 5);
			

	}


	private List<GenerationDescriptor> makePars(){
		List<GenerationDescriptor> ret = new ArrayList<GenerationDescriptor>();
		
		for(TypedParameterExpression tpe : parentFlow.getParameters()){
			ret.add(Make.descriptor(e, parameters, Make.parameter(tpe.getName()), 1));
		}
		return ret;
		
	}
	
	
	
}
