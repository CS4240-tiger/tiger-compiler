// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-20 10:44:33

	import java.util.Map;
	import java.util.HashMap;
	import org.antlr.runtime.tree.CommonTree;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class tigerParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY_KEY", "ASSIGN", 
		"AST_ARRAY_DECL", "AST_BLOCK", "AST_FUNC_DECL", "AST_PARAM", "BEGIN_KEY", 
		"BREAK_KEY", "CARRAGE_RET", "COLON", "COMMA", "COMMENT", "DIV", "DO_KEY", 
		"ELSE_KEY", "ENDDO_KEY", "ENDIF_KEY", "END_KEY", "EQ", "FIXEDPTLIT", "FIXEDPT_KEY", 
		"FOR_KEY", "FUNCTION_KEY", "GREATER", "GREATEREQ", "ID", "ID_KEY", "IF_KEY", 
		"INTLIT", "INT_KEY", "LBRACK", "LESSER", "LESSEREQ", "LPAREN", "MAIN_KEY", 
		"MINUS", "MULT", "NEQ", "NEWLINE", "OF_KEY", "OR", "PLUS", "RBRACK", "RETURN_KEY", 
		"RPAREN", "SEMI", "TAB", "THEN_KEY", "TO_KEY", "TYPE_KEY", "VAR_KEY", 
		"VOID_KEY", "WHILE_KEY", "WHITESPACE"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY_KEY=5;
	public static final int ASSIGN=6;
	public static final int AST_ARRAY_DECL=7;
	public static final int AST_BLOCK=8;
	public static final int AST_FUNC_DECL=9;
	public static final int AST_PARAM=10;
	public static final int BEGIN_KEY=11;
	public static final int BREAK_KEY=12;
	public static final int CARRAGE_RET=13;
	public static final int COLON=14;
	public static final int COMMA=15;
	public static final int COMMENT=16;
	public static final int DIV=17;
	public static final int DO_KEY=18;
	public static final int ELSE_KEY=19;
	public static final int ENDDO_KEY=20;
	public static final int ENDIF_KEY=21;
	public static final int END_KEY=22;
	public static final int EQ=23;
	public static final int FIXEDPTLIT=24;
	public static final int FIXEDPT_KEY=25;
	public static final int FOR_KEY=26;
	public static final int FUNCTION_KEY=27;
	public static final int GREATER=28;
	public static final int GREATEREQ=29;
	public static final int ID=30;
	public static final int ID_KEY=31;
	public static final int IF_KEY=32;
	public static final int INTLIT=33;
	public static final int INT_KEY=34;
	public static final int LBRACK=35;
	public static final int LESSER=36;
	public static final int LESSEREQ=37;
	public static final int LPAREN=38;
	public static final int MAIN_KEY=39;
	public static final int MINUS=40;
	public static final int MULT=41;
	public static final int NEQ=42;
	public static final int NEWLINE=43;
	public static final int OF_KEY=44;
	public static final int OR=45;
	public static final int PLUS=46;
	public static final int RBRACK=47;
	public static final int RETURN_KEY=48;
	public static final int RPAREN=49;
	public static final int SEMI=50;
	public static final int TAB=51;
	public static final int THEN_KEY=52;
	public static final int TO_KEY=53;
	public static final int TYPE_KEY=54;
	public static final int VAR_KEY=55;
	public static final int VOID_KEY=56;
	public static final int WHILE_KEY=57;
	public static final int WHITESPACE=58;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "ret_type", "block", "func_call", "binary_operator", "synpred1_tiger", 
		"base_type", "constval", "param_list", "binop_p0", "index_expr", "stat", 
		"type_declaration", "declaration_statement", "value_tail", "funct_declaration_list", 
		"main_function", "binop_p3", "keywords", "block_list", "expr_list", "funct_declaration", 
		"param", "var_declaration_list", "expr", "type", "binop_p2", "type_id", 
		"stat_seq", "synpred2_tiger", "tiger_program", "id_list", "binop_p1", 
		"var_declaration", "index_oper", "func_param_list", "type_declaration_list", 
		"func_call_tail", "value"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, true, false, false, false, false, false, 
		    false, false, false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public tigerParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public tigerParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public tigerParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return tigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g"; }


		public Map<String, TigerFunction> functions = new HashMap<String, TigerFunction>();
	    
		@Override
		public void reportError(RecognitionException e) {
			displayRecognitionError(this.getTokenNames(), e);
		}
		
		@Override
		public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
			/*
			 * Function code
			 */
			String code = e.input.toString();
			/*
			 * Line index
			 */
			int lineIndex = e.line;
			
			// Split into an array by lines
			String lines[] = code.split("\\r?\\n");
			
	        // Get the line of code with everything before 
			// the first character turned into spaces
			String lineCode = lines[lineIndex-1].replaceAll("\t", " ");
	        // Turn into char array
			if (e.charPositionInLine == 0) {
				lineCode = "' '" + lineCode;
			} else if (e.charPositionInLine == lineCode.length()) {
				lineCode = lineCode + "' '";
			} else {
				lineCode = lineCode.substring(0,e.charPositionInLine) 
				+ "'" + lineCode.charAt(e.charPositionInLine) 
				+ "'" + lineCode.substring(e.charPositionInLine + 1,lineCode.length());
			}
			lineCode = lineCode.replaceFirst(".*?(?=[a-zA-Z0-9\'])", "");
			System.err.println("Error at line " + String.valueOf(lineIndex) + ": " + lineCode + " ("+getErrorMessage(e, tokenNames)+")");
		}
	    
		private void defineFunction(String id, Object params, Object block) {
			// Parameters
			CommonTree paramTree = params == null ? new CommonTree() : (CommonTree) params;

			// Code block tree
			CommonTree blockTree = (CommonTree) block;

			// The function name with the number of parameters after it, is the unique key
			String key = id + paramTree.getChildCount();
			functions.put(key, new TigerFunction(id, paramTree, blockTree));
		}


	public static class tiger_program_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(112, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:113:2: ( type_declaration_list funct_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:113:4: type_declaration_list funct_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(113,4);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program96);
			type_declaration_list1=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list1.getTree());
			dbg.location(113,26);
			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program98);
			funct_declaration_list2=funct_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, funct_declaration_list2.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(114, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "tiger_program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "tiger_program"


	public static class funct_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:116:1: funct_declaration_list : ( funct_declaration )* ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(116, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:2: ( ( funct_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:4: ( funct_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(117,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:4: ( funct_declaration )*
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY||LA1_0==VOID_KEY) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:4: funct_declaration
					{
					dbg.location(117,4);
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list111);
					funct_declaration3=funct_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, funct_declaration3.getTree());

					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(118, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funct_declaration_list"


	public static class funct_declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:1: funct_declaration : ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI -> ^( AST_FUNC_DECL[ID] param_list block_list ) ;
	public final tigerParser.funct_declaration_return funct_declaration() throws RecognitionException {
		tigerParser.funct_declaration_return retval = new tigerParser.funct_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FUNCTION_KEY5=null;
		Token ID6=null;
		Token LPAREN7=null;
		Token RPAREN9=null;
		Token BEGIN_KEY10=null;
		Token END_KEY12=null;
		Token SEMI13=null;
		ParserRuleReturnScope ret_type4 =null;
		ParserRuleReturnScope param_list8 =null;
		ParserRuleReturnScope block_list11 =null;

		CommonTree FUNCTION_KEY5_tree=null;
		CommonTree ID6_tree=null;
		CommonTree LPAREN7_tree=null;
		CommonTree RPAREN9_tree=null;
		CommonTree BEGIN_KEY10_tree=null;
		CommonTree END_KEY12_tree=null;
		CommonTree SEMI13_tree=null;
		RewriteRuleTokenStream stream_BEGIN_KEY=new RewriteRuleTokenStream(adaptor,"token BEGIN_KEY");
		RewriteRuleTokenStream stream_FUNCTION_KEY=new RewriteRuleTokenStream(adaptor,"token FUNCTION_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_END_KEY=new RewriteRuleTokenStream(adaptor,"token END_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_ret_type=new RewriteRuleSubtreeStream(adaptor,"rule ret_type");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try { dbg.enterRule(getGrammarFileName(), "funct_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(120, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:2: ( ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI -> ^( AST_FUNC_DECL[ID] param_list block_list ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:4: ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(121,4);
			pushFollow(FOLLOW_ret_type_in_funct_declaration123);
			ret_type4=ret_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ret_type.add(ret_type4.getTree());dbg.location(121,13);
			FUNCTION_KEY5=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration125); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FUNCTION_KEY.add(FUNCTION_KEY5);
			dbg.location(121,26);
			ID6=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration127); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID6);
			dbg.location(121,29);
			LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration129); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN7);
			dbg.location(121,36);
			pushFollow(FOLLOW_param_list_in_funct_declaration131);
			param_list8=param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_param_list.add(param_list8.getTree());dbg.location(121,47);
			RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration133); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN9);
			dbg.location(121,54);
			BEGIN_KEY10=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration135); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BEGIN_KEY.add(BEGIN_KEY10);
			dbg.location(121,64);
			pushFollow(FOLLOW_block_list_in_funct_declaration137);
			block_list11=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_list.add(block_list11.getTree());dbg.location(121,75);
			END_KEY12=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration139); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_END_KEY.add(END_KEY12);
			dbg.location(121,83);
			SEMI13=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration141); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI13);

			// AST REWRITE
			// elements: param_list, block_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 122:2: -> ^( AST_FUNC_DECL[ID] param_list block_list )
			{
				dbg.location(122,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:122:5: ^( AST_FUNC_DECL[ID] param_list block_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(122,7);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_FUNC_DECL, ID), root_1);
				dbg.location(122,25);
				adaptor.addChild(root_1, stream_param_list.nextTree());dbg.location(122,36);
				adaptor.addChild(root_1, stream_block_list.nextTree());
				adaptor.addChild(root_0, root_1);
				}
				dbg.location(123,3);
				adaptor.addChild(root_0, defineFunction((ID6!=null?ID6.getText():null), (param_list8!=null?((CommonTree)param_list8.getTree()):null), (block_list11!=null?((CommonTree)block_list11.getTree()):null)););
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(124, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funct_declaration"


	public static class main_function_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "main_function"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:126:1: main_function : ( VOID_KEY MAIN_KEY LPAREN RPAREN )=> VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI ;
	public final tigerParser.main_function_return main_function() throws RecognitionException {
		tigerParser.main_function_return retval = new tigerParser.main_function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY14=null;
		Token MAIN_KEY15=null;
		Token LPAREN16=null;
		Token RPAREN17=null;
		Token BEGIN_KEY18=null;
		Token END_KEY20=null;
		Token SEMI21=null;
		ParserRuleReturnScope block_list19 =null;

		CommonTree VOID_KEY14_tree=null;
		CommonTree MAIN_KEY15_tree=null;
		CommonTree LPAREN16_tree=null;
		CommonTree RPAREN17_tree=null;
		CommonTree BEGIN_KEY18_tree=null;
		CommonTree END_KEY20_tree=null;
		CommonTree SEMI21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "main_function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(126, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:2: ( ( VOID_KEY MAIN_KEY LPAREN RPAREN )=> VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:4: ( VOID_KEY MAIN_KEY LPAREN RPAREN )=> VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(127,41);
			VOID_KEY14=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_main_function180); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VOID_KEY14_tree = (CommonTree)adaptor.create(VOID_KEY14);
			adaptor.addChild(root_0, VOID_KEY14_tree);
			}
			dbg.location(127,50);
			MAIN_KEY15=(Token)match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function182); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAIN_KEY15_tree = (CommonTree)adaptor.create(MAIN_KEY15);
			adaptor.addChild(root_0, MAIN_KEY15_tree);
			}
			dbg.location(127,59);
			LPAREN16=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function184); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN16_tree = (CommonTree)adaptor.create(LPAREN16);
			adaptor.addChild(root_0, LPAREN16_tree);
			}
			dbg.location(127,66);
			RPAREN17=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function186); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN17_tree = (CommonTree)adaptor.create(RPAREN17);
			adaptor.addChild(root_0, RPAREN17_tree);
			}
			dbg.location(127,73);
			BEGIN_KEY18=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_main_function188); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BEGIN_KEY18_tree = (CommonTree)adaptor.create(BEGIN_KEY18);
			adaptor.addChild(root_0, BEGIN_KEY18_tree);
			}
			dbg.location(127,83);
			pushFollow(FOLLOW_block_list_in_main_function190);
			block_list19=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, block_list19.getTree());
			dbg.location(127,94);
			END_KEY20=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_main_function192); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			END_KEY20_tree = (CommonTree)adaptor.create(END_KEY20);
			adaptor.addChild(root_0, END_KEY20_tree);
			}
			dbg.location(127,102);
			SEMI21=(Token)match(input,SEMI,FOLLOW_SEMI_in_main_function194); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SEMI21_tree = (CommonTree)adaptor.create(SEMI21);
			adaptor.addChild(root_0, SEMI21_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(128, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "main_function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "main_function"


	public static class ret_type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:1: ret_type : ( VOID_KEY | type_id );
	public final tigerParser.ret_type_return ret_type() throws RecognitionException {
		tigerParser.ret_type_return retval = new tigerParser.ret_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY22=null;
		ParserRuleReturnScope type_id23 =null;

		CommonTree VOID_KEY22_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "ret_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(130, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:2: ( VOID_KEY | type_id )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==VOID_KEY) ) {
				alt2=1;
			}
			else if ( (LA2_0==FIXEDPT_KEY||LA2_0==ID||LA2_0==INT_KEY) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:4: VOID_KEY
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(131,4);
					VOID_KEY22=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type206); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VOID_KEY22_tree = (CommonTree)adaptor.create(VOID_KEY22);
					adaptor.addChild(root_0, VOID_KEY22_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:132:4: type_id
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(132,4);
					pushFollow(FOLLOW_type_id_in_ret_type211);
					type_id23=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id23.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(133, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ret_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ret_type"


	public static class param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:1: param_list : ( param ( COMMA param )* )? -> ( AST_PARAM[param] )* ;
	public final tigerParser.param_list_return param_list() throws RecognitionException {
		tigerParser.param_list_return retval = new tigerParser.param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA25=null;
		ParserRuleReturnScope param24 =null;
		ParserRuleReturnScope param26 =null;

		CommonTree COMMA25_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");

		try { dbg.enterRule(getGrammarFileName(), "param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(135, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:2: ( ( param ( COMMA param )* )? -> ( AST_PARAM[param] )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:4: ( param ( COMMA param )* )?
			{
			dbg.location(136,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:4: ( param ( COMMA param )* )?
			int alt4=2;
			try { dbg.enterSubRule(4);
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:5: param ( COMMA param )*
					{
					dbg.location(136,5);
					pushFollow(FOLLOW_param_in_param_list224);
					param24=param();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param.add(param24.getTree());dbg.location(136,11);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:11: ( COMMA param )*
					try { dbg.enterSubRule(3);

					loop3:
					while (true) {
						int alt3=2;
						try { dbg.enterDecision(3, decisionCanBacktrack[3]);

						int LA3_0 = input.LA(1);
						if ( (LA3_0==COMMA) ) {
							alt3=1;
						}

						} finally {dbg.exitDecision(3);}

						switch (alt3) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:12: COMMA param
							{
							dbg.location(136,12);
							COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list227); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA25);
							dbg.location(136,18);
							pushFollow(FOLLOW_param_in_param_list229);
							param26=param();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_param.add(param26.getTree());
							}
							break;

						default :
							break loop3;
						}
					}
					} finally {dbg.exitSubRule(3);}

					}
					break;

			}
			} finally {dbg.exitSubRule(4);}

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 137:2: -> ( AST_PARAM[param] )*
			{
				dbg.location(137,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:137:5: ( AST_PARAM[param] )*
				while (  ) {
					dbg.location(137,5);
					adaptor.addChild(root_0, (CommonTree)adaptor.create(AST_PARAM, param));
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(138, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "param_list"


	public static class param_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:1: param : ID COLON type_id -> ^( COLON ID type_id ) ;
	public final tigerParser.param_return param() throws RecognitionException {
		tigerParser.param_return retval = new tigerParser.param_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID27=null;
		Token COLON28=null;
		ParserRuleReturnScope type_id29 =null;

		CommonTree ID27_tree=null;
		CommonTree COLON28_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");

		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(140, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:8: ( ID COLON type_id -> ^( COLON ID type_id ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:10: ID COLON type_id
			{
			dbg.location(140,10);
			ID27=(Token)match(input,ID,FOLLOW_ID_in_param251); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID27);
			dbg.location(140,13);
			COLON28=(Token)match(input,COLON,FOLLOW_COLON_in_param253); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON28);
			dbg.location(140,19);
			pushFollow(FOLLOW_type_id_in_param255);
			type_id29=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_id.add(type_id29.getTree());
			// AST REWRITE
			// elements: COLON, ID, type_id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 141:2: -> ^( COLON ID type_id )
			{
				dbg.location(141,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:141:5: ^( COLON ID type_id )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(141,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_COLON.nextNode(), root_1);
				dbg.location(141,13);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(141,16);
				adaptor.addChild(root_1, stream_type_id.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(142, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "param"


	public static class block_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block30 =null;


		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(144, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:2: ( ( block )+ )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:4: ( block )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(145,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:4: ( block )+
			int cnt5=0;
			try { dbg.enterSubRule(5);

			loop5:
			while (true) {
				int alt5=2;
				try { dbg.enterDecision(5, decisionCanBacktrack[5]);

				int LA5_0 = input.LA(1);
				if ( (LA5_0==BEGIN_KEY) ) {
					alt5=1;
				}

				} finally {dbg.exitDecision(5);}

				switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:4: block
					{
					dbg.location(145,4);
					pushFollow(FOLLOW_block_in_block_list278);
					block30=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block30.getTree());

					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(5, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt5++;
			}
			} finally {dbg.exitSubRule(5);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(146, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "block_list"


	public static class block_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:1: block : BEGIN_KEY ( declaration_statement stat_seq ) END_KEY SEMI -> ^( AST_BLOCK declaration_statement stat_seq ) ;
	public final tigerParser.block_return block() throws RecognitionException {
		tigerParser.block_return retval = new tigerParser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BEGIN_KEY31=null;
		Token END_KEY34=null;
		Token SEMI35=null;
		ParserRuleReturnScope declaration_statement32 =null;
		ParserRuleReturnScope stat_seq33 =null;

		CommonTree BEGIN_KEY31_tree=null;
		CommonTree END_KEY34_tree=null;
		CommonTree SEMI35_tree=null;
		RewriteRuleTokenStream stream_BEGIN_KEY=new RewriteRuleTokenStream(adaptor,"token BEGIN_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_END_KEY=new RewriteRuleTokenStream(adaptor,"token END_KEY");
		RewriteRuleSubtreeStream stream_declaration_statement=new RewriteRuleSubtreeStream(adaptor,"rule declaration_statement");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(148, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:8: ( BEGIN_KEY ( declaration_statement stat_seq ) END_KEY SEMI -> ^( AST_BLOCK declaration_statement stat_seq ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:10: BEGIN_KEY ( declaration_statement stat_seq ) END_KEY SEMI
			{
			dbg.location(148,10);
			BEGIN_KEY31=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block290); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BEGIN_KEY.add(BEGIN_KEY31);
			dbg.location(148,20);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:20: ( declaration_statement stat_seq )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:21: declaration_statement stat_seq
			{
			dbg.location(148,21);
			pushFollow(FOLLOW_declaration_statement_in_block293);
			declaration_statement32=declaration_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declaration_statement.add(declaration_statement32.getTree());dbg.location(148,43);
			pushFollow(FOLLOW_stat_seq_in_block295);
			stat_seq33=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq33.getTree());
			}
			dbg.location(148,53);
			END_KEY34=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_block298); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_END_KEY.add(END_KEY34);
			dbg.location(148,61);
			SEMI35=(Token)match(input,SEMI,FOLLOW_SEMI_in_block300); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI35);

			// AST REWRITE
			// elements: stat_seq, declaration_statement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 149:2: -> ^( AST_BLOCK declaration_statement stat_seq )
			{
				dbg.location(149,6);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:149:6: ^( AST_BLOCK declaration_statement stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(149,8);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_BLOCK, "AST_BLOCK"), root_1);
				dbg.location(149,18);
				adaptor.addChild(root_1, stream_declaration_statement.nextTree());dbg.location(149,40);
				adaptor.addChild(root_1, stream_stat_seq.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(150, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "block"


	public static class declaration_statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list36 =null;
		ParserRuleReturnScope var_declaration_list37 =null;


		try { dbg.enterRule(getGrammarFileName(), "declaration_statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(152, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:2: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:4: type_declaration_list var_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(153,4);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement325);
			type_declaration_list36=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list36.getTree());
			dbg.location(153,26);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement327);
			var_declaration_list37=var_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration_list37.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(154, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration_statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "declaration_statement"


	public static class type_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration38 =null;


		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(156, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:2: ( ( type_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:5: ( type_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(157,5);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:5: ( type_declaration )*
			try { dbg.enterSubRule(6);

			loop6:
			while (true) {
				int alt6=2;
				try { dbg.enterDecision(6, decisionCanBacktrack[6]);

				int LA6_0 = input.LA(1);
				if ( (LA6_0==TYPE_KEY) ) {
					alt6=1;
				}

				} finally {dbg.exitDecision(6);}

				switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:5: type_declaration
					{
					dbg.location(157,5);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list341);
					type_declaration38=type_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration38.getTree());

					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(158, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type_declaration_list"


	public static class var_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_declaration39 =null;


		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(160, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:2: ( ( var_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:4: ( var_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(161,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:4: ( var_declaration )*
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==VAR_KEY) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:4: var_declaration
					{
					dbg.location(161,4);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list355);
					var_declaration39=var_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration39.getTree());

					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(162, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "var_declaration_list"


	public static class type_declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:1: type_declaration : ( TYPE_KEY ID ) EQ type SEMI -> ^( EQ ID type ) ;
	public final tigerParser.type_declaration_return type_declaration() throws RecognitionException {
		tigerParser.type_declaration_return retval = new tigerParser.type_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TYPE_KEY40=null;
		Token ID41=null;
		Token EQ42=null;
		Token SEMI44=null;
		ParserRuleReturnScope type43 =null;

		CommonTree TYPE_KEY40_tree=null;
		CommonTree ID41_tree=null;
		CommonTree EQ42_tree=null;
		CommonTree SEMI44_tree=null;
		RewriteRuleTokenStream stream_TYPE_KEY=new RewriteRuleTokenStream(adaptor,"token TYPE_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try { dbg.enterRule(getGrammarFileName(), "type_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(164, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:2: ( ( TYPE_KEY ID ) EQ type SEMI -> ^( EQ ID type ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:4: ( TYPE_KEY ID ) EQ type SEMI
			{
			dbg.location(165,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:4: ( TYPE_KEY ID )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:5: TYPE_KEY ID
			{
			dbg.location(165,5);
			TYPE_KEY40=(Token)match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration369); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TYPE_KEY.add(TYPE_KEY40);
			dbg.location(165,14);
			ID41=(Token)match(input,ID,FOLLOW_ID_in_type_declaration371); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID41);

			}
			dbg.location(165,18);
			EQ42=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration374); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EQ.add(EQ42);
			dbg.location(165,21);
			pushFollow(FOLLOW_type_in_type_declaration376);
			type43=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(type43.getTree());dbg.location(165,26);
			SEMI44=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration378); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI44);

			// AST REWRITE
			// elements: ID, EQ, type
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 166:2: -> ^( EQ ID type )
			{
				dbg.location(166,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:166:5: ^( EQ ID type )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(166,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_EQ.nextNode(), root_1);
				dbg.location(166,10);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(166,13);
				adaptor.addChild(root_1, stream_type.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(167, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type_declaration"


	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:169:1: type : ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) OF_KEY ( base_type ) -> ^( OF_KEY AST_ARRAY_DECL[ARRAY_KEY LBRACK INTLIT RBRACK (LBRACK INTLIT RBRACK)?] base_type ) );
	public final tigerParser.type_return type() throws RecognitionException {
		tigerParser.type_return retval = new tigerParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ARRAY_KEY46=null;
		Token LBRACK47=null;
		Token INTLIT48=null;
		Token RBRACK49=null;
		Token LBRACK50=null;
		Token INTLIT51=null;
		Token RBRACK52=null;
		Token OF_KEY53=null;
		ParserRuleReturnScope base_type45 =null;
		ParserRuleReturnScope base_type54 =null;

		CommonTree ARRAY_KEY46_tree=null;
		CommonTree LBRACK47_tree=null;
		CommonTree INTLIT48_tree=null;
		CommonTree RBRACK49_tree=null;
		CommonTree LBRACK50_tree=null;
		CommonTree INTLIT51_tree=null;
		CommonTree RBRACK52_tree=null;
		CommonTree OF_KEY53_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_OF_KEY=new RewriteRuleTokenStream(adaptor,"token OF_KEY");
		RewriteRuleTokenStream stream_ARRAY_KEY=new RewriteRuleTokenStream(adaptor,"token ARRAY_KEY");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_INTLIT=new RewriteRuleTokenStream(adaptor,"token INTLIT");
		RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");

		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(169, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:169:6: ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) OF_KEY ( base_type ) -> ^( OF_KEY AST_ARRAY_DECL[ARRAY_KEY LBRACK INTLIT RBRACK (LBRACK INTLIT RBRACK)?] base_type ) )
			int alt9=2;
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			int LA9_0 = input.LA(1);
			if ( (LA9_0==FIXEDPT_KEY||LA9_0==INT_KEY) ) {
				alt9=1;
			}
			else if ( (LA9_0==ARRAY_KEY) ) {
				alt9=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(9);}

			switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:169:8: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(169,8);
					pushFollow(FOLLOW_base_type_in_type400);
					base_type45=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type45.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) OF_KEY ( base_type )
					{
					dbg.location(170,4);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:5: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )?
					{
					dbg.location(170,5);
					ARRAY_KEY46=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type406); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARRAY_KEY.add(ARRAY_KEY46);
					dbg.location(170,15);
					LBRACK47=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type408); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK47);
					dbg.location(170,22);
					INTLIT48=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type410); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_INTLIT.add(INTLIT48);
					dbg.location(170,29);
					RBRACK49=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type412); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK49);
					dbg.location(170,36);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:36: ( LBRACK INTLIT RBRACK )?
					int alt8=2;
					try { dbg.enterSubRule(8);
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==LBRACK) ) {
						alt8=1;
					}
					} finally {dbg.exitDecision(8);}

					switch (alt8) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:37: LBRACK INTLIT RBRACK
							{
							dbg.location(170,37);
							LBRACK50=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type415); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK50);
							dbg.location(170,44);
							INTLIT51=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type417); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_INTLIT.add(INTLIT51);
							dbg.location(170,51);
							RBRACK52=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type419); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK52);

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}

					}
					dbg.location(170,61);
					OF_KEY53=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type424); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OF_KEY.add(OF_KEY53);
					dbg.location(170,68);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:68: ( base_type )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:170:69: base_type
					{
					dbg.location(170,69);
					pushFollow(FOLLOW_base_type_in_type427);
					base_type54=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_base_type.add(base_type54.getTree());
					}

					// AST REWRITE
					// elements: base_type, OF_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 171:2: -> ^( OF_KEY AST_ARRAY_DECL[ARRAY_KEY LBRACK INTLIT RBRACK (LBRACK INTLIT RBRACK)?] base_type )
					{
						dbg.location(171,5);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:171:5: ^( OF_KEY AST_ARRAY_DECL[ARRAY_KEY LBRACK INTLIT RBRACK (LBRACK INTLIT RBRACK)?] base_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(171,7);
						root_1 = (CommonTree)adaptor.becomeRoot(stream_OF_KEY.nextNode(), root_1);
						dbg.location(171,14);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(AST_ARRAY_DECL, ARRAY_KEY LBRACK INTLIT RBRACK (LBRACK INTLIT RBRACK)?));dbg.location(171,85);
						adaptor.addChild(root_1, stream_base_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(172, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type"


	public static class type_id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:174:1: type_id : ( base_type | ID );
	public final tigerParser.type_id_return type_id() throws RecognitionException {
		tigerParser.type_id_return retval = new tigerParser.type_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID56=null;
		ParserRuleReturnScope base_type55 =null;

		CommonTree ID56_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "type_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(174, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:174:9: ( base_type | ID )
			int alt10=2;
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			int LA10_0 = input.LA(1);
			if ( (LA10_0==FIXEDPT_KEY||LA10_0==INT_KEY) ) {
				alt10=1;
			}
			else if ( (LA10_0==ID) ) {
				alt10=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:174:11: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(174,11);
					pushFollow(FOLLOW_base_type_in_type_id450);
					base_type55=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type55.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:175:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(175,4);
					ID56=(Token)match(input,ID,FOLLOW_ID_in_type_id455); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID56_tree = (CommonTree)adaptor.create(ID56);
					adaptor.addChild(root_0, ID56_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(176, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "type_id"


	public static class base_type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "base_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:178:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set57=null;

		CommonTree set57_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(178, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:179:2: ( INT_KEY | FIXEDPT_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(179,2);
			set57=input.LT(1);
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set57));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(181, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "base_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "base_type"


	public static class var_declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:183:1: var_declaration : ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !;
	public final tigerParser.var_declaration_return var_declaration() throws RecognitionException {
		tigerParser.var_declaration_return retval = new tigerParser.var_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VAR_KEY58=null;
		Token COLON60=null;
		Token ASSIGN62=null;
		Token SEMI64=null;
		ParserRuleReturnScope id_list59 =null;
		ParserRuleReturnScope type_id61 =null;
		ParserRuleReturnScope expr63 =null;

		CommonTree VAR_KEY58_tree=null;
		CommonTree COLON60_tree=null;
		CommonTree ASSIGN62_tree=null;
		CommonTree SEMI64_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "var_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(183, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:2: ( ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !)
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:4: ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(184,36);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:4: ( VAR_KEY id_list COLON ^ type_id )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:5: VAR_KEY id_list COLON ^ type_id
			{
			dbg.location(184,5);
			VAR_KEY58=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration484); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VAR_KEY58_tree = (CommonTree)adaptor.create(VAR_KEY58);
			adaptor.addChild(root_0, VAR_KEY58_tree);
			}
			dbg.location(184,13);
			pushFollow(FOLLOW_id_list_in_var_declaration486);
			id_list59=id_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id_list59.getTree());
			dbg.location(184,26);
			COLON60=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration488); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON60_tree = (CommonTree)adaptor.create(COLON60);
			root_0 = (CommonTree)adaptor.becomeRoot(COLON60_tree, root_0);
			}
			dbg.location(184,28);
			pushFollow(FOLLOW_type_id_in_var_declaration491);
			type_id61=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id61.getTree());

			}
			dbg.location(184,38);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:38: ( ASSIGN ^ expr )?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==ASSIGN) ) {
				alt11=1;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:39: ASSIGN ^ expr
					{
					dbg.location(184,45);
					ASSIGN62=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration496); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN62_tree = (CommonTree)adaptor.create(ASSIGN62);
					root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN62_tree, root_0);
					}
					dbg.location(184,47);
					pushFollow(FOLLOW_expr_in_var_declaration499);
					expr63=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr63.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(11);}
			dbg.location(184,58);
			SEMI64=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration503); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(185, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "var_declaration"


	public static class id_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:1: id_list : ID ( COMMA ! id_list )? ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID65=null;
		Token COMMA66=null;
		ParserRuleReturnScope id_list67 =null;

		CommonTree ID65_tree=null;
		CommonTree COMMA66_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(187, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:9: ( ID ( COMMA ! id_list )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:11: ID ( COMMA ! id_list )?
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(187,11);
			ID65=(Token)match(input,ID,FOLLOW_ID_in_id_list514); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID65_tree = (CommonTree)adaptor.create(ID65);
			adaptor.addChild(root_0, ID65_tree);
			}
			dbg.location(187,14);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:14: ( COMMA ! id_list )?
			int alt12=2;
			try { dbg.enterSubRule(12);
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( (LA12_0==COMMA) ) {
				alt12=1;
			}
			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:15: COMMA ! id_list
					{
					dbg.location(187,20);
					COMMA66=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list517); if (state.failed) return retval;dbg.location(187,22);
					pushFollow(FOLLOW_id_list_in_id_list520);
					id_list67=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id_list67.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(12);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(188, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "id_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "id_list"


	public static class stat_seq_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:190:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat68 =null;


		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(190, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:191:2: ( ( stat )+ )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:191:4: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(191,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:191:4: ( stat )+
			int cnt13=0;
			try { dbg.enterSubRule(13);

			loop13:
			while (true) {
				int alt13=2;
				try { dbg.enterDecision(13, decisionCanBacktrack[13]);

				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= BEGIN_KEY && LA13_0 <= BREAK_KEY)||LA13_0==FOR_KEY||LA13_0==ID||LA13_0==IF_KEY||LA13_0==RETURN_KEY||LA13_0==WHILE_KEY) ) {
					alt13=1;
				}

				} finally {dbg.exitDecision(13);}

				switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:191:4: stat
					{
					dbg.location(191,4);
					pushFollow(FOLLOW_stat_in_stat_seq534);
					stat68=stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stat68.getTree());

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(13, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt13++;
			}
			} finally {dbg.exitSubRule(13);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(192, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat_seq");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat_seq"


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:194:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) | WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) | ( ID value_tail )=> ID value_tail ASSIGN ^ expr_list SEMI !| func_call SEMI !| BREAK_KEY SEMI !| RETURN_KEY ^ expr SEMI !| block );
	public final tigerParser.stat_return stat() throws RecognitionException {
		tigerParser.stat_return retval = new tigerParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF_KEY69=null;
		Token THEN_KEY71=null;
		Token ENDIF_KEY73=null;
		Token SEMI74=null;
		Token ELSE_KEY75=null;
		Token ENDIF_KEY77=null;
		Token SEMI78=null;
		Token WHILE_KEY79=null;
		Token DO_KEY81=null;
		Token ENDDO_KEY83=null;
		Token SEMI84=null;
		Token FOR_KEY85=null;
		Token ID86=null;
		Token ASSIGN87=null;
		Token TO_KEY89=null;
		Token DO_KEY91=null;
		Token ENDDO_KEY93=null;
		Token SEMI94=null;
		Token ID95=null;
		Token ASSIGN97=null;
		Token SEMI99=null;
		Token SEMI101=null;
		Token BREAK_KEY102=null;
		Token SEMI103=null;
		Token RETURN_KEY104=null;
		Token SEMI106=null;
		ParserRuleReturnScope expr70 =null;
		ParserRuleReturnScope stat_seq72 =null;
		ParserRuleReturnScope stat_seq76 =null;
		ParserRuleReturnScope expr80 =null;
		ParserRuleReturnScope stat_seq82 =null;
		ParserRuleReturnScope index_expr88 =null;
		ParserRuleReturnScope index_expr90 =null;
		ParserRuleReturnScope stat_seq92 =null;
		ParserRuleReturnScope value_tail96 =null;
		ParserRuleReturnScope expr_list98 =null;
		ParserRuleReturnScope func_call100 =null;
		ParserRuleReturnScope expr105 =null;
		ParserRuleReturnScope block107 =null;

		CommonTree IF_KEY69_tree=null;
		CommonTree THEN_KEY71_tree=null;
		CommonTree ENDIF_KEY73_tree=null;
		CommonTree SEMI74_tree=null;
		CommonTree ELSE_KEY75_tree=null;
		CommonTree ENDIF_KEY77_tree=null;
		CommonTree SEMI78_tree=null;
		CommonTree WHILE_KEY79_tree=null;
		CommonTree DO_KEY81_tree=null;
		CommonTree ENDDO_KEY83_tree=null;
		CommonTree SEMI84_tree=null;
		CommonTree FOR_KEY85_tree=null;
		CommonTree ID86_tree=null;
		CommonTree ASSIGN87_tree=null;
		CommonTree TO_KEY89_tree=null;
		CommonTree DO_KEY91_tree=null;
		CommonTree ENDDO_KEY93_tree=null;
		CommonTree SEMI94_tree=null;
		CommonTree ID95_tree=null;
		CommonTree ASSIGN97_tree=null;
		CommonTree SEMI99_tree=null;
		CommonTree SEMI101_tree=null;
		CommonTree BREAK_KEY102_tree=null;
		CommonTree SEMI103_tree=null;
		CommonTree RETURN_KEY104_tree=null;
		CommonTree SEMI106_tree=null;
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_THEN_KEY=new RewriteRuleTokenStream(adaptor,"token THEN_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_IF_KEY=new RewriteRuleTokenStream(adaptor,"token IF_KEY");
		RewriteRuleTokenStream stream_ENDIF_KEY=new RewriteRuleTokenStream(adaptor,"token ENDIF_KEY");
		RewriteRuleTokenStream stream_TO_KEY=new RewriteRuleTokenStream(adaptor,"token TO_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_FOR_KEY=new RewriteRuleTokenStream(adaptor,"token FOR_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ELSE_KEY=new RewriteRuleTokenStream(adaptor,"token ELSE_KEY");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(194, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) | WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) | ( ID value_tail )=> ID value_tail ASSIGN ^ expr_list SEMI !| func_call SEMI !| BREAK_KEY SEMI !| RETURN_KEY ^ expr SEMI !| block )
			int alt15=8;
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			switch ( input.LA(1) ) {
			case IF_KEY:
				{
				alt15=1;
				}
				break;
			case WHILE_KEY:
				{
				alt15=2;
				}
				break;
			case FOR_KEY:
				{
				alt15=3;
				}
				break;
			case ID:
				{
				int LA15_4 = input.LA(2);
				if ( (synpred2_tiger()) ) {
					alt15=4;
				}
				else if ( (true) ) {
					alt15=5;
				}

				}
				break;
			case BREAK_KEY:
				{
				alt15=6;
				}
				break;
			case RETURN_KEY:
				{
				alt15=7;
				}
				break;
			case BEGIN_KEY:
				{
				alt15=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(15);}

			switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					dbg.location(195,4);
					IF_KEY69=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_stat547); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY69);
					dbg.location(195,11);
					pushFollow(FOLLOW_expr_in_stat549);
					expr70=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr70.getTree());dbg.location(195,16);
					THEN_KEY71=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat551); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY71);
					dbg.location(195,25);
					pushFollow(FOLLOW_stat_seq_in_stat553);
					stat_seq72=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq72.getTree());dbg.location(195,34);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					int alt14=2;
					try { dbg.enterSubRule(14);
					try { dbg.enterDecision(14, decisionCanBacktrack[14]);

					int LA14_0 = input.LA(1);
					if ( (LA14_0==ENDIF_KEY) ) {
						alt14=1;
					}
					else if ( (LA14_0==ELSE_KEY) ) {
						alt14=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(14);}

					switch (alt14) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:35: ENDIF_KEY SEMI
							{
							dbg.location(195,35);
							ENDIF_KEY73=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat556); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY73);
							dbg.location(195,45);
							SEMI74=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat558); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMI.add(SEMI74);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							dbg.location(195,50);
							ELSE_KEY75=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat560); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ELSE_KEY.add(ELSE_KEY75);
							dbg.location(195,59);
							pushFollow(FOLLOW_stat_seq_in_stat562);
							stat_seq76=stat_seq();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq76.getTree());dbg.location(195,68);
							ENDIF_KEY77=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat564); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY77);
							dbg.location(195,78);
							SEMI78=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat566); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMI.add(SEMI78);

							}
							break;

					}
					} finally {dbg.exitSubRule(14);}

					// AST REWRITE
					// elements: ELSE_KEY, IF_KEY, stat_seq, expr, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 196:3: -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
					{
						dbg.location(196,6);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:6: ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(196,8);
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						dbg.location(196,15);
						adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(196,20);
						adaptor.addChild(root_1, stream_stat_seq.nextTree());dbg.location(196,29);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:29: ( ^( ELSE_KEY stat_seq ) )?
						if ( stream_ELSE_KEY.hasNext()||stream_stat_seq.hasNext() ) {
							dbg.location(196,29);
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:29: ^( ELSE_KEY stat_seq )
							{
							CommonTree root_2 = (CommonTree)adaptor.nil();
							dbg.location(196,31);
							root_2 = (CommonTree)adaptor.becomeRoot(stream_ELSE_KEY.nextNode(), root_2);
							dbg.location(196,40);
							adaptor.addChild(root_2, stream_stat_seq.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_ELSE_KEY.reset();
						stream_stat_seq.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:4: WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(197,13);
					WHILE_KEY79=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat591); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WHILE_KEY79_tree = (CommonTree)adaptor.create(WHILE_KEY79);
					root_0 = (CommonTree)adaptor.becomeRoot(WHILE_KEY79_tree, root_0);
					}
					dbg.location(197,15);
					pushFollow(FOLLOW_expr_in_stat594);
					expr80=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr80.getTree());
					dbg.location(197,26);
					DO_KEY81=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_stat596); if (state.failed) return retval;dbg.location(197,28);
					pushFollow(FOLLOW_stat_seq_in_stat599);
					stat_seq82=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stat_seq82.getTree());
					dbg.location(197,46);
					ENDDO_KEY83=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat601); if (state.failed) return retval;dbg.location(197,52);
					SEMI84=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat604); if (state.failed) return retval;
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:198:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(198,4);
					FOR_KEY85=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat610); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOR_KEY.add(FOR_KEY85);
					dbg.location(198,12);
					ID86=(Token)match(input,ID,FOLLOW_ID_in_stat612); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID86);
					dbg.location(198,15);
					ASSIGN87=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat614); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN87);
					dbg.location(198,22);
					pushFollow(FOLLOW_index_expr_in_stat616);
					index_expr88=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr88.getTree());dbg.location(198,33);
					TO_KEY89=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_stat618); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TO_KEY.add(TO_KEY89);
					dbg.location(198,40);
					pushFollow(FOLLOW_index_expr_in_stat620);
					index_expr90=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr90.getTree());dbg.location(198,51);
					DO_KEY91=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_stat622); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY91);
					dbg.location(198,58);
					pushFollow(FOLLOW_stat_seq_in_stat624);
					stat_seq92=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq92.getTree());dbg.location(198,67);
					ENDDO_KEY93=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat626); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY93);
					dbg.location(198,77);
					SEMI94=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat628); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI94);

					// AST REWRITE
					// elements: ASSIGN, stat_seq, index_expr, FOR_KEY, index_expr, ID, TO_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 199:3: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
					{
						dbg.location(199,6);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:199:6: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(199,8);
						root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
						dbg.location(199,16);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:199:16: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						dbg.location(199,18);
						root_2 = (CommonTree)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
						dbg.location(199,25);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:199:25: ^( ASSIGN ID index_expr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						dbg.location(199,27);
						root_3 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_3);
						dbg.location(199,34);
						adaptor.addChild(root_3, stream_ID.nextNode());dbg.location(199,37);
						adaptor.addChild(root_3, stream_index_expr.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(199,49);
						adaptor.addChild(root_2, stream_index_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}
						dbg.location(199,61);
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:200:6: ( ID value_tail )=> ID value_tail ASSIGN ^ expr_list SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(200,25);
					ID95=(Token)match(input,ID,FOLLOW_ID_in_stat667); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID95_tree = (CommonTree)adaptor.create(ID95);
					adaptor.addChild(root_0, ID95_tree);
					}
					dbg.location(200,28);
					pushFollow(FOLLOW_value_tail_in_stat669);
					value_tail96=value_tail();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, value_tail96.getTree());
					dbg.location(200,45);
					ASSIGN97=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat671); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN97_tree = (CommonTree)adaptor.create(ASSIGN97);
					root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN97_tree, root_0);
					}
					dbg.location(200,47);
					pushFollow(FOLLOW_expr_list_in_stat674);
					expr_list98=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_list98.getTree());
					dbg.location(200,61);
					SEMI99=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat676); if (state.failed) return retval;
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:201:6: func_call SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(201,6);
					pushFollow(FOLLOW_func_call_in_stat684);
					func_call100=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call100.getTree());
					dbg.location(201,20);
					SEMI101=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat686); if (state.failed) return retval;
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:202:4: BREAK_KEY SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(202,4);
					BREAK_KEY102=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat692); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BREAK_KEY102_tree = (CommonTree)adaptor.create(BREAK_KEY102);
					adaptor.addChild(root_0, BREAK_KEY102_tree);
					}
					dbg.location(202,18);
					SEMI103=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat694); if (state.failed) return retval;
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:203:4: RETURN_KEY ^ expr SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(203,14);
					RETURN_KEY104=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat700); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RETURN_KEY104_tree = (CommonTree)adaptor.create(RETURN_KEY104);
					root_0 = (CommonTree)adaptor.becomeRoot(RETURN_KEY104_tree, root_0);
					}
					dbg.location(203,16);
					pushFollow(FOLLOW_expr_in_stat703);
					expr105=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr105.getTree());
					dbg.location(203,25);
					SEMI106=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat705); if (state.failed) return retval;
					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:4: block
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(204,4);
					pushFollow(FOLLOW_block_in_stat711);
					block107=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block107.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(205, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat"


	public static class func_call_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:207:1: func_call : ID LPAREN func_param_list RPAREN ;
	public final tigerParser.func_call_return func_call() throws RecognitionException {
		tigerParser.func_call_return retval = new tigerParser.func_call_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID108=null;
		Token LPAREN109=null;
		Token RPAREN111=null;
		ParserRuleReturnScope func_param_list110 =null;

		CommonTree ID108_tree=null;
		CommonTree LPAREN109_tree=null;
		CommonTree RPAREN111_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "func_call");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(207, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:208:2: ( ID LPAREN func_param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:208:4: ID LPAREN func_param_list RPAREN
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(208,4);
			ID108=(Token)match(input,ID,FOLLOW_ID_in_func_call722); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID108_tree = (CommonTree)adaptor.create(ID108);
			adaptor.addChild(root_0, ID108_tree);
			}
			dbg.location(208,7);
			LPAREN109=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call724); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN109_tree = (CommonTree)adaptor.create(LPAREN109);
			adaptor.addChild(root_0, LPAREN109_tree);
			}
			dbg.location(208,14);
			pushFollow(FOLLOW_func_param_list_in_func_call726);
			func_param_list110=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, func_param_list110.getTree());
			dbg.location(208,30);
			RPAREN111=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call728); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN111_tree = (CommonTree)adaptor.create(RPAREN111);
			adaptor.addChild(root_0, RPAREN111_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(209, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_call");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "func_call"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )? ;
	public final tigerParser.expr_return expr() throws RecognitionException {
		tigerParser.expr_return retval = new tigerParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID113=null;
		Token LPAREN116=null;
		Token RPAREN118=null;
		ParserRuleReturnScope constval112 =null;
		ParserRuleReturnScope value_tail114 =null;
		ParserRuleReturnScope func_call_tail115 =null;
		ParserRuleReturnScope expr117 =null;
		ParserRuleReturnScope binop_p0119 =null;
		ParserRuleReturnScope expr120 =null;

		CommonTree ID113_tree=null;
		CommonTree LPAREN116_tree=null;
		CommonTree RPAREN118_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(211, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(211,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !)
			int alt17=3;
			try { dbg.enterSubRule(17);
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt17=1;
				}
				break;
			case ID:
				{
				alt17=2;
				}
				break;
			case LPAREN:
				{
				alt17=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:10: constval
					{
					dbg.location(211,10);
					pushFollow(FOLLOW_constval_in_expr742);
					constval112=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constval112.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:21: ID ( value_tail | func_call_tail )
					{
					dbg.location(211,21);
					ID113=(Token)match(input,ID,FOLLOW_ID_in_expr746); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID113_tree = (CommonTree)adaptor.create(ID113);
					adaptor.addChild(root_0, ID113_tree);
					}
					dbg.location(211,24);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:24: ( value_tail | func_call_tail )
					int alt16=2;
					try { dbg.enterSubRule(16);
					try { dbg.enterDecision(16, decisionCanBacktrack[16]);

					int LA16_0 = input.LA(1);
					if ( (LA16_0==EOF||LA16_0==AND||LA16_0==ASSIGN||LA16_0==COMMA||(LA16_0 >= DIV && LA16_0 <= DO_KEY)||LA16_0==EQ||(LA16_0 >= GREATER && LA16_0 <= GREATEREQ)||(LA16_0 >= LBRACK && LA16_0 <= LESSEREQ)||(LA16_0 >= MINUS && LA16_0 <= NEQ)||(LA16_0 >= OR && LA16_0 <= PLUS)||(LA16_0 >= RPAREN && LA16_0 <= SEMI)||LA16_0==THEN_KEY) ) {
						alt16=1;
					}
					else if ( (LA16_0==LPAREN) ) {
						alt16=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(16);}

					switch (alt16) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:25: value_tail
							{
							dbg.location(211,25);
							pushFollow(FOLLOW_value_tail_in_expr749);
							value_tail114=value_tail();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, value_tail114.getTree());

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:38: func_call_tail
							{
							dbg.location(211,38);
							pushFollow(FOLLOW_func_call_tail_in_expr753);
							func_call_tail115=func_call_tail();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call_tail115.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(16);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:56: LPAREN ! expr RPAREN !
					{
					dbg.location(211,62);
					LPAREN116=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr758); if (state.failed) return retval;dbg.location(211,64);
					pushFollow(FOLLOW_expr_in_expr761);
					expr117=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr117.getTree());
					dbg.location(211,75);
					RPAREN118=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr763); if (state.failed) return retval;
					}
					break;

			}
			} finally {dbg.exitSubRule(17);}
			dbg.location(211,78);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:78: ( binop_p0 ^ expr )?
			int alt18=2;
			try { dbg.enterSubRule(18);
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

			int LA18_0 = input.LA(1);
			if ( (LA18_0==AND||LA18_0==DIV||LA18_0==EQ||(LA18_0 >= GREATER && LA18_0 <= GREATEREQ)||(LA18_0 >= LESSER && LA18_0 <= LESSEREQ)||(LA18_0 >= MINUS && LA18_0 <= NEQ)||(LA18_0 >= OR && LA18_0 <= PLUS)) ) {
				alt18=1;
			}
			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:79: binop_p0 ^ expr
					{
					dbg.location(211,87);
					pushFollow(FOLLOW_binop_p0_in_expr768);
					binop_p0119=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0119.getTree(), root_0);dbg.location(211,89);
					pushFollow(FOLLOW_expr_in_expr771);
					expr120=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr120.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(18);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(212, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr"


	public static class binop_p0_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p0"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:1: binop_p0 : ( AND | OR | binop_p1 ) ;
	public final tigerParser.binop_p0_return binop_p0() throws RecognitionException {
		tigerParser.binop_p0_return retval = new tigerParser.binop_p0_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND121=null;
		Token OR122=null;
		ParserRuleReturnScope binop_p1123 =null;

		CommonTree AND121_tree=null;
		CommonTree OR122_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p0");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(214, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:9: ( ( AND | OR | binop_p1 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:11: ( AND | OR | binop_p1 )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(214,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:11: ( AND | OR | binop_p1 )
			int alt19=3;
			try { dbg.enterSubRule(19);
			try { dbg.enterDecision(19, decisionCanBacktrack[19]);

			switch ( input.LA(1) ) {
			case AND:
				{
				alt19=1;
				}
				break;
			case OR:
				{
				alt19=2;
				}
				break;
			case DIV:
			case EQ:
			case GREATER:
			case GREATEREQ:
			case LESSER:
			case LESSEREQ:
			case MINUS:
			case MULT:
			case NEQ:
			case PLUS:
				{
				alt19=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(19);}

			switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:12: AND
					{
					dbg.location(214,12);
					AND121=(Token)match(input,AND,FOLLOW_AND_in_binop_p0784); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND121_tree = (CommonTree)adaptor.create(AND121);
					adaptor.addChild(root_0, AND121_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:18: OR
					{
					dbg.location(214,18);
					OR122=(Token)match(input,OR,FOLLOW_OR_in_binop_p0788); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR122_tree = (CommonTree)adaptor.create(OR122);
					adaptor.addChild(root_0, OR122_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:23: binop_p1
					{
					dbg.location(214,23);
					pushFollow(FOLLOW_binop_p1_in_binop_p0792);
					binop_p1123=binop_p1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p1123.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(19);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(214, 31);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binop_p0");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "binop_p0"


	public static class binop_p1_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:1: binop_p1 : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) ;
	public final tigerParser.binop_p1_return binop_p1() throws RecognitionException {
		tigerParser.binop_p1_return retval = new tigerParser.binop_p1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQ124=null;
		Token NEQ125=null;
		Token LESSER126=null;
		Token GREATER127=null;
		Token LESSEREQ128=null;
		Token GREATEREQ129=null;
		ParserRuleReturnScope binop_p2130 =null;

		CommonTree EQ124_tree=null;
		CommonTree NEQ125_tree=null;
		CommonTree LESSER126_tree=null;
		CommonTree GREATER127_tree=null;
		CommonTree LESSEREQ128_tree=null;
		CommonTree GREATEREQ129_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p1");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(215, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:9: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(215,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			int alt20=7;
			try { dbg.enterSubRule(20);
			try { dbg.enterDecision(20, decisionCanBacktrack[20]);

			switch ( input.LA(1) ) {
			case EQ:
				{
				alt20=1;
				}
				break;
			case NEQ:
				{
				alt20=2;
				}
				break;
			case LESSER:
				{
				alt20=3;
				}
				break;
			case GREATER:
				{
				alt20=4;
				}
				break;
			case LESSEREQ:
				{
				alt20=5;
				}
				break;
			case GREATEREQ:
				{
				alt20=6;
				}
				break;
			case DIV:
			case MINUS:
			case MULT:
			case PLUS:
				{
				alt20=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(20);}

			switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:12: EQ
					{
					dbg.location(215,12);
					EQ124=(Token)match(input,EQ,FOLLOW_EQ_in_binop_p1800); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQ124_tree = (CommonTree)adaptor.create(EQ124);
					adaptor.addChild(root_0, EQ124_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:17: NEQ
					{
					dbg.location(215,17);
					NEQ125=(Token)match(input,NEQ,FOLLOW_NEQ_in_binop_p1804); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEQ125_tree = (CommonTree)adaptor.create(NEQ125);
					adaptor.addChild(root_0, NEQ125_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:23: LESSER
					{
					dbg.location(215,23);
					LESSER126=(Token)match(input,LESSER,FOLLOW_LESSER_in_binop_p1808); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSER126_tree = (CommonTree)adaptor.create(LESSER126);
					adaptor.addChild(root_0, LESSER126_tree);
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:32: GREATER
					{
					dbg.location(215,32);
					GREATER127=(Token)match(input,GREATER,FOLLOW_GREATER_in_binop_p1812); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATER127_tree = (CommonTree)adaptor.create(GREATER127);
					adaptor.addChild(root_0, GREATER127_tree);
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:42: LESSEREQ
					{
					dbg.location(215,42);
					LESSEREQ128=(Token)match(input,LESSEREQ,FOLLOW_LESSEREQ_in_binop_p1816); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSEREQ128_tree = (CommonTree)adaptor.create(LESSEREQ128);
					adaptor.addChild(root_0, LESSEREQ128_tree);
					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:53: GREATEREQ
					{
					dbg.location(215,53);
					GREATEREQ129=(Token)match(input,GREATEREQ,FOLLOW_GREATEREQ_in_binop_p1820); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATEREQ129_tree = (CommonTree)adaptor.create(GREATEREQ129);
					adaptor.addChild(root_0, GREATEREQ129_tree);
					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:65: binop_p2
					{
					dbg.location(215,65);
					pushFollow(FOLLOW_binop_p2_in_binop_p1824);
					binop_p2130=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p2130.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(20);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(215, 73);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binop_p1");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "binop_p1"


	public static class binop_p2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:1: binop_p2 : ( MINUS | PLUS | binop_p3 ) ;
	public final tigerParser.binop_p2_return binop_p2() throws RecognitionException {
		tigerParser.binop_p2_return retval = new tigerParser.binop_p2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS131=null;
		Token PLUS132=null;
		ParserRuleReturnScope binop_p3133 =null;

		CommonTree MINUS131_tree=null;
		CommonTree PLUS132_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p2");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(216, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:9: ( ( MINUS | PLUS | binop_p3 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:11: ( MINUS | PLUS | binop_p3 )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(216,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:11: ( MINUS | PLUS | binop_p3 )
			int alt21=3;
			try { dbg.enterSubRule(21);
			try { dbg.enterDecision(21, decisionCanBacktrack[21]);

			switch ( input.LA(1) ) {
			case MINUS:
				{
				alt21=1;
				}
				break;
			case PLUS:
				{
				alt21=2;
				}
				break;
			case DIV:
			case MULT:
				{
				alt21=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(21);}

			switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:12: MINUS
					{
					dbg.location(216,12);
					MINUS131=(Token)match(input,MINUS,FOLLOW_MINUS_in_binop_p2837); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS131_tree = (CommonTree)adaptor.create(MINUS131);
					adaptor.addChild(root_0, MINUS131_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:20: PLUS
					{
					dbg.location(216,20);
					PLUS132=(Token)match(input,PLUS,FOLLOW_PLUS_in_binop_p2841); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS132_tree = (CommonTree)adaptor.create(PLUS132);
					adaptor.addChild(root_0, PLUS132_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:27: binop_p3
					{
					dbg.location(216,27);
					pushFollow(FOLLOW_binop_p3_in_binop_p2845);
					binop_p3133=binop_p3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p3133.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(21);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(216, 35);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binop_p2");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "binop_p2"


	public static class binop_p3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p3"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:217:1: binop_p3 : ( MULT | DIV ) ;
	public final tigerParser.binop_p3_return binop_p3() throws RecognitionException {
		tigerParser.binop_p3_return retval = new tigerParser.binop_p3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set134=null;

		CommonTree set134_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p3");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(217, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:217:9: ( ( MULT | DIV ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(217,9);
			set134=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set134));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(217, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binop_p3");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "binop_p3"


	public static class constval_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:219:1: constval : ( INTLIT | FIXEDPTLIT );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set135=null;

		CommonTree set135_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "constval");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(219, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:219:9: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(219,9);
			set135=input.LT(1);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set135));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(221, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constval");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "constval"


	public static class binary_operator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binary_operator"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:230:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set136=null;

		CommonTree set136_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binary_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(230, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:231:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(231,2);
			set136=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set136));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(232, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binary_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "binary_operator"


	public static class expr_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:234:1: expr_list : expr ( COMMA ! expr )* ;
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA138=null;
		ParserRuleReturnScope expr137 =null;
		ParserRuleReturnScope expr139 =null;

		CommonTree COMMA138_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(234, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:235:2: ( expr ( COMMA ! expr )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:235:4: expr ( COMMA ! expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(235,4);
			pushFollow(FOLLOW_expr_in_expr_list968);
			expr137=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr137.getTree());
			dbg.location(235,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:235:9: ( COMMA ! expr )*
			try { dbg.enterSubRule(22);

			loop22:
			while (true) {
				int alt22=2;
				try { dbg.enterDecision(22, decisionCanBacktrack[22]);

				int LA22_0 = input.LA(1);
				if ( (LA22_0==COMMA) ) {
					alt22=1;
				}

				} finally {dbg.exitDecision(22);}

				switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:235:10: COMMA ! expr
					{
					dbg.location(235,15);
					COMMA138=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list971); if (state.failed) return retval;dbg.location(235,17);
					pushFollow(FOLLOW_expr_in_expr_list974);
					expr139=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr139.getTree());

					}
					break;

				default :
					break loop22;
				}
			}
			} finally {dbg.exitSubRule(22);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(236, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expr_list"


	public static class value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:238:1: value : ID value_tail ;
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID140=null;
		ParserRuleReturnScope value_tail141 =null;

		CommonTree ID140_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(238, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:238:8: ( ID value_tail )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:238:10: ID value_tail
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(238,10);
			ID140=(Token)match(input,ID,FOLLOW_ID_in_value987); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID140_tree = (CommonTree)adaptor.create(ID140);
			adaptor.addChild(root_0, ID140_tree);
			}
			dbg.location(238,13);
			pushFollow(FOLLOW_value_tail_in_value989);
			value_tail141=value_tail();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, value_tail141.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(238, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "value"


	public static class value_tail_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:239:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? ;
	public final tigerParser.value_tail_return value_tail() throws RecognitionException {
		tigerParser.value_tail_return retval = new tigerParser.value_tail_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LBRACK142=null;
		Token RBRACK144=null;
		Token LBRACK145=null;
		Token RBRACK147=null;
		ParserRuleReturnScope index_expr143 =null;
		ParserRuleReturnScope index_expr146 =null;

		CommonTree LBRACK142_tree=null;
		CommonTree RBRACK144_tree=null;
		CommonTree LBRACK145_tree=null;
		CommonTree RBRACK147_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "value_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(239, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:2: ( ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:4: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(240,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:4: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			int alt24=2;
			try { dbg.enterSubRule(24);
			try { dbg.enterDecision(24, decisionCanBacktrack[24]);

			int LA24_0 = input.LA(1);
			if ( (LA24_0==LBRACK) ) {
				alt24=1;
			}
			} finally {dbg.exitDecision(24);}

			switch (alt24) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:5: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					dbg.location(240,5);
					LBRACK142=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail999); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK142_tree = (CommonTree)adaptor.create(LBRACK142);
					adaptor.addChild(root_0, LBRACK142_tree);
					}
					dbg.location(240,12);
					pushFollow(FOLLOW_index_expr_in_value_tail1001);
					index_expr143=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr143.getTree());
					dbg.location(240,23);
					RBRACK144=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail1003); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK144_tree = (CommonTree)adaptor.create(RBRACK144);
					adaptor.addChild(root_0, RBRACK144_tree);
					}
					dbg.location(240,30);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:30: ( LBRACK index_expr RBRACK )?
					int alt23=2;
					try { dbg.enterSubRule(23);
					try { dbg.enterDecision(23, decisionCanBacktrack[23]);

					int LA23_0 = input.LA(1);
					if ( (LA23_0==LBRACK) ) {
						alt23=1;
					}
					} finally {dbg.exitDecision(23);}

					switch (alt23) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:31: LBRACK index_expr RBRACK
							{
							dbg.location(240,31);
							LBRACK145=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail1006); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LBRACK145_tree = (CommonTree)adaptor.create(LBRACK145);
							adaptor.addChild(root_0, LBRACK145_tree);
							}
							dbg.location(240,38);
							pushFollow(FOLLOW_index_expr_in_value_tail1008);
							index_expr146=index_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr146.getTree());
							dbg.location(240,49);
							RBRACK147=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail1010); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							RBRACK147_tree = (CommonTree)adaptor.create(RBRACK147);
							adaptor.addChild(root_0, RBRACK147_tree);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(23);}

					}
					break;

			}
			} finally {dbg.exitSubRule(24);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(241, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "value_tail"


	public static class index_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:243:1: index_expr : ( INTLIT | ID ) ( index_oper ^ index_expr )? ;
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set148=null;
		ParserRuleReturnScope index_oper149 =null;
		ParserRuleReturnScope index_expr150 =null;

		CommonTree set148_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(243, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:244:2: ( ( INTLIT | ID ) ( index_oper ^ index_expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:244:4: ( INTLIT | ID ) ( index_oper ^ index_expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(244,4);
			set148=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set148));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(244,18);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:244:18: ( index_oper ^ index_expr )?
			int alt25=2;
			try { dbg.enterSubRule(25);
			try { dbg.enterDecision(25, decisionCanBacktrack[25]);

			int LA25_0 = input.LA(1);
			if ( ((LA25_0 >= MINUS && LA25_0 <= MULT)||LA25_0==PLUS) ) {
				alt25=1;
			}
			} finally {dbg.exitDecision(25);}

			switch (alt25) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:244:19: index_oper ^ index_expr
					{
					dbg.location(244,29);
					pushFollow(FOLLOW_index_oper_in_index_expr1035);
					index_oper149=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(index_oper149.getTree(), root_0);dbg.location(244,31);
					pushFollow(FOLLOW_index_expr_in_index_expr1038);
					index_expr150=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr150.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(25);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(245, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "index_expr"


	public static class index_oper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_oper"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:247:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set151=null;

		CommonTree set151_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_oper");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(247, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:248:2: ( ( PLUS | MINUS | MULT ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(248,2);
			set151=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set151));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(249, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_oper");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "index_oper"


	public static class func_call_tail_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:267:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final tigerParser.func_call_tail_return func_call_tail() throws RecognitionException {
		tigerParser.func_call_tail_return retval = new tigerParser.func_call_tail_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN152=null;
		Token RPAREN154=null;
		ParserRuleReturnScope func_param_list153 =null;

		CommonTree LPAREN152_tree=null;
		CommonTree RPAREN154_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "func_call_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(267, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:268:2: ( LPAREN func_param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:268:4: LPAREN func_param_list RPAREN
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(268,4);
			LPAREN152=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail1154); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN152_tree = (CommonTree)adaptor.create(LPAREN152);
			adaptor.addChild(root_0, LPAREN152_tree);
			}
			dbg.location(268,11);
			pushFollow(FOLLOW_func_param_list_in_func_call_tail1156);
			func_param_list153=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, func_param_list153.getTree());
			dbg.location(268,27);
			RPAREN154=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail1158); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN154_tree = (CommonTree)adaptor.create(RPAREN154);
			adaptor.addChild(root_0, RPAREN154_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(269, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_call_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "func_call_tail"


	public static class func_param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:271:1: func_param_list : ( expr ( COMMA ! expr )* )? ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA156=null;
		ParserRuleReturnScope expr155 =null;
		ParserRuleReturnScope expr157 =null;

		CommonTree COMMA156_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "func_param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(271, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:2: ( ( expr ( COMMA ! expr )* )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:4: ( expr ( COMMA ! expr )* )?
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(272,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:4: ( expr ( COMMA ! expr )* )?
			int alt27=2;
			try { dbg.enterSubRule(27);
			try { dbg.enterDecision(27, decisionCanBacktrack[27]);

			int LA27_0 = input.LA(1);
			if ( (LA27_0==FIXEDPTLIT||LA27_0==ID||LA27_0==INTLIT||LA27_0==LPAREN) ) {
				alt27=1;
			}
			} finally {dbg.exitDecision(27);}

			switch (alt27) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:5: expr ( COMMA ! expr )*
					{
					dbg.location(272,5);
					pushFollow(FOLLOW_expr_in_func_param_list1172);
					expr155=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr155.getTree());
					dbg.location(272,10);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:10: ( COMMA ! expr )*
					try { dbg.enterSubRule(26);

					loop26:
					while (true) {
						int alt26=2;
						try { dbg.enterDecision(26, decisionCanBacktrack[26]);

						int LA26_0 = input.LA(1);
						if ( (LA26_0==COMMA) ) {
							alt26=1;
						}

						} finally {dbg.exitDecision(26);}

						switch (alt26) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:11: COMMA ! expr
							{
							dbg.location(272,16);
							COMMA156=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list1175); if (state.failed) return retval;dbg.location(272,18);
							pushFollow(FOLLOW_expr_in_func_param_list1178);
							expr157=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expr157.getTree());

							}
							break;

						default :
							break loop26;
						}
					}
					} finally {dbg.exitSubRule(26);}

					}
					break;

			}
			} finally {dbg.exitSubRule(27);}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(273, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "func_param_list"


	public static class keywords_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "keywords"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:275:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set158=null;

		CommonTree set158_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "keywords");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(275, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(276,2);
			set158=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= IF_KEY)||input.LA(1)==INT_KEY||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set158));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(299, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "keywords");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "keywords"

	// $ANTLR start synpred2_tiger
	public final void synpred2_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:200:6: ( ID value_tail )
		dbg.enterAlt(1);

		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:200:7: ID value_tail
		{
		dbg.location(200,7);
		match(input,ID,FOLLOW_ID_in_synpred2_tiger660); if (state.failed) return;
		dbg.location(200,10);
		pushFollow(FOLLOW_value_tail_in_synpred2_tiger662);
		value_tail();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_tiger

	// Delegated rules

	public final boolean synpred2_tiger() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred2_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		dbg.endBacktrack(state.backtracking, success);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program96 = new BitSet(new long[]{0x0100000442000000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list111 = new BitSet(new long[]{0x0100000442000002L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration123 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration125 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration127 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration129 = new BitSet(new long[]{0x0002000040000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration131 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration133 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration135 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration137 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration139 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_main_function180 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function182 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function184 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function186 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_main_function188 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_block_list_in_main_function190 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_END_KEY_in_main_function192 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list224 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_param_list227 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_param_in_param_list229 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_ID_in_param251 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COLON_in_param253 = new BitSet(new long[]{0x0000000442000000L});
	public static final BitSet FOLLOW_type_id_in_param255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list278 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block290 = new BitSet(new long[]{0x00C0000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block293 = new BitSet(new long[]{0x0201000144001800L});
	public static final BitSet FOLLOW_stat_seq_in_block295 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_END_KEY_in_block298 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement325 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list341 = new BitSet(new long[]{0x0040000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list355 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration369 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration371 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration374 = new BitSet(new long[]{0x0000000402000020L});
	public static final BitSet FOLLOW_type_in_type_declaration376 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type406 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_LBRACK_in_type408 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_INTLIT_in_type410 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type412 = new BitSet(new long[]{0x0000100800000000L});
	public static final BitSet FOLLOW_LBRACK_in_type415 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_INTLIT_in_type417 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type419 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type424 = new BitSet(new long[]{0x0000000402000000L});
	public static final BitSet FOLLOW_base_type_in_type427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration484 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration486 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration488 = new BitSet(new long[]{0x0000000442000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration491 = new BitSet(new long[]{0x0004000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration496 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_var_declaration499 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration503 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list514 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_id_list517 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_id_list_in_id_list520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq534 = new BitSet(new long[]{0x0201000144001802L});
	public static final BitSet FOLLOW_IF_KEY_in_stat547 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_stat549 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat551 = new BitSet(new long[]{0x0201000144001800L});
	public static final BitSet FOLLOW_stat_seq_in_stat553 = new BitSet(new long[]{0x0000000000280000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat556 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat560 = new BitSet(new long[]{0x0201000144001800L});
	public static final BitSet FOLLOW_stat_seq_in_stat562 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat564 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat591 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_stat594 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat596 = new BitSet(new long[]{0x0201000144001800L});
	public static final BitSet FOLLOW_stat_seq_in_stat599 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat601 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat610 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_ID_in_stat612 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat614 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_index_expr_in_stat616 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat618 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_index_expr_in_stat620 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat622 = new BitSet(new long[]{0x0201000144001800L});
	public static final BitSet FOLLOW_stat_seq_in_stat624 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat626 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat667 = new BitSet(new long[]{0x0000000800000040L});
	public static final BitSet FOLLOW_value_tail_in_stat669 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat671 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_list_in_stat674 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_stat684 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat692 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat700 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_stat703 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat705 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call722 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call724 = new BitSet(new long[]{0x0002004241000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call726 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr742 = new BitSet(new long[]{0x0000673030820012L});
	public static final BitSet FOLLOW_ID_in_expr746 = new BitSet(new long[]{0x0000677830820010L});
	public static final BitSet FOLLOW_value_tail_in_expr749 = new BitSet(new long[]{0x0000673030820012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr753 = new BitSet(new long[]{0x0000673030820012L});
	public static final BitSet FOLLOW_LPAREN_in_expr758 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_expr761 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr763 = new BitSet(new long[]{0x0000673030820012L});
	public static final BitSet FOLLOW_binop_p0_in_expr768 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_expr771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p0784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p0788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p0792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_binop_p1800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEQ_in_binop_p1804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSER_in_binop_p1808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_binop_p1812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEREQ_in_binop_p1816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQ_in_binop_p1820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p2_in_binop_p1824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p2837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p2841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p2845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list968 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list971 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_expr_list974 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_ID_in_value987 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_value_tail_in_value989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail999 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail1001 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail1003 = new BitSet(new long[]{0x0000000800000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail1006 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail1008 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail1010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr1026 = new BitSet(new long[]{0x0000430000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1035 = new BitSet(new long[]{0x0000000240000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1038 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail1154 = new BitSet(new long[]{0x0002004241000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail1156 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail1158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list1172 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list1175 = new BitSet(new long[]{0x0000004241000000L});
	public static final BitSet FOLLOW_expr_in_func_param_list1178 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_ID_in_synpred2_tiger660 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_value_tail_in_synpred2_tiger662 = new BitSet(new long[]{0x0000000000000002L});
}
