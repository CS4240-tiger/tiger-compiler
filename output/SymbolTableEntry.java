public class SymbolTableEntry {
	/**
	 * The parent Scope of this SymbolTableEntry.
	 */
	private Scope scope;
	/**
	 * The String identifier of this SymbolTableEntry.
	 */
	private String id;
	
	/**
	 * Constructs a new general SymbolTableEntry, compatible for insertion into a SymbolTable.
	 * 
	 * @param scope The parent Scope of the SymbolTableEntry.
	 * @param id The String identifier of this SymbolTableEntry.
	 */
	public SymbolTableEntry(Scope scope, String id) {
		this.scope = scope;
		this.id = id;
	}
	
	/**
	 * Returns the Scope of this SymbolTableEntry.
	 * 
	 * @return The Scope of this SymbolTableEntry.
	 */
	public Scope getScope() {
		return scope;
	}
	
	/**
	 * Returns the String identifier of this SymbolTableEntry.
	 * 
	 * @return The String identifier of this SymbolTableEntry.
	 */
	public String getId() {
		return id;
	}
}