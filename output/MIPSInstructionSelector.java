import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A MIPSInstructionSelector class is involved in the final stage of compilation
 * and is responsible for translating modified IR code to MIPS code.
 */
public class MIPSInstructionSelector {
	/**
	 * The content of the MIPS .data header.
	 */
	private List<String> data;
	/**
	 * The content of the MIPS .text header.
	 */
	private List<String> text;
	/**
	 * Static mappings between IR and MIPS code.
	 */
	private static Map<String, String> IR_MIPS_OP_MAPPINGS;
	/**
	 * Constructs a new MIPSInstructionSelector with given .data header 
	 * and given modified IR code.
	 * 
	 * @param data A given .data header, as a List.
	 * @param modIR Given modified IR code, as a List.
	 */
	public MIPSInstructionSelector(List<String> data, List<String> modIR) {
		this.data = data;
		text = new ArrayList<String>();
		initializeMipsMappings();
		text.add(".text");
		text.addAll(modIR);
	}
	
	/**
	 * Splits a given line of IR into instruction and parameter components.
	 * Given a line of standard 4-instruction IR, the resulting indexes
	 * should be accessible as follows:<br /><br />
	 * 
	 * splitToComponents(IR)[0] = op<br />
	 * splitToComponents(IR)[1] = param1<br />
	 * splitToComponents(IR)[2] = param2<br />
	 * splitToComponents(IR)[3] = param3<br /><br />
	 * 
	 * If one or more parameters are left out of the IR, the corresponding 
	 * index(es) should contain an empty String.
	 * 
	 * @param IR A given line of IR.
	 * @return A String[] containing instruction and parameter components.
	 */
	private String[] splitToComponents(String IR) {
		return IR.replaceAll(" ", "").split(",");
	}
	
	/**
	 * Populates IR_MIPS_OP_MAPPINGS with direct mappings 
	 * of IR to MIPS instructions.
	 */
	private static final void initializeMipsMappings() {
		IR_MIPS_OP_MAPPINGS = new HashMap<String, String>();
		
		// Map IR instruction -> MIPS instructions here
		IR_MIPS_OP_MAPPINGS.put("assign", ""); // TODO: Do we even need to add this?
		// TODO: "assign" is overloaded in IR!
		IR_MIPS_OP_MAPPINGS.put("add", "add");
		IR_MIPS_OP_MAPPINGS.put("sub", "sub");
		IR_MIPS_OP_MAPPINGS.put("mult", "mult");
		IR_MIPS_OP_MAPPINGS.put("div", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("and", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("or", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("goto", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("breq", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("brneq", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("brlt", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("brgt", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("brgeq", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("brleq", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("return", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("call", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("callr", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("array_store", ""); // TODO: Translate
		IR_MIPS_OP_MAPPINGS.put("array_load", ""); // TODO: Translate
		
		// TODO: Now, map standard library functions to MIPS (call, callr)
	}

}
