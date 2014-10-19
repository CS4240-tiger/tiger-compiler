import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class __Test__ {

    public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\testcase.tig", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
            CommonTree parseTree = g.tiger_program().getTree();
            CommonTreeNodeStream nodes = new CommonTreeNodeStream(parseTree);
            tigerTreeWalker walker = new tigerTreeWalker(nodes, g.functions);
            TigerNode walkResult = walker.tiger_program();
            System.out.println(walker.tiger_program() == null ? 
            		"Returned null" : walkResult.eval());
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}