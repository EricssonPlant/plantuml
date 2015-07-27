package org.xtext.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.impl.TerminalRuleImpl;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.*;
import org.xtext.plantuml.Arrow;
import org.xtext.plantuml.Legend;

import static org.xtext.ui.PlantumlHighlightingConfiguration.*;

public class PlantumlHighlightingCalculator implements ISemanticHighlightingCalculator {
	public void provideHighlightingFor( XtextResource resource,
		IHighlightedPositionAcceptor acceptor) {
		
		if(resource == null || resource.getParseResult() == null) return;
		INode root = resource.getParseResult().getRootNode();
		BidiTreeIterator<INode> it = root.getAsTreeIterable().iterator();
		
		// This loop will check the type of grammar for each node
		// and apply a specific colour to that node.
		while( it.hasNext())
		{
			INode node = it.next();
			node.getClass();
			
			// If a node is considered a comment the node will be coloured according to the style COMMENT
			if(node instanceof HiddenLeafNode && node.getGrammarElement() instanceof TerminalRuleImpl)
			{
				TerminalRuleImpl ge = (TerminalRuleImpl) node.getGrammarElement();
				if( ge.getName().equalsIgnoreCase( "SL_COMMENT"))
					acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
				
				else if(ge.getName().equalsIgnoreCase("ML_COMMENT")){
					acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
				}
			}
			else if( node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Arrow)
			{
				acceptor.addPosition(node.getOffset(), node.getLength(), SEQ_ARR);
			}
			else{
				try {
					if(node instanceof LeafNode && node.getSemanticElement().getClass().getMethod("getStartKeyword") != null){
						String startKeyword = (String) node.getSemanticElement().getClass().getMethod("getStartKeyword").invoke(node.getSemanticElement());
						if(node.getText().equalsIgnoreCase(startKeyword)){
							acceptor.addPosition( node.getOffset(), node.getLength(), startKeyword.toLowerCase());
						}
						else if(node instanceof LeafNode && node.getSemanticElement().getClass().getMethod("getEndKeyword") != null){
							String endKeyword = (String) node.getSemanticElement().getClass().getMethod("getEndKeyword").invoke(node.getSemanticElement());
							if(node.getText().equalsIgnoreCase(endKeyword)){
								acceptor.addPosition( node.getOffset(), node.getLength(), endKeyword.toLowerCase());
							}
						}
					}
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				if(node.getGrammarElement() instanceof RuleCall){
					RuleCall rc = (RuleCall) node.getGrammarElement();
					AbstractRule r = rc.getRule();
					if(r.getName().equals("IncArrow")){
						acceptor.addPosition(node.getOffset(), node.getLength(), INCOUT);
					}
					
					else if(r.getName().equals("OutArrow")){
						acceptor.addPosition(node.getOffset(), node.getLength(), INCOUT);
					}
					else if(r.getName().equals("dotdotdot")){
						acceptor.addPosition(node.getOffset(), node.getLength(), DELAY);
					}
				}
			}
		}
	}
}

