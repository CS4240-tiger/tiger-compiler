/**
 * An IRGenerator serves to provide direct translations between 
 * Tiger statements and an intermediate representation.
 */
public class IRGenerator {

	// No constructor.
	
	/**
	 * Returns an IR translation of a Tiger function declaration.
	 * NOTE: Everything but params can be populated from SymbolTable.
	 * 
	 * @param type The return type of the function - look this up in the symbol table!
	 * @param functID The ID of the function.
	 * @param params The parameters this function accepts.
	 * @return An IR translation of a Tiger function declaration.
	 */
	public static String funct_declaration(TigerPrimitive type, String functID, String[] params) {
		// TODO: implement
		return "";
	}
	
	/**
	 * Returns an IR translation of a Tiger end-block tail.
	 * 
	 * @param tigerInput The input Tiger line.
	 * @return An IR translation of a Tiger end-block tail.
	 */
	public static String block_end(String tigerInput) {
		// TODO: implement
		return "";
	}
	
	/**
	 * Returns an IR translation of a Tiger declaration statement.
	 * 
	 * @param tigerInput The input Tiger line.
	 * @return An IR translation of a Tiger declaration statement.
	 */
	public static String declaration_statement(String tigerInput) {
		// TODO: implement
		return "";
	}
	
	// TODO: Continue from type_declaration downwards
}
