import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class TestTreeWalk {
	public static final String OUTPUT_IR_FILENAME = "ir-output.tigir";
	public static final String OUTPUT_IR_PATH = TestTreeWalk.class.getProtectionDomain().getCodeSource().getLocation()
			.getPath().replace("%20", " ").replace("bin/", OUTPUT_IR_FILENAME);

	public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\testcase4kc.tig", "UTF8"));
		
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
        	tigerParser.tiger_program_return postParse = g.tiger_program();
            CommonTree parseTree = postParse.getTree();
            SymbolTable symbolTable = postParse.symTable;
            CommonTreeNodeStream treeNodes = new CommonTreeNodeStream(parseTree);
            tigerTreeWalker treeWalker = new tigerTreeWalker(treeNodes, symbolTable);
            
            treeWalker.tiger_program(); // Walk tree and output IR
            NaiveRegisterAllocator regAlloc = new NaiveRegisterAllocator(readFileToList(OUTPUT_IR_PATH));
            for (String output : regAlloc.output) {
            	System.out.println(output);
            }
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
	
	private static List<String> readFileToList(String path) throws FileNotFoundException {
		List<String> output = new ArrayList<String>();
		Scanner scan = new Scanner(new File(path));

		while (scan.hasNext()){
			output.add(scan.next());
		}
		
		scan.close();
		return output;
	}
}
