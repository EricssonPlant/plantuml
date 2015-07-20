package org.xtext.ui;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.impl.TerminalRuleImpl;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.*;
import org.xtext.plantuml.Arrow;

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
		//	System.out.println("-------------------------------------");
		//	System.out.println(node.getText());
			
			// Checks if the node is a RuleCall
			if(node.getGrammarElement() instanceof RuleCall){
				RuleCall rc = (RuleCall) node.getGrammarElement();
				AbstractRule r = rc.getRule();
				//System.out.println(r.getName());
				
				// For example if the called rule is of the type START or END the specific
				// node will be coloured according the style STND.
				if(r.getName().equals("START") || r.getName().equals("END")){
					acceptor.addPosition(node.getOffset(), node.getLength(), STND);
				}
				
				else if(r.getName().equals("Definition")){
					node = it.next();			
					acceptor.addPosition(node.getOffset(), node.getLength(), DEFINITION);
				}
				
				else if(r.getName().equals("AutoNumber")){
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the autonumber while still keeping highlighting
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
						
					}
					acceptor.addPosition(node.getOffset(), node.getLength(), AUTONUMBER);
				}
				
				else if(r.getName().equals("Title")){
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the title while still keeping highlighting
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

					}
					
					if(node.getText().equalsIgnoreCase("legend")){
						acceptor.addPosition(node.getOffset(), node.getLength(), LEGEND);
						//This loop traverses the legend section to find endlegend and an aligmnent if there is one
						while(legendLength>=legendPartLength){
							node = it.next();
							//This if-statement skips tokens so that the counting towards the legendLength will be correct
							if(node.getText().equalsIgnoreCase("\r\n") || node.getText().equalsIgnoreCase("\n")){
								node = it.next();
								node = it.next();
							}
							legendPartLength += node.getLength();
							//If there has been one alignment already, there shouldn't be highlighting for another occurence of aligmnent.
							//When the alignment is typed on a different row than 'legend' it shouldn't be highlighted.
							if((node.getText().equalsIgnoreCase("left") || node.getText().equalsIgnoreCase("right")
							 || node.getText().equalsIgnoreCase("center")) && searchForAlignment && !newlineBeforeAlignment){
								acceptor.addPosition(node.getOffset(), node.getLength(), LEGEND);
								searchForAlignment = false;
							}
							else if(node.getText().equalsIgnoreCase("endlegend") || node.getText().equalsIgnoreCase("end legend")){
								acceptor.addPosition(node.getOffset(), node.getLength(), LEGEND);
								break;
							}	
							
						}
					}
				}
				
				else if(r.getName().equals("Newpage")){
					
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of newpage while still keeping highlighting
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
						//This if-construct allows for spaces and tabs to be used in front of grouping messages while still keeping highlighting

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
				
				else if(r.getName().equalsIgnoreCase("Note")){
					int noteLength = node.getLength();
					int notePartLength = 0;
					int textToBeHighlightedLength = 0;
					int startOffset = node.getOffset();
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the note while still keeping highlighting
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
					}
					notePartLength += node.getLength();
					textToBeHighlightedLength += node.getLength();
					
					//This loop goes through the first three note tokens to reach the newline character or to reach a ':'
					for(int i=0; i<3; i++){
						node = it.next();
						notePartLength += node.getLength();
						textToBeHighlightedLength += node.getLength();
					}
					if(node.getText().equals(":")){
						acceptor.addPosition(startOffset, textToBeHighlightedLength, NOTE);
					}
					//This else-statement handles the case where there is a multiline note
					else{
						acceptor.addPosition(startOffset, textToBeHighlightedLength, NOTE);
						textToBeHighlightedLength = 0;

						//A multiline note can only end with 'end note' or 'endnote' after a newline which is why '\n' or '\r\n' 
						// is required before checking for the end of a note.
						// For the while-loop to calculate the size of the tokens correctly it needs to skip certain nodes and 
						// that is handled by the if-statement.
						while(noteLength >= notePartLength){
							if(node.getText().contains("\r\n") || node.getText().contains("\n")){
								node = it.next();
								if(node.getText().equalsIgnoreCase("end note") || node.getText().equalsIgnoreCase("endnote")){
									acceptor.addPosition(node.getOffset(), node.getLength(), NOTE);
									break;
								}
								node = it.next();

								if(node.getText().equalsIgnoreCase("end note") || node.getText().equalsIgnoreCase("endnote")){
									acceptor.addPosition(node.getOffset(), node.getLength(), NOTE);
									break;
								}
							}
							node = it.next();
							notePartLength += node.getLength();
						}
					}
				}
				
				else if(r.getName().equals("Divider")){
					int dividerLength = node.getLength();
					int dividerPartLength = 0;
					node = it.next();
					dividerPartLength += node.getLength();
					acceptor.addPosition(node.getOffset(), node.getLength(), DIVIDER);
					node = it.next();
					while(!node.getText().equals("==")){
						node = it.next();
						dividerPartLength += node.getLength();
						
					}
					acceptor.addPosition(node.getOffset(), node.getLength(), DIVIDER);
				}
				
				else if(r.getName().equals("Reference")){
					int referenceLength = node.getLength();
					int referencePartLength = 0;
					boolean multilineReference = true;
					node = it.next();
					//This if-construct allows for spaces and tabs to be used in front of the reference while still keeping highlighting
					if(node.getText().equals(" ") || node.getText().equals("\t")
					 || node.getText().contains("  ") || node.getText().contains("\t\t")){
							node = it.next();
					}
					referencePartLength += node.getLength();
					acceptor.addPosition(node.getOffset(), referencePartLength, REFERENCE);
					node = it.next();
					//This while-loop will check the first line of the reference to determine whether it is a singeline or multiline reference
					while(!node.getText().equals("\n") && !node.getText().equals("\r\n")){
						node = it.next();
						referenceLength += referencePartLength;
						if(node.getText().equals(":")){
							multilineReference = false;
						}
						else if(node.getText().equals(",")){
							node = it.next();
						}
					}
					//This if-statement will make sure that the rest of the reference if it's multiline reference
					if(multilineReference){
						while(referenceLength > referencePartLength){
							//This if-construct skips certain parent nodes to not skew the counting towards the total length of the reference
							if(node.getText().equals("\n") || node.getText().equals("\r\n")){
								node = it.next();
							}
							if(node.getText().equals(" ") || node.getText().equals("\t")
							 || node.getText().contains("  ") || node.getText().contains("\t\t")){
								node = it.next();
							}
							if(node.getText().equalsIgnoreCase("endref")){
								acceptor.addPosition(node.getOffset(), node.getLength(), REFERENCE);
								break;
							}
							else if(node.getText().equalsIgnoreCase("end ref")){
								acceptor.addPosition(node.getOffset()-1, node.getLength()+1, REFERENCE);
								break;
							}
							
							referencePartLength += node.getLength();
							node = it.next();
						}
					}
				}
				else if(r.getName().equals("Delay")){
					int delayLength = node.getLength();
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();	
					}
					int delayPartLength = node.getLength();
					if(node.getText().equals("...")){
						acceptor.addPosition(node.getOffset(), node.getLength(), DELAY);
					}
					node = it.next();
					node = it.next();
;					while(delayLength > delayPartLength){
						node = it.next();
						delayPartLength += node.getLength();
						if(node.getText().equals("...")){
							acceptor.addPosition(node.getOffset(), node.getLength(), DELAY);
						}
					}
				}
				
				else if(r.getName().equals("Space")){
					int spaceLength = node.getLength();
					int spacePartLength = 0;
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();	
					}
					spacePartLength += node.getLength();
					if(node.getText().equals("|||")){
						acceptor.addPosition(node.getOffset(), spacePartLength, SPACE);
					}
					else if(node.getText().equals("||")){
						acceptor.addPosition(node.getOffset(), spacePartLength, SPACE);
						while(spaceLength > spacePartLength){
							node = it.next();
							if(node.getText().equals("||")){
								acceptor.addPosition(node.getOffset(), spacePartLength, SPACE);
								break;
							}
						}
					}
				}
				
				else if(r.getName().equals("Hidefootbox")){
					node = it.next();
					if(node.getText().contains("  ") || node.getText().contains("\t\t") 
					 || node.getText().equals(" ") || node.getText().equals("\t")){
						node = it.next();
					}
					if(node.getText().equalsIgnoreCase("hidefootbox")){
						acceptor.addPosition(node.getOffset(), node.getLength(), HIDEFOOTBOX);
					}
					else if(node.getText().equalsIgnoreCase("hide footbox")){
						acceptor.addPosition(node.getOffset(), node.getLength(), HIDEFOOTBOX);
					}
					/*
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
						System.out.println(node.getText());
					}
					if(node.getText().equalsIgnoreCase("hide")){
						acceptor.addPosition(node.getOffset(), node.getLength(), HIDEFOOTBOX);
						while(node.getText().equals("\n") || node.getText().equals("\r\n")){	
							node = it.next();
							System.out.println(node.getText());
							if(node.getText().equalsIgnoreCase("box")){
								acceptor.addPosition(node.getOffset(), node.getLength(), HIDEFOOTBOX);
							}
						}
					}
					*/
				}
				
				else if(r.getName().equals("Deactivate")){
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();	
					}
					if(node.getText().equalsIgnoreCase("deactivate")){
						acceptor.addPosition(node.getOffset(), node.getLength(), DEACTIVATE);
					}
				}
				else if(r.getName().equals("Activate")){
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();
					}
					if(node.getText().equalsIgnoreCase("activate")){
						acceptor.addPosition(node.getOffset(), node.getLength(), ACTIVATE);
					}
				}
				
				else if(r.getName().equals("ParticipantCreation")){
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();	
					}
					if(node.getText().equalsIgnoreCase("create")){
						acceptor.addPosition(node.getOffset(), node.getLength(), PARTICIPANTCREATION);
					}
				}
				
				else if(r.getName().equals("Box")){
					//This value will make sure that the iterator will traverse the tree in reverse to reach the subsequent node of 'Box'.
					//This is done to provide highlighting for the text within the box section.
					int numberOfRequiredReverseSteps = 0;
					node = it.next();
					if(node.getText().contains(" ") || node.getText().contains("\t")){
						node = it.next();	
					}
					if(node.getText().equalsIgnoreCase("box")){
						acceptor.addPosition(node.getOffset(), node.getLength(), BOX);
					}
					while(it.hasNext()){
						node = it.next();
						numberOfRequiredReverseSteps++;
						if(node.getText().equalsIgnoreCase("end box")){
							acceptor.addPosition(node.getOffset(), node.getLength(), BOX);
							break;
						}
					}
					while(numberOfRequiredReverseSteps > 0){
						numberOfRequiredReverseSteps--;
						node = it.previous();
					}
				}
				
				else if(r.getName().equals("IncArrow")){
					acceptor.addPosition(node.getOffset(), node.getLength(), INCOUT);
				}
				
				else if(r.getName().equals("OutArrow")){
					acceptor.addPosition(node.getOffset(), node.getLength(), INCOUT);
				}
				
				else if(r.getName().equals("SkinparamCommand")){
					acceptor.addPosition(node.getOffset(), node.getLength(), SKINPARAM);
				}
			}
			
			else if( node instanceof CompositeNodeWithSemanticElement && node.getSemanticElement() instanceof Arrow)
			{
				acceptor.addPosition(node.getOffset(), node.getLength(), SEQ_ARR);
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

