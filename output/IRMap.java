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
		String base = "assign, $a, $b, ";

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
		String base = "add, $a, $b, $target";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$target", target);
		
		return base;
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
		String base = "sub, $a, $b, $target";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$target", target);
		
		return base;
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
		String base = "mult, $a, $b, $target";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$target", target);
		
		return base;
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
		String base = "div, $a, $b, $target";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$target", target);
		
		return base;
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
		String base = "and, $a, $b, $target";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$target", target);
		
		return base;
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
		String base = "or, $a, $b, $target";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$target", target);
		
		return base;
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
		String base = "goto, $label, , ";
		
		base = base.replace("$label", label);
		
		return base;
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
		String base = "breq, $a, $b, $label";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$label", label);
		
		return base;
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
		String base = "brneq, $a, $b, $label";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$label", label);
		
		return base;
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
		String base = "brlt, $a, $b, $label";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$label", label);
		
		return base;
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
		String base = "brgt, $a, $b, $label";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$label", label);
		
		return base;
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
		String base = "brgeq, $a, $b, $label";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$label", label);
		
		return base;
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
		String base = "brleq, $a, $b, $label";
		
		base = base.replace("$a", a);
		base = base.replace("$b", b);
		base = base.replace("$label", label);
		
		return base;
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
		String base = "return, $a, , ";
		
		base = base.replace("$a", a);
		
		return base;
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
		String base = "call, $func_name, $params";
		
		base = base.replace("$func_name", func_name);
		
		// Convert params into simple comma-delimited String
		String flatParams = params[0];
		for (int paramIndex = 1; paramIndex < params.length; paramIndex++) {
			flatParams += (", " + params[paramIndex]);
		}
		
		base = base.replace("$params", flatParams);
		
		return base;
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
		String base = "callr, $a, $func_name, $params";
		
		base = base.replace("$a", a);
		base = base.replace("$func_name", func_name);
		
		// Convert params into simple comma-delimited String
		String flatParams = params[0];
		for (int paramIndex = 1; paramIndex < params.length; paramIndex++) {
			flatParams += (", " + params[paramIndex]);
		}
		
		base = base.replace("$params", flatParams);
		
		return base;
	}
	
	/* Store into array (op, array_name, offset, x) */
	
	/**
	 * Stores a value into an array's index.
	 * 
	 * @param array_name The name of the array.
	 * @param offset The index into the array.
	 * @param value The value to store into the array at index.
	 * @return The generated IR code.
	 */
	public static String array_store(String array_name, int offset, String value) {
		String base = "array_store, $array_name, $offset, $value";
		
		base = base.replace("$array_name", array_name);
		base = base.replace("$offset", String.valueOf(offset));
		base = base.replace("$value", value);
		
		return base;
	}
	
	/* Load from array (op, x, array_name, offset) */
	
	/**
	 * Loads a value from an array's index into a variable.
	 * 
	 * @param a A variable to load the array's value at index in to.
	 * @param array_name The name of the array.
	 * @param offset The index into the array.
	 * @return The generated IR code.
	 */
	public static String array_load(String a, String array_name, int offset) {
		String base = "array_load, $a, $array_name, $offset";
		
		base = base.replace("$a", a);
		base = base.replace("$array_name", array_name);
		base = base.replace("$offset", String.valueOf(offset));
		
		return base;
	}
	
	/* Array assignment (op, x, size, value) */
	
	/**
	 * Populates an array with a static value.
	 * NOTE: value is of type String to handle all value types.
	 * 
	 * @param array_name The name of the array.
	 * @param size The size of the array.
	 * @param value The value to set all locations in the array to.
	 * @return The generated IR code.
	 */
	public static String assign(String array_name, int size, String value) {
		String base = "assign, $array_name, $size, $value";
		
		base = base.replace("$array_name", array_name);
		base = base.replace("$size", String.valueOf(size));
		base = base.replace("$value", value);
		
		return base;
	}
}


