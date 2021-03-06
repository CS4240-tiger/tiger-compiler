import java.util.List;

/**
 * A FunctionSymbolTableEntry is an SymbolTableEntry for function declarations.
 */
public class FunctionSymbolTableEntry extends SymbolTableEntry {
	/**
	 * The return type of this SymbolTableEntry.
	 */
	private TypeSymbolTableEntry returnType;
	
	/**
	 * The list of parameter types for checking during function calls
	 */
	private List<TypeSymbolTableEntry> paramTypeList;
	
	/**
	 * Constructs a new FunctionSymbolTableEntry with specified return type.
	 * 
	 * @param scope The parent scope of this FunctionSymbolTableEntry.
	 * @param id The String identifier of this FunctionSymbolTableEntry.
	 * @param returnType The return type of this FunctionSymbolTableEntry.
	 * @param paramList A list of parameter types this function accepts.
	 */
	protected FunctionSymbolTableEntry(Scope scope, String id, TypeSymbolTableEntry returnType, 
			List<TypeSymbolTableEntry> paramList) {
		super(scope, id);
		this.paramTypeList = paramList;
		this.returnType = returnType;
	}
	
	/**
	 * Returns the return type of this TigerFunctionSymbolTableEntry.
	 * 
	 * @return The return type of this TigerFunctionSymbolTableEntry.
	 */
	protected TypeSymbolTableEntry getReturnType() {
		return returnType;
	}
	
	/**
	 * Returns the ArrayList of parameter types
	 * 
	 * @return The ArrayList of parameter types
	 */
	protected List<TypeSymbolTableEntry> getParamTypeList() {
		return this.paramTypeList;
	}
	
	public String toString() {
		if (returnType != null) {
			return "Function:" + this.getId() +"| Return Type:"+this.returnType.getId()+"| Scope:"+this.getScope().getId()+"| # of Parameters: "+ ((this.paramTypeList != null) ? this.paramTypeList.size() : "0");
		} else {
			return "Function:" + this.getId() +"| Return Type: void| Scope:"+this.getScope().getId()+"| # of Parameters: "+ ((this.paramTypeList != null) ? this.paramTypeList.size() : "0");
		}
	}
}