import java.util.HashMap;
import java.util.Map;

/**
 * A symbol table contains the symbols generated from walking a parse tree.
 * 
 * Symbol tables contain information about variable type, scope, arguments, 
 * and return types, whatever applicable.
 * 
 * @author Sean Collins
 *
 */
public class SymbolTable {
	private Map<Integer, SymbolTable.Entry> backingTable;
	
	/**
	 * Valid entry types in a SymbolTable.
	 */
	enum EntryType {
		/**
		 * A function with no return type.
		 */
		VOID_FUNCTION,
		/**
		 * A function which returns an int.
		 */
		INT_FUNCTION,
		/**
		 * A function which returns a fixedpt.
		 */
		FIXEDPT_FUNCTION,
		/**
		 * A function which returns a previously-declared type.
		 */
		OTHER_TYPE_FUNCTION,
		/**
		 * The main function, identified by "void main()".
		 */
		MAIN_FUNCTION,
		/**
		 * A true/false value or condition.
		 */
		BOOLEAN,
		/**
		 * An int value.
		 */
		INT,
		/**
		 * A fixedpt value.
		 */
		FIXEDPT,
		/**
		 * A previously-declared type value.
		 */
		OTHER_TYPE,
		/**
		 * An (n > 1)-array of int values.
		 */
		INT_ARRAY,
		/**
		 * An (n > 1)-array of fixedpt values.
		 */
		FIXEDPT_ARRAY,
		/**
		 * An (n > 1)-array of previously-declared type values.
		 */
		OTHER_TYPE_ARRAY
	}

	/**
	 * Instantiates a new SymbolTable.
	 */
	public SymbolTable() {
		backingTable = new HashMap<Integer, SymbolTable.Entry>();
	}
	
	/**
	 * Adds a new Entry into this SymbolTable.
	 * 
	 * @param entry The type of Entry to add.
	 */
	public void add(Entry entry) {
		backingTable.put(entry.hashCode(), entry);
	}
	
	/**
	 * switch (entry) {
		case VOID_FUNCTION:
			backingTable.put(entry.hashCode(), entry);
		case INT_FUNCTION:
			break;
		case FIXEDPT_FUNCTION:
			break;
		case OTHER_TYPE_FUNCTION:
			break;
		case MAIN_FUNCTION:
			break;
		case BOOLEAN:
			break;
		case INT:
			break;
		case FIXEDPT:
			break;
		case OTHER_TYPE:
			break;
		case INT_ARRAY:
			break;
		case FIXEDPT_ARRAY:
			break;
		case OTHER_TYPE_ARRAY:
			break;
		}
	 */
	
	/**
	 * An entry in a SymbolTable.
	 */
	class Entry {
		private EntryType type, returnValue;
		private EntryType[] args;
		private Scope scope;
		
		/**
		 * Constructs a new general Entry, compatible for insertion into a SymbolTable.
		 * 
		 * @param type The type of the Entry.
		 * @param scope The parent Scope of the Entry.
		 * @param returnValue The return value of the Entry.
		 * @param args The arguments of the Entry.
		 */
		public Entry(EntryType type, Scope scope, EntryType returnValue, EntryType[] args) {
			this.type = type;
			this.scope = scope;
			this.returnValue = returnValue;
			this.args = args;
		}
		
		/**
		 * Constructs a new Entry for a general value or void function.
		 * 
		 * @param type The type of the Entry.
		 * @param scope The parent Scope of the Entry.
		 */
		public Entry(EntryType type, Scope scope) {
			this(type, scope, null, null);
		}
		
		/**
		 * Returns the type of this Entry.
		 * 
		 * @return The EntryType associated with this Entry.
		 */
		public EntryType getType() {
			return type;
		}
		
		/**
		 * Returns the return value type of this Entry.
		 * 
		 * @return The EntryType associated with this Entry's return value.
		 */
		public EntryType getReturnValue() {
			return returnValue;
		}
		
		/**
		 * Returns the argument types of this Entry.
		 * 
		 * @return The EntryType[] associated with this Entry's calling arguments.
		 */
		public EntryType[] getArgs() {
			return args;
		}
		
		/**
		 * Returns the Scope of this Entry.
		 * 
		 * @return The Scope of this Entry.
		 */
		public Scope getScope() {
			return scope;
		}
	}

}