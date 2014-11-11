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
	private BinaryExpression left, right;
	/**
	 * A static value - used only if this is a terminal expression.
	 */
	private String value;
	/**
	 * The operator to apply between the left and right expressions.
	 */
	private Binop op;
	
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
		return (op == null) ? true : false;
	}
	
	// TODO: implement eval() tree traversal and IR generation
}
