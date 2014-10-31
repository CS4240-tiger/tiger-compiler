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
	private String declaredType;
	
	/**
	 * Constructs a new TigerVariable with provided Scope, String identifier, and backing value.
	 * This constructor is designed for primitive variable declarations, and the declared type
	 * will be set to the primitive this variable matches against.
	 * 
	 * @param scope The parent Scope of this variable.
	 * @param id The String identifier of this variable.
	 * @param value The backing value of this variable.
	 */
	public TigerVariable(Scope scope, String id, Object value) {
		super(scope, id);
		this.value = value;
		primitiveCheck();
		declaredType = type.name().toLowerCase();
	}
	
	/**
	 * Constructs a new TigerVariable with provided Scope, String identifier, backing value, and declared type.
	 * This constructor is meant for variable declarations with previous type declarations.
	 * 
	 * @param scope The parent Scope of this variable.
	 * @param id The String identifier of this variable.
	 * @param value The backing value of this variable.
	 * @param declaredType The declared type of this variable.
	 */
	public TigerVariable(Scope scope, String id, Object value, String declaredType) {
		this(scope, id, value);
		this.declaredType = declaredType;
	}
	
	/**
	 * Matches the backing value against a Tiger primitive.
	 */
	private void primitiveCheck() {
		if (value instanceof Integer) {
			type = TigerPrimitive.INT;
		} else if (value instanceof Double) {
			type = TigerPrimitive.FIXEDPT;
		} else if (value instanceof Integer[]) {
			type = TigerPrimitive.INT_ARRAY;
		} else if (value instanceof Double[]) {
			type = TigerPrimitive.FIXEDPT_ARRAY;
		} else if (value instanceof Integer[][]) {
			type = TigerPrimitive.INT_2D_ARRAY;
		} else if (value instanceof Double[][]) {
			type = TigerPrimitive.FIXEDPT_2D_ARRAY;
		}
	}
	
	/**
	 * Returns the declared type of this variable. 
	 * 
	 * @return The declared type of this variable. 
	 */
	public String getType() {
		return declaredType;
	}
	
	/**
	 * Returns the backing primitive type of this variable. 
	 * 
	 * @return The backing primitive type of this variable. 
	 */
	public String getBackingType() {
		return type.name().toLowerCase();
	}
}
