// $ANTLR 3.5.2 src/Tiger.g 2019-02-20 17:41:50

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TigerLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int ARRTY=4;
	public static final int ASSIGNMENT=5;
	public static final int BRACBEG=6;
	public static final int BREAK=7;
	public static final int CALLEXP=8;
	public static final int EXPBEG=9;
	public static final int EXPSTOR=10;
	public static final int FIELDCREATE=11;
	public static final int FIELDDEC=12;
	public static final int FIELDEXP=13;
	public static final int FOR=14;
	public static final int FUNDEC=15;
	public static final int ID=16;
	public static final int IDBEG=17;
	public static final int IDSTOR=18;
	public static final int IFTHEN=19;
	public static final int INT=20;
	public static final int INTLIT=21;
	public static final int LET=22;
	public static final int LETEXP=23;
	public static final int MULTEXP=24;
	public static final int NEGATION=25;
	public static final int NIL=26;
	public static final int RECCREATE=27;
	public static final int RECTY=28;
	public static final int RETOUR=29;
	public static final int RETURNTYPE=30;
	public static final int ROOT=31;
	public static final int SEQEXP=32;
	public static final int STRING=33;
	public static final int STRINGLIT=34;
	public static final int TYDEC=35;
	public static final int VAR=36;
	public static final int VARDEC=37;
	public static final int VD=38;
	public static final int WHILE=39;
	public static final int WS=40;

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
	@Override public String getGrammarFileName() { return "src/Tiger.g"; }

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:2:7: ( '&' )
			// src/Tiger.g:2:9: '&'
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
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:3:7: ( '(' )
			// src/Tiger.g:3:9: '('
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
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:4:7: ( ')' )
			// src/Tiger.g:4:9: ')'
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
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:5:7: ( '*' )
			// src/Tiger.g:5:9: '*'
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
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:6:7: ( '+' )
			// src/Tiger.g:6:9: '+'
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
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:7:7: ( ',' )
			// src/Tiger.g:7:9: ','
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
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:8:7: ( '-' )
			// src/Tiger.g:8:9: '-'
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
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:9:7: ( '.' )
			// src/Tiger.g:9:9: '.'
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
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:10:7: ( '/' )
			// src/Tiger.g:10:9: '/'
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
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:11:7: ( ':' )
			// src/Tiger.g:11:9: ':'
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
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:12:7: ( ':=' )
			// src/Tiger.g:12:9: ':='
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
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:13:7: ( ';' )
			// src/Tiger.g:13:9: ';'
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
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:14:7: ( '<' )
			// src/Tiger.g:14:9: '<'
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
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:15:7: ( '<=' )
			// src/Tiger.g:15:9: '<='
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
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:16:7: ( '<>' )
			// src/Tiger.g:16:9: '<>'
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
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:17:7: ( '=' )
			// src/Tiger.g:17:9: '='
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
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:18:7: ( '>' )
			// src/Tiger.g:18:9: '>'
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
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:19:7: ( '>=' )
			// src/Tiger.g:19:9: '>='
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
	// $ANTLR end "T__58"

	// $ANTLR start "T__59"
	public final void mT__59() throws RecognitionException {
		try {
			int _type = T__59;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:20:7: ( '[' )
			// src/Tiger.g:20:9: '['
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
	// $ANTLR end "T__59"

	// $ANTLR start "T__60"
	public final void mT__60() throws RecognitionException {
		try {
			int _type = T__60;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:21:7: ( ']' )
			// src/Tiger.g:21:9: ']'
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
	// $ANTLR end "T__60"

	// $ANTLR start "T__61"
	public final void mT__61() throws RecognitionException {
		try {
			int _type = T__61;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:22:7: ( 'array' )
			// src/Tiger.g:22:9: 'array'
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
	// $ANTLR end "T__61"

	// $ANTLR start "T__62"
	public final void mT__62() throws RecognitionException {
		try {
			int _type = T__62;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:23:7: ( 'break' )
			// src/Tiger.g:23:9: 'break'
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
	// $ANTLR end "T__62"

	// $ANTLR start "T__63"
	public final void mT__63() throws RecognitionException {
		try {
			int _type = T__63;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:24:7: ( 'do' )
			// src/Tiger.g:24:9: 'do'
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
	// $ANTLR end "T__63"

	// $ANTLR start "T__64"
	public final void mT__64() throws RecognitionException {
		try {
			int _type = T__64;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:25:7: ( 'else' )
			// src/Tiger.g:25:9: 'else'
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
	// $ANTLR end "T__64"

	// $ANTLR start "T__65"
	public final void mT__65() throws RecognitionException {
		try {
			int _type = T__65;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:26:7: ( 'end' )
			// src/Tiger.g:26:9: 'end'
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
	// $ANTLR end "T__65"

	// $ANTLR start "T__66"
	public final void mT__66() throws RecognitionException {
		try {
			int _type = T__66;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:27:7: ( 'for' )
			// src/Tiger.g:27:9: 'for'
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
	// $ANTLR end "T__66"

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:28:7: ( 'function' )
			// src/Tiger.g:28:9: 'function'
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
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:29:7: ( 'if' )
			// src/Tiger.g:29:9: 'if'
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
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:30:7: ( 'in' )
			// src/Tiger.g:30:9: 'in'
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
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:31:7: ( 'let' )
			// src/Tiger.g:31:9: 'let'
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
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:32:7: ( 'nil' )
			// src/Tiger.g:32:9: 'nil'
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
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:33:7: ( 'of' )
			// src/Tiger.g:33:9: 'of'
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
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:34:7: ( 'then' )
			// src/Tiger.g:34:9: 'then'
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
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:35:7: ( 'to' )
			// src/Tiger.g:35:9: 'to'
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
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:36:7: ( 'type' )
			// src/Tiger.g:36:9: 'type'
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
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:37:7: ( 'var' )
			// src/Tiger.g:37:9: 'var'
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
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:38:7: ( 'while' )
			// src/Tiger.g:38:9: 'while'
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
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:39:7: ( '{' )
			// src/Tiger.g:39:9: '{'
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
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:40:7: ( '|' )
			// src/Tiger.g:40:9: '|'
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
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:41:7: ( '}' )
			// src/Tiger.g:41:9: '}'
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
	// $ANTLR end "T__80"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:217:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )* )
			// src/Tiger.g:217:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/Tiger.g:217:30: ( 'a' .. 'z' | 'A' .. 'Z' | ( '0' .. '9' ) | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// src/Tiger.g:
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
			// src/Tiger.g:221:2: ( ( '0' .. '9' )+ )
			// src/Tiger.g:221:4: ( '0' .. '9' )+
			{
			// src/Tiger.g:221:4: ( '0' .. '9' )+
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
					// src/Tiger.g:
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
			// src/Tiger.g:225:2: ( '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' | '#' .. '@' | ' ' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' )* '\"' )
			// src/Tiger.g:225:4: '\"' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' | '#' .. '@' | ' ' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' )* '\"'
			{
			match('\"'); 
			// src/Tiger.g:225:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '!' | '#' .. '@' | ' ' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= ' ' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')||(LA3_0 >= '\u00C0' && LA3_0 <= '\u00D6')||(LA3_0 >= '\u00D8' && LA3_0 <= '\u00F6')||(LA3_0 >= '\u00F8' && LA3_0 <= '\u02FF')||(LA3_0 >= '\u0370' && LA3_0 <= '\u037D')||(LA3_0 >= '\u037F' && LA3_0 <= '\u1FFF')||(LA3_0 >= '\u200C' && LA3_0 <= '\u200D')||(LA3_0 >= '\u2070' && LA3_0 <= '\u218F')||(LA3_0 >= '\u2C00' && LA3_0 <= '\u2FEF')||(LA3_0 >= '\u3001' && LA3_0 <= '\uD7FF')||(LA3_0 >= '\uF900' && LA3_0 <= '\uFDCF')||(LA3_0 >= '\uFDF0' && LA3_0 <= '\uFFFD')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/Tiger.g:
					{
					if ( (input.LA(1) >= ' ' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u02FF')||(input.LA(1) >= '\u0370' && input.LA(1) <= '\u037D')||(input.LA(1) >= '\u037F' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u200C' && input.LA(1) <= '\u200D')||(input.LA(1) >= '\u2070' && input.LA(1) <= '\u218F')||(input.LA(1) >= '\u2C00' && input.LA(1) <= '\u2FEF')||(input.LA(1) >= '\u3001' && input.LA(1) <= '\uD7FF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFDCF')||(input.LA(1) >= '\uFDF0' && input.LA(1) <= '\uFFFD') ) {
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/Tiger.g:245:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '/*' ( . )* '*/' | '//' ( . )* ( '\\r' | '\\n' ) )+ )
			// src/Tiger.g:245:6: ( ' ' | '\\t' | '\\n' | '\\r' | '/*' ( . )* '*/' | '//' ( . )* ( '\\r' | '\\n' ) )+
			{
			// src/Tiger.g:245:6: ( ' ' | '\\t' | '\\n' | '\\r' | '/*' ( . )* '*/' | '//' ( . )* ( '\\r' | '\\n' ) )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=7;
				switch ( input.LA(1) ) {
				case ' ':
					{
					alt6=1;
					}
					break;
				case '\t':
					{
					alt6=2;
					}
					break;
				case '\n':
					{
					alt6=3;
					}
					break;
				case '\r':
					{
					alt6=4;
					}
					break;
				case '/':
					{
					int LA6_6 = input.LA(2);
					if ( (LA6_6=='*') ) {
						alt6=5;
					}
					else if ( (LA6_6=='/') ) {
						alt6=6;
					}

					}
					break;
				}
				switch (alt6) {
				case 1 :
					// src/Tiger.g:245:7: ' '
					{
					match(' '); 
					}
					break;
				case 2 :
					// src/Tiger.g:245:13: '\\t'
					{
					match('\t'); 
					}
					break;
				case 3 :
					// src/Tiger.g:245:20: '\\n'
					{
					match('\n'); 
					}
					break;
				case 4 :
					// src/Tiger.g:245:27: '\\r'
					{
					match('\r'); 
					}
					break;
				case 5 :
					// src/Tiger.g:245:34: '/*' ( . )* '*/'
					{
					match("/*"); 

					// src/Tiger.g:245:38: ( . )*
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
							// src/Tiger.g:245:38: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop4;
						}
					}

					match("*/"); 

					}
					break;
				case 6 :
					// src/Tiger.g:245:47: '//' ( . )* ( '\\r' | '\\n' )
					{
					match("//"); 

					// src/Tiger.g:245:51: ( . )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0=='\n'||LA5_0=='\r') ) {
							alt5=2;
						}
						else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// src/Tiger.g:245:51: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop5;
						}
					}

					if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
		// src/Tiger.g:1:8: ( T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | ID | INTLIT | STRINGLIT | WS )
		int alt7=44;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// src/Tiger.g:1:10: T__41
				{
				mT__41(); 

				}
				break;
			case 2 :
				// src/Tiger.g:1:16: T__42
				{
				mT__42(); 

				}
				break;
			case 3 :
				// src/Tiger.g:1:22: T__43
				{
				mT__43(); 

				}
				break;
			case 4 :
				// src/Tiger.g:1:28: T__44
				{
				mT__44(); 

				}
				break;
			case 5 :
				// src/Tiger.g:1:34: T__45
				{
				mT__45(); 

				}
				break;
			case 6 :
				// src/Tiger.g:1:40: T__46
				{
				mT__46(); 

				}
				break;
			case 7 :
				// src/Tiger.g:1:46: T__47
				{
				mT__47(); 

				}
				break;
			case 8 :
				// src/Tiger.g:1:52: T__48
				{
				mT__48(); 

				}
				break;
			case 9 :
				// src/Tiger.g:1:58: T__49
				{
				mT__49(); 

				}
				break;
			case 10 :
				// src/Tiger.g:1:64: T__50
				{
				mT__50(); 

				}
				break;
			case 11 :
				// src/Tiger.g:1:70: T__51
				{
				mT__51(); 

				}
				break;
			case 12 :
				// src/Tiger.g:1:76: T__52
				{
				mT__52(); 

				}
				break;
			case 13 :
				// src/Tiger.g:1:82: T__53
				{
				mT__53(); 

				}
				break;
			case 14 :
				// src/Tiger.g:1:88: T__54
				{
				mT__54(); 

				}
				break;
			case 15 :
				// src/Tiger.g:1:94: T__55
				{
				mT__55(); 

				}
				break;
			case 16 :
				// src/Tiger.g:1:100: T__56
				{
				mT__56(); 

				}
				break;
			case 17 :
				// src/Tiger.g:1:106: T__57
				{
				mT__57(); 

				}
				break;
			case 18 :
				// src/Tiger.g:1:112: T__58
				{
				mT__58(); 

				}
				break;
			case 19 :
				// src/Tiger.g:1:118: T__59
				{
				mT__59(); 

				}
				break;
			case 20 :
				// src/Tiger.g:1:124: T__60
				{
				mT__60(); 

				}
				break;
			case 21 :
				// src/Tiger.g:1:130: T__61
				{
				mT__61(); 

				}
				break;
			case 22 :
				// src/Tiger.g:1:136: T__62
				{
				mT__62(); 

				}
				break;
			case 23 :
				// src/Tiger.g:1:142: T__63
				{
				mT__63(); 

				}
				break;
			case 24 :
				// src/Tiger.g:1:148: T__64
				{
				mT__64(); 

				}
				break;
			case 25 :
				// src/Tiger.g:1:154: T__65
				{
				mT__65(); 

				}
				break;
			case 26 :
				// src/Tiger.g:1:160: T__66
				{
				mT__66(); 

				}
				break;
			case 27 :
				// src/Tiger.g:1:166: T__67
				{
				mT__67(); 

				}
				break;
			case 28 :
				// src/Tiger.g:1:172: T__68
				{
				mT__68(); 

				}
				break;
			case 29 :
				// src/Tiger.g:1:178: T__69
				{
				mT__69(); 

				}
				break;
			case 30 :
				// src/Tiger.g:1:184: T__70
				{
				mT__70(); 

				}
				break;
			case 31 :
				// src/Tiger.g:1:190: T__71
				{
				mT__71(); 

				}
				break;
			case 32 :
				// src/Tiger.g:1:196: T__72
				{
				mT__72(); 

				}
				break;
			case 33 :
				// src/Tiger.g:1:202: T__73
				{
				mT__73(); 

				}
				break;
			case 34 :
				// src/Tiger.g:1:208: T__74
				{
				mT__74(); 

				}
				break;
			case 35 :
				// src/Tiger.g:1:214: T__75
				{
				mT__75(); 

				}
				break;
			case 36 :
				// src/Tiger.g:1:220: T__76
				{
				mT__76(); 

				}
				break;
			case 37 :
				// src/Tiger.g:1:226: T__77
				{
				mT__77(); 

				}
				break;
			case 38 :
				// src/Tiger.g:1:232: T__78
				{
				mT__78(); 

				}
				break;
			case 39 :
				// src/Tiger.g:1:238: T__79
				{
				mT__79(); 

				}
				break;
			case 40 :
				// src/Tiger.g:1:244: T__80
				{
				mT__80(); 

				}
				break;
			case 41 :
				// src/Tiger.g:1:250: ID
				{
				mID(); 

				}
				break;
			case 42 :
				// src/Tiger.g:1:253: INTLIT
				{
				mINTLIT(); 

				}
				break;
			case 43 :
				// src/Tiger.g:1:260: STRINGLIT
				{
				mSTRINGLIT(); 

				}
				break;
			case 44 :
				// src/Tiger.g:1:270: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\11\uffff\1\44\1\46\1\uffff\1\51\1\uffff\1\53\2\uffff\14\40\17\uffff\2"+
		"\40\1\77\4\40\1\104\1\105\2\40\1\110\1\40\1\112\5\40\1\uffff\1\40\1\121"+
		"\1\122\1\40\2\uffff\1\124\1\125\1\uffff\1\40\1\uffff\1\40\1\130\3\40\1"+
		"\134\2\uffff\1\40\2\uffff\1\136\1\137\1\uffff\1\40\1\141\1\142\1\uffff"+
		"\1\40\2\uffff\1\144\2\uffff\1\40\1\uffff\1\40\1\147\1\uffff";
	static final String DFA7_eofS =
		"\150\uffff";
	static final String DFA7_minS =
		"\1\11\10\uffff\1\52\1\75\1\uffff\1\75\1\uffff\1\75\2\uffff\2\162\1\157"+
		"\1\154\1\157\1\146\1\145\1\151\1\146\1\150\1\141\1\150\17\uffff\1\162"+
		"\1\145\1\60\1\163\1\144\1\162\1\156\2\60\1\164\1\154\1\60\1\145\1\60\1"+
		"\160\1\162\1\151\2\141\1\uffff\1\145\2\60\1\143\2\uffff\2\60\1\uffff\1"+
		"\156\1\uffff\1\145\1\60\1\154\1\171\1\153\1\60\2\uffff\1\164\2\uffff\2"+
		"\60\1\uffff\1\145\2\60\1\uffff\1\151\2\uffff\1\60\2\uffff\1\157\1\uffff"+
		"\1\156\1\60\1\uffff";
	static final String DFA7_maxS =
		"\1\175\10\uffff\1\57\1\75\1\uffff\1\76\1\uffff\1\75\2\uffff\2\162\1\157"+
		"\1\156\1\165\1\156\1\145\1\151\1\146\1\171\1\141\1\150\17\uffff\1\162"+
		"\1\145\1\172\1\163\1\144\1\162\1\156\2\172\1\164\1\154\1\172\1\145\1\172"+
		"\1\160\1\162\1\151\2\141\1\uffff\1\145\2\172\1\143\2\uffff\2\172\1\uffff"+
		"\1\156\1\uffff\1\145\1\172\1\154\1\171\1\153\1\172\2\uffff\1\164\2\uffff"+
		"\2\172\1\uffff\1\145\2\172\1\uffff\1\151\2\uffff\1\172\2\uffff\1\157\1"+
		"\uffff\1\156\1\172\1\uffff";
	static final String DFA7_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\14\1\uffff\1\20\1"+
		"\uffff\1\23\1\24\14\uffff\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\11\1\13"+
		"\1\12\1\16\1\17\1\15\1\22\1\21\23\uffff\1\27\4\uffff\1\34\1\35\2\uffff"+
		"\1\40\1\uffff\1\42\6\uffff\1\31\1\32\1\uffff\1\36\1\37\2\uffff\1\44\3"+
		"\uffff\1\30\1\uffff\1\41\1\43\1\uffff\1\25\1\26\1\uffff\1\45\2\uffff\1"+
		"\33";
	static final String DFA7_specialS =
		"\150\uffff}>";
	static final String[] DFA7_transitionS = {
			"\2\43\2\uffff\1\43\22\uffff\1\43\1\uffff\1\42\3\uffff\1\1\1\uffff\1\2"+
			"\1\3\1\4\1\5\1\6\1\7\1\10\1\11\12\41\1\12\1\13\1\14\1\15\1\16\2\uffff"+
			"\32\40\1\17\1\uffff\1\20\3\uffff\1\21\1\22\1\40\1\23\1\24\1\25\2\40\1"+
			"\26\2\40\1\27\1\40\1\30\1\31\4\40\1\32\1\40\1\33\1\34\3\40\1\35\1\36"+
			"\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\43\4\uffff\1\43",
			"\1\45",
			"",
			"\1\47\1\50",
			"",
			"\1\52",
			"",
			"",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57\1\uffff\1\60",
			"\1\61\5\uffff\1\62",
			"\1\63\7\uffff\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70\6\uffff\1\71\11\uffff\1\72",
			"\1\73",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\75",
			"\1\76",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\106",
			"\1\107",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\111",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"",
			"\1\120",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\123",
			"",
			"",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"\1\126",
			"",
			"\1\127",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\1\131",
			"\1\132",
			"\1\133",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"",
			"\1\135",
			"",
			"",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"\1\140",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"\1\143",
			"",
			"",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
			"",
			"",
			"\1\145",
			"",
			"\1\146",
			"\12\40\7\uffff\32\40\4\uffff\1\40\1\uffff\32\40",
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
			return "1:1: Tokens : ( T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | ID | INTLIT | STRINGLIT | WS );";
		}
	}

}
