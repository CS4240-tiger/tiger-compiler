// $ANTLR 3.5.1 /Users/cevanish12/git/tiger-compiler/tiger.g 2014-11-11 10:48:22

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
	@Override public String getGrammarFileName() { return "/Users/cevanish12/git/tiger-compiler/tiger.g"; }


	  private String func_name;
	  private SymbolTable symbolTable = new SymbolTable(); 
	  private Scope GLOBAL_SCOPE = new Scope();
	  private Scope CURRENT_SCOPE = GLOBAL_SCOPE;
	  private int numLoops;
	  
	  private static void outln(Object obj) {
	    System.out.println(obj);
	  }
	  
	  public OperationObject getTyping(OperationObject var1, OperationObject var2, int lineNum, String bin_op) {
	    if (var1 != null && var2 != null) {
		    boolean newisConst;
		    TypeSymbolTableEntry newType;
		    String newId = var1.getId()+bin_op+var2.getId();
		    if (var1.isConstant() && var2.isConstant()) {
		      newisConst = true;
		      if (!(var1.getType().equals(var2.getType()))) {
		        newType = symbolTable.getFixedPtType();
		      } else {
		        newType = var1.getType();
		      }
		      return new OperationObject(newisConst,newType,newId);
		    } else {
		      newisConst = false;
		      if ((var1.getType().getId().equals("int") && var2.getType().getId().equals("fixedpt"))||(var1.getType().getId().equals("fixedpt") && var2.getType().getId().equals("int"))) {
		        newType = symbolTable.getFixedPtType();
		        return new OperationObject(newisConst,newType, newId);
		      } else {
			      if (!(var1.getType().equals(var2.getType()))) {
			        System.out.println("Typing error between "+ var1.getId() + " and " + var2.getId() + " on line " + String.valueOf(lineNum));
			        return null;
			      } else {
			        newType = var1.getType();
			        return new OperationObject(newisConst,newType, newId);
			      }
		      }
		    }
	    } else {
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:233:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:234:2: ( type_declaration_list funct_declaration_list )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:234:4: type_declaration_list funct_declaration_list
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:237:1: funct_declaration_list : ( funct_declaration )+ ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:238:2: ( ( funct_declaration )+ )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:238:4: ( funct_declaration )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:238:4: ( funct_declaration )+
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:238:4: funct_declaration
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:241:1: funct_declaration : ( return_func | void_func );
	public final tigerParser.funct_declaration_return funct_declaration() throws RecognitionException {
		tigerParser.funct_declaration_return retval = new tigerParser.funct_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope return_func4 =null;
		ParserRuleReturnScope void_func5 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:242:2: ( return_func | void_func )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:242:4: return_func
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:243:4: void_func
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:246:1: return_func : type_id FUNCTION_KEY ID LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] RPAREN begin block_list block_end -> ^( ID param_list block_list ) ;
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
			// /Users/cevanish12/git/tiger-compiler/tiger.g:247:2: ( type_id FUNCTION_KEY ID LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] RPAREN begin block_list block_end -> ^( ID param_list block_list ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:247:4: type_id FUNCTION_KEY ID LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] RPAREN begin block_list block_end
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

			if ( state.backtracking==0 ) {
				    func_name = (ID8!=null?ID8.getText():null);
				    CURRENT_SCOPE = new Scope(CURRENT_SCOPE, (ID8!=null?ID8.getText():null));
				  }
			LPAREN9=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_return_func164); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN9);

			pushFollow(FOLLOW_param_list_in_return_func166);
			param_list10=param_list(new ArrayList<TypeSymbolTableEntry>());
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_param_list.add(param_list10.getTree());
			if ( state.backtracking==0 ) {
				    SymbolTableEntry type = symbolTable.get((type_id6!=null?input.toString(type_id6.start,type_id6.stop):null), CURRENT_SCOPE);
				    if (type != null && type instanceof TypeSymbolTableEntry) {
				      symbolTable.put(new FunctionSymbolTableEntry(GLOBAL_SCOPE, (ID8!=null?ID8.getText():null), ((TypeSymbolTableEntry) type),(param_list10!=null?((tigerParser.param_list_return)param_list10).outtypeList:null)));
				    } else {
				       System.out.println("The type " + (type_id6!=null?input.toString(type_id6.start,type_id6.stop):null) + "on line " + (type_id6!=null?(type_id6.start):null).getLine()+ " does not exist or is not in an accessible scope");
				    }
				  }
			RPAREN11=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_return_func171); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN11);

			pushFollow(FOLLOW_begin_in_return_func173);
			begin12=begin();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_begin.add(begin12.getTree());
			pushFollow(FOLLOW_block_list_in_return_func175);
			block_list13=block_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_list.add(block_list13.getTree());
			pushFollow(FOLLOW_block_end_in_return_func177);
			block_end14=block_end();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_end.add(block_end14.getTree());
			// AST REWRITE
			// elements: block_list, ID, param_list
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 258:2: -> ^( ID param_list block_list )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:258:5: ^( ID param_list block_list )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:261:1: void_func : ( ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] RPAREN begin block_list block_end -> ^( ID param_list block_list ) | VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end -> ^( MAIN_KEY block_list ) );
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
			// /Users/cevanish12/git/tiger-compiler/tiger.g:262:2: ( ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] RPAREN begin block_list block_end -> ^( ID param_list block_list ) | VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end -> ^( MAIN_KEY block_list ) )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:262:4: ( VOID_KEY FUNCTION_KEY )=> VOID_KEY FUNCTION_KEY ID LPAREN param_list[new ArrayList<TypeSymbolTableEntry>()] RPAREN begin block_list block_end
					{
					VOID_KEY15=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_void_func207); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VOID_KEY.add(VOID_KEY15);

					FUNCTION_KEY16=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_void_func209); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_FUNCTION_KEY.add(FUNCTION_KEY16);

					ID17=(Token)match(input,ID,FOLLOW_ID_in_void_func211); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID17);

					if ( state.backtracking==0 ) {
						    func_name = (ID17!=null?ID17.getText():null);
						    CURRENT_SCOPE = new Scope(CURRENT_SCOPE, (ID17!=null?ID17.getText():null));
						  }
					LPAREN18=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_void_func215); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN18);

					pushFollow(FOLLOW_param_list_in_void_func217);
					param_list19=param_list(new ArrayList<TypeSymbolTableEntry>());
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param_list.add(param_list19.getTree());
					if ( state.backtracking==0 ) {
					      symbolTable.put(new FunctionSymbolTableEntry(GLOBAL_SCOPE, (ID17!=null?ID17.getText():null), null, (param_list19!=null?((tigerParser.param_list_return)param_list19).outtypeList:null)));     
					    }
					RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_void_func225); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN20);

					pushFollow(FOLLOW_begin_in_void_func227);
					begin21=begin();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_begin.add(begin21.getTree());
					pushFollow(FOLLOW_block_list_in_void_func229);
					block_list22=block_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_list.add(block_list22.getTree());
					pushFollow(FOLLOW_block_end_in_void_func231);
					block_end23=block_end();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_end.add(block_end23.getTree());
					// AST REWRITE
					// elements: block_list, param_list, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 269:2: -> ^( ID param_list block_list )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:269:5: ^( ID param_list block_list )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ID.nextNode(), root_1);
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:271:4: VOID_KEY MAIN_KEY LPAREN RPAREN begin block_list block_end
					{
					VOID_KEY24=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_void_func251); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VOID_KEY.add(VOID_KEY24);

					MAIN_KEY25=(Token)match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_void_func253); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MAIN_KEY.add(MAIN_KEY25);

					if ( state.backtracking==0 ) {
						    func_name = (MAIN_KEY25!=null?MAIN_KEY25.getText():null);
						    symbolTable.put(new FunctionSymbolTableEntry(GLOBAL_SCOPE, (MAIN_KEY25!=null?MAIN_KEY25.getText():null), null, null));
					      CURRENT_SCOPE = new Scope(CURRENT_SCOPE, (MAIN_KEY25!=null?MAIN_KEY25.getText():null)); 
						  }
					LPAREN26=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_void_func257); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN26);

					RPAREN27=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_void_func259); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN27);

					pushFollow(FOLLOW_begin_in_void_func261);
					begin28=begin();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_begin.add(begin28.getTree());
					pushFollow(FOLLOW_block_list_in_void_func263);
					block_list29=block_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_list.add(block_list29.getTree());
					pushFollow(FOLLOW_block_end_in_void_func265);
					block_end30=block_end();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_block_end.add(block_end30.getTree());
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
					// 276:2: -> ^( MAIN_KEY block_list )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:276:5: ^( MAIN_KEY block_list )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:279:1: block_end : END_KEY SEMI ;
	public final tigerParser.block_end_return block_end() throws RecognitionException {
		tigerParser.block_end_return retval = new tigerParser.block_end_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token END_KEY31=null;
		Token SEMI32=null;

		CommonTree END_KEY31_tree=null;
		CommonTree SEMI32_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:280:2: ( END_KEY SEMI )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:280:4: END_KEY SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			END_KEY31=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_block_end286); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			END_KEY31_tree = (CommonTree)adaptor.create(END_KEY31);
			adaptor.addChild(root_0, END_KEY31_tree);
			}

			SEMI32=(Token)match(input,SEMI,FOLLOW_SEMI_in_block_end288); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SEMI32_tree = (CommonTree)adaptor.create(SEMI32);
			adaptor.addChild(root_0, SEMI32_tree);
			}

			if ( state.backtracking==0 ) {
						CURRENT_SCOPE = CURRENT_SCOPE.getParent();
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:286:1: ret_type : ( VOID_KEY | type_id );
	public final tigerParser.ret_type_return ret_type() throws RecognitionException {
		tigerParser.ret_type_return retval = new tigerParser.ret_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VOID_KEY33=null;
		ParserRuleReturnScope type_id34 =null;

		CommonTree VOID_KEY33_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:287:2: ( VOID_KEY | type_id )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:287:4: VOID_KEY
					{
					root_0 = (CommonTree)adaptor.nil();


					VOID_KEY33=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type304); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					VOID_KEY33_tree = (CommonTree)adaptor.create(VOID_KEY33);
					adaptor.addChild(root_0, VOID_KEY33_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:288:4: type_id
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_type_id_in_ret_type309);
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
		public List<TypeSymbolTableEntry> outtypeList;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:291:1: param_list[List<TypeSymbolTableEntry> intypeList] returns [List<TypeSymbolTableEntry> outtypeList] : (var1= param[intypeList] ( COMMA param[intypeList] )* )? -> ^( AST_PARAM_LIST ( ( param )+ )? ) ;
	public final tigerParser.param_list_return param_list(List<TypeSymbolTableEntry> intypeList) throws RecognitionException {
		tigerParser.param_list_return retval = new tigerParser.param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA35=null;
		ParserRuleReturnScope var1 =null;
		ParserRuleReturnScope param36 =null;

		CommonTree COMMA35_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:292:2: ( (var1= param[intypeList] ( COMMA param[intypeList] )* )? -> ^( AST_PARAM_LIST ( ( param )+ )? ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:292:4: (var1= param[intypeList] ( COMMA param[intypeList] )* )?
			{
			// /Users/cevanish12/git/tiger-compiler/tiger.g:292:4: (var1= param[intypeList] ( COMMA param[intypeList] )* )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:292:5: var1= param[intypeList] ( COMMA param[intypeList] )*
					{
					pushFollow(FOLLOW_param_in_param_list329);
					var1=param(intypeList);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_param.add(var1.getTree());
					if ( state.backtracking==0 ) {
						    retval.outtypeList = (var1!=null?((tigerParser.param_return)var1).outtypeList:null);
						  }
					// /Users/cevanish12/git/tiger-compiler/tiger.g:294:6: ( COMMA param[intypeList] )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/cevanish12/git/tiger-compiler/tiger.g:294:7: COMMA param[intypeList]
							{
							COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list334); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA35);

							pushFollow(FOLLOW_param_in_param_list336);
							param36=param(intypeList);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_param.add(param36.getTree());
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
			// 295:2: -> ^( AST_PARAM_LIST ( ( param )+ )? )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:295:5: ^( AST_PARAM_LIST ( ( param )+ )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_PARAM_LIST, "AST_PARAM_LIST"), root_1);
				// /Users/cevanish12/git/tiger-compiler/tiger.g:295:22: ( ( param )+ )?
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
		public List<TypeSymbolTableEntry> outtypeList;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "param"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:298:1: param[List<TypeSymbolTableEntry> intypeList] returns [List<TypeSymbolTableEntry> outtypeList] : ID COLON type_id -> ^( COLON ID type_id ) ;
	public final tigerParser.param_return param(List<TypeSymbolTableEntry> intypeList) throws RecognitionException {
		tigerParser.param_return retval = new tigerParser.param_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID37=null;
		Token COLON38=null;
		ParserRuleReturnScope type_id39 =null;

		CommonTree ID37_tree=null;
		CommonTree COLON38_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:299:3: ( ID COLON type_id -> ^( COLON ID type_id ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:299:5: ID COLON type_id
			{
			ID37=(Token)match(input,ID,FOLLOW_ID_in_param373); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID37);

			COLON38=(Token)match(input,COLON,FOLLOW_COLON_in_param375); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_COLON.add(COLON38);

			pushFollow(FOLLOW_type_id_in_param377);
			type_id39=type_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type_id.add(type_id39.getTree());
			if ( state.backtracking==0 ) {
			    if (!(type_id39!=null?input.toString(type_id39.start,type_id39.stop):null).equals("int") && !(type_id39!=null?input.toString(type_id39.start,type_id39.stop):null).equals("fixedpt")) {
			    SymbolTableEntry type = symbolTable.get((type_id39!=null?input.toString(type_id39.start,type_id39.stop):null), CURRENT_SCOPE);
			    if (type != null && type instanceof TypeSymbolTableEntry) {
			      intypeList.add((TypeSymbolTableEntry) type);
			      retval.outtypeList = intypeList;
			      symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip((ID37!=null?ID37.getText():null)), null, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
			    } else {
				    System.out.println("The type "+ (type_id39!=null?input.toString(type_id39.start,type_id39.stop):null)+" on line "+(type_id39!=null?(type_id39.start):null).getLine()+" was not declared yet");
			    }
			    } else {
			      if ((type_id39!=null?input.toString(type_id39.start,type_id39.stop):null).equals("int")) {
			        intypeList.add(symbolTable.getIntType());
			        retval.outtypeList = intypeList;
			        symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip((ID37!=null?ID37.getText():null)), null, symbolTable.getIntType(), TigerPrimitive.INT));
			      } else if ((type_id39!=null?input.toString(type_id39.start,type_id39.stop):null).equals("fixedpt")) {
			        intypeList.add(symbolTable.getFixedPtType());
			        retval.outtypeList = intypeList;
			        symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip((ID37!=null?ID37.getText():null)), null, symbolTable.getFixedPtType(), TigerPrimitive.FIXEDPT));
			      }
			    }
			    //System.out.println((ID37!=null?ID37.getText():null) + "added");
			  }
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
			// 322:2: -> ^( COLON ID type_id )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:322:5: ^( COLON ID type_id )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:325:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope block40 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:326:2: ( ( block )+ )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:326:4: ( block )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:326:4: ( block )+
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:326:4: block
					{
					pushFollow(FOLLOW_block_in_block_list401);
					block40=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block40.getTree());

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:329:1: block : begin ( declaration_statement stat_seq ) block_end -> ^( AST_BLOCK ( declaration_statement )? stat_seq ) ;
	public final tigerParser.block_return block() throws RecognitionException {
		tigerParser.block_return retval = new tigerParser.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope begin41 =null;
		ParserRuleReturnScope declaration_statement42 =null;
		ParserRuleReturnScope stat_seq43 =null;
		ParserRuleReturnScope block_end44 =null;

		RewriteRuleSubtreeStream stream_block_end=new RewriteRuleSubtreeStream(adaptor,"rule block_end");
		RewriteRuleSubtreeStream stream_declaration_statement=new RewriteRuleSubtreeStream(adaptor,"rule declaration_statement");
		RewriteRuleSubtreeStream stream_begin=new RewriteRuleSubtreeStream(adaptor,"rule begin");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:330:4: ( begin ( declaration_statement stat_seq ) block_end -> ^( AST_BLOCK ( declaration_statement )? stat_seq ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:330:6: begin ( declaration_statement stat_seq ) block_end
			{
			pushFollow(FOLLOW_begin_in_block417);
			begin41=begin();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_begin.add(begin41.getTree());
			// /Users/cevanish12/git/tiger-compiler/tiger.g:330:12: ( declaration_statement stat_seq )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:330:13: declaration_statement stat_seq
			{
			pushFollow(FOLLOW_declaration_statement_in_block420);
			declaration_statement42=declaration_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_declaration_statement.add(declaration_statement42.getTree());
			pushFollow(FOLLOW_stat_seq_in_block422);
			stat_seq43=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq43.getTree());
			}

			pushFollow(FOLLOW_block_end_in_block425);
			block_end44=block_end();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_block_end.add(block_end44.getTree());
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
			// 331:2: -> ^( AST_BLOCK ( declaration_statement )? stat_seq )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:331:6: ^( AST_BLOCK ( declaration_statement )? stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_BLOCK, "AST_BLOCK"), root_1);
				// /Users/cevanish12/git/tiger-compiler/tiger.g:331:18: ( declaration_statement )?
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:334:1: begin : BEGIN_KEY ;
	public final tigerParser.begin_return begin() throws RecognitionException {
		tigerParser.begin_return retval = new tigerParser.begin_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BEGIN_KEY45=null;

		CommonTree BEGIN_KEY45_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:335:3: ( BEGIN_KEY )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:335:5: BEGIN_KEY
			{
			root_0 = (CommonTree)adaptor.nil();


			BEGIN_KEY45=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_begin451); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BEGIN_KEY45_tree = (CommonTree)adaptor.create(BEGIN_KEY45);
			adaptor.addChild(root_0, BEGIN_KEY45_tree);
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:339:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration_list46 =null;
		ParserRuleReturnScope var_declaration_list47 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:340:2: ( type_declaration_list var_declaration_list )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:340:4: type_declaration_list var_declaration_list
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement465);
			type_declaration_list46=type_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration_list46.getTree());

			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement467);
			var_declaration_list47=var_declaration_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration_list47.getTree());

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:343:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope type_declaration48 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:344:2: ( ( type_declaration )* )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:344:5: ( type_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:344:5: ( type_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TYPE_KEY) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:344:5: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list481);
					type_declaration48=type_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_declaration48.getTree());

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:347:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_declaration49 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:348:2: ( ( var_declaration )* )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:348:4: ( var_declaration )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:348:4: ( var_declaration )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==VAR_KEY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:348:4: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list495);
					var_declaration49=var_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_declaration49.getTree());

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:351:1: type_declaration : TYPE_KEY ID EQ type[$ID.text] SEMI -> ^( EQ ID type ) ;
	public final tigerParser.type_declaration_return type_declaration() throws RecognitionException {
		tigerParser.type_declaration_return retval = new tigerParser.type_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TYPE_KEY50=null;
		Token ID51=null;
		Token EQ52=null;
		Token SEMI54=null;
		ParserRuleReturnScope type53 =null;

		CommonTree TYPE_KEY50_tree=null;
		CommonTree ID51_tree=null;
		CommonTree EQ52_tree=null;
		CommonTree SEMI54_tree=null;
		RewriteRuleTokenStream stream_EQ=new RewriteRuleTokenStream(adaptor,"token EQ");
		RewriteRuleTokenStream stream_TYPE_KEY=new RewriteRuleTokenStream(adaptor,"token TYPE_KEY");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:352:2: ( TYPE_KEY ID EQ type[$ID.text] SEMI -> ^( EQ ID type ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:352:4: TYPE_KEY ID EQ type[$ID.text] SEMI
			{
			TYPE_KEY50=(Token)match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration508); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TYPE_KEY.add(TYPE_KEY50);

			ID51=(Token)match(input,ID,FOLLOW_ID_in_type_declaration510); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID51);

			EQ52=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration512); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EQ.add(EQ52);

			pushFollow(FOLLOW_type_in_type_declaration514);
			type53=type((ID51!=null?ID51.getText():null));
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_type.add(type53.getTree());
			SEMI54=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration517); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI54);

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
			// 353:2: -> ^( EQ ID type )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:353:5: ^( EQ ID type )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:356:1: type[String id] : ( base_type | ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY base_type -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) base_type ) | ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY base_type -> ^( ARRAY_KEY UNSIGNED_INTLIT base_type ) );
	public final tigerParser.type_return type(String id) throws RecognitionException {
		tigerParser.type_return retval = new tigerParser.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token var1=null;
		Token var2=null;
		Token ARRAY_KEY56=null;
		Token LBRACK57=null;
		Token RBRACK58=null;
		Token LBRACK59=null;
		Token RBRACK60=null;
		Token OF_KEY61=null;
		Token ARRAY_KEY63=null;
		Token LBRACK64=null;
		Token UNSIGNED_INTLIT65=null;
		Token RBRACK66=null;
		Token OF_KEY67=null;
		ParserRuleReturnScope base_type55 =null;
		ParserRuleReturnScope base_type62 =null;
		ParserRuleReturnScope base_type68 =null;

		CommonTree var1_tree=null;
		CommonTree var2_tree=null;
		CommonTree ARRAY_KEY56_tree=null;
		CommonTree LBRACK57_tree=null;
		CommonTree RBRACK58_tree=null;
		CommonTree LBRACK59_tree=null;
		CommonTree RBRACK60_tree=null;
		CommonTree OF_KEY61_tree=null;
		CommonTree ARRAY_KEY63_tree=null;
		CommonTree LBRACK64_tree=null;
		CommonTree UNSIGNED_INTLIT65_tree=null;
		CommonTree RBRACK66_tree=null;
		CommonTree OF_KEY67_tree=null;
		RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
		RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
		RewriteRuleTokenStream stream_OF_KEY=new RewriteRuleTokenStream(adaptor,"token OF_KEY");
		RewriteRuleTokenStream stream_ARRAY_KEY=new RewriteRuleTokenStream(adaptor,"token ARRAY_KEY");
		RewriteRuleTokenStream stream_UNSIGNED_INTLIT=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTLIT");
		RewriteRuleSubtreeStream stream_base_type=new RewriteRuleSubtreeStream(adaptor,"rule base_type");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:357:3: ( base_type | ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY base_type -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) base_type ) | ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY base_type -> ^( ARRAY_KEY UNSIGNED_INTLIT base_type ) )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:357:5: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type544);
					base_type55=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type55.getTree());

					if ( state.backtracking==0 ) {
					    if ((base_type55!=null?input.toString(base_type55.start,base_type55.stop):null).equals("int")) { 
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT));
					    } else if ((base_type55!=null?input.toString(base_type55.start,base_type55.stop):null).equals("fixedpt")) {
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT));
					    }
					  }
					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:364:4: ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )=> ARRAY_KEY LBRACK var1= UNSIGNED_INTLIT RBRACK LBRACK var2= UNSIGNED_INTLIT RBRACK OF_KEY base_type
					{
					ARRAY_KEY56=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type572); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARRAY_KEY.add(ARRAY_KEY56);

					LBRACK57=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type574); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK57);

					var1=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_type578); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(var1);

					RBRACK58=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type580); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK58);

					LBRACK59=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type582); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK59);

					var2=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_type586); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(var2);

					RBRACK60=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type588); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK60);

					OF_KEY61=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type590); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OF_KEY.add(OF_KEY61);

					pushFollow(FOLLOW_base_type_in_type592);
					base_type62=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_base_type.add(base_type62.getTree());
					if ( state.backtracking==0 ) {
						  if ((base_type62!=null?input.toString(base_type62.start,base_type62.stop):null).equals("int")) { 
						    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_2D_ARRAY, toInteger((var1!=null?var1.getText():null)),toInteger((var2!=null?var2.getText():null))));
						  } else if ((base_type62!=null?input.toString(base_type62.start,base_type62.stop):null).equals("fixedpt")) {
						    symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_2D_ARRAY, toInteger((var1!=null?var1.getText():null)),toInteger((var2!=null?var2.getText():null))));
						  } 
						}
					// AST REWRITE
					// elements: UNSIGNED_INTLIT, UNSIGNED_INTLIT, base_type, ARRAY_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 372:2: -> ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) base_type )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:372:5: ^( ARRAY_KEY ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT ) base_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ARRAY_KEY.nextNode(), root_1);
						// /Users/cevanish12/git/tiger-compiler/tiger.g:372:17: ^( AST_2D_ARRAY UNSIGNED_INTLIT UNSIGNED_INTLIT )
						{
						CommonTree root_2 = (CommonTree)adaptor.nil();
						root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_2D_ARRAY, "AST_2D_ARRAY"), root_2);
						adaptor.addChild(root_2, stream_UNSIGNED_INTLIT.nextNode());
						adaptor.addChild(root_2, stream_UNSIGNED_INTLIT.nextNode());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_1, stream_base_type.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:373:4: ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK OF_KEY base_type
					{
					ARRAY_KEY63=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type616); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ARRAY_KEY.add(ARRAY_KEY63);

					LBRACK64=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type618); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK64);

					UNSIGNED_INTLIT65=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_type620); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(UNSIGNED_INTLIT65);

					RBRACK66=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type622); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK66);

					OF_KEY67=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type624); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OF_KEY.add(OF_KEY67);

					pushFollow(FOLLOW_base_type_in_type626);
					base_type68=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_base_type.add(base_type68.getTree());
					if ( state.backtracking==0 ) {
						  if ((base_type68!=null?input.toString(base_type68.start,base_type68.stop):null).equals("int")) { 
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.INT_ARRAY, toInteger((UNSIGNED_INTLIT65!=null?UNSIGNED_INTLIT65.getText():null))));
					    } else if ((base_type68!=null?input.toString(base_type68.start,base_type68.stop):null).equals("fixedpt")) {
					      symbolTable.put(new TypeSymbolTableEntry(CURRENT_SCOPE,strip(id), TigerPrimitive.FIXEDPT_ARRAY, toInteger((UNSIGNED_INTLIT65!=null?UNSIGNED_INTLIT65.getText():null))));
					    }
						}
					// AST REWRITE
					// elements: UNSIGNED_INTLIT, base_type, ARRAY_KEY
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 380:2: -> ^( ARRAY_KEY UNSIGNED_INTLIT base_type )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:380:5: ^( ARRAY_KEY UNSIGNED_INTLIT base_type )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ARRAY_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_UNSIGNED_INTLIT.nextNode());
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
		return retval;
	}
	// $ANTLR end "type"


	public static class type_id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:383:1: type_id : ( base_type | ID );
	public final tigerParser.type_id_return type_id() throws RecognitionException {
		tigerParser.type_id_return retval = new tigerParser.type_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID70=null;
		ParserRuleReturnScope base_type69 =null;

		CommonTree ID70_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:384:3: ( base_type | ID )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:384:5: base_type
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_base_type_in_type_id652);
					base_type69=base_type();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, base_type69.getTree());

					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:385:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID70=(Token)match(input,ID,FOLLOW_ID_in_type_id657); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID70_tree = (CommonTree)adaptor.create(ID70);
					adaptor.addChild(root_0, ID70_tree);
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:388:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set71=null;

		CommonTree set71_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:389:2: ( INT_KEY | FIXEDPT_KEY )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set71=input.LT(1);
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set71));
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:393:1: var_declaration : ( ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit ) | ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT ) | VAR_KEY id_list COLON type_id SEMI -> ^( COLON id_list type_id ) );
	public final tigerParser.var_declaration_return var_declaration() throws RecognitionException {
		tigerParser.var_declaration_return retval = new tigerParser.var_declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VAR_KEY72=null;
		Token COLON74=null;
		Token ASSIGN76=null;
		Token SEMI78=null;
		Token VAR_KEY79=null;
		Token COLON81=null;
		Token ASSIGN83=null;
		Token UNSIGNED_INTLIT84=null;
		Token SEMI85=null;
		Token VAR_KEY86=null;
		Token COLON88=null;
		Token SEMI90=null;
		ParserRuleReturnScope id_list73 =null;
		ParserRuleReturnScope type_id75 =null;
		ParserRuleReturnScope fixedptlit77 =null;
		ParserRuleReturnScope id_list80 =null;
		ParserRuleReturnScope type_id82 =null;
		ParserRuleReturnScope id_list87 =null;
		ParserRuleReturnScope type_id89 =null;

		CommonTree VAR_KEY72_tree=null;
		CommonTree COLON74_tree=null;
		CommonTree ASSIGN76_tree=null;
		CommonTree SEMI78_tree=null;
		CommonTree VAR_KEY79_tree=null;
		CommonTree COLON81_tree=null;
		CommonTree ASSIGN83_tree=null;
		CommonTree UNSIGNED_INTLIT84_tree=null;
		CommonTree SEMI85_tree=null;
		CommonTree VAR_KEY86_tree=null;
		CommonTree COLON88_tree=null;
		CommonTree SEMI90_tree=null;
		RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
		RewriteRuleTokenStream stream_VAR_KEY=new RewriteRuleTokenStream(adaptor,"token VAR_KEY");
		RewriteRuleTokenStream stream_UNSIGNED_INTLIT=new RewriteRuleTokenStream(adaptor,"token UNSIGNED_INTLIT");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_type_id=new RewriteRuleSubtreeStream(adaptor,"rule type_id");
		RewriteRuleSubtreeStream stream_fixedptlit=new RewriteRuleSubtreeStream(adaptor,"rule fixedptlit");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:394:2: ( ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit ) | ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT ) | VAR_KEY id_list COLON type_id SEMI -> ^( COLON id_list type_id ) )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:394:4: ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )=> VAR_KEY id_list COLON type_id ASSIGN fixedptlit SEMI
					{
					VAR_KEY72=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration701); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VAR_KEY.add(VAR_KEY72);

					pushFollow(FOLLOW_id_list_in_var_declaration703);
					id_list73=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list73.getTree());
					COLON74=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration705); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON74);

					pushFollow(FOLLOW_type_id_in_var_declaration707);
					type_id75=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id75.getTree());
					ASSIGN76=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration709); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN76);

					pushFollow(FOLLOW_fixedptlit_in_var_declaration711);
					fixedptlit77=fixedptlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_fixedptlit.add(fixedptlit77.getTree());
					SEMI78=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration713); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI78);

					if ( state.backtracking==0 ) {   
						  	String idlist = (id_list73!=null?input.toString(id_list73.start,id_list73.stop):null); 
					    		String[] ids = idlist.split(",");
					    		// Check if it's not a base type
					    		if (!strip((type_id75!=null?input.toString(type_id75.start,type_id75.stop):null)).equals("int") && !strip((type_id75!=null?input.toString(type_id75.start,type_id75.stop):null)).equals("fixedpt")) {
					    		  // Gets the type and makes the variables for INT_ARRAY, INT_2D_ARRAY, and INT
					    		  SymbolTableEntry type = symbolTable.get((type_id75!=null?input.toString(type_id75.start,type_id75.stop):null), CURRENT_SCOPE);
					    		  
					    		  if (type != null && type instanceof TypeSymbolTableEntry) {
					    		    
					    		    switch (((TypeSymbolTableEntry) type).getBackingType()) {
					    		    
					    		    case FIXEDPT_ARRAY:
					    		      // Instantiates the 1D array
					    		      Double[] fpArray = (Double[]) make1DArray("fixedpt", 
					    		        ((TypeSymbolTableEntry) type).getWidth(), (fixedptlit77!=null?input.toString(fixedptlit77.start,fixedptlit77.stop):null));
					          
					    		      for (String id: ids) {
					    		        // Gets rid of white space and adds to symbol table
					    		        symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					    		          strip(id), 
					    		          fpArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
					    			 
					    		      }
					          
					    		    break;
					    		    
					    		    case FIXEDPT_2D_ARRAY:
					             // Instantiates the 2D array
					             Double[][] fp2DArray = (Double[][]) make2DArray("fixedpt", 
					               ((TypeSymbolTableEntry) type).getWidth(), 
					               ((TypeSymbolTableEntry) type).getHeight(), (fixedptlit77!=null?input.toString(fixedptlit77.start,fixedptlit77.stop):null));
					             for (String id: ids) {
					                // Gets rid of white space and adds to symbol table
					                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					                  strip(id), 
					                  fp2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
					             }
					          
					            break;
					            
					            case FIXEDPT:
					              for (String id: ids) {
					              // Gets rid of white space and adds to symbol table
					              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					                strip(id), 
					                toDouble((fixedptlit77!=null?input.toString(fixedptlit77.start,fixedptlit77.stop):null)), ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
					               
					              }
					          
					            break;
					          
					            default:
					              System.out.println("The type " + (type_id75!=null?input.toString(type_id75.start,type_id75.stop):null) + " on line " + (type_id75!=null?(type_id75.start):null).getLine()
					              + " is not of type int");
					          
					            break;
					            
					    		    }
					    		  } else {
					    		    System.out.println("The type " + (type_id75!=null?input.toString(type_id75.start,type_id75.stop):null) + 
					    		      " does not exist or is not in an accessible scope from " 
					    		      + (id_list73!=null?input.toString(id_list73.start,id_list73.stop):null) + " on line " + (type_id75!=null?(type_id75.start):null).getLine());
					    		  }
					    		} else {
					    		  if ((type_id75!=null?input.toString(type_id75.start,type_id75.stop):null).equals("fixedpt")) {
						    		  for (String id: ids) {
						      			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), toDouble((fixedptlit77!=null?input.toString(fixedptlit77.start,fixedptlit77.stop):null)), symbolTable.getFixedPtType(), TigerPrimitive.FIXEDPT));
						      			
						      		}
					      		} else if ((type_id75!=null?input.toString(type_id75.start,type_id75.stop):null).equals("int")) {
					      		  System.out.println("A fixedpt constant cannot be declared to a variable of type int on line "+(type_id75!=null?(type_id75.start):null).getLine());
					      		}
					      	}
					      	
						}
					// AST REWRITE
					// elements: ASSIGN, fixedptlit, id_list, COLON, type_id
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 471:2: -> ^( ASSIGN ^( COLON id_list type_id ) fixedptlit )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:471:5: ^( ASSIGN ^( COLON id_list type_id ) fixedptlit )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// /Users/cevanish12/git/tiger-compiler/tiger.g:471:14: ^( COLON id_list type_id )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:472:4: ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )=> VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT SEMI
					{
					VAR_KEY79=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration755); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VAR_KEY.add(VAR_KEY79);

					pushFollow(FOLLOW_id_list_in_var_declaration757);
					id_list80=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list80.getTree());
					COLON81=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration759); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON81);

					pushFollow(FOLLOW_type_id_in_var_declaration761);
					type_id82=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id82.getTree());
					ASSIGN83=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration763); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN83);

					UNSIGNED_INTLIT84=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_var_declaration765); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNSIGNED_INTLIT.add(UNSIGNED_INTLIT84);

					SEMI85=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration767); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI85);

					if ( state.backtracking==0 ) {
							String idlist = (id_list80!=null?input.toString(id_list80.start,id_list80.stop):null); 
							String[] ids = idlist.split(",");
							
							// Check if it's not a base type
							if (!strip((type_id82!=null?input.toString(type_id82.start,type_id82.stop):null)).equals("int") && !strip((type_id82!=null?input.toString(type_id82.start,type_id82.stop):null)).equals("fixedpt")) {
								// Gets the type and makes the variables for INT_ARRAY, INT_2D_ARRAY, and INT
								SymbolTableEntry type = symbolTable.get((type_id82!=null?input.toString(type_id82.start,type_id82.stop):null), CURRENT_SCOPE);
								// Check existence
								if (type != null && type instanceof TypeSymbolTableEntry) {
									switch (((TypeSymbolTableEntry) type).getBackingType()) {
									
									case INT_ARRAY:
										// Instantiates the 1D array
										Integer[] intArray = (Integer[]) make1DArray("int", 
											((TypeSymbolTableEntry) type).getWidth(), (UNSIGNED_INTLIT84!=null?UNSIGNED_INTLIT84.getText():null));
										
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
											  symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
											    strip(id), 
											    intArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
											    
										}
										
										break;
										
									case INT_2D_ARRAY:
										// Instantiates the 2D array
										Integer[][] int2DArray = (Integer[][]) make2DArray("int", 
											((TypeSymbolTableEntry) type).getWidth(), 
											((TypeSymbolTableEntry) type).getHeight(), (UNSIGNED_INTLIT84!=null?UNSIGNED_INTLIT84.getText():null));
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
										              symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
										                strip(id), 
										                int2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
										}
										
										break;
										
									case INT:
										for (String id: ids) {
											// Gets rid of white space and adds to symbol table
												symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
													strip(id), 
													toInteger((UNSIGNED_INTLIT84!=null?UNSIGNED_INTLIT84.getText():null)), ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
										}
										
										break;
										
									default:
										System.out.println("The type " + (type_id82!=null?input.toString(type_id82.start,type_id82.stop):null) + " on line " + (type_id82!=null?(type_id82.start):null).getLine()
											+ " is not of type int");
										
										break;
									}
								} else {
									System.out.println("The type " + (type_id82!=null?input.toString(type_id82.start,type_id82.stop):null) + 
										" does not exist or is not in an accessible scope from " 
										+ (id_list80!=null?input.toString(id_list80.start,id_list80.stop):null) + " on line " + (type_id82!=null?(type_id82.start):null).getLine());
								}
							} else {
								// Else, it's a primitive already
								if ((type_id82!=null?input.toString(type_id82.start,type_id82.stop):null).equals("int")) {
									for (String id: ids) {
										// Gets rid of white space and adds to symbol table
										symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), toInteger((UNSIGNED_INTLIT84!=null?UNSIGNED_INTLIT84.getText():null)), symbolTable.getIntType(), TigerPrimitive.INT));
										
									}
								} else if ((type_id82!=null?input.toString(type_id82.start,type_id82.stop):null).equals("fixedpt")) {
								  System.out.println("An int constant cannot be declared to a variable of type fixedpt on line "+(type_id82!=null?(type_id82.start):null).getLine());
								}
					        }
					        	}
					// AST REWRITE
					// elements: UNSIGNED_INTLIT, ASSIGN, id_list, type_id, COLON
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 548:2: -> ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:548:5: ^( ASSIGN ^( COLON id_list type_id ) UNSIGNED_INTLIT )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						// /Users/cevanish12/git/tiger-compiler/tiger.g:548:14: ^( COLON id_list type_id )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:549:4: VAR_KEY id_list COLON type_id SEMI
					{
					VAR_KEY86=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration794); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_VAR_KEY.add(VAR_KEY86);

					pushFollow(FOLLOW_id_list_in_var_declaration796);
					id_list87=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list87.getTree());
					COLON88=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration798); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COLON.add(COLON88);

					pushFollow(FOLLOW_type_id_in_var_declaration800);
					type_id89=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_type_id.add(type_id89.getTree());
					SEMI90=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration802); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI90);

					if ( state.backtracking==0 ) {   
					   		String idlist = (id_list87!=null?input.toString(id_list87.start,id_list87.stop):null); 
					    	String[] ids = idlist.split(",");
					    	if (!strip((type_id89!=null?input.toString(type_id89.start,type_id89.stop):null)).equals("int") && !strip((type_id89!=null?input.toString(type_id89.start,type_id89.stop):null)).equals("fixedpt")) {
					    	  //type of declared type is transferred to the variables
					    		SymbolTableEntry type = symbolTable.get((type_id89!=null?input.toString(type_id89.start,type_id89.stop):null), CURRENT_SCOPE);
					    		//checks if it exists 
					    		if (type != null && type instanceof TypeSymbolTableEntry) {
					    		  TigerPrimitive backingType = ((TypeSymbolTableEntry) type).getBackingType();
					    		  //prints warning that arrays are not initialized if the type are arrays and sets the value to null
					    		  if (backingType == TigerPrimitive.INT_ARRAY || backingType == TigerPrimitive.FIXEDPT_ARRAY || backingType == TigerPrimitive.INT_2D_ARRAY || backingType == TigerPrimitive.FIXEDPT_2D_ARRAY) {
					    		    switch (((TypeSymbolTableEntry) type).getBackingType()) {
					    		      case INT_ARRAY:
					    		        // Instantiates the 1D array into 0s
					    		        Integer[] intArray = (Integer[]) make1DArray("int", 
					    		        ((TypeSymbolTableEntry) type).getWidth(), "0");
					          
					    		        for (String id: ids) {
					    		          // Gets rid of white space and adds to symbol table
					    		          symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
					    		            strip(id), 
					    		            intArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
					                }
					              break;
					              case INT_2D_ARRAY:
								          // Instantiates the 2D array
								          Integer[][] int2DArray = (Integer[][]) make2DArray("int", 
								            ((TypeSymbolTableEntry) type).getWidth(), 
								            ((TypeSymbolTableEntry) type).getHeight(), "0");
								          for (String id: ids) {
								            // Gets rid of white space and adds to symbol table
									           symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
									             strip(id), 
									             int2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
								          }
								        break;
								        case FIXEDPT_ARRAY:
						              // Instantiates the 1D array
						              Double[] fpArray = (Double[]) make1DArray("fixedpt", 
						                ((TypeSymbolTableEntry) type).getWidth(), "0.0");
						          
						              for (String id: ids) {
						                // Gets rid of white space and adds to symbol table
						                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
						                  strip(id), 
						                  fpArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
						              }
						            break;
						            case FIXEDPT_2D_ARRAY:
						             // Instantiates the 2D array
						             Double[][] fp2DArray = (Double[][]) make2DArray("fixedpt", 
						               ((TypeSymbolTableEntry) type).getWidth(), 
						               ((TypeSymbolTableEntry) type).getHeight(), "0.0");
						             for (String id: ids) {
						                // Gets rid of white space and adds to symbol table
						                symbolTable.put(new TigerVariable(CURRENT_SCOPE, 
						                  strip(id), 
						                  fp2DArray, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
						             }
					             break;
					    		    }
					    		  } else {
					    		    //apparently gets set to null if not array according to piazza
					    		    System.out.println("WARNING:"+(id_list87!=null?input.toString(id_list87.start,id_list87.stop):null) +" are are not initialized on line "+ (type_id89!=null?(type_id89.start):null).getLine()+ " and will be set to null");
						    		  for (String id: ids) {
						    		    symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), null, ((TypeSymbolTableEntry) type), ((TypeSymbolTableEntry) type).getBackingType()));
						    		  }
					    		  }
					    		} else {
					    		  System.out.println("The type " + (type_id89!=null?input.toString(type_id89.start,type_id89.stop):null) + 
					          " does not exist or is not in an accessible scope from " 
					          + (id_list87!=null?input.toString(id_list87.start,id_list87.stop):null) + " on line " + (type_id89!=null?(type_id89.start):null).getLine());
					    		}
					    	} else {
					    	  // prints out warning
					    	  System.out.println("WARNING:"+(id_list87!=null?input.toString(id_list87.start,id_list87.stop):null) +" are are not initialized on line "+ (type_id89!=null?(type_id89.start):null).getLine()+ " and will be set to null");
					    		//initialiazes for both int and fixedpt.. to null
					    	  if (strip((type_id89!=null?input.toString(type_id89.start,type_id89.stop):null)).equals("int")) {
							   		for (String id: ids) {
						     			symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), null, symbolTable.getIntType(), TigerPrimitive.INT));
							   		}
						   		} else if (strip((type_id89!=null?input.toString(type_id89.start,type_id89.stop):null)).equals("fixedpt")) {
						   		   for (String id: ids) {
					            symbolTable.put(new TigerVariable(CURRENT_SCOPE, strip(id), null, symbolTable.getFixedPtType(), TigerPrimitive.FIXEDPT));
					          }
						   		}
					   		}
					  	}
					// AST REWRITE
					// elements: id_list, type_id, COLON
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 638:2: -> ^( COLON id_list type_id )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:638:5: ^( COLON id_list type_id )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:642:1: id_list : ID ( COMMA id_list )? -> ^( AST_ID_LIST ( ID )+ ) ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID91=null;
		Token COMMA92=null;
		ParserRuleReturnScope id_list93 =null;

		CommonTree ID91_tree=null;
		CommonTree COMMA92_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_id_list=new RewriteRuleSubtreeStream(adaptor,"rule id_list");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:643:3: ( ID ( COMMA id_list )? -> ^( AST_ID_LIST ( ID )+ ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:643:5: ID ( COMMA id_list )?
			{
			ID91=(Token)match(input,ID,FOLLOW_ID_in_id_list830); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID91);

			// /Users/cevanish12/git/tiger-compiler/tiger.g:643:8: ( COMMA id_list )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==COMMA) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:643:9: COMMA id_list
					{
					COMMA92=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list833); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA92);

					pushFollow(FOLLOW_id_list_in_id_list835);
					id_list93=id_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_id_list.add(id_list93.getTree());
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
			// 644:2: -> ^( AST_ID_LIST ( ID )+ )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:644:5: ^( AST_ID_LIST ( ID )+ )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:647:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat94 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:648:2: ( ( stat )+ )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:648:4: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:648:4: ( stat )+
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:648:4: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq858);
					stat94=stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stat94.getTree());

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:651:1: stat : ( if_stat | while_stat | for_stat | ( value ASSIGN )=> assign_stat | func_call SEMI !| break_stat | return_stat | block );
	public final tigerParser.stat_return stat() throws RecognitionException {
		tigerParser.stat_return retval = new tigerParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI100=null;
		ParserRuleReturnScope if_stat95 =null;
		ParserRuleReturnScope while_stat96 =null;
		ParserRuleReturnScope for_stat97 =null;
		ParserRuleReturnScope assign_stat98 =null;
		ParserRuleReturnScope func_call99 =null;
		ParserRuleReturnScope break_stat101 =null;
		ParserRuleReturnScope return_stat102 =null;
		ParserRuleReturnScope block103 =null;

		CommonTree SEMI100_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:652:2: ( if_stat | while_stat | for_stat | ( value ASSIGN )=> assign_stat | func_call SEMI !| break_stat | return_stat | block )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:652:4: if_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_if_stat_in_stat870);
					if_stat95=if_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stat95.getTree());

					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:653:4: while_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_while_stat_in_stat875);
					while_stat96=while_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stat96.getTree());

					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:654:4: for_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_for_stat_in_stat880);
					for_stat97=for_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stat97.getTree());

					}
					break;
				case 4 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:655:5: ( value ASSIGN )=> assign_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_assign_stat_in_stat894);
					assign_stat98=assign_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assign_stat98.getTree());

					}
					break;
				case 5 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:656:5: func_call SEMI !
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_func_call_in_stat901);
					func_call99=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_call99.getTree());

					SEMI100=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat903); if (state.failed) return retval;
					}
					break;
				case 6 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:657:4: break_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_break_stat_in_stat909);
					break_stat101=break_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, break_stat101.getTree());

					}
					break;
				case 7 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:658:4: return_stat
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_return_stat_in_stat914);
					return_stat102=return_stat();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, return_stat102.getTree());

					}
					break;
				case 8 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:659:4: block
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_block_in_stat919);
					block103=block();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, block103.getTree());

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:662:1: if_stat : ( ( IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY )=> IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) ) | IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ) );
	public final tigerParser.if_stat_return if_stat() throws RecognitionException {
		tigerParser.if_stat_return retval = new tigerParser.if_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IF_KEY104=null;
		Token LPAREN105=null;
		Token RPAREN107=null;
		Token THEN_KEY108=null;
		Token ELSE_KEY110=null;
		Token ENDIF_KEY112=null;
		Token SEMI113=null;
		Token IF_KEY114=null;
		Token LPAREN115=null;
		Token RPAREN117=null;
		Token THEN_KEY118=null;
		Token ENDIF_KEY120=null;
		Token SEMI121=null;
		ParserRuleReturnScope expr106 =null;
		ParserRuleReturnScope stat_seq109 =null;
		ParserRuleReturnScope stat_seq111 =null;
		ParserRuleReturnScope expr116 =null;
		ParserRuleReturnScope stat_seq119 =null;

		CommonTree IF_KEY104_tree=null;
		CommonTree LPAREN105_tree=null;
		CommonTree RPAREN107_tree=null;
		CommonTree THEN_KEY108_tree=null;
		CommonTree ELSE_KEY110_tree=null;
		CommonTree ENDIF_KEY112_tree=null;
		CommonTree SEMI113_tree=null;
		CommonTree IF_KEY114_tree=null;
		CommonTree LPAREN115_tree=null;
		CommonTree RPAREN117_tree=null;
		CommonTree THEN_KEY118_tree=null;
		CommonTree ENDIF_KEY120_tree=null;
		CommonTree SEMI121_tree=null;
		RewriteRuleTokenStream stream_ELSE_KEY=new RewriteRuleTokenStream(adaptor,"token ELSE_KEY");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ENDIF_KEY=new RewriteRuleTokenStream(adaptor,"token ENDIF_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_THEN_KEY=new RewriteRuleTokenStream(adaptor,"token THEN_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_IF_KEY=new RewriteRuleTokenStream(adaptor,"token IF_KEY");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:663:3: ( ( IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY )=> IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) ) | IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI -> ^( IF_KEY expr stat_seq ) )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:663:5: ( IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY )=> IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY stat_seq ENDIF_KEY SEMI
					{
					IF_KEY104=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat951); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY104);

					LPAREN105=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_if_stat953); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN105);

					pushFollow(FOLLOW_expr_in_if_stat955);
					expr106=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr106.getTree());
					RPAREN107=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_if_stat957); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN107);

					THEN_KEY108=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat959); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY108);

					pushFollow(FOLLOW_stat_seq_in_if_stat961);
					stat_seq109=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq109.getTree());
					ELSE_KEY110=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_if_stat963); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ELSE_KEY.add(ELSE_KEY110);

					pushFollow(FOLLOW_stat_seq_in_if_stat965);
					stat_seq111=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq111.getTree());
					ENDIF_KEY112=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat967); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY112);

					SEMI113=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat969); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI113);

					// AST REWRITE
					// elements: stat_seq, ELSE_KEY, stat_seq, IF_KEY, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 664:2: -> ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:664:6: ^( IF_KEY expr stat_seq ^( ELSE_KEY stat_seq ) )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						adaptor.addChild(root_1, stream_expr.nextTree());
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						// /Users/cevanish12/git/tiger-compiler/tiger.g:664:29: ^( ELSE_KEY stat_seq )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:665:4: IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ENDIF_KEY SEMI
					{
					IF_KEY114=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_if_stat992); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IF_KEY.add(IF_KEY114);

					LPAREN115=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_if_stat994); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN115);

					pushFollow(FOLLOW_expr_in_if_stat996);
					expr116=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr116.getTree());
					RPAREN117=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_if_stat998); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN117);

					THEN_KEY118=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_if_stat1000); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_THEN_KEY.add(THEN_KEY118);

					pushFollow(FOLLOW_stat_seq_in_if_stat1002);
					stat_seq119=stat_seq();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq119.getTree());
					ENDIF_KEY120=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_if_stat1004); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ENDIF_KEY.add(ENDIF_KEY120);

					SEMI121=(Token)match(input,SEMI,FOLLOW_SEMI_in_if_stat1006); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI121);

					// AST REWRITE
					// elements: expr, IF_KEY, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 666:2: -> ^( IF_KEY expr stat_seq )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:666:5: ^( IF_KEY expr stat_seq )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:669:1: while_stat : WHILE_KEY LPAREN expr RPAREN DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY expr stat_seq ) ;
	public final tigerParser.while_stat_return while_stat() throws RecognitionException {
		tigerParser.while_stat_return retval = new tigerParser.while_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHILE_KEY122=null;
		Token LPAREN123=null;
		Token RPAREN125=null;
		Token DO_KEY126=null;
		Token ENDDO_KEY128=null;
		Token SEMI129=null;
		ParserRuleReturnScope expr124 =null;
		ParserRuleReturnScope stat_seq127 =null;

		CommonTree WHILE_KEY122_tree=null;
		CommonTree LPAREN123_tree=null;
		CommonTree RPAREN125_tree=null;
		CommonTree DO_KEY126_tree=null;
		CommonTree ENDDO_KEY128_tree=null;
		CommonTree SEMI129_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ENDDO_KEY=new RewriteRuleTokenStream(adaptor,"token ENDDO_KEY");
		RewriteRuleTokenStream stream_DO_KEY=new RewriteRuleTokenStream(adaptor,"token DO_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_WHILE_KEY=new RewriteRuleTokenStream(adaptor,"token WHILE_KEY");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_stat_seq=new RewriteRuleSubtreeStream(adaptor,"rule stat_seq");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:670:2: ( WHILE_KEY LPAREN expr RPAREN DO_KEY stat_seq ENDDO_KEY SEMI -> ^( WHILE_KEY expr stat_seq ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:670:4: WHILE_KEY LPAREN expr RPAREN DO_KEY stat_seq ENDDO_KEY SEMI
			{
			WHILE_KEY122=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_while_stat1028); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_WHILE_KEY.add(WHILE_KEY122);

			LPAREN123=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_while_stat1030); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN123);

			pushFollow(FOLLOW_expr_in_while_stat1032);
			expr124=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr124.getTree());
			RPAREN125=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_while_stat1034); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN125);

			DO_KEY126=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_while_stat1036); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY126);

			if ( state.backtracking==0 ) {numLoops++;}
			pushFollow(FOLLOW_stat_seq_in_while_stat1040);
			stat_seq127=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq127.getTree());
			ENDDO_KEY128=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_while_stat1042); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY128);

			SEMI129=(Token)match(input,SEMI,FOLLOW_SEMI_in_while_stat1044); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI129);

			if ( state.backtracking==0 ) {
				  numLoops--;
				}
			// AST REWRITE
			// elements: WHILE_KEY, stat_seq, expr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 673:2: -> ^( WHILE_KEY expr stat_seq )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:673:5: ^( WHILE_KEY expr stat_seq )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:676:1: for_stat : FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) ;
	public final tigerParser.for_stat_return for_stat() throws RecognitionException {
		tigerParser.for_stat_return retval = new tigerParser.for_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FOR_KEY130=null;
		Token ID131=null;
		Token ASSIGN132=null;
		Token TO_KEY134=null;
		Token DO_KEY136=null;
		Token ENDDO_KEY138=null;
		Token SEMI139=null;
		ParserRuleReturnScope index_expr133 =null;
		ParserRuleReturnScope index_expr135 =null;
		ParserRuleReturnScope stat_seq137 =null;

		CommonTree FOR_KEY130_tree=null;
		CommonTree ID131_tree=null;
		CommonTree ASSIGN132_tree=null;
		CommonTree TO_KEY134_tree=null;
		CommonTree DO_KEY136_tree=null;
		CommonTree ENDDO_KEY138_tree=null;
		CommonTree SEMI139_tree=null;
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
			// /Users/cevanish12/git/tiger-compiler/tiger.g:677:3: ( FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:677:5: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
			{
			FOR_KEY130=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_for_stat1069); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FOR_KEY.add(FOR_KEY130);

			ID131=(Token)match(input,ID,FOLLOW_ID_in_for_stat1071); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID131);

			ASSIGN132=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_for_stat1073); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN132);

			pushFollow(FOLLOW_index_expr_in_for_stat1075);
			index_expr133=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr133.getTree());
			TO_KEY134=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_for_stat1077); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TO_KEY.add(TO_KEY134);

			pushFollow(FOLLOW_index_expr_in_for_stat1079);
			index_expr135=index_expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_index_expr.add(index_expr135.getTree());
			DO_KEY136=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_for_stat1081); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DO_KEY.add(DO_KEY136);

			if ( state.backtracking==0 ) {numLoops++;}
			pushFollow(FOLLOW_stat_seq_in_for_stat1085);
			stat_seq137=stat_seq();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_stat_seq.add(stat_seq137.getTree());
			ENDDO_KEY138=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_for_stat1087); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ENDDO_KEY.add(ENDDO_KEY138);

			SEMI139=(Token)match(input,SEMI,FOLLOW_SEMI_in_for_stat1089); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI139);

			if ( state.backtracking==0 ) {
			    numLoops--;
			  }
			// AST REWRITE
			// elements: TO_KEY, index_expr, index_expr, stat_seq, ID, FOR_KEY, ASSIGN
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 680:2: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:680:5: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
				// /Users/cevanish12/git/tiger-compiler/tiger.g:680:15: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
				{
				CommonTree root_2 = (CommonTree)adaptor.nil();
				root_2 = (CommonTree)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
				// /Users/cevanish12/git/tiger-compiler/tiger.g:680:24: ^( ASSIGN ID index_expr )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:683:1: assign_stat : ( ( value ASSIGN func_call )=> value ASSIGN func_call SEMI -> ^( ASSIGN value func_call ) | ( value ASSIGN expr )=> value ASSIGN expr SEMI -> ^( ASSIGN value expr ) );
	public final tigerParser.assign_stat_return assign_stat() throws RecognitionException {
		tigerParser.assign_stat_return retval = new tigerParser.assign_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ASSIGN141=null;
		Token SEMI143=null;
		Token ASSIGN145=null;
		Token SEMI147=null;
		ParserRuleReturnScope value140 =null;
		ParserRuleReturnScope func_call142 =null;
		ParserRuleReturnScope value144 =null;
		ParserRuleReturnScope expr146 =null;

		CommonTree ASSIGN141_tree=null;
		CommonTree SEMI143_tree=null;
		CommonTree ASSIGN145_tree=null;
		CommonTree SEMI147_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
		RewriteRuleSubtreeStream stream_func_call=new RewriteRuleSubtreeStream(adaptor,"rule func_call");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:684:2: ( ( value ASSIGN func_call )=> value ASSIGN func_call SEMI -> ^( ASSIGN value func_call ) | ( value ASSIGN expr )=> value ASSIGN expr SEMI -> ^( ASSIGN value expr ) )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:684:4: ( value ASSIGN func_call )=> value ASSIGN func_call SEMI
					{
					pushFollow(FOLLOW_value_in_assign_stat1135);
					value140=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value140.getTree());
					ASSIGN141=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat1137); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN141);

					pushFollow(FOLLOW_func_call_in_assign_stat1139);
					func_call142=func_call();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_func_call.add(func_call142.getTree());
					SEMI143=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat1141); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI143);

					if ( state.backtracking==0 ) {
						  SymbolTableEntry variable = symbolTable.get((value140!=null?((tigerParser.value_return)value140).id:null),CURRENT_SCOPE);
						  if (variable == null || !(variable instanceof TigerVariable)) {
						    System.out.println("The variable "+(value140!=null?((tigerParser.value_return)value140).id:null)+" on line "+(value140!=null?(value140.start):null).getLine()+" was never declared");
						  } 
						}
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
					// 690:3: -> ^( ASSIGN value func_call )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:690:7: ^( ASSIGN value func_call )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:691:5: ( value ASSIGN expr )=> value ASSIGN expr SEMI
					{
					pushFollow(FOLLOW_value_in_assign_stat1172);
					value144=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value144.getTree());
					ASSIGN145=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assign_stat1174); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN145);

					pushFollow(FOLLOW_expr_in_assign_stat1176);
					expr146=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr146.getTree());
					SEMI147=(Token)match(input,SEMI,FOLLOW_SEMI_in_assign_stat1178); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_SEMI.add(SEMI147);

					if ( state.backtracking==0 ) {
					    SymbolTableEntry variable = symbolTable.get((value144!=null?((tigerParser.value_return)value144).id:null),CURRENT_SCOPE);
					    if ((expr146!=null?((tigerParser.expr_return)expr146).isBool:null)) {
					      System.out.println("Cannot assign boolean to variable");
					    } else {
						    if (variable != null && variable instanceof TigerVariable) {
						      // if right expression type is not null or if they are not equal and right is not int and left is not fixedpt (for promotion)
						      // Dem parentheses doe
						     if ((expr146!=null?((tigerParser.expr_return)expr146).typing:null) == null || (!((TigerVariable)variable).getType().equals((expr146!=null?((tigerParser.expr_return)expr146).typing:null).getType()) && !(((TigerVariable)variable).getType().equals(symbolTable.getFixedPtType()) &&((expr146!=null?((tigerParser.expr_return)expr146).typing:null).getType().equals(symbolTable.getIntType()))))) {
						      System.out.println("The variable "+(value144!=null?((tigerParser.value_return)value144).id:null)+" on line "+(value144!=null?(value144.start):null).getLine()+" cannot be assigned to "+(expr146!=null?input.toString(expr146.start,expr146.stop):null)+" because it has conflicting types");
						     } else {
						      System.out.println("Success");
						     }
						    }
						   }
					    }
					// AST REWRITE
					// elements: ASSIGN, expr, value
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 707:3: -> ^( ASSIGN value expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:707:6: ^( ASSIGN value expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_1);
						adaptor.addChild(root_1, stream_value.nextTree());
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
	// $ANTLR end "assign_stat"


	public static class func_call_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_call"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:710:1: func_call : ID LPAREN func_param_list RPAREN -> ^( AST_FUNC_CALL ID func_param_list ) ;
	public final tigerParser.func_call_return func_call() throws RecognitionException {
		tigerParser.func_call_return retval = new tigerParser.func_call_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID148=null;
		Token LPAREN149=null;
		Token RPAREN151=null;
		ParserRuleReturnScope func_param_list150 =null;

		CommonTree ID148_tree=null;
		CommonTree LPAREN149_tree=null;
		CommonTree RPAREN151_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_func_param_list=new RewriteRuleSubtreeStream(adaptor,"rule func_param_list");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:711:2: ( ID LPAREN func_param_list RPAREN -> ^( AST_FUNC_CALL ID func_param_list ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:711:4: ID LPAREN func_param_list RPAREN
			{
			ID148=(Token)match(input,ID,FOLLOW_ID_in_func_call1203); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ID.add(ID148);

			LPAREN149=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call1205); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN149);

			pushFollow(FOLLOW_func_param_list_in_func_call1207);
			func_param_list150=func_param_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_func_param_list.add(func_param_list150.getTree());
			RPAREN151=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call1209); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN151);

			if ( state.backtracking==0 ) {
				  
				}
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
			// 714:2: -> ^( AST_FUNC_CALL ID func_param_list )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:714:5: ^( AST_FUNC_CALL ID func_param_list )
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:717:1: break_stat : BREAK_KEY SEMI -> BREAK_KEY ;
	public final tigerParser.break_stat_return break_stat() throws RecognitionException {
		tigerParser.break_stat_return retval = new tigerParser.break_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BREAK_KEY152=null;
		Token SEMI153=null;

		CommonTree BREAK_KEY152_tree=null;
		CommonTree SEMI153_tree=null;
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleTokenStream stream_BREAK_KEY=new RewriteRuleTokenStream(adaptor,"token BREAK_KEY");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:718:2: ( BREAK_KEY SEMI -> BREAK_KEY )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:718:4: BREAK_KEY SEMI
			{
			BREAK_KEY152=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_break_stat1234); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_BREAK_KEY.add(BREAK_KEY152);

			SEMI153=(Token)match(input,SEMI,FOLLOW_SEMI_in_break_stat1236); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI153);

			if ( state.backtracking==0 ) {
				  if (numLoops == 0) {
				    System.out.println("Break at line " +(retval.start).getLine() +" cannot occur outside of a loop");
				  }
				}
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
			// 723:2: -> BREAK_KEY
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:726:1: return_stat : ( RETURN_KEY expr )=> RETURN_KEY expr SEMI -> ^( AST_RETURN_STAT RETURN_KEY expr ) ;
	public final tigerParser.return_stat_return return_stat() throws RecognitionException {
		tigerParser.return_stat_return retval = new tigerParser.return_stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RETURN_KEY154=null;
		Token SEMI156=null;
		ParserRuleReturnScope expr155 =null;

		CommonTree RETURN_KEY154_tree=null;
		CommonTree SEMI156_tree=null;
		RewriteRuleTokenStream stream_RETURN_KEY=new RewriteRuleTokenStream(adaptor,"token RETURN_KEY");
		RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:727:2: ( ( RETURN_KEY expr )=> RETURN_KEY expr SEMI -> ^( AST_RETURN_STAT RETURN_KEY expr ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:727:4: ( RETURN_KEY expr )=> RETURN_KEY expr SEMI
			{
			RETURN_KEY154=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_return_stat1263); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RETURN_KEY.add(RETURN_KEY154);

			pushFollow(FOLLOW_expr_in_return_stat1265);
			expr155=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expr.add(expr155.getTree());
			SEMI156=(Token)match(input,SEMI,FOLLOW_SEMI_in_return_stat1267); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEMI.add(SEMI156);

			// AST REWRITE
			// elements: expr, RETURN_KEY
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 728:2: -> ^( AST_RETURN_STAT RETURN_KEY expr )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:728:5: ^( AST_RETURN_STAT RETURN_KEY expr )
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
		public OperationObject typing;
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:731:1: expr returns [OperationObject typing, Boolean isBool] : ( ( boolExpr )=> boolExpr | ( numExpr )=> numExpr | LPAREN !var1= expr RPAREN !);
	public final tigerParser.expr_return expr() throws RecognitionException {
		tigerParser.expr_return retval = new tigerParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN159=null;
		Token RPAREN160=null;
		ParserRuleReturnScope var1 =null;
		ParserRuleReturnScope boolExpr157 =null;
		ParserRuleReturnScope numExpr158 =null;

		CommonTree LPAREN159_tree=null;
		CommonTree RPAREN160_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:732:3: ( ( boolExpr )=> boolExpr | ( numExpr )=> numExpr | LPAREN !var1= expr RPAREN !)
			int alt18=3;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				int LA18_1 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt18=1;
				}
				else if ( (synpred11_tiger()) ) {
					alt18=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA18_2 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt18=1;
				}
				else if ( (synpred11_tiger()) ) {
					alt18=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA18_3 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt18=1;
				}
				else if ( (synpred11_tiger()) ) {
					alt18=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ID:
				{
				int LA18_4 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt18=1;
				}
				else if ( (synpred11_tiger()) ) {
					alt18=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LPAREN:
				{
				int LA18_5 = input.LA(2);
				if ( (synpred10_tiger()) ) {
					alt18=1;
				}
				else if ( (synpred11_tiger()) ) {
					alt18=2;
				}
				else if ( (true) ) {
					alt18=3;
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:732:5: ( boolExpr )=> boolExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_boolExpr_in_expr1300);
					boolExpr157=boolExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolExpr157.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = (boolExpr157!=null?((tigerParser.boolExpr_return)boolExpr157).typing:null);
					    retval.isBool = (boolExpr157!=null?((tigerParser.boolExpr_return)boolExpr157).isBool:null);
					  }
					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:736:5: ( numExpr )=> numExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numExpr_in_expr1314);
					numExpr158=numExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numExpr158.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = (numExpr158!=null?((tigerParser.numExpr_return)numExpr158).typing:null);
					    retval.isBool = (numExpr158!=null?((tigerParser.numExpr_return)numExpr158).isBool:null);
					  }
					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:740:5: LPAREN !var1= expr RPAREN !
					{
					root_0 = (CommonTree)adaptor.nil();


					LPAREN159=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr1322); if (state.failed) return retval;
					pushFollow(FOLLOW_expr_in_expr1327);
					var1=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var1.getTree());

					RPAREN160=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr1329); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					    retval.typing = (var1!=null?((tigerParser.expr_return)var1).typing:null);
					    retval.isBool = (var1!=null?((tigerParser.expr_return)var1).isBool:null);
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


	public static class boolExpr_return extends ParserRuleReturnScope {
		public OperationObject typing;
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "boolExpr"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:746:1: boolExpr returns [OperationObject typing, Boolean isBool] : ( ( constval binop_p0 )=> constval binop_p0 expr -> ^( binop_p0 constval expr ) | ( value binop_p0 )=> value binop_p0 expr -> ^( binop_p0 value expr ) | ( LPAREN expr RPAREN binop_p0 )=> LPAREN !var1= expr RPAREN ! binop_p0 ^var2= expr );
	public final tigerParser.boolExpr_return boolExpr() throws RecognitionException {
		tigerParser.boolExpr_return retval = new tigerParser.boolExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN167=null;
		Token RPAREN168=null;
		ParserRuleReturnScope var1 =null;
		ParserRuleReturnScope var2 =null;
		ParserRuleReturnScope constval161 =null;
		ParserRuleReturnScope binop_p0162 =null;
		ParserRuleReturnScope expr163 =null;
		ParserRuleReturnScope value164 =null;
		ParserRuleReturnScope binop_p0165 =null;
		ParserRuleReturnScope expr166 =null;
		ParserRuleReturnScope binop_p0169 =null;

		CommonTree LPAREN167_tree=null;
		CommonTree RPAREN168_tree=null;
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_constval=new RewriteRuleSubtreeStream(adaptor,"rule constval");
		RewriteRuleSubtreeStream stream_binop_p0=new RewriteRuleSubtreeStream(adaptor,"rule binop_p0");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:747:3: ( ( constval binop_p0 )=> constval binop_p0 expr -> ^( binop_p0 constval expr ) | ( value binop_p0 )=> value binop_p0 expr -> ^( binop_p0 value expr ) | ( LPAREN expr RPAREN binop_p0 )=> LPAREN !var1= expr RPAREN ! binop_p0 ^var2= expr )
			int alt19=3;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==MINUS) && (synpred12_tiger())) {
				alt19=1;
			}
			else if ( (LA19_0==UNSIGNED_FIXEDPTLIT) && (synpred12_tiger())) {
				alt19=1;
			}
			else if ( (LA19_0==UNSIGNED_INTLIT) && (synpred12_tiger())) {
				alt19=1;
			}
			else if ( (LA19_0==ID) && (synpred13_tiger())) {
				alt19=2;
			}
			else if ( (LA19_0==LPAREN) && (synpred14_tiger())) {
				alt19=3;
			}

			switch (alt19) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:747:5: ( constval binop_p0 )=> constval binop_p0 expr
					{
					pushFollow(FOLLOW_constval_in_boolExpr1358);
					constval161=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constval.add(constval161.getTree());
					pushFollow(FOLLOW_binop_p0_in_boolExpr1360);
					binop_p0162=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p0.add(binop_p0162.getTree());
					pushFollow(FOLLOW_expr_in_boolExpr1362);
					expr163=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr163.getTree());
					if ( state.backtracking==0 ) {
					    retval.typing = getTyping((constval161!=null?((tigerParser.constval_return)constval161).typing:null), (expr163!=null?((tigerParser.expr_return)expr163).typing:null), (retval.start).getLine(), (binop_p0162!=null?input.toString(binop_p0162.start,binop_p0162.stop):null));
					    retval.isBool = (constval161!=null?((tigerParser.constval_return)constval161).isBool:null) || (binop_p0162!=null?((tigerParser.binop_p0_return)binop_p0162).isBool:null) || (expr163!=null?((tigerParser.expr_return)expr163).isBool:null);
					  }
					// AST REWRITE
					// elements: expr, constval, binop_p0
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 751:3: -> ^( binop_p0 constval expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:751:6: ^( binop_p0 constval expr )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:752:5: ( value binop_p0 )=> value binop_p0 expr
					{
					pushFollow(FOLLOW_value_in_boolExpr1391);
					value164=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value164.getTree());
					pushFollow(FOLLOW_binop_p0_in_boolExpr1393);
					binop_p0165=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p0.add(binop_p0165.getTree());
					pushFollow(FOLLOW_expr_in_boolExpr1395);
					expr166=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr166.getTree());
					if ( state.backtracking==0 ) {
					    retval.typing = getTyping((value164!=null?((tigerParser.value_return)value164).typing:null), (expr166!=null?((tigerParser.expr_return)expr166).typing:null), (retval.start).getLine(), (binop_p0165!=null?input.toString(binop_p0165.start,binop_p0165.stop):null));
					    retval.isBool = (value164!=null?((tigerParser.value_return)value164).isBool:null) || (binop_p0165!=null?((tigerParser.binop_p0_return)binop_p0165).isBool:null) || (expr166!=null?((tigerParser.expr_return)expr166).isBool:null);
					  }
					// AST REWRITE
					// elements: binop_p0, value, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 756:3: -> ^( binop_p0 value expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:756:6: ^( binop_p0 value expr )
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
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:757:5: ( LPAREN expr RPAREN binop_p0 )=> LPAREN !var1= expr RPAREN ! binop_p0 ^var2= expr
					{
					root_0 = (CommonTree)adaptor.nil();


					LPAREN167=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_boolExpr1427); if (state.failed) return retval;
					pushFollow(FOLLOW_expr_in_boolExpr1432);
					var1=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var1.getTree());

					RPAREN168=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_boolExpr1434); if (state.failed) return retval;
					pushFollow(FOLLOW_binop_p0_in_boolExpr1437);
					binop_p0169=binop_p0();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p0169.getTree(), root_0);
					pushFollow(FOLLOW_expr_in_boolExpr1442);
					var2=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var2.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = getTyping((var1!=null?((tigerParser.expr_return)var1).typing:null), (var2!=null?((tigerParser.expr_return)var2).typing:null), (retval.start).getLine(), (binop_p0169!=null?input.toString(binop_p0169.start,binop_p0169.stop):null));
					    retval.isBool = (var1!=null?((tigerParser.expr_return)var1).isBool:null) || (binop_p0169!=null?((tigerParser.binop_p0_return)binop_p0169).isBool:null) || (var2!=null?((tigerParser.expr_return)var2).isBool:null);
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
	// $ANTLR end "boolExpr"


	public static class numExpr_return extends ParserRuleReturnScope {
		public OperationObject typing;
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "numExpr"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:763:1: numExpr returns [OperationObject typing, Boolean isBool] : ( ( constval binop_p2 )=> constval binop_p2 expr -> ^( binop_p2 constval expr ) | constval | ( value binop_p2 )=> value binop_p2 expr -> ^( binop_p2 value expr ) | value | ( LPAREN expr RPAREN binop_p2 )=> LPAREN !var1= expr RPAREN ! binop_p2 ^var2= expr );
	public final tigerParser.numExpr_return numExpr() throws RecognitionException {
		tigerParser.numExpr_return retval = new tigerParser.numExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN178=null;
		Token RPAREN179=null;
		ParserRuleReturnScope var1 =null;
		ParserRuleReturnScope var2 =null;
		ParserRuleReturnScope constval170 =null;
		ParserRuleReturnScope binop_p2171 =null;
		ParserRuleReturnScope expr172 =null;
		ParserRuleReturnScope constval173 =null;
		ParserRuleReturnScope value174 =null;
		ParserRuleReturnScope binop_p2175 =null;
		ParserRuleReturnScope expr176 =null;
		ParserRuleReturnScope value177 =null;
		ParserRuleReturnScope binop_p2180 =null;

		CommonTree LPAREN178_tree=null;
		CommonTree RPAREN179_tree=null;
		RewriteRuleSubtreeStream stream_binop_p2=new RewriteRuleSubtreeStream(adaptor,"rule binop_p2");
		RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
		RewriteRuleSubtreeStream stream_constval=new RewriteRuleSubtreeStream(adaptor,"rule constval");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:764:3: ( ( constval binop_p2 )=> constval binop_p2 expr -> ^( binop_p2 constval expr ) | constval | ( value binop_p2 )=> value binop_p2 expr -> ^( binop_p2 value expr ) | value | ( LPAREN expr RPAREN binop_p2 )=> LPAREN !var1= expr RPAREN ! binop_p2 ^var2= expr )
			int alt20=5;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==MINUS) ) {
				int LA20_1 = input.LA(2);
				if ( (synpred15_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

			}
			else if ( (LA20_0==UNSIGNED_FIXEDPTLIT) ) {
				int LA20_2 = input.LA(2);
				if ( (synpred15_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

			}
			else if ( (LA20_0==UNSIGNED_INTLIT) ) {
				int LA20_3 = input.LA(2);
				if ( (synpred15_tiger()) ) {
					alt20=1;
				}
				else if ( (true) ) {
					alt20=2;
				}

			}
			else if ( (LA20_0==ID) ) {
				int LA20_4 = input.LA(2);
				if ( (synpred16_tiger()) ) {
					alt20=3;
				}
				else if ( (true) ) {
					alt20=4;
				}

			}
			else if ( (LA20_0==LPAREN) && (synpred17_tiger())) {
				alt20=5;
			}

			switch (alt20) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:764:5: ( constval binop_p2 )=> constval binop_p2 expr
					{
					pushFollow(FOLLOW_constval_in_numExpr1470);
					constval170=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_constval.add(constval170.getTree());
					pushFollow(FOLLOW_binop_p2_in_numExpr1472);
					binop_p2171=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p2.add(binop_p2171.getTree());
					pushFollow(FOLLOW_expr_in_numExpr1474);
					expr172=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr172.getTree());
					if ( state.backtracking==0 ) {
					    retval.typing = getTyping((constval170!=null?((tigerParser.constval_return)constval170).typing:null), (expr172!=null?((tigerParser.expr_return)expr172).typing:null), (retval.start).getLine(), (binop_p2171!=null?input.toString(binop_p2171.start,binop_p2171.stop):null));
					    retval.isBool = (constval170!=null?((tigerParser.constval_return)constval170).isBool:null) || (binop_p2171!=null?((tigerParser.binop_p2_return)binop_p2171).isBool:null) || (expr172!=null?((tigerParser.expr_return)expr172).isBool:null);
					  }
					// AST REWRITE
					// elements: constval, binop_p2, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 768:3: -> ^( binop_p2 constval expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:768:6: ^( binop_p2 constval expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_binop_p2.nextNode(), root_1);
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:769:5: constval
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_constval_in_numExpr1494);
					constval173=constval();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constval173.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = (constval173!=null?((tigerParser.constval_return)constval173).typing:null);
					    retval.isBool = (constval173!=null?((tigerParser.constval_return)constval173).isBool:null);
					  }
					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:773:5: ( value binop_p2 )=> value binop_p2 expr
					{
					pushFollow(FOLLOW_value_in_numExpr1510);
					value174=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value.add(value174.getTree());
					pushFollow(FOLLOW_binop_p2_in_numExpr1512);
					binop_p2175=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_binop_p2.add(binop_p2175.getTree());
					pushFollow(FOLLOW_expr_in_numExpr1514);
					expr176=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr176.getTree());
					if ( state.backtracking==0 ) {
					    retval.typing = getTyping((value174!=null?((tigerParser.value_return)value174).typing:null), (expr176!=null?((tigerParser.expr_return)expr176).typing:null), (retval.start).getLine(), (binop_p2175!=null?input.toString(binop_p2175.start,binop_p2175.stop):null));
					    retval.isBool = (value174!=null?((tigerParser.value_return)value174).isBool:null) || (binop_p2175!=null?((tigerParser.binop_p2_return)binop_p2175).isBool:null) || (expr176!=null?((tigerParser.expr_return)expr176).isBool:null);
					  }
					// AST REWRITE
					// elements: binop_p2, value, expr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 777:3: -> ^( binop_p2 value expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:777:6: ^( binop_p2 value expr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_binop_p2.nextNode(), root_1);
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:778:5: value
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_value_in_numExpr1534);
					value177=value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, value177.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = (value177!=null?((tigerParser.value_return)value177).typing:null);
					    retval.isBool = (value177!=null?((tigerParser.value_return)value177).isBool:null);
					  }
					}
					break;
				case 5 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:782:5: ( LPAREN expr RPAREN binop_p2 )=> LPAREN !var1= expr RPAREN ! binop_p2 ^var2= expr
					{
					root_0 = (CommonTree)adaptor.nil();


					LPAREN178=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_numExpr1554); if (state.failed) return retval;
					pushFollow(FOLLOW_expr_in_numExpr1559);
					var1=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var1.getTree());

					RPAREN179=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_numExpr1561); if (state.failed) return retval;
					pushFollow(FOLLOW_binop_p2_in_numExpr1564);
					binop_p2180=binop_p2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(binop_p2180.getTree(), root_0);
					pushFollow(FOLLOW_expr_in_numExpr1569);
					var2=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var2.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = getTyping((var1!=null?((tigerParser.expr_return)var1).typing:null), (var2!=null?((tigerParser.expr_return)var2).typing:null), (retval.start).getLine(), (binop_p2180!=null?input.toString(binop_p2180.start,binop_p2180.stop):null));
					    retval.isBool = (var1!=null?((tigerParser.expr_return)var1).isBool:null) || (binop_p2180!=null?((tigerParser.binop_p2_return)binop_p2180).isBool:null) || (var2!=null?((tigerParser.expr_return)var2).isBool:null);
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
	// $ANTLR end "numExpr"


	public static class binop_p0_return extends ParserRuleReturnScope {
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p0"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:789:1: binop_p0 returns [Boolean isBool] : ( AND | OR | binop_p1 ) ;
	public final tigerParser.binop_p0_return binop_p0() throws RecognitionException {
		tigerParser.binop_p0_return retval = new tigerParser.binop_p0_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND181=null;
		Token OR182=null;
		ParserRuleReturnScope binop_p1183 =null;

		CommonTree AND181_tree=null;
		CommonTree OR182_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:790:3: ( ( AND | OR | binop_p1 ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:790:5: ( AND | OR | binop_p1 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:790:5: ( AND | OR | binop_p1 )
			int alt21=3;
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
			case EQ:
			case GREATER:
			case GREATEREQ:
			case LESSER:
			case LESSEREQ:
			case NEQ:
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:790:6: AND
					{
					AND181=(Token)match(input,AND,FOLLOW_AND_in_binop_p01592); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND181_tree = (CommonTree)adaptor.create(AND181);
					adaptor.addChild(root_0, AND181_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:790:12: OR
					{
					OR182=(Token)match(input,OR,FOLLOW_OR_in_binop_p01596); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR182_tree = (CommonTree)adaptor.create(OR182);
					adaptor.addChild(root_0, OR182_tree);
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:790:17: binop_p1
					{
					pushFollow(FOLLOW_binop_p1_in_binop_p01600);
					binop_p1183=binop_p1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p1183.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			    retval.isBool = true;
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
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p1"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:794:1: binop_p1 returns [Boolean isBool] : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ ) ;
	public final tigerParser.binop_p1_return binop_p1() throws RecognitionException {
		tigerParser.binop_p1_return retval = new tigerParser.binop_p1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set184=null;

		CommonTree set184_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:795:3: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:795:5: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ )
			{
			root_0 = (CommonTree)adaptor.nil();


			set184=input.LT(1);
			if ( input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||input.LA(1)==NEQ ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set184));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			if ( state.backtracking==0 ) {
			    retval.isBool = true;
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
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p2"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:801:1: binop_p2 returns [Boolean isBool] : ( MINUS | PLUS | binop_p3 ) ;
	public final tigerParser.binop_p2_return binop_p2() throws RecognitionException {
		tigerParser.binop_p2_return retval = new tigerParser.binop_p2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS185=null;
		Token PLUS186=null;
		ParserRuleReturnScope binop_p3187 =null;

		CommonTree MINUS185_tree=null;
		CommonTree PLUS186_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:802:3: ( ( MINUS | PLUS | binop_p3 ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:802:5: ( MINUS | PLUS | binop_p3 )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:802:5: ( MINUS | PLUS | binop_p3 )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:802:6: MINUS
					{
					MINUS185=(Token)match(input,MINUS,FOLLOW_MINUS_in_binop_p21666); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS185_tree = (CommonTree)adaptor.create(MINUS185);
					adaptor.addChild(root_0, MINUS185_tree);
					}

					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:802:14: PLUS
					{
					PLUS186=(Token)match(input,PLUS,FOLLOW_PLUS_in_binop_p21670); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PLUS186_tree = (CommonTree)adaptor.create(PLUS186);
					adaptor.addChild(root_0, PLUS186_tree);
					}

					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:802:21: binop_p3
					{
					pushFollow(FOLLOW_binop_p3_in_binop_p21674);
					binop_p3187=binop_p3();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, binop_p3187.getTree());

					}
					break;

			}

			if ( state.backtracking==0 ) {
			    retval.isBool = false;
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
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "binop_p3"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:806:1: binop_p3 returns [Boolean isBool] : ( MULT | DIV ) ;
	public final tigerParser.binop_p3_return binop_p3() throws RecognitionException {
		tigerParser.binop_p3_return retval = new tigerParser.binop_p3_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set188=null;

		CommonTree set188_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:807:3: ( ( MULT | DIV ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:807:5: ( MULT | DIV )
			{
			root_0 = (CommonTree)adaptor.nil();


			set188=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
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
			if ( state.backtracking==0 ) {
			    retval.isBool = false;
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
		public OperationObject typing;
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constval"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:812:1: constval returns [OperationObject typing, Boolean isBool] : ( ( fixedptlit )=> fixedptlit | intlit );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope fixedptlit189 =null;
		ParserRuleReturnScope intlit190 =null;


		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:813:3: ( ( fixedptlit )=> fixedptlit | intlit )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==MINUS) ) {
				int LA23_1 = input.LA(2);
				if ( (synpred18_tiger()) ) {
					alt23=1;
				}
				else if ( (true) ) {
					alt23=2;
				}

			}
			else if ( (LA23_0==UNSIGNED_FIXEDPTLIT) && (synpred18_tiger())) {
				alt23=1;
			}
			else if ( (LA23_0==UNSIGNED_INTLIT) ) {
				alt23=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:813:5: ( fixedptlit )=> fixedptlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_fixedptlit_in_constval1725);
					fixedptlit189=fixedptlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fixedptlit189.getTree());

					if ( state.backtracking==0 ) {
					    retval.typing = new OperationObject(true, symbolTable.getFixedPtType(), (fixedptlit189!=null?input.toString(fixedptlit189.start,fixedptlit189.stop):null));
					    retval.isBool = false;
					  }
					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:817:4: intlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intlit_in_constval1732);
					intlit190=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intlit190.getTree());

					if ( state.backtracking==0 ) {
						  retval.typing = new OperationObject(true, symbolTable.getIntType(), (intlit190!=null?input.toString(intlit190.start,intlit190.stop):null));
						  retval.isBool = false;
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:823:1: intlit : ( MINUS )? UNSIGNED_INTLIT ;
	public final tigerParser.intlit_return intlit() throws RecognitionException {
		tigerParser.intlit_return retval = new tigerParser.intlit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS191=null;
		Token UNSIGNED_INTLIT192=null;

		CommonTree MINUS191_tree=null;
		CommonTree UNSIGNED_INTLIT192_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:823:8: ( ( MINUS )? UNSIGNED_INTLIT )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:823:10: ( MINUS )? UNSIGNED_INTLIT
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:823:10: ( MINUS )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==MINUS) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:823:10: MINUS
					{
					MINUS191=(Token)match(input,MINUS,FOLLOW_MINUS_in_intlit1744); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS191_tree = (CommonTree)adaptor.create(MINUS191);
					adaptor.addChild(root_0, MINUS191_tree);
					}

					}
					break;

			}

			UNSIGNED_INTLIT192=(Token)match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_intlit1747); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNSIGNED_INTLIT192_tree = (CommonTree)adaptor.create(UNSIGNED_INTLIT192);
			adaptor.addChild(root_0, UNSIGNED_INTLIT192_tree);
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:828:1: fixedptlit : ( MINUS )? UNSIGNED_FIXEDPTLIT ;
	public final tigerParser.fixedptlit_return fixedptlit() throws RecognitionException {
		tigerParser.fixedptlit_return retval = new tigerParser.fixedptlit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MINUS193=null;
		Token UNSIGNED_FIXEDPTLIT194=null;

		CommonTree MINUS193_tree=null;
		CommonTree UNSIGNED_FIXEDPTLIT194_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:829:2: ( ( MINUS )? UNSIGNED_FIXEDPTLIT )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:829:6: ( MINUS )? UNSIGNED_FIXEDPTLIT
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/cevanish12/git/tiger-compiler/tiger.g:829:6: ( MINUS )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==MINUS) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:829:6: MINUS
					{
					MINUS193=(Token)match(input,MINUS,FOLLOW_MINUS_in_fixedptlit1771); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MINUS193_tree = (CommonTree)adaptor.create(MINUS193);
					adaptor.addChild(root_0, MINUS193_tree);
					}

					}
					break;

			}

			UNSIGNED_FIXEDPTLIT194=(Token)match(input,UNSIGNED_FIXEDPTLIT,FOLLOW_UNSIGNED_FIXEDPTLIT_in_fixedptlit1774); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNSIGNED_FIXEDPTLIT194_tree = (CommonTree)adaptor.create(UNSIGNED_FIXEDPTLIT194);
			adaptor.addChild(root_0, UNSIGNED_FIXEDPTLIT194_tree);
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:836:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set195=null;

		CommonTree set195_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:837:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set195=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set195));
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:840:1: expr_list : ( ( expr )=> expr ( COMMA expr )* -> ^( AST_EXPR_LIST ( expr )+ ) | expr ( COMMA expr )* -> ^( AST_EXPR_LIST ( expr )+ ) );
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA197=null;
		Token COMMA200=null;
		ParserRuleReturnScope expr196 =null;
		ParserRuleReturnScope expr198 =null;
		ParserRuleReturnScope expr199 =null;
		ParserRuleReturnScope expr201 =null;

		CommonTree COMMA197_tree=null;
		CommonTree COMMA200_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:841:2: ( ( expr )=> expr ( COMMA expr )* -> ^( AST_EXPR_LIST ( expr )+ ) | expr ( COMMA expr )* -> ^( AST_EXPR_LIST ( expr )+ ) )
			int alt28=2;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				int LA28_1 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt28=1;
				}
				else if ( (true) ) {
					alt28=2;
				}

				}
				break;
			case UNSIGNED_FIXEDPTLIT:
				{
				int LA28_2 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt28=1;
				}
				else if ( (true) ) {
					alt28=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA28_3 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt28=1;
				}
				else if ( (true) ) {
					alt28=2;
				}

				}
				break;
			case ID:
				{
				int LA28_4 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt28=1;
				}
				else if ( (true) ) {
					alt28=2;
				}

				}
				break;
			case LPAREN:
				{
				int LA28_5 = input.LA(2);
				if ( (synpred19_tiger()) ) {
					alt28=1;
				}
				else if ( (true) ) {
					alt28=2;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:841:4: ( expr )=> expr ( COMMA expr )*
					{
					pushFollow(FOLLOW_expr_in_expr_list1854);
					expr196=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr196.getTree());
					// /Users/cevanish12/git/tiger-compiler/tiger.g:841:19: ( COMMA expr )*
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0==COMMA) ) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// /Users/cevanish12/git/tiger-compiler/tiger.g:841:20: COMMA expr
							{
							COMMA197=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1857); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA197);

							pushFollow(FOLLOW_expr_in_expr_list1859);
							expr198=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(expr198.getTree());
							}
							break;

						default :
							break loop26;
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
					// 842:2: -> ^( AST_EXPR_LIST ( expr )+ )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:842:5: ^( AST_EXPR_LIST ( expr )+ )
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
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:843:5: expr ( COMMA expr )*
					{
					pushFollow(FOLLOW_expr_in_expr_list1877);
					expr199=expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expr.add(expr199.getTree());
					// /Users/cevanish12/git/tiger-compiler/tiger.g:843:10: ( COMMA expr )*
					loop27:
					while (true) {
						int alt27=2;
						int LA27_0 = input.LA(1);
						if ( (LA27_0==COMMA) ) {
							alt27=1;
						}

						switch (alt27) {
						case 1 :
							// /Users/cevanish12/git/tiger-compiler/tiger.g:843:11: COMMA expr
							{
							COMMA200=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list1880); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA200);

							pushFollow(FOLLOW_expr_in_expr_list1882);
							expr201=expr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expr.add(expr201.getTree());
							}
							break;

						default :
							break loop27;
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
					// 844:3: -> ^( AST_EXPR_LIST ( expr )+ )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:844:7: ^( AST_EXPR_LIST ( expr )+ )
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
		public OperationObject typing;
		public String id;
		public Boolean isBool;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// /Users/cevanish12/git/tiger-compiler/tiger.g:847:1: value returns [OperationObject typing, String id, Boolean isBool] : ( ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK | ( ID LBRACK )=> ID LBRACK index_expr RBRACK | ID );
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID202=null;
		Token LBRACK203=null;
		Token RBRACK205=null;
		Token LBRACK206=null;
		Token RBRACK208=null;
		Token ID209=null;
		Token LBRACK210=null;
		Token RBRACK212=null;
		Token ID213=null;
		ParserRuleReturnScope index_expr204 =null;
		ParserRuleReturnScope index_expr207 =null;
		ParserRuleReturnScope index_expr211 =null;

		CommonTree ID202_tree=null;
		CommonTree LBRACK203_tree=null;
		CommonTree RBRACK205_tree=null;
		CommonTree LBRACK206_tree=null;
		CommonTree RBRACK208_tree=null;
		CommonTree ID209_tree=null;
		CommonTree LBRACK210_tree=null;
		CommonTree RBRACK212_tree=null;
		CommonTree ID213_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:848:3: ( ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK | ( ID LBRACK )=> ID LBRACK index_expr RBRACK | ID )
			int alt29=3;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==ID) ) {
				int LA29_1 = input.LA(2);
				if ( (synpred20_tiger()) ) {
					alt29=1;
				}
				else if ( (synpred21_tiger()) ) {
					alt29=2;
				}
				else if ( (true) ) {
					alt29=3;
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:848:5: ( ID LBRACK index_expr RBRACK LBRACK )=> ID LBRACK index_expr RBRACK LBRACK index_expr RBRACK
					{
					root_0 = (CommonTree)adaptor.nil();


					ID202=(Token)match(input,ID,FOLLOW_ID_in_value1926); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID202_tree = (CommonTree)adaptor.create(ID202);
					adaptor.addChild(root_0, ID202_tree);
					}

					LBRACK203=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1928); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK203_tree = (CommonTree)adaptor.create(LBRACK203);
					adaptor.addChild(root_0, LBRACK203_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1930);
					index_expr204=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr204.getTree());

					RBRACK205=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1932); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK205_tree = (CommonTree)adaptor.create(RBRACK205);
					adaptor.addChild(root_0, RBRACK205_tree);
					}

					LBRACK206=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1934); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK206_tree = (CommonTree)adaptor.create(LBRACK206);
					adaptor.addChild(root_0, LBRACK206_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1936);
					index_expr207=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr207.getTree());

					RBRACK208=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1938); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK208_tree = (CommonTree)adaptor.create(RBRACK208);
					adaptor.addChild(root_0, RBRACK208_tree);
					}

					if ( state.backtracking==0 ) {
					  	  SymbolTableEntry entry = symbolTable.get(strip((ID202!=null?ID202.getText():null)),CURRENT_SCOPE);
					  	  if (entry != null && entry instanceof TigerVariable) {
					  	    if (((TigerVariable)entry).getBackingType() == TigerPrimitive.INT_2D_ARRAY || ((TigerVariable)entry).getBackingType() == TigerPrimitive.FIXEDPT_2D_ARRAY) {
					  	      retval.typing = new OperationObject(false, ((TigerVariable)entry).getType(), input.toString(retval.start,input.LT(-1)));
					  	    } else {
					  	      System.out.println("The variable "+(ID202!=null?ID202.getText():null)+ " on line "+(retval.start).getLine() +" is not a 2D array");
					  	    }
					  	  } else {
					  	    System.out.println("The variable "+(ID202!=null?ID202.getText():null)+ " on line "+(retval.start).getLine() +" is not a variable");
					  	  }
					  	  retval.id = (ID202!=null?ID202.getText():null);
					  	  retval.isBool = false;
					  	}
					}
					break;
				case 2 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:862:4: ( ID LBRACK )=> ID LBRACK index_expr RBRACK
					{
					root_0 = (CommonTree)adaptor.nil();


					ID209=(Token)match(input,ID,FOLLOW_ID_in_value1953); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID209_tree = (CommonTree)adaptor.create(ID209);
					adaptor.addChild(root_0, ID209_tree);
					}

					LBRACK210=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value1955); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LBRACK210_tree = (CommonTree)adaptor.create(LBRACK210);
					adaptor.addChild(root_0, LBRACK210_tree);
					}

					pushFollow(FOLLOW_index_expr_in_value1957);
					index_expr211=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, index_expr211.getTree());

					RBRACK212=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value1959); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					RBRACK212_tree = (CommonTree)adaptor.create(RBRACK212);
					adaptor.addChild(root_0, RBRACK212_tree);
					}

					if ( state.backtracking==0 ) {
							    SymbolTableEntry entry = symbolTable.get(strip((ID209!=null?ID209.getText():null)),CURRENT_SCOPE);
						      if (entry != null && entry instanceof TigerVariable) {
						        if (((TigerVariable)entry).getBackingType() == TigerPrimitive.INT_ARRAY || ((TigerVariable)entry).getBackingType() == TigerPrimitive.FIXEDPT_ARRAY) {
						          retval.typing = new OperationObject(false, ((TigerVariable)entry).getType(), input.toString(retval.start,input.LT(-1)));
						        } else {
						          System.out.println("The variable "+(ID209!=null?ID209.getText():null)+ " on line "+(retval.start).getLine() +" is not a 1D array");
						        }
						      } else {
						        System.out.println("The variable "+(ID209!=null?ID209.getText():null)+ " on line "+(retval.start).getLine() +" is not a variable");
						      }
						  retval.id = (ID209!=null?ID209.getText():null);
						  retval.isBool = false;
						}
					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:876:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID213=(Token)match(input,ID,FOLLOW_ID_in_value1966); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID213_tree = (CommonTree)adaptor.create(ID213);
					adaptor.addChild(root_0, ID213_tree);
					}

					if ( state.backtracking==0 ) {
					      SymbolTableEntry entry = symbolTable.get(strip((ID213!=null?ID213.getText():null)),CURRENT_SCOPE);
					      if (entry != null && entry instanceof TigerVariable) {
					            retval.typing = new OperationObject(false, ((TigerVariable)entry).getType(), input.toString(retval.start,input.LT(-1)));
					        } else {
					          System.out.println("The variable "+(ID213!=null?ID213.getText():null)+ " on line "+(retval.start).getLine() +" is not a variable or was never declared");
					        }
					      retval.id = (ID213!=null?ID213.getText():null);
					      retval.isBool = false;
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:888:1: index_expr : ( ( intlit index_oper )=> intlit index_oper index_expr -> ^( index_oper intlit index_expr ) | intlit | ( ID index_oper )=> ID index_oper index_expr -> ^( index_oper ID index_expr ) | ID );
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID218=null;
		Token ID221=null;
		ParserRuleReturnScope intlit214 =null;
		ParserRuleReturnScope index_oper215 =null;
		ParserRuleReturnScope index_expr216 =null;
		ParserRuleReturnScope intlit217 =null;
		ParserRuleReturnScope index_oper219 =null;
		ParserRuleReturnScope index_expr220 =null;

		CommonTree ID218_tree=null;
		CommonTree ID221_tree=null;
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_index_oper=new RewriteRuleSubtreeStream(adaptor,"rule index_oper");
		RewriteRuleSubtreeStream stream_index_expr=new RewriteRuleSubtreeStream(adaptor,"rule index_expr");
		RewriteRuleSubtreeStream stream_intlit=new RewriteRuleSubtreeStream(adaptor,"rule intlit");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:889:2: ( ( intlit index_oper )=> intlit index_oper index_expr -> ^( index_oper intlit index_expr ) | intlit | ( ID index_oper )=> ID index_oper index_expr -> ^( index_oper ID index_expr ) | ID )
			int alt30=4;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				int LA30_1 = input.LA(2);
				if ( (synpred22_tiger()) ) {
					alt30=1;
				}
				else if ( (true) ) {
					alt30=2;
				}

				}
				break;
			case UNSIGNED_INTLIT:
				{
				int LA30_2 = input.LA(2);
				if ( (synpred22_tiger()) ) {
					alt30=1;
				}
				else if ( (true) ) {
					alt30=2;
				}

				}
				break;
			case ID:
				{
				int LA30_3 = input.LA(2);
				if ( (synpred23_tiger()) ) {
					alt30=3;
				}
				else if ( (true) ) {
					alt30=4;
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:889:4: ( intlit index_oper )=> intlit index_oper index_expr
					{
					pushFollow(FOLLOW_intlit_in_index_expr1988);
					intlit214=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_intlit.add(intlit214.getTree());
					pushFollow(FOLLOW_index_oper_in_index_expr1990);
					index_oper215=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_oper.add(index_oper215.getTree());
					pushFollow(FOLLOW_index_expr_in_index_expr1992);
					index_expr216=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr216.getTree());
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
					// 890:2: -> ^( index_oper intlit index_expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:890:5: ^( index_oper intlit index_expr )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:891:4: intlit
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intlit_in_index_expr2008);
					intlit217=intlit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intlit217.getTree());

					}
					break;
				case 3 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:892:4: ( ID index_oper )=> ID index_oper index_expr
					{
					ID218=(Token)match(input,ID,FOLLOW_ID_in_index_expr2021); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ID.add(ID218);

					pushFollow(FOLLOW_index_oper_in_index_expr2023);
					index_oper219=index_oper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_oper.add(index_oper219.getTree());
					pushFollow(FOLLOW_index_expr_in_index_expr2025);
					index_expr220=index_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_index_expr.add(index_expr220.getTree());
					// AST REWRITE
					// elements: ID, index_expr, index_oper
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 893:2: -> ^( index_oper ID index_expr )
					{
						// /Users/cevanish12/git/tiger-compiler/tiger.g:893:5: ^( index_oper ID index_expr )
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
					// /Users/cevanish12/git/tiger-compiler/tiger.g:894:4: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					ID221=(Token)match(input,ID,FOLLOW_ID_in_index_expr2041); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID221_tree = (CommonTree)adaptor.create(ID221);
					adaptor.addChild(root_0, ID221_tree);
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:897:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set222=null;

		CommonTree set222_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:898:2: ( ( PLUS | MINUS | MULT ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set222=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set222));
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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:917:1: func_param_list : ( numExpr ( COMMA numExpr )* )? -> ^( AST_PARAM_LIST ( ( numExpr )+ )? ) ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA224=null;
		ParserRuleReturnScope numExpr223 =null;
		ParserRuleReturnScope numExpr225 =null;

		CommonTree COMMA224_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_numExpr=new RewriteRuleSubtreeStream(adaptor,"rule numExpr");

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:918:2: ( ( numExpr ( COMMA numExpr )* )? -> ^( AST_PARAM_LIST ( ( numExpr )+ )? ) )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:918:4: ( numExpr ( COMMA numExpr )* )?
			{
			// /Users/cevanish12/git/tiger-compiler/tiger.g:918:4: ( numExpr ( COMMA numExpr )* )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==ID||LA32_0==LPAREN||LA32_0==MINUS||(LA32_0 >= UNSIGNED_FIXEDPTLIT && LA32_0 <= UNSIGNED_INTLIT)) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// /Users/cevanish12/git/tiger-compiler/tiger.g:918:5: numExpr ( COMMA numExpr )*
					{
					pushFollow(FOLLOW_numExpr_in_func_param_list2158);
					numExpr223=numExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_numExpr.add(numExpr223.getTree());
					// /Users/cevanish12/git/tiger-compiler/tiger.g:918:13: ( COMMA numExpr )*
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==COMMA) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// /Users/cevanish12/git/tiger-compiler/tiger.g:918:14: COMMA numExpr
							{
							COMMA224=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list2161); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA224);

							pushFollow(FOLLOW_numExpr_in_func_param_list2163);
							numExpr225=numExpr();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_numExpr.add(numExpr225.getTree());
							}
							break;

						default :
							break loop31;
						}
					}

					}
					break;

			}

			// AST REWRITE
			// elements: numExpr
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 919:2: -> ^( AST_PARAM_LIST ( ( numExpr )+ )? )
			{
				// /Users/cevanish12/git/tiger-compiler/tiger.g:919:5: ^( AST_PARAM_LIST ( ( numExpr )+ )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(AST_PARAM_LIST, "AST_PARAM_LIST"), root_1);
				// /Users/cevanish12/git/tiger-compiler/tiger.g:919:22: ( ( numExpr )+ )?
				if ( stream_numExpr.hasNext() ) {
					if ( !(stream_numExpr.hasNext()) ) {
						throw new RewriteEarlyExitException();
					}
					while ( stream_numExpr.hasNext() ) {
						adaptor.addChild(root_1, stream_numExpr.nextTree());
					}
					stream_numExpr.reset();

				}
				stream_numExpr.reset();

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
	// /Users/cevanish12/git/tiger-compiler/tiger.g:922:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set226=null;

		CommonTree set226_tree=null;

		try {
			// /Users/cevanish12/git/tiger-compiler/tiger.g:923:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			// /Users/cevanish12/git/tiger-compiler/tiger.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set226=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= INT_KEY)||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= TYPE_KEY)||(input.LA(1) >= VAR_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set226));
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
		// /Users/cevanish12/git/tiger-compiler/tiger.g:262:4: ( VOID_KEY FUNCTION_KEY )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:262:5: VOID_KEY FUNCTION_KEY
		{
		match(input,VOID_KEY,FOLLOW_VOID_KEY_in_synpred1_tiger200); if (state.failed) return;

		match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_synpred1_tiger202); if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_tiger

	// $ANTLR start synpred2_tiger
	public final void synpred2_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:364:4: ( ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:364:5: ARRAY_KEY LBRACK UNSIGNED_INTLIT RBRACK LBRACK UNSIGNED_INTLIT RBRACK
		{
		match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_synpred2_tiger552); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred2_tiger554); if (state.failed) return;

		match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger556); if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred2_tiger558); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred2_tiger560); if (state.failed) return;

		match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger562); if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred2_tiger564); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_tiger

	// $ANTLR start synpred3_tiger
	public final void synpred3_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:394:4: ( VAR_KEY id_list COLON type_id ASSIGN fixedptlit )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:394:5: VAR_KEY id_list COLON type_id ASSIGN fixedptlit
		{
		match(input,VAR_KEY,FOLLOW_VAR_KEY_in_synpred3_tiger686); if (state.failed) return;

		pushFollow(FOLLOW_id_list_in_synpred3_tiger688);
		id_list();
		state._fsp--;
		if (state.failed) return;

		match(input,COLON,FOLLOW_COLON_in_synpred3_tiger690); if (state.failed) return;

		pushFollow(FOLLOW_type_id_in_synpred3_tiger692);
		type_id();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred3_tiger694); if (state.failed) return;

		pushFollow(FOLLOW_fixedptlit_in_synpred3_tiger696);
		fixedptlit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_tiger

	// $ANTLR start synpred4_tiger
	public final void synpred4_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:472:4: ( VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:472:5: VAR_KEY id_list COLON type_id ASSIGN UNSIGNED_INTLIT
		{
		match(input,VAR_KEY,FOLLOW_VAR_KEY_in_synpred4_tiger740); if (state.failed) return;

		pushFollow(FOLLOW_id_list_in_synpred4_tiger742);
		id_list();
		state._fsp--;
		if (state.failed) return;

		match(input,COLON,FOLLOW_COLON_in_synpred4_tiger744); if (state.failed) return;

		pushFollow(FOLLOW_type_id_in_synpred4_tiger746);
		type_id();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred4_tiger748); if (state.failed) return;

		match(input,UNSIGNED_INTLIT,FOLLOW_UNSIGNED_INTLIT_in_synpred4_tiger750); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_tiger

	// $ANTLR start synpred5_tiger
	public final void synpred5_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:655:5: ( value ASSIGN )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:655:6: value ASSIGN
		{
		pushFollow(FOLLOW_value_in_synpred5_tiger887);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred5_tiger889); if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_tiger

	// $ANTLR start synpred6_tiger
	public final void synpred6_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:663:5: ( IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:663:6: IF_KEY LPAREN expr RPAREN THEN_KEY stat_seq ELSE_KEY
		{
		match(input,IF_KEY,FOLLOW_IF_KEY_in_synpred6_tiger933); if (state.failed) return;

		match(input,LPAREN,FOLLOW_LPAREN_in_synpred6_tiger935); if (state.failed) return;

		pushFollow(FOLLOW_expr_in_synpred6_tiger937);
		expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred6_tiger939); if (state.failed) return;

		match(input,THEN_KEY,FOLLOW_THEN_KEY_in_synpred6_tiger941); if (state.failed) return;

		pushFollow(FOLLOW_stat_seq_in_synpred6_tiger943);
		stat_seq();
		state._fsp--;
		if (state.failed) return;

		match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_synpred6_tiger945); if (state.failed) return;

		}

	}
	// $ANTLR end synpred6_tiger

	// $ANTLR start synpred7_tiger
	public final void synpred7_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:684:4: ( value ASSIGN func_call )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:684:5: value ASSIGN func_call
		{
		pushFollow(FOLLOW_value_in_synpred7_tiger1126);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred7_tiger1128); if (state.failed) return;

		pushFollow(FOLLOW_func_call_in_synpred7_tiger1130);
		func_call();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_tiger

	// $ANTLR start synpred8_tiger
	public final void synpred8_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:691:5: ( value ASSIGN expr )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:691:6: value ASSIGN expr
		{
		pushFollow(FOLLOW_value_in_synpred8_tiger1163);
		value();
		state._fsp--;
		if (state.failed) return;

		match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred8_tiger1165); if (state.failed) return;

		pushFollow(FOLLOW_expr_in_synpred8_tiger1167);
		expr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_tiger

	// $ANTLR start synpred10_tiger
	public final void synpred10_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:732:5: ( boolExpr )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:732:6: boolExpr
		{
		pushFollow(FOLLOW_boolExpr_in_synpred10_tiger1295);
		boolExpr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred10_tiger

	// $ANTLR start synpred11_tiger
	public final void synpred11_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:736:5: ( numExpr )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:736:6: numExpr
		{
		pushFollow(FOLLOW_numExpr_in_synpred11_tiger1309);
		numExpr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred11_tiger

	// $ANTLR start synpred12_tiger
	public final void synpred12_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:747:5: ( constval binop_p0 )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:747:6: constval binop_p0
		{
		pushFollow(FOLLOW_constval_in_synpred12_tiger1351);
		constval();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_binop_p0_in_synpred12_tiger1353);
		binop_p0();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_tiger

	// $ANTLR start synpred13_tiger
	public final void synpred13_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:752:5: ( value binop_p0 )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:752:6: value binop_p0
		{
		pushFollow(FOLLOW_value_in_synpred13_tiger1384);
		value();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_binop_p0_in_synpred13_tiger1386);
		binop_p0();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred13_tiger

	// $ANTLR start synpred14_tiger
	public final void synpred14_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:757:5: ( LPAREN expr RPAREN binop_p0 )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:757:6: LPAREN expr RPAREN binop_p0
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred14_tiger1416); if (state.failed) return;

		pushFollow(FOLLOW_expr_in_synpred14_tiger1418);
		expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred14_tiger1420); if (state.failed) return;

		pushFollow(FOLLOW_binop_p0_in_synpred14_tiger1422);
		binop_p0();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred14_tiger

	// $ANTLR start synpred15_tiger
	public final void synpred15_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:764:5: ( constval binop_p2 )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:764:6: constval binop_p2
		{
		pushFollow(FOLLOW_constval_in_synpred15_tiger1463);
		constval();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_binop_p2_in_synpred15_tiger1465);
		binop_p2();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred15_tiger

	// $ANTLR start synpred16_tiger
	public final void synpred16_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:773:5: ( value binop_p2 )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:773:6: value binop_p2
		{
		pushFollow(FOLLOW_value_in_synpred16_tiger1503);
		value();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_binop_p2_in_synpred16_tiger1505);
		binop_p2();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred16_tiger

	// $ANTLR start synpred17_tiger
	public final void synpred17_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:782:5: ( LPAREN expr RPAREN binop_p2 )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:782:6: LPAREN expr RPAREN binop_p2
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred17_tiger1543); if (state.failed) return;

		pushFollow(FOLLOW_expr_in_synpred17_tiger1545);
		expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred17_tiger1547); if (state.failed) return;

		pushFollow(FOLLOW_binop_p2_in_synpred17_tiger1549);
		binop_p2();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred17_tiger

	// $ANTLR start synpred18_tiger
	public final void synpred18_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:813:5: ( fixedptlit )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:813:6: fixedptlit
		{
		pushFollow(FOLLOW_fixedptlit_in_synpred18_tiger1720);
		fixedptlit();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred18_tiger

	// $ANTLR start synpred19_tiger
	public final void synpred19_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:841:4: ( expr )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:841:5: expr
		{
		pushFollow(FOLLOW_expr_in_synpred19_tiger1849);
		expr();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred19_tiger

	// $ANTLR start synpred20_tiger
	public final void synpred20_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:848:5: ( ID LBRACK index_expr RBRACK LBRACK )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:848:6: ID LBRACK index_expr RBRACK LBRACK
		{
		match(input,ID,FOLLOW_ID_in_synpred20_tiger1913); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred20_tiger1915); if (state.failed) return;

		pushFollow(FOLLOW_index_expr_in_synpred20_tiger1917);
		index_expr();
		state._fsp--;
		if (state.failed) return;

		match(input,RBRACK,FOLLOW_RBRACK_in_synpred20_tiger1919); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred20_tiger1921); if (state.failed) return;

		}

	}
	// $ANTLR end synpred20_tiger

	// $ANTLR start synpred21_tiger
	public final void synpred21_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:862:4: ( ID LBRACK )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:862:5: ID LBRACK
		{
		match(input,ID,FOLLOW_ID_in_synpred21_tiger1946); if (state.failed) return;

		match(input,LBRACK,FOLLOW_LBRACK_in_synpred21_tiger1948); if (state.failed) return;

		}

	}
	// $ANTLR end synpred21_tiger

	// $ANTLR start synpred22_tiger
	public final void synpred22_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:889:4: ( intlit index_oper )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:889:5: intlit index_oper
		{
		pushFollow(FOLLOW_intlit_in_synpred22_tiger1981);
		intlit();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_index_oper_in_synpred22_tiger1983);
		index_oper();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred22_tiger

	// $ANTLR start synpred23_tiger
	public final void synpred23_tiger_fragment() throws RecognitionException {
		// /Users/cevanish12/git/tiger-compiler/tiger.g:892:4: ( ID index_oper )
		// /Users/cevanish12/git/tiger-compiler/tiger.g:892:5: ID index_oper
		{
		match(input,ID,FOLLOW_ID_in_synpred23_tiger2014); if (state.failed) return;

		pushFollow(FOLLOW_index_oper_in_synpred23_tiger2016);
		index_oper();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred23_tiger

	// Delegated rules

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
	public final boolean synpred22_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred22_tiger_fragment(); // can never throw exception
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
	public final boolean synpred23_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred23_tiger_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred21_tiger() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_tiger_fragment(); // can never throw exception
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
	public static final BitSet FOLLOW_RPAREN_in_return_func171 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_begin_in_return_func173 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_list_in_return_func175 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_return_func177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_void_func207 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_void_func209 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_void_func211 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_void_func215 = new BitSet(new long[]{0x0008000200000000L});
	public static final BitSet FOLLOW_param_list_in_void_func217 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_void_func225 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_begin_in_void_func227 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_list_in_void_func229 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_void_func231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_void_func251 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_void_func253 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_void_func257 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_void_func259 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_begin_in_void_func261 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_block_list_in_void_func263 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_void_func265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_END_KEY_in_block_end286 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_block_end288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list329 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_param_list334 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_param_in_param_list336 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ID_in_param373 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_param375 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_param377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list401 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_begin_in_block417 = new BitSet(new long[]{0x0900000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block420 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_block422 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_block_end_in_block425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_begin451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement465 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list481 = new BitSet(new long[]{0x0100000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list495 = new BitSet(new long[]{0x0800000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration508 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration510 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration512 = new BitSet(new long[]{0x0000001010000020L});
	public static final BitSet FOLLOW_type_in_type_declaration514 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type572 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type574 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_type578 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type580 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type582 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_type586 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type588 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type590 = new BitSet(new long[]{0x0000001010000000L});
	public static final BitSet FOLLOW_base_type_in_type592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type616 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_type618 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_type620 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type622 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type624 = new BitSet(new long[]{0x0000001010000000L});
	public static final BitSet FOLLOW_base_type_in_type626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration701 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration703 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration705 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration707 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration709 = new BitSet(new long[]{0x0200040000000000L});
	public static final BitSet FOLLOW_fixedptlit_in_var_declaration711 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration755 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration757 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration759 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration761 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration763 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_var_declaration765 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration794 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration796 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_var_declaration798 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration800 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list830 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_id_list833 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_id_list835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq858 = new BitSet(new long[]{0x2004000A20018002L});
	public static final BitSet FOLLOW_if_stat_in_stat870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_while_stat_in_stat875 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_for_stat_in_stat880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assign_stat_in_stat894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_stat901 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_break_stat_in_stat909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_return_stat_in_stat914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat919 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_if_stat951 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_if_stat953 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_if_stat955 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_if_stat957 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat959 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat961 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ELSE_KEY_in_if_stat963 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat965 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat967 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_if_stat992 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_if_stat994 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_if_stat996 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_if_stat998 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_if_stat1000 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_if_stat1002 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_if_stat1004 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_if_stat1006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_while_stat1028 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_while_stat1030 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_while_stat1032 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_while_stat1034 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_DO_KEY_in_while_stat1036 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_while_stat1040 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_while_stat1042 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_while_stat1044 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_for_stat1069 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_ID_in_for_stat1071 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_for_stat1073 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1075 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_for_stat1077 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_for_stat1079 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_DO_KEY_in_for_stat1081 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_for_stat1085 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_for_stat1087 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_for_stat1089 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat1135 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat1137 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_func_call_in_assign_stat1139 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat1141 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_assign_stat1172 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_assign_stat1174 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_assign_stat1176 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_assign_stat1178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call1203 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call1205 = new BitSet(new long[]{0x0608050200000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call1207 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call1209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_break_stat1234 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_break_stat1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_return_stat1263 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_return_stat1265 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_SEMI_in_return_stat1267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolExpr_in_expr1300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr_in_expr1314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_expr1322 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr1327 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr1329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_boolExpr1358 = new BitSet(new long[]{0x000090C188000010L});
	public static final BitSet FOLLOW_binop_p0_in_boolExpr1360 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_boolExpr1362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_boolExpr1391 = new BitSet(new long[]{0x000090C188000010L});
	public static final BitSet FOLLOW_binop_p0_in_boolExpr1393 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_boolExpr1395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolExpr1427 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_boolExpr1432 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_boolExpr1434 = new BitSet(new long[]{0x000090C188000010L});
	public static final BitSet FOLLOW_binop_p0_in_boolExpr1437 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_boolExpr1442 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_numExpr1470 = new BitSet(new long[]{0x00010C0000200000L});
	public static final BitSet FOLLOW_binop_p2_in_numExpr1472 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_numExpr1474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_numExpr1494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_numExpr1510 = new BitSet(new long[]{0x00010C0000200000L});
	public static final BitSet FOLLOW_binop_p2_in_numExpr1512 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_numExpr1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_numExpr1534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_numExpr1554 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_numExpr1559 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_numExpr1561 = new BitSet(new long[]{0x00010C0000200000L});
	public static final BitSet FOLLOW_binop_p2_in_numExpr1564 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_numExpr1569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p01592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p01596 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p01600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_binop_p11619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p21666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p21670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p21674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_binop_p31693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fixedptlit_in_constval1725 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_constval1732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_intlit1744 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_intlit1747 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_fixedptlit1771 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_FIXEDPTLIT_in_fixedptlit1774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list1854 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list1857 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr_list1859 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_expr_in_expr_list1877 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list1880 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_expr_list1882 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_ID_in_value1926 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1928 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1930 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1932 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1934 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1936 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1953 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_value1955 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_value1957 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value1959 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value1966 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_index_expr1988 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_index_expr1990 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr1992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_index_expr2008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr2021 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_index_expr2023 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr2025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_index_expr2041 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr_in_func_param_list2158 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list2161 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_numExpr_in_func_param_list2163 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_VOID_KEY_in_synpred1_tiger200 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_synpred1_tiger202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_synpred2_tiger552 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred2_tiger554 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger556 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred2_tiger558 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred2_tiger560 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_synpred2_tiger562 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred2_tiger564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_synpred3_tiger686 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_synpred3_tiger688 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_synpred3_tiger690 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_synpred3_tiger692 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred3_tiger694 = new BitSet(new long[]{0x0200040000000000L});
	public static final BitSet FOLLOW_fixedptlit_in_synpred3_tiger696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_synpred4_tiger740 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_id_list_in_synpred4_tiger742 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_COLON_in_synpred4_tiger744 = new BitSet(new long[]{0x0000001210000000L});
	public static final BitSet FOLLOW_type_id_in_synpred4_tiger746 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred4_tiger748 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_UNSIGNED_INTLIT_in_synpred4_tiger750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred5_tiger887 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred5_tiger889 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_KEY_in_synpred6_tiger933 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_LPAREN_in_synpred6_tiger935 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_synpred6_tiger937 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred6_tiger939 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_synpred6_tiger941 = new BitSet(new long[]{0x2004000A20018000L});
	public static final BitSet FOLLOW_stat_seq_in_synpred6_tiger943 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ELSE_KEY_in_synpred6_tiger945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred7_tiger1126 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred7_tiger1128 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_func_call_in_synpred7_tiger1130 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred8_tiger1163 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_synpred8_tiger1165 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_synpred8_tiger1167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolExpr_in_synpred10_tiger1295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numExpr_in_synpred11_tiger1309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_synpred12_tiger1351 = new BitSet(new long[]{0x000090C188000010L});
	public static final BitSet FOLLOW_binop_p0_in_synpred12_tiger1353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred13_tiger1384 = new BitSet(new long[]{0x000090C188000010L});
	public static final BitSet FOLLOW_binop_p0_in_synpred13_tiger1386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred14_tiger1416 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_synpred14_tiger1418 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred14_tiger1420 = new BitSet(new long[]{0x000090C188000010L});
	public static final BitSet FOLLOW_binop_p0_in_synpred14_tiger1422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_synpred15_tiger1463 = new BitSet(new long[]{0x00010C0000200000L});
	public static final BitSet FOLLOW_binop_p2_in_synpred15_tiger1465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_synpred16_tiger1503 = new BitSet(new long[]{0x00010C0000200000L});
	public static final BitSet FOLLOW_binop_p2_in_synpred16_tiger1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred17_tiger1543 = new BitSet(new long[]{0x0600050200000000L});
	public static final BitSet FOLLOW_expr_in_synpred17_tiger1545 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred17_tiger1547 = new BitSet(new long[]{0x00010C0000200000L});
	public static final BitSet FOLLOW_binop_p2_in_synpred17_tiger1549 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fixedptlit_in_synpred18_tiger1720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_synpred19_tiger1849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred20_tiger1913 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred20_tiger1915 = new BitSet(new long[]{0x0400040200000000L});
	public static final BitSet FOLLOW_index_expr_in_synpred20_tiger1917 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_RBRACK_in_synpred20_tiger1919 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred20_tiger1921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred21_tiger1946 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_LBRACK_in_synpred21_tiger1948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intlit_in_synpred22_tiger1981 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_synpred22_tiger1983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_synpred23_tiger2014 = new BitSet(new long[]{0x00010C0000000000L});
	public static final BitSet FOLLOW_index_oper_in_synpred23_tiger2016 = new BitSet(new long[]{0x0000000000000002L});
}
