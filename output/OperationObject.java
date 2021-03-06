/**
 * Object that hopefully makes type checking a lot easier
 * 
 * @author cevanish12
 *
 */
public class OperationObject {
	
	/**
	 * Whether or not this object is a constant
	 */
	private Boolean isConst;
	
	/**
	 * The type of this object
	 */
	private TypeSymbolTableEntry type;
	
	/**
	 * The id for this object
	 */
	private String id;
	
	public OperationObject(Boolean isConst, TypeSymbolTableEntry type, String id) {
		this.isConst = isConst;
		this.type = type;
		this.id = id;
	}

	/**
	 * the getter for isConst
	 * 
	 * @return isConst
	 */
	public Boolean isConstant() {
		return this.isConst;
	}
	
	/**
	 * the getter for the type of this object
	 * 
	 * @return the type of this object
	 */
	public TypeSymbolTableEntry getType() {
		return this.type;
	}
	
	/**
	 * the getter for the id
	 * 
	 * @return the id for this object
	 */
	public String getId() {
		return this.id;
	}
}
