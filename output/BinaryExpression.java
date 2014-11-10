/**
 * An BinaryExpression is a wrapper which groups an expression 
 * in the form of (val1 OP val2) together.
 */
public class BinaryExpression {
	private String value1, value2;
	private Binop op;
	
	/**
	 * Constructs a new BinaryExpression from an expression in the
	 * form of (val1 OP val2).
	 * 
	 * @param value1 The first value to perform the operation on.
	 * @param value2 The second value to perform the operation on.
	 * @param op A target temporary variable.
	 */
	public BinaryExpression(String value1, String value2, Binop op) {
		this.value1 = value1;
		this.value2 = value2;
		this.op = op;
	}
	
	/**
	 * Evaluates this expression and stores the result in a target temporary.
	 * 
	 * @param target The target temporary variable to store the result.
	 * @return An IR representation of the evaluation.
	 */
	public String eval(String target) {
		switch (op) {
		
		// Math operations
		case PLUS:
			return IRGenerator.emit(IRMap.add(value1, value2, target));
		case MINUS:
			return IRGenerator.emit(IRMap.sub(value1, value2, target));
		case MULT:
			return IRGenerator.emit(IRMap.mult(value1, value2, target));
		case DIV:
			return IRGenerator.emit(IRMap.div(value1, value2, target));
		
		// Logical operations
		case AND:
			return IRGenerator.emit(IRMap.and(value1, value2, target));
		case OR:
			return IRGenerator.emit(IRMap.or(value1, value2, target));
			
		// Comparator operations
		// TODO: Not quite sure how to handle these yet - Sean
		case EQUAL:
			break;
		case NOT_EQUAL:
			break;
		case GREATER_THAN:
			break;
		case GREATER_THAN_OR_EQUAL:
			break;
		case LESS_THAN:
			break;
		case LESS_THAN_OR_EQUAL:
			break;
		
		}
		
		return "";
	}
}
