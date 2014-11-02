import org.antlr.runtime.*;

public class __Test__ {

    public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("/Users/cevanish12/Desktop/CS4240/tiger-compiler/TestCases/testCase4kc.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
            g.tiger_program();
            //System.out.println("passed!");
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}