import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A TigerFunction encapsulates all of the evaluations and variables 
 * in a Tiger program function.
 */
public class TigerFunction {
	/**
	 * The String identifier of this function.
	 */
	private String id;
	/**
	 * Parameters to be passed into this function.
	 */
	private List<String> params;
	/**
	 * This function's logic, expressed as a tree.
	 */
	private CommonTree code;
	/**
	 * The owning Scope of this function.
	 */
	private Scope scope;

	/**
	 * Constructs a new TigerFunction with given function identifier, 
	 * parameters, and code block tree. This constructor assumes this 
	 * TigerFunction was declared in the global scope.
	 * 
	 * @param id The String identifier of this TigerFunction.
	 * @param params The parameters this TigerFunction expects to receieve.
	 * @param code The logic contained in this TigerFunction.
	 */
	public TigerFunction(String id, CommonTree params, CommonTree code) {
		this.id = id;
		this.params = toList(params);
		this.code = code;
		scope = new Scope();
	}

	/**
	 * Constructs a TigerFunction from another TigerFunction.
	 * Used for recursive calls.
	 * 
	 * @param orig The original TigerFunction.
	 */
	public TigerFunction(TigerFunction orig) {
		id = orig.id;
		params = orig.params;
		code = orig.code;
		scope = orig.scope.copy();
	}

	/**
	 * Invokes this TigerFunction to return a TigerValue.
	 * 
	 * @param callParams The parameters given to pass to the function call.
	 * @param tigerFunctions A map of TigerFunctions to their String identifiers.
	 * @return The resultant TigerValue.
	 */
	public TigerValue invoke(List<TigerNode> callParams, Map<String, TigerFunction> tigerFunctions) {
		// Check if number of parameters match expected
		if (callParams.size() != params.size()) {
			throw new InvalidNumParameterException(id, callParams.size(), params.size());
		}

		// If no issue, assign all parameters given to local variables in the owning Scope
		// IDs will be provided by constructor; callParams will provide values
		for (int i = 0; i < params.size(); i++) {
			scope.assign(params.get(i), callParams.get(i).evaluate());
		}

		try {
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(code);
			tigerTreeWalker walker = new tigerTreeWalker(nodes, scope, tigerFunctions);
			
			// Walk this code block's tree
			return walker.block().evaluate();
		} catch (RecognitionException e) {
			// Problem, don't recover from this
			throw new RuntimeException("Error: Unexpected RecognitionException", e);
		}
	}

	/**
	 * Converts a CommonTree to a one-dimensional list of String identifiers.
	 * 
	 * @param tree A CommonTree to get values from.
	 * @return A List<String> of identifiers.
	 */
	private List<String> toList(CommonTree tree) {
		List<String> ids = new ArrayList<String>();
		
		for (int i = 0; i < tree.getChildCount(); i++) {
			CommonTree child = (CommonTree) tree.getChild(i);
			ids.add(child.getText());
		}
		
		return ids;
	}
	
	/**
	 * An exception thrown when parameters passed into a function do not 
	 * match the number of arguments expected.
	 */
	private class InvalidNumParameterException extends RuntimeException {
		private static final long serialVersionUID = -8118100538622330945L;

		/**
		 * An exception thrown when parameters passed into a function do not 
		 * match the number of arguments expected.
		 */
		private InvalidNumParameterException(String id, int expectedNum, int givenNum) {
			super("Error: function " + id + " expects " + expectedNum + " parameter(s), "
					+ givenNum + " given");
		}
	}
}