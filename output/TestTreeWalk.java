import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class TestTreeWalk {
	public static void main(String args[]) throws Exception {
        tigerLexer lex = new tigerLexer(new ANTLRFileStream("C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\TestCases\\testcase4kc.tig", "UTF8"));
		
        CommonTokenStream tokens = new CommonTokenStream(lex);

        tigerParser g = new tigerParser(tokens);
        try {
            CommonTree parseTree = g.tiger_program().getTree();
            CommonTreeNodeStream treeNodes = new CommonTreeNodeStream(parseTree);
            tigerTreeWalker treeWalker = new tigerTreeWalker(treeNodes);
            
            treeWalker.tiger_program(); // Walk tree and output IR
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
