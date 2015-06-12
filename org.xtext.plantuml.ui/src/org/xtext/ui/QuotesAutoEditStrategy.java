package org.xtext.ui;

//import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

public class QuotesAutoEditStrategy extends org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider {
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		
		// Removes the auto-completion of single- and double quotation marks
		//configureStringLiteral(acceptor);
		//configureParenthesis(acceptor);
		//configureSquareBrackets(acceptor);
		//configureCurlyBracesBlock(acceptor);
		
		
		// Multi-line comments gets to stay, only changed from /* to /', etc
		configureMultilineComments(acceptor);
		
		// Removes the auto-completion of Brackets, Curly Brackets and Block Brackets
		//configureCompoundBracesBlocks(acceptor);
	}
	 
	 //Edits the multi-line comments to "get with the program". /* -> /'
	 @Override
	 protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
			acceptor.accept(singleLineTerminals.newInstance("/\'", " \'/"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.newInstance("/\'"," \' ", " \'/"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.newInstance("/\'"," \' ", " \'/"),TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
	}
}
