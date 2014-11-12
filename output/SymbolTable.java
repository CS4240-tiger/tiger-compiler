import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		prePopulate();
	}
	
	/**
	 * Adds a new Entry into this SymbolTable.
	 * 
	 * @param entry The Entry to add.
	 */
	public void put(SymbolTableEntry entry) {
		//if (!idExists(entry.getId(),entry.getScope())) {
			if (entry instanceof TigerVariable) {
				if (backingTable.get(entry.getId()) == null) {
					backingTable.put(entry.getId(), 
							new VariableSymbolTableEntry(
									entry.getScope(), 
									entry.getId(), 
									(TigerVariable) entry));
					//System.out.println(((TigerVariable)entry).getId()+":"+((TigerVariable)entry).getScope().getId());
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
					//System.out.println(addVar.getId()+":"+addVar.getScope().getId());
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
		//}
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
						//System.out.println(scope.getId()+"<-"+ scope.getParent().getId());
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
	
	/**
	 * Pops all variables from a block's scope.
	 * Useful to clear non-accessible entries on block exit.
	 * 
	 * @param scope The scope to pop entries from.
	 */
	public void popAllVarsInScope(Scope scope) {
		Iterator<String> keySetIter = backingTable.keySet().iterator();
		SymbolTableEntry currentEntry = null;
		TigerVariable var = null;
		
		while (keySetIter.hasNext()) {
			String id = keySetIter.next();
			
			currentEntry = backingTable.get(id);
			if (currentEntry instanceof VariableSymbolTableEntry) {
				for (int index = 0; index < ((VariableSymbolTableEntry) currentEntry).backingList.size(); index++) {
					var = ((VariableSymbolTableEntry) currentEntry).backingList.get(index);
					if (var.getScope().equals(scope)) {
						// DEBUG
						System.out.println("Removing " + id + " from symbol table. (Exiting scope " + scope.getId() + ")");
						// DEBUG
						((VariableSymbolTableEntry) currentEntry).backingList.remove(index);
					}
				}
				
				// If VariableSymbolTableEntry now has 0 members in list, remove id mapping
				if (((VariableSymbolTableEntry) currentEntry).backingList.size() == 0) {
					keySetIter.remove();
				}
				
			}
		}
	}
	
	/**
	 * Pre-populates the SymbolTable with primitive types and library functions.
	 */
	private void prePopulate() {
		List<TypeSymbolTableEntry> args = new ArrayList<TypeSymbolTableEntry>();
		
		this.intType =  new TypeSymbolTableEntry(new Scope(), "int", TigerPrimitive.INT);
		this.fixedptType = new TypeSymbolTableEntry(new Scope(), "fixedpt", TigerPrimitive.FIXEDPT);
		
		put(this.intType);
		put(this.fixedptType);
		
		// Use this only for string library functions (is it safe to remove later?)
		TypeSymbolTableEntry string = new TypeSymbolTableEntry(new Scope(), "string", TigerPrimitive.STRING);
		args.add(string);
		
		/* String parameter functions */
		
		/**
		 * function print(s : string)
		 * Print the string on the standard output. 
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "print", null, args));
		
		/**
		 * function getchar() : string 
		 * Read and return a character from standard input; return an empty string at end-of-file.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "getchar", string, null));
		
		/**
		 * function ord(s : string) : int
		 * Return the ASCII value of the first character of s, or −1 if s is empty. 
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "ord", intType, args));
		
		/**
		 * function size(s : string) : int 
		 * Return the number of characters in s. 
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "size", intType, args));
		
		args.add(intType);
		args.add(intType);
		
		/**
		 * function substring(s:string,f:int,n:int) : string 
		 * Return the substring of s starting at the character f 
		 * (first character is numbered zero) and going for n characters.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "substring", string, args));
		
		args.remove(intType);
		args.remove(intType);
		args.add(string);
		
		/**
		 * function concat (s1:string, s2:string) : string 
		 * Return a new string consisting of s1 followed by s2.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "concat", string, args));
		
		args.remove(string);
		args.remove(string);
		args.add(intType);
		
		/**
		 * function chr(i : int) : string 
		 * Return a single-character string for ASCII value i. 
		 * Terminate program if i is out of range.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "chr", string, args));
		args.clear();
		
		/* Non-string functions */
		
		args.add(intType);
		
		/**
		 * function printi(i : int) 
		 * Print the integer on the standard output.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "printi", null, args));
		
		/**
		 * function flush() 
		 * Flush the standard output buffer.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "flush", null, null));
		
		/**
		 * function not(i : int) : int 
		 * Return 1 if i is zero, 0 otherwise. 
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "not", intType, args));
		
		/**
		 * function exit(i : int) 
		 * Terminate execution of the program with code i.
		 */
		put(new FunctionSymbolTableEntry(new Scope(), "exit", null, args));
		
		// Now, reserve the "string" keyword by pushing it to table
		put(string);
	}
}
