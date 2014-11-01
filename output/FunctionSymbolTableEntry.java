/**
 * A FunctionSymbolTableEntry is an SymbolTableEntry for function declarations.
 */
public class FunctionSymbolTableEntry extends SymbolTableEntry {
	/**
	 * The return type of this SymbolTableEntry.
	 */
	private String returnType;
	
	/**
	 * Constructs a new FunctionSymbolTableEntry with specified return type.
	 * 
	 * @param scope The parent scope of this FunctionSymbolTableEntry.
	 * @param id The String identifier of this FunctionSymbolTableEntry.
	 * @param returnType The return type of this FunctionSymbolTableEntry.
	 */
	protected FunctionSymbolTableEntry(Scope scope, String id, String returnType) {
		super(scope, id);
		this.returnType = returnType;
	}
	
	/**
	 * Returns the return type of this TigerFunctionSymbolTableEntry.
	 * 
	 * @return The return type of this TigerFunctionSymbolTableEntry.
	 */
	protected String getReturnType() {
		return returnType;
	}
}