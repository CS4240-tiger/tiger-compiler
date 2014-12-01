import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
	
	/**
	 * return type for this block if it is a helper function
	 */
	private String returnType;
	
	/**
	 * Map for all the variables in this block and their type
	 */
	private Map<String,String> typeMap;
	
	/**
	 * Map for all the integer registers
	 */
	private Map<String,String> intRegs;
	
	/**
	 * Map for all the fixedpt registers
	 */
	private Map<String,String> fixeptRegs;
	
	/**
	 * All the available integer registers
	 */
	private static String[] allIntRegs = new String[]{"$t0", "$t1", "$t2", "$t3", "$t4", 
		"$t5", "$t6", "$t7", "$t8", "$t9", "$s0", "$s1", 
		"$s2", "$s3", "$s4", "$s5", "$s6", "$s7"};
	
	/**
	 * All the available fixedpt integers
	 */
	private static String[] allFixedPtRegs = new String[]{"$f0", 
		"$f1", "$f2", "$f3", "$f4", "$f5", "$f6", "$f7", 
		"$f8", "$f9", "$f10", "$f11", "$f12", "$f13", "$f14", 
		"$f15", "$f16", "$f17", "$f18", "$f19", "$f20", "$f21", 
		"$f22", "$f23", "$f24", "$f25", "$f26", "$f27", "$f28", 
		"$f29", "$f30", "$f31"};
	
	/**
	 * The number of total integer variables
	 */
	private int numIntVars;
	
	/**
	 * The number of total fixedpt variables
	 */
	private int numFixedPtVars;
	
	/**
	 * @param leader the first line of code of this block
	 * @param last the last line of code of this block
	 * @param code the entire code of this block
	 * @param id the id of this code block
	 */
	public CodeBlock(String leader, String last, String[] code, int id) {
		this.leader= leader;
		this.last = last;
		this.code = new ArrayList<String>(Arrays.asList(code));
		this.id = id;
		this.typeMap = new HashMap<String,String>();
		this.intRegs = new HashMap<String,String>();
		this.fixeptRegs = new HashMap<String,String>();
		this.numIntVars = 0;
		this.numFixedPtVars= 0;
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
