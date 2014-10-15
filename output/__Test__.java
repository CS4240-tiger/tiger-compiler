import java.io.*;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    @SuppressWarnings("unused")
	public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\testcase.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);


        tigerParser parser = new tigerParser(tokens);
        tigerParser.tiger_program_return r = parser.tiger_program();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(r.getTree());


        tigerTreeWalker walker = new tigerTreeWalker(nodes);
        try {
            CommonTree result = walker.tiger_program().getTree();
            System.nanoTime(); // DEBUG, check result in debug mode
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}