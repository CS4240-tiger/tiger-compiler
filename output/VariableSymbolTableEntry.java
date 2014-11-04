import java.util.LinkedList;
import java.util.List;

/**
 * A VariableSymbolTableEntry is an SymbolTableEntry for variable declarations.
 * It contains a backing List to handle overlapping names in different Scopes.
 */
public class VariableSymbolTableEntry extends SymbolTableEntry {
	protected List<TigerVariable> backingList;
	private TypeSymbolTableEntry type;
	
	/**
	 * Constructs a new VariableSymbolTableEntry with given Scope and id.
	 * 
	 * @param scope The parent Scope of the SymbolTableEntry.
	 * @param id The String identifier of this SymbolTableEntry.
	 * @param value The value to associate with the provided id.
	 */
	protected VariableSymbolTableEntry(Scope scope, String id, TigerVariable value) {
		super(scope, id);
		backingList = new LinkedList<TigerVariable>();
		backingList.add(value);
	}
	
	protected VariableSymbolTableEntry(Scope scope, String id, TigerVariable value, TypeSymbolTableEntry type) {
		super(scope, id);
		backingList = new LinkedList<TigerVariable>();
		backingList.add(value);
		this.type = type;
	}
}