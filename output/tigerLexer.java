// $ANTLR 3.5.1 /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g 2014-11-04 16:18:18

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class tigerLexer extends Lexer {
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

		@Override
		public void reportError(RecognitionException e) {
			displayRecognitionError(this.getTokenNames(), e);
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
		


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public tigerLexer() {} 
	public tigerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public tigerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g"; }

	// $ANTLR start "UNSIGNED_INTLIT"
	public final void mUNSIGNED_INTLIT() throws RecognitionException {
		try {
			int _type = UNSIGNED_INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:454:2: ( ( '0' .. '9' )+ )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:454:4: ( '0' .. '9' )+
			{
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:454:4: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNSIGNED_INTLIT"

	// $ANTLR start "UNSIGNED_FIXEDPTLIT"
	public final void mUNSIGNED_FIXEDPTLIT() throws RecognitionException {
		try {
			int _type = UNSIGNED_FIXEDPTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:461:2: ( ( '0' .. '9' )* '.' ( '0' .. '9' )* )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:461:5: ( '0' .. '9' )* '.' ( '0' .. '9' )*
			{
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:461:5: ( '0' .. '9' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			match('.'); 
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:461:21: ( '0' .. '9' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNSIGNED_FIXEDPTLIT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:493:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:493:7: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:493:12: ( options {greedy=false; } : . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='*') ) {
					int LA4_1 = input.LA(2);
					if ( (LA4_1=='/') ) {
						alt4=2;
					}
					else if ( ((LA4_1 >= '\u0000' && LA4_1 <= '.')||(LA4_1 >= '0' && LA4_1 <= '\uFFFF')) ) {
						alt4=1;
					}

				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:493:40: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop4;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "TAB"
	public final void mTAB() throws RecognitionException {
		try {
			int _type = TAB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:496:5: ( '\\t' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:496:7: '\\t'
			{
			match('\t'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TAB"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:498:2: ( '\\n' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:498:4: '\\n'
			{
			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "CARRAGE_RET"
	public final void mCARRAGE_RET() throws RecognitionException {
		try {
			int _type = CARRAGE_RET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:501:2: ( '\\r' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:501:4: '\\r'
			{
			match('\r'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CARRAGE_RET"

	// $ANTLR start "WHITESPACE"
	public final void mWHITESPACE() throws RecognitionException {
		try {
			int _type = WHITESPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:505:2: ( ' ' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:505:4: ' '
			{
			match(' '); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHITESPACE"

	// $ANTLR start "FUNCTION_KEY"
	public final void mFUNCTION_KEY() throws RecognitionException {
		try {
			int _type = FUNCTION_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:540:2: ( 'function' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:540:4: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION_KEY"

	// $ANTLR start "BEGIN_KEY"
	public final void mBEGIN_KEY() throws RecognitionException {
		try {
			int _type = BEGIN_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:544:2: ( 'begin' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:544:4: 'begin'
			{
			match("begin"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BEGIN_KEY"

	// $ANTLR start "END_KEY"
	public final void mEND_KEY() throws RecognitionException {
		try {
			int _type = END_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:548:2: ( 'end' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:548:4: 'end'
			{
			match("end"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END_KEY"

	// $ANTLR start "VOID_KEY"
	public final void mVOID_KEY() throws RecognitionException {
		try {
			int _type = VOID_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:552:2: ( 'void' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:552:4: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID_KEY"

	// $ANTLR start "MAIN_KEY"
	public final void mMAIN_KEY() throws RecognitionException {
		try {
			int _type = MAIN_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:556:2: ( 'main' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:556:4: 'main'
			{
			match("main"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN_KEY"

	// $ANTLR start "TYPE_KEY"
	public final void mTYPE_KEY() throws RecognitionException {
		try {
			int _type = TYPE_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:560:2: ( 'type' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:560:4: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE_KEY"

	// $ANTLR start "ARRAY_KEY"
	public final void mARRAY_KEY() throws RecognitionException {
		try {
			int _type = ARRAY_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:2: ( 'array' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:564:4: 'array'
			{
			match("array"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARRAY_KEY"

	// $ANTLR start "OF_KEY"
	public final void mOF_KEY() throws RecognitionException {
		try {
			int _type = OF_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:568:2: ( 'of' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:568:4: 'of'
			{
			match("of"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OF_KEY"

	// $ANTLR start "INT_KEY"
	public final void mINT_KEY() throws RecognitionException {
		try {
			int _type = INT_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:572:2: ( 'int' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:572:4: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_KEY"

	// $ANTLR start "FIXEDPT_KEY"
	public final void mFIXEDPT_KEY() throws RecognitionException {
		try {
			int _type = FIXEDPT_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:576:2: ( 'fixedpt' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:576:4: 'fixedpt'
			{
			match("fixedpt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIXEDPT_KEY"

	// $ANTLR start "VAR_KEY"
	public final void mVAR_KEY() throws RecognitionException {
		try {
			int _type = VAR_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:580:2: ( 'var' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:580:4: 'var'
			{
			match("var"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VAR_KEY"

	// $ANTLR start "IF_KEY"
	public final void mIF_KEY() throws RecognitionException {
		try {
			int _type = IF_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:584:2: ( 'if' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:584:4: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF_KEY"

	// $ANTLR start "THEN_KEY"
	public final void mTHEN_KEY() throws RecognitionException {
		try {
			int _type = THEN_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:588:2: ( 'then' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:588:4: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN_KEY"

	// $ANTLR start "ENDIF_KEY"
	public final void mENDIF_KEY() throws RecognitionException {
		try {
			int _type = ENDIF_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:592:2: ( 'endif' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:592:4: 'endif'
			{
			match("endif"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDIF_KEY"

	// $ANTLR start "ELSE_KEY"
	public final void mELSE_KEY() throws RecognitionException {
		try {
			int _type = ELSE_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:596:2: ( 'else' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:596:4: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE_KEY"

	// $ANTLR start "WHILE_KEY"
	public final void mWHILE_KEY() throws RecognitionException {
		try {
			int _type = WHILE_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:600:2: ( 'while' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:600:4: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE_KEY"

	// $ANTLR start "ENDDO_KEY"
	public final void mENDDO_KEY() throws RecognitionException {
		try {
			int _type = ENDDO_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:604:2: ( 'enddo' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:604:4: 'enddo'
			{
			match("enddo"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENDDO_KEY"

	// $ANTLR start "FOR_KEY"
	public final void mFOR_KEY() throws RecognitionException {
		try {
			int _type = FOR_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:608:2: ( 'for' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:608:4: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR_KEY"

	// $ANTLR start "ID_KEY"
	public final void mID_KEY() throws RecognitionException {
		try {
			int _type = ID_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:612:2: ( 'id' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:612:4: 'id'
			{
			match("id"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID_KEY"

	// $ANTLR start "TO_KEY"
	public final void mTO_KEY() throws RecognitionException {
		try {
			int _type = TO_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:616:2: ( 'to' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:616:4: 'to'
			{
			match("to"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TO_KEY"

	// $ANTLR start "DO_KEY"
	public final void mDO_KEY() throws RecognitionException {
		try {
			int _type = DO_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:620:2: ( 'do' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:620:4: 'do'
			{
			match("do"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DO_KEY"

	// $ANTLR start "BREAK_KEY"
	public final void mBREAK_KEY() throws RecognitionException {
		try {
			int _type = BREAK_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:624:2: ( 'break' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:624:4: 'break'
			{
			match("break"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BREAK_KEY"

	// $ANTLR start "RETURN_KEY"
	public final void mRETURN_KEY() throws RecognitionException {
		try {
			int _type = RETURN_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:628:2: ( 'return' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:628:4: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN_KEY"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:8: ( ',' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:632:10: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:633:8: ( ':' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:633:10: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:634:6: ( ';' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:634:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:635:8: ( '(' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:635:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:636:8: ( ')' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:636:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:637:8: ( '[' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:637:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:638:8: ( ']' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:638:10: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:639:6: ( '+' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:639:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:640:7: ( '-' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:640:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULT"
	public final void mMULT() throws RecognitionException {
		try {
			int _type = MULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:641:6: ( '*' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:641:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:642:5: ( '/' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:642:7: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:643:4: ( '=' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:643:6: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "NEQ"
	public final void mNEQ() throws RecognitionException {
		try {
			int _type = NEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:644:5: ( '<>' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:644:7: '<>'
			{
			match("<>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEQ"

	// $ANTLR start "LESSER"
	public final void mLESSER() throws RecognitionException {
		try {
			int _type = LESSER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:645:8: ( '<' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:645:10: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSER"

	// $ANTLR start "LESSEREQ"
	public final void mLESSEREQ() throws RecognitionException {
		try {
			int _type = LESSEREQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:646:9: ( '<=' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:646:11: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSEREQ"

	// $ANTLR start "GREATER"
	public final void mGREATER() throws RecognitionException {
		try {
			int _type = GREATER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:647:9: ( '>' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:647:11: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER"

	// $ANTLR start "GREATEREQ"
	public final void mGREATEREQ() throws RecognitionException {
		try {
			int _type = GREATEREQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:649:2: ( '>=' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:649:4: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATEREQ"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:650:5: ( '&' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:650:7: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:651:4: ( '|' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:651:6: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:652:8: ( ':=' )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:652:10: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:654:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:654:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:654:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop5;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:8: ( UNSIGNED_INTLIT | UNSIGNED_FIXEDPTLIT | COMMENT | TAB | NEWLINE | CARRAGE_RET | WHITESPACE | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID )
		int alt6=51;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:10: UNSIGNED_INTLIT
				{
				mUNSIGNED_INTLIT(); 

				}
				break;
			case 2 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:26: UNSIGNED_FIXEDPTLIT
				{
				mUNSIGNED_FIXEDPTLIT(); 

				}
				break;
			case 3 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:46: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 4 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:54: TAB
				{
				mTAB(); 

				}
				break;
			case 5 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:58: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 6 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:66: CARRAGE_RET
				{
				mCARRAGE_RET(); 

				}
				break;
			case 7 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:78: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;
			case 8 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:89: FUNCTION_KEY
				{
				mFUNCTION_KEY(); 

				}
				break;
			case 9 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:102: BEGIN_KEY
				{
				mBEGIN_KEY(); 

				}
				break;
			case 10 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:112: END_KEY
				{
				mEND_KEY(); 

				}
				break;
			case 11 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:120: VOID_KEY
				{
				mVOID_KEY(); 

				}
				break;
			case 12 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:129: MAIN_KEY
				{
				mMAIN_KEY(); 

				}
				break;
			case 13 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:138: TYPE_KEY
				{
				mTYPE_KEY(); 

				}
				break;
			case 14 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:147: ARRAY_KEY
				{
				mARRAY_KEY(); 

				}
				break;
			case 15 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:157: OF_KEY
				{
				mOF_KEY(); 

				}
				break;
			case 16 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:164: INT_KEY
				{
				mINT_KEY(); 

				}
				break;
			case 17 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:172: FIXEDPT_KEY
				{
				mFIXEDPT_KEY(); 

				}
				break;
			case 18 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:184: VAR_KEY
				{
				mVAR_KEY(); 

				}
				break;
			case 19 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:192: IF_KEY
				{
				mIF_KEY(); 

				}
				break;
			case 20 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:199: THEN_KEY
				{
				mTHEN_KEY(); 

				}
				break;
			case 21 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:208: ENDIF_KEY
				{
				mENDIF_KEY(); 

				}
				break;
			case 22 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:218: ELSE_KEY
				{
				mELSE_KEY(); 

				}
				break;
			case 23 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:227: WHILE_KEY
				{
				mWHILE_KEY(); 

				}
				break;
			case 24 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:237: ENDDO_KEY
				{
				mENDDO_KEY(); 

				}
				break;
			case 25 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:247: FOR_KEY
				{
				mFOR_KEY(); 

				}
				break;
			case 26 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:255: ID_KEY
				{
				mID_KEY(); 

				}
				break;
			case 27 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:262: TO_KEY
				{
				mTO_KEY(); 

				}
				break;
			case 28 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:269: DO_KEY
				{
				mDO_KEY(); 

				}
				break;
			case 29 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:276: BREAK_KEY
				{
				mBREAK_KEY(); 

				}
				break;
			case 30 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:286: RETURN_KEY
				{
				mRETURN_KEY(); 

				}
				break;
			case 31 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:297: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 32 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:303: COLON
				{
				mCOLON(); 

				}
				break;
			case 33 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:309: SEMI
				{
				mSEMI(); 

				}
				break;
			case 34 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:314: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 35 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:321: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 36 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:328: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 37 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:335: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 38 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:342: PLUS
				{
				mPLUS(); 

				}
				break;
			case 39 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:347: MINUS
				{
				mMINUS(); 

				}
				break;
			case 40 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:353: MULT
				{
				mMULT(); 

				}
				break;
			case 41 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:358: DIV
				{
				mDIV(); 

				}
				break;
			case 42 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:362: EQ
				{
				mEQ(); 

				}
				break;
			case 43 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:365: NEQ
				{
				mNEQ(); 

				}
				break;
			case 44 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:369: LESSER
				{
				mLESSER(); 

				}
				break;
			case 45 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:376: LESSEREQ
				{
				mLESSEREQ(); 

				}
				break;
			case 46 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:385: GREATER
				{
				mGREATER(); 

				}
				break;
			case 47 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:393: GREATEREQ
				{
				mGREATEREQ(); 

				}
				break;
			case 48 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:403: AND
				{
				mAND(); 

				}
				break;
			case 49 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:407: OR
				{
				mOR(); 

				}
				break;
			case 50 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:410: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 51 :
				// /Users/cevanish12/Desktop/CS4240/tiger-compiler/tiger.g:1:417: ID
				{
				mID(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\1\uffff\1\44\1\uffff\1\46\4\uffff\14\43\1\uffff\1\75\11\uffff\1\100\1"+
		"\102\6\uffff\14\43\1\117\1\43\1\121\1\43\1\123\1\124\1\43\1\126\1\43\7"+
		"\uffff\2\43\1\132\2\43\1\137\2\43\1\142\3\43\1\uffff\1\43\1\uffff\1\147"+
		"\2\uffff\1\43\1\uffff\3\43\1\uffff\4\43\1\uffff\1\160\1\161\1\uffff\1"+
		"\162\1\163\1\164\1\43\1\uffff\4\43\1\172\1\173\1\174\1\175\5\uffff\1\176"+
		"\1\177\3\43\6\uffff\1\u0083\1\43\1\u0085\1\uffff\1\u0086\2\uffff";
	static final String DFA6_eofS =
		"\u0087\uffff";
	static final String DFA6_minS =
		"\1\11\1\56\1\uffff\1\52\4\uffff\1\151\1\145\1\154\2\141\1\150\1\162\1"+
		"\146\1\144\1\150\1\157\1\145\1\uffff\1\75\11\uffff\2\75\6\uffff\1\156"+
		"\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145\1\60"+
		"\1\162\1\60\1\164\2\60\1\151\1\60\1\164\7\uffff\1\143\1\145\1\60\1\151"+
		"\1\141\1\60\1\145\1\144\1\60\1\156\1\145\1\156\1\uffff\1\141\1\uffff\1"+
		"\60\2\uffff\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1\156\1\153\1\146"+
		"\1\157\1\uffff\2\60\1\uffff\3\60\1\171\1\uffff\1\145\1\162\1\151\1\160"+
		"\4\60\5\uffff\2\60\1\156\1\157\1\164\6\uffff\1\60\1\156\1\60\1\uffff\1"+
		"\60\2\uffff";
	static final String DFA6_maxS =
		"\1\174\1\71\1\uffff\1\52\4\uffff\1\165\1\162\1\156\1\157\1\141\1\171\1"+
		"\162\1\146\1\156\1\150\1\157\1\145\1\uffff\1\75\11\uffff\1\76\1\75\6\uffff"+
		"\1\156\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145"+
		"\1\172\1\162\1\172\1\164\2\172\1\151\1\172\1\164\7\uffff\1\143\1\145\1"+
		"\172\1\151\1\141\1\172\1\145\1\144\1\172\1\156\1\145\1\156\1\uffff\1\141"+
		"\1\uffff\1\172\2\uffff\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1\156\1"+
		"\153\1\146\1\157\1\uffff\2\172\1\uffff\3\172\1\171\1\uffff\1\145\1\162"+
		"\1\151\1\160\4\172\5\uffff\2\172\1\156\1\157\1\164\6\uffff\1\172\1\156"+
		"\1\172\1\uffff\1\172\2\uffff";
	static final String DFA6_acceptS =
		"\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\14\uffff\1\37\1\uffff\1\41\1\42\1"+
		"\43\1\44\1\45\1\46\1\47\1\50\1\52\2\uffff\1\60\1\61\1\63\1\1\1\3\1\51"+
		"\25\uffff\1\62\1\40\1\53\1\55\1\54\1\57\1\56\14\uffff\1\33\1\uffff\1\17"+
		"\1\uffff\1\23\1\32\1\uffff\1\34\3\uffff\1\31\4\uffff\1\12\2\uffff\1\22"+
		"\4\uffff\1\20\10\uffff\1\26\1\13\1\14\1\15\1\24\5\uffff\1\11\1\35\1\25"+
		"\1\30\1\16\1\27\3\uffff\1\36\1\uffff\1\21\1\10";
	static final String DFA6_specialS =
		"\u0087\uffff}>";
	static final String[] DFA6_transitionS = {
			"\1\4\1\5\2\uffff\1\6\22\uffff\1\7\5\uffff\1\41\1\uffff\1\27\1\30\1\35"+
			"\1\33\1\24\1\34\1\2\1\3\12\1\1\25\1\26\1\37\1\36\1\40\2\uffff\32\43\1"+
			"\31\1\uffff\1\32\1\uffff\1\43\1\uffff\1\16\1\11\1\43\1\22\1\12\1\10\2"+
			"\43\1\20\3\43\1\14\1\43\1\17\2\43\1\23\1\43\1\15\1\43\1\13\1\21\3\43"+
			"\1\uffff\1\42",
			"\1\2\1\uffff\12\1",
			"",
			"\1\45",
			"",
			"",
			"",
			"",
			"\1\50\5\uffff\1\51\5\uffff\1\47",
			"\1\52\14\uffff\1\53",
			"\1\55\1\uffff\1\54",
			"\1\57\15\uffff\1\56",
			"\1\60",
			"\1\62\6\uffff\1\63\11\uffff\1\61",
			"\1\64",
			"\1\65",
			"\1\70\1\uffff\1\67\7\uffff\1\66",
			"\1\71",
			"\1\72",
			"\1\73",
			"",
			"\1\74",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\77\1\76",
			"\1\101",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\120",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\122",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\125",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\127",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\130",
			"\1\131",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\133",
			"\1\134",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\3\43\1\136\4\43\1\135\21\43",
			"\1\140",
			"\1\141",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\143",
			"\1\144",
			"\1\145",
			"",
			"\1\146",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"\1\150",
			"",
			"\1\151",
			"\1\152",
			"\1\153",
			"",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\165",
			"",
			"\1\166",
			"\1\167",
			"\1\170",
			"\1\171",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0080",
			"\1\u0081",
			"\1\u0082",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0084",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			""
	};

	static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
	static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
	static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
	static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
	static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
	static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
	static final short[][] DFA6_transition;

	static {
		int numStates = DFA6_transitionS.length;
		DFA6_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
		}
	}

	protected class DFA6 extends DFA {

		public DFA6(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 6;
			this.eot = DFA6_eot;
			this.eof = DFA6_eof;
			this.min = DFA6_min;
			this.max = DFA6_max;
			this.accept = DFA6_accept;
			this.special = DFA6_special;
			this.transition = DFA6_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( UNSIGNED_INTLIT | UNSIGNED_FIXEDPTLIT | COMMENT | TAB | NEWLINE | CARRAGE_RET | WHITESPACE | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID );";
		}
	}

}
