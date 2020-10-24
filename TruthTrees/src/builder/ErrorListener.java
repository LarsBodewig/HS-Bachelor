package builder;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorListener extends BaseErrorListener {
	
	private final String input;
	
	public ErrorListener(String input) {
		this.input = input;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		throw new RuntimeException("Unrecognized symbol at position " + line + ":" + charPositionInLine + " of '" + this.input + "'");
	}
}
