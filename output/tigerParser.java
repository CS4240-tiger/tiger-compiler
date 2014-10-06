// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-05 23:23:58

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class tigerParser extends Parser {
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


	public tigerParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public tigerParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return tigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g"; }



	// $ANTLR start "tiger_program"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:8:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final void tiger_program() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:2: ( type_declaration_list funct_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:4: type_declaration_list funct_declaration_list
			{
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program42);
			type_declaration_list();
			state._fsp--;

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
	}
	// $ANTLR end "tiger_program"



	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:12:1: funct_declaration_list : ( funct_declaration )* ;
	public final void funct_declaration_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:2: ( ( funct_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: ( funct_declaration )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: ( funct_declaration )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY||LA1_0==VOID_KEY) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list56);
					funct_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
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
	}
	// $ANTLR end "funct_declaration_list"



	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:16:1: funct_declaration : ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI ;
	public final void funct_declaration() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:2: ( ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) )
			int alt3=2;
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
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:5: ( type_id funct_declaration_tail )
					{
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:5: ( type_id funct_declaration_tail )
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:6: type_id funct_declaration_tail
					{
					pushFollow(FOLLOW_type_id_in_funct_declaration70);
					type_id();
					state._fsp--;

					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration72);
					funct_declaration_tail();
					state._fsp--;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					{
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:41: VOID_KEY ( funct_declaration_tail | main_function_tail )
					{
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_funct_declaration78); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:50: ( funct_declaration_tail | main_function_tail )
					int alt2=2;
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
						throw nvae;
					}

					switch (alt2) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:51: funct_declaration_tail
							{
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration81);
							funct_declaration_tail();
							state._fsp--;

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:76: main_function_tail
							{
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration85);
							main_function_tail();
							state._fsp--;

							}
							break;

					}

					}

					}
					break;

			}

			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration90); 
			pushFollow(FOLLOW_block_list_in_funct_declaration92);
			block_list();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration94); 
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration96); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "funct_declaration"



	// $ANTLR start "funct_declaration_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:20:1: funct_declaration_tail : FUNCTION_KEY ID LPAREN param_list RPAREN ;
	public final void funct_declaration_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:3: ( FUNCTION_KEY ID LPAREN param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:5: FUNCTION_KEY ID LPAREN param_list RPAREN
			{
			match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration_tail108); 
			match(input,ID,FOLLOW_ID_in_funct_declaration_tail110); 
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail112); 
			pushFollow(FOLLOW_param_list_in_funct_declaration_tail114);
			param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail116); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "funct_declaration_tail"



	// $ANTLR start "main_function_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:24:1: main_function_tail : MAIN_KEY LPAREN RPAREN ;
	public final void main_function_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:25:2: ( MAIN_KEY LPAREN RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:25:4: MAIN_KEY LPAREN RPAREN
			{
			match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function_tail128); 
			match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail130); 
			match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail132); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "main_function_tail"



	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:28:1: ret_type : ( VOID_KEY | type_id );
	public final void ret_type() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:29:2: ( VOID_KEY | type_id )
			int alt4=2;
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
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:29:4: VOID_KEY
					{
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type144); 
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:30:4: type_id
					{
					pushFollow(FOLLOW_type_id_in_ret_type149);
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
	}
	// $ANTLR end "ret_type"



	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:33:1: param_list : ( param ( COMMA_SPACE param )* )? ;
	public final void param_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:2: ( ( param ( COMMA_SPACE param )* )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:4: ( param ( COMMA_SPACE param )* )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:4: ( param ( COMMA_SPACE param )* )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:5: param ( COMMA_SPACE param )*
					{
					pushFollow(FOLLOW_param_in_param_list162);
					param();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:11: ( COMMA_SPACE param )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA_SPACE) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:34:12: COMMA_SPACE param
							{
							match(input,COMMA_SPACE,FOLLOW_COMMA_SPACE_in_param_list165); 
							pushFollow(FOLLOW_param_in_param_list167);
							param();
							state._fsp--;

							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;

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
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:1: param : ID COLON type_id ;
	public final void param() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:8: ( ID COLON type_id )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:10: ID COLON type_id
			{
			match(input,ID,FOLLOW_ID_in_param182); 
			match(input,COLON,FOLLOW_COLON_in_param184); 
			pushFollow(FOLLOW_type_id_in_param186);
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
	}
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:39:1: block_list : block block_tail ;
	public final void block_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:40:2: ( block block_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:40:4: block block_tail
			{
			pushFollow(FOLLOW_block_in_block_list196);
			block();
			state._fsp--;

			pushFollow(FOLLOW_block_tail_in_block_list198);
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
	}
	// $ANTLR end "block_list"



	// $ANTLR start "block_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:43:1: block_tail : ( block block_tail |);
	public final void block_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:44:2: ( block block_tail |)
			int alt7=2;
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
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:44:4: block block_tail
					{
					pushFollow(FOLLOW_block_in_block_tail210);
					block();
					state._fsp--;

					pushFollow(FOLLOW_block_tail_in_block_tail212);
					block_tail();
					state._fsp--;

					}
					break;
				case 2 :
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
	}
	// $ANTLR end "block_tail"



	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:1: block : BEGIN_KEY declaration_statement stat_seq END_KEY SEMI ;
	public final void block() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:8: ( BEGIN_KEY declaration_statement stat_seq END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:10: BEGIN_KEY declaration_statement stat_seq END_KEY SEMI
			{
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block227); 
			pushFollow(FOLLOW_declaration_statement_in_block229);
			declaration_statement();
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_in_block231);
			stat_seq();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_block233); 
			match(input,SEMI,FOLLOW_SEMI_in_block235); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "block"



	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:50:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final void declaration_statement() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:51:2: ( type_declaration_list var_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:51:4: type_declaration_list var_declaration_list
			{
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement245);
			type_declaration_list();
			state._fsp--;

			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement247);
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
	}
	// $ANTLR end "declaration_statement"



	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:54:1: type_declaration_list : ( type_declaration )* ;
	public final void type_declaration_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:2: ( ( type_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:5: ( type_declaration )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:5: ( type_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TYPE_KEY) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:55:5: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list261);
					type_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
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
	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:58:1: var_declaration_list : ( var_declaration )* ;
	public final void var_declaration_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:2: ( ( var_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: ( var_declaration )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: ( var_declaration )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==VAR_KEY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list275);
					var_declaration();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
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
	}
	// $ANTLR end "var_declaration_list"



	// $ANTLR start "type_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:62:1: type_declaration : TYPE_KEY ID EQ type SEMI ;
	public final void type_declaration() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:2: ( TYPE_KEY ID EQ type SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:4: TYPE_KEY ID EQ type SEMI
			{
			match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration288); 
			match(input,ID,FOLLOW_ID_in_type_declaration290); 
			match(input,EQ,FOLLOW_EQ_in_type_declaration292); 
			pushFollow(FOLLOW_type_in_type_declaration294);
			type();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_type_declaration296); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_declaration"



	// $ANTLR start "type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:1: type : ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type );
	public final void type() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:6: ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type )
			int alt11=2;
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
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:8: base_type
					{
					pushFollow(FOLLOW_base_type_in_type307);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:4: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type
					{
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type312); 
					match(input,LBRACK,FOLLOW_LBRACK_in_type314); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type316); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type318); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:35: ( LBRACK INTLIT RBRACK )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==LBRACK) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:36: LBRACK INTLIT RBRACK
							{
							match(input,LBRACK,FOLLOW_LBRACK_in_type321); 
							match(input,INTLIT,FOLLOW_INTLIT_in_type323); 
							match(input,RBRACK,FOLLOW_RBRACK_in_type325); 
							}
							break;

					}

					match(input,OF_KEY,FOLLOW_OF_KEY_in_type329); 
					pushFollow(FOLLOW_base_type_in_type331);
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
	}
	// $ANTLR end "type"



	// $ANTLR start "type_id"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:70:1: type_id : ( base_type | ID );
	public final void type_id() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:70:9: ( base_type | ID )
			int alt12=2;
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
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:70:11: base_type
					{
					pushFollow(FOLLOW_base_type_in_type_id341);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:4: ID
					{
					match(input,ID,FOLLOW_ID_in_type_id346); 
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
	}
	// $ANTLR end "type_id"



	// $ANTLR start "base_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:74:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final void base_type() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:75:2: ( INT_KEY | FIXEDPT_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			if ( input.LA(1)==FIXEDPT_KEY||input.LA(1)==INT_KEY ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
	}
	// $ANTLR end "base_type"



	// $ANTLR start "var_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:79:1: var_declaration : VAR_KEY id_list COLON type_id optional_init SEMI ;
	public final void var_declaration() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:2: ( VAR_KEY id_list COLON type_id optional_init SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:4: VAR_KEY id_list COLON type_id optional_init SEMI
			{
			match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration374); 
			pushFollow(FOLLOW_id_list_in_var_declaration376);
			id_list();
			state._fsp--;

			match(input,COLON,FOLLOW_COLON_in_var_declaration378); 
			pushFollow(FOLLOW_type_id_in_var_declaration380);
			type_id();
			state._fsp--;

			pushFollow(FOLLOW_optional_init_in_var_declaration382);
			optional_init();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_var_declaration384); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "var_declaration"



	// $ANTLR start "id_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:1: id_list : ID ( ( COMMA | COMMA_SPACE ) id_list )? ;
	public final void id_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:9: ( ID ( ( COMMA | COMMA_SPACE ) id_list )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:11: ID ( ( COMMA | COMMA_SPACE ) id_list )?
			{
			match(input,ID,FOLLOW_ID_in_id_list394); 
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:14: ( ( COMMA | COMMA_SPACE ) id_list )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( ((LA13_0 >= COMMA && LA13_0 <= COMMA_SPACE)) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:15: ( COMMA | COMMA_SPACE ) id_list
					{
					if ( (input.LA(1) >= COMMA && input.LA(1) <= COMMA_SPACE) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_id_list_in_id_list405);
					id_list();
					state._fsp--;

					}
					break;

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
	}
	// $ANTLR end "id_list"



	// $ANTLR start "optional_init"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:86:1: optional_init : (| ASSIGN expr );
	public final void optional_init() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:87:2: (| ASSIGN expr )
			int alt14=2;
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
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:5: ASSIGN expr
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init426); 
					pushFollow(FOLLOW_expr_in_optional_init428);
					expr();
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
	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:91:1: stat_seq : ( stat )* ;
	public final void stat_seq() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:2: ( ( stat )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:4: ( stat )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:4: ( stat )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= BEGIN_KEY && LA15_0 <= BREAK_KEY)||LA15_0==FOR_KEY||LA15_0==ID||LA15_0==IF_KEY||LA15_0==RETURN_KEY||LA15_0==WHILE_KEY) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:4: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq440);
					stat();
					state._fsp--;

					}
					break;

				default :
					break loop15;
				}
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
	}
	// $ANTLR end "stat_seq"



	// $ANTLR start "stat"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:95:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block );
	public final void stat() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block )
			int alt18=7;
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
				throw nvae;
			}
			switch (alt18) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					match(input,IF_KEY,FOLLOW_IF_KEY_in_stat453); 
					pushFollow(FOLLOW_expr_in_stat455);
					expr();
					state._fsp--;

					match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat457); 
					pushFollow(FOLLOW_stat_seq_in_stat459);
					stat_seq();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					int alt16=2;
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
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:35: ENDIF_KEY SEMI
							{
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat462); 
							match(input,SEMI,FOLLOW_SEMI_in_stat464); 
							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat466); 
							pushFollow(FOLLOW_stat_seq_in_stat468);
							stat_seq();
							state._fsp--;

							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat470); 
							match(input,SEMI,FOLLOW_SEMI_in_stat472); 
							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat478); 
					pushFollow(FOLLOW_expr_in_stat480);
					expr();
					state._fsp--;

					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat482); 
					pushFollow(FOLLOW_stat_seq_in_stat484);
					stat_seq();
					state._fsp--;

					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat486); 
					match(input,SEMI,FOLLOW_SEMI_in_stat488); 
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat493); 
					match(input,ID,FOLLOW_ID_in_stat495); 
					match(input,ASSIGN,FOLLOW_ASSIGN_in_stat497); 
					pushFollow(FOLLOW_index_expr_in_stat499);
					index_expr();
					state._fsp--;

					match(input,TO_KEY,FOLLOW_TO_KEY_in_stat501); 
					pushFollow(FOLLOW_index_expr_in_stat503);
					index_expr();
					state._fsp--;

					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat505); 
					pushFollow(FOLLOW_stat_seq_in_stat507);
					stat_seq();
					state._fsp--;

					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat509); 
					match(input,SEMI,FOLLOW_SEMI_in_stat511); 
					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:6: ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI
					{
					match(input,ID,FOLLOW_ID_in_stat518); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:9: ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) )
					int alt17=2;
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
						throw nvae;
					}

					switch (alt17) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:10: ( value_tail ASSIGN expr_list )
							{
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:10: ( value_tail ASSIGN expr_list )
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:11: value_tail ASSIGN expr_list
							{
							pushFollow(FOLLOW_value_tail_in_stat522);
							value_tail();
							state._fsp--;

							match(input,ASSIGN,FOLLOW_ASSIGN_in_stat524); 
							pushFollow(FOLLOW_expr_list_in_stat526);
							expr_list();
							state._fsp--;

							}

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:42: ( func_call_tail )
							{
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:42: ( func_call_tail )
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:43: func_call_tail
							{
							pushFollow(FOLLOW_func_call_tail_in_stat532);
							func_call_tail();
							state._fsp--;

							}

							}
							break;

					}

					match(input,SEMI,FOLLOW_SEMI_in_stat536); 
					}
					break;
				case 5 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:100:4: BREAK_KEY SEMI
					{
					match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat541); 
					match(input,SEMI,FOLLOW_SEMI_in_stat543); 
					}
					break;
				case 6 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:101:4: RETURN_KEY expr SEMI
					{
					match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat548); 
					pushFollow(FOLLOW_expr_in_stat550);
					expr();
					state._fsp--;

					match(input,SEMI,FOLLOW_SEMI_in_stat552); 
					}
					break;
				case 7 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:102:4: block
					{
					pushFollow(FOLLOW_block_in_stat557);
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
	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )? ;
	public final void expr() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binary_operator expr )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN )
			int alt20=3;
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
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:10: constval
					{
					pushFollow(FOLLOW_constval_in_expr571);
					constval();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:21: ID ( value_tail | func_call_tail )
					{
					match(input,ID,FOLLOW_ID_in_expr575); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:24: ( value_tail | func_call_tail )
					int alt19=2;
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
						throw nvae;
					}

					switch (alt19) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:25: value_tail
							{
							pushFollow(FOLLOW_value_tail_in_expr578);
							value_tail();
							state._fsp--;

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:36: func_call_tail
							{
							pushFollow(FOLLOW_func_call_tail_in_expr580);
							func_call_tail();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:54: LPAREN expr RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_expr585); 
					pushFollow(FOLLOW_expr_in_expr587);
					expr();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_expr589); 
					}
					break;

			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:74: ( binary_operator expr )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==AND||LA21_0==DIV||LA21_0==EQ||(LA21_0 >= GREATER && LA21_0 <= GREATEREQ)||(LA21_0 >= LESSER && LA21_0 <= LESSEREQ)||(LA21_0 >= MINUS && LA21_0 <= NEQ)||(LA21_0 >= OR && LA21_0 <= PLUS)) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:75: binary_operator expr
					{
					pushFollow(FOLLOW_binary_operator_in_expr593);
					binary_operator();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr595);
					expr();
					state._fsp--;

					}
					break;

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
	}
	// $ANTLR end "expr"



	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:1: constval : ( INTLIT | FIXEDPTLIT );
	public final void constval() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:9: ( INTLIT | FIXEDPTLIT )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			if ( input.LA(1)==FIXEDPTLIT||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
	}
	// $ANTLR end "constval"



	// $ANTLR start "binary_operator"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:119:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final void binary_operator() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:120:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			if ( input.LA(1)==AND||input.LA(1)==DIV||input.LA(1)==EQ||(input.LA(1) >= GREATER && input.LA(1) <= GREATEREQ)||(input.LA(1) >= LESSER && input.LA(1) <= LESSEREQ)||(input.LA(1) >= MINUS && input.LA(1) <= NEQ)||(input.LA(1) >= OR && input.LA(1) <= PLUS) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
	}
	// $ANTLR end "binary_operator"



	// $ANTLR start "expr_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:123:1: expr_list : expr ( COMMA expr )* ;
	public final void expr_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:2: ( expr ( COMMA expr )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:4: expr ( COMMA expr )*
			{
			pushFollow(FOLLOW_expr_in_expr_list720);
			expr();
			state._fsp--;

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:9: ( COMMA expr )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==COMMA) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:124:10: COMMA expr
					{
					match(input,COMMA,FOLLOW_COMMA_in_expr_list723); 
					pushFollow(FOLLOW_expr_in_expr_list725);
					expr();
					state._fsp--;

					}
					break;

				default :
					break loop22;
				}
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
	}
	// $ANTLR end "expr_list"



	// $ANTLR start "value"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:1: value : ID value_tail ;
	public final void value() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:8: ( ID value_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:127:10: ID value_tail
			{
			match(input,ID,FOLLOW_ID_in_value738); 
			pushFollow(FOLLOW_value_tail_in_value740);
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
	}
	// $ANTLR end "value"



	// $ANTLR start "value_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:128:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |);
	public final void value_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:2: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |)
			int alt24=2;
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
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:4: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail749); 
					pushFollow(FOLLOW_index_expr_in_value_tail751);
					index_expr();
					state._fsp--;

					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail753); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:29: ( LBRACK index_expr RBRACK )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==LBRACK) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:30: LBRACK index_expr RBRACK
							{
							match(input,LBRACK,FOLLOW_LBRACK_in_value_tail756); 
							pushFollow(FOLLOW_index_expr_in_value_tail758);
							index_expr();
							state._fsp--;

							match(input,RBRACK,FOLLOW_RBRACK_in_value_tail760); 
							}
							break;

					}

					}
					break;
				case 2 :
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
	}
	// $ANTLR end "value_tail"



	// $ANTLR start "index_expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:1: index_expr : ( INTLIT | ID ) ( index_oper index_expr )? ;
	public final void index_expr() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:2: ( ( INTLIT | ID ) ( index_oper index_expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:4: ( INTLIT | ID ) ( index_oper index_expr )?
			{
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:18: ( index_oper index_expr )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( ((LA25_0 >= MINUS && LA25_0 <= MULT)||LA25_0==PLUS) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:19: index_oper index_expr
					{
					pushFollow(FOLLOW_index_oper_in_index_expr788);
					index_oper();
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr790);
					index_expr();
					state._fsp--;

					}
					break;

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
	}
	// $ANTLR end "index_expr"



	// $ANTLR start "index_oper"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:137:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final void index_oper() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:2: ( ( PLUS | MINUS | MULT ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			if ( (input.LA(1) >= MINUS && input.LA(1) <= MULT)||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
	}
	// $ANTLR end "index_oper"



	// $ANTLR start "func_call_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:145:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final void func_call_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:3: ( LPAREN func_param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:5: LPAREN func_param_list RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail862); 
			pushFollow(FOLLOW_func_param_list_in_func_call_tail864);
			func_param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail866); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "func_call_tail"



	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:149:1: func_param_list : ( expr ( COMMA_SPACE expr )* |);
	public final void func_param_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:3: ( expr ( COMMA_SPACE expr )* |)
			int alt27=2;
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
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:5: expr ( COMMA_SPACE expr )*
					{
					pushFollow(FOLLOW_expr_in_func_param_list881);
					expr();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:10: ( COMMA_SPACE expr )*
					loop26:
					while (true) {
						int alt26=2;
						int LA26_0 = input.LA(1);
						if ( (LA26_0==COMMA_SPACE) ) {
							alt26=1;
						}

						switch (alt26) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:11: COMMA_SPACE expr
							{
							match(input,COMMA_SPACE,FOLLOW_COMMA_SPACE_in_func_param_list884); 
							pushFollow(FOLLOW_expr_in_func_param_list886);
							expr();
							state._fsp--;

							}
							break;

						default :
							break loop26;
						}
					}

					}
					break;
				case 2 :
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
	}
	// $ANTLR end "func_param_list"



	// $ANTLR start "keywords"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final void keywords() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			if ( input.LA(1)==ARRAY_KEY||(input.LA(1) >= BEGIN_KEY && input.LA(1) <= BREAK_KEY)||(input.LA(1) >= DO_KEY && input.LA(1) <= END_KEY)||(input.LA(1) >= FIXEDPT_KEY && input.LA(1) <= FUNCTION_KEY)||(input.LA(1) >= ID_KEY && input.LA(1) <= IF_KEY)||input.LA(1)==INT_KEY||input.LA(1)==MAIN_KEY||input.LA(1)==OF_KEY||input.LA(1)==RETURN_KEY||(input.LA(1) >= THEN_KEY && input.LA(1) <= WHILE_KEY) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
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
	}
	// $ANTLR end "keywords"

	// Delegated rules



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program42 = new BitSet(new long[]{0x0004000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list56 = new BitSet(new long[]{0x0004000044200002L});
	public static final BitSet FOLLOW_type_id_in_funct_declaration70 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration72 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_VOID_KEY_in_funct_declaration78 = new BitSet(new long[]{0x0000000800800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration81 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration85 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration90 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration92 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration94 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration_tail108 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail110 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail112 = new BitSet(new long[]{0x0000100004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail114 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function_tail128 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail130 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list162 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_SPACE_in_param_list165 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list167 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_param182 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_param184 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param186 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list196 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail210 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block227 = new BitSet(new long[]{0x0003000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block229 = new BitSet(new long[]{0x0008080014440180L});
	public static final BitSet FOLLOW_stat_seq_in_block231 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block233 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_block235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement245 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list261 = new BitSet(new long[]{0x0001000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list275 = new BitSet(new long[]{0x0002000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration288 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration290 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration292 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration294 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type312 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type314 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type316 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type318 = new BitSet(new long[]{0x0000008080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type321 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type323 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type325 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type329 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration374 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration376 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_var_declaration378 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration380 = new BitSet(new long[]{0x0000200000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration382 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list394 = new BitSet(new long[]{0x0000000000000C02L});
	public static final BitSet FOLLOW_set_in_id_list397 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init426 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_optional_init428 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq440 = new BitSet(new long[]{0x0008080014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat453 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat455 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat457 = new BitSet(new long[]{0x0008080014428180L});
	public static final BitSet FOLLOW_stat_seq_in_stat459 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat462 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat466 = new BitSet(new long[]{0x0008080014420180L});
	public static final BitSet FOLLOW_stat_seq_in_stat468 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat470 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat478 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat480 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat482 = new BitSet(new long[]{0x0008080014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat484 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat486 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat493 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat495 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat497 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat499 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat501 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat503 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat505 = new BitSet(new long[]{0x0008080014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat507 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat509 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat511 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat518 = new BitSet(new long[]{0x0000000480000040L});
	public static final BitSet FOLLOW_value_tail_in_stat522 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat524 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat526 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_func_call_tail_in_stat532 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat541 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat548 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat550 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr571 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_ID_in_expr575 = new BitSet(new long[]{0x0000037783082010L});
	public static final BitSet FOLLOW_value_tail_in_expr578 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr580 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr585 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr587 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr589 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_binary_operator_in_expr593 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list720 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_expr_list723 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list725 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ID_in_value738 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value740 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail749 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail751 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail753 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail756 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail758 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr779 = new BitSet(new long[]{0x0000023000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr788 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail862 = new BitSet(new long[]{0x0000100424100000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail864 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list881 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_SPACE_in_func_param_list884 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_func_param_list886 = new BitSet(new long[]{0x0000000000000802L});
}
