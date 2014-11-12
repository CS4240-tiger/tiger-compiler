/**
 * A SymbolTableEntry represents a symbol encountered during parsing which
 * can be inserted into a symbol table for semantic checks and translation.
 */
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
	
	/**
	 * Checks if the types are equal
	 * 
	 * @param the TypeSymbolTable that they are checking equality for
	 * 
	 * @return true if they are equal
	 * @return false if they are not equal
	 */
	
	public Boolean equals(SymbolTableEntry entry) {
		return this.id.equals(entry.getId());
	}
	
	/**
	 * Returns the ID.
	 * 
	 * @return The String ID.
	 */
	public String toString() {
		return getId();
	}
}