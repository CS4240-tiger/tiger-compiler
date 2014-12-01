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
	 * a list of variables that were used in the block but didn't have any assign statements
	 * used for load statements at the beginning of the block
	 */
	private List<String> usedVars;
	
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
		this.intRegs = new HashMap<String,String>();
		this.fixeptRegs = new HashMap<String,String>();
		this.numIntVars = 0;
		this.numFixedPtVars= 0;
		this.assignedVars = new ArrayList<String>();
	}
	
	public void allocateRegs(List<CodeBlock> allCodeBlocks, Map<String,String> typeMap) {
		for (int i = 0; i < code.size(); i++) {
			String codeLine = code.get(i);
			searchLine(codeLine, allCodeBlocks, typeMap);
		}
		System.out.println("Int Vars: " +numIntVars);
		System.out.println("Fixedpt Vars: "+numFixedPtVars);
		System.out.println("Return type: "+this.returnType);
	}
	
	private void searchLine(String codeLine, List<CodeBlock> allCodeBlocks, Map<String,String> typeMap) {
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
				String type = findType(asigner, typeMap);
				if (type.equals("int") ) {
					numIntVars++;
				} else if (type.equals("fixedpt")) {
					numFixedPtVars++;
				}
				typeMap.put(asignee, type);
				addToUsed(asigner, typeMap);
			}
			addToAssigned(asignee);
		} else if (codeLine.contains("add") || codeLine.contains("sub") || codeLine.contains("mult") || 
				codeLine.contains("div") || codeLine.contains("and") || codeLine.contains("or")) {
			String operator1 = breakUp[1].trim();
			String type1 = findType(operator1, typeMap);
			String operator2 = breakUp[2].trim();
			String type2 = findType(operator2, typeMap);
			String asigneeType;
			if (type1.equals("fixedpt") || type2.equals("fixedpt")) {
				asigneeType = "fixedpt";
				numFixedPtVars++;
			} else {
				asigneeType = "int";
				numIntVars++;
			}
			typeMap.put(breakUp[3].trim(),asigneeType);
			addToUsed(operator1,typeMap);
			addToUsed(operator2, typeMap);
			addToAssigned(breakUp[3].trim());
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
			addFuncParams(breakUp, 3, typeMap);
			addToAssigned(returnVar);
		} else if (codeLine.contains("return") && this.returnType == null) {
			String returnVarType = findType(breakUp[1].trim(), typeMap);
			this.returnType = returnVarType; 
		} else if (breakUp[0].contains("br")) {
			String oneVar = breakUp[1].trim();
			String twoVar = breakUp[2].trim();
			addToUsed(oneVar,typeMap);
			addToUsed(twoVar,typeMap);
		}
	}
	
	private void addFuncParams(String[] breakUp, int start, Map<String,String> typeMap) {
		for (int i = start; i < breakUp.length; i++) {
			if (!breakUp[i].trim().equals("")) {
				addToUsed(breakUp[i].trim(),typeMap);
			}
		}
	}
	
	/**
	 * This function decides whether or not the variable should be loaded at the beginning of the block
	 * @param operator the variable used in math operations
	 */
	private void addToUsed(String operator, Map<String,String> typeMap) {
		//If used without being assigned first
		if (!assignedVars.contains(operator)) {
			String type = findType(operator,typeMap); 
			if (type.equals("int")) {
				numIntVars++;
			} else if (type.equals("fixedpt")) {
				numFixedPtVars++;
			}
			usedVars.add(operator);
		}
	}
	
	private void addToAssigned(String variable) {
		//If it already wasn't assigned at some point
		if (!assignedVars.contains(variable)) {
			assignedVars.add("variable");
		}
	}
	/**
	 * Recursive function that goes to the depth of hell and searches through typeMap to find the type of the asignee
	 * 
	 * @param asignee the original variable
	 * @return either "int" or "fixedpt"
	 */
	private String findType(String asignee, Map<String,String> typeMap) {
		String type = typeMap.get(asignee);
		if (type.equals("int")) {
			return "int";
		} else if (type.equals("fixedpt")) {
			return "fixedpt";
		} else {
			return findType(type, typeMap);
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
