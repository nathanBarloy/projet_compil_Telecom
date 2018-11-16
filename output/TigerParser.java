// $ANTLR null /home/nathan/Telecom/vannesso4u/Tiger.g 2018-11-14 17:29:54

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class TigerParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ADDOP", "ID", "INTLIT", "LOGOP", 
		"MULTOP", "STRINGLIT", "'('", "')'", "','", "'.'", "':'", "':='", "';'", 
		"'='", "'['", "']'", "'array'", "'break'", "'do'", "'else'", "'end'", 
		"'for'", "'function'", "'if'", "'in'", "'let'", "'nil'", "'of'", "'then'", 
		"'to'", "'type'", "'var'", "'while'", "'{'", "'}'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "tyid", "bracBegin", "fieldDec", "ifThen", "forExp", "exp", 
		"idBegin", "whileExp", "returnType", "tyDec", "varDec", "vd", "fieldCreate", 
		"lValue", "program", "atom", "seqExp", "multExp", "recTy", "funDec", "dec", 
		"e", "letExp", "arrTy", "ty"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false, false, 
		    false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public TigerParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public TigerParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public TigerParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return TigerParser.tokenNames; }
	@Override public String getGrammarFileName() { return "/home/nathan/Telecom/vannesso4u/Tiger.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:19:1: program : exp ;
	public final TigerParser.program_return program() throws RecognitionException {
		TigerParser.program_return retval = new TigerParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exp1 =null;


		try { dbg.enterRule(getGrammarFileName(), "program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(19, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:20:2: ( exp )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:20:4: exp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(20,4);
			pushFollow(FOLLOW_exp_in_program70);
			exp1=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp1.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(21, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "program"


	public static class dec_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "dec"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:23:1: dec : ( tyDec | varDec | funDec );
	public final TigerParser.dec_return dec() throws RecognitionException {
		TigerParser.dec_return retval = new TigerParser.dec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope tyDec2 =null;
		ParserRuleReturnScope varDec3 =null;
		ParserRuleReturnScope funDec4 =null;


		try { dbg.enterRule(getGrammarFileName(), "dec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(23, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:24:2: ( tyDec | varDec | funDec )
			int alt1=3;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

			switch ( input.LA(1) ) {
			case 34:
				{
				alt1=1;
				}
				break;
			case 35:
				{
				alt1=2;
				}
				break;
			case 26:
				{
				alt1=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:24:4: tyDec
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(24,4);
					pushFollow(FOLLOW_tyDec_in_dec81);
					tyDec2=tyDec();
					state._fsp--;

					adaptor.addChild(root_0, tyDec2.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:25:4: varDec
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(25,4);
					pushFollow(FOLLOW_varDec_in_dec86);
					varDec3=varDec();
					state._fsp--;

					adaptor.addChild(root_0, varDec3.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:26:4: funDec
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(26,4);
					pushFollow(FOLLOW_funDec_in_dec91);
					funDec4=funDec();
					state._fsp--;

					adaptor.addChild(root_0, funDec4.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(27, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "dec");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "dec"


	public static class tyDec_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tyDec"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:28:1: tyDec : 'type' tyid '=' ty ;
	public final TigerParser.tyDec_return tyDec() throws RecognitionException {
		TigerParser.tyDec_return retval = new TigerParser.tyDec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal5=null;
		Token char_literal7=null;
		ParserRuleReturnScope tyid6 =null;
		ParserRuleReturnScope ty8 =null;

		Object string_literal5_tree=null;
		Object char_literal7_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "tyDec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(28, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:29:2: ( 'type' tyid '=' ty )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:29:4: 'type' tyid '=' ty
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(29,4);
			string_literal5=(Token)match(input,34,FOLLOW_34_in_tyDec101); 
			string_literal5_tree = (Object)adaptor.create(string_literal5);
			adaptor.addChild(root_0, string_literal5_tree);
			dbg.location(29,11);
			pushFollow(FOLLOW_tyid_in_tyDec103);
			tyid6=tyid();
			state._fsp--;

			adaptor.addChild(root_0, tyid6.getTree());
			dbg.location(29,16);
			char_literal7=(Token)match(input,17,FOLLOW_17_in_tyDec105); 
			char_literal7_tree = (Object)adaptor.create(char_literal7);
			adaptor.addChild(root_0, char_literal7_tree);
			dbg.location(29,20);
			pushFollow(FOLLOW_ty_in_tyDec107);
			ty8=ty();
			state._fsp--;

			adaptor.addChild(root_0, ty8.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(30, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "tyDec");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "tyDec"


	public static class ty_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ty"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:32:1: ty : ( tyid | arrTy | recTy );
	public final TigerParser.ty_return ty() throws RecognitionException {
		TigerParser.ty_return retval = new TigerParser.ty_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope tyid9 =null;
		ParserRuleReturnScope arrTy10 =null;
		ParserRuleReturnScope recTy11 =null;


		try { dbg.enterRule(getGrammarFileName(), "ty");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(32, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:33:2: ( tyid | arrTy | recTy )
			int alt2=3;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			switch ( input.LA(1) ) {
			case ID:
				{
				alt2=1;
				}
				break;
			case 20:
				{
				alt2=2;
				}
				break;
			case 37:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:33:4: tyid
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(33,4);
					pushFollow(FOLLOW_tyid_in_ty118);
					tyid9=tyid();
					state._fsp--;

					adaptor.addChild(root_0, tyid9.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:34:4: arrTy
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(34,4);
					pushFollow(FOLLOW_arrTy_in_ty123);
					arrTy10=arrTy();
					state._fsp--;

					adaptor.addChild(root_0, arrTy10.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:35:4: recTy
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(35,4);
					pushFollow(FOLLOW_recTy_in_ty128);
					recTy11=recTy();
					state._fsp--;

					adaptor.addChild(root_0, recTy11.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(36, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ty");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ty"


	public static class arrTy_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "arrTy"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:38:1: arrTy : 'array' 'of' tyid ;
	public final TigerParser.arrTy_return arrTy() throws RecognitionException {
		TigerParser.arrTy_return retval = new TigerParser.arrTy_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal12=null;
		Token string_literal13=null;
		ParserRuleReturnScope tyid14 =null;

		Object string_literal12_tree=null;
		Object string_literal13_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "arrTy");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(38, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:39:2: ( 'array' 'of' tyid )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:39:4: 'array' 'of' tyid
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(39,4);
			string_literal12=(Token)match(input,20,FOLLOW_20_in_arrTy139); 
			string_literal12_tree = (Object)adaptor.create(string_literal12);
			adaptor.addChild(root_0, string_literal12_tree);
			dbg.location(39,12);
			string_literal13=(Token)match(input,31,FOLLOW_31_in_arrTy141); 
			string_literal13_tree = (Object)adaptor.create(string_literal13);
			adaptor.addChild(root_0, string_literal13_tree);
			dbg.location(39,17);
			pushFollow(FOLLOW_tyid_in_arrTy143);
			tyid14=tyid();
			state._fsp--;

			adaptor.addChild(root_0, tyid14.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(40, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arrTy");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arrTy"


	public static class recTy_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "recTy"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:42:1: recTy : '{' ( fieldDec ( ',' fieldDec )* )? '}' ;
	public final TigerParser.recTy_return recTy() throws RecognitionException {
		TigerParser.recTy_return retval = new TigerParser.recTy_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal15=null;
		Token char_literal17=null;
		Token char_literal19=null;
		ParserRuleReturnScope fieldDec16 =null;
		ParserRuleReturnScope fieldDec18 =null;

		Object char_literal15_tree=null;
		Object char_literal17_tree=null;
		Object char_literal19_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "recTy");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(42, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:43:2: ( '{' ( fieldDec ( ',' fieldDec )* )? '}' )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:43:4: '{' ( fieldDec ( ',' fieldDec )* )? '}'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(43,4);
			char_literal15=(Token)match(input,37,FOLLOW_37_in_recTy154); 
			char_literal15_tree = (Object)adaptor.create(char_literal15);
			adaptor.addChild(root_0, char_literal15_tree);
			dbg.location(43,8);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:43:8: ( fieldDec ( ',' fieldDec )* )?
			int alt4=2;
			try { dbg.enterSubRule(4);
			try { dbg.enterDecision(4, decisionCanBacktrack[4]);

			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			} finally {dbg.exitDecision(4);}

			switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:43:9: fieldDec ( ',' fieldDec )*
					{
					dbg.location(43,9);
					pushFollow(FOLLOW_fieldDec_in_recTy157);
					fieldDec16=fieldDec();
					state._fsp--;

					adaptor.addChild(root_0, fieldDec16.getTree());
					dbg.location(43,18);
					// /home/nathan/Telecom/vannesso4u/Tiger.g:43:18: ( ',' fieldDec )*
					try { dbg.enterSubRule(3);

					loop3:
					while (true) {
						int alt3=2;
						try { dbg.enterDecision(3, decisionCanBacktrack[3]);

						int LA3_0 = input.LA(1);
						if ( (LA3_0==12) ) {
							alt3=1;
						}

						} finally {dbg.exitDecision(3);}

						switch (alt3) {
						case 1 :
							dbg.enterAlt(1);

							// /home/nathan/Telecom/vannesso4u/Tiger.g:43:19: ',' fieldDec
							{
							dbg.location(43,19);
							char_literal17=(Token)match(input,12,FOLLOW_12_in_recTy160); 
							char_literal17_tree = (Object)adaptor.create(char_literal17);
							adaptor.addChild(root_0, char_literal17_tree);
							dbg.location(43,23);
							pushFollow(FOLLOW_fieldDec_in_recTy162);
							fieldDec18=fieldDec();
							state._fsp--;

							adaptor.addChild(root_0, fieldDec18.getTree());

							}
							break;

						default :
							break loop3;
						}
					}
					} finally {dbg.exitSubRule(3);}

					}
					break;

			}
			} finally {dbg.exitSubRule(4);}
			dbg.location(43,36);
			char_literal19=(Token)match(input,38,FOLLOW_38_in_recTy168); 
			char_literal19_tree = (Object)adaptor.create(char_literal19);
			adaptor.addChild(root_0, char_literal19_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(44, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "recTy");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "recTy"


	public static class fieldDec_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fieldDec"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:46:1: fieldDec : ID ':' tyid ;
	public final TigerParser.fieldDec_return fieldDec() throws RecognitionException {
		TigerParser.fieldDec_return retval = new TigerParser.fieldDec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID20=null;
		Token char_literal21=null;
		ParserRuleReturnScope tyid22 =null;

		Object ID20_tree=null;
		Object char_literal21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "fieldDec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(46, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:47:2: ( ID ':' tyid )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:47:4: ID ':' tyid
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(47,4);
			ID20=(Token)match(input,ID,FOLLOW_ID_in_fieldDec179); 
			ID20_tree = (Object)adaptor.create(ID20);
			adaptor.addChild(root_0, ID20_tree);
			dbg.location(47,7);
			char_literal21=(Token)match(input,14,FOLLOW_14_in_fieldDec181); 
			char_literal21_tree = (Object)adaptor.create(char_literal21);
			adaptor.addChild(root_0, char_literal21_tree);
			dbg.location(47,11);
			pushFollow(FOLLOW_tyid_in_fieldDec183);
			tyid22=tyid();
			state._fsp--;

			adaptor.addChild(root_0, tyid22.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(48, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fieldDec");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "fieldDec"


	public static class funDec_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "funDec"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:50:1: funDec : 'function' ID '(' ( fieldDec ( ',' fieldDec )* )? ')' returnType '=' exp ;
	public final TigerParser.funDec_return funDec() throws RecognitionException {
		TigerParser.funDec_return retval = new TigerParser.funDec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal23=null;
		Token ID24=null;
		Token char_literal25=null;
		Token char_literal27=null;
		Token char_literal29=null;
		Token char_literal31=null;
		ParserRuleReturnScope fieldDec26 =null;
		ParserRuleReturnScope fieldDec28 =null;
		ParserRuleReturnScope returnType30 =null;
		ParserRuleReturnScope exp32 =null;

		Object string_literal23_tree=null;
		Object ID24_tree=null;
		Object char_literal25_tree=null;
		Object char_literal27_tree=null;
		Object char_literal29_tree=null;
		Object char_literal31_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "funDec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:51:2: ( 'function' ID '(' ( fieldDec ( ',' fieldDec )* )? ')' returnType '=' exp )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:51:4: 'function' ID '(' ( fieldDec ( ',' fieldDec )* )? ')' returnType '=' exp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(51,4);
			string_literal23=(Token)match(input,26,FOLLOW_26_in_funDec194); 
			string_literal23_tree = (Object)adaptor.create(string_literal23);
			adaptor.addChild(root_0, string_literal23_tree);
			dbg.location(51,15);
			ID24=(Token)match(input,ID,FOLLOW_ID_in_funDec196); 
			ID24_tree = (Object)adaptor.create(ID24);
			adaptor.addChild(root_0, ID24_tree);
			dbg.location(51,18);
			char_literal25=(Token)match(input,10,FOLLOW_10_in_funDec198); 
			char_literal25_tree = (Object)adaptor.create(char_literal25);
			adaptor.addChild(root_0, char_literal25_tree);
			dbg.location(51,22);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:51:22: ( fieldDec ( ',' fieldDec )* )?
			int alt6=2;
			try { dbg.enterSubRule(6);
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

			int LA6_0 = input.LA(1);
			if ( (LA6_0==ID) ) {
				alt6=1;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:51:23: fieldDec ( ',' fieldDec )*
					{
					dbg.location(51,23);
					pushFollow(FOLLOW_fieldDec_in_funDec201);
					fieldDec26=fieldDec();
					state._fsp--;

					adaptor.addChild(root_0, fieldDec26.getTree());
					dbg.location(51,31);
					// /home/nathan/Telecom/vannesso4u/Tiger.g:51:31: ( ',' fieldDec )*
					try { dbg.enterSubRule(5);

					loop5:
					while (true) {
						int alt5=2;
						try { dbg.enterDecision(5, decisionCanBacktrack[5]);

						int LA5_0 = input.LA(1);
						if ( (LA5_0==12) ) {
							alt5=1;
						}

						} finally {dbg.exitDecision(5);}

						switch (alt5) {
						case 1 :
							dbg.enterAlt(1);

							// /home/nathan/Telecom/vannesso4u/Tiger.g:51:32: ',' fieldDec
							{
							dbg.location(51,32);
							char_literal27=(Token)match(input,12,FOLLOW_12_in_funDec203); 
							char_literal27_tree = (Object)adaptor.create(char_literal27);
							adaptor.addChild(root_0, char_literal27_tree);
							dbg.location(51,36);
							pushFollow(FOLLOW_fieldDec_in_funDec205);
							fieldDec28=fieldDec();
							state._fsp--;

							adaptor.addChild(root_0, fieldDec28.getTree());

							}
							break;

						default :
							break loop5;
						}
					}
					} finally {dbg.exitSubRule(5);}

					}
					break;

			}
			} finally {dbg.exitSubRule(6);}
			dbg.location(51,49);
			char_literal29=(Token)match(input,11,FOLLOW_11_in_funDec211); 
			char_literal29_tree = (Object)adaptor.create(char_literal29);
			adaptor.addChild(root_0, char_literal29_tree);
			dbg.location(51,53);
			pushFollow(FOLLOW_returnType_in_funDec213);
			returnType30=returnType();
			state._fsp--;

			adaptor.addChild(root_0, returnType30.getTree());
			dbg.location(51,64);
			char_literal31=(Token)match(input,17,FOLLOW_17_in_funDec215); 
			char_literal31_tree = (Object)adaptor.create(char_literal31);
			adaptor.addChild(root_0, char_literal31_tree);
			dbg.location(51,68);
			pushFollow(FOLLOW_exp_in_funDec217);
			exp32=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp32.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(52, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "funDec");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "funDec"


	public static class returnType_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "returnType"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:54:1: returnType : ( ':' tyid |);
	public final TigerParser.returnType_return returnType() throws RecognitionException {
		TigerParser.returnType_return retval = new TigerParser.returnType_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal33=null;
		ParserRuleReturnScope tyid34 =null;

		Object char_literal33_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "returnType");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:55:2: ( ':' tyid |)
			int alt7=2;
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==14) ) {
				alt7=1;
			}
			else if ( (LA7_0==17) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:55:4: ':' tyid
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(55,4);
					char_literal33=(Token)match(input,14,FOLLOW_14_in_returnType228); 
					char_literal33_tree = (Object)adaptor.create(char_literal33);
					adaptor.addChild(root_0, char_literal33_tree);
					dbg.location(55,8);
					pushFollow(FOLLOW_tyid_in_returnType230);
					tyid34=tyid();
					state._fsp--;

					adaptor.addChild(root_0, tyid34.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:57:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(57, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "returnType");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "returnType"


	public static class varDec_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "varDec"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:59:1: varDec : 'var' ID vd ':=' exp ;
	public final TigerParser.varDec_return varDec() throws RecognitionException {
		TigerParser.varDec_return retval = new TigerParser.varDec_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal35=null;
		Token ID36=null;
		Token string_literal38=null;
		ParserRuleReturnScope vd37 =null;
		ParserRuleReturnScope exp39 =null;

		Object string_literal35_tree=null;
		Object ID36_tree=null;
		Object string_literal38_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "varDec");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(59, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:60:2: ( 'var' ID vd ':=' exp )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:60:4: 'var' ID vd ':=' exp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(60,4);
			string_literal35=(Token)match(input,35,FOLLOW_35_in_varDec244); 
			string_literal35_tree = (Object)adaptor.create(string_literal35);
			adaptor.addChild(root_0, string_literal35_tree);
			dbg.location(60,10);
			ID36=(Token)match(input,ID,FOLLOW_ID_in_varDec246); 
			ID36_tree = (Object)adaptor.create(ID36);
			adaptor.addChild(root_0, ID36_tree);
			dbg.location(60,13);
			pushFollow(FOLLOW_vd_in_varDec248);
			vd37=vd();
			state._fsp--;

			adaptor.addChild(root_0, vd37.getTree());
			dbg.location(60,16);
			string_literal38=(Token)match(input,15,FOLLOW_15_in_varDec250); 
			string_literal38_tree = (Object)adaptor.create(string_literal38);
			adaptor.addChild(root_0, string_literal38_tree);
			dbg.location(60,21);
			pushFollow(FOLLOW_exp_in_varDec252);
			exp39=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp39.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(61, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "varDec");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "varDec"


	public static class vd_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vd"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:63:1: vd : ( ':' tyid |);
	public final TigerParser.vd_return vd() throws RecognitionException {
		TigerParser.vd_return retval = new TigerParser.vd_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal40=null;
		ParserRuleReturnScope tyid41 =null;

		Object char_literal40_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "vd");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(63, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:64:2: ( ':' tyid |)
			int alt8=2;
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			int LA8_0 = input.LA(1);
			if ( (LA8_0==14) ) {
				alt8=1;
			}
			else if ( (LA8_0==15) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:64:4: ':' tyid
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(64,4);
					char_literal40=(Token)match(input,14,FOLLOW_14_in_vd263); 
					char_literal40_tree = (Object)adaptor.create(char_literal40);
					adaptor.addChild(root_0, char_literal40_tree);
					dbg.location(64,8);
					pushFollow(FOLLOW_tyid_in_vd265);
					tyid41=tyid();
					state._fsp--;

					adaptor.addChild(root_0, tyid41.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:66:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(66, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "vd");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "vd"


	public static class lValue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lValue"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:91:1: lValue : ( '[' exp ']' lValue | '.' ID lValue |);
	public final TigerParser.lValue_return lValue() throws RecognitionException {
		TigerParser.lValue_return retval = new TigerParser.lValue_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal42=null;
		Token char_literal44=null;
		Token char_literal46=null;
		Token ID47=null;
		ParserRuleReturnScope exp43 =null;
		ParserRuleReturnScope lValue45 =null;
		ParserRuleReturnScope lValue48 =null;

		Object char_literal42_tree=null;
		Object char_literal44_tree=null;
		Object char_literal46_tree=null;
		Object ID47_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "lValue");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(91, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:92:2: ( '[' exp ']' lValue | '.' ID lValue |)
			int alt9=3;
			try { dbg.enterDecision(9, decisionCanBacktrack[9]);

			switch ( input.LA(1) ) {
			case 18:
				{
				alt9=1;
				}
				break;
			case 13:
				{
				alt9=2;
				}
				break;
			case EOF:
			case ADDOP:
			case LOGOP:
			case MULTOP:
			case 11:
			case 12:
			case 16:
			case 19:
			case 22:
			case 23:
			case 24:
			case 26:
			case 28:
			case 32:
			case 33:
			case 34:
			case 35:
			case 38:
				{
				alt9=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(9);}

			switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:92:4: '[' exp ']' lValue
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(92,4);
					char_literal42=(Token)match(input,18,FOLLOW_18_in_lValue290); 
					char_literal42_tree = (Object)adaptor.create(char_literal42);
					adaptor.addChild(root_0, char_literal42_tree);
					dbg.location(92,8);
					pushFollow(FOLLOW_exp_in_lValue292);
					exp43=exp();
					state._fsp--;

					adaptor.addChild(root_0, exp43.getTree());
					dbg.location(92,12);
					char_literal44=(Token)match(input,19,FOLLOW_19_in_lValue294); 
					char_literal44_tree = (Object)adaptor.create(char_literal44);
					adaptor.addChild(root_0, char_literal44_tree);
					dbg.location(92,16);
					pushFollow(FOLLOW_lValue_in_lValue296);
					lValue45=lValue();
					state._fsp--;

					adaptor.addChild(root_0, lValue45.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:93:4: '.' ID lValue
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(93,4);
					char_literal46=(Token)match(input,13,FOLLOW_13_in_lValue301); 
					char_literal46_tree = (Object)adaptor.create(char_literal46);
					adaptor.addChild(root_0, char_literal46_tree);
					dbg.location(93,8);
					ID47=(Token)match(input,ID,FOLLOW_ID_in_lValue303); 
					ID47_tree = (Object)adaptor.create(ID47);
					adaptor.addChild(root_0, ID47_tree);
					dbg.location(93,11);
					pushFollow(FOLLOW_lValue_in_lValue305);
					lValue48=lValue();
					state._fsp--;

					adaptor.addChild(root_0, lValue48.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:95:2: 
					{
					root_0 = (Object)adaptor.nil();


					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(95, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "lValue");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "lValue"


	public static class exp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exp"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:98:1: exp : e ( LOGOP e )* ;
	public final TigerParser.exp_return exp() throws RecognitionException {
		TigerParser.exp_return retval = new TigerParser.exp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token LOGOP50=null;
		ParserRuleReturnScope e49 =null;
		ParserRuleReturnScope e51 =null;

		Object LOGOP50_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "exp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(98, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:99:2: ( e ( LOGOP e )* )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:99:4: e ( LOGOP e )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(99,4);
			pushFollow(FOLLOW_e_in_exp320);
			e49=e();
			state._fsp--;

			adaptor.addChild(root_0, e49.getTree());
			dbg.location(99,6);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:99:6: ( LOGOP e )*
			try { dbg.enterSubRule(10);

			loop10:
			while (true) {
				int alt10=2;
				try { dbg.enterDecision(10, decisionCanBacktrack[10]);

				int LA10_0 = input.LA(1);
				if ( (LA10_0==LOGOP) ) {
					alt10=1;
				}

				} finally {dbg.exitDecision(10);}

				switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:99:7: LOGOP e
					{
					dbg.location(99,7);
					LOGOP50=(Token)match(input,LOGOP,FOLLOW_LOGOP_in_exp323); 
					LOGOP50_tree = (Object)adaptor.create(LOGOP50);
					adaptor.addChild(root_0, LOGOP50_tree);
					dbg.location(99,13);
					pushFollow(FOLLOW_e_in_exp325);
					e51=e();
					state._fsp--;

					adaptor.addChild(root_0, e51.getTree());

					}
					break;

				default :
					break loop10;
				}
			}
			} finally {dbg.exitSubRule(10);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(100, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "exp"


	public static class e_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "e"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:114:1: e : multExp ( ADDOP multExp )* ;
	public final TigerParser.e_return e() throws RecognitionException {
		TigerParser.e_return retval = new TigerParser.e_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ADDOP53=null;
		ParserRuleReturnScope multExp52 =null;
		ParserRuleReturnScope multExp54 =null;

		Object ADDOP53_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "e");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(114, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:115:2: ( multExp ( ADDOP multExp )* )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:115:4: multExp ( ADDOP multExp )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(115,4);
			pushFollow(FOLLOW_multExp_in_e341);
			multExp52=multExp();
			state._fsp--;

			adaptor.addChild(root_0, multExp52.getTree());
			dbg.location(115,12);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:115:12: ( ADDOP multExp )*
			try { dbg.enterSubRule(11);

			loop11:
			while (true) {
				int alt11=2;
				try { dbg.enterDecision(11, decisionCanBacktrack[11]);

				int LA11_0 = input.LA(1);
				if ( (LA11_0==ADDOP) ) {
					alt11=1;
				}

				} finally {dbg.exitDecision(11);}

				switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:115:13: ADDOP multExp
					{
					dbg.location(115,13);
					ADDOP53=(Token)match(input,ADDOP,FOLLOW_ADDOP_in_e344); 
					ADDOP53_tree = (Object)adaptor.create(ADDOP53);
					adaptor.addChild(root_0, ADDOP53_tree);
					dbg.location(115,19);
					pushFollow(FOLLOW_multExp_in_e346);
					multExp54=multExp();
					state._fsp--;

					adaptor.addChild(root_0, multExp54.getTree());

					}
					break;

				default :
					break loop11;
				}
			}
			} finally {dbg.exitSubRule(11);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(116, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "e");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "e"


	public static class multExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multExp"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:118:1: multExp : atom ( MULTOP atom )* ;
	public final TigerParser.multExp_return multExp() throws RecognitionException {
		TigerParser.multExp_return retval = new TigerParser.multExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token MULTOP56=null;
		ParserRuleReturnScope atom55 =null;
		ParserRuleReturnScope atom57 =null;

		Object MULTOP56_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "multExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(118, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:119:2: ( atom ( MULTOP atom )* )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:119:4: atom ( MULTOP atom )*
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(119,4);
			pushFollow(FOLLOW_atom_in_multExp359);
			atom55=atom();
			state._fsp--;

			adaptor.addChild(root_0, atom55.getTree());
			dbg.location(119,9);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:119:9: ( MULTOP atom )*
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==MULTOP) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:119:10: MULTOP atom
					{
					dbg.location(119,10);
					MULTOP56=(Token)match(input,MULTOP,FOLLOW_MULTOP_in_multExp362); 
					MULTOP56_tree = (Object)adaptor.create(MULTOP56);
					adaptor.addChild(root_0, MULTOP56_tree);
					dbg.location(119,17);
					pushFollow(FOLLOW_atom_in_multExp364);
					atom57=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom57.getTree());

					}
					break;

				default :
					break loop12;
				}
			}
			} finally {dbg.exitSubRule(12);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(120, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "multExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "multExp"


	public static class atom_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:122:1: atom : ( 'nil' | INTLIT | STRINGLIT | seqExp | ID idBegin | ifThen | whileExp | forExp | 'break' | letExp );
	public final TigerParser.atom_return atom() throws RecognitionException {
		TigerParser.atom_return retval = new TigerParser.atom_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal58=null;
		Token INTLIT59=null;
		Token STRINGLIT60=null;
		Token ID62=null;
		Token string_literal67=null;
		ParserRuleReturnScope seqExp61 =null;
		ParserRuleReturnScope idBegin63 =null;
		ParserRuleReturnScope ifThen64 =null;
		ParserRuleReturnScope whileExp65 =null;
		ParserRuleReturnScope forExp66 =null;
		ParserRuleReturnScope letExp68 =null;

		Object string_literal58_tree=null;
		Object INTLIT59_tree=null;
		Object STRINGLIT60_tree=null;
		Object ID62_tree=null;
		Object string_literal67_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "atom");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(122, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:123:2: ( 'nil' | INTLIT | STRINGLIT | seqExp | ID idBegin | ifThen | whileExp | forExp | 'break' | letExp )
			int alt13=10;
			try { dbg.enterDecision(13, decisionCanBacktrack[13]);

			switch ( input.LA(1) ) {
			case 30:
				{
				alt13=1;
				}
				break;
			case INTLIT:
				{
				alt13=2;
				}
				break;
			case STRINGLIT:
				{
				alt13=3;
				}
				break;
			case 10:
				{
				alt13=4;
				}
				break;
			case ID:
				{
				alt13=5;
				}
				break;
			case 27:
				{
				alt13=6;
				}
				break;
			case 36:
				{
				alt13=7;
				}
				break;
			case 25:
				{
				alt13=8;
				}
				break;
			case 21:
				{
				alt13=9;
				}
				break;
			case 29:
				{
				alt13=10;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(13);}

			switch (alt13) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:123:4: 'nil'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(123,4);
					string_literal58=(Token)match(input,30,FOLLOW_30_in_atom377); 
					string_literal58_tree = (Object)adaptor.create(string_literal58);
					adaptor.addChild(root_0, string_literal58_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:124:4: INTLIT
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(124,4);
					INTLIT59=(Token)match(input,INTLIT,FOLLOW_INTLIT_in_atom382); 
					INTLIT59_tree = (Object)adaptor.create(INTLIT59);
					adaptor.addChild(root_0, INTLIT59_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:125:4: STRINGLIT
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(125,4);
					STRINGLIT60=(Token)match(input,STRINGLIT,FOLLOW_STRINGLIT_in_atom387); 
					STRINGLIT60_tree = (Object)adaptor.create(STRINGLIT60);
					adaptor.addChild(root_0, STRINGLIT60_tree);

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:126:4: seqExp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(126,4);
					pushFollow(FOLLOW_seqExp_in_atom392);
					seqExp61=seqExp();
					state._fsp--;

					adaptor.addChild(root_0, seqExp61.getTree());

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:128:4: ID idBegin
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(128,4);
					ID62=(Token)match(input,ID,FOLLOW_ID_in_atom399); 
					ID62_tree = (Object)adaptor.create(ID62);
					adaptor.addChild(root_0, ID62_tree);
					dbg.location(128,7);
					pushFollow(FOLLOW_idBegin_in_atom401);
					idBegin63=idBegin();
					state._fsp--;

					adaptor.addChild(root_0, idBegin63.getTree());

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:129:4: ifThen
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(129,4);
					pushFollow(FOLLOW_ifThen_in_atom406);
					ifThen64=ifThen();
					state._fsp--;

					adaptor.addChild(root_0, ifThen64.getTree());

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:130:4: whileExp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(130,4);
					pushFollow(FOLLOW_whileExp_in_atom411);
					whileExp65=whileExp();
					state._fsp--;

					adaptor.addChild(root_0, whileExp65.getTree());

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:131:4: forExp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(131,4);
					pushFollow(FOLLOW_forExp_in_atom416);
					forExp66=forExp();
					state._fsp--;

					adaptor.addChild(root_0, forExp66.getTree());

					}
					break;
				case 9 :
					dbg.enterAlt(9);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:132:4: 'break'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(132,4);
					string_literal67=(Token)match(input,21,FOLLOW_21_in_atom421); 
					string_literal67_tree = (Object)adaptor.create(string_literal67);
					adaptor.addChild(root_0, string_literal67_tree);

					}
					break;
				case 10 :
					dbg.enterAlt(10);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:133:4: letExp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(133,4);
					pushFollow(FOLLOW_letExp_in_atom426);
					letExp68=letExp();
					state._fsp--;

					adaptor.addChild(root_0, letExp68.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(134, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "atom");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "atom"


	public static class seqExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "seqExp"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:136:1: seqExp : '(' ( exp ( ';' exp )* )? ')' ;
	public final TigerParser.seqExp_return seqExp() throws RecognitionException {
		TigerParser.seqExp_return retval = new TigerParser.seqExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal69=null;
		Token char_literal71=null;
		Token char_literal73=null;
		ParserRuleReturnScope exp70 =null;
		ParserRuleReturnScope exp72 =null;

		Object char_literal69_tree=null;
		Object char_literal71_tree=null;
		Object char_literal73_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "seqExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(136, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:137:2: ( '(' ( exp ( ';' exp )* )? ')' )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:137:4: '(' ( exp ( ';' exp )* )? ')'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(137,4);
			char_literal69=(Token)match(input,10,FOLLOW_10_in_seqExp437); 
			char_literal69_tree = (Object)adaptor.create(char_literal69);
			adaptor.addChild(root_0, char_literal69_tree);
			dbg.location(137,8);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:137:8: ( exp ( ';' exp )* )?
			int alt15=2;
			try { dbg.enterSubRule(15);
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			int LA15_0 = input.LA(1);
			if ( ((LA15_0 >= ID && LA15_0 <= INTLIT)||(LA15_0 >= STRINGLIT && LA15_0 <= 10)||LA15_0==21||LA15_0==25||LA15_0==27||(LA15_0 >= 29 && LA15_0 <= 30)||LA15_0==36) ) {
				alt15=1;
			}
			} finally {dbg.exitDecision(15);}

			switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:137:9: exp ( ';' exp )*
					{
					dbg.location(137,9);
					pushFollow(FOLLOW_exp_in_seqExp440);
					exp70=exp();
					state._fsp--;

					adaptor.addChild(root_0, exp70.getTree());
					dbg.location(137,13);
					// /home/nathan/Telecom/vannesso4u/Tiger.g:137:13: ( ';' exp )*
					try { dbg.enterSubRule(14);

					loop14:
					while (true) {
						int alt14=2;
						try { dbg.enterDecision(14, decisionCanBacktrack[14]);

						int LA14_0 = input.LA(1);
						if ( (LA14_0==16) ) {
							alt14=1;
						}

						} finally {dbg.exitDecision(14);}

						switch (alt14) {
						case 1 :
							dbg.enterAlt(1);

							// /home/nathan/Telecom/vannesso4u/Tiger.g:137:14: ';' exp
							{
							dbg.location(137,14);
							char_literal71=(Token)match(input,16,FOLLOW_16_in_seqExp443); 
							char_literal71_tree = (Object)adaptor.create(char_literal71);
							adaptor.addChild(root_0, char_literal71_tree);
							dbg.location(137,18);
							pushFollow(FOLLOW_exp_in_seqExp445);
							exp72=exp();
							state._fsp--;

							adaptor.addChild(root_0, exp72.getTree());

							}
							break;

						default :
							break loop14;
						}
					}
					} finally {dbg.exitSubRule(14);}

					}
					break;

			}
			} finally {dbg.exitSubRule(15);}
			dbg.location(137,26);
			char_literal73=(Token)match(input,11,FOLLOW_11_in_seqExp451); 
			char_literal73_tree = (Object)adaptor.create(char_literal73);
			adaptor.addChild(root_0, char_literal73_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(138, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "seqExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "seqExp"


	public static class idBegin_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "idBegin"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:156:1: idBegin : ( '[' exp ']' bracBegin | '.' ID lValue | '{' ( fieldCreate ( ',' fieldCreate )* )? '}' );
	public final TigerParser.idBegin_return idBegin() throws RecognitionException {
		TigerParser.idBegin_return retval = new TigerParser.idBegin_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal74=null;
		Token char_literal76=null;
		Token char_literal78=null;
		Token ID79=null;
		Token char_literal81=null;
		Token char_literal83=null;
		Token char_literal85=null;
		ParserRuleReturnScope exp75 =null;
		ParserRuleReturnScope bracBegin77 =null;
		ParserRuleReturnScope lValue80 =null;
		ParserRuleReturnScope fieldCreate82 =null;
		ParserRuleReturnScope fieldCreate84 =null;

		Object char_literal74_tree=null;
		Object char_literal76_tree=null;
		Object char_literal78_tree=null;
		Object ID79_tree=null;
		Object char_literal81_tree=null;
		Object char_literal83_tree=null;
		Object char_literal85_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "idBegin");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(156, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:157:2: ( '[' exp ']' bracBegin | '.' ID lValue | '{' ( fieldCreate ( ',' fieldCreate )* )? '}' )
			int alt18=3;
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

			switch ( input.LA(1) ) {
			case 18:
				{
				alt18=1;
				}
				break;
			case 13:
				{
				alt18=2;
				}
				break;
			case 37:
				{
				alt18=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:157:4: '[' exp ']' bracBegin
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(157,4);
					char_literal74=(Token)match(input,18,FOLLOW_18_in_idBegin471); 
					char_literal74_tree = (Object)adaptor.create(char_literal74);
					adaptor.addChild(root_0, char_literal74_tree);
					dbg.location(157,8);
					pushFollow(FOLLOW_exp_in_idBegin473);
					exp75=exp();
					state._fsp--;

					adaptor.addChild(root_0, exp75.getTree());
					dbg.location(157,12);
					char_literal76=(Token)match(input,19,FOLLOW_19_in_idBegin475); 
					char_literal76_tree = (Object)adaptor.create(char_literal76);
					adaptor.addChild(root_0, char_literal76_tree);
					dbg.location(157,16);
					pushFollow(FOLLOW_bracBegin_in_idBegin477);
					bracBegin77=bracBegin();
					state._fsp--;

					adaptor.addChild(root_0, bracBegin77.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:158:4: '.' ID lValue
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(158,4);
					char_literal78=(Token)match(input,13,FOLLOW_13_in_idBegin482); 
					char_literal78_tree = (Object)adaptor.create(char_literal78);
					adaptor.addChild(root_0, char_literal78_tree);
					dbg.location(158,8);
					ID79=(Token)match(input,ID,FOLLOW_ID_in_idBegin484); 
					ID79_tree = (Object)adaptor.create(ID79);
					adaptor.addChild(root_0, ID79_tree);
					dbg.location(158,11);
					pushFollow(FOLLOW_lValue_in_idBegin486);
					lValue80=lValue();
					state._fsp--;

					adaptor.addChild(root_0, lValue80.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:159:4: '{' ( fieldCreate ( ',' fieldCreate )* )? '}'
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(159,4);
					char_literal81=(Token)match(input,37,FOLLOW_37_in_idBegin491); 
					char_literal81_tree = (Object)adaptor.create(char_literal81);
					adaptor.addChild(root_0, char_literal81_tree);
					dbg.location(159,8);
					// /home/nathan/Telecom/vannesso4u/Tiger.g:159:8: ( fieldCreate ( ',' fieldCreate )* )?
					int alt17=2;
					try { dbg.enterSubRule(17);
					try { dbg.enterDecision(17, decisionCanBacktrack[17]);

					int LA17_0 = input.LA(1);
					if ( (LA17_0==ID) ) {
						alt17=1;
					}
					} finally {dbg.exitDecision(17);}

					switch (alt17) {
						case 1 :
							dbg.enterAlt(1);

							// /home/nathan/Telecom/vannesso4u/Tiger.g:159:9: fieldCreate ( ',' fieldCreate )*
							{
							dbg.location(159,9);
							pushFollow(FOLLOW_fieldCreate_in_idBegin494);
							fieldCreate82=fieldCreate();
							state._fsp--;

							adaptor.addChild(root_0, fieldCreate82.getTree());
							dbg.location(159,20);
							// /home/nathan/Telecom/vannesso4u/Tiger.g:159:20: ( ',' fieldCreate )*
							try { dbg.enterSubRule(16);

							loop16:
							while (true) {
								int alt16=2;
								try { dbg.enterDecision(16, decisionCanBacktrack[16]);

								int LA16_0 = input.LA(1);
								if ( (LA16_0==12) ) {
									alt16=1;
								}

								} finally {dbg.exitDecision(16);}

								switch (alt16) {
								case 1 :
									dbg.enterAlt(1);

									// /home/nathan/Telecom/vannesso4u/Tiger.g:159:21: ',' fieldCreate
									{
									dbg.location(159,21);
									char_literal83=(Token)match(input,12,FOLLOW_12_in_idBegin496); 
									char_literal83_tree = (Object)adaptor.create(char_literal83);
									adaptor.addChild(root_0, char_literal83_tree);
									dbg.location(159,25);
									pushFollow(FOLLOW_fieldCreate_in_idBegin498);
									fieldCreate84=fieldCreate();
									state._fsp--;

									adaptor.addChild(root_0, fieldCreate84.getTree());

									}
									break;

								default :
									break loop16;
								}
							}
							} finally {dbg.exitSubRule(16);}

							}
							break;

					}
					} finally {dbg.exitSubRule(17);}
					dbg.location(159,41);
					char_literal85=(Token)match(input,38,FOLLOW_38_in_idBegin504); 
					char_literal85_tree = (Object)adaptor.create(char_literal85);
					adaptor.addChild(root_0, char_literal85_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(160, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "idBegin");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "idBegin"


	public static class bracBegin_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "bracBegin"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:162:1: bracBegin : ( 'of' exp | lValue );
	public final TigerParser.bracBegin_return bracBegin() throws RecognitionException {
		TigerParser.bracBegin_return retval = new TigerParser.bracBegin_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal86=null;
		ParserRuleReturnScope exp87 =null;
		ParserRuleReturnScope lValue88 =null;

		Object string_literal86_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "bracBegin");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(162, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:163:2: ( 'of' exp | lValue )
			int alt19=2;
			try { dbg.enterDecision(19, decisionCanBacktrack[19]);

			int LA19_0 = input.LA(1);
			if ( (LA19_0==31) ) {
				alt19=1;
			}
			else if ( (LA19_0==EOF||LA19_0==ADDOP||(LA19_0 >= LOGOP && LA19_0 <= MULTOP)||(LA19_0 >= 11 && LA19_0 <= 13)||LA19_0==16||(LA19_0 >= 18 && LA19_0 <= 19)||(LA19_0 >= 22 && LA19_0 <= 24)||LA19_0==26||LA19_0==28||(LA19_0 >= 32 && LA19_0 <= 35)||LA19_0==38) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(19);}

			switch (alt19) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:163:5: 'of' exp
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(163,5);
					string_literal86=(Token)match(input,31,FOLLOW_31_in_bracBegin516); 
					string_literal86_tree = (Object)adaptor.create(string_literal86);
					adaptor.addChild(root_0, string_literal86_tree);
					dbg.location(163,10);
					pushFollow(FOLLOW_exp_in_bracBegin518);
					exp87=exp();
					state._fsp--;

					adaptor.addChild(root_0, exp87.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:164:4: lValue
					{
					root_0 = (Object)adaptor.nil();


					dbg.location(164,4);
					pushFollow(FOLLOW_lValue_in_bracBegin523);
					lValue88=lValue();
					state._fsp--;

					adaptor.addChild(root_0, lValue88.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(165, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "bracBegin");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "bracBegin"


	public static class fieldCreate_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "fieldCreate"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:173:1: fieldCreate : ID '=' exp ;
	public final TigerParser.fieldCreate_return fieldCreate() throws RecognitionException {
		TigerParser.fieldCreate_return retval = new TigerParser.fieldCreate_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID89=null;
		Token char_literal90=null;
		ParserRuleReturnScope exp91 =null;

		Object ID89_tree=null;
		Object char_literal90_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "fieldCreate");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(173, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:174:2: ( ID '=' exp )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:174:4: ID '=' exp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(174,4);
			ID89=(Token)match(input,ID,FOLLOW_ID_in_fieldCreate537); 
			ID89_tree = (Object)adaptor.create(ID89);
			adaptor.addChild(root_0, ID89_tree);
			dbg.location(174,7);
			char_literal90=(Token)match(input,17,FOLLOW_17_in_fieldCreate539); 
			char_literal90_tree = (Object)adaptor.create(char_literal90);
			adaptor.addChild(root_0, char_literal90_tree);
			dbg.location(174,11);
			pushFollow(FOLLOW_exp_in_fieldCreate541);
			exp91=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp91.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(175, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "fieldCreate");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "fieldCreate"


	public static class ifThen_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "ifThen"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:178:1: ifThen : 'if' exp 'then' exp ( options {greedy=true; } : 'else' exp )? ;
	public final TigerParser.ifThen_return ifThen() throws RecognitionException {
		TigerParser.ifThen_return retval = new TigerParser.ifThen_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal92=null;
		Token string_literal94=null;
		Token string_literal96=null;
		ParserRuleReturnScope exp93 =null;
		ParserRuleReturnScope exp95 =null;
		ParserRuleReturnScope exp97 =null;

		Object string_literal92_tree=null;
		Object string_literal94_tree=null;
		Object string_literal96_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "ifThen");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(178, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:179:2: ( 'if' exp 'then' exp ( options {greedy=true; } : 'else' exp )? )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:179:4: 'if' exp 'then' exp ( options {greedy=true; } : 'else' exp )?
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(179,4);
			string_literal92=(Token)match(input,27,FOLLOW_27_in_ifThen553); 
			string_literal92_tree = (Object)adaptor.create(string_literal92);
			adaptor.addChild(root_0, string_literal92_tree);
			dbg.location(179,9);
			pushFollow(FOLLOW_exp_in_ifThen555);
			exp93=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp93.getTree());
			dbg.location(179,13);
			string_literal94=(Token)match(input,32,FOLLOW_32_in_ifThen557); 
			string_literal94_tree = (Object)adaptor.create(string_literal94);
			adaptor.addChild(root_0, string_literal94_tree);
			dbg.location(179,20);
			pushFollow(FOLLOW_exp_in_ifThen559);
			exp95=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp95.getTree());
			dbg.location(179,24);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:179:24: ( options {greedy=true; } : 'else' exp )?
			int alt20=2;
			try { dbg.enterSubRule(20);
			try { dbg.enterDecision(20, decisionCanBacktrack[20]);

			int LA20_0 = input.LA(1);
			if ( (LA20_0==23) ) {
				alt20=1;
			}
			} finally {dbg.exitDecision(20);}

			switch (alt20) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:179:48: 'else' exp
					{
					dbg.location(179,48);
					string_literal96=(Token)match(input,23,FOLLOW_23_in_ifThen570); 
					string_literal96_tree = (Object)adaptor.create(string_literal96);
					adaptor.addChild(root_0, string_literal96_tree);
					dbg.location(179,55);
					pushFollow(FOLLOW_exp_in_ifThen572);
					exp97=exp();
					state._fsp--;

					adaptor.addChild(root_0, exp97.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(20);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(180, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ifThen");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "ifThen"


	public static class whileExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "whileExp"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:187:1: whileExp : 'while' exp 'do' exp ;
	public final TigerParser.whileExp_return whileExp() throws RecognitionException {
		TigerParser.whileExp_return retval = new TigerParser.whileExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal98=null;
		Token string_literal100=null;
		ParserRuleReturnScope exp99 =null;
		ParserRuleReturnScope exp101 =null;

		Object string_literal98_tree=null;
		Object string_literal100_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "whileExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(187, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:188:2: ( 'while' exp 'do' exp )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:188:4: 'while' exp 'do' exp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(188,4);
			string_literal98=(Token)match(input,36,FOLLOW_36_in_whileExp589); 
			string_literal98_tree = (Object)adaptor.create(string_literal98);
			adaptor.addChild(root_0, string_literal98_tree);
			dbg.location(188,12);
			pushFollow(FOLLOW_exp_in_whileExp591);
			exp99=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp99.getTree());
			dbg.location(188,16);
			string_literal100=(Token)match(input,22,FOLLOW_22_in_whileExp593); 
			string_literal100_tree = (Object)adaptor.create(string_literal100);
			adaptor.addChild(root_0, string_literal100_tree);
			dbg.location(188,21);
			pushFollow(FOLLOW_exp_in_whileExp595);
			exp101=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp101.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(189, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "whileExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "whileExp"


	public static class forExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "forExp"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:191:1: forExp : 'for' ID ':=' exp 'to' exp 'do' exp ;
	public final TigerParser.forExp_return forExp() throws RecognitionException {
		TigerParser.forExp_return retval = new TigerParser.forExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal102=null;
		Token ID103=null;
		Token string_literal104=null;
		Token string_literal106=null;
		Token string_literal108=null;
		ParserRuleReturnScope exp105 =null;
		ParserRuleReturnScope exp107 =null;
		ParserRuleReturnScope exp109 =null;

		Object string_literal102_tree=null;
		Object ID103_tree=null;
		Object string_literal104_tree=null;
		Object string_literal106_tree=null;
		Object string_literal108_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "forExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(191, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:192:2: ( 'for' ID ':=' exp 'to' exp 'do' exp )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:192:4: 'for' ID ':=' exp 'to' exp 'do' exp
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(192,4);
			string_literal102=(Token)match(input,25,FOLLOW_25_in_forExp606); 
			string_literal102_tree = (Object)adaptor.create(string_literal102);
			adaptor.addChild(root_0, string_literal102_tree);
			dbg.location(192,10);
			ID103=(Token)match(input,ID,FOLLOW_ID_in_forExp608); 
			ID103_tree = (Object)adaptor.create(ID103);
			adaptor.addChild(root_0, ID103_tree);
			dbg.location(192,13);
			string_literal104=(Token)match(input,15,FOLLOW_15_in_forExp610); 
			string_literal104_tree = (Object)adaptor.create(string_literal104);
			adaptor.addChild(root_0, string_literal104_tree);
			dbg.location(192,18);
			pushFollow(FOLLOW_exp_in_forExp612);
			exp105=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp105.getTree());
			dbg.location(192,22);
			string_literal106=(Token)match(input,33,FOLLOW_33_in_forExp614); 
			string_literal106_tree = (Object)adaptor.create(string_literal106);
			adaptor.addChild(root_0, string_literal106_tree);
			dbg.location(192,27);
			pushFollow(FOLLOW_exp_in_forExp616);
			exp107=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp107.getTree());
			dbg.location(192,31);
			string_literal108=(Token)match(input,22,FOLLOW_22_in_forExp618); 
			string_literal108_tree = (Object)adaptor.create(string_literal108);
			adaptor.addChild(root_0, string_literal108_tree);
			dbg.location(192,36);
			pushFollow(FOLLOW_exp_in_forExp620);
			exp109=exp();
			state._fsp--;

			adaptor.addChild(root_0, exp109.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(193, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "forExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "forExp"


	public static class letExp_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "letExp"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:195:1: letExp : 'let' ( dec )+ 'in' ( exp ( ';' exp )* )? 'end' ;
	public final TigerParser.letExp_return letExp() throws RecognitionException {
		TigerParser.letExp_return retval = new TigerParser.letExp_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal110=null;
		Token string_literal112=null;
		Token char_literal114=null;
		Token string_literal116=null;
		ParserRuleReturnScope dec111 =null;
		ParserRuleReturnScope exp113 =null;
		ParserRuleReturnScope exp115 =null;

		Object string_literal110_tree=null;
		Object string_literal112_tree=null;
		Object char_literal114_tree=null;
		Object string_literal116_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "letExp");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(195, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:196:2: ( 'let' ( dec )+ 'in' ( exp ( ';' exp )* )? 'end' )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:196:4: 'let' ( dec )+ 'in' ( exp ( ';' exp )* )? 'end'
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(196,4);
			string_literal110=(Token)match(input,29,FOLLOW_29_in_letExp631); 
			string_literal110_tree = (Object)adaptor.create(string_literal110);
			adaptor.addChild(root_0, string_literal110_tree);
			dbg.location(196,10);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:196:10: ( dec )+
			int cnt21=0;
			try { dbg.enterSubRule(21);

			loop21:
			while (true) {
				int alt21=2;
				try { dbg.enterDecision(21, decisionCanBacktrack[21]);

				int LA21_0 = input.LA(1);
				if ( (LA21_0==26||(LA21_0 >= 34 && LA21_0 <= 35)) ) {
					alt21=1;
				}

				} finally {dbg.exitDecision(21);}

				switch (alt21) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:196:11: dec
					{
					dbg.location(196,11);
					pushFollow(FOLLOW_dec_in_letExp634);
					dec111=dec();
					state._fsp--;

					adaptor.addChild(root_0, dec111.getTree());

					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					EarlyExitException eee = new EarlyExitException(21, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt21++;
			}
			} finally {dbg.exitSubRule(21);}
			dbg.location(196,17);
			string_literal112=(Token)match(input,28,FOLLOW_28_in_letExp638); 
			string_literal112_tree = (Object)adaptor.create(string_literal112);
			adaptor.addChild(root_0, string_literal112_tree);
			dbg.location(196,22);
			// /home/nathan/Telecom/vannesso4u/Tiger.g:196:22: ( exp ( ';' exp )* )?
			int alt23=2;
			try { dbg.enterSubRule(23);
			try { dbg.enterDecision(23, decisionCanBacktrack[23]);

			int LA23_0 = input.LA(1);
			if ( ((LA23_0 >= ID && LA23_0 <= INTLIT)||(LA23_0 >= STRINGLIT && LA23_0 <= 10)||LA23_0==21||LA23_0==25||LA23_0==27||(LA23_0 >= 29 && LA23_0 <= 30)||LA23_0==36) ) {
				alt23=1;
			}
			} finally {dbg.exitDecision(23);}

			switch (alt23) {
				case 1 :
					dbg.enterAlt(1);

					// /home/nathan/Telecom/vannesso4u/Tiger.g:196:23: exp ( ';' exp )*
					{
					dbg.location(196,23);
					pushFollow(FOLLOW_exp_in_letExp641);
					exp113=exp();
					state._fsp--;

					adaptor.addChild(root_0, exp113.getTree());
					dbg.location(196,26);
					// /home/nathan/Telecom/vannesso4u/Tiger.g:196:26: ( ';' exp )*
					try { dbg.enterSubRule(22);

					loop22:
					while (true) {
						int alt22=2;
						try { dbg.enterDecision(22, decisionCanBacktrack[22]);

						int LA22_0 = input.LA(1);
						if ( (LA22_0==16) ) {
							alt22=1;
						}

						} finally {dbg.exitDecision(22);}

						switch (alt22) {
						case 1 :
							dbg.enterAlt(1);

							// /home/nathan/Telecom/vannesso4u/Tiger.g:196:27: ';' exp
							{
							dbg.location(196,27);
							char_literal114=(Token)match(input,16,FOLLOW_16_in_letExp643); 
							char_literal114_tree = (Object)adaptor.create(char_literal114);
							adaptor.addChild(root_0, char_literal114_tree);
							dbg.location(196,31);
							pushFollow(FOLLOW_exp_in_letExp645);
							exp115=exp();
							state._fsp--;

							adaptor.addChild(root_0, exp115.getTree());

							}
							break;

						default :
							break loop22;
						}
					}
					} finally {dbg.exitSubRule(22);}

					}
					break;

			}
			} finally {dbg.exitSubRule(23);}
			dbg.location(196,39);
			string_literal116=(Token)match(input,24,FOLLOW_24_in_letExp651); 
			string_literal116_tree = (Object)adaptor.create(string_literal116);
			adaptor.addChild(root_0, string_literal116_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(197, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "letExp");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "letExp"


	public static class tyid_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "tyid"
	// /home/nathan/Telecom/vannesso4u/Tiger.g:199:1: tyid : ID ;
	public final TigerParser.tyid_return tyid() throws RecognitionException {
		TigerParser.tyid_return retval = new TigerParser.tyid_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token ID117=null;

		Object ID117_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "tyid");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(199, 0);

		try {
			// /home/nathan/Telecom/vannesso4u/Tiger.g:200:2: ( ID )
			dbg.enterAlt(1);

			// /home/nathan/Telecom/vannesso4u/Tiger.g:200:4: ID
			{
			root_0 = (Object)adaptor.nil();


			dbg.location(200,4);
			ID117=(Token)match(input,ID,FOLLOW_ID_in_tyid662); 
			ID117_tree = (Object)adaptor.create(ID117);
			adaptor.addChild(root_0, ID117_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(201, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "tyid");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "tyid"

	// Delegated rules



	public static final BitSet FOLLOW_exp_in_program70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tyDec_in_dec81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varDec_in_dec86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_funDec_in_dec91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_tyDec101 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tyid_in_tyDec103 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_tyDec105 = new BitSet(new long[]{0x0000002000100020L});
	public static final BitSet FOLLOW_ty_in_tyDec107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tyid_in_ty118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arrTy_in_ty123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_recTy_in_ty128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_arrTy139 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_arrTy141 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tyid_in_arrTy143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_recTy154 = new BitSet(new long[]{0x0000004000000020L});
	public static final BitSet FOLLOW_fieldDec_in_recTy157 = new BitSet(new long[]{0x0000004000001000L});
	public static final BitSet FOLLOW_12_in_recTy160 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_fieldDec_in_recTy162 = new BitSet(new long[]{0x0000004000001000L});
	public static final BitSet FOLLOW_38_in_recTy168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fieldDec179 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_fieldDec181 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tyid_in_fieldDec183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_funDec194 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_funDec196 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_funDec198 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_fieldDec_in_funDec201 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_12_in_funDec203 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_fieldDec_in_funDec205 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_11_in_funDec211 = new BitSet(new long[]{0x0000000000024000L});
	public static final BitSet FOLLOW_returnType_in_funDec213 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_funDec215 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_funDec217 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_returnType228 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tyid_in_returnType230 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_varDec244 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_varDec246 = new BitSet(new long[]{0x000000000000C000L});
	public static final BitSet FOLLOW_vd_in_varDec248 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_varDec250 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_varDec252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_vd263 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_tyid_in_vd265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_lValue290 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_lValue292 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_lValue294 = new BitSet(new long[]{0x0000000000042000L});
	public static final BitSet FOLLOW_lValue_in_lValue296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_lValue301 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_lValue303 = new BitSet(new long[]{0x0000000000042000L});
	public static final BitSet FOLLOW_lValue_in_lValue305 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_e_in_exp320 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_LOGOP_in_exp323 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_e_in_exp325 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_multExp_in_e341 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ADDOP_in_e344 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_multExp_in_e346 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_atom_in_multExp359 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_MULTOP_in_multExp362 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_atom_in_multExp364 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_30_in_atom377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTLIT_in_atom382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRINGLIT_in_atom387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_seqExp_in_atom392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom399 = new BitSet(new long[]{0x0000002000042000L});
	public static final BitSet FOLLOW_idBegin_in_atom401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifThen_in_atom406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whileExp_in_atom411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forExp_in_atom416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_atom421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_letExp_in_atom426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_seqExp437 = new BitSet(new long[]{0x000000106A200E60L});
	public static final BitSet FOLLOW_exp_in_seqExp440 = new BitSet(new long[]{0x0000000000010800L});
	public static final BitSet FOLLOW_16_in_seqExp443 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_seqExp445 = new BitSet(new long[]{0x0000000000010800L});
	public static final BitSet FOLLOW_11_in_seqExp451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_18_in_idBegin471 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_idBegin473 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_19_in_idBegin475 = new BitSet(new long[]{0x0000000080042000L});
	public static final BitSet FOLLOW_bracBegin_in_idBegin477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_idBegin482 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_idBegin484 = new BitSet(new long[]{0x0000000000042000L});
	public static final BitSet FOLLOW_lValue_in_idBegin486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_37_in_idBegin491 = new BitSet(new long[]{0x0000004000000020L});
	public static final BitSet FOLLOW_fieldCreate_in_idBegin494 = new BitSet(new long[]{0x0000004000001000L});
	public static final BitSet FOLLOW_12_in_idBegin496 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_fieldCreate_in_idBegin498 = new BitSet(new long[]{0x0000004000001000L});
	public static final BitSet FOLLOW_38_in_idBegin504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_bracBegin516 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_bracBegin518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lValue_in_bracBegin523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fieldCreate537 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_fieldCreate539 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_fieldCreate541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_ifThen553 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_ifThen555 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_ifThen557 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_ifThen559 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_ifThen570 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_ifThen572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_whileExp589 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_whileExp591 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_whileExp593 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_whileExp595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_forExp606 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_forExp608 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_forExp610 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_forExp612 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_33_in_forExp614 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_forExp616 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_forExp618 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_forExp620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_29_in_letExp631 = new BitSet(new long[]{0x0000000C04000000L});
	public static final BitSet FOLLOW_dec_in_letExp634 = new BitSet(new long[]{0x0000000C14000000L});
	public static final BitSet FOLLOW_28_in_letExp638 = new BitSet(new long[]{0x000000106B200660L});
	public static final BitSet FOLLOW_exp_in_letExp641 = new BitSet(new long[]{0x0000000001010000L});
	public static final BitSet FOLLOW_16_in_letExp643 = new BitSet(new long[]{0x000000106A200660L});
	public static final BitSet FOLLOW_exp_in_letExp645 = new BitSet(new long[]{0x0000000001010000L});
	public static final BitSet FOLLOW_24_in_letExp651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_tyid662 = new BitSet(new long[]{0x0000000000000002L});
}
