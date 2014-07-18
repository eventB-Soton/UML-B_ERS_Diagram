package ac.soton.eventb.atomicitydecomposition.generator.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;

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
				if(isAbstractFlow(parent))
					return null;
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
			ArrayList<Object> invSet =  new ArrayList<Object>();
			for(FlowDiagram flw : ((Leaf)pred).getDecompose())
				if(flw.isSw())
					invSet.add(build_seq_inv(flw.getRefine().get(flw.getRefine().size() -1 ), predParList, l, parList));
				else{
					Child refTrue = null;
					for(Child ch : flw.getRefine())
						if(ch.isRef()){
							refTrue  = ch;
							break;
						}
					invSet.add(build_seq_inv(refTrue, predParList, l, parList));
				}
					
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
			result.add(e2.getName() + Strings.B_EQ + Strings.B_EMPTYSET);
			result.add(e1.getName() + Strings.B_EQ + Strings.B_TRUE);
			
		}
		//3
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0 , n-1).size() == 0){
			result.add("3");
			System.out.println(3);
			result.add(e2.getName() + Strings.B_EQ + Strings.B_TRUE);
			result.add(e1.getName() + Strings.B_EQ + Strings.B_EMPTYSET);
		}
		//4
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0, n-1).size() == 0){
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
				if(samePar(parList1.get(i).getType(), parList2) != 0){
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
				result.add(getDomainRangeStr( e2.getName(), samePar( allReplicatorPar(e1, 0, n-1).get(0).toString(), parList2 ), m));
				result.add(getDomainRangeStr(e1.getName(), allReplicatorPar(e1, 0, n-1).get(0), n ));
			}
		}
		//8
		else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, 0, n-1).size() == 0){
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
			str = str.concat(toString(expressions, Strings.B_MAPLET) + Strings.B_IN + e2.getName());
			
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
				counter++;
			}
			node = node.eContainer();
		}
		return ret;
	}
	
	public static String getDomainStr(String eveName, Integer index, Integer n){
		String str = "";
		if(n > index){
			for(int i = 1 ; i < n-index+1 ; i++)
				str = str.concat(Strings.B_DOM + Strings.B_LPAR);
		}
		str = str.concat(eveName);
		
		if(n > index){
			for(int i = 1 ; i < n-index+1 ; i++)
				str = str.concat(Strings.B_RPAR);
		}
		
		return str;
		
	}
	
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
		//index  > 0
		else if(n-index > 1){
			str = str.concat(Strings.B_RAN + Strings.B_LPAR);
			
			
			if(n > index){
				for(int i = 1 ; i < n-index+1 ; i++)
					str = str.concat(Strings.B_DOM + Strings.B_LPAR);
			}
			str.concat(eveName);
			
			if(n > index){
				for(int i = 1 ; i < n-index+1 ; i++)
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
				return parList.indexOf(tp);
		}
		
		return 0;
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
					for(int j = i+1 ; i < invSet.size() ; i++){
						List<String> element = invSet.get(j);
						if(element.size() >= 3 && element.get(0) == invSet.get(i).get(0)){
							String s = sameMerge.get(2);
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
					mergeResult.set(2, mergeResult.get(2).concat( Strings.B_AND + i.get(2)));
				}
				//FIXME Different from old implementation!!! Needs checking
				for(ArrayList<String> i : first7){
					mergeResult.set(2, mergeResult.get(2).concat( Strings.B_AND + i.get(2)));
				}


			}
			else if(result.get(0).get(0).equals("8") || result.get(0).get(0).equals("9")){
				//FIXME YET TO BE IMPLEMENTED!!!!!!
				System.out.println("TAKE CARE, CODE WAS NOT PLANNED TO GET HERE!!");
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

		for(int i = 0 ; i < invSet.size() ; i++){
			ArrayList<String> sameMerge = new ArrayList<String>();

			if(invSet.get(i).size() == 3 && invSet.size() > 0){
				sameMerge.add(invSet.get(i).get(0));
				sameMerge.add(invSet.get(i).get(1));
				sameMerge.add(invSet.get(i).get(2));
				invSet.get(i).add("false");

				if(invSet.size() > 1){
					for(int j = i+1 ; i < invSet.size() ; i++){
						List<String> element = invSet.get(j);
						if(element.size() >= 3 && element.get(0) == invSet.get(i).get(0)){
							String s = sameMerge.get(2);
							if(element.get(0).equals("7") || element.get(0).equals("8")){
								s = s.concat(Strings.B_UNION);
							}
							else{
								s = s.concat(Strings.B_OR);
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
				//FIXME YET TO BE IMPLEMENTED!!!!!!
				System.out.println("TAKE CARE, CODE WAS NOT PLANNED TO GET HERE!!");
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
		else
			return "NOT SUPPORTED";
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
			return Utils.parenthesize(Utils.toString(expressions, Strings.B_OR));
		}
		else if(pred instanceof Xor){
			List<String> expressions =  new ArrayList<String>();
			for(Child ch : ((Xor) pred).getXorLink()){
				expressions.add(build_seq_grd(ch, predParList, l, parList, false));
			}
			return Utils.parenthesize(Utils.toString(expressions, Strings.B_OR));
		}
		else if(pred instanceof All){
			List<TypedParameterExpression> parSet = new ArrayList<TypedParameterExpression>();
			parSet.addAll(parList);
			parSet.add(((All) pred).getNewParameter());
			return build_seq_grd(((All) pred).getAllLink(), parSet, l, parList, false);
		}
		else if(pred instanceof Some){
			List<TypedParameterExpression> parSet = new ArrayList<TypedParameterExpression>();
			parSet.addAll(parList);
			parSet.add(((Some) pred).getNewParameter());
			return build_seq_grd(((Some) pred).getSomeLink(), parSet, l, parList, false);
		}
		else if(pred instanceof One){
			List<TypedParameterExpression> parSet = new ArrayList<TypedParameterExpression>();
			parSet.addAll(parList);
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

		if(n == 0)
			return e1.getName() + Strings.B_EQ + Strings.B_TRUE;
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0, n-1).size() == 0)
			return e1.getName() + Strings.B_NEQ + Strings.B_EMPTYSET;
		else if(n != 0 && m == 0 && allReplicatorPar(e1, 0, n-1).size() != 0){
			List<String> expressions = new ArrayList<String>();
			for(Integer k : allReplicatorPar(e1, 0, n-1))
				if(parList1.get(k).getInputExpression().isEmpty())
					expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getType());
				else
					expressions.add(getDomainRangeStr(e1.getName(), k, n) + Strings.B_EQ + parList1.get(k).getInputExpression());
			return toString(expressions, Strings.B_AND);
		}
		else if(n != 0 && m != 0 && commonPar(e1, e2) == 0 && allReplicatorPar(e1, 0, n-1).size() == 0)
			return e1.getName() + Strings.B_NEQ + Strings.B_EMPTYSET;
		else if(n != 0 && m != 0 && commonPar(e1,e2) == 0 && allReplicatorPar(e1, 0, n-1).size() != 0){
			boolean bool = false;

			for(Integer i : allReplicatorPar(e1, 0, n-1)){
				if(samePar(parList1.get(i).getType(), parList2) != 0){
					bool = true;
					break;
				}
			}

			if(!bool){
				List<String> expressions = new ArrayList<String>();
				for(Integer k : allReplicatorPar(e1, 0, n-1))
					if(parList1.get(k).getInputExpression().isEmpty())
						expressions.add(getDomainRangeStr(e1.getName(), k, n) +  Strings.B_EQ + parList1.get(k).getType());
					else
						expressions.add(getDomainRangeStr(e1.getName(), k, n) +  Strings.B_EQ + parList1.get(k).getInputExpression());
				return toString(expressions, Strings.B_AND);
			}
			else{
				//				List<String> expressions = new ArrayList<String>();
				//				int i = 0;
				//				for(Integer l : samePar(allReplicatorPar(e1, 0, n-1), e2)){
				//					expressions.add( getDomainRangeStr(e2.getName(), l) +  Strings.B_SUBSETEQ + getDomainRangeStr(e1.getName(), allReplicatorPar(e1, 0, n-1).get(i)));
				//				}
				//				String str = toString(expressions, Strings.B_AND);
				//FIXME the first addition would cause an error if implemented as in previous version. get(0).toString() added, but not sure if right
				return ( parList2.get(samePar(allReplicatorPar(e1, 0, n-1).get(0).toString(), parList2)).getName() + Strings.B_IN + 
						getDomainRangeStr(e1.getName(), allReplicatorPar(e1, 0, n-1).get(0), n) );
			}
		}
		else if(n != 0 && m != 0 && commonPar(e1, e2) != 0 && allReplicatorPar(e1, 0, n-1).size() == 0){
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
}
