
public class MIPSGenerator {
	
	private String[] IROutLines;
	
	public MIPSGenerator(String in){
		IROutLines = in.split("[\\r\\n]+");

	}

	public void outputMIPS() {
		IROutLines = removeEmptyFields(IROutLines);	
		for(String curr:IROutLines) System.out.println(curr);
		System.out.println(IROutLines.length);
	}
	
	/**
	 * This method uses removes trailing commas and commas after instruction names. Messy but functional.
	 * eg. add, x, y, z => add x, y, z
	 * 	   return x, , , => return x
	 */
	private String[] removeEmptyFields(String[] target){
		for (int i = 0; i < target.length; i++){
			target[i] = target[i].trim(); 
			target[i] = target[i].replaceAll(", , ,|, ,|,$", ""); 
			target[i] = target[i].replaceAll("assign,", "assign");
			target[i] = target[i].replaceAll("return,", "return");
			target[i] = target[i].replaceAll("callr,","callr");
			target[i] = target[i].replaceAll("add,", "add");
			target[i] = target[i].replaceAll("goto,", "goto");
			target[i] = target[i].replaceAll("brneq,", "brneq");
		}
		return target;
	}
}
