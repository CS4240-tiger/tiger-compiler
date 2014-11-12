import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A symbol table contains the symbols generated from walking a parse tree.
 * 
 * Symbol tables contain information about variable type, scope, arguments, 
 * and return types, whatever applicable.
 */
public class SymbolTable {
	/**
	 * The size of this SymbolTable.
	 */
	private int size;
	/**
	 * The backing hashtable of this SymbolTable.
	 */
	private Map<String, SymbolTableEntry> backingTable;
	
	/**
	 * the type entry for int
	 * makes it easier to deal with functions
	 */
	private TypeSymbolTableEntry intType;
	
	/**
	 * the type entry for fixedpt
	 * makes it easier to deal with functions
	 */
	private TypeSymbolTableEntry fixedptType;
	
	/**
	 * Instantiates a new SymbolTable.
	 */
	public SymbolTable() {
		backingTable = new HashMap<String, SymbolTableEntry>();
		this.intType =  new TypeSymbolTableEntry(new Scope(),"int", TigerPrimitive.INT);
		this.fixedptType = new TypeSymbolTableEntry(new Scope(),"fixedpt", TigerPrimitive.FIXEDPT);
		put(this.intType);
		put(this.fixedptType);
	}
	
	/**
	 * Adds a new Entry into this SymbolTable.
	 * 
	 * @param entry The Entry to add.
	 */
	public void put(SymbolTableEntry entry) {
		if (!idExists(entry.getId(),entry.getScope())) {
			if (entry instanceof TigerVariable) {
				if (backingTable.get(entry.getId()) == null) {
					backingTable.put(entry.getId(), 
							new VariableSymbolTableEntry(
									entry.getScope(), 
									entry.getId(), 
									(TigerVariable) entry));
					//System.out.println(((TigerVariable)entry).getId()+":"+((TigerVariable)entry).getBackingType());
				} else {
					// Check if it exists
					List<TigerVariable> resultVarList = ((VariableSymbolTableEntry) backingTable.get(entry.getId())).backingList;
					TigerVariable addVar = ((TigerVariable) entry);
					Scope curScope = addVar.getScope();
					for (int index = 0; index < resultVarList.size(); index++) {
						while (curScope != null) {
							if (curScope.equals(resultVarList.get(index))) {
								// Found value in this or parent Scope! Reassign it.
								resultVarList.get(index).setValue(addVar.getValue());
								return;
							}
							
							curScope = curScope.getParent();
						}
						
					}
					
					// Otherwise, not found in accessible scope; safe to declare new entry in current scope
					//System.out.println(addVar.getId()+":"+addVar.getBackingType());
					resultVarList.add(addVar);
				}
			} else {	
				backingTable.put(entry.getId(), entry);
				size++;
				/**if (entry instanceof TypeSymbolTableEntry) {
					System.out.println(String.valueOf(((TypeSymbolTableEntry)(entry)).getBackingType()) + ((TypeSymbolTableEntry)(entry)).getWidth());
				} else if (entry instanceof FunctionSymbolTableEntry) {
					if (((FunctionSymbolTableEntry) entry).getParamTypeList() != null) {
						System.out.println(((FunctionSymbolTableEntry) entry).getId()+" has a size of " + ((FunctionSymbolTableEntry) entry).getParamTypeList().size());
					} else {
						System.out.println(((FunctionSymbolTableEntry) entry).getId()+" has a size of 0");
					}
				}**/
				//System.out.println(entry.getScope().getId()+":"+entry.getId());
			}
		}
	}
	
	/**
	* checks if another id exists in the symbol table
	* @return true if this id is also a name of a type or function name
	* @return false if no such id exists or that id is a variable name
	*
	**/
	public boolean idExists(String id, Scope thisScope) {
	  SymbolTableEntry entry= this.get(id, thisScope);
	  if (entry != null && (entry instanceof TypeSymbolTableEntry || entry instanceof FunctionSymbolTableEntry)) {
	    System.out.println(id +" is already a name of a function or a type");
	    return true;
	  }
	  return false;
	}
	
	/**
	 * Gets a SymbolTableEntry from this SymbolTable.
	 * 
	 * @param key The String id of the SymbolTableEntry to get.
	 * @param scope the current scope that we are currently in?
	 * @return the symbol table entry
	 */
	public SymbolTableEntry get(String key, Scope scope) {
		SymbolTableEntry entry = backingTable.get(key);
		
		// If it's a variable, search through the LinkedList until we find one in matching scope
		if (entry instanceof VariableSymbolTableEntry) {
			SymbolTableEntry result = null;
			Scope entryScope = null;
			
			for (int index = 0; index < ((VariableSymbolTableEntry) entry).backingList.size(); index++) {
				result = ((VariableSymbolTableEntry) entry).backingList.get(index);
				entryScope = result.getScope();
				
				while (scope != null) {
					if (entryScope.equals(scope)) {
						return result;
					} else {
						// Check any parent scopes
						scope = scope.getParent();
					}
				}
			}
			// Not in accessible scope
			return null;
		} else if (entry instanceof TypeSymbolTableEntry) {
			//check if we can access this type
			if (entry.getScope().isAncestor(scope)) {
				return entry;
			} 
			return null;
		}
		
		return entry;
	}
	
	/**
	 * Removes a SymbolTableEntry from this SymbolTable.
	 * 
	 * @param key The String id of the SymbolTableEntry to remove.
	 */
	public void remove(String key) {
		backingTable.remove(key);
	}

	/**
	 * Returns the size of this SymbolTable.
	 * 
	 * @return The size of this SymbolTable.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns the TypeTableEntry for the primitive int to make life ezpz
	 * 
	 * @return the TypeTableEntry for the primitive int
	 */
	public TypeSymbolTableEntry getIntType() {
		return this.intType;
	}
	
	/**
	 * Returns the TypeTableEntry for the primitive fixedpt to make life ezpz
	 * 
	 * @return the TypeTableEntry for the primitive fixedpt
	 */
	public TypeSymbolTableEntry getFixedPtType() {
		return this.fixedptType;
	}
}
