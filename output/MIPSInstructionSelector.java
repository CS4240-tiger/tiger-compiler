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
		
		// IR_MIPS_OP_MAPPINGS.put("assign", "$label: $value");
		// It's assumed that variables are already assigned in previous 
		// phases, so we're going to assume that assign is referring to 
		// array static value population only
		
		// But we need to handle placing unique labels later on for looping
		IR_MIPS_OP_MAPPINGS.put("assign", "add $t9, $zero, $zero\n"
				+ "addi $t8, $zero, $array_size"
				+ "$assignLoopLabelBeg:\n" 
				+ "sw $value, $label($t9)\n"
				+ "addi $t9, $t9, 1\n"
				+ "bne $t8, $t9, $assignLoopLabelEnd");
		IR_MIPS_OP_MAPPINGS.put("add", "add $dest, $param1, $param2");
		IR_MIPS_OP_MAPPINGS.put("sub", "sub $dest, $param1, $param2");
		// mult: Assume max 32-bit, so don't access HI
		IR_MIPS_OP_MAPPINGS.put("mult", "mult $param1, $param2\n"
				+ "mflo $dest"); 
		// div: Assume integer division, so don't access HI
		IR_MIPS_OP_MAPPINGS.put("div", "div $param1, $param2\n"
				+ "mflo $dest");
		IR_MIPS_OP_MAPPINGS.put("and", "and $dest, $param1, $param2");
		IR_MIPS_OP_MAPPINGS.put("or", "or $dest, $param1, $param2");
		IR_MIPS_OP_MAPPINGS.put("goto", "jr $addr");
		IR_MIPS_OP_MAPPINGS.put("breq", "beq $param1, $param2, $addr");
		IR_MIPS_OP_MAPPINGS.put("brneq", "bne $param1, $param2, $addr");
		IR_MIPS_OP_MAPPINGS.put("brlt", "blt $param1, $param2, $addr");
		IR_MIPS_OP_MAPPINGS.put("brgt", "bgt $param1, $param2, $addr");
		IR_MIPS_OP_MAPPINGS.put("brgeq", "bge $param1, $param2, $addr");
		IR_MIPS_OP_MAPPINGS.put("brleq", "ble $param1, $param2, $addr");
		IR_MIPS_OP_MAPPINGS.put("return", "jr $ra");
		IR_MIPS_OP_MAPPINGS.put("call", "jr $addr");
		IR_MIPS_OP_MAPPINGS.put("callr", "jr $addr");
		IR_MIPS_OP_MAPPINGS.put("array_store", "add $at, $param1, $zero\n"
				+ "lw $dest, $addr($at)"); // value -> $reg, then lw
		IR_MIPS_OP_MAPPINGS.put("array_load", "add $at, $param1, $zero\n"
				+ "sw $dest, $addr($at)"); // value -> $reg, then sw
		
		// TODO: Now, map standard library functions to MIPS (call, callr)
	}

}
