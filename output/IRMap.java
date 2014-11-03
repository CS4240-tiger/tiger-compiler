/**
 * An IRMap provides an API to generate IR code via function calls.
 */
public final class IRMap {
	
	/* Assignment (op, x, y) */
	
	/**
	 * Assigns a value to a variable.
	 * (Literals should be converted to String before call.)
	 * 
	 * @param a The variable to assign to.
	 * @param b The value to assign to the variable.
	 * @return The generated IR code.
	 */
	public static String assign(String a, String b) {
		String base = "assign, $a, $b";

		base = base.replace("$a", a);
		base = base.replace("$b", b);
		
		return base;
	}
	
	/* Binary operation (op, y, z, x) */
	
	/**
	 * Adds (a + b) and stores the result in target temporary variable.
	 * 
	 * @param a The first value to add.
	 * @param b The second value to add.
	 * @param target A target temporary variable.
	 * @return The generated IR code.
	 */
	public static String add(String a, String b, String target) {
		
	}
	
	/**
	 * Subtracts (a - b) and stores the result in target temporary variable.
	 * 
	 * @param a The first value to subtract.
	 * @param b The second value to subtract.
	 * @param target A target temporary variable.
	 * @return The generated IR code.
	 */
	public static String sub(String a, String b, String target) {
		
	}
	
	/**
	 * Multiplies (a * b) and stores the result in target temporary variable.
	 * 
	 * @param a The first value to multiply.
	 * @param b The second value to multiply.
	 * @param target A target temporary variable.
	 * @return The generated IR code.
	 */
	public static String mult(String a, String b, String target) {
		
	}
	
	/**
	 * Divides (a / b) and stores the result in target temporary variable.
	 * 
	 * @param a The first value to divide.
	 * @param b The second value to divide.
	 * @param target A target temporary variable.
	 * @return The generated IR code.
	 */
	public static String div(String a, String b, String target) {
		
	}
	
	/**
	 * ANDs (a & b) and stores the result in target temporary variable.
	 * 
	 * @param a The first value to AND.
	 * @param b The second value to AND.
	 * @param target A target temporary variable.
	 * @return The generated IR code.
	 */
	public static String and(String a, String b, String target) {
		
	}
	
	/**
	 * ORs (a | b) and stores the result in target temporary variable.
	 * 
	 * @param a The first value to OR.
	 * @param b The second value to OR.
	 * @param target A target temporary variable.
	 * @return The generated IR code.
	 */
	public static String or(String a, String b, String target) {
		
	}
	
	/* Goto (op, label) */
	
	/**
	 * Jumps to a specified label in the program.
	 * NOTE: The IR function is "goto," but this is reserved in Java.
	 * 
	 * @param label The label to jump to.
	 * @return The generated IR code.
	 */
	public static String gotoLabel(String label) {
		
	}
	
	/* Branch (op, y, z, label) */
	
	/**
	 * If (a == b), branch to label.
	 * 
	 * @param a The first value to compare. 
	 * @param b The second value to compare.
	 * @param label The label to jump to if true.
	 * @return The generated IR code.
	 */
	public static String breq(String a, String b, String label) {
		
	}
	
	/**
	 * If (a != b), branch to label.
	 * 
	 * @param a The first value to compare.
	 * @param b The second value to compare.
	 * @param label The label to jump to if true.
	 * @return The generated IR code.
	 */
	public static String brneq(String a, String b, String label) {
		
	}
	
	/**
	 * If (a < b), branch to label.
	 * 
	 * @param a The first value to compare.
	 * @param b The second value to compare.
	 * @param label The label to jump to if true.
	 * @return The generated IR code.
	 */
	public static String brlt(String a, String b, String label) {
		
	}
	
	/**
	 * If (a > b), branch to label.
	 * 
	 * @param a The first value to compare.
	 * @param b The second value to compare.
	 * @param label The label to jump to if true.
	 * @return The generated IR code.
	 */
	public static String brgt(String a, String b, String label) {
		
	}
	
	/**
	 * If (a >= b), branch to label.
	 * 
	 * @param a The first value to compare.
	 * @param b The second value to compare.
	 * @param label The label to jump to if true.
	 * @return The generated IR code.
	 */
	public static String brgeq(String a, String b, String label) {
		
	}
	
	/**
	 * If (a <= b), branch to label.
	 * 
	 * @param a The first value to compare.
	 * @param b The second value to compare.
	 * @param label The label to jump to if true.
	 * @return The generated IR code.
	 */
	public static String brleq(String a, String b, String label) {
		
	}
	
	/* Return (op, x) */
	
	/**
	 * Returns a value.
	 * NOTE: The IR function is "return," but this is reserved in Java.
	 * 
	 * @param a The value to return.
	 * @return The generated IR code.
	 */
	public static String returnVal(String a) {
		
	}
	
	/* Function call, no return value (op, func_name, [param1 .. n]) */
	
	/**
	 * Calls a void function (no return value).
	 * 
	 * @param func_name The name of the function to call.
	 * @param params An array of parameters to pass into the function.
	 * @return The generated IR code.
	 */
	public static String call(String func_name, String[] params) {
		
	}
	
	/* Function call, with return value (op, x, func_name, [param1 .. n]) */
	
	/**
	 * Calls a function with a return value and assigns the 
	 * return value to a variable.
	 * 
	 * @param a A variable to assign to the function's return value.
	 * @param func_name The name of the function to call.
	 * @param params An array of parameters to pass into the function.
	 * @return The generated IR code.
	 */
	public static String callr(String a, String func_name, String[] params) {
		
	}
	
	/* Store into array (op, array_name, offset, x) */
	
	/**
	 * 
	 * @param array_name
	 * @param offset
	 * @param value
	 * @return The generated IR code.
	 */
	public static String array_store(String array_name, int offset, String value) {
		
	}
	
	/* Load from array (op, x, array_name, offset) */
	
	/**
	 * 
	 * @param a
	 * @param array_name
	 * @param offset
	 * @return The generated IR code.
	 */
	public static String array_load(String a, String array_name, int offset) {
		
	}
	
	/* Array assignment (op, x, size, value) */
	
	/**
	 * 
	 * @param x
	 * @param size
	 * @param value
	 * @return The generated IR code.
	 */
	public static String assign(String x, int size, int value) {
		
	}
}


