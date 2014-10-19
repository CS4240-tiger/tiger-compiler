import org.antlr.runtime.*;

public class __Test__ {

    public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\testcase.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
            g.tiger_program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}