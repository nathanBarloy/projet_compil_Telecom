// $ANTLR 3.5.2 Tiger.g 2018-11-15 14:35:23

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int ADDOP=4;
	public static final int FOR=5;
	public static final int ID=6;
	public static final int IFTHEN=7;
	public static final int INTLIT=8;
	public static final int LETEXP=9;
	public static final int LOGOP=10;
	public static final int MULTEXP=11;
	public static final int MULTOP=12;
	public static final int NEGATION=13;
	public static final int RECTY=14;
	public static final int ROOT=15;
	public static final int STRINGLIT=16;
	public static final int WHILE=17;
	public static final int WS=18;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public TigerLexer() {} 
	public TigerLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public TigerLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "Tiger.g"; }

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:2:7: ( '(' )
			// Tiger.g:2:9: '('
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:3:7: ( ')' )
			// Tiger.g:3:9: ')'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:4:7: ( ',' )
			// Tiger.g:4:9: ','
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:5:7: ( '-' )
			// Tiger.g:5:9: '-'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:6:7: ( '.' )
			// Tiger.g:6:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:7:7: ( ':' )
			// Tiger.g:7:9: ':'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:8:7: ( ':=' )
			// Tiger.g:8:9: ':='
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:9:7: ( ';' )
			// Tiger.g:9:9: ';'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:10:7: ( '=' )
			// Tiger.g:10:9: '='
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:11:7: ( '[' )
			// Tiger.g:11:9: '['
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:12:7: ( ']' )
			// Tiger.g:12:9: ']'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:13:7: ( 'array' )
			// Tiger.g:13:9: 'array'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:14:7: ( 'break' )
			// Tiger.g:14:9: 'break'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:15:7: ( 'do' )
			// Tiger.g:15:9: 'do'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:16:7: ( 'else' )
			// Tiger.g:16:9: 'else'
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:17:7: ( 'end' )
			// Tiger.g:17:9: 'end'
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
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:18:7: ( 'for' )
			// Tiger.g:18:9: 'for'
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
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:19:7: ( 'function' )
			// Tiger.g:19:9: 'function'
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
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:20:7: ( 'if' )
			// Tiger.g:20:9: 'if'
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
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:21:7: ( 'in' )
			// Tiger.g:21:9: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:22:7: ( 'let' )
			// Tiger.g:22:9: 'let'
			{
			match("let"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:23:7: ( 'nil' )
			// Tiger.g:23:9: 'nil'
			{
			match("nil"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:24:7: ( 'of' )
			// Tiger.g:24:9: 'of'
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
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:25:7: ( 'then' )
			// Tiger.g:25:9: 'then'
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
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:26:7: ( 'to' )
			// Tiger.g:26:9: 'to'
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
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:27:7: ( 'type' )
			// Tiger.g:27:9: 'type'
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
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:28:7: ( 'var' )
			// Tiger.g:28:9: 'var'
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
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:29:7: ( 'while' )
			// Tiger.g:29:9: 'while'
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
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:30:7: ( '{' )
			// Tiger.g:30:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:31:7: ( '}' )
			// Tiger.g:31:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__48"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:215:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )* )
			// Tiger.g:215:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// Tiger.g:215:30: ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Tiger.g:
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
					break loop1;
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

	// $ANTLR start "INTLIT"
	public final void mINTLIT() throws RecognitionException {
		try {
			int _type = INTLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:222:2: ( ( '0' .. '9' )+ )
			// Tiger.g:222:4: ( '0' .. '9' )+
			{
			// Tiger.g:222:4: ( '0' .. '9' )+
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
					// Tiger.g:
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

	// $ANTLR start "STRINGLIT"
	public final void mSTRINGLIT() throws RecognitionException {
		try {
			int _type = STRINGLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:226:2: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' .. '@' )* '\"' )
			// Tiger.g:226:4: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' .. '@' )* '\"'
			{
			match('\"'); 
			// Tiger.g:226:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' .. '@' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\"') ) {
					int LA3_1 = input.LA(2);
					if ( ((LA3_1 >= '!' && LA3_1 <= 'Z')||(LA3_1 >= 'a' && LA3_1 <= 'z')) ) {
						alt3=1;
					}

				}
				else if ( (LA3_0=='!'||(LA3_0 >= '#' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Tiger.g:
					{
					if ( (input.LA(1) >= '!' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRINGLIT"

	// $ANTLR start "ADDOP"
	public final void mADDOP() throws RecognitionException {
		try {
			int _type = ADDOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:230:2: ( '+' | '-' )
			// Tiger.g:
			{
			if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADDOP"

	// $ANTLR start "MULTOP"
	public final void mMULTOP() throws RecognitionException {
		try {
			int _type = MULTOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:235:2: ( '*' | '/' )
			// Tiger.g:
			{
			if ( input.LA(1)=='*'||input.LA(1)=='/' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTOP"

	// $ANTLR start "LOGOP"
	public final void mLOGOP() throws RecognitionException {
		try {
			int _type = LOGOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:239:7: ( '=' | '<>' | '>' | '<' | '>=' | '<=' | '&' | '|' )
			int alt4=8;
			switch ( input.LA(1) ) {
			case '=':
				{
				alt4=1;
				}
				break;
			case '<':
				{
				switch ( input.LA(2) ) {
				case '>':
					{
					alt4=2;
					}
					break;
				case '=':
					{
					alt4=6;
					}
					break;
				default:
					alt4=4;
				}
				}
				break;
			case '>':
				{
				int LA4_3 = input.LA(2);
				if ( (LA4_3=='=') ) {
					alt4=5;
				}

				else {
					alt4=3;
				}

				}
				break;
			case '&':
				{
				alt4=7;
				}
				break;
			case '|':
				{
				alt4=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// Tiger.g:239:9: '='
					{
					match('='); 
					}
					break;
				case 2 :
					// Tiger.g:240:4: '<>'
					{
					match("<>"); 

					}
					break;
				case 3 :
					// Tiger.g:241:4: '>'
					{
					match('>'); 
					}
					break;
				case 4 :
					// Tiger.g:242:4: '<'
					{
					match('<'); 
					}
					break;
				case 5 :
					// Tiger.g:243:4: '>='
					{
					match(">="); 

					}
					break;
				case 6 :
					// Tiger.g:244:4: '<='
					{
					match("<="); 

					}
					break;
				case 7 :
					// Tiger.g:245:4: '&'
					{
					match('&'); 
					}
					break;
				case 8 :
					// Tiger.g:246:4: '|'
					{
					match('|'); 
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
	// $ANTLR end "LOGOP"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// Tiger.g:249:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '/\\**\\*/' | '//\\*\\n' )+ )
			// Tiger.g:249:6: ( ' ' | '\\t' | '\\n' | '\\r' | '/\\**\\*/' | '//\\*\\n' )+
			{
			// Tiger.g:249:6: ( ' ' | '\\t' | '\\n' | '\\r' | '/\\**\\*/' | '//\\*\\n' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=7;
				switch ( input.LA(1) ) {
				case ' ':
					{
					alt5=1;
					}
					break;
				case '\t':
					{
					alt5=2;
					}
					break;
				case '\n':
					{
					alt5=3;
					}
					break;
				case '\r':
					{
					alt5=4;
					}
					break;
				case '/':
					{
					int LA5_6 = input.LA(2);
					if ( (LA5_6=='\u0000') ) {
						alt5=5;
					}
					else if ( (LA5_6=='/') ) {
						alt5=6;
					}

					}
					break;
				}
				switch (alt5) {
				case 1 :
					// Tiger.g:249:7: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// Tiger.g:249:13: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// Tiger.g:249:20: '\\n'
					{
					match('\n'); 
					}
					break;
				case 4 :
					// Tiger.g:249:27: '\\r'
					{
					match('\r'); 
					}
					break;
				case 5 :
					// Tiger.g:249:34: '/\\**\\*/'
					{
					match("/***/"); 

					}
					break;
				case 6 :
					// Tiger.g:249:46: '//\\*\\n'
					{
					match("//*\n"); 

					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			_channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// Tiger.g:1:8: ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | ID | INTLIT | STRINGLIT | ADDOP | MULTOP | LOGOP | WS )
		int alt6=37;
		alt6 = dfa6.predict(input);
		switch (alt6) {
			case 1 :
				// Tiger.g:1:10: T__19
				{
				mT__19(); 

				}
				break;
			case 2 :
				// Tiger.g:1:16: T__20
				{
				mT__20(); 

				}
				break;
			case 3 :
				// Tiger.g:1:22: T__21
				{
				mT__21(); 

				}
				break;
			case 4 :
				// Tiger.g:1:28: T__22
				{
				mT__22(); 

				}
				break;
			case 5 :
				// Tiger.g:1:34: T__23
				{
				mT__23(); 

				}
				break;
			case 6 :
				// Tiger.g:1:40: T__24
				{
				mT__24(); 

				}
				break;
			case 7 :
				// Tiger.g:1:46: T__25
				{
				mT__25(); 

				}
				break;
			case 8 :
				// Tiger.g:1:52: T__26
				{
				mT__26(); 

				}
				break;
			case 9 :
				// Tiger.g:1:58: T__27
				{
				mT__27(); 

				}
				break;
			case 10 :
				// Tiger.g:1:64: T__28
				{
				mT__28(); 

				}
				break;
			case 11 :
				// Tiger.g:1:70: T__29
				{
				mT__29(); 

				}
				break;
			case 12 :
				// Tiger.g:1:76: T__30
				{
				mT__30(); 

				}
				break;
			case 13 :
				// Tiger.g:1:82: T__31
				{
				mT__31(); 

				}
				break;
			case 14 :
				// Tiger.g:1:88: T__32
				{
				mT__32(); 

				}
				break;
			case 15 :
				// Tiger.g:1:94: T__33
				{
				mT__33(); 

				}
				break;
			case 16 :
				// Tiger.g:1:100: T__34
				{
				mT__34(); 

				}
				break;
			case 17 :
				// Tiger.g:1:106: T__35
				{
				mT__35(); 

				}
				break;
			case 18 :
				// Tiger.g:1:112: T__36
				{
				mT__36(); 

				}
				break;
			case 19 :
				// Tiger.g:1:118: T__37
				{
				mT__37(); 

				}
				break;
			case 20 :
				// Tiger.g:1:124: T__38
				{
				mT__38(); 

				}
				break;
			case 21 :
				// Tiger.g:1:130: T__39
				{
				mT__39(); 

				}
				break;
			case 22 :
				// Tiger.g:1:136: T__40
				{
				mT__40(); 

				}
				break;
			case 23 :
				// Tiger.g:1:142: T__41
				{
				mT__41(); 

				}
				break;
			case 24 :
				// Tiger.g:1:148: T__42
				{
				mT__42(); 

				}
				break;
			case 25 :
				// Tiger.g:1:154: T__43
				{
				mT__43(); 

				}
				break;
			case 26 :
				// Tiger.g:1:160: T__44
				{
				mT__44(); 

				}
				break;
			case 27 :
				// Tiger.g:1:166: T__45
				{
				mT__45(); 

				}
				break;
			case 28 :
				// Tiger.g:1:172: T__46
				{
				mT__46(); 

				}
				break;
			case 29 :
				// Tiger.g:1:178: T__47
				{
				mT__47(); 

				}
				break;
			case 30 :
				// Tiger.g:1:184: T__48
				{
				mT__48(); 

				}
				break;
			case 31 :
				// Tiger.g:1:190: ID
				{
				mID(); 

				}
				break;
			case 32 :
				// Tiger.g:1:193: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 33 :
				// Tiger.g:1:200: STRINGLIT
				{
				mSTRINGLIT(); 

				}
				break;
			case 34 :
				// Tiger.g:1:210: ADDOP
				{
				mADDOP(); 

				}
				break;
			case 35 :
				// Tiger.g:1:216: MULTOP
				{
				mMULTOP(); 

				}
				break;
			case 36 :
				// Tiger.g:1:223: LOGOP
				{
				mLOGOP(); 

				}
				break;
			case 37 :
				// Tiger.g:1:229: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA6 dfa6 = new DFA6(this);
	static final String DFA6_eotS =
		"\6\uffff\1\43\4\uffff\14\31\6\uffff\1\40\7\uffff\2\31\1\70\4\31\1\75\1"+
		"\76\2\31\1\101\1\31\1\103\5\31\1\uffff\1\31\1\112\1\113\1\31\2\uffff\1"+
		"\115\1\116\1\uffff\1\31\1\uffff\1\31\1\121\3\31\1\125\2\uffff\1\31\2\uffff"+
		"\1\127\1\130\1\uffff\1\31\1\132\1\133\1\uffff\1\31\2\uffff\1\135\2\uffff"+
		"\1\31\1\uffff\1\31\1\140\1\uffff";
	static final String DFA6_eofS =
		"\141\uffff";
	static final String DFA6_minS =
		"\1\11\5\uffff\1\75\4\uffff\2\162\1\157\1\154\1\157\1\146\1\145\1\151\1"+
		"\146\1\150\1\141\1\150\6\uffff\1\0\7\uffff\1\162\1\145\1\60\1\163\1\144"+
		"\1\162\1\156\2\60\1\164\1\154\1\60\1\145\1\60\1\160\1\162\1\151\2\141"+
		"\1\uffff\1\145\2\60\1\143\2\uffff\2\60\1\uffff\1\156\1\uffff\1\145\1\60"+
		"\1\154\1\171\1\153\1\60\2\uffff\1\164\2\uffff\2\60\1\uffff\1\145\2\60"+
		"\1\uffff\1\151\2\uffff\1\60\2\uffff\1\157\1\uffff\1\156\1\60\1\uffff";
	static final String DFA6_maxS =
		"\1\175\5\uffff\1\75\4\uffff\2\162\1\157\1\156\1\165\1\156\1\145\1\151"+
		"\1\146\1\171\1\141\1\150\6\uffff\1\57\7\uffff\1\162\1\145\1\172\1\163"+
		"\1\144\1\162\1\156\2\172\1\164\1\154\1\172\1\145\1\172\1\160\1\162\1\151"+
		"\2\141\1\uffff\1\145\2\172\1\143\2\uffff\2\172\1\uffff\1\156\1\uffff\1"+
		"\145\1\172\1\154\1\171\1\153\1\172\2\uffff\1\164\2\uffff\2\172\1\uffff"+
		"\1\145\2\172\1\uffff\1\151\2\uffff\1\172\2\uffff\1\157\1\uffff\1\156\1"+
		"\172\1\uffff";
	static final String DFA6_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\13\14\uffff\1\35"+
		"\1\36\1\37\1\40\1\41\1\42\1\uffff\1\44\1\45\1\43\1\4\1\7\1\6\1\11\23\uffff"+
		"\1\16\4\uffff\1\23\1\24\2\uffff\1\27\1\uffff\1\31\6\uffff\1\20\1\21\1"+
		"\uffff\1\25\1\26\2\uffff\1\33\3\uffff\1\17\1\uffff\1\30\1\32\1\uffff\1"+
		"\14\1\15\1\uffff\1\34\2\uffff\1\22";
	static final String DFA6_specialS =
		"\141\uffff}>";
	static final String[] DFA6_transitionS = {
			"\2\37\2\uffff\1\37\22\uffff\1\37\1\uffff\1\33\3\uffff\1\36\1\uffff\1"+
			"\1\1\2\1\40\1\34\1\3\1\4\1\5\1\35\12\32\1\6\1\7\1\36\1\10\1\36\2\uffff"+
			"\32\31\1\11\1\uffff\1\12\3\uffff\1\13\1\14\1\31\1\15\1\16\1\17\2\31\1"+
			"\20\2\31\1\21\1\31\1\22\1\23\4\31\1\24\1\31\1\25\1\26\3\31\1\27\1\36"+
			"\1\30",
			"",
			"",
			"",
			"",
			"",
			"\1\42",
			"",
			"",
			"",
			"",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50\1\uffff\1\51",
			"\1\52\5\uffff\1\53",
			"\1\54\7\uffff\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61\6\uffff\1\62\11\uffff\1\63",
			"\1\64",
			"\1\65",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\37\56\uffff\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\66",
			"\1\67",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\77",
			"\1\100",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\102",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"",
			"\1\111",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\114",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\1\117",
			"",
			"\1\120",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\122",
			"\1\123",
			"\1\124",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"\1\126",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\1\131",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\1\134",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"\1\136",
			"",
			"\1\137",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
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
			return "1:1: Tokens : ( T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | ID | INTLIT | STRINGLIT | ADDOP | MULTOP | LOGOP | WS );";
		}
	}

}
