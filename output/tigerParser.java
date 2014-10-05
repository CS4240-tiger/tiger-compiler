// $ANTLR 3.5 C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g 2014-10-05 18:59:12

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
		"LPAREN", "MAIN_FUNCTION_KEY", "MAIN_KEY", "MINUS", "MULT", "NEQ", "OF_KEY", 
		"OR", "PLUS", "RBRACK", "RETURN_KEY", "RPAREN", "SEMI", "THEN_KEY", "TO_KEY", 
		"TYPE_KEY", "VAR_KEY", "VOID_KEY", "WHILE_KEY"
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
	public static final int MAIN_FUNCTION_KEY=35;
	public static final int MAIN_KEY=36;
	public static final int MINUS=37;
	public static final int MULT=38;
	public static final int NEQ=39;
	public static final int OF_KEY=40;
	public static final int OR=41;
	public static final int PLUS=42;
	public static final int RBRACK=43;
	public static final int RETURN_KEY=44;
	public static final int RPAREN=45;
	public static final int SEMI=46;
	public static final int THEN_KEY=47;
	public static final int TO_KEY=48;
	public static final int TYPE_KEY=49;
	public static final int VAR_KEY=50;
	public static final int VOID_KEY=51;
	public static final int WHILE_KEY=52;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "block_list", "declaration_statement", "expr", "param_list", 
		"id_list", "main_function", "index_oper", "ret_type", "optional_init", 
		"block", "constval", "var_declaration_list", "keywords", "tiger_program", 
		"funct_declaration_list", "block_tail", "base_type", "func_param_list", 
		"type_id", "type", "value", "binary_operator", "expr_list", "value_tail", 
		"param", "stat_seq", "type_declaration", "index_expr", "funct_declaration", 
		"type_declaration_list", "stat", "func_call_tail", "var_declaration"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false
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
	@Override public String getGrammarFileName() { return "C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g"; }



	// $ANTLR start "tiger_program"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:8:1: tiger_program : type_declaration_list funct_declaration_list main_function ;
	public final void tiger_program() throws  {
		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(8, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:9:2: ( type_declaration_list funct_declaration_list main_function )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:9:4: type_declaration_list funct_declaration_list main_function
			{
			dbg.location(9,4);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program42);
			type_declaration_list();
			state._fsp--;
			dbg.location(9,26);
			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program44);
			funct_declaration_list();
			state._fsp--;
			dbg.location(9,49);
			pushFollow(FOLLOW_main_function_in_tiger_program46);
			main_function();
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
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:12:1: funct_declaration_list : ( funct_declaration funct_declaration_list )? ;
	public final void funct_declaration_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(12, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:13:2: ( ( funct_declaration funct_declaration_list )? )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:13:4: ( funct_declaration funct_declaration_list )?
			{
			dbg.location(13,4);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:13:4: ( funct_declaration funct_declaration_list )?
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:13:5: funct_declaration funct_declaration_list
					{
					dbg.location(13,5);
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list59);
					funct_declaration();
					state._fsp--;
					dbg.location(13,23);
					pushFollow(FOLLOW_funct_declaration_list_in_funct_declaration_list61);
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
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:16:1: funct_declaration : ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI ;
	public final void funct_declaration() throws  {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(16, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:17:2: ( ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:17:4: ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(17,4);
			pushFollow(FOLLOW_ret_type_in_funct_declaration74);
			ret_type();
			state._fsp--;
			dbg.location(17,13);
			match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration76); dbg.location(17,26);
			match(input,ID,FOLLOW_ID_in_funct_declaration78); dbg.location(17,29);
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration80); dbg.location(17,36);
			pushFollow(FOLLOW_param_list_in_funct_declaration82);
			param_list();
			state._fsp--;
			dbg.location(17,47);
			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration84); dbg.location(17,54);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration86); dbg.location(17,64);
			pushFollow(FOLLOW_block_list_in_funct_declaration88);
			block_list();
			state._fsp--;
			dbg.location(17,75);
			match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration90); dbg.location(17,83);
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration92); 
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



	// $ANTLR start "main_function"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:20:1: main_function : MAIN_FUNCTION_KEY BEGIN_KEY block_list END_KEY SEMI ;
	public final void main_function() throws  {
		try { dbg.enterRule(getGrammarFileName(), "main_function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:21:2: ( MAIN_FUNCTION_KEY BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:21:4: MAIN_FUNCTION_KEY BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(21,4);
			match(input,MAIN_FUNCTION_KEY,FOLLOW_MAIN_FUNCTION_KEY_in_main_function104); dbg.location(21,22);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_main_function106); dbg.location(21,32);
			pushFollow(FOLLOW_block_list_in_main_function108);
			block_list();
			state._fsp--;
			dbg.location(21,43);
			match(input,END_KEY,FOLLOW_END_KEY_in_main_function110); dbg.location(21,51);
			match(input,SEMI,FOLLOW_SEMI_in_main_function112); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(22, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "main_function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "main_function"



	// $ANTLR start "ret_type"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:24:1: ret_type : ( VOID_KEY | type_id );
	public final void ret_type() throws  {
		try { dbg.enterRule(getGrammarFileName(), "ret_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(24, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:25:2: ( VOID_KEY | type_id )
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
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:25:4: VOID_KEY
					{
					dbg.location(25,4);
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type124); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:26:4: type_id
					{
					dbg.location(26,4);
					pushFollow(FOLLOW_type_id_in_ret_type129);
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
		dbg.location(27, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ret_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "ret_type"



	// $ANTLR start "param_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:29:1: param_list : ( param ( COMMA param )* )? ;
	public final void param_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(29, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:30:2: ( ( param ( COMMA param )* )? )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:30:4: ( param ( COMMA param )* )?
			{
			dbg.location(30,4);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:30:4: ( param ( COMMA param )* )?
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:30:5: param ( COMMA param )*
					{
					dbg.location(30,5);
					pushFollow(FOLLOW_param_in_param_list142);
					param();
					state._fsp--;
					dbg.location(30,11);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:30:11: ( COMMA param )*
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

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:30:12: COMMA param
							{
							dbg.location(30,12);
							match(input,COMMA,FOLLOW_COMMA_in_param_list145); dbg.location(30,18);
							pushFollow(FOLLOW_param_in_param_list147);
							param();
							state._fsp--;

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
			dbg.exitRule(getGrammarFileName(), "param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:33:1: param : ID COLON type_id ;
	public final void param() throws  {
		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(33, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:33:8: ( ID COLON type_id )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:33:10: ID COLON type_id
			{
			dbg.location(33,10);
			match(input,ID,FOLLOW_ID_in_param162); dbg.location(33,13);
			match(input,COLON,FOLLOW_COLON_in_param164); dbg.location(33,19);
			pushFollow(FOLLOW_type_id_in_param166);
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
		dbg.location(33, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:35:1: block_list : block block_tail ;
	public final void block_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(35, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:36:2: ( block block_tail )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:36:4: block block_tail
			{
			dbg.location(36,4);
			pushFollow(FOLLOW_block_in_block_list176);
			block();
			state._fsp--;
			dbg.location(36,10);
			pushFollow(FOLLOW_block_tail_in_block_list178);
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
		dbg.location(37, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block_list"



	// $ANTLR start "block_tail"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:39:1: block_tail : ( block block_tail |);
	public final void block_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "block_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(39, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:40:2: ( block block_tail |)
			int alt5=2;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==BEGIN_KEY) ) {
				alt5=1;
			}
			else if ( (LA5_0==END_KEY) ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:40:4: block block_tail
					{
					dbg.location(40,4);
					pushFollow(FOLLOW_block_in_block_tail190);
					block();
					state._fsp--;
					dbg.location(40,10);
					pushFollow(FOLLOW_block_tail_in_block_tail192);
					block_tail();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:42:2: 
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
		dbg.location(42, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block_tail"



	// $ANTLR start "block"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:44:1: block : BEGIN_KEY declaration_statement stat_seq END_KEY SEMI ;
	public final void block() throws  {
		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(44, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:44:8: ( BEGIN_KEY declaration_statement stat_seq END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:44:10: BEGIN_KEY declaration_statement stat_seq END_KEY SEMI
			{
			dbg.location(44,10);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block207); dbg.location(44,20);
			pushFollow(FOLLOW_declaration_statement_in_block209);
			declaration_statement();
			state._fsp--;
			dbg.location(44,42);
			pushFollow(FOLLOW_stat_seq_in_block211);
			stat_seq();
			state._fsp--;
			dbg.location(44,51);
			match(input,END_KEY,FOLLOW_END_KEY_in_block213); dbg.location(44,59);
			match(input,SEMI,FOLLOW_SEMI_in_block215); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(44, 62);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block"



	// $ANTLR start "declaration_statement"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:46:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final void declaration_statement() throws  {
		try { dbg.enterRule(getGrammarFileName(), "declaration_statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(46, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:47:2: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:47:4: type_declaration_list var_declaration_list
			{
			dbg.location(47,4);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement225);
			type_declaration_list();
			state._fsp--;
			dbg.location(47,26);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement227);
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
		dbg.location(48, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration_statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "declaration_statement"



	// $ANTLR start "type_declaration_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:50:1: type_declaration_list : ( type_declaration )* ;
	public final void type_declaration_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:51:2: ( ( type_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:51:5: ( type_declaration )*
			{
			dbg.location(51,5);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:51:5: ( type_declaration )*
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:51:5: type_declaration
					{
					dbg.location(51,5);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list241);
					type_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop6;
				}
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
		dbg.location(52, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:54:1: var_declaration_list : ( var_declaration )* ;
	public final void var_declaration_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:55:2: ( ( var_declaration )* )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:55:4: ( var_declaration )*
			{
			dbg.location(55,4);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:55:4: ( var_declaration )*
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:55:4: var_declaration
					{
					dbg.location(55,4);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list255);
					var_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop7;
				}
			}
			} finally {dbg.exitSubRule(7);}

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
			dbg.exitRule(getGrammarFileName(), "var_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "var_declaration_list"



	// $ANTLR start "type_declaration"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:58:1: type_declaration : TYPE_KEY ID EQ type SEMI ;
	public final void type_declaration() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(58, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:59:2: ( TYPE_KEY ID EQ type SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:59:4: TYPE_KEY ID EQ type SEMI
			{
			dbg.location(59,4);
			match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration268); dbg.location(59,13);
			match(input,ID,FOLLOW_ID_in_type_declaration270); dbg.location(59,16);
			match(input,EQ,FOLLOW_EQ_in_type_declaration272); dbg.location(59,19);
			pushFollow(FOLLOW_type_in_type_declaration274);
			type();
			state._fsp--;
			dbg.location(59,24);
			match(input,SEMI,FOLLOW_SEMI_in_type_declaration276); 
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
			dbg.exitRule(getGrammarFileName(), "type_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_declaration"



	// $ANTLR start "type"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:62:1: type : ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type );
	public final void type() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(62, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:62:6: ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type )
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
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(9);}

			switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:62:8: base_type
					{
					dbg.location(62,8);
					pushFollow(FOLLOW_base_type_in_type287);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:63:4: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type
					{
					dbg.location(63,4);
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type292); dbg.location(63,14);
					match(input,LBRACK,FOLLOW_LBRACK_in_type294); dbg.location(63,21);
					match(input,INTLIT,FOLLOW_INTLIT_in_type296); dbg.location(63,28);
					match(input,RBRACK,FOLLOW_RBRACK_in_type298); dbg.location(63,35);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:63:35: ( LBRACK INTLIT RBRACK )?
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

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:63:36: LBRACK INTLIT RBRACK
							{
							dbg.location(63,36);
							match(input,LBRACK,FOLLOW_LBRACK_in_type301); dbg.location(63,43);
							match(input,INTLIT,FOLLOW_INTLIT_in_type303); dbg.location(63,50);
							match(input,RBRACK,FOLLOW_RBRACK_in_type305); 
							}
							break;

					}
					} finally {dbg.exitSubRule(8);}
					dbg.location(63,59);
					match(input,OF_KEY,FOLLOW_OF_KEY_in_type309); dbg.location(63,66);
					pushFollow(FOLLOW_base_type_in_type311);
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
		dbg.location(64, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type"



	// $ANTLR start "type_id"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:66:1: type_id : ( base_type | ID );
	public final void type_id() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:66:9: ( base_type | ID )
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
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:66:11: base_type
					{
					dbg.location(66,11);
					pushFollow(FOLLOW_base_type_in_type_id321);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:67:4: ID
					{
					dbg.location(67,4);
					match(input,ID,FOLLOW_ID_in_type_id326); 
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
			dbg.exitRule(getGrammarFileName(), "type_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_id"



	// $ANTLR start "base_type"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:70:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final void base_type() throws  {
		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(70, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:71:2: ( INT_KEY | FIXEDPT_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
			{
			dbg.location(71,2);
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
		dbg.location(73, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "base_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:75:1: var_declaration : VAR_KEY id_list COLON type_id optional_init SEMI ;
	public final void var_declaration() throws  {
		try { dbg.enterRule(getGrammarFileName(), "var_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(75, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:76:2: ( VAR_KEY id_list COLON type_id optional_init SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:76:4: VAR_KEY id_list COLON type_id optional_init SEMI
			{
			dbg.location(76,4);
			match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration354); dbg.location(76,12);
			pushFollow(FOLLOW_id_list_in_var_declaration356);
			id_list();
			state._fsp--;
			dbg.location(76,20);
			match(input,COLON,FOLLOW_COLON_in_var_declaration358); dbg.location(76,26);
			pushFollow(FOLLOW_type_id_in_var_declaration360);
			type_id();
			state._fsp--;
			dbg.location(76,34);
			pushFollow(FOLLOW_optional_init_in_var_declaration362);
			optional_init();
			state._fsp--;
			dbg.location(76,48);
			match(input,SEMI,FOLLOW_SEMI_in_var_declaration364); 
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
			dbg.exitRule(getGrammarFileName(), "var_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "var_declaration"



	// $ANTLR start "id_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:79:1: id_list : ID ( ( COMMA | COMMA_SPACE ) id_list )? ;
	public final void id_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(79, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:79:9: ( ID ( ( COMMA | COMMA_SPACE ) id_list )? )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:79:11: ID ( ( COMMA | COMMA_SPACE ) id_list )?
			{
			dbg.location(79,11);
			match(input,ID,FOLLOW_ID_in_id_list374); dbg.location(79,14);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:79:14: ( ( COMMA | COMMA_SPACE ) id_list )?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( ((LA11_0 >= COMMA && LA11_0 <= COMMA_SPACE)) ) {
				alt11=1;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:79:15: ( COMMA | COMMA_SPACE ) id_list
					{
					dbg.location(79,15);
					if ( (input.LA(1) >= COMMA && input.LA(1) <= COMMA_SPACE) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(79,37);
					pushFollow(FOLLOW_id_list_in_id_list385);
					id_list();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(11);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(80, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "id_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "id_list"



	// $ANTLR start "optional_init"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:82:1: optional_init : (| ASSIGN constval );
	public final void optional_init() throws  {
		try { dbg.enterRule(getGrammarFileName(), "optional_init");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(82, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:83:2: (| ASSIGN constval )
			int alt12=2;
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( (LA12_0==SEMI) ) {
				alt12=1;
			}
			else if ( (LA12_0==ASSIGN) ) {
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:84:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:84:5: ASSIGN constval
					{
					dbg.location(84,5);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init406); dbg.location(84,12);
					pushFollow(FOLLOW_constval_in_optional_init408);
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
		dbg.location(85, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "optional_init");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:87:1: stat_seq : ( stat )* ;
	public final void stat_seq() throws  {
		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(87, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:88:2: ( ( stat )* )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:88:4: ( stat )*
			{
			dbg.location(88,4);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:88:4: ( stat )*
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:88:4: stat
					{
					dbg.location(88,4);
					pushFollow(FOLLOW_stat_in_stat_seq420);
					stat();
					state._fsp--;

					}
					break;

				default :
					break loop13;
				}
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
		dbg.location(89, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat_seq");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat_seq"



	// $ANTLR start "stat"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:91:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block );
	public final void stat() throws  {
		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(91, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:92:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block )
			int alt16=7;
			try { dbg.enterDecision(16, decisionCanBacktrack[16]);

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
				alt16=4;
				}
				break;
			case BREAK_KEY:
				{
				alt16=5;
				}
				break;
			case RETURN_KEY:
				{
				alt16=6;
				}
				break;
			case BEGIN_KEY:
				{
				alt16=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(16);}

			switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:92:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					dbg.location(92,4);
					match(input,IF_KEY,FOLLOW_IF_KEY_in_stat433); dbg.location(92,11);
					pushFollow(FOLLOW_expr_in_stat435);
					expr();
					state._fsp--;
					dbg.location(92,16);
					match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat437); dbg.location(92,25);
					pushFollow(FOLLOW_stat_seq_in_stat439);
					stat_seq();
					state._fsp--;
					dbg.location(92,34);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:92:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
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
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(14);}

					switch (alt14) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:92:35: ENDIF_KEY SEMI
							{
							dbg.location(92,35);
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat442); dbg.location(92,45);
							match(input,SEMI,FOLLOW_SEMI_in_stat444); 
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:92:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							dbg.location(92,50);
							match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat446); dbg.location(92,59);
							pushFollow(FOLLOW_stat_seq_in_stat448);
							stat_seq();
							state._fsp--;
							dbg.location(92,68);
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat450); dbg.location(92,78);
							match(input,SEMI,FOLLOW_SEMI_in_stat452); 
							}
							break;

					}
					} finally {dbg.exitSubRule(14);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:93:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(93,4);
					match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat458); dbg.location(93,14);
					pushFollow(FOLLOW_expr_in_stat460);
					expr();
					state._fsp--;
					dbg.location(93,19);
					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat462); dbg.location(93,26);
					pushFollow(FOLLOW_stat_seq_in_stat464);
					stat_seq();
					state._fsp--;
					dbg.location(93,35);
					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat466); dbg.location(93,45);
					match(input,SEMI,FOLLOW_SEMI_in_stat468); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:94:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(94,4);
					match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat473); dbg.location(94,12);
					match(input,ID,FOLLOW_ID_in_stat475); dbg.location(94,15);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_stat477); dbg.location(94,22);
					pushFollow(FOLLOW_index_expr_in_stat479);
					index_expr();
					state._fsp--;
					dbg.location(94,33);
					match(input,TO_KEY,FOLLOW_TO_KEY_in_stat481); dbg.location(94,40);
					pushFollow(FOLLOW_index_expr_in_stat483);
					index_expr();
					state._fsp--;
					dbg.location(94,51);
					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat485); dbg.location(94,58);
					pushFollow(FOLLOW_stat_seq_in_stat487);
					stat_seq();
					state._fsp--;
					dbg.location(94,67);
					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat489); dbg.location(94,77);
					match(input,SEMI,FOLLOW_SEMI_in_stat491); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:6: ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI
					{
					dbg.location(95,6);
					match(input,ID,FOLLOW_ID_in_stat498); dbg.location(95,9);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:9: ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) )
					int alt15=2;
					try { dbg.enterSubRule(15);
					try { dbg.enterDecision(15, decisionCanBacktrack[15]);

					int LA15_0 = input.LA(1);
					if ( (LA15_0==AND||LA15_0==ASSIGN||(LA15_0 >= COMMA && LA15_0 <= COMMA_SPACE)||(LA15_0 >= DIV && LA15_0 <= DO_KEY)||LA15_0==EQ||(LA15_0 >= GREATER && LA15_0 <= GREATEREQ)||(LA15_0 >= LBRACK && LA15_0 <= LESSEREQ)||(LA15_0 >= MINUS && LA15_0 <= NEQ)||(LA15_0 >= OR && LA15_0 <= PLUS)||(LA15_0 >= RPAREN && LA15_0 <= THEN_KEY)) ) {
						alt15=1;
					}
					else if ( (LA15_0==LPAREN) ) {
						alt15=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(15);}

					switch (alt15) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:10: ( value_tail ASSIGN expr_list )
							{
							dbg.location(95,10);
							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:10: ( value_tail ASSIGN expr_list )
							dbg.enterAlt(1);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:11: value_tail ASSIGN expr_list
							{
							dbg.location(95,11);
							pushFollow(FOLLOW_value_tail_in_stat502);
							value_tail();
							state._fsp--;
							dbg.location(95,22);
							match(input,ASSIGN,FOLLOW_ASSIGN_in_stat504); dbg.location(95,29);
							pushFollow(FOLLOW_expr_list_in_stat506);
							expr_list();
							state._fsp--;

							}

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:42: ( func_call_tail )
							{
							dbg.location(95,42);
							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:42: ( func_call_tail )
							dbg.enterAlt(1);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:95:43: func_call_tail
							{
							dbg.location(95,43);
							pushFollow(FOLLOW_func_call_tail_in_stat512);
							func_call_tail();
							state._fsp--;

							}

							}
							break;

					}
					} finally {dbg.exitSubRule(15);}
					dbg.location(95,60);
					match(input,SEMI,FOLLOW_SEMI_in_stat516); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:96:4: BREAK_KEY SEMI
					{
					dbg.location(96,4);
					match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat521); dbg.location(96,14);
					match(input,SEMI,FOLLOW_SEMI_in_stat523); 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:97:4: RETURN_KEY expr SEMI
					{
					dbg.location(97,4);
					match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat528); dbg.location(97,15);
					pushFollow(FOLLOW_expr_in_stat530);
					expr();
					state._fsp--;
					dbg.location(97,20);
					match(input,SEMI,FOLLOW_SEMI_in_stat532); 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:98:4: block
					{
					dbg.location(98,4);
					pushFollow(FOLLOW_block_in_stat537);
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
		dbg.location(99, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )? ;
	public final void expr() throws  {
		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(101, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )?
			{
			dbg.location(101,9);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN )
			int alt18=3;
			try { dbg.enterSubRule(18);
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

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
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:10: constval
					{
					dbg.location(101,10);
					pushFollow(FOLLOW_constval_in_expr551);
					constval();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:21: ID ( value_tail | func_call_tail )
					{
					dbg.location(101,21);
					match(input,ID,FOLLOW_ID_in_expr555); dbg.location(101,24);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:24: ( value_tail | func_call_tail )
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==AND||LA17_0==ASSIGN||(LA17_0 >= COMMA && LA17_0 <= COMMA_SPACE)||(LA17_0 >= DIV && LA17_0 <= DO_KEY)||LA17_0==EQ||(LA17_0 >= GREATER && LA17_0 <= GREATEREQ)||(LA17_0 >= LBRACK && LA17_0 <= LESSEREQ)||(LA17_0 >= MINUS && LA17_0 <= NEQ)||(LA17_0 >= OR && LA17_0 <= PLUS)||(LA17_0 >= RPAREN && LA17_0 <= THEN_KEY)) ) {
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

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:25: value_tail
							{
							dbg.location(101,25);
							pushFollow(FOLLOW_value_tail_in_expr558);
							value_tail();
							state._fsp--;

							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:36: func_call_tail
							{
							dbg.location(101,36);
							pushFollow(FOLLOW_func_call_tail_in_expr560);
							func_call_tail();
							state._fsp--;

							}
							break;

					}
					} finally {dbg.exitSubRule(17);}

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:54: LPAREN expr RPAREN
					{
					dbg.location(101,54);
					match(input,LPAREN,FOLLOW_LPAREN_in_expr565); dbg.location(101,61);
					pushFollow(FOLLOW_expr_in_expr567);
					expr();
					state._fsp--;
					dbg.location(101,66);
					match(input,RPAREN,FOLLOW_RPAREN_in_expr569); 
					}
					break;

			}
			} finally {dbg.exitSubRule(18);}
			dbg.location(101,74);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:74: ( binary_operator expr )?
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

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:101:75: binary_operator expr
					{
					dbg.location(101,75);
					pushFollow(FOLLOW_binary_operator_in_expr573);
					binary_operator();
					state._fsp--;
					dbg.location(101,91);
					pushFollow(FOLLOW_expr_in_expr575);
					expr();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(19);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(102, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr"



	// $ANTLR start "constval"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:104:1: constval : ( INTLIT | FIXEDPTLIT );
	public final void constval() throws  {
		try { dbg.enterRule(getGrammarFileName(), "constval");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(104, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:104:9: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
			{
			dbg.location(104,9);
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
		dbg.location(106, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "constval");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "constval"



	// $ANTLR start "binary_operator"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:115:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final void binary_operator() throws  {
		try { dbg.enterRule(getGrammarFileName(), "binary_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(115, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:116:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
			{
			dbg.location(116,2);
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
		dbg.location(117, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binary_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "binary_operator"



	// $ANTLR start "expr_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:119:1: expr_list : expr ( COMMA expr )* ;
	public final void expr_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(119, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:120:2: ( expr ( COMMA expr )* )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:120:4: expr ( COMMA expr )*
			{
			dbg.location(120,4);
			pushFollow(FOLLOW_expr_in_expr_list697);
			expr();
			state._fsp--;
			dbg.location(120,9);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:120:9: ( COMMA expr )*
			try { dbg.enterSubRule(20);

			loop20:
			while (true) {
				int alt20=2;
				try { dbg.enterDecision(20, decisionCanBacktrack[20]);

				int LA20_0 = input.LA(1);
				if ( (LA20_0==COMMA) ) {
					alt20=1;
				}

				} finally {dbg.exitDecision(20);}

				switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:120:10: COMMA expr
					{
					dbg.location(120,10);
					match(input,COMMA,FOLLOW_COMMA_in_expr_list700); dbg.location(120,16);
					pushFollow(FOLLOW_expr_in_expr_list702);
					expr();
					state._fsp--;

					}
					break;

				default :
					break loop20;
				}
			}
			} finally {dbg.exitSubRule(20);}

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
			dbg.exitRule(getGrammarFileName(), "expr_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr_list"



	// $ANTLR start "value"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:123:1: value : ID value_tail ;
	public final void value() throws  {
		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(123, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:123:8: ( ID value_tail )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:123:10: ID value_tail
			{
			dbg.location(123,10);
			match(input,ID,FOLLOW_ID_in_value715); dbg.location(123,13);
			pushFollow(FOLLOW_value_tail_in_value717);
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
		dbg.location(123, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "value"



	// $ANTLR start "value_tail"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:124:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |);
	public final void value_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "value_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(124, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:125:2: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |)
			int alt22=2;
			try { dbg.enterDecision(22, decisionCanBacktrack[22]);

			int LA22_0 = input.LA(1);
			if ( (LA22_0==LBRACK) ) {
				alt22=1;
			}
			else if ( (LA22_0==AND||LA22_0==ASSIGN||(LA22_0 >= COMMA && LA22_0 <= COMMA_SPACE)||(LA22_0 >= DIV && LA22_0 <= DO_KEY)||LA22_0==EQ||(LA22_0 >= GREATER && LA22_0 <= GREATEREQ)||(LA22_0 >= LESSER && LA22_0 <= LESSEREQ)||(LA22_0 >= MINUS && LA22_0 <= NEQ)||(LA22_0 >= OR && LA22_0 <= PLUS)||(LA22_0 >= RPAREN && LA22_0 <= THEN_KEY)) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(22);}

			switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:125:4: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					dbg.location(125,4);
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail726); dbg.location(125,11);
					pushFollow(FOLLOW_index_expr_in_value_tail728);
					index_expr();
					state._fsp--;
					dbg.location(125,22);
					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail730); dbg.location(125,29);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:125:29: ( LBRACK index_expr RBRACK )?
					int alt21=2;
					try { dbg.enterSubRule(21);
					try { dbg.enterDecision(21, decisionCanBacktrack[21]);

					int LA21_0 = input.LA(1);
					if ( (LA21_0==LBRACK) ) {
						alt21=1;
					}
					} finally {dbg.exitDecision(21);}

					switch (alt21) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:125:30: LBRACK index_expr RBRACK
							{
							dbg.location(125,30);
							match(input,LBRACK,FOLLOW_LBRACK_in_value_tail733); dbg.location(125,37);
							pushFollow(FOLLOW_index_expr_in_value_tail735);
							index_expr();
							state._fsp--;
							dbg.location(125,48);
							match(input,RBRACK,FOLLOW_RBRACK_in_value_tail737); 
							}
							break;

					}
					} finally {dbg.exitSubRule(21);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:127:2: 
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
		dbg.location(127, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "value_tail"



	// $ANTLR start "index_expr"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:129:1: index_expr : ( INTLIT | ID ) ( index_oper index_expr )? ;
	public final void index_expr() throws  {
		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(129, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:130:2: ( ( INTLIT | ID ) ( index_oper index_expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:130:4: ( INTLIT | ID ) ( index_oper index_expr )?
			{
			dbg.location(130,4);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(130,18);
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:130:18: ( index_oper index_expr )?
			int alt23=2;
			try { dbg.enterSubRule(23);
			try { dbg.enterDecision(23, decisionCanBacktrack[23]);

			int LA23_0 = input.LA(1);
			if ( ((LA23_0 >= MINUS && LA23_0 <= MULT)||LA23_0==PLUS) ) {
				alt23=1;
			}
			} finally {dbg.exitDecision(23);}

			switch (alt23) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:130:19: index_oper index_expr
					{
					dbg.location(130,19);
					pushFollow(FOLLOW_index_oper_in_index_expr765);
					index_oper();
					state._fsp--;
					dbg.location(130,30);
					pushFollow(FOLLOW_index_expr_in_index_expr767);
					index_expr();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(23);}

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
			dbg.exitRule(getGrammarFileName(), "index_expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "index_expr"



	// $ANTLR start "index_oper"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:133:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final void index_oper() throws  {
		try { dbg.enterRule(getGrammarFileName(), "index_oper");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(133, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:134:2: ( ( PLUS | MINUS | MULT ) )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
			{
			dbg.location(134,2);
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
		dbg.location(135, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_oper");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "index_oper"



	// $ANTLR start "func_call_tail"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:141:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final void func_call_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "func_call_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(141, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:142:3: ( LPAREN func_param_list RPAREN )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:142:5: LPAREN func_param_list RPAREN
			{
			dbg.location(142,5);
			match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail839); dbg.location(142,12);
			pushFollow(FOLLOW_func_param_list_in_func_call_tail841);
			func_param_list();
			state._fsp--;
			dbg.location(142,28);
			match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail843); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(143, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_call_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "func_call_tail"



	// $ANTLR start "func_param_list"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:145:1: func_param_list : ( value ( COMMA_SPACE value )* |);
	public final void func_param_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "func_param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(145, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:146:3: ( value ( COMMA_SPACE value )* |)
			int alt25=2;
			try { dbg.enterDecision(25, decisionCanBacktrack[25]);

			int LA25_0 = input.LA(1);
			if ( (LA25_0==ID) ) {
				alt25=1;
			}
			else if ( (LA25_0==RPAREN) ) {
				alt25=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(25);}

			switch (alt25) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:146:5: value ( COMMA_SPACE value )*
					{
					dbg.location(146,5);
					pushFollow(FOLLOW_value_in_func_param_list858);
					value();
					state._fsp--;
					dbg.location(146,11);
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:146:11: ( COMMA_SPACE value )*
					try { dbg.enterSubRule(24);

					loop24:
					while (true) {
						int alt24=2;
						try { dbg.enterDecision(24, decisionCanBacktrack[24]);

						int LA24_0 = input.LA(1);
						if ( (LA24_0==COMMA_SPACE) ) {
							alt24=1;
						}

						} finally {dbg.exitDecision(24);}

						switch (alt24) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:146:12: COMMA_SPACE value
							{
							dbg.location(146,12);
							match(input,COMMA_SPACE,FOLLOW_COMMA_SPACE_in_func_param_list861); dbg.location(146,24);
							pushFollow(FOLLOW_value_in_func_param_list863);
							value();
							state._fsp--;

							}
							break;

						default :
							break loop24;
						}
					}
					} finally {dbg.exitSubRule(24);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:148:3: 
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
		dbg.location(148, 2);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "func_param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "func_param_list"



	// $ANTLR start "keywords"
	// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:151:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final void keywords() throws  {
		try { dbg.enterRule(getGrammarFileName(), "keywords");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(151, 0);

		try {
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:152:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
			{
			dbg.location(152,2);
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
		dbg.location(175, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "keywords");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "keywords"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program42 = new BitSet(new long[]{0x0008000844200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program44 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_main_function_in_tiger_program46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list59 = new BitSet(new long[]{0x0008000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_funct_declaration_list61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration74 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration76 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration78 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration80 = new BitSet(new long[]{0x0000200004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration82 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration84 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration86 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration88 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration90 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_FUNCTION_KEY_in_main_function104 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_main_function106 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function108 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_main_function110 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list142 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_param_list145 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list147 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ID_in_param162 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_param164 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list176 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail190 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block207 = new BitSet(new long[]{0x0006000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block209 = new BitSet(new long[]{0x0010100014440180L});
	public static final BitSet FOLLOW_stat_seq_in_block211 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block213 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_block215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement225 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list241 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list255 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration268 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration270 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration272 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration274 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type292 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type294 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type296 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type298 = new BitSet(new long[]{0x0000010080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type301 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type303 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type305 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type309 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id326 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration354 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration356 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_var_declaration358 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration360 = new BitSet(new long[]{0x0000400000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration362 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list374 = new BitSet(new long[]{0x0000000000000C02L});
	public static final BitSet FOLLOW_set_in_id_list377 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init406 = new BitSet(new long[]{0x0000000020100000L});
	public static final BitSet FOLLOW_constval_in_optional_init408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq420 = new BitSet(new long[]{0x0010100014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat433 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat435 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat437 = new BitSet(new long[]{0x0010100014428180L});
	public static final BitSet FOLLOW_stat_seq_in_stat439 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat442 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat446 = new BitSet(new long[]{0x0010100014420180L});
	public static final BitSet FOLLOW_stat_seq_in_stat448 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat450 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat452 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat458 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat460 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat462 = new BitSet(new long[]{0x0010100014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat464 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat466 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat473 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat475 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat477 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat479 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat481 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat483 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat485 = new BitSet(new long[]{0x0010100014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat487 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat489 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat498 = new BitSet(new long[]{0x0000000480000040L});
	public static final BitSet FOLLOW_value_tail_in_stat502 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat504 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat506 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_func_call_tail_in_stat512 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat521 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat528 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat530 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr551 = new BitSet(new long[]{0x000006E303082012L});
	public static final BitSet FOLLOW_ID_in_expr555 = new BitSet(new long[]{0x000006E783082010L});
	public static final BitSet FOLLOW_value_tail_in_expr558 = new BitSet(new long[]{0x000006E303082012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr560 = new BitSet(new long[]{0x000006E303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr565 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr567 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr569 = new BitSet(new long[]{0x000006E303082012L});
	public static final BitSet FOLLOW_binary_operator_in_expr573 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list697 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_expr_list700 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list702 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ID_in_value715 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail726 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail728 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail730 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail733 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail735 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr756 = new BitSet(new long[]{0x0000046000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr765 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail839 = new BitSet(new long[]{0x0000200004000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail841 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_func_param_list858 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_SPACE_in_func_param_list861 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_value_in_func_param_list863 = new BitSet(new long[]{0x0000000000000802L});
}
