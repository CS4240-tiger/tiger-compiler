// $ANTLR 3.5 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-03 12:29:02

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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:3:1: tiger_program : type_declaration_list funct_declaration_list main_function ;
	public final void tiger_program() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:4:2: ( type_declaration_list funct_declaration_list main_function )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:4:4: type_declaration_list funct_declaration_list main_function
			{
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program11);
			type_declaration_list();
			state._fsp--;

			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program13);
			funct_declaration_list();
			state._fsp--;

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
	}
	// $ANTLR end "tiger_program"



	// $ANTLR start "funct_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:7:1: funct_declaration_list : (| funct_declaration funct_declaration_list );
	public final void funct_declaration_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:8:2: (| funct_declaration funct_declaration_list )
			int alt1=2;
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
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:9:4: funct_declaration funct_declaration_list
					{
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list31);
					funct_declaration();
					state._fsp--;

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
	}
	// $ANTLR end "funct_declaration_list"



	// $ANTLR start "funct_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:12:1: funct_declaration : ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI ;
	public final void funct_declaration() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:2: ( ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:13:4: ret_type FUNCTION_KEY ID LPAREN param_list RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			pushFollow(FOLLOW_ret_type_in_funct_declaration44);
			ret_type();
			state._fsp--;

			match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration46); 
			match(input,ID,FOLLOW_ID_in_funct_declaration48); 
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration50); 
			pushFollow(FOLLOW_param_list_in_funct_declaration52);
			param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration54); 
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration56); 
			pushFollow(FOLLOW_block_list_in_funct_declaration58);
			block_list();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration60); 
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
	}
	// $ANTLR end "funct_declaration"



	// $ANTLR start "main_function"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:16:1: main_function : VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI ;
	public final void main_function() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:2: ( VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:17:4: VOID_KEY MAIN_KEY LPAREN RPAREN BEGIN_KEY block_list END_KEY SEMI
			{
			match(input,VOID_KEY,FOLLOW_VOID_KEY_in_main_function74); 
			match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function76); 
			match(input,LPAREN,FOLLOW_LPAREN_in_main_function78); 
			match(input,RPAREN,FOLLOW_RPAREN_in_main_function80); 
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_main_function82); 
			pushFollow(FOLLOW_block_list_in_main_function84);
			block_list();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_main_function86); 
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
	}
	// $ANTLR end "main_function"



	// $ANTLR start "ret_type"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:20:1: ret_type : ( VOID_KEY | type_id );
	public final void ret_type() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:2: ( VOID_KEY | type_id )
			int alt2=2;
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
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:21:4: VOID_KEY
					{
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type100); 
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:22:4: type_id
					{
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
	}
	// $ANTLR end "ret_type"



	// $ANTLR start "param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:25:1: param_list : (| param param_list_tail );
	public final void param_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:26:2: (| param param_list_tail )
			int alt3=2;
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
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:27:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:27:4: param param_list_tail
					{
					pushFollow(FOLLOW_param_in_param_list121);
					param();
					state._fsp--;

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
	}
	// $ANTLR end "param_list"



	// $ANTLR start "param_list_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:30:1: param_list_tail : (| COMMA param param_list_tail );
	public final void param_list_tail() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:31:2: (| COMMA param param_list_tail )
			int alt4=2;
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
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:32:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:32:4: COMMA param param_list_tail
					{
					match(input,COMMA,FOLLOW_COMMA_in_param_list_tail139); 
					pushFollow(FOLLOW_param_in_param_list_tail141);
					param();
					state._fsp--;

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
	}
	// $ANTLR end "param_list_tail"



	// $ANTLR start "param"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:35:1: param : ID COLON type_id ;
	public final void param() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:35:8: ( ID COLON type_id )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:35:10: ID COLON type_id
			{
			match(input,ID,FOLLOW_ID_in_param154); 
			match(input,COLON,FOLLOW_COLON_in_param156); 
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
	}
	// $ANTLR end "param"



	// $ANTLR start "block_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:37:1: block_list : block block_tail ;
	public final void block_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:38:2: ( block block_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:38:4: block block_tail
			{
			pushFollow(FOLLOW_block_in_block_list168);
			block();
			state._fsp--;

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
	}
	// $ANTLR end "block_list"



	// $ANTLR start "block_tail"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:41:1: block_tail : ( block block_tail |);
	public final void block_tail() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:42:2: ( block block_tail |)
			int alt5=2;
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
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:42:4: block block_tail
					{
					pushFollow(FOLLOW_block_in_block_tail182);
					block();
					state._fsp--;

					pushFollow(FOLLOW_block_tail_in_block_tail184);
					block_tail();
					state._fsp--;

					}
					break;
				case 2 :
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
	}
	// $ANTLR end "block_tail"



	// $ANTLR start "block"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:1: block : BEGIN_KEY declaration_statement stat_seq END_KEY SEMI ;
	public final void block() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:8: ( BEGIN_KEY declaration_statement stat_seq END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:46:10: BEGIN_KEY declaration_statement stat_seq END_KEY SEMI
			{
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block199); 
			pushFollow(FOLLOW_declaration_statement_in_block201);
			declaration_statement();
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_in_block203);
			stat_seq();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_block205); 
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
	}
	// $ANTLR end "block"



	// $ANTLR start "declaration_statement"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:48:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final void declaration_statement() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:49:2: ( type_declaration_list var_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:49:4: type_declaration_list var_declaration_list
			{
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement217);
			type_declaration_list();
			state._fsp--;

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
	}
	// $ANTLR end "declaration_statement"



	// $ANTLR start "type_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:52:1: type_declaration_list : (| type_declaration type_declaration_list );
	public final void type_declaration_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:53:2: (| type_declaration type_declaration_list )
			int alt6=2;
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
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:54:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:54:4: type_declaration type_declaration_list
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list237);
					type_declaration();
					state._fsp--;

					pushFollow(FOLLOW_type_declaration_list_in_type_declaration_list239);
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
	}
	// $ANTLR end "type_declaration_list"



	// $ANTLR start "var_declaration_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:57:1: var_declaration_list : (| var_declaration var_declaration_list );
	public final void var_declaration_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:58:2: (| var_declaration var_declaration_list )
			int alt7=2;
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
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:59:4: var_declaration var_declaration_list
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list256);
					var_declaration();
					state._fsp--;

					pushFollow(FOLLOW_var_declaration_list_in_var_declaration_list258);
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
	}
	// $ANTLR end "var_declaration_list"



	// $ANTLR start "type_declaration"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:62:1: type_declaration : TYPE_KEY ID EQ type SEMI ;
	public final void type_declaration() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:2: ( TYPE_KEY ID EQ type SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:4: TYPE_KEY ID EQ type SEMI
			{
			match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration270); 
			match(input,ID,FOLLOW_ID_in_type_declaration272); 
			match(input,EQ,FOLLOW_EQ_in_type_declaration274); 
			pushFollow(FOLLOW_type_in_type_declaration276);
			type();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_type_declaration278); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:1: type : ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY base_type | ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY base_type );
	public final void type() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:6: ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY base_type | ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY base_type )
			int alt8=3;
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
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:66:8: base_type
					{
					pushFollow(FOLLOW_base_type_in_type289);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:4: ARRAY_KEY LBRACK INTLIT RBRACK OF_KEY base_type
					{
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type294); 
					match(input,LBRACK,FOLLOW_LBRACK_in_type296); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type298); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type300); 
					match(input,OF_KEY,FOLLOW_OF_KEY_in_type302); 
					pushFollow(FOLLOW_base_type_in_type304);
					base_type();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:4: ARRAY_KEY LBRACK INTLIT RBRACK LBRACK INTLIT RBRACK OF_KEY base_type
					{
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type309); 
					match(input,LBRACK,FOLLOW_LBRACK_in_type311); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type313); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type315); 
					match(input,LBRACK,FOLLOW_LBRACK_in_type317); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type319); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type321); 
					match(input,OF_KEY,FOLLOW_OF_KEY_in_type323); 
					pushFollow(FOLLOW_base_type_in_type325);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:1: type_id : ( base_type | ID );
	public final void type_id() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:9: ( base_type | ID )
			int alt9=2;
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
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:11: base_type
					{
					pushFollow(FOLLOW_base_type_in_type_id335);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:4: ID
					{
					match(input,ID,FOLLOW_ID_in_type_id340); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:75:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final void base_type() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:76:2: ( INT_KEY | FIXEDPT_KEY )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:1: var_declaration : VAR_KEY id_list COLON type_id optional_init SEMI ;
	public final void var_declaration() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:81:2: ( VAR_KEY id_list COLON type_id optional_init SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:81:4: VAR_KEY id_list COLON type_id optional_init SEMI
			{
			match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration368); 
			pushFollow(FOLLOW_id_list_in_var_declaration370);
			id_list();
			state._fsp--;

			match(input,COLON,FOLLOW_COLON_in_var_declaration372); 
			pushFollow(FOLLOW_type_id_in_var_declaration374);
			type_id();
			state._fsp--;

			pushFollow(FOLLOW_optional_init_in_var_declaration376);
			optional_init();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_var_declaration378); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:1: id_list : ID ( ( COMMA | COMMA_SPACE ) id_list )? ;
	public final void id_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:9: ( ID ( ( COMMA | COMMA_SPACE ) id_list )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:11: ID ( ( COMMA | COMMA_SPACE ) id_list )?
			{
			match(input,ID,FOLLOW_ID_in_id_list388); 
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:14: ( ( COMMA | COMMA_SPACE ) id_list )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( ((LA10_0 >= COMMA && LA10_0 <= COMMA_SPACE)) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:15: ( COMMA | COMMA_SPACE ) id_list
					{
					if ( (input.LA(1) >= COMMA && input.LA(1) <= COMMA_SPACE) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_id_list_in_id_list399);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:87:1: optional_init : (| ASSIGN constval );
	public final void optional_init() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:2: (| ASSIGN constval )
			int alt11=2;
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
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:5: ASSIGN constval
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init420); 
					pushFollow(FOLLOW_constval_in_optional_init422);
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
	}
	// $ANTLR end "optional_init"



	// $ANTLR start "stat_seq"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:1: stat_seq : ( stat )* ;
	public final void stat_seq() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:2: ( ( stat )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:4: ( stat )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:4: ( stat )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= BEGIN_KEY && LA12_0 <= BREAK_KEY)||LA12_0==FOR_KEY||LA12_0==ID||LA12_0==IF_KEY||LA12_0==RETURN_KEY||LA12_0==WHILE_KEY) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:93:4: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq434);
					stat();
					state._fsp--;

					}
					break;

				default :
					break loop12;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:96:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | opt_prefix expr_list SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | func_call SEMI | block );
	public final void stat() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | opt_prefix expr_list SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | func_call SEMI | block )
			int alt14=8;
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
				if ( (LA14_4==LPAREN) ) {
					alt14=7;
				}
				else if ( (LA14_4==ASSIGN||LA14_4==LBRACK) ) {
					alt14=4;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

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
				alt14=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					match(input,IF_KEY,FOLLOW_IF_KEY_in_stat447); 
					pushFollow(FOLLOW_expr_in_stat449);
					expr();
					state._fsp--;

					match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat451); 
					pushFollow(FOLLOW_stat_seq_in_stat453);
					stat_seq();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					int alt13=2;
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
						throw nvae;
					}

					switch (alt13) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:35: ENDIF_KEY SEMI
							{
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat456); 
							match(input,SEMI,FOLLOW_SEMI_in_stat458); 
							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:97:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat460); 
							pushFollow(FOLLOW_stat_seq_in_stat462);
							stat_seq();
							state._fsp--;

							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat464); 
							match(input,SEMI,FOLLOW_SEMI_in_stat466); 
							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat472); 
					pushFollow(FOLLOW_expr_in_stat474);
					expr();
					state._fsp--;

					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat476); 
					pushFollow(FOLLOW_stat_seq_in_stat478);
					stat_seq();
					state._fsp--;

					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat480); 
					match(input,SEMI,FOLLOW_SEMI_in_stat482); 
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat487); 
					match(input,ID,FOLLOW_ID_in_stat489); 
					match(input,ASSIGN,FOLLOW_ASSIGN_in_stat491); 
					pushFollow(FOLLOW_index_expr_in_stat493);
					index_expr();
					state._fsp--;

					match(input,TO_KEY,FOLLOW_TO_KEY_in_stat495); 
					pushFollow(FOLLOW_index_expr_in_stat497);
					index_expr();
					state._fsp--;

					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat499); 
					pushFollow(FOLLOW_stat_seq_in_stat501);
					stat_seq();
					state._fsp--;

					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat503); 
					match(input,SEMI,FOLLOW_SEMI_in_stat505); 
					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:100:4: opt_prefix expr_list SEMI
					{
					pushFollow(FOLLOW_opt_prefix_in_stat510);
					opt_prefix();
					state._fsp--;

					pushFollow(FOLLOW_expr_list_in_stat512);
					expr_list();
					state._fsp--;

					match(input,SEMI,FOLLOW_SEMI_in_stat514); 
					}
					break;
				case 5 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:101:4: BREAK_KEY SEMI
					{
					match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat519); 
					match(input,SEMI,FOLLOW_SEMI_in_stat521); 
					}
					break;
				case 6 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:102:4: RETURN_KEY expr SEMI
					{
					match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat526); 
					pushFollow(FOLLOW_expr_in_stat528);
					expr();
					state._fsp--;

					match(input,SEMI,FOLLOW_SEMI_in_stat530); 
					}
					break;
				case 7 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:103:4: func_call SEMI
					{
					pushFollow(FOLLOW_func_call_in_stat535);
					func_call();
					state._fsp--;

					match(input,SEMI,FOLLOW_SEMI_in_stat537); 
					}
					break;
				case 8 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:104:4: block
					{
					pushFollow(FOLLOW_block_in_stat542);
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



	// $ANTLR start "opt_prefix"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:107:1: opt_prefix : value ASSIGN ;
	public final void opt_prefix() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:2: ( value ASSIGN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:108:4: value ASSIGN
			{
			pushFollow(FOLLOW_value_in_opt_prefix554);
			value();
			state._fsp--;

			match(input,ASSIGN,FOLLOW_ASSIGN_in_opt_prefix556); 
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
	// $ANTLR end "opt_prefix"



	// $ANTLR start "expr"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:1: expr : ( constval | value | LPAREN expr RPAREN | func_call ) ( binary_operator expr )? ;
	public final void expr() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:7: ( ( constval | value | LPAREN expr RPAREN | func_call ) ( binary_operator expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:9: ( constval | value | LPAREN expr RPAREN | func_call ) ( binary_operator expr )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:9: ( constval | value | LPAREN expr RPAREN | func_call )
			int alt15=4;
			switch ( input.LA(1) ) {
			case FIXEDPTLIT:
			case INTLIT:
				{
				alt15=1;
				}
				break;
			case ID:
				{
				int LA15_2 = input.LA(2);
				if ( (LA15_2==LPAREN) ) {
					alt15=4;
				}
				else if ( (LA15_2==AND||LA15_2==COMMA||(LA15_2 >= DIV && LA15_2 <= DO_KEY)||LA15_2==EQ||(LA15_2 >= GREATER && LA15_2 <= GREATEREQ)||(LA15_2 >= LBRACK && LA15_2 <= LESSEREQ)||(LA15_2 >= MINUS && LA15_2 <= NEQ)||(LA15_2 >= OR && LA15_2 <= PLUS)||(LA15_2 >= RPAREN && LA15_2 <= THEN_KEY)) ) {
					alt15=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case LPAREN:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:10: constval
					{
					pushFollow(FOLLOW_constval_in_expr570);
					constval();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:21: value
					{
					pushFollow(FOLLOW_value_in_expr574);
					value();
					state._fsp--;

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:29: LPAREN expr RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_expr578); 
					pushFollow(FOLLOW_expr_in_expr580);
					expr();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_expr582); 
					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:50: func_call
					{
					pushFollow(FOLLOW_func_call_in_expr586);
					func_call();
					state._fsp--;

					}
					break;

			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:61: ( binary_operator expr )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==AND||LA16_0==DIV||LA16_0==EQ||(LA16_0 >= GREATER && LA16_0 <= GREATEREQ)||(LA16_0 >= LESSER && LA16_0 <= LESSEREQ)||(LA16_0 >= MINUS && LA16_0 <= NEQ)||(LA16_0 >= OR && LA16_0 <= PLUS)) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:111:62: binary_operator expr
					{
					pushFollow(FOLLOW_binary_operator_in_expr590);
					binary_operator();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr592);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:1: constval : ( INTLIT | FIXEDPTLIT );
	public final void constval() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:9: ( INTLIT | FIXEDPTLIT )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:125:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final void binary_operator() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:126:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:1: expr_list : expr ( COMMA expr )* ;
	public final void expr_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:2: ( expr ( COMMA expr )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:4: expr ( COMMA expr )*
			{
			pushFollow(FOLLOW_expr_in_expr_list714);
			expr();
			state._fsp--;

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:9: ( COMMA expr )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==COMMA) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:10: COMMA expr
					{
					match(input,COMMA,FOLLOW_COMMA_in_expr_list717); 
					pushFollow(FOLLOW_expr_in_expr_list719);
					expr();
					state._fsp--;

					}
					break;

				default :
					break loop17;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:1: value : ID value_tail ;
	public final void value() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:8: ( ID value_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:133:10: ID value_tail
			{
			match(input,ID,FOLLOW_ID_in_value732); 
			pushFollow(FOLLOW_value_tail_in_value734);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |);
	public final void value_tail() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:2: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |)
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==LBRACK) ) {
				alt19=1;
			}
			else if ( (LA19_0==AND||LA19_0==ASSIGN||(LA19_0 >= COMMA && LA19_0 <= COMMA_SPACE)||(LA19_0 >= DIV && LA19_0 <= DO_KEY)||LA19_0==EQ||(LA19_0 >= GREATER && LA19_0 <= GREATEREQ)||(LA19_0 >= LESSER && LA19_0 <= LESSEREQ)||(LA19_0 >= MINUS && LA19_0 <= NEQ)||(LA19_0 >= OR && LA19_0 <= PLUS)||(LA19_0 >= RPAREN && LA19_0 <= THEN_KEY)) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:4: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail743); 
					pushFollow(FOLLOW_index_expr_in_value_tail745);
					index_expr();
					state._fsp--;

					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail747); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:29: ( LBRACK index_expr RBRACK )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==LBRACK) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:30: LBRACK index_expr RBRACK
							{
							match(input,LBRACK,FOLLOW_LBRACK_in_value_tail750); 
							pushFollow(FOLLOW_index_expr_in_value_tail752);
							index_expr();
							state._fsp--;

							match(input,RBRACK,FOLLOW_RBRACK_in_value_tail754); 
							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:137:2: 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:139:1: index_expr : ( INTLIT | ID ) ( index_oper index_expr )? ;
	public final void index_expr() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:2: ( ( INTLIT | ID ) ( index_oper index_expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:4: ( INTLIT | ID ) ( index_oper index_expr )?
			{
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:18: ( index_oper index_expr )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( ((LA20_0 >= MINUS && LA20_0 <= MULT)||LA20_0==PLUS) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:140:19: index_oper index_expr
					{
					pushFollow(FOLLOW_index_oper_in_index_expr782);
					index_oper();
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr784);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final void index_oper() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:144:2: ( ( PLUS | MINUS | MULT ) )
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



	// $ANTLR start "func_call"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:1: func_call : ID LPAREN func_param_list RPAREN ;
	public final void func_call() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:3: ( ID LPAREN func_param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:5: ID LPAREN func_param_list RPAREN
			{
			match(input,ID,FOLLOW_ID_in_func_call856); 
			match(input,LPAREN,FOLLOW_LPAREN_in_func_call858); 
			pushFollow(FOLLOW_func_param_list_in_func_call860);
			func_param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_func_call862); 
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
	// $ANTLR end "func_call"



	// $ANTLR start "func_param_list"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:1: func_param_list : ( value ( COMMA_SPACE value )* |);
	public final void func_param_list() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:3: ( value ( COMMA_SPACE value )* |)
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==ID) ) {
				alt22=1;
			}
			else if ( (LA22_0==RPAREN) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:5: value ( COMMA_SPACE value )*
					{
					pushFollow(FOLLOW_value_in_func_param_list877);
					value();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:11: ( COMMA_SPACE value )*
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==COMMA_SPACE) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:12: COMMA_SPACE value
							{
							match(input,COMMA_SPACE,FOLLOW_COMMA_SPACE_in_func_param_list880); 
							pushFollow(FOLLOW_value_in_func_param_list882);
							value();
							state._fsp--;

							}
							break;

						default :
							break loop21;
						}
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:158:3: 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:161:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final void keywords() throws TigerParseException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:162:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
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



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program11 = new BitSet(new long[]{0x0004000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program13 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_main_function_in_tiger_program15 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list31 = new BitSet(new long[]{0x0004000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_funct_declaration_list33 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_type_in_funct_declaration44 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration46 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration48 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration50 = new BitSet(new long[]{0x0000100004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration52 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration54 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration56 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration58 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration60 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration62 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_main_function74 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function76 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function78 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function80 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_main_function82 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_main_function84 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_main_function86 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_main_function88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list121 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_param_list_tail_in_param_list123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_param_list_tail139 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list_tail141 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_param_list_tail_in_param_list_tail143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_param154 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_param156 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list168 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail182 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block199 = new BitSet(new long[]{0x0003000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block201 = new BitSet(new long[]{0x0008080014440180L});
	public static final BitSet FOLLOW_stat_seq_in_block203 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block205 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_block207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement217 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list237 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_type_declaration_list_in_type_declaration_list239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list256 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_var_declaration_list258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration270 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration272 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration274 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration276 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type294 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type296 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type298 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type300 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type302 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type309 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type311 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type313 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type315 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type317 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type319 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type321 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type323 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration368 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration370 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COLON_in_var_declaration372 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration374 = new BitSet(new long[]{0x0000200000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration376 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list388 = new BitSet(new long[]{0x0000000000000C02L});
	public static final BitSet FOLLOW_set_in_id_list391 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init420 = new BitSet(new long[]{0x0000000020100000L});
	public static final BitSet FOLLOW_constval_in_optional_init422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq434 = new BitSet(new long[]{0x0008080014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat447 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat449 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat451 = new BitSet(new long[]{0x0008080014428180L});
	public static final BitSet FOLLOW_stat_seq_in_stat453 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat456 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat460 = new BitSet(new long[]{0x0008080014420180L});
	public static final BitSet FOLLOW_stat_seq_in_stat462 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat464 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat472 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat474 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat476 = new BitSet(new long[]{0x0008080014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat478 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat480 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat487 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat489 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat491 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat493 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat495 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat497 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat499 = new BitSet(new long[]{0x0008080014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat501 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat503 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_opt_prefix_in_stat510 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat512 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat519 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat526 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat528 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat530 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_call_in_stat535 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_opt_prefix554 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_opt_prefix556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr570 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_value_in_expr574 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr578 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr580 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr582 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_func_call_in_expr586 = new BitSet(new long[]{0x0000037303082012L});
	public static final BitSet FOLLOW_binary_operator_in_expr590 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list714 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_expr_list717 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list719 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ID_in_value732 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value734 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail743 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail745 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail747 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail750 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail752 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail754 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr773 = new BitSet(new long[]{0x0000023000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr782 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_func_call856 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_func_call858 = new BitSet(new long[]{0x0000100004000000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call860 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_func_param_list877 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_SPACE_in_func_param_list880 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_value_in_func_param_list882 = new BitSet(new long[]{0x0000000000000802L});
}
