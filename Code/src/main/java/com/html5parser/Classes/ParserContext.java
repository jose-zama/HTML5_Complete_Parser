package com.html5parser.Classes;

import java.util.ArrayList;
import java.util.Stack;

import org.w3c.dom.Element;

import com.html5parser.Error.ParseError;
import com.html5parser.Error.ParseErrorType;
import com.html5parser.InsertionModes.Initial;
import com.html5parser.Interfaces.IInsertionMode;

public class ParserContext {

	/*
	 * Tokenizer context
	 */
	private TokenizerContext tokenizerContext = new TokenizerContext();
	
	/*
	 * Insertion modes
	 */	
	private IInsertionMode insertionMode= new Initial();
	private IInsertionMode originalInsertionMode;
	private IInsertionMode currentTemplateInsertionMode;

	/*
	 * Stacks
	 */
	private Stack<Element> openElements= new Stack<Element>();
	private Stack<ParseError> parseErrors = new Stack<ParseError>();
	private Stack<IInsertionMode> templateInsertionModes = new Stack<IInsertionMode>();
	
	/*
	 * Flags
	 */
	private boolean flagScripting = false;
	private boolean flagForceQuirks = false;
	private boolean flagParserPause = false;
	private boolean flagFramesetOk = false;
	private boolean flagStopParsing = false;
	private boolean flagReconsumeToken = false;

	/*
	 * Others
	 */
	private ArrayList<Element> activeFormattingElements = new ArrayList<Element>();
	private Element currentNode;
	private Element adjustedCurrentNode;
	private Element headElementPointer;
	private Element formElementPointer;
	
	
	public TokenizerContext getTokenizerContext() {
		return tokenizerContext;
	}

	public void setTokenizerContext(TokenizerContext value) {
		this.tokenizerContext = value;
	}
	
	public IInsertionMode getInsertionMode() {
		return insertionMode;
	}

	public void setInsertionMode(IInsertionMode value) {
		this.insertionMode = value;
	}
	

/*	public IInsertionMode getInsertionMode() {
		return IInsertionMode;
	}

	public void setInsertionMode(IInsertionMode IInsertionMode) {
		this.insertionMode = IInsertionMode;
	}
*/
	public IInsertionMode getOriginalInsertionMode() {
		return originalInsertionMode;
	}

	public void setOriginalInsertionMode(IInsertionMode originalInsertionMode) {
		this.originalInsertionMode = originalInsertionMode;
	}

	public IInsertionMode getCurrentTemplateInsertionMode() {
		return currentTemplateInsertionMode;
	}

	public void setCurrentTemplateInsertionMode(
			IInsertionMode currentTemplateInsertionMode) {
		this.currentTemplateInsertionMode = currentTemplateInsertionMode;
	}

	public Stack<Element> getOpenElements() {
		return openElements;
	}

	public void setOpenElements(Stack<Element> openElements) {
		this.openElements = openElements;
	}

	public Stack<ParseError> getParseErrors() {
		return parseErrors;
	}

	public void setParseErrors(Stack<ParseError> parseErrors) {
		this.parseErrors = parseErrors;
	}
	
	public void addParseErrors(ParseErrorType parseErrorType) {
		parseErrors.push(new ParseError(parseErrorType,this));		
	}

	public Stack<IInsertionMode> getTemplateInsertionModes() {
		return templateInsertionModes;
	}

	public void setTemplateInsertionModes(
			Stack<IInsertionMode> templateInsertionModes) {
		this.templateInsertionModes = templateInsertionModes;
	}

	public boolean isFlagScripting() {
		return flagScripting;
	}

	public void setFlagScripting(boolean flagScripting) {
		this.flagScripting = flagScripting;
	}

	public boolean isFlagForceQuirks() {
		return flagForceQuirks;
	}

	public void setFlagForceQuirks(boolean flagForceQuirks) {
		this.flagForceQuirks = flagForceQuirks;
	}

	public boolean isFlagParserPause() {
		return flagParserPause;
	}

	public void setFlagParserPause(boolean flagParserPause) {
		this.flagParserPause = flagParserPause;
	}

	public boolean isFlagFramesetOk() {
		return flagFramesetOk;
	}

	public void setFlagFramesetOk(boolean flagFramesetOk) {
		this.flagFramesetOk = flagFramesetOk;
	}

	public ArrayList<Element> getActiveFormattingElements() {
		return activeFormattingElements;
	}

	public void setActiveFormattingElements(
			ArrayList<Element> activeFormattingElements) {
		this.activeFormattingElements = activeFormattingElements;
	}

	public Element getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(Element currentNode) {
		this.currentNode = currentNode;
	}

	public Element getAdjustedCurrentNode() {
		return adjustedCurrentNode;
	}

	public void setAdjustedCurrentNode(Element adjustedCurrentNode) {
		this.adjustedCurrentNode = adjustedCurrentNode;
	}

	public Element getHeadElementPointer() {
		return headElementPointer;
	}

	public void setHeadElementPointer(Element headElementPointer) {
		this.headElementPointer = headElementPointer;
	}

	public Element getFormElementPointer() {
		return formElementPointer;
	}

	public void setFormElementPointer(Element formElementPointer) {
		this.formElementPointer = formElementPointer;
	}

	public boolean isFlagStopParsing() {
		return flagStopParsing;
	}

	public void setFlagStopParsing(boolean flagStopParsing) {
		this.flagStopParsing = flagStopParsing;
	}

	public boolean isFlagReconsumeToken() {
		return flagReconsumeToken;
	}

	public void setFlagReconsumeToken(boolean flagReconsumeToken) {
		this.flagReconsumeToken = flagReconsumeToken;
	}

	
	
}