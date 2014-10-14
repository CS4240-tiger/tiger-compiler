import java.io.*;

import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;
import org.antlr.runtime.tree.CommonTree;

public class __Test__ {

    public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\testcase.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
            CommonTree ast = g.tiger_program().getTree();
            Thread.sleep(1); // DEBUG: examine result AST in Debug mode 
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}