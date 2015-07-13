package org.xtext.ui;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.impl.TerminalRuleImpl;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.*;

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
			System.out.println(node.getText());
			
			// Checks if the node is a RuleCall
			if(node.getGrammarElement() instanceof RuleCall){
				RuleCall rc = (RuleCall) node.getGrammarElement();
				AbstractRule r = rc.getRule();
				System.out.println(r.getName());
				
				// For example if the called rule is of the type START or END the specific
				// node will be coloured according the style STND.
				if(r.getName().equals("START") || r.getName().equals("END")){
					acceptor.addPosition(node.getOffset(), node.getLength(), STND);
				}
				else if(r.getName().equals("Arrow")){
					acceptor.addPosition(node.getOffset(), node.getLength(), SEQ_ARR);
				}
				else if(r.getName().equals("Definition")){
					node = it.next();			
					acceptor.addPosition(node.getOffset(), node.getLength(), DEFINITION);
				}
				
				else if(r.getName().equals("AutoNumber")){
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the definition while still keeping highlighting
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
						
					}
					acceptor.addPosition(node.getOffset(), node.getLength(), AUTONUMBER);
				}
				
				else if(r.getName().equals("Title")){
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the definition while still keeping highlighting
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
						
					}
					acceptor.addPosition(node.getOffset(), node.getLength(), TITLE);
					
				}
				
				else if(r.getName().equals("Legend")){
					int legendLength = node.getLength();
					int legendPartLength = 0;
					boolean searchForAlignment = true;
					boolean newlineBeforeAlignment = false;
					node = it.next();
					
					//This if-construct allows for spaces and tabs to be used in front of legend while still keeping highlighting
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
						System.out.println(node.getText());
					}
					
					if(node.getText().equalsIgnoreCase("legend")){
						acceptor.addPosition(node.getOffset(), node.getLength(), LEGEND);
						//This loop traverses the legend section to find endlegend and a aligmnent if there is one
						while(legendLength>legendPartLength){
							node = it.next();
							if(node.getText().contains("\n"))
								newlineBeforeAlignment = true;
							legendPartLength += node.getLength();
							//If there has been one alignment already, there shouldn't be highlighting for another occurence of aligmnent.
							//When the alignment is typed on a different row than 'legend' it shouldn't be highlighted.
							if((node.getText().equalsIgnoreCase("left") || node.getText().equalsIgnoreCase("right")
							 || node.getText().equalsIgnoreCase("center")) && searchForAlignment && !newlineBeforeAlignment){
								acceptor.addPosition(node.getOffset(), node.getLength(), LEGEND);
								searchForAlignment = false;
							}
							else if(node.getText().equalsIgnoreCase("endlegend"))
								acceptor.addPosition(node.getOffset(), node.getLength(), LEGEND);
						}
					}
				}
				
				else if(r.getName().equals("Newpage")){
					
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the definition while still keeping highlighting
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
						
					}
					acceptor.addPosition(node.getOffset(), node.getLength(), NEWPAGE);
				}
				
				else if(r.getName().equals("GroupingMessages")){
					int amountOfEmbeddedGroupingMessages = 0;
					if(node.getText().contains("end")){
						node = it.next();
						acceptor.addPosition(node.getOffset(), node.getLength(), GROUPINGMESSAGES);
						//This if-construct allows for spaces and tabs to be used in front of the definition while still keeping highlighting
						if(node.getText().contains(" ") || node.getText().contains("\t")){
							node = it.next();
						}
						while(true){
							node = it.next();
							if(node.getText().equalsIgnoreCase("else")){
								acceptor.addPosition(node.getOffset(), node.getLength(), GROUPINGMESSAGES);
							}
							else if(node.getText().equalsIgnoreCase("end")){
								acceptor.addPosition(node.getOffset(), node.getLength(), GROUPINGMESSAGES);
								if(amountOfEmbeddedGroupingMessages == 0)
									break;
								amountOfEmbeddedGroupingMessages--;
							}
							else if(node.getText().equalsIgnoreCase("opt")
							 || node.getText().equalsIgnoreCase("loop")
							 || node.getText().equalsIgnoreCase("par")
							 || node.getText().equalsIgnoreCase("break")
							 || node.getText().equalsIgnoreCase("critical")
							 || node.getText().equalsIgnoreCase("group")
							 || node.getText().equalsIgnoreCase("alt")){
								acceptor.addPosition(node.getOffset(), node.getLength(), GROUPINGMESSAGES);
								amountOfEmbeddedGroupingMessages++;
							}
						}
					}
				}
				
				else if(r.getName().equals("Note")){
					int textToBeHighlightedLength = 0;
					int startOffset = node.getOffset();
					int newOffset = 0;
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
					}
					textToBeHighlightedLength += node.getLength();
					node = it.next();
					textToBeHighlightedLength += node.getLength();
					node = it.next();
					textToBeHighlightedLength += node.getLength();
					node = it.next();
					if(node.getText().equals(":")){
						acceptor.addPosition(startOffset, textToBeHighlightedLength+1, NOTE);
					}
					else{
						acceptor.addPosition(startOffset, textToBeHighlightedLength, NOTE);
						textToBeHighlightedLength = 0;
						node = it.next();
						while(!node.getText().equalsIgnoreCase("endnote")){
							if(node.getText().equalsIgnoreCase("\r\n") || node.getText().equalsIgnoreCase("\n")){
								System.out.println("11111111111111111111111");
								node = it.next();
								node = it.next();
								node = it.next();
								System.out.print("|"+node.getText()+"|");
								if(node.getText().equalsIgnoreCase("end")){
									System.out.println("22222222222222222222");
									node = it.next();
									node = it.next();
									System.out.print(node.getText());
									if(node.getText().equalsIgnoreCase(" note")){
										textToBeHighlightedLength = 10;
										break;
									}
								}
							}
							System.out.print("["+node.getText()+"]");
							node = it.next();
							newOffset = node.getOffset();
						}
						acceptor.addPosition(newOffset, textToBeHighlightedLength, NOTE);
					}
				}
				
				else if(r.getName().equals("Reference")){
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
					}
					acceptor.addPosition(node.getOffset(), 9, REFERENCE);
				}
				
			}
			
			// If a node is considered a comment the node will be coloured according to the style COMMENT
			else if(node instanceof HiddenLeafNode && node.getGrammarElement() instanceof TerminalRuleImpl)
			{
				TerminalRuleImpl ge = (TerminalRuleImpl) node.getGrammarElement();
				
				if( ge.getName().equalsIgnoreCase( "SL_COMMENT"))
					acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
				
				else if(ge.getName().equalsIgnoreCase("ML_COMMENT")){
					acceptor.addPosition( node.getOffset(), node.getLength(), COMMENT);
				}
			}
			
		}
	}
}

