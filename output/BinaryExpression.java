/**
 * An BinaryExpression is a wrapper which groups an expression 
 * in the form of (val1 OP val2) together. 
 * 
 * It is a binary tree implementation of expression evaluation.
 */
public class BinaryExpression {
	/**
	 * The left and right expressions to evaluate.
	 */
	protected BinaryExpression left, right;
	/**
	 * A static value - used only if this is a terminal expression.
	 */
	protected String value;
	/**
	 * The operator to apply between the left and right expressions.
	 */
	private Binop op;
	/**
	 * The parent BinaryExpression of this one.
	 */
	protected BinaryExpression parent;
	/**
	 * Constructs a new non-terminal BinaryExpression from an expression in the
	 * form of (BinaryExpression1 OP BinaryExpression2).
	 * 
	 * @param left The first expression to perform the operation on.
	 * @param right The second expression to perform the operation on.
	 * @param op A the operation to perform.
	 */
	public BinaryExpression(BinaryExpression left, BinaryExpression right, Binop op) {
		this.left = left;
		this.right = right;
		
		if (left != null) {
			left.parent = this;
		}
		
		if (right != null) {
			right.parent = this;
		}
		
		parent = null;
		
		this.op = op;
	}
	
	/**
	 * Constructs a new terminal BinaryExpression from a value or variable.
	 * 
	 * @param value The value held by this BinaryExpression.
	 */
	public BinaryExpression(String value) {
		this(null, null, null);
		this.value = value;
	}
	
	/**
	 * Returns if this BinaryExpression is a terminal expression or not.
	 * 
	 * @return True if this BinaryExpression is terminal; false otherwise.
	 */
	public boolean isTerminal() {
		return (value != null) ? true : false;
	}
	
	/**
	 * Performs a post-order traversal on this BinaryExpression to evaluate it
	 * and generates a packaged result.
	 * 
	 * This result can be accessed as follows:<br />
	 * <b>EvalReturn.irGen</b>: The resultant IR translation of the evaluation.<br />
	 * <b>EvalReturn.nextUnusedTemp</b>: The next unused temporary variable available for assignment.<br />
	 * <b>EvalReturn.condLabel</b>: If a conditional expression, the label generated if condition is false.
	 * 
	 * @param startTemp The number of the temporary variable to store intermediary values in.
	 * @return A result packaged as a EvalReturn object.
	 */
	public EvalReturn eval(int startTemp) {
		if (isTerminal()) {
			return new EvalReturn(IRGenerator.emit(IRMap.assign(emitTemp(startTemp), value)), ++startTemp);
		}
		
		return evalHelper(this, startTemp);
	}
		
	/**
	 * A helper function which recursively traverses the expression tree and returns a packaged result.
	 * 
	 * @param startNode The node to start traversing from.
	 * @param tempNum The current free temporary variable.
	 * @return A result packaged as a EvalReturn object.
	 */
	private EvalReturn evalHelper(BinaryExpression startNode, int tempNum) {
		EvalReturn returnBlock = new EvalReturn(tempNum);
		
		while (!startNode.right.isTerminal()) {
			EvalReturn rightEval = evalHelper(startNode.right, returnBlock.nextUnusedTemp);
			returnBlock.irGen += IRGenerator.emit(rightEval.irGen);
			returnBlock.nextUnusedTemp = rightEval.nextUnusedTemp;
			returnBlock.condLabel = rightEval.condLabel;
			
			// Make it terminal
			startNode.right.value = String.valueOf((rightEval.nextUnusedTemp - 1));
		}
			
		while (!startNode.left.isTerminal()) {
			EvalReturn leftEval = evalHelper(startNode.left, returnBlock.nextUnusedTemp);
			returnBlock.irGen += IRGenerator.emit(leftEval.irGen);
			returnBlock.nextUnusedTemp = leftEval.nextUnusedTemp;
			returnBlock.condLabel = leftEval.condLabel;
			
			// Make it terminal
			startNode.left.value = String.valueOf((leftEval.nextUnusedTemp - 1));
		}
		
		assert startNode.right.isTerminal() && startNode.left.isTerminal(); // Make sure this is direct expression
		
		String tempLeft = emitTemp(tempNum++);
		String tempRight = emitTemp(tempNum++);
		returnBlock.irGen += IRGenerator.emit(IRMap.assign(tempLeft, startNode.left.value));
		returnBlock.irGen += IRGenerator.emit(IRMap.assign(tempRight, startNode.right.value));
		
		// Generate a conditional label no matter what!
		// We need it for break statements as well
		// Conditional statement
		if (returnBlock.condLabel.isEmpty()) {
			returnBlock.condLabel = generateCondLabel();
		}
		
		switch (op) {
		case AND:
			returnBlock.irGen += IRGenerator.emit(IRMap.and(tempLeft, tempRight, emitTemp(tempNum++)));
			break;
		case DIV:
			returnBlock.irGen += IRGenerator.emit(IRMap.div(tempLeft, tempRight, emitTemp(tempNum++)));
		case EQUAL:
			returnBlock.irGen += IRGenerator.emit(IRMap.breq(tempLeft, tempRight, returnBlock.condLabel));
			break;
		case GREATER_THAN:
			returnBlock.irGen += IRGenerator.emit(IRMap.brgt(tempLeft, tempRight, returnBlock.condLabel));
			break;
		case GREATER_THAN_OR_EQUAL:
			returnBlock.irGen += IRGenerator.emit(IRMap.brgeq(tempLeft, tempRight, returnBlock.condLabel));
			break;
		case LESS_THAN:
			returnBlock.irGen += IRGenerator.emit(IRMap.brlt(tempLeft, tempRight, returnBlock.condLabel));
			break;
		case LESS_THAN_OR_EQUAL:
			returnBlock.irGen += IRGenerator.emit(IRMap.brleq(tempLeft, tempRight, returnBlock.condLabel));
			break;
		case MINUS:
			returnBlock.irGen += IRGenerator.emit(IRMap.sub(tempLeft, tempRight, emitTemp(tempNum++)));
			break;
		case MULT:
			returnBlock.irGen += IRGenerator.emit(IRMap.mult(tempLeft, tempRight, emitTemp(tempNum++)));
			break;
		case NOT_EQUAL:
			returnBlock.irGen += IRGenerator.emit(IRMap.brneq(tempLeft, tempRight, returnBlock.condLabel));
			break;
		case OR:
			returnBlock.irGen += IRGenerator.emit(IRMap.or(tempLeft, tempRight, emitTemp(tempNum++)));
			break;
		case PLUS:
			returnBlock.irGen += IRGenerator.emit(IRMap.add(tempLeft, tempRight, emitTemp(tempNum++)));
			break;
		default:
			// This should not happen
			throw new RuntimeException("ERROR: Unknown Binop on BinaryExpression.eval()!");
		}
		
		returnBlock.nextUnusedTemp = tempNum;
		return returnBlock;
	}
	
	/**
	 * Emits a temporary variable given a number.
	 * 
	 * @param tempNum The number to append to produce a valid temporary variable name.
	 * @return A valid temporary variable name.
	 */
	private String emitTemp(int tempNum) {
		return "t" + tempNum;
	}
	
	/**
	 * Generates a unique conditional label based on this BinaryExpression's hashcode.
	 * 
	 * @return A unique conditional label.
	 */
	private String generateCondLabel() {
		return String.valueOf(this.hashCode()).substring(
				String.valueOf(this.hashCode()).length() / 2, 
				String.valueOf(this.hashCode()).length()) 
				+ "-expr-eval";
	}
	
	/**
	 * A EvalReturn object contains a collection of objects 
	 * produced as a result of recursive evaluation.
	 */
	class EvalReturn {
		protected String irGen, condLabel;
		protected int nextUnusedTemp;
		
		/**
		 * Constructs a new EvalReturn object with given temporary variable.
		 * All other fields are blank.
		 * 
		 * @param nextUnusedTemp The next unused temporary variable able to be assigned.
		 */
		public EvalReturn(int nextUnusedTemp) {
			irGen = "";
			condLabel = "";
			this.nextUnusedTemp = nextUnusedTemp;
		}
		
		/**
		 * Constructs a new EvalReturn object with given irGen and target temp.
		 * This is useful when evaluating directly on a terminal.
		 * 
		 * All other fields are blank.
		 * 
		 * @param irGen Input IR translated code.
		 * @param nextUnusedTemp The next unused temporary variable.
		 */
		public EvalReturn(String irGen, int nextUnusedTemp) {
			this.irGen = irGen;
			condLabel = "";
			this.nextUnusedTemp = nextUnusedTemp;
		}
	}
}
