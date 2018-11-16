// $ANTLR null /home/nathan/Telecom/vannesso4u/Tiger.g 2018-11-14 17:29:55

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
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
	public static final int ADDOP=4;
	public static final int ID=5;
	public static final int INTLIT=6;
	public static final int LOGOP=7;
	public static final int MULTOP=8;
	public static final int STRINGLIT=9;

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
	@Override public String getGrammarFileName() { return "/home/nathan/Telecom/vannesso4u/Tiger.g"; }

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:2:7: ( '(' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:2:9: '('
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:3:7: ( ')' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:3:9: ')'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:4:7: ( ',' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:4:9: ','
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:5:7: ( '.' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:5:9: '.'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:6:7: ( ':' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:6:9: ':'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:7:7: ( ':=' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:7:9: ':='
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:8:7: ( ';' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:8:9: ';'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:9:7: ( '=' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:9:9: '='
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:10:7: ( '[' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:10:9: '['
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:11:7: ( ']' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:11:9: ']'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:12:7: ( 'array' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:12:9: 'array'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:13:7: ( 'break' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:13:9: 'break'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:14:7: ( 'do' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:14:9: 'do'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:15:7: ( 'else' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:15:9: 'else'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:16:7: ( 'end' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:16:9: 'end'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:17:7: ( 'for' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:17:9: 'for'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:18:7: ( 'function' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:18:9: 'function'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:19:7: ( 'if' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:19:9: 'if'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:20:7: ( 'in' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:20:9: 'in'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:21:7: ( 'let' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:21:9: 'let'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:22:7: ( 'nil' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:22:9: 'nil'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:23:7: ( 'of' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:23:9: 'of'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:24:7: ( 'then' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:24:9: 'then'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:25:7: ( 'to' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:25:9: 'to'
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:26:7: ( 'type' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:26:9: 'type'
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
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:27:7: ( 'var' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:27:9: 'var'
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
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:28:7: ( 'while' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:28:9: 'while'
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
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:29:7: ( '{' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:29:9: '{'
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
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:30:7: ( '}' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:30:9: '}'
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
	// $ANTLR end "T__38"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/nathan/Telecom/vannesso4u/Tiger.g:204:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )* )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:204:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/nathan/Telecom/vannesso4u/Tiger.g:204:30: ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:
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
			// /home/nathan/Telecom/vannesso4u/Tiger.g:211:2: ( ( '0' .. '9' )+ )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:211:4: ( '0' .. '9' )+
			{
			// /home/nathan/Telecom/vannesso4u/Tiger.g:211:4: ( '0' .. '9' )+
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
					// /home/nathan/Telecom/vannesso4u/Tiger.g:
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
			// /home/nathan/Telecom/vannesso4u/Tiger.g:215:2: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' .. '@' )* '\"' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:215:4: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' .. '@' )* '\"'
			{
			match('\"'); 
			// /home/nathan/Telecom/vannesso4u/Tiger.g:215:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' .. '@' )*
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
					// /home/nathan/Telecom/vannesso4u/Tiger.g:
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
			// /home/nathan/Telecom/vannesso4u/Tiger.g:219:2: ( '+' | '-' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:
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
			// /home/nathan/Telecom/vannesso4u/Tiger.g:224:2: ( '*' | '/' )
			// /home/nathan/Telecom/vannesso4u/Tiger.g:
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
			// /home/nathan/Telecom/vannesso4u/Tiger.g:229:2: ( '=' | '<>' | '>' | '<' | '>=' | '<=' | '&' | '|' )
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
					// /home/nathan/Telecom/vannesso4u/Tiger.g:229:4: '='
					{
					match('='); 
					}
					break;
				case 2 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:230:4: '<>'
					{
					match("<>"); 

					}
					break;
				case 3 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:231:4: '>'
					{
					match('>'); 
					}
					break;
				case 4 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:232:4: '<'
					{
					match('<'); 
					}
					break;
				case 5 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:233:4: '>='
					{
					match(">="); 

					}
					break;
				case 6 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:234:4: '<='
					{
					match("<="); 

					}
					break;
				case 7 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:235:4: '&'
					{
					match('&'); 
					}
					break;
				case 8 :
					// /home/nathan/Telecom/vannesso4u/Tiger.g:236:4: '|'
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

	@Override
	public void mTokens() throws RecognitionException {
		// /home/nathan/Telecom/vannesso4u/Tiger.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | ID | INTLIT | STRINGLIT | ADDOP | MULTOP | LOGOP )
		int alt5=35;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:10: T__10
				{
				mT__10(); 

				}
				break;
			case 2 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:16: T__11
				{
				mT__11(); 

				}
				break;
			case 3 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:22: T__12
				{
				mT__12(); 

				}
				break;
			case 4 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:28: T__13
				{
				mT__13(); 

				}
				break;
			case 5 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:34: T__14
				{
				mT__14(); 

				}
				break;
			case 6 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:40: T__15
				{
				mT__15(); 

				}
				break;
			case 7 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:46: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:52: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:58: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:64: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:70: T__20
				{
				mT__20(); 

				}
				break;
			case 12 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:76: T__21
				{
				mT__21(); 

				}
				break;
			case 13 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:82: T__22
				{
				mT__22(); 

				}
				break;
			case 14 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:88: T__23
				{
				mT__23(); 

				}
				break;
			case 15 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:94: T__24
				{
				mT__24(); 

				}
				break;
			case 16 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:100: T__25
				{
				mT__25(); 

				}
				break;
			case 17 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:106: T__26
				{
				mT__26(); 

				}
				break;
			case 18 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:112: T__27
				{
				mT__27(); 

				}
				break;
			case 19 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:118: T__28
				{
				mT__28(); 

				}
				break;
			case 20 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:124: T__29
				{
				mT__29(); 

				}
				break;
			case 21 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:130: T__30
				{
				mT__30(); 

				}
				break;
			case 22 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:136: T__31
				{
				mT__31(); 

				}
				break;
			case 23 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:142: T__32
				{
				mT__32(); 

				}
				break;
			case 24 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:148: T__33
				{
				mT__33(); 

				}
				break;
			case 25 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:154: T__34
				{
				mT__34(); 

				}
				break;
			case 26 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:160: T__35
				{
				mT__35(); 

				}
				break;
			case 27 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:166: T__36
				{
				mT__36(); 

				}
				break;
			case 28 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:172: T__37
				{
				mT__37(); 

				}
				break;
			case 29 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:178: T__38
				{
				mT__38(); 

				}
				break;
			case 30 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:184: ID
				{
				mID(); 

				}
				break;
			case 31 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:187: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 32 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:194: STRINGLIT
				{
				mSTRINGLIT(); 

				}
				break;
			case 33 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:204: ADDOP
				{
				mADDOP(); 

				}
				break;
			case 34 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:210: MULTOP
				{
				mMULTOP(); 

				}
				break;
			case 35 :
				// /home/nathan/Telecom/vannesso4u/Tiger.g:1:217: LOGOP
				{
				mLOGOP(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\5\uffff\1\37\4\uffff\14\30\13\uffff\2\30\1\64\4\30\1\71\1\72\2\30\1\75"+
		"\1\30\1\77\5\30\1\uffff\1\30\1\106\1\107\1\30\2\uffff\1\111\1\112\1\uffff"+
		"\1\30\1\uffff\1\30\1\115\3\30\1\121\2\uffff\1\30\2\uffff\1\123\1\124\1"+
		"\uffff\1\30\1\126\1\127\1\uffff\1\30\2\uffff\1\131\2\uffff\1\30\1\uffff"+
		"\1\30\1\134\1\uffff";
	static final String DFA5_eofS =
		"\135\uffff";
	static final String DFA5_minS =
		"\1\42\4\uffff\1\75\4\uffff\2\162\1\157\1\154\1\157\1\146\1\145\1\151\1"+
		"\146\1\150\1\141\1\150\13\uffff\1\162\1\145\1\60\1\163\1\144\1\162\1\156"+
		"\2\60\1\164\1\154\1\60\1\145\1\60\1\160\1\162\1\151\2\141\1\uffff\1\145"+
		"\2\60\1\143\2\uffff\2\60\1\uffff\1\156\1\uffff\1\145\1\60\1\154\1\171"+
		"\1\153\1\60\2\uffff\1\164\2\uffff\2\60\1\uffff\1\145\2\60\1\uffff\1\151"+
		"\2\uffff\1\60\2\uffff\1\157\1\uffff\1\156\1\60\1\uffff";
	static final String DFA5_maxS =
		"\1\175\4\uffff\1\75\4\uffff\2\162\1\157\1\156\1\165\1\156\1\145\1\151"+
		"\1\146\1\171\1\141\1\150\13\uffff\1\162\1\145\1\172\1\163\1\144\1\162"+
		"\1\156\2\172\1\164\1\154\1\172\1\145\1\172\1\160\1\162\1\151\2\141\1\uffff"+
		"\1\145\2\172\1\143\2\uffff\2\172\1\uffff\1\156\1\uffff\1\145\1\172\1\154"+
		"\1\171\1\153\1\172\2\uffff\1\164\2\uffff\2\172\1\uffff\1\145\2\172\1\uffff"+
		"\1\151\2\uffff\1\172\2\uffff\1\157\1\uffff\1\156\1\172\1\uffff";
	static final String DFA5_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\11\1\12\14\uffff\1\34\1\35"+
		"\1\36\1\37\1\40\1\41\1\42\1\43\1\6\1\5\1\10\23\uffff\1\15\4\uffff\1\22"+
		"\1\23\2\uffff\1\26\1\uffff\1\30\6\uffff\1\17\1\20\1\uffff\1\24\1\25\2"+
		"\uffff\1\32\3\uffff\1\16\1\uffff\1\27\1\31\1\uffff\1\13\1\14\1\uffff\1"+
		"\33\2\uffff\1\21";
	static final String DFA5_specialS =
		"\135\uffff}>";
	static final String[] DFA5_transitionS = {
			"\1\32\3\uffff\1\35\1\uffff\1\1\1\2\1\34\1\33\1\3\1\33\1\4\1\34\12\31"+
			"\1\5\1\6\1\35\1\7\1\35\2\uffff\32\30\1\10\1\uffff\1\11\3\uffff\1\12\1"+
			"\13\1\30\1\14\1\15\1\16\2\30\1\17\2\30\1\20\1\30\1\21\1\22\4\30\1\23"+
			"\1\30\1\24\1\25\3\30\1\26\1\35\1\27",
			"",
			"",
			"",
			"",
			"\1\36",
			"",
			"",
			"",
			"",
			"\1\41",
			"\1\42",
			"\1\43",
			"\1\44\1\uffff\1\45",
			"\1\46\5\uffff\1\47",
			"\1\50\7\uffff\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55\6\uffff\1\56\11\uffff\1\57",
			"\1\60",
			"\1\61",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\62",
			"\1\63",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\73",
			"\1\74",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\76",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"",
			"\1\105",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\110",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\113",
			"",
			"\1\114",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\116",
			"\1\117",
			"\1\120",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"\1\122",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\125",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\130",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"\1\132",
			"",
			"\1\133",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			""
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | ID | INTLIT | STRINGLIT | ADDOP | MULTOP | LOGOP );";
		}
	}

}
