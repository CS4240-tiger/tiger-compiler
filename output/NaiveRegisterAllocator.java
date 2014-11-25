import java.util.List;

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
	 * The number of free registers available to allocate.
	 */
	private int numRegisters;
	
	/**
	 * Constructs a new NaiveRegisterAllocator with input IR List and number of
	 * available registers to allocate.
	 * 
	 * @param input Input IR lines, as Strings.
	 * @param numRegisters The number of free registers available to allocate.
	 */
	public NaiveRegisterAllocator(List<String> input, int numRegisters) {
		this.input = input;
		this.numRegisters = numRegisters;
	}
	
	
}
