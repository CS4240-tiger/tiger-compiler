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
	
	public CFGIntraBlockAllocation(String input) {
		code = input.split("\n");
		graph = new HashMap<CodeBlock, List<CodeBlock>>(10);
		allCodeBlocks = new ArrayList<CodeBlock>(10);
	}
	
	/**
	 * gets all the blocks from the code
	 */
	public void findBlocks() {
		int count = 0;
		int id = 0;
		for (int i = 1; i < code.length - 1; i++) {
			if (code[i].contains(":")) {
				CodeBlock newCodeBlock = new CodeBlock(code[count], code[i-1], Arrays.copyOfRange(code,count, i), id);
				allCodeBlocks.add(id, newCodeBlock);
				graph.put(newCodeBlock, new LinkedList<CodeBlock>());
				count = i;
				id++;
			} else if (code[i].contains("br") || code[i].contains("goto") || code[i].contains("call") || code[i].contains("callr")) {
				CodeBlock newCodeBlock = new CodeBlock(code[count], code[i], Arrays.copyOfRange(code,count, i+1), id);
				allCodeBlocks.add(id, newCodeBlock);
				graph.put(newCodeBlock, new LinkedList<CodeBlock>());
				count = i+1;
				id++;
			} 
		}
		//for the very last block
		CodeBlock newCodeBlock = new CodeBlock(code[count], code[code.length - 1], Arrays.copyOfRange(code,count, code.length), id);
		allCodeBlocks.add(id, newCodeBlock);
		graph.put(newCodeBlock, new LinkedList<CodeBlock>());
	}
	
	public void buildCFG() {
		//for if the node should point to the next block
		boolean nextblock;
		for (int i = 0; i < allCodeBlocks.size() - 1; i++) {
			nextblock = true;
			CodeBlock block1 = allCodeBlocks.get(i);
			String last = block1.getLast();
			String[] breakUp = last.split(",");
			String label = "";
			if (breakUp[0].contains("br")) {
				label = breakUp[3];
			} else if (breakUp[0].contains("goto")) {
				label = breakUp[1];
				nextblock = false;
			} else if (breakUp[0].contains("callr")) {
				label = breakUp[2];
			} else if (breakUp[0].contains("call")) {
				label = breakUp[1];
			}
			for (int j = 0; j < allCodeBlocks.size(); j++) {
				CodeBlock block2 = allCodeBlocks.get(j);
				if (block2.getLeader().contains(label)) {
					graph.get(block1).add(block2);
				}
			}
			if (nextblock) {
				graph.get(block1).add(allCodeBlocks.get(block1.getId() + 1));
			}
		}
	}	
	

}
