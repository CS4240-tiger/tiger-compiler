import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

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
		return emitLabel(id);
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
		
		if (function.getReturnType().getId().toLowerCase().equals("void")) {
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
	 * Attempts to write an input IR String list to a file.
	 * 
	 * @param filename The output file to write to.
	 * @param inputIR A list of IR Strings.
	 * @return True if write was successful; false otherwise.
	 */
	public static boolean writeIRToFile(String filename, List<String> inputIR) {
		try {
			FileWriter writer = new FileWriter(filename);
			for (String irLine : inputIR) {
				if (!irLine.equals("\n")) {
					writer.write(cleanUp(emit(irLine)));
				}
			}
			
			writer.close();
		} catch (IOException e) {
			System.out.println("ERROR: Writing IR to file failed!");
			return false;
		} 
		
		return true;
	}
	
	private static String cleanUp(String input) {
		return input.replaceAll("\n\n+", "\n");
	}
	
	/**
	 * Emits an input IRMap String and appends a newline character to the end.
	 * 
	 * @param input An input IRMap String.
	 * @return An IR output line.
	 */
	public static String emit(String input) {
		return input + "\n";
	}
	
	/**
	 * Emits a label given a label ID (appends a colon and space).
	 * 
	 * @param label An input label ID.
	 * @return A label to insert into IR.
	 */
	public static String emitLabel(String label) {
		return label + ": ";
	}
}
