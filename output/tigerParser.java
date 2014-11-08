// $ANTLR 3.5.1 /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g 2014-11-08 16:00:56

	import java.util.Map;
	import java.util.HashMap;
	import java.util.List;
	import java.util.ArrayList;
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
		"AST_2D_ARRAY", "AST_BLOCK", "AST_EXPR_LIST", "AST_EXPR_PAREN", "AST_FUNC_CALL", 
		"AST_ID_LIST", "AST_PARAM_LIST", "AST_RETURN_STAT", "BEGIN_KEY", "BREAK_KEY", 
		"CARRAGE_RET", "COLON", "COMMA", "COMMENT", "DIV", "DO_KEY", "ELSE_KEY", 
		"ENDDO_KEY", "ENDIF_KEY", "END_KEY", "EQ", "FIXEDPT_KEY", "FOR_KEY", "FUNCTION_KEY", 
		"GREATER", "GREATEREQ", "ID", "ID_KEY", "IF_KEY", "INT_KEY", "LBRACK", 
		"LESSER", "LESSEREQ", "LPAREN", "MAIN_KEY", "MINUS", "MULT", "NEQ", "NEWLINE", 
		"OF_KEY", "OR", "PLUS", "RBRACK", "RETURN_KEY", "RPAREN", "SEMI", "TAB", 
		"THEN_KEY", "TO_KEY", "TYPE_KEY", "UNSIGNED_FIXEDPTLIT", "UNSIGNED_INTLIT", 
		"VAR_KEY", "VOID_KEY", "WHILE_KEY", "WHITESPACE"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY_KEY=5;
	public static final int ASSIGN=6;
	public static final int AST_2D_ARRAY=7;
	public static final int AST_BLOCK=8;
	public static final int AST_EXPR_LIST=9;
	public static final int AST_EXPR_PAREN=10;
	public static final int AST_FUNC_CALL=11;
	public static final int AST_ID_LIST=12;
	public static final int AST_PARAM_LIST=13;
	public static final int AST_RETURN_STAT=14;
	public static final int BEGIN_KEY=15;
	public static final int BREAK_KEY=16;
	public static final int CARRAGE_RET=17;
	public static final int COLON=18;
	public static final int COMMA=19;
	public static final int COMMENT=20;
	public static final int DIV=21;
	public static final int DO_KEY=22;
	public static final int ELSE_KEY=23;
	public static final int ENDDO_KEY=24;
	public static final int ENDIF_KEY=25;
	public static final int END_KEY=26;
	public static final int EQ=27;
	public static final int FIXEDPT_KEY=28;
	public static final int FOR_KEY=29;
	public static final int FUNCTION_KEY=30;
	public static final int GREATER=31;
	public static final int GREATEREQ=32;
	public static final int ID=33;
	public static final int ID_KEY=34;
	public static final int IF_KEY=35;
	public static final int INT_KEY=36;
	public static final int LBRACK=37;
	public static final int LESSER=38;
	public static final int LESSEREQ=39;
	public static final int LPAREN=40;
	public static final int MAIN_KEY=41;
	public static final int MINUS=42;
	public static final int MULT=43;
	public static final int NEQ=44;
	public static final int NEWLINE=45;
	public static final int OF_KEY=46;
	public static final int OR=47;
	public static final int PLUS=48;
	public static final int RBRACK=49;
	public static final int RETURN_KEY=50;
	public static final int RPAREN=51;
	public static final int SEMI=52;
	public static final int TAB=53;
	public static final int THEN_KEY=54;
	public static final int TO_KEY=55;
	public static final int TYPE_KEY=56;
	public static final int UNSIGNED_FIXEDPTLIT=57;
	public static final int UNSIGNED_INTLIT=58;
	public static final int VAR_KEY=59;
	public static final int VOID_KEY=60;
	public static final int WHILE_KEY=61;
	public static final int WHITESPACE=62;

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
	@Override public String getGrammarFileName() { return "/Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g"; }


	  private String func_name;
	  private SymbolTable symbolTable = new SymbolTable(); 
	  private List<String> irOutput = new ArrayList<String>();
	  private int currentTemp = 0;
	  private Scope GLOBAL_SCOPE = new Scope();
	  private Scope CURRENT_SCOPE = GLOBAL_SCOPE;

	  private static void outln(Object obj) {
	    System.out.println(obj);
	  }

		@Override
		public void reportError(RecognitionException e) {
			displayRecognitionError(this.getTokenNames(), e);
		}
		
		/**
		* makes a 1D array of either an Integer or Double type
		* @param s the string "int" or "fixedpt"
		* @param width the length of the array 
		* @param value the initial value that will be converted to either an integer or double
		* @return either an Integer or Double array initialized
		**/
		public Object[] make1DArray(String s, Integer width, String value) {
		  if (s.equals("int")){
		    //toInteger method defined below
		    Integer val = toInteger(value);
	      Integer[] IntArray = new Integer[width];
	      for (int i = 0; i < width; i++) {
	         IntArray[i] = val;
	      }
	      return IntArray;
	    } else if (s.equals("fixedpt")) {
	      Double val = toDouble(value);
	      Double[] DoubleArray = new Double[width];
	      for (int i = 0; i < width; i++) {
	        DoubleArray[i] = val;
	      }
	      return DoubleArray;
	    }
	    return null;
		}
		
	  /**
	  * makes a 2D array of either an Integer or Double type
	  * @param s the string "int" or "fixedpt"
	  * @param width the width, or x component, of the array 
	  * @param height the height, or y component, of the array
	  * @param value the initial value that will be converted to either an integer or double
	  * @return either an Integer or Double array initialized
	  **/
		public Object[][] make2DArray(String s, Integer width, Integer height, String value) {
		  if (s.equals("int")){
		    //toInteger method defined below
		    Integer val = toInteger(value);
		    Integer[][] IntArray = new Integer[width][height];
		    for (int i = 0; i < width; i++) {
		      for (int j = 0; j < height; j++) {
		        IntArray[i][j] = val;
		      }
		    }
		    return IntArray;
		  } else if (s.equals("fixedpt")) {
		    Double val = toDouble(value);
		    Double[][] DoubleArray = new Double[width][height];
		    for (int i = 0; i < width; i++) {
		      for (int j = 0; j < height; j++) {
		        DoubleArray[i][j] = val;
		      }
		    }
		    return DoubleArray;
		  }
		  return null;
		}
		
		public Double toDouble(String s) {
			double value = Double.parseDouble(s);
			return new Double(value);
		}
		
		public Integer toInteger(String s) {
			int value;
			value = Integer.parseInt(s);
			return new Integer(value); 
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
		
		// Checks if 'void main()' was the last signature declared
		private void mainCheck(CommonTree parseTree) {
			if (!parseTree.getChildren().get(parseTree.getChildren().size() - 1).toString().equals("main"))
			{
				// It wasn't found or wasn't the last function
				throw new RuntimeException("Error: main must be in your program, and must be the last function declared");
			}
		}


	public static class tiger_program_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:197:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:198:2: ( type_declaration_list funct_declaration_list )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:198:4: type_declaration_list funct_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_tiger_program113);
			type_declaration_list1=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list1.getTree());

			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program115);
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:201:1: funct_declaration_list : ( funct_declaration )+ ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:202:2: ( ( funct_declaration )+ )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:202:4: ( funct_declaration )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:202:4: ( funct_declaration )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY||LA1_0==VOID_KEY) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:202:4: funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list127);
					funct_declaration3=funct_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, funct_declaration3.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:205:1: funct_declaration : ( return_func | void_func );
	public final tigerParser.funct_declaration_return funct_declaration() throws RecognitionException {
		tigerParser.funct_declaration_return retval = new tigerParser.funct_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope return_func4 =null;
		ParserRuleReturnScope void_func5 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:206:2: ( return_func | void_func )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==FIXEDPT_KEY||LA2_0==ID||LA2_0==INT_KEY) ) {
				alt2=1;
			}
			else if ( (LA2_0==VOID_KEY) ) {
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
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:206:4: return_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_return_func_in_funct_declaration139);
					return_func4=return_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, return_func4.getTree());

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:207:4: void_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_void_func_in_funct_declaration144);
					void_func5=void_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, void_func5.getTree());

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
	// $ANTLR end "funct_declaration"


	public static class return_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "return_func"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:210:1: return_func : type_id FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID type_id param_list block_list ) ;
	public final tigerParser.return_func_return return_func() throws RecognitionException {
		tigerParser.return_func_return retval = new tigerParser.return_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FUNCTION_KEY7=null;
		Token ID8=null;
		Token LPAREN9=null;
		Token RPAREN11=null;
		ParserRuleReturnScope type_id6 =null;
		ParserRuleReturnScope param_list10 =null;
		ParserRuleReturnScope begin12 =null;
		ParserRuleReturnScope block_list13 =null;
		ParserRuleReturnScope block_end14 =null;

		CommonTree FUNCTION_KEY7_tree=null;
		CommonTree ID8_tree=null;
		CommonTree LPAREN9_tree=null;
		CommonTree RPAREN11_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_FUNCTION_KEY=new RewriteRuleTokenStream(adaptor,"token FUNCTION_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:211:2: ( type_id FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID type_id param_list block_list ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:211:4: type_id FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end
			{
			pushFollow(FOLLOW_type_id_in_return_func156);
			type_id6=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_id.add(type_id6.getTree());
			FUNCTION_KEY7=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_return_func158); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FUNCTION_KEY.add(FUNCTION_KEY7);

			ID8=(Token)match(input,ID,FOLLOW_ID_in_return_func160); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID8);

			if ( state.backtracking==0 ) {func_name = (ID8!=null?ID8.getText():null);}
			LPAREN9=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_return_func164); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN9);

			pushFollow(FOLLOW_param_list_in_return_func166);
			param_list10=param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_param_list.add(param_list10.getTree());
			RPAREN11=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_return_func168); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN11);

			pushFollow(FOLLOW_begin_in_return_func170);
			begin12=begin();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_begin.add(begin12.getTree());
			pushFollow(FOLLOW_block_list_in_return_func172);
			block_list13=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_list.add(block_list13.getTree());
			pushFollow(FOLLOW_block_end_in_return_func174);
			block_end14=block_end();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_end.add(block_end14.getTree());
			if ( state.backtracking==0 ) {
			      	    		symbolTable.put(new FunctionSymbolTableEntry(CURRENT_SCOPE, (ID8!=null?ID8.getText():null), (type_id6!=null?input.toString(type_id6.start,type_id6.stop):null)));	
			      	    		irOutput.add(IRGenerator.funct_declaration(func_name));
			      	    		
			      	    		CURRENT_SCOPE = new Scope(CURRENT_SCOPE, (ID8!=null?ID8.getText():null));
			      		}
			// AST REWRITE
			// elements: param_list, block_list, ID, type_id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 218:2: -> ^( ID type_id param_list block_list )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:218:5: ^( ID type_id param_list block_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
				adaptor.addChild(root_1, stream_type_id.nextTree());
				adaptor.addChild(root_1, stream_param_list.nextTree());
				adaptor.addChild(root_1, stream_block_list.nextTree());
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
		return retval;
	}
	// $ANTLR end "return_func"


	public static class void_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "void_func"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:221:1: void_func : ( ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID VOID_KEY param_list block_list ) | VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end -> ^( MAIN_KEY block_list ) );
	public final tigerParser.void_func_return void_func() throws RecognitionException {
		tigerParser.void_func_return retval = new tigerParser.void_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY15=null;
		Token FUNCTION_KEY16=null;
		Token ID17=null;
		Token LPAREN18=null;
		Token RPAREN20=null;
		Token VOID_KEY24=null;
		Token MAIN_KEY25=null;
		Token LPAREN26=null;
		Token RPAREN27=null;
		ParserRuleReturnScope param_list19 =null;
		ParserRuleReturnScope begin21 =null;
		ParserRuleReturnScope block_list22 =null;
		ParserRuleReturnScope block_end23 =null;
		ParserRuleReturnScope begin28 =null;
		ParserRuleReturnScope block_list29 =null;
		ParserRuleReturnScope block_end30 =null;

		CommonTree VOID_KEY15_tree=null;
		CommonTree FUNCTION_KEY16_tree=null;
		CommonTree ID17_tree=null;
		CommonTree LPAREN18_tree=null;
		CommonTree RPAREN20_tree=null;
		CommonTree VOID_KEY24_tree=null;
		CommonTree MAIN_KEY25_tree=null;
		CommonTree LPAREN26_tree=null;
		CommonTree RPAREN27_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_VOID_KEY=new RewriteRuleTokenStream(adaptor,"token VOID_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_FUNCTION_KEY=new RewriteRuleTokenStream(adaptor,"token FUNCTION_KEY");
		RewriteRuleTokenStream stream_MAIN_KEY=new RewriteRuleTokenStream(adaptor,"token MAIN_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:222:2: ( ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID VOID_KEY param_list block_list ) | VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end -> ^( MAIN_KEY block_list ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==VOID_KEY) ) {
				int LA3_1 = input.LA(2);
				if ( (synpred1_tiger()) ) {
					alt3=1;
				}
				else if ( (true) ) {
					alt3=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:222:4: ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end
					{
					VOID_KEY15=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_void_func210); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VOID_KEY.add(VOID_KEY15);

					FUNCTION_KEY16=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_void_func212); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUNCTION_KEY.add(FUNCTION_KEY16);

					ID17=(Token)match(input,ID,FOLLOW_ID_in_void_func214); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID17);

					if ( state.backtracking==0 ) {func_name = (ID17!=null?ID17.getText():null);}
					LPAREN18=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_void_func218); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN18);

					pushFollow(FOLLOW_param_list_in_void_func220);
					param_list19=param_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param_list.add(param_list19.getTree());
					RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_void_func222); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN20);

					pushFollow(FOLLOW_begin_in_void_func224);
					begin21=begin();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_begin.add(begin21.getTree());
					pushFollow(FOLLOW_block_list_in_void_func226);
					block_list22=block_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_list.add(block_list22.getTree());
					pushFollow(FOLLOW_block_end_in_void_func228);
					block_end23=block_end();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_end.add(block_end23.getTree());
					if ( state.backtracking==0 ) {
								symbolTable.put(new FunctionSymbolTableEntry(CURRENT_SCOPE, (ID17!=null?ID17.getText():null), (VOID_KEY15!=null?VOID_KEY15.getText():null)));
								irOutput.add(IRGenerator.funct_declaration(func_name));
								
								CURRENT_SCOPE = new Scope(CURRENT_SCOPE, (ID17!=null?ID17.getText():null));
							}
					// AST REWRITE
					// elements: VOID_KEY, ID, param_list, block_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 229:2: -> ^( ID VOID_KEY param_list block_list )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:229:5: ^( ID VOID_KEY param_list block_list )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
						adaptor.addChild(root_1, stream_VOID_KEY.nextNode());
						adaptor.addChild(root_1, stream_param_list.nextTree());
						adaptor.addChild(root_1, stream_block_list.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:231:4: VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end
					{
					VOID_KEY24=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_void_func254); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VOID_KEY.add(VOID_KEY24);

					MAIN_KEY25=(Token)match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_void_func256); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MAIN_KEY.add(MAIN_KEY25);

					if ( state.backtracking==0 ) {func_name = (MAIN_KEY25!=null?MAIN_KEY25.getText():null);}
					LPAREN26=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_void_func260); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN26);

					RPAREN27=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_void_func262); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN27);

					pushFollow(FOLLOW_begin_in_void_func264);
					begin28=begin();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_begin.add(begin28.getTree());
					pushFollow(FOLLOW_block_list_in_void_func266);
					block_list29=block_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_list.add(block_list29.getTree());
					pushFollow(FOLLOW_block_end_in_void_func268);
					block_end30=block_end();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_end.add(block_end30.getTree());
					if ( state.backtracking==0 ) {
					     			symbolTable.put(new FunctionSymbolTableEntry(CURRENT_SCOPE, (MAIN_KEY25!=null?MAIN_KEY25.getText():null), (VOID_KEY24!=null?VOID_KEY24.getText():null)));
					     			irOutput.add(IRGenerator.funct_declaration(func_name));
					     			
								CURRENT_SCOPE = new Scope(CURRENT_SCOPE, (MAIN_KEY25!=null?MAIN_KEY25.getText():null)); 
					            	}
					// AST REWRITE
					// elements: block_list, MAIN_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 238:2: -> ^( MAIN_KEY block_list )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:238:5: ^( MAIN_KEY block_list )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_MAIN_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_block_list.nextTree());
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
		return retval;
	}
	// $ANTLR end "void_func"


	public static class block_end_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block_end"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:241:1: block_end : END_KEY SEMI ;
	public final tigerParser.block_end_return block_end() throws RecognitionException {
		tigerParser.block_end_return retval = new tigerParser.block_end_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token END_KEY31=null;
		Token SEMI32=null;

		CommonTree END_KEY31_tree=null;
		CommonTree SEMI32_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:242:2: ( END_KEY SEMI )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:242:4: END_KEY SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			END_KEY31=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_block_end293); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			END_KEY31_tree = (CommonTree)adaptor.create(END_KEY31);
			adaptor.addChild(root_0, END_KEY31_tree);
			}

			SEMI32=(Token)match(input,SEMI,FOLLOW_SEMI_in_block_end295); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SEMI32_tree = (CommonTree)adaptor.create(SEMI32);
			adaptor.addChild(root_0, SEMI32_tree);
			}

			if ( state.backtracking==0 ) {
						if (CURRENT_SCOPE != GLOBAL_SCOPE) {
							CURRENT_SCOPE = CURRENT_SCOPE.getParent();
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
	// $ANTLR end "block_end"


	public static class ret_type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret_type"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:250:1: ret_type : ( VOID_KEY | type_id );
	public final tigerParser.ret_type_return ret_type() throws RecognitionException {
		tigerParser.ret_type_return retval = new tigerParser.ret_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY33=null;
		ParserRuleReturnScope type_id34 =null;

		CommonTree VOID_KEY33_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:251:2: ( VOID_KEY | type_id )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==VOID_KEY) ) {
				alt4=1;
			}
			else if ( (LA4_0==FIXEDPT_KEY||LA4_0==ID||LA4_0==INT_KEY) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:251:4: VOID_KEY
					{
					root_0 = (CommonTree)adaptor.nil();


					VOID_KEY33=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type311); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VOID_KEY33_tree = (CommonTree)adaptor.create(VOID_KEY33);
					adaptor.addChild(root_0, VOID_KEY33_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:252:4: type_id
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_id_in_ret_type316);
					type_id34=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id34.getTree());

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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:255:1: param_list : ( param ( COMMA param )* )? -> ^( AST_PARAM_LIST ( ( param )+ )? ) ;
	public final tigerParser.param_list_return param_list() throws RecognitionException {
		tigerParser.param_list_return retval = new tigerParser.param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA36=null;
		ParserRuleReturnScope param35 =null;
		ParserRuleReturnScope param37 =null;

		CommonTree COMMA36_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:256:2: ( ( param ( COMMA param )* )? -> ^( AST_PARAM_LIST ( ( param )+ )? ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:256:4: ( param ( COMMA param )* )?
			{
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:256:4: ( param ( COMMA param )* )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:256:5: param ( COMMA param )*
					{
					pushFollow(FOLLOW_param_in_param_list329);
					param35=param();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param.add(param35.getTree());
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:256:11: ( COMMA param )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:256:12: COMMA param
							{
							COMMA36=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list332); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA36);

							pushFollow(FOLLOW_param_in_param_list334);
							param37=param();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_param.add(param37.getTree());
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;

			}

			// AST REWRITE
			// elements: param
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 257:2: -> ^( AST_PARAM_LIST ( ( param )+ )? )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:257:5: ^( AST_PARAM_LIST ( ( param )+ )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_PARAM_LIST, "AST_PARAM_LIST"), root_1);
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:257:22: ( ( param )+ )?
				if ( stream_param.hasNext() ) {
					if ( !(stream_param.hasNext()) ) {
						throw new RewriteEarlyExitException();
					}
					while ( stream_param.hasNext() ) {
						adaptor.addChild(root_1, stream_param.nextTree());
					}
					stream_param.reset();

				}
				stream_param.reset();

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
		return retval;
	}
	// $ANTLR end "param_list"


	public static class param_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:260:1: param : ID COLON type_id -> ^( COLON ID type_id ) ;
	public final tigerParser.param_return param() throws RecognitionException {
		tigerParser.param_return retval = new tigerParser.param_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID38=null;
		Token COLON39=null;
		ParserRuleReturnScope type_id40 =null;

		CommonTree ID38_tree=null;
		CommonTree COLON39_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:261:3: ( ID COLON type_id -> ^( COLON ID type_id ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:261:5: ID COLON type_id
			{
			ID38=(Token)match(input,ID,FOLLOW_ID_in_param365); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID38);

			COLON39=(Token)match(input,COLON,FOLLOW_COLON_in_param367); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON39);

			pushFollow(FOLLOW_type_id_in_param369);
			type_id40=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_id.add(type_id40.getTree());
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
			// 262:2: -> ^( COLON ID type_id )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:262:5: ^( COLON ID type_id )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_COLON.nextNode(), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
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
		return retval;
	}
	// $ANTLR end "param"


	public static class block_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block_list"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:265:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block41 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:266:2: ( ( block )+ )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:266:4: ( block )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:266:4: ( block )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==BEGIN_KEY) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:266:4: block
					{
					pushFollow(FOLLOW_block_in_block_list391);
					block41=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block41.getTree());

					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:269:1: block : begin ( declaration_statement stat_seq ) block_end -> ^( AST_BLOCK ( declaration_statement )? stat_seq ) ;
	public final tigerParser.block_return block() throws RecognitionException {
		tigerParser.block_return retval = new tigerParser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope begin42 =null;
		ParserRuleReturnScope declaration_statement43 =null;
		ParserRuleReturnScope stat_seq44 =null;
		ParserRuleReturnScope block_end45 =null;

		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_declaration_statement=new RewriteRuleSubtreeStream(adaptor,"rule declaration_statement");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:270:4: ( begin ( declaration_statement stat_seq ) block_end -> ^( AST_BLOCK ( declaration_statement )? stat_seq ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:270:6: begin ( declaration_statement stat_seq ) block_end
			{
			pushFollow(FOLLOW_begin_in_block407);
			begin42=begin();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_begin.add(begin42.getTree());
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:270:12: ( declaration_statement stat_seq )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:270:13: declaration_statement stat_seq
			{
			pushFollow(FOLLOW_declaration_statement_in_block410);
			declaration_statement43=declaration_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declaration_statement.add(declaration_statement43.getTree());
			pushFollow(FOLLOW_stat_seq_in_block412);
			stat_seq44=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq44.getTree());
			}

			pushFollow(FOLLOW_block_end_in_block415);
			block_end45=block_end();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_end.add(block_end45.getTree());
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
			// 271:2: -> ^( AST_BLOCK ( declaration_statement )? stat_seq )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:271:6: ^( AST_BLOCK ( declaration_statement )? stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_BLOCK, "AST_BLOCK"), root_1);
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:271:18: ( declaration_statement )?
				if ( stream_declaration_statement.hasNext() ) {
					adaptor.addChild(root_1, stream_declaration_statement.nextTree());
				}
				stream_declaration_statement.reset();

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
		return retval;
	}
	// $ANTLR end "block"


	public static class begin_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "begin"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:274:1: begin : BEGIN_KEY ;
	public final tigerParser.begin_return begin() throws RecognitionException {
		tigerParser.begin_return retval = new tigerParser.begin_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BEGIN_KEY46=null;

		CommonTree BEGIN_KEY46_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:275:3: ( BEGIN_KEY )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:275:5: BEGIN_KEY
			{
			root_0 = (CommonTree)adaptor.nil();


			BEGIN_KEY46=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_begin441); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BEGIN_KEY46_tree = (CommonTree)adaptor.create(BEGIN_KEY46);
			adaptor.addChild(root_0, BEGIN_KEY46_tree);
			}

			if ( state.backtracking==0 ) {
			    CURRENT_SCOPE = new Scope(CURRENT_SCOPE, func_name);
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
	// $ANTLR end "begin"


	public static class declaration_statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration_statement"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:279:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list47 =null;
		ParserRuleReturnScope var_declaration_list48 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:280:2: ( type_declaration_list var_declaration_list )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:280:4: type_declaration_list var_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement455);
			type_declaration_list47=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list47.getTree());

			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement457);
			var_declaration_list48=var_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration_list48.getTree());

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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:283:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration49 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:284:2: ( ( type_declaration )* )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:284:5: ( type_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:284:5: ( type_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TYPE_KEY) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:284:5: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list471);
					type_declaration49=type_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration49.getTree());

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
	// $ANTLR end "type_declaration_list"


	public static class var_declaration_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_declaration_list"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:287:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_declaration50 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:288:2: ( ( var_declaration )* )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:288:4: ( var_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:288:4: ( var_declaration )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==VAR_KEY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:288:4: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list485);
					var_declaration50=var_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration50.getTree());

					}
					break;

				default :
					break loop9;
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:291:1: type_declaration : TYPE_KEY ID EQ type[$ID.text] SEMI -> ^( EQ ID type ) ;
	public final tigerParser.type_declaration_return type_declaration() throws RecognitionException {
		tigerParser.type_declaration_return retval = new tigerParser.type_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TYPE_KEY51=null;
		Token ID52=null;
		Token EQ53=null;
		Token SEMI55=null;
		ParserRuleReturnScope type54 =null;

		CommonTree TYPE_KEY51_tree=null;
		CommonTree ID52_tree=null;
		CommonTree EQ53_tree=null;
		CommonTree SEMI55_tree=null;
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleTokenStream stream_TYPE_KEY=new RewriteRuleTokenStream(adaptor,"token TYPE_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:292:2: ( TYPE_KEY ID EQ type[$ID.text] SEMI -> ^( EQ ID type ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:292:4: TYPE_KEY ID EQ type[$ID.text] SEMI
			{
			TYPE_KEY51=(Token)match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration498); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TYPE_KEY.add(TYPE_KEY51);

			ID52=(Token)match(input,ID,FOLLOW_ID_in_type_declaration500); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID52);

			EQ53=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration502); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EQ.add(EQ53);

			pushFollow(FOLLOW_type_in_type_declaration504);
			type54=type((ID52!=null?ID52.getText():null));
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(type54.getTree());
			SEMI55=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration507); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI55);

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
			// 293:2: -> ^( EQ ID type )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:293:5: ^( EQ ID type )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_EQ.nextNode(), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
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
		return retval;
	}
	// $ANTLR end "type_declaration"


	public static class type_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:296:1: type[String id] : ( base_type | ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id ) | ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY UNSIGNED_INTLIT type_id ) );
	public final tigerParser.type_return type(String id) throws RecognitionException {
		tigerParser.type_return retval = new tigerParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token var1=null;
		Token var2=null;
		Token ARRAY_KEY57=null;
		Token LBRACK58=null;
		Token RBRACK59=null;
		Token LBRACK60=null;
		Token RBRACK61=null;
		Token OF_KEY62=null;
		Token ARRAY_KEY64=null;
		Token LBRACK65=null;
		Token UNSIGNED_INTLIT66=null;
		Token RBRACK67=null;
		Token OF_KEY68=null;
		ParserRuleReturnScope base_type56 =null;
		ParserRuleReturnScope type_id63 =null;
		ParserRuleReturnScope type_id69 =null;

		CommonTree var1_tree=null;
		CommonTree var2_tree=null;
		CommonTree ARRAY_KEY57_tree=null;
		CommonTree LBRACK58_tree=null;
		CommonTree RBRACK59_tree=null;
		CommonTree LBRACK60_tree=null;
		CommonTree RBRACK61_tree=null;
		CommonTree OF_KEY62_tree=null;
		CommonTree ARRAY_KEY64_tree=null;
		CommonTree LBRACK65_tree=null;
		CommonTree UNSIGNED_INTLIT66_tree=null;
		CommonTree RBRACK67_tree=null;
		CommonTree OF_KEY68_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_OF_KEY=new RewriteRuleTokenStream(adaptor,"token OF_KEY");
		RewriteRuleTokenStream stream_ARRAY_KEY=new RewriteRuleTokenStream(adaptor,"token ARRAY_KEY");
		RewriteRuleTokenStream stream_UNSIGNED_INTLIT=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTLIT");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:297:3: ( base_type | ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id ) | ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY UNSIGNED_INTLIT type_id ) )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==FIXEDPT_KEY||LA10_0==INT_KEY) ) {
				alt10=1;
			}
			else if ( (LA10_0==ARRAY_KEY) ) {
				int LA10_2 = input.LA(2);
				if ( (synpred2_tiger()) ) {
					alt10=2;
				}
				else if ( (true) ) {
					alt10=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:297:5: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type534);
					base_type56=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type56.getTree());

					if ( state.backtracking==0 ) {
					    if ((base_type56!=null?input.toString(base_type56.start,base_type56.stop):null).equals("int")) { 
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,id.replaceAll("\\s",""), TigerPrimitive.INT));
					    } else if ((base_type56!=null?input.toString(base_type56.start,base_type56.stop):null).equals("fixedpt")) {
					      System.out.println("about to add");
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,id.replaceAll("\\s",""), TigerPrimitive.FIXEDPT));
					      System.out.println("added");
					    }
					  }
					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:306:4: ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY type_id
					{
					ARRAY_KEY57=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type562); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARRAY_KEY.add(ARRAY_KEY57);

					LBRACK58=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type564); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK58);

					var1=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_type568); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(var1);

					RBRACK59=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type570); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK59);

					LBRACK60=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type572); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK60);

					var2=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_type576); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(var2);

					RBRACK61=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type578); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK61);

					OF_KEY62=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type580); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OF_KEY.add(OF_KEY62);

					pushFollow(FOLLOW_type_id_in_type582);
					type_id63=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id63.getTree());
					if ( state.backtracking==0 ) {
						  if ((type_id63!=null?input.toString(type_id63.start,type_id63.stop):null).equals("int")) { 
						    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,id.replaceAll("\\s",""), TigerPrimitive.INT_2D_ARRAY, toInteger((var1!=null?var1.getText():null)),toInteger((var2!=null?var2.getText():null))));
						  } else if ((type_id63!=null?input.toString(type_id63.start,type_id63.stop):null).equals("fixedpt")) {
						    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,id.replaceAll("\\s",""), TigerPrimitive.FIXEDPT_2D_ARRAY, toInteger((var1!=null?var1.getText():null)),toInteger((var2!=null?var2.getText():null))));
						  }
						}
					// AST REWRITE
					// elements: type_id, UNSIGNED_INTLIT, UNSIGNED_INTLIT, ARRAY_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 314:2: -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:314:5: ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ARRAY_KEY.nextNode(), root_1);
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:314:17: ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_2D_ARRAY, "AST_2D_ARRAY"), root_2);
						adaptor.addChild(root_2, stream_UNSIGNED_INTLIT.nextNode());
						adaptor.addChild(root_2, stream_UNSIGNED_INTLIT.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_type_id.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:315:4: ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id
					{
					ARRAY_KEY64=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type606); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARRAY_KEY.add(ARRAY_KEY64);

					LBRACK65=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type608); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK65);

					UNSIGNED_INTLIT66=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_type610); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(UNSIGNED_INTLIT66);

					RBRACK67=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type612); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK67);

					OF_KEY68=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type614); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OF_KEY.add(OF_KEY68);

					pushFollow(FOLLOW_type_id_in_type616);
					type_id69=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id69.getTree());
					if ( state.backtracking==0 ) {
						  if ((type_id69!=null?input.toString(type_id69.start,type_id69.stop):null).equals("int")) { 
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,id.replaceAll("\\s",""), TigerPrimitive.INT_ARRAY, toInteger((UNSIGNED_INTLIT66!=null?UNSIGNED_INTLIT66.getText():null))));
					    } else if ((type_id69!=null?input.toString(type_id69.start,type_id69.stop):null).equals("fixedpt")) {
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,id.replaceAll("\\s",""), TigerPrimitive.FIXEDPT_ARRAY, toInteger((UNSIGNED_INTLIT66!=null?UNSIGNED_INTLIT66.getText():null))));
					    }
						}
					// AST REWRITE
					// elements: ARRAY_KEY, type_id, UNSIGNED_INTLIT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 322:2: -> ^( ARRAY_KEY UNSIGNED_INTLIT type_id )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:322:5: ^( ARRAY_KEY UNSIGNED_INTLIT type_id )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ARRAY_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_UNSIGNED_INTLIT.nextNode());
						adaptor.addChild(root_1, stream_type_id.nextTree());
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
		return retval;
	}
	// $ANTLR end "type"


	public static class type_id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:325:1: type_id : ( base_type | ID );
	public final tigerParser.type_id_return type_id() throws RecognitionException {
		tigerParser.type_id_return retval = new tigerParser.type_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID71=null;
		ParserRuleReturnScope base_type70 =null;

		CommonTree ID71_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:326:3: ( base_type | ID )
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
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:326:5: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type_id642);
					base_type70=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type70.getTree());

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:327:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID71=(Token)match(input,ID,FOLLOW_ID_in_type_id647); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID71_tree = (CommonTree)adaptor.create(ID71);
					adaptor.addChild(root_0, ID71_tree);
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:330:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set72=null;

		CommonTree set72_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:331:2: ( INT_KEY | FIXEDPT_KEY )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set72=input.LT(1);
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set72));
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:335:1: var_declaration : ( ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit ) | ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT ) | VAR_KEY id_list COLON type_id SEMI -> ^( COLON id_list type_id ) );
	public final tigerParser.var_declaration_return var_declaration() throws RecognitionException {
		tigerParser.var_declaration_return retval = new tigerParser.var_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VAR_KEY73=null;
		Token COLON75=null;
		Token ASSIGN77=null;
		Token SEMI79=null;
		Token VAR_KEY80=null;
		Token COLON82=null;
		Token ASSIGN84=null;
		Token UNSIGNED_INTLIT85=null;
		Token SEMI86=null;
		Token VAR_KEY87=null;
		Token COLON89=null;
		Token SEMI91=null;
		ParserRuleReturnScope id_list74 =null;
		ParserRuleReturnScope type_id76 =null;
		ParserRuleReturnScope fixedptlit78 =null;
		ParserRuleReturnScope id_list81 =null;
		ParserRuleReturnScope type_id83 =null;
		ParserRuleReturnScope id_list88 =null;
		ParserRuleReturnScope type_id90 =null;

		CommonTree VAR_KEY73_tree=null;
		CommonTree COLON75_tree=null;
		CommonTree ASSIGN77_tree=null;
		CommonTree SEMI79_tree=null;
		CommonTree VAR_KEY80_tree=null;
		CommonTree COLON82_tree=null;
		CommonTree ASSIGN84_tree=null;
		CommonTree UNSIGNED_INTLIT85_tree=null;
		CommonTree SEMI86_tree=null;
		CommonTree VAR_KEY87_tree=null;
		CommonTree COLON89_tree=null;
		CommonTree SEMI91_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_VAR_KEY=new RewriteRuleTokenStream(adaptor,"token VAR_KEY");
		RewriteRuleTokenStream stream_UNSIGNED_INTLIT=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTLIT");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_fixedptlit=new RewriteRuleSubtreeStream(adaptor,"rule fixedptlit");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:336:2: ( ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit ) | ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT ) | VAR_KEY id_list COLON type_id SEMI -> ^( COLON id_list type_id ) )
			int alt12=3;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==VAR_KEY) ) {
				int LA12_1 = input.LA(2);
				if ( (synpred3_tiger()) ) {
					alt12=1;
				}
				else if ( (synpred4_tiger()) ) {
					alt12=2;
				}
				else if ( (true) ) {
					alt12=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:336:4: ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI
					{
					VAR_KEY73=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration691); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VAR_KEY.add(VAR_KEY73);

					pushFollow(FOLLOW_id_list_in_var_declaration693);
					id_list74=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list74.getTree());
					COLON75=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration695); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON75);

					pushFollow(FOLLOW_type_id_in_var_declaration697);
					type_id76=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id76.getTree());
					ASSIGN77=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration699); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN77);

					pushFollow(FOLLOW_fixedptlit_in_var_declaration701);
					fixedptlit78=fixedptlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fixedptlit.add(fixedptlit78.getTree());
					SEMI79=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration703); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI79);

					if ( state.backtracking==0 ) {   
						  	String idlist = (id_list74!=null?input.toString(id_list74.start,id_list74.stop):null); 
					    		String[] ids = idlist.split(",");
					    		// Check if it's not a base type
					    		if (!((type_id76!=null?input.toString(type_id76.start,type_id76.stop):null).equals("int") && (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null).equals("fixedpt"))) {
					    		  // Gets the type and makes the variables for INT_ARRAY, INT_2D_ARRAY, and INT
					    		  SymbolTableEntry type = symbolTable.get((type_id76!=null?input.toString(type_id76.start,type_id76.stop):null), CURRENT_SCOPE);
					    		  
					    		  if (type != null && type instanceof TypeSymbolTableEntry) {
					    		  
					    		    switch (((TypeSymbolTableEntry) type).getBackingType()) {
					    		    
					    		    case FIXEDPT_ARRAY:
					    		      // Instantiates the 1D array
					    		      Double[] fpArray = (Double[]) make1DArray("fixedpt", 
					    		        ((TypeSymbolTableEntry) type).getWidth(), (fixedptlit78!=null?input.toString(fixedptlit78.start,fixedptlit78.stop):null));
					          
					    		      for (String id: ids) {
					    		        // Gets rid of white space and adds to symbol table
					    		        symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					    		          id.replaceAll("\\s",""), 
					    		          fpArray, (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null)));
					    		      }
					          
					    		    break;
					    		    
					    		    case FIXEDPT_2D_ARRAY:
					             // Instantiates the 2D array
					             Double[][] fp2DArray = (Double[][]) make2DArray("fixedpt", 
					               ((TypeSymbolTableEntry) type).getWidth(), 
					               ((TypeSymbolTableEntry) type).getHeight(), (fixedptlit78!=null?input.toString(fixedptlit78.start,fixedptlit78.stop):null));
					             for (String id: ids) {
					                // Gets rid of white space and adds to symbol table
					                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					                  id.replaceAll("\\s",""), 
					                  fp2DArray, (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null)));
					             }
					          
					            break;
					            
					            case FIXEDPT:
					              for (String id: ids) {
					              // Gets rid of white space and adds to symbol table
					              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					                id.replaceAll("\\s",""), 
					                toDouble((fixedptlit78!=null?input.toString(fixedptlit78.start,fixedptlit78.stop):null)), (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null)));
					              }
					          
					            break;
					          
					            default:
					              System.out.println("The type " + (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null) + " on line " + (type_id76!=null?(type_id76.start):null).getLine()
					              + " is not of type int");
					          
					            break;
					            
					    		    }
					    		  } else {
					    		    System.out.println("The type " + (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null) + 
					    		      " does not exist or is not in an accessible scope from " 
					    		      + (id_list74!=null?input.toString(id_list74.start,id_list74.stop):null) + " on line " + (type_id76!=null?(type_id76.start):null).getLine());
					    		  }
					    		} else {
					    		  for (String id: ids) {
					      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, id.replaceAll("\\s",""), toDouble((fixedptlit78!=null?input.toString(fixedptlit78.start,fixedptlit78.stop):null))));
					      		}
					      	}
					      	
						}
					// AST REWRITE
					// elements: fixedptlit, id_list, ASSIGN, type_id, COLON
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 406:2: -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:406:5: ^( ASSIGN ^( COLON id_list type_id ) fixedptlit )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:406:14: ^( COLON id_list type_id )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_COLON.nextNode(), root_2);
						adaptor.addChild(root_2, stream_id_list.nextTree());
						adaptor.addChild(root_2, stream_type_id.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_fixedptlit.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:407:4: ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI
					{
					VAR_KEY80=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration745); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VAR_KEY.add(VAR_KEY80);

					pushFollow(FOLLOW_id_list_in_var_declaration747);
					id_list81=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list81.getTree());
					COLON82=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration749); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON82);

					pushFollow(FOLLOW_type_id_in_var_declaration751);
					type_id83=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id83.getTree());
					ASSIGN84=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration753); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN84);

					UNSIGNED_INTLIT85=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_var_declaration755); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(UNSIGNED_INTLIT85);

					SEMI86=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration757); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI86);

					if ( state.backtracking==0 ) {
							String idlist = (id_list81!=null?input.toString(id_list81.start,id_list81.stop):null); 
							String[] ids = idlist.split(",");
							
							// Check if it's not a base type
							if (!((type_id83!=null?input.toString(type_id83.start,type_id83.stop):null).equals("int") && (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null).equals("fixedpt"))) {
								// Gets the type and makes the variables for INT_ARRAY, INT_2D_ARRAY, and INT
								SymbolTableEntry type = symbolTable.get((type_id83!=null?input.toString(type_id83.start,type_id83.stop):null), CURRENT_SCOPE);
								// Check existence
								if (type != null && type instanceof TypeSymbolTableEntry) {
									switch (((TypeSymbolTableEntry) type).getBackingType()) {
									
									case INT_ARRAY:
										// Instantiates the 1D array
										Integer[] intArray = (Integer[]) make1DArray("int", 
											((TypeSymbolTableEntry) type).getWidth(), (UNSIGNED_INTLIT85!=null?UNSIGNED_INTLIT85.getText():null));
										
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
											  symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
											    id.replaceAll("\\s",""), 
											    intArray, (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null)));
										}
										
										break;
										
									case INT_2D_ARRAY:
										// Instantiates the 2D array
										Integer[][] int2DArray = (Integer[][]) make2DArray("int", 
											((TypeSymbolTableEntry) type).getWidth(), 
											((TypeSymbolTableEntry) type).getHeight(), (UNSIGNED_INTLIT85!=null?UNSIGNED_INTLIT85.getText():null));
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
					              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					                id.replaceAll("\\s",""), 
					                int2DArray, (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null)));
										}
										
										break;
										
									case INT:
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
												symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
													id.replaceAll("\\s",""), 
													toInteger((UNSIGNED_INTLIT85!=null?UNSIGNED_INTLIT85.getText():null)), (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null)));
										}
										
										break;
										
									default:
										System.out.println("The type " + (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null) + " on line " + (type_id83!=null?(type_id83.start):null).getLine()
											+ " is not of type int");
										
										break;
									}
								} else {
									System.out.println("The type " + (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null) + 
										" does not exist or is not in an accessible scope from " 
										+ (id_list81!=null?input.toString(id_list81.start,id_list81.stop):null) + " on line " + (type_id83!=null?(type_id83.start):null).getLine());
								}
							} else {
								// Else, it's a primitive already
								for (String id: ids) {
									// Gets rid of white space and adds to symbol table
									symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
									id.replaceAll("\\s",""), toInteger((UNSIGNED_INTLIT85!=null?UNSIGNED_INTLIT85.getText():null))));
								}
					        }
					        	}
					// AST REWRITE
					// elements: COLON, id_list, UNSIGNED_INTLIT, ASSIGN, type_id
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 478:2: -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:478:5: ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:478:14: ^( COLON id_list type_id )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_COLON.nextNode(), root_2);
						adaptor.addChild(root_2, stream_id_list.nextTree());
						adaptor.addChild(root_2, stream_type_id.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_UNSIGNED_INTLIT.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:479:4: VAR_KEY id_list COLON type_id SEMI
					{
					VAR_KEY87=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration784); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VAR_KEY.add(VAR_KEY87);

					pushFollow(FOLLOW_id_list_in_var_declaration786);
					id_list88=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list88.getTree());
					COLON89=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration788); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON89);

					pushFollow(FOLLOW_type_id_in_var_declaration790);
					type_id90=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id90.getTree());
					SEMI91=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration792); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI91);

					if ( state.backtracking==0 ) {
					   		String idlist = (id_list88!=null?input.toString(id_list88.start,id_list88.stop):null); 
					    		String[] ids = idlist.split(",");
					    		for (String id: ids) {
					      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, id, new Integer(0)));
					    		}
					  	}
					// AST REWRITE
					// elements: COLON, type_id, id_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 487:2: -> ^( COLON id_list type_id )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:487:5: ^( COLON id_list type_id )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_COLON.nextNode(), root_1);
						adaptor.addChild(root_1, stream_id_list.nextTree());
						adaptor.addChild(root_1, stream_type_id.nextTree());
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
		return retval;
	}
	// $ANTLR end "var_declaration"


	public static class id_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:491:1: id_list : ID ( COMMA id_list )? -> ^( AST_ID_LIST ( ID )+ ) ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID92=null;
		Token COMMA93=null;
		ParserRuleReturnScope id_list94 =null;

		CommonTree ID92_tree=null;
		CommonTree COMMA93_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:492:3: ( ID ( COMMA id_list )? -> ^( AST_ID_LIST ( ID )+ ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:492:5: ID ( COMMA id_list )?
			{
			ID92=(Token)match(input,ID,FOLLOW_ID_in_id_list820); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID92);

			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:492:8: ( COMMA id_list )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==COMMA) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:492:9: COMMA id_list
					{
					COMMA93=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list823); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA93);

					pushFollow(FOLLOW_id_list_in_id_list825);
					id_list94=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list94.getTree());
					}
					break;

			}

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
			// 493:2: -> ^( AST_ID_LIST ( ID )+ )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:493:5: ^( AST_ID_LIST ( ID )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_ID_LIST, "AST_ID_LIST"), root_1);
				if ( !(stream_ID.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_ID.hasNext() ) {
					adaptor.addChild(root_1, stream_ID.nextNode());
				}
				stream_ID.reset();

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
		return retval;
	}
	// $ANTLR end "id_list"


	public static class stat_seq_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat_seq"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:496:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat95 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:497:2: ( ( stat )+ )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:497:4: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:497:4: ( stat )+
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
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:497:4: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq848);
					stat95=stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stat95.getTree());

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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:500:1: stat : ( if_stat | while_stat | for_stat | ( value ASSIGN )=> assign_stat | func_call SEMI !| break_stat | return_stat | block );
	public final tigerParser.stat_return stat() throws RecognitionException {
		tigerParser.stat_return retval = new tigerParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI101=null;
		ParserRuleReturnScope if_stat96 =null;
		ParserRuleReturnScope while_stat97 =null;
		ParserRuleReturnScope for_stat98 =null;
		ParserRuleReturnScope assign_stat99 =null;
		ParserRuleReturnScope func_call100 =null;
		ParserRuleReturnScope break_stat102 =null;
		ParserRuleReturnScope return_stat103 =null;
		ParserRuleReturnScope block104 =null;

		CommonTree SEMI101_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:501:2: ( if_stat | while_stat | for_stat | ( value ASSIGN )=> assign_stat | func_call SEMI !| break_stat | return_stat | block )
			int alt15=8;
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
				if ( (synpred5_tiger()) ) {
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
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:501:4: if_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_if_stat_in_stat860);
					if_stat96=if_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stat96.getTree());

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:502:4: while_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_while_stat_in_stat865);
					while_stat97=while_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stat97.getTree());

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:503:4: for_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_for_stat_in_stat870);
					for_stat98=for_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stat98.getTree());

					}
					break;
				case 4 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:504:5: ( value ASSIGN )=> assign_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_assign_stat_in_stat884);
					assign_stat99=assign_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_stat99.getTree());

					}
					break;
				case 5 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:505:5: func_call SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_func_call_in_stat891);
					func_call100=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call100.getTree());

					SEMI101=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat893); if (state.failed) return retval;
					}
					break;
				case 6 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:506:4: break_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_break_stat_in_stat899);
					break_stat102=break_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, break_stat102.getTree());

					}
					break;
				case 7 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:507:4: return_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_return_stat_in_stat904);
					return_stat103=return_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, return_stat103.getTree());

					}
					break;
				case 8 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:508:4: block
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_block_in_stat909);
					block104=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block104.getTree());

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


	public static class if_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_stat"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:511:1: if_stat : ( ( IF_KEY expr THEN_KEY stat_seq ELSE_KEY )=> IF_KEY expr THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) ) | IF_KEY expr THEN_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ) );
	public final tigerParser.if_stat_return if_stat() throws RecognitionException {
		tigerParser.if_stat_return retval = new tigerParser.if_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF_KEY105=null;
		Token THEN_KEY107=null;
		Token ELSE_KEY109=null;
		Token ENDIF_KEY111=null;
		Token SEMI112=null;
		Token IF_KEY113=null;
		Token THEN_KEY115=null;
		Token ENDIF_KEY117=null;
		Token SEMI118=null;
		ParserRuleReturnScope expr106 =null;
		ParserRuleReturnScope stat_seq108 =null;
		ParserRuleReturnScope stat_seq110 =null;
		ParserRuleReturnScope expr114 =null;
		ParserRuleReturnScope stat_seq116 =null;

		CommonTree IF_KEY105_tree=null;
		CommonTree THEN_KEY107_tree=null;
		CommonTree ELSE_KEY109_tree=null;
		CommonTree ENDIF_KEY111_tree=null;
		CommonTree SEMI112_tree=null;
		CommonTree IF_KEY113_tree=null;
		CommonTree THEN_KEY115_tree=null;
		CommonTree ENDIF_KEY117_tree=null;
		CommonTree SEMI118_tree=null;
		RewriteRuleTokenStream stream_ELSE_KEY=new RewriteRuleTokenStream(adaptor,"token ELSE_KEY");
		RewriteRuleTokenStream stream_ENDIF_KEY=new RewriteRuleTokenStream(adaptor,"token ENDIF_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_THEN_KEY=new RewriteRuleTokenStream(adaptor,"token THEN_KEY");
		RewriteRuleTokenStream stream_IF_KEY=new RewriteRuleTokenStream(adaptor,"token IF_KEY");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:512:3: ( ( IF_KEY expr THEN_KEY stat_seq ELSE_KEY )=> IF_KEY expr THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) ) | IF_KEY expr THEN_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==IF_KEY) ) {
				int LA16_1 = input.LA(2);
				if ( (synpred6_tiger()) ) {
					alt16=1;
				}
				else if ( (true) ) {
					alt16=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:512:5: ( IF_KEY expr THEN_KEY stat_seq ELSE_KEY )=> IF_KEY expr THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI
					{
					IF_KEY105=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat937); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY105);

					pushFollow(FOLLOW_expr_in_if_stat939);
					expr106=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr106.getTree());
					THEN_KEY107=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat941); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY107);

					pushFollow(FOLLOW_stat_seq_in_if_stat943);
					stat_seq108=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq108.getTree());
					ELSE_KEY109=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_if_stat945); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELSE_KEY.add(ELSE_KEY109);

					pushFollow(FOLLOW_stat_seq_in_if_stat947);
					stat_seq110=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq110.getTree());
					ENDIF_KEY111=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat949); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY111);

					SEMI112=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat951); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI112);

					// AST REWRITE
					// elements: expr, IF_KEY, stat_seq, ELSE_KEY, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 513:2: -> ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:513:6: ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:513:29: ^( ELSE_KEY stat_seq )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot(stream_ELSE_KEY.nextNode(), root_2);
						adaptor.addChild(root_2, stream_stat_seq.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:514:4: IF_KEY expr THEN_KEY stat_seq ENDIF_KEY SEMI
					{
					IF_KEY113=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat974); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY113);

					pushFollow(FOLLOW_expr_in_if_stat976);
					expr114=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr114.getTree());
					THEN_KEY115=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat978); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY115);

					pushFollow(FOLLOW_stat_seq_in_if_stat980);
					stat_seq116=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq116.getTree());
					ENDIF_KEY117=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat982); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY117);

					SEMI118=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat984); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI118);

					// AST REWRITE
					// elements: IF_KEY, expr, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 515:2: -> ^( IF_KEY expr stat_seq )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:515:5: ^( IF_KEY expr stat_seq )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
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
		return retval;
	}
	// $ANTLR end "if_stat"


	public static class while_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "while_stat"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:518:1: while_stat : WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY expr stat_seq ) ;
	public final tigerParser.while_stat_return while_stat() throws RecognitionException {
		tigerParser.while_stat_return retval = new tigerParser.while_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHILE_KEY119=null;
		Token DO_KEY121=null;
		Token ENDDO_KEY123=null;
		Token SEMI124=null;
		ParserRuleReturnScope expr120 =null;
		ParserRuleReturnScope stat_seq122 =null;

		CommonTree WHILE_KEY119_tree=null;
		CommonTree DO_KEY121_tree=null;
		CommonTree ENDDO_KEY123_tree=null;
		CommonTree SEMI124_tree=null;
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_WHILE_KEY=new RewriteRuleTokenStream(adaptor,"token WHILE_KEY");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:519:2: ( WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY expr stat_seq ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:519:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
			{
			WHILE_KEY119=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_while_stat1006); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_WHILE_KEY.add(WHILE_KEY119);

			pushFollow(FOLLOW_expr_in_while_stat1008);
			expr120=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr120.getTree());
			DO_KEY121=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_while_stat1010); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY121);

			pushFollow(FOLLOW_stat_seq_in_while_stat1012);
			stat_seq122=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq122.getTree());
			ENDDO_KEY123=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_while_stat1014); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY123);

			SEMI124=(Token)match(input,SEMI,FOLLOW_SEMI_in_while_stat1016); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI124);

			// AST REWRITE
			// elements: WHILE_KEY, expr, stat_seq
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 520:2: -> ^( WHILE_KEY expr stat_seq )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:520:5: ^( WHILE_KEY expr stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE_KEY.nextNode(), root_1);
				adaptor.addChild(root_1, stream_expr.nextTree());
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
		return retval;
	}
	// $ANTLR end "while_stat"


	public static class for_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "for_stat"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:523:1: for_stat : FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) ;
	public final tigerParser.for_stat_return for_stat() throws RecognitionException {
		tigerParser.for_stat_return retval = new tigerParser.for_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FOR_KEY125=null;
		Token ID126=null;
		Token ASSIGN127=null;
		Token TO_KEY129=null;
		Token DO_KEY131=null;
		Token ENDDO_KEY133=null;
		Token SEMI134=null;
		ParserRuleReturnScope index_expr128 =null;
		ParserRuleReturnScope index_expr130 =null;
		ParserRuleReturnScope stat_seq132 =null;

		CommonTree FOR_KEY125_tree=null;
		CommonTree ID126_tree=null;
		CommonTree ASSIGN127_tree=null;
		CommonTree TO_KEY129_tree=null;
		CommonTree DO_KEY131_tree=null;
		CommonTree ENDDO_KEY133_tree=null;
		CommonTree SEMI134_tree=null;
		RewriteRuleTokenStream stream_TO_KEY=new RewriteRuleTokenStream(adaptor,"token TO_KEY");
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_FOR_KEY=new RewriteRuleTokenStream(adaptor,"token FOR_KEY");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:524:3: ( FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:524:5: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
			{
			FOR_KEY125=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_for_stat1039); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FOR_KEY.add(FOR_KEY125);

			ID126=(Token)match(input,ID,FOLLOW_ID_in_for_stat1041); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID126);

			ASSIGN127=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_for_stat1043); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN127);

			pushFollow(FOLLOW_index_expr_in_for_stat1045);
			index_expr128=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr128.getTree());
			TO_KEY129=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_for_stat1047); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TO_KEY.add(TO_KEY129);

			pushFollow(FOLLOW_index_expr_in_for_stat1049);
			index_expr130=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr130.getTree());
			DO_KEY131=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_for_stat1051); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY131);

			pushFollow(FOLLOW_stat_seq_in_for_stat1053);
			stat_seq132=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq132.getTree());
			ENDDO_KEY133=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_for_stat1055); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY133);

			SEMI134=(Token)match(input,SEMI,FOLLOW_SEMI_in_for_stat1057); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI134);

			// AST REWRITE
			// elements: index_expr, ASSIGN, stat_seq, FOR_KEY, index_expr, ID, TO_KEY
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 525:2: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:525:5: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:525:15: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:525:24: ^( ASSIGN ID index_expr )
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
	// $ANTLR end "for_stat"


	public static class assign_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assign_stat"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:528:1: assign_stat : ( ( value ASSIGN func_call )=> value ASSIGN func_call SEMI -> ^( ASSIGN value func_call ) | value ASSIGN expr_list SEMI -> ^( ASSIGN value expr_list ) );
	public final tigerParser.assign_stat_return assign_stat() throws RecognitionException {
		tigerParser.assign_stat_return retval = new tigerParser.assign_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ASSIGN136=null;
		Token SEMI138=null;
		Token ASSIGN140=null;
		Token SEMI142=null;
		ParserRuleReturnScope value135 =null;
		ParserRuleReturnScope func_call137 =null;
		ParserRuleReturnScope value139 =null;
		ParserRuleReturnScope expr_list141 =null;

		CommonTree ASSIGN136_tree=null;
		CommonTree SEMI138_tree=null;
		CommonTree ASSIGN140_tree=null;
		CommonTree SEMI142_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_func_call=new RewriteRuleSubtreeStream(adaptor,"rule func_call");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
		RewriteRuleSubtreeStream stream_expr_list=new RewriteRuleSubtreeStream(adaptor,"rule expr_list");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:529:2: ( ( value ASSIGN func_call )=> value ASSIGN func_call SEMI -> ^( ASSIGN value func_call ) | value ASSIGN expr_list SEMI -> ^( ASSIGN value expr_list ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==ID) ) {
				int LA17_1 = input.LA(2);
				if ( (synpred7_tiger()) ) {
					alt17=1;
				}
				else if ( (true) ) {
					alt17=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:529:4: ( value ASSIGN func_call )=> value ASSIGN func_call SEMI
					{
					pushFollow(FOLLOW_value_in_assign_stat1101);
					value135=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value135.getTree());
					ASSIGN136=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat1103); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN136);

					pushFollow(FOLLOW_func_call_in_assign_stat1105);
					func_call137=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_call.add(func_call137.getTree());
					SEMI138=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat1107); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI138);

					// AST REWRITE
					// elements: value, ASSIGN, func_call
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 530:2: -> ^( ASSIGN value func_call )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:530:5: ^( ASSIGN value func_call )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_value.nextTree());
						adaptor.addChild(root_1, stream_func_call.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:531:4: value ASSIGN expr_list SEMI
					{
					pushFollow(FOLLOW_value_in_assign_stat1123);
					value139=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value139.getTree());
					ASSIGN140=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat1125); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN140);

					pushFollow(FOLLOW_expr_list_in_assign_stat1127);
					expr_list141=expr_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr_list.add(expr_list141.getTree());
					SEMI142=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat1129); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI142);

					// AST REWRITE
					// elements: expr_list, value, ASSIGN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 532:2: -> ^( ASSIGN value expr_list )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:532:5: ^( ASSIGN value expr_list )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_value.nextTree());
						adaptor.addChild(root_1, stream_expr_list.nextTree());
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
		return retval;
	}
	// $ANTLR end "assign_stat"


	public static class func_call_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:535:1: func_call : ID LPAREN func_param_list RPAREN -> ^( AST_FUNC_CALL ID func_param_list ) ;
	public final tigerParser.func_call_return func_call() throws RecognitionException {
		tigerParser.func_call_return retval = new tigerParser.func_call_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID143=null;
		Token LPAREN144=null;
		Token RPAREN146=null;
		ParserRuleReturnScope func_param_list145 =null;

		CommonTree ID143_tree=null;
		CommonTree LPAREN144_tree=null;
		CommonTree RPAREN146_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_func_param_list=new RewriteRuleSubtreeStream(adaptor,"rule func_param_list");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:536:2: ( ID LPAREN func_param_list RPAREN -> ^( AST_FUNC_CALL ID func_param_list ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:536:4: ID LPAREN func_param_list RPAREN
			{
			ID143=(Token)match(input,ID,FOLLOW_ID_in_func_call1151); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID143);

			LPAREN144=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call1153); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN144);

			pushFollow(FOLLOW_func_param_list_in_func_call1155);
			func_param_list145=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_param_list.add(func_param_list145.getTree());
			RPAREN146=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call1157); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN146);

			// AST REWRITE
			// elements: ID, func_param_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 537:2: -> ^( AST_FUNC_CALL ID func_param_list )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:537:5: ^( AST_FUNC_CALL ID func_param_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_FUNC_CALL, "AST_FUNC_CALL"), root_1);
				adaptor.addChild(root_1, stream_ID.nextNode());
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
		return retval;
	}
	// $ANTLR end "func_call"


	public static class break_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "break_stat"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:540:1: break_stat : BREAK_KEY SEMI -> BREAK_KEY ;
	public final tigerParser.break_stat_return break_stat() throws RecognitionException {
		tigerParser.break_stat_return retval = new tigerParser.break_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BREAK_KEY147=null;
		Token SEMI148=null;

		CommonTree BREAK_KEY147_tree=null;
		CommonTree SEMI148_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BREAK_KEY=new RewriteRuleTokenStream(adaptor,"token BREAK_KEY");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:541:2: ( BREAK_KEY SEMI -> BREAK_KEY )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:541:4: BREAK_KEY SEMI
			{
			BREAK_KEY147=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_break_stat1180); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BREAK_KEY.add(BREAK_KEY147);

			SEMI148=(Token)match(input,SEMI,FOLLOW_SEMI_in_break_stat1182); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI148);

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
			// 542:2: -> BREAK_KEY
			{
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
		return retval;
	}
	// $ANTLR end "break_stat"


	public static class return_stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "return_stat"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:545:1: return_stat : RETURN_KEY expr SEMI -> ^( AST_RETURN_STAT RETURN_KEY expr ) ;
	public final tigerParser.return_stat_return return_stat() throws RecognitionException {
		tigerParser.return_stat_return retval = new tigerParser.return_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RETURN_KEY149=null;
		Token SEMI151=null;
		ParserRuleReturnScope expr150 =null;

		CommonTree RETURN_KEY149_tree=null;
		CommonTree SEMI151_tree=null;
		RewriteRuleTokenStream stream_RETURN_KEY=new RewriteRuleTokenStream(adaptor,"token RETURN_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:546:2: ( RETURN_KEY expr SEMI -> ^( AST_RETURN_STAT RETURN_KEY expr ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:546:4: RETURN_KEY expr SEMI
			{
			RETURN_KEY149=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_return_stat1199); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RETURN_KEY.add(RETURN_KEY149);

			pushFollow(FOLLOW_expr_in_return_stat1201);
			expr150=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr150.getTree());
			SEMI151=(Token)match(input,SEMI,FOLLOW_SEMI_in_return_stat1203); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI151);

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
			// 547:2: -> ^( AST_RETURN_STAT RETURN_KEY expr )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:547:5: ^( AST_RETURN_STAT RETURN_KEY expr )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_RETURN_STAT, "AST_RETURN_STAT"), root_1);
				adaptor.addChild(root_1, stream_RETURN_KEY.nextNode());
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
		return retval;
	}
	// $ANTLR end "return_stat"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:551:1: expr : ( ( constval binop_p0 )=> constval binop_p0 expr -> ^( binop_p0 constval expr ) | constval | ( value binop_p0 )=> value binop_p0 expr -> ^( binop_p0 value expr ) | value | ( LPAREN expr RPAREN binop_p0 )=> LPAREN expr RPAREN binop_p0 expr -> ^( binop_p0 ^( AST_EXPR_PAREN expr ) expr ) | LPAREN expr RPAREN -> ^( AST_EXPR_PAREN expr ) );
	public final tigerParser.expr_return expr() throws RecognitionException {
		tigerParser.expr_return retval = new tigerParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN160=null;
		Token RPAREN162=null;
		Token LPAREN165=null;
		Token RPAREN167=null;
		ParserRuleReturnScope constval152 =null;
		ParserRuleReturnScope binop_p0153 =null;
		ParserRuleReturnScope expr154 =null;
		ParserRuleReturnScope constval155 =null;
		ParserRuleReturnScope value156 =null;
		ParserRuleReturnScope binop_p0157 =null;
		ParserRuleReturnScope expr158 =null;
		ParserRuleReturnScope value159 =null;
		ParserRuleReturnScope expr161 =null;
		ParserRuleReturnScope binop_p0163 =null;
		ParserRuleReturnScope expr164 =null;
		ParserRuleReturnScope expr166 =null;

		CommonTree LPAREN160_tree=null;
		CommonTree RPAREN162_tree=null;
		CommonTree LPAREN165_tree=null;
		CommonTree RPAREN167_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_constval=new RewriteRuleSubtreeStream(adaptor,"rule constval");
		RewriteRuleSubtreeStream stream_binop_p0=new RewriteRuleSubtreeStream(adaptor,"rule binop_p0");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:552:3: ( ( constval binop_p0 )=> constval binop_p0 expr -> ^( binop_p0 constval expr ) | constval | ( value binop_p0 )=> value binop_p0 expr -> ^( binop_p0 value expr ) | value | ( LPAREN expr RPAREN binop_p0 )=> LPAREN expr RPAREN binop_p0 expr -> ^( binop_p0 ^( AST_EXPR_PAREN expr ) expr ) | LPAREN expr RPAREN -> ^( AST_EXPR_PAREN expr ) )
			int alt18=6;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				int LA18_1 = input.LA(2);
				if ( (synpred8_tiger()) ) {
					alt18=1;
				}
				else if ( (true) ) {
					alt18=2;
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA18_2 = input.LA(2);
				if ( (synpred8_tiger()) ) {
					alt18=1;
				}
				else if ( (true) ) {
					alt18=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA18_3 = input.LA(2);
				if ( (synpred8_tiger()) ) {
					alt18=1;
				}
				else if ( (true) ) {
					alt18=2;
				}

				}
				break;
			case ID:
				{
				int LA18_4 = input.LA(2);
				if ( (synpred9_tiger()) ) {
					alt18=3;
				}
				else if ( (true) ) {
					alt18=4;
				}

				}
				break;
			case LPAREN:
				{
				int LA18_5 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt18=5;
				}
				else if ( (true) ) {
					alt18=6;
				}

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
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:552:5: ( constval binop_p0 )=> constval binop_p0 expr
					{
					pushFollow(FOLLOW_constval_in_expr1238);
					constval152=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constval.add(constval152.getTree());
					pushFollow(FOLLOW_binop_p0_in_expr1240);
					binop_p0153=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p0.add(binop_p0153.getTree());
					pushFollow(FOLLOW_expr_in_expr1242);
					expr154=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr154.getTree());
					// AST REWRITE
					// elements: constval, expr, binop_p0
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 553:2: -> ^( binop_p0 constval expr )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:553:5: ^( binop_p0 constval expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_binop_p0.nextNode(), root_1);
						adaptor.addChild(root_1, stream_constval.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:554:4: constval
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_constval_in_expr1258);
					constval155=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constval155.getTree());

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:555:4: ( value binop_p0 )=> value binop_p0 expr
					{
					pushFollow(FOLLOW_value_in_expr1271);
					value156=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value156.getTree());
					pushFollow(FOLLOW_binop_p0_in_expr1273);
					binop_p0157=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p0.add(binop_p0157.getTree());
					pushFollow(FOLLOW_expr_in_expr1275);
					expr158=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr158.getTree());
					// AST REWRITE
					// elements: value, binop_p0, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 556:2: -> ^( binop_p0 value expr )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:556:5: ^( binop_p0 value expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_binop_p0.nextNode(), root_1);
						adaptor.addChild(root_1, stream_value.nextTree());
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:557:4: value
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_value_in_expr1291);
					value159=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, value159.getTree());

					}
					break;
				case 5 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:558:4: ( LPAREN expr RPAREN binop_p0 )=> LPAREN expr RPAREN binop_p0 expr
					{
					LPAREN160=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr1308); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN160);

					pushFollow(FOLLOW_expr_in_expr1310);
					expr161=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr161.getTree());
					RPAREN162=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr1312); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN162);

					pushFollow(FOLLOW_binop_p0_in_expr1314);
					binop_p0163=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p0.add(binop_p0163.getTree());
					pushFollow(FOLLOW_expr_in_expr1316);
					expr164=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr164.getTree());
					// AST REWRITE
					// elements: expr, expr, binop_p0
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 559:2: -> ^( binop_p0 ^( AST_EXPR_PAREN expr ) expr )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:559:5: ^( binop_p0 ^( AST_EXPR_PAREN expr ) expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_binop_p0.nextNode(), root_1);
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:559:16: ^( AST_EXPR_PAREN expr )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_EXPR_PAREN, "AST_EXPR_PAREN"), root_2);
						adaptor.addChild(root_2, stream_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:560:4: LPAREN expr RPAREN
					{
					LPAREN165=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr1336); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN165);

					pushFollow(FOLLOW_expr_in_expr1338);
					expr166=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr166.getTree());
					RPAREN167=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr1340); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN167);

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
					// 561:2: -> ^( AST_EXPR_PAREN expr )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:561:5: ^( AST_EXPR_PAREN expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_EXPR_PAREN, "AST_EXPR_PAREN"), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
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
		return retval;
	}
	// $ANTLR end "expr"


	public static class binop_p0_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p0"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:1: binop_p0 : ( AND | OR | binop_p1 ) ;
	public final tigerParser.binop_p0_return binop_p0() throws RecognitionException {
		tigerParser.binop_p0_return retval = new tigerParser.binop_p0_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND168=null;
		Token OR169=null;
		ParserRuleReturnScope binop_p1170 =null;

		CommonTree AND168_tree=null;
		CommonTree OR169_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:9: ( ( AND | OR | binop_p1 ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:11: ( AND | OR | binop_p1 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:11: ( AND | OR | binop_p1 )
			int alt19=3;
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
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:12: AND
					{
					AND168=(Token)match(input,AND,FOLLOW_AND_in_binop_p01359); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND168_tree = (CommonTree)adaptor.create(AND168);
					adaptor.addChild(root_0, AND168_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:18: OR
					{
					OR169=(Token)match(input,OR,FOLLOW_OR_in_binop_p01363); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR169_tree = (CommonTree)adaptor.create(OR169);
					adaptor.addChild(root_0, OR169_tree);
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:23: binop_p1
					{
					pushFollow(FOLLOW_binop_p1_in_binop_p01367);
					binop_p1170=binop_p1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p1170.getTree());

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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:1: binop_p1 : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) ;
	public final tigerParser.binop_p1_return binop_p1() throws RecognitionException {
		tigerParser.binop_p1_return retval = new tigerParser.binop_p1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQ171=null;
		Token NEQ172=null;
		Token LESSER173=null;
		Token GREATER174=null;
		Token LESSEREQ175=null;
		Token GREATEREQ176=null;
		ParserRuleReturnScope binop_p2177 =null;

		CommonTree EQ171_tree=null;
		CommonTree NEQ172_tree=null;
		CommonTree LESSER173_tree=null;
		CommonTree GREATER174_tree=null;
		CommonTree LESSEREQ175_tree=null;
		CommonTree GREATEREQ176_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:9: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			int alt20=7;
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
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:12: EQ
					{
					EQ171=(Token)match(input,EQ,FOLLOW_EQ_in_binop_p11375); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EQ171_tree = (CommonTree)adaptor.create(EQ171);
					adaptor.addChild(root_0, EQ171_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:17: NEQ
					{
					NEQ172=(Token)match(input,NEQ,FOLLOW_NEQ_in_binop_p11379); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NEQ172_tree = (CommonTree)adaptor.create(NEQ172);
					adaptor.addChild(root_0, NEQ172_tree);
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:23: LESSER
					{
					LESSER173=(Token)match(input,LESSER,FOLLOW_LESSER_in_binop_p11383); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSER173_tree = (CommonTree)adaptor.create(LESSER173);
					adaptor.addChild(root_0, LESSER173_tree);
					}

					}
					break;
				case 4 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:32: GREATER
					{
					GREATER174=(Token)match(input,GREATER,FOLLOW_GREATER_in_binop_p11387); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATER174_tree = (CommonTree)adaptor.create(GREATER174);
					adaptor.addChild(root_0, GREATER174_tree);
					}

					}
					break;
				case 5 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:42: LESSEREQ
					{
					LESSEREQ175=(Token)match(input,LESSEREQ,FOLLOW_LESSEREQ_in_binop_p11391); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LESSEREQ175_tree = (CommonTree)adaptor.create(LESSEREQ175);
					adaptor.addChild(root_0, LESSEREQ175_tree);
					}

					}
					break;
				case 6 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:53: GREATEREQ
					{
					GREATEREQ176=(Token)match(input,GREATEREQ,FOLLOW_GREATEREQ_in_binop_p11395); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					GREATEREQ176_tree = (CommonTree)adaptor.create(GREATEREQ176);
					adaptor.addChild(root_0, GREATEREQ176_tree);
					}

					}
					break;
				case 7 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:565:65: binop_p2
					{
					pushFollow(FOLLOW_binop_p2_in_binop_p11399);
					binop_p2177=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p2177.getTree());

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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:1: binop_p2 : ( MINUS | PLUS | binop_p3 ) ;
	public final tigerParser.binop_p2_return binop_p2() throws RecognitionException {
		tigerParser.binop_p2_return retval = new tigerParser.binop_p2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS178=null;
		Token PLUS179=null;
		ParserRuleReturnScope binop_p3180 =null;

		CommonTree MINUS178_tree=null;
		CommonTree PLUS179_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:9: ( ( MINUS | PLUS | binop_p3 ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:11: ( MINUS | PLUS | binop_p3 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:11: ( MINUS | PLUS | binop_p3 )
			int alt21=3;
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
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:12: MINUS
					{
					MINUS178=(Token)match(input,MINUS,FOLLOW_MINUS_in_binop_p21412); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS178_tree = (CommonTree)adaptor.create(MINUS178);
					adaptor.addChild(root_0, MINUS178_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:20: PLUS
					{
					PLUS179=(Token)match(input,PLUS,FOLLOW_PLUS_in_binop_p21416); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS179_tree = (CommonTree)adaptor.create(PLUS179);
					adaptor.addChild(root_0, PLUS179_tree);
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:566:27: binop_p3
					{
					pushFollow(FOLLOW_binop_p3_in_binop_p21420);
					binop_p3180=binop_p3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p3180.getTree());

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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:567:1: binop_p3 : ( MULT | DIV ) ;
	public final tigerParser.binop_p3_return binop_p3() throws RecognitionException {
		tigerParser.binop_p3_return retval = new tigerParser.binop_p3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set181=null;

		CommonTree set181_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:567:9: ( ( MULT | DIV ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set181=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set181));
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:569:1: constval : ( ( fixedptlit )=> fixedptlit | intlit );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope fixedptlit182 =null;
		ParserRuleReturnScope intlit183 =null;


		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:570:3: ( ( fixedptlit )=> fixedptlit | intlit )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==MINUS) ) {
				int LA22_1 = input.LA(2);
				if ( (synpred11_tiger()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

			}
			else if ( (LA22_0==UNSIGNED_FIXEDPTLIT) && (synpred11_tiger())) {
				alt22=1;
			}
			else if ( (LA22_0==UNSIGNED_INTLIT) ) {
				alt22=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:570:5: ( fixedptlit )=> fixedptlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_fixedptlit_in_constval1450);
					fixedptlit182=fixedptlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fixedptlit182.getTree());

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:571:4: intlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intlit_in_constval1455);
					intlit183=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intlit183.getTree());

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
	// $ANTLR end "constval"


	public static class intlit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "intlit"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:574:1: intlit : ( MINUS )? UNSIGNED_INTLIT ;
	public final tigerParser.intlit_return intlit() throws RecognitionException {
		tigerParser.intlit_return retval = new tigerParser.intlit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS184=null;
		Token UNSIGNED_INTLIT185=null;

		CommonTree MINUS184_tree=null;
		CommonTree UNSIGNED_INTLIT185_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:574:8: ( ( MINUS )? UNSIGNED_INTLIT )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:574:10: ( MINUS )? UNSIGNED_INTLIT
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:574:10: ( MINUS )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==MINUS) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:574:10: MINUS
					{
					MINUS184=(Token)match(input,MINUS,FOLLOW_MINUS_in_intlit1465); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS184_tree = (CommonTree)adaptor.create(MINUS184);
					adaptor.addChild(root_0, MINUS184_tree);
					}

					}
					break;

			}

			UNSIGNED_INTLIT185=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_intlit1468); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNSIGNED_INTLIT185_tree = (CommonTree)adaptor.create(UNSIGNED_INTLIT185);
			adaptor.addChild(root_0, UNSIGNED_INTLIT185_tree);
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
	// $ANTLR end "intlit"


	public static class fixedptlit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "fixedptlit"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:579:1: fixedptlit : ( MINUS )? UNSIGNED_FIXEDPTLIT ;
	public final tigerParser.fixedptlit_return fixedptlit() throws RecognitionException {
		tigerParser.fixedptlit_return retval = new tigerParser.fixedptlit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS186=null;
		Token UNSIGNED_FIXEDPTLIT187=null;

		CommonTree MINUS186_tree=null;
		CommonTree UNSIGNED_FIXEDPTLIT187_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:580:2: ( ( MINUS )? UNSIGNED_FIXEDPTLIT )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:580:6: ( MINUS )? UNSIGNED_FIXEDPTLIT
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:580:6: ( MINUS )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==MINUS) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:580:6: MINUS
					{
					MINUS186=(Token)match(input,MINUS,FOLLOW_MINUS_in_fixedptlit1492); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS186_tree = (CommonTree)adaptor.create(MINUS186);
					adaptor.addChild(root_0, MINUS186_tree);
					}

					}
					break;

			}

			UNSIGNED_FIXEDPTLIT187=(Token)match(input,UNSIGNED_FIXEDPTLIT,FOLLOW_UNSIGNED_FIXEDPTLIT_in_fixedptlit1495); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNSIGNED_FIXEDPTLIT187_tree = (CommonTree)adaptor.create(UNSIGNED_FIXEDPTLIT187);
			adaptor.addChild(root_0, UNSIGNED_FIXEDPTLIT187_tree);
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
	// $ANTLR end "fixedptlit"


	public static class binary_operator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binary_operator"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:587:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set188=null;

		CommonTree set188_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:588:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set188=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set188));
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
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:591:1: expr_list : expr ( COMMA expr )* -> ^( AST_EXPR_LIST ( expr )+ ) ;
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA190=null;
		ParserRuleReturnScope expr189 =null;
		ParserRuleReturnScope expr191 =null;

		CommonTree COMMA190_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:592:2: ( expr ( COMMA expr )* -> ^( AST_EXPR_LIST ( expr )+ ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:592:4: expr ( COMMA expr )*
			{
			pushFollow(FOLLOW_expr_in_expr_list1569);
			expr189=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr189.getTree());
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:592:9: ( COMMA expr )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==COMMA) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:592:10: COMMA expr
					{
					COMMA190=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1572); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA190);

					pushFollow(FOLLOW_expr_in_expr_list1574);
					expr191=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr191.getTree());
					}
					break;

				default :
					break loop25;
				}
			}

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
			// 593:2: -> ^( AST_EXPR_LIST ( expr )+ )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:593:5: ^( AST_EXPR_LIST ( expr )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_EXPR_LIST, "AST_EXPR_LIST"), root_1);
				if ( !(stream_expr.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expr.hasNext() ) {
					adaptor.addChild(root_1, stream_expr.nextTree());
				}
				stream_expr.reset();

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
		return retval;
	}
	// $ANTLR end "expr_list"


	public static class value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:596:1: value : ( ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK | ( ID LBRACK )=> ID LBRACK index_expr RBRACK | ID );
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID192=null;
		Token LBRACK193=null;
		Token RBRACK195=null;
		Token LBRACK196=null;
		Token RBRACK198=null;
		Token ID199=null;
		Token LBRACK200=null;
		Token RBRACK202=null;
		Token ID203=null;
		ParserRuleReturnScope index_expr194 =null;
		ParserRuleReturnScope index_expr197 =null;
		ParserRuleReturnScope index_expr201 =null;

		CommonTree ID192_tree=null;
		CommonTree LBRACK193_tree=null;
		CommonTree RBRACK195_tree=null;
		CommonTree LBRACK196_tree=null;
		CommonTree RBRACK198_tree=null;
		CommonTree ID199_tree=null;
		CommonTree LBRACK200_tree=null;
		CommonTree RBRACK202_tree=null;
		CommonTree ID203_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:597:4: ( ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK | ( ID LBRACK )=> ID LBRACK index_expr RBRACK | ID )
			int alt26=3;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==ID) ) {
				int LA26_1 = input.LA(2);
				if ( (synpred12_tiger()) ) {
					alt26=1;
				}
				else if ( (synpred13_tiger()) ) {
					alt26=2;
				}
				else if ( (true) ) {
					alt26=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:597:6: ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
					{
					root_0 = (CommonTree)adaptor.nil();


					ID192=(Token)match(input,ID,FOLLOW_ID_in_value1615); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID192_tree = (CommonTree)adaptor.create(ID192);
					adaptor.addChild(root_0, ID192_tree);
					}

					LBRACK193=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1617); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK193_tree = (CommonTree)adaptor.create(LBRACK193);
					adaptor.addChild(root_0, LBRACK193_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1619);
					index_expr194=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr194.getTree());

					RBRACK195=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1621); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK195_tree = (CommonTree)adaptor.create(RBRACK195);
					adaptor.addChild(root_0, RBRACK195_tree);
					}

					LBRACK196=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1623); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK196_tree = (CommonTree)adaptor.create(LBRACK196);
					adaptor.addChild(root_0, LBRACK196_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1625);
					index_expr197=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr197.getTree());

					RBRACK198=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1627); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK198_tree = (CommonTree)adaptor.create(RBRACK198);
					adaptor.addChild(root_0, RBRACK198_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:598:4: ( ID LBRACK )=> ID LBRACK index_expr RBRACK
					{
					root_0 = (CommonTree)adaptor.nil();


					ID199=(Token)match(input,ID,FOLLOW_ID_in_value1640); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID199_tree = (CommonTree)adaptor.create(ID199);
					adaptor.addChild(root_0, ID199_tree);
					}

					LBRACK200=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1642); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK200_tree = (CommonTree)adaptor.create(LBRACK200);
					adaptor.addChild(root_0, LBRACK200_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1644);
					index_expr201=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr201.getTree());

					RBRACK202=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1646); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK202_tree = (CommonTree)adaptor.create(RBRACK202);
					adaptor.addChild(root_0, RBRACK202_tree);
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:599:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID203=(Token)match(input,ID,FOLLOW_ID_in_value1651); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID203_tree = (CommonTree)adaptor.create(ID203);
					adaptor.addChild(root_0, ID203_tree);
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
	// $ANTLR end "value"


	public static class index_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:602:1: index_expr : ( ( intlit index_oper )=> intlit index_oper index_expr -> ^( index_oper intlit index_expr ) | intlit | ( ID index_oper )=> ID index_oper index_expr -> ^( index_oper ID index_expr ) | ID );
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID208=null;
		Token ID211=null;
		ParserRuleReturnScope intlit204 =null;
		ParserRuleReturnScope index_oper205 =null;
		ParserRuleReturnScope index_expr206 =null;
		ParserRuleReturnScope intlit207 =null;
		ParserRuleReturnScope index_oper209 =null;
		ParserRuleReturnScope index_expr210 =null;

		CommonTree ID208_tree=null;
		CommonTree ID211_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_index_oper=new RewriteRuleSubtreeStream(adaptor,"rule index_oper");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_intlit=new RewriteRuleSubtreeStream(adaptor,"rule intlit");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:603:2: ( ( intlit index_oper )=> intlit index_oper index_expr -> ^( index_oper intlit index_expr ) | intlit | ( ID index_oper )=> ID index_oper index_expr -> ^( index_oper ID index_expr ) | ID )
			int alt27=4;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				int LA27_1 = input.LA(2);
				if ( (synpred14_tiger()) ) {
					alt27=1;
				}
				else if ( (true) ) {
					alt27=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA27_2 = input.LA(2);
				if ( (synpred14_tiger()) ) {
					alt27=1;
				}
				else if ( (true) ) {
					alt27=2;
				}

				}
				break;
			case ID:
				{
				int LA27_3 = input.LA(2);
				if ( (synpred15_tiger()) ) {
					alt27=3;
				}
				else if ( (true) ) {
					alt27=4;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}
			switch (alt27) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:603:4: ( intlit index_oper )=> intlit index_oper index_expr
					{
					pushFollow(FOLLOW_intlit_in_index_expr1671);
					intlit204=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_intlit.add(intlit204.getTree());
					pushFollow(FOLLOW_index_oper_in_index_expr1673);
					index_oper205=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_oper.add(index_oper205.getTree());
					pushFollow(FOLLOW_index_expr_in_index_expr1675);
					index_expr206=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr206.getTree());
					// AST REWRITE
					// elements: intlit, index_expr, index_oper
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 604:2: -> ^( index_oper intlit index_expr )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:604:5: ^( index_oper intlit index_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_index_oper.nextNode(), root_1);
						adaptor.addChild(root_1, stream_intlit.nextTree());
						adaptor.addChild(root_1, stream_index_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:605:4: intlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intlit_in_index_expr1691);
					intlit207=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intlit207.getTree());

					}
					break;
				case 3 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:606:4: ( ID index_oper )=> ID index_oper index_expr
					{
					ID208=(Token)match(input,ID,FOLLOW_ID_in_index_expr1704); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID208);

					pushFollow(FOLLOW_index_oper_in_index_expr1706);
					index_oper209=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_oper.add(index_oper209.getTree());
					pushFollow(FOLLOW_index_expr_in_index_expr1708);
					index_expr210=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr210.getTree());
					// AST REWRITE
					// elements: index_expr, ID, index_oper
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 607:2: -> ^( index_oper ID index_expr )
					{
						// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:607:5: ^( index_oper ID index_expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_index_oper.nextNode(), root_1);
						adaptor.addChild(root_1, stream_ID.nextNode());
						adaptor.addChild(root_1, stream_index_expr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:608:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID211=(Token)match(input,ID,FOLLOW_ID_in_index_expr1724); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID211_tree = (CommonTree)adaptor.create(ID211);
					adaptor.addChild(root_0, ID211_tree);
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
	// $ANTLR end "index_expr"


	public static class index_oper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_oper"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:611:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set212=null;

		CommonTree set212_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:612:2: ( ( PLUS | MINUS | MULT ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set212=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set212));
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


	public static class func_param_list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_param_list"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:631:1: func_param_list : ( expr ( COMMA expr )* )? -> ^( AST_PARAM_LIST ( ( expr )+ )? ) ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA214=null;
		ParserRuleReturnScope expr213 =null;
		ParserRuleReturnScope expr215 =null;

		CommonTree COMMA214_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:2: ( ( expr ( COMMA expr )* )? -> ^( AST_PARAM_LIST ( ( expr )+ )? ) )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:4: ( expr ( COMMA expr )* )?
			{
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:4: ( expr ( COMMA expr )* )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==ID||LA29_0==LPAREN||LA29_0==MINUS||(LA29_0 >= UNSIGNED_FIXEDPTLIT && LA29_0 <= UNSIGNED_INTLIT)) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:5: expr ( COMMA expr )*
					{
					pushFollow(FOLLOW_expr_in_func_param_list1841);
					expr213=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr213.getTree());
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:10: ( COMMA expr )*
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( (LA28_0==COMMA) ) {
							alt28=1;
						}

						switch (alt28) {
						case 1 :
							// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:11: COMMA expr
							{
							COMMA214=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list1844); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA214);

							pushFollow(FOLLOW_expr_in_func_param_list1846);
							expr215=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(expr215.getTree());
							}
							break;

						default :
							break loop28;
						}
					}

					}
					break;

			}

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
			// 633:2: -> ^( AST_PARAM_LIST ( ( expr )+ )? )
			{
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:633:5: ^( AST_PARAM_LIST ( ( expr )+ )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_PARAM_LIST, "AST_PARAM_LIST"), root_1);
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:633:22: ( ( expr )+ )?
				if ( stream_expr.hasNext() ) {
					if ( !(stream_expr.hasNext()) ) {
						throw new RewriteEarlyExitException();
					}
					while ( stream_expr.hasNext() ) {
						adaptor.addChild(root_1, stream_expr.nextTree());
					}
					stream_expr.reset();

				}
				stream_expr.reset();

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
		return retval;
	}
	// $ANTLR end "func_param_list"


	public static class keywords_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "keywords"
	// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:636:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set216=null;

		CommonTree set216_tree=null;

		try {
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:637:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set216=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= INT_KEY)||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= TYPE_KEY)||(input.LA(1) >= VAR_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set216));
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
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:222:4: ( VOID_KEY FUNCTION_KEY )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:222:5: VOID_KEY FUNCTION_KEY
		{
		match(input,VOID_KEY,FOLLOW_VOID_KEY_in_synpred1_tiger203); if (state.failed) return;

		match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_synpred1_tiger205); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_tiger

	// $ANTLR start synpred2_tiger
	public final void synpred2_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:306:4: ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:306:5: ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK
		{
		match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_synpred2_tiger542); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred2_tiger544); if (state.failed) return;

		match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger546); if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred2_tiger548); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred2_tiger550); if (state.failed) return;

		match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger552); if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred2_tiger554); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_tiger

	// $ANTLR start synpred3_tiger
	public final void synpred3_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:336:4: ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:336:5: VAR_KEY id_list COLON type_id ASSIGN fixedptlit
		{
		match(input,VAR_KEY,FOLLOW_VAR_KEY_in_synpred3_tiger676); if (state.failed) return;

		pushFollow(FOLLOW_id_list_in_synpred3_tiger678);
		id_list();
		state._fsp--;
		if (state.failed) return;

		match(input,COLON,FOLLOW_COLON_in_synpred3_tiger680); if (state.failed) return;

		pushFollow(FOLLOW_type_id_in_synpred3_tiger682);
		type_id();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred3_tiger684); if (state.failed) return;

		pushFollow(FOLLOW_fixedptlit_in_synpred3_tiger686);
		fixedptlit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_tiger

	// $ANTLR start synpred4_tiger
	public final void synpred4_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:407:4: ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:407:5: VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT
		{
		match(input,VAR_KEY,FOLLOW_VAR_KEY_in_synpred4_tiger730); if (state.failed) return;

		pushFollow(FOLLOW_id_list_in_synpred4_tiger732);
		id_list();
		state._fsp--;
		if (state.failed) return;

		match(input,COLON,FOLLOW_COLON_in_synpred4_tiger734); if (state.failed) return;

		pushFollow(FOLLOW_type_id_in_synpred4_tiger736);
		type_id();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred4_tiger738); if (state.failed) return;

		match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_synpred4_tiger740); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_tiger

	// $ANTLR start synpred5_tiger
	public final void synpred5_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:504:5: ( value ASSIGN )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:504:6: value ASSIGN
		{
		pushFollow(FOLLOW_value_in_synpred5_tiger877);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred5_tiger879); if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_tiger

	// $ANTLR start synpred6_tiger
	public final void synpred6_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:512:5: ( IF_KEY expr THEN_KEY stat_seq ELSE_KEY )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:512:6: IF_KEY expr THEN_KEY stat_seq ELSE_KEY
		{
		match(input,IF_KEY,FOLLOW_IF_KEY_in_synpred6_tiger923); if (state.failed) return;

		pushFollow(FOLLOW_expr_in_synpred6_tiger925);
		expr();
		state._fsp--;
		if (state.failed) return;

		match(input,THEN_KEY,FOLLOW_THEN_KEY_in_synpred6_tiger927); if (state.failed) return;

		pushFollow(FOLLOW_stat_seq_in_synpred6_tiger929);
		stat_seq();
		state._fsp--;
		if (state.failed) return;

		match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_synpred6_tiger931); if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_tiger

	// $ANTLR start synpred7_tiger
	public final void synpred7_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:529:4: ( value ASSIGN func_call )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:529:5: value ASSIGN func_call
		{
		pushFollow(FOLLOW_value_in_synpred7_tiger1092);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred7_tiger1094); if (state.failed) return;

		pushFollow(FOLLOW_func_call_in_synpred7_tiger1096);
		func_call();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_tiger

	// $ANTLR start synpred8_tiger
	public final void synpred8_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:552:5: ( constval binop_p0 )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:552:6: constval binop_p0
		{
		pushFollow(FOLLOW_constval_in_synpred8_tiger1231);
		constval();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_binop_p0_in_synpred8_tiger1233);
		binop_p0();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_tiger

	// $ANTLR start synpred9_tiger
	public final void synpred9_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:555:4: ( value binop_p0 )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:555:5: value binop_p0
		{
		pushFollow(FOLLOW_value_in_synpred9_tiger1264);
		value();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_binop_p0_in_synpred9_tiger1266);
		binop_p0();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_tiger

	// $ANTLR start synpred10_tiger
	public final void synpred10_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:558:4: ( LPAREN expr RPAREN binop_p0 )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:558:5: LPAREN expr RPAREN binop_p0
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred10_tiger1297); if (state.failed) return;

		pushFollow(FOLLOW_expr_in_synpred10_tiger1299);
		expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred10_tiger1301); if (state.failed) return;

		pushFollow(FOLLOW_binop_p0_in_synpred10_tiger1303);
		binop_p0();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred10_tiger

	// $ANTLR start synpred11_tiger
	public final void synpred11_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:570:5: ( fixedptlit )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:570:6: fixedptlit
		{
		pushFollow(FOLLOW_fixedptlit_in_synpred11_tiger1445);
		fixedptlit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred11_tiger

	// $ANTLR start synpred12_tiger
	public final void synpred12_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:597:6: ( ID LBRACK index_expr RBRACK LBRACK )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:597:7: ID LBRACK index_expr RBRACK LBRACK
		{
		match(input,ID,FOLLOW_ID_in_synpred12_tiger1602); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred12_tiger1604); if (state.failed) return;

		pushFollow(FOLLOW_index_expr_in_synpred12_tiger1606);
		index_expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred12_tiger1608); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred12_tiger1610); if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_tiger

	// $ANTLR start synpred13_tiger
	public final void synpred13_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:598:4: ( ID LBRACK )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:598:5: ID LBRACK
		{
		match(input,ID,FOLLOW_ID_in_synpred13_tiger1633); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred13_tiger1635); if (state.failed) return;

		}

	}
	// $ANTLR end synpred13_tiger

	// $ANTLR start synpred14_tiger
	public final void synpred14_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:603:4: ( intlit index_oper )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:603:5: intlit index_oper
		{
		pushFollow(FOLLOW_intlit_in_synpred14_tiger1664);
		intlit();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_index_oper_in_synpred14_tiger1666);
		index_oper();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred14_tiger

	// $ANTLR start synpred15_tiger
	public final void synpred15_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:606:4: ( ID index_oper )
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:606:5: ID index_oper
		{
		match(input,ID,FOLLOW_ID_in_synpred15_tiger1697); if (state.failed) return;

		pushFollow(FOLLOW_index_oper_in_synpred15_tiger1699);
		index_oper();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred15_tiger

	// Delegated rules

	public final boolean synpred11_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
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
	public final boolean synpred4_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred10_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred10_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred15_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred15_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program113 = new BitSet(new long[]{0x1000001210000000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list127 = new BitSet(new long[]{0x1000001210000002L});
	public static final BitSet FOLLOW_return_func_in_funct_declaration139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_void_func_in_funct_declaration144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_return_func156 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_return_func158 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_return_func160 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_return_func164 = new BitSet(new long[]{0x0008000200000000L});
	public static final BitSet FOLLOW_param_list_in_return_func166 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_return_func168 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_begin_in_return_func170 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_list_in_return_func172 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_return_func174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_void_func210 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_void_func212 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_void_func214 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_void_func218 = new BitSet(new long[]{0x0008000200000000L});
	public static final BitSet FOLLOW_param_list_in_void_func220 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_void_func222 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_begin_in_void_func224 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_list_in_void_func226 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_void_func228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_void_func254 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_void_func256 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_void_func260 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_void_func262 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_begin_in_void_func264 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_list_in_void_func266 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_void_func268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_END_KEY_in_block_end293 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block_end295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list329 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_param_list332 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list334 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ID_in_param365 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_param367 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_param369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list391 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_begin_in_block407 = new BitSet(new long[]{0x0900000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block410 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_block412 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_block415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_begin441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement455 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list471 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list485 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration498 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration500 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration502 = new BitSet(new long[]{0x0000001010000020L});
	public static final BitSet FOLLOW_type_in_type_declaration504 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type562 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type564 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_type568 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type570 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type572 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_type576 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type578 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type580 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_type582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type606 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type608 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_type610 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type612 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type614 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_type616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration691 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration693 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration695 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration697 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration699 = new BitSet(new long[]{0x0200040000000000L});
	public static final BitSet FOLLOW_fixedptlit_in_var_declaration701 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration745 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration747 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration749 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration751 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration753 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_var_declaration755 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration784 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration786 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration788 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration790 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list820 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_id_list823 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_id_list825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq848 = new BitSet(new long[]{0x2004000A20018002L});
	public static final BitSet FOLLOW_if_stat_in_stat860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_stat_in_stat884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_stat891 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_break_stat_in_stat899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_return_stat_in_stat904 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_if_stat937 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_if_stat939 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat941 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat943 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ELSE_KEY_in_if_stat945 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat947 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat949 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_if_stat974 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_if_stat976 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat978 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat980 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat982 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat984 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_while_stat1006 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_while_stat1008 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_DO_KEY_in_while_stat1010 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_while_stat1012 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_while_stat1014 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_while_stat1016 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_for_stat1039 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_for_stat1041 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_for_stat1043 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1045 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_for_stat1047 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1049 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_DO_KEY_in_for_stat1051 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_for_stat1053 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_for_stat1055 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_stat1057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat1101 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat1103 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_func_call_in_assign_stat1105 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat1107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat1123 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat1125 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_list_in_assign_stat1127 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call1151 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call1153 = new BitSet(new long[]{0x0608050200000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call1155 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_break_stat1180 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_break_stat1182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_return_stat1199 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_return_stat1201 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_return_stat1203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr1238 = new BitSet(new long[]{0x00019CC188200010L});
	public static final BitSet FOLLOW_binop_p0_in_expr1240 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr1258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_expr1271 = new BitSet(new long[]{0x00019CC188200010L});
	public static final BitSet FOLLOW_binop_p0_in_expr1273 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr1275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_expr1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_expr1308 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr1310 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr1312 = new BitSet(new long[]{0x00019CC188200010L});
	public static final BitSet FOLLOW_binop_p0_in_expr1314 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr1316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_expr1336 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr1338 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr1340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p01359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p01363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p01367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_binop_p11375 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEQ_in_binop_p11379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSER_in_binop_p11383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_binop_p11387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEREQ_in_binop_p11391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQ_in_binop_p11395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p2_in_binop_p11399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p21412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p21416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p21420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fixedptlit_in_constval1450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_constval1455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_intlit1465 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_intlit1468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_fixedptlit1492 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_FIXEDPTLIT_in_fixedptlit1495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list1569 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list1572 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr_list1574 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ID_in_value1615 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1617 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1619 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1621 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1623 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1625 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1640 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1642 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1644 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1646 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_index_expr1671 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1673 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_index_expr1691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1704 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1706 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1708 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1724 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list1841 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list1844 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_func_param_list1846 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_VOID_KEY_in_synpred1_tiger203 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_synpred1_tiger205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_synpred2_tiger542 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred2_tiger544 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger546 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred2_tiger548 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred2_tiger550 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger552 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred2_tiger554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_synpred3_tiger676 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_synpred3_tiger678 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_synpred3_tiger680 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_synpred3_tiger682 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred3_tiger684 = new BitSet(new long[]{0x0200040000000000L});
	public static final BitSet FOLLOW_fixedptlit_in_synpred3_tiger686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_synpred4_tiger730 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_synpred4_tiger732 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_synpred4_tiger734 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_synpred4_tiger736 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred4_tiger738 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_synpred4_tiger740 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred5_tiger877 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred5_tiger879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_synpred6_tiger923 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_synpred6_tiger925 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_synpred6_tiger927 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_synpred6_tiger929 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ELSE_KEY_in_synpred6_tiger931 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred7_tiger1092 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred7_tiger1094 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_func_call_in_synpred7_tiger1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_synpred8_tiger1231 = new BitSet(new long[]{0x00019CC188200010L});
	public static final BitSet FOLLOW_binop_p0_in_synpred8_tiger1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred9_tiger1264 = new BitSet(new long[]{0x00019CC188200010L});
	public static final BitSet FOLLOW_binop_p0_in_synpred9_tiger1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred10_tiger1297 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_synpred10_tiger1299 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred10_tiger1301 = new BitSet(new long[]{0x00019CC188200010L});
	public static final BitSet FOLLOW_binop_p0_in_synpred10_tiger1303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fixedptlit_in_synpred11_tiger1445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred12_tiger1602 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred12_tiger1604 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_synpred12_tiger1606 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred12_tiger1608 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred12_tiger1610 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred13_tiger1633 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred13_tiger1635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_synpred14_tiger1664 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_synpred14_tiger1666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred15_tiger1697 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_synpred15_tiger1699 = new BitSet(new long[]{0x0000000000000002L});
}
