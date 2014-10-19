import java.util.HashMap;
import java.util.Map;

/**
 * A Scope is a structure used to group local variables in a logical block.
 */
public class Scope {
	/**
	 * The parent Scope of this Scope.
	 */
	private Scope parent;
	/**
	 * Local variables defined in this Scope.
	 */
	private Map<String, TigerValue> vars;

	/**
	 * Constructs a new Scope with given parent Scope.
	 * 
	 * @param parent The owning parent Scope.
	 */
	public Scope(Scope parent) {
		this.parent = parent;
		vars = new HashMap<String, TigerValue>();
	}
	
	/**
	 * Constructs a new global Scope (no parent).
	 */
	public Scope() {
		this(null);
	}

	/**
	 * Assigns a TigerValue to a String identifier.
	 * 
	 * If the variable doesn't exist, it is local to this Scope; 
	 * otherwise, reassign it in the owning parent Scope.
	 * 
	 * @param id The String identifier of the variable to assign.
	 * @param value The value to associate with the id.
	 */
	public void assign(String id, TigerValue value) {
		if (resolve(id) != null) {
			// Variable exists in this Scope or parent Scope!
			this.reassign(id, value);
		} else {
			// Variable doesn't exist and should be local to this Scope
			vars.put(id, value);
		}
	}
	
	/**
	 * Resolves a variable into its value by a String id.
	 * 
	 * If the variable was not declared in this Scope, attempts to
	 * resolve from its parent Scope.
	 * 
	 * @param id The String identifier of the variable to resolve.
	 * @return The resolved variable as a TigerValue, or null if not found.
	 */
	public TigerValue resolve(String id) {
		TigerValue value = vars.get(id);
		
		if (value != null) {
			// Local variable
			return value;
		} else if (!isGlobalScope()) {
			// If this isn't the global Scope, let parent Scope search for it
			return parent.resolve(id);
		} else {
			// Variable not found
			return null;
		}
	}
	
	/**
	 * Reassigns a variable in its parent Scope by a String identifier.
	 * 
	 * @param id The String identifier of the variable to assign.
	 * @param value The value to associate with the id.
	 */
	private void reassign(String id, TigerValue value) {
		if (vars.containsKey(id)) {
			// The variable is local to this Scope!
			vars.put(id, value);
		} else if(!isGlobalScope()) {
			// The variable is not local, so reassign it in parent
			parent.reassign(id, value);
		}
	}

	/**
	 * Returns a shallow copy of this Scope.
	 * 
	 * @return A shallow copy of this Scope.
	 */
	public Scope copy() {
		Scope scope = new Scope();
		scope.vars = new HashMap<String, TigerValue>(this.vars);
		return scope;
	}

	/**
	 * Returns if this Scope is the global Scope (characterized by a null parent).
	 * 
	 * @return True if this Scope is the global Scope; false otherwise.
	 */
	public boolean isGlobalScope() {
		return parent == null;
	}

	/**
	 * Returns the parent Scope.
	 * 
	 * @return The parent Scope.
	 */
	public Scope getParent() {
		return parent;
	}
}