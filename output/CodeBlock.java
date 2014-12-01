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
	 * list of variables that were assigned in this block for store statements later
	 */
	private List<String> assignedVars;
	
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
		this.assignedVars = new ArrayList<String>();
	}
	
	public void allocateRegs(List<CodeBlock> allCodeBlocks) {
		for (int i = 0; i < code.size(); i++) {
			String codeLine = code.get(i);
			searchLine(codeLine, allCodeBlocks);
		}
		System.out.println("Int Vars: " +numIntVars);
		System.out.println("Fixedpt Vars: "+numFixedPtVars);
		System.out.println("Return type: "+this.returnType);
	}
	
	private void searchLine(String codeLine, List<CodeBlock> allCodeBlocks) {
		String[] breakUp = codeLine.split(",");
		if (codeLine.contains("assign")) {
			String asignee = breakUp[1].trim();
			String asigner = breakUp[2].trim();
			String asignerNums = asigner.replaceAll("[^\\d.]", "");
			if (asigner.length()==asignerNums.length() && asignerNums.indexOf(".") != -1) {
				typeMap.put(asignee, "fixedpt");
				numFixedPtVars++;
			} else if (asigner.length()==asignerNums.length() && asignerNums.indexOf(".") == -1) {
				typeMap.put(asignee, "int");
				numIntVars++;
			} else {
				String type = findType(asigner);
				if (type.equals("int") ) {
					numIntVars++;
				} else if (type.equals("fixedpt")) {
					numFixedPtVars++;
				}
				typeMap.put(asignee, type);
			}
			assignedVars.add(asignee);
		} else if (codeLine.contains("add") || codeLine.contains("sub") || codeLine.contains("mult") || 
				codeLine.contains("div") || codeLine.contains("and") || codeLine.contains("or")) {
			String operator1 = breakUp[1].trim();
			String type1 = findType(operator1);
			String operator2 = breakUp[2].trim();
			String type2 = findType(operator2);
			String asigneeType;
			if (type1.equals("fixedpt") || type2.equals("fixedpt")) {
				asigneeType = "fixedpt";
				numFixedPtVars++;
			} else {
				asigneeType = "int";
				numIntVars++;
			}
			typeMap.put(breakUp[3].trim(),asigneeType);
			assignedVars.add(breakUp[3].trim());
		} else if (codeLine.contains("callr")) {
			String returnVar = breakUp[1].trim();
			String funcName = breakUp[2].trim();
			String funcReturnType = "";
			for (int i = 0; i < allCodeBlocks.size(); i++) {
				CodeBlock block = allCodeBlocks.get(i);
				if (block.getLeader().contains(funcName)) {
					funcReturnType = block.returnType;
					break;
				}
			}
			if (funcReturnType.equals("int")) {
				numIntVars++;
			} else if (funcReturnType.equals("fixedpt")) {
				numFixedPtVars++;
			}
			typeMap.put(returnVar,funcReturnType);
			assignedVars.add(returnVar);
		} else if (codeLine.contains("return") && this.returnType == null) {
			String returnVarType = findType(breakUp[1].trim());
			this.returnType = returnVarType; 
		}
	}
	
	/**
	 * Recursive function that goes to the depth of hell and searches through typeMap to find the type of the asignee
	 * 
	 * @param asignee the original variable
	 * @return either "int" or "fixedpt"
	 */
	private String findType(String asignee) {
		String type = typeMap.get(asignee);
		if (type.equals("int")) {
			return "int";
		} else if (type.equals("fixedpt")) {
			return "fixedpt";
		} else {
			return findType(type);
		}
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
