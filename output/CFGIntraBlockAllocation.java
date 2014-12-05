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
	
	/**
	 * Map for all the variables in this block and their type
	 */
	private Map<String,String> typeMap;
	
	/**
	 * List of all EBBs. I'm just going to combine all of them into one codeBlock
	 */
	private ArrayList<CodeBlock> allEBBs;
	
	public CFGIntraBlockAllocation(String input) {
		code = input.split("\n");
		graph = new HashMap<CodeBlock, List<CodeBlock>>(10);
		allCodeBlocks = new ArrayList<CodeBlock>(10);
		this.typeMap = new HashMap<String,String>();
	}
	
	public void allocateAllBlocks() {
		for (CodeBlock block: allCodeBlocks) {
			block.allocateRegs(allCodeBlocks, typeMap);
			block.printMIPS();
		}
	}
	
	public void findEBBs() {
		LinkedList<CodeBlock> leader = new LinkedList<CodeBlock>();
		LinkedList<LinkedList<CodeBlock>> EBBs = new LinkedList<LinkedList<CodeBlock>>(); 
		//gets the actual leader, in this case, the block with main:
		for (CodeBlock each: allCodeBlocks) {
			if (each.getLeader().contains("main:")) {
				leader.push(each);
				//System.out.println(each.getId());
				//System.out.println("edges to:");
				/**for (int i = 0; i < graph.get(each).size(); i++) {
					System.out.println(graph.get(each).get(i).getId());
				}**/
				break;
			}
		}
		ArrayList<CodeBlock> allLeaders = new ArrayList<CodeBlock>();
		while (!leader.isEmpty()) {
			CodeBlock currLeader = leader.pop();
			LinkedList<CodeBlock> currEBB = new LinkedList<CodeBlock>();
			currEBB.push(currLeader);
			//EBBs.push(currEBB);
			LinkedList<CodeBlock> newcurrEBB = new LinkedList<CodeBlock>();
			//System.out.println(currEBB.isEmpty());
			while (!currEBB.isEmpty()) {
				CodeBlock currBlock = currEBB.pop();
				//System.out.println(graph.get(currBlock).size());
				newcurrEBB.push(currBlock);
				List<CodeBlock> neighbors = graph.get(currBlock);
				for (CodeBlock block2: neighbors) {
					//System.out.println(numPredecessor(block2));
					if (numPredecessor(block2) > 1 && !allLeaders.contains(block2)) {
						allLeaders.add(block2);
						//System.out.println("added" + block2.getId());
						leader.push(block2);
					} else if (numPredecessor(block2) == 1){
						//System.out.println("added" + block2.getId());
						currEBB.push(block2);
					}
				}
			}
			EBBs.push(newcurrEBB);
		}
		//System.out.println(EBBs.size());
		ArrayList<CodeBlock> newAllEBBs= new ArrayList<CodeBlock>();
		int id=0;
		for (LinkedList<CodeBlock> EBB: EBBs) {
			ArrayList<String> newCode = new ArrayList<String>();
			while (!EBB.isEmpty()) {
				CodeBlock block = EBB.pop();
				//System.out.println(block.getCode());
				newCode.addAll(block.getCode());
				//newCode.add
			}
			//System.out.println(newCode.size());
			String leader2 = newCode.get(0);
			String last = newCode.get(newCode.size()-1);
			CodeBlock newBlock = new CodeBlock(leader2,last,newCode.toArray(new String[newCode.size()]), id);
			newAllEBBs.add(newBlock);
			id++;
		}
		//System.out.println(newAllEBBs.size());
		allEBBs = newAllEBBs;
	}
	
	private int numPredecessor(CodeBlock block) {
		int numPred = 0;
		for (CodeBlock each: graph.keySet()) {
			if (graph.get(each).contains(block)) {
				numPred++;
			}
		}
		return numPred;
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
			} else if (code[i].contains("br") || code[i].contains("goto") || code[i].contains("call") || code[i].contains("callr") || code[i].contains("return")) {
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
				//System.out.println(breakUp[0]);
				label = breakUp[3].trim();
			} else if (breakUp[0].contains("goto")) {
				//System.out.println(breakUp[0]);
				label = breakUp[1].trim();
				nextblock = false;
			} else if (breakUp[0].contains("callr")) {
				//System.out.println(breakUp[0]);
				label = breakUp[2].trim();
				nextblock = false;
				funcCall = true;
				//System.out.println(label);
			} else if (breakUp[0].contains("call")) {
				//System.out.println(breakUp[0]);
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
						for (int k = j; k < allCodeBlocks.size(); k++) {
							CodeBlock block3 = allCodeBlocks.get(k);
							if (block3.getLast().contains("return")) {
								graph.get(block3).add(allCodeBlocks.get(block1.getId() + 1));
								break;
							}
						}
					}
					if (block2.getLeader().trim().equals(label+":") && !block1.equals(block2)) {
						//System.out.println(block2.getLeader()+" and "+label);
						graph.get(block1).add(block2);
					}
				}
			}
			if (nextblock) {
				graph.get(block1).add(allCodeBlocks.get(block1.getId() + 1));
			}
		}
		/**for (CodeBlock block:graph.get(allCodeBlocks.get(0))){
			System.out.println(block.getLeader());
		}**/
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
