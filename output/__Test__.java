import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("/Users/cevanish12/git/tiger-compiler/TestCases/testCase4kc.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);
        tigerParser g = new tigerParser(tokens);
        System.out.println("Hello");
        try {
            g.tiger_program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}