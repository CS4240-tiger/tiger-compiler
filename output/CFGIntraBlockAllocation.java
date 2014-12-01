import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CFGIntraBlockAllocation {
	/**
	 * All the code in one list, separated by lines
	 */
	private String[] code;
	
	/**
	 * the cfg that will be filled
	 */
	private Map<CodeBlock,List<CodeBlock>> graph;
	
	/**
	 * list of all the blocks...Thought it might come in handy
	 */
	private List<CodeBlock> allCodeBlocks;
	
	/**
	 * Generated opening sections to a MIPS program.
	 */
	private Map<String,String> mipsPreface;
	
	public CFGIntraBlockAllocation(String input) {
		code = input.split("\n");
		graph = new HashMap<CodeBlock, List<CodeBlock>>(10);
		allCodeBlocks = new ArrayList<CodeBlock>(10);
	}
	
	public void allocateAllBlocks() {
		allCodeBlocks.get(3).allocateRegs(allCodeBlocks);
	}
	
	/**
	 * gets all the blocks from the code
	 */
	public void findBlocks() {
		int count = 0;
		int id = 0;
		for (int i = 1; i < code.length - 1; i++) {
			if (code[i].contains(":")) {
				//check to get right blocks
				if (i-1 >= count) {
					CodeBlock newCodeBlock = new CodeBlock(code[count], code[i-1], Arrays.copyOfRange(code,count, i), id);
					allCodeBlocks.add(id, newCodeBlock);
					graph.put(newCodeBlock, new LinkedList<CodeBlock>());
					//System.out.println("id:"+String.valueOf(id)+"|S: "+code[count]+"|E: "+code[i-1]);
					count = i;
					id++;
				}
			} else if (code[i].contains("br") || code[i].contains("goto") || code[i].contains("call") || code[i].contains("callr")) {
				//check to get the right blocks
				if (i >= count) {
					CodeBlock newCodeBlock = new CodeBlock(code[count], code[i], Arrays.copyOfRange(code,count, i+1), id);
					allCodeBlocks.add(id, newCodeBlock);
					graph.put(newCodeBlock, new LinkedList<CodeBlock>());
					//System.out.println("id:"+String.valueOf(id)+"|S: "+code[count]+"|E: "+code[i]);
					count = i+1;
					id++;
				}
			} 
		}
		//for the very last block
		CodeBlock newCodeBlock = new CodeBlock(code[count], code[code.length - 1], Arrays.copyOfRange(code,count, code.length), id);
		allCodeBlocks.add(id, newCodeBlock);
		graph.put(newCodeBlock, new LinkedList<CodeBlock>());
		//System.out.println("id:"+String.valueOf(id)+"|S: "+code[count]+"|E: "+code[code.length - 1]);
		//System.out.println(allCodeBlocks.size());
	}
	
	public void buildCFG() {
		//for if the node should point to the next block
		boolean funcCall = false;
		boolean nextblock = false;
		boolean hasLabel;
		for (int i = 0; i < allCodeBlocks.size() - 1; i++) {
			hasLabel = true;
			funcCall = false;
			CodeBlock block1 = allCodeBlocks.get(i);
			String first = block1.getLeader();
			//all blocks before the main label should not point to the next code block
			if (first.contains("main")) {
				nextblock = true;
			}
			String last = block1.getLast();
			String[] breakUp = last.split(",");
			String label = "";
			if (breakUp[0].contains("br")) {
				//System.out.println(Arrays.toString(breakUp));
				label = breakUp[3].trim();
			} else if (breakUp[0].contains("goto")) {
				//System.out.println(Arrays.toString(breakUp));
				label = breakUp[1].trim();
				nextblock = false;
			} else if (breakUp[0].contains("callr")) {
				//System.out.println(Arrays.toString(breakUp));
				label = breakUp[2].trim();
				nextblock = false;
				funcCall = true;
				//System.out.println(label);
			} else if (breakUp[0].contains("call")) {
				//System.out.println(Arrays.toString(breakUp));
				label = breakUp[1].trim();
				nextblock = false;
				funcCall = true;
			} else {
				//shouldn't even check for edges because it doesn't have any labels
				hasLabel = false;
			}
			if (hasLabel) { 
				for (int j = 0; j < allCodeBlocks.size(); j++) {
					CodeBlock block2 = allCodeBlocks.get(j);
					if (funcCall && block2.getLeader().contains(label)) {
						graph.get(block2).add(allCodeBlocks.get(block1.getId() + 1));
					}
					if (block2.getLeader().contains(label)) {
						graph.get(block1).add(block2);
					}
				}
			}
			if (nextblock) {
				graph.get(block1).add(allCodeBlocks.get(block1.getId() + 1));
			}
		}
	}
	
	/**
	 * Appends a list of temporary variables in memory, 
	 * as well as the MIPS .data section header.
	 */
	public void storeAllTemporaries() {
		List<Integer> tempIndexes;
		List<String> foundTemps = new ArrayList<String>();
		String temp, line;
		
		// Search through IR and add all temp references to foundTemps list
		for (int i = 0; i < code.length; i++) {
			line = code[i];
			
			tempIndexes = findTempInLine(line);
			if (!tempIndexes.isEmpty()) {
				for (int index : tempIndexes) {
					temp = line.split("\\s+")[index];
					System.out.println(temp);
					if (!foundTemps.contains(temp)) {
						foundTemps.add(temp);
						//if (line.toLowerCase().contains("assign")) {
							/* Add to header */
							//mipsMemAssign(temp, line);
						//} else {
							/* Assign default value */
							//mipsMemAssign(temp, "assign " + temp + ", 0, ");
						//}
					} 
				}
			}
		}
		//System.out.println(Arrays.toString(foundTemps.toArray()));
	}
	
	private void mipsMemAssign(String label, String line) {
		// assign $a, $b, => [$a, $b, ]
		// assignComponents[0] = target
		// assignComponents[1] = value
		// MIPS: label: .word value
		System.out.println(line);
		String[] assignComponents = line.replace(" ",  "").replace("assign", "").split(",");
		//System.out.println("target: "+assignComponents[0]+"|"+"value: "+assignComponents[1]);
		//System.out.println(Arrays.toString(assignComponents));
		//mipsPreface.put(assignComponents[0],assignComponents[1]);
	}
	
	
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
	

}
