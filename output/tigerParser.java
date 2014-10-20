// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-20 13:05:18

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
		"AST_ARRAY_DECL", "AST_ARRAY_INDEX", "AST_BLOCK", "AST_FUNC_CALL", "AST_FUNC_DECL", 
		"AST_PARAM", "AST_RETURN_STAT", "BEGIN_KEY", "BREAK_KEY", "CARRAGE_RET", 
		"COLON", "COMMA", "COMMENT", "DIV", "DO_KEY", "ELSE_KEY", "ENDDO_KEY", 
		"ENDIF_KEY", "END_KEY", "EQ", "FIXEDPTLIT", "FIXEDPT_KEY", "FOR_KEY", 
		"FUNCTION_KEY", "GREATER", "GREATEREQ", "ID", "ID_KEY", "IF_KEY", "INTLIT", 
		"INT_KEY", "LBRACK", "LESSER", "LESSEREQ", "LPAREN", "MAIN_KEY", "MINUS", 
		"MULT", "NEQ", "NEWLINE", "OF_KEY", "OR", "PLUS", "RBRACK", "RETURN_KEY", 
		"RPAREN", "SEMI", "TAB", "THEN_KEY", "TO_KEY", "TYPE_KEY", "VAR_KEY", 
		"VOID_KEY", "WHILE_KEY", "WHITESPACE"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY_KEY=5;
	public static final int ASSIGN=6;
	public static final int AST_ARRAY_DECL=7;
	public static final int AST_ARRAY_INDEX=8;
	public static final int AST_BLOCK=9;
	public static final int AST_FUNC_CALL=10;
	public static final int AST_FUNC_DECL=11;
	public static final int AST_PARAM=12;
	public static final int AST_RETURN_STAT=13;
	public static final int BEGIN_KEY=14;
	public static final int BREAK_KEY=15;
	public static final int CARRAGE_RET=16;
	public static final int COLON=17;
	public static final int COMMA=18;
	public static final int COMMENT=19;
	public static final int DIV=20;
	public static final int DO_KEY=21;
	public static final int ELSE_KEY=22;
	public static final int ENDDO_KEY=23;
	public static final int ENDIF_KEY=24;
	public static final int END_KEY=25;
	public static final int EQ=26;
	public static final int FIXEDPTLIT=27;
	public static final int FIXEDPT_KEY=28;
	public static final int FOR_KEY=29;
	public static final int FUNCTION_KEY=30;
	public static final int GREATER=31;
	public static final int GREATEREQ=32;
	public static final int ID=33;
	public static final int ID_KEY=34;
	public static final int IF_KEY=35;
	public static final int INTLIT=36;
	public static final int INT_KEY=37;
	public static final int LBRACK=38;
	public static final int LESSER=39;
	public static final int LESSEREQ=40;
	public static final int LPAREN=41;
	public static final int MAIN_KEY=42;
	public static final int MINUS=43;
	public static final int MULT=44;
	public static final int NEQ=45;
	public static final int NEWLINE=46;
	public static final int OF_KEY=47;
	public static final int OR=48;
	public static final int PLUS=49;
	public static final int RBRACK=50;
	public static final int RETURN_KEY=51;
	public static final int RPAREN=52;
	public static final int SEMI=53;
	public static final int TAB=54;
	public static final int THEN_KEY=55;
	public static final int TO_KEY=56;
	public static final int TYPE_KEY=57;
	public static final int VAR_KEY=58;
	public static final int VOID_KEY=59;
	public static final int WHILE_KEY=60;
	public static final int WHITESPACE=61;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "declaration_statement", "block_list", "ret_type", "tiger_program", 
		"var_declaration", "index_oper", "func_param_list", "type_declaration", 
		"for_stat", "funct_declaration", "constval", "expr", "return_stat", "synpred4_tiger", 
		"func_call", "index_expr", "binop_p0", "main_function", "stat", "type_declaration_list", 
		"if_stat", "synpred2_tiger", "type_id", "param", "assign_stat", "param_list", 
		"synpred3_tiger", "binop_p2", "keywords", "id_list", "type", "binop_p3", 
		"expr_list", "value", "funct_declaration_list", "while_stat", "synpred1_tiger", 
		"binary_operator", "block", "break_stat", "stat_seq", "binop_p1", "base_type", 
		"var_declaration_list"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, true, false, false, false, false, false, true, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:115:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(115, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:116:2: ( type_declaration_list funct_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:116:4: type_declaration_list funct_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(116,4);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program108);
			type_declaration_list1=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list1.getTree());
			dbg.location(116,26);
			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program110);
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
		dbg.location(117, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:119:1: funct_declaration_list : ( funct_declaration )* ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(119, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:2: ( ( funct_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:4: ( funct_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(120,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:4: ( funct_declaration )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:4: funct_declaration
					{
					dbg.location(120,4);
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list123);
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
		dbg.location(121, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:123:1: funct_declaration : ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI -> ^( AST_FUNC_DECL[ID] param_list block_list ) ;
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
		dbg.location(123, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:2: ( ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI -> ^( AST_FUNC_DECL[ID] param_list block_list ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:4: ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(124,4);
			pushFollow(FOLLOW_ret_type_in_funct_declaration135);
			ret_type4=ret_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_ret_type.add(ret_type4.getTree());dbg.location(124,13);
			FUNCTION_KEY5=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration137); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FUNCTION_KEY.add(FUNCTION_KEY5);
			dbg.location(124,26);
			ID6=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration139); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID6);
			dbg.location(124,29);
			LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration141); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN7);
			dbg.location(124,36);
			pushFollow(FOLLOW_param_list_in_funct_declaration143);
			param_list8=param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_param_list.add(param_list8.getTree());dbg.location(124,47);
			RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration145); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN9);
			dbg.location(124,54);
			BEGIN_KEY10=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration147); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BEGIN_KEY.add(BEGIN_KEY10);
			dbg.location(124,64);
			pushFollow(FOLLOW_block_list_in_funct_declaration149);
			block_list11=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_list.add(block_list11.getTree());dbg.location(124,75);
			END_KEY12=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration151); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_END_KEY.add(END_KEY12);
			dbg.location(124,83);
			SEMI13=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration153); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI13);

			// AST REWRITE
			// elements: block_list, param_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 125:2: -> ^( AST_FUNC_DECL[ID] param_list block_list )
			{
				dbg.location(125,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:125:5: ^( AST_FUNC_DECL[ID] param_list block_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(125,7);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_FUNC_DECL, ID), root_1);
				dbg.location(125,25);
				adaptor.addChild(root_1, stream_param_list.nextTree());dbg.location(125,36);
				adaptor.addChild(root_1, stream_block_list.nextTree());
				adaptor.addChild(root_0, root_1);
				}
				dbg.location(126,3);
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
		dbg.location(127, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:1: main_function : ( VOID_KEY MAIN_KEY LPAREN RPAREN )=> VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI ;
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
		dbg.location(129, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:2: ( ( VOID_KEY MAIN_KEY LPAREN RPAREN )=> VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:4: ( VOID_KEY MAIN_KEY LPAREN RPAREN )=> VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(130,41);
			VOID_KEY14=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_main_function192); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VOID_KEY14_tree = (CommonTree)adaptor.create(VOID_KEY14);
			adaptor.addChild(root_0, VOID_KEY14_tree);
			}
			dbg.location(130,50);
			MAIN_KEY15=(Token)match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function194); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAIN_KEY15_tree = (CommonTree)adaptor.create(MAIN_KEY15);
			adaptor.addChild(root_0, MAIN_KEY15_tree);
			}
			dbg.location(130,59);
			LPAREN16=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function196); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN16_tree = (CommonTree)adaptor.create(LPAREN16);
			adaptor.addChild(root_0, LPAREN16_tree);
			}
			dbg.location(130,66);
			RPAREN17=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function198); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN17_tree = (CommonTree)adaptor.create(RPAREN17);
			adaptor.addChild(root_0, RPAREN17_tree);
			}
			dbg.location(130,73);
			BEGIN_KEY18=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_main_function200); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BEGIN_KEY18_tree = (CommonTree)adaptor.create(BEGIN_KEY18);
			adaptor.addChild(root_0, BEGIN_KEY18_tree);
			}
			dbg.location(130,83);
			pushFollow(FOLLOW_block_list_in_main_function202);
			block_list19=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, block_list19.getTree());
			dbg.location(130,94);
			END_KEY20=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_main_function204); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			END_KEY20_tree = (CommonTree)adaptor.create(END_KEY20);
			adaptor.addChild(root_0, END_KEY20_tree);
			}
			dbg.location(130,102);
			SEMI21=(Token)match(input,SEMI,FOLLOW_SEMI_in_main_function206); if (state.failed) return retval;
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
		dbg.location(131, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:1: ret_type : ( VOID_KEY | type_id );
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
		dbg.location(133, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:2: ( VOID_KEY | type_id )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:4: VOID_KEY
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(134,4);
					VOID_KEY22=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type218); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VOID_KEY22_tree = (CommonTree)adaptor.create(VOID_KEY22);
					adaptor.addChild(root_0, VOID_KEY22_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:4: type_id
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(135,4);
					pushFollow(FOLLOW_type_id_in_ret_type223);
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
		dbg.location(136, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:1: param_list : ( param ( COMMA param )* )? -> ( AST_PARAM[param] )* ;
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
		dbg.location(138, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:2: ( ( param ( COMMA param )* )? -> ( AST_PARAM[param] )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:4: ( param ( COMMA param )* )?
			{
			dbg.location(139,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:4: ( param ( COMMA param )* )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:5: param ( COMMA param )*
					{
					dbg.location(139,5);
					pushFollow(FOLLOW_param_in_param_list236);
					param24=param();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param.add(param24.getTree());dbg.location(139,11);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:11: ( COMMA param )*
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:12: COMMA param
							{
							dbg.location(139,12);
							COMMA25=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list239); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA25);
							dbg.location(139,18);
							pushFollow(FOLLOW_param_in_param_list241);
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
			// 140:2: -> ( AST_PARAM[param] )*
			{
				dbg.location(140,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:5: ( AST_PARAM[param] )*
				while (  ) {
					dbg.location(140,5);
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
		dbg.location(141, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:1: param : ID COLON type_id -> ^( COLON ID type_id ) ;
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
		dbg.location(143, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:8: ( ID COLON type_id -> ^( COLON ID type_id ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:10: ID COLON type_id
			{
			dbg.location(143,10);
			ID27=(Token)match(input,ID,FOLLOW_ID_in_param263); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID27);
			dbg.location(143,13);
			COLON28=(Token)match(input,COLON,FOLLOW_COLON_in_param265); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON28);
			dbg.location(143,19);
			pushFollow(FOLLOW_type_id_in_param267);
			type_id29=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_id.add(type_id29.getTree());
			// AST REWRITE
			// elements: ID, type_id, COLON
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 144:2: -> ^( COLON ID type_id )
			{
				dbg.location(144,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:5: ^( COLON ID type_id )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(144,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_COLON.nextNode(), root_1);
				dbg.location(144,13);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(144,16);
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
		dbg.location(145, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block30 =null;


		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(147, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:2: ( ( block )+ )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:4: ( block )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(148,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:4: ( block )+
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:4: block
					{
					dbg.location(148,4);
					pushFollow(FOLLOW_block_in_block_list290);
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
		dbg.location(149, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:1: block : BEGIN_KEY ( declaration_statement stat_seq ) END_KEY SEMI -> ^( AST_BLOCK declaration_statement stat_seq ) ;
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
		dbg.location(151, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:8: ( BEGIN_KEY ( declaration_statement stat_seq ) END_KEY SEMI -> ^( AST_BLOCK declaration_statement stat_seq ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:10: BEGIN_KEY ( declaration_statement stat_seq ) END_KEY SEMI
			{
			dbg.location(151,10);
			BEGIN_KEY31=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block302); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BEGIN_KEY.add(BEGIN_KEY31);
			dbg.location(151,20);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:20: ( declaration_statement stat_seq )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:21: declaration_statement stat_seq
			{
			dbg.location(151,21);
			pushFollow(FOLLOW_declaration_statement_in_block305);
			declaration_statement32=declaration_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declaration_statement.add(declaration_statement32.getTree());dbg.location(151,43);
			pushFollow(FOLLOW_stat_seq_in_block307);
			stat_seq33=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq33.getTree());
			}
			dbg.location(151,53);
			END_KEY34=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_block310); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_END_KEY.add(END_KEY34);
			dbg.location(151,61);
			SEMI35=(Token)match(input,SEMI,FOLLOW_SEMI_in_block312); if (state.failed) return retval; 
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
			// 152:2: -> ^( AST_BLOCK declaration_statement stat_seq )
			{
				dbg.location(152,6);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:6: ^( AST_BLOCK declaration_statement stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(152,8);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_BLOCK, "AST_BLOCK"), root_1);
				dbg.location(152,18);
				adaptor.addChild(root_1, stream_declaration_statement.nextTree());dbg.location(152,40);
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
		dbg.location(153, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list36 =null;
		ParserRuleReturnScope var_declaration_list37 =null;


		try { dbg.enterRule(getGrammarFileName(), "declaration_statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(155, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:2: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:4: type_declaration_list var_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(156,4);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement337);
			type_declaration_list36=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list36.getTree());
			dbg.location(156,26);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement339);
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
		dbg.location(157, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:159:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration38 =null;


		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(159, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:2: ( ( type_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:5: ( type_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(160,5);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:5: ( type_declaration )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:5: type_declaration
					{
					dbg.location(160,5);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list353);
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
		dbg.location(161, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_declaration39 =null;


		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(163, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:2: ( ( var_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:4: ( var_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(164,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:4: ( var_declaration )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:4: var_declaration
					{
					dbg.location(164,4);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list367);
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
		dbg.location(165, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:167:1: type_declaration : ( TYPE_KEY ID ) EQ type SEMI -> ^( EQ ID type ) ;
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
		dbg.location(167, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:2: ( ( TYPE_KEY ID ) EQ type SEMI -> ^( EQ ID type ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:4: ( TYPE_KEY ID ) EQ type SEMI
			{
			dbg.location(168,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:4: ( TYPE_KEY ID )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:5: TYPE_KEY ID
			{
			dbg.location(168,5);
			TYPE_KEY40=(Token)match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration381); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TYPE_KEY.add(TYPE_KEY40);
			dbg.location(168,14);
			ID41=(Token)match(input,ID,FOLLOW_ID_in_type_declaration383); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID41);

			}
			dbg.location(168,18);
			EQ42=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration386); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EQ.add(EQ42);
			dbg.location(168,21);
			pushFollow(FOLLOW_type_in_type_declaration388);
			type43=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(type43.getTree());dbg.location(168,26);
			SEMI44=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration390); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI44);

			// AST REWRITE
			// elements: EQ, type, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 169:2: -> ^( EQ ID type )
			{
				dbg.location(169,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:169:5: ^( EQ ID type )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(169,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_EQ.nextNode(), root_1);
				dbg.location(169,10);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(169,13);
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
		dbg.location(170, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:1: type : ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) OF_KEY ( base_type ) -> ^( ARRAY_KEY AST_ARRAY_INDEX base_type ) );
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
		dbg.location(172, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:6: ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) OF_KEY ( base_type ) -> ^( ARRAY_KEY AST_ARRAY_INDEX base_type ) )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:8: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(172,8);
					pushFollow(FOLLOW_base_type_in_type412);
					base_type45=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type45.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) OF_KEY ( base_type )
					{
					dbg.location(173,4);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:5: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )?
					{
					dbg.location(173,5);
					ARRAY_KEY46=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type418); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARRAY_KEY.add(ARRAY_KEY46);
					dbg.location(173,15);
					LBRACK47=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type420); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK47);
					dbg.location(173,22);
					INTLIT48=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type422); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_INTLIT.add(INTLIT48);
					dbg.location(173,29);
					RBRACK49=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type424); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK49);
					dbg.location(173,36);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:36: ( LBRACK INTLIT RBRACK )?
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:37: LBRACK INTLIT RBRACK
							{
							dbg.location(173,37);
							LBRACK50=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type427); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK50);
							dbg.location(173,44);
							INTLIT51=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type429); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_INTLIT.add(INTLIT51);
							dbg.location(173,51);
							RBRACK52=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type431); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK52);

							}
							break;

					}
					} finally {dbg.exitSubRule(8);}

					}
					dbg.location(173,61);
					OF_KEY53=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type436); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OF_KEY.add(OF_KEY53);
					dbg.location(173,68);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:68: ( base_type )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:69: base_type
					{
					dbg.location(173,69);
					pushFollow(FOLLOW_base_type_in_type439);
					base_type54=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_base_type.add(base_type54.getTree());
					}

					// AST REWRITE
					// elements: ARRAY_KEY, base_type
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 174:2: -> ^( ARRAY_KEY AST_ARRAY_INDEX base_type )
					{
						dbg.location(174,5);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:174:5: ^( ARRAY_KEY AST_ARRAY_INDEX base_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(174,7);
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ARRAY_KEY.nextNode(), root_1);
						dbg.location(174,17);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(AST_ARRAY_INDEX, "AST_ARRAY_INDEX"));dbg.location(174,33);
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
		dbg.location(175, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:1: type_id : ( base_type | ID );
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
		dbg.location(177, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:9: ( base_type | ID )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:11: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(177,11);
					pushFollow(FOLLOW_base_type_in_type_id461);
					base_type55=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type55.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:178:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(178,4);
					ID56=(Token)match(input,ID,FOLLOW_ID_in_type_id466); if (state.failed) return retval;
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
		dbg.location(179, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:181:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set57=null;

		CommonTree set57_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(181, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:2: ( INT_KEY | FIXEDPT_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(182,2);
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
		dbg.location(184, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:186:1: var_declaration : ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !;
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
		dbg.location(186, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:2: ( ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !)
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:4: ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(187,36);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:4: ( VAR_KEY id_list COLON ^ type_id )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:5: VAR_KEY id_list COLON ^ type_id
			{
			dbg.location(187,5);
			VAR_KEY58=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration495); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VAR_KEY58_tree = (CommonTree)adaptor.create(VAR_KEY58);
			adaptor.addChild(root_0, VAR_KEY58_tree);
			}
			dbg.location(187,13);
			pushFollow(FOLLOW_id_list_in_var_declaration497);
			id_list59=id_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id_list59.getTree());
			dbg.location(187,26);
			COLON60=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration499); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON60_tree = (CommonTree)adaptor.create(COLON60);
			root_0 = (CommonTree)adaptor.becomeRoot(COLON60_tree, root_0);
			}
			dbg.location(187,28);
			pushFollow(FOLLOW_type_id_in_var_declaration502);
			type_id61=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id61.getTree());

			}
			dbg.location(187,38);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:38: ( ASSIGN ^ expr )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:39: ASSIGN ^ expr
					{
					dbg.location(187,45);
					ASSIGN62=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration507); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN62_tree = (CommonTree)adaptor.create(ASSIGN62);
					root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN62_tree, root_0);
					}
					dbg.location(187,47);
					pushFollow(FOLLOW_expr_in_var_declaration510);
					expr63=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr63.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(11);}
			dbg.location(187,58);
			SEMI64=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration514); if (state.failed) return retval;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:1: id_list : ID ( COMMA id_list )? -> ( ^( ID ) )* ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID65=null;
		Token COMMA66=null;
		ParserRuleReturnScope id_list67 =null;

		CommonTree ID65_tree=null;
		CommonTree COMMA66_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(192, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:9: ( ID ( COMMA id_list )? -> ( ^( ID ) )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:11: ID ( COMMA id_list )?
			{
			dbg.location(192,11);
			ID65=(Token)match(input,ID,FOLLOW_ID_in_id_list529); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID65);
			dbg.location(192,14);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:14: ( COMMA id_list )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:15: COMMA id_list
					{
					dbg.location(192,15);
					COMMA66=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list532); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA66);
					dbg.location(192,21);
					pushFollow(FOLLOW_id_list_in_id_list534);
					id_list67=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list67.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(12);}

			// AST REWRITE
			// elements: ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 193:2: -> ( ^( ID ) )*
			{
				dbg.location(193,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:193:5: ( ^( ID ) )*
				while ( stream_ID.hasNext() ) {
					dbg.location(193,5);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:193:5: ^( ID )
					{
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(193,7);
					root_1 = (CommonTree)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
					adaptor.addChild(root_0, root_1);
					}

				}
				stream_ID.reset();

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
		dbg.location(194, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat68 =null;


		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(196, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:2: ( ( stat )+ )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:4: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(197,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:4: ( stat )+
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:4: stat
					{
					dbg.location(197,4);
					pushFollow(FOLLOW_stat_in_stat_seq556);
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
		dbg.location(198, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:200:1: stat : ( if_stat | while_stat | for_stat | ( assign_stat )=> assign_stat | func_call | break_stat | return_stat | block );
	public final tigerParser.stat_return stat() throws RecognitionException {
		tigerParser.stat_return retval = new tigerParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope if_stat69 =null;
		ParserRuleReturnScope while_stat70 =null;
		ParserRuleReturnScope for_stat71 =null;
		ParserRuleReturnScope assign_stat72 =null;
		ParserRuleReturnScope func_call73 =null;
		ParserRuleReturnScope break_stat74 =null;
		ParserRuleReturnScope return_stat75 =null;
		ParserRuleReturnScope block76 =null;


		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(200, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:201:2: ( if_stat | while_stat | for_stat | ( assign_stat )=> assign_stat | func_call | break_stat | return_stat | block )
			int alt14=8;
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			switch ( input.LA(1) ) {
			case IF_KEY:
				{
				alt14=1;
				}
				break;
			case WHILE_KEY:
				{
				alt14=2;
				}
				break;
			case FOR_KEY:
				{
				alt14=3;
				}
				break;
			case ID:
				{
				int LA14_4 = input.LA(2);
				if ( (synpred2_tiger()) ) {
					alt14=4;
				}
				else if ( (true) ) {
					alt14=5;
				}

				}
				break;
			case BREAK_KEY:
				{
				alt14=6;
				}
				break;
			case RETURN_KEY:
				{
				alt14=7;
				}
				break;
			case BEGIN_KEY:
				{
				alt14=8;
				}
				break;
			default:
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:201:4: if_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(201,4);
					pushFollow(FOLLOW_if_stat_in_stat569);
					if_stat69=if_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stat69.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:202:4: while_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(202,4);
					pushFollow(FOLLOW_while_stat_in_stat574);
					while_stat70=while_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stat70.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:203:4: for_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(203,4);
					pushFollow(FOLLOW_for_stat_in_stat579);
					for_stat71=for_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stat71.getTree());

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:6: ( assign_stat )=> assign_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(204,23);
					pushFollow(FOLLOW_assign_stat_in_stat592);
					assign_stat72=assign_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_stat72.getTree());

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:205:6: func_call
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(205,6);
					pushFollow(FOLLOW_func_call_in_stat599);
					func_call73=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call73.getTree());

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:206:4: break_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(206,4);
					pushFollow(FOLLOW_break_stat_in_stat604);
					break_stat74=break_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, break_stat74.getTree());

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:207:4: return_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(207,4);
					pushFollow(FOLLOW_return_stat_in_stat609);
					return_stat75=return_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, return_stat75.getTree());

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:208:4: block
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(208,4);
					pushFollow(FOLLOW_block_in_stat614);
					block76=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block76.getTree());

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
		dbg.location(209, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat"


	public static class if_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:1: if_stat : IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) ;
	public final tigerParser.if_stat_return if_stat() throws RecognitionException {
		tigerParser.if_stat_return retval = new tigerParser.if_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF_KEY77=null;
		Token THEN_KEY79=null;
		Token ENDIF_KEY81=null;
		Token SEMI82=null;
		Token ELSE_KEY83=null;
		Token ENDIF_KEY85=null;
		Token SEMI86=null;
		ParserRuleReturnScope expr78 =null;
		ParserRuleReturnScope stat_seq80 =null;
		ParserRuleReturnScope stat_seq84 =null;

		CommonTree IF_KEY77_tree=null;
		CommonTree THEN_KEY79_tree=null;
		CommonTree ENDIF_KEY81_tree=null;
		CommonTree SEMI82_tree=null;
		CommonTree ELSE_KEY83_tree=null;
		CommonTree ENDIF_KEY85_tree=null;
		CommonTree SEMI86_tree=null;
		RewriteRuleTokenStream stream_THEN_KEY=new RewriteRuleTokenStream(adaptor,"token THEN_KEY");
		RewriteRuleTokenStream stream_IF_KEY=new RewriteRuleTokenStream(adaptor,"token IF_KEY");
		RewriteRuleTokenStream stream_ENDIF_KEY=new RewriteRuleTokenStream(adaptor,"token ENDIF_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ELSE_KEY=new RewriteRuleTokenStream(adaptor,"token ELSE_KEY");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "if_stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(211, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:9: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:11: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
			{
			dbg.location(211,11);
			IF_KEY77=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat624); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY77);
			dbg.location(211,18);
			pushFollow(FOLLOW_expr_in_if_stat626);
			expr78=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr78.getTree());dbg.location(211,23);
			THEN_KEY79=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat628); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY79);
			dbg.location(211,32);
			pushFollow(FOLLOW_stat_seq_in_if_stat630);
			stat_seq80=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq80.getTree());dbg.location(211,41);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:41: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
			int alt15=2;
			try { dbg.enterSubRule(15);
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			int LA15_0 = input.LA(1);
			if ( (LA15_0==ENDIF_KEY) ) {
				alt15=1;
			}
			else if ( (LA15_0==ELSE_KEY) ) {
				alt15=2;
			}

			else {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:42: ENDIF_KEY SEMI
					{
					dbg.location(211,42);
					ENDIF_KEY81=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat633); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY81);
					dbg.location(211,52);
					SEMI82=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat635); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI82);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:57: ELSE_KEY stat_seq ENDIF_KEY SEMI
					{
					dbg.location(211,57);
					ELSE_KEY83=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_if_stat637); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELSE_KEY.add(ELSE_KEY83);
					dbg.location(211,66);
					pushFollow(FOLLOW_stat_seq_in_if_stat639);
					stat_seq84=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq84.getTree());dbg.location(211,75);
					ENDIF_KEY85=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat641); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY85);
					dbg.location(211,85);
					SEMI86=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat643); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI86);

					}
					break;

			}
			} finally {dbg.exitSubRule(15);}

			// AST REWRITE
			// elements: stat_seq, stat_seq, IF_KEY, expr, ELSE_KEY
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 212:2: -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
			{
				dbg.location(212,6);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:212:6: ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(212,8);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
				dbg.location(212,15);
				adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(212,20);
				adaptor.addChild(root_1, stream_stat_seq.nextTree());dbg.location(212,29);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:212:29: ( ^( ELSE_KEY stat_seq ) )?
				if ( stream_stat_seq.hasNext()||stream_ELSE_KEY.hasNext() ) {
					dbg.location(212,29);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:212:29: ^( ELSE_KEY stat_seq )
					{
					CommonTree root_2 = (CommonTree)adaptor.nil();
					dbg.location(212,31);
					root_2 = (CommonTree)adaptor.becomeRoot(stream_ELSE_KEY.nextNode(), root_2);
					dbg.location(212,40);
					adaptor.addChild(root_2, stream_stat_seq.nextTree());
					adaptor.addChild(root_1, root_2);
					}

				}
				stream_stat_seq.reset();
				stream_ELSE_KEY.reset();

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
		dbg.location(213, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "if_stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "if_stat"


	public static class while_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "while_stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:1: while_stat : WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY expr stat_seq ) ;
	public final tigerParser.while_stat_return while_stat() throws RecognitionException {
		tigerParser.while_stat_return retval = new tigerParser.while_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHILE_KEY87=null;
		Token DO_KEY89=null;
		Token ENDDO_KEY91=null;
		Token SEMI92=null;
		ParserRuleReturnScope expr88 =null;
		ParserRuleReturnScope stat_seq90 =null;

		CommonTree WHILE_KEY87_tree=null;
		CommonTree DO_KEY89_tree=null;
		CommonTree ENDDO_KEY91_tree=null;
		CommonTree SEMI92_tree=null;
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_WHILE_KEY=new RewriteRuleTokenStream(adaptor,"token WHILE_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "while_stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(215, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:2: ( WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY expr stat_seq ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
			{
			dbg.location(216,4);
			WHILE_KEY87=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_while_stat674); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_WHILE_KEY.add(WHILE_KEY87);
			dbg.location(216,14);
			pushFollow(FOLLOW_expr_in_while_stat676);
			expr88=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr88.getTree());dbg.location(216,19);
			DO_KEY89=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_while_stat678); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY89);
			dbg.location(216,26);
			pushFollow(FOLLOW_stat_seq_in_while_stat680);
			stat_seq90=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq90.getTree());dbg.location(216,35);
			ENDDO_KEY91=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_while_stat682); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY91);
			dbg.location(216,45);
			SEMI92=(Token)match(input,SEMI,FOLLOW_SEMI_in_while_stat684); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI92);

			// AST REWRITE
			// elements: stat_seq, expr, WHILE_KEY
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 217:2: -> ^( WHILE_KEY expr stat_seq )
			{
				dbg.location(217,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:217:5: ^( WHILE_KEY expr stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(217,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE_KEY.nextNode(), root_1);
				dbg.location(217,17);
				adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(217,22);
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
		dbg.location(218, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "while_stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "while_stat"


	public static class for_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "for_stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:220:1: for_stat : FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) ;
	public final tigerParser.for_stat_return for_stat() throws RecognitionException {
		tigerParser.for_stat_return retval = new tigerParser.for_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FOR_KEY93=null;
		Token ID94=null;
		Token ASSIGN95=null;
		Token TO_KEY97=null;
		Token DO_KEY99=null;
		Token ENDDO_KEY101=null;
		Token SEMI102=null;
		ParserRuleReturnScope index_expr96 =null;
		ParserRuleReturnScope index_expr98 =null;
		ParserRuleReturnScope stat_seq100 =null;

		CommonTree FOR_KEY93_tree=null;
		CommonTree ID94_tree=null;
		CommonTree ASSIGN95_tree=null;
		CommonTree TO_KEY97_tree=null;
		CommonTree DO_KEY99_tree=null;
		CommonTree ENDDO_KEY101_tree=null;
		CommonTree SEMI102_tree=null;
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_TO_KEY=new RewriteRuleTokenStream(adaptor,"token TO_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_FOR_KEY=new RewriteRuleTokenStream(adaptor,"token FOR_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try { dbg.enterRule(getGrammarFileName(), "for_stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(220, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:220:9: ( FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:220:11: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
			{
			dbg.location(220,11);
			FOR_KEY93=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_for_stat704); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FOR_KEY.add(FOR_KEY93);
			dbg.location(220,19);
			ID94=(Token)match(input,ID,FOLLOW_ID_in_for_stat706); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID94);
			dbg.location(220,22);
			ASSIGN95=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_for_stat708); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN95);
			dbg.location(220,29);
			pushFollow(FOLLOW_index_expr_in_for_stat710);
			index_expr96=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr96.getTree());dbg.location(220,40);
			TO_KEY97=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_for_stat712); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TO_KEY.add(TO_KEY97);
			dbg.location(220,47);
			pushFollow(FOLLOW_index_expr_in_for_stat714);
			index_expr98=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr98.getTree());dbg.location(220,58);
			DO_KEY99=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_for_stat716); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY99);
			dbg.location(220,65);
			pushFollow(FOLLOW_stat_seq_in_for_stat718);
			stat_seq100=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq100.getTree());dbg.location(220,74);
			ENDDO_KEY101=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_for_stat720); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY101);
			dbg.location(220,84);
			SEMI102=(Token)match(input,SEMI,FOLLOW_SEMI_in_for_stat722); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI102);

			// AST REWRITE
			// elements: stat_seq, index_expr, ID, index_expr, FOR_KEY, TO_KEY, ASSIGN
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 221:2: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
			{
				dbg.location(221,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:5: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(221,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
				dbg.location(221,15);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:15: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				dbg.location(221,17);
				root_2 = (CommonTree)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
				dbg.location(221,24);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:24: ^( ASSIGN ID index_expr )
				{
				CommonTree root_3 = (CommonTree)adaptor.nil();
				dbg.location(221,26);
				root_3 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_3);
				dbg.location(221,33);
				adaptor.addChild(root_3, stream_ID.nextNode());dbg.location(221,36);
				adaptor.addChild(root_3, stream_index_expr.nextTree());
				adaptor.addChild(root_2, root_3);
				}
				dbg.location(221,48);
				adaptor.addChild(root_2, stream_index_expr.nextTree());
				adaptor.addChild(root_1, root_2);
				}
				dbg.location(221,60);
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
		dbg.location(222, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "for_stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "for_stat"


	public static class assign_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign_stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:224:1: assign_stat : ( value )=> value ASSIGN expr_list SEMI -> ^( ASSIGN value expr_list ) ;
	public final tigerParser.assign_stat_return assign_stat() throws RecognitionException {
		tigerParser.assign_stat_return retval = new tigerParser.assign_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ASSIGN104=null;
		Token SEMI106=null;
		ParserRuleReturnScope value103 =null;
		ParserRuleReturnScope expr_list105 =null;

		CommonTree ASSIGN104_tree=null;
		CommonTree SEMI106_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");

		try { dbg.enterRule(getGrammarFileName(), "assign_stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(224, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:2: ( ( value )=> value ASSIGN expr_list SEMI -> ^( ASSIGN value expr_list ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:4: ( value )=> value ASSIGN expr_list SEMI
			{
			dbg.location(225,15);
			pushFollow(FOLLOW_value_in_assign_stat762);
			value103=value();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_value.add(value103.getTree());dbg.location(225,21);
			ASSIGN104=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat764); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN104);
			dbg.location(225,28);
			pushFollow(FOLLOW_expr_list_in_assign_stat766);
			expr_list105=expr_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr_list.add(expr_list105.getTree());dbg.location(225,38);
			SEMI106=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat768); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI106);

			// AST REWRITE
			// elements: value, expr_list, ASSIGN
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 226:2: -> ^( ASSIGN value expr_list )
			{
				dbg.location(226,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:226:5: ^( ASSIGN value expr_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(226,7);
				root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
				dbg.location(226,14);
				adaptor.addChild(root_1, stream_value.nextTree());dbg.location(226,20);
				adaptor.addChild(root_1, stream_expr_list.nextTree());
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
		dbg.location(227, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assign_stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "assign_stat"


	public static class func_call_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:229:1: func_call : ID LPAREN func_param_list RPAREN SEMI -> ^( AST_FUNC_CALL ID func_param_list ) ;
	public final tigerParser.func_call_return func_call() throws RecognitionException {
		tigerParser.func_call_return retval = new tigerParser.func_call_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID107=null;
		Token LPAREN108=null;
		Token RPAREN110=null;
		Token SEMI111=null;
		ParserRuleReturnScope func_param_list109 =null;

		CommonTree ID107_tree=null;
		CommonTree LPAREN108_tree=null;
		CommonTree RPAREN110_tree=null;
		CommonTree SEMI111_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_func_param_list=new RewriteRuleSubtreeStream(adaptor,"rule func_param_list");

		try { dbg.enterRule(getGrammarFileName(), "func_call");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(229, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:230:2: ( ID LPAREN func_param_list RPAREN SEMI -> ^( AST_FUNC_CALL ID func_param_list ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:230:4: ID LPAREN func_param_list RPAREN SEMI
			{
			dbg.location(230,4);
			ID107=(Token)match(input,ID,FOLLOW_ID_in_func_call790); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID107);
			dbg.location(230,7);
			LPAREN108=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call792); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN108);
			dbg.location(230,14);
			pushFollow(FOLLOW_func_param_list_in_func_call794);
			func_param_list109=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_param_list.add(func_param_list109.getTree());dbg.location(230,30);
			RPAREN110=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call796); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN110);
			dbg.location(230,37);
			SEMI111=(Token)match(input,SEMI,FOLLOW_SEMI_in_func_call798); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI111);

			// AST REWRITE
			// elements: func_param_list, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 231:2: -> ^( AST_FUNC_CALL ID func_param_list )
			{
				dbg.location(231,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:231:5: ^( AST_FUNC_CALL ID func_param_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(231,7);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_FUNC_CALL, "AST_FUNC_CALL"), root_1);
				dbg.location(231,21);
				adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(231,24);
				adaptor.addChild(root_1, stream_func_param_list.nextTree());
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
		dbg.location(232, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_call");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "func_call"


	public static class break_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "break_stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:234:1: break_stat : BREAK_KEY SEMI -> BREAK_KEY ;
	public final tigerParser.break_stat_return break_stat() throws RecognitionException {
		tigerParser.break_stat_return retval = new tigerParser.break_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BREAK_KEY112=null;
		Token SEMI113=null;

		CommonTree BREAK_KEY112_tree=null;
		CommonTree SEMI113_tree=null;
		RewriteRuleTokenStream stream_BREAK_KEY=new RewriteRuleTokenStream(adaptor,"token BREAK_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");

		try { dbg.enterRule(getGrammarFileName(), "break_stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(234, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:235:2: ( BREAK_KEY SEMI -> BREAK_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:235:4: BREAK_KEY SEMI
			{
			dbg.location(235,4);
			BREAK_KEY112=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_break_stat821); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BREAK_KEY.add(BREAK_KEY112);
			dbg.location(235,14);
			SEMI113=(Token)match(input,SEMI,FOLLOW_SEMI_in_break_stat823); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI113);

			// AST REWRITE
			// elements: BREAK_KEY
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 236:2: -> BREAK_KEY
			{
				dbg.location(236,5);
				adaptor.addChild(root_0, stream_BREAK_KEY.nextNode());
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
		dbg.location(237, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "break_stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "break_stat"


	public static class return_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "return_stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:239:1: return_stat : RETURN_KEY expr SEMI -> ^( AST_RETURN_STAT RETURN_KEY expr ) ;
	public final tigerParser.return_stat_return return_stat() throws RecognitionException {
		tigerParser.return_stat_return retval = new tigerParser.return_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RETURN_KEY114=null;
		Token SEMI116=null;
		ParserRuleReturnScope expr115 =null;

		CommonTree RETURN_KEY114_tree=null;
		CommonTree SEMI116_tree=null;
		RewriteRuleTokenStream stream_RETURN_KEY=new RewriteRuleTokenStream(adaptor,"token RETURN_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "return_stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(239, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:2: ( RETURN_KEY expr SEMI -> ^( AST_RETURN_STAT RETURN_KEY expr ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:240:4: RETURN_KEY expr SEMI
			{
			dbg.location(240,4);
			RETURN_KEY114=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_return_stat840); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RETURN_KEY.add(RETURN_KEY114);
			dbg.location(240,15);
			pushFollow(FOLLOW_expr_in_return_stat842);
			expr115=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr115.getTree());dbg.location(240,20);
			SEMI116=(Token)match(input,SEMI,FOLLOW_SEMI_in_return_stat844); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI116);

			// AST REWRITE
			// elements: RETURN_KEY, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 241:2: -> ^( AST_RETURN_STAT RETURN_KEY expr )
			{
				dbg.location(241,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:241:5: ^( AST_RETURN_STAT RETURN_KEY expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				dbg.location(241,7);
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_RETURN_STAT, "AST_RETURN_STAT"), root_1);
				dbg.location(241,23);
				adaptor.addChild(root_1, stream_RETURN_KEY.nextNode());dbg.location(241,34);
				adaptor.addChild(root_1, stream_expr.nextTree());
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
		dbg.location(242, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "return_stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "return_stat"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:1: expr : ( constval ( binop_p0 ^ expr )? | ( value )=> value ( binop_p0 ^ expr )? | func_call ( binop_p0 ^ expr )? | LPAREN ! expr RPAREN ! ( binop_p0 ^ expr )? );
	public final tigerParser.expr_return expr() throws RecognitionException {
		tigerParser.expr_return retval = new tigerParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN126=null;
		Token RPAREN128=null;
		ParserRuleReturnScope constval117 =null;
		ParserRuleReturnScope binop_p0118 =null;
		ParserRuleReturnScope expr119 =null;
		ParserRuleReturnScope value120 =null;
		ParserRuleReturnScope binop_p0121 =null;
		ParserRuleReturnScope expr122 =null;
		ParserRuleReturnScope func_call123 =null;
		ParserRuleReturnScope binop_p0124 =null;
		ParserRuleReturnScope expr125 =null;
		ParserRuleReturnScope expr127 =null;
		ParserRuleReturnScope binop_p0129 =null;
		ParserRuleReturnScope expr130 =null;

		CommonTree LPAREN126_tree=null;
		CommonTree RPAREN128_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(245, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:7: ( constval ( binop_p0 ^ expr )? | ( value )=> value ( binop_p0 ^ expr )? | func_call ( binop_p0 ^ expr )? | LPAREN ! expr RPAREN ! ( binop_p0 ^ expr )? )
			int alt20=4;
			try { dbg.enterDecision(20, decisionCanBacktrack[20]);

			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt20=1;
				}
				break;
			case ID:
				{
				int LA20_2 = input.LA(2);
				if ( (synpred4_tiger()) ) {
					alt20=2;
				}
				else if ( (true) ) {
					alt20=3;
				}

				}
				break;
			case LPAREN:
				{
				alt20=4;
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:9: constval ( binop_p0 ^ expr )?
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(245,9);
					pushFollow(FOLLOW_constval_in_expr868);
					constval117=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constval117.getTree());
					dbg.location(245,18);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:18: ( binop_p0 ^ expr )?
					int alt16=2;
					try { dbg.enterSubRule(16);
					try { dbg.enterDecision(16, decisionCanBacktrack[16]);

					int LA16_0 = input.LA(1);
					if ( (LA16_0==AND||LA16_0==DIV||LA16_0==EQ||(LA16_0 >= GREATER && LA16_0 <= GREATEREQ)||(LA16_0 >= LESSER && LA16_0 <= LESSEREQ)||(LA16_0 >= MINUS && LA16_0 <= NEQ)||(LA16_0 >= OR && LA16_0 <= PLUS)) ) {
						alt16=1;
					}
					} finally {dbg.exitDecision(16);}

					switch (alt16) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:19: binop_p0 ^ expr
							{
							dbg.location(245,27);
							pushFollow(FOLLOW_binop_p0_in_expr871);
							binop_p0118=binop_p0();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0118.getTree(), root_0);dbg.location(245,29);
							pushFollow(FOLLOW_expr_in_expr874);
							expr119=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expr119.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(16);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:246:4: ( value )=> value ( binop_p0 ^ expr )?
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(246,15);
					pushFollow(FOLLOW_value_in_expr887);
					value120=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, value120.getTree());
					dbg.location(246,21);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:246:21: ( binop_p0 ^ expr )?
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==AND||LA17_0==DIV||LA17_0==EQ||(LA17_0 >= GREATER && LA17_0 <= GREATEREQ)||(LA17_0 >= LESSER && LA17_0 <= LESSEREQ)||(LA17_0 >= MINUS && LA17_0 <= NEQ)||(LA17_0 >= OR && LA17_0 <= PLUS)) ) {
						alt17=1;
					}
					} finally {dbg.exitDecision(17);}

					switch (alt17) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:246:22: binop_p0 ^ expr
							{
							dbg.location(246,30);
							pushFollow(FOLLOW_binop_p0_in_expr890);
							binop_p0121=binop_p0();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0121.getTree(), root_0);dbg.location(246,32);
							pushFollow(FOLLOW_expr_in_expr893);
							expr122=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expr122.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(17);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:247:4: func_call ( binop_p0 ^ expr )?
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(247,4);
					pushFollow(FOLLOW_func_call_in_expr900);
					func_call123=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call123.getTree());
					dbg.location(247,14);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:247:14: ( binop_p0 ^ expr )?
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:247:15: binop_p0 ^ expr
							{
							dbg.location(247,23);
							pushFollow(FOLLOW_binop_p0_in_expr903);
							binop_p0124=binop_p0();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0124.getTree(), root_0);dbg.location(247,25);
							pushFollow(FOLLOW_expr_in_expr906);
							expr125=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expr125.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(18);}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:248:4: LPAREN ! expr RPAREN ! ( binop_p0 ^ expr )?
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(248,10);
					LPAREN126=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr913); if (state.failed) return retval;dbg.location(248,12);
					pushFollow(FOLLOW_expr_in_expr916);
					expr127=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr127.getTree());
					dbg.location(248,23);
					RPAREN128=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr918); if (state.failed) return retval;dbg.location(248,25);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:248:25: ( binop_p0 ^ expr )?
					int alt19=2;
					try { dbg.enterSubRule(19);
					try { dbg.enterDecision(19, decisionCanBacktrack[19]);

					int LA19_0 = input.LA(1);
					if ( (LA19_0==AND||LA19_0==DIV||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LESSER && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= NEQ)||(LA19_0 >= OR && LA19_0 <= PLUS)) ) {
						alt19=1;
					}
					} finally {dbg.exitDecision(19);}

					switch (alt19) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:248:26: binop_p0 ^ expr
							{
							dbg.location(248,34);
							pushFollow(FOLLOW_binop_p0_in_expr922);
							binop_p0129=binop_p0();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0129.getTree(), root_0);dbg.location(248,36);
							pushFollow(FOLLOW_expr_in_expr925);
							expr130=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expr130.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(19);}

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
		dbg.location(249, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:1: binop_p0 : ( AND | OR | binop_p1 ) ;
	public final tigerParser.binop_p0_return binop_p0() throws RecognitionException {
		tigerParser.binop_p0_return retval = new tigerParser.binop_p0_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND131=null;
		Token OR132=null;
		ParserRuleReturnScope binop_p1133 =null;

		CommonTree AND131_tree=null;
		CommonTree OR132_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p0");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(251, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:9: ( ( AND | OR | binop_p1 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:11: ( AND | OR | binop_p1 )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(251,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:11: ( AND | OR | binop_p1 )
			int alt21=3;
			try { dbg.enterSubRule(21);
			try { dbg.enterDecision(21, decisionCanBacktrack[21]);

			switch ( input.LA(1) ) {
			case AND:
				{
				alt21=1;
				}
				break;
			case OR:
				{
				alt21=2;
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:12: AND
					{
					dbg.location(251,12);
					AND131=(Token)match(input,AND,FOLLOW_AND_in_binop_p0937); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND131_tree = (CommonTree)adaptor.create(AND131);
					adaptor.addChild(root_0, AND131_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:18: OR
					{
					dbg.location(251,18);
					OR132=(Token)match(input,OR,FOLLOW_OR_in_binop_p0941); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR132_tree = (CommonTree)adaptor.create(OR132);
					adaptor.addChild(root_0, OR132_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:251:23: binop_p1
					{
					dbg.location(251,23);
					pushFollow(FOLLOW_binop_p1_in_binop_p0945);
					binop_p1133=binop_p1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p1133.getTree());

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
		dbg.location(251, 31);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:1: binop_p1 : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) ;
	public final tigerParser.binop_p1_return binop_p1() throws RecognitionException {
		tigerParser.binop_p1_return retval = new tigerParser.binop_p1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQ134=null;
		Token NEQ135=null;
		Token LESSER136=null;
		Token GREATER137=null;
		Token LESSEREQ138=null;
		Token GREATEREQ139=null;
		ParserRuleReturnScope binop_p2140 =null;

		CommonTree EQ134_tree=null;
		CommonTree NEQ135_tree=null;
		CommonTree LESSER136_tree=null;
		CommonTree GREATER137_tree=null;
		CommonTree LESSEREQ138_tree=null;
		CommonTree GREATEREQ139_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p1");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(252, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:9: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(252,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			int alt22=7;
			try { dbg.enterSubRule(22);
			try { dbg.enterDecision(22, decisionCanBacktrack[22]);

			switch ( input.LA(1) ) {
			case EQ:
				{
				alt22=1;
				}
				break;
			case NEQ:
				{
				alt22=2;
				}
				break;
			case LESSER:
				{
				alt22=3;
				}
				break;
			case GREATER:
				{
				alt22=4;
				}
				break;
			case LESSEREQ:
				{
				alt22=5;
				}
				break;
			case GREATEREQ:
				{
				alt22=6;
				}
				break;
			case DIV:
			case MINUS:
			case MULT:
			case PLUS:
				{
				alt22=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(22);}

			switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:12: EQ
					{
					dbg.location(252,12);
					EQ134=(Token)match(input,EQ,FOLLOW_EQ_in_binop_p1953); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQ134_tree = (CommonTree)adaptor.create(EQ134);
					adaptor.addChild(root_0, EQ134_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:17: NEQ
					{
					dbg.location(252,17);
					NEQ135=(Token)match(input,NEQ,FOLLOW_NEQ_in_binop_p1957); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEQ135_tree = (CommonTree)adaptor.create(NEQ135);
					adaptor.addChild(root_0, NEQ135_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:23: LESSER
					{
					dbg.location(252,23);
					LESSER136=(Token)match(input,LESSER,FOLLOW_LESSER_in_binop_p1961); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSER136_tree = (CommonTree)adaptor.create(LESSER136);
					adaptor.addChild(root_0, LESSER136_tree);
					}

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:32: GREATER
					{
					dbg.location(252,32);
					GREATER137=(Token)match(input,GREATER,FOLLOW_GREATER_in_binop_p1965); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATER137_tree = (CommonTree)adaptor.create(GREATER137);
					adaptor.addChild(root_0, GREATER137_tree);
					}

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:42: LESSEREQ
					{
					dbg.location(252,42);
					LESSEREQ138=(Token)match(input,LESSEREQ,FOLLOW_LESSEREQ_in_binop_p1969); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSEREQ138_tree = (CommonTree)adaptor.create(LESSEREQ138);
					adaptor.addChild(root_0, LESSEREQ138_tree);
					}

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:53: GREATEREQ
					{
					dbg.location(252,53);
					GREATEREQ139=(Token)match(input,GREATEREQ,FOLLOW_GREATEREQ_in_binop_p1973); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATEREQ139_tree = (CommonTree)adaptor.create(GREATEREQ139);
					adaptor.addChild(root_0, GREATEREQ139_tree);
					}

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:65: binop_p2
					{
					dbg.location(252,65);
					pushFollow(FOLLOW_binop_p2_in_binop_p1977);
					binop_p2140=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p2140.getTree());

					}
					break;

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
		dbg.location(252, 73);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:1: binop_p2 : ( MINUS | PLUS | binop_p3 ) ;
	public final tigerParser.binop_p2_return binop_p2() throws RecognitionException {
		tigerParser.binop_p2_return retval = new tigerParser.binop_p2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS141=null;
		Token PLUS142=null;
		ParserRuleReturnScope binop_p3143 =null;

		CommonTree MINUS141_tree=null;
		CommonTree PLUS142_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p2");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(253, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:9: ( ( MINUS | PLUS | binop_p3 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:11: ( MINUS | PLUS | binop_p3 )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(253,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:11: ( MINUS | PLUS | binop_p3 )
			int alt23=3;
			try { dbg.enterSubRule(23);
			try { dbg.enterDecision(23, decisionCanBacktrack[23]);

			switch ( input.LA(1) ) {
			case MINUS:
				{
				alt23=1;
				}
				break;
			case PLUS:
				{
				alt23=2;
				}
				break;
			case DIV:
			case MULT:
				{
				alt23=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(23);}

			switch (alt23) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:12: MINUS
					{
					dbg.location(253,12);
					MINUS141=(Token)match(input,MINUS,FOLLOW_MINUS_in_binop_p2990); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS141_tree = (CommonTree)adaptor.create(MINUS141);
					adaptor.addChild(root_0, MINUS141_tree);
					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:20: PLUS
					{
					dbg.location(253,20);
					PLUS142=(Token)match(input,PLUS,FOLLOW_PLUS_in_binop_p2994); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS142_tree = (CommonTree)adaptor.create(PLUS142);
					adaptor.addChild(root_0, PLUS142_tree);
					}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:27: binop_p3
					{
					dbg.location(253,27);
					pushFollow(FOLLOW_binop_p3_in_binop_p2998);
					binop_p3143=binop_p3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p3143.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(23);}

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
		dbg.location(253, 35);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:254:1: binop_p3 : ( MULT | DIV ) ;
	public final tigerParser.binop_p3_return binop_p3() throws RecognitionException {
		tigerParser.binop_p3_return retval = new tigerParser.binop_p3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set144=null;

		CommonTree set144_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p3");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(254, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:254:9: ( ( MULT | DIV ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(254,9);
			set144=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set144));
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
		dbg.location(254, 22);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:256:1: constval : ( INTLIT | FIXEDPTLIT );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set145=null;

		CommonTree set145_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "constval");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(256, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:256:9: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(256,9);
			set145=input.LT(1);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set145));
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
		dbg.location(258, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:267:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set146=null;

		CommonTree set146_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binary_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(267, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:268:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(268,2);
			set146=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set146));
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
		dbg.location(269, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:271:1: expr_list : expr ( COMMA expr )* -> ( ^( expr ) )* ;
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA148=null;
		ParserRuleReturnScope expr147 =null;
		ParserRuleReturnScope expr149 =null;

		CommonTree COMMA148_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(271, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:2: ( expr ( COMMA expr )* -> ( ^( expr ) )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:4: expr ( COMMA expr )*
			{
			dbg.location(272,4);
			pushFollow(FOLLOW_expr_in_expr_list1121);
			expr147=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr147.getTree());dbg.location(272,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:9: ( COMMA expr )*
			try { dbg.enterSubRule(24);

			loop24:
			while (true) {
				int alt24=2;
				try { dbg.enterDecision(24, decisionCanBacktrack[24]);

				int LA24_0 = input.LA(1);
				if ( (LA24_0==COMMA) ) {
					alt24=1;
				}

				} finally {dbg.exitDecision(24);}

				switch (alt24) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:272:10: COMMA expr
					{
					dbg.location(272,10);
					COMMA148=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1124); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA148);
					dbg.location(272,16);
					pushFollow(FOLLOW_expr_in_expr_list1126);
					expr149=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr149.getTree());
					}
					break;

				default :
					break loop24;
				}
			}
			} finally {dbg.exitSubRule(24);}

			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 273:2: -> ( ^( expr ) )*
			{
				dbg.location(273,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:273:5: ( ^( expr ) )*
				while ( stream_expr.hasNext() ) {
					dbg.location(273,5);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:273:5: ^( expr )
					{
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(273,7);
					root_1 = (CommonTree)adaptor.becomeRoot(stream_expr.nextNode(), root_1);
					adaptor.addChild(root_0, root_1);
					}

				}
				stream_expr.reset();

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
		dbg.location(274, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:1: value : ID ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? ;
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID150=null;
		Token LBRACK151=null;
		Token RBRACK153=null;
		Token LBRACK154=null;
		Token RBRACK156=null;
		ParserRuleReturnScope index_expr152 =null;
		ParserRuleReturnScope index_expr155 =null;

		CommonTree ID150_tree=null;
		CommonTree LBRACK151_tree=null;
		CommonTree RBRACK153_tree=null;
		CommonTree LBRACK154_tree=null;
		CommonTree RBRACK156_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(276, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:8: ( ID ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:10: ID ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(276,10);
			ID150=(Token)match(input,ID,FOLLOW_ID_in_value1147); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID150_tree = (CommonTree)adaptor.create(ID150);
			adaptor.addChild(root_0, ID150_tree);
			}
			dbg.location(276,13);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:13: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			int alt26=2;
			try { dbg.enterSubRule(26);
			try { dbg.enterDecision(26, decisionCanBacktrack[26]);

			int LA26_0 = input.LA(1);
			if ( (LA26_0==LBRACK) ) {
				alt26=1;
			}
			} finally {dbg.exitDecision(26);}

			switch (alt26) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:14: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					dbg.location(276,14);
					LBRACK151=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1150); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK151_tree = (CommonTree)adaptor.create(LBRACK151);
					adaptor.addChild(root_0, LBRACK151_tree);
					}
					dbg.location(276,21);
					pushFollow(FOLLOW_index_expr_in_value1152);
					index_expr152=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr152.getTree());
					dbg.location(276,32);
					RBRACK153=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1154); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK153_tree = (CommonTree)adaptor.create(RBRACK153);
					adaptor.addChild(root_0, RBRACK153_tree);
					}
					dbg.location(276,39);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:39: ( LBRACK index_expr RBRACK )?
					int alt25=2;
					try { dbg.enterSubRule(25);
					try { dbg.enterDecision(25, decisionCanBacktrack[25]);

					int LA25_0 = input.LA(1);
					if ( (LA25_0==LBRACK) ) {
						alt25=1;
					}
					} finally {dbg.exitDecision(25);}

					switch (alt25) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:276:40: LBRACK index_expr RBRACK
							{
							dbg.location(276,40);
							LBRACK154=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1157); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LBRACK154_tree = (CommonTree)adaptor.create(LBRACK154);
							adaptor.addChild(root_0, LBRACK154_tree);
							}
							dbg.location(276,47);
							pushFollow(FOLLOW_index_expr_in_value1159);
							index_expr155=index_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr155.getTree());
							dbg.location(276,58);
							RBRACK156=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1161); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							RBRACK156_tree = (CommonTree)adaptor.create(RBRACK156);
							adaptor.addChild(root_0, RBRACK156_tree);
							}

							}
							break;

					}
					} finally {dbg.exitSubRule(25);}

					}
					break;

			}
			} finally {dbg.exitSubRule(26);}

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
		dbg.location(277, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "value"


	public static class index_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:1: index_expr : ( INTLIT ( index_oper ^ index_expr )? | ID ( index_oper ^ index_expr )? );
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INTLIT157=null;
		Token ID160=null;
		ParserRuleReturnScope index_oper158 =null;
		ParserRuleReturnScope index_expr159 =null;
		ParserRuleReturnScope index_oper161 =null;
		ParserRuleReturnScope index_expr162 =null;

		CommonTree INTLIT157_tree=null;
		CommonTree ID160_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(279, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:280:2: ( INTLIT ( index_oper ^ index_expr )? | ID ( index_oper ^ index_expr )? )
			int alt29=2;
			try { dbg.enterDecision(29, decisionCanBacktrack[29]);

			int LA29_0 = input.LA(1);
			if ( (LA29_0==INTLIT) ) {
				alt29=1;
			}
			else if ( (LA29_0==ID) ) {
				alt29=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(29);}

			switch (alt29) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:280:4: INTLIT ( index_oper ^ index_expr )?
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(280,4);
					INTLIT157=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_index_expr1177); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTLIT157_tree = (CommonTree)adaptor.create(INTLIT157);
					adaptor.addChild(root_0, INTLIT157_tree);
					}
					dbg.location(280,11);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:280:11: ( index_oper ^ index_expr )?
					int alt27=2;
					try { dbg.enterSubRule(27);
					try { dbg.enterDecision(27, decisionCanBacktrack[27]);

					int LA27_0 = input.LA(1);
					if ( ((LA27_0 >= MINUS && LA27_0 <= MULT)||LA27_0==PLUS) ) {
						alt27=1;
					}
					} finally {dbg.exitDecision(27);}

					switch (alt27) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:280:12: index_oper ^ index_expr
							{
							dbg.location(280,22);
							pushFollow(FOLLOW_index_oper_in_index_expr1180);
							index_oper158=index_oper();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(index_oper158.getTree(), root_0);dbg.location(280,24);
							pushFollow(FOLLOW_index_expr_in_index_expr1183);
							index_expr159=index_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr159.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(27);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:281:5: ID ( index_oper ^ index_expr )?
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(281,5);
					ID160=(Token)match(input,ID,FOLLOW_ID_in_index_expr1191); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID160_tree = (CommonTree)adaptor.create(ID160);
					adaptor.addChild(root_0, ID160_tree);
					}
					dbg.location(281,8);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:281:8: ( index_oper ^ index_expr )?
					int alt28=2;
					try { dbg.enterSubRule(28);
					try { dbg.enterDecision(28, decisionCanBacktrack[28]);

					int LA28_0 = input.LA(1);
					if ( ((LA28_0 >= MINUS && LA28_0 <= MULT)||LA28_0==PLUS) ) {
						alt28=1;
					}
					} finally {dbg.exitDecision(28);}

					switch (alt28) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:281:9: index_oper ^ index_expr
							{
							dbg.location(281,19);
							pushFollow(FOLLOW_index_oper_in_index_expr1194);
							index_oper161=index_oper();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(index_oper161.getTree(), root_0);dbg.location(281,21);
							pushFollow(FOLLOW_index_expr_in_index_expr1197);
							index_expr162=index_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr162.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(28);}

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
		dbg.location(282, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:284:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set163=null;

		CommonTree set163_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_oper");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(284, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:285:2: ( ( PLUS | MINUS | MULT ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(285,2);
			set163=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set163));
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
		dbg.location(286, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_oper");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "index_oper"


	public static class func_param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:304:1: func_param_list : ( expr ( COMMA expr )* )? -> ( ^( expr ) )* ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA165=null;
		ParserRuleReturnScope expr164 =null;
		ParserRuleReturnScope expr166 =null;

		CommonTree COMMA165_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try { dbg.enterRule(getGrammarFileName(), "func_param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(304, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:305:2: ( ( expr ( COMMA expr )* )? -> ( ^( expr ) )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:305:4: ( expr ( COMMA expr )* )?
			{
			dbg.location(305,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:305:4: ( expr ( COMMA expr )* )?
			int alt31=2;
			try { dbg.enterSubRule(31);
			try { dbg.enterDecision(31, decisionCanBacktrack[31]);

			int LA31_0 = input.LA(1);
			if ( (LA31_0==FIXEDPTLIT||LA31_0==ID||LA31_0==INTLIT||LA31_0==LPAREN) ) {
				alt31=1;
			}
			} finally {dbg.exitDecision(31);}

			switch (alt31) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:305:5: expr ( COMMA expr )*
					{
					dbg.location(305,5);
					pushFollow(FOLLOW_expr_in_func_param_list1316);
					expr164=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr164.getTree());dbg.location(305,10);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:305:10: ( COMMA expr )*
					try { dbg.enterSubRule(30);

					loop30:
					while (true) {
						int alt30=2;
						try { dbg.enterDecision(30, decisionCanBacktrack[30]);

						int LA30_0 = input.LA(1);
						if ( (LA30_0==COMMA) ) {
							alt30=1;
						}

						} finally {dbg.exitDecision(30);}

						switch (alt30) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:305:11: COMMA expr
							{
							dbg.location(305,11);
							COMMA165=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list1319); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA165);
							dbg.location(305,17);
							pushFollow(FOLLOW_expr_in_func_param_list1321);
							expr166=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(expr166.getTree());
							}
							break;

						default :
							break loop30;
						}
					}
					} finally {dbg.exitSubRule(30);}

					}
					break;

			}
			} finally {dbg.exitSubRule(31);}

			// AST REWRITE
			// elements: expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 306:2: -> ( ^( expr ) )*
			{
				dbg.location(306,5);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:306:5: ( ^( expr ) )*
				while ( stream_expr.hasNext() ) {
					dbg.location(306,5);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:306:5: ^( expr )
					{
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(306,7);
					root_1 = (CommonTree)adaptor.becomeRoot(stream_expr.nextNode(), root_1);
					adaptor.addChild(root_0, root_1);
					}

				}
				stream_expr.reset();

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
		dbg.location(307, 1);

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:309:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set167=null;

		CommonTree set167_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "keywords");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(309, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:310:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(310,2);
			set167=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= IF_KEY)||input.LA(1)==INT_KEY||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set167));
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
		dbg.location(333, 1);

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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:6: ( assign_stat )
		dbg.enterAlt(1);

		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:7: assign_stat
		{
		dbg.location(204,7);
		pushFollow(FOLLOW_assign_stat_in_synpred2_tiger587);
		assign_stat();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_tiger

	// $ANTLR start synpred4_tiger
	public final void synpred4_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:246:4: ( value )
		dbg.enterAlt(1);

		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:246:5: value
		{
		dbg.location(246,5);
		pushFollow(FOLLOW_value_in_synpred4_tiger882);
		value();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_tiger

	// Delegated rules

	public final boolean synpred4_tiger() {
		state.backtracking++;
		dbg.beginBacktrack(state.backtracking);
		int start = input.mark();
		try {
			synpred4_tiger_fragment(); // can never throw exception
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



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program108 = new BitSet(new long[]{0x0800002210000000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list123 = new BitSet(new long[]{0x0800002210000002L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration135 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration137 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration139 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration141 = new BitSet(new long[]{0x0010000200000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration143 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration145 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration147 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration149 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration151 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_main_function192 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function194 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function196 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function198 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_main_function200 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_block_list_in_main_function202 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_END_KEY_in_main_function204 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list236 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_param_list239 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list241 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_ID_in_param263 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COLON_in_param265 = new BitSet(new long[]{0x0000002210000000L});
	public static final BitSet FOLLOW_type_id_in_param267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list290 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block302 = new BitSet(new long[]{0x0600000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block305 = new BitSet(new long[]{0x1008000A2000C000L});
	public static final BitSet FOLLOW_stat_seq_in_block307 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_END_KEY_in_block310 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement337 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list353 = new BitSet(new long[]{0x0200000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list367 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration381 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration383 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration386 = new BitSet(new long[]{0x0000002010000020L});
	public static final BitSet FOLLOW_type_in_type_declaration388 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration390 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type418 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type420 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type422 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type424 = new BitSet(new long[]{0x0000804000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type427 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_INTLIT_in_type429 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type431 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type436 = new BitSet(new long[]{0x0000002010000000L});
	public static final BitSet FOLLOW_base_type_in_type439 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration495 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration497 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration499 = new BitSet(new long[]{0x0000002210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration502 = new BitSet(new long[]{0x0020000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration507 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_var_declaration510 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list529 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_id_list532 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_id_list534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq556 = new BitSet(new long[]{0x1008000A2000C002L});
	public static final BitSet FOLLOW_if_stat_in_stat569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat574 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_stat_in_stat592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_stat599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_break_stat_in_stat604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_return_stat_in_stat609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_if_stat624 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_if_stat626 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat628 = new BitSet(new long[]{0x1008000A2000C000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat630 = new BitSet(new long[]{0x0000000001400000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat633 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_if_stat637 = new BitSet(new long[]{0x1008000A2000C000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat639 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat641 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_while_stat674 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_while_stat676 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DO_KEY_in_while_stat678 = new BitSet(new long[]{0x1008000A2000C000L});
	public static final BitSet FOLLOW_stat_seq_in_while_stat680 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_while_stat682 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_while_stat684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_for_stat704 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_for_stat706 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_for_stat708 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat710 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_for_stat712 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat714 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_DO_KEY_in_for_stat716 = new BitSet(new long[]{0x1008000A2000C000L});
	public static final BitSet FOLLOW_stat_seq_in_for_stat718 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_for_stat720 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_stat722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat762 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat764 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_list_in_assign_stat766 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call790 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call792 = new BitSet(new long[]{0x0010021208000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call794 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call796 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_func_call798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_break_stat821 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_break_stat823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_return_stat840 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_return_stat842 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_SEMI_in_return_stat844 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr868 = new BitSet(new long[]{0x0003398184100012L});
	public static final BitSet FOLLOW_binop_p0_in_expr871 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_expr874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_expr887 = new BitSet(new long[]{0x0003398184100012L});
	public static final BitSet FOLLOW_binop_p0_in_expr890 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_expr893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_expr900 = new BitSet(new long[]{0x0003398184100012L});
	public static final BitSet FOLLOW_binop_p0_in_expr903 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_expr906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_expr913 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_expr916 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr918 = new BitSet(new long[]{0x0003398184100012L});
	public static final BitSet FOLLOW_binop_p0_in_expr922 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_expr925 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p0937 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p0941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p0945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_binop_p1953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEQ_in_binop_p1957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSER_in_binop_p1961 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_binop_p1965 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEREQ_in_binop_p1969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQ_in_binop_p1973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p2_in_binop_p1977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p2990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p2994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p2998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list1121 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list1124 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_expr_list1126 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_ID_in_value1147 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value1150 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1152 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1154 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value1157 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1159 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTLIT_in_index_expr1177 = new BitSet(new long[]{0x0002180000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1180 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1191 = new BitSet(new long[]{0x0002180000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1194 = new BitSet(new long[]{0x0000001200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list1316 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list1319 = new BitSet(new long[]{0x0000021208000000L});
	public static final BitSet FOLLOW_expr_in_func_param_list1321 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_assign_stat_in_synpred2_tiger587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred4_tiger882 = new BitSet(new long[]{0x0000000000000002L});
}
