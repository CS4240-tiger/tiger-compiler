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
		translateAll();
	}
	
	/**
	 * Returns the full translated MIPS program.
	 * 
	 * @return The full translated MIPS program, as a String list.
	 */
	public List<String> getOutput() {
		List<String> output = new ArrayList<String>();
		output.addAll(data);
		output.addAll(text);
		
		return output;
	}
	
	/**
	 * Translates the IR in .text to MIPS.
	 */
	private void translateAll() {
		String line, translatedLine;
		String[] components;
		
		for (int index = 0; index < text.size(); index++) {
			line = text.get(index);
			components = splitToComponents(line);
			// TODO: If it's a normal assignment statement, filter it out
			// (These should be already dealt with in previous phase)
			translatedLine = IR_MIPS_OP_MAPPINGS.get(components[0]);
			
		}
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
		final String FUNC_CALL_CALL_CONV = "addi $sp, $sp, <NUM-ARGS>\n"
				+ "<FUNC_CALL_STACK_POPULATION>\n"
				+ "add $fp, $sp, $zero";
		IR_MIPS_OP_MAPPINGS = new HashMap<String, String>();
		
		// Map IR instruction -> MIPS instructions here
		
		// IR_MIPS_OP_MAPPINGS.put("assign", "$label: $value");
		// It's assumed that variables are already assigned in previous 
		// phases, so we're going to assume that assign is referring to 
		// array static value population only
		
		// But we need to handle placing unique labels later on for looping
		
		// add $t9, $zero, $zero
		// addi $t8, $zero, $array_size
		// $assignLoopLabelBeg:
		// sw $value, $label($t9)
		// addi $t9, $t9, 1
		// bne $t8, $t9, $assignLoopLabelEnd
		IR_MIPS_OP_MAPPINGS.put("assign", "add $t9, $zero, $zero\n"
				+ "addi $t8, $zero, <PARAM2>"
				+ "<ASSIGN-LOOP-LABEL-START>:\n" 
				+ "sw <PARAM3>, <PARAM1>($t9)\n"
				+ "addi $t9, $t9, 1\n"
				+ "bne $t8, $t9, <ASSIGN-LOOP-LABEL-END>\n"
				+ "<ASSIGN-LOOP-LABEL-END>:");
		// add $dest, $param1, $param2
		IR_MIPS_OP_MAPPINGS.put("add", "add <PARAM3>, <PARAM1>, <PARAM2>");
		// sub $dest, $param1, $param2
		IR_MIPS_OP_MAPPINGS.put("sub", "sub <PARAM3>, <PARAM1>, <PARAM2>");
		// mult: Assume max 32-bit, so don't access HI
		
		// mult $param1, $param2
		// mflo $dest
		IR_MIPS_OP_MAPPINGS.put("mult", "mult <PARAM1>, <PARAM2>\n"
				+ "mflo <PARAM3>"); 
		// div: Assume integer division, so don't access HI
		
		// div $param1, $param2
		// mflo $dest
		IR_MIPS_OP_MAPPINGS.put("div", "div <PARAM2>, <PARAM3>\n"
				+ "mflo <PARAM1>");
		// and $dest, $param1, $param2
		IR_MIPS_OP_MAPPINGS.put("and", "and <PARAM3>, <PARAM1>, <PARAM2>");
		// or $dest, $param1, $param2
		IR_MIPS_OP_MAPPINGS.put("or", "or <PARAM3>, <PARAM1>, <PARAM2>");
		// jr $addr
		IR_MIPS_OP_MAPPINGS.put("goto", "jr <PARAM1>");
		// beq $param1, $param2, $addr
		IR_MIPS_OP_MAPPINGS.put("breq", "beq <PARAM1>, <PARAM2>, <PARAM3>");
		// bne $param1, $param2, $addr
		IR_MIPS_OP_MAPPINGS.put("brneq", "bne <PARAM1>, <PARAM2>, <PARAM3>");
		// blt $param1, $param2, $addr
		IR_MIPS_OP_MAPPINGS.put("brlt", "blt <PARAM1>, <PARAM2>, <PARAM3>");
		// bgt $param1, $param2, $addr
		IR_MIPS_OP_MAPPINGS.put("brgt", "bgt <PARAM1>, <PARAM2>, <PARAM3>");
		// bge $param1, $param2, $addr
		IR_MIPS_OP_MAPPINGS.put("brgeq", "bge <PARAM1>, <PARAM2>, <PARAM3>");
		// ble $param1, $param2, $addr
		IR_MIPS_OP_MAPPINGS.put("brleq", "ble <PARAM1>, <PARAM2>, <PARAM3>");
		IR_MIPS_OP_MAPPINGS.put("return", "jr $ra");
		IR_MIPS_OP_MAPPINGS.put("call", FUNC_CALL_CALL_CONV + "jr <PARAM1>");
		IR_MIPS_OP_MAPPINGS.put("callr", FUNC_CALL_CALL_CONV + "jr <PARAM1>\n"
				+ "sw $v0, <PARAM2>($zero)");
		IR_MIPS_OP_MAPPINGS.put("array_store", "addi $at, $zero, <PARAM2>\n"
				+ "lw <PARAM3>, <PARAM1>($at)"); // value -> $reg, then lw
		IR_MIPS_OP_MAPPINGS.put("array_load", "addi $at, $zero, <PARAM2>\n"
				+ "sw <PARAM3>, <PARAM1>($at)"); // value -> $reg, then sw
		
		// TODO: Now, map standard library functions to MIPS (call, callr)
	}

}
