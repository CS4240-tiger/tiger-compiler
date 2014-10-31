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
	 * The backing hashtable of this SymbolTable.
	 */
	private Map<String, SymbolTableEntry> backingTable;
	
	/**
	 * Instantiates a new SymbolTable.
	 */
	public SymbolTable() {
		backingTable = new HashMap<String, SymbolTableEntry>();
	}
	
	/**
	 * Adds a new Entry into this SymbolTable.
	 * 
	 * @param entry The Entry to add.
	 */
	public void put(SymbolTableEntry entry) {
		if (entry instanceof TigerVariable) {
			if (backingTable.get(entry.getId()) == null) {
				backingTable.put(entry.getId(), 
						new VariableSymbolTableEntry(
								entry.getScope(), 
								entry.getId(), 
								(TigerVariable) entry));
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
					}
					
				}
				
				// Otherwise, not found in accessible scope; safe to declare new entry in current scope
				resultVarList.add(addVar);
			}
		} else {	
			backingTable.put(entry.getId(), entry);
		}
	}
	
	/**
	 * Gets a SymbolTableEntry from this SymbolTable.
	 * 
	 * @param key The String id of the SymbolTableEntry to get.
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
				
				while (entryScope != null) {
					if (scope.equals(entryScope)) {
						return result;
					} else {
						// Check any parent scopes
						entryScope = entryScope.getParent();
					}
				}
			}
			
			// Not in accessible scope
			return result;
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
}