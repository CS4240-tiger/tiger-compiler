// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-19 19:53:31

	import java.util.Map;
	import java.util.HashMap;
	import org.antlr.runtime.tree.CommonTree;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class tigerParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY_KEY", "ASSIGN", 
		"BEGIN_KEY", "BREAK_KEY", "CARRAGE_RET", "COLON", "COMMA", "COMMENT", 
		"DIV", "DO_KEY", "ELSE_KEY", "ENDDO_KEY", "ENDIF_KEY", "END_KEY", "EQ", 
		"FIXEDPTLIT", "FIXEDPT_KEY", "FOR_KEY", "FUNCTION_KEY", "GREATER", "GREATEREQ", 
		"ID", "ID_KEY", "IF_KEY", "INTLIT", "INT_KEY", "LBRACK", "LESSER", "LESSEREQ", 
		"LPAREN", "MAIN_KEY", "MINUS", "MULT", "NEQ", "NEWLINE", "OF_KEY", "OR", 
		"PLUS", "RBRACK", "RETURN_KEY", "RPAREN", "SEMI", "TAB", "THEN_KEY", "TO_KEY", 
		"TYPE_KEY", "VAR_KEY", "VOID_KEY", "WHILE_KEY", "WHITESPACE"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY_KEY=5;
	public static final int ASSIGN=6;
	public static final int BEGIN_KEY=7;
	public static final int BREAK_KEY=8;
	public static final int CARRAGE_RET=9;
	public static final int COLON=10;
	public static final int COMMA=11;
	public static final int COMMENT=12;
	public static final int DIV=13;
	public static final int DO_KEY=14;
	public static final int ELSE_KEY=15;
	public static final int ENDDO_KEY=16;
	public static final int ENDIF_KEY=17;
	public static final int END_KEY=18;
	public static final int EQ=19;
	public static final int FIXEDPTLIT=20;
	public static final int FIXEDPT_KEY=21;
	public static final int FOR_KEY=22;
	public static final int FUNCTION_KEY=23;
	public static final int GREATER=24;
	public static final int GREATEREQ=25;
	public static final int ID=26;
	public static final int ID_KEY=27;
	public static final int IF_KEY=28;
	public static final int INTLIT=29;
	public static final int INT_KEY=30;
	public static final int LBRACK=31;
	public static final int LESSER=32;
	public static final int LESSEREQ=33;
	public static final int LPAREN=34;
	public static final int MAIN_KEY=35;
	public static final int MINUS=36;
	public static final int MULT=37;
	public static final int NEQ=38;
	public static final int NEWLINE=39;
	public static final int OF_KEY=40;
	public static final int OR=41;
	public static final int PLUS=42;
	public static final int RBRACK=43;
	public static final int RETURN_KEY=44;
	public static final int RPAREN=45;
	public static final int SEMI=46;
	public static final int TAB=47;
	public static final int THEN_KEY=48;
	public static final int TO_KEY=49;
	public static final int TYPE_KEY=50;
	public static final int VAR_KEY=51;
	public static final int VOID_KEY=52;
	public static final int WHILE_KEY=53;
	public static final int WHITESPACE=54;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public tigerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public tigerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:2: ( type_declaration_list funct_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:4: type_declaration_list funct_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_tiger_program75);
			type_declaration_list1=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list1.getTree());

			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program77);
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
		return retval;
	}
	// $ANTLR end "tiger_program"


	public static class funct_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:109:1: funct_declaration_list : ( funct_declaration )* ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:2: ( ( funct_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:4: ( funct_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:4: ( funct_declaration )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY||LA1_0==VOID_KEY) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:4: funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list89);
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
		return retval;
	}
	// $ANTLR end "funct_declaration_list"


	public static class funct_declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:113:1: funct_declaration : ( ret_type ( FUNCTION_KEY ID | MAIN_KEY ) ) ^ LPAREN ! param_list RPAREN ! BEGIN_KEY ! block_list END_KEY ! SEMI !;
	public final tigerParser.funct_declaration_return funct_declaration() throws RecognitionException {
		tigerParser.funct_declaration_return retval = new tigerParser.funct_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FUNCTION_KEY5=null;
		Token ID6=null;
		Token MAIN_KEY7=null;
		Token LPAREN8=null;
		Token RPAREN10=null;
		Token BEGIN_KEY11=null;
		Token END_KEY13=null;
		Token SEMI14=null;
		ParserRuleReturnScope ret_type4 =null;
		ParserRuleReturnScope param_list9 =null;
		ParserRuleReturnScope block_list12 =null;

		CommonTree FUNCTION_KEY5_tree=null;
		CommonTree ID6_tree=null;
		CommonTree MAIN_KEY7_tree=null;
		CommonTree LPAREN8_tree=null;
		CommonTree RPAREN10_tree=null;
		CommonTree BEGIN_KEY11_tree=null;
		CommonTree END_KEY13_tree=null;
		CommonTree SEMI14_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:2: ( ( ret_type ( FUNCTION_KEY ID | MAIN_KEY ) ) ^ LPAREN ! param_list RPAREN ! BEGIN_KEY ! block_list END_KEY ! SEMI !)
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: ( ret_type ( FUNCTION_KEY ID | MAIN_KEY ) ) ^ LPAREN ! param_list RPAREN ! BEGIN_KEY ! block_list END_KEY ! SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: ( ret_type ( FUNCTION_KEY ID | MAIN_KEY ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:5: ret_type ( FUNCTION_KEY ID | MAIN_KEY )
			{
			pushFollow(FOLLOW_ret_type_in_funct_declaration102);
			ret_type4=ret_type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ret_type4.getTree());

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:14: ( FUNCTION_KEY ID | MAIN_KEY )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FUNCTION_KEY) ) {
				alt2=1;
			}
			else if ( (LA2_0==MAIN_KEY) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:15: FUNCTION_KEY ID
					{
					FUNCTION_KEY5=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration105); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FUNCTION_KEY5_tree = (CommonTree)adaptor.create(FUNCTION_KEY5);
					adaptor.addChild(root_0, FUNCTION_KEY5_tree);
					}

					ID6=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration107); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID6_tree = (CommonTree)adaptor.create(ID6);
					adaptor.addChild(root_0, ID6_tree);
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:33: MAIN_KEY
					{
					MAIN_KEY7=(Token)match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_funct_declaration111); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MAIN_KEY7_tree = (CommonTree)adaptor.create(MAIN_KEY7);
					adaptor.addChild(root_0, MAIN_KEY7_tree);
					}

					}
					break;

			}

			}

			LPAREN8=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration116); if (state.failed) return retval;
			pushFollow(FOLLOW_param_list_in_funct_declaration119);
			param_list9=param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, param_list9.getTree());

			RPAREN10=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration121); if (state.failed) return retval;
			BEGIN_KEY11=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration124); if (state.failed) return retval;
			pushFollow(FOLLOW_block_list_in_funct_declaration127);
			block_list12=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, block_list12.getTree());

			END_KEY13=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration129); if (state.failed) return retval;
			SEMI14=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration132); if (state.failed) return retval;
			if ( state.backtracking==0 ) {defineFunction((ID6!=null?ID6.getText():null), (param_list9!=null?((CommonTree)param_list9.getTree()):null), (block_list12!=null?((CommonTree)block_list12.getTree()):null));}
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
		return retval;
	}
	// $ANTLR end "funct_declaration"


	public static class ret_type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:1: ret_type : ( VOID_KEY | type_id );
	public final tigerParser.ret_type_return ret_type() throws RecognitionException {
		tigerParser.ret_type_return retval = new tigerParser.ret_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY15=null;
		ParserRuleReturnScope type_id16 =null;

		CommonTree VOID_KEY15_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:119:2: ( VOID_KEY | type_id )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==VOID_KEY) ) {
				alt3=1;
			}
			else if ( (LA3_0==FIXEDPT_KEY||LA3_0==ID||LA3_0==INT_KEY) ) {
				alt3=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:119:4: VOID_KEY
					{
					root_0 = (CommonTree)adaptor.nil();


					VOID_KEY15=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type149); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VOID_KEY15_tree = (CommonTree)adaptor.create(VOID_KEY15);
					adaptor.addChild(root_0, VOID_KEY15_tree);
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:4: type_id
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_id_in_ret_type154);
					type_id16=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id16.getTree());

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
		return retval;
	}
	// $ANTLR end "ret_type"


	public static class param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:123:1: param_list : ( param ( COMMA param )* )? ;
	public final tigerParser.param_list_return param_list() throws RecognitionException {
		tigerParser.param_list_return retval = new tigerParser.param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA18=null;
		ParserRuleReturnScope param17 =null;
		ParserRuleReturnScope param19 =null;

		CommonTree COMMA18_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:2: ( ( param ( COMMA param )* )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:4: ( param ( COMMA param )* )?
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:4: ( param ( COMMA param )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ID) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:5: param ( COMMA param )*
					{
					pushFollow(FOLLOW_param_in_param_list167);
					param17=param();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, param17.getTree());

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:11: ( COMMA param )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMA) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:12: COMMA param
							{
							COMMA18=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list170); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							COMMA18_tree = (CommonTree)adaptor.create(COMMA18);
							adaptor.addChild(root_0, COMMA18_tree);
							}

							pushFollow(FOLLOW_param_in_param_list172);
							param19=param();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, param19.getTree());

							}
							break;

						default :
							break loop4;
						}
					}

					}
					break;

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
		return retval;
	}
	// $ANTLR end "param_list"


	public static class param_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:1: param : ID COLON ^ type_id ;
	public final tigerParser.param_return param() throws RecognitionException {
		tigerParser.param_return retval = new tigerParser.param_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID20=null;
		Token COLON21=null;
		ParserRuleReturnScope type_id22 =null;

		CommonTree ID20_tree=null;
		CommonTree COLON21_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:8: ( ID COLON ^ type_id )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:10: ID COLON ^ type_id
			{
			root_0 = (CommonTree)adaptor.nil();


			ID20=(Token)match(input,ID,FOLLOW_ID_in_param187); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID20_tree = (CommonTree)adaptor.create(ID20);
			adaptor.addChild(root_0, ID20_tree);
			}

			COLON21=(Token)match(input,COLON,FOLLOW_COLON_in_param189); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON21_tree = (CommonTree)adaptor.create(COLON21);
			root_0 = (CommonTree)adaptor.becomeRoot(COLON21_tree, root_0);
			}

			pushFollow(FOLLOW_type_id_in_param192);
			type_id22=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id22.getTree());

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
		return retval;
	}
	// $ANTLR end "param"


	public static class block_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block23 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:2: ( ( block )+ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:4: ( block )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:4: ( block )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==BEGIN_KEY) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:4: block
					{
					pushFollow(FOLLOW_block_in_block_list202);
					block23=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block23.getTree());

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
		return retval;
	}
	// $ANTLR end "block_list"


	public static class block_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:1: block : BEGIN_KEY ^ ( declaration_statement stat_seq ) ^ END_KEY ! SEMI !;
	public final tigerParser.block_return block() throws RecognitionException {
		tigerParser.block_return retval = new tigerParser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BEGIN_KEY24=null;
		Token END_KEY27=null;
		Token SEMI28=null;
		ParserRuleReturnScope declaration_statement25 =null;
		ParserRuleReturnScope stat_seq26 =null;

		CommonTree BEGIN_KEY24_tree=null;
		CommonTree END_KEY27_tree=null;
		CommonTree SEMI28_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:8: ( BEGIN_KEY ^ ( declaration_statement stat_seq ) ^ END_KEY ! SEMI !)
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:10: BEGIN_KEY ^ ( declaration_statement stat_seq ) ^ END_KEY ! SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			BEGIN_KEY24=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block214); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BEGIN_KEY24_tree = (CommonTree)adaptor.create(BEGIN_KEY24);
			root_0 = (CommonTree)adaptor.becomeRoot(BEGIN_KEY24_tree, root_0);
			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:21: ( declaration_statement stat_seq )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:22: declaration_statement stat_seq
			{
			pushFollow(FOLLOW_declaration_statement_in_block218);
			declaration_statement25=declaration_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_statement25.getTree());

			pushFollow(FOLLOW_stat_seq_in_block220);
			stat_seq26=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, stat_seq26.getTree());

			}

			END_KEY27=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_block224); if (state.failed) return retval;
			SEMI28=(Token)match(input,SEMI,FOLLOW_SEMI_in_block227); if (state.failed) return retval;
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
		return retval;
	}
	// $ANTLR end "block"


	public static class declaration_statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list29 =null;
		ParserRuleReturnScope var_declaration_list30 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:2: ( type_declaration_list var_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:4: type_declaration_list var_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement238);
			type_declaration_list29=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list29.getTree());

			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement240);
			var_declaration_list30=var_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration_list30.getTree());

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
		return retval;
	}
	// $ANTLR end "declaration_statement"


	public static class type_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration31 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:2: ( ( type_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:5: ( type_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:5: ( type_declaration )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==TYPE_KEY) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:5: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list254);
					type_declaration31=type_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration31.getTree());

					}
					break;

				default :
					break loop7;
				}
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
		return retval;
	}
	// $ANTLR end "type_declaration_list"


	public static class var_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_declaration32 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:2: ( ( var_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:4: ( var_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:4: ( var_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==VAR_KEY) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:4: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list268);
					var_declaration32=var_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration32.getTree());

					}
					break;

				default :
					break loop8;
				}
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
		return retval;
	}
	// $ANTLR end "var_declaration_list"


	public static class type_declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:1: type_declaration : ( TYPE_KEY ID ) ^ EQ ^ type SEMI !;
	public final tigerParser.type_declaration_return type_declaration() throws RecognitionException {
		tigerParser.type_declaration_return retval = new tigerParser.type_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TYPE_KEY33=null;
		Token ID34=null;
		Token EQ35=null;
		Token SEMI37=null;
		ParserRuleReturnScope type36 =null;

		CommonTree TYPE_KEY33_tree=null;
		CommonTree ID34_tree=null;
		CommonTree EQ35_tree=null;
		CommonTree SEMI37_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:2: ( ( TYPE_KEY ID ) ^ EQ ^ type SEMI !)
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:4: ( TYPE_KEY ID ) ^ EQ ^ type SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:4: ( TYPE_KEY ID )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:5: TYPE_KEY ID
			{
			TYPE_KEY33=(Token)match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration282); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TYPE_KEY33_tree = (CommonTree)adaptor.create(TYPE_KEY33);
			adaptor.addChild(root_0, TYPE_KEY33_tree);
			}

			ID34=(Token)match(input,ID,FOLLOW_ID_in_type_declaration284); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID34_tree = (CommonTree)adaptor.create(ID34);
			adaptor.addChild(root_0, ID34_tree);
			}

			}

			EQ35=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration288); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EQ35_tree = (CommonTree)adaptor.create(EQ35);
			root_0 = (CommonTree)adaptor.becomeRoot(EQ35_tree, root_0);
			}

			pushFollow(FOLLOW_type_in_type_declaration291);
			type36=type();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type36.getTree());

			SEMI37=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration293); if (state.failed) return retval;
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
		return retval;
	}
	// $ANTLR end "type_declaration"


	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:1: type : ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) ^ OF_KEY ^ ( base_type ) ^);
	public final tigerParser.type_return type() throws RecognitionException {
		tigerParser.type_return retval = new tigerParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ARRAY_KEY39=null;
		Token LBRACK40=null;
		Token INTLIT41=null;
		Token RBRACK42=null;
		Token LBRACK43=null;
		Token INTLIT44=null;
		Token RBRACK45=null;
		Token OF_KEY46=null;
		ParserRuleReturnScope base_type38 =null;
		ParserRuleReturnScope base_type47 =null;

		CommonTree ARRAY_KEY39_tree=null;
		CommonTree LBRACK40_tree=null;
		CommonTree INTLIT41_tree=null;
		CommonTree RBRACK42_tree=null;
		CommonTree LBRACK43_tree=null;
		CommonTree INTLIT44_tree=null;
		CommonTree RBRACK45_tree=null;
		CommonTree OF_KEY46_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:6: ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) ^ OF_KEY ^ ( base_type ) ^)
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==FIXEDPT_KEY||LA10_0==INT_KEY) ) {
				alt10=1;
			}
			else if ( (LA10_0==ARRAY_KEY) ) {
				alt10=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:8: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type305);
					base_type38=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type38.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) ^ OF_KEY ^ ( base_type ) ^
					{
					root_0 = (CommonTree)adaptor.nil();


					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? )
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:5: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )?
					{
					ARRAY_KEY39=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type311); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ARRAY_KEY39_tree = (CommonTree)adaptor.create(ARRAY_KEY39);
					adaptor.addChild(root_0, ARRAY_KEY39_tree);
					}

					LBRACK40=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type313); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK40_tree = (CommonTree)adaptor.create(LBRACK40);
					adaptor.addChild(root_0, LBRACK40_tree);
					}

					INTLIT41=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type315); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTLIT41_tree = (CommonTree)adaptor.create(INTLIT41);
					adaptor.addChild(root_0, INTLIT41_tree);
					}

					RBRACK42=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type317); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK42_tree = (CommonTree)adaptor.create(RBRACK42);
					adaptor.addChild(root_0, RBRACK42_tree);
					}

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:36: ( LBRACK INTLIT RBRACK )?
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==LBRACK) ) {
						alt9=1;
					}
					switch (alt9) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:37: LBRACK INTLIT RBRACK
							{
							LBRACK43=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type320); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LBRACK43_tree = (CommonTree)adaptor.create(LBRACK43);
							adaptor.addChild(root_0, LBRACK43_tree);
							}

							INTLIT44=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type322); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							INTLIT44_tree = (CommonTree)adaptor.create(INTLIT44);
							adaptor.addChild(root_0, INTLIT44_tree);
							}

							RBRACK45=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type324); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							RBRACK45_tree = (CommonTree)adaptor.create(RBRACK45);
							adaptor.addChild(root_0, RBRACK45_tree);
							}

							}
							break;

					}

					}

					OF_KEY46=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type330); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OF_KEY46_tree = (CommonTree)adaptor.create(OF_KEY46);
					root_0 = (CommonTree)adaptor.becomeRoot(OF_KEY46_tree, root_0);
					}

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:70: ( base_type )
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:71: base_type
					{
					pushFollow(FOLLOW_base_type_in_type334);
					base_type47=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type47.getTree());

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
		return retval;
	}
	// $ANTLR end "type"


	public static class type_id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:1: type_id : ( base_type | ID );
	public final tigerParser.type_id_return type_id() throws RecognitionException {
		tigerParser.type_id_return retval = new tigerParser.type_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID49=null;
		ParserRuleReturnScope base_type48 =null;

		CommonTree ID49_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:9: ( base_type | ID )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==FIXEDPT_KEY||LA11_0==INT_KEY) ) {
				alt11=1;
			}
			else if ( (LA11_0==ID) ) {
				alt11=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:11: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type_id346);
					base_type48=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type48.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID49=(Token)match(input,ID,FOLLOW_ID_in_type_id351); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID49_tree = (CommonTree)adaptor.create(ID49);
					adaptor.addChild(root_0, ID49_tree);
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
		return retval;
	}
	// $ANTLR end "type_id"


	public static class base_type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "base_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:159:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set50=null;

		CommonTree set50_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:2: ( INT_KEY | FIXEDPT_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set50=input.LT(1);
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set50));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "base_type"


	public static class var_declaration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:1: var_declaration : ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !;
	public final tigerParser.var_declaration_return var_declaration() throws RecognitionException {
		tigerParser.var_declaration_return retval = new tigerParser.var_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VAR_KEY51=null;
		Token COLON53=null;
		Token ASSIGN55=null;
		Token SEMI57=null;
		ParserRuleReturnScope id_list52 =null;
		ParserRuleReturnScope type_id54 =null;
		ParserRuleReturnScope expr56 =null;

		CommonTree VAR_KEY51_tree=null;
		CommonTree COLON53_tree=null;
		CommonTree ASSIGN55_tree=null;
		CommonTree SEMI57_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:2: ( ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !)
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:4: ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:4: ( VAR_KEY id_list COLON ^ type_id )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:5: VAR_KEY id_list COLON ^ type_id
			{
			VAR_KEY51=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration380); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VAR_KEY51_tree = (CommonTree)adaptor.create(VAR_KEY51);
			adaptor.addChild(root_0, VAR_KEY51_tree);
			}

			pushFollow(FOLLOW_id_list_in_var_declaration382);
			id_list52=id_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, id_list52.getTree());

			COLON53=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration384); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			COLON53_tree = (CommonTree)adaptor.create(COLON53);
			root_0 = (CommonTree)adaptor.becomeRoot(COLON53_tree, root_0);
			}

			pushFollow(FOLLOW_type_id_in_var_declaration387);
			type_id54=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id54.getTree());

			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:38: ( ASSIGN ^ expr )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==ASSIGN) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:39: ASSIGN ^ expr
					{
					ASSIGN55=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration392); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN55_tree = (CommonTree)adaptor.create(ASSIGN55);
					root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN55_tree, root_0);
					}

					pushFollow(FOLLOW_expr_in_var_declaration395);
					expr56=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr56.getTree());

					}
					break;

			}

			SEMI57=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration399); if (state.failed) return retval;
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
		return retval;
	}
	// $ANTLR end "var_declaration"


	public static class id_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:1: id_list : ID ( COMMA ! id_list )? ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID58=null;
		Token COMMA59=null;
		ParserRuleReturnScope id_list60 =null;

		CommonTree ID58_tree=null;
		CommonTree COMMA59_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:9: ( ID ( COMMA ! id_list )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:11: ID ( COMMA ! id_list )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ID58=(Token)match(input,ID,FOLLOW_ID_in_id_list410); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID58_tree = (CommonTree)adaptor.create(ID58);
			adaptor.addChild(root_0, ID58_tree);
			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:14: ( COMMA ! id_list )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==COMMA) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:15: COMMA ! id_list
					{
					COMMA59=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list413); if (state.failed) return retval;
					pushFollow(FOLLOW_id_list_in_id_list416);
					id_list60=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, id_list60.getTree());

					}
					break;

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
		return retval;
	}
	// $ANTLR end "id_list"


	public static class stat_seq_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:171:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat61 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:2: ( ( stat )+ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:4: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:4: ( stat )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= BEGIN_KEY && LA14_0 <= BREAK_KEY)||LA14_0==FOR_KEY||LA14_0==ID||LA14_0==IF_KEY||LA14_0==RETURN_KEY||LA14_0==WHILE_KEY) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:4: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq430);
					stat61=stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stat61.getTree());

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
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
		return retval;
	}
	// $ANTLR end "stat_seq"


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:175:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) | WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) | ( ID value_tail )=> ID value_tail ASSIGN ^ expr_list SEMI !| func_call SEMI !| BREAK_KEY SEMI !| RETURN_KEY ^ expr SEMI !| block );
	public final tigerParser.stat_return stat() throws RecognitionException {
		tigerParser.stat_return retval = new tigerParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF_KEY62=null;
		Token THEN_KEY64=null;
		Token ENDIF_KEY66=null;
		Token SEMI67=null;
		Token ELSE_KEY68=null;
		Token ENDIF_KEY70=null;
		Token SEMI71=null;
		Token WHILE_KEY72=null;
		Token DO_KEY74=null;
		Token ENDDO_KEY76=null;
		Token SEMI77=null;
		Token FOR_KEY78=null;
		Token ID79=null;
		Token ASSIGN80=null;
		Token TO_KEY82=null;
		Token DO_KEY84=null;
		Token ENDDO_KEY86=null;
		Token SEMI87=null;
		Token ID88=null;
		Token ASSIGN90=null;
		Token SEMI92=null;
		Token SEMI94=null;
		Token BREAK_KEY95=null;
		Token SEMI96=null;
		Token RETURN_KEY97=null;
		Token SEMI99=null;
		ParserRuleReturnScope expr63 =null;
		ParserRuleReturnScope stat_seq65 =null;
		ParserRuleReturnScope stat_seq69 =null;
		ParserRuleReturnScope expr73 =null;
		ParserRuleReturnScope stat_seq75 =null;
		ParserRuleReturnScope index_expr81 =null;
		ParserRuleReturnScope index_expr83 =null;
		ParserRuleReturnScope stat_seq85 =null;
		ParserRuleReturnScope value_tail89 =null;
		ParserRuleReturnScope expr_list91 =null;
		ParserRuleReturnScope func_call93 =null;
		ParserRuleReturnScope expr98 =null;
		ParserRuleReturnScope block100 =null;

		CommonTree IF_KEY62_tree=null;
		CommonTree THEN_KEY64_tree=null;
		CommonTree ENDIF_KEY66_tree=null;
		CommonTree SEMI67_tree=null;
		CommonTree ELSE_KEY68_tree=null;
		CommonTree ENDIF_KEY70_tree=null;
		CommonTree SEMI71_tree=null;
		CommonTree WHILE_KEY72_tree=null;
		CommonTree DO_KEY74_tree=null;
		CommonTree ENDDO_KEY76_tree=null;
		CommonTree SEMI77_tree=null;
		CommonTree FOR_KEY78_tree=null;
		CommonTree ID79_tree=null;
		CommonTree ASSIGN80_tree=null;
		CommonTree TO_KEY82_tree=null;
		CommonTree DO_KEY84_tree=null;
		CommonTree ENDDO_KEY86_tree=null;
		CommonTree SEMI87_tree=null;
		CommonTree ID88_tree=null;
		CommonTree ASSIGN90_tree=null;
		CommonTree SEMI92_tree=null;
		CommonTree SEMI94_tree=null;
		CommonTree BREAK_KEY95_tree=null;
		CommonTree SEMI96_tree=null;
		CommonTree RETURN_KEY97_tree=null;
		CommonTree SEMI99_tree=null;
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

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:176:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) | WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) | ( ID value_tail )=> ID value_tail ASSIGN ^ expr_list SEMI !| func_call SEMI !| BREAK_KEY SEMI !| RETURN_KEY ^ expr SEMI !| block )
			int alt16=8;
			switch ( input.LA(1) ) {
			case IF_KEY:
				{
				alt16=1;
				}
				break;
			case WHILE_KEY:
				{
				alt16=2;
				}
				break;
			case FOR_KEY:
				{
				alt16=3;
				}
				break;
			case ID:
				{
				int LA16_4 = input.LA(2);
				if ( (synpred1_tiger()) ) {
					alt16=4;
				}
				else if ( (true) ) {
					alt16=5;
				}

				}
				break;
			case BREAK_KEY:
				{
				alt16=6;
				}
				break;
			case RETURN_KEY:
				{
				alt16=7;
				}
				break;
			case BEGIN_KEY:
				{
				alt16=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:176:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					IF_KEY62=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_stat443); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY62);

					pushFollow(FOLLOW_expr_in_stat445);
					expr63=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr63.getTree());
					THEN_KEY64=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat447); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY64);

					pushFollow(FOLLOW_stat_seq_in_stat449);
					stat_seq65=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq65.getTree());
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:176:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					int alt15=2;
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
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:176:35: ENDIF_KEY SEMI
							{
							ENDIF_KEY66=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat452); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY66);

							SEMI67=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat454); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMI.add(SEMI67);

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:176:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							ELSE_KEY68=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat456); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ELSE_KEY.add(ELSE_KEY68);

							pushFollow(FOLLOW_stat_seq_in_stat458);
							stat_seq69=stat_seq();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq69.getTree());
							ENDIF_KEY70=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat460); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY70);

							SEMI71=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat462); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_SEMI.add(SEMI71);

							}
							break;

					}

					// AST REWRITE
					// elements: expr, IF_KEY, stat_seq, stat_seq, ELSE_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 177:3: -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:6: ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:29: ( ^( ELSE_KEY stat_seq ) )?
						if ( stream_stat_seq.hasNext()||stream_ELSE_KEY.hasNext() ) {
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:29: ^( ELSE_KEY stat_seq )
							{
							CommonTree root_2 = (CommonTree)adaptor.nil();
							root_2 = (CommonTree)adaptor.becomeRoot(stream_ELSE_KEY.nextNode(), root_2);
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
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:178:4: WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					WHILE_KEY72=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat487); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					WHILE_KEY72_tree = (CommonTree)adaptor.create(WHILE_KEY72);
					root_0 = (CommonTree)adaptor.becomeRoot(WHILE_KEY72_tree, root_0);
					}

					pushFollow(FOLLOW_expr_in_stat490);
					expr73=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr73.getTree());

					DO_KEY74=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_stat492); if (state.failed) return retval;
					pushFollow(FOLLOW_stat_seq_in_stat495);
					stat_seq75=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stat_seq75.getTree());

					ENDDO_KEY76=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat497); if (state.failed) return retval;
					SEMI77=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat500); if (state.failed) return retval;
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:179:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					FOR_KEY78=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat506); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FOR_KEY.add(FOR_KEY78);

					ID79=(Token)match(input,ID,FOLLOW_ID_in_stat508); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID79);

					ASSIGN80=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat510); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN80);

					pushFollow(FOLLOW_index_expr_in_stat512);
					index_expr81=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr81.getTree());
					TO_KEY82=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_stat514); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TO_KEY.add(TO_KEY82);

					pushFollow(FOLLOW_index_expr_in_stat516);
					index_expr83=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr83.getTree());
					DO_KEY84=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_stat518); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY84);

					pushFollow(FOLLOW_stat_seq_in_stat520);
					stat_seq85=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq85.getTree());
					ENDDO_KEY86=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat522); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY86);

					SEMI87=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat524); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI87);

					// AST REWRITE
					// elements: index_expr, index_expr, stat_seq, TO_KEY, ID, FOR_KEY, ASSIGN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 180:3: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:6: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:16: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:25: ^( ASSIGN ID index_expr )
						{
						CommonTree root_3 = (CommonTree)adaptor.nil();
						root_3 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_3);
						adaptor.addChild(root_3, stream_ID.nextNode());
						adaptor.addChild(root_3, stream_index_expr.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_2, stream_index_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:181:6: ( ID value_tail )=> ID value_tail ASSIGN ^ expr_list SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					ID88=(Token)match(input,ID,FOLLOW_ID_in_stat563); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID88_tree = (CommonTree)adaptor.create(ID88);
					adaptor.addChild(root_0, ID88_tree);
					}

					pushFollow(FOLLOW_value_tail_in_stat565);
					value_tail89=value_tail();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, value_tail89.getTree());

					ASSIGN90=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat567); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASSIGN90_tree = (CommonTree)adaptor.create(ASSIGN90);
					root_0 = (CommonTree)adaptor.becomeRoot(ASSIGN90_tree, root_0);
					}

					pushFollow(FOLLOW_expr_list_in_stat570);
					expr_list91=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_list91.getTree());

					SEMI92=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat572); if (state.failed) return retval;
					}
					break;
				case 5 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:6: func_call SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_func_call_in_stat580);
					func_call93=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call93.getTree());

					SEMI94=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat582); if (state.failed) return retval;
					}
					break;
				case 6 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:183:4: BREAK_KEY SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					BREAK_KEY95=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat588); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					BREAK_KEY95_tree = (CommonTree)adaptor.create(BREAK_KEY95);
					adaptor.addChild(root_0, BREAK_KEY95_tree);
					}

					SEMI96=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat590); if (state.failed) return retval;
					}
					break;
				case 7 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:4: RETURN_KEY ^ expr SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					RETURN_KEY97=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat596); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RETURN_KEY97_tree = (CommonTree)adaptor.create(RETURN_KEY97);
					root_0 = (CommonTree)adaptor.becomeRoot(RETURN_KEY97_tree, root_0);
					}

					pushFollow(FOLLOW_expr_in_stat599);
					expr98=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr98.getTree());

					SEMI99=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat601); if (state.failed) return retval;
					}
					break;
				case 8 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:185:4: block
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_block_in_stat607);
					block100=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block100.getTree());

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
		return retval;
	}
	// $ANTLR end "stat"


	public static class func_call_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:188:1: func_call : ID LPAREN func_param_list RPAREN ;
	public final tigerParser.func_call_return func_call() throws RecognitionException {
		tigerParser.func_call_return retval = new tigerParser.func_call_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID101=null;
		Token LPAREN102=null;
		Token RPAREN104=null;
		ParserRuleReturnScope func_param_list103 =null;

		CommonTree ID101_tree=null;
		CommonTree LPAREN102_tree=null;
		CommonTree RPAREN104_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:2: ( ID LPAREN func_param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:4: ID LPAREN func_param_list RPAREN
			{
			root_0 = (CommonTree)adaptor.nil();


			ID101=(Token)match(input,ID,FOLLOW_ID_in_func_call618); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID101_tree = (CommonTree)adaptor.create(ID101);
			adaptor.addChild(root_0, ID101_tree);
			}

			LPAREN102=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call620); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN102_tree = (CommonTree)adaptor.create(LPAREN102);
			adaptor.addChild(root_0, LPAREN102_tree);
			}

			pushFollow(FOLLOW_func_param_list_in_func_call622);
			func_param_list103=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, func_param_list103.getTree());

			RPAREN104=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call624); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN104_tree = (CommonTree)adaptor.create(RPAREN104);
			adaptor.addChild(root_0, RPAREN104_tree);
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
		return retval;
	}
	// $ANTLR end "func_call"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )? ;
	public final tigerParser.expr_return expr() throws RecognitionException {
		tigerParser.expr_return retval = new tigerParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID106=null;
		Token LPAREN109=null;
		Token RPAREN111=null;
		ParserRuleReturnScope constval105 =null;
		ParserRuleReturnScope value_tail107 =null;
		ParserRuleReturnScope func_call_tail108 =null;
		ParserRuleReturnScope expr110 =null;
		ParserRuleReturnScope binop_p0112 =null;
		ParserRuleReturnScope expr113 =null;

		CommonTree ID106_tree=null;
		CommonTree LPAREN109_tree=null;
		CommonTree RPAREN111_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !)
			int alt18=3;
			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt18=1;
				}
				break;
			case ID:
				{
				alt18=2;
				}
				break;
			case LPAREN:
				{
				alt18=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:10: constval
					{
					pushFollow(FOLLOW_constval_in_expr638);
					constval105=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constval105.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:21: ID ( value_tail | func_call_tail )
					{
					ID106=(Token)match(input,ID,FOLLOW_ID_in_expr642); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID106_tree = (CommonTree)adaptor.create(ID106);
					adaptor.addChild(root_0, ID106_tree);
					}

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:24: ( value_tail | func_call_tail )
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==EOF||LA17_0==AND||LA17_0==ASSIGN||LA17_0==COMMA||(LA17_0 >= DIV && LA17_0 <= DO_KEY)||LA17_0==EQ||(LA17_0 >= GREATER && LA17_0 <= GREATEREQ)||(LA17_0 >= LBRACK && LA17_0 <= LESSEREQ)||(LA17_0 >= MINUS && LA17_0 <= NEQ)||(LA17_0 >= OR && LA17_0 <= PLUS)||(LA17_0 >= RPAREN && LA17_0 <= SEMI)||LA17_0==THEN_KEY) ) {
						alt17=1;
					}
					else if ( (LA17_0==LPAREN) ) {
						alt17=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 17, 0, input);
						throw nvae;
					}

					switch (alt17) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:25: value_tail
							{
							pushFollow(FOLLOW_value_tail_in_expr645);
							value_tail107=value_tail();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, value_tail107.getTree());

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:38: func_call_tail
							{
							pushFollow(FOLLOW_func_call_tail_in_expr649);
							func_call_tail108=func_call_tail();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call_tail108.getTree());

							}
							break;

					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:56: LPAREN ! expr RPAREN !
					{
					LPAREN109=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr654); if (state.failed) return retval;
					pushFollow(FOLLOW_expr_in_expr657);
					expr110=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr110.getTree());

					RPAREN111=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr659); if (state.failed) return retval;
					}
					break;

			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:78: ( binop_p0 ^ expr )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==AND||LA19_0==DIV||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LESSER && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= NEQ)||(LA19_0 >= OR && LA19_0 <= PLUS)) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:192:79: binop_p0 ^ expr
					{
					pushFollow(FOLLOW_binop_p0_in_expr664);
					binop_p0112=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0112.getTree(), root_0);
					pushFollow(FOLLOW_expr_in_expr667);
					expr113=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr113.getTree());

					}
					break;

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
		return retval;
	}
	// $ANTLR end "expr"


	public static class binop_p0_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p0"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:1: binop_p0 : ( AND | OR | binop_p1 ) ;
	public final tigerParser.binop_p0_return binop_p0() throws RecognitionException {
		tigerParser.binop_p0_return retval = new tigerParser.binop_p0_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND114=null;
		Token OR115=null;
		ParserRuleReturnScope binop_p1116 =null;

		CommonTree AND114_tree=null;
		CommonTree OR115_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:9: ( ( AND | OR | binop_p1 ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:11: ( AND | OR | binop_p1 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:11: ( AND | OR | binop_p1 )
			int alt20=3;
			switch ( input.LA(1) ) {
			case AND:
				{
				alt20=1;
				}
				break;
			case OR:
				{
				alt20=2;
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
				alt20=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:12: AND
					{
					AND114=(Token)match(input,AND,FOLLOW_AND_in_binop_p0680); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND114_tree = (CommonTree)adaptor.create(AND114);
					adaptor.addChild(root_0, AND114_tree);
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:18: OR
					{
					OR115=(Token)match(input,OR,FOLLOW_OR_in_binop_p0684); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR115_tree = (CommonTree)adaptor.create(OR115);
					adaptor.addChild(root_0, OR115_tree);
					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:195:23: binop_p1
					{
					pushFollow(FOLLOW_binop_p1_in_binop_p0688);
					binop_p1116=binop_p1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p1116.getTree());

					}
					break;

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
		return retval;
	}
	// $ANTLR end "binop_p0"


	public static class binop_p1_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:1: binop_p1 : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) ;
	public final tigerParser.binop_p1_return binop_p1() throws RecognitionException {
		tigerParser.binop_p1_return retval = new tigerParser.binop_p1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQ117=null;
		Token NEQ118=null;
		Token LESSER119=null;
		Token GREATER120=null;
		Token LESSEREQ121=null;
		Token GREATEREQ122=null;
		ParserRuleReturnScope binop_p2123 =null;

		CommonTree EQ117_tree=null;
		CommonTree NEQ118_tree=null;
		CommonTree LESSER119_tree=null;
		CommonTree GREATER120_tree=null;
		CommonTree LESSEREQ121_tree=null;
		CommonTree GREATEREQ122_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:9: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			int alt21=7;
			switch ( input.LA(1) ) {
			case EQ:
				{
				alt21=1;
				}
				break;
			case NEQ:
				{
				alt21=2;
				}
				break;
			case LESSER:
				{
				alt21=3;
				}
				break;
			case GREATER:
				{
				alt21=4;
				}
				break;
			case LESSEREQ:
				{
				alt21=5;
				}
				break;
			case GREATEREQ:
				{
				alt21=6;
				}
				break;
			case DIV:
			case MINUS:
			case MULT:
			case PLUS:
				{
				alt21=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:12: EQ
					{
					EQ117=(Token)match(input,EQ,FOLLOW_EQ_in_binop_p1696); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQ117_tree = (CommonTree)adaptor.create(EQ117);
					adaptor.addChild(root_0, EQ117_tree);
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:17: NEQ
					{
					NEQ118=(Token)match(input,NEQ,FOLLOW_NEQ_in_binop_p1700); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEQ118_tree = (CommonTree)adaptor.create(NEQ118);
					adaptor.addChild(root_0, NEQ118_tree);
					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:23: LESSER
					{
					LESSER119=(Token)match(input,LESSER,FOLLOW_LESSER_in_binop_p1704); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSER119_tree = (CommonTree)adaptor.create(LESSER119);
					adaptor.addChild(root_0, LESSER119_tree);
					}

					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:32: GREATER
					{
					GREATER120=(Token)match(input,GREATER,FOLLOW_GREATER_in_binop_p1708); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATER120_tree = (CommonTree)adaptor.create(GREATER120);
					adaptor.addChild(root_0, GREATER120_tree);
					}

					}
					break;
				case 5 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:42: LESSEREQ
					{
					LESSEREQ121=(Token)match(input,LESSEREQ,FOLLOW_LESSEREQ_in_binop_p1712); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSEREQ121_tree = (CommonTree)adaptor.create(LESSEREQ121);
					adaptor.addChild(root_0, LESSEREQ121_tree);
					}

					}
					break;
				case 6 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:53: GREATEREQ
					{
					GREATEREQ122=(Token)match(input,GREATEREQ,FOLLOW_GREATEREQ_in_binop_p1716); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATEREQ122_tree = (CommonTree)adaptor.create(GREATEREQ122);
					adaptor.addChild(root_0, GREATEREQ122_tree);
					}

					}
					break;
				case 7 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:196:65: binop_p2
					{
					pushFollow(FOLLOW_binop_p2_in_binop_p1720);
					binop_p2123=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p2123.getTree());

					}
					break;

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
		return retval;
	}
	// $ANTLR end "binop_p1"


	public static class binop_p2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:1: binop_p2 : ( MINUS | PLUS | binop_p3 ) ;
	public final tigerParser.binop_p2_return binop_p2() throws RecognitionException {
		tigerParser.binop_p2_return retval = new tigerParser.binop_p2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS124=null;
		Token PLUS125=null;
		ParserRuleReturnScope binop_p3126 =null;

		CommonTree MINUS124_tree=null;
		CommonTree PLUS125_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:9: ( ( MINUS | PLUS | binop_p3 ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:11: ( MINUS | PLUS | binop_p3 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:11: ( MINUS | PLUS | binop_p3 )
			int alt22=3;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				alt22=1;
				}
				break;
			case PLUS:
				{
				alt22=2;
				}
				break;
			case DIV:
			case MULT:
				{
				alt22=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:12: MINUS
					{
					MINUS124=(Token)match(input,MINUS,FOLLOW_MINUS_in_binop_p2733); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS124_tree = (CommonTree)adaptor.create(MINUS124);
					adaptor.addChild(root_0, MINUS124_tree);
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:20: PLUS
					{
					PLUS125=(Token)match(input,PLUS,FOLLOW_PLUS_in_binop_p2737); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS125_tree = (CommonTree)adaptor.create(PLUS125);
					adaptor.addChild(root_0, PLUS125_tree);
					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:27: binop_p3
					{
					pushFollow(FOLLOW_binop_p3_in_binop_p2741);
					binop_p3126=binop_p3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p3126.getTree());

					}
					break;

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
		return retval;
	}
	// $ANTLR end "binop_p2"


	public static class binop_p3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p3"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:198:1: binop_p3 : ( MULT | DIV ) ;
	public final tigerParser.binop_p3_return binop_p3() throws RecognitionException {
		tigerParser.binop_p3_return retval = new tigerParser.binop_p3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set127=null;

		CommonTree set127_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:198:9: ( ( MULT | DIV ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set127=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set127));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "binop_p3"


	public static class constval_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:200:1: constval : ( INTLIT | FIXEDPTLIT );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set128=null;

		CommonTree set128_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:200:9: ( INTLIT | FIXEDPTLIT )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set128=input.LT(1);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set128));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "constval"


	public static class binary_operator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binary_operator"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:211:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set129=null;

		CommonTree set129_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:212:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set129=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set129));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "binary_operator"


	public static class expr_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:215:1: expr_list : expr ( COMMA ! expr )* ;
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA131=null;
		ParserRuleReturnScope expr130 =null;
		ParserRuleReturnScope expr132 =null;

		CommonTree COMMA131_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:2: ( expr ( COMMA ! expr )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:4: expr ( COMMA ! expr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_expr_list864);
			expr130=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr130.getTree());

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:9: ( COMMA ! expr )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==COMMA) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:216:10: COMMA ! expr
					{
					COMMA131=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list867); if (state.failed) return retval;
					pushFollow(FOLLOW_expr_in_expr_list870);
					expr132=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr132.getTree());

					}
					break;

				default :
					break loop23;
				}
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
		return retval;
	}
	// $ANTLR end "expr_list"


	public static class value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:219:1: value : ID value_tail ;
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID133=null;
		ParserRuleReturnScope value_tail134 =null;

		CommonTree ID133_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:219:8: ( ID value_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:219:10: ID value_tail
			{
			root_0 = (CommonTree)adaptor.nil();


			ID133=(Token)match(input,ID,FOLLOW_ID_in_value883); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID133_tree = (CommonTree)adaptor.create(ID133);
			adaptor.addChild(root_0, ID133_tree);
			}

			pushFollow(FOLLOW_value_tail_in_value885);
			value_tail134=value_tail();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, value_tail134.getTree());

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
		return retval;
	}
	// $ANTLR end "value"


	public static class value_tail_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:220:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? ;
	public final tigerParser.value_tail_return value_tail() throws RecognitionException {
		tigerParser.value_tail_return retval = new tigerParser.value_tail_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LBRACK135=null;
		Token RBRACK137=null;
		Token LBRACK138=null;
		Token RBRACK140=null;
		ParserRuleReturnScope index_expr136 =null;
		ParserRuleReturnScope index_expr139 =null;

		CommonTree LBRACK135_tree=null;
		CommonTree RBRACK137_tree=null;
		CommonTree LBRACK138_tree=null;
		CommonTree RBRACK140_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:2: ( ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:4: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:4: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==LBRACK) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:5: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					LBRACK135=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail895); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK135_tree = (CommonTree)adaptor.create(LBRACK135);
					adaptor.addChild(root_0, LBRACK135_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value_tail897);
					index_expr136=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr136.getTree());

					RBRACK137=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail899); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK137_tree = (CommonTree)adaptor.create(RBRACK137);
					adaptor.addChild(root_0, RBRACK137_tree);
					}

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:30: ( LBRACK index_expr RBRACK )?
					int alt24=2;
					int LA24_0 = input.LA(1);
					if ( (LA24_0==LBRACK) ) {
						alt24=1;
					}
					switch (alt24) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:31: LBRACK index_expr RBRACK
							{
							LBRACK138=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail902); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							LBRACK138_tree = (CommonTree)adaptor.create(LBRACK138);
							adaptor.addChild(root_0, LBRACK138_tree);
							}

							pushFollow(FOLLOW_index_expr_in_value_tail904);
							index_expr139=index_expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr139.getTree());

							RBRACK140=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail906); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							RBRACK140_tree = (CommonTree)adaptor.create(RBRACK140);
							adaptor.addChild(root_0, RBRACK140_tree);
							}

							}
							break;

					}

					}
					break;

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
		return retval;
	}
	// $ANTLR end "value_tail"


	public static class index_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:224:1: index_expr : ( INTLIT | ID ) ( index_oper ^ index_expr )? ;
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set141=null;
		ParserRuleReturnScope index_oper142 =null;
		ParserRuleReturnScope index_expr143 =null;

		CommonTree set141_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:2: ( ( INTLIT | ID ) ( index_oper ^ index_expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:4: ( INTLIT | ID ) ( index_oper ^ index_expr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			set141=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set141));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:18: ( index_oper ^ index_expr )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( ((LA26_0 >= MINUS && LA26_0 <= MULT)||LA26_0==PLUS) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:19: index_oper ^ index_expr
					{
					pushFollow(FOLLOW_index_oper_in_index_expr931);
					index_oper142=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(index_oper142.getTree(), root_0);
					pushFollow(FOLLOW_index_expr_in_index_expr934);
					index_expr143=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr143.getTree());

					}
					break;

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
		return retval;
	}
	// $ANTLR end "index_expr"


	public static class index_oper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_oper"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:228:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set144=null;

		CommonTree set144_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:229:2: ( ( PLUS | MINUS | MULT ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set144=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set144));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "index_oper"


	public static class func_call_tail_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:248:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final tigerParser.func_call_tail_return func_call_tail() throws RecognitionException {
		tigerParser.func_call_tail_return retval = new tigerParser.func_call_tail_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN145=null;
		Token RPAREN147=null;
		ParserRuleReturnScope func_param_list146 =null;

		CommonTree LPAREN145_tree=null;
		CommonTree RPAREN147_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:249:2: ( LPAREN func_param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:249:4: LPAREN func_param_list RPAREN
			{
			root_0 = (CommonTree)adaptor.nil();


			LPAREN145=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail1050); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LPAREN145_tree = (CommonTree)adaptor.create(LPAREN145);
			adaptor.addChild(root_0, LPAREN145_tree);
			}

			pushFollow(FOLLOW_func_param_list_in_func_call_tail1052);
			func_param_list146=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, func_param_list146.getTree());

			RPAREN147=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail1054); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RPAREN147_tree = (CommonTree)adaptor.create(RPAREN147);
			adaptor.addChild(root_0, RPAREN147_tree);
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
		return retval;
	}
	// $ANTLR end "func_call_tail"


	public static class func_param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:1: func_param_list : ( expr ( COMMA ! expr )* )? ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA149=null;
		ParserRuleReturnScope expr148 =null;
		ParserRuleReturnScope expr150 =null;

		CommonTree COMMA149_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:2: ( ( expr ( COMMA ! expr )* )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:4: ( expr ( COMMA ! expr )* )?
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:4: ( expr ( COMMA ! expr )* )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==FIXEDPTLIT||LA28_0==ID||LA28_0==INTLIT||LA28_0==LPAREN) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:5: expr ( COMMA ! expr )*
					{
					pushFollow(FOLLOW_expr_in_func_param_list1068);
					expr148=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr148.getTree());

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:10: ( COMMA ! expr )*
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0==COMMA) ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:253:11: COMMA ! expr
							{
							COMMA149=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list1071); if (state.failed) return retval;
							pushFollow(FOLLOW_expr_in_func_param_list1074);
							expr150=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expr150.getTree());

							}
							break;

						default :
							break loop27;
						}
					}

					}
					break;

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
		return retval;
	}
	// $ANTLR end "func_param_list"


	public static class keywords_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "keywords"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:256:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set151=null;

		CommonTree set151_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:257:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set151=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= IF_KEY)||input.LA(1)==INT_KEY||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set151));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
		return retval;
	}
	// $ANTLR end "keywords"

	// $ANTLR start synpred1_tiger
	public final void synpred1_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:181:6: ( ID value_tail )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:181:7: ID value_tail
		{
		match(input,ID,FOLLOW_ID_in_synpred1_tiger556); if (state.failed) return;

		pushFollow(FOLLOW_value_tail_in_synpred1_tiger558);
		value_tail();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_tiger

	// Delegated rules

	public final boolean synpred1_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program75 = new BitSet(new long[]{0x0010000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program77 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list89 = new BitSet(new long[]{0x0010000044200002L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration102 = new BitSet(new long[]{0x0000000800800000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration105 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration107 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_funct_declaration111 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration116 = new BitSet(new long[]{0x0000200004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration119 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration121 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration124 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration127 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration129 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list167 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_param_list170 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list172 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_param187 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_param189 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list202 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block214 = new BitSet(new long[]{0x000C000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block218 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_block220 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block224 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_block227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement238 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list254 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list268 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration282 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration284 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration288 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration291 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type311 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type313 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type315 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type317 = new BitSet(new long[]{0x0000010080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type320 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type322 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type324 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type330 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration380 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration382 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_var_declaration384 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration387 = new BitSet(new long[]{0x0000400000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration392 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_var_declaration395 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list410 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_id_list413 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq430 = new BitSet(new long[]{0x0020100014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat443 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat445 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat447 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat449 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat452 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat454 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat456 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat458 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat460 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat487 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat490 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat492 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat495 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat497 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat506 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat508 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat510 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat512 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat514 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat516 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat518 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat520 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat522 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat563 = new BitSet(new long[]{0x0000000080000040L});
	public static final BitSet FOLLOW_value_tail_in_stat565 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat567 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat570 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_stat580 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat588 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat590 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat596 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat599 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call618 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call620 = new BitSet(new long[]{0x0000200424100000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call622 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr638 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_ID_in_expr642 = new BitSet(new long[]{0x0000067783082010L});
	public static final BitSet FOLLOW_value_tail_in_expr645 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr649 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr654 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr657 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr659 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_binop_p0_in_expr664 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p0680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p0684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p0688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_binop_p1696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEQ_in_binop_p1700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSER_in_binop_p1704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_binop_p1708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEREQ_in_binop_p1712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQ_in_binop_p1716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p2_in_binop_p1720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p2733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p2737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p2741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list864 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_expr_list867 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list870 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_value883 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail895 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail897 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail899 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail902 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail904 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr922 = new BitSet(new long[]{0x0000043000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr931 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr934 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail1050 = new BitSet(new long[]{0x0000200424100000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail1052 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail1054 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list1068 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list1071 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_func_param_list1074 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_synpred1_tiger556 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_synpred1_tiger558 = new BitSet(new long[]{0x0000000000000002L});
}
