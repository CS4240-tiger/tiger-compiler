import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class TestTreeWalk {
	public static final String LOCAL_TEST_PATH = "C:\\Users\\dcbenas\\Documents\\NewComp\\tiger-compiler2\\TestCases\\testcase4kc.tig";
	public static final String LOCAL_TEST_PATH_SC = "/Users/cevanish12/git/tiger-compiler/TestCases/testcase4kc.tig";
	public static final String MOBILE_TEST_PATH = "E:\\Utilities\\PortableApps\\PortableApps\\GitPortable\\App\\Git\\tiger-compiler\\TestCases\\testcase4kc.tig";
	public static final String OUTPUT_IR_FILENAME = "ir-output.tigir";
	public static final String OUTPUT_IR_PATH = TestTreeWalk.class.getProtectionDomain().getCodeSource().getLocation()
			.getPath().replace("%20", " ").replace("bin/", OUTPUT_IR_FILENAME);
	public static final String OUTPUT_MIPS_FILENAME = "mips-output.s";
	
	public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream(LOCAL_TEST_PATH_SC, "UTF8"));
		
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
        	
        	// Phase 1: Lex/parse/AST population
        	tigerParser.tiger_program_return postParse = g.tiger_program();
            CommonTree parseTree = postParse.getTree();
            SymbolTable symbolTable = postParse.symTable;
            // Phase 2: Treewalk/symbol table/semantic checks/IR generation
            CommonTreeNodeStream treeNodes = new CommonTreeNodeStream(parseTree);
            tigerTreeWalker treeWalker = new tigerTreeWalker(treeNodes, symbolTable);
            treeWalker.tiger_program(); // Walk tree and output IR
            // Phase 3: Register allocation
            NaiveRegisterAllocator regAlloc = new NaiveRegisterAllocator(
            		readFileToList(OUTPUT_IR_PATH));
            for (String output : regAlloc.getMixedOutput()) {
            	System.out.println(output);
            }
            
            // Phase 4: MIPS translation
            MIPSInstructionSelector translator = new MIPSInstructionSelector(
            		regAlloc.getData(), regAlloc.getOutput());
            System.out.println("FINAL TRANSLATED MIPS PROGRAM:");
            for (String output : translator.getOutput()) {
            	System.out.println(output);
            }
            
            outputMIPS(translator.getOutput());
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
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
	
	private static void outputMIPS(List<String> mipsList) throws IOException {
		FileWriter fw = new FileWriter(OUTPUT_MIPS_FILENAME); 
		for (String mipsLine : mipsList) {
			fw.write(mipsLine + "\n");
		}
		
		System.out.println("Output written to " + OUTPUT_MIPS_FILENAME + "!");
		fw.close();
	}
}
