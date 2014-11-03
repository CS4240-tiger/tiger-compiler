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
	
	public static String add(String a, String b, String target) {
		
	}
	
	public static String sub(String a, String b, String target) {
		
	}
	
	public static String mult(String a, String b, String target) {
		
	}
	
	public static String div(String a, String b, String target) {
		
	}
	
	public static String and(String a, String b, String target) {
		
	}
	
	public static String or(String a, String b, String target) {
		
	}
	
	/* Goto (op, label) */
	
	public static String gotoLabel(String label) {
		
	}
	
	/* Branch (op, y, z, label) */
	
	public static String breq(String a, String b, String label) {
		
	}
	
	public static String brneq(String a, String b, String label) {
		
	}
	
	public static String brlt(String a, String b, String label) {
		
	}
	
	public static String brgt(String a, String b, String label) {
		
	}
	
	public static String brgeq(String a, String b, String label) {
		
	}
	
	public static String brleq(String a, String b, String label) {
		
	}
	
	/* Return (op, x) */
	
	public static String returnVal(String a) {
		
	}
	
	/* Function call, no return value (op, func_name, [param1 .. n]) */
	
	public static String call(String func_name, String[] params) {
		
	}
	
	/* Function call, with return value (op, x, func_name, [param1 .. n]) */
	
	public static String callr(String a, String func_name, String[] params) {
		
	}
	
	/* Store into array (op, array_name, offset, x) */
	
	public static String array_store(String array_name, int offset, String value) {
		
	}
	
	/* Load from array (op, x, array_name, offset) */
	
	public static String array_load(String a, String array_name, int offset) {
		
	}
	
	/* Array assignment (op, x, size, value) */
	
	public static String assign(String x, int size, int value) {
		
	}
}


