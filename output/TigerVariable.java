/**
 * A TigerVariable represents a declared variable in a given scope.
 */
public class TigerVariable extends SymbolTableEntry {
	/**
	 * The backing value of this TigerVariable.
	 */
	private Object value;
	/**
	 * The backing (Tiger) primitive of this TigerVariable.
	 */
	private TigerPrimitive type;
	/**
	 * The declared type of the variable.
	 */
	private TypeSymbolTableEntry declaredType;
	
	/**
	 * Constructs a new TigerVariable with provided Scope, String identifier, and backing value and backing type.
	 * This is for when the value is not initialized and set to null
	 * 
	 * @param scope The parent Scope of this variable.
	 * @param id The String identifier of this variable.
	 * @param value The backing value of this variable.
	 * @param backingType the backing type of the variable
	 */
	/**public TigerVariable(Scope scope, String id, Object value, TigerPrimitive backingType) {
		super(scope,id);
		this.value = value;
		this.type = backingType;
		this.declaredType = null; 
	}**/
	
	/**
	 * Constructs a new TigerVariable with provided Scope, String identifier, and backing value.
	 * This constructor is designed for primitive variable declarations, and the declared type
	 * will be set to the primitive this variable matches against.
	 * 
	 * @param scope The parent Scope of this variable.
	 * @param id The String identifier of this variable.
	 * @param value The backing value of this variable.
	 */
	/**public TigerVariable(Scope scope, String id, Object value) {
		super(scope, id);
		this.value = value;
		primitiveCheck(value);
		declaredType = null;
	}**/
	/**
	 * Constructs a new TigerVariable with provided Scope, String identifier, backing value, and declared type.
	 * This constructor is meant for variable declarations with previous type declarations.
	 * 
	 * @param scope The parent Scope of this variable.
	 * @param id The String identifier of this variable.
	 * @param value The backing value of this variable.
	 * @param declaredType The declared type of this variable.
	 */
	public TigerVariable(Scope scope, String id, Object value, TypeSymbolTableEntry declaredType, TigerPrimitive backingType) {
		super(scope, id);
		this.type = backingType;
		this.declaredType = declaredType;
	}
	
	
	/**
	 * Matches the backing value against a Tiger primitive.
	 * 
	 * @param value The value to check against Tiger primitives.
	 */
	private boolean primitiveCheck(Object value) {
		boolean result = false;
		
		if (value instanceof Integer) {
			type = TigerPrimitive.INT;
			result = true;
		} else if (value instanceof Double) {
			type = TigerPrimitive.FIXEDPT;
			result = true;
		} else if (value instanceof Integer[]) {
			type = TigerPrimitive.INT_ARRAY;
			result = true;
		} else if (value instanceof Double[]) {
			type = TigerPrimitive.FIXEDPT_ARRAY;
			result = true;
		} else if (value instanceof Integer[][]) {
			type = TigerPrimitive.INT_2D_ARRAY;
			result = true;
		} else if (value instanceof Double[][]) {
			type = TigerPrimitive.FIXEDPT_2D_ARRAY;
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Returns the declared type of this variable. 
	 * 
	 * @return The declared type of this variable. 
	 */
	public TypeSymbolTableEntry getType() {
		return declaredType;
	}
	
	/**
	 * Returns the backing primitive type of this variable. 
	 * 
	 * @return The backing primitive type of this variable. 
	 */
	public TigerPrimitive getBackingType() {
		return type;
	}
	
	/**
	 * Returns the backing value of this variable.
	 * 
	 * @return The backing value of this variable.
	 */
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object value) {
		if (!primitiveCheck(value)) {
			throw new RuntimeException("Error: Attempt to reassign existing value with differing type!");
		}
		
		this.value = value;
	}
}
