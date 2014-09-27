import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        tiger lex = new tiger(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\dotproduct.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

 g = new (tokens, 49100, null);
        try {
            g.TIGER_PROGRAM();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}