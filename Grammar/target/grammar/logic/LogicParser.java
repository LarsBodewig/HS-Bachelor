// Generated from Logic.g4 by ANTLR 4.8

package grammar.logic;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALPHA=1, DIGIT=2, NOT=3, AND=4, OR=5, IMPLY=6, PARENTHESES_OPEN=7, PARENTHESES_CLOSE=8, 
		STATEMENT_DELIMIT=9, STATEMENTS_OPEN=10, STATEMENTS_CLOSE=11, WS=12;
	public static final int
		RULE_variable = 0, RULE_term = 1, RULE_statement = 2, RULE_statements = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"variable", "term", "statement", "statements"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'('", "')'", null, "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALPHA", "DIGIT", "NOT", "AND", "OR", "IMPLY", "PARENTHESES_OPEN", 
			"PARENTHESES_CLOSE", "STATEMENT_DELIMIT", "STATEMENTS_OPEN", "STATEMENTS_CLOSE", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Logic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LogicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> ALPHA() { return getTokens(LogicParser.ALPHA); }
		public TerminalNode ALPHA(int i) {
			return getToken(LogicParser.ALPHA, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(LogicParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(LogicParser.DIGIT, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_variable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(ALPHA);
			setState(12);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(9);
					_la = _input.LA(1);
					if ( !(_la==ALPHA || _la==DIGIT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(14);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConjunctionContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode AND() { return getToken(LogicParser.AND, 0); }
		public ConjunctionContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitConjunction(this);
		}
	}
	public static class DisjunctionContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OR() { return getToken(LogicParser.OR, 0); }
		public DisjunctionContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitDisjunction(this);
		}
	}
	public static class VarContext extends TermContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitVar(this);
		}
	}
	public static class PrecedenceNegContext extends TermContext {
		public TerminalNode NOT() { return getToken(LogicParser.NOT, 0); }
		public TerminalNode PARENTHESES_OPEN() { return getToken(LogicParser.PARENTHESES_OPEN, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PARENTHESES_CLOSE() { return getToken(LogicParser.PARENTHESES_CLOSE, 0); }
		public PrecedenceNegContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterPrecedenceNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitPrecedenceNeg(this);
		}
	}
	public static class SubjunctionContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode IMPLY() { return getToken(LogicParser.IMPLY, 0); }
		public SubjunctionContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterSubjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitSubjunction(this);
		}
	}
	public static class InhibitionContext extends TermContext {
		public TerminalNode NOT() { return getToken(LogicParser.NOT, 0); }
		public TerminalNode PARENTHESES_OPEN() { return getToken(LogicParser.PARENTHESES_OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode IMPLY() { return getToken(LogicParser.IMPLY, 0); }
		public TerminalNode PARENTHESES_CLOSE() { return getToken(LogicParser.PARENTHESES_CLOSE, 0); }
		public InhibitionContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterInhibition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitInhibition(this);
		}
	}
	public static class VarNegContext extends TermContext {
		public TerminalNode NOT() { return getToken(LogicParser.NOT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarNegContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterVarNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitVarNeg(this);
		}
	}
	public static class ShefferContext extends TermContext {
		public TerminalNode NOT() { return getToken(LogicParser.NOT, 0); }
		public TerminalNode PARENTHESES_OPEN() { return getToken(LogicParser.PARENTHESES_OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode AND() { return getToken(LogicParser.AND, 0); }
		public TerminalNode PARENTHESES_CLOSE() { return getToken(LogicParser.PARENTHESES_CLOSE, 0); }
		public ShefferContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterSheffer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitSheffer(this);
		}
	}
	public static class PrecedenceContext extends TermContext {
		public TerminalNode PARENTHESES_OPEN() { return getToken(LogicParser.PARENTHESES_OPEN, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode PARENTHESES_CLOSE() { return getToken(LogicParser.PARENTHESES_CLOSE, 0); }
		public PrecedenceContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterPrecedence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitPrecedence(this);
		}
	}
	public static class PeirceContext extends TermContext {
		public TerminalNode NOT() { return getToken(LogicParser.NOT, 0); }
		public TerminalNode PARENTHESES_OPEN() { return getToken(LogicParser.PARENTHESES_OPEN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OR() { return getToken(LogicParser.OR, 0); }
		public TerminalNode PARENTHESES_CLOSE() { return getToken(LogicParser.PARENTHESES_CLOSE, 0); }
		public PeirceContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterPeirce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitPeirce(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(16);
				variable();
				}
				break;
			case 2:
				{
				_localctx = new VarNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(NOT);
				setState(18);
				variable();
				}
				break;
			case 3:
				{
				_localctx = new ShefferContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(NOT);
				setState(20);
				match(PARENTHESES_OPEN);
				setState(21);
				term(0);
				setState(22);
				match(AND);
				setState(23);
				term(0);
				setState(24);
				match(PARENTHESES_CLOSE);
				}
				break;
			case 4:
				{
				_localctx = new PeirceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(NOT);
				setState(27);
				match(PARENTHESES_OPEN);
				setState(28);
				term(0);
				setState(29);
				match(OR);
				setState(30);
				term(0);
				setState(31);
				match(PARENTHESES_CLOSE);
				}
				break;
			case 5:
				{
				_localctx = new InhibitionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(NOT);
				setState(34);
				match(PARENTHESES_OPEN);
				setState(35);
				term(0);
				setState(36);
				match(IMPLY);
				setState(37);
				term(0);
				setState(38);
				match(PARENTHESES_CLOSE);
				}
				break;
			case 6:
				{
				_localctx = new PrecedenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(40);
				match(PARENTHESES_OPEN);
				setState(41);
				term(0);
				setState(42);
				match(PARENTHESES_CLOSE);
				}
				break;
			case 7:
				{
				_localctx = new PrecedenceNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44);
				match(NOT);
				setState(45);
				match(PARENTHESES_OPEN);
				setState(46);
				term(0);
				setState(47);
				match(PARENTHESES_CLOSE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(60);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(51);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(52);
						match(AND);
						setState(53);
						term(9);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(54);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(55);
						match(OR);
						setState(56);
						term(7);
						}
						break;
					case 3:
						{
						_localctx = new SubjunctionContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(57);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(58);
						match(IMPLY);
						setState(59);
						term(5);
						}
						break;
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			term(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> STATEMENT_DELIMIT() { return getTokens(LogicParser.STATEMENT_DELIMIT); }
		public TerminalNode STATEMENT_DELIMIT(int i) {
			return getToken(LogicParser.STATEMENT_DELIMIT, i);
		}
		public TerminalNode STATEMENTS_OPEN() { return getToken(LogicParser.STATEMENTS_OPEN, 0); }
		public TerminalNode STATEMENTS_CLOSE() { return getToken(LogicParser.STATEMENTS_CLOSE, 0); }
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LogicListener ) ((LogicListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statements);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				statement();
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STATEMENT_DELIMIT) {
					{
					{
					setState(68);
					match(STATEMENT_DELIMIT);
					setState(69);
					statement();
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATEMENTS_OPEN) {
					{
					setState(75);
					match(STATEMENTS_OPEN);
					}
				}

				setState(78);
				statement();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==STATEMENT_DELIMIT) {
					{
					{
					setState(79);
					match(STATEMENT_DELIMIT);
					setState(80);
					statement();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATEMENTS_CLOSE) {
					{
					setState(86);
					match(STATEMENTS_CLOSE);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\7\2\r\n\2\f\2\16\2\20\13\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\64\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3\3\4\3\4\3\5\3\5\3"+
		"\5\7\5I\n\5\f\5\16\5L\13\5\3\5\5\5O\n\5\3\5\3\5\3\5\7\5T\n\5\f\5\16\5"+
		"W\13\5\3\5\5\5Z\n\5\5\5\\\n\5\3\5\2\3\4\6\2\4\6\b\2\3\3\2\3\4\2h\2\n\3"+
		"\2\2\2\4\63\3\2\2\2\6C\3\2\2\2\b[\3\2\2\2\n\16\7\3\2\2\13\r\t\2\2\2\f"+
		"\13\3\2\2\2\r\20\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\3\3\2\2\2\20\16"+
		"\3\2\2\2\21\22\b\3\1\2\22\64\5\2\2\2\23\24\7\5\2\2\24\64\5\2\2\2\25\26"+
		"\7\5\2\2\26\27\7\t\2\2\27\30\5\4\3\2\30\31\7\6\2\2\31\32\5\4\3\2\32\33"+
		"\7\n\2\2\33\64\3\2\2\2\34\35\7\5\2\2\35\36\7\t\2\2\36\37\5\4\3\2\37 \7"+
		"\7\2\2 !\5\4\3\2!\"\7\n\2\2\"\64\3\2\2\2#$\7\5\2\2$%\7\t\2\2%&\5\4\3\2"+
		"&\'\7\b\2\2\'(\5\4\3\2()\7\n\2\2)\64\3\2\2\2*+\7\t\2\2+,\5\4\3\2,-\7\n"+
		"\2\2-\64\3\2\2\2./\7\5\2\2/\60\7\t\2\2\60\61\5\4\3\2\61\62\7\n\2\2\62"+
		"\64\3\2\2\2\63\21\3\2\2\2\63\23\3\2\2\2\63\25\3\2\2\2\63\34\3\2\2\2\63"+
		"#\3\2\2\2\63*\3\2\2\2\63.\3\2\2\2\64@\3\2\2\2\65\66\f\n\2\2\66\67\7\6"+
		"\2\2\67?\5\4\3\1389\f\b\2\29:\7\7\2\2:?\5\4\3\t;<\f\6\2\2<=\7\b\2\2=?"+
		"\5\4\3\7>\65\3\2\2\2>8\3\2\2\2>;\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2"+
		"A\5\3\2\2\2B@\3\2\2\2CD\5\4\3\2D\7\3\2\2\2EJ\5\6\4\2FG\7\13\2\2GI\5\6"+
		"\4\2HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\\\3\2\2\2LJ\3\2\2\2MO\7"+
		"\f\2\2NM\3\2\2\2NO\3\2\2\2OP\3\2\2\2PU\5\6\4\2QR\7\13\2\2RT\5\6\4\2SQ"+
		"\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WU\3\2\2\2XZ\7\r\2\2Y"+
		"X\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[E\3\2\2\2[N\3\2\2\2\\\t\3\2\2\2\13\16\63"+
		">@JNUY[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}