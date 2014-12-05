import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
	private List<String> replaceCode;
	
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
	private Map<String,String> fixedptRegs;
	
	/**
	 * Keeps track of all the times the integer registers have been used. This is used for the heuristic
	 */
	private Map<String,Integer> intRegCount;
	
	/**
	 * Keeps track of all the times the fixedpt registers have been used. This is used for the heuristic
	 */
	private Map<String,Integer> fixedptRegCount;
	
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
		this.fixedptRegs = new HashMap<String,String>();
		this.assignedVars = new ArrayList<String>();
		this.usedVars = new ArrayList<String>();
		this.intRegCount = new HashMap<String,Integer>();
		this.fixedptRegCount = new HashMap<String,Integer>();
	}
	
	public void allocateRegs(List<CodeBlock> allCodeBlocks, Map<String,String> typeMap) {
		for (int i = 0; i < code.size(); i++) {
			String codeLine = code.get(i);
			searchLine(codeLine, allCodeBlocks, typeMap);
		}
		if (intRegCount.size() <= allIntRegs.length) {
			//System.out.println(intRegCount.size());
			Set<String> register = intRegCount.keySet();
			int index = 0;
			for (String reg: register) {
				if (typeMap.get(reg).equals("int")) {
					intRegs.put(reg, allIntRegs[index]);
					index++;
				}
			}
			//System.out.println("all int regs can be allocated");
		} else {
			System.out.println("all int regs cannot be allocated");
			int min = Integer.MAX_VALUE;
			String minVar = ""; 
			int index = 0;
			for (String each: intRegCount.keySet()) {
				int thisCount = intRegCount.get(each);
				if (min > thisCount) {
					min = thisCount;
					minVar = each;
				}
				if (index > allIntRegs.length && thisCount > min) {
					String reg = intRegs.get(minVar);
					intRegs.remove(minVar);
					intRegs.put(each, reg);
					// finds new min in intRegs
					minVar = findNewMin(intRegs, intRegCount, new String[1]);
					min = intRegCount.get(minVar);
				} else {
					intRegs.put(each, allIntRegs[index]);
				}
				index++;
			}
		}
		if (fixedptRegCount.size() <= allFixedPtRegs.length) {
			Set<String> register = fixedptRegCount.keySet();
			int index = 0;
			for (String reg: register) {
				if (typeMap.get(reg).equals("fixedpt")) {
					fixedptRegs.put(reg, allFixedPtRegs[index]);
					index++;
				}
			}
			//System.out.println("all fixedpt regs can be allocated");
		} else {
			System.out.println("all fixedpt regs canot be allocated");
			int min = Integer.MAX_VALUE;
			String minVar = ""; 
			int index = 0;
			for (String each: fixedptRegCount.keySet()) {
				int thisCount = fixedptRegCount.get(each);
				if (min > thisCount) {
					min = thisCount;
					minVar = each;
				}
				if (index > allFixedPtRegs.length && thisCount > min) {
					String reg = fixedptRegs.get(minVar);
					fixedptRegs.remove(minVar);
					fixedptRegs.put(each, reg);
					// finds new min in fixedptRegs
					minVar = findNewMin(fixedptRegs, fixedptRegCount, new String[1]);
					min = fixedptRegCount.get(minVar);
				} else {
					fixedptRegs.put(each, allFixedPtRegs[index]);
				}
				index++;
			}
		}
		replaceVars();
		/**System.out.println("Int Vars: " +intRegCount.size());
		for (String each: intRegCount.keySet()) {
			System.out.println(each +":"+intRegCount.get(each));
		}
		System.out.println("Fixedpt Vars: "+fixedptRegCount.size());
		System.out.println("Return type: "+this.returnType);**/
	}
	
	public void printMIPS() {
		for (String each: code) {
			System.out.println(each);
		}
	}
	
	private void replaceVars() {
		replaceCode = new ArrayList<String>();
		boolean hasLabel = false;
		if (code.get(0).contains(":")) {
			replaceCode.add(code.get(0));
			hasLabel = true;
		}
		for (String each: intRegs.keySet()) {
			genMipsLoad(each,intRegs.get(each),replaceCode);
		}
		for (String each:fixedptRegs.keySet()) {
			genMipsLoad(each,fixedptRegs.get(each), replaceCode);
		}
		int startIndex;
		if (!hasLabel) {
			startIndex = 0;
		} else {
			startIndex = 1;
		}
		for (int i = startIndex; i < code.size(); i++) {
			String line = code.get(i);
			handleLine(line);
		}
		for (String each: intRegs.keySet()) {
			genMipsStore(each,intRegs.get(each),replaceCode);
		}
		for (String each:fixedptRegs.keySet()) {
			genMipsStore(each,fixedptRegs.get(each), replaceCode);
		}
		this.code = replaceCode;
	}
	
	private void handleLine(String line) {
		String[] stuff = line.replace(" ", "").split(",");
		String newLine = stuff[0]+", ";
		for (int j = 1; j < stuff.length; j++) {
			String var = stuff[j].trim();
			if (!intRegs.containsKey(var) && intRegCount.containsKey(var)) {
				String min = findNewMin(intRegs,intRegCount,stuff);
				String register = intRegs.get(min);
				genMipsStore(min,register,replaceCode);
				genMipsLoad(var,register,replaceCode);
				intRegs.remove(min);
				intRegs.put(var, register);
				newLine = newLine + register + ", ";
				//newLine = newLine + 
				//line.replace(var, register);
				//System.out.println("replaced");
			} else if (!fixedptRegs.containsKey(var) && fixedptRegCount.containsKey(var)) {
				String min = findNewMin(fixedptRegs,fixedptRegCount,stuff);
				String register = fixedptRegs.get(min);
				genMipsStore(min,register,replaceCode);
				genMipsLoad(var,register,replaceCode);
				fixedptRegs.remove(min);
				fixedptRegs.put(var, register);
				//line.replace(var,register);
				newLine = newLine + register + ", ";
				//System.out.println("replaced");
			} else if (intRegs.containsKey(var) && intRegCount.containsKey(var)) {
				//line.replace(var,intRegs.get(var));
				newLine = newLine + intRegs.get(var)+", ";
				//System.out.println(var +" replaced with " + intRegs.get(var));
			} else if (fixedptRegs.containsKey(var) && fixedptRegCount.containsKey(var)) {
				//line.replace(var,fixedptRegs.get(var));
				newLine = newLine + fixedptRegs.get(var)+", ";
				//System.out.println("replaced");
			} else {
				newLine = newLine + var + ", ";
			}
		}
		//System.out.println(newLine);
		replaceCode.add(newLine);	
	}
	
	private String findNewMin(Map<String,String> regs, Map<String,Integer> regCount, String[] notInclude){
		List<String> toList = Arrays.asList(notInclude);
		int min = Integer.MAX_VALUE;
		String minVar = "";
		for (String each: regs.keySet()) {
			int varCount = regCount.get(each);
			if (min > varCount && !toList.contains(each)) {
				min = varCount;
				minVar = each;
			}
		}
		return minVar;
	}
	
	private void searchLine(String codeLine, List<CodeBlock> allCodeBlocks, Map<String,String> typeMap) {
		String[] breakUp = codeLine.split(",");
		if (codeLine.contains("assign")) {
			String asignee = breakUp[1].trim();
			String asigner = breakUp[2].trim();
			String asignerNums = asigner.replaceAll("[^\\d.]", "");
			String type;
			if (asigner.length()==asignerNums.length() && asignerNums.indexOf(".") != -1) {
				typeMap.put(asignee, "fixedpt");
				type = "fixedpt";
			} else if (asigner.length()==asignerNums.length() && asignerNums.indexOf(".") == -1) {
				typeMap.put(asignee, "int");
				type = "int";
			} else {
				type = findType(asigner, typeMap);
				typeMap.put(asignee, type);
				addToUsed(asigner, type);
			}
			addToAssigned(asignee,type);
		} else if (codeLine.contains("add") || codeLine.contains("sub") || codeLine.contains("mult") || 
				codeLine.contains("div") || codeLine.contains("and") || codeLine.contains("or")) {
			String operator1 = breakUp[1].trim();
			String type1 = findType(operator1, typeMap);
			String operator2 = breakUp[2].trim();
			String type2 = findType(operator2, typeMap);
			String asigneeType;
			if (type1.equals("fixedpt") || type2.equals("fixedpt")) {
				asigneeType = "fixedpt";
			} else {
				asigneeType = "int";
			}
			typeMap.put(breakUp[3].trim(),asigneeType);
			addToUsed(operator1, findType(operator1,typeMap));
			addToUsed(operator2, findType(operator1,typeMap));
			addToAssigned(breakUp[3].trim(), asigneeType);
		} else if (codeLine.contains("callr")) {
			//System.out.println(codeLine);
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
			typeMap.put(returnVar,funcReturnType);
			addFuncParams(breakUp, 3, typeMap);
			addToAssigned(returnVar, funcReturnType);
		} else if (codeLine.contains("return") && this.returnType == null) {
			String varName = breakUp[1].trim();
			String returnVarType = findType(varName, typeMap);
			addToUsed(varName,returnVarType);
			this.returnType = returnVarType; 
		} else if (breakUp[0].contains("br")) {
			String oneVar = breakUp[1].trim();
			String twoVar = breakUp[2].trim();
			addToUsed(oneVar,findType(oneVar, typeMap));
			addToUsed(twoVar,findType(twoVar, typeMap));
		}
	}
	
	private void addFuncParams(String[] breakUp, int start, Map<String,String> typeMap) {
		for (int i = start; i < breakUp.length; i++) {
			if (!breakUp[i].trim().equals("")) {
				String var = breakUp[i].trim();
				addToUsed(var,findType(var,typeMap));
			}
		}
	}
	
	/**
	 * This function decides whether or not the variable should be loaded at the beginning of the block
	 * @param operator the variable used in math operations
	 */
	private void addToUsed(String operator, String type) {
		//If used without being assigned first
		if (!assignedVars.contains(operator)) {
			usedVars.add(operator);
		}
		if (type != null && type.equals("int")) {
			if (!intRegCount.containsKey(operator)) {
				intRegCount.put(operator, 2);
			} else {
				intRegCount.put(operator, intRegCount.get(operator)+2);
			}
		} else if (type != null && type.equals("fixedpt")) {
			if (!fixedptRegCount.containsKey(operator)) {
				fixedptRegCount.put(operator, 2);
			} else {
				fixedptRegCount.put(operator, fixedptRegCount.get(operator)+2);
			}
		}
	}
	
	private void addToAssigned(String variable,String type) {
		//If it already wasn't assigned at some point
		if (!assignedVars.contains(variable)) {
			assignedVars.add("variable");
		}
		if (type != null && type.equals("fixedpt")) {
			if (!fixedptRegCount.containsKey(variable)) {
				fixedptRegCount.put(variable, 1);
			} else {
				fixedptRegCount.put(variable, fixedptRegCount.get(variable)+1);
			}
		} else if (type != null && type.equals("int")) {
			if (!intRegCount.containsKey(variable)) {
				intRegCount.put(variable, 1);
			} else {
				intRegCount.put(variable, intRegCount.get(variable)+1);
			}
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
		if (type != null) {
			if (type.equals("int")) {
				return "int";
			} else if (type.equals("fixedpt")) {
				return "fixedpt";
			} else {
				return findType(type, typeMap);
			}
		}
		//shouldn't happen
		return null;
	}
	
	public ArrayList<String> getCode() {
		return (ArrayList<String>)code;
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
	private void genMipsLoad(String label, String register, List<String> code) {
		code.add("la $at, " + label);
		code.add("lw " + register + ", 0($at)");
		
	}
	
	/**
	 * Generates a MIPS store instruction given a source register and target label.
	 * 
	 * @param label The target label to store to.
	 * @param register The source register to store from.
	 * @return The String MIPS load instruction.
	 */
	private void genMipsStore(String label, String register, List<String> code) {
		
		code.add("la $at, " + label);
		code.add("sw " + register + ", 0($at)");
	}
}
