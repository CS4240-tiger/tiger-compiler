import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CodeBlock {
	/**
	 * first line of the block
	 */
	private String leader;
	
	/**
	 * last line of the block
	 */
	private String last;
	
	/**
	 * All the code in the block separated by lines
	 */
	private List<String> code;
	
	/**
	 * the id for this code block
	 */
	private int id;
	
	public CodeBlock(String leader, String last, String[] code, int id) {
		this.leader= leader;
		this.last = last;
		this.code = new ArrayList<String>(Arrays.asList(code));
		this.id = id;
	}
	
	public boolean equals(CodeBlock block2) {
		return this.id == block2.getId();
	}
	
	public int getId() {
		return this.id;
	}

	public String getLeader() {
		return this.leader;
	}
	
	public String getLast() {
		return this.last;
	}
	
	/**
	 * Generates a MIPS load instruction given a source label and target register.
	 * 
	 * @param label The source label to load from.
	 * @param register The target register to load to.
	 * @return The String MIPS load instruction.
	 */
	private String[] genMipsLoad(String label, String register) {
		// We'll use the assembler register $at for loading the address
		String[] result = new String[2];
		
		result[0] = "la $at, " + label;
		result[1] = "lw " + register + ", 0($at)";
		
		return result;
	}
	
	/**
	 * Generates a MIPS store instruction given a source register and target label.
	 * 
	 * @param label The target label to store to.
	 * @param register The source register to store from.
	 * @return The String MIPS load instruction.
	 */
	private String[] genMipsStore(String label, String register) {
		// We'll use the assembler register $at for loading the address
		String[] result = new String[2];
		
		result[0] = "la $at, " + label;
		result[1] = "sw " + register + ", 0($at)";
		
		return result;
	}
}
