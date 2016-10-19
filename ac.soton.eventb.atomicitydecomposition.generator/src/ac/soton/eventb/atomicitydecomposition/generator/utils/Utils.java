package ac.soton.eventb.atomicitydecomposition.generator.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;

import ac.soton.eventb.atomicitydecomposition.All;
import ac.soton.eventb.atomicitydecomposition.And;
import ac.soton.eventb.atomicitydecomposition.Child;
import ac.soton.eventb.atomicitydecomposition.FlowDiagram;
import ac.soton.eventb.atomicitydecomposition.Leaf;
import ac.soton.eventb.atomicitydecomposition.Loop;
import ac.soton.eventb.atomicitydecomposition.One;
import ac.soton.eventb.atomicitydecomposition.Or;
import ac.soton.eventb.atomicitydecomposition.Par;
import ac.soton.eventb.atomicitydecomposition.Some;
import ac.soton.eventb.atomicitydecomposition.TypedParameterExpression;
import ac.soton.eventb.atomicitydecomposition.Xor;
import ac.soton.eventb.atomicitydecomposition.generator.strings.Strings;
import ac.soton.eventb.emf.diagrams.generator.GenerationDescriptor;

public class Utils {
	
	/**
	 * return the parent flow of a child
	 * @param ch
	 * @return
	 */
	public static FlowDiagram getParentFlow(Child ch) {
		
		if (ch instanceof Leaf) {
			
			if (ch.eContainer() instanceof FlowDiagram)
				return (FlowDiagram) ch.eContainer();
			else // a constructor leaf
				return (FlowDiagram) ch.eContainer().eContainer();
		}
		
		else // ch is a constructor
			return (FlowDiagram) ch.eContainer();
		
	}

	/**
	 * return the parent child of a leaf constructor
	 * @param ch
	 * @return
	 */
	public static Child getParentChild(Child ch){

		if (ch.eContainer() instanceof FlowDiagram)
			return ch;

		else // ch is a leaf constructor
		return (Child) ch.eContainer();

	}
	
	/**
	 * Returns the Initialisation event of a given machine (n
	 * @param m
	 * @return
	 */
	public static Event getInitialisationEvent(Machine m){
		for(Event e : m.getEvents()){
			if(e.getName().equals(Strings.INIT))
				return e;
		}
		return null;
	}
	
	/**
	 * return a set containing the non-loop predecessor child as first item and the list of its parameters as second item
	 * @param ch
	 * @param parList
	 * @param sw
	 * @return
	 */
	public static List<Object> predecessor(Child ch, List<TypedParameterExpression> parList, boolean sw){
		FlowDiagram parent = getParentFlow(ch);
		List<Child> sibiling = parent.getRefine();
		int i = sibiling.indexOf(getParentChild(ch));
		
		if(i > 0){
			Child prev = sibiling.get(i-1);
			if(!((prev instanceof Loop) || (prev instanceof Par))){
				List<Object> list = new ArrayList<Object>();
				list.add(prev);
				list.add(parent.getParameters());
				return list;
			}
			else{
				return predecessor(prev, parList, sw);
			}
		}
		else{
			if(!sw)
				return null;
			else{
				if(isAbstractFlow(parent)){
					return null;
				}
				else{
					if ((parent instanceof All) || (parent instanceof Some) || (parent instanceof One)){
						ArrayList<TypedParameterExpression> noNewPar = new ArrayList<TypedParameterExpression>();
						if(parent instanceof All){
							All allParent = (All) parent;
							for(TypedParameterExpression p : parList){
								if(!p.equals(allParent.getNewParameter()))
									noNewPar.add(p);
							}						
						}
						else if(parent instanceof Some){
							Some someParent = (Some) parent;
							for(TypedParameterExpression p : parList){
								if(!p.equals(someParent.getNewParameter()))
									noNewPar.add(p);
							}
						}
						else if(parent instanceof One){
							One oneParent = (One) parent;
							for(TypedParameterExpression p : parList){
								if(!p.equals(oneParent.getNewParameter()))
									noNewPar.add(p);
							}
						}						
						return predecessor((Child)parent.eContainer(), noNewPar, sw);
					}
					else{
						return predecessor((Child)parent.eContainer(), parList, sw);
					}
				}			
			}
		}		
	}
	
	public static boolean isAbstractFlow(FlowDiagram flow){
		for(Child ch : flow.getRefine()){
			if(ch.isRef())
				return false;
		}
		return true;
	}

	
	/**
	 * Returns string representation of a sequence of strings, separated by separator.
	 * @param inStr
	 * @param separator
	 * @return
	 */
	public static String toString(List<String> inStr, String separator){
		String ret = "";
		for(int i = 0 ; i < inStr.size() ; i++){
			ret += inStr.get(i);
			if (i != inStr.size() -1 ) ret += separator;
		}
		return ret;
	}
	
	/**
	 * Return cartesian product of the parameter types
	 * @param parList
	 * @return
	 */
	public static String getParTypeCartesian(List<TypedParameterExpression> parList){
		List<String> partTypes = new ArrayList<String>();
		
		//return cartesian product of the parameter types
		for(TypedParameterExpression tp : parList){
			partTypes.add(tp.getType());
		}
		
		return toString(partTypes, Strings.B_CPROD);
	}

	
	
	public static String parenthesize(String s){
		return Strings.B_LPAR + s + Strings.B_RPAR;
	}
	
	
	
	public static ArrayList<String> build_seq_inv(Child pred, List<TypedParameterExpression> predParList,
			Leaf l, List<TypedParameterExpression> parList) {
		//List<String> ret = new ArrayList<String>();
		
		//Leaf
		if(pred instanceof Leaf && ((Leaf) pred).getDecompose().isEmpty())
			return seq_inv((Leaf)pred, predParList, l, parList);
		//And
		else if(pred instanceof And){
			ArrayList<ArrayList<String>> invSet =  new ArrayList<ArrayList<String>>();
			for(Child ch : ((And) pred).getAndLink())
				invSet.add(build_seq_inv(ch, predParList, l, parList));
			
			ArrayList<String> t = merg_and_inv(invSet);
			String e = (String) t.get(2);
			t.remove(e);
			t.add(parenthesize(e));
			return t;
		}
		//Or
		else if(pred instanceof Or){
			ArrayList<ArrayList<String>> invSet =  new ArrayList<ArrayList<String>>();
			for(Child ch : ((Or) pred).getOrLink())
				invSet.add(build_seq_inv(ch, predParList, l, parList));
			
			ArrayList<String> t = merg_or_inv(invSet);
			String e = t.get(2);
			t.remove(e);
			t.add(parenthesize(e));
			return t;
		}
		//Xor
		else if(pred instanceof Xor){
			ArrayList<ArrayList<String>> invSet =  new ArrayList<ArrayList<String>>();
			for(Child ch : ((Xor) pred).getXorLink())
				invSet.add(build_seq_inv(ch, predParList, l, parList));
			
			ArrayList<String> t = merg_or_inv(invSet);
			String e = t.get(2);
			t.remove(e);
			t.add(parenthesize(e));
			return t;
		}
		
		else if(pred instanceof All){
			ArrayList<TypedParameterExpression> parSet =  new ArrayList<TypedParameterExpression>();
			parSet.addAll(predParList);
			parSet.add(((All) pred).getNewParameter());
			return build_seq_inv(((All) pred).getAllLink(), parSet, l, parList);
		}
		else if(pred instanceof Some){
			ArrayList<TypedParameterExpression> parSet =  new ArrayList<TypedParameterExpression>();
			parSet.addAll(predParList);
			parSet.add(((Some) pred).getNewParameter());
			return build_seq_inv(((Some) pred).getSomeLink(), parSet, l, parList);
		}
		else if(pred instanceof One){
			ArrayList<TypedParameterExpression> parSet =  new ArrayList<TypedParameterExpression>();
			parSet.addAll(predParList);
			parSet.add(((One) pred).getNewParameter());
			return build_seq_inv(((One) pred).getOneLink(), parSet, l, parList);
		}
		else if(pred instanceof Leaf && !( ((Leaf)pred).getDecompose().isEmpty())){
			ArrayList<ArrayList<String>> invSet =  new ArrayList<ArrayList<String>>();
			for(FlowDiagram flw : ((Leaf)pred).getDecompose())
				if(flw.isSw()){
					invSet.add(build_seq_inv(flw.getRefine().get(flw.getRefine().size() -1 ), predParList, l, parList)); 
					// what if previous flow has loop or par-rep
					// now leave the restriction that a loop and par-rep can not be first or last child of flowdiagram
					/*int index = flw.getRefine().size() -1 ;
					while(flw.getRefine().get(index) instanceof Par || flw.getRefine().get(index) instanceof Loop){
						if(index > 0)
							index--;
						else
							flw = predecessor(flw.getRefine().get(index), flw.getParameters(), flw.isSw()).;
					}*/
				}
					
				else{
					Child refTrue = null;
					for(Child ch : flw.getRefine())
						if(ch.isRef()){
							refTrue  = ch;
							break;
						}
					invSet.add(build_seq_inv(refTrue, predParList, l, parList));
				}
					
			return merg_or_inv(invSet);
		}
		
		
		
		
		return null;
	}

	public static ArrayList<String> seq_inv(Leaf e1,
			List<TypedParameterExpression> parList1, Leaf e2,
			List<TypedParameterExpression> parList2) {
		
		ArrayList<String> result = new ArrayList<String>();
		int n = parList1.size();
		int m = parList2.size();
		
		//1
		if(n == 0 && m == 0){
			result.add("1");
			System.out.println(1);
			result.add(e2.getName() + Strings.B_EQ + Strings.B_TRUE);
			result.add(e1.getName() + Strings.B_EQ + Strings.B_TRUE);
		}
		//2
		else if(n == 0 && m != 0){
			result.add("2");
			System.out.println(2);
			result.add(e2.getName() + Strings.B_NEQ + Strings.B_EMPTYSET);
			result.add(e1.getName() + Strings.B_EQ + Strings.B_TRUE);
			
		}
		//3
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0 , n-1).size() == 0){
			result.add("3");
			System.out.println(3);
			result.add(e2.getName() + Strings.B_EQ + Strings.B_TRUE);
			result.add(e1.getName() + Strings.B_NEQ + Strings.B_EMPTYSET);
		}
		//4
	else if(n != 0 && m == 0 && allReplicatorPar(e1, 0, n-1).size() != 0){
			result.add("4");
			System.out.println(4);
			ArrayList<String> expressions = new ArrayList<String>();
			for(Integer k : allReplicatorPar(e1, 0, n-1)){
				if(parList1.get(k).getInputExpression().isEmpty())
					expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getType());
				else
					expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getInputExpression());
			}
			
			result.add(e2.getName() + Strings.B_EQ + Strings.B_TRUE);
			result.add(toString(expressions, Strings.B_AND));
		}
		//5
		else if(n != 0 && m != 0 && commonPar(e1, e2) == 0 && allReplicatorPar(e1, 0, n-1).size() == 0){
			result.add("5");
			System.out.println(5);
			result.add(e2.getName() + Strings.B_NEQ + Strings.B_EMPTYSET);
			result.add(e1.getName() + Strings.B_NEQ + Strings.B_EMPTYSET);
			
		}
		//6, 7
		else if(n != 0 && m != 0 && commonPar(e1, e2) == 0 && allReplicatorPar(e1, 0, n-1).size() != 0){
			boolean bool = false;
			// no same par
			for(Integer i : allReplicatorPar(e1, 0, n-1)){
				if(samePar(parList1.get(i).getType(), parList2) != -1){ //Dana: it was 0 but fixed because indexing now starts from 0
					bool = true;
					break;		
				}
			}
			//6
			if(!bool){
				result.add("6");
				System.out.println(6);
				ArrayList<String> expressions = new ArrayList<String>();
				for(Integer k : allReplicatorPar(e1, 0, n-1)){
					if(parList1.get(k).getInputExpression().isEmpty())
						expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getType());
					else
						expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getInputExpression());
				}
				result.add(e2.getName() + Strings.B_NEQ + Strings.B_EMPTYSET);
				result.add(toString(expressions, Strings.B_AND));
				
			}
			else{
				result.add("7");
				System.out.println(7);
				//FIXME the first addition would cause an error if implemented as in previous version. get(0).toString() added, but not sure if right
				/*result.add(getDomainRangeStr( e2.getName(), samePar( allReplicatorPar(e1, 0, n-1).get(0).toString(), parList2 ), m));
				result.add(getDomainRangeStr(e1.getName(), allReplicatorPar(e1, 0, n-1).get(0), n ));*/
				 
				//-----------------------------------------------------------------------------------------------------
				 //Fixed By Dana
				Integer allp = allReplicatorPar(e1, 0, n-1).get(0);
			      String p1Type = parList1.get(allp).getType();
				  Integer sp = samePar(p1Type, parList2);
				 
				  String domRange_e2 = getDomainRangeStr(e2.getName(), sp, m);
				  result.add(domRange_e2);
				  String domRange_e1 = getDomainRangeStr(e1.getName(), allp, n);
				  result.add(domRange_e1);
				//-----------------------------------------------------------------------------------------------------
				
			}
		}
		//8
		//else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, 0, n-1).size() == 0){
		else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, commonPar(e1, e2), n-1).size() == 0){//fixed by Dana
			result.add("8");
			result.add(getDomainStr(e2.getName(), commonPar(e1, e2), m));
			result.add(getDomainStr(e1.getName(), commonPar(e1, e2), n));
		}
		//9
		else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, commonPar(e1, e2), n-1).size() != 0){
			result.add("9");
			System.out.println(9);
			Integer commonPar = commonPar(e1, e2);
			
			String str = "" + Strings.B_FORALL;
			ArrayList<String> expressions = new ArrayList<String>();
			if(commonPar > 0){
				for(int i = 0 ; i < commonPar ; i++){
					expressions.add(parList2.get(i).getName());
				}
			}
			str = str.concat(toString(expressions, Strings.B_COM) + Strings.B_MIDDOT);
			
			expressions.clear();
			
			if(commonPar > 0){
				for(int i = 0 ; i < commonPar ; i++){
					expressions.add(parList2.get(i).getName());
				}
			}
			str = str.concat(toString(expressions, Strings.B_MAPLET) + Strings.B_IN + Utils.getDomainStr(e2.getName(), 0, m - commonPar));
			
			/***/
			result.add(str);
			/***/
			
			
			
			expressions.clear();
			
			for(Integer j : allReplicatorPar(e1, commonPar, n-1)){
				str = "";
				str = str.concat(getDomainStr(e1.getName(), j+1, n) + Strings.B_LSQBRC + Strings.B_LBRC);
				
				ArrayList<String> expressions2 = new ArrayList<String>();
				for(int i = 0 ; i < j ; i++){
					expressions2.add(parList1.get(i).getName());
				}
				str = str.concat(toString(expressions2, Strings.B_MAPLET));
				
				if(parList1.get(j).getInputExpression().isEmpty())
					str = str.concat(Strings.B_RBRC + Strings.B_RSQBRC + Strings.B_EQ + parList1.get(j).getType());
				else
					str = str.concat(Strings.B_RBRC + Strings.B_RSQBRC + Strings.B_EQ + parList1.get(j).getInputExpression());
				expressions.add(str);
			}
			
			result.add(toString(expressions, Strings.B_AND));		
			
		}
		return result;
	}
	
	public static List<Integer> allReplicatorPar(Leaf e, Integer low, Integer up){
		List<Integer> ret = new ArrayList<Integer>();
		EObject node = e;
		Integer counter = up;
		
		while(!(node.eContainer() instanceof Machine) && counter >= low){
			if(node.eContainer() instanceof All){
				ret.add(counter);
				counter--;
			}
			else if( (node.eContainer() instanceof Some) || (node.eContainer() instanceof One)){
				//counter++;
				counter--; //fixed by Dana
			}
			node = node.eContainer();
		}
		return ret;
	}
	
	// X, Y, Z
	public static String getDomainStr(String eveName, Integer index, Integer n){
		String str = "";
		if(n > index){
			for(int i = 1 ; i <= n-index ; i++)
				str = str.concat(Strings.B_DOM + Strings.B_LPAR);
		}
		str = str.concat(eveName);
		
		if(n > index){
			for(int i = 1 ; i <= n-index ; i++)
				str = str.concat(Strings.B_RPAR);
		}
		
		return str;
		
	}
	
	// W, K
	public static String getDomainRangeStr(String eveName, Integer index, Integer n){
		String str = "";
		if(index == 0 && n-1 > 1){
			for(int i = 1 ; i < n ; i++){
				str = str.concat(Strings.B_DOM + Strings.B_LPAR);
			}
			
			str = str.concat(eveName);
			
			for(int i = 1 ; i < n ; i++){
				str = str.concat(Strings.B_RPAR);
			}
			return str;
		}
		//--index  > 0
		//else if (n-index > 1)
		else if(n-index >= 1 && index != 0){ //changed by Dana
			str = str.concat(Strings.B_RAN + Strings.B_LPAR);
			
			
			//if(n > index){
			if(n-index > 1){ // changed by Dana
				for(int i = 1 ; i <= n-index ; i++)
					str = str.concat(Strings.B_DOM + Strings.B_LPAR);
			}
			str = str.concat(eveName);
			
			//if(n > index){
		    if(n-index > 1){ // changed by Dana
				for(int i = 1 ; i <= n-index ; i++)
					str = str.concat(Strings.B_RPAR);
			}
			
			str = str.concat(Strings.B_RPAR);
			return str;
		}
		else 
			return eveName;
		
	}
	
	public static Integer commonPar(Leaf e1, Leaf e2){
		EObject node1 = e1;
		EObject node2 = e2;
		
		while(! (node1 instanceof Machine)){
			//XXX Cast to child may be dodgy
			FlowDiagram flw1 = getParentFlow((Child) node1);
			while(!(node2 instanceof Machine)){
				FlowDiagram flw2 = getParentFlow((Child) node2);
				if(flw2.equals(flw1))
					return flw2.getParameters().size();
				node2 = flw2.eContainer();
			}
			node2 = e2;
			node1 = flw1.eContainer();
		}
		
		return 0;
	}
	
	public static Integer samePar(String type, List<TypedParameterExpression> parList){
		for(TypedParameterExpression tp : parList){
			if(tp.getType().equals(type))
				return parList.indexOf(tp);// Dana what if the index was 0??
		}
		
		//return 0;
		return -1; //Dana: Fixed in case the same parameter has index 0
	}
	
	public static ArrayList<String> merg_and_inv(ArrayList<ArrayList<String>> invSet){
		//ArrayList<String> firstEle = new ArrayList<String>();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> mergeResult = new ArrayList<String>();

		for(int i = 0 ; i < invSet.size() ; i++){
			ArrayList<String> sameMerge = new ArrayList<String>();

			if(invSet.get(i).size() == 3 && invSet.size() > 0){
				sameMerge.add(invSet.get(i).get(0));
				sameMerge.add(invSet.get(i).get(1));
				sameMerge.add(invSet.get(i).get(2));
				invSet.get(i).add("false");

				if(invSet.size() > 1){
					
					for(int j = i+1 ; j < invSet.size() ; j++){ // fixed by Dana it was i < and i++ 
						
						List<String> element = invSet.get(j);
						if(element.size() < 4 && element.get(0) == invSet.get(i).get(0)){ //Dana changed from >= 3 to <4
					
							String s = sameMerge.get(2);
							sameMerge.remove(s); //added by Dana
							
							if(element.get(0).equals("7") || element.get(0).equals("8")){
								s = s.concat(Strings.B_INTER); 
							}
							else{
								s = s.concat(Strings.B_AND); 
							}
							s = s.concat(element.get(2));
							sameMerge.add(s);

							invSet.get(j).add("false");
						}

					}
				}
				result.add(sameMerge);
			}
		}
		if(result.size() > 1){
			System.out.println("merg_and_inv: (result.size() > 1)");
			if(result.get(0).get(0).equals("3") || result.get(0).get(0).equals("4")){
				mergeResult.add("3");
				mergeResult.add(result.get(0).get(1));
				mergeResult.add(result.get(0).get(2) + Strings.B_AND + result.get(1).get(2));

			}
			else if(result.get(0).get(0).equals("5") || result.get(0).get(0).equals("6") || result.get(0).get(0).equals("7")){
				mergeResult.add("5");
				mergeResult.add("");
				mergeResult.add("");

				ArrayList<ArrayList<String>> first5or6 = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> first7 = new ArrayList<ArrayList<String>>();

				for(ArrayList<String> i : result){
					if(i.get(0).equals("5") || i.get(0).equals("6"))
						first5or6.add(i);
					else if (i.get(0).equals("7") )
						first7.add(i);
				}

				for(ArrayList<String> i : first5or6){
					mergeResult.set(1, mergeResult.get(1).concat(i.get(1)));
					mergeResult.set(2, mergeResult.get(2).concat(Strings.B_AND + i.get(2)));
				}
				//FIXME Different from old implementation!!! Needs checking
				for(ArrayList<String> i : first7){
					mergeResult.set(2, mergeResult.get(2).concat( Strings.B_AND + i.get(2)));
				//if(!first7.isEmpty())
					//mergeResult.set(2, )
					
				}


			}
			else if(result.get(0).get(0).equals("8") || result.get(0).get(0).equals("9")){
				//XXX NEEDS TESTING!
				List<String> l = null;
				List<String> l2 = null;
				
				for(ArrayList<String> il : result){
					if(il.get(0).equals("9"))
						l = il;
					else if(il.get(0).equals("8"))
						l2 = il;
				}
			
				
				String[] split = l.get(2).split(Strings.B_IN);
				mergeResult.add("9");
				mergeResult.set(1, l.get(1));
				mergeResult.set(2, l.get(2) + Strings.B_AND + split[0] + Strings.B_IN + l2.get(2));
				
			}
		}
		else 
			return result.get(0);
		
		return  mergeResult;
	
			
		
	}
	
	
	public static ArrayList<String> merg_or_inv(ArrayList<ArrayList<String>> invSet){
		//ArrayList<String> firstEle = new ArrayList<String>();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> mergeResult = new ArrayList<String>();
		boolean bool = false; 

		for(int i = 0 ; i < invSet.size() ; i++){
			ArrayList<String> sameMerge = new ArrayList<String>();

			if(invSet.get(i).size() == 3 && invSet.size() > 0){
				sameMerge.add(invSet.get(i).get(0));
				sameMerge.add(invSet.get(i).get(1));
				sameMerge.add(invSet.get(i).get(2));
				invSet.get(i).add("false");

				if(invSet.size() > 1){
					for(int j = i+1 ; j < invSet.size() ; j++){ //Fixed by Dana change i to j
						List<String> element = invSet.get(j);
						if(element.size() < 4 && element.get(0) == invSet.get(i).get(0)){//fixed by dana <4
							String s = sameMerge.get(2);
							sameMerge.remove(s);
							if(element.get(0).equals("7") || element.get(0).equals("8")){
								s = s.concat(Strings.B_UNION);
								s = s.concat(element.get(2));
								
							}
						//--------------------------------------------------------------------------------------
							
							//Trial by Dana
							//Still needs to handle the case if they are not equal
							else if(element.get(0).equals("4") || element.get(0).equals("6")|| element.get(0).equals("9")){
								String str = "";
								if (s.startsWith(Strings.B_LPAR))
									str = s.substring(1, s.indexOf(Strings.B_RPAR));
								else
									str = s;
								
								String[] s1 = str.split("=");
								String [] s2 = element.get(2).split("=");
								if(s1[1].trim().equals(s2[1].trim()))
									s = s1[0].concat(Strings.B_UNION + s2[0].trim() + Strings.B_EQ + s1[1].trim());
								else
									bool = true;
										
							}
						
					   //----------------------------------------------------------------------------------------
							//else{
							//Dana
							else if(element.get(0).equals("1")|| element.get(0).equals("2")|| element.get(0).equals("3")|| element.get(0).equals("5")|| (element.get(0).equals("4") && bool ==true)|| (element.get(0).equals("6") && bool ==true)||(element.get(0).equals("9") && bool ==true)){
								s = s.concat(Strings.B_OR);
								s = s.concat(element.get(2));
							}
							//s = s.concat(element.get(2)); //Dana moved in the if else to do trial
							sameMerge.add(s);

							invSet.get(j).add("false");
						}

					}
				}
				result.add(sameMerge);
			}
		}
		
		if(result.size() > 1){
			if(result.get(0).get(0).equals("3") || result.get(0).get(0).equals("4")){
				mergeResult.add("3");
				mergeResult.add(result.get(0).get(1));
				mergeResult.add(result.get(0).get(2) + Strings.B_OR + result.get(1).get(2));

			}
			else if(result.get(0).get(0).equals("5") || result.get(0).get(0).equals("6") || result.get(0).get(0).equals("7")){
				mergeResult.add("5");
				mergeResult.add("");
				mergeResult.add("");

				ArrayList<ArrayList<String>> first5or6 = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> first7 = new ArrayList<ArrayList<String>>();

				for(ArrayList<String> i : result){
					if(i.get(0).equals("5") || i.get(0).equals("6"))
						first5or6.add(i);
					else if (i.get(0).equals("7") )
						first7.add(i);
				}

				for(ArrayList<String> i : first5or6){
					mergeResult.set(1, mergeResult.get(1).concat(i.get(1)));
					mergeResult.set(2, mergeResult.get(2).concat( Strings.B_OR + i.get(2)));
				}
				//FIXME Different from old implementation!!! Needs checking
				for(ArrayList<String> i : first7){
					mergeResult.set(2,mergeResult.get(2).concat( Strings.B_OR + i.get(2)));
				}


			}
			else if(result.get(0).get(0).equals("8") || result.get(0).get(0).equals("9")){
				//XXX TEST THIS!
				System.out.println("IAM HERE");
				List<String> l = null;
				List<String> l2 = null;
				
				for(ArrayList<String> il : result){
					if(il.get(0).equals("9"))
						l = il;
					else if(il.get(0).equals("8"))
						l2 = il;
				}
			
				
				String[] split = l.get(2).split(Strings.B_IN);
				mergeResult.add("9");
				mergeResult.set(1, l.get(1));
				mergeResult.set(2, l.get(2) + Strings.B_OR + split[0] + Strings.B_IN + l2.get(2));
			}
		}
		else 
			return result.get(0);
		
		return  mergeResult;
	
			
		
	}
	
	public static String build_seq_inv_string(ArrayList<String> inv){
		if(inv.get(0).equals("1") || inv.get(0).equals("2") || inv.get(0).equals("3") || inv.get(0).equals("4") || inv.get(0).equals("5") || inv.get(0).equals("6") ||inv.get(0).equals("9")){
			return (inv.get(1) + Strings.B_IMPL + inv.get(2));
		}
		else if (inv.get(0).equals("7") || inv.get(0).equals("8")){
			return inv.get(1) + Strings.B_SUBSETEQ + inv.get(2);
		}
		else{
			return inv.get(0) + " NOT SUPPORTED";
		}
	}
	
	public static String build_seq_grd(Child pred, List<TypedParameterExpression> predParList, Leaf l, List<TypedParameterExpression> parList, boolean loop){
		if(pred instanceof Leaf && ((Leaf) pred).getDecompose().isEmpty())
			return seq_grd((Leaf) pred, predParList, l, parList);
		// And
		else if(pred instanceof And){
			List<String> expressions =  new ArrayList<String>();
			for(Child ch : ((And) pred).getAndLink()){
				expressions.add(build_seq_grd(ch, predParList, l, parList, false));
			}
			return Utils.parenthesize(Utils.toString(expressions, Strings.B_AND));
		}
		else if(pred instanceof Or){
			List<String> expressions =  new ArrayList<String>();
			for(Child ch : ((Or) pred).getOrLink()){
				expressions.add(build_seq_grd(ch, predParList, l, parList, false));
			}
			// Changed by Dana
			if(predParList.isEmpty())
				return Utils.parenthesize(Utils.toString(expressions, Strings.B_OR));
			else
				return Utils.merge_or_grd(expressions);
		}
		else if(pred instanceof Xor){
			List<String> expressions =  new ArrayList<String>();
			for(Child ch : ((Xor) pred).getXorLink()){
				expressions.add(build_seq_grd(ch, predParList, l, parList, false));
			}
		   
			// Changed by Dana
			if(predParList.isEmpty())
				return Utils.parenthesize(Utils.toString(expressions, Strings.B_OR));
			else
				return Utils.merge_or_grd(expressions);
		}
		else if(pred instanceof All){
			List<TypedParameterExpression> parSet = new ArrayList<TypedParameterExpression>();
			parSet.addAll(predParList); //fixed by Dana, it was parList
			parSet.add(((All) pred).getNewParameter());
			return build_seq_grd(((All) pred).getAllLink(), parSet, l, parList, false);
		}
		else if(pred instanceof Some){
			List<TypedParameterExpression> parSet = new ArrayList<TypedParameterExpression>();
			parSet.addAll(predParList);//fixed by Dana, it was parList
			parSet.add(((Some) pred).getNewParameter());
			return build_seq_grd(((Some) pred).getSomeLink(), parSet, l, parList, false);
		}
		else if(pred instanceof One){
			List<TypedParameterExpression> parSet = new ArrayList<TypedParameterExpression>();
			parSet.addAll(predParList);//fixed by Dana, it was parList
			parSet.add(((One) pred).getNewParameter());
			return build_seq_grd(((One) pred).getOneLink(), parSet, l, parList, false);
		}
		//1*flow
		else if(pred instanceof Leaf && ((Leaf)pred).getDecompose().size() > 0){
			List<String> expressions = new ArrayList<String>();
			for(FlowDiagram flw : ((Leaf)pred).getDecompose()){
				if(flw.isSw() || loop)
					expressions.add(build_seq_grd(flw.getRefine().get(flw.getRefine().size() - 1), predParList, l, parList, loop));
				else{
					for(Child ch : flw.getRefine())
						if(ch.isRef()){
							expressions.add(build_seq_grd(ch, predParList, l, parList, false));
						}					
				}	
			}
			return toString(expressions, Strings.B_OR);
		}
		return null;
	}
	
	public static String seq_grd(Leaf e1, List<TypedParameterExpression> parList1, Leaf e2, List<TypedParameterExpression> parList2){
		int n = parList1.size();
		int m = parList2.size();

		// 1 & 2
		if(n == 0)
			return e1.getName() + Strings.B_EQ + Strings.B_TRUE;
		//3
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0, n-1).size() == 0)
			return e1.getName() + Strings.B_NEQ + Strings.B_EMPTYSET;
		//4
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0, n-1).size() != 0){
			List<String> expressions = new ArrayList<String>();
			for(Integer k : allReplicatorPar(e1, 0, n-1))
				if(parList1.get(k).getInputExpression().isEmpty())
					expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getType());
				else
					expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getInputExpression());
			return toString(expressions, Strings.B_AND);
		}
		//5
		else if(n != 0 && m != 0 && commonPar(e1, e2) == 0 && allReplicatorPar(e1, 0, n-1).size() == 0)
			return e1.getName() + Strings.B_NEQ + Strings.B_EMPTYSET;
		//6 & 7
		else if(n != 0 && m != 0 && commonPar(e1,e2) == 0 && allReplicatorPar(e1, 0, n-1).size() != 0){
			boolean bool = false;

			for(Integer i : allReplicatorPar(e1, 0, n-1)){
				if(samePar(parList1.get(i).getType(), parList2) != -1){ //Dana: it was 0
					bool = true;
					break;
				}
			}
            //6
			
			//----------------------------------------------------------------------------
			// Dana, case 7 is not as strong as expected, it should be a combination
			// of case 6 and 7
			//----------------------------------------------------------------------------
			if(!bool){
				List<String> expressions = new ArrayList<String>();
				for(Integer k : allReplicatorPar(e1, 0, n-1))
					if(parList1.get(k).getInputExpression().isEmpty())
						expressions.add(getDomainRangeStr(e1.getName(), k, n) +  Strings.B_EQ + parList1.get(k).getType());
					else
						expressions.add(getDomainRangeStr(e1.getName(), k, n) +  Strings.B_EQ + parList1.get(k).getInputExpression());
				return toString(expressions, Strings.B_AND);
			}
			//7
			else{
				//				List<String> expressions = new ArrayList<String>();
				//				int i = 0;
				//				for(Integer l : samePar(allReplicatorPar(e1, 0, n-1), e2)){
				//					expressions.add( getDomainRangeStr(e2.getName(), l) +  Strings.B_SUBSETEQ + getDomainRangeStr(e1.getName(), allReplicatorPar(e1, 0, n-1).get(i)));
				//				}
				//				String str = toString(expressions, Strings.B_AND);
				//FIXME the first addition would cause an error if implemented as in previous version. get(0).toString() added, but not sure if right
				
				//----------------------------------------------------------------------------------
				 // Fixed by Dana 
				
			      Integer allp = allReplicatorPar(e1, 0, n-1).get(0);
			      String p1Type = parList1.get(allp).getType();
				  Integer sp = samePar(p1Type, parList2);
				  String p2 = parList2.get(sp).getName();
				  String domRange = getDomainRangeStr(e1.getName(), allp, n);
				  String s = p2 + Strings.B_IN + domRange;
				  return s;
				  
				
				//----------------------------------------------------------------------------------
				
				/*return ( parList2.get(samePar(allReplicatorPar(e1, 0, n-1).get(0).toString(), parList2)).getName() + Strings.B_IN + 
						getDomainRangeStr(e1.getName(), allReplicatorPar(e1, 0, n-1).get(0), n) );*/
			}
		}
		//8
		//else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, 0, n-1).size() == 0){
		else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, commonPar(e1, e2), n-1).size() == 0){//fixed by Dana
			String str = "";
			if(commonPar(e1, e2) > 0){
				List<String> expressions = new ArrayList<String>();
				for(int i = 0 ; i < commonPar(e1, e2) ; i++){
					expressions.add(parList2.get(i).getName());
				}
				str = toString(expressions, Strings.B_MAPLET);
			}
			return str + Strings.B_IN + getDomainStr(e1.getName(), commonPar(e1, e2), n);
		}
		//9
		else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, commonPar(e1, e2), n-1).size() != 0){
			int commonPar = commonPar(e1, e2);
			List<String> expressions = new ArrayList<String>();

			for(Integer j : allReplicatorPar(e1, commonPar, n-1)){
				String str =  getDomainStr(e1.getName(), j+1, n) +  Strings.B_LSQBRC + Strings.B_LBRC;

				List<String> expressions2 = new ArrayList<String>();
				for(int i = 0 ; i < j ; i++){
					expressions2.add(parList1.get(i).getName());
				}
				str = str.concat(toString(expressions2, Strings.B_MAPLET));

				if(parList1.get(j).getInputExpression().isEmpty())
					str = str.concat( Strings.B_RBRC + Strings.B_RSQBRC+ Strings.B_EQ + parList1.get(j).getType());
				else
					str = str.concat( Strings.B_RBRC + Strings.B_RSQBRC+ Strings.B_EQ + parList1.get(j).getInputExpression());

				expressions.add(str);

			}

			return toString(expressions, Strings.B_AND);
		}
		else
			return null;

	}
	
	public static String getParMaplet(List<TypedParameterExpression> parList){
		List<String> expression = new ArrayList<String>();
		for(TypedParameterExpression tp : parList){
			expression.add(tp.getName());
		}
		
		return toString(expression, Strings.B_MAPLET);
		
	}

	//Dana: Check if ancestor is a replicator, this function will find the first child of sw
	// and refining child if !sw
	public static List<Child> repAncestor(Leaf sourceLeaf) {
		List<Child> result = new ArrayList<Child>();
		Child node = sourceLeaf;
		
		while(true){
			if(node.eContainer() instanceof One || node.eContainer() instanceof All || node.eContainer() instanceof Some || node.eContainer() instanceof Par){// Dana added Par
				result.add((Child) node.eContainer());
			}
			FlowDiagram parentFlow = getParentFlow(node);
			Child parentChild = getParentChild(node);
			if((parentFlow.isSw() && parentChild == parentFlow.getRefine().get(0)) || 
					(!parentFlow.isSw() && parentChild.isRef()))
				if(parentFlow.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parentFlow.eContainer();
			else
				break;
		}
		return result;
	}
	//Dana: Check if ancestor is a replicator, this will check the first child whether sw or !sw
	public static List<Child> repAncestorFirstChild(Leaf sourceLeaf) {
		List<Child> result = new ArrayList<Child>();
		Child node = sourceLeaf;
		
		while(true){
			if(node.eContainer() instanceof One || node.eContainer() instanceof All || node.eContainer() instanceof Some || node.eContainer() instanceof Par){// Dana added Par
				result.add((Child) node.eContainer());
			}
			FlowDiagram parentFlow = getParentFlow(node);
			Child parentChild = getParentChild(node);
			if(parentChild == parentFlow.getRefine().get(0))
				if(parentFlow.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parentFlow.eContainer();
			else
				break;
		}
		return result;
	}
	public static String getInvXorGluName(Xor sourceXor, List<GenerationDescriptor> generatedElements) {
		int max = 0;
		
		List<Invariant> allInvariants = new ArrayList<Invariant>();
		for(GenerationDescriptor gd : generatedElements){
			if(gd.feature.equals(MachinePackage.Literals.MACHINE__INVARIANTS))
				allInvariants.add((Invariant)gd.value);
		}
	
		for(Invariant i :allInvariants){
			int temp;
			if(i.getName().endsWith(Strings.XOR+Strings._GLU +  Utils.getRootFlowDiagramName(sourceXor)) && max < (temp = Integer.parseInt(i.getName().split("_")[0].substring(3))))
				max = temp;
		}
		
		
		return Strings.INV + (max + 1) + Strings._XOR + Strings._GLU + Utils.getRootFlowDiagramName(sourceXor);
	}

	public static String getInvXorName(Xor sourceXor, List<GenerationDescriptor> generatedElements) {
		int max = 0;

		List<Invariant> allInvariants = new ArrayList<Invariant>();
		for(GenerationDescriptor gd : generatedElements){
			if(gd.feature.equals(MachinePackage.Literals.MACHINE__INVARIANTS))
				allInvariants.add((Invariant)gd.value);
		}
		
		for(Invariant i :allInvariants){
			int temp;
			if(i.getName().endsWith(Strings.XOR + Utils.getRootFlowDiagramName(sourceXor)) && max < (temp = Integer.parseInt(i.getName().split("_")[0].substring(3))))
				max = temp;
		}
		
		
		return Strings.INV + (max+1) + Strings._XOR + Utils.getRootFlowDiagramName(sourceXor);
	}

	public static String disjunction_of_leaves(Child ch, int parNum) {
		if((ch instanceof Leaf) && ((Leaf)ch).getDecompose().isEmpty()){
			if(parNum == 0)
				return ((Leaf)ch).getName();
			else
				return ((Leaf)ch).getName() + Strings.B_NEQ + Strings.B_EMPTYSET;
						
		}
		else if(ch instanceof And){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((And) ch).getAndLink()){
				expressions.add(disjunction_of_leaves(ich, parNum));
			}
			return toString(expressions, Strings.B_OR);
		}
		else if(ch instanceof Or){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Or) ch).getOrLink()){
				expressions.add(disjunction_of_leaves(ich, parNum));
			}
			return toString(expressions, Strings.B_OR);
		}
		else if(ch instanceof Xor){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Xor) ch).getXorLink()){
				expressions.add(disjunction_of_leaves(ich, parNum));
			}
			return toString(expressions, Strings.B_OR);
		}
		else if(ch instanceof All)
			return disjunction_of_leaves(((All) ch).getAllLink(), parNum+1);
		else if(ch instanceof Some)
			return disjunction_of_leaves(((Some) ch).getSomeLink(), parNum+1);
		else if(ch instanceof One)
			return disjunction_of_leaves(((One) ch).getOneLink(), parNum+1);
		else if(ch instanceof Leaf && ((Leaf)ch).getDecompose().size() > 0){
			List<String> expressions = new ArrayList<String>();
			for(FlowDiagram flw : ((Leaf)ch).getDecompose()){
				//strong sequencing flow, select the first child
				if(flw.isSw())
					expressions.add(disjunction_of_leaves(flw.getRefine().get(0), parNum));
				//weak sequencing flow, select the solid child
				else{
					for(Child ich : flw.getRefine()){
						if(ich.isRef()){
							expressions.add(disjunction_of_leaves(ich, parNum));
							break;
						}
							
					}
				}		
			}
			
			return toString(expressions, Strings.B_OR);
		}
		return "ERROR: Should have not reached this situation";
	}

	
	
	
	public static String union_of_leaves(Child ch, int n) {
		if((ch instanceof Leaf) && ((Leaf)ch).getDecompose().isEmpty()){
			String str = ""; 
			if(n > 0){
				for(int i = 1 ; i <= n ; i++){
					str = str.concat(Strings.B_DOM + Strings.B_LPAR);
				}
				str = str.concat(((Leaf)ch).getName());
				for(int i = 1 ; i <= n ; i++){
					str = str.concat(Strings.B_RPAR);
				}
				
			}
			else
				str = str.concat(((Leaf)ch).getName());
			return str;
		}
		else if(ch instanceof And){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((And) ch).getAndLink()){
				expressions.add(union_of_leaves(ich, n)); // fixed by Dana it was disjunction
			}
			return toString(expressions, Strings.B_UNION);
		}
		else if(ch instanceof Or){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Or) ch).getOrLink()){
				expressions.add(union_of_leaves(ich, n));// fixed by Dana it was disjunction
			}
			return toString(expressions, Strings.B_UNION);
		}
		else if(ch instanceof Xor){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Xor) ch).getXorLink()){
				expressions.add(union_of_leaves(ich, n));// fixed by Dana it was disjunction
			}
			return toString(expressions, Strings.B_UNION);
		}
		else if(ch instanceof All)
			return union_of_leaves(((All) ch).getAllLink(), n+1);// fixed by Dana it was disjunction
		else if(ch instanceof Some)
			return union_of_leaves(((Some) ch).getSomeLink(), n+1);// fixed by Dana it was disjunction
		else if(ch instanceof One)
			return union_of_leaves(((One) ch).getOneLink(), n+1);// fixed by Dana it was disjunction
		else if(ch instanceof Par){ //Dana Newly added to allow par-rep tp be first child
			List<String> expressions = new ArrayList<String>();
			expressions.add(union_of_leaves(((Par) ch).getParLink(), n+1));
		    expressions.add(union_of_leaves((Child)successor(ch, n).get(0), n));
			
			return toString(expressions, Strings.B_UNION);
		}
		else if(ch instanceof Leaf && ((Leaf)ch).getDecompose().size() > 0){
			List<String> expressions = new ArrayList<String>();
			for(FlowDiagram flw : ((Leaf)ch).getDecompose()){
				//strong sequencing flow, select the first child
				if(flw.isSw())
					expressions.add(union_of_leaves(flw.getRefine().get(0), n));// fixed by Dana it was disjunction
				//weak sequencing flow, select the solid child
				else{
					for(Child ich : flw.getRefine()){
						if(ich.isRef()){
							expressions.add(union_of_leaves(ich, n));// fixed by Dana it was disjunction
							break;
						}
							
					}
				}		
			}
			
			return toString(expressions, Strings.B_UNION);
		}
		return "ERROR: Should have not reached this situation";

	}

	public static List<Xor> xorAncestors(Leaf l) {
		List<Xor> result = new ArrayList<Xor>();
		Child node = l;
		while(true){
			if(node.eContainer() instanceof Xor)
				result.add((Xor) node.eContainer());
			FlowDiagram parentFlow = getParentFlow(node);
			Child parentChild = getParentChild(node);
			if((parentFlow.isSw() && parentChild.equals(parentFlow.getRefine().get(0))) ||
					(!parentFlow.isSw() && parentChild.isRef()))
				if(parentFlow.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parentFlow.eContainer();
			else
				break;
		}
		return result;
	}

	public static Child xorAncestorChild(Xor x, Leaf l) {
		Child node = l;
		while(true){
			if(node.eContainer().equals(x))
				return node;
			else{
				FlowDiagram parentFlow = getParentFlow(node);
				if(parentFlow.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parentFlow.eContainer();
			}
		}
		return null;
	}
	/**
	 * The disjunction recursive call was replaced by conjunction
	 * return toString expressions is fixed to include only the B_AND
	 * Fixed by Dana
	 */
	public static String conjunction_of_leaves(Child ch, int parNum) {
		if((ch instanceof Leaf) && ((Leaf)ch).getDecompose().isEmpty()){
			if(parNum == 0)
				return ((Leaf)ch).getName() + Strings.B_EQ + Strings.B_FALSE;
			else
				return ((Leaf)ch).getName() + Strings.B_EQ + Strings.B_EMPTYSET; //fixed by Dana Changed B_NEQ to B_EQ
						
		}
		else if(ch instanceof And){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((And) ch).getAndLink()){
				expressions.add(conjunction_of_leaves(ich, parNum));
			}
			//return toString(expressions, Strings.B_EQ + Strings.B_FALSE + Strings.B_AND) + Strings.B_EQ + Strings.B_FALSE ;
			return toString(expressions, Strings.B_AND);
		}
		else if(ch instanceof Or){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Or) ch).getOrLink()){
				expressions.add(conjunction_of_leaves(ich, parNum));
			}
			//return toString(expressions, Strings.B_EQ + Strings.B_FALSE + Strings.B_AND) + Strings.B_EQ + Strings.B_FALSE ;
			return toString(expressions, Strings.B_AND);
		}
		else if(ch instanceof Xor){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Xor) ch).getXorLink()){
				expressions.add(conjunction_of_leaves(ich, parNum));
			}
			////return toString(expressions, Strings.B_EQ + Strings.B_FALSE + Strings.B_AND) + Strings.B_EQ + Strings.B_FALSE ;
			return toString(expressions, Strings.B_AND);
		}
		else if(ch instanceof All)
			return conjunction_of_leaves(((All) ch).getAllLink(), parNum+1);
		else if(ch instanceof Some)
			return conjunction_of_leaves(((Some) ch).getSomeLink(), parNum+1);
		else if(ch instanceof One)
			return conjunction_of_leaves(((One) ch).getOneLink(), parNum+1);
		else if(ch instanceof Par){ //Dana Newly added to allow par-rep tp be first child
			List<String> expressions = new ArrayList<String>();
			expressions.add(conjunction_of_leaves(((Par) ch).getParLink(), parNum+1));
		    expressions.add(conjunction_of_leaves((Child)successor(ch, parNum).get(0), parNum));
			
			return toString(expressions, Strings.B_AND);
		}
			
		else if(ch instanceof Leaf && ((Leaf)ch).getDecompose().size() > 0){
			List<String> expressions = new ArrayList<String>();
			for(FlowDiagram flw : ((Leaf)ch).getDecompose()){
				//strong sequencing flow, select the first child
				if(flw.isSw())
					expressions.add(conjunction_of_leaves(flw.getRefine().get(0), parNum));
				//weak sequencing flow, select the solid child
				else{
					for(Child ich : flw.getRefine()){
						if(ich.isRef()){
							expressions.add(conjunction_of_leaves(ich, parNum));
							break;
						}
							
					}
				}		
			}
			
			return toString(expressions,Strings.B_AND);
		}
		return "ERROR: Should have not reached this situation";
	}

	public static String getPrevOneGluInvName(EObject sourceElement, List<GenerationDescriptor> generatedElements) {
		int max = 0;
		
		List<Invariant> allInvariants = new ArrayList<Invariant>();
		for(GenerationDescriptor gd : generatedElements){
			if(gd.feature.equals(MachinePackage.Literals.MACHINE__INVARIANTS))
				allInvariants.add((Invariant)gd.value);
		}
		
		for(Invariant i :allInvariants){
			int temp;
			if(i.getName().matches(Strings.ONE + Strings._GLU + Utils.getRootFlowDiagramName(sourceElement)) && max < (temp = Integer.parseInt(i.getName().split("_")[0].substring(3))))
				max = temp;
		}
		
		
		return Strings.INV + (max + 1) + Strings.ONE + Strings._GLU + Utils.getRootFlowDiagramName(sourceElement);
	}

	public static List<One> oneAncestors(Leaf l) {
		List<One> result = new ArrayList<One>();
		Child node = l;
		while(true){
			if(node.eContainer() instanceof One)
				result.add((One) node.eContainer());
			FlowDiagram parentFlow = getParentFlow(node);
			Child parentChild = getParentChild(node);
			if((parentFlow.isSw() && parentChild.equals(parentFlow.getRefine().get(0))) ||
					(!parentFlow.isSw() && parentChild.isRef()))
				if(parentFlow.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parentFlow.eContainer();
			else
				break;
		}
		return result;
//		return (List<One>) getAncestorsAncestorsOfClass(l, One.class);
	}

	public static String getParList(List<TypedParameterExpression> parList) {
		List<String> parNames = new ArrayList<String>();
		for(TypedParameterExpression tp : parList)
			parNames.add(tp.getName());
			
		return toString(parNames, Strings.B_COM);
	}

	public static int getParNumAfterOnePar(Leaf l, One o) {
		int i = 0;
		Child node = l;
		while(true){
			Child p = getParentChild(node);
			if(p instanceof One && p.equals(o))
				break;
			if((p instanceof All) || (p instanceof Some) || (p instanceof One) || (p instanceof Par)) //Dana: changed to include par
				i++;
			
			FlowDiagram parentFlow = getParentFlow(node);
			if(parentFlow.eContainer() instanceof Machine)
				break;
			else
				node = (Child) parentFlow.eContainer();
		}
		return i;
	}

	public static int getPrevOneInvIndex(EObject sourceElement, List<GenerationDescriptor> generatedElements) {
		int max = 0;
		
		List<Invariant> allInvariants = new ArrayList<Invariant>();
		for(GenerationDescriptor gd : generatedElements){
			if(gd.feature.equals(MachinePackage.Literals.MACHINE__INVARIANTS))
				allInvariants.add((Invariant)gd.value);
		}
		
		for(Invariant i :allInvariants){
			int temp;
			if(i.getName().endsWith( Strings.UNDERSC + Strings._ONE + "_" + Utils.getRootFlowDiagramName(sourceElement)) && max < (temp = Integer.parseInt(i.getName().split("_")[0].substring(3))))
				max = temp;
		}
		
		
		return max;
	}

	
	
	// Dana: I updated removing the difference between weak seq and strong seq, so we get the first child in both cases
	public static List<? extends EventBElement> getAncestorsAncestorsOfClass(Leaf l, Class<? extends EventBElement> clazz) {
		List<EventBElement> result = new ArrayList<EventBElement>();
		Child node = l;
		
		while(true){
			if(clazz.isInstance(node.eContainer()))
				result.add(clazz.cast(node.eContainer()));
			FlowDiagram parentFlow = getParentFlow(node);
			Child parentChild = getParentChild(node);
			//if((parentFlow.isSw() && parentChild.equals(parentFlow.getRefine().get(0))) ||
				//	(!parentFlow.isSw() && parentChild.isRef()))
			if(parentChild.equals(parentFlow.getRefine().get(0)))
				if(parentFlow.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parentFlow.eContainer();
			else
				break;
		}
		return result;
	}

	//return a set containing the successor child as first item and the number of its parameters as second item
	// A loop is never placed as the first or the last child of a flow; so always (0 < i < n)
	public static List<Object> successor(Child ch, Integer parNum) {
		FlowDiagram parentFlow = getParentFlow(ch);
		List<Child> sibilings = parentFlow.getRefine();
		int i = sibilings.indexOf(Utils.getParentChild(ch));
		int n = sibilings.size();
		
		
		// for now leave the restriction that par-rep and loop can not be first or last child of a flowdiagram
		// if need to remove restriction, uncomment the comments and check build-seq-guard when thepredecessor is a flowdiagram
		if(i >= n-1) // this is why loop can not be the last child of a loop
			return null;
		//---------------------------------------------------------------------------------
		//Dana test
		//if(i >= n-1){
	
				//return successor((Child)parentFlow.eContainer(), parentFlow.getParameters().size());
		
		//}
		//else{
	    //--------------------------------------------------------------
		
		Child next = sibilings.get(i+1);
		
		if(!((next instanceof Loop) || (next instanceof Par) )){
			List<Object> list = new ArrayList<Object>();
			list.add(next);
			list.add(parNum);
			return list;
		}
		else
			return successor(next, parNum);
		//}//dana new else
	}

	public static Child predecessorLoop(Child ch, boolean sw) {
		FlowDiagram parent = getParentFlow(ch);
		List<Child> sibiling = parent.getRefine();
		int i = sibiling.indexOf(getParentChild(ch));
		
		if(i > 0){
			return sibiling.get(i-1);
			
			
		}
		else{
			if(!sw)
				return null;
			else{
				if(isAbstractFlow(parent)){
					return null;
				}
				else{
					return predecessorLoop((Child) parent.eContainer(), sw);
				}			
			}
		}		
	}

	public static String getPrevLoopGrdName(EObject sourceElement, Event e, List<GenerationDescriptor> generatedElements) {
		int max = 0;
		
		List<Guard> allGuards = new ArrayList<Guard>();
		for(GenerationDescriptor gend : generatedElements ){
			if( gend.parent != null &&  gend.parent.equals(e) && gend.value instanceof Guard){
				allGuards.add((Guard) gend.value);
			}
		}

		for(Guard grd : allGuards){
			int temp;
			if( grd.getName().matches("loop_" + Utils.getRootFlowDiagramName(sourceElement)) && (temp = Integer.parseInt(grd.getName().split("_")[0].substring(3)) )  > max )
				max = temp;

		}

		return Strings.GRD + (max+1) + Strings._LOOP + "_" + Utils.getRootFlowDiagramName(sourceElement);
	}

	public static String getLoopResetName(EObject sourceElement ,List<GenerationDescriptor> generatedElements) {
		int max = 0;
		List<Event> allEvents = new ArrayList<Event>();
		//allEvents.addAll(m.getEvents());
		for(GenerationDescriptor gend : generatedElements){
			if(gend.value instanceof Event){
				allEvents.add((Event) gend.value);
			}
		}
		
		for(Event e : allEvents){

			int temp;
			String[] splitted = e.getName().split("_");
			if(e.getName().matches(Utils.getRootFlowDiagramName(sourceElement) + "_reset_loop") && ((temp = Integer.parseInt(splitted[splitted.length - 1])) > max ) )
				max = temp;		
		}

		
		return Utils.getRootFlowDiagramName(sourceElement) + "_" + Strings.RESET_LOOP_ + (max+1);
	}

	public static List<Leaf> getNonDecomposedLeafDescendants(EventBElement ch){
		List<Leaf> ret = new ArrayList<Leaf>();
		if(ch instanceof Leaf){
			if(((Leaf) ch).getDecompose().isEmpty()){
				ret.add((Leaf) ch);
			}
			else
				for(FlowDiagram flw : ((Leaf) ch).getDecompose())
					ret.addAll(getNonDecomposedLeafDescendants(flw));
		}
		else if(ch instanceof FlowDiagram){
			for(Child refine : ((FlowDiagram) ch).getRefine())
				ret.addAll(getNonDecomposedLeafDescendants(refine));
		}
		else if(ch instanceof And){
			for(Leaf l : ((And) ch).getAndLink())
				ret.addAll(getNonDecomposedLeafDescendants(l));				
		}
		else if(ch instanceof Loop){
			for(Leaf l : ((Loop) ch).getLoopLink())
			ret.addAll(getNonDecomposedLeafDescendants(l));
		}
		else if(ch instanceof All)
			ret.addAll(getNonDecomposedLeafDescendants(((All) ch).getAllLink()));
		else if(ch instanceof Some)
			ret.addAll(getNonDecomposedLeafDescendants(((Some) ch).getSomeLink()));
		else if(ch instanceof Or){
			for(Leaf l : ((Or) ch).getOrLink())
				ret.addAll(getNonDecomposedLeafDescendants(l));
		}
		else if(ch instanceof Xor){
			for(Leaf l : ((Xor) ch).getXorLink())
				ret.addAll(getNonDecomposedLeafDescendants(l));
		}
		else if(ch instanceof One)
			ret.addAll(getNonDecomposedLeafDescendants(((One) ch).getOneLink()));
		else //if(ch instanceof Par)
			ret.addAll(getNonDecomposedLeafDescendants(((Par) ch).getParLink()));	
		
		return ret;
	}

	public static Leaf weakAncestor(Leaf sourceLeaf) {
		
		Child node = sourceLeaf;

		while(true){
			FlowDiagram parent = Utils.getParentFlow(node);
			Child parentChild = Utils.getParentChild(node);
			if(!parent.isSw() && parentChild.isRef())
				return (Leaf) parent.eContainer();
			if(parent.isSw() && parentChild.equals(parent.getRefine().get(0))){//strong seq and first child
				if(parent.eContainer() instanceof Machine)
					break;
				else
					node = (Child) parent.eContainer();
					
			}
			else
				return null;
				
		}
		return null;
	}

	public static String build_par_ref_grd(Child ch) {
		// 3 cases for firstFlow=lastFlow: leaf, one, xor due to single solid line rule
		//Single leaf
		if(ch instanceof Leaf && ((Leaf) ch).getDecompose().isEmpty()){
			return "";
		}
		else if(ch instanceof Leaf && ((Leaf)ch).getDecompose().size() > 0){
	     //Dana: fixed
			String str = "";
			for(FlowDiagram fw: ((Leaf) ch).getDecompose()){
				Child firstChild = fw.getRefine().get(0); // Fisrt Child of the flow
				Child lastChild = fw.getRefine().get(fw.getRefine().size()-1); //last child of the flow
				
				if(firstChild == lastChild){
					String s = build_par_ref_grd(firstChild);
					
				if(str.equals("") || s.equals(""))
					str = str.concat(s);
				else
					str = str.concat(Strings.B_AND + s);
				}
				else{
					String str1 = par_ref_grd(firstChild, true);
					String str2 = par_ref_grd(lastChild, false);
					
					String s = (str1 + Strings.B_BEQ + str2);
					
					if(str.equals(""))
						str = str.concat(s);
					else
						str = str.concat(Strings.B_AND + s);
				}
			}
			return str;
		}
		else if(ch instanceof One){
			return build_par_ref_grd(((One) ch).getOneLink());
		}
		else if(ch instanceof Xor){
			String str = "";
			for(Child x : ((Xor) ch).getXorLink()){
				String str2 = build_par_ref_grd(x);
				if(str.equals("") || str2.equals(""))
					str = str.concat(str2);
				else
					str = str.concat(Strings.B_AND + str2);				
				
			}
			return str;
		}
		
		return null;
	}

	/*************************dana *********************/
	public static String par_ref_grd(Child ch, Boolean bool) {
		
		// case: Leaf
		if(ch instanceof Leaf && ((Leaf) ch).getDecompose().isEmpty()){
			return ((Leaf) ch).getName();
		}
		
		//case: and
		else if(ch instanceof And){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((And) ch).getAndLink())
				expressions.add(par_ref_grd(ich, bool));
			return parenthesize(toString(expressions, Strings.B_INTER));
		}
		
		//case: or
		else if(ch instanceof Or){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Or) ch).getOrLink())
				expressions.add(par_ref_grd(ich, bool));
			return parenthesize(toString(expressions, Strings.B_UNION));
		}
		
		//case: xor
		else if(ch instanceof Xor){
			List<String> expressions = new ArrayList<String>();
			for(Child ich : ((Xor) ch).getXorLink())
				expressions.add(par_ref_grd(ich, bool));
			return parenthesize(toString(expressions, Strings.B_UNION));
		}
		
		//case: all
		else if(ch instanceof All)
			return Strings.B_DOM + parenthesize(par_ref_grd(((All) ch).getAllLink(), bool));
		
		//casr: some
		else if(ch instanceof Some)
			return Strings.B_DOM + parenthesize(par_ref_grd(((Some) ch).getSomeLink(), bool));
		
		//case: one
		else if(ch instanceof One)
			return Strings.B_DOM + parenthesize(par_ref_grd(((One) ch).getOneLink(), bool));
		
		//case: par
		else if(ch instanceof Par){
			List<String> expressions = new ArrayList<String>();
			expressions.add(par_ref_grd(((Par) ch).getParLink(), bool));
			int parNum = getParentFlow(ch).getParameters().size();
			Child succ = (Child) successor(ch, parNum).get(0);
			expressions.add(par_ref_grd(succ, bool));
			return parenthesize(toString(expressions, Strings.B_UNION));
			
		}
		
		//case: 1*flow
		else if(ch instanceof Leaf && ((Leaf)ch).getDecompose().size() > 0){
			//TODO Implement this: Done by Dana
            List<String> expressions = new ArrayList<String>();
            for(FlowDiagram fw: ((Leaf) ch).getDecompose()){
            	if(bool)
            		expressions.add(par_ref_grd(fw.getRefine().get(0), bool));
            	else
            		expressions.add(par_ref_grd(fw.getRefine().get(fw.getRefine().size()-1), bool));
            }
            return parenthesize(toString(expressions, Strings.B_UNION));
		}
			
		return null;
	}

	public static String getPrevParGrdName(EObject sourceElement, Event equivalent, List<GenerationDescriptor> generatedElements) {
		int max = 0;
		
		List<Guard> allGuards = new ArrayList<Guard>();
		for(GenerationDescriptor gend : generatedElements){
			if(gend.value instanceof Guard && gend.parent != null && gend.parent.equals(equivalent)){
				allGuards.add((Guard) gend.value);
			}
		}
			
		for(Guard grd : allGuards){
				int temp;
				String[] splitted = grd.getName().split("_");
				if(grd.getName().matches("par_" + Utils.getRootFlowDiagramName(sourceElement)) && ((temp = Integer.parseInt(splitted[splitted.length - 1])) > max ) )
					max = temp;		
			
		}
		
		return Strings.GRD + (max+1) + Strings._PAR + Utils.getRootFlowDiagramName(sourceElement);
	}

	public static String getRootFlowDiagramName(EObject obj){
		if(obj instanceof FlowDiagram && 
				(obj.eContainer() instanceof Machine  || obj.eContainer() == null))
			return ((FlowDiagram) obj).getName();
		else
			return getRootFlowDiagramName(obj.eContainer());
	}
	
	//--------------------------------------------------------------------------------
	// Dana
	// merge_or_grd merges the or, xor guards in case they contain a common all-rep
	// using union
	// then we do a normal or-merge
	//--------------------------------------------------------------------------------
	
	public static String merge_or_grd(List<String> exp){
		
	
		for (int i = 0; i < exp.size(); i++){
			if (exp.get(i).contains(Strings.B_EQ)){
				for(int j = i+1; j < exp.size(); j++){
					
					if (exp.get(j).contains(Strings.B_EQ)){
						String s = exp.get(i);
						if (s.startsWith(Strings.B_LPAR))
							s = s.substring(1, s.indexOf(Strings.B_RPAR));
						
						
						String[] s1 = s.split(Strings.B_EQ);
						String [] s2 = exp.get(j).split(Strings.B_EQ);
						if(s1[1].trim().equals(s2[1].trim())){
					
							s = s1[0].concat(Strings.B_UNION + s2[0].trim() + Strings.B_EQ + s1[1].trim());
						
							Utils.parenthesize(s);
							exp.set(i, s);
							exp.remove(j);
						}
							
				}
						
				}
			}
		}
		return Utils.parenthesize(Utils.toString(exp, Strings.B_OR));
		
	}
	
 // new method to get all the refined children of a loop
  public static List <Child> getLoopRefinedChildren(Loop lo){
	  List <Child> chList = new ArrayList<Child>();
	  for(Leaf ch : lo.getLoopLink()){
			if(!ch.getDecompose().isEmpty()){
				chList.add(ch);
			}
	  }
	  return chList;
	  
  }
  
  //Dana: new method to build invariant in SI case
  public static String build_succ_SI_inv(Child ch, int parnum){
	  
	  //Case: Leaf parnum= 0
	  if(ch instanceof Leaf && ((Leaf) ch).getDecompose().isEmpty() && parnum == 0)
		  return ((Leaf) ch).getName().concat(Strings.B_EQ + Strings.B_TRUE);
	  
	   //Case: Leaf parnum> 0
	  else if(ch instanceof Leaf && ((Leaf) ch).getDecompose().isEmpty() && parnum > 0)
		  return ((Leaf) ch).getName().concat(Strings.B_NEQ + Strings.B_EMPTYSET);
	  
	  //Case: one
	  else if(ch instanceof One)
		  return build_succ_SI_inv(((One) ch).getOneLink(), parnum +1);
	  //Case: xor
	  else if(ch instanceof Xor){
		  List<String> expressions = new ArrayList<String>();
		  for(Child x : ((Xor) ch).getXorLink())
			  expressions.add(build_succ_SI_inv(x, parnum));
	      return parenthesize(toString(expressions, Strings.B_OR));
	  }
	 
	  //case: 1* flow
	  else if(ch instanceof Leaf && ((Leaf) ch).getDecompose().size() > 0){
		  List<String> expressions = new ArrayList<String>();
		  for(FlowDiagram fw: ((Leaf) ch).getDecompose())
			  expressions.add(build_succ_SI_inv(fw.getRefine().get(0), parnum));
		  return parenthesize(toString(expressions, Strings.B_OR));
		  
	  }
	  
	  return null;
	  
  }

}
