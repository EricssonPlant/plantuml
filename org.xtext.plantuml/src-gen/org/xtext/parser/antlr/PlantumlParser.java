/*
 * generated by Xtext
 */
package org.xtext.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.services.PlantumlGrammarAccess;

public class PlantumlParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private PlantumlGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.xtext.parser.antlr.internal.InternalPlantumlParser createParser(XtextTokenStream stream) {
		return new org.xtext.parser.antlr.internal.InternalPlantumlParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public PlantumlGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(PlantumlGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
