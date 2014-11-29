import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A NaiveRegistorAllocator is a class which takes in IR-generated code as 
 * input and produces modified IR code (with naively-allocated registers) 
 * as output.
 */
public class NaiveRegisterAllocator {
	/**
	 * Input IR lines, as Strings.
	 */
	private List<String> input;
	/**
	 * Generated opening sections to a MIPS program.
	 */
	private List<String> mipsPreface;
	/**
	 * An array of register numbers to allocate.
	 */
	private int[] registers;
	
	/**
	 * Constructs a new NaiveRegisterAllocator with input IR List and number of
	 * available registers to allocate.
	 * 
	 * @param input Input IR lines, as Strings.
	 * @param numRegisters An array of register numbers to allocate.
	 */
	public NaiveRegisterAllocator(List<String> input, int[] registers) {
		this.input = input;
		this.registers = registers;
	}
	
	/**
	 * Appends a list of temporary variables in memory, 
	 * as well as the MIPS .data section header.
	 */
	private void storeAllTemporaries() {
		List<Integer> tempIndexes;
		List<String> foundTemps = new ArrayList<String>();
		String temp;
		
		// Append .data section to our MIPS header
		mipsPreface.add(".data");
		
		// Search through IR and add all temp references to foundTemps list
		for (String line : input) {
			tempIndexes = findTempInLine(line);
			if (!tempIndexes.isEmpty()) {
				for (int index : tempIndexes) {
					temp = line.split("\\s+")[index];
					if (!foundTemps.contains(temp)) {
						foundTemps.add(temp);
						if (line.toLowerCase().contains("assign")) {
							/* Add to header */
							mipsMemAssign(temp, line);
						} else {
							int lineIndex = input.indexOf(line);
							String targetRegister = ""; // Get most appropriate register
							/* Load before use */
							input.add(lineIndex, genMipsLoad(temp, targetRegister)[0]);
							input.add(lineIndex, genMipsLoad(temp, targetRegister)[1]);
							/* Store after use */
							input.add(lineIndex, genMipsStore(temp, targetRegister)[0]);
							input.add(lineIndex, genMipsStore(temp, targetRegister)[1]);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Splits an IR line into an array of words.
	 * Returns the indexes where temporaries are referenced.
	 * 
	 * @param input An input IR line.
	 * @return The indexes where temporary variables are references in the IR line.
	 */
	private List<Integer> findTempInLine(String input) {
		String[] lineSplit = input.split("\\s+");
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
		// assignComponents[0] = target
		// assignComponents[1] = value
		// MIPS: label: .word value
		
		String[] assignComponents = line.replace(" ",  "").replace("assign", "").split(",");
		mipsPreface.add(assignComponents[0] + ": .word " + assignComponents[1]);
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
