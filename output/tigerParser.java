// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-05 20:35:13

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class tigerParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY_KEY", "ASSIGN", 
		"BEGIN_KEY", "BREAK_KEY", "COLON", "COMMA", "COMMA_SPACE", "COMMENT", 
		"DIV", "DO_KEY", "ELSE_KEY", "ENDDO_KEY", "ENDIF_KEY", "END_KEY", "EQ", 
		"FIXEDPTLIT", "FIXEDPT_KEY", "FOR_KEY", "FUNCTION_KEY", "GREATER", "GREATEREQ", 
		"ID", "ID_KEY", "IF_KEY", "INTLIT", "INT_KEY", "LBRACK", "LESSER", "LESSEREQ", 
		"LPAREN", "MAIN_KEY", "MINUS", "MULT", "NEQ", "OF_KEY", "OR", "PLUS", 
		"RBRACK", "RETURN_KEY", "RPAREN", "SEMI", "THEN_KEY", "TO_KEY", "TYPE_KEY", 
		"VAR_KEY", "VOID_KEY", "WHILE_KEY"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY_KEY=5;
	public static final int ASSIGN=6;
	public static final int BEGIN_KEY=7;
	public static final int BREAK_KEY=8;
	public static final int COLON=9;
	public static final int COMMA=10;
	public static final int COMMA_SPACE=11;
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
	public static final int OF_KEY=39;
	public static final int OR=40;
	public static final int PLUS=41;
	public static final int RBRACK=42;
	public static final int RETURN_KEY=43;
	public static final int RPAREN=44;
	public static final int SEMI=45;
	public static final int THEN_KEY=46;
	public static final int TO_KEY=47;
	public static final int TYPE_KEY=48;
	public static final int VAR_KEY=49;
	public static final int VOID_KEY=50;
	public static final int WHILE_KEY=51;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "funct_declaration", "keywords", "declaration_statement", 
		"expr_list", "stat", "main_function_tail", "tiger_program", "base_type", 
		"param", "param_list", "value", "var_declaration_list", "binary_operator", 
		"type_declaration_list", "funct_declaration_list", "block_tail", "block", 
		"type_id", "funct_declaration_tail", "constval", "index_oper", "type", 
		"stat_seq", "func_param_list", "expr", "func_call_tail", "optional_init", 
		"index_expr", "value_tail", "type_declaration", "block_list", "id_list", 
		"ret_type", "var_declaration"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
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
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public tigerParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return tigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g"; }



	// $ANTLR start "tiger_program"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:8:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final void tiger_program() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(8, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:2: ( type_declaration_list funct_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:4: type_declaration_list funct_declaration_list
			{
			dbg.location(9,4);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program42);
			type_declaration_list();
			state._fsp--;
			dbg.location(9,26);
			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program44);
			funct_declaration_list();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(10, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "tiger_program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "tiger_program"



	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:12:1: funct_declaration_list : ( funct_declaration funct_declaration_list )? ;
	public final void funct_declaration_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(12, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:2: ( ( funct_declaration funct_declaration_list )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: ( funct_declaration funct_declaration_list )?
			{
			dbg.location(13,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: ( funct_declaration funct_declaration_list )?
			int alt1=2;
			try { dbg.enterSubRule(1);
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY||LA1_0==VOID_KEY) ) {
				alt1=1;
			}
			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:5: funct_declaration funct_declaration_list
					{
					dbg.location(13,5);
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list57);
					funct_declaration();
					state._fsp--;
					dbg.location(13,23);
					pushFollow(FOLLOW_funct_declaration_list_in_funct_declaration_list59);
					funct_declaration_list();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(1);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(14, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "funct_declaration_list"



	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:16:1: funct_declaration : ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI ;
	public final void funct_declaration() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(16, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:2: ( ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(17,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:5: ( type_id funct_declaration_tail )
					{
					dbg.location(17,5);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:5: ( type_id funct_declaration_tail )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:6: type_id funct_declaration_tail
					{
					dbg.location(17,6);
					pushFollow(FOLLOW_type_id_in_funct_declaration74);
					type_id();
					state._fsp--;
					dbg.location(17,14);
					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration76);
					funct_declaration_tail();
					state._fsp--;

					}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					{
					dbg.location(17,40);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:41: VOID_KEY ( funct_declaration_tail | main_function_tail )
					{
					dbg.location(17,41);
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_funct_declaration82); dbg.location(17,50);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:50: ( funct_declaration_tail | main_function_tail )
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:51: funct_declaration_tail
							{
							dbg.location(17,51);
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration85);
							funct_declaration_tail();
							state._fsp--;

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:76: main_function_tail
							{
							dbg.location(17,76);
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration89);
							main_function_tail();
							state._fsp--;

							}
							break;

					}
					} finally {dbg.exitSubRule(2);}

					}

					}
					break;

			}
			} finally {dbg.exitSubRule(3);}
			dbg.location(17,98);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration94); dbg.location(17,108);
			pushFollow(FOLLOW_block_list_in_funct_declaration96);
			block_list();
			state._fsp--;
			dbg.location(17,119);
			match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration98); dbg.location(17,127);
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration100); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(18, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "funct_declaration"



	// $ANTLR start "funct_declaration_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:20:1: funct_declaration_tail : FUNCTION_KEY ID LPAREN param_list RPAREN ;
	public final void funct_declaration_tail() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:3: ( FUNCTION_KEY ID LPAREN param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:5: FUNCTION_KEY ID LPAREN param_list RPAREN
			{
			dbg.location(21,5);
			match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration_tail112); dbg.location(21,18);
			match(input,ID,FOLLOW_ID_in_funct_declaration_tail114); dbg.location(21,21);
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail116); dbg.location(21,28);
			pushFollow(FOLLOW_param_list_in_funct_declaration_tail118);
			param_list();
			state._fsp--;
			dbg.location(21,39);
			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail120); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(22, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "funct_declaration_tail"



	// $ANTLR start "main_function_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:24:1: main_function_tail : MAIN_KEY LPAREN RPAREN ;
	public final void main_function_tail() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "main_function_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(24, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:25:2: ( MAIN_KEY LPAREN RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:25:4: MAIN_KEY LPAREN RPAREN
			{
			dbg.location(25,4);
			match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function_tail132); dbg.location(25,13);
			match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail134); dbg.location(25,20);
			match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail136); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(26, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "main_function_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "main_function_tail"



	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:28:1: ret_type : ( VOID_KEY | type_id );
	public final void ret_type() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "ret_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:29:2: ( VOID_KEY | type_id )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:29:4: VOID_KEY
					{
					dbg.location(29,4);
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type148); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:30:4: type_id
					{
					dbg.location(30,4);
					pushFollow(FOLLOW_type_id_in_ret_type153);
					type_id();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(31, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ret_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "ret_type"



	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:33:1: param_list : ( param ( COMMA param )* )? ;
	public final void param_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(33, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:2: ( ( param ( COMMA param )* )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:4: ( param ( COMMA param )* )?
			{
			dbg.location(34,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:4: ( param ( COMMA param )* )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:5: param ( COMMA param )*
					{
					dbg.location(34,5);
					pushFollow(FOLLOW_param_in_param_list166);
					param();
					state._fsp--;
					dbg.location(34,11);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:11: ( COMMA param )*
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:12: COMMA param
							{
							dbg.location(34,12);
							match(input,COMMA,FOLLOW_COMMA_in_param_list169); dbg.location(34,18);
							pushFollow(FOLLOW_param_in_param_list171);
							param();
							state._fsp--;

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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(35, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:1: param : ID COLON type_id ;
	public final void param() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:8: ( ID COLON type_id )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:10: ID COLON type_id
			{
			dbg.location(37,10);
			match(input,ID,FOLLOW_ID_in_param186); dbg.location(37,13);
			match(input,COLON,FOLLOW_COLON_in_param188); dbg.location(37,19);
			pushFollow(FOLLOW_type_id_in_param190);
			type_id();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(37, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:39:1: block_list : block block_tail ;
	public final void block_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(39, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:40:2: ( block block_tail )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:40:4: block block_tail
			{
			dbg.location(40,4);
			pushFollow(FOLLOW_block_in_block_list200);
			block();
			state._fsp--;
			dbg.location(40,10);
			pushFollow(FOLLOW_block_tail_in_block_list202);
			block_tail();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(41, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block_list"



	// $ANTLR start "block_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:43:1: block_tail : ( block block_tail |);
	public final void block_tail() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "block_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(43, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:44:2: ( block block_tail |)
			int alt7=2;
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==BEGIN_KEY) ) {
				alt7=1;
			}
			else if ( (LA7_0==END_KEY) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:44:4: block block_tail
					{
					dbg.location(44,4);
					pushFollow(FOLLOW_block_in_block_tail214);
					block();
					state._fsp--;
					dbg.location(44,10);
					pushFollow(FOLLOW_block_tail_in_block_tail216);
					block_tail();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(46, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block_tail"



	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:1: block : BEGIN_KEY declaration_statement stat_seq END_KEY SEMI ;
	public final void block() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(48, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:8: ( BEGIN_KEY declaration_statement stat_seq END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:10: BEGIN_KEY declaration_statement stat_seq END_KEY SEMI
			{
			dbg.location(48,10);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block231); dbg.location(48,20);
			pushFollow(FOLLOW_declaration_statement_in_block233);
			declaration_statement();
			state._fsp--;
			dbg.location(48,42);
			pushFollow(FOLLOW_stat_seq_in_block235);
			stat_seq();
			state._fsp--;
			dbg.location(48,51);
			match(input,END_KEY,FOLLOW_END_KEY_in_block237); dbg.location(48,59);
			match(input,SEMI,FOLLOW_SEMI_in_block239); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(48, 62);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block"



	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:50:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final void declaration_statement() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "declaration_statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:51:2: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:51:4: type_declaration_list var_declaration_list
			{
			dbg.location(51,4);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement249);
			type_declaration_list();
			state._fsp--;
			dbg.location(51,26);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement251);
			var_declaration_list();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(52, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration_statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "declaration_statement"



	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:54:1: type_declaration_list : ( type_declaration )* ;
	public final void type_declaration_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:2: ( ( type_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:5: ( type_declaration )*
			{
			dbg.location(55,5);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:5: ( type_declaration )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:5: type_declaration
					{
					dbg.location(55,5);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list265);
					type_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}
			} finally {dbg.exitSubRule(8);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(56, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:58:1: var_declaration_list : ( var_declaration )* ;
	public final void var_declaration_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:2: ( ( var_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: ( var_declaration )*
			{
			dbg.location(59,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: ( var_declaration )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: var_declaration
					{
					dbg.location(59,4);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list279);
					var_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(60, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "var_declaration_list"



	// $ANTLR start "type_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:62:1: type_declaration : TYPE_KEY ID EQ type SEMI ;
	public final void type_declaration() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "type_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:2: ( TYPE_KEY ID EQ type SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:4: TYPE_KEY ID EQ type SEMI
			{
			dbg.location(63,4);
			match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration292); dbg.location(63,13);
			match(input,ID,FOLLOW_ID_in_type_declaration294); dbg.location(63,16);
			match(input,EQ,FOLLOW_EQ_in_type_declaration296); dbg.location(63,19);
			pushFollow(FOLLOW_type_in_type_declaration298);
			type();
			state._fsp--;
			dbg.location(63,24);
			match(input,SEMI,FOLLOW_SEMI_in_type_declaration300); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(64, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_declaration"



	// $ANTLR start "type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:1: type : ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type );
	public final void type() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:6: ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:8: base_type
					{
					dbg.location(66,8);
					pushFollow(FOLLOW_base_type_in_type311);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:4: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type
					{
					dbg.location(67,4);
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type316); dbg.location(67,14);
					match(input,LBRACK,FOLLOW_LBRACK_in_type318); dbg.location(67,21);
					match(input,INTLIT,FOLLOW_INTLIT_in_type320); dbg.location(67,28);
					match(input,RBRACK,FOLLOW_RBRACK_in_type322); dbg.location(67,35);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:35: ( LBRACK INTLIT RBRACK )?
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:36: LBRACK INTLIT RBRACK
							{
							dbg.location(67,36);
							match(input,LBRACK,FOLLOW_LBRACK_in_type325); dbg.location(67,43);
							match(input,INTLIT,FOLLOW_INTLIT_in_type327); dbg.location(67,50);
							match(input,RBRACK,FOLLOW_RBRACK_in_type329); 
							}
							break;

					}
					} finally {dbg.exitSubRule(10);}
					dbg.location(67,59);
					match(input,OF_KEY,FOLLOW_OF_KEY_in_type333); dbg.location(67,66);
					pushFollow(FOLLOW_base_type_in_type335);
					base_type();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(68, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type"



	// $ANTLR start "type_id"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:70:1: type_id : ( base_type | ID );
	public final void type_id() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "type_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(70, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:70:9: ( base_type | ID )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:70:11: base_type
					{
					dbg.location(70,11);
					pushFollow(FOLLOW_base_type_in_type_id345);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:4: ID
					{
					dbg.location(71,4);
					match(input,ID,FOLLOW_ID_in_type_id350); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(72, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_id"



	// $ANTLR start "base_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:74:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final void base_type() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(74, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:75:2: ( INT_KEY | FIXEDPT_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(75,2);
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(77, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "base_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:79:1: var_declaration : VAR_KEY id_list COLON type_id optional_init SEMI ;
	public final void var_declaration() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "var_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:2: ( VAR_KEY id_list COLON type_id optional_init SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:4: VAR_KEY id_list COLON type_id optional_init SEMI
			{
			dbg.location(80,4);
			match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration378); dbg.location(80,12);
			pushFollow(FOLLOW_id_list_in_var_declaration380);
			id_list();
			state._fsp--;
			dbg.location(80,20);
			match(input,COLON,FOLLOW_COLON_in_var_declaration382); dbg.location(80,26);
			pushFollow(FOLLOW_type_id_in_var_declaration384);
			type_id();
			state._fsp--;
			dbg.location(80,34);
			pushFollow(FOLLOW_optional_init_in_var_declaration386);
			optional_init();
			state._fsp--;
			dbg.location(80,48);
			match(input,SEMI,FOLLOW_SEMI_in_var_declaration388); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(81, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "var_declaration"



	// $ANTLR start "id_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:1: id_list : ID ( ( COMMA | COMMA_SPACE ) id_list )? ;
	public final void id_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(83, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:9: ( ID ( ( COMMA | COMMA_SPACE ) id_list )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:11: ID ( ( COMMA | COMMA_SPACE ) id_list )?
			{
			dbg.location(83,11);
			match(input,ID,FOLLOW_ID_in_id_list398); dbg.location(83,14);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:14: ( ( COMMA | COMMA_SPACE ) id_list )?
			int alt13=2;
			try { dbg.enterSubRule(13);
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			int LA13_0 = input.LA(1);
			if ( ((LA13_0 >= COMMA && LA13_0 <= COMMA_SPACE)) ) {
				alt13=1;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:15: ( COMMA | COMMA_SPACE ) id_list
					{
					dbg.location(83,15);
					if ( (input.LA(1) >= COMMA && input.LA(1) <= COMMA_SPACE) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(83,37);
					pushFollow(FOLLOW_id_list_in_id_list409);
					id_list();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(13);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(84, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "id_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "id_list"



	// $ANTLR start "optional_init"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:86:1: optional_init : (| ASSIGN constval );
	public final void optional_init() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "optional_init");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(86, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:87:2: (| ASSIGN constval )
			int alt14=2;
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

			int LA14_0 = input.LA(1);
			if ( (LA14_0==SEMI) ) {
				alt14=1;
			}
			else if ( (LA14_0==ASSIGN) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:5: ASSIGN constval
					{
					dbg.location(88,5);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init430); dbg.location(88,12);
					pushFollow(FOLLOW_constval_in_optional_init432);
					constval();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(89, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "optional_init");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:91:1: stat_seq : ( stat )* ;
	public final void stat_seq() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(91, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:2: ( ( stat )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:4: ( stat )*
			{
			dbg.location(92,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:4: ( stat )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:4: stat
					{
					dbg.location(92,4);
					pushFollow(FOLLOW_stat_in_stat_seq444);
					stat();
					state._fsp--;

					}
					break;

				default :
					break loop15;
				}
			}
			} finally {dbg.exitSubRule(15);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(93, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat_seq");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat_seq"



	// $ANTLR start "stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:95:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block );
	public final void stat() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(95, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					dbg.location(96,4);
					match(input,IF_KEY,FOLLOW_IF_KEY_in_stat457); dbg.location(96,11);
					pushFollow(FOLLOW_expr_in_stat459);
					expr();
					state._fsp--;
					dbg.location(96,16);
					match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat461); dbg.location(96,25);
					pushFollow(FOLLOW_stat_seq_in_stat463);
					stat_seq();
					state._fsp--;
					dbg.location(96,34);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:35: ENDIF_KEY SEMI
							{
							dbg.location(96,35);
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat466); dbg.location(96,45);
							match(input,SEMI,FOLLOW_SEMI_in_stat468); 
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							dbg.location(96,50);
							match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat470); dbg.location(96,59);
							pushFollow(FOLLOW_stat_seq_in_stat472);
							stat_seq();
							state._fsp--;
							dbg.location(96,68);
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat474); dbg.location(96,78);
							match(input,SEMI,FOLLOW_SEMI_in_stat476); 
							}
							break;

					}
					} finally {dbg.exitSubRule(16);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(97,4);
					match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat482); dbg.location(97,14);
					pushFollow(FOLLOW_expr_in_stat484);
					expr();
					state._fsp--;
					dbg.location(97,19);
					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat486); dbg.location(97,26);
					pushFollow(FOLLOW_stat_seq_in_stat488);
					stat_seq();
					state._fsp--;
					dbg.location(97,35);
					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat490); dbg.location(97,45);
					match(input,SEMI,FOLLOW_SEMI_in_stat492); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(98,4);
					match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat497); dbg.location(98,12);
					match(input,ID,FOLLOW_ID_in_stat499); dbg.location(98,15);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_stat501); dbg.location(98,22);
					pushFollow(FOLLOW_index_expr_in_stat503);
					index_expr();
					state._fsp--;
					dbg.location(98,33);
					match(input,TO_KEY,FOLLOW_TO_KEY_in_stat505); dbg.location(98,40);
					pushFollow(FOLLOW_index_expr_in_stat507);
					index_expr();
					state._fsp--;
					dbg.location(98,51);
					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat509); dbg.location(98,58);
					pushFollow(FOLLOW_stat_seq_in_stat511);
					stat_seq();
					state._fsp--;
					dbg.location(98,67);
					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat513); dbg.location(98,77);
					match(input,SEMI,FOLLOW_SEMI_in_stat515); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:6: ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI
					{
					dbg.location(99,6);
					match(input,ID,FOLLOW_ID_in_stat522); dbg.location(99,9);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:9: ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) )
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==EOF||LA17_0==AND||LA17_0==ASSIGN||(LA17_0 >= COMMA && LA17_0 <= COMMA_SPACE)||(LA17_0 >= DIV && LA17_0 <= DO_KEY)||LA17_0==EQ||(LA17_0 >= GREATER && LA17_0 <= GREATEREQ)||(LA17_0 >= LBRACK && LA17_0 <= LESSEREQ)||(LA17_0 >= MINUS && LA17_0 <= NEQ)||(LA17_0 >= OR && LA17_0 <= PLUS)||(LA17_0 >= RPAREN && LA17_0 <= THEN_KEY)) ) {
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:10: ( value_tail ASSIGN expr_list )
							{
							dbg.location(99,10);
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:10: ( value_tail ASSIGN expr_list )
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:11: value_tail ASSIGN expr_list
							{
							dbg.location(99,11);
							pushFollow(FOLLOW_value_tail_in_stat526);
							value_tail();
							state._fsp--;
							dbg.location(99,22);
							match(input,ASSIGN,FOLLOW_ASSIGN_in_stat528); dbg.location(99,29);
							pushFollow(FOLLOW_expr_list_in_stat530);
							expr_list();
							state._fsp--;

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:42: ( func_call_tail )
							{
							dbg.location(99,42);
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:42: ( func_call_tail )
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:43: func_call_tail
							{
							dbg.location(99,43);
							pushFollow(FOLLOW_func_call_tail_in_stat536);
							func_call_tail();
							state._fsp--;

							}

							}
							break;

					}
					} finally {dbg.exitSubRule(17);}
					dbg.location(99,60);
					match(input,SEMI,FOLLOW_SEMI_in_stat540); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:100:4: BREAK_KEY SEMI
					{
					dbg.location(100,4);
					match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat545); dbg.location(100,14);
					match(input,SEMI,FOLLOW_SEMI_in_stat547); 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:101:4: RETURN_KEY expr SEMI
					{
					dbg.location(101,4);
					match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat552); dbg.location(101,15);
					pushFollow(FOLLOW_expr_in_stat554);
					expr();
					state._fsp--;
					dbg.location(101,20);
					match(input,SEMI,FOLLOW_SEMI_in_stat556); 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:102:4: block
					{
					dbg.location(102,4);
					pushFollow(FOLLOW_block_in_stat561);
					block();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(103, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )? ;
	public final void expr() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(105, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )?
			{
			dbg.location(105,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:10: constval
					{
					dbg.location(105,10);
					pushFollow(FOLLOW_constval_in_expr575);
					constval();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:21: ID ( value_tail | func_call_tail )
					{
					dbg.location(105,21);
					match(input,ID,FOLLOW_ID_in_expr579); dbg.location(105,24);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:24: ( value_tail | func_call_tail )
					int alt19=2;
					try { dbg.enterSubRule(19);
					try { dbg.enterDecision(19, decisionCanBacktrack[19]);

					int LA19_0 = input.LA(1);
					if ( (LA19_0==EOF||LA19_0==AND||LA19_0==ASSIGN||(LA19_0 >= COMMA && LA19_0 <= COMMA_SPACE)||(LA19_0 >= DIV && LA19_0 <= DO_KEY)||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LBRACK && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= NEQ)||(LA19_0 >= OR && LA19_0 <= PLUS)||(LA19_0 >= RPAREN && LA19_0 <= THEN_KEY)) ) {
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:25: value_tail
							{
							dbg.location(105,25);
							pushFollow(FOLLOW_value_tail_in_expr582);
							value_tail();
							state._fsp--;

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:36: func_call_tail
							{
							dbg.location(105,36);
							pushFollow(FOLLOW_func_call_tail_in_expr584);
							func_call_tail();
							state._fsp--;

							}
							break;

					}
					} finally {dbg.exitSubRule(19);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:54: LPAREN expr RPAREN
					{
					dbg.location(105,54);
					match(input,LPAREN,FOLLOW_LPAREN_in_expr589); dbg.location(105,61);
					pushFollow(FOLLOW_expr_in_expr591);
					expr();
					state._fsp--;
					dbg.location(105,66);
					match(input,RPAREN,FOLLOW_RPAREN_in_expr593); 
					}
					break;

			}
			} finally {dbg.exitSubRule(20);}
			dbg.location(105,74);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:74: ( binary_operator expr )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:75: binary_operator expr
					{
					dbg.location(105,75);
					pushFollow(FOLLOW_binary_operator_in_expr597);
					binary_operator();
					state._fsp--;
					dbg.location(105,91);
					pushFollow(FOLLOW_expr_in_expr599);
					expr();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(21);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(106, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr"



	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:1: constval : ( INTLIT | FIXEDPTLIT );
	public final void constval() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "constval");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(108, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:9: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(108,9);
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(110, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constval");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "constval"



	// $ANTLR start "binary_operator"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:119:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final void binary_operator() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "binary_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(119, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(120,2);
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(121, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binary_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "binary_operator"



	// $ANTLR start "expr_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:123:1: expr_list : expr ( COMMA expr )* ;
	public final void expr_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(123, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:2: ( expr ( COMMA expr )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:4: expr ( COMMA expr )*
			{
			dbg.location(124,4);
			pushFollow(FOLLOW_expr_in_expr_list721);
			expr();
			state._fsp--;
			dbg.location(124,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:9: ( COMMA expr )*
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:10: COMMA expr
					{
					dbg.location(124,10);
					match(input,COMMA,FOLLOW_COMMA_in_expr_list724); dbg.location(124,16);
					pushFollow(FOLLOW_expr_in_expr_list726);
					expr();
					state._fsp--;

					}
					break;

				default :
					break loop22;
				}
			}
			} finally {dbg.exitSubRule(22);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(125, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr_list"



	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:1: value : ID value_tail ;
	public final void value() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(127, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:8: ( ID value_tail )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:10: ID value_tail
			{
			dbg.location(127,10);
			match(input,ID,FOLLOW_ID_in_value739); dbg.location(127,13);
			pushFollow(FOLLOW_value_tail_in_value741);
			value_tail();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(127, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "value"



	// $ANTLR start "value_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:128:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |);
	public final void value_tail() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "value_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(128, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:2: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |)
			int alt24=2;
			try { dbg.enterDecision(24, decisionCanBacktrack[24]);

			int LA24_0 = input.LA(1);
			if ( (LA24_0==LBRACK) ) {
				alt24=1;
			}
			else if ( (LA24_0==EOF||LA24_0==AND||LA24_0==ASSIGN||(LA24_0 >= COMMA && LA24_0 <= COMMA_SPACE)||(LA24_0 >= DIV && LA24_0 <= DO_KEY)||LA24_0==EQ||(LA24_0 >= GREATER && LA24_0 <= GREATEREQ)||(LA24_0 >= LESSER && LA24_0 <= LESSEREQ)||(LA24_0 >= MINUS && LA24_0 <= NEQ)||(LA24_0 >= OR && LA24_0 <= PLUS)||(LA24_0 >= RPAREN && LA24_0 <= THEN_KEY)) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(24);}

			switch (alt24) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:4: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					dbg.location(129,4);
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail750); dbg.location(129,11);
					pushFollow(FOLLOW_index_expr_in_value_tail752);
					index_expr();
					state._fsp--;
					dbg.location(129,22);
					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail754); dbg.location(129,29);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:29: ( LBRACK index_expr RBRACK )?
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

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:30: LBRACK index_expr RBRACK
							{
							dbg.location(129,30);
							match(input,LBRACK,FOLLOW_LBRACK_in_value_tail757); dbg.location(129,37);
							pushFollow(FOLLOW_index_expr_in_value_tail759);
							index_expr();
							state._fsp--;
							dbg.location(129,48);
							match(input,RBRACK,FOLLOW_RBRACK_in_value_tail761); 
							}
							break;

					}
					} finally {dbg.exitSubRule(23);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:2: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(131, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "value_tail"



	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:1: index_expr : ( INTLIT | ID ) ( index_oper index_expr )? ;
	public final void index_expr() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(133, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:2: ( ( INTLIT | ID ) ( index_oper index_expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:4: ( INTLIT | ID ) ( index_oper index_expr )?
			{
			dbg.location(134,4);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(134,18);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:18: ( index_oper index_expr )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:19: index_oper index_expr
					{
					dbg.location(134,19);
					pushFollow(FOLLOW_index_oper_in_index_expr789);
					index_oper();
					state._fsp--;
					dbg.location(134,30);
					pushFollow(FOLLOW_index_expr_in_index_expr791);
					index_expr();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(25);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(135, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "index_expr"



	// $ANTLR start "index_oper"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:137:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final void index_oper() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "index_oper");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(137, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:2: ( ( PLUS | MINUS | MULT ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(138,2);
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(139, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_oper");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "index_oper"



	// $ANTLR start "func_call_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final void func_call_tail() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "func_call_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(145, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:3: ( LPAREN func_param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:5: LPAREN func_param_list RPAREN
			{
			dbg.location(146,5);
			match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail863); dbg.location(146,12);
			pushFollow(FOLLOW_func_param_list_in_func_call_tail865);
			func_param_list();
			state._fsp--;
			dbg.location(146,28);
			match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail867); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(147, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_call_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "func_call_tail"



	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:149:1: func_param_list : ( expr ( COMMA_SPACE expr )* |);
	public final void func_param_list() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "func_param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(149, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:3: ( expr ( COMMA_SPACE expr )* |)
			int alt27=2;
			try { dbg.enterDecision(27, decisionCanBacktrack[27]);

			int LA27_0 = input.LA(1);
			if ( (LA27_0==FIXEDPTLIT||LA27_0==ID||LA27_0==INTLIT||LA27_0==LPAREN) ) {
				alt27=1;
			}
			else if ( (LA27_0==RPAREN) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(27);}

			switch (alt27) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:5: expr ( COMMA_SPACE expr )*
					{
					dbg.location(150,5);
					pushFollow(FOLLOW_expr_in_func_param_list882);
					expr();
					state._fsp--;
					dbg.location(150,10);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:10: ( COMMA_SPACE expr )*
					try { dbg.enterSubRule(26);

					loop26:
					while (true) {
						int alt26=2;
						try { dbg.enterDecision(26, decisionCanBacktrack[26]);

						int LA26_0 = input.LA(1);
						if ( (LA26_0==COMMA_SPACE) ) {
							alt26=1;
						}

						} finally {dbg.exitDecision(26);}

						switch (alt26) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:11: COMMA_SPACE expr
							{
							dbg.location(150,11);
							match(input,COMMA_SPACE,FOLLOW_COMMA_SPACE_in_func_param_list885); dbg.location(150,23);
							pushFollow(FOLLOW_expr_in_func_param_list887);
							expr();
							state._fsp--;

							}
							break;

						default :
							break loop26;
						}
					}
					} finally {dbg.exitSubRule(26);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:3: 
					{
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(152, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "func_param_list"



	// $ANTLR start "keywords"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final void keywords() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "keywords");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(155, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(156,2);
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= IF_KEY)||input.LA(1)==INT_KEY||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(179, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "keywords");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "keywords"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program42 = new BitSet(new long[]{0x0004000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list57 = new BitSet(new long[]{0x0004000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_funct_declaration_list59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_funct_declaration74 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration76 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_VOID_KEY_in_funct_declaration82 = new BitSet(new long[]{0x0000000800800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration85 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration89 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration94 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration96 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration98 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration_tail112 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail114 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail116 = new BitSet(new long[]{0x0000100004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail118 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function_tail132 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail134 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list166 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_param_list169 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list171 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ID_in_param186 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_param188 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list200 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail214 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail216 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block231 = new BitSet(new long[]{0x0003000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block233 = new BitSet(new long[]{0x0008080014440180L});
	public static final BitSet FOLLOW_stat_seq_in_block235 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block237 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_block239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement249 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list265 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list279 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration292 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration294 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration296 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration298 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type316 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type318 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type320 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type322 = new BitSet(new long[]{0x0000008080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type325 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type327 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type329 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type333 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration378 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration380 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_var_declaration382 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration384 = new BitSet(new long[]{0x0000200000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration386 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list398 = new BitSet(new long[]{0x0000000000000C02L});
	public static final BitSet FOLLOW_set_in_id_list401 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init430 = new BitSet(new long[]{0x0000000020100000L});
	public static final BitSet FOLLOW_constval_in_optional_init432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq444 = new BitSet(new long[]{0x0008080014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat457 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat459 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat461 = new BitSet(new long[]{0x0008080014428180L});
	public static final BitSet FOLLOW_stat_seq_in_stat463 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat466 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat470 = new BitSet(new long[]{0x0008080014420180L});
	public static final BitSet FOLLOW_stat_seq_in_stat472 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat474 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat476 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat482 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat484 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat486 = new BitSet(new long[]{0x0008080014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat488 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat490 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat497 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat499 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat501 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat503 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat505 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat507 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat509 = new BitSet(new long[]{0x0008080014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat511 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat513 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat522 = new BitSet(new long[]{0x0000000480000040L});
	public static final BitSet FOLLOW_value_tail_in_stat526 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat528 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat530 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_func_call_tail_in_stat536 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat545 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat547 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat552 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat554 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr575 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_ID_in_expr579 = new BitSet(new long[]{0x0000037783082010L});
	public static final BitSet FOLLOW_value_tail_in_expr582 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr584 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr589 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr591 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr593 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_binary_operator_in_expr597 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list721 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_expr_list724 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list726 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ID_in_value739 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail750 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail752 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail754 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail757 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail759 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr780 = new BitSet(new long[]{0x0000023000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr789 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail863 = new BitSet(new long[]{0x0000100424100000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail865 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list882 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_SPACE_in_func_param_list885 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_func_param_list887 = new BitSet(new long[]{0x0000000000000802L});
}
