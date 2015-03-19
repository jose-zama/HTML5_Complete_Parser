package com.html5parser.InsertionModes;

import com.html5parser.Classes.InsertionMode;
import com.html5parser.Classes.ParserContext;
import com.html5parser.Classes.Token;
import com.html5parser.Factories.InsertionModeFactory;
import com.html5parser.Interfaces.IInsertionMode;

public class Initial implements IInsertionMode {

	public ParserContext process(ParserContext parserContext) {

		InsertionModeFactory factory;
		Token token = parserContext.getTokenizerContext().getCurrentToken();

		switch (token.getType()) {
		case DOCTYPE:
			throw new UnsupportedOperationException();

		// A comment token
		// Append a Comment node to the Document object with the data attribute
		// set to the data given in the comment token.
		case comment:
			throw new UnsupportedOperationException();
		// A character token that is one of U+0009 CHARACTER TABULATION, "LF"
		// (U+000A), "FF" (U+000C), "CR" (U+000D), or U+0020 SPACE
		// Ignore the token.
		case character:
			int currentChar = (int) token.getValue().charAt(0);
			if ((currentChar == 0x0009 || currentChar == 0x000A
					|| currentChar == 0x000C || currentChar == 0x000D || currentChar == 0x0020))
				return parserContext;

			// Anything else
			// TODO If the document is not an iframe srcdoc document, then this
			// is a
			// parse error; set the Document to quirks mode.
			// In any case, switch the insertion mode to "before html", then
			// reprocess the current token.
		case end_of_file:
		case start_tag:
		case end_tag:
		default:
			factory = InsertionModeFactory.getInstance();
			parserContext.setInsertionMode(factory
					.getInsertionMode(InsertionMode.before_html));
			parserContext.setFlagReconsumeToken(true);
		}
		return parserContext;
	}

}