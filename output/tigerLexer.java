// $ANTLR 3.5.1 C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g 2014-10-19 19:53:32

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g"; }

	// $ANTLR start "INTLIT"
	public final void mINTLIT() throws RecognitionException {
		try {
			int _type = INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:8: ( ( MINUS )? ( '0' .. '9' )+ )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:10: ( MINUS )? ( '0' .. '9' )+
			{
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:10: ( MINUS )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='-') ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
					{
					if ( input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:204:17: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTLIT"

	// $ANTLR start "FIXEDPTLIT"
	public final void mFIXEDPTLIT() throws RecognitionException {
		try {
			int _type = FIXEDPTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:207:2: ( INTLIT '.' ( '0' .. '9' )* | '.' ( '0' .. '9' )+ )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='-'||(LA5_0 >= '0' && LA5_0 <= '9')) ) {
				alt5=1;
			}
			else if ( (LA5_0=='.') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:207:6: INTLIT '.' ( '0' .. '9' )*
					{
					mINTLIT(); 

					match('.'); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:207:17: ( '0' .. '9' )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
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
					break;
				case 2 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:208:6: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:208:10: ( '0' .. '9' )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
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
							if ( cnt4 >= 1 ) break loop4;
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIXEDPTLIT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:233:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:233:7: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:233:12: ( options {greedy=false; } : . )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='*') ) {
					int LA6_1 = input.LA(2);
					if ( (LA6_1=='/') ) {
						alt6=2;
					}
					else if ( ((LA6_1 >= '\u0000' && LA6_1 <= '.')||(LA6_1 >= '0' && LA6_1 <= '\uFFFF')) ) {
						alt6=1;
					}

				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= ')')||(LA6_0 >= '+' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:233:40: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop6;
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:236:5: ( '\\t' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:236:7: '\\t'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:238:2: ( '\\n' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:238:4: '\\n'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:241:2: ( '\\r' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:241:4: '\\r'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:2: ( ' ' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:245:4: ' '
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:283:2: ( 'function' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:283:4: 'function'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:287:2: ( 'begin' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:287:4: 'begin'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:291:2: ( 'end' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:291:4: 'end'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:295:2: ( 'void' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:295:4: 'void'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:299:2: ( 'main' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:299:4: 'main'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:303:2: ( 'type' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:303:4: 'type'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:307:2: ( 'array' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:307:4: 'array'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:311:2: ( 'of' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:311:4: 'of'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:315:2: ( 'int' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:315:4: 'int'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:319:2: ( 'fixedpt' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:319:4: 'fixedpt'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:323:2: ( 'var' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:323:4: 'var'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:327:2: ( 'if' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:327:4: 'if'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:331:2: ( 'then' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:331:4: 'then'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:335:2: ( 'endif' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:335:4: 'endif'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:339:2: ( 'else' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:339:4: 'else'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:343:2: ( 'while' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:343:4: 'while'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:347:2: ( 'enddo' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:347:4: 'enddo'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:351:2: ( 'for' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:351:4: 'for'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:355:2: ( 'id' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:355:4: 'id'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:359:2: ( 'to' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:359:4: 'to'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:363:2: ( 'do' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:363:4: 'do'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:367:2: ( 'break' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:367:4: 'break'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:371:2: ( 'return' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:371:4: 'return'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:375:8: ( ',' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:375:10: ','
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:376:8: ( ':' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:376:10: ':'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:377:6: ( ';' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:377:8: ';'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:378:8: ( '(' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:378:10: '('
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:379:8: ( ')' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:379:10: ')'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:380:8: ( '[' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:380:10: '['
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:381:8: ( ']' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:381:10: ']'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:382:6: ( '+' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:382:8: '+'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:383:7: ( '-' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:383:9: '-'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:384:6: ( '*' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:384:8: '*'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:385:5: ( '/' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:385:7: '/'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:386:4: ( '=' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:386:6: '='
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:387:5: ( '<>' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:387:7: '<>'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:388:8: ( '<' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:388:10: '<'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:389:9: ( '<=' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:389:11: '<='
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:390:9: ( '>' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:390:11: '>'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:392:2: ( '>=' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:392:4: '>='
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:393:5: ( '&' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:393:7: '&'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:394:4: ( '|' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:394:6: '|'
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:395:8: ( ':=' )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:395:10: ':='
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
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:397:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:397:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:397:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:
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
					break loop7;
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
		// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:8: ( INTLIT | FIXEDPTLIT | COMMENT | TAB | NEWLINE | CARRAGE_RET | WHITESPACE | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID )
		int alt8=51;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:10: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 2 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:17: FIXEDPTLIT
				{
				mFIXEDPTLIT(); 

				}
				break;
			case 3 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:28: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 4 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:36: TAB
				{
				mTAB(); 

				}
				break;
			case 5 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:40: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 6 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:48: CARRAGE_RET
				{
				mCARRAGE_RET(); 

				}
				break;
			case 7 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:60: WHITESPACE
				{
				mWHITESPACE(); 

				}
				break;
			case 8 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:71: FUNCTION_KEY
				{
				mFUNCTION_KEY(); 

				}
				break;
			case 9 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:84: BEGIN_KEY
				{
				mBEGIN_KEY(); 

				}
				break;
			case 10 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:94: END_KEY
				{
				mEND_KEY(); 

				}
				break;
			case 11 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:102: VOID_KEY
				{
				mVOID_KEY(); 

				}
				break;
			case 12 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:111: MAIN_KEY
				{
				mMAIN_KEY(); 

				}
				break;
			case 13 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:120: TYPE_KEY
				{
				mTYPE_KEY(); 

				}
				break;
			case 14 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:129: ARRAY_KEY
				{
				mARRAY_KEY(); 

				}
				break;
			case 15 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:139: OF_KEY
				{
				mOF_KEY(); 

				}
				break;
			case 16 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:146: INT_KEY
				{
				mINT_KEY(); 

				}
				break;
			case 17 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:154: FIXEDPT_KEY
				{
				mFIXEDPT_KEY(); 

				}
				break;
			case 18 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:166: VAR_KEY
				{
				mVAR_KEY(); 

				}
				break;
			case 19 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:174: IF_KEY
				{
				mIF_KEY(); 

				}
				break;
			case 20 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:181: THEN_KEY
				{
				mTHEN_KEY(); 

				}
				break;
			case 21 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:190: ENDIF_KEY
				{
				mENDIF_KEY(); 

				}
				break;
			case 22 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:200: ELSE_KEY
				{
				mELSE_KEY(); 

				}
				break;
			case 23 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:209: WHILE_KEY
				{
				mWHILE_KEY(); 

				}
				break;
			case 24 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:219: ENDDO_KEY
				{
				mENDDO_KEY(); 

				}
				break;
			case 25 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:229: FOR_KEY
				{
				mFOR_KEY(); 

				}
				break;
			case 26 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:237: ID_KEY
				{
				mID_KEY(); 

				}
				break;
			case 27 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:244: TO_KEY
				{
				mTO_KEY(); 

				}
				break;
			case 28 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:251: DO_KEY
				{
				mDO_KEY(); 

				}
				break;
			case 29 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:258: BREAK_KEY
				{
				mBREAK_KEY(); 

				}
				break;
			case 30 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:268: RETURN_KEY
				{
				mRETURN_KEY(); 

				}
				break;
			case 31 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:279: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 32 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:285: COLON
				{
				mCOLON(); 

				}
				break;
			case 33 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:291: SEMI
				{
				mSEMI(); 

				}
				break;
			case 34 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:296: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 35 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:303: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 36 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:310: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 37 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:317: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 38 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:324: PLUS
				{
				mPLUS(); 

				}
				break;
			case 39 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:329: MINUS
				{
				mMINUS(); 

				}
				break;
			case 40 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:335: MULT
				{
				mMULT(); 

				}
				break;
			case 41 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:340: DIV
				{
				mDIV(); 

				}
				break;
			case 42 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:344: EQ
				{
				mEQ(); 

				}
				break;
			case 43 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:347: NEQ
				{
				mNEQ(); 

				}
				break;
			case 44 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:351: LESSER
				{
				mLESSER(); 

				}
				break;
			case 45 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:358: LESSEREQ
				{
				mLESSEREQ(); 

				}
				break;
			case 46 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:367: GREATER
				{
				mGREATER(); 

				}
				break;
			case 47 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:375: GREATEREQ
				{
				mGREATEREQ(); 

				}
				break;
			case 48 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:385: AND
				{
				mAND(); 

				}
				break;
			case 49 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:389: OR
				{
				mOR(); 

				}
				break;
			case 50 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:392: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 51 :
				// C:\\Users\\Jinhai Steakhouse\\OneDrive\\College\\CS 4240\\tiger-compiler\\tiger.g:1:399: ID
				{
				mID(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\44\1\45\1\uffff\1\47\4\uffff\14\43\1\uffff\1\76\10\uffff\1"+
		"\101\1\103\7\uffff\14\43\1\120\1\43\1\122\1\43\1\124\1\125\1\43\1\127"+
		"\1\43\7\uffff\2\43\1\133\2\43\1\140\2\43\1\143\3\43\1\uffff\1\43\1\uffff"+
		"\1\150\2\uffff\1\43\1\uffff\3\43\1\uffff\4\43\1\uffff\1\161\1\162\1\uffff"+
		"\1\163\1\164\1\165\1\43\1\uffff\4\43\1\173\1\174\1\175\1\176\5\uffff\1"+
		"\177\1\u0080\3\43\6\uffff\1\u0084\1\43\1\u0086\1\uffff\1\u0087\2\uffff";
	static final String DFA8_eofS =
		"\u0088\uffff";
	static final String DFA8_minS =
		"\1\11\1\60\1\56\1\uffff\1\52\4\uffff\1\151\1\145\1\154\2\141\1\150\1\162"+
		"\1\146\1\144\1\150\1\157\1\145\1\uffff\1\75\10\uffff\2\75\7\uffff\1\156"+
		"\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145\1\60"+
		"\1\162\1\60\1\164\2\60\1\151\1\60\1\164\7\uffff\1\143\1\145\1\60\1\151"+
		"\1\141\1\60\1\145\1\144\1\60\1\156\1\145\1\156\1\uffff\1\141\1\uffff\1"+
		"\60\2\uffff\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1\156\1\153\1\146"+
		"\1\157\1\uffff\2\60\1\uffff\3\60\1\171\1\uffff\1\145\1\162\1\151\1\160"+
		"\4\60\5\uffff\2\60\1\156\1\157\1\164\6\uffff\1\60\1\156\1\60\1\uffff\1"+
		"\60\2\uffff";
	static final String DFA8_maxS =
		"\1\174\2\71\1\uffff\1\52\4\uffff\1\165\1\162\1\156\1\157\1\141\1\171\1"+
		"\162\1\146\1\156\1\150\1\157\1\145\1\uffff\1\75\10\uffff\1\76\1\75\7\uffff"+
		"\1\156\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145"+
		"\1\172\1\162\1\172\1\164\2\172\1\151\1\172\1\164\7\uffff\1\143\1\145\1"+
		"\172\1\151\1\141\1\172\1\145\1\144\1\172\1\156\1\145\1\156\1\uffff\1\141"+
		"\1\uffff\1\172\2\uffff\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1\156\1"+
		"\153\1\146\1\157\1\uffff\2\172\1\uffff\3\172\1\171\1\uffff\1\145\1\162"+
		"\1\151\1\160\4\172\5\uffff\2\172\1\156\1\157\1\164\6\uffff\1\172\1\156"+
		"\1\172\1\uffff\1\172\2\uffff";
	static final String DFA8_acceptS =
		"\3\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\14\uffff\1\37\1\uffff\1\41\1\42\1"+
		"\43\1\44\1\45\1\46\1\50\1\52\2\uffff\1\60\1\61\1\63\1\47\1\1\1\3\1\51"+
		"\25\uffff\1\62\1\40\1\53\1\55\1\54\1\57\1\56\14\uffff\1\33\1\uffff\1\17"+
		"\1\uffff\1\23\1\32\1\uffff\1\34\3\uffff\1\31\4\uffff\1\12\2\uffff\1\22"+
		"\4\uffff\1\20\10\uffff\1\26\1\13\1\14\1\15\1\24\5\uffff\1\11\1\35\1\25"+
		"\1\30\1\16\1\27\3\uffff\1\36\1\uffff\1\21\1\10";
	static final String DFA8_specialS =
		"\u0088\uffff}>";
	static final String[] DFA8_transitionS = {
			"\1\5\1\6\2\uffff\1\7\22\uffff\1\10\5\uffff\1\41\1\uffff\1\30\1\31\1\35"+
			"\1\34\1\25\1\1\1\3\1\4\12\2\1\26\1\27\1\37\1\36\1\40\2\uffff\32\43\1"+
			"\32\1\uffff\1\33\1\uffff\1\43\1\uffff\1\17\1\12\1\43\1\23\1\13\1\11\2"+
			"\43\1\21\3\43\1\15\1\43\1\20\2\43\1\24\1\43\1\16\1\43\1\14\1\22\3\43"+
			"\1\uffff\1\42",
			"\12\2",
			"\1\3\1\uffff\12\2",
			"",
			"\1\46",
			"",
			"",
			"",
			"",
			"\1\51\5\uffff\1\52\5\uffff\1\50",
			"\1\53\14\uffff\1\54",
			"\1\56\1\uffff\1\55",
			"\1\60\15\uffff\1\57",
			"\1\61",
			"\1\63\6\uffff\1\64\11\uffff\1\62",
			"\1\65",
			"\1\66",
			"\1\71\1\uffff\1\70\7\uffff\1\67",
			"\1\72",
			"\1\73",
			"\1\74",
			"",
			"\1\75",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\100\1\77",
			"\1\102",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
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
			"\1\117",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\121",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\123",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\126",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\130",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\131",
			"\1\132",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\134",
			"\1\135",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\3\43\1\137\4\43\1\136\21\43",
			"\1\141",
			"\1\142",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\144",
			"\1\145",
			"\1\146",
			"",
			"\1\147",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"",
			"\1\151",
			"",
			"\1\152",
			"\1\153",
			"\1\154",
			"",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\160",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\166",
			"",
			"\1\167",
			"\1\170",
			"\1\171",
			"\1\172",
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
			"\1\u0081",
			"\1\u0082",
			"\1\u0083",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"\1\u0085",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			"\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32\43",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( INTLIT | FIXEDPTLIT | COMMENT | TAB | NEWLINE | CARRAGE_RET | WHITESPACE | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID );";
		}
	}

}
