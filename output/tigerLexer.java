// $ANTLR 3.5 C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g 2014-10-05 18:59:12

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
	@Override public String getGrammarFileName() { return "C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g"; }

	// $ANTLR start "INTLIT"
	public final void mINTLIT() throws RecognitionException {
		try {
			int _type = INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:108:8: ( ( '0' .. '9' )+ )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:108:10: ( '0' .. '9' )+
			{
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:108:10: ( '0' .. '9' )+
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
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:111:5: ( INTLIT '.' ( '0' .. '9' )* | '.' ( '0' .. '9' )+ )
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
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:111:9: INTLIT '.' ( '0' .. '9' )*
					{
					mINTLIT(); 

					match('.'); 
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:111:20: ( '0' .. '9' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
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
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:112:9: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:112:13: ( '0' .. '9' )+
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
							// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:138:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:138:10: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:138:15: ( options {greedy=false; } : . )*
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
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:138:43: .
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

	// $ANTLR start "MAIN_FUNCTION_KEY"
	public final void mMAIN_FUNCTION_KEY() throws RecognitionException {
		try {
			int _type = MAIN_FUNCTION_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:178:2: ( 'void main()' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:178:4: 'void main()'
			{
			match("void main()"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAIN_FUNCTION_KEY"

	// $ANTLR start "FUNCTION_KEY"
	public final void mFUNCTION_KEY() throws RecognitionException {
		try {
			int _type = FUNCTION_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:182:2: ( 'function' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:182:4: 'function'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:186:2: ( 'begin' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:186:4: 'begin'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:190:2: ( 'end' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:190:4: 'end'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:194:2: ( 'void' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:194:4: 'void'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:198:2: ( 'main' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:198:4: 'main'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:202:2: ( 'type' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:202:4: 'type'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:206:2: ( 'array' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:206:4: 'array'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:210:2: ( 'of' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:210:4: 'of'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:214:2: ( 'int' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:214:4: 'int'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:218:2: ( 'fixedpt' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:218:4: 'fixedpt'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:222:2: ( 'var' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:222:4: 'var'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:226:2: ( 'if' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:226:4: 'if'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:230:2: ( 'then' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:230:4: 'then'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:234:2: ( 'endif' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:234:4: 'endif'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:238:2: ( 'else' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:238:4: 'else'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:242:2: ( 'while' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:242:4: 'while'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:246:2: ( 'enddo' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:246:4: 'enddo'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:250:2: ( 'for' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:250:4: 'for'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:254:2: ( 'id' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:254:4: 'id'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:258:2: ( 'to' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:258:4: 'to'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:262:2: ( 'do' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:262:4: 'do'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:266:2: ( 'break' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:266:4: 'break'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:270:2: ( 'return' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:270:4: 'return'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:274:8: ( ',' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:274:10: ','
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

	// $ANTLR start "COMMA_SPACE"
	public final void mCOMMA_SPACE() throws RecognitionException {
		try {
			int _type = COMMA_SPACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:276:3: ( ', ' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:276:5: ', '
			{
			match(", "); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA_SPACE"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:277:8: ( ':' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:277:10: ':'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:278:6: ( ';' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:278:8: ';'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:279:8: ( '(' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:279:10: '('
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:280:8: ( ')' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:280:10: ')'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:281:8: ( '[' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:281:10: '['
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:282:8: ( ']' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:282:10: ']'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:283:6: ( '+' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:283:8: '+'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:284:7: ( '-' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:284:9: '-'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:285:6: ( '*' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:285:8: '*'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:286:5: ( '/' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:286:7: '/'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:287:4: ( '=' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:287:6: '='
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:288:5: ( '<>' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:288:7: '<>'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:289:8: ( '<' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:289:10: '<'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:290:9: ( '<=' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:290:11: '<='
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:291:9: ( '>' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:291:11: '>'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:293:2: ( '>=' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:293:4: '>='
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:294:5: ( '&' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:294:7: '&'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:295:4: ( '|' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:295:6: '|'
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:296:8: ( ':=' )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:296:10: ':='
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
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:298:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:298:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:298:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:
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
		// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:8: ( INTLIT | FIXEDPTLIT | COMMENT | MAIN_FUNCTION_KEY | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COMMA_SPACE | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID )
		int alt7=49;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:10: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 2 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:17: FIXEDPTLIT
				{
				mFIXEDPTLIT(); 

				}
				break;
			case 3 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:28: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 4 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:36: MAIN_FUNCTION_KEY
				{
				mMAIN_FUNCTION_KEY(); 

				}
				break;
			case 5 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:54: FUNCTION_KEY
				{
				mFUNCTION_KEY(); 

				}
				break;
			case 6 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:67: BEGIN_KEY
				{
				mBEGIN_KEY(); 

				}
				break;
			case 7 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:77: END_KEY
				{
				mEND_KEY(); 

				}
				break;
			case 8 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:85: VOID_KEY
				{
				mVOID_KEY(); 

				}
				break;
			case 9 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:94: MAIN_KEY
				{
				mMAIN_KEY(); 

				}
				break;
			case 10 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:103: TYPE_KEY
				{
				mTYPE_KEY(); 

				}
				break;
			case 11 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:112: ARRAY_KEY
				{
				mARRAY_KEY(); 

				}
				break;
			case 12 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:122: OF_KEY
				{
				mOF_KEY(); 

				}
				break;
			case 13 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:129: INT_KEY
				{
				mINT_KEY(); 

				}
				break;
			case 14 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:137: FIXEDPT_KEY
				{
				mFIXEDPT_KEY(); 

				}
				break;
			case 15 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:149: VAR_KEY
				{
				mVAR_KEY(); 

				}
				break;
			case 16 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:157: IF_KEY
				{
				mIF_KEY(); 

				}
				break;
			case 17 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:164: THEN_KEY
				{
				mTHEN_KEY(); 

				}
				break;
			case 18 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:173: ENDIF_KEY
				{
				mENDIF_KEY(); 

				}
				break;
			case 19 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:183: ELSE_KEY
				{
				mELSE_KEY(); 

				}
				break;
			case 20 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:192: WHILE_KEY
				{
				mWHILE_KEY(); 

				}
				break;
			case 21 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:202: ENDDO_KEY
				{
				mENDDO_KEY(); 

				}
				break;
			case 22 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:212: FOR_KEY
				{
				mFOR_KEY(); 

				}
				break;
			case 23 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:220: ID_KEY
				{
				mID_KEY(); 

				}
				break;
			case 24 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:227: TO_KEY
				{
				mTO_KEY(); 

				}
				break;
			case 25 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:234: DO_KEY
				{
				mDO_KEY(); 

				}
				break;
			case 26 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:241: BREAK_KEY
				{
				mBREAK_KEY(); 

				}
				break;
			case 27 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:251: RETURN_KEY
				{
				mRETURN_KEY(); 

				}
				break;
			case 28 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:262: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 29 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:268: COMMA_SPACE
				{
				mCOMMA_SPACE(); 

				}
				break;
			case 30 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:280: COLON
				{
				mCOLON(); 

				}
				break;
			case 31 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:286: SEMI
				{
				mSEMI(); 

				}
				break;
			case 32 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:291: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 33 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:298: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 34 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:305: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 35 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:312: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 36 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:319: PLUS
				{
				mPLUS(); 

				}
				break;
			case 37 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:324: MINUS
				{
				mMINUS(); 

				}
				break;
			case 38 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:330: MULT
				{
				mMULT(); 

				}
				break;
			case 39 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:335: DIV
				{
				mDIV(); 

				}
				break;
			case 40 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:339: EQ
				{
				mEQ(); 

				}
				break;
			case 41 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:342: NEQ
				{
				mNEQ(); 

				}
				break;
			case 42 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:346: LESSER
				{
				mLESSER(); 

				}
				break;
			case 43 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:353: LESSEREQ
				{
				mLESSEREQ(); 

				}
				break;
			case 44 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:362: GREATER
				{
				mGREATER(); 

				}
				break;
			case 45 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:370: GREATEREQ
				{
				mGREATEREQ(); 

				}
				break;
			case 46 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:380: AND
				{
				mAND(); 

				}
				break;
			case 47 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:384: OR
				{
				mOR(); 

				}
				break;
			case 48 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:387: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 49 :
				// C:\\Users\\dcbenas\\Documents\\tiger-compiler\\tiger.g:1:394: ID
				{
				mID(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\1\uffff\1\40\1\uffff\1\42\14\37\1\71\1\73\11\uffff\1\76\1\100\6\uffff"+
		"\14\37\1\115\1\37\1\117\1\37\1\121\1\122\1\37\1\124\1\37\11\uffff\1\37"+
		"\1\127\2\37\1\132\2\37\1\137\4\37\1\uffff\1\37\1\uffff\1\145\2\uffff\1"+
		"\37\1\uffff\1\37\1\151\1\uffff\2\37\1\uffff\4\37\1\uffff\1\160\1\161\1"+
		"\162\1\163\1\37\1\uffff\2\37\2\uffff\2\37\1\171\1\172\1\173\1\174\4\uffff"+
		"\1\175\1\176\3\37\6\uffff\1\u0082\1\37\1\u0084\1\uffff\1\u0085\2\uffff";
	static final String DFA7_eofS =
		"\u0086\uffff";
	static final String DFA7_minS =
		"\1\46\1\56\1\uffff\1\52\1\141\1\151\1\145\1\154\1\141\1\150\1\162\1\146"+
		"\1\144\1\150\1\157\1\145\1\40\1\75\11\uffff\2\75\6\uffff\1\151\1\162\1"+
		"\156\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\160\1\145\1\60\1\162"+
		"\1\60\1\164\2\60\1\151\1\60\1\164\11\uffff\1\144\1\60\1\143\1\145\1\60"+
		"\1\151\1\141\1\60\1\145\1\156\1\145\1\156\1\uffff\1\141\1\uffff\1\60\2"+
		"\uffff\1\154\1\uffff\1\165\1\40\1\uffff\1\164\1\144\1\uffff\1\156\1\153"+
		"\1\146\1\157\1\uffff\4\60\1\171\1\uffff\1\145\1\162\2\uffff\1\151\1\160"+
		"\4\60\4\uffff\2\60\1\156\1\157\1\164\6\uffff\1\60\1\156\1\60\1\uffff\1"+
		"\60\2\uffff";
	static final String DFA7_maxS =
		"\1\174\1\71\1\uffff\1\52\1\157\1\165\1\162\1\156\1\141\1\171\1\162\1\146"+
		"\1\156\1\150\1\157\1\145\1\40\1\75\11\uffff\1\76\1\75\6\uffff\1\151\1"+
		"\162\1\156\1\170\1\162\1\147\1\145\1\144\1\163\1\151\1\160\1\145\1\172"+
		"\1\162\1\172\1\164\2\172\1\151\1\172\1\164\11\uffff\1\144\1\172\1\143"+
		"\1\145\1\172\1\151\1\141\1\172\1\145\1\156\1\145\1\156\1\uffff\1\141\1"+
		"\uffff\1\172\2\uffff\1\154\1\uffff\1\165\1\172\1\uffff\1\164\1\144\1\uffff"+
		"\1\156\1\153\1\146\1\157\1\uffff\4\172\1\171\1\uffff\1\145\1\162\2\uffff"+
		"\1\151\1\160\4\172\4\uffff\2\172\1\156\1\157\1\164\6\uffff\1\172\1\156"+
		"\1\172\1\uffff\1\172\2\uffff";
	static final String DFA7_acceptS =
		"\2\uffff\1\2\17\uffff\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\50\2\uffff"+
		"\1\56\1\57\1\61\1\1\1\3\1\47\25\uffff\1\35\1\34\1\60\1\36\1\51\1\53\1"+
		"\52\1\55\1\54\14\uffff\1\30\1\uffff\1\14\1\uffff\1\20\1\27\1\uffff\1\31"+
		"\2\uffff\1\17\2\uffff\1\26\4\uffff\1\7\5\uffff\1\15\2\uffff\1\4\1\10\6"+
		"\uffff\1\23\1\11\1\12\1\21\5\uffff\1\6\1\32\1\22\1\25\1\13\1\24\3\uffff"+
		"\1\33\1\uffff\1\16\1\5";
	static final String DFA7_specialS =
		"\u0086\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\35\1\uffff\1\23\1\24\1\31\1\27\1\20\1\30\1\2\1\3\12\1\1\21\1\22\1"+
			"\33\1\32\1\34\2\uffff\32\37\1\25\1\uffff\1\26\1\uffff\1\37\1\uffff\1"+
			"\12\1\6\1\37\1\16\1\7\1\5\2\37\1\14\3\37\1\10\1\37\1\13\2\37\1\17\1\37"+
			"\1\11\1\37\1\4\1\15\3\37\1\uffff\1\36",
			"\1\2\1\uffff\12\1",
			"",
			"\1\41",
			"\1\44\15\uffff\1\43",
			"\1\46\5\uffff\1\47\5\uffff\1\45",
			"\1\50\14\uffff\1\51",
			"\1\53\1\uffff\1\52",
			"\1\54",
			"\1\56\6\uffff\1\57\11\uffff\1\55",
			"\1\60",
			"\1\61",
			"\1\64\1\uffff\1\63\7\uffff\1\62",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\72",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\75\1\74",
			"\1\77",
			"",
			"",
			"",
			"",
			"",
			"",
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
			"\1\113",
			"\1\114",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\116",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\120",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\123",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\125",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\126",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\130",
			"\1\131",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\133",
			"\1\134",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\3\37\1\136\4\37\1\135\21\37",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"",
			"\1\144",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"\1\146",
			"",
			"\1\147",
			"\1\150\17\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"\1\152",
			"\1\153",
			"",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\164",
			"",
			"\1\165",
			"\1\166",
			"",
			"",
			"\1\167",
			"\1\170",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
			"\1\u0083",
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
			return "1:1: Tokens : ( INTLIT | FIXEDPTLIT | COMMENT | MAIN_FUNCTION_KEY | FUNCTION_KEY | BEGIN_KEY | END_KEY | VOID_KEY | MAIN_KEY | TYPE_KEY | ARRAY_KEY | OF_KEY | INT_KEY | FIXEDPT_KEY | VAR_KEY | IF_KEY | THEN_KEY | ENDIF_KEY | ELSE_KEY | WHILE_KEY | ENDDO_KEY | FOR_KEY | ID_KEY | TO_KEY | DO_KEY | BREAK_KEY | RETURN_KEY | COMMA | COMMA_SPACE | COLON | SEMI | LPAREN | RPAREN | LBRACK | RBRACK | PLUS | MINUS | MULT | DIV | EQ | NEQ | LESSER | LESSEREQ | GREATER | GREATEREQ | AND | OR | ASSIGN | ID );";
		}
	}

}
