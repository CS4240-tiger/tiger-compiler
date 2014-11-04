/**
 * A Scope is a structure used to group local variables in a logical block.
 */
public class Scope {
	/**
	 * The parent Scope of this Scope.
	 */
	private Scope parent;
	/**
	 * A string identifier for this Scope.
	 */
	private String id;
	/**
	 * The number of children Scopes referencing this scope as a parent.
	 */
	private int numChildren;
	
	/**
	 * Constructs a new Scope with given parent Scope only.
	 * This is useful when defining a new block inside an existing function.
	 * 
	 * @param parent The owning parent Scope.
	 */
	public Scope(Scope parent) {
		this.parent = parent;
		this.numChildren = 0;
		parent.numChildren++;
		this.id = parent.id + parent.numChildren;
	}
	
	/**
	 * Constructs a new Scope with given parent Scope and ID.
	 * This is useful when defining a new function.
	 * 
	 * @param parent The owning parent Scope.
	 * @param id A String identifier of this Scope (generally a function ID).
	 */
	public Scope(Scope parent, String id) {
		this.parent = parent;
		this.numChildren = 0;
		parent.numChildren++;
		System.out.println(parent.getId());
		if (parent.getId().replaceAll("[^A-Za-z]","").equals(id)) {
			this.id = parent.id + parent.numChildren;
		} else {
			this.id = id;
		}
	}
	
	/**
	 * Constructs a new global Scope (no parent).
	 */
	public Scope() {
		this.parent = null;
		this.numChildren = 0;
		this.id = "GLOBAL_SCOPE";
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
	
	/**
	 * Returns the String identifier.
	 * 
	 * @return The String identifier.
	 */
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object scope) {
		if (scope instanceof Scope) {
			if (((Scope) scope).getId().equals(this.id)) {
				return true;
			}
		}
		
		return false;
	}
}