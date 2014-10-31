import java.util.LinkedList;
import java.util.List;

/**
 * A VariableSymbolTableEntry is an SymbolTableEntry for variable declarations.
 * It contains a backing List to handle overlapping names in different Scopes.
 */
public class VariableSymbolTableEntry extends SymbolTableEntry {
	protected List<TigerVariable> backingList;
	
	/**
	 * Constructs a new VariableSymbolTableEntry with given Scope and id.
	 * 
	 * @param scope The parent Scope of the SymbolTableEntry.
	 * @param id The String identifier of this SymbolTableEntry.
	 */
	protected VariableSymbolTableEntry(Scope scope, String id) {
		super(scope, id);
		backingList = new LinkedList<TigerVariable>();
	}
}