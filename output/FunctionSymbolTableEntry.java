import java.util.List;

/**
 * A FunctionSymbolTableEntry is an SymbolTableEntry for function declarations.
 */
public class FunctionSymbolTableEntry extends SymbolTableEntry {
	/**
	 * The return type of this SymbolTableEntry.
	 */
	private String returnType;
	
	/**
	 * The list of parameter types for checking during function calls
	 */
	private List<String> paramTypeList;
	
	/**
	 * Constructs a new FunctionSymbolTableEntry with specified return type.
	 * 
	 * @param scope The parent scope of this FunctionSymbolTableEntry.
	 * @param id The String identifier of this FunctionSymbolTableEntry.
	 * @param returnType The return type of this FunctionSymbolTableEntry.
	 */
	protected FunctionSymbolTableEntry(Scope scope, String id, String returnType, List<String> paramList) {
		super(scope, id);
		this.paramTypeList = paramList;
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
	
	/**
	 * Returns the ArrayList of parameter types
	 * 
	 * @return The ArrayList of parameter types
	 */
	protected List<String> getParamTypeList() {
		return this.paramTypeList;
	}
}