package ac.soton.eventb.atomicitydecomposition.generator.strings;

import org.eventb.emf.core.EventBNamedCommentedComponentElement;


public class Strings {
	//private static final String BUNDLE_NAME = "ac.soton.eventb.classdiagrams.generator.strings.Strings"; //$NON-NLS-1$

	private Strings() {
		// Do not instantiate
	}
	// //////////////////////////////////////////////////////////
	// ADMIN and HELPER methods
	// /////////////////////////////////////////////////////////
	
//	static {
//		NLS.initializeMessages(BUNDLE_NAME, Strings.class);
//	}
	public static String index   = "index";

	// generator id key
	public static String GENERATOR_ID_KEY   = "org.eventb.emf.persistence.generator_ID";

	// initialisation event name
	public static String INIT   = "INITIALISATION";

	// math
	public static String B_EQ   = " = ";
	public static String B_LTEQ   = " \u2264 ";
	public static String B_NEQ   = " \u2260 ";
	public static String B_BEQ   = " \u2254 ";
	public static String B_IN   = " \u2208 ";
	public static String B_NOTIN   = " \u2209 ";
	public static String B_BOOL   = "BOOL";
	public static String B_TRUE   = "TRUE";
	public static String B_FALSE   = "FALSE";
	public static String B_NOT   = " \u00AC ";
	public static String B_AND   = " \u2227 ";
	public static String B_OR   = " \u2228 ";
	public static String B_XOR   = " xor ";
	public static String B_LPAR   = "(";
	public static String B_RPAR   = ")";
	public static String B_LBRC   = "{";
	public static String B_RBRC   = "}";
	public static String B_LSQBRC   = "[";
	public static String B_RSQBRC   = "]";
	public static String B_COM   = ", ";
	public static String B_FORALL   = "\u2200";
	public static String B_MIDDOT   = "\u00B7";
	public static String B_IMPL   = " \u21D2 ";
	public static String B_EQUIV   = " \u21D4 ";
	public static String B_INTER   = " \u2229 ";
	public static String B_UNION   = " \u222A ";
	public static String B_SETMINUS   = " \u2216 ";
	public static String B_EMPTYSET   = " \u2205 ";
	public static String B_SUBSETEQ   = " \u2286 ";
	public static String B_SUB   = " \u2286 ";
	public static String B_TFUN   = " \u2192 ";
	public static String B_PFUN   = " \u2900 ";
	public static String B_DOM   = "dom";
	public static String B_CARD   = "card";
	public static String B_RAN   = "ran";
	public static String B_RANSUB   = " \u2A65 ";
	public static String B_RANRES   = " \u25B7 ";
	public static String B_CPROD   = " \u00D7 ";
	public static String B_PARTITION = " partition";
	public static String B_MAPLET = " \u21A6 ";
	
	// generated names & labels
	public static String _STATES   = "_STATES";
	public static String _NULL   = "_NULL";
	public static String TYPEOF_   = "typeof_";
	public static String SUPERSTATEOF_   = "superstateof_";
	public static String _SUBSTATEOF_   = "_substateof_";
	public static String DISTINCT_STATES_IN_   = "distinct_states_in_";
	public static String INIT_   = "init_";
	public static String ISIN_   = "isin_";
	public static String ISNOTIN_   = "isnotin_";
	public static String ENTER_   = "enter_";
	public static String LEAVE_   = "leave_";
	public static String _TYPE   = "_type";
	public static String ACT_   = "act_";
	public static String INV_   = "inv_";
	public static String INV   = "inv";
	public static String _XOR   = "_xor";
	public static String XOR   = "xor";
	public static String ONE   = "one";
	public static String _SEQ   = "_seq";
	public static String _GLU   = "_glu";
	public static String GRD_SEQ   = "grd_seq";
	public static String GRD_SELF   = "grd_self";
	public static String GRD   = "grd";
	public static String GRD_INPUTEXPRESSION   = "grd_InputExpression";
	public static String ACT   = "act";
	public static String UNDERSC   = "_";
	public static String _ONE   = "_one";
	public static String _REP   = "_rep";
	public static String _PAR   = "_par";
	public static String _LOOP   = "_loop";
	
	
	// context name
	public static String _IMPLICIT_CONTEXT   = "_implicitContext";
	
	
	//auxiliary methods
	public static String CTX_NAME(EventBNamedCommentedComponentElement element){
		return element.getName() + _IMPLICIT_CONTEXT;
	}

	
}