// Generated from Logic.g4 by ANTLR 4.8

package grammar.logic;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LogicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALPHA=1, DIGIT=2, NOT=3, AND=4, OR=5, IMPLY=6, PARENTHESES_OPEN=7, PARENTHESES_CLOSE=8, 
		STATEMENT_DELIMIT=9, STATEMENTS_OPEN=10, STATEMENTS_CLOSE=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ALPHA", "DIGIT", "NOT", "AND", "OR", "IMPLY", "PARENTHESES_OPEN", "PARENTHESES_CLOSE", 
			"STATEMENT_DELIMIT", "STATEMENTS_OPEN", "STATEMENTS_CLOSE", "WS"
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


	public LogicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Logic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16V\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\'"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\3\6\3\6\5\6\67"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7D\n\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rQ\n\r\r\r\16\rR\3\r\3\r\2\2\16\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\6\4\2C\\c"+
		"|\3\2\62;\4\2..==\5\2\13\f\17\17\"\"\2^\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35"+
		"\3\2\2\2\7&\3\2\2\2\t/\3\2\2\2\13\66\3\2\2\2\rC\3\2\2\2\17E\3\2\2\2\21"+
		"G\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31P\3\2\2\2\33\34\t\2\2"+
		"\2\34\4\3\2\2\2\35\36\t\3\2\2\36\6\3\2\2\2\37 \7P\2\2 !\7Q\2\2!\'\7V\2"+
		"\2\"#\7p\2\2#$\7q\2\2$\'\7v\2\2%\'\7\u00ae\2\2&\37\3\2\2\2&\"\3\2\2\2"+
		"&%\3\2\2\2\'\b\3\2\2\2()\7C\2\2)*\7P\2\2*\60\7F\2\2+,\7c\2\2,-\7p\2\2"+
		"-\60\7f\2\2.\60\7\u2229\2\2/(\3\2\2\2/+\3\2\2\2/.\3\2\2\2\60\n\3\2\2\2"+
		"\61\62\7Q\2\2\62\67\7T\2\2\63\64\7q\2\2\64\67\7t\2\2\65\67\7\u222a\2\2"+
		"\66\61\3\2\2\2\66\63\3\2\2\2\66\65\3\2\2\2\67\f\3\2\2\289\7K\2\29:\7O"+
		"\2\2:;\7R\2\2;<\7N\2\2<D\7[\2\2=>\7k\2\2>?\7o\2\2?@\7r\2\2@A\7n\2\2AD"+
		"\7{\2\2BD\7\u2194\2\2C8\3\2\2\2C=\3\2\2\2CB\3\2\2\2D\16\3\2\2\2EF\7*\2"+
		"\2F\20\3\2\2\2GH\7+\2\2H\22\3\2\2\2IJ\t\4\2\2J\24\3\2\2\2KL\7}\2\2L\26"+
		"\3\2\2\2MN\7\177\2\2N\30\3\2\2\2OQ\t\5\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2"+
		"\2RS\3\2\2\2ST\3\2\2\2TU\b\r\2\2U\32\3\2\2\2\b\2&/\66CR\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}