package org.xtext.ui;

import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.impl.TerminalRuleImpl;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.*;
import org.xtext.plantuml.*;
import org.xtext.services.PlantumlGrammarAccess.*;

import static org.xtext.ui.PlantumlHighlightingConfiguration.*;

public class PlantumlHighlightingCalculator implements ISemanticHighlightingCalculator {
	public void provideHighlightingFor( XtextResource resource,
		IHighlightedPositionAcceptor acceptor) {
		if(resource == null || resource.getParseResult() == null) return;
		
		INode root = resource.getParseResult().getRootNode();
		BidiTreeIterator<INode> it = root.getAsTreeIterable().iterator();
		while( it.hasNext())
		{
			INode node = it.next();
			
			System.out.println();
			
			if(node.getGrammarElement() instanceof TerminalRule){
				TerminalRuleImpl ge1 = (TerminalRuleImpl) node.getGrammarElement();
				System.out.println(ge1.getName());
				if (ge1.getName().equals("SEQUENCE")){
					System.out.println("SANT");
					setStyles( acceptor, it, SEQ_ARR);
				}
				
			}
			
			
			if (node.getSemanticElement() instanceof Diagram && node instanceof CompositeNode){
				System.out.println("1");
				setStyles( acceptor, it, DIAGRAM);
				setStyles( acceptor, node.getAsTreeIterable().reverse().iterator(), null, DIAGRAM);
			}
			
			else if (node.getSemanticElement() instanceof Definition && node instanceof CompositeNode){
				System.out.println("2");
				setStyles( acceptor, it, DEFINITION);
				
			}
			/*
			else if(node.getSemanticElement() instanceof Sequence && node instanceof CompositeNode){
				System.out.println("3");
				setStyles( acceptor, it, SEQUENCE);
				
			}*/
			else if(node instanceof HiddenLeafNode && node.getGrammarElement() instanceof TerminalRuleImpl)
			{
				System.out.println("4");
				TerminalRuleImpl ge = (TerminalRuleImpl) node.getGrammarElement();
				if( ge.getName().equalsIgnoreCase( "SL_COMMENT"))
					acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
				else if(ge.getName().equalsIgnoreCase("ML_COMMENT")){
					acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
				}
			}
			
		}
	}

	void setStyles( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it, String...styles )
	{
		for( String s : styles )
		{
			if( ! it.hasNext() ) return;
				INode n = skipWhiteSpace( acceptor, it );
				if( n != null && s != null ) 
					acceptor.addPosition( n.getOffset(), n.getLength(), s );
		}
	}
	
	INode skipWhiteSpace( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it )
	{
		INode n = null;
		while ( it.hasNext() && ( n = it.next() ).getClass() == HiddenLeafNode.class )
			processHiddenNode( acceptor, (HiddenLeafNode)n );
		return n;
	}
	 
	INode skipWhiteSpaceBackwards( IHighlightedPositionAcceptor acceptor, BidiIterator<INode> it )
	{
		INode n = null;
		while ( it.hasPrevious() && ( n = it.previous() ).getClass() == HiddenLeafNode.class )
			processHiddenNode( acceptor, (HiddenLeafNode)n );
		return n;
	}
	 
	 
	void processHiddenNode( IHighlightedPositionAcceptor acceptor, HiddenLeafNode node )
	{
		if( node.getGrammarElement() instanceof TerminalRuleImpl )
		{
			TerminalRuleImpl ge = (TerminalRuleImpl) node.getGrammarElement();
			if( ge.getName().equalsIgnoreCase( "SL_COMMENT" ) ) 
				acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT );
			else if(ge.getName().equalsIgnoreCase("ML_COMMENT")){
				acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
			}
		}
	 
	}
	
}
