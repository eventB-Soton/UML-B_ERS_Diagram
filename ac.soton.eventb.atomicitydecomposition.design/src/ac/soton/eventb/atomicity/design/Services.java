package ac.soton.eventb.atomicity.design;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.Constructor;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.Xor;

/**
 * The services class used by VSM.
 */

public class Services {
	
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24
    * for documentation on how to write service methods.
    */
	
	/**
	 * This method returns all the hierarchy of a FlowDiagram.
	 * More specifically, this method returns all Child elements that refine the provided FlowDiagram,
	 * as well as all their children nodes (links,...)
	 * This method is called when the diagram is first drawn/ redrawn, so that we get all 
	 * children elements of the drawn FlowDiagram
	 * @param diag flow diagram that we want the children of
	 * @return list containing all direct and indirect children of the FlowDiagram
	 */
    public List<EObject> getFlowDiagramAndChildrenNodes(FlowDiagram diag){
    	ArrayList<EObject> gatheredObjects = new ArrayList<EObject>();
    	gatheredObjects.add(diag);
    	//We get the direct refinements of this FlowDiagram
    	EList<Child> refinements = diag.getRefine();
    	gatheredObjects.addAll(refinements);
    	//for each refinement, we get also the linked leaves to this refinement
    	//(ie : linked leaves to nodes such as And, Loop, All, etc ...)
    	//We also get the subDiagrams of leaves
    	List<Leaf> linkedLeaves = new ArrayList<>();
    	List<FlowDiagram> subDiagrams = new ArrayList<>();
    	for(Child refinement : refinements) {
    		if(refinement instanceof Leaf) {
    			//Leaf : Might know sub-FlowDiagrams via its decompose attribute
    			//we store those subDiagrams in a specific list
				subDiagrams.addAll(((Leaf) refinement).getDecompose());
				//we store also the subFlows themselves
				gatheredObjects.addAll(((Leaf) refinement).getDecompose());
    		} else if(refinement instanceof Constructor){
    			//And, Or, ... Node : we retrieve its linked Leaf(s)
    			linkedLeaves.addAll(getLinkedLeavesFromConstructor((Constructor) refinement));
    		} else {
    			//this case should not happen considering the model structure 
    			//(a Child is either a Leaf or a Constructor)
    			//TODO : see how to log properly
    			System.err.println("WARNING : unknown instance type in getFlowDiagramAndChildrenNodes()."
    					+ "Ignoring that instance. Unrecognized Instance Type : "+refinement.getClass());
    		}
    	}
    	//We add all the gathered linked leaves 
    	gatheredObjects.addAll(linkedLeaves);
    	
    	//for each linked Leaf that we've found, we check if they have sub diagrams
    	//and add them to the list if that's the case
    	for(Leaf leaf : linkedLeaves) {
    		subDiagrams.addAll(((Leaf) leaf).getDecompose());
    	}
    	
    	//we call recursively getFlowDiagramAndChildrenNodes on the subDiagrams previously found
		for(FlowDiagram subDiagram : subDiagrams) {
			gatheredObjects.addAll(getFlowDiagramAndChildrenNodes(subDiagram));
		}
		
    	//Finally we return the bunch of EObjects that we collected
		//this list contains : all Leaves in the hierarchy, as well as all Constructors (Or, And, Loop, ...)
		return gatheredObjects;
    }


    /**
     * Returns a list containing all linked Leaf instances
     * to the given constructor
     * @param constructor Constructor for which we want the linked leaves
     * @return List containing the linked elements to the given constructor. <br>
     *         This list can be empty, but will never be null.
     */
    public static List<Leaf> getLinkedLeavesFromConstructor(Constructor constructor) {
    	ArrayList<Leaf> leaves = new ArrayList<Leaf>();
		if(constructor instanceof And) {
			addAllIfNotNull(leaves, ((And) constructor).getAndLink());
		} else if(constructor instanceof Loop) {
			addAllIfNotNull(leaves, ((Loop) constructor).getLoopLink());
		} else if(constructor instanceof All) {
			addIfNotNull(leaves, ((All) constructor).getAllLink());
		} else if(constructor instanceof Some) {
			addIfNotNull(leaves, ((Some) constructor).getSomeLink());
		} else if(constructor instanceof Or) {
			addAllIfNotNull(leaves, ((Or) constructor).getOrLink());
		} else if(constructor instanceof Par) {
			addIfNotNull(leaves, ((Par) constructor).getParLink());
		} else if(constructor instanceof Xor) {
			addAllIfNotNull(leaves, ((Xor) constructor).getXorLink());
		} else if(constructor instanceof One) {
			addIfNotNull(leaves, ((One) constructor).getOneLink());
		} else {
			//TODO : see how to log properly
			System.err.println("WARNING : unknown instance in getLinkedLeaves()");
		}
		
		return leaves;
	}
    
    
    /**
     * Returns the name of the reference that contains the Leaves linked to this constructor/
     * @param constructor Constructor for which we want the links reference name
     * @returns name of the reference that contains the elements linked to the constructor.
     * 			or null if none or the Constructor type is unknown
     */
    public String getLinksAttributeName(Constructor constructor) {
    	String linksName;
		if(constructor instanceof And) {
			linksName = "andLink";
		} else if(constructor instanceof Loop) {
			linksName = "loopLink";
		} else if(constructor instanceof All) {
			linksName = "allLink";
		} else if(constructor instanceof Some) {
			linksName = "someLink";
		} else if(constructor instanceof Or) {
			linksName = "orLink";
		} else if(constructor instanceof Par) {
			linksName = "parLink";
		} else if(constructor instanceof Xor) {
			linksName = "xorLink";
		} else if(constructor instanceof One) {
			linksName = "oneLink";
		} else {
			//TODO : see how to log properly
			System.err.println("WARNING : unknown instance in getLinksAttributeName()");
			linksName = null;
		}
		
		return linksName;
	}

    /**
     * Checks if link is not null, then : <br>
     * if not null, calls leaves.add(link) <br>
     * if null, does nothing
     * @param leaves list of leaves
     * @param link link to add to the list if not null
     */
    private static void addIfNotNull(ArrayList<Leaf> leaves, Leaf link) {
    	if(link != null) {
    		leaves.add(link);
    	}//else do nothing
	}

	/**
     * Checks if links is not null, then : <br>
     * if not null, calls leaves.addAll(links) <br>
     * if null, does nothing
     * @param leaves list of leaves
     * @param links links to add to the list if not null
     */
    private static void addAllIfNotNull(ArrayList<Leaf> leaves, EList<Leaf> links) {
    	if(links != null) {
    		leaves.addAll(links);
    	}//else do nothing
	}



	/**
     * Returns the label for a Leaf.<br>
     * This method is only called when the Leaf is decomposed into a new FlowDiagram (decompose.size() > 0)<br>
     * The returned format is the following : <br>
     * LeafName(param1, param2, param3, ..., paramN)<br>
     * @return label of the Leaf with the parameters declared in its sub-FlowDiagrams
     */
    public String getLabelForDecomposedLeaf(Leaf leaf) {
    	String label;
    	EList<FlowDiagram> subFlowDiagrams = leaf.getDecompose();
    	if(leaf.getDecompose().isEmpty()) {
    		//TODO : log a warning/error properly
    		System.err.println("WARNING : getLabelForDecomposedLeaf() should not be called for a Leaf without sub-FlowDiagrams");
    		label = leaf.getName();
    	} else {
    		//We generate the correct formating for the Leaf label
    		StringBuilder labelBuilder = new StringBuilder(leaf.getName());
    		boolean firstParameter = true;
    		labelBuilder.append("(");
    		for( FlowDiagram diagram : subFlowDiagrams) {
    			for(TypedParameterExpression parameter : diagram.getParameters()) {
    				String separator = (firstParameter) ? "" : ", ";
    				labelBuilder.append(separator + parameter.getName());
    				firstParameter = false;
    			}
    		}
    		labelBuilder.append(")");
    		//the label is finally the built String
			label = labelBuilder.toString();
    	}
    	return label;
    }
	
    /**
     * Returns a String format from a Collection of TypedParameterExpression
     * (param1, param2, param3, ..., paramN) <br><br>
     * @param params the collection of parameters that we want the format of
     * @return string format of this collection
     */
    public String getParametersStringFormat(Collection<TypedParameterExpression> params) {
    	StringBuilder labelBuilder = new StringBuilder();
		boolean firstParameter = true;
		labelBuilder.append("(");
		for(TypedParameterExpression parameter : params) {
			String separator = (firstParameter) ? "" : ", ";
			labelBuilder.append(separator + parameter.getName());
			firstParameter = false;
		}
		labelBuilder.append(")");
		//the label is finally the built String
		return labelBuilder.toString();
    }
    
    /**
     * Returns the String representation of a newly declared parameter.
     * @param param parameter that we want the String representation
     * @return String representation of a newly declared parameter
     */
	private String getNewParameterStringRepresentation(TypedParameterExpression param) {
		// This method is just here to avoid code duplication of this small code fragment
		//in One, All, Some, Par label-returning services
		return param.getName() + " : " + param.getInputExpression(); //TODO to update if needed (will probably need to add parameter "type")
	}
	
	public String getLeafLabelWithParameters(Leaf leaf, Object container, Object containerOfcontainer) {
		FlowDiagram parentFlowDiagram;
		TypedParameterExpression parameterDeclaredInConstructor = null;
		if(container instanceof FlowDiagram) {
			//the leaf is linked directly from a FlowDiagram
			parentFlowDiagram = (FlowDiagram) container;
		} else {
			//the leaf is linked to a Constructor node (Or, Xor, ...)
			//thus it is indirectly linked to a FlowDiagram node
			parentFlowDiagram = (FlowDiagram) containerOfcontainer;
			
			//we also get the parameter declared in the Constructor node, if any
			parameterDeclaredInConstructor = getParameterFromConstructor((EObject) container);
		}
		
		ArrayList<TypedParameterExpression> paramsToConsider = new ArrayList<>();
		paramsToConsider.addAll(parentFlowDiagram.getParameters());
		//if any parameter was declared in the parent Constructor node, we will display it in the leaf's label
		if(parameterDeclaredInConstructor != null) {
			paramsToConsider.add(parameterDeclaredInConstructor);
		}
		
		//finally, we return the label with found parameters
		return leaf.getName() + getParametersStringFormat(paramsToConsider);	
	}
    
	/**
	 * Returns the label displayed in the ERS Diagram for One nodes.
	 * @param node The One node that we want the label of
	 * @return label of the given One label
	 */
    public String getOneLabelWithParameters(One node) {
    	TypedParameterExpression param =  node.getNewParameter();
    	return  "ONE(" + getNewParameterStringRepresentation(param) + ")";
    }
    
    /**
	 * Returns the label displayed in the ERS Diagram for All nodes.
	 * @param node The All node that we want the label of
	 * @return label of the given All label
	 */
    public String getAllLabelWithParameters(All node) {
    	TypedParameterExpression param =  node.getNewParameter();
    	return  "ALL(" + getNewParameterStringRepresentation(param) + ")";
    }
    
    /**
	 * Returns the label displayed in the ERS Diagram for Some nodes.
	 * @param node The Some node that we want the label of
	 * @return label of the given Some label
	 */
    public String getSomeLabelWithParameters(Some node) {
    	TypedParameterExpression param =  node.getNewParameter();
    	return  "SOME(" + getNewParameterStringRepresentation(param) + ")";
    }
    
    /**
   	 * Returns the label displayed in the ERS Diagram for Par nodes.
   	 * @param node The Par node that we want the label of
   	 * @return label of the given Some label
   	 */
     public String getParLabelWithParameters(Par node) {
       	TypedParameterExpression param =  node.getNewParameter();
       	return  "PAR(" + getNewParameterStringRepresentation(param) + ")";
     }

     
     /**
      * Checks if the element passed in parameter has a TypedParameter.
      * returns true if that element is an instance of Some, All, Par, or One
      * @param element element to check
      * @return true if that element is an instance of Some, All, Par, or One
      */
     public boolean checkIfSelectedElementHasParameter(EObject element){
    	 return (element instanceof Some) 
    			 || (element instanceof All) 
    			 || (element instanceof Par) 
    			 || (element instanceof One);
     }
     
     /**
      * Returns the value of the "newParameter" attribute if the element given
      * is an instance of Some, All, Par, One.
      * Else returns null.
      * @param element element that we want the "newParameter" attribute
      * @return value of the "newParameter" attribute if the element given
      * is an instance of Some, All, Par, One, or null else.
      */
     public TypedParameterExpression getParameterFromConstructor(EObject element) {
    	 TypedParameterExpression param;
    	 if(element instanceof Some) {
    		 param = ((Some) element).getNewParameter();
    	 } else if(element instanceof All) {
    		 param = ((All) element).getNewParameter();
    	 } else if(element instanceof Par) {
    		 param = ((Par) element).getNewParameter();
    	 } else if(element instanceof One) {
    		 param = ((One) element).getNewParameter();
    	 } else {
    		 param = null;
    	 }
    	 return param;
     }
     
     /**
      * Returns true if the allLink attribute of the given allNode
      * is null
      * @param allNode all node tested
      * @return true if the allLink attribute of the given allNode
      * is null
      */
     public Boolean isAllLinkFree(All allNode) {
    	 return allNode.getAllLink() == null ;
     }
     
     /**
      * Adds taget to the links list of node, then returns the modified list.
      * @param node And node in which we add the target element
      * @param target element to add to the links list
      * @return modified node's links list
      */
     public List<Leaf> addElementToAndNode(And node, Leaf target) {
    	 node.getAndLink().add(target);
    	 return node.getAndLink();
     }
     
     /**
      * Adds taget to the links list of node, then returns the modified list.
      * @param node Xor node in which we add the target element
      * @param target element to add to the links list
      * @return modified node's links list
      */
     public List<Leaf> addElementToXorNode(Xor node, Leaf target) {
    	 node.getXorLink().add(target);
    	 return node.getXorLink();
     }
     
     /**
      * Adds taget to the links list of node, then returns the modified list.
      * @param node Or node in which we add the target element
      * @param target element to add to the links list
      * @return modified node's links list
      */
     public List<Leaf> addElementToOrNode(Or node, Leaf target) {
    	 node.getOrLink().add(target);
    	 return node.getOrLink();
     }
     
     
     /**
      * Adds target to the list of refined elements of the given diagram
      * @param diagram FlowDiagram in which we want to add target as a refine element
      * @param target element to add
      * @return new state of the diagram's refine list
      */
     public List<Child> addRefinedElementToFlowDiagram(FlowDiagram diagram, Child target){
    	 diagram.getRefine().add(target);
    	 return diagram.getRefine();
     }
    
     /**
      * Checks if a link can be added to the given Constructor.
      * This methods first checks the Constructor type (And, All ... Node)
      * then checks if its link structure can contain one more element.
      * If it is the case, the method returns true, else it return false.
      * @param construct Constructor for which we want to check if a link can be added
      * @return true if a link can be added to the Constructor or false if not.
      */
    public Boolean checkIsConstructorConnectionStartAllowed(Constructor constructor) {
    	boolean freeLink;
    	if(constructor instanceof And) {
 			//For an And Node, a link can be added anytime
    		freeLink = true;
 		} else if(constructor instanceof Loop) {
 			//For an Loop Node, a link can be added anytime
    		freeLink = true;
 		} else if(constructor instanceof All) {
 			//for an All Node, a link can be added only if the node is not connected to any Leaf
 			freeLink = ((All) constructor).getAllLink() == null;
 		} else if(constructor instanceof Some) {
 			//for a Some Node, a link can be added only if the node is not connected to any leaf
 			freeLink = ((Some) constructor).getSomeLink() == null;
 		} else if(constructor instanceof Or) {
 			//for an Or node, a link can be added anytime
 			freeLink = true;
 		} else if(constructor instanceof Par) {
 			//for a Par Node, a link can be added only if the node is not connected to any leaf
 			freeLink = ((Par) constructor).getParLink() == null;
 		} else if(constructor instanceof Xor) {
 			//for an Xor node, a link can be added anytime
 			freeLink = true;
 		} else if(constructor instanceof One) {
 			//For a One node, a link can be added only if there if no current link
 			freeLink = ((One) constructor).getOneLink() == null;
 		} else {
 			//TODO : see how to log properly
 			System.err.println("WARNING : unknown instance in checkIsConstructorConnectionStartAllowed()");
 			freeLink = false;
 		}
    	return freeLink;
    }
    
    /**
     * Returns an empty ArrayList of TypedParameterExpression
     * Used in parameters copy 
     * @return empty ArrayList of TypedParameterExpression
     */
    public List<TypedParameterExpression> getNewParametersList(){
    	return new ArrayList<TypedParameterExpression>();
    }
    
    /**
     * Transmits the given parameter to all the children FlowDiagrams of flowDiag
     * @param flowDiag FlowDiagram for which we want to transmit a parameter
     * @param parameterToTransmit parameter to transmit
     */
    public void doInheritanceOfParameter(FlowDiagram flowDiag, TypedParameterExpression parameterToTransmit) {
		System.out.println("parameter added to FlowDiagram : "+flowDiag.getName()+", ID : "+flowDiag.getExtensionId());
    	//If the flowDiagram has child flowDiagram, we transmit the new parameter to them
    	transmitParameter(flowDiag, parameterToTransmit);
    }

    /**
     * Transmits a newly created parameter to the whole hierarchy of a FlowDiagram.
     * The parameter is registered into all FlowDiagrams that are children of flowDiag
     * @param flowDiag root FlowDiagram
     * @param parameterToTransmit parameter to transmit to all the hierarchy of the tree
     */
	private void transmitParameter(FlowDiagram flowDiag, TypedParameterExpression parameterToTransmit) {
		EList<Child> children = flowDiag.getRefine();
    	for(Child child : children) {
    		if(child instanceof Leaf) {
    			//if the child is a Leaf, transmit the parameter to its decompositions
    			transmitParameterOnLeaf((Leaf) child, parameterToTransmit);
    		} else if(child instanceof Constructor) {
    			//if the child is a Constructor, transmit the parameter to its linked leaves
    			List<Leaf> linkedLeaves = getLinkedLeavesFromConstructor((Constructor) child);
    			for(Leaf leaf : linkedLeaves) {
    				transmitParameterOnLeaf(leaf, parameterToTransmit);
    			}
    		} else {
    			//unknown Child instance, log it
    			//TODO : see how to log properly
     			System.err.println("WARNING : unknown instance in transmitParameter()");
    		}
    	}
	}

	/**
	 * Simple function that transmits a newly created parameter 
	 * to all FlowDiagrams that are children (direct or not) to a Leaf.
	 * @param leaf 
	 * @param parameterToTransmit parameter to transmit to leaf's decompositions
	 */
	private void transmitParameterOnLeaf(Leaf leaf, TypedParameterExpression parameterToTransmit) {
		//Access to the Leaf's decompositions
		EList<FlowDiagram> decompositions = leaf.getDecompose();
		for(FlowDiagram decomposition : decompositions) {
			//transmit the parameter to the decomposition
			TypedParameterExpression copy = EcoreUtil.copy(parameterToTransmit);
			decomposition.getParameters().add(copy);
			System.out.println("parameter added to FlowDiagram : "+decomposition.getName()+", ID : "+decomposition.getExtensionId());
			//and transmit the parameter to the decomposition sub-tree
			transmitParameter(decomposition, parameterToTransmit);
		}
	}
	
	/**
	 * Removes a parameter from the whole hierarchy under flowDiag.
	 * @param flowDiag root FlowDiagram
	 * @param parameterToRemove parameter to delete
	 */
	public void removeParameter(TypedParameterExpression parameterToRemove, FlowDiagram  flowDiag) {
		//Remove the parameter from flowDiag parameters
		boolean sucess = findAndRemoveParameter(flowDiag, parameterToRemove);
		if(sucess) {
			removeParameterWithoutSuccessCheck(flowDiag, parameterToRemove);
		}
		
	}

	private void removeParameterWithoutSuccessCheck(FlowDiagram flowDiag, TypedParameterExpression parameterToRemove) {
		//then transmit the deletion order to all sub FlowDiagrams of flowDiag
		EList<Child> children = flowDiag.getRefine();
    	for(Child child : children) {
    		if(child instanceof Leaf) {
    			//if the child is a Leaf, transmit the deletion order to its decompositions
    			deleteParameterOnLeaf((Leaf) child, parameterToRemove);
    		} else if(child instanceof Constructor) {
    			//if the child is a Constructor, transmit the deletion order to its linked leaves
    			List<Leaf> linkedLeaves = getLinkedLeavesFromConstructor((Constructor) child);
    			for(Leaf leaf : linkedLeaves) {
    				deleteParameterOnLeaf(leaf, parameterToRemove);
    			}
    		} else {
    			//unknown Child instance, log it
    			//TODO : see how to log properly
     			System.err.println("WARNING : unknown instance in removeParameter()");
    		}
    	}
	}


	/**
	 * Simple function that transmits the deletion order of a parameter to all sub-flowDiagrams of a Leaf
	 * @param leaf
	 * @param parameterToRemove parameter to remove 
	 */
	private void deleteParameterOnLeaf(Leaf leaf, TypedParameterExpression parameterToRemove) {
		//Access to the Leaf's decompositions
		EList<FlowDiagram> decompositions = leaf.getDecompose();
		for(FlowDiagram decomposition : decompositions) {
			//remove the parameter from the decomposition
			boolean success = findAndRemoveParameter(decomposition, parameterToRemove);
			if(success) {
				System.out.println("parameter removed from FlowDiagram : "+decomposition.getName()+", ID : "+decomposition.getExtensionId());
			} else {
				System.err.println("WARNING : Could not delete parameter "+parameterToRemove.getName()
				                   +" from FlowDiagram "+decomposition.getName()+", ID : "+decomposition.getExtensionId());
			}
			//and transmit the parameter to the decomposition sub-tree
			removeParameterWithoutSuccessCheck(decomposition, parameterToRemove);
		}
	}

	/**
	 * Look for the first parameter of flowDiag that has the same name, expression, and type as parameterToRemove,
	 * and removes it from flowDiag's list of parameter
	 * @param flowDiag FlowDiagram in which the parameter must be removed
	 * @param parameterToRemove parameter to Remove
	 * @return true if the parameter could be removed, else false
	 */
	private boolean findAndRemoveParameter(FlowDiagram flowDiag, TypedParameterExpression parameterToRemove) {
		EList<TypedParameterExpression> params = flowDiag.getParameters();
		for(TypedParameterExpression param : params) {
			//Check if parameters properties match
			boolean nameOK = param.getName().equals(parameterToRemove.getName());
			boolean inputExprOK = param.getInputExpression().equals(parameterToRemove.getInputExpression());;
			boolean typeOK = param.getType().equals(parameterToRemove.getType());;
			
			//if so, we found the parameter to remove. Remove it
			if(nameOK && inputExprOK && typeOK) {
				boolean success = params.remove(param);
				return success;//parameter found return success value
			}
		}
		//parameter could not be found
		return false;
	}
    
    
}
