// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-06 22:59:02

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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



	// $ANTLR start "tiger_program"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:63:1: tiger_program : type_declaration_list funct_declaration_list ;
	public final void tiger_program() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:64:2: ( type_declaration_list funct_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:64:4: type_declaration_list funct_declaration_list
			{
			pushFollow(FOLLOW_type_declaration_list_in_tiger_program58);
			type_declaration_list();
			state._fsp--;

			pushFollow(FOLLOW_funct_declaration_list_in_tiger_program60);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:67:1: funct_declaration_list : ( funct_declaration )* ;
	public final void funct_declaration_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:2: ( ( funct_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:4: ( funct_declaration )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:4: ( funct_declaration )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==FIXEDPT_KEY||LA1_0==ID||LA1_0==INT_KEY||LA1_0==VOID_KEY) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:68:4: funct_declaration
					{
					pushFollow(FOLLOW_funct_declaration_in_funct_declaration_list72);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:71:1: funct_declaration : ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI ;
	public final void funct_declaration() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:2: ( ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) ) BEGIN_KEY block_list END_KEY SEMI
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:4: ( ( type_id funct_declaration_tail ) | ( VOID_KEY ( funct_declaration_tail | main_function_tail ) ) )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:5: ( type_id funct_declaration_tail )
					{
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:5: ( type_id funct_declaration_tail )
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:6: type_id funct_declaration_tail
					{
					pushFollow(FOLLOW_type_id_in_funct_declaration86);
					type_id();
					state._fsp--;

					pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration88);
					funct_declaration_tail();
					state._fsp--;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					{
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:40: ( VOID_KEY ( funct_declaration_tail | main_function_tail ) )
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:41: VOID_KEY ( funct_declaration_tail | main_function_tail )
					{
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_funct_declaration94); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:50: ( funct_declaration_tail | main_function_tail )
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
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:51: funct_declaration_tail
							{
							pushFollow(FOLLOW_funct_declaration_tail_in_funct_declaration97);
							funct_declaration_tail();
							state._fsp--;

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:72:76: main_function_tail
							{
							pushFollow(FOLLOW_main_function_tail_in_funct_declaration101);
							main_function_tail();
							state._fsp--;

							}
							break;

					}

					}

					}
					break;

			}

			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_funct_declaration106); 
			pushFollow(FOLLOW_block_list_in_funct_declaration108);
			block_list();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_funct_declaration110); 
			match(input,SEMI,FOLLOW_SEMI_in_funct_declaration112); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:75:1: funct_declaration_tail : FUNCTION_KEY ID LPAREN param_list RPAREN ;
	public final void funct_declaration_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:76:3: ( FUNCTION_KEY ID LPAREN param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:76:5: FUNCTION_KEY ID LPAREN param_list RPAREN
			{
			match(input,FUNCTION_KEY,FOLLOW_FUNCTION_KEY_in_funct_declaration_tail124); 
			match(input,ID,FOLLOW_ID_in_funct_declaration_tail126); 
			match(input,LPAREN,FOLLOW_LPAREN_in_funct_declaration_tail128); 
			pushFollow(FOLLOW_param_list_in_funct_declaration_tail130);
			param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_funct_declaration_tail132); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:79:1: main_function_tail : MAIN_KEY LPAREN RPAREN ;
	public final void main_function_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:2: ( MAIN_KEY LPAREN RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:80:4: MAIN_KEY LPAREN RPAREN
			{
			match(input,MAIN_KEY,FOLLOW_MAIN_KEY_in_main_function_tail144); 
			match(input,LPAREN,FOLLOW_LPAREN_in_main_function_tail146); 
			match(input,RPAREN,FOLLOW_RPAREN_in_main_function_tail148); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:83:1: ret_type : ( VOID_KEY | type_id );
	public final void ret_type() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:2: ( VOID_KEY | type_id )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:84:4: VOID_KEY
					{
					match(input,VOID_KEY,FOLLOW_VOID_KEY_in_ret_type160); 
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:85:4: type_id
					{
					pushFollow(FOLLOW_type_id_in_ret_type165);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:88:1: param_list : ( param ( COMMA param )* )? ;
	public final void param_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:2: ( ( param ( COMMA param )* )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:4: ( param ( COMMA param )* )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:4: ( param ( COMMA param )* )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:5: param ( COMMA param )*
					{
					pushFollow(FOLLOW_param_in_param_list178);
					param();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:11: ( COMMA param )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==COMMA) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:89:12: COMMA param
							{
							match(input,COMMA,FOLLOW_COMMA_in_param_list181); 
							pushFollow(FOLLOW_param_in_param_list183);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:1: param : ID COLON type_id ;
	public final void param() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:8: ( ID COLON type_id )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:92:10: ID COLON type_id
			{
			match(input,ID,FOLLOW_ID_in_param198); 
			match(input,COLON,FOLLOW_COLON_in_param200); 
			pushFollow(FOLLOW_type_id_in_param202);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:94:1: block_list : block block_tail ;
	public final void block_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:95:2: ( block block_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:95:4: block block_tail
			{
			pushFollow(FOLLOW_block_in_block_list212);
			block();
			state._fsp--;

			pushFollow(FOLLOW_block_tail_in_block_list214);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:98:1: block_tail : ( block block_tail |);
	public final void block_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:2: ( block block_tail |)
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:99:4: block block_tail
					{
					pushFollow(FOLLOW_block_in_block_tail226);
					block();
					state._fsp--;

					pushFollow(FOLLOW_block_tail_in_block_tail228);
					block_tail();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:101:2: 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:103:1: block : BEGIN_KEY declaration_statement stat_seq END_KEY SEMI ;
	public final void block() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:103:8: ( BEGIN_KEY declaration_statement stat_seq END_KEY SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:103:10: BEGIN_KEY declaration_statement stat_seq END_KEY SEMI
			{
			match(input,BEGIN_KEY,FOLLOW_BEGIN_KEY_in_block243); 
			pushFollow(FOLLOW_declaration_statement_in_block245);
			declaration_statement();
			state._fsp--;

			pushFollow(FOLLOW_stat_seq_in_block247);
			stat_seq();
			state._fsp--;

			match(input,END_KEY,FOLLOW_END_KEY_in_block249); 
			match(input,SEMI,FOLLOW_SEMI_in_block251); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:105:1: declaration_statement : type_declaration_list var_declaration_list ;
	public final void declaration_statement() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:2: ( type_declaration_list var_declaration_list )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:106:4: type_declaration_list var_declaration_list
			{
			pushFollow(FOLLOW_type_declaration_list_in_declaration_statement261);
			type_declaration_list();
			state._fsp--;

			pushFollow(FOLLOW_var_declaration_list_in_declaration_statement263);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:109:1: type_declaration_list : ( type_declaration )* ;
	public final void type_declaration_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:2: ( ( type_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:5: ( type_declaration )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:5: ( type_declaration )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==TYPE_KEY) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:110:5: type_declaration
					{
					pushFollow(FOLLOW_type_declaration_in_type_declaration_list277);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:113:1: var_declaration_list : ( var_declaration )* ;
	public final void var_declaration_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:2: ( ( var_declaration )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: ( var_declaration )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: ( var_declaration )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==VAR_KEY) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:114:4: var_declaration
					{
					pushFollow(FOLLOW_var_declaration_in_var_declaration_list291);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:117:1: type_declaration : TYPE_KEY ID EQ type SEMI ;
	public final void type_declaration() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:2: ( TYPE_KEY ID EQ type SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:118:4: TYPE_KEY ID EQ type SEMI
			{
			match(input,TYPE_KEY,FOLLOW_TYPE_KEY_in_type_declaration304); 
			match(input,ID,FOLLOW_ID_in_type_declaration306); 
			match(input,EQ,FOLLOW_EQ_in_type_declaration308); 
			pushFollow(FOLLOW_type_in_type_declaration310);
			type();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_type_declaration312); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:1: type : ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type );
	public final void type() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:6: ( base_type | ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:121:8: base_type
					{
					pushFollow(FOLLOW_base_type_in_type323);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:122:4: ARRAY_KEY LBRACK INTLIT RBRACK ( LBRACK INTLIT RBRACK )? OF_KEY base_type
					{
					match(input,ARRAY_KEY,FOLLOW_ARRAY_KEY_in_type328); 
					match(input,LBRACK,FOLLOW_LBRACK_in_type330); 
					match(input,INTLIT,FOLLOW_INTLIT_in_type332); 
					match(input,RBRACK,FOLLOW_RBRACK_in_type334); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:122:35: ( LBRACK INTLIT RBRACK )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==LBRACK) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:122:36: LBRACK INTLIT RBRACK
							{
							match(input,LBRACK,FOLLOW_LBRACK_in_type337); 
							match(input,INTLIT,FOLLOW_INTLIT_in_type339); 
							match(input,RBRACK,FOLLOW_RBRACK_in_type341); 
							}
							break;

					}

					match(input,OF_KEY,FOLLOW_OF_KEY_in_type345); 
					pushFollow(FOLLOW_base_type_in_type347);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:125:1: type_id : ( base_type | ID );
	public final void type_id() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:125:9: ( base_type | ID )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:125:11: base_type
					{
					pushFollow(FOLLOW_base_type_in_type_id357);
					base_type();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:126:4: ID
					{
					match(input,ID,FOLLOW_ID_in_type_id362); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:129:1: base_type : ( INT_KEY | FIXEDPT_KEY );
	public final void base_type() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:130:2: ( INT_KEY | FIXEDPT_KEY )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:134:1: var_declaration : VAR_KEY id_list COLON type_id optional_init SEMI ;
	public final void var_declaration() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:2: ( VAR_KEY id_list COLON type_id optional_init SEMI )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:135:4: VAR_KEY id_list COLON type_id optional_init SEMI
			{
			match(input,VAR_KEY,FOLLOW_VAR_KEY_in_var_declaration390); 
			pushFollow(FOLLOW_id_list_in_var_declaration392);
			id_list();
			state._fsp--;

			match(input,COLON,FOLLOW_COLON_in_var_declaration394); 
			pushFollow(FOLLOW_type_id_in_var_declaration396);
			type_id();
			state._fsp--;

			pushFollow(FOLLOW_optional_init_in_var_declaration398);
			optional_init();
			state._fsp--;

			match(input,SEMI,FOLLOW_SEMI_in_var_declaration400); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:1: id_list : ID ( COMMA id_list )? ;
	public final void id_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:9: ( ID ( COMMA id_list )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:11: ID ( COMMA id_list )?
			{
			match(input,ID,FOLLOW_ID_in_id_list410); 
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:14: ( COMMA id_list )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==COMMA) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:138:15: COMMA id_list
					{
					match(input,COMMA,FOLLOW_COMMA_in_id_list413); 
					pushFollow(FOLLOW_id_list_in_id_list415);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:141:1: optional_init : (| ASSIGN expr );
	public final void optional_init() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:142:2: (| ASSIGN expr )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:2: 
					{
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:143:5: ASSIGN expr
					{
					match(input,ASSIGN,FOLLOW_ASSIGN_in_optional_init436); 
					pushFollow(FOLLOW_expr_in_optional_init438);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:146:1: stat_seq : ( stat )* ;
	public final void stat_seq() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:2: ( ( stat )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:4: ( stat )*
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:4: ( stat )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= BEGIN_KEY && LA15_0 <= BREAK_KEY)||LA15_0==FOR_KEY||LA15_0==ID||LA15_0==IF_KEY||LA15_0==RETURN_KEY||LA15_0==WHILE_KEY) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:147:4: stat
					{
					pushFollow(FOLLOW_stat_in_stat_seq450);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:150:1: stat : ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block );
	public final void stat() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:2: ( IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI ) | WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI | FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI | ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI | BREAK_KEY SEMI | RETURN_KEY expr SEMI | block )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:4: IF_KEY expr THEN_KEY stat_seq ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
					{
					match(input,IF_KEY,FOLLOW_IF_KEY_in_stat463); 
					pushFollow(FOLLOW_expr_in_stat465);
					expr();
					state._fsp--;

					match(input,THEN_KEY,FOLLOW_THEN_KEY_in_stat467); 
					pushFollow(FOLLOW_stat_seq_in_stat469);
					stat_seq();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:34: ( ENDIF_KEY SEMI | ELSE_KEY stat_seq ENDIF_KEY SEMI )
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
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:35: ENDIF_KEY SEMI
							{
							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat472); 
							match(input,SEMI,FOLLOW_SEMI_in_stat474); 
							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:151:50: ELSE_KEY stat_seq ENDIF_KEY SEMI
							{
							match(input,ELSE_KEY,FOLLOW_ELSE_KEY_in_stat476); 
							pushFollow(FOLLOW_stat_seq_in_stat478);
							stat_seq();
							state._fsp--;

							match(input,ENDIF_KEY,FOLLOW_ENDIF_KEY_in_stat480); 
							match(input,SEMI,FOLLOW_SEMI_in_stat482); 
							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:152:4: WHILE_KEY expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					match(input,WHILE_KEY,FOLLOW_WHILE_KEY_in_stat488); 
					pushFollow(FOLLOW_expr_in_stat490);
					expr();
					state._fsp--;

					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat492); 
					pushFollow(FOLLOW_stat_seq_in_stat494);
					stat_seq();
					state._fsp--;

					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat496); 
					match(input,SEMI,FOLLOW_SEMI_in_stat498); 
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:153:4: FOR_KEY ID ASSIGN index_expr TO_KEY index_expr DO_KEY stat_seq ENDDO_KEY SEMI
					{
					match(input,FOR_KEY,FOLLOW_FOR_KEY_in_stat503); 
					match(input,ID,FOLLOW_ID_in_stat505); 
					match(input,ASSIGN,FOLLOW_ASSIGN_in_stat507); 
					pushFollow(FOLLOW_index_expr_in_stat509);
					index_expr();
					state._fsp--;

					match(input,TO_KEY,FOLLOW_TO_KEY_in_stat511); 
					pushFollow(FOLLOW_index_expr_in_stat513);
					index_expr();
					state._fsp--;

					match(input,DO_KEY,FOLLOW_DO_KEY_in_stat515); 
					pushFollow(FOLLOW_stat_seq_in_stat517);
					stat_seq();
					state._fsp--;

					match(input,ENDDO_KEY,FOLLOW_ENDDO_KEY_in_stat519); 
					match(input,SEMI,FOLLOW_SEMI_in_stat521); 
					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:6: ID ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) ) SEMI
					{
					match(input,ID,FOLLOW_ID_in_stat528); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:9: ( ( value_tail ASSIGN expr_list ) | ( func_call_tail ) )
					int alt17=2;
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
						throw nvae;
					}

					switch (alt17) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:10: ( value_tail ASSIGN expr_list )
							{
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:10: ( value_tail ASSIGN expr_list )
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:11: value_tail ASSIGN expr_list
							{
							pushFollow(FOLLOW_value_tail_in_stat532);
							value_tail();
							state._fsp--;

							match(input,ASSIGN,FOLLOW_ASSIGN_in_stat534); 
							pushFollow(FOLLOW_expr_list_in_stat536);
							expr_list();
							state._fsp--;

							}

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:42: ( func_call_tail )
							{
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:42: ( func_call_tail )
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:154:43: func_call_tail
							{
							pushFollow(FOLLOW_func_call_tail_in_stat542);
							func_call_tail();
							state._fsp--;

							}

							}
							break;

					}

					match(input,SEMI,FOLLOW_SEMI_in_stat546); 
					}
					break;
				case 5 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:155:4: BREAK_KEY SEMI
					{
					match(input,BREAK_KEY,FOLLOW_BREAK_KEY_in_stat551); 
					match(input,SEMI,FOLLOW_SEMI_in_stat553); 
					}
					break;
				case 6 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:156:4: RETURN_KEY expr SEMI
					{
					match(input,RETURN_KEY,FOLLOW_RETURN_KEY_in_stat558); 
					pushFollow(FOLLOW_expr_in_stat560);
					expr();
					state._fsp--;

					match(input,SEMI,FOLLOW_SEMI_in_stat562); 
					}
					break;
				case 7 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:157:4: block
					{
					pushFollow(FOLLOW_block_in_stat567);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:1: expr : ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binop_p0 expr )? ;
	public final void expr() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:7: ( ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binop_p0 expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN ) ( binop_p0 expr )?
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:9: ( constval | ID ( value_tail | func_call_tail ) | LPAREN expr RPAREN )
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
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:10: constval
					{
					pushFollow(FOLLOW_constval_in_expr581);
					constval();
					state._fsp--;

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:21: ID ( value_tail | func_call_tail )
					{
					match(input,ID,FOLLOW_ID_in_expr585); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:24: ( value_tail | func_call_tail )
					int alt19=2;
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
						throw nvae;
					}

					switch (alt19) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:25: value_tail
							{
							pushFollow(FOLLOW_value_tail_in_expr588);
							value_tail();
							state._fsp--;

							}
							break;
						case 2 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:38: func_call_tail
							{
							pushFollow(FOLLOW_func_call_tail_in_expr592);
							func_call_tail();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:56: LPAREN expr RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_expr597); 
					pushFollow(FOLLOW_expr_in_expr599);
					expr();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_expr601); 
					}
					break;

			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:76: ( binop_p0 expr )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==AND||LA21_0==DIV||LA21_0==EQ||(LA21_0 >= GREATER && LA21_0 <= GREATEREQ)||(LA21_0 >= LESSER && LA21_0 <= LESSEREQ)||(LA21_0 >= MINUS && LA21_0 <= NEQ)||(LA21_0 >= OR && LA21_0 <= PLUS)) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:160:77: binop_p0 expr
					{
					pushFollow(FOLLOW_binop_p0_in_expr605);
					binop_p0();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr607);
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



	// $ANTLR start "binop_p0"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:1: binop_p0 : ( AND | OR | binop_p1 ) ;
	public final void binop_p0() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:9: ( ( AND | OR | binop_p1 ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:11: ( AND | OR | binop_p1 )
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:11: ( AND | OR | binop_p1 )
			int alt22=3;
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
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:12: AND
					{
					match(input,AND,FOLLOW_AND_in_binop_p0621); 
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:18: OR
					{
					match(input,OR,FOLLOW_OR_in_binop_p0625); 
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:163:23: binop_p1
					{
					pushFollow(FOLLOW_binop_p1_in_binop_p0629);
					binop_p1();
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
	// $ANTLR end "binop_p0"



	// $ANTLR start "binop_p1"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:1: binop_p1 : ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) ;
	public final void binop_p1() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:9: ( ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:11: ( EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | binop_p2 )
			int alt23=7;
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
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:12: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_binop_p1637); 
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:17: NEQ
					{
					match(input,NEQ,FOLLOW_NEQ_in_binop_p1641); 
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:23: LESSER
					{
					match(input,LESSER,FOLLOW_LESSER_in_binop_p1645); 
					}
					break;
				case 4 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:32: GREATER
					{
					match(input,GREATER,FOLLOW_GREATER_in_binop_p1649); 
					}
					break;
				case 5 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:42: LESSEREQ
					{
					match(input,LESSEREQ,FOLLOW_LESSEREQ_in_binop_p1653); 
					}
					break;
				case 6 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:53: GREATEREQ
					{
					match(input,GREATEREQ,FOLLOW_GREATEREQ_in_binop_p1657); 
					}
					break;
				case 7 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:164:65: binop_p2
					{
					pushFollow(FOLLOW_binop_p2_in_binop_p1661);
					binop_p2();
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
	// $ANTLR end "binop_p1"



	// $ANTLR start "binop_p2"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:1: binop_p2 : ( MINUS | PLUS | binop_p3 ) ;
	public final void binop_p2() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:9: ( ( MINUS | PLUS | binop_p3 ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:11: ( MINUS | PLUS | binop_p3 )
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:11: ( MINUS | PLUS | binop_p3 )
			int alt24=3;
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
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:12: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_binop_p2674); 
					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:20: PLUS
					{
					match(input,PLUS,FOLLOW_PLUS_in_binop_p2678); 
					}
					break;
				case 3 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:165:27: binop_p3
					{
					pushFollow(FOLLOW_binop_p3_in_binop_p2682);
					binop_p3();
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
	// $ANTLR end "binop_p2"



	// $ANTLR start "binop_p3"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:166:1: binop_p3 : ( MULT | DIV ) ;
	public final void binop_p3() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:166:9: ( ( MULT | DIV ) )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
			{
			if ( input.LA(1)==DIV||input.LA(1)==MULT ) {
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
	// $ANTLR end "binop_p3"



	// $ANTLR start "constval"
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:1: constval : ( INTLIT | FIXEDPTLIT );
	public final void constval() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:168:9: ( INTLIT | FIXEDPTLIT )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:179:1: binary_operator : ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) ;
	public final void binary_operator() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:180:2: ( ( PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | GREATER | LESSEREQ | GREATEREQ | AND | OR ) )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:183:1: expr_list : expr ( COMMA expr )* ;
	public final void expr_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:2: ( expr ( COMMA expr )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:4: expr ( COMMA expr )*
			{
			pushFollow(FOLLOW_expr_in_expr_list815);
			expr();
			state._fsp--;

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:9: ( COMMA expr )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==COMMA) ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:184:10: COMMA expr
					{
					match(input,COMMA,FOLLOW_COMMA_in_expr_list818); 
					pushFollow(FOLLOW_expr_in_expr_list820);
					expr();
					state._fsp--;

					}
					break;

				default :
					break loop25;
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:1: value : ID value_tail ;
	public final void value() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:8: ( ID value_tail )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:187:10: ID value_tail
			{
			match(input,ID,FOLLOW_ID_in_value833); 
			pushFollow(FOLLOW_value_tail_in_value835);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:188:1: value_tail : ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |);
	public final void value_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:2: ( LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )? |)
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==LBRACK) ) {
				alt27=1;
			}
			else if ( (LA27_0==EOF||LA27_0==AND||LA27_0==ASSIGN||LA27_0==COMMA||(LA27_0 >= DIV && LA27_0 <= DO_KEY)||LA27_0==EQ||(LA27_0 >= GREATER && LA27_0 <= GREATEREQ)||(LA27_0 >= LESSER && LA27_0 <= LESSEREQ)||(LA27_0 >= MINUS && LA27_0 <= NEQ)||(LA27_0 >= OR && LA27_0 <= PLUS)||(LA27_0 >= RPAREN && LA27_0 <= SEMI)||LA27_0==THEN_KEY) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:4: LBRACK index_expr RBRACK ( LBRACK index_expr RBRACK )?
					{
					match(input,LBRACK,FOLLOW_LBRACK_in_value_tail844); 
					pushFollow(FOLLOW_index_expr_in_value_tail846);
					index_expr();
					state._fsp--;

					match(input,RBRACK,FOLLOW_RBRACK_in_value_tail848); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:29: ( LBRACK index_expr RBRACK )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==LBRACK) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:189:30: LBRACK index_expr RBRACK
							{
							match(input,LBRACK,FOLLOW_LBRACK_in_value_tail851); 
							pushFollow(FOLLOW_index_expr_in_value_tail853);
							index_expr();
							state._fsp--;

							match(input,RBRACK,FOLLOW_RBRACK_in_value_tail855); 
							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:191:2: 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:193:1: index_expr : ( INTLIT | ID ) ( index_oper index_expr )? ;
	public final void index_expr() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:194:2: ( ( INTLIT | ID ) ( index_oper index_expr )? )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:194:4: ( INTLIT | ID ) ( index_oper index_expr )?
			{
			if ( input.LA(1)==ID||input.LA(1)==INTLIT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:194:18: ( index_oper index_expr )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( ((LA28_0 >= MINUS && LA28_0 <= MULT)||LA28_0==PLUS) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:194:19: index_oper index_expr
					{
					pushFollow(FOLLOW_index_oper_in_index_expr883);
					index_oper();
					state._fsp--;

					pushFollow(FOLLOW_index_expr_in_index_expr885);
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:197:1: index_oper : ( PLUS | MINUS | MULT ) ;
	public final void index_oper() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:198:2: ( ( PLUS | MINUS | MULT ) )
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:217:1: func_call_tail : LPAREN func_param_list RPAREN ;
	public final void func_call_tail() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:218:3: ( LPAREN func_param_list RPAREN )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:218:5: LPAREN func_param_list RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_func_call_tail1008); 
			pushFollow(FOLLOW_func_param_list_in_func_call_tail1010);
			func_param_list();
			state._fsp--;

			match(input,RPAREN,FOLLOW_RPAREN_in_func_call_tail1012); 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:221:1: func_param_list : ( expr ( COMMA expr )* |);
	public final void func_param_list() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:222:3: ( expr ( COMMA expr )* |)
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==FIXEDPTLIT||LA30_0==ID||LA30_0==INTLIT||LA30_0==LPAREN) ) {
				alt30=1;
			}
			else if ( (LA30_0==RPAREN) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:222:5: expr ( COMMA expr )*
					{
					pushFollow(FOLLOW_expr_in_func_param_list1027);
					expr();
					state._fsp--;

					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:222:10: ( COMMA expr )*
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==COMMA) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:222:11: COMMA expr
							{
							match(input,COMMA,FOLLOW_COMMA_in_func_param_list1030); 
							pushFollow(FOLLOW_expr_in_func_param_list1032);
							expr();
							state._fsp--;

							}
							break;

						default :
							break loop29;
						}
					}

					}
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:224:3: 
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
	// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:227:1: keywords : ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY );
	public final void keywords() throws RecognitionException {
		try {
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:228:2: ( FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | DO_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | BREAK_KEY | RETURN_KEY )
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



	public static final BitSet FOLLOW_type_declaration_list_in_tiger_program58 = new BitSet(new long[]{0x0010000044200000L});
	public static final BitSet FOLLOW_funct_declaration_list_in_tiger_program60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funct_declaration_in_funct_declaration_list72 = new BitSet(new long[]{0x0010000044200002L});
	public static final BitSet FOLLOW_type_id_in_funct_declaration86 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration88 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_VOID_KEY_in_funct_declaration94 = new BitSet(new long[]{0x0000000800800000L});
	public static final BitSet FOLLOW_funct_declaration_tail_in_funct_declaration97 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_main_function_tail_in_funct_declaration101 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_funct_declaration106 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_list_in_funct_declaration108 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_funct_declaration110 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_funct_declaration112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FUNCTION_KEY_in_funct_declaration_tail124 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_funct_declaration_tail126 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_funct_declaration_tail128 = new BitSet(new long[]{0x0000200004000000L});
	public static final BitSet FOLLOW_param_list_in_funct_declaration_tail130 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_funct_declaration_tail132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAIN_KEY_in_main_function_tail144 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_LPAREN_in_main_function_tail146 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_main_function_tail148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_KEY_in_ret_type160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_ret_type165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_param_in_param_list178 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_param_list181 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_param_in_param_list183 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_param198 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_param200 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_param202 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_list212 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_list214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_block_tail226 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_tail_in_block_tail228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BEGIN_KEY_in_block243 = new BitSet(new long[]{0x000C000000000000L});
	public static final BitSet FOLLOW_declaration_statement_in_block245 = new BitSet(new long[]{0x0020100014440180L});
	public static final BitSet FOLLOW_stat_seq_in_block247 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_END_KEY_in_block249 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_block251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_list_in_declaration_statement261 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_var_declaration_list_in_declaration_statement263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_declaration_in_type_declaration_list277 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_var_declaration_in_var_declaration_list291 = new BitSet(new long[]{0x0008000000000002L});
	public static final BitSet FOLLOW_TYPE_KEY_in_type_declaration304 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_type_declaration306 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_EQ_in_type_declaration308 = new BitSet(new long[]{0x0000000040200020L});
	public static final BitSet FOLLOW_type_in_type_declaration310 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_type_declaration312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_KEY_in_type328 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type330 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type332 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type334 = new BitSet(new long[]{0x0000010080000000L});
	public static final BitSet FOLLOW_LBRACK_in_type337 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTLIT_in_type339 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_type341 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_OF_KEY_in_type345 = new BitSet(new long[]{0x0000000040200000L});
	public static final BitSet FOLLOW_base_type_in_type347 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_base_type_in_type_id357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_id362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_KEY_in_var_declaration390 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_var_declaration392 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_COLON_in_var_declaration394 = new BitSet(new long[]{0x0000000044200000L});
	public static final BitSet FOLLOW_type_id_in_var_declaration396 = new BitSet(new long[]{0x0000400000000040L});
	public static final BitSet FOLLOW_optional_init_in_var_declaration398 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_var_declaration400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_list410 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_id_list413 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_id_list_in_id_list415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASSIGN_in_optional_init436 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_optional_init438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stat_in_stat_seq450 = new BitSet(new long[]{0x0020100014400182L});
	public static final BitSet FOLLOW_IF_KEY_in_stat463 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat465 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_THEN_KEY_in_stat467 = new BitSet(new long[]{0x0020100014428180L});
	public static final BitSet FOLLOW_stat_seq_in_stat469 = new BitSet(new long[]{0x0000000000028000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat472 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ELSE_KEY_in_stat476 = new BitSet(new long[]{0x0020100014420180L});
	public static final BitSet FOLLOW_stat_seq_in_stat478 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_ENDIF_KEY_in_stat480 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHILE_KEY_in_stat488 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat490 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat492 = new BitSet(new long[]{0x0020100014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat494 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat496 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_KEY_in_stat503 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_ID_in_stat505 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat507 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat509 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_TO_KEY_in_stat511 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_stat513 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_DO_KEY_in_stat515 = new BitSet(new long[]{0x0020100014410180L});
	public static final BitSet FOLLOW_stat_seq_in_stat517 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ENDDO_KEY_in_stat519 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat521 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat528 = new BitSet(new long[]{0x0000000480000040L});
	public static final BitSet FOLLOW_value_tail_in_stat532 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASSIGN_in_stat534 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_list_in_stat536 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_func_call_tail_in_stat542 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BREAK_KEY_in_stat551 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RETURN_KEY_in_stat558 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_stat560 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_SEMI_in_stat562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_block_in_stat567 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constval_in_expr581 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_ID_in_expr585 = new BitSet(new long[]{0x0000067783082010L});
	public static final BitSet FOLLOW_value_tail_in_expr588 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_func_call_tail_in_expr592 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_LPAREN_in_expr597 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr599 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_expr601 = new BitSet(new long[]{0x0000067303082012L});
	public static final BitSet FOLLOW_binop_p0_in_expr605 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_binop_p0621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_binop_p0625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p1_in_binop_p0629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_binop_p1637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEQ_in_binop_p1641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSER_in_binop_p1645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_binop_p1649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESSEREQ_in_binop_p1653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATEREQ_in_binop_p1657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p2_in_binop_p1661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binop_p2674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binop_p2678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_binop_p3_in_binop_p2682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_expr_list815 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_expr_list818 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_expr_list820 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_ID_in_value833 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_value_tail_in_value835 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail844 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail846 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail848 = new BitSet(new long[]{0x0000000080000002L});
	public static final BitSet FOLLOW_LBRACK_in_value_tail851 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_value_tail853 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_RBRACK_in_value_tail855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_index_expr874 = new BitSet(new long[]{0x0000043000000002L});
	public static final BitSet FOLLOW_index_oper_in_index_expr883 = new BitSet(new long[]{0x0000000024000000L});
	public static final BitSet FOLLOW_index_expr_in_index_expr885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_func_call_tail1008 = new BitSet(new long[]{0x0000200424100000L});
	public static final BitSet FOLLOW_func_param_list_in_func_call_tail1010 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_RPAREN_in_func_call_tail1012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_func_param_list1027 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_COMMA_in_func_param_list1030 = new BitSet(new long[]{0x0000000424100000L});
	public static final BitSet FOLLOW_expr_in_func_param_list1032 = new BitSet(new long[]{0x0000000000000802L});
}
