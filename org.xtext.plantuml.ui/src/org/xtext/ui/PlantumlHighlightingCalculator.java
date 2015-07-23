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
			System.out.println("-------------------------------------");
			System.out.println("-------------------------------------");
			node.getClass();
			System.out.println(node.getText());
			System.out.println(node.getSemanticElement());
			System.out.println(node.getClass());
			System.out.println("-------------------------------------");
			
			
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
			else{
				try {
					if(node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement().getClass().getMethod("getStartKeyWord") != null){
						String  startKeyWord = (String) node.getSemanticElement().getClass().getMethod("getStartKeyWord").invoke(node.getSemanticElement());
						System.out.println("|******************|");
						System.out.println(node.getText());
						System.out.println("|__________________|");
						if(it.hasNext())
							node = it.next();
						while(node.hasNextSibling()){
								node = node.getNextSibling();
								System.out.println("<------Sibling------->");
								System.out.println(node.getText());
								System.out.println("<------Sibling------->");
								if(node.getText().equalsIgnoreCase("legend")){
									acceptor.addPosition( node.getOffset(), node.getLength(), LEGEND);
								}
						}
					}
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}
	}
}

