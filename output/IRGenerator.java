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
	 * @param statSeqTrue The code to execute if the result of the comparison is true.
	 * @param statSeqFalse The code to execute of the result of the comparison is false.
	 * @return An IR translation of an if statement.
	 */
	public static String if_stat(String expr1, String expr2, Binop compare, 
			List<String> statSeqTrue, List<String> statSeqFalse) {
		
		String result = "";
		
		// Generate a unique (hopefully) label to go to if statement is false
		String elseLabel = String.valueOf(expr2.hashCode())
				.substring((expr2.length() / 2), (expr2.length() / 2) + 5)
				 + "-else:\n";
		
		// Insert it at beginning of irFalseStat.
		
		// If there is an else block, it will jump to the beginning of that block;
		// otherwise it will fall through to the end
		statSeqFalse.add(0, elseLabel);
		
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
			// If binary operator is not comparator
			throw new RuntimeException("ERROR: Conditional statement invalid, this is not a comparator!");
		}
		
		for (String stat : statSeqTrue) {
			result += stat;
			result += "\n";
		}
		
		for (String stat : statSeqFalse) {
			result += stat;
			result += "\n";
		}
		
		return result;
	}
	
	/**
	 * Returns an IR translation of a while statement.
	 * 
	 * These statements must be already translated into IR!
	 * 
	 * @param expr1 The first expression to compare.
	 * @param expr2 The second expression to compare.
	 * @param compare The comparison operator to apply to the two expressions.
	 * @param statSeqTrue The code to execute if the result of the comparison is true.
	 * @param statSeqFalse The code to execute of the result of the comparison is false.
	 * @return An IR translation of a while statement.
	 */
	public static String while_stat(String expr1, String expr2, Binop compare, List<String> statSeq) {
		String result = "";
		
		// Generate a unique (hopefully) label to loop to if statement is still true
		String startDo = String.valueOf(expr2.hashCode())
				.substring((expr2.length() / 4), (expr2.length() / 4) + 5)
				 + "-while-do:\n";
		
		// Generate a unique (hopefully) label to go to if statement is false
		String endDo = String.valueOf(expr2.hashCode())
				.substring((expr2.length() / 2), (expr2.length() / 2) + 5)
				 + "-while-enddo:\n";
		
		// Insert start label at beginning of loop.
		result += startDo;
		
		switch (compare) {
		case EQUAL:
			result += IRMap.breq(expr1, expr2, endDo);
			break;
		case NOT_EQUAL:
			result += IRMap.brneq(expr1, expr2, endDo);
			break;
		case LESS_THAN:
			result += IRMap.brlt(expr1, expr2, endDo);
			break;
		case GREATER_THAN:
			result += IRMap.brgt(expr1, expr2, endDo);
			break;
		case LESS_THAN_OR_EQUAL:
			result += IRMap.brleq(expr1, expr2, endDo);
			break;
		case GREATER_THAN_OR_EQUAL:
			result += IRMap.brgeq(expr1, expr2, endDo);
			break;
		default:
			// If binary operator is not comparator
			throw new RuntimeException("ERROR: Conditional statement invalid, this is not a comparator!");
		}
		
		for (String stat : statSeq) {
			result += stat;
			result += "\n";
		}
		
		// Insert end label at end of statSeq.
		result += "\n" + endDo;
		
		return result;
	}
	
	/**
	 * Returns an IR translation of a for statement.
	 * 
	 * These statements must already be translated to IR!
	 * 
	 * @param var The variable to increment.
	 * @param start The starting value of the variable.
	 * @param end The ending value to conclude the loop.
	 * @param statSeq The code to execute if (start != end).
	 * @return An IR translation of a for statement.
	 */
	public static String for_stat(String var, int start, int end, List<String> statSeq) {
		String result = "";
		// Generate a unique (hopefully) label to loop to if statement is still true
		String startDo = String.valueOf(var.hashCode())
				.substring((var.length() / 4), (var.length() / 4) + 5)
				 + "-for-do:\n";
		// ...and for concluding the loop
		String endDo = String.valueOf(var.hashCode())
				.substring((var.length() / 4), (var.length() / 4) + 5)
				 + "-for-enddo:\n";
		
		// TODO: implement
		
		return result;
	}
	
	/**
	 * Returns an IR translation of an assignment statement.
	 * Assigns a variable to a value or the target temporary variable from expr.
	 * 
	 * @param var The variable symbol to assign.
	 * @param targetVal The value or target temporary to assign to var.
	 * @return An IR translation of an assignment statement.
	 */
	public static String assign_stat(String var, String targetVal) {
		return IRMap.assign(var, targetVal);
	}
	
	/**
	 * Returns an IR translation of a function call.
	 * This method requires a SymbolTable lookup.
	 * 
	 * @param function The FunctionSymbolTableEntry of the function to call.
	 * @param args An array of arguments to pass into the function.
	 * @param target A target temporary variable to store the result in.
	 * @return An IR translation of a function call.
	 */
	public static String func_call(FunctionSymbolTableEntry function, String[] args, String target) {
		String result = "";
		
		if (function.getReturnType().toLowerCase().equals("void")) {
			// It's a void function, no return value
			result += IRMap.call(function.getId(), args);
		} else {
			// It's a function with return type, it has a return value
			
			// Store the result in t0; if we actually assign this to something 
			// meaningful, we can reassign to a different temporary in assign_stat
			result += IRMap.callr(target, function.getId(), args);
		}
		
		return result;
	}
	
	/**
	 * Returns an IR translation of a break statement.
	 * Breaks out of the closest loop by jumping to a for- or while-loop label.
	 * 
	 * @param label The label to jump to.
	 * @return An IR translation of a break statement.
	 */
	public static String break_stat(String label) {
		return IRMap.gotoLabel(label);
	}
	
	/**
	 * Returns an IR translation of a return statement.
	 * 
	 * @param target The target temporary variable or value returned by expr.
	 * @return An IR translation of a return statement.
	 */
	public static String return_stat(String target) {
		return IRMap.returnVal(target);
	}
	
	/**
	 * Returns an IR translation of an expression that produces a 
	 * constant or variable with no further expansion.
	 * 
	 * @param value The value to pass through.
	 * @return An IR translation of a constant- or variable-terminating expression.
	 */
	public static String expr_val(String value) {
		// No further processing needed
		return value;
	}
	
	/**
	 * Returns an IR translation of an expression applied to a binary operator
	 * that produces a resultant value.
	 * 
	 * @param val1 The first value.
	 * @param val2 The second value.
	 * @param binop The binary operation to perform on the two values.
	 * @param target The target temporary value to store the result.
	 * @return The String result. If the values are both literals, the result will be evaluated and return a single literal.
	 */
	public static String expr_binop(String val1, String val2, Binop binop, String target) {
		String result = "";
		boolean areLiterals = (isInteger(val1) || isDouble(val1)) 
				&& (isInteger(val2) || isDouble(val2));
		boolean bothInteger = isInteger(val1) && isInteger(val2);
		switch (binop) {
		case MINUS:
			if (areLiterals) {
				if (bothInteger) {
					result = String.valueOf(Integer.parseInt(val1) - Integer.parseInt(val2));
				} else {
					// Either one or both are fixedpt, cast to fixedpt
					result = String.valueOf(Double.parseDouble(val1) - Double.parseDouble(val2));
				}
			} else {
				result = IRMap.sub(val1, val2, target);
			}
			
			break;
		case PLUS:
			if (areLiterals) {
				if (bothInteger) {
					result = String.valueOf(Integer.parseInt(val1) + Integer.parseInt(val2));
				} else {
					// Either one or both are fixedpt, cast to fixedpt
					result = String.valueOf(Double.parseDouble(val1) + Double.parseDouble(val2));
				}
			} else {
				result = IRMap.add(val1, val2, target);
			}
			
			break;
		case MULT:
			if (areLiterals) {
				if (bothInteger) {
					result = String.valueOf(Integer.parseInt(val1) * Integer.parseInt(val2));
				} else {
					// Either one or both are fixedpt, cast to fixedpt
					result = String.valueOf(Double.parseDouble(val1) * Double.parseDouble(val2));
				}
			} else {
				result = IRMap.mult(val1, val2, target);
			}
			
			break;
		case DIV:
			if (areLiterals) {
				if (bothInteger) {
					result = String.valueOf(Integer.parseInt(val1) / Integer.parseInt(val2));
				} else {
					// Either one or both are fixedpt, cast to fixedpt
					result = String.valueOf(Double.parseDouble(val1) / Double.parseDouble(val2));
				}
			} else {
				result = IRMap.div(val1, val2, target);
			}
			
			break;
		case AND:
			result = IRMap.and(val1, val2, target);

			break;
		case OR:
			result = IRMap.or(val1, val2, target);
			
			break;
		default:
			// This should not happen
			throw new RuntimeException("ERROR: Binop is not valid in expr!");
		}
		
		return result;
	}
	
	/**
	 * Checks a value to see if it is an integer.
	 * 
	 * @param value The String value to check.
	 * @return true if the value is a valid integer; false otherwise.
	 */
	private static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks a value to see if it is a double.
	 * 
	 * @param value The String value to check.
	 * @return true if the value is a valid double; false otherwise.
	 */
	private static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
}
