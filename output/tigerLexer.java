// $ANTLR 3.5 /media/sf_College/CS 4240/tiger-compiler/tiger.g 2014-09-30 18:12:24

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
	@Override public String getGrammarFileName() { return "/media/sf_College/CS 4240/tiger-compiler/tiger.g"; }

	// $ANTLR start "INTLIT"
	public final void mINTLIT() throws RecognitionException {
		try {
			int _type = INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:119:8: ( ( '0' .. '9' )+ )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:119:10: ( '0' .. '9' )+
			{
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:119:10: ( '0' .. '9' )+
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
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:
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
	// $ANTLR end "INTLIT"

	// $ANTLR start "FIXEDPTLIT"
	public final void mFIXEDPTLIT() throws RecognitionException {
		try {
			int _type = FIXEDPTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:122:5: ( INTLIT '.' ( '0' .. '9' )* | '.' ( '0' .. '9' )+ )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
				alt4=1;
			}
			else if ( (LA4_0=='.') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:122:9: INTLIT '.' ( '0' .. '9' )*
					{
					mINTLIT(); 

					match('.'); 
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:122:20: ( '0' .. '9' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /media/sf_College/CS 4240/tiger-compiler/tiger.g:
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

					}
					break;
				case 2 :
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:123:9: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:123:13: ( '0' .. '9' )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /media/sf_College/CS 4240/tiger-compiler/tiger.g:
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
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:154:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:154:10: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:154:15: ( options {greedy=false; } : . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='*') ) {
					int LA5_1 = input.LA(2);
					if ( (LA5_1=='/') ) {
						alt5=2;
					}
					else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
						alt5=1;
					}

				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:154:43: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
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

	// $ANTLR start "FUNCTION_KEY"
	public final void mFUNCTION_KEY() throws RecognitionException {
		try {
			int _type = FUNCTION_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:185:2: ( 'function' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:185:4: 'function'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:189:2: ( 'begin' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:189:4: 'begin'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:193:2: ( 'end' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:193:4: 'end'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:197:2: ( 'void' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:197:4: 'void'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:201:2: ( 'main' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:201:4: 'main'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:205:2: ( 'type' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:205:4: 'type'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:209:2: ( 'array' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:209:4: 'array'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:213:2: ( 'of' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:213:4: 'of'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:217:2: ( 'int' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:217:4: 'int'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:221:2: ( 'fixedpt' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:221:4: 'fixedpt'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:225:2: ( 'var' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:225:4: 'var'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:229:2: ( 'if' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:229:4: 'if'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:233:2: ( 'then' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:233:4: 'then'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:237:2: ( 'endif' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:237:4: 'endif'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:241:2: ( 'else' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:241:4: 'else'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:245:2: ( 'while' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:245:4: 'while'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:249:2: ( 'enddo' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:249:4: 'enddo'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:253:2: ( 'for' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:253:4: 'for'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:257:2: ( 'id' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:257:4: 'id'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:261:2: ( 'to' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:261:4: 'to'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:265:2: ( 'do' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:265:4: 'do'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:269:2: ( 'break' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:269:4: 'break'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:273:2: ( 'return' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:273:4: 'return'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:277:8: ( ',' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:277:10: ','
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:278:8: ( ':' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:278:10: ':'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:279:6: ( ';' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:279:8: ';'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:280:8: ( '(' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:280:10: '('
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:281:8: ( ')' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:281:10: ')'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:282:8: ( '[' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:282:10: '['
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:283:8: ( ']' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:283:10: ']'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:284:6: ( '+' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:284:8: '+'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:285:7: ( '-' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:285:9: '-'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:286:6: ( '*' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:286:8: '*'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:287:5: ( '/' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:287:7: '/'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:288:4: ( '=' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:288:6: '='
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:289:5: ( '<>' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:289:7: '<>'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:290:8: ( '<' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:290:10: '<'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:291:9: ( '<=' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:291:11: '<='
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:292:9: ( '>' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:292:11: '>'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:294:2: ( '>=' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:294:4: '>='
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:295:5: ( '&' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:295:7: '&'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:296:4: ( '|' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:296:6: '|'
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:297:8: ( ':=' )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:297:10: ':='
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
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:299:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:299:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /media/sf_College/CS 4240/tiger-compiler/tiger.g:299:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /media/sf_College/CS 4240/tiger-compiler/tiger.g:
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
					break loop6;
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
		// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:8: ( INTLIT | FIXEDPTLIT | COMMENT | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID )
		int alt7=47;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:10: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 2 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:17: FIXEDPTLIT
				{
				mFIXEDPTLIT(); 

				}
				break;
			case 3 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:28: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 4 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:36: FUNCTION_KEY
				{
				mFUNCTION_KEY(); 

				}
				break;
			case 5 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:49: BEGIN_KEY
				{
				mBEGIN_KEY(); 

				}
				break;
			case 6 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:59: END_KEY
				{
				mEND_KEY(); 

				}
				break;
			case 7 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:67: VOID_KEY
				{
				mVOID_KEY(); 

				}
				break;
			case 8 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:76: MAIN_KEY
				{
				mMAIN_KEY(); 

				}
				break;
			case 9 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:85: TYPE_KEY
				{
				mTYPE_KEY(); 

				}
				break;
			case 10 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:94: ARRAY_KEY
				{
				mARRAY_KEY(); 

				}
				break;
			case 11 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:104: OF_KEY
				{
				mOF_KEY(); 

				}
				break;
			case 12 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:111: INT_KEY
				{
				mINT_KEY(); 

				}
				break;
			case 13 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:119: FIXEDPT_KEY
				{
				mFIXEDPT_KEY(); 

				}
				break;
			case 14 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:131: VAR_KEY
				{
				mVAR_KEY(); 

				}
				break;
			case 15 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:139: IF_KEY
				{
				mIF_KEY(); 

				}
				break;
			case 16 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:146: THEN_KEY
				{
				mTHEN_KEY(); 

				}
				break;
			case 17 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:155: ENDIF_KEY
				{
				mENDIF_KEY(); 

				}
				break;
			case 18 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:165: ELSE_KEY
				{
				mELSE_KEY(); 

				}
				break;
			case 19 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:174: WHILE_KEY
				{
				mWHILE_KEY(); 

				}
				break;
			case 20 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:184: ENDDO_KEY
				{
				mENDDO_KEY(); 

				}
				break;
			case 21 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:194: FOR_KEY
				{
				mFOR_KEY(); 

				}
				break;
			case 22 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:202: ID_KEY
				{
				mID_KEY(); 

				}
				break;
			case 23 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:209: TO_KEY
				{
				mTO_KEY(); 

				}
				break;
			case 24 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:216: DO_KEY
				{
				mDO_KEY(); 

				}
				break;
			case 25 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:223: BREAK_KEY
				{
				mBREAK_KEY(); 

				}
				break;
			case 26 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:233: RETURN_KEY
				{
				mRETURN_KEY(); 

				}
				break;
			case 27 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:244: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 28 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:250: COLON
				{
				mCOLON(); 

				}
				break;
			case 29 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:256: SEMI
				{
				mSEMI(); 

				}
				break;
			case 30 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:261: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 31 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:268: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 32 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:275: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 33 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:282: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 34 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:289: PLUS
				{
				mPLUS(); 

				}
				break;
			case 35 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:294: MINUS
				{
				mMINUS(); 

				}
				break;
			case 36 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:300: MULT
				{
				mMULT(); 

				}
				break;
			case 37 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:305: DIV
				{
				mDIV(); 

				}
				break;
			case 38 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:309: EQ
				{
				mEQ(); 

				}
				break;
			case 39 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:312: NEQ
				{
				mNEQ(); 

				}
				break;
			case 40 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:316: LESSER
				{
				mLESSER(); 

				}
				break;
			case 41 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:323: LESSEREQ
				{
				mLESSEREQ(); 

				}
				break;
			case 42 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:332: GREATER
				{
				mGREATER(); 

				}
				break;
			case 43 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:340: GREATEREQ
				{
				mGREATEREQ(); 

				}
				break;
			case 44 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:350: AND
				{
				mAND(); 

				}
				break;
			case 45 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:354: OR
				{
				mOR(); 

				}
				break;
			case 46 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:357: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 47 :
				// /media/sf_College/CS 4240/tiger-compiler/tiger.g:1:364: ID
				{
				mID(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\1\uffff\1\40\1\uffff\1\42\14\37\1\uffff\1\71\11\uffff\1\74\1\76\6\uffff"+
		"\14\37\1\113\1\37\1\115\1\37\1\117\1\120\1\37\1\122\1\37\7\uffff\2\37"+
		"\1\126\2\37\1\133\2\37\1\136\3\37\1\uffff\1\37\1\uffff\1\143\2\uffff\1"+
		"\37\1\uffff\3\37\1\uffff\4\37\1\uffff\1\154\1\155\1\uffff\1\156\1\157"+
		"\1\160\1\37\1\uffff\4\37\1\166\1\167\1\170\1\171\5\uffff\1\172\1\173\3"+
		"\37\6\uffff\1\177\1\37\1\u0081\1\uffff\1\u0082\2\uffff";
	static final String DFA7_eofS =
		"\u0083\uffff";
	static final String DFA7_minS =
		"\1\46\1\56\1\uffff\1\52\1\151\1\145\1\154\2\141\1\150\1\162\1\146\1\144"+
		"\1\150\1\157\1\145\1\uffff\1\75\11\uffff\2\75\6\uffff\1\156\1\170\1\162"+
		"\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145\1\60\1\162\1\60"+
		"\1\164\2\60\1\151\1\60\1\164\7\uffff\1\143\1\145\1\60\1\151\1\141\1\60"+
		"\1\145\1\144\1\60\1\156\1\145\1\156\1\uffff\1\141\1\uffff\1\60\2\uffff"+
		"\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1\156\1\153\1\146\1\157\1\uffff"+
		"\2\60\1\uffff\3\60\1\171\1\uffff\1\145\1\162\1\151\1\160\4\60\5\uffff"+
		"\2\60\1\156\1\157\1\164\6\uffff\1\60\1\156\1\60\1\uffff\1\60\2\uffff";
	static final String DFA7_maxS =
		"\1\174\1\71\1\uffff\1\52\1\165\1\162\1\156\1\157\1\141\1\171\1\162\1\146"+
		"\1\156\1\150\1\157\1\145\1\uffff\1\75\11\uffff\1\76\1\75\6\uffff\1\156"+
		"\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\162\1\151\1\160\1\145\1\172"+
		"\1\162\1\172\1\164\2\172\1\151\1\172\1\164\7\uffff\1\143\1\145\1\172\1"+
		"\151\1\141\1\172\1\145\1\144\1\172\1\156\1\145\1\156\1\uffff\1\141\1\uffff"+
		"\1\172\2\uffff\1\154\1\uffff\1\165\1\164\1\144\1\uffff\1\156\1\153\1\146"+
		"\1\157\1\uffff\2\172\1\uffff\3\172\1\171\1\uffff\1\145\1\162\1\151\1\160"+
		"\4\172\5\uffff\2\172\1\156\1\157\1\164\6\uffff\1\172\1\156\1\172\1\uffff"+
		"\1\172\2\uffff";
	static final String DFA7_acceptS =
		"\2\uffff\1\2\15\uffff\1\33\1\uffff\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
		"\1\44\1\46\2\uffff\1\54\1\55\1\57\1\1\1\3\1\45\25\uffff\1\56\1\34\1\47"+
		"\1\51\1\50\1\53\1\52\14\uffff\1\27\1\uffff\1\13\1\uffff\1\17\1\26\1\uffff"+
		"\1\30\3\uffff\1\25\4\uffff\1\6\2\uffff\1\16\4\uffff\1\14\10\uffff\1\22"+
		"\1\7\1\10\1\11\1\20\5\uffff\1\5\1\31\1\21\1\24\1\12\1\23\3\uffff\1\32"+
		"\1\uffff\1\15\1\4";
	static final String DFA7_specialS =
		"\u0083\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\35\1\uffff\1\23\1\24\1\31\1\27\1\20\1\30\1\2\1\3\12\1\1\21\1\22\1"+
			"\33\1\32\1\34\2\uffff\32\37\1\25\1\uffff\1\26\1\uffff\1\37\1\uffff\1"+
			"\12\1\5\1\37\1\16\1\6\1\4\2\37\1\14\3\37\1\10\1\37\1\13\2\37\1\17\1\37"+
			"\1\11\1\37\1\7\1\15\3\37\1\uffff\1\36",
			"\1\2\1\uffff\12\1",
			"",
			"\1\41",
			"\1\44\5\uffff\1\45\5\uffff\1\43",
			"\1\46\14\uffff\1\47",
			"\1\51\1\uffff\1\50",
			"\1\53\15\uffff\1\52",
			"\1\54",
			"\1\56\6\uffff\1\57\11\uffff\1\55",
			"\1\60",
			"\1\61",
			"\1\64\1\uffff\1\63\7\uffff\1\62",
			"\1\65",
			"\1\66",
			"\1\67",
			"",
			"\1\70",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\73\1\72",
			"\1\75",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\114",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\116",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\121",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\123",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\124",
			"\1\125",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\127",
			"\1\130",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\3\37\1\132\4\37\1\131\21\37",
			"\1\134",
			"\1\135",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\137",
			"\1\140",
			"\1\141",
			"",
			"\1\142",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"\1\144",
			"",
			"\1\145",
			"\1\146",
			"\1\147",
			"",
			"\1\150",
			"\1\151",
			"\1\152",
			"\1\153",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\161",
			"",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\174",
			"\1\175",
			"\1\176",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u0080",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( INTLIT | FIXEDPTLIT | COMMENT | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID );";
		}
	}

}
