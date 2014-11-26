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
	
	private void storeAllTemporaries() {
		List<Integer> tempIndexes;
		mipsPreface.add(".data");
		
		for (String line : input) {
			tempIndexes = findTempInLine(line);
			if (!tempIndexes.isEmpty()) {
				for (int index : findTempInLine(line)) {
					
				}
				mipsPreface.add("");
			}
		}
	}
	
	private List<Integer> findTempInLine(String input) {
		String[] lineSplit = input.split("\\s+");
		List<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < lineSplit.length; i++) {
			if (lineSplit[i].matches("[t][0-9]+")) {
				
			}
		}
		
		
		return indexes;
	}
}
