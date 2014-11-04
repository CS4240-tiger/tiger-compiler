/**
 * A TypeSymbolTableEntry is an SymbolTableEntry for type declarations.
 */
class TypeSymbolTableEntry extends SymbolTableEntry {
	/**
	 * The return type of this SymbolTableEntry.
	 */
	private TigerPrimitive type;
	
	/**
	 * For arrays. This is used for the length for 1D arrays and the first dimension for 2D arrays.
	 */
	private int width;
	
	/**
	 * For arrays. This is used for the second dimension for 2D arrays.
	 */
	private int height;
	
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
		this.width = 0;
		this.height = 0;
	}
	
	/**
	 * Constructs a new TypeSymbolTableEntry with specified backing type.
	 * 
	 * @param scope The parent scope of this TypeSymbolTableEntry.
	 * @param id The String identifier of this TypeSymbolTableEntry.
	 * @param type The backing type of this TypeSymbolTableEntry.
	 */
	protected TypeSymbolTableEntry(Scope scope, String id, TigerPrimitive type, int length) {
		super(scope, id);
		this.type = type;
		this.width = length;
		this.height = 0;
	}
	
	/**
	 * Constructs a new TypeSymbolTableEntry with specified backing type.
	 * 
	 * @param scope The parent scope of this TypeSymbolTableEntry.
	 * @param id The String identifier of this TypeSymbolTableEntry.
	 * @param type The backing type of this TypeSymbolTableEntry.
	 */
	protected TypeSymbolTableEntry(Scope scope, String id, TigerPrimitive type, int length, int height) {
		super(scope, id);
		this.type = type;
		this.width = length;
		this.height = height;
	}
	/**
	 * Returns the backing type of this TypeSymbolTableEntry.
	 * 
	 * @return The backing type of this TypeSymbolTableEntry.
	 */
	protected TigerPrimitive getBackingType() {
		return type;
	}
	
	/**
	 * Gets the width of the array if it is one
	 */
	protected int getWidth() {
		TigerPrimitive thisType = getBackingType();
		if (thisType == TigerPrimitive.INT_ARRAY || thisType == TigerPrimitive.FIXEDPT_ARRAY || thisType == TigerPrimitive.INT_2D_ARRAY || thisType == TigerPrimitive.FIXEDPT_2D_ARRAY) {
			return this.width;
		}
		return 0;
	}
	
	/**
	 * Gets the height of the array if it is one
	 */
	protected int getHeight() {
		TigerPrimitive thisType = getBackingType();
		if (thisType == TigerPrimitive.INT_ARRAY || thisType == TigerPrimitive.FIXEDPT_ARRAY || thisType == TigerPrimitive.INT_2D_ARRAY || thisType == TigerPrimitive.FIXEDPT_2D_ARRAY) {
			return this.height;
		}
		return 0;
	}
}