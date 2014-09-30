// $ANTLR 3.5 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-09-30 17:23:38

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
		"BEGIN_KEY", "BREAK_KEY", "COLON", "COMMA", "COMMENT", "DIV", "DO_KEY", 
		"ELSE_KEY", "ENDDO_KEY", "ENDIF_KEY", "END_KEY", "EQ", "FIXEDPTLIT", "FIXEDPT_KEY", 
		"FOR_KEY", "FUNCTION_KEY", "GREATER", "GREATEREQ", "ID", "ID_KEY", "IF_KEY", 
		"INTLIT", "INT_KEY", "LBRACK", "LESSER", "LESSEREQ", "LPAREN", "MAIN_KEY", 
		"MINUS", "MULT", "NEQ", "OF_KEY", "OR", "PLUS", "RBRACK", "RETURN_KEY", 
		"RPAREN", "SEMI", "THEN_KEY", "TO_KEY", "TYPE_KEY", "VAR_KEY", "VOID_KEY", 
		"WHILE_KEY"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY_KEY=5;
	public static final int ASSIGN=6;
	public static final int BEGIN_KEY=7;
	public static final int BREAK_KEY=8;
	public static final int COLON=9;
	public static final int COMMA=10;
	public static final int COMMENT=11;
	public static final int DIV=12;
	public static final int DO_KEY=13;
	public static final int ELSE_KEY=14;
	public static final int ENDDO_KEY=15;
	public static final int ENDIF_KEY=16;
	public static final int END_KEY=17;
	public static final int EQ=18;
	public static final int FIXEDPTLIT=19;
	public static final int FIXEDPT_KEY=20;
	public static final int FOR_KEY=21;
	public static final int FUNCTION_KEY=22;
	public static final int GREATER=23;
	public static final int GREATEREQ=24;
	public static final int ID=25;
	public static final int ID_KEY=26;
	public static final int IF_KEY=27;
	public static final int INTLIT=28;
	public static final int INT_KEY=29;
	public static final int LBRACK=30;
	public static final int LESSER=31;
	public static final int LESSEREQ=32;
	public static final int LPAREN=33;
	public static final int MAIN_KEY=34;
	public static final int MINUS=35;
	public static final int MULT=36;
	public static final int NEQ=37;
	public static final int OF_KEY=38;
	public static final int OR=39;
	public static final int PLUS=40;
	public static final int RBRACK=41;
	public static final int RETURN_KEY=42;
	public static final int RPAREN=43;
	public static final int SEMI=44;
	public static final int THEN_KEY=45;
	public static final int TO_KEY=46;
	public static final int TYPE_KEY=47;
	public static final int VAR_KEY=48;
	public static final int VOID_KEY=49;
	public static final int WHILE_KEY=50;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "funct_declaration_list", "param", "expr", "param_list", 
		"type_id", "stat", "tiger_program", "var_declaration", "value", "block_tail", 
		"opt_prefix", "expr_list_tail", "main_function", "type", "optional_init", 
		"base_type", "binary_operator", "const", "keywords", "ret_type", "block_list", 
		"stat_seq", "expr_list", "index_oper", "param_list_tail", "type_declaration", 
		"id_list", "type_declaration_list", "value_tail", "funct_declaration", 
		"block", "var_declaration_list", "index_expr", "declaration_statement"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:3:1: tiger_program : type_declaration_list funct_declaration_list main_function ;
	public final void tiger_program() throws  {
		try { dbg.enterRule(getGrammarFileName(), "tiger_program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(3, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:4:2: ( type_declaration_list funct_declaration_list main_function )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:4:4: type_declaration_list funct_declaration_list main_function
			{
			dbg.location(4,4);
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program11);
			type_declaration_list();
			state._fsp--;
			dbg.location(4,26);
			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program13);
			funct_declaration_list();
			state._fsp--;
			dbg.location(4,49);
			pushFollow(FOLLOW_main_function_in_tiger_program15);
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
		dbg.location(5, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "tiger_program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "tiger_program"



	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:7:1: funct_declaration_list : (| funct_declaration funct_declaration_list );
	public final void funct_declaration_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(7, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:8:2: (| funct_declaration funct_declaration_list )
			int alt1=2;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			int LA1_0 = input.LA(1);
			if ( (LA1_0==VOID_KEY) ) {
				int LA1_1 = input.LA(2);
				if ( (LA1_1==MAIN_KEY) ) {
					alt1=1;
				}
				else if ( (LA1_1==FUNCTION_KEY) ) {
					alt1=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:4: funct_declaration funct_declaration_list
					{
					dbg.location(9,4);
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list31);
					funct_declaration();
					state._fsp--;
					dbg.location(9,22);
					pushFollow(FOLLOW_funct_declaration_list_in_funct_declaration_list33);
					funct_declaration_list();
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
		dbg.location(10, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funct_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "funct_declaration_list"



	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:12:1: funct_declaration : ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI ;
	public final void funct_declaration() throws  {
		try { dbg.enterRule(getGrammarFileName(), "funct_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(12, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:2: ( ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(13,4);
			pushFollow(FOLLOW_ret_type_in_funct_declaration44);
			ret_type();
			state._fsp--;
			dbg.location(13,13);
			match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration46); dbg.location(13,26);
			match(input,ID,FOLLOW_ID_in_funct_declaration48); dbg.location(13,29);
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration50); dbg.location(13,36);
			pushFollow(FOLLOW_param_list_in_funct_declaration52);
			param_list();
			state._fsp--;
			dbg.location(13,47);
			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration54); dbg.location(13,54);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration56); dbg.location(13,64);
			pushFollow(FOLLOW_block_list_in_funct_declaration58);
			block_list();
			state._fsp--;
			dbg.location(13,75);
			match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration60); dbg.location(13,83);
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration62); 
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
			dbg.exitRule(getGrammarFileName(), "funct_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "funct_declaration"



	// $ANTLR start "main_function"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:16:1: main_function : VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI ;
	public final void main_function() throws  {
		try { dbg.enterRule(getGrammarFileName(), "main_function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(16, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:2: ( VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:4: VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			dbg.location(17,4);
			match(input,VOID_KEY,FOLLOW_VOID_KEY_in_main_function74); dbg.location(17,13);
			match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function76); dbg.location(17,22);
			match(input,LPAREN,FOLLOW_LPAREN_in_main_function78); dbg.location(17,29);
			match(input,RPAREN,FOLLOW_RPAREN_in_main_function80); dbg.location(17,36);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_main_function82); dbg.location(17,46);
			pushFollow(FOLLOW_block_list_in_main_function84);
			block_list();
			state._fsp--;
			dbg.location(17,57);
			match(input,END_KEY,FOLLOW_END_KEY_in_main_function86); dbg.location(17,65);
			match(input,SEMI,FOLLOW_SEMI_in_main_function88); 
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
			dbg.exitRule(getGrammarFileName(), "main_function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "main_function"



	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:20:1: ret_type : ( VOID_KEY | type_id );
	public final void ret_type() throws  {
		try { dbg.enterRule(getGrammarFileName(), "ret_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:2: ( VOID_KEY | type_id )
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:4: VOID_KEY
					{
					dbg.location(21,4);
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type100); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:22:4: type_id
					{
					dbg.location(22,4);
					pushFollow(FOLLOW_type_id_in_ret_type105);
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
		dbg.location(23, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ret_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "ret_type"



	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:25:1: param_list : (| param param_list_tail );
	public final void param_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "param_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(25, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:26:2: (| param param_list_tail )
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

			int LA3_0 = input.LA(1);
			if ( (LA3_0==RPAREN) ) {
				alt3=1;
			}
			else if ( (LA3_0==ID) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:27:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:27:4: param param_list_tail
					{
					dbg.location(27,4);
					pushFollow(FOLLOW_param_in_param_list121);
					param();
					state._fsp--;
					dbg.location(27,10);
					pushFollow(FOLLOW_param_list_tail_in_param_list123);
					param_list_tail();
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
		dbg.location(28, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param_list"



	// $ANTLR start "param_list_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:30:1: param_list_tail : (| COMMA param param_list_tail );
	public final void param_list_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "param_list_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(30, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:31:2: (| COMMA param param_list_tail )
			int alt4=2;
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==RPAREN) ) {
				alt4=1;
			}
			else if ( (LA4_0==COMMA) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:32:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:32:4: COMMA param param_list_tail
					{
					dbg.location(32,4);
					match(input,COMMA,FOLLOW_COMMA_in_param_list_tail139); dbg.location(32,10);
					pushFollow(FOLLOW_param_in_param_list_tail141);
					param();
					state._fsp--;
					dbg.location(32,16);
					pushFollow(FOLLOW_param_list_tail_in_param_list_tail143);
					param_list_tail();
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
		dbg.location(33, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param_list_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param_list_tail"



	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:35:1: param : ID COLON type_id ;
	public final void param() throws  {
		try { dbg.enterRule(getGrammarFileName(), "param");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(35, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:35:8: ( ID COLON type_id )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:35:10: ID COLON type_id
			{
			dbg.location(35,10);
			match(input,ID,FOLLOW_ID_in_param154); dbg.location(35,13);
			match(input,COLON,FOLLOW_COLON_in_param156); dbg.location(35,19);
			pushFollow(FOLLOW_type_id_in_param158);
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
		dbg.location(35, 25);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "param");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:1: block_list : block block_tail ;
	public final void block_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "block_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:38:2: ( block block_tail )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:38:4: block block_tail
			{
			dbg.location(38,4);
			pushFollow(FOLLOW_block_in_block_list168);
			block();
			state._fsp--;
			dbg.location(38,10);
			pushFollow(FOLLOW_block_tail_in_block_list170);
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
		dbg.location(39, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block_list"



	// $ANTLR start "block_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:41:1: block_tail : ( block block_tail |);
	public final void block_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "block_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(41, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:42:2: ( block block_tail |)
			int alt5=2;
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==BEGIN_KEY) ) {
				alt5=1;
			}
			else if ( (LA5_0==END_KEY||LA5_0==SEMI) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:42:4: block block_tail
					{
					dbg.location(42,4);
					pushFollow(FOLLOW_block_in_block_tail182);
					block();
					state._fsp--;
					dbg.location(42,10);
					pushFollow(FOLLOW_block_tail_in_block_tail184);
					block_tail();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:44:2: 
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
		dbg.location(44, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block_tail"



	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:1: block : BEGIN_KEY declaration_statement stat_seq END_KEY SEMI ;
	public final void block() throws  {
		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(46, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:8: ( BEGIN_KEY declaration_statement stat_seq END_KEY SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:10: BEGIN_KEY declaration_statement stat_seq END_KEY SEMI
			{
			dbg.location(46,10);
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block199); dbg.location(46,20);
			pushFollow(FOLLOW_declaration_statement_in_block201);
			declaration_statement();
			state._fsp--;
			dbg.location(46,42);
			pushFollow(FOLLOW_stat_seq_in_block203);
			stat_seq();
			state._fsp--;
			dbg.location(46,51);
			match(input,END_KEY,FOLLOW_END_KEY_in_block205); dbg.location(46,59);
			match(input,SEMI,FOLLOW_SEMI_in_block207); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(46, 62);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "block"



	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final void declaration_statement() throws  {
		try { dbg.enterRule(getGrammarFileName(), "declaration_statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(48, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:49:2: ( type_declaration_list var_declaration_list )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:49:4: type_declaration_list var_declaration_list
			{
			dbg.location(49,4);
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement217);
			type_declaration_list();
			state._fsp--;
			dbg.location(49,26);
			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement219);
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
		dbg.location(50, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration_statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "declaration_statement"



	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:52:1: type_declaration_list : (| type_declaration type_declaration_list );
	public final void type_declaration_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(52, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:53:2: (| type_declaration type_declaration_list )
			int alt6=2;
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= BEGIN_KEY && LA6_0 <= BREAK_KEY)||(LA6_0 >= ELSE_KEY && LA6_0 <= END_KEY)||(LA6_0 >= FIXEDPT_KEY && LA6_0 <= FOR_KEY)||LA6_0==ID||LA6_0==IF_KEY||LA6_0==INT_KEY||LA6_0==RETURN_KEY||(LA6_0 >= VAR_KEY && LA6_0 <= WHILE_KEY)) ) {
				alt6=1;
			}
			else if ( (LA6_0==TYPE_KEY) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:54:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:54:4: type_declaration type_declaration_list
					{
					dbg.location(54,4);
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list236);
					type_declaration();
					state._fsp--;
					dbg.location(54,21);
					pushFollow(FOLLOW_type_declaration_list_in_type_declaration_list238);
					type_declaration_list();
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
		dbg.location(55, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_declaration_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:57:1: var_declaration_list : (| var_declaration var_declaration_list );
	public final void var_declaration_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "var_declaration_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(57, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:58:2: (| var_declaration var_declaration_list )
			int alt7=2;
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( ((LA7_0 >= BEGIN_KEY && LA7_0 <= BREAK_KEY)||(LA7_0 >= ELSE_KEY && LA7_0 <= END_KEY)||LA7_0==FOR_KEY||LA7_0==ID||LA7_0==IF_KEY||LA7_0==RETURN_KEY||LA7_0==WHILE_KEY) ) {
				alt7=1;
			}
			else if ( (LA7_0==VAR_KEY) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: var_declaration var_declaration_list
					{
					dbg.location(59,4);
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list255);
					var_declaration();
					state._fsp--;
					dbg.location(59,20);
					pushFollow(FOLLOW_var_declaration_list_in_var_declaration_list257);
					var_declaration_list();
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
	public final void type_declaration() throws  {
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
			match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration269); dbg.location(63,13);
			match(input,ID,FOLLOW_ID_in_type_declaration271); dbg.location(63,16);
			match(input,EQ,FOLLOW_EQ_in_type_declaration273); dbg.location(63,19);
			pushFollow(FOLLOW_type_in_type_declaration275);
			type();
			state._fsp--;
			dbg.location(63,24);
			match(input,SEMI,FOLLOW_SEMI_in_type_declaration277); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:1: type : ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY base_type | ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY base_type );
	public final void type() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(66, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:6: ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY base_type | ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY base_type )
			int alt8=3;
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			int LA8_0 = input.LA(1);
			if ( (LA8_0==FIXEDPT_KEY||LA8_0==INT_KEY) ) {
				alt8=1;
			}
			else if ( (LA8_0==ARRAY_KEY) ) {
				int LA8_2 = input.LA(2);
				if ( (LA8_2==LBRACK) ) {
					int LA8_3 = input.LA(3);
					if ( (LA8_3==INTLIT) ) {
						int LA8_4 = input.LA(4);
						if ( (LA8_4==RBRACK) ) {
							int LA8_5 = input.LA(5);
							if ( (LA8_5==OF_KEY) ) {
								alt8=2;
							}
							else if ( (LA8_5==LBRACK) ) {
								alt8=3;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 8, 5, input);
									dbg.recognitionException(nvae);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 8, 4, input);
								dbg.recognitionException(nvae);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 8, 3, input);
							dbg.recognitionException(nvae);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 2, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:8: base_type
					{
					dbg.location(66,8);
					pushFollow(FOLLOW_base_type_in_type288);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:4: ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY base_type
					{
					dbg.location(67,4);
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type293); dbg.location(67,14);
					match(input,LBRACK,FOLLOW_LBRACK_in_type295); dbg.location(67,21);
					match(input,INTLIT,FOLLOW_INTLIT_in_type297); dbg.location(67,28);
					match(input,RBRACK,FOLLOW_RBRACK_in_type299); dbg.location(67,35);
					match(input,OF_KEY,FOLLOW_OF_KEY_in_type301); dbg.location(67,42);
					pushFollow(FOLLOW_base_type_in_type303);
					base_type();
					state._fsp--;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:4: ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY base_type
					{
					dbg.location(68,4);
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type308); dbg.location(68,14);
					match(input,LBRACK,FOLLOW_LBRACK_in_type310); dbg.location(68,21);
					match(input,INTLIT,FOLLOW_INTLIT_in_type312); dbg.location(68,28);
					match(input,RBRACK,FOLLOW_RBRACK_in_type314); dbg.location(68,35);
					match(input,LBRACK,FOLLOW_LBRACK_in_type316); dbg.location(68,42);
					match(input,INTLIT,FOLLOW_INTLIT_in_type318); dbg.location(68,49);
					match(input,RBRACK,FOLLOW_RBRACK_in_type320); dbg.location(68,56);
					match(input,OF_KEY,FOLLOW_OF_KEY_in_type322); dbg.location(68,63);
					pushFollow(FOLLOW_base_type_in_type324);
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
		dbg.location(69, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type"



	// $ANTLR start "type_id"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:1: type_id : ( base_type | ID );
	public final void type_id() throws  {
		try { dbg.enterRule(getGrammarFileName(), "type_id");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:9: ( base_type | ID )
			int alt9=2;
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			int LA9_0 = input.LA(1);
			if ( (LA9_0==FIXEDPT_KEY||LA9_0==INT_KEY) ) {
				alt9=1;
			}
			else if ( (LA9_0==ID) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:11: base_type
					{
					dbg.location(71,11);
					pushFollow(FOLLOW_base_type_in_type_id334);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:4: ID
					{
					dbg.location(72,4);
					match(input,ID,FOLLOW_ID_in_type_id339); 
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
		dbg.location(73, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_id");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "type_id"



	// $ANTLR start "base_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:75:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final void base_type() throws  {
		try { dbg.enterRule(getGrammarFileName(), "base_type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(75, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:76:2: ( INT_KEY | FIXEDPT_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(76,2);
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
		dbg.location(78, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "base_type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:1: var_declaration : VAR_KEY id_list COLON type_id optional_init SEMI ;
	public final void var_declaration() throws  {
		try { dbg.enterRule(getGrammarFileName(), "var_declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(80, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:81:2: ( VAR_KEY id_list COLON type_id optional_init SEMI )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:81:4: VAR_KEY id_list COLON type_id optional_init SEMI
			{
			dbg.location(81,4);
			match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration367); dbg.location(81,12);
			pushFollow(FOLLOW_id_list_in_var_declaration369);
			id_list();
			state._fsp--;
			dbg.location(81,20);
			match(input,COLON,FOLLOW_COLON_in_var_declaration371); dbg.location(81,26);
			pushFollow(FOLLOW_type_id_in_var_declaration373);
			type_id();
			state._fsp--;
			dbg.location(81,34);
			pushFollow(FOLLOW_optional_init_in_var_declaration375);
			optional_init();
			state._fsp--;
			dbg.location(81,48);
			match(input,SEMI,FOLLOW_SEMI_in_var_declaration377); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(82, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "var_declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "var_declaration"



	// $ANTLR start "id_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:1: id_list : ( ID | ID COMMA id_list );
	public final void id_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(84, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:9: ( ID | ID COMMA id_list )
			int alt10=2;
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			int LA10_0 = input.LA(1);
			if ( (LA10_0==ID) ) {
				int LA10_1 = input.LA(2);
				if ( (LA10_1==COMMA) ) {
					alt10=2;
				}
				else if ( (LA10_1==COLON) ) {
					alt10=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:11: ID
					{
					dbg.location(84,11);
					match(input,ID,FOLLOW_ID_in_id_list387); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:85:4: ID COMMA id_list
					{
					dbg.location(85,4);
					match(input,ID,FOLLOW_ID_in_id_list392); dbg.location(85,7);
					match(input,COMMA,FOLLOW_COMMA_in_id_list394); dbg.location(85,13);
					pushFollow(FOLLOW_id_list_in_id_list396);
					id_list();
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
		dbg.location(86, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "id_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "id_list"



	// $ANTLR start "optional_init"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:1: optional_init : (| ASSIGN const );
	public final void optional_init() throws  {
		try { dbg.enterRule(getGrammarFileName(), "optional_init");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(88, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:2: (| ASSIGN const )
			int alt11=2;
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==SEMI) ) {
				alt11=1;
			}
			else if ( (LA11_0==ASSIGN) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:90:5: ASSIGN const
					{
					dbg.location(90,5);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init415); dbg.location(90,12);
					pushFollow(FOLLOW_const_in_optional_init417);
					const();
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
		dbg.location(91, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "optional_init");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:1: stat_seq : ( stat )* ;
	public final void stat_seq() throws  {
		try { dbg.enterRule(getGrammarFileName(), "stat_seq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(93, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:94:2: ( ( stat )* )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:94:4: ( stat )*
			{
			dbg.location(94,4);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:94:4: ( stat )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= BEGIN_KEY && LA12_0 <= BREAK_KEY)||LA12_0==FOR_KEY||LA12_0==ID||LA12_0==IF_KEY||LA12_0==RETURN_KEY||LA12_0==WHILE_KEY) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:94:4: stat
					{
					dbg.location(94,4);
					pushFollow(FOLLOW_stat_in_stat_seq429);
					stat();
					state._fsp--;

					}
					break;

				default :
					break loop12;
				}
			}
			} finally {dbg.exitSubRule(12);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(95, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat_seq");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat_seq"



	// $ANTLR start "stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | opt_prefix ID LPAREN expr_list RPAREN SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block_list SEMI );
	public final void stat() throws  {
		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(97, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | opt_prefix ID LPAREN expr_list RPAREN SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block_list SEMI )
			int alt14=7;
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
				alt14=4;
				}
				break;
			case BREAK_KEY:
				{
				alt14=5;
				}
				break;
			case RETURN_KEY:
				{
				alt14=6;
				}
				break;
			case BEGIN_KEY:
				{
				alt14=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					dbg.location(98,4);
					match(input,IF_KEY,FOLLOW_IF_KEY_in_stat442); dbg.location(98,11);
					pushFollow(FOLLOW_expr_in_stat444);
					expr();
					state._fsp--;
					dbg.location(98,16);
					match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat446); dbg.location(98,25);
					pushFollow(FOLLOW_stat_seq_in_stat448);
					stat_seq();
					state._fsp--;
					dbg.location(98,34);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					int alt13=2;
					try { dbg.enterSubRule(13);
					try { dbg.enterDecision(13, decisionCanBacktrack[13]);

					int LA13_0 = input.LA(1);
					if ( (LA13_0==ENDIF_KEY) ) {
						alt13=1;
					}
					else if ( (LA13_0==ELSE_KEY) ) {
						alt13=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 13, 0, input);
						dbg.recognitionException(nvae);
						throw nvae;
					}

					} finally {dbg.exitDecision(13);}

					switch (alt13) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:35: ENDIF_KEY SEMI
							{
							dbg.location(98,35);
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat451); dbg.location(98,45);
							match(input,SEMI,FOLLOW_SEMI_in_stat453); 
							}
							break;
						case 2 :
							dbg.enterAlt(2);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							dbg.location(98,50);
							match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat455); dbg.location(98,59);
							pushFollow(FOLLOW_stat_seq_in_stat457);
							stat_seq();
							state._fsp--;
							dbg.location(98,68);
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat459); dbg.location(98,78);
							match(input,SEMI,FOLLOW_SEMI_in_stat461); 
							}
							break;

					}
					} finally {dbg.exitSubRule(13);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(99,4);
					match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat467); dbg.location(99,14);
					pushFollow(FOLLOW_expr_in_stat469);
					expr();
					state._fsp--;
					dbg.location(99,19);
					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat471); dbg.location(99,26);
					pushFollow(FOLLOW_stat_seq_in_stat473);
					stat_seq();
					state._fsp--;
					dbg.location(99,35);
					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat475); dbg.location(99,45);
					match(input,SEMI,FOLLOW_SEMI_in_stat477); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:100:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					dbg.location(100,4);
					match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat482); dbg.location(100,12);
					match(input,ID,FOLLOW_ID_in_stat484); dbg.location(100,15);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_stat486); dbg.location(100,22);
					pushFollow(FOLLOW_index_expr_in_stat488);
					index_expr();
					state._fsp--;
					dbg.location(100,33);
					match(input,TO_KEY,FOLLOW_TO_KEY_in_stat490); dbg.location(100,40);
					pushFollow(FOLLOW_index_expr_in_stat492);
					index_expr();
					state._fsp--;
					dbg.location(100,51);
					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat494); dbg.location(100,58);
					pushFollow(FOLLOW_stat_seq_in_stat496);
					stat_seq();
					state._fsp--;
					dbg.location(100,67);
					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat498); dbg.location(100,77);
					match(input,SEMI,FOLLOW_SEMI_in_stat500); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:101:4: opt_prefix ID LPAREN expr_list RPAREN SEMI
					{
					dbg.location(101,4);
					pushFollow(FOLLOW_opt_prefix_in_stat505);
					opt_prefix();
					state._fsp--;
					dbg.location(101,15);
					match(input,ID,FOLLOW_ID_in_stat507); dbg.location(101,18);
					match(input,LPAREN,FOLLOW_LPAREN_in_stat509); dbg.location(101,25);
					pushFollow(FOLLOW_expr_list_in_stat511);
					expr_list();
					state._fsp--;
					dbg.location(101,35);
					match(input,RPAREN,FOLLOW_RPAREN_in_stat513); dbg.location(101,42);
					match(input,SEMI,FOLLOW_SEMI_in_stat515); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:102:4: BREAK_KEY SEMI
					{
					dbg.location(102,4);
					match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat520); dbg.location(102,14);
					match(input,SEMI,FOLLOW_SEMI_in_stat522); 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:103:4: RETURN_KEY expr SEMI
					{
					dbg.location(103,4);
					match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat527); dbg.location(103,15);
					pushFollow(FOLLOW_expr_in_stat529);
					expr();
					state._fsp--;
					dbg.location(103,20);
					match(input,SEMI,FOLLOW_SEMI_in_stat531); 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:104:4: block_list SEMI
					{
					dbg.location(104,4);
					pushFollow(FOLLOW_block_list_in_stat536);
					block_list();
					state._fsp--;
					dbg.location(104,15);
					match(input,SEMI,FOLLOW_SEMI_in_stat538); 
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
		dbg.location(105, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat"



	// $ANTLR start "opt_prefix"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:107:1: opt_prefix : ( value ASSIGN |);
	public final void opt_prefix() throws  {
		try { dbg.enterRule(getGrammarFileName(), "opt_prefix");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(107, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:2: ( value ASSIGN |)
			int alt15=2;
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			int LA15_0 = input.LA(1);
			if ( (LA15_0==ID) ) {
				int LA15_1 = input.LA(2);
				if ( (LA15_1==LPAREN) ) {
					alt15=2;
				}
				else if ( (LA15_1==ASSIGN||LA15_1==LBRACK) ) {
					alt15=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:4: value ASSIGN
					{
					dbg.location(108,4);
					pushFollow(FOLLOW_value_in_opt_prefix550);
					value();
					state._fsp--;
					dbg.location(108,10);
					match(input,ASSIGN,FOLLOW_ASSIGN_in_opt_prefix552); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:2: 
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
		dbg.location(110, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "opt_prefix");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "opt_prefix"



	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:1: expr : ( const | value | LPAREN expr RPAREN ) ( binary_operator expr )? ;
	public final void expr() throws  {
		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(112, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:7: ( ( const | value | LPAREN expr RPAREN ) ( binary_operator expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:9: ( const | value | LPAREN expr RPAREN ) ( binary_operator expr )?
			{
			dbg.location(112,9);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:9: ( const | value | LPAREN expr RPAREN )
			int alt16=3;
			try { dbg.enterSubRule(16);
			try { dbg.enterDecision(16, decisionCanBacktrack[16]);

			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt16=1;
				}
				break;
			case ID:
				{
				alt16=2;
				}
				break;
			case LPAREN:
				{
				alt16=3;
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:10: const
					{
					dbg.location(112,10);
					pushFollow(FOLLOW_const_in_expr570);
					const();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:18: value
					{
					dbg.location(112,18);
					pushFollow(FOLLOW_value_in_expr574);
					value();
					state._fsp--;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:26: LPAREN expr RPAREN
					{
					dbg.location(112,26);
					match(input,LPAREN,FOLLOW_LPAREN_in_expr578); dbg.location(112,33);
					pushFollow(FOLLOW_expr_in_expr580);
					expr();
					state._fsp--;
					dbg.location(112,38);
					match(input,RPAREN,FOLLOW_RPAREN_in_expr582); 
					}
					break;

			}
			} finally {dbg.exitSubRule(16);}
			dbg.location(112,46);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:46: ( binary_operator expr )?
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:112:47: binary_operator expr
					{
					dbg.location(112,47);
					pushFollow(FOLLOW_binary_operator_in_expr586);
					binary_operator();
					state._fsp--;
					dbg.location(112,63);
					pushFollow(FOLLOW_expr_in_expr588);
					expr();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(17);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(113, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr"



	// $ANTLR start "const"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:115:1: const : ( INTLIT | FIXEDPTLIT );
	public final void const() throws  {
		try { dbg.enterRule(getGrammarFileName(), "const");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(115, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:115:8: ( INTLIT | FIXEDPTLIT )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(115,8);
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
		dbg.location(117, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "const");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "const"



	// $ANTLR start "binary_operator"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:126:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final void binary_operator() throws  {
		try { dbg.enterRule(getGrammarFileName(), "binary_operator");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(126, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(127,2);
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
		dbg.location(128, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "binary_operator");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "binary_operator"



	// $ANTLR start "expr_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:1: expr_list : (| expr expr_list_tail );
	public final void expr_list() throws  {
		try { dbg.enterRule(getGrammarFileName(), "expr_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(130, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:131:2: (| expr expr_list_tail )
			int alt18=2;
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

			int LA18_0 = input.LA(1);
			if ( (LA18_0==RPAREN) ) {
				alt18=1;
			}
			else if ( (LA18_0==FIXEDPTLIT||LA18_0==ID||LA18_0==INTLIT||LA18_0==LPAREN) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:132:2: 
					{
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:132:4: expr expr_list_tail
					{
					dbg.location(132,4);
					pushFollow(FOLLOW_expr_in_expr_list716);
					expr();
					state._fsp--;
					dbg.location(132,9);
					pushFollow(FOLLOW_expr_list_tail_in_expr_list718);
					expr_list_tail();
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
		dbg.location(133, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr_list"



	// $ANTLR start "expr_list_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:1: expr_list_tail : ( COMMA expr expr_list_tail |);
	public final void expr_list_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "expr_list_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(135, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:2: ( COMMA expr expr_list_tail |)
			int alt19=2;
			try { dbg.enterDecision(19, decisionCanBacktrack[19]);

			int LA19_0 = input.LA(1);
			if ( (LA19_0==COMMA) ) {
				alt19=1;
			}
			else if ( (LA19_0==RPAREN) ) {
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

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:136:4: COMMA expr expr_list_tail
					{
					dbg.location(136,4);
					match(input,COMMA,FOLLOW_COMMA_in_expr_list_tail729); dbg.location(136,10);
					pushFollow(FOLLOW_expr_in_expr_list_tail731);
					expr();
					state._fsp--;
					dbg.location(136,15);
					pushFollow(FOLLOW_expr_list_tail_in_expr_list_tail733);
					expr_list_tail();
					state._fsp--;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:2: 
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
		dbg.location(138, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr_list_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expr_list_tail"



	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:1: value : ID value_tail ;
	public final void value() throws  {
		try { dbg.enterRule(getGrammarFileName(), "value");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(140, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:8: ( ID value_tail )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:10: ID value_tail
			{
			dbg.location(140,10);
			match(input,ID,FOLLOW_ID_in_value748); dbg.location(140,13);
			pushFollow(FOLLOW_value_tail_in_value750);
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
		dbg.location(140, 22);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "value"



	// $ANTLR start "value_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:141:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |);
	public final void value_tail() throws  {
		try { dbg.enterRule(getGrammarFileName(), "value_tail");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(141, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:2: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |)
			int alt21=2;
			try { dbg.enterDecision(21, decisionCanBacktrack[21]);

			int LA21_0 = input.LA(1);
			if ( (LA21_0==LBRACK) ) {
				alt21=1;
			}
			else if ( (LA21_0==AND||LA21_0==ASSIGN||LA21_0==COMMA||(LA21_0 >= DIV && LA21_0 <= DO_KEY)||LA21_0==EQ||(LA21_0 >= GREATER && LA21_0 <= GREATEREQ)||(LA21_0 >= LESSER && LA21_0 <= LESSEREQ)||(LA21_0 >= MINUS && LA21_0 <= NEQ)||(LA21_0 >= OR && LA21_0 <= PLUS)||(LA21_0 >= RPAREN && LA21_0 <= THEN_KEY)) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(21);}

			switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:4: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					dbg.location(142,4);
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail759); dbg.location(142,11);
					pushFollow(FOLLOW_index_expr_in_value_tail761);
					index_expr();
					state._fsp--;
					dbg.location(142,22);
					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail763); dbg.location(142,29);
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:29: ( LBRACK index_expr RBRACK )?
					int alt20=2;
					try { dbg.enterSubRule(20);
					try { dbg.enterDecision(20, decisionCanBacktrack[20]);

					int LA20_0 = input.LA(1);
					if ( (LA20_0==LBRACK) ) {
						alt20=1;
					}
					} finally {dbg.exitDecision(20);}

					switch (alt20) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:30: LBRACK index_expr RBRACK
							{
							dbg.location(142,30);
							match(input,LBRACK,FOLLOW_LBRACK_in_value_tail766); dbg.location(142,37);
							pushFollow(FOLLOW_index_expr_in_value_tail768);
							index_expr();
							state._fsp--;
							dbg.location(142,48);
							match(input,RBRACK,FOLLOW_RBRACK_in_value_tail770); 
							}
							break;

					}
					} finally {dbg.exitSubRule(20);}

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:2: 
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
		dbg.location(144, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "value_tail");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "value_tail"



	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:1: index_expr : ( INTLIT | ID ) ( index_oper index_expr )? ;
	public final void index_expr() throws  {
		try { dbg.enterRule(getGrammarFileName(), "index_expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(146, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:2: ( ( INTLIT | ID ) ( index_oper index_expr )? )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:4: ( INTLIT | ID ) ( index_oper index_expr )?
			{
			dbg.location(147,4);
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}dbg.location(147,18);
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:18: ( index_oper index_expr )?
			int alt22=2;
			try { dbg.enterSubRule(22);
			try { dbg.enterDecision(22, decisionCanBacktrack[22]);

			int LA22_0 = input.LA(1);
			if ( ((LA22_0 >= MINUS && LA22_0 <= MULT)||LA22_0==PLUS) ) {
				alt22=1;
			}
			} finally {dbg.exitDecision(22);}

			switch (alt22) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:19: index_oper index_expr
					{
					dbg.location(147,19);
					pushFollow(FOLLOW_index_oper_in_index_expr798);
					index_oper();
					state._fsp--;
					dbg.location(147,30);
					pushFollow(FOLLOW_index_expr_in_index_expr800);
					index_expr();
					state._fsp--;

					}
					break;

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
		dbg.location(148, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "index_expr"



	// $ANTLR start "index_oper"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final void index_oper() throws  {
		try { dbg.enterRule(getGrammarFileName(), "index_oper");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(150, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:2: ( ( PLUS | MINUS | MULT ) )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(151,2);
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
		dbg.location(152, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "index_oper");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "index_oper"



	// $ANTLR start "keywords"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final void keywords() throws  {
		try { dbg.enterRule(getGrammarFileName(), "keywords");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(158, 0);

		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:159:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			dbg.enterAlt(1);

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			dbg.location(159,2);
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
		dbg.location(182, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "keywords");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "keywords"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program11 = new BitSet(new long[]{0x0002000022100000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program13 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_main_function_in_tiger_program15 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list31 = new BitSet(new long[]{0x0002000022100000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_funct_declaration_list33 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration44 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration46 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration48 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration50 = new BitSet(new long[]{0x0000080002000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration52 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration54 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration56 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration58 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration60 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_main_function74 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function76 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function78 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function80 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_main_function82 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function84 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_END_KEY_in_main_function86 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list121 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_param_list_tail_in_param_list123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_param_list_tail139 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_param_in_param_list_tail141 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_param_list_tail_in_param_list_tail143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_param154 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_param156 = new BitSet(new long[]{0x0000000022100000L});
	public static final BitSet FOLLOW_type_id_in_param158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list168 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail182 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block199 = new BitSet(new long[]{0x0001800000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block201 = new BitSet(new long[]{0x000404000A220180L});
	public static final BitSet FOLLOW_stat_seq_in_block203 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_END_KEY_in_block205 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_block207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement217 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list236 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_type_declaration_list_in_type_declaration_list238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list255 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_var_declaration_list257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration269 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration271 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration273 = new BitSet(new long[]{0x0000000020100020L});
	public static final BitSet FOLLOW_type_in_type_declaration275 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type293 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LBRACK_in_type295 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_INTLIT_in_type297 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type299 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type301 = new BitSet(new long[]{0x0000000020100000L});
	public static final BitSet FOLLOW_base_type_in_type303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type308 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LBRACK_in_type310 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_INTLIT_in_type312 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type314 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_LBRACK_in_type316 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_INTLIT_in_type318 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type320 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type322 = new BitSet(new long[]{0x0000000020100000L});
	public static final BitSet FOLLOW_base_type_in_type324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration367 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration369 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_var_declaration371 = new BitSet(new long[]{0x0000000022100000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration373 = new BitSet(new long[]{0x0000100000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration375 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list392 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COMMA_in_id_list394 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_id_list_in_id_list396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init415 = new BitSet(new long[]{0x0000000010080000L});
	public static final BitSet FOLLOW_const_in_optional_init417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq429 = new BitSet(new long[]{0x000404000A200182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat442 = new BitSet(new long[]{0x0000000212080000L});
	public static final BitSet FOLLOW_expr_in_stat444 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat446 = new BitSet(new long[]{0x000404000A214180L});
	public static final BitSet FOLLOW_stat_seq_in_stat448 = new BitSet(new long[]{0x0000000000014000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat451 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat455 = new BitSet(new long[]{0x000404000A210180L});
	public static final BitSet FOLLOW_stat_seq_in_stat457 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat459 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat467 = new BitSet(new long[]{0x0000000212080000L});
	public static final BitSet FOLLOW_expr_in_stat469 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat471 = new BitSet(new long[]{0x000404000A208180L});
	public static final BitSet FOLLOW_stat_seq_in_stat473 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat475 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat482 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_stat484 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat486 = new BitSet(new long[]{0x0000000012000000L});
	public static final BitSet FOLLOW_index_expr_in_stat488 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat490 = new BitSet(new long[]{0x0000000012000000L});
	public static final BitSet FOLLOW_index_expr_in_stat492 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat494 = new BitSet(new long[]{0x000404000A208180L});
	public static final BitSet FOLLOW_stat_seq_in_stat496 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat498 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_opt_prefix_in_stat505 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_stat507 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_LPAREN_in_stat509 = new BitSet(new long[]{0x0000080212080000L});
	public static final BitSet FOLLOW_expr_list_in_stat511 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RPAREN_in_stat513 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat520 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat527 = new BitSet(new long[]{0x0000000212080000L});
	public static final BitSet FOLLOW_expr_in_stat529 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat531 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_list_in_stat536 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_opt_prefix550 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_opt_prefix552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_const_in_expr570 = new BitSet(new long[]{0x000001B981841012L});
	public static final BitSet FOLLOW_value_in_expr574 = new BitSet(new long[]{0x000001B981841012L});
	public static final BitSet FOLLOW_LPAREN_in_expr578 = new BitSet(new long[]{0x0000000212080000L});
	public static final BitSet FOLLOW_expr_in_expr580 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr582 = new BitSet(new long[]{0x000001B981841012L});
	public static final BitSet FOLLOW_binary_operator_in_expr586 = new BitSet(new long[]{0x0000000212080000L});
	public static final BitSet FOLLOW_expr_in_expr588 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list716 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_expr_list_tail_in_expr_list718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_expr_list_tail729 = new BitSet(new long[]{0x0000000212080000L});
	public static final BitSet FOLLOW_expr_in_expr_list_tail731 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_expr_list_tail_in_expr_list_tail733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_value748 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_value_tail_in_value750 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail759 = new BitSet(new long[]{0x0000000012000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail761 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail763 = new BitSet(new long[]{0x0000000040000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail766 = new BitSet(new long[]{0x0000000012000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail768 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr789 = new BitSet(new long[]{0x0000011800000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr798 = new BitSet(new long[]{0x0000000012000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr800 = new BitSet(new long[]{0x0000000000000002L});
}
