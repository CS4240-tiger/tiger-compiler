// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-14 08:40:00

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class tigerParser extends DebugParser {
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


	public static final String[] ruleNames = new String[] {
		"invalidRule", "funct_declaration", "func_param_list", "ret_type", "var_declaration", 
		"binop_p3", "param_list", "block_list", "binary_operator", "stat_seq", 
		"func_call_tail", "tiger_program", "type_declaration_list", "var_declaration_list", 
		"funct_declaration_tail", "type_declaration", "base_type", "binop_p1", 
		"type_id", "id_list", "main_function_tail", "binop_p2", "stat", "param", 
		"block", "expr", "value_tail", "index_expr", "expr_list", "type", "keywords", 
		"declaration_statement", "funct_declaration_list", "index_oper", "binop_p0", 
		"constval", "value"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false
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


	  @Override
	    public void reportError(RecognitionException e) {
	      displayRecognitionError(this.getTokenNames(), e);
	  }
	  @Override
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	        //entire function
	        String code = e.input.toString();
	        //line index
	        int lineIndex = e.line;
	        //split into an array by lines
	        String lines[] = code.split("\\r?\\n");
	        //get the line of code with everything before the first charracter turned into spaces
	        String lineCode = lines[lineIndex-1].replaceAll("\t", " ");
	        //turned to char array
	        if (e.charPositionInLine == 0) {
	          lineCode = "' '" + lineCode;
	        } else if (e.charPositionInLine == lineCode.length()) {
	          lineCode = lineCode + "' '";
	        } else {
	          lineCode = lineCode.substring(0,e.charPositionInLine) + "'" + lineCode.charAt(e.charPositionInLine) + "'" + lineCode.substring(e.charPositionInLine+1,lineCode.length());
	        }
	        lineCode = lineCode.replaceFirst(".*?(?=[a-zA-Z0-9\'])", "");
	        System.err.println("Error At Line "+String.valueOf(lineIndex)+": "+ lineCode + " ("+getErrorMessage(e, tokenNames)+")");
	    }


	public static class tiger_program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tiger_program"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:64:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final tigerParser.tiger_program_return tiger_program() throws RecognitionException {
		tigerParser.tiger_program_return retval = new tigerParser.tiger_program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration_list1 =null;
		ParserRuleReturnScope funct_declaration_list2 =null;


		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(64, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:65:2: ( type_declaration_list funct_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:65:4: type_declaration_list funct_declaration_list
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(65,4);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program69);
			type_declaration_list1=type_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, type_declaration_list1.getTree());
			dbg.location(65,26);
			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program71);
			funct_declaration_list2=funct_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, funct_declaration_list2.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(66, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:1: funct_declaration_list : ( funct_declaration )* ;
	public final tigerParser.funct_declaration_list_return funct_declaration_list() throws RecognitionException {
		tigerParser.funct_declaration_list_return retval = new tigerParser.funct_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope funct_declaration3 =null;


		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(68, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:69:2: ( ( funct_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:69:4: ( funct_declaration )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(69,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:69:4: ( funct_declaration )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:69:4: funct_declaration
					{
					dbg.location(69,4);
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list83);
					funct_declaration3=funct_declaration();
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration3.getTree());

					}
					break;

				default :
					break loop1;
				}
			}
			} finally {dbg.exitSubRule(1);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(70, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:1: funct_declaration : ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) ^ BEGIN_KEY ! block_list ^ END_KEY ! SEMI !;
	public final tigerParser.funct_declaration_return funct_declaration() throws RecognitionException {
		tigerParser.funct_declaration_return retval = new tigerParser.funct_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VOID_KEY6=null;
		Token BEGIN_KEY9=null;
		Token END_KEY11=null;
		Token SEMI12=null;
		ParserRuleReturnScope type_id4 =null;
		ParserRuleReturnScope funct_declaration_tail5 =null;
		ParserRuleReturnScope funct_declaration_tail7 =null;
		ParserRuleReturnScope main_function_tail8 =null;
		ParserRuleReturnScope block_list10 =null;

		Object VOID_KEY6_tree=null;
		Object BEGIN_KEY9_tree=null;
		Object END_KEY11_tree=null;
		Object SEMI12_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "funct_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(72, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:2: ( ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) ^ BEGIN_KEY ! block_list ^ END_KEY ! SEMI !)
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) ^ BEGIN_KEY ! block_list ^ END_KEY ! SEMI !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(73,97);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) )
			int alt3=2;
			try { dbg.enterSubRule(3);
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==FIXEDPT_KEY||LA3_0==ID||LA3_0==INT_KEY) ) {
				alt3=1;
			}
			else if ( (LA3_0==VOID_KEY) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:5: ( type_id funct_declaration_tail )
					{
					dbg.location(73,5);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:5: ( type_id funct_declaration_tail )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:6: type_id funct_declaration_tail
					{
					dbg.location(73,6);
					pushFollow(FOLLOW_type_id_in_funct_declaration97);
					type_id4=type_id();
					state._fsp--;

					adaptor.addChild(root_0, type_id4.getTree());
					dbg.location(73,14);
					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration99);
					funct_declaration_tail5=funct_declaration_tail();
					state._fsp--;

					adaptor.addChild(root_0, funct_declaration_tail5.getTree());

					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					{
					dbg.location(73,40);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:41: VOID_KEY ( funct_declaration_tail | main_function_tail )
					{
					dbg.location(73,41);
					VOID_KEY6=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_funct_declaration105); 
					VOID_KEY6_tree = (Object)adaptor.create(VOID_KEY6);
					adaptor.addChild(root_0, VOID_KEY6_tree);
					dbg.location(73,50);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:50: ( funct_declaration_tail | main_function_tail )
					int alt2=2;
					try { dbg.enterSubRule(2);
					try { dbg.enterDecision(2, decisionCanBacktrack[2]);

					int LA2_0 = input.LA(1);
					if ( (LA2_0==FUNCTION_KEY) ) {
						alt2=1;
					}
					else if ( (LA2_0==MAIN_KEY) ) {
						alt2=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(2);}

					switch (alt2) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:51: funct_declaration_tail
							{
							dbg.location(73,51);
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration108);
							funct_declaration_tail7=funct_declaration_tail();
							state._fsp--;

							adaptor.addChild(root_0, funct_declaration_tail7.getTree());

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:73:76: main_function_tail
							{
							dbg.location(73,76);
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration112);
							main_function_tail8=main_function_tail();
							state._fsp--;

							adaptor.addChild(root_0, main_function_tail8.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(2);}

					}

					}
					break;

			}
			} finally {dbg.exitSubRule(3);}
			dbg.location(73,108);
			BEGIN_KEY9=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration118); dbg.location(73,120);
			pushFollow(FOLLOW_block_list_in_funct_declaration121);
			block_list10=block_list();
			state._fsp--;

			root_0 = (Object)adaptor.becomeRoot(block_list10.getTree(), root_0);dbg.location(73,129);
			END_KEY11=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration124); dbg.location(73,135);
			SEMI12=(Token)match(input,SEMI,FOLLOW_SEMI_in_funct_declaration127); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(74, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funct_declaration"


	public static class funct_declaration_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funct_declaration_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:76:1: funct_declaration_tail : FUNCTION_KEY ID LPAREN param_list RPAREN ;
	public final tigerParser.funct_declaration_tail_return funct_declaration_tail() throws RecognitionException {
		tigerParser.funct_declaration_tail_return retval = new tigerParser.funct_declaration_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token FUNCTION_KEY13=null;
		Token ID14=null;
		Token LPAREN15=null;
		Token RPAREN17=null;
		ParserRuleReturnScope param_list16 =null;

		Object FUNCTION_KEY13_tree=null;
		Object ID14_tree=null;
		Object LPAREN15_tree=null;
		Object RPAREN17_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(76, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:77:3: ( FUNCTION_KEY ID LPAREN param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:77:5: FUNCTION_KEY ID LPAREN param_list RPAREN
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(77,5);
			FUNCTION_KEY13=(Token)match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration_tail140); 
			FUNCTION_KEY13_tree = (Object)adaptor.create(FUNCTION_KEY13);
			adaptor.addChild(root_0, FUNCTION_KEY13_tree);
			dbg.location(77,18);
			ID14=(Token)match(input,ID,FOLLOW_ID_in_funct_declaration_tail142); 
			ID14_tree = (Object)adaptor.create(ID14);
			adaptor.addChild(root_0, ID14_tree);
			dbg.location(77,21);
			LPAREN15=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail144); 
			LPAREN15_tree = (Object)adaptor.create(LPAREN15);
			adaptor.addChild(root_0, LPAREN15_tree);
			dbg.location(77,28);
			pushFollow(FOLLOW_param_list_in_funct_declaration_tail146);
			param_list16=param_list();
			state._fsp--;

			adaptor.addChild(root_0, param_list16.getTree());
			dbg.location(77,39);
			RPAREN17=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail148); 
			RPAREN17_tree = (Object)adaptor.create(RPAREN17);
			adaptor.addChild(root_0, RPAREN17_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(78, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funct_declaration_tail"


	public static class main_function_tail_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "main_function_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:1: main_function_tail : MAIN_KEY LPAREN RPAREN ;
	public final tigerParser.main_function_tail_return main_function_tail() throws RecognitionException {
		tigerParser.main_function_tail_return retval = new tigerParser.main_function_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MAIN_KEY18=null;
		Token LPAREN19=null;
		Token RPAREN20=null;

		Object MAIN_KEY18_tree=null;
		Object LPAREN19_tree=null;
		Object RPAREN20_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "main_function_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(80, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:81:2: ( MAIN_KEY LPAREN RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:81:4: MAIN_KEY LPAREN RPAREN
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(81,4);
			MAIN_KEY18=(Token)match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function_tail160); 
			MAIN_KEY18_tree = (Object)adaptor.create(MAIN_KEY18);
			adaptor.addChild(root_0, MAIN_KEY18_tree);
			dbg.location(81,13);
			LPAREN19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail162); 
			LPAREN19_tree = (Object)adaptor.create(LPAREN19);
			adaptor.addChild(root_0, LPAREN19_tree);
			dbg.location(81,20);
			RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail164); 
			RPAREN20_tree = (Object)adaptor.create(RPAREN20);
			adaptor.addChild(root_0, RPAREN20_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(82, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "main_function_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "main_function_tail"


	public static class ret_type_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:1: ret_type : ( VOID_KEY | type_id );
	public final tigerParser.ret_type_return ret_type() throws RecognitionException {
		tigerParser.ret_type_return retval = new tigerParser.ret_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VOID_KEY21=null;
		ParserRuleReturnScope type_id22 =null;

		Object VOID_KEY21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "ret_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(84, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:85:2: ( VOID_KEY | type_id )
			int alt4=2;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==VOID_KEY) ) {
				alt4=1;
			}
			else if ( (LA4_0==FIXEDPT_KEY||LA4_0==ID||LA4_0==INT_KEY) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:85:4: VOID_KEY
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(85,4);
					VOID_KEY21=(Token)match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type176); 
					VOID_KEY21_tree = (Object)adaptor.create(VOID_KEY21);
					adaptor.addChild(root_0, VOID_KEY21_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:86:4: type_id
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(86,4);
					pushFollow(FOLLOW_type_id_in_ret_type181);
					type_id22=type_id();
					state._fsp--;

					adaptor.addChild(root_0, type_id22.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(87, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:1: param_list : ( param ( COMMA param )* )? ;
	public final tigerParser.param_list_return param_list() throws RecognitionException {
		tigerParser.param_list_return retval = new tigerParser.param_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA24=null;
		ParserRuleReturnScope param23 =null;
		ParserRuleReturnScope param25 =null;

		Object COMMA24_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(89, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:2: ( ( param ( COMMA param )* )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:4: ( param ( COMMA param )* )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(90,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:4: ( param ( COMMA param )* )?
			int alt6=2;
			try { dbg.enterSubRule(6);
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:5: param ( COMMA param )*
					{
					dbg.location(90,5);
					pushFollow(FOLLOW_param_in_param_list194);
					param23=param();
					state._fsp--;

					adaptor.addChild(root_0, param23.getTree());
					dbg.location(90,11);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:11: ( COMMA param )*
					try { dbg.enterSubRule(5);

					loop5:
					while (true) {
						int alt5=2;
						try { dbg.enterDecision(5, decisionCanBacktrack[5]);

						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						} finally {dbg.exitDecision(5);}

						switch (alt5) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:12: COMMA param
							{
							dbg.location(90,12);
							COMMA24=(Token)match(input,COMMA,FOLLOW_COMMA_in_param_list197); 
							COMMA24_tree = (Object)adaptor.create(COMMA24);
							adaptor.addChild(root_0, COMMA24_tree);
							dbg.location(90,18);
							pushFollow(FOLLOW_param_in_param_list199);
							param25=param();
							state._fsp--;

							adaptor.addChild(root_0, param25.getTree());

							}
							break;

						default :
							break loop5;
						}
					}
					} finally {dbg.exitSubRule(5);}

					}
					break;

			}
			} finally {dbg.exitSubRule(6);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(91, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:1: param : ID COLON ^ type_id ;
	public final tigerParser.param_return param() throws RecognitionException {
		tigerParser.param_return retval = new tigerParser.param_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID26=null;
		Token COLON27=null;
		ParserRuleReturnScope type_id28 =null;

		Object ID26_tree=null;
		Object COLON27_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(93, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:8: ( ID COLON ^ type_id )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:10: ID COLON ^ type_id
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(93,10);
			ID26=(Token)match(input,ID,FOLLOW_ID_in_param214); 
			ID26_tree = (Object)adaptor.create(ID26);
			adaptor.addChild(root_0, ID26_tree);
			dbg.location(93,18);
			COLON27=(Token)match(input,COLON,FOLLOW_COLON_in_param216); 
			COLON27_tree = (Object)adaptor.create(COLON27);
			root_0 = (Object)adaptor.becomeRoot(COLON27_tree, root_0);
			dbg.location(93,20);
			pushFollow(FOLLOW_type_id_in_param219);
			type_id28=type_id();
			state._fsp--;

			adaptor.addChild(root_0, type_id28.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(93, 26);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:95:1: block_list : ( block )+ ;
	public final tigerParser.block_list_return block_list() throws RecognitionException {
		tigerParser.block_list_return retval = new tigerParser.block_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope block29 =null;


		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(95, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:2: ( ( block )+ )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:4: ( block )+
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(96,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:4: ( block )+
			int cnt7=0;
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==BEGIN_KEY) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:4: block
					{
					dbg.location(96,4);
					pushFollow(FOLLOW_block_in_block_list229);
					block29=block();
					state._fsp--;

					adaptor.addChild(root_0, block29.getTree());

					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt7++;
			}
			} finally {dbg.exitSubRule(7);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(97, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:1: block : BEGIN_KEY ^ ( declaration_statement stat_seq ) ^ END_KEY ! SEMI !;
	public final tigerParser.block_return block() throws RecognitionException {
		tigerParser.block_return retval = new tigerParser.block_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token BEGIN_KEY30=null;
		Token END_KEY33=null;
		Token SEMI34=null;
		ParserRuleReturnScope declaration_statement31 =null;
		ParserRuleReturnScope stat_seq32 =null;

		Object BEGIN_KEY30_tree=null;
		Object END_KEY33_tree=null;
		Object SEMI34_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(99, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:8: ( BEGIN_KEY ^ ( declaration_statement stat_seq ) ^ END_KEY ! SEMI !)
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:10: BEGIN_KEY ^ ( declaration_statement stat_seq ) ^ END_KEY ! SEMI !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(99,19);
			BEGIN_KEY30=(Token)match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block241); 
			BEGIN_KEY30_tree = (Object)adaptor.create(BEGIN_KEY30);
			root_0 = (Object)adaptor.becomeRoot(BEGIN_KEY30_tree, root_0);
			dbg.location(99,53);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:21: ( declaration_statement stat_seq )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:22: declaration_statement stat_seq
			{
			dbg.location(99,22);
			pushFollow(FOLLOW_declaration_statement_in_block245);
			declaration_statement31=declaration_statement();
			state._fsp--;

			adaptor.addChild(root_0, declaration_statement31.getTree());
			dbg.location(99,44);
			pushFollow(FOLLOW_stat_seq_in_block247);
			stat_seq32=stat_seq();
			state._fsp--;

			adaptor.addChild(root_0, stat_seq32.getTree());

			}
			dbg.location(99,62);
			END_KEY33=(Token)match(input,END_KEY,FOLLOW_END_KEY_in_block251); dbg.location(99,68);
			SEMI34=(Token)match(input,SEMI,FOLLOW_SEMI_in_block254); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(99, 68);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:101:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final tigerParser.declaration_statement_return declaration_statement() throws RecognitionException {
		tigerParser.declaration_statement_return retval = new tigerParser.declaration_statement_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration_list35 =null;
		ParserRuleReturnScope var_declaration_list36 =null;


		try { dbg.enterRule(getGrammarFileName(), "declaration_statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(101, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:102:2: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:102:4: type_declaration_list var_declaration_list
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(102,4);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement265);
			type_declaration_list35=type_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, type_declaration_list35.getTree());
			dbg.location(102,26);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement267);
			var_declaration_list36=var_declaration_list();
			state._fsp--;

			adaptor.addChild(root_0, var_declaration_list36.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(103, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:1: type_declaration_list : ( type_declaration )* ;
	public final tigerParser.type_declaration_list_return type_declaration_list() throws RecognitionException {
		tigerParser.type_declaration_list_return retval = new tigerParser.type_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope type_declaration37 =null;


		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(105, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:2: ( ( type_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:5: ( type_declaration )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(106,5);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:5: ( type_declaration )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==TYPE_KEY) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:5: type_declaration
					{
					dbg.location(106,5);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list281);
					type_declaration37=type_declaration();
					state._fsp--;

					adaptor.addChild(root_0, type_declaration37.getTree());

					}
					break;

				default :
					break loop8;
				}
			}
			} finally {dbg.exitSubRule(8);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(107, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:109:1: var_declaration_list : ( var_declaration )* ;
	public final tigerParser.var_declaration_list_return var_declaration_list() throws RecognitionException {
		tigerParser.var_declaration_list_return retval = new tigerParser.var_declaration_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope var_declaration38 =null;


		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(109, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:2: ( ( var_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:4: ( var_declaration )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(110,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:4: ( var_declaration )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==VAR_KEY) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:4: var_declaration
					{
					dbg.location(110,4);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list295);
					var_declaration38=var_declaration();
					state._fsp--;

					adaptor.addChild(root_0, var_declaration38.getTree());

					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(111, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:113:1: type_declaration : ( TYPE_KEY ID ) ^ EQ ^ type SEMI !;
	public final tigerParser.type_declaration_return type_declaration() throws RecognitionException {
		tigerParser.type_declaration_return retval = new tigerParser.type_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token TYPE_KEY39=null;
		Token ID40=null;
		Token EQ41=null;
		Token SEMI43=null;
		ParserRuleReturnScope type42 =null;

		Object TYPE_KEY39_tree=null;
		Object ID40_tree=null;
		Object EQ41_tree=null;
		Object SEMI43_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "type_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(113, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:2: ( ( TYPE_KEY ID ) ^ EQ ^ type SEMI !)
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: ( TYPE_KEY ID ) ^ EQ ^ type SEMI !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(114,17);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: ( TYPE_KEY ID )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:5: TYPE_KEY ID
			{
			dbg.location(114,5);
			TYPE_KEY39=(Token)match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration309); 
			TYPE_KEY39_tree = (Object)adaptor.create(TYPE_KEY39);
			adaptor.addChild(root_0, TYPE_KEY39_tree);
			dbg.location(114,14);
			ID40=(Token)match(input,ID,FOLLOW_ID_in_type_declaration311); 
			ID40_tree = (Object)adaptor.create(ID40);
			adaptor.addChild(root_0, ID40_tree);

			}
			dbg.location(114,21);
			EQ41=(Token)match(input,EQ,FOLLOW_EQ_in_type_declaration315); 
			EQ41_tree = (Object)adaptor.create(EQ41);
			root_0 = (Object)adaptor.becomeRoot(EQ41_tree, root_0);
			dbg.location(114,23);
			pushFollow(FOLLOW_type_in_type_declaration318);
			type42=type();
			state._fsp--;

			adaptor.addChild(root_0, type42.getTree());
			dbg.location(114,32);
			SEMI43=(Token)match(input,SEMI,FOLLOW_SEMI_in_type_declaration320); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(115, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:1: type : ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) ^ OF_KEY ^ ( base_type ) ^);
	public final tigerParser.type_return type() throws RecognitionException {
		tigerParser.type_return retval = new tigerParser.type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ARRAY_KEY45=null;
		Token LBRACK46=null;
		Token INTLIT47=null;
		Token RBRACK48=null;
		Token LBRACK49=null;
		Token INTLIT50=null;
		Token RBRACK51=null;
		Token OF_KEY52=null;
		ParserRuleReturnScope base_type44 =null;
		ParserRuleReturnScope base_type53 =null;

		Object ARRAY_KEY45_tree=null;
		Object LBRACK46_tree=null;
		Object INTLIT47_tree=null;
		Object RBRACK48_tree=null;
		Object LBRACK49_tree=null;
		Object INTLIT50_tree=null;
		Object RBRACK51_tree=null;
		Object OF_KEY52_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(117, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:6: ( base_type | ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) ^ OF_KEY ^ ( base_type ) ^)
			int alt11=2;
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==FIXEDPT_KEY||LA11_0==INT_KEY) ) {
				alt11=1;
			}
			else if ( (LA11_0==ARRAY_KEY) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:8: base_type
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(117,8);
					pushFollow(FOLLOW_base_type_in_type332);
					base_type44=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type44.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? ) ^ OF_KEY ^ ( base_type ) ^
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(118,60);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:4: ( ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:5: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )?
					{
					dbg.location(118,5);
					ARRAY_KEY45=(Token)match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type338); 
					ARRAY_KEY45_tree = (Object)adaptor.create(ARRAY_KEY45);
					adaptor.addChild(root_0, ARRAY_KEY45_tree);
					dbg.location(118,15);
					LBRACK46=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type340); 
					LBRACK46_tree = (Object)adaptor.create(LBRACK46);
					adaptor.addChild(root_0, LBRACK46_tree);
					dbg.location(118,22);
					INTLIT47=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type342); 
					INTLIT47_tree = (Object)adaptor.create(INTLIT47);
					adaptor.addChild(root_0, INTLIT47_tree);
					dbg.location(118,29);
					RBRACK48=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type344); 
					RBRACK48_tree = (Object)adaptor.create(RBRACK48);
					adaptor.addChild(root_0, RBRACK48_tree);
					dbg.location(118,36);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:36: ( LBRACK INTLIT RBRACK )?
					int alt10=2;
					try { dbg.enterSubRule(10);
					try { dbg.enterDecision(10, decisionCanBacktrack[10]);

					int LA10_0 = input.LA(1);
					if ( (LA10_0==LBRACK) ) {
						alt10=1;
					}
					} finally {dbg.exitDecision(10);}

					switch (alt10) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:37: LBRACK INTLIT RBRACK
							{
							dbg.location(118,37);
							LBRACK49=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_type347); 
							LBRACK49_tree = (Object)adaptor.create(LBRACK49);
							adaptor.addChild(root_0, LBRACK49_tree);
							dbg.location(118,44);
							INTLIT50=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_type349); 
							INTLIT50_tree = (Object)adaptor.create(INTLIT50);
							adaptor.addChild(root_0, INTLIT50_tree);
							dbg.location(118,51);
							RBRACK51=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_type351); 
							RBRACK51_tree = (Object)adaptor.create(RBRACK51);
							adaptor.addChild(root_0, RBRACK51_tree);

							}
							break;

					}
					} finally {dbg.exitSubRule(10);}

					}
					dbg.location(118,68);
					OF_KEY52=(Token)match(input,OF_KEY,FOLLOW_OF_KEY_in_type357); 
					OF_KEY52_tree = (Object)adaptor.create(OF_KEY52);
					root_0 = (Object)adaptor.becomeRoot(OF_KEY52_tree, root_0);
					dbg.location(118,81);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:70: ( base_type )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:71: base_type
					{
					dbg.location(118,71);
					pushFollow(FOLLOW_base_type_in_type361);
					base_type53=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type53.getTree());

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(119, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:1: type_id : ( base_type | ID );
	public final tigerParser.type_id_return type_id() throws RecognitionException {
		tigerParser.type_id_return retval = new tigerParser.type_id_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID55=null;
		ParserRuleReturnScope base_type54 =null;

		Object ID55_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "type_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(121, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:9: ( base_type | ID )
			int alt12=2;
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( (LA12_0==FIXEDPT_KEY||LA12_0==INT_KEY) ) {
				alt12=1;
			}
			else if ( (LA12_0==ID) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:11: base_type
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(121,11);
					pushFollow(FOLLOW_base_type_in_type_id373);
					base_type54=base_type();
					state._fsp--;

					adaptor.addChild(root_0, base_type54.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:122:4: ID
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(122,4);
					ID55=(Token)match(input,ID,FOLLOW_ID_in_type_id378); 
					ID55_tree = (Object)adaptor.create(ID55);
					adaptor.addChild(root_0, ID55_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(123, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "base_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:125:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final tigerParser.base_type_return base_type() throws RecognitionException {
		tigerParser.base_type_return retval = new tigerParser.base_type_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set56=null;

		Object set56_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(125, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:126:2: ( INT_KEY | FIXEDPT_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(126,2);
			set56=input.LT(1);
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set56));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(128, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "var_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:1: var_declaration : ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !;
	public final tigerParser.var_declaration_return var_declaration() throws RecognitionException {
		tigerParser.var_declaration_return retval = new tigerParser.var_declaration_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token VAR_KEY57=null;
		Token COLON59=null;
		Token ASSIGN61=null;
		Token SEMI63=null;
		ParserRuleReturnScope id_list58 =null;
		ParserRuleReturnScope type_id60 =null;
		ParserRuleReturnScope expr62 =null;

		Object VAR_KEY57_tree=null;
		Object COLON59_tree=null;
		Object ASSIGN61_tree=null;
		Object SEMI63_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "var_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(130, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:2: ( ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !)
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:4: ( VAR_KEY id_list COLON ^ type_id ) ^ ( ASSIGN ^ expr )? SEMI !
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(131,36);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:4: ( VAR_KEY id_list COLON ^ type_id )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:5: VAR_KEY id_list COLON ^ type_id
			{
			dbg.location(131,5);
			VAR_KEY57=(Token)match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration407); 
			VAR_KEY57_tree = (Object)adaptor.create(VAR_KEY57);
			adaptor.addChild(root_0, VAR_KEY57_tree);
			dbg.location(131,13);
			pushFollow(FOLLOW_id_list_in_var_declaration409);
			id_list58=id_list();
			state._fsp--;

			adaptor.addChild(root_0, id_list58.getTree());
			dbg.location(131,26);
			COLON59=(Token)match(input,COLON,FOLLOW_COLON_in_var_declaration411); 
			COLON59_tree = (Object)adaptor.create(COLON59);
			root_0 = (Object)adaptor.becomeRoot(COLON59_tree, root_0);
			dbg.location(131,28);
			pushFollow(FOLLOW_type_id_in_var_declaration414);
			type_id60=type_id();
			state._fsp--;

			adaptor.addChild(root_0, type_id60.getTree());

			}
			dbg.location(131,38);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:38: ( ASSIGN ^ expr )?
			int alt13=2;
			try { dbg.enterSubRule(13);
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			int LA13_0 = input.LA(1);
			if ( (LA13_0==ASSIGN) ) {
				alt13=1;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:39: ASSIGN ^ expr
					{
					dbg.location(131,45);
					ASSIGN61=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_var_declaration419); 
					ASSIGN61_tree = (Object)adaptor.create(ASSIGN61);
					root_0 = (Object)adaptor.becomeRoot(ASSIGN61_tree, root_0);
					dbg.location(131,47);
					pushFollow(FOLLOW_expr_in_var_declaration422);
					expr62=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr62.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(13);}
			dbg.location(131,58);
			SEMI63=(Token)match(input,SEMI,FOLLOW_SEMI_in_var_declaration426); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(132, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:1: id_list : ID ( COMMA ! id_list )? ;
	public final tigerParser.id_list_return id_list() throws RecognitionException {
		tigerParser.id_list_return retval = new tigerParser.id_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID64=null;
		Token COMMA65=null;
		ParserRuleReturnScope id_list66 =null;

		Object ID64_tree=null;
		Object COMMA65_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(134, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:9: ( ID ( COMMA ! id_list )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:11: ID ( COMMA ! id_list )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(134,11);
			ID64=(Token)match(input,ID,FOLLOW_ID_in_id_list437); 
			ID64_tree = (Object)adaptor.create(ID64);
			adaptor.addChild(root_0, ID64_tree);
			dbg.location(134,14);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:14: ( COMMA ! id_list )?
			int alt14=2;
			try { dbg.enterSubRule(14);
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			int LA14_0 = input.LA(1);
			if ( (LA14_0==COMMA) ) {
				alt14=1;
			}
			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:15: COMMA ! id_list
					{
					dbg.location(134,20);
					COMMA65=(Token)match(input,COMMA,FOLLOW_COMMA_in_id_list440); dbg.location(134,22);
					pushFollow(FOLLOW_id_list_in_id_list443);
					id_list66=id_list();
					state._fsp--;

					adaptor.addChild(root_0, id_list66.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(14);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(135, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:137:1: stat_seq : ( stat )+ ;
	public final tigerParser.stat_seq_return stat_seq() throws RecognitionException {
		tigerParser.stat_seq_return retval = new tigerParser.stat_seq_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope stat67 =null;


		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(137, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:2: ( ( stat )+ )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:4: ( stat )+
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(138,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:4: ( stat )+
			int cnt15=0;
			try { dbg.enterSubRule(15);

			loop15:
			while (true) {
				int alt15=2;
				try { dbg.enterDecision(15, decisionCanBacktrack[15]);

				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= BEGIN_KEY && LA15_0 <= BREAK_KEY)||LA15_0==FOR_KEY||LA15_0==ID||LA15_0==IF_KEY||LA15_0==RETURN_KEY||LA15_0==WHILE_KEY) ) {
					alt15=1;
				}

				} finally {dbg.exitDecision(15);}

				switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:4: stat
					{
					dbg.location(138,4);
					pushFollow(FOLLOW_stat_in_stat_seq457);
					stat67=stat();
					state._fsp--;

					adaptor.addChild(root_0, stat67.getTree());

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt15++;
			}
			} finally {dbg.exitSubRule(15);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(139, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:141:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) | WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) | ID ( ( value_tail ASSIGN ^ expr_list ) | ( func_call_tail ) ) SEMI !| BREAK_KEY SEMI !| RETURN_KEY ^ expr SEMI !| block );
	public final tigerParser.stat_return stat() throws RecognitionException {
		tigerParser.stat_return retval = new tigerParser.stat_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token IF_KEY68=null;
		Token THEN_KEY70=null;
		Token ENDIF_KEY72=null;
		Token SEMI73=null;
		Token ELSE_KEY74=null;
		Token ENDIF_KEY76=null;
		Token SEMI77=null;
		Token WHILE_KEY78=null;
		Token DO_KEY80=null;
		Token ENDDO_KEY82=null;
		Token SEMI83=null;
		Token FOR_KEY84=null;
		Token ID85=null;
		Token ASSIGN86=null;
		Token TO_KEY88=null;
		Token DO_KEY90=null;
		Token ENDDO_KEY92=null;
		Token SEMI93=null;
		Token ID94=null;
		Token ASSIGN96=null;
		Token SEMI99=null;
		Token BREAK_KEY100=null;
		Token SEMI101=null;
		Token RETURN_KEY102=null;
		Token SEMI104=null;
		ParserRuleReturnScope expr69 =null;
		ParserRuleReturnScope stat_seq71 =null;
		ParserRuleReturnScope stat_seq75 =null;
		ParserRuleReturnScope expr79 =null;
		ParserRuleReturnScope stat_seq81 =null;
		ParserRuleReturnScope index_expr87 =null;
		ParserRuleReturnScope index_expr89 =null;
		ParserRuleReturnScope stat_seq91 =null;
		ParserRuleReturnScope value_tail95 =null;
		ParserRuleReturnScope expr_list97 =null;
		ParserRuleReturnScope func_call_tail98 =null;
		ParserRuleReturnScope expr103 =null;
		ParserRuleReturnScope block105 =null;

		Object IF_KEY68_tree=null;
		Object THEN_KEY70_tree=null;
		Object ENDIF_KEY72_tree=null;
		Object SEMI73_tree=null;
		Object ELSE_KEY74_tree=null;
		Object ENDIF_KEY76_tree=null;
		Object SEMI77_tree=null;
		Object WHILE_KEY78_tree=null;
		Object DO_KEY80_tree=null;
		Object ENDDO_KEY82_tree=null;
		Object SEMI83_tree=null;
		Object FOR_KEY84_tree=null;
		Object ID85_tree=null;
		Object ASSIGN86_tree=null;
		Object TO_KEY88_tree=null;
		Object DO_KEY90_tree=null;
		Object ENDDO_KEY92_tree=null;
		Object SEMI93_tree=null;
		Object ID94_tree=null;
		Object ASSIGN96_tree=null;
		Object SEMI99_tree=null;
		Object BREAK_KEY100_tree=null;
		Object SEMI101_tree=null;
		Object RETURN_KEY102_tree=null;
		Object SEMI104_tree=null;
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
		dbg.location(141, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? ) | WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !| FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq ) | ID ( ( value_tail ASSIGN ^ expr_list ) | ( func_call_tail ) ) SEMI !| BREAK_KEY SEMI !| RETURN_KEY ^ expr SEMI !| block )
			int alt18=7;
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

			switch ( input.LA(1) ) {
			case IF_KEY:
				{
				alt18=1;
				}
				break;
			case WHILE_KEY:
				{
				alt18=2;
				}
				break;
			case FOR_KEY:
				{
				alt18=3;
				}
				break;
			case ID:
				{
				alt18=4;
				}
				break;
			case BREAK_KEY:
				{
				alt18=5;
				}
				break;
			case RETURN_KEY:
				{
				alt18=6;
				}
				break;
			case BEGIN_KEY:
				{
				alt18=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					dbg.location(142,4);
					IF_KEY68=(Token)match(input,IF_KEY,FOLLOW_IF_KEY_in_stat470);  
					stream_IF_KEY.add(IF_KEY68);
					dbg.location(142,11);
					pushFollow(FOLLOW_expr_in_stat472);
					expr69=expr();
					state._fsp--;

					stream_expr.add(expr69.getTree());dbg.location(142,16);
					THEN_KEY70=(Token)match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat474);  
					stream_THEN_KEY.add(THEN_KEY70);
					dbg.location(142,25);
					pushFollow(FOLLOW_stat_seq_in_stat476);
					stat_seq71=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq71.getTree());dbg.location(142,34);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					int alt16=2;
					try { dbg.enterSubRule(16);
					try { dbg.enterDecision(16, decisionCanBacktrack[16]);

					int LA16_0 = input.LA(1);
					if ( (LA16_0==ENDIF_KEY) ) {
						alt16=1;
					}
					else if ( (LA16_0==ELSE_KEY) ) {
						alt16=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(16);}

					switch (alt16) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:35: ENDIF_KEY SEMI
							{
							dbg.location(142,35);
							ENDIF_KEY72=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat479);  
							stream_ENDIF_KEY.add(ENDIF_KEY72);
							dbg.location(142,45);
							SEMI73=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat481);  
							stream_SEMI.add(SEMI73);

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							dbg.location(142,50);
							ELSE_KEY74=(Token)match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat483);  
							stream_ELSE_KEY.add(ELSE_KEY74);
							dbg.location(142,59);
							pushFollow(FOLLOW_stat_seq_in_stat485);
							stat_seq75=stat_seq();
							state._fsp--;

							stream_stat_seq.add(stat_seq75.getTree());dbg.location(142,68);
							ENDIF_KEY76=(Token)match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat487);  
							stream_ENDIF_KEY.add(ENDIF_KEY76);
							dbg.location(142,78);
							SEMI77=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat489);  
							stream_SEMI.add(SEMI77);

							}
							break;

					}
					} finally {dbg.exitSubRule(16);}

					// AST REWRITE
					// elements: ELSE_KEY, stat_seq, expr, IF_KEY, stat_seq
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 143:3: -> ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
					{
						dbg.location(143,6);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:6: ^( IF_KEY expr stat_seq ( ^( ELSE_KEY stat_seq ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(143,8);
						root_1 = (Object)adaptor.becomeRoot(stream_IF_KEY.nextNode(), root_1);
						dbg.location(143,15);
						adaptor.addChild(root_1, stream_expr.nextTree());dbg.location(143,20);
						adaptor.addChild(root_1, stream_stat_seq.nextTree());dbg.location(143,29);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:29: ( ^( ELSE_KEY stat_seq ) )?
						if ( stream_ELSE_KEY.hasNext()||stream_stat_seq.hasNext() ) {
							dbg.location(143,29);
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:29: ^( ELSE_KEY stat_seq )
							{
							Object root_2 = (Object)adaptor.nil();
							dbg.location(143,31);
							root_2 = (Object)adaptor.becomeRoot(stream_ELSE_KEY.nextNode(), root_2);
							dbg.location(143,40);
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
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:4: WHILE_KEY ^ expr DO_KEY ! stat_seq ENDDO_KEY ! SEMI !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(144,13);
					WHILE_KEY78=(Token)match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat514); 
					WHILE_KEY78_tree = (Object)adaptor.create(WHILE_KEY78);
					root_0 = (Object)adaptor.becomeRoot(WHILE_KEY78_tree, root_0);
					dbg.location(144,15);
					pushFollow(FOLLOW_expr_in_stat517);
					expr79=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr79.getTree());
					dbg.location(144,26);
					DO_KEY80=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_stat519); dbg.location(144,28);
					pushFollow(FOLLOW_stat_seq_in_stat522);
					stat_seq81=stat_seq();
					state._fsp--;

					adaptor.addChild(root_0, stat_seq81.getTree());
					dbg.location(144,46);
					ENDDO_KEY82=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat524); dbg.location(144,52);
					SEMI83=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat527); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(145,4);
					FOR_KEY84=(Token)match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat533);  
					stream_FOR_KEY.add(FOR_KEY84);
					dbg.location(145,12);
					ID85=(Token)match(input,ID,FOLLOW_ID_in_stat535);  
					stream_ID.add(ID85);
					dbg.location(145,15);
					ASSIGN86=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat537);  
					stream_ASSIGN.add(ASSIGN86);
					dbg.location(145,22);
					pushFollow(FOLLOW_index_expr_in_stat539);
					index_expr87=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr87.getTree());dbg.location(145,33);
					TO_KEY88=(Token)match(input,TO_KEY,FOLLOW_TO_KEY_in_stat541);  
					stream_TO_KEY.add(TO_KEY88);
					dbg.location(145,40);
					pushFollow(FOLLOW_index_expr_in_stat543);
					index_expr89=index_expr();
					state._fsp--;

					stream_index_expr.add(index_expr89.getTree());dbg.location(145,51);
					DO_KEY90=(Token)match(input,DO_KEY,FOLLOW_DO_KEY_in_stat545);  
					stream_DO_KEY.add(DO_KEY90);
					dbg.location(145,58);
					pushFollow(FOLLOW_stat_seq_in_stat547);
					stat_seq91=stat_seq();
					state._fsp--;

					stream_stat_seq.add(stat_seq91.getTree());dbg.location(145,67);
					ENDDO_KEY92=(Token)match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat549);  
					stream_ENDDO_KEY.add(ENDDO_KEY92);
					dbg.location(145,77);
					SEMI93=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat551);  
					stream_SEMI.add(SEMI93);

					// AST REWRITE
					// elements: TO_KEY, ASSIGN, index_expr, FOR_KEY, stat_seq, index_expr, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 146:3: -> ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
					{
						dbg.location(146,6);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:6: ^( FOR_KEY ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr ) stat_seq )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(146,8);
						root_1 = (Object)adaptor.becomeRoot(stream_FOR_KEY.nextNode(), root_1);
						dbg.location(146,16);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:16: ^( TO_KEY ^( ASSIGN ID index_expr ) index_expr )
						{
						Object root_2 = (Object)adaptor.nil();
						dbg.location(146,18);
						root_2 = (Object)adaptor.becomeRoot(stream_TO_KEY.nextNode(), root_2);
						dbg.location(146,25);
						// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:25: ^( ASSIGN ID index_expr )
						{
						Object root_3 = (Object)adaptor.nil();
						dbg.location(146,27);
						root_3 = (Object)adaptor.becomeRoot(stream_ASSIGN.nextNode(), root_3);
						dbg.location(146,34);
						adaptor.addChild(root_3, stream_ID.nextNode());dbg.location(146,37);
						adaptor.addChild(root_3, stream_index_expr.nextTree());
						adaptor.addChild(root_2, root_3);
						}
						dbg.location(146,49);
						adaptor.addChild(root_2, stream_index_expr.nextTree());
						adaptor.addChild(root_1, root_2);
						}
						dbg.location(146,61);
						adaptor.addChild(root_1, stream_stat_seq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:6: ID ( ( value_tail ASSIGN ^ expr_list ) | ( func_call_tail ) ) SEMI !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(147,6);
					ID94=(Token)match(input,ID,FOLLOW_ID_in_stat582); 
					ID94_tree = (Object)adaptor.create(ID94);
					adaptor.addChild(root_0, ID94_tree);
					dbg.location(147,9);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:9: ( ( value_tail ASSIGN ^ expr_list ) | ( func_call_tail ) )
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==EOF||LA17_0==AND||LA17_0==ASSIGN||LA17_0==COMMA||(LA17_0 >= DIV && LA17_0 <= DO_KEY)||LA17_0==EQ||(LA17_0 >= GREATER && LA17_0 <= GREATEREQ)||(LA17_0 >= LBRACK && LA17_0 <= LESSEREQ)||(LA17_0 >= MINUS && LA17_0 <= NEQ)||(LA17_0 >= OR && LA17_0 <= PLUS)||(LA17_0 >= RPAREN && LA17_0 <= SEMI)||LA17_0==THEN_KEY) ) {
						alt17=1;
					}
					else if ( (LA17_0==LPAREN) ) {
						alt17=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 17, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(17);}

					switch (alt17) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:10: ( value_tail ASSIGN ^ expr_list )
							{
							dbg.location(147,10);
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:10: ( value_tail ASSIGN ^ expr_list )
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:11: value_tail ASSIGN ^ expr_list
							{
							dbg.location(147,11);
							pushFollow(FOLLOW_value_tail_in_stat586);
							value_tail95=value_tail();
							state._fsp--;

							adaptor.addChild(root_0, value_tail95.getTree());
							dbg.location(147,28);
							ASSIGN96=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_stat588); 
							ASSIGN96_tree = (Object)adaptor.create(ASSIGN96);
							root_0 = (Object)adaptor.becomeRoot(ASSIGN96_tree, root_0);
							dbg.location(147,30);
							pushFollow(FOLLOW_expr_list_in_stat591);
							expr_list97=expr_list();
							state._fsp--;

							adaptor.addChild(root_0, expr_list97.getTree());

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:43: ( func_call_tail )
							{
							dbg.location(147,43);
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:43: ( func_call_tail )
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:44: func_call_tail
							{
							dbg.location(147,44);
							pushFollow(FOLLOW_func_call_tail_in_stat597);
							func_call_tail98=func_call_tail();
							state._fsp--;

							adaptor.addChild(root_0, func_call_tail98.getTree());

							}

							}
							break;

					}
					} finally {dbg.exitSubRule(17);}
					dbg.location(147,65);
					SEMI99=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat601); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:148:4: BREAK_KEY SEMI !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(148,4);
					BREAK_KEY100=(Token)match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat607); 
					BREAK_KEY100_tree = (Object)adaptor.create(BREAK_KEY100);
					adaptor.addChild(root_0, BREAK_KEY100_tree);
					dbg.location(148,18);
					SEMI101=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat609); 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:149:4: RETURN_KEY ^ expr SEMI !
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(149,14);
					RETURN_KEY102=(Token)match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat615); 
					RETURN_KEY102_tree = (Object)adaptor.create(RETURN_KEY102);
					root_0 = (Object)adaptor.becomeRoot(RETURN_KEY102_tree, root_0);
					dbg.location(149,16);
					pushFollow(FOLLOW_expr_in_stat618);
					expr103=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr103.getTree());
					dbg.location(149,25);
					SEMI104=(Token)match(input,SEMI,FOLLOW_SEMI_in_stat620); 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:4: block
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(150,4);
					pushFollow(FOLLOW_block_in_stat626);
					block105=block();
					state._fsp--;

					adaptor.addChild(root_0, block105.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(151, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat"


	public static class expr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )? ;
	public final tigerParser.expr_return expr() throws RecognitionException {
		tigerParser.expr_return retval = new tigerParser.expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID107=null;
		Token LPAREN110=null;
		Token RPAREN112=null;
		ParserRuleReturnScope constval106 =null;
		ParserRuleReturnScope value_tail108 =null;
		ParserRuleReturnScope func_call_tail109 =null;
		ParserRuleReturnScope expr111 =null;
		ParserRuleReturnScope binop_p0113 =null;
		ParserRuleReturnScope expr114 =null;

		Object ID107_tree=null;
		Object LPAREN110_tree=null;
		Object RPAREN112_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(153, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !) ( binop_p0 ^ expr )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(153,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN ! expr RPAREN !)
			int alt20=3;
			try { dbg.enterSubRule(20);
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
				alt20=2;
				}
				break;
			case LPAREN:
				{
				alt20=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(20);}

			switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:10: constval
					{
					dbg.location(153,10);
					pushFollow(FOLLOW_constval_in_expr640);
					constval106=constval();
					state._fsp--;

					adaptor.addChild(root_0, constval106.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:21: ID ( value_tail | func_call_tail )
					{
					dbg.location(153,21);
					ID107=(Token)match(input,ID,FOLLOW_ID_in_expr644); 
					ID107_tree = (Object)adaptor.create(ID107);
					adaptor.addChild(root_0, ID107_tree);
					dbg.location(153,24);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:24: ( value_tail | func_call_tail )
					int alt19=2;
					try { dbg.enterSubRule(19);
					try { dbg.enterDecision(19, decisionCanBacktrack[19]);

					int LA19_0 = input.LA(1);
					if ( (LA19_0==EOF||LA19_0==AND||LA19_0==ASSIGN||LA19_0==COMMA||(LA19_0 >= DIV && LA19_0 <= DO_KEY)||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LBRACK && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= NEQ)||(LA19_0 >= OR && LA19_0 <= PLUS)||(LA19_0 >= RPAREN && LA19_0 <= SEMI)||LA19_0==THEN_KEY) ) {
						alt19=1;
					}
					else if ( (LA19_0==LPAREN) ) {
						alt19=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 19, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(19);}

					switch (alt19) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:25: value_tail
							{
							dbg.location(153,25);
							pushFollow(FOLLOW_value_tail_in_expr647);
							value_tail108=value_tail();
							state._fsp--;

							adaptor.addChild(root_0, value_tail108.getTree());

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:38: func_call_tail
							{
							dbg.location(153,38);
							pushFollow(FOLLOW_func_call_tail_in_expr651);
							func_call_tail109=func_call_tail();
							state._fsp--;

							adaptor.addChild(root_0, func_call_tail109.getTree());

							}
							break;

					}
					} finally {dbg.exitSubRule(19);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:56: LPAREN ! expr RPAREN !
					{
					dbg.location(153,62);
					LPAREN110=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_expr656); dbg.location(153,64);
					pushFollow(FOLLOW_expr_in_expr659);
					expr111=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr111.getTree());
					dbg.location(153,75);
					RPAREN112=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_expr661); 
					}
					break;

			}
			} finally {dbg.exitSubRule(20);}
			dbg.location(153,78);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:78: ( binop_p0 ^ expr )?
			int alt21=2;
			try { dbg.enterSubRule(21);
			try { dbg.enterDecision(21, decisionCanBacktrack[21]);

			int LA21_0 = input.LA(1);
			if ( (LA21_0==AND||LA21_0==DIV||LA21_0==EQ||(LA21_0 >= GREATER && LA21_0 <= GREATEREQ)||(LA21_0 >= LESSER && LA21_0 <= LESSEREQ)||(LA21_0 >= MINUS && LA21_0 <= NEQ)||(LA21_0 >= OR && LA21_0 <= PLUS)) ) {
				alt21=1;
			}
			} finally {dbg.exitDecision(21);}

			switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:79: binop_p0 ^ expr
					{
					dbg.location(153,87);
					pushFollow(FOLLOW_binop_p0_in_expr666);
					binop_p0113=binop_p0();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(binop_p0113.getTree(), root_0);dbg.location(153,89);
					pushFollow(FOLLOW_expr_in_expr669);
					expr114=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr114.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(21);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(154, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binop_p0"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:1: binop_p0 : ( AND | OR | binop_p1 ) ;
	public final tigerParser.binop_p0_return binop_p0() throws RecognitionException {
		tigerParser.binop_p0_return retval = new tigerParser.binop_p0_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token AND115=null;
		Token OR116=null;
		ParserRuleReturnScope binop_p1117 =null;

		Object AND115_tree=null;
		Object OR116_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p0");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(156, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:9: ( ( AND | OR | binop_p1 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:11: ( AND | OR | binop_p1 )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(156,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:11: ( AND | OR | binop_p1 )
			int alt22=3;
			try { dbg.enterSubRule(22);
			try { dbg.enterDecision(22, decisionCanBacktrack[22]);

			switch ( input.LA(1) ) {
			case AND:
				{
				alt22=1;
				}
				break;
			case OR:
				{
				alt22=2;
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
				alt22=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(22);}

			switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:12: AND
					{
					dbg.location(156,12);
					AND115=(Token)match(input,AND,FOLLOW_AND_in_binop_p0682); 
					AND115_tree = (Object)adaptor.create(AND115);
					adaptor.addChild(root_0, AND115_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:18: OR
					{
					dbg.location(156,18);
					OR116=(Token)match(input,OR,FOLLOW_OR_in_binop_p0686); 
					OR116_tree = (Object)adaptor.create(OR116);
					adaptor.addChild(root_0, OR116_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:23: binop_p1
					{
					dbg.location(156,23);
					pushFollow(FOLLOW_binop_p1_in_binop_p0690);
					binop_p1117=binop_p1();
					state._fsp--;

					adaptor.addChild(root_0, binop_p1117.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(22);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(156, 31);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binop_p1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:1: binop_p1 : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) ;
	public final tigerParser.binop_p1_return binop_p1() throws RecognitionException {
		tigerParser.binop_p1_return retval = new tigerParser.binop_p1_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EQ118=null;
		Token NEQ119=null;
		Token LESSER120=null;
		Token GREATER121=null;
		Token LESSEREQ122=null;
		Token GREATEREQ123=null;
		ParserRuleReturnScope binop_p2124 =null;

		Object EQ118_tree=null;
		Object NEQ119_tree=null;
		Object LESSER120_tree=null;
		Object GREATER121_tree=null;
		Object LESSEREQ122_tree=null;
		Object GREATEREQ123_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p1");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(157, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:9: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(157,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			int alt23=7;
			try { dbg.enterSubRule(23);
			try { dbg.enterDecision(23, decisionCanBacktrack[23]);

			switch ( input.LA(1) ) {
			case EQ:
				{
				alt23=1;
				}
				break;
			case NEQ:
				{
				alt23=2;
				}
				break;
			case LESSER:
				{
				alt23=3;
				}
				break;
			case GREATER:
				{
				alt23=4;
				}
				break;
			case LESSEREQ:
				{
				alt23=5;
				}
				break;
			case GREATEREQ:
				{
				alt23=6;
				}
				break;
			case DIV:
			case MINUS:
			case MULT:
			case PLUS:
				{
				alt23=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(23);}

			switch (alt23) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:12: EQ
					{
					dbg.location(157,12);
					EQ118=(Token)match(input,EQ,FOLLOW_EQ_in_binop_p1698); 
					EQ118_tree = (Object)adaptor.create(EQ118);
					adaptor.addChild(root_0, EQ118_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:17: NEQ
					{
					dbg.location(157,17);
					NEQ119=(Token)match(input,NEQ,FOLLOW_NEQ_in_binop_p1702); 
					NEQ119_tree = (Object)adaptor.create(NEQ119);
					adaptor.addChild(root_0, NEQ119_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:23: LESSER
					{
					dbg.location(157,23);
					LESSER120=(Token)match(input,LESSER,FOLLOW_LESSER_in_binop_p1706); 
					LESSER120_tree = (Object)adaptor.create(LESSER120);
					adaptor.addChild(root_0, LESSER120_tree);

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:32: GREATER
					{
					dbg.location(157,32);
					GREATER121=(Token)match(input,GREATER,FOLLOW_GREATER_in_binop_p1710); 
					GREATER121_tree = (Object)adaptor.create(GREATER121);
					adaptor.addChild(root_0, GREATER121_tree);

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:42: LESSEREQ
					{
					dbg.location(157,42);
					LESSEREQ122=(Token)match(input,LESSEREQ,FOLLOW_LESSEREQ_in_binop_p1714); 
					LESSEREQ122_tree = (Object)adaptor.create(LESSEREQ122);
					adaptor.addChild(root_0, LESSEREQ122_tree);

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:53: GREATEREQ
					{
					dbg.location(157,53);
					GREATEREQ123=(Token)match(input,GREATEREQ,FOLLOW_GREATEREQ_in_binop_p1718); 
					GREATEREQ123_tree = (Object)adaptor.create(GREATEREQ123);
					adaptor.addChild(root_0, GREATEREQ123_tree);

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:65: binop_p2
					{
					dbg.location(157,65);
					pushFollow(FOLLOW_binop_p2_in_binop_p1722);
					binop_p2124=binop_p2();
					state._fsp--;

					adaptor.addChild(root_0, binop_p2124.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(23);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(157, 73);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binop_p2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:1: binop_p2 : ( MINUS | PLUS | binop_p3 ) ;
	public final tigerParser.binop_p2_return binop_p2() throws RecognitionException {
		tigerParser.binop_p2_return retval = new tigerParser.binop_p2_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MINUS125=null;
		Token PLUS126=null;
		ParserRuleReturnScope binop_p3127 =null;

		Object MINUS125_tree=null;
		Object PLUS126_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p2");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(158, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:9: ( ( MINUS | PLUS | binop_p3 ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:11: ( MINUS | PLUS | binop_p3 )
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(158,11);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:11: ( MINUS | PLUS | binop_p3 )
			int alt24=3;
			try { dbg.enterSubRule(24);
			try { dbg.enterDecision(24, decisionCanBacktrack[24]);

			switch ( input.LA(1) ) {
			case MINUS:
				{
				alt24=1;
				}
				break;
			case PLUS:
				{
				alt24=2;
				}
				break;
			case DIV:
			case MULT:
				{
				alt24=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(24);}

			switch (alt24) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:12: MINUS
					{
					dbg.location(158,12);
					MINUS125=(Token)match(input,MINUS,FOLLOW_MINUS_in_binop_p2735); 
					MINUS125_tree = (Object)adaptor.create(MINUS125);
					adaptor.addChild(root_0, MINUS125_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:20: PLUS
					{
					dbg.location(158,20);
					PLUS126=(Token)match(input,PLUS,FOLLOW_PLUS_in_binop_p2739); 
					PLUS126_tree = (Object)adaptor.create(PLUS126);
					adaptor.addChild(root_0, PLUS126_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:27: binop_p3
					{
					dbg.location(158,27);
					pushFollow(FOLLOW_binop_p3_in_binop_p2743);
					binop_p3127=binop_p3();
					state._fsp--;

					adaptor.addChild(root_0, binop_p3127.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(24);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(158, 35);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binop_p3"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:159:1: binop_p3 : ( MULT | DIV ) ;
	public final tigerParser.binop_p3_return binop_p3() throws RecognitionException {
		tigerParser.binop_p3_return retval = new tigerParser.binop_p3_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set128=null;

		Object set128_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binop_p3");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(159, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:159:9: ( ( MULT | DIV ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(159,9);
			set128=input.LT(1);
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set128));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(159, 22);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:1: constval : ( INTLIT | FIXEDPTLIT );
	public final tigerParser.constval_return constval() throws RecognitionException {
		tigerParser.constval_return retval = new tigerParser.constval_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set129=null;

		Object set129_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "constval");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(161, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:9: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(161,9);
			set129=input.LT(1);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set129));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(163, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "binary_operator"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:172:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final tigerParser.binary_operator_return binary_operator() throws RecognitionException {
		tigerParser.binary_operator_return retval = new tigerParser.binary_operator_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set130=null;

		Object set130_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "binary_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(172, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:173:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(173,2);
			set130=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set130));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(174, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expr_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:176:1: expr_list : expr ( COMMA ! expr )* ;
	public final tigerParser.expr_list_return expr_list() throws RecognitionException {
		tigerParser.expr_list_return retval = new tigerParser.expr_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA132=null;
		ParserRuleReturnScope expr131 =null;
		ParserRuleReturnScope expr133 =null;

		Object COMMA132_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(176, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:2: ( expr ( COMMA ! expr )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:4: expr ( COMMA ! expr )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(177,4);
			pushFollow(FOLLOW_expr_in_expr_list875);
			expr131=expr();
			state._fsp--;

			adaptor.addChild(root_0, expr131.getTree());
			dbg.location(177,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:9: ( COMMA ! expr )*
			try { dbg.enterSubRule(25);

			loop25:
			while (true) {
				int alt25=2;
				try { dbg.enterDecision(25, decisionCanBacktrack[25]);

				int LA25_0 = input.LA(1);
				if ( (LA25_0==COMMA) ) {
					alt25=1;
				}

				} finally {dbg.exitDecision(25);}

				switch (alt25) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:177:10: COMMA ! expr
					{
					dbg.location(177,15);
					COMMA132=(Token)match(input,COMMA,FOLLOW_COMMA_in_expr_list878); dbg.location(177,17);
					pushFollow(FOLLOW_expr_in_expr_list881);
					expr133=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr133.getTree());

					}
					break;

				default :
					break loop25;
				}
			}
			} finally {dbg.exitSubRule(25);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(178, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:1: value : ID value_tail ;
	public final tigerParser.value_return value() throws RecognitionException {
		tigerParser.value_return retval = new tigerParser.value_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID134=null;
		ParserRuleReturnScope value_tail135 =null;

		Object ID134_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(180, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:8: ( ID value_tail )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:10: ID value_tail
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(180,10);
			ID134=(Token)match(input,ID,FOLLOW_ID_in_value894); 
			ID134_tree = (Object)adaptor.create(ID134);
			adaptor.addChild(root_0, ID134_tree);
			dbg.location(180,13);
			pushFollow(FOLLOW_value_tail_in_value896);
			value_tail135=value_tail();
			state._fsp--;

			adaptor.addChild(root_0, value_tail135.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(180, 22);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "value_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:181:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? ;
	public final tigerParser.value_tail_return value_tail() throws RecognitionException {
		tigerParser.value_tail_return retval = new tigerParser.value_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LBRACK136=null;
		Token RBRACK138=null;
		Token LBRACK139=null;
		Token RBRACK141=null;
		ParserRuleReturnScope index_expr137 =null;
		ParserRuleReturnScope index_expr140 =null;

		Object LBRACK136_tree=null;
		Object RBRACK138_tree=null;
		Object LBRACK139_tree=null;
		Object RBRACK141_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "value_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(181, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:2: ( ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:4: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(182,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:4: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? )?
			int alt27=2;
			try { dbg.enterSubRule(27);
			try { dbg.enterDecision(27, decisionCanBacktrack[27]);

			int LA27_0 = input.LA(1);
			if ( (LA27_0==LBRACK) ) {
				alt27=1;
			}
			} finally {dbg.exitDecision(27);}

			switch (alt27) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:5: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					dbg.location(182,5);
					LBRACK136=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail906); 
					LBRACK136_tree = (Object)adaptor.create(LBRACK136);
					adaptor.addChild(root_0, LBRACK136_tree);
					dbg.location(182,12);
					pushFollow(FOLLOW_index_expr_in_value_tail908);
					index_expr137=index_expr();
					state._fsp--;

					adaptor.addChild(root_0, index_expr137.getTree());
					dbg.location(182,23);
					RBRACK138=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail910); 
					RBRACK138_tree = (Object)adaptor.create(RBRACK138);
					adaptor.addChild(root_0, RBRACK138_tree);
					dbg.location(182,30);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:30: ( LBRACK index_expr RBRACK )?
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:182:31: LBRACK index_expr RBRACK
							{
							dbg.location(182,31);
							LBRACK139=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_value_tail913); 
							LBRACK139_tree = (Object)adaptor.create(LBRACK139);
							adaptor.addChild(root_0, LBRACK139_tree);
							dbg.location(182,38);
							pushFollow(FOLLOW_index_expr_in_value_tail915);
							index_expr140=index_expr();
							state._fsp--;

							adaptor.addChild(root_0, index_expr140.getTree());
							dbg.location(182,49);
							RBRACK141=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_value_tail917); 
							RBRACK141_tree = (Object)adaptor.create(RBRACK141);
							adaptor.addChild(root_0, RBRACK141_tree);

							}
							break;

					}
					} finally {dbg.exitSubRule(26);}

					}
					break;

			}
			} finally {dbg.exitSubRule(27);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(183, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:185:1: index_expr : ( INTLIT | ID ) ( index_oper ^ index_expr )? ;
	public final tigerParser.index_expr_return index_expr() throws RecognitionException {
		tigerParser.index_expr_return retval = new tigerParser.index_expr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set142=null;
		ParserRuleReturnScope index_oper143 =null;
		ParserRuleReturnScope index_expr144 =null;

		Object set142_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(185, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:186:2: ( ( INTLIT | ID ) ( index_oper ^ index_expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:186:4: ( INTLIT | ID ) ( index_oper ^ index_expr )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(186,4);
			set142=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set142));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(186,18);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:186:18: ( index_oper ^ index_expr )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:186:19: index_oper ^ index_expr
					{
					dbg.location(186,29);
					pushFollow(FOLLOW_index_oper_in_index_expr942);
					index_oper143=index_oper();
					state._fsp--;

					root_0 = (Object)adaptor.becomeRoot(index_oper143.getTree(), root_0);dbg.location(186,31);
					pushFollow(FOLLOW_index_expr_in_index_expr945);
					index_expr144=index_expr();
					state._fsp--;

					adaptor.addChild(root_0, index_expr144.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(28);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(187, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "index_oper"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final tigerParser.index_oper_return index_oper() throws RecognitionException {
		tigerParser.index_oper_return retval = new tigerParser.index_oper_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set145=null;

		Object set145_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "index_oper");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(189, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:190:2: ( ( PLUS | MINUS | MULT ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(190,2);
			set145=input.LT(1);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set145));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(191, 1);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_call_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:209:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final tigerParser.func_call_tail_return func_call_tail() throws RecognitionException {
		tigerParser.func_call_tail_return retval = new tigerParser.func_call_tail_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LPAREN146=null;
		Token RPAREN148=null;
		ParserRuleReturnScope func_param_list147 =null;

		Object LPAREN146_tree=null;
		Object RPAREN148_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "func_call_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(209, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:210:3: ( LPAREN func_param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:210:5: LPAREN func_param_list RPAREN
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(210,5);
			LPAREN146=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail1068); 
			LPAREN146_tree = (Object)adaptor.create(LPAREN146);
			adaptor.addChild(root_0, LPAREN146_tree);
			dbg.location(210,12);
			pushFollow(FOLLOW_func_param_list_in_func_call_tail1070);
			func_param_list147=func_param_list();
			state._fsp--;

			adaptor.addChild(root_0, func_param_list147.getTree());
			dbg.location(210,28);
			RPAREN148=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail1072); 
			RPAREN148_tree = (Object)adaptor.create(RPAREN148);
			adaptor.addChild(root_0, RPAREN148_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(211, 2);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:213:1: func_param_list : ( expr ( COMMA ! expr )* )? ;
	public final tigerParser.func_param_list_return func_param_list() throws RecognitionException {
		tigerParser.func_param_list_return retval = new tigerParser.func_param_list_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token COMMA150=null;
		ParserRuleReturnScope expr149 =null;
		ParserRuleReturnScope expr151 =null;

		Object COMMA150_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "func_param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(213, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:3: ( ( expr ( COMMA ! expr )* )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:5: ( expr ( COMMA ! expr )* )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(214,5);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:5: ( expr ( COMMA ! expr )* )?
			int alt30=2;
			try { dbg.enterSubRule(30);
			try { dbg.enterDecision(30, decisionCanBacktrack[30]);

			int LA30_0 = input.LA(1);
			if ( (LA30_0==FIXEDPTLIT||LA30_0==ID||LA30_0==INTLIT||LA30_0==LPAREN) ) {
				alt30=1;
			}
			} finally {dbg.exitDecision(30);}

			switch (alt30) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:6: expr ( COMMA ! expr )*
					{
					dbg.location(214,6);
					pushFollow(FOLLOW_expr_in_func_param_list1088);
					expr149=expr();
					state._fsp--;

					adaptor.addChild(root_0, expr149.getTree());
					dbg.location(214,11);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:11: ( COMMA ! expr )*
					try { dbg.enterSubRule(29);

					loop29:
					while (true) {
						int alt29=2;
						try { dbg.enterDecision(29, decisionCanBacktrack[29]);

						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							alt29=1;
						}

						} finally {dbg.exitDecision(29);}

						switch (alt29) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:214:12: COMMA ! expr
							{
							dbg.location(214,17);
							COMMA150=(Token)match(input,COMMA,FOLLOW_COMMA_in_func_param_list1091); dbg.location(214,19);
							pushFollow(FOLLOW_expr_in_func_param_list1094);
							expr151=expr();
							state._fsp--;

							adaptor.addChild(root_0, expr151.getTree());

							}
							break;

						default :
							break loop29;
						}
					}
					} finally {dbg.exitSubRule(29);}

					}
					break;

			}
			} finally {dbg.exitSubRule(30);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(215, 2);

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
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "keywords"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:217:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final tigerParser.keywords_return keywords() throws RecognitionException {
		tigerParser.keywords_return retval = new tigerParser.keywords_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token set152=null;

		Object set152_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "keywords");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(217, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:218:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(218,2);
			set152=input.LT(1);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= IF_KEY)||input.LA(1)==INT_KEY||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				adaptor.addChild(root_0, (Object)adaptor.create(set152));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(241, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "keywords");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "keywords"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program69 = new BitSet(new long[]{0x0010000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list83 = new BitSet(new long[]{0x0010000044200002L});
	public static final BitSet FOLLOW_type_id_in_funct_declaration97 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration99 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_VOID_KEY_in_funct_declaration105 = new BitSet(new long[]{0x0000000800800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration108 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration112 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration118 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration121 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration124 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration_tail140 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail142 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail144 = new BitSet(new long[]{0x0000200004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail146 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function_tail160 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail162 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type181 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list194 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_param_list197 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list199 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_param214 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_param216 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list229 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block241 = new BitSet(new long[]{0x000C000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block245 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_block247 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block251 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_block254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement265 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list281 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list295 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration309 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration311 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration315 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration318 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type338 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type340 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type342 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type344 = new BitSet(new long[]{0x0000010080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type347 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type349 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type351 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type357 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration407 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration409 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_var_declaration411 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration414 = new BitSet(new long[]{0x0000400000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_var_declaration419 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_var_declaration422 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list437 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_id_list440 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq457 = new BitSet(new long[]{0x0020100014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat470 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat472 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat474 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat476 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat479 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat481 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat483 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat485 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat487 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat514 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat517 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat519 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat522 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat524 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat533 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat535 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat537 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat539 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat541 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat543 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat545 = new BitSet(new long[]{0x0020100014400180L});
	public static final BitSet FOLLOW_stat_seq_in_stat547 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat549 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat582 = new BitSet(new long[]{0x0000000480000040L});
	public static final BitSet FOLLOW_value_tail_in_stat586 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat588 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat591 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_func_call_tail_in_stat597 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat607 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat615 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat618 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat626 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr640 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_ID_in_expr644 = new BitSet(new long[]{0x0000067783082010L});
	public static final BitSet FOLLOW_value_tail_in_expr647 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr651 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr656 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr659 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr661 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_binop_p0_in_expr666 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p0682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p0686 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p0690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_binop_p1698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEQ_in_binop_p1702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSER_in_binop_p1706 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_binop_p1710 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEREQ_in_binop_p1714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQ_in_binop_p1718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p2_in_binop_p1722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p2735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p2739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p2743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list875 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_expr_list878 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list881 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_value894 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail906 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail908 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail910 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail913 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail915 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr933 = new BitSet(new long[]{0x0000043000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr942 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr945 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail1068 = new BitSet(new long[]{0x0000200424100000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail1070 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail1072 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list1088 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list1091 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_func_param_list1094 = new BitSet(new long[]{0x0000000000000802L});
}
