// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-11-09 11:04:24

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g"; }


	  private String func_name;
	  private SymbolTable symbolTable = new SymbolTable(); 
	  private List<String> irOutput = new ArrayList<String>();
	  private int currentTemp = 0;
	  private Scope GLOBAL_SCOPE = new Scope();
	  private Scope CURRENT_SCOPE = GLOBAL_SCOPE;

	  private static void outln(Object obj) {
	    System.out.println(obj);
	  }
	  
	  public String getTyping(String var1, String var2) {
	    if ((strip(var1).equals("int") && strip(var2).equals("fixedpt")) || (strip(var1).equals("fixedpt") && strip(var2).equals("int"))) {
	      return "fixedpt";
	    } else if (strip(var1).equals("int") && strip(var2).equals("int")) {
	      return "int";
	    } else if (strip(var1).equals("fixedpt") && strip(var2).equals("fixedpt")) {
	      return "fixedpt";
	    } else {
	      if (strip(var1).equals("int") && strip(var2).equals("fixedpt") && strip(var1).equals("fixedpt") && strip(var2).equals("int")) {
	        if (strip(var1).equals(strip(var2))) {
	          return strip(var1);
	        } else {
	          return null;
	        }
	      }
	      return null;
	    }
	  }
	  
	  public String strip(String id) {
	    return id.replaceAll("\\s","");
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:220:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:2: ( type_declaration_list funct_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:4: type_declaration_list funct_declaration_list
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:224:1: funct_declaration_list : ( funct_declaration )+ ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:2: ( ( funct_declaration )+ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:4: ( funct_declaration )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:4: ( funct_declaration )+
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:225:4: funct_declaration
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:228:1: funct_declaration : ( return_func | void_func );
	public final tigerParser.funct_declaration_return funct_declaration() throws RecognitionException {
		tigerParser.funct_declaration_return retval = new tigerParser.funct_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope return_func4 =null;
		ParserRuleReturnScope void_func5 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:229:2: ( return_func | void_func )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:229:4: return_func
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:230:4: void_func
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:233:1: return_func : type_id FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID type_id param_list block_list ) ;
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
		RewriteRuleTokenStream stream_FUNCTION_KEY=new RewriteRuleTokenStream(adaptor,"token FUNCTION_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:234:2: ( type_id FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID type_id param_list block_list ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:234:4: type_id FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end
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
			// elements: ID, block_list, param_list, type_id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 241:2: -> ^( ID type_id param_list block_list )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:241:5: ^( ID type_id param_list block_list )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:244:1: void_func : ( ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID VOID_KEY param_list block_list ) | VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end -> ^( MAIN_KEY block_list ) );
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
		RewriteRuleTokenStream stream_MAIN_KEY=new RewriteRuleTokenStream(adaptor,"token MAIN_KEY");
		RewriteRuleTokenStream stream_FUNCTION_KEY=new RewriteRuleTokenStream(adaptor,"token FUNCTION_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_VOID_KEY=new RewriteRuleTokenStream(adaptor,"token VOID_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_block_list=new RewriteRuleSubtreeStream(adaptor,"rule block_list");
		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");
		RewriteRuleSubtreeStream stream_param_list=new RewriteRuleSubtreeStream(adaptor,"rule param_list");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:2: ( ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end -> ^( ID VOID_KEY param_list block_list ) | VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end -> ^( MAIN_KEY block_list ) )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:4: ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list RPAREN begin block_list block_end
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
					// elements: block_list, ID, VOID_KEY, param_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 252:2: -> ^( ID VOID_KEY param_list block_list )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:252:5: ^( ID VOID_KEY param_list block_list )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:254:4: VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end
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
					// elements: MAIN_KEY, block_list
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 261:2: -> ^( MAIN_KEY block_list )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:261:5: ^( MAIN_KEY block_list )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:264:1: block_end : END_KEY SEMI ;
	public final tigerParser.block_end_return block_end() throws RecognitionException {
		tigerParser.block_end_return retval = new tigerParser.block_end_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token END_KEY31=null;
		Token SEMI32=null;

		CommonTree END_KEY31_tree=null;
		CommonTree SEMI32_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:265:2: ( END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:265:4: END_KEY SEMI
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:273:1: ret_type : ( VOID_KEY | type_id );
	public final tigerParser.ret_type_return ret_type() throws RecognitionException {
		tigerParser.ret_type_return retval = new tigerParser.ret_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY33=null;
		ParserRuleReturnScope type_id34 =null;

		CommonTree VOID_KEY33_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:274:2: ( VOID_KEY | type_id )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:274:4: VOID_KEY
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:275:4: type_id
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:278:1: param_list : ( param ( COMMA param )* )? -> ^( AST_PARAM_LIST ( ( param )+ )? ) ;
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:2: ( ( param ( COMMA param )* )? -> ^( AST_PARAM_LIST ( ( param )+ )? ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:4: ( param ( COMMA param )* )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:4: ( param ( COMMA param )* )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:5: param ( COMMA param )*
					{
					pushFollow(FOLLOW_param_in_param_list329);
					param35=param();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param.add(param35.getTree());
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:11: ( COMMA param )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:279:12: COMMA param
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
			// 280:2: -> ^( AST_PARAM_LIST ( ( param )+ )? )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:280:5: ^( AST_PARAM_LIST ( ( param )+ )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_PARAM_LIST, "AST_PARAM_LIST"), root_1);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:280:22: ( ( param )+ )?
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:283:1: param : ID COLON type_id -> ^( COLON ID type_id ) ;
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:284:3: ( ID COLON type_id -> ^( COLON ID type_id ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:284:5: ID COLON type_id
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
			// elements: ID, COLON, type_id
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 285:2: -> ^( COLON ID type_id )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:285:5: ^( COLON ID type_id )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:288:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block41 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:289:2: ( ( block )+ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:289:4: ( block )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:289:4: ( block )+
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:289:4: block
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:292:1: block : begin ( declaration_statement stat_seq ) block_end -> ^( AST_BLOCK ( declaration_statement )? stat_seq ) ;
	public final tigerParser.block_return block() throws RecognitionException {
		tigerParser.block_return retval = new tigerParser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope begin42 =null;
		ParserRuleReturnScope declaration_statement43 =null;
		ParserRuleReturnScope stat_seq44 =null;
		ParserRuleReturnScope block_end45 =null;

		RewriteRuleSubtreeStream stream_declaration_statement=new RewriteRuleSubtreeStream(adaptor,"rule declaration_statement");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");
		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:293:4: ( begin ( declaration_statement stat_seq ) block_end -> ^( AST_BLOCK ( declaration_statement )? stat_seq ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:293:6: begin ( declaration_statement stat_seq ) block_end
			{
			pushFollow(FOLLOW_begin_in_block407);
			begin42=begin();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_begin.add(begin42.getTree());
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:293:12: ( declaration_statement stat_seq )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:293:13: declaration_statement stat_seq
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
			// elements: declaration_statement, stat_seq
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 294:2: -> ^( AST_BLOCK ( declaration_statement )? stat_seq )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:294:6: ^( AST_BLOCK ( declaration_statement )? stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_BLOCK, "AST_BLOCK"), root_1);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:294:18: ( declaration_statement )?
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:297:1: begin : BEGIN_KEY ;
	public final tigerParser.begin_return begin() throws RecognitionException {
		tigerParser.begin_return retval = new tigerParser.begin_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BEGIN_KEY46=null;

		CommonTree BEGIN_KEY46_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:298:3: ( BEGIN_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:298:5: BEGIN_KEY
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:302:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list47 =null;
		ParserRuleReturnScope var_declaration_list48 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:303:2: ( type_declaration_list var_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:303:4: type_declaration_list var_declaration_list
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:306:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration49 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:307:2: ( ( type_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:307:5: ( type_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:307:5: ( type_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TYPE_KEY) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:307:5: type_declaration
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:310:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_declaration50 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:311:2: ( ( var_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:311:4: ( var_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:311:4: ( var_declaration )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==VAR_KEY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:311:4: var_declaration
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:314:1: type_declaration : TYPE_KEY ID EQ type[$ID.text] SEMI -> ^( EQ ID type ) ;
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
		RewriteRuleTokenStream stream_TYPE_KEY=new RewriteRuleTokenStream(adaptor,"token TYPE_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:315:2: ( TYPE_KEY ID EQ type[$ID.text] SEMI -> ^( EQ ID type ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:315:4: TYPE_KEY ID EQ type[$ID.text] SEMI
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
			// 316:2: -> ^( EQ ID type )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:316:5: ^( EQ ID type )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:319:1: type[String id] : ( base_type | ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id ) | ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY UNSIGNED_INTLIT type_id ) );
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
		RewriteRuleTokenStream stream_OF_KEY=new RewriteRuleTokenStream(adaptor,"token OF_KEY");
		RewriteRuleTokenStream stream_ARRAY_KEY=new RewriteRuleTokenStream(adaptor,"token ARRAY_KEY");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_UNSIGNED_INTLIT=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTLIT");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:320:3: ( base_type | ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id ) | ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id -> ^( ARRAY_KEY UNSIGNED_INTLIT type_id ) )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:320:5: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type534);
					base_type56=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type56.getTree());

					if ( state.backtracking==0 ) {
					    if ((base_type56!=null?input.toString(base_type56.start,base_type56.stop):null).equals("int")) { 
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT));
					    } else if ((base_type56!=null?input.toString(base_type56.start,base_type56.stop):null).equals("fixedpt")) {
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT));
					    }
					  }
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:327:4: ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY type_id
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
						    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_2D_ARRAY, toInteger((var1!=null?var1.getText():null)),toInteger((var2!=null?var2.getText():null))));
						  } else if ((type_id63!=null?input.toString(type_id63.start,type_id63.stop):null).equals("fixedpt")) {
						    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_2D_ARRAY, toInteger((var1!=null?var1.getText():null)),toInteger((var2!=null?var2.getText():null))));
						  }
						}
					// AST REWRITE
					// elements: ARRAY_KEY, UNSIGNED_INTLIT, UNSIGNED_INTLIT, type_id
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 335:2: -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:335:5: ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) type_id )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ARRAY_KEY.nextNode(), root_1);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:335:17: ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:336:4: ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY type_id
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
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_ARRAY, toInteger((UNSIGNED_INTLIT66!=null?UNSIGNED_INTLIT66.getText():null))));
					    } else if ((type_id69!=null?input.toString(type_id69.start,type_id69.stop):null).equals("fixedpt")) {
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_ARRAY, toInteger((UNSIGNED_INTLIT66!=null?UNSIGNED_INTLIT66.getText():null))));
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
					// 343:2: -> ^( ARRAY_KEY UNSIGNED_INTLIT type_id )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:343:5: ^( ARRAY_KEY UNSIGNED_INTLIT type_id )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:346:1: type_id : ( base_type | ID );
	public final tigerParser.type_id_return type_id() throws RecognitionException {
		tigerParser.type_id_return retval = new tigerParser.type_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID71=null;
		ParserRuleReturnScope base_type70 =null;

		CommonTree ID71_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:347:3: ( base_type | ID )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:347:5: base_type
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:348:4: ID
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:351:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set72=null;

		CommonTree set72_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:352:2: ( INT_KEY | FIXEDPT_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:356:1: var_declaration : ( ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit ) | ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT ) | VAR_KEY id_list COLON type_id SEMI -> ^( COLON id_list type_id ) );
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
		RewriteRuleTokenStream stream_VAR_KEY=new RewriteRuleTokenStream(adaptor,"token VAR_KEY");
		RewriteRuleTokenStream stream_UNSIGNED_INTLIT=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTLIT");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");
		RewriteRuleSubtreeStream stream_fixedptlit=new RewriteRuleSubtreeStream(adaptor,"rule fixedptlit");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:357:2: ( ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit ) | ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT ) | VAR_KEY id_list COLON type_id SEMI -> ^( COLON id_list type_id ) )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:357:4: ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI
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
					    		if (!strip((type_id76!=null?input.toString(type_id76.start,type_id76.stop):null)).equals("int") && !strip((type_id76!=null?input.toString(type_id76.start,type_id76.stop):null)).equals("fixedpt")) {
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
					    		          strip(id), 
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
					                  strip(id), 
					                  fp2DArray, (type_id76!=null?input.toString(type_id76.start,type_id76.stop):null)));
					             }
					          
					            break;
					            
					            case FIXEDPT:
					              for (String id: ids) {
					              // Gets rid of white space and adds to symbol table
					              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					                strip(id), 
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
					      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), toDouble((fixedptlit78!=null?input.toString(fixedptlit78.start,fixedptlit78.stop):null))));
					      		}
					      	}
					      	
						}
					// AST REWRITE
					// elements: id_list, ASSIGN, fixedptlit, COLON, type_id
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 427:2: -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:427:5: ^( ASSIGN ^( COLON id_list type_id ) fixedptlit )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:427:14: ^( COLON id_list type_id )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:428:4: ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI
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
							if (!strip((type_id83!=null?input.toString(type_id83.start,type_id83.stop):null)).equals("int") && !strip((type_id83!=null?input.toString(type_id83.start,type_id83.stop):null)).equals("fixedpt")) {
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
											    strip(id), 
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
					                strip(id), 
					                int2DArray, (type_id83!=null?input.toString(type_id83.start,type_id83.stop):null)));
										}
										
										break;
										
									case INT:
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
												symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
													strip(id), 
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
									strip(id), toInteger((UNSIGNED_INTLIT85!=null?UNSIGNED_INTLIT85.getText():null))));
								}
					        }
					        	}
					// AST REWRITE
					// elements: ASSIGN, UNSIGNED_INTLIT, COLON, id_list, type_id
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 499:2: -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:499:5: ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:499:14: ^( COLON id_list type_id )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:500:4: VAR_KEY id_list COLON type_id SEMI
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
					      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), new Integer(0)));
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
					// 508:2: -> ^( COLON id_list type_id )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:508:5: ^( COLON id_list type_id )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:512:1: id_list : ID ( COMMA id_list )? -> ^( AST_ID_LIST ( ID )+ ) ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID92=null;
		Token COMMA93=null;
		ParserRuleReturnScope id_list94 =null;

		CommonTree ID92_tree=null;
		CommonTree COMMA93_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:513:3: ( ID ( COMMA id_list )? -> ^( AST_ID_LIST ( ID )+ ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:513:5: ID ( COMMA id_list )?
			{
			ID92=(Token)match(input,ID,FOLLOW_ID_in_id_list820); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID92);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:513:8: ( COMMA id_list )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==COMMA) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:513:9: COMMA id_list
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
			// 514:2: -> ^( AST_ID_LIST ( ID )+ )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:514:5: ^( AST_ID_LIST ( ID )+ )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:517:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat95 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:518:2: ( ( stat )+ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:518:4: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:518:4: ( stat )+
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:518:4: stat
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:521:1: stat : ( if_stat | while_stat | for_stat | ( value ASSIGN )=> assign_stat | func_call SEMI !| break_stat | return_stat | block );
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:522:2: ( if_stat | while_stat | for_stat | ( value ASSIGN )=> assign_stat | func_call SEMI !| break_stat | return_stat | block )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:522:4: if_stat
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:523:4: while_stat
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:524:4: for_stat
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:525:5: ( value ASSIGN )=> assign_stat
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:526:5: func_call SEMI !
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:527:4: break_stat
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:528:4: return_stat
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:529:4: block
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:532:1: if_stat : ( ( IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY )=> IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY boolExpr1 stat_seq ^( ELSE_KEY stat_seq ) ) | IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY boolExpr1 stat_seq ) );
	public final tigerParser.if_stat_return if_stat() throws RecognitionException {
		tigerParser.if_stat_return retval = new tigerParser.if_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF_KEY105=null;
		Token LPAREN106=null;
		Token RPAREN108=null;
		Token THEN_KEY109=null;
		Token ELSE_KEY111=null;
		Token ENDIF_KEY113=null;
		Token SEMI114=null;
		Token IF_KEY115=null;
		Token LPAREN116=null;
		Token RPAREN118=null;
		Token THEN_KEY119=null;
		Token ENDIF_KEY121=null;
		Token SEMI122=null;
		ParserRuleReturnScope boolExpr1107 =null;
		ParserRuleReturnScope stat_seq110 =null;
		ParserRuleReturnScope stat_seq112 =null;
		ParserRuleReturnScope boolExpr1117 =null;
		ParserRuleReturnScope stat_seq120 =null;

		CommonTree IF_KEY105_tree=null;
		CommonTree LPAREN106_tree=null;
		CommonTree RPAREN108_tree=null;
		CommonTree THEN_KEY109_tree=null;
		CommonTree ELSE_KEY111_tree=null;
		CommonTree ENDIF_KEY113_tree=null;
		CommonTree SEMI114_tree=null;
		CommonTree IF_KEY115_tree=null;
		CommonTree LPAREN116_tree=null;
		CommonTree RPAREN118_tree=null;
		CommonTree THEN_KEY119_tree=null;
		CommonTree ENDIF_KEY121_tree=null;
		CommonTree SEMI122_tree=null;
		RewriteRuleTokenStream stream_THEN_KEY=new RewriteRuleTokenStream(adaptor,"token THEN_KEY");
		RewriteRuleTokenStream stream_IF_KEY=new RewriteRuleTokenStream(adaptor,"token IF_KEY");
		RewriteRuleTokenStream stream_ENDIF_KEY=new RewriteRuleTokenStream(adaptor,"token ENDIF_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ELSE_KEY=new RewriteRuleTokenStream(adaptor,"token ELSE_KEY");
		RewriteRuleSubtreeStream stream_boolExpr1=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr1");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:533:3: ( ( IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY )=> IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY boolExpr1 stat_seq ^( ELSE_KEY stat_seq ) ) | IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY boolExpr1 stat_seq ) )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:533:5: ( IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY )=> IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI
					{
					IF_KEY105=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat941); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY105);

					LPAREN106=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_if_stat943); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN106);

					pushFollow(FOLLOW_boolExpr1_in_if_stat945);
					boolExpr1107=boolExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_boolExpr1.add(boolExpr1107.getTree());
					RPAREN108=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_if_stat947); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN108);

					THEN_KEY109=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat949); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY109);

					pushFollow(FOLLOW_stat_seq_in_if_stat951);
					stat_seq110=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq110.getTree());
					ELSE_KEY111=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_if_stat953); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELSE_KEY.add(ELSE_KEY111);

					pushFollow(FOLLOW_stat_seq_in_if_stat955);
					stat_seq112=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq112.getTree());
					ENDIF_KEY113=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat957); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY113);

					SEMI114=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat959); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI114);

					// AST REWRITE
					// elements: IF_KEY, boolExpr1, stat_seq, ELSE_KEY, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 534:2: -> ^( IF_KEY boolExpr1 stat_seq ^( ELSE_KEY stat_seq ) )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:534:6: ^( IF_KEY boolExpr1 stat_seq ^( ELSE_KEY stat_seq ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_boolExpr1.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:534:34: ^( ELSE_KEY stat_seq )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:535:4: IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI
					{
					IF_KEY115=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat982); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY115);

					LPAREN116=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_if_stat984); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN116);

					pushFollow(FOLLOW_boolExpr1_in_if_stat986);
					boolExpr1117=boolExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_boolExpr1.add(boolExpr1117.getTree());
					RPAREN118=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_if_stat988); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN118);

					THEN_KEY119=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat990); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY119);

					pushFollow(FOLLOW_stat_seq_in_if_stat992);
					stat_seq120=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq120.getTree());
					ENDIF_KEY121=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat994); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY121);

					SEMI122=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat996); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI122);

					// AST REWRITE
					// elements: IF_KEY, stat_seq, boolExpr1
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 536:2: -> ^( IF_KEY boolExpr1 stat_seq )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:536:5: ^( IF_KEY boolExpr1 stat_seq )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_boolExpr1.nextTree());
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:539:1: while_stat : WHILE_KEY LPAREN boolExpr1 RPAREN DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY boolExpr1 stat_seq ) ;
	public final tigerParser.while_stat_return while_stat() throws RecognitionException {
		tigerParser.while_stat_return retval = new tigerParser.while_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHILE_KEY123=null;
		Token LPAREN124=null;
		Token RPAREN126=null;
		Token DO_KEY127=null;
		Token ENDDO_KEY129=null;
		Token SEMI130=null;
		ParserRuleReturnScope boolExpr1125 =null;
		ParserRuleReturnScope stat_seq128 =null;

		CommonTree WHILE_KEY123_tree=null;
		CommonTree LPAREN124_tree=null;
		CommonTree RPAREN126_tree=null;
		CommonTree DO_KEY127_tree=null;
		CommonTree ENDDO_KEY129_tree=null;
		CommonTree SEMI130_tree=null;
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_WHILE_KEY=new RewriteRuleTokenStream(adaptor,"token WHILE_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_boolExpr1=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr1");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:540:2: ( WHILE_KEY LPAREN boolExpr1 RPAREN DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY boolExpr1 stat_seq ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:540:4: WHILE_KEY LPAREN boolExpr1 RPAREN DO_KEY stat_seq ENDDO_KEY SEMI
			{
			WHILE_KEY123=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_while_stat1018); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_WHILE_KEY.add(WHILE_KEY123);

			LPAREN124=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_while_stat1020); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN124);

			pushFollow(FOLLOW_boolExpr1_in_while_stat1022);
			boolExpr1125=boolExpr1();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_boolExpr1.add(boolExpr1125.getTree());
			RPAREN126=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_while_stat1024); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN126);

			DO_KEY127=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_while_stat1026); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY127);

			pushFollow(FOLLOW_stat_seq_in_while_stat1028);
			stat_seq128=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq128.getTree());
			ENDDO_KEY129=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_while_stat1030); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY129);

			SEMI130=(Token)match(input,SEMI,FOLLOW_SEMI_in_while_stat1032); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI130);

			// AST REWRITE
			// elements: boolExpr1, WHILE_KEY, stat_seq
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 541:2: -> ^( WHILE_KEY boolExpr1 stat_seq )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:541:5: ^( WHILE_KEY boolExpr1 stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE_KEY.nextNode(), root_1);
				adaptor.addChild(root_1, stream_boolExpr1.nextTree());
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:544:1: for_stat : FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) ;
	public final tigerParser.for_stat_return for_stat() throws RecognitionException {
		tigerParser.for_stat_return retval = new tigerParser.for_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FOR_KEY131=null;
		Token ID132=null;
		Token ASSIGN133=null;
		Token TO_KEY135=null;
		Token DO_KEY137=null;
		Token ENDDO_KEY139=null;
		Token SEMI140=null;
		ParserRuleReturnScope index_expr134 =null;
		ParserRuleReturnScope index_expr136 =null;
		ParserRuleReturnScope stat_seq138 =null;

		CommonTree FOR_KEY131_tree=null;
		CommonTree ID132_tree=null;
		CommonTree ASSIGN133_tree=null;
		CommonTree TO_KEY135_tree=null;
		CommonTree DO_KEY137_tree=null;
		CommonTree ENDDO_KEY139_tree=null;
		CommonTree SEMI140_tree=null;
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_TO_KEY=new RewriteRuleTokenStream(adaptor,"token TO_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_FOR_KEY=new RewriteRuleTokenStream(adaptor,"token FOR_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:545:3: ( FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:545:5: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
			{
			FOR_KEY131=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_for_stat1055); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FOR_KEY.add(FOR_KEY131);

			ID132=(Token)match(input,ID,FOLLOW_ID_in_for_stat1057); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID132);

			ASSIGN133=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_for_stat1059); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN133);

			pushFollow(FOLLOW_index_expr_in_for_stat1061);
			index_expr134=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr134.getTree());
			TO_KEY135=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_for_stat1063); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TO_KEY.add(TO_KEY135);

			pushFollow(FOLLOW_index_expr_in_for_stat1065);
			index_expr136=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr136.getTree());
			DO_KEY137=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_for_stat1067); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY137);

			pushFollow(FOLLOW_stat_seq_in_for_stat1069);
			stat_seq138=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq138.getTree());
			ENDDO_KEY139=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_for_stat1071); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY139);

			SEMI140=(Token)match(input,SEMI,FOLLOW_SEMI_in_for_stat1073); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI140);

			// AST REWRITE
			// elements: ASSIGN, index_expr, TO_KEY, index_expr, stat_seq, FOR_KEY, ID
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 546:2: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:546:5: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:546:15: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:546:24: ^( ASSIGN ID index_expr )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:549:1: assign_stat : ( ( value ASSIGN func_call )=> value ASSIGN func_call SEMI -> ^( ASSIGN value func_call ) | ( value ASSIGN numExpr1 )=> value ASSIGN numExpr1 SEMI -> ^( ASSIGN value numExpr1 ) );
	public final tigerParser.assign_stat_return assign_stat() throws RecognitionException {
		tigerParser.assign_stat_return retval = new tigerParser.assign_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ASSIGN142=null;
		Token SEMI144=null;
		Token ASSIGN146=null;
		Token SEMI148=null;
		ParserRuleReturnScope value141 =null;
		ParserRuleReturnScope func_call143 =null;
		ParserRuleReturnScope value145 =null;
		ParserRuleReturnScope numExpr1147 =null;

		CommonTree ASSIGN142_tree=null;
		CommonTree SEMI144_tree=null;
		CommonTree ASSIGN146_tree=null;
		CommonTree SEMI148_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_numExpr1=new RewriteRuleSubtreeStream(adaptor,"rule numExpr1");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
		RewriteRuleSubtreeStream stream_func_call=new RewriteRuleSubtreeStream(adaptor,"rule func_call");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:550:2: ( ( value ASSIGN func_call )=> value ASSIGN func_call SEMI -> ^( ASSIGN value func_call ) | ( value ASSIGN numExpr1 )=> value ASSIGN numExpr1 SEMI -> ^( ASSIGN value numExpr1 ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==ID) ) {
				int LA17_1 = input.LA(2);
				if ( (synpred7_tiger()) ) {
					alt17=1;
				}
				else if ( (synpred8_tiger()) ) {
					alt17=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:550:4: ( value ASSIGN func_call )=> value ASSIGN func_call SEMI
					{
					pushFollow(FOLLOW_value_in_assign_stat1116);
					value141=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value141.getTree());
					ASSIGN142=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat1118); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN142);

					pushFollow(FOLLOW_func_call_in_assign_stat1120);
					func_call143=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_call.add(func_call143.getTree());
					SEMI144=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat1122); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI144);

					// AST REWRITE
					// elements: value, func_call, ASSIGN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 551:3: -> ^( ASSIGN value func_call )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:551:7: ^( ASSIGN value func_call )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:552:5: ( value ASSIGN numExpr1 )=> value ASSIGN numExpr1 SEMI
					{
					pushFollow(FOLLOW_value_in_assign_stat1151);
					value145=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value145.getTree());
					ASSIGN146=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat1153); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN146);

					pushFollow(FOLLOW_numExpr1_in_assign_stat1155);
					numExpr1147=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_numExpr1.add(numExpr1147.getTree());
					SEMI148=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat1157); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI148);

					if ( state.backtracking==0 ) {
					    System.out.println((numExpr1147!=null?((tigerParser.numExpr1_return)numExpr1147).type:null));
					  }
					// AST REWRITE
					// elements: ASSIGN, value, numExpr1
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 555:3: -> ^( ASSIGN value numExpr1 )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:555:6: ^( ASSIGN value numExpr1 )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_value.nextTree());
						adaptor.addChild(root_1, stream_numExpr1.nextTree());
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:558:1: func_call : ID LPAREN func_param_list RPAREN -> ^( AST_FUNC_CALL ID func_param_list ) ;
	public final tigerParser.func_call_return func_call() throws RecognitionException {
		tigerParser.func_call_return retval = new tigerParser.func_call_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID149=null;
		Token LPAREN150=null;
		Token RPAREN152=null;
		ParserRuleReturnScope func_param_list151 =null;

		CommonTree ID149_tree=null;
		CommonTree LPAREN150_tree=null;
		CommonTree RPAREN152_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_func_param_list=new RewriteRuleSubtreeStream(adaptor,"rule func_param_list");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:559:2: ( ID LPAREN func_param_list RPAREN -> ^( AST_FUNC_CALL ID func_param_list ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:559:4: ID LPAREN func_param_list RPAREN
			{
			ID149=(Token)match(input,ID,FOLLOW_ID_in_func_call1182); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID149);

			LPAREN150=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call1184); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN150);

			pushFollow(FOLLOW_func_param_list_in_func_call1186);
			func_param_list151=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_param_list.add(func_param_list151.getTree());
			RPAREN152=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call1188); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN152);

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
			// 560:2: -> ^( AST_FUNC_CALL ID func_param_list )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:560:5: ^( AST_FUNC_CALL ID func_param_list )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:563:1: break_stat : BREAK_KEY SEMI -> BREAK_KEY ;
	public final tigerParser.break_stat_return break_stat() throws RecognitionException {
		tigerParser.break_stat_return retval = new tigerParser.break_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BREAK_KEY153=null;
		Token SEMI154=null;

		CommonTree BREAK_KEY153_tree=null;
		CommonTree SEMI154_tree=null;
		RewriteRuleTokenStream stream_BREAK_KEY=new RewriteRuleTokenStream(adaptor,"token BREAK_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:564:2: ( BREAK_KEY SEMI -> BREAK_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:564:4: BREAK_KEY SEMI
			{
			BREAK_KEY153=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_break_stat1211); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BREAK_KEY.add(BREAK_KEY153);

			SEMI154=(Token)match(input,SEMI,FOLLOW_SEMI_in_break_stat1213); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI154);

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
			// 565:2: -> BREAK_KEY
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:568:1: return_stat : ( ( RETURN_KEY numExpr1 )=> RETURN_KEY numExpr1 SEMI -> ^( AST_RETURN_STAT RETURN_KEY numExpr1 ) | RETURN_KEY boolExpr1 SEMI -> ^( AST_RETURN_STAT RETURN_KEY boolExpr1 ) );
	public final tigerParser.return_stat_return return_stat() throws RecognitionException {
		tigerParser.return_stat_return retval = new tigerParser.return_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RETURN_KEY155=null;
		Token SEMI157=null;
		Token RETURN_KEY158=null;
		Token SEMI160=null;
		ParserRuleReturnScope numExpr1156 =null;
		ParserRuleReturnScope boolExpr1159 =null;

		CommonTree RETURN_KEY155_tree=null;
		CommonTree SEMI157_tree=null;
		CommonTree RETURN_KEY158_tree=null;
		CommonTree SEMI160_tree=null;
		RewriteRuleTokenStream stream_RETURN_KEY=new RewriteRuleTokenStream(adaptor,"token RETURN_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_numExpr1=new RewriteRuleSubtreeStream(adaptor,"rule numExpr1");
		RewriteRuleSubtreeStream stream_boolExpr1=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr1");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:569:2: ( ( RETURN_KEY numExpr1 )=> RETURN_KEY numExpr1 SEMI -> ^( AST_RETURN_STAT RETURN_KEY numExpr1 ) | RETURN_KEY boolExpr1 SEMI -> ^( AST_RETURN_STAT RETURN_KEY boolExpr1 ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==RETURN_KEY) ) {
				int LA18_1 = input.LA(2);
				if ( (synpred9_tiger()) ) {
					alt18=1;
				}
				else if ( (true) ) {
					alt18=2;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:569:4: ( RETURN_KEY numExpr1 )=> RETURN_KEY numExpr1 SEMI
					{
					RETURN_KEY155=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_return_stat1238); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RETURN_KEY.add(RETURN_KEY155);

					pushFollow(FOLLOW_numExpr1_in_return_stat1240);
					numExpr1156=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_numExpr1.add(numExpr1156.getTree());
					SEMI157=(Token)match(input,SEMI,FOLLOW_SEMI_in_return_stat1242); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI157);

					// AST REWRITE
					// elements: numExpr1, RETURN_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 570:2: -> ^( AST_RETURN_STAT RETURN_KEY numExpr1 )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:570:5: ^( AST_RETURN_STAT RETURN_KEY numExpr1 )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_RETURN_STAT, "AST_RETURN_STAT"), root_1);
						adaptor.addChild(root_1, stream_RETURN_KEY.nextNode());
						adaptor.addChild(root_1, stream_numExpr1.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:571:4: RETURN_KEY boolExpr1 SEMI
					{
					RETURN_KEY158=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_return_stat1258); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RETURN_KEY.add(RETURN_KEY158);

					pushFollow(FOLLOW_boolExpr1_in_return_stat1260);
					boolExpr1159=boolExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_boolExpr1.add(boolExpr1159.getTree());
					SEMI160=(Token)match(input,SEMI,FOLLOW_SEMI_in_return_stat1262); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI160);

					// AST REWRITE
					// elements: RETURN_KEY, boolExpr1
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 572:3: -> ^( AST_RETURN_STAT RETURN_KEY boolExpr1 )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:572:7: ^( AST_RETURN_STAT RETURN_KEY boolExpr1 )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_RETURN_STAT, "AST_RETURN_STAT"), root_1);
						adaptor.addChild(root_1, stream_RETURN_KEY.nextNode());
						adaptor.addChild(root_1, stream_boolExpr1.nextTree());
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
	// $ANTLR end "return_stat"


	public static class numExpr1_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "numExpr1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:575:1: numExpr1 returns [String type] : ( ( numExpr2 bin_op3 )=>val1= numExpr2 ( bin_op3 val2= numExpr2 )+ | numExpr2 );
	public final tigerParser.numExpr1_return numExpr1() throws RecognitionException {
		tigerParser.numExpr1_return retval = new tigerParser.numExpr1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope val1 =null;
		ParserRuleReturnScope val2 =null;
		ParserRuleReturnScope bin_op3161 =null;
		ParserRuleReturnScope numExpr2162 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:576:3: ( ( numExpr2 bin_op3 )=>val1= numExpr2 ( bin_op3 val2= numExpr2 )+ | numExpr2 )
			int alt20=2;
			switch ( input.LA(1) ) {
			case ID:
				{
				int LA20_1 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

				}
				break;
			case MINUS:
				{
				int LA20_2 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA20_3 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA20_4 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA20_5 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:576:5: ( numExpr2 bin_op3 )=>val1= numExpr2 ( bin_op3 val2= numExpr2 )+
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr2_in_numExpr11301);
					val1=numExpr2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, val1.getTree());

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:576:41: ( bin_op3 val2= numExpr2 )+
					int cnt19=0;
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0==MINUS||LA19_0==PLUS) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:576:42: bin_op3 val2= numExpr2
							{
							pushFollow(FOLLOW_bin_op3_in_numExpr11304);
							bin_op3161=bin_op3();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, bin_op3161.getTree());

							pushFollow(FOLLOW_numExpr2_in_numExpr11308);
							val2=numExpr2();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, val2.getTree());

							}
							break;

						default :
							if ( cnt19 >= 1 ) break loop19;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(19, input);
							throw eee;
						}
						cnt19++;
					}

					if ( state.backtracking==0 ) {
					    retval.type = getTyping((val1!=null?((tigerParser.numExpr2_return)val1).type:null), (val2!=null?((tigerParser.numExpr2_return)val2).type:null));
					    if (retval.type == null) {
					      System.out.println("Typing mismatch at line " + (val1!=null?(val1.start):null).getLine() + " between values " + (val1!=null?input.toString(val1.start,val1.stop):null) + " and " + (val2!=null?input.toString(val2.start,val2.stop):null));
					    }
					  }
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:582:5: numExpr2
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr2_in_numExpr11318);
					numExpr2162=numExpr2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr2162.getTree());

					if ( state.backtracking==0 ) {
					    retval.type = (numExpr2162!=null?((tigerParser.numExpr2_return)numExpr2162).type:null);
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
	// $ANTLR end "numExpr1"


	public static class bin_op3_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bin_op3"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:587:1: bin_op3 : ( PLUS | MINUS );
	public final tigerParser.bin_op3_return bin_op3() throws RecognitionException {
		tigerParser.bin_op3_return retval = new tigerParser.bin_op3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set163=null;

		CommonTree set163_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:588:3: ( PLUS | MINUS )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set163=input.LT(1);
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set163));
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
	// $ANTLR end "bin_op3"


	public static class numExpr2_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "numExpr2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:592:1: numExpr2 returns [String type] : ( ( numExpr3 bin_op4 )=>val1= numExpr3 ( bin_op4 val2= numExpr3 )+ | numExpr3 );
	public final tigerParser.numExpr2_return numExpr2() throws RecognitionException {
		tigerParser.numExpr2_return retval = new tigerParser.numExpr2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope val1 =null;
		ParserRuleReturnScope val2 =null;
		ParserRuleReturnScope bin_op4164 =null;
		ParserRuleReturnScope numExpr3165 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:593:3: ( ( numExpr3 bin_op4 )=>val1= numExpr3 ( bin_op4 val2= numExpr3 )+ | numExpr3 )
			int alt22=2;
			switch ( input.LA(1) ) {
			case ID:
				{
				int LA22_1 = input.LA(2);
				if ( (synpred11_tiger()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

				}
				break;
			case MINUS:
				{
				int LA22_2 = input.LA(2);
				if ( (synpred11_tiger()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA22_3 = input.LA(2);
				if ( (synpred11_tiger()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA22_4 = input.LA(2);
				if ( (synpred11_tiger()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA22_5 = input.LA(2);
				if ( (synpred11_tiger()) ) {
					alt22=1;
				}
				else if ( (true) ) {
					alt22=2;
				}

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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:593:5: ( numExpr3 bin_op4 )=>val1= numExpr3 ( bin_op4 val2= numExpr3 )+
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr3_in_numExpr21368);
					val1=numExpr3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, val1.getTree());

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:593:41: ( bin_op4 val2= numExpr3 )+
					int cnt21=0;
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==DIV||LA21_0==MULT) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:593:42: bin_op4 val2= numExpr3
							{
							pushFollow(FOLLOW_bin_op4_in_numExpr21371);
							bin_op4164=bin_op4();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, bin_op4164.getTree());

							pushFollow(FOLLOW_numExpr3_in_numExpr21375);
							val2=numExpr3();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, val2.getTree());

							}
							break;

						default :
							if ( cnt21 >= 1 ) break loop21;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(21, input);
							throw eee;
						}
						cnt21++;
					}

					if ( state.backtracking==0 ) {
					    retval.type = getTyping((val1!=null?((tigerParser.numExpr3_return)val1).type:null), (val2!=null?((tigerParser.numExpr3_return)val2).type:null));
					    if (retval.type == null) {
					      System.out.println("Typing mismatch at line " + (val1!=null?(val1.start):null).getLine() + " between values " + (val1!=null?input.toString(val1.start,val1.stop):null) + " and " + (val2!=null?input.toString(val2.start,val2.stop):null));
					    }
					  }
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:599:5: numExpr3
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr3_in_numExpr21385);
					numExpr3165=numExpr3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr3165.getTree());

					if ( state.backtracking==0 ) {
					    retval.type = (numExpr3165!=null?((tigerParser.numExpr3_return)numExpr3165).type:null);
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
	// $ANTLR end "numExpr2"


	public static class bin_op4_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bin_op4"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:604:1: bin_op4 : ( MULT | DIV );
	public final tigerParser.bin_op4_return bin_op4() throws RecognitionException {
		tigerParser.bin_op4_return retval = new tigerParser.bin_op4_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set166=null;

		CommonTree set166_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:605:3: ( MULT | DIV )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set166=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set166));
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
	// $ANTLR end "bin_op4"


	public static class numExpr3_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "numExpr3"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:609:1: numExpr3 returns [String type] : ( ( value )=> value | constval | LPAREN numExpr1 RPAREN );
	public final tigerParser.numExpr3_return numExpr3() throws RecognitionException {
		tigerParser.numExpr3_return retval = new tigerParser.numExpr3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN169=null;
		Token RPAREN171=null;
		ParserRuleReturnScope value167 =null;
		ParserRuleReturnScope constval168 =null;
		ParserRuleReturnScope numExpr1170 =null;

		CommonTree LPAREN169_tree=null;
		CommonTree RPAREN171_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:610:3: ( ( value )=> value | constval | LPAREN numExpr1 RPAREN )
			int alt23=3;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==ID) && (synpred12_tiger())) {
				alt23=1;
			}
			else if ( (LA23_0==MINUS||(LA23_0 >= UNSIGNED_FIXEDPTLIT && LA23_0 <= UNSIGNED_INTLIT)) ) {
				alt23=2;
			}
			else if ( (LA23_0==LPAREN) ) {
				alt23=3;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:610:5: ( value )=> value
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_value_in_numExpr31438);
					value167=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, value167.getTree());

					if ( state.backtracking==0 ) {
					    retval.type = (value167!=null?((tigerParser.value_return)value167).type:null);
					  }
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:613:5: constval
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_constval_in_numExpr31446);
					constval168=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constval168.getTree());

					if ( state.backtracking==0 ) {
					    retval.type = (constval168!=null?((tigerParser.constval_return)constval168).type:null);
					  }
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:616:5: LPAREN numExpr1 RPAREN
					{
					root_0 = (CommonTree)adaptor.nil();


					LPAREN169=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numExpr31454); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LPAREN169_tree = (CommonTree)adaptor.create(LPAREN169);
					adaptor.addChild(root_0, LPAREN169_tree);
					}

					pushFollow(FOLLOW_numExpr1_in_numExpr31456);
					numExpr1170=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr1170.getTree());

					RPAREN171=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numExpr31458); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RPAREN171_tree = (CommonTree)adaptor.create(RPAREN171);
					adaptor.addChild(root_0, RPAREN171_tree);
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
	// $ANTLR end "numExpr3"


	public static class boolExpr1_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "boolExpr1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:620:1: boolExpr1 : ( ( boolExpr2 bin_op1 )=> boolExpr2 ( bin_op1 boolExpr2 )+ | boolExpr2 );
	public final tigerParser.boolExpr1_return boolExpr1() throws RecognitionException {
		tigerParser.boolExpr1_return retval = new tigerParser.boolExpr1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope boolExpr2172 =null;
		ParserRuleReturnScope bin_op1173 =null;
		ParserRuleReturnScope boolExpr2174 =null;
		ParserRuleReturnScope boolExpr2175 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:621:3: ( ( boolExpr2 bin_op1 )=> boolExpr2 ( bin_op1 boolExpr2 )+ | boolExpr2 )
			int alt25=2;
			switch ( input.LA(1) ) {
			case ID:
				{
				int LA25_1 = input.LA(2);
				if ( (synpred13_tiger()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case MINUS:
				{
				int LA25_2 = input.LA(2);
				if ( (synpred13_tiger()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA25_3 = input.LA(2);
				if ( (synpred13_tiger()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA25_4 = input.LA(2);
				if ( (synpred13_tiger()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA25_5 = input.LA(2);
				if ( (synpred13_tiger()) ) {
					alt25=1;
				}
				else if ( (true) ) {
					alt25=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:621:5: ( boolExpr2 bin_op1 )=> boolExpr2 ( bin_op1 boolExpr2 )+
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_boolExpr2_in_boolExpr11483);
					boolExpr2172=boolExpr2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolExpr2172.getTree());

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:621:38: ( bin_op1 boolExpr2 )+
					int cnt24=0;
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==AND||LA24_0==OR) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:621:39: bin_op1 boolExpr2
							{
							pushFollow(FOLLOW_bin_op1_in_boolExpr11486);
							bin_op1173=bin_op1();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, bin_op1173.getTree());

							pushFollow(FOLLOW_boolExpr2_in_boolExpr11488);
							boolExpr2174=boolExpr2();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, boolExpr2174.getTree());

							}
							break;

						default :
							if ( cnt24 >= 1 ) break loop24;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(24, input);
							throw eee;
						}
						cnt24++;
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:622:5: boolExpr2
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_boolExpr2_in_boolExpr11497);
					boolExpr2175=boolExpr2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolExpr2175.getTree());

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
	// $ANTLR end "boolExpr1"


	public static class bin_op1_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bin_op1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:625:1: bin_op1 : ( AND | OR );
	public final tigerParser.bin_op1_return bin_op1() throws RecognitionException {
		tigerParser.bin_op1_return retval = new tigerParser.bin_op1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set176=null;

		CommonTree set176_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:626:3: ( AND | OR )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set176=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set176));
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
	// $ANTLR end "bin_op1"


	public static class boolExpr2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "boolExpr2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:630:1: boolExpr2 : ( ( numExpr1 bin_op2 )=> numExpr1 ( bin_op2 numExpr1 )+ | numExpr1 );
	public final tigerParser.boolExpr2_return boolExpr2() throws RecognitionException {
		tigerParser.boolExpr2_return retval = new tigerParser.boolExpr2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope numExpr1177 =null;
		ParserRuleReturnScope bin_op2178 =null;
		ParserRuleReturnScope numExpr1179 =null;
		ParserRuleReturnScope numExpr1180 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:631:3: ( ( numExpr1 bin_op2 )=> numExpr1 ( bin_op2 numExpr1 )+ | numExpr1 )
			int alt27=2;
			switch ( input.LA(1) ) {
			case ID:
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
			case MINUS:
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
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA27_3 = input.LA(2);
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
				int LA27_4 = input.LA(2);
				if ( (synpred14_tiger()) ) {
					alt27=1;
				}
				else if ( (true) ) {
					alt27=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA27_5 = input.LA(2);
				if ( (synpred14_tiger()) ) {
					alt27=1;
				}
				else if ( (true) ) {
					alt27=2;
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:631:5: ( numExpr1 bin_op2 )=> numExpr1 ( bin_op2 numExpr1 )+
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr1_in_boolExpr21550);
					numExpr1177=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr1177.getTree());

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:631:36: ( bin_op2 numExpr1 )+
					int cnt26=0;
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0==EQ||(LA26_0 >= GREATER && LA26_0 <= GREATEREQ)||(LA26_0 >= LESSER && LA26_0 <= LESSEREQ)||LA26_0==NEQ) ) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:631:37: bin_op2 numExpr1
							{
							pushFollow(FOLLOW_bin_op2_in_boolExpr21553);
							bin_op2178=bin_op2();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, bin_op2178.getTree());

							pushFollow(FOLLOW_numExpr1_in_boolExpr21555);
							numExpr1179=numExpr1();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr1179.getTree());

							}
							break;

						default :
							if ( cnt26 >= 1 ) break loop26;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(26, input);
							throw eee;
						}
						cnt26++;
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:632:5: numExpr1
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr1_in_boolExpr21563);
					numExpr1180=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr1180.getTree());

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
	// $ANTLR end "boolExpr2"


	public static class bin_op2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bin_op2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:634:1: bin_op2 : ( LESSER | GREATER | EQ | NEQ | LESSEREQ | GREATEREQ );
	public final tigerParser.bin_op2_return bin_op2() throws RecognitionException {
		tigerParser.bin_op2_return retval = new tigerParser.bin_op2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set181=null;

		CommonTree set181_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:635:3: ( LESSER | GREATER | EQ | NEQ | LESSEREQ | GREATEREQ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set181=input.LT(1);
			if ( input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||input.LA(1)==NEQ ) {
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
	// $ANTLR end "bin_op2"


	public static class constval_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:643:1: constval returns [String type] : ( ( fixedptlit )=> fixedptlit | intlit );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope fixedptlit182 =null;
		ParserRuleReturnScope intlit183 =null;


		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:644:3: ( ( fixedptlit )=> fixedptlit | intlit )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==MINUS) ) {
				int LA28_1 = input.LA(2);
				if ( (synpred15_tiger()) ) {
					alt28=1;
				}
				else if ( (true) ) {
					alt28=2;
				}

			}
			else if ( (LA28_0==UNSIGNED_FIXEDPTLIT) && (synpred15_tiger())) {
				alt28=1;
			}
			else if ( (LA28_0==UNSIGNED_INTLIT) ) {
				alt28=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:644:5: ( fixedptlit )=> fixedptlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_fixedptlit_in_constval1629);
					fixedptlit182=fixedptlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fixedptlit182.getTree());

					if ( state.backtracking==0 ) {
					    retval.type = "fixedpt";
					  }
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:647:4: intlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intlit_in_constval1636);
					intlit183=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intlit183.getTree());

					if ( state.backtracking==0 ) {
						  retval.type = "int";
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
	// $ANTLR end "constval"


	public static class intlit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "intlit"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:652:1: intlit : ( MINUS )? UNSIGNED_INTLIT ;
	public final tigerParser.intlit_return intlit() throws RecognitionException {
		tigerParser.intlit_return retval = new tigerParser.intlit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS184=null;
		Token UNSIGNED_INTLIT185=null;

		CommonTree MINUS184_tree=null;
		CommonTree UNSIGNED_INTLIT185_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:652:8: ( ( MINUS )? UNSIGNED_INTLIT )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:652:10: ( MINUS )? UNSIGNED_INTLIT
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:652:10: ( MINUS )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==MINUS) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:652:10: MINUS
					{
					MINUS184=(Token)match(input,MINUS,FOLLOW_MINUS_in_intlit1648); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS184_tree = (CommonTree)adaptor.create(MINUS184);
					adaptor.addChild(root_0, MINUS184_tree);
					}

					}
					break;

			}

			UNSIGNED_INTLIT185=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_intlit1651); if (state.failed) return retval;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:657:1: fixedptlit : ( MINUS )? UNSIGNED_FIXEDPTLIT ;
	public final tigerParser.fixedptlit_return fixedptlit() throws RecognitionException {
		tigerParser.fixedptlit_return retval = new tigerParser.fixedptlit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS186=null;
		Token UNSIGNED_FIXEDPTLIT187=null;

		CommonTree MINUS186_tree=null;
		CommonTree UNSIGNED_FIXEDPTLIT187_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:658:2: ( ( MINUS )? UNSIGNED_FIXEDPTLIT )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:658:6: ( MINUS )? UNSIGNED_FIXEDPTLIT
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:658:6: ( MINUS )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==MINUS) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:658:6: MINUS
					{
					MINUS186=(Token)match(input,MINUS,FOLLOW_MINUS_in_fixedptlit1675); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS186_tree = (CommonTree)adaptor.create(MINUS186);
					adaptor.addChild(root_0, MINUS186_tree);
					}

					}
					break;

			}

			UNSIGNED_FIXEDPTLIT187=(Token)match(input,UNSIGNED_FIXEDPTLIT,FOLLOW_UNSIGNED_FIXEDPTLIT_in_fixedptlit1678); if (state.failed) return retval;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:665:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set188=null;

		CommonTree set188_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:666:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:669:1: expr_list : ( ( boolExpr1 )=> boolExpr1 ( COMMA boolExpr1 )* -> ^( AST_EXPR_LIST ( boolExpr1 )+ ) | numExpr1 ( COMMA numExpr1 )* -> ^( AST_EXPR_LIST ( numExpr1 )+ ) );
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA190=null;
		Token COMMA193=null;
		ParserRuleReturnScope boolExpr1189 =null;
		ParserRuleReturnScope boolExpr1191 =null;
		ParserRuleReturnScope numExpr1192 =null;
		ParserRuleReturnScope numExpr1194 =null;

		CommonTree COMMA190_tree=null;
		CommonTree COMMA193_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_numExpr1=new RewriteRuleSubtreeStream(adaptor,"rule numExpr1");
		RewriteRuleSubtreeStream stream_boolExpr1=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr1");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:670:2: ( ( boolExpr1 )=> boolExpr1 ( COMMA boolExpr1 )* -> ^( AST_EXPR_LIST ( boolExpr1 )+ ) | numExpr1 ( COMMA numExpr1 )* -> ^( AST_EXPR_LIST ( numExpr1 )+ ) )
			int alt33=2;
			switch ( input.LA(1) ) {
			case ID:
				{
				int LA33_1 = input.LA(2);
				if ( (synpred16_tiger()) ) {
					alt33=1;
				}
				else if ( (true) ) {
					alt33=2;
				}

				}
				break;
			case MINUS:
				{
				int LA33_2 = input.LA(2);
				if ( (synpred16_tiger()) ) {
					alt33=1;
				}
				else if ( (true) ) {
					alt33=2;
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA33_3 = input.LA(2);
				if ( (synpred16_tiger()) ) {
					alt33=1;
				}
				else if ( (true) ) {
					alt33=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA33_4 = input.LA(2);
				if ( (synpred16_tiger()) ) {
					alt33=1;
				}
				else if ( (true) ) {
					alt33=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA33_5 = input.LA(2);
				if ( (synpred16_tiger()) ) {
					alt33=1;
				}
				else if ( (true) ) {
					alt33=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}
			switch (alt33) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:670:4: ( boolExpr1 )=> boolExpr1 ( COMMA boolExpr1 )*
					{
					pushFollow(FOLLOW_boolExpr1_in_expr_list1758);
					boolExpr1189=boolExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_boolExpr1.add(boolExpr1189.getTree());
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:670:29: ( COMMA boolExpr1 )*
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==COMMA) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:670:30: COMMA boolExpr1
							{
							COMMA190=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1761); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA190);

							pushFollow(FOLLOW_boolExpr1_in_expr_list1763);
							boolExpr1191=boolExpr1();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_boolExpr1.add(boolExpr1191.getTree());
							}
							break;

						default :
							break loop31;
						}
					}

					// AST REWRITE
					// elements: boolExpr1
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 671:2: -> ^( AST_EXPR_LIST ( boolExpr1 )+ )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:671:5: ^( AST_EXPR_LIST ( boolExpr1 )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_EXPR_LIST, "AST_EXPR_LIST"), root_1);
						if ( !(stream_boolExpr1.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_boolExpr1.hasNext() ) {
							adaptor.addChild(root_1, stream_boolExpr1.nextTree());
						}
						stream_boolExpr1.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:672:5: numExpr1 ( COMMA numExpr1 )*
					{
					pushFollow(FOLLOW_numExpr1_in_expr_list1781);
					numExpr1192=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_numExpr1.add(numExpr1192.getTree());
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:672:14: ( COMMA numExpr1 )*
					loop32:
					while (true) {
						int alt32=2;
						int LA32_0 = input.LA(1);
						if ( (LA32_0==COMMA) ) {
							alt32=1;
						}

						switch (alt32) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:672:15: COMMA numExpr1
							{
							COMMA193=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1784); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA193);

							pushFollow(FOLLOW_numExpr1_in_expr_list1786);
							numExpr1194=numExpr1();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_numExpr1.add(numExpr1194.getTree());
							}
							break;

						default :
							break loop32;
						}
					}

					// AST REWRITE
					// elements: numExpr1
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 673:3: -> ^( AST_EXPR_LIST ( numExpr1 )+ )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:673:7: ^( AST_EXPR_LIST ( numExpr1 )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_EXPR_LIST, "AST_EXPR_LIST"), root_1);
						if ( !(stream_numExpr1.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_numExpr1.hasNext() ) {
							adaptor.addChild(root_1, stream_numExpr1.nextTree());
						}
						stream_numExpr1.reset();

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
	// $ANTLR end "expr_list"


	public static class value_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:676:1: value returns [String type] : ( ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK | ( ID LBRACK )=> ID LBRACK index_expr RBRACK | ID );
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID195=null;
		Token LBRACK196=null;
		Token RBRACK198=null;
		Token LBRACK199=null;
		Token RBRACK201=null;
		Token ID202=null;
		Token LBRACK203=null;
		Token RBRACK205=null;
		Token ID206=null;
		ParserRuleReturnScope index_expr197 =null;
		ParserRuleReturnScope index_expr200 =null;
		ParserRuleReturnScope index_expr204 =null;

		CommonTree ID195_tree=null;
		CommonTree LBRACK196_tree=null;
		CommonTree RBRACK198_tree=null;
		CommonTree LBRACK199_tree=null;
		CommonTree RBRACK201_tree=null;
		CommonTree ID202_tree=null;
		CommonTree LBRACK203_tree=null;
		CommonTree RBRACK205_tree=null;
		CommonTree ID206_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:677:3: ( ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK | ( ID LBRACK )=> ID LBRACK index_expr RBRACK | ID )
			int alt34=3;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==ID) ) {
				int LA34_1 = input.LA(2);
				if ( (synpred17_tiger()) ) {
					alt34=1;
				}
				else if ( (synpred18_tiger()) ) {
					alt34=2;
				}
				else if ( (true) ) {
					alt34=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:677:5: ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
					{
					root_0 = (CommonTree)adaptor.nil();


					ID195=(Token)match(input,ID,FOLLOW_ID_in_value1830); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID195_tree = (CommonTree)adaptor.create(ID195);
					adaptor.addChild(root_0, ID195_tree);
					}

					LBRACK196=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1832); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK196_tree = (CommonTree)adaptor.create(LBRACK196);
					adaptor.addChild(root_0, LBRACK196_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1834);
					index_expr197=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr197.getTree());

					RBRACK198=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1836); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK198_tree = (CommonTree)adaptor.create(RBRACK198);
					adaptor.addChild(root_0, RBRACK198_tree);
					}

					LBRACK199=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1838); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK199_tree = (CommonTree)adaptor.create(LBRACK199);
					adaptor.addChild(root_0, LBRACK199_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1840);
					index_expr200=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr200.getTree());

					RBRACK201=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1842); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK201_tree = (CommonTree)adaptor.create(RBRACK201);
					adaptor.addChild(root_0, RBRACK201_tree);
					}

					if ( state.backtracking==0 ) {
					  	  SymbolTableEntry entry = symbolTable.get(strip((ID195!=null?ID195.getText():null)),CURRENT_SCOPE);
					  	  System.out.println(((TigerVariable)entry).getType());
					  	}
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:681:4: ( ID LBRACK )=> ID LBRACK index_expr RBRACK
					{
					root_0 = (CommonTree)adaptor.nil();


					ID202=(Token)match(input,ID,FOLLOW_ID_in_value1857); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID202_tree = (CommonTree)adaptor.create(ID202);
					adaptor.addChild(root_0, ID202_tree);
					}

					LBRACK203=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1859); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK203_tree = (CommonTree)adaptor.create(LBRACK203);
					adaptor.addChild(root_0, LBRACK203_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1861);
					index_expr204=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr204.getTree());

					RBRACK205=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1863); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK205_tree = (CommonTree)adaptor.create(RBRACK205);
					adaptor.addChild(root_0, RBRACK205_tree);
					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:682:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID206=(Token)match(input,ID,FOLLOW_ID_in_value1868); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID206_tree = (CommonTree)adaptor.create(ID206);
					adaptor.addChild(root_0, ID206_tree);
					}

					if ( state.backtracking==0 ) {
					      SymbolTableEntry entry = symbolTable.get(strip((ID206!=null?ID206.getText():null)),CURRENT_SCOPE);
					      retval.type = ((TigerVariable)entry).getType();
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:688:1: index_expr : ( ( intlit index_oper )=> intlit index_oper index_expr -> ^( index_oper intlit index_expr ) | intlit | ( ID index_oper )=> ID index_oper index_expr -> ^( index_oper ID index_expr ) | ID );
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID211=null;
		Token ID214=null;
		ParserRuleReturnScope intlit207 =null;
		ParserRuleReturnScope index_oper208 =null;
		ParserRuleReturnScope index_expr209 =null;
		ParserRuleReturnScope intlit210 =null;
		ParserRuleReturnScope index_oper212 =null;
		ParserRuleReturnScope index_expr213 =null;

		CommonTree ID211_tree=null;
		CommonTree ID214_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_intlit=new RewriteRuleSubtreeStream(adaptor,"rule intlit");
		RewriteRuleSubtreeStream stream_index_oper=new RewriteRuleSubtreeStream(adaptor,"rule index_oper");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:689:2: ( ( intlit index_oper )=> intlit index_oper index_expr -> ^( index_oper intlit index_expr ) | intlit | ( ID index_oper )=> ID index_oper index_expr -> ^( index_oper ID index_expr ) | ID )
			int alt35=4;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				int LA35_1 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt35=1;
				}
				else if ( (true) ) {
					alt35=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA35_2 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt35=1;
				}
				else if ( (true) ) {
					alt35=2;
				}

				}
				break;
			case ID:
				{
				int LA35_3 = input.LA(2);
				if ( (synpred20_tiger()) ) {
					alt35=3;
				}
				else if ( (true) ) {
					alt35=4;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}
			switch (alt35) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:689:4: ( intlit index_oper )=> intlit index_oper index_expr
					{
					pushFollow(FOLLOW_intlit_in_index_expr1890);
					intlit207=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_intlit.add(intlit207.getTree());
					pushFollow(FOLLOW_index_oper_in_index_expr1892);
					index_oper208=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_oper.add(index_oper208.getTree());
					pushFollow(FOLLOW_index_expr_in_index_expr1894);
					index_expr209=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr209.getTree());
					// AST REWRITE
					// elements: intlit, index_oper, index_expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 690:2: -> ^( index_oper intlit index_expr )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:690:5: ^( index_oper intlit index_expr )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:691:4: intlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intlit_in_index_expr1910);
					intlit210=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intlit210.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:692:4: ( ID index_oper )=> ID index_oper index_expr
					{
					ID211=(Token)match(input,ID,FOLLOW_ID_in_index_expr1923); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID211);

					pushFollow(FOLLOW_index_oper_in_index_expr1925);
					index_oper212=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_oper.add(index_oper212.getTree());
					pushFollow(FOLLOW_index_expr_in_index_expr1927);
					index_expr213=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr213.getTree());
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
					// 693:2: -> ^( index_oper ID index_expr )
					{
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:693:5: ^( index_oper ID index_expr )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:694:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID214=(Token)match(input,ID,FOLLOW_ID_in_index_expr1943); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID214_tree = (CommonTree)adaptor.create(ID214);
					adaptor.addChild(root_0, ID214_tree);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:697:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set215=null;

		CommonTree set215_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:698:2: ( ( PLUS | MINUS | MULT ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set215=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set215));
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:717:1: func_param_list : ( numExpr1 ( COMMA numExpr1 )* )? -> ^( AST_PARAM_LIST ( ( numExpr1 )+ )? ) ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA217=null;
		ParserRuleReturnScope numExpr1216 =null;
		ParserRuleReturnScope numExpr1218 =null;

		CommonTree COMMA217_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_numExpr1=new RewriteRuleSubtreeStream(adaptor,"rule numExpr1");

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:718:2: ( ( numExpr1 ( COMMA numExpr1 )* )? -> ^( AST_PARAM_LIST ( ( numExpr1 )+ )? ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:718:4: ( numExpr1 ( COMMA numExpr1 )* )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:718:4: ( numExpr1 ( COMMA numExpr1 )* )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==ID||LA37_0==LPAREN||LA37_0==MINUS||(LA37_0 >= UNSIGNED_FIXEDPTLIT && LA37_0 <= UNSIGNED_INTLIT)) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:718:5: numExpr1 ( COMMA numExpr1 )*
					{
					pushFollow(FOLLOW_numExpr1_in_func_param_list2060);
					numExpr1216=numExpr1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_numExpr1.add(numExpr1216.getTree());
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:718:14: ( COMMA numExpr1 )*
					loop36:
					while (true) {
						int alt36=2;
						int LA36_0 = input.LA(1);
						if ( (LA36_0==COMMA) ) {
							alt36=1;
						}

						switch (alt36) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:718:15: COMMA numExpr1
							{
							COMMA217=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list2063); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA217);

							pushFollow(FOLLOW_numExpr1_in_func_param_list2065);
							numExpr1218=numExpr1();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_numExpr1.add(numExpr1218.getTree());
							}
							break;

						default :
							break loop36;
						}
					}

					}
					break;

			}

			// AST REWRITE
			// elements: numExpr1
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 719:2: -> ^( AST_PARAM_LIST ( ( numExpr1 )+ )? )
			{
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:719:5: ^( AST_PARAM_LIST ( ( numExpr1 )+ )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_PARAM_LIST, "AST_PARAM_LIST"), root_1);
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:719:22: ( ( numExpr1 )+ )?
				if ( stream_numExpr1.hasNext() ) {
					if ( !(stream_numExpr1.hasNext()) ) {
						throw new RewriteEarlyExitException();
					}
					while ( stream_numExpr1.hasNext() ) {
						adaptor.addChild(root_1, stream_numExpr1.nextTree());
					}
					stream_numExpr1.reset();

				}
				stream_numExpr1.reset();

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:722:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set219=null;

		CommonTree set219_tree=null;

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:723:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set219=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= INT_KEY)||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= TYPE_KEY)||(input.LA(1) >= VAR_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set219));
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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:4: ( VOID_KEY FUNCTION_KEY )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:5: VOID_KEY FUNCTION_KEY
		{
		match(input,VOID_KEY,FOLLOW_VOID_KEY_in_synpred1_tiger203); if (state.failed) return;

		match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_synpred1_tiger205); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_tiger

	// $ANTLR start synpred2_tiger
	public final void synpred2_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:327:4: ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:327:5: ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK
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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:357:4: ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:357:5: VAR_KEY id_list COLON type_id ASSIGN fixedptlit
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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:428:4: ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:428:5: VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT
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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:525:5: ( value ASSIGN )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:525:6: value ASSIGN
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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:533:5: ( IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:533:6: IF_KEY LPAREN boolExpr1 RPAREN THEN_KEY stat_seq ELSE_KEY
		{
		match(input,IF_KEY,FOLLOW_IF_KEY_in_synpred6_tiger923); if (state.failed) return;

		match(input,LPAREN,FOLLOW_LPAREN_in_synpred6_tiger925); if (state.failed) return;

		pushFollow(FOLLOW_boolExpr1_in_synpred6_tiger927);
		boolExpr1();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred6_tiger929); if (state.failed) return;

		match(input,THEN_KEY,FOLLOW_THEN_KEY_in_synpred6_tiger931); if (state.failed) return;

		pushFollow(FOLLOW_stat_seq_in_synpred6_tiger933);
		stat_seq();
		state._fsp--;
		if (state.failed) return;

		match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_synpred6_tiger935); if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_tiger

	// $ANTLR start synpred7_tiger
	public final void synpred7_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:550:4: ( value ASSIGN func_call )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:550:5: value ASSIGN func_call
		{
		pushFollow(FOLLOW_value_in_synpred7_tiger1108);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred7_tiger1110); if (state.failed) return;

		pushFollow(FOLLOW_func_call_in_synpred7_tiger1112);
		func_call();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_tiger

	// $ANTLR start synpred8_tiger
	public final void synpred8_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:552:5: ( value ASSIGN numExpr1 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:552:6: value ASSIGN numExpr1
		{
		pushFollow(FOLLOW_value_in_synpred8_tiger1142);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred8_tiger1144); if (state.failed) return;

		pushFollow(FOLLOW_numExpr1_in_synpred8_tiger1146);
		numExpr1();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_tiger

	// $ANTLR start synpred9_tiger
	public final void synpred9_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:569:4: ( RETURN_KEY numExpr1 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:569:5: RETURN_KEY numExpr1
		{
		match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_synpred9_tiger1231); if (state.failed) return;

		pushFollow(FOLLOW_numExpr1_in_synpred9_tiger1233);
		numExpr1();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_tiger

	// $ANTLR start synpred10_tiger
	public final void synpred10_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:576:5: ( numExpr2 bin_op3 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:576:6: numExpr2 bin_op3
		{
		pushFollow(FOLLOW_numExpr2_in_synpred10_tiger1292);
		numExpr2();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_bin_op3_in_synpred10_tiger1294);
		bin_op3();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred10_tiger

	// $ANTLR start synpred11_tiger
	public final void synpred11_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:593:5: ( numExpr3 bin_op4 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:593:6: numExpr3 bin_op4
		{
		pushFollow(FOLLOW_numExpr3_in_synpred11_tiger1359);
		numExpr3();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_bin_op4_in_synpred11_tiger1361);
		bin_op4();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred11_tiger

	// $ANTLR start synpred12_tiger
	public final void synpred12_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:610:5: ( value )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:610:6: value
		{
		pushFollow(FOLLOW_value_in_synpred12_tiger1433);
		value();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_tiger

	// $ANTLR start synpred13_tiger
	public final void synpred13_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:621:5: ( boolExpr2 bin_op1 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:621:6: boolExpr2 bin_op1
		{
		pushFollow(FOLLOW_boolExpr2_in_synpred13_tiger1476);
		boolExpr2();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_bin_op1_in_synpred13_tiger1478);
		bin_op1();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred13_tiger

	// $ANTLR start synpred14_tiger
	public final void synpred14_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:631:5: ( numExpr1 bin_op2 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:631:6: numExpr1 bin_op2
		{
		pushFollow(FOLLOW_numExpr1_in_synpred14_tiger1543);
		numExpr1();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_bin_op2_in_synpred14_tiger1545);
		bin_op2();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred14_tiger

	// $ANTLR start synpred15_tiger
	public final void synpred15_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:644:5: ( fixedptlit )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:644:6: fixedptlit
		{
		pushFollow(FOLLOW_fixedptlit_in_synpred15_tiger1624);
		fixedptlit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred15_tiger

	// $ANTLR start synpred16_tiger
	public final void synpred16_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:670:4: ( boolExpr1 )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:670:5: boolExpr1
		{
		pushFollow(FOLLOW_boolExpr1_in_synpred16_tiger1753);
		boolExpr1();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred16_tiger

	// $ANTLR start synpred17_tiger
	public final void synpred17_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:677:5: ( ID LBRACK index_expr RBRACK LBRACK )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:677:6: ID LBRACK index_expr RBRACK LBRACK
		{
		match(input,ID,FOLLOW_ID_in_synpred17_tiger1817); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred17_tiger1819); if (state.failed) return;

		pushFollow(FOLLOW_index_expr_in_synpred17_tiger1821);
		index_expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred17_tiger1823); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred17_tiger1825); if (state.failed) return;

		}

	}
	// $ANTLR end synpred17_tiger

	// $ANTLR start synpred18_tiger
	public final void synpred18_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:681:4: ( ID LBRACK )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:681:5: ID LBRACK
		{
		match(input,ID,FOLLOW_ID_in_synpred18_tiger1850); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred18_tiger1852); if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_tiger

	// $ANTLR start synpred19_tiger
	public final void synpred19_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:689:4: ( intlit index_oper )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:689:5: intlit index_oper
		{
		pushFollow(FOLLOW_intlit_in_synpred19_tiger1883);
		intlit();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_index_oper_in_synpred19_tiger1885);
		index_oper();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred19_tiger

	// $ANTLR start synpred20_tiger
	public final void synpred20_tiger_fragment() throws RecognitionException {
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:692:4: ( ID index_oper )
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:692:5: ID index_oper
		{
		match(input,ID,FOLLOW_ID_in_synpred20_tiger1916); if (state.failed) return;

		pushFollow(FOLLOW_index_oper_in_synpred20_tiger1918);
		index_oper();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred20_tiger

	// Delegated rules

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
	public final boolean synpred20_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred20_tiger_fragment(); // can never throw exception
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
	public final boolean synpred18_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred18_tiger_fragment(); // can never throw exception
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
	public final boolean synpred19_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred19_tiger_fragment(); // can never throw exception
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
	public final boolean synpred17_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred17_tiger_fragment(); // can never throw exception
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
	public final boolean synpred16_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred16_tiger_fragment(); // can never throw exception
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
	public static final BitSet FOLLOW_IF_KEY_in_if_stat941 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_if_stat943 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr1_in_if_stat945 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_if_stat947 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat949 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat951 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ELSE_KEY_in_if_stat953 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat955 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat957 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_if_stat982 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_if_stat984 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr1_in_if_stat986 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_if_stat988 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat990 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat992 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat994 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_while_stat1018 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_while_stat1020 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr1_in_while_stat1022 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_while_stat1024 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_DO_KEY_in_while_stat1026 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_while_stat1028 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_while_stat1030 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_while_stat1032 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_for_stat1055 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_for_stat1057 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_for_stat1059 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1061 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_for_stat1063 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1065 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_DO_KEY_in_for_stat1067 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_for_stat1069 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_for_stat1071 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_stat1073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat1116 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat1118 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_func_call_in_assign_stat1120 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat1122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat1151 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat1153 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_assign_stat1155 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call1182 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call1184 = new BitSet(new long[]{0x0608050200000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call1186 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call1188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_break_stat1211 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_break_stat1213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_return_stat1238 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_return_stat1240 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_return_stat1242 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_return_stat1258 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr1_in_return_stat1260 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_return_stat1262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr2_in_numExpr11301 = new BitSet(new long[]{0x0001040000000000L});
	public static final BitSet FOLLOW_bin_op3_in_numExpr11304 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr2_in_numExpr11308 = new BitSet(new long[]{0x0001040000000002L});
	public static final BitSet FOLLOW_numExpr2_in_numExpr11318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr3_in_numExpr21368 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_bin_op4_in_numExpr21371 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr3_in_numExpr21375 = new BitSet(new long[]{0x0000080000200002L});
	public static final BitSet FOLLOW_numExpr3_in_numExpr21385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_numExpr31438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_numExpr31446 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_numExpr31454 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_numExpr31456 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_numExpr31458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolExpr2_in_boolExpr11483 = new BitSet(new long[]{0x0000800000000010L});
	public static final BitSet FOLLOW_bin_op1_in_boolExpr11486 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr2_in_boolExpr11488 = new BitSet(new long[]{0x0000800000000012L});
	public static final BitSet FOLLOW_boolExpr2_in_boolExpr11497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr1_in_boolExpr21550 = new BitSet(new long[]{0x000010C188000000L});
	public static final BitSet FOLLOW_bin_op2_in_boolExpr21553 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_boolExpr21555 = new BitSet(new long[]{0x000010C188000002L});
	public static final BitSet FOLLOW_numExpr1_in_boolExpr21563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fixedptlit_in_constval1629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_constval1636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_intlit1648 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_intlit1651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_fixedptlit1675 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_FIXEDPTLIT_in_fixedptlit1678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolExpr1_in_expr_list1758 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list1761 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr1_in_expr_list1763 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_numExpr1_in_expr_list1781 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list1784 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_expr_list1786 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ID_in_value1830 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1832 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1834 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1836 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1838 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1840 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1857 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1859 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1861 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_index_expr1890 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1892 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_index_expr1910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1923 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1925 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr1_in_func_param_list2060 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list2063 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_func_param_list2065 = new BitSet(new long[]{0x0000000000080002L});
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
	public static final BitSet FOLLOW_IF_KEY_in_synpred6_tiger923 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_synpred6_tiger925 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_boolExpr1_in_synpred6_tiger927 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred6_tiger929 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_synpred6_tiger931 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_synpred6_tiger933 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ELSE_KEY_in_synpred6_tiger935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred7_tiger1108 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred7_tiger1110 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_func_call_in_synpred7_tiger1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred8_tiger1142 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred8_tiger1144 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_synpred8_tiger1146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_synpred9_tiger1231 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr1_in_synpred9_tiger1233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr2_in_synpred10_tiger1292 = new BitSet(new long[]{0x0001040000000000L});
	public static final BitSet FOLLOW_bin_op3_in_synpred10_tiger1294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr3_in_synpred11_tiger1359 = new BitSet(new long[]{0x0000080000200000L});
	public static final BitSet FOLLOW_bin_op4_in_synpred11_tiger1361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred12_tiger1433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolExpr2_in_synpred13_tiger1476 = new BitSet(new long[]{0x0000800000000010L});
	public static final BitSet FOLLOW_bin_op1_in_synpred13_tiger1478 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr1_in_synpred14_tiger1543 = new BitSet(new long[]{0x000010C188000000L});
	public static final BitSet FOLLOW_bin_op2_in_synpred14_tiger1545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fixedptlit_in_synpred15_tiger1624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolExpr1_in_synpred16_tiger1753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred17_tiger1817 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred17_tiger1819 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_synpred17_tiger1821 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred17_tiger1823 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred17_tiger1825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred18_tiger1850 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred18_tiger1852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_synpred19_tiger1883 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_synpred19_tiger1885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred20_tiger1916 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_synpred20_tiger1918 = new BitSet(new long[]{0x0000000000000002L});
}
