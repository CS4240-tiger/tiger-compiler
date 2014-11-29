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
							/* TODO: Generate load-stores */
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
		
	}
}
