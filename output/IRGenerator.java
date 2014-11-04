import java.util.List;

/**
 * An IRGenerator serves to provide direct translations between 
 * Tiger statements and an intermediate representation.
 */
public class IRGenerator {

	// No constructor.
	
	/**
	 * Returns an IR translation of a Tiger function declaration.
	 * 
	 * @param id The ID of the function.
	 */
	public static String funct_declaration(String id) {
		// For IR, all we need is a label to jump to here
		return id + ": ";
	}
	
	/**
	 * Returns an IR translation of a variable declaration.
	 * 
	 * @param id The ID of the variable
	 * @param value The value of the variable, as String (this can be another variable).
	 * @return An IR translation of a Tiger declaration statement.
	 */
	public static String declaration_statement(String id, String value) {
		return IRMap.assign(id, value);
	}
	
	/**
	 * Returns an IR translation of an if statement.
	 * NOTE: irTrueStat is the IR representation of what follows after (if .. then ..),
	 * and irFalseStat is the IR form of (.. else ..).
	 * 
	 * These statements must be already translated into IR!
	 * 
	 * @param expr1 The first expression to compare.
	 * @param expr2 The second expression to compare.
	 * @param compare The comparison operator to apply to the two expressions.
	 * @param irTrueStat The code to execute if the result of the comparison is true.
	 * @param irFalseStat The code to execute of the result of the comparison is false.
	 * @return An IR translation of an if statement.
	 */
	public static String if_stat(String expr1, String expr2, Comparator compare, 
			List<String> irTrueStat, List<String> irFalseStat) {
		
		String result = "";
		
		// Generate a unique (hopefully) label to go to if statement is false
		String elseLabel = String.valueOf(expr2.hashCode())
				.substring((expr2.length() / 2), (expr2.length() / 2) + 5)
				 + "-else:";
		
		// Insert it at beginning of irFalseStat.
		
		// If there is an else block, it will jump to the beginning of that block;
		// otherwise it will fall through to the end
		irFalseStat.add(0, elseLabel);
		
		switch (compare) {
		case EQUAL:
			result += IRMap.breq(expr1, expr2, elseLabel);
			break;
		case NOT_EQUAL:
			result += IRMap.brneq(expr1, expr2, elseLabel);
			break;
		case LESS_THAN:
			result += IRMap.brlt(expr1, expr2, elseLabel);
			break;
		case GREATER_THAN:
			result += IRMap.brgt(expr1, expr2, elseLabel);
			break;
		case LESS_THAN_OR_EQUAL:
			result += IRMap.brleq(expr1, expr2, elseLabel);
			break;
		case GREATER_THAN_OR_EQUAL:
			result += IRMap.brgeq(expr1, expr2, elseLabel);
			break;
		default:
			// This should not happen
			throw new RuntimeException("ERROR: Conditional statement invalid in IR generation");
		}
		
		return result;
	}
	
	// TODO: Continue from type_declaration downwards
}
