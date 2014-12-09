import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.antlr.runtime.RecognitionException;

public class KCTESTER {
	public static final String OUTPUT_MIPS_FILENAME = "mips-output.s";
	public static final String OUTPUT_IR_FILENAME = "ir-output.tigir";
	public static final String OUTPUT_IR_PATH = TestTreeWalk.class.getProtectionDomain().getCodeSource().getLocation()
			.getPath().replace("%20", " ").replace("bin/", OUTPUT_IR_FILENAME);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String content="hi";
		NaiveRegisterAllocator regAlloc = null;
		try {
		content = new Scanner(new File("C:\\Users\\Jinhai Steakhouse\\Desktop\\Temp\\phase3_tiger-compiler\\ir-output.tigir")).useDelimiter("\\Z").next();
		regAlloc = new NaiveRegisterAllocator(
        		readFileToList(OUTPUT_IR_PATH));
		} catch (FileNotFoundException e) {
			System.out.println("file doesn't exist");
		}
		//System.out.println(content);
		CFGIntraBlockAllocation cfg = new CFGIntraBlockAllocation(content);
		cfg.findBlocks();
		//cfg.printBlocks();
		//cfg.storeAllTemporaries();
		cfg.buildCFG();
		//cfg.printGraph();
		//cfg.allocateAllBlocks();
		cfg.findEBBs();
		cfg.allocateAllEBBs();
		//cfg.printEBBs();
		MIPSInstructionSelector translator = new MIPSInstructionSelector(
        		regAlloc.getData(), cfg.getEBBOutput());
		System.out.println("FINAL TRANSLATED MIPS PROGRAM:");
        for (String output : translator.getOutput()) {
        	System.out.println(output);
        }
        try {
        	outputMIPS(translator.getOutput());
        } catch(IOException e) {
        	System.out.println("nothing works");
        }
	}
	
	private static void outputMIPS(List<String> mipsList) throws IOException {
		FileWriter fw = new FileWriter(OUTPUT_MIPS_FILENAME); 
		for (String mipsLine : mipsList) {
			fw.write(mipsLine + "\n");
		}
		
		System.out.println("Output written to " + OUTPUT_MIPS_FILENAME + "!");
		fw.close();
	}
	
	private static List<String> readFileToList(String path) throws FileNotFoundException {
		List<String> output = new LinkedList<String>();
		Scanner scan = new Scanner(new File(path));

		while (scan.hasNextLine()){
			output.add(scan.nextLine());
		}
		
		scan.close();
		return output;
	}

}
