/**
 * A TypeSymbolTableEntry is an SymbolTableEntry for type declarations.
 */
class TypeSymbolTableEntry extends SymbolTableEntry {
	/**
	 * The return type of this SymbolTableEntry.
	 */
	private TigerPrimitive type;
	
	/**
	 * Constructs a new TypeSymbolTableEntry with specified backing type.
	 * 
	 * @param scope The parent scope of this TypeSymbolTableEntry.
	 * @param id The String identifier of this TypeSymbolTableEntry.
	 * @param type The backing type of this TypeSymbolTableEntry.
	 */
	protected TypeSymbolTableEntry(Scope scope, String id, TigerPrimitive type) {
		super(scope, id);
		this.type = type;
	}
	
	/**
	 * Returns the backing type of this TypeSymbolTableEntry.
	 * 
	 * @return The backing type of this TypeSymbolTableEntry.
	 */
	protected TigerPrimitive getBackingType() {
		return type;
	}
}