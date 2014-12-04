
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
	 * This method uses removes trailing commas. There are three cases of this: trailing ", , ," ", ," ","
	 */
	private String[] removeEmptyFields(String[] target){
		for (int i = 0; i < target.length; i++){
			target[i] = target[i].trim(); 
			target[i] = target[i].replaceAll(", , ,", "");
			target[i] = target[i].replaceAll(", ,", "");
			target[i] = target[i].replaceAll(",$", "");
		}
		return target;
	}
}
