import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A NaiveRegistorAllocator is a class which takes in IR-generated code as 
 * input and produces modified IR code (with naively-allocated registers) 
 * as output.
 */
public class NaiveRegisterAllocator {
	/**
	 * Input IR lines, as Strings.
	 */
	private List<String> inputIR;
	/**
	 * Output mixed IR-MIPS lines, as Strings.
	 */
	protected List<String> output;
	/**
	 * Generated opening sections to a MIPS program.
	 */
	private List<String> mipsPreface;
	/**
	 * A map of register numbers to allocate.
	 * The mappings are in the following format:
	 * 
	 * String registerName -> Boolean isUsed
	 */
	private Map<String, Boolean> registerMap;
	
	/**
	 * Constructs a new NaiveRegisterAllocator with input IR List and number of
	 * available registers to allocate.
	 * 
	 * @param input Input IR lines, as Strings.
	 * @param numRegisters An array of register numbers to allocate.
	 */
	private NaiveRegisterAllocator(List<String> inputIR, String[] registers) {
		this.inputIR = inputIR;
		registerMap = new HashMap<String, Boolean>();
		mipsPreface = new ArrayList<String>();
		output = new ArrayList<String>();
		for (String register : registers) {
			registerMap.put(register, false);
		}
		
		// Copy input to output for modification
		inputOutputDeepCopy();
		
		// Now, perform load-stores on temporary variables as required
		storeAllTemporaries();
	}
	
	/**
	 * Constructs a new NaiveRegisterAllocator with input IR List.
	 * Available registers will be allocated based on standard MIPS registers:<br /><br />
	 * 
	 * <b>$t0-$t9</b>: Temporaries (int)<br />
	 * <b>$s0-$s7</b>: Saved temporaries (int)<br />
	 * <b>$f0-$f31</b>: FPU temporaries (fixedpt)
	 * 
	 * @param input Input IR lines, as Strings.
	 */
	public NaiveRegisterAllocator(List<String> inputIR) {
		this(inputIR, new String[]{"$t0", "$t1", "$t2", "$t3", "$t4", 
				"$t5", "$t6", "$t7", "$t8", "$t9", "$s0", "$s1", 
				"$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$f0", 
				"$f1", "$f2", "$f3", "$f4", "$f5", "$f6", "$f7", 
				"$f8", "$f9", "$f10", "$f11", "$f12", "$f13", "$f14", 
				"$f15", "$f16", "$f17", "$f18", "$f19", "$f20", "$f21", 
				"$f22", "$f23", "$f24", "$f25", "$f26", "$f27", "$f28", 
				"$f29", "$f30", "$f31"});
	}
	
	/**
	 * Appends a list of temporary variables in memory, 
	 * as well as the MIPS .data section header.
	 */
	private void storeAllTemporaries() {
		List<Integer> tempIndexes;
		List<String> foundTemps = new ArrayList<String>();
		String temp, line;
		
		// Append .data section to our MIPS header
		mipsPreface.add(".data");
		
		// Search through IR and add all temp references to foundTemps list
		for (int i = 0; i < output.size(); i++) {
			line = output.get(i);
			tempIndexes = findTempInLine(line);
			
			if (!tempIndexes.isEmpty()) {
				for (int index : tempIndexes) {
					temp = line.replaceAll(",", "").split("\\s+")[index];
					if (!foundTemps.contains(temp)) {
						foundTemps.add(temp);
						if (line.toLowerCase().contains("assign")) {
							/* Add to header */
							mipsMemAssign(temp, line);
						} else {
							/* Assign default value */
							mipsMemAssign(temp, "assign, " + temp + ", 0, ");
						}
					}
						
					int lineIndex = output.indexOf(line.replaceAll("$", ""));
					String targetRegister = useBestRegister(temp); // Get most appropriate register
					// Load before use
					output.add(lineIndex, genMipsLoad(temp, targetRegister)[0]);
					output.add(lineIndex + 1, genMipsLoad(temp, targetRegister)[1]);
					// Replace use with register
					output.set(lineIndex + 2, output.get(lineIndex + 2).replace(temp, targetRegister));
					line = output.get(lineIndex + 2);
					// Store after use
					output.add(lineIndex + 3, genMipsStore(temp, targetRegister)[0]);
					output.add(lineIndex + 4, genMipsStore(temp, targetRegister)[1]);
					
					// Advance index to ignore IR lines
					i += 4;	
				}
				
			}
			
			// All registers are now free!
			unuseAllRegisters();
		}
		
		// End .data section
		mipsPreface.add(".text");
	}
	
	/**
	 * Splits an IR line into an array of words.
	 * Returns the indexes where temporaries are referenced.
	 * 
	 * @param input An input IR line.
	 * @return The indexes where temporary variables are references in the IR line.
	 */
	private List<Integer> findTempInLine(String input) {
		String[] lineSplit = input.replaceAll(",", "").split("\\s+");
		List<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < lineSplit.length; i++) {
			if (lineSplit[i].matches("[t][0-9]+")) {
				indexes.add(i);
			}
		}
		
		return indexes;
	}
	
	/**
	 * Generates an assignment label for a variable in memory 
	 * and places it in the MIPS header.
	 * 
	 * @param label A label (without colon).
	 * @param line A full assignment statement in input IR.
	 */
	private void mipsMemAssign(String label, String line) {
		// assign $a, $b, => [$a, $b, ]
		// assignComponents[1] = target
		// assignComponents[2] = value
		// MIPS (if int): label: .word value
		// MIPS (if fixedpt): label: .float value
		
		String[] assignComponents = line.replace(" ",  "")
				.replace("assign", "").split(",");
		
		if (!assignComponents[2].matches("[0-9]+(.[0-9]+)?")) {
			if (assignComponents[2].matches("[t][0-9]+")) {
				// Temporary value, look it up
				assignComponents[2] = getValueFromLabel(assignComponents[2]);
			} else {
				assignComponents[2] = reverseVarLookup(assignComponents[2], line);
			}
		}
		
		mipsPreface.add(assignComponents[1] + (assignComponents[2].contains(".") 
				? ": .float " : ": .word ") + assignComponents[2]);
	}
	
	/**
	 * Looks up from the current line in the IR for a variable declaration, 
	 * given the variable to look for.
	 * 
	 * Returns the value of that variable.
	 * 
	 * @param var The variable to search for.
	 * @param line The input line to look up from.
	 * @return The variable's value.
	 */
	private String reverseVarLookup(String var, String line) {
		int lineIndex = output.indexOf(line);
		
		while (!output.get(lineIndex).contains("assign, " + var)) {
			lineIndex--;
		}
		
		String[] assignComponents = output.get(lineIndex)
				.replace(" ",  "").replace("assign", "").split(",");
		
		if (!assignComponents[2].matches("[0-9]+(.[0-9]+)?")) {
			// Recurse for that value
			return reverseVarLookup(assignComponents[2], output.get(lineIndex));
		}
		
		return assignComponents[2];
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
	
	/**
	 * Returns the best register used to store a type of value 
	 * (int vs. fixedpt) and marks that register as used in the 
	 * register map.
	 * 
	 * @param label The label in memory to load from.
	 * @return A free register to store to.
	 */
	private String useBestRegister(String label) {
		boolean isInt = true;
		
		// Iterate through .data
		for (String temp : mipsPreface) {
			if (temp.contains(label)) {
				if (temp.split("\\s+")[1].contains(".float")) {
					// This is a fixedpt
					isInt = false;
				}
				
				break;
			}
		}
		
		// Now that we know the type of value, assign register
		if (isInt) {
			// Check t-registers
			for (int i = 0; i < 10; i++) {
				if (!registerMap.get("$t" + i)) {
					// Mark as used
					registerMap.put("$t" + i, true);
					
					return ("$t" + i);
				}
			}
			
			// If somehow we don't have a register yet, check s-registers
			for (int i = 0; i < 8; i++) {
				if (!registerMap.get("$s" + i)) {
					// Mark as used
					registerMap.put("$s" + i, true);
					
					return ("$s" + i);
				}
			}
			
		} else {
			// Check f-registers for fixedpt
			for (int i = 0; i < 32; i++) {
				if (!registerMap.get("$f" + i)) {
					// Mark as used
					registerMap.put("$f" + i, true);
					
					return ("$f" + i);
				}
			}
		}
		
		// This should not happen
		return null;
	}
	
	/**
	 * Marks all registers in the register map as unused.
	 */
	private void unuseAllRegisters() {
		for (String key : registerMap.keySet()) {
			registerMap.put(key, false);
		}
	}
	
	/**
	 * Deep-copies inputIR to output for modification.
	 */
	private void inputOutputDeepCopy() {
		Iterator<String> i = inputIR.iterator();
		while (i.hasNext()) {
			output.add(i.next());
		}
	}
	
	/**
	 * Returns the value of a previously stored temporary.
	 * 
	 * @param label The name of the temporary to search for.
	 * @return The value of the temporary in memory.
	 */
	private String getValueFromLabel(String label) {
		for (String temp : mipsPreface) {
			if (temp.contains(label)) {
				return temp.split("\\s+")[2];
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the mixed output appended to the .data preface.
	 * 
	 * @return Mixed MIPS-IR output.
	 */
	public List<String> getMixedOutput() {
		List<String> mixedOutput = mipsPreface;
		mixedOutput.addAll(output);
		
		return mixedOutput;
	}
	
	/**
	 * Returns the MIPS .data preface only.
	 * 
	 * @return MIPS .data preface.
	 */
	public List<String> getData() {
		return mipsPreface;
	}
	
	/**
	 * Returns the mixed MIPS-IR output, without the .data preface.
	 * 
	 * @return Mixed MIPS-IR output, without .data.
	 */
	public List<String> getOutput() {
		return output;
	}
}
