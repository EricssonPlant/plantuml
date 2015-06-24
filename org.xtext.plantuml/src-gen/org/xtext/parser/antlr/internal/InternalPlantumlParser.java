package org.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.services.PlantumlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlantumlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Participant", "Autonumber", "Deactivate", "Endlegend", "Activate", "Boundary", "Critical", "Database", "Control", "Destroy", "Footbox", "Newpage", "Center", "Create", "Entity", "Legend", "Actor", "Break", "Group", "Right", "Title", "Else", "Hide", "Left", "Loop", "Note", "Over", "FullStopFullStopFullStop", "Alt", "Box", "End", "Opt", "Par", "Ref", "VerticalLineVerticalLineVerticalLine", "LessThanSignLessThanSign", "EqualsSignEqualsSign", "GreaterThanSignGreaterThanSign", "Of", "VerticalLineVerticalLine", "QuotationMark", "LeftParenthesis", "RightParenthesis", "Comma", "Colon", "RULE_NEWLINE", "RULE_START", "RULE_END", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_SEQUENCE", "RULE_COLOR", "RULE_HEXCODE", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Par=36;
    public static final int Entity=18;
    public static final int Left=27;
    public static final int RULE_SEQUENCE=56;
    public static final int Break=21;
    public static final int Alt=32;
    public static final int Critical=10;
    public static final int FullStopFullStopFullStop=31;
    public static final int Boundary=9;
    public static final int Opt=35;
    public static final int LeftParenthesis=45;
    public static final int Actor=20;
    public static final int VerticalLineVerticalLineVerticalLine=38;
    public static final int Database=11;
    public static final int RULE_ID=53;
    public static final int Endlegend=7;
    public static final int RightParenthesis=46;
    public static final int Box=33;
    public static final int EqualsSignEqualsSign=40;
    public static final int Participant=4;
    public static final int Activate=8;
    public static final int RULE_INT=52;
    public static final int Note=29;
    public static final int RULE_ML_COMMENT=54;
    public static final int RULE_HEXCODE=58;
    public static final int End=34;
    public static final int LessThanSignLessThanSign=39;
    public static final int Hide=26;
    public static final int Group=22;
    public static final int Legend=19;
    public static final int RULE_END=51;
    public static final int RULE_START=50;
    public static final int VerticalLineVerticalLine=43;
    public static final int RULE_NEWLINE=49;
    public static final int Right=23;
    public static final int Footbox=14;
    public static final int QuotationMark=44;
    public static final int Newpage=15;
    public static final int RULE_SL_COMMENT=55;
    public static final int Over=30;
    public static final int Comma=47;
    public static final int Control=12;
    public static final int Destroy=13;
    public static final int Create=17;
    public static final int RULE_COLOR=57;
    public static final int Deactivate=6;
    public static final int Colon=48;
    public static final int EOF=-1;
    public static final int Loop=28;
    public static final int Center=16;
    public static final int RULE_WS=59;
    public static final int Title=24;
    public static final int RULE_ANY_OTHER=60;
    public static final int GreaterThanSignGreaterThanSign=41;
    public static final int Ref=37;
    public static final int Of=42;
    public static final int Else=25;
    public static final int Autonumber=5;

    // delegates
    // delegators


        public InternalPlantumlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPlantumlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPlantumlParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g"; }




    	private PlantumlGrammarAccess grammarAccess;
    	 	
    	public InternalPlantumlParser(TokenStream input, PlantumlGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Plantuml";	
    	} 
    	   	   	
    	@Override
    	protected PlantumlGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRulePlantuml"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:61:1: entryRulePlantuml returns [EObject current=null] : iv_rulePlantuml= rulePlantuml EOF ;
    public final EObject entryRulePlantuml() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlantuml = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:62:2: (iv_rulePlantuml= rulePlantuml EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:63:2: iv_rulePlantuml= rulePlantuml EOF
            {
             newCompositeNode(grammarAccess.getPlantumlRule()); 
            pushFollow(FOLLOW_rulePlantuml_in_entryRulePlantuml67);
            iv_rulePlantuml=rulePlantuml();

            state._fsp--;

             current =iv_rulePlantuml; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlantuml77); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlantuml"


    // $ANTLR start "rulePlantuml"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:70:1: rulePlantuml returns [EObject current=null] : ( (lv_diagrams_0_0= ruleDiagram ) )* ;
    public final EObject rulePlantuml() throws RecognitionException {
        EObject current = null;

        EObject lv_diagrams_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:73:28: ( ( (lv_diagrams_0_0= ruleDiagram ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:74:1: ( (lv_diagrams_0_0= ruleDiagram ) )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:74:1: ( (lv_diagrams_0_0= ruleDiagram ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_START) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:75:1: (lv_diagrams_0_0= ruleDiagram )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:75:1: (lv_diagrams_0_0= ruleDiagram )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:76:3: lv_diagrams_0_0= ruleDiagram
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDiagram_in_rulePlantuml122);
            	    lv_diagrams_0_0=ruleDiagram();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPlantumlRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"diagrams",
            	            		lv_diagrams_0_0, 
            	            		"Diagram");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlantuml"


    // $ANTLR start "entryRuleDiagram"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:100:1: entryRuleDiagram returns [EObject current=null] : iv_ruleDiagram= ruleDiagram EOF ;
    public final EObject entryRuleDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiagram = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:101:2: (iv_ruleDiagram= ruleDiagram EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:102:2: iv_ruleDiagram= ruleDiagram EOF
            {
             newCompositeNode(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_ruleDiagram_in_entryRuleDiagram157);
            iv_ruleDiagram=ruleDiagram();

            state._fsp--;

             current =iv_ruleDiagram; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDiagram167); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDiagram"


    // $ANTLR start "ruleDiagram"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:109:1: ruleDiagram returns [EObject current=null] : ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token this_START_1=null;
        Token this_NEWLINE_2=null;
        Token this_END_4=null;
        Token this_NEWLINE_5=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:112:28: ( ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: ( () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:2: () this_START_1= RULE_START this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* this_END_4= RULE_END (this_NEWLINE_5= RULE_NEWLINE )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:2: ()
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:114:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDiagramAccess().getDiagramAction_0(),
                        current);
                

            }

            this_START_1=(Token)match(input,RULE_START,FOLLOW_RULE_START_in_ruleDiagram212); 
             
                newLeafNode(this_START_1, grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_1()); 
                
            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram222); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:127:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=Participant && LA2_0<=Deactivate)||(LA2_0>=Activate && LA2_0<=Destroy)||LA2_0==Newpage||(LA2_0>=Create && LA2_0<=Group)||LA2_0==Title||LA2_0==Hide||(LA2_0>=Loop && LA2_0<=Note)||(LA2_0>=FullStopFullStopFullStop && LA2_0<=Box)||(LA2_0>=Opt && LA2_0<=VerticalLineVerticalLineVerticalLine)||LA2_0==EqualsSignEqualsSign||LA2_0==VerticalLineVerticalLine||LA2_0==RULE_NEWLINE||LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:128:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:128:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:129:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram242);
            	    lv_instructions_3_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDiagramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_3_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            this_END_4=(Token)match(input,RULE_END,FOLLOW_RULE_END_in_ruleDiagram254); 
             
                newLeafNode(this_END_4, grammarAccess.getDiagramAccess().getENDTerminalRuleCall_4()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:149:1: (this_NEWLINE_5= RULE_NEWLINE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:149:2: this_NEWLINE_5= RULE_NEWLINE
            	    {
            	    this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram265); 
            	     
            	        newLeafNode(this_NEWLINE_5, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_5()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDiagram"


    // $ANTLR start "entryRuleInstruction"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:161:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:162:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:163:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction301);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction311); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:170:1: ruleInstruction returns [EObject current=null] : ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token this_COLOR_2=null;
        Token this_HEXCODE_3=null;
        Token this_NEWLINE_20=null;
        EObject this_Arrow_0 = null;

        EObject this_Definition_1 = null;

        EObject this_AltElse_8 = null;

        EObject this_GroupingMessages_9 = null;

        EObject this_Note_10 = null;

        EObject this_Reference_12 = null;

        EObject this_Activate_16 = null;

        EObject this_Deactivate_17 = null;

        EObject this_Box_19 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:173:28: ( ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:174:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )?
            int alt5=19;
            switch ( input.LA(1) ) {
                case RULE_ID:
                    {
                    alt5=1;
                    }
                    break;
                case Participant:
                case Boundary:
                case Database:
                case Control:
                case Entity:
                case Actor:
                    {
                    alt5=2;
                    }
                    break;
                case Autonumber:
                    {
                    alt5=3;
                    }
                    break;
                case Title:
                    {
                    alt5=4;
                    }
                    break;
                case Legend:
                    {
                    alt5=5;
                    }
                    break;
                case Newpage:
                    {
                    alt5=6;
                    }
                    break;
                case Alt:
                    {
                    alt5=7;
                    }
                    break;
                case Critical:
                case Break:
                case Group:
                case Loop:
                case Opt:
                case Par:
                    {
                    alt5=8;
                    }
                    break;
                case Note:
                    {
                    alt5=9;
                    }
                    break;
                case EqualsSignEqualsSign:
                    {
                    alt5=10;
                    }
                    break;
                case Ref:
                    {
                    alt5=11;
                    }
                    break;
                case FullStopFullStopFullStop:
                    {
                    alt5=12;
                    }
                    break;
                case VerticalLineVerticalLineVerticalLine:
                case VerticalLineVerticalLine:
                    {
                    alt5=13;
                    }
                    break;
                case Hide:
                    {
                    alt5=14;
                    }
                    break;
                case Activate:
                    {
                    alt5=15;
                    }
                    break;
                case Deactivate:
                case Destroy:
                    {
                    alt5=16;
                    }
                    break;
                case Create:
                    {
                    alt5=17;
                    }
                    break;
                case Box:
                    {
                    alt5=18;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:175:5: this_Arrow_0= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleInstruction359);
                    this_Arrow_0=ruleArrow();

                    state._fsp--;


                            current = this_Arrow_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:184:6: (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:184:6: (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:185:5: this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction387);
                    this_Definition_1=ruleDefinition();

                    state._fsp--;


                            current = this_Definition_1;
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:193:1: (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )?
                    int alt4=3;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_COLOR) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_HEXCODE) ) {
                        alt4=2;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:193:2: this_COLOR_2= RULE_COLOR
                            {
                            this_COLOR_2=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleInstruction398); 
                             
                                newLeafNode(this_COLOR_2, grammarAccess.getInstructionAccess().getCOLORTerminalRuleCall_0_1_1_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:198:6: this_HEXCODE_3= RULE_HEXCODE
                            {
                            this_HEXCODE_3=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleInstruction414); 
                             
                                newLeafNode(this_HEXCODE_3, grammarAccess.getInstructionAccess().getHEXCODETerminalRuleCall_0_1_1_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:204:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction438);
                    ruleAutoNumber();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:213:5: ruleTitle
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleTitle_in_ruleInstruction459);
                    ruleTitle();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:222:5: ruleLegend
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleLegend_in_ruleInstruction480);
                    ruleLegend();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:231:5: ruleNewpage
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleNewpage_in_ruleInstruction501);
                    ruleNewpage();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:240:5: this_AltElse_8= ruleAltElse
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleAltElse_in_ruleInstruction528);
                    this_AltElse_8=ruleAltElse();

                    state._fsp--;


                            current = this_AltElse_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:250:5: this_GroupingMessages_9= ruleGroupingMessages
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_ruleGroupingMessages_in_ruleInstruction555);
                    this_GroupingMessages_9=ruleGroupingMessages();

                    state._fsp--;


                            current = this_GroupingMessages_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:260:5: this_Note_10= ruleNote
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_ruleNote_in_ruleInstruction582);
                    this_Note_10=ruleNote();

                    state._fsp--;


                            current = this_Note_10;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:270:5: ruleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_ruleDivider_in_ruleInstruction603);
                    ruleDivider();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:279:5: this_Reference_12= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleInstruction630);
                    this_Reference_12=ruleReference();

                    state._fsp--;


                            current = this_Reference_12;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:289:5: ruleDelay
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_ruleDelay_in_ruleInstruction651);
                    ruleDelay();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:298:5: ruleSpace
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_ruleSpace_in_ruleInstruction672);
                    ruleSpace();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:307:5: ruleHidefootbox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                        
                    pushFollow(FOLLOW_ruleHidefootbox_in_ruleInstruction693);
                    ruleHidefootbox();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:316:5: this_Activate_16= ruleActivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                        
                    pushFollow(FOLLOW_ruleActivate_in_ruleInstruction720);
                    this_Activate_16=ruleActivate();

                    state._fsp--;


                            current = this_Activate_16;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:326:5: this_Deactivate_17= ruleDeactivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                        
                    pushFollow(FOLLOW_ruleDeactivate_in_ruleInstruction747);
                    this_Deactivate_17=ruleDeactivate();

                    state._fsp--;


                            current = this_Deactivate_17;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:336:5: ruleParticipantCreation
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                        
                    pushFollow(FOLLOW_ruleParticipantCreation_in_ruleInstruction768);
                    ruleParticipantCreation();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:345:5: this_Box_19= ruleBox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                        
                    pushFollow(FOLLOW_ruleBox_in_ruleInstruction795);
                    this_Box_19=ruleBox();

                    state._fsp--;


                            current = this_Box_19;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_20=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleInstruction807); 
             
                newLeafNode(this_NEWLINE_20, grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleArrow"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:365:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:366:2: (iv_ruleArrow= ruleArrow EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:367:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow841);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow851); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:374:1: ruleArrow returns [EObject current=null] : ( ( (lv_ids_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? ) ;
    public final EObject ruleArrow() throws RecognitionException {
        EObject current = null;

        Token lv_ids_0_0=null;
        Token this_SEQUENCE_1=null;
        Token lv_ids_2_0=null;
        Token otherlv_3=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:377:28: ( ( ( (lv_ids_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:378:1: ( ( (lv_ids_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:378:1: ( ( (lv_ids_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:378:2: ( (lv_ids_0_0= RULE_ID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_ids_2_0= RULE_ID ) ) (otherlv_3= Colon (this_ID_4= RULE_ID )* )?
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:378:2: ( (lv_ids_0_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:379:1: (lv_ids_0_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:379:1: (lv_ids_0_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:380:3: lv_ids_0_0= RULE_ID
            {
            lv_ids_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrow893); 

            			newLeafNode(lv_ids_0_0, grammarAccess.getArrowAccess().getIdsIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArrowRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"ids",
                    		lv_ids_0_0, 
                    		"ID");
            	    

            }


            }

            this_SEQUENCE_1=(Token)match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_ruleArrow909); 
             
                newLeafNode(this_SEQUENCE_1, grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:400:1: ( (lv_ids_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:401:1: (lv_ids_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:401:1: (lv_ids_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:402:3: lv_ids_2_0= RULE_ID
            {
            lv_ids_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrow925); 

            			newLeafNode(lv_ids_2_0, grammarAccess.getArrowAccess().getIdsIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArrowRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"ids",
                    		lv_ids_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:418:2: (otherlv_3= Colon (this_ID_4= RULE_ID )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:419:2: otherlv_3= Colon (this_ID_4= RULE_ID )*
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleArrow944); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:423:1: (this_ID_4= RULE_ID )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:423:2: this_ID_4= RULE_ID
                    	    {
                    	    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArrow955); 
                    	     
                    	        newLeafNode(this_ID_4, grammarAccess.getArrowAccess().getIDTerminalRuleCall_3_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:435:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:436:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:437:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition993);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition1003); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:444:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token lv_name_7_0=null;
        Token otherlv_8=null;
        Token lv_name_9_0=null;
        Token otherlv_10=null;
        Token lv_name_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token this_ID_14=null;
        Token otherlv_15=null;
        Token this_COLOR_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token this_ID_19=null;
        Token otherlv_20=null;
        Token this_COLOR_21=null;
        Token otherlv_22=null;
        Token this_ID_23=null;
        Token this_ID_24=null;
        Token otherlv_25=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:447:28: ( ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:448:1: ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:448:1: ( (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt10=1;
                }
                break;
            case Boundary:
                {
                alt10=2;
                }
                break;
            case Control:
                {
                alt10=3;
                }
                break;
            case Entity:
                {
                alt10=4;
                }
                break;
            case Database:
                {
                alt10=5;
                }
                break;
            case Participant:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:448:2: (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:448:2: (otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:449:2: otherlv_0= Actor ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,Actor,FOLLOW_Actor_in_ruleDefinition1042); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:453:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:454:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:454:1: (lv_name_1_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:455:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1058); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:472:6: (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:472:6: (otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:473:2: otherlv_2= Boundary ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,Boundary,FOLLOW_Boundary_in_ruleDefinition1084); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:477:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:478:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:478:1: (lv_name_3_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:479:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1100); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:496:6: (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:496:6: (otherlv_4= Control ( (lv_name_5_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:497:2: otherlv_4= Control ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,Control,FOLLOW_Control_in_ruleDefinition1126); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:501:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:502:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:502:1: (lv_name_5_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:503:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1142); 

                    			newLeafNode(lv_name_5_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:520:6: (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:520:6: (otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:521:2: otherlv_6= Entity ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,Entity,FOLLOW_Entity_in_ruleDefinition1168); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:525:1: ( (lv_name_7_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:526:1: (lv_name_7_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:526:1: (lv_name_7_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:527:3: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1184); 

                    			newLeafNode(lv_name_7_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_7_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:544:6: (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:544:6: (otherlv_8= Database ( (lv_name_9_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:545:2: otherlv_8= Database ( (lv_name_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,Database,FOLLOW_Database_in_ruleDefinition1210); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:549:1: ( (lv_name_9_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:550:1: (lv_name_9_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:550:1: (lv_name_9_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:551:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1226); 

                    			newLeafNode(lv_name_9_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_9_0, 
                            		"ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:568:6: (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:568:6: (otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:569:2: otherlv_10= Participant ( (lv_name_11_0= RULE_ID ) ) (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )?
                    {
                    otherlv_10=(Token)match(input,Participant,FOLLOW_Participant_in_ruleDefinition1252); 

                        	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:573:1: ( (lv_name_11_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:574:1: (lv_name_11_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:574:1: (lv_name_11_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:575:3: lv_name_11_0= RULE_ID
                    {
                    lv_name_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1268); 

                    			newLeafNode(lv_name_11_0, grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_11_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:591:2: (otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LessThanSignLessThanSign) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:592:2: otherlv_12= LessThanSignLessThanSign ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID ) otherlv_25= GreaterThanSignGreaterThanSign
                            {
                            otherlv_12=(Token)match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1287); 

                                	newLeafNode(otherlv_12, grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:596:1: ( (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis ) | (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID ) | this_ID_24= RULE_ID )
                            int alt8=3;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==LeftParenthesis) ) {
                                int LA8_1 = input.LA(2);

                                if ( (LA8_1==RULE_ID) ) {
                                    int LA8_3 = input.LA(3);

                                    if ( (LA8_3==Comma) ) {
                                        int LA8_4 = input.LA(4);

                                        if ( (LA8_4==RULE_COLOR) ) {
                                            int LA8_5 = input.LA(5);

                                            if ( (LA8_5==RightParenthesis) ) {
                                                int LA8_6 = input.LA(6);

                                                if ( (LA8_6==GreaterThanSignGreaterThanSign) ) {
                                                    alt8=1;
                                                }
                                                else if ( (LA8_6==RULE_ID) ) {
                                                    alt8=2;
                                                }
                                                else {
                                                    NoViableAltException nvae =
                                                        new NoViableAltException("", 8, 6, input);

                                                    throw nvae;
                                                }
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 8, 5, input);

                                                throw nvae;
                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 8, 4, input);

                                            throw nvae;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 8, 3, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 8, 1, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA8_0==RULE_ID) ) {
                                alt8=3;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 8, 0, input);

                                throw nvae;
                            }
                            switch (alt8) {
                                case 1 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:596:2: (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis )
                                    {
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:596:2: (otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis )
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:597:2: otherlv_13= LeftParenthesis this_ID_14= RULE_ID otherlv_15= Comma this_COLOR_16= RULE_COLOR otherlv_17= RightParenthesis
                                    {
                                    otherlv_13=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1301); 

                                        	newLeafNode(otherlv_13, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0_0());
                                        
                                    this_ID_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1311); 
                                     
                                        newLeafNode(this_ID_14, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_0_1()); 
                                        
                                    otherlv_15=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1323); 

                                        	newLeafNode(otherlv_15, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_0_2());
                                        
                                    this_COLOR_16=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleDefinition1333); 
                                     
                                        newLeafNode(this_COLOR_16, grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_0_3()); 
                                        
                                    otherlv_17=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1345); 

                                        	newLeafNode(otherlv_17, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_0_4());
                                        

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:620:6: (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID )
                                    {
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:620:6: (otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID )
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:621:2: otherlv_18= LeftParenthesis this_ID_19= RULE_ID otherlv_20= Comma this_COLOR_21= RULE_COLOR otherlv_22= RightParenthesis this_ID_23= RULE_ID
                                    {
                                    otherlv_18=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1365); 

                                        	newLeafNode(otherlv_18, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_1_0());
                                        
                                    this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1375); 
                                     
                                        newLeafNode(this_ID_19, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_1()); 
                                        
                                    otherlv_20=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1387); 

                                        	newLeafNode(otherlv_20, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_1_2());
                                        
                                    this_COLOR_21=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleDefinition1397); 
                                     
                                        newLeafNode(this_COLOR_21, grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_1_3()); 
                                        
                                    otherlv_22=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1409); 

                                        	newLeafNode(otherlv_22, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_1_4());
                                        
                                    this_ID_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1419); 
                                     
                                        newLeafNode(this_ID_23, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_5()); 
                                        

                                    }


                                    }
                                    break;
                                case 3 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:648:6: this_ID_24= RULE_ID
                                    {
                                    this_ID_24=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition1436); 
                                     
                                        newLeafNode(this_ID_24, grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_2()); 
                                        

                                    }
                                    break;

                            }

                            otherlv_25=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1449); 

                                	newLeafNode(otherlv_25, grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_2());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:665:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:666:1: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:667:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber1487);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber1498); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAutoNumber"


    // $ANTLR start "ruleAutoNumber"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:674:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:678:6: ( (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:679:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:679:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:680:2: kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleAutoNumber1536); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:685:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:685:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber1552); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:692:1: (this_INT_2= RULE_INT )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==RULE_INT) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:692:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber1573); 

                            		current.merge(this_INT_2);
                                
                             
                                newLeafNode(this_INT_2, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
                                

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAutoNumber"


    // $ANTLR start "entryRuleTitle"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:707:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:708:1: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:709:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle1622);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle1633); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTitle"


    // $ANTLR start "ruleTitle"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:716:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Title (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:720:6: ( (kw= Title (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:721:1: (kw= Title (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:721:1: (kw= Title (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:722:2: kw= Title (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Title,FOLLOW_Title_in_ruleTitle1671); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:727:1: (this_ID_1= RULE_ID )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:727:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle1687); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleLegend"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:742:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:743:1: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:744:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend1734);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend1745); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLegend"


    // $ANTLR start "ruleLegend"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:751:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:755:6: ( (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:756:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:756:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:757:2: kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend
            {
            kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleLegend1783); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:762:1: (kw= Right | kw= Left | kw= Center )?
            int alt14=4;
            switch ( input.LA(1) ) {
                case Right:
                    {
                    alt14=1;
                    }
                    break;
                case Left:
                    {
                    alt14=2;
                    }
                    break;
                case Center:
                    {
                    alt14=3;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:763:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleLegend1797); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:770:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleLegend1816); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:777:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleLegend1835); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:782:3: (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NEWLINE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:782:8: this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )*
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend1853); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:789:1: (this_ID_5= RULE_ID )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==RULE_ID) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:789:6: this_ID_5= RULE_ID
            	    	    {
            	    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend1874); 

            	    	    		current.merge(this_ID_5);
            	    	        
            	    	     
            	    	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleLegend1896); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
                

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLegend"


    // $ANTLR start "entryRuleNewpage"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:810:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:811:1: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:812:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage1936);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage1947); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNewpage"


    // $ANTLR start "ruleNewpage"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:819:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Newpage (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:823:6: ( (kw= Newpage (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:824:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:824:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:825:2: kw= Newpage (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleNewpage1985); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:830:1: (this_ID_1= RULE_ID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:830:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage2001); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNewpage"


    // $ANTLR start "entryRuleAltElse"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:845:1: entryRuleAltElse returns [EObject current=null] : iv_ruleAltElse= ruleAltElse EOF ;
    public final EObject entryRuleAltElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:846:2: (iv_ruleAltElse= ruleAltElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:847:2: iv_ruleAltElse= ruleAltElse EOF
            {
             newCompositeNode(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse2047);
            iv_ruleAltElse=ruleAltElse();

            state._fsp--;

             current =iv_ruleAltElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse2057); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAltElse"


    // $ANTLR start "ruleAltElse"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:854:1: ruleAltElse returns [EObject current=null] : (otherlv_0= Alt (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) ;
    public final EObject ruleAltElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_NEWLINE_2=null;
        Token otherlv_5=null;
        EObject lv_instructions_3_0 = null;

        EObject lv_elses_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:857:28: ( (otherlv_0= Alt (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:858:1: (otherlv_0= Alt (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:858:1: (otherlv_0= Alt (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:859:2: otherlv_0= Alt (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End
            {
            otherlv_0=(Token)match(input,Alt,FOLLOW_Alt_in_ruleAltElse2095); 

                	newLeafNode(otherlv_0, grammarAccess.getAltElseAccess().getAltKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:863:1: (this_ID_1= RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:863:2: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAltElse2106); 
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getAltElseAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAltElse2118); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:871:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=Participant && LA19_0<=Deactivate)||(LA19_0>=Activate && LA19_0<=Destroy)||LA19_0==Newpage||(LA19_0>=Create && LA19_0<=Group)||LA19_0==Title||LA19_0==Hide||(LA19_0>=Loop && LA19_0<=Note)||(LA19_0>=FullStopFullStopFullStop && LA19_0<=Box)||(LA19_0>=Opt && LA19_0<=VerticalLineVerticalLineVerticalLine)||LA19_0==EqualsSignEqualsSign||LA19_0==VerticalLineVerticalLine||LA19_0==RULE_NEWLINE||LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:872:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:872:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:873:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleAltElse2138);
            	    lv_instructions_3_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAltElseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_3_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:889:3: ( (lv_elses_4_0= ruleElse ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==Else) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:890:1: (lv_elses_4_0= ruleElse )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:890:1: (lv_elses_4_0= ruleElse )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:891:3: lv_elses_4_0= ruleElse
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElse_in_ruleAltElse2160);
            	    lv_elses_4_0=ruleElse();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAltElseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elses",
            	            		lv_elses_4_0, 
            	            		"Else");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_5=(Token)match(input,End,FOLLOW_End_in_ruleAltElse2174); 

                	newLeafNode(otherlv_5, grammarAccess.getAltElseAccess().getEndKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAltElse"


    // $ANTLR start "entryRuleElse"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:920:1: entryRuleElse returns [EObject current=null] : iv_ruleElse= ruleElse EOF ;
    public final EObject entryRuleElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:921:2: (iv_ruleElse= ruleElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:922:2: iv_ruleElse= ruleElse EOF
            {
             newCompositeNode(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse2208);
            iv_ruleElse=ruleElse();

            state._fsp--;

             current =iv_ruleElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse2218); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElse"


    // $ANTLR start "ruleElse"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:929:1: ruleElse returns [EObject current=null] : (otherlv_0= Else (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) ;
    public final EObject ruleElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_ID_1=null;
        Token this_NEWLINE_2=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:932:28: ( (otherlv_0= Else (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:933:1: (otherlv_0= Else (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:933:1: (otherlv_0= Else (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:934:2: otherlv_0= Else (this_ID_1= RULE_ID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )*
            {
            otherlv_0=(Token)match(input,Else,FOLLOW_Else_in_ruleElse2256); 

                	newLeafNode(otherlv_0, grammarAccess.getElseAccess().getElseKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:938:1: (this_ID_1= RULE_ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:938:2: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleElse2267); 
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getElseAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleElse2279); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:946:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=Participant && LA22_0<=Deactivate)||(LA22_0>=Activate && LA22_0<=Destroy)||LA22_0==Newpage||(LA22_0>=Create && LA22_0<=Group)||LA22_0==Title||LA22_0==Hide||(LA22_0>=Loop && LA22_0<=Note)||(LA22_0>=FullStopFullStopFullStop && LA22_0<=Box)||(LA22_0>=Opt && LA22_0<=VerticalLineVerticalLineVerticalLine)||LA22_0==EqualsSignEqualsSign||LA22_0==VerticalLineVerticalLine||LA22_0==RULE_NEWLINE||LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:947:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:947:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:948:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleElse2299);
            	    lv_instructions_3_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElseRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_3_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElse"


    // $ANTLR start "entryRuleGroupingMessages"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:972:1: entryRuleGroupingMessages returns [EObject current=null] : iv_ruleGroupingMessages= ruleGroupingMessages EOF ;
    public final EObject entryRuleGroupingMessages() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingMessages = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:973:2: (iv_ruleGroupingMessages= ruleGroupingMessages EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:974:2: iv_ruleGroupingMessages= ruleGroupingMessages EOF
            {
             newCompositeNode(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages2335);
            iv_ruleGroupingMessages=ruleGroupingMessages();

            state._fsp--;

             current =iv_ruleGroupingMessages; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages2345); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroupingMessages"


    // $ANTLR start "ruleGroupingMessages"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:981:1: ruleGroupingMessages returns [EObject current=null] : ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) ;
    public final EObject ruleGroupingMessages() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token this_NEWLINE_7=null;
        Token otherlv_9=null;
        EObject lv_instructions_8_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:984:28: ( ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group )
            int alt23=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt23=1;
                }
                break;
            case Loop:
                {
                alt23=2;
                }
                break;
            case Par:
                {
                alt23=3;
                }
                break;
            case Break:
                {
                alt23=4;
                }
                break;
            case Critical:
                {
                alt23=5;
                }
                break;
            case Group:
                {
                alt23=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:986:2: otherlv_0= Opt
                    {
                    otherlv_0=(Token)match(input,Opt,FOLLOW_Opt_in_ruleGroupingMessages2384); 

                        	newLeafNode(otherlv_0, grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:992:2: otherlv_1= Loop
                    {
                    otherlv_1=(Token)match(input,Loop,FOLLOW_Loop_in_ruleGroupingMessages2402); 

                        	newLeafNode(otherlv_1, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:998:2: otherlv_2= Par
                    {
                    otherlv_2=(Token)match(input,Par,FOLLOW_Par_in_ruleGroupingMessages2420); 

                        	newLeafNode(otherlv_2, grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1004:2: otherlv_3= Break
                    {
                    otherlv_3=(Token)match(input,Break,FOLLOW_Break_in_ruleGroupingMessages2438); 

                        	newLeafNode(otherlv_3, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3());
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1010:2: otherlv_4= Critical
                    {
                    otherlv_4=(Token)match(input,Critical,FOLLOW_Critical_in_ruleGroupingMessages2456); 

                        	newLeafNode(otherlv_4, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4());
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1016:2: otherlv_5= Group
                    {
                    otherlv_5=(Token)match(input,Group,FOLLOW_Group_in_ruleGroupingMessages2474); 

                        	newLeafNode(otherlv_5, grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1020:2: (this_ID_6= RULE_ID )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1020:3: this_ID_6= RULE_ID
            	    {
            	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGroupingMessages2486); 
            	     
            	        newLeafNode(this_ID_6, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages2498); 
             
                newLeafNode(this_NEWLINE_7, grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1028:1: ( (lv_instructions_8_0= ruleInstruction ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=Participant && LA25_0<=Deactivate)||(LA25_0>=Activate && LA25_0<=Destroy)||LA25_0==Newpage||(LA25_0>=Create && LA25_0<=Group)||LA25_0==Title||LA25_0==Hide||(LA25_0>=Loop && LA25_0<=Note)||(LA25_0>=FullStopFullStopFullStop && LA25_0<=Box)||(LA25_0>=Opt && LA25_0<=VerticalLineVerticalLineVerticalLine)||LA25_0==EqualsSignEqualsSign||LA25_0==VerticalLineVerticalLine||LA25_0==RULE_NEWLINE||LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1029:1: (lv_instructions_8_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1029:1: (lv_instructions_8_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1030:3: lv_instructions_8_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleGroupingMessages2518);
            	    lv_instructions_8_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGroupingMessagesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_8_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleGroupingMessages2532); 

                	newLeafNode(otherlv_9, grammarAccess.getGroupingMessagesAccess().getEndKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupingMessages"


    // $ANTLR start "entryRuleNote"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1059:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1060:2: (iv_ruleNote= ruleNote EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1061:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote2566);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote2576); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNote"


    // $ANTLR start "ruleNote"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1068:1: ruleNote returns [EObject current=null] : (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note ) ) ) ;
    public final EObject ruleNote() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token this_COLOR_15=null;
        Token otherlv_16=null;
        Token this_ID_17=null;
        Token this_NEWLINE_18=null;
        Token this_ID_19=null;
        Token this_NEWLINE_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1071:28: ( (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1072:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1072:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1073:2: otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note ) )
            {
            otherlv_0=(Token)match(input,Note,FOLLOW_Note_in_ruleNote2614); 

                	newLeafNode(otherlv_0, grammarAccess.getNoteAccess().getNoteKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1077:1: ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt31=1;
                }
                break;
            case Left:
                {
                alt31=2;
                }
                break;
            case Over:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1077:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1077:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1078:2: otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    {
                    otherlv_1=(Token)match(input,Right,FOLLOW_Right_in_ruleNote2628); 

                        	newLeafNode(otherlv_1, grammarAccess.getNoteAccess().getRightKeyword_1_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1082:1: (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==Of) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1083:2: otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            {
                            otherlv_2=(Token)match(input,Of,FOLLOW_Of_in_ruleNote2641); 

                                	newLeafNode(otherlv_2, grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1087:1: ( (otherlv_3= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1088:1: (otherlv_3= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1088:1: (otherlv_3= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1089:3: otherlv_3= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2660); 

                            		newLeafNode(otherlv_3, grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1100:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==Comma) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1101:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                            	    {
                            	    otherlv_4=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote2674); 

                            	        	newLeafNode(otherlv_4, grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1105:1: ( (otherlv_5= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1106:1: (otherlv_5= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1106:1: (otherlv_5= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1107:3: otherlv_5= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2693); 

                            	    		newLeafNode(otherlv_5, grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1119:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1119:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1120:2: otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    {
                    otherlv_6=(Token)match(input,Left,FOLLOW_Left_in_ruleNote2718); 

                        	newLeafNode(otherlv_6, grammarAccess.getNoteAccess().getLeftKeyword_1_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1124:1: (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==Of) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1125:2: otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            {
                            otherlv_7=(Token)match(input,Of,FOLLOW_Of_in_ruleNote2731); 

                                	newLeafNode(otherlv_7, grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1129:1: ( (otherlv_8= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1130:1: (otherlv_8= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1130:1: (otherlv_8= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1131:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2750); 

                            		newLeafNode(otherlv_8, grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1142:2: (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( (LA28_0==Comma) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1143:2: otherlv_9= Comma ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote2764); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1147:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1148:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1148:1: (otherlv_10= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1149:3: otherlv_10= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2783); 

                            	    		newLeafNode(otherlv_10, grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop28;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1161:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1161:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1162:2: otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    {
                    otherlv_11=(Token)match(input,Over,FOLLOW_Over_in_ruleNote2808); 

                        	newLeafNode(otherlv_11, grammarAccess.getNoteAccess().getOverKeyword_1_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1166:1: ( (otherlv_12= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1167:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1167:1: (otherlv_12= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1168:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNoteRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2827); 

                    		newLeafNode(otherlv_12, grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
                    	

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1179:2: (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==Comma) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1180:2: otherlv_13= Comma ( (otherlv_14= RULE_ID ) )
                    	    {
                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote2841); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0());
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1184:1: ( (otherlv_14= RULE_ID ) )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1185:1: (otherlv_14= RULE_ID )
                    	    {
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1185:1: (otherlv_14= RULE_ID )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1186:3: otherlv_14= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getNoteRule());
                    	    	        }
                    	            
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2860); 

                    	    		newLeafNode(otherlv_14, grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1197:6: (this_COLOR_15= RULE_COLOR )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_COLOR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1197:7: this_COLOR_15= RULE_COLOR
            	    {
            	    this_COLOR_15=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleNote2876); 
            	     
            	        newLeafNode(this_COLOR_15, grammarAccess.getNoteAccess().getCOLORTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1201:3: ( (otherlv_16= Colon this_ID_17= RULE_ID ) | ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Colon) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_NEWLINE) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1201:4: (otherlv_16= Colon this_ID_17= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1201:4: (otherlv_16= Colon this_ID_17= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1202:2: otherlv_16= Colon this_ID_17= RULE_ID
                    {
                    otherlv_16=(Token)match(input,Colon,FOLLOW_Colon_in_ruleNote2892); 

                        	newLeafNode(otherlv_16, grammarAccess.getNoteAccess().getColonKeyword_3_0_0());
                        
                    this_ID_17=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2902); 
                     
                        newLeafNode(this_ID_17, grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_0_1()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:6: ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:6: ( (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:7: (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )* this_NEWLINE_20= RULE_NEWLINE otherlv_21= End otherlv_22= Note
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:7: (this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )* )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_NEWLINE) ) {
                            int LA34_1 = input.LA(2);

                            if ( (LA34_1==RULE_NEWLINE||LA34_1==RULE_ID) ) {
                                alt34=1;
                            }


                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1211:8: this_NEWLINE_18= RULE_NEWLINE (this_ID_19= RULE_ID )*
                    	    {
                    	    this_NEWLINE_18=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote2921); 
                    	     
                    	        newLeafNode(this_NEWLINE_18, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1215:1: (this_ID_19= RULE_ID )*
                    	    loop33:
                    	    do {
                    	        int alt33=2;
                    	        int LA33_0 = input.LA(1);

                    	        if ( (LA33_0==RULE_ID) ) {
                    	            alt33=1;
                    	        }


                    	        switch (alt33) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1215:2: this_ID_19= RULE_ID
                    	    	    {
                    	    	    this_ID_19=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote2932); 
                    	    	     
                    	    	        newLeafNode(this_ID_19, grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_1_0_1()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop33;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    this_NEWLINE_20=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote2946); 
                     
                        newLeafNode(this_NEWLINE_20, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_1()); 
                        
                    otherlv_21=(Token)match(input,End,FOLLOW_End_in_ruleNote2958); 

                        	newLeafNode(otherlv_21, grammarAccess.getNoteAccess().getEndKeyword_3_1_2());
                        
                    otherlv_22=(Token)match(input,Note,FOLLOW_Note_in_ruleNote2970); 

                        	newLeafNode(otherlv_22, grammarAccess.getNoteAccess().getNoteKeyword_3_1_3());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNote"


    // $ANTLR start "entryRuleDivider"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1241:1: entryRuleDivider returns [String current=null] : iv_ruleDivider= ruleDivider EOF ;
    public final String entryRuleDivider() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDivider = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1242:1: (iv_ruleDivider= ruleDivider EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1243:2: iv_ruleDivider= ruleDivider EOF
            {
             newCompositeNode(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider3007);
            iv_ruleDivider=ruleDivider();

            state._fsp--;

             current =iv_ruleDivider.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider3018); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDivider"


    // $ANTLR start "ruleDivider"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1250:1: ruleDivider returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleDivider() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1254:6: ( (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1255:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1255:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1256:2: kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign
            {
            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider3056); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1261:1: (this_ID_1= RULE_ID )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1261:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDivider3072); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider3092); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 
                

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDivider"


    // $ANTLR start "entryRuleReference"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1282:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1283:2: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1284:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference3131);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference3141); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1291:1: ruleReference returns [EObject current=null] : (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token this_NEWLINE_7=null;
        Token this_ID_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1294:28: ( (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1295:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1295:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1296:2: otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) )
            {
            otherlv_0=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference3179); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
                
            otherlv_1=(Token)match(input,Over,FOLLOW_Over_in_ruleReference3191); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1305:1: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1306:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1306:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1307:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference3210); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            	

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1318:2: (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==Comma) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1319:2: otherlv_3= Comma ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReference3224); 

            	        	newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1323:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1324:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1324:1: (otherlv_4= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1325:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReferenceRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference3243); 

            	    		newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1336:4: ( (otherlv_5= Colon (this_ID_6= RULE_ID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Colon) ) {
                alt41=1;
            }
            else if ( (LA41_0==End||LA41_0==RULE_NEWLINE) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1336:5: (otherlv_5= Colon (this_ID_6= RULE_ID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1336:5: (otherlv_5= Colon (this_ID_6= RULE_ID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1337:2: otherlv_5= Colon (this_ID_6= RULE_ID )*
                    {
                    otherlv_5=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReference3260); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceAccess().getColonKeyword_4_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1341:1: (this_ID_6= RULE_ID )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==RULE_ID) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1341:2: this_ID_6= RULE_ID
                    	    {
                    	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference3271); 
                    	     
                    	        newLeafNode(this_ID_6, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_0_1()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1346:6: ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1346:6: ( (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1346:7: (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )* otherlv_9= End otherlv_10= Ref
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1346:7: (this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )* )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==RULE_NEWLINE) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1346:8: this_NEWLINE_7= RULE_NEWLINE (this_ID_8= RULE_ID )*
                    	    {
                    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference3292); 
                    	     
                    	        newLeafNode(this_NEWLINE_7, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1350:1: (this_ID_8= RULE_ID )*
                    	    loop39:
                    	    do {
                    	        int alt39=2;
                    	        int LA39_0 = input.LA(1);

                    	        if ( (LA39_0==RULE_ID) ) {
                    	            alt39=1;
                    	        }


                    	        switch (alt39) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1350:2: this_ID_8= RULE_ID
                    	    	    {
                    	    	    this_ID_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference3303); 
                    	    	     
                    	    	        newLeafNode(this_ID_8, grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_1_0_1()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop39;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleReference3319); 

                        	newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getEndKeyword_4_1_1());
                        
                    otherlv_10=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference3331); 

                        	newLeafNode(otherlv_10, grammarAccess.getReferenceAccess().getRefKeyword_4_1_2());
                        

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleDelay"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1372:1: entryRuleDelay returns [String current=null] : iv_ruleDelay= ruleDelay EOF ;
    public final String entryRuleDelay() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelay = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1373:1: (iv_ruleDelay= ruleDelay EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1374:2: iv_ruleDelay= ruleDelay EOF
            {
             newCompositeNode(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay3368);
            iv_ruleDelay=ruleDelay();

            state._fsp--;

             current =iv_ruleDelay.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay3379); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDelay"


    // $ANTLR start "ruleDelay"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1381:1: ruleDelay returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) ;
    public final AntlrDatatypeRuleToken ruleDelay() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1385:6: ( (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1386:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1386:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1387:2: kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            {
            kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay3417); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1392:1: ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==FullStopFullStopFullStop||LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1392:2: (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1392:2: (this_ID_1= RULE_ID )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1392:7: this_ID_1= RULE_ID
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDelay3434); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay3454); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDelay"


    // $ANTLR start "entryRuleSpace"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1413:1: entryRuleSpace returns [String current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final String entryRuleSpace() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpace = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1414:1: (iv_ruleSpace= ruleSpace EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1415:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace3496);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace3507); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpace"


    // $ANTLR start "ruleSpace"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1422:1: ruleSpace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) ;
    public final AntlrDatatypeRuleToken ruleSpace() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1426:6: ( (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1427:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1427:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==VerticalLineVerticalLineVerticalLine) ) {
                alt44=1;
            }
            else if ( (LA44_0==VerticalLineVerticalLine) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1428:2: kw= VerticalLineVerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace3545); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1434:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1434:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1435:2: kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace3565); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpace3580); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace3598); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpace"


    // $ANTLR start "entryRuleHidefootbox"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1461:1: entryRuleHidefootbox returns [String current=null] : iv_ruleHidefootbox= ruleHidefootbox EOF ;
    public final String entryRuleHidefootbox() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHidefootbox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1462:1: (iv_ruleHidefootbox= ruleHidefootbox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1463:2: iv_ruleHidefootbox= ruleHidefootbox EOF
            {
             newCompositeNode(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox3639);
            iv_ruleHidefootbox=ruleHidefootbox();

            state._fsp--;

             current =iv_ruleHidefootbox.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox3650); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHidefootbox"


    // $ANTLR start "ruleHidefootbox"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1470:1: ruleHidefootbox returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Hide kw= Footbox ) ;
    public final AntlrDatatypeRuleToken ruleHidefootbox() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1474:6: ( (kw= Hide kw= Footbox ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1475:1: (kw= Hide kw= Footbox )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1475:1: (kw= Hide kw= Footbox )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1476:2: kw= Hide kw= Footbox
            {
            kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleHidefootbox3688); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
                
            kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleHidefootbox3701); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 
                

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHidefootbox"


    // $ANTLR start "entryRuleActivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1495:1: entryRuleActivate returns [EObject current=null] : iv_ruleActivate= ruleActivate EOF ;
    public final EObject entryRuleActivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1496:2: (iv_ruleActivate= ruleActivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1497:2: iv_ruleActivate= ruleActivate EOF
            {
             newCompositeNode(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate3740);
            iv_ruleActivate=ruleActivate();

            state._fsp--;

             current =iv_ruleActivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate3750); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActivate"


    // $ANTLR start "ruleActivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1504:1: ruleActivate returns [EObject current=null] : (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleActivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLOR_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1507:28: ( (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1508:1: (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1508:1: (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1509:2: otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Activate,FOLLOW_Activate_in_ruleActivate3788); 

                	newLeafNode(otherlv_0, grammarAccess.getActivateAccess().getActivateKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1513:1: (this_COLOR_1= RULE_COLOR )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_COLOR) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1513:2: this_COLOR_1= RULE_COLOR
                    {
                    this_COLOR_1=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleActivate3799); 
                     
                        newLeafNode(this_COLOR_1, grammarAccess.getActivateAccess().getCOLORTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1517:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1518:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1518:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1519:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActivate3817); 

            			newLeafNode(lv_name_2_0, grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getActivateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActivate"


    // $ANTLR start "entryRuleDeactivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1543:1: entryRuleDeactivate returns [EObject current=null] : iv_ruleDeactivate= ruleDeactivate EOF ;
    public final EObject entryRuleDeactivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeactivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1544:2: (iv_ruleDeactivate= ruleDeactivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1545:2: iv_ruleDeactivate= ruleDeactivate EOF
            {
             newCompositeNode(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate3857);
            iv_ruleDeactivate=ruleDeactivate();

            state._fsp--;

             current =iv_ruleDeactivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate3867); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeactivate"


    // $ANTLR start "ruleDeactivate"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1552:1: ruleDeactivate returns [EObject current=null] : ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDeactivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1555:28: ( ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1556:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1556:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1556:2: (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1556:2: (otherlv_0= Deactivate | otherlv_1= Destroy )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Deactivate) ) {
                alt46=1;
            }
            else if ( (LA46_0==Destroy) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1557:2: otherlv_0= Deactivate
                    {
                    otherlv_0=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleDeactivate3906); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1563:2: otherlv_1= Destroy
                    {
                    otherlv_1=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleDeactivate3924); 

                        	newLeafNode(otherlv_1, grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1567:2: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1568:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1568:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1569:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeactivateRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeactivate3944); 

            		newLeafNode(otherlv_2, grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeactivate"


    // $ANTLR start "entryRuleParticipantCreation"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1588:1: entryRuleParticipantCreation returns [String current=null] : iv_ruleParticipantCreation= ruleParticipantCreation EOF ;
    public final String entryRuleParticipantCreation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParticipantCreation = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1589:1: (iv_ruleParticipantCreation= ruleParticipantCreation EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1590:2: iv_ruleParticipantCreation= ruleParticipantCreation EOF
            {
             newCompositeNode(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation3980);
            iv_ruleParticipantCreation=ruleParticipantCreation();

            state._fsp--;

             current =iv_ruleParticipantCreation.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation3991); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParticipantCreation"


    // $ANTLR start "ruleParticipantCreation"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1597:1: ruleParticipantCreation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Create this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleParticipantCreation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1601:6: ( (kw= Create this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1602:1: (kw= Create this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1602:1: (kw= Create this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1603:2: kw= Create this_ID_1= RULE_ID
            {
            kw=(Token)match(input,Create,FOLLOW_Create_in_ruleParticipantCreation4029); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParticipantCreation4044); 

            		current.merge(this_ID_1);
                
             
                newLeafNode(this_ID_1, grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 
                

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParticipantCreation"


    // $ANTLR start "entryRuleBox"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1623:1: entryRuleBox returns [EObject current=null] : iv_ruleBox= ruleBox EOF ;
    public final EObject entryRuleBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1624:2: (iv_ruleBox= ruleBox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1625:2: iv_ruleBox= ruleBox EOF
            {
             newCompositeNode(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox4088);
            iv_ruleBox=ruleBox();

            state._fsp--;

             current =iv_ruleBox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox4098); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBox"


    // $ANTLR start "ruleBox"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1632:1: ruleBox returns [EObject current=null] : (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) ;
    public final EObject ruleBox() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_3=null;
        Token this_COLOR_4=null;
        Token this_NEWLINE_5=null;
        Token this_NEWLINE_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_definitions_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1635:28: ( (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1636:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1636:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1637:2: otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box
            {
            otherlv_0=(Token)match(input,Box,FOLLOW_Box_in_ruleBox4136); 

                	newLeafNode(otherlv_0, grammarAccess.getBoxAccess().getBoxKeyword_0());
                
            otherlv_1=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox4148); 

                	newLeafNode(otherlv_1, grammarAccess.getBoxAccess().getQuotationMarkKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1646:1: (this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1646:2: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBox4159); 
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            otherlv_3=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox4173); 

                	newLeafNode(otherlv_3, grammarAccess.getBoxAccess().getQuotationMarkKeyword_3());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1655:1: (this_COLOR_4= RULE_COLOR )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_COLOR) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1655:2: this_COLOR_4= RULE_COLOR
                    {
                    this_COLOR_4=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleBox4184); 
                     
                        newLeafNode(this_COLOR_4, grammarAccess.getBoxAccess().getCOLORTerminalRuleCall_4()); 
                        

                    }
                    break;

            }

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox4196); 
             
                newLeafNode(this_NEWLINE_5, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1663:1: ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==Participant||LA50_0==Boundary||(LA50_0>=Database && LA50_0<=Control)||LA50_0==Entity||LA50_0==Actor||LA50_0==RULE_NEWLINE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1663:2: ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1663:2: ( (lv_definitions_6_0= ruleDefinition ) )?
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==Participant||LA49_0==Boundary||(LA49_0>=Database && LA49_0<=Control)||LA49_0==Entity||LA49_0==Actor) ) {
            	        alt49=1;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1664:1: (lv_definitions_6_0= ruleDefinition )
            	            {
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1664:1: (lv_definitions_6_0= ruleDefinition )
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1665:3: lv_definitions_6_0= ruleDefinition
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDefinition_in_ruleBox4217);
            	            lv_definitions_6_0=ruleDefinition();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getBoxRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"definitions",
            	                    		lv_definitions_6_0, 
            	                    		"Definition");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }
            	            break;

            	    }

            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox4229); 
            	     
            	        newLeafNode(this_NEWLINE_7, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            otherlv_8=(Token)match(input,End,FOLLOW_End_in_ruleBox4243); 

                	newLeafNode(otherlv_8, grammarAccess.getBoxAccess().getEndKeyword_7());
                
            otherlv_9=(Token)match(input,Box,FOLLOW_Box_in_ruleBox4255); 

                	newLeafNode(otherlv_9, grammarAccess.getBoxAccess().getBoxKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBox"

    // Delegated rules


 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rulePlantuml122 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_ruleDiagram212 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram222 = new BitSet(new long[]{0x002A097BB57EBF70L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram242 = new BitSet(new long[]{0x002A097BB57EBF70L});
    public static final BitSet FOLLOW_RULE_END_in_ruleDiagram254 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram265 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleInstruction359 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction387 = new BitSet(new long[]{0x0602000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleInstruction398 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleInstruction414 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction438 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction459 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction480 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction501 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleAltElse_in_ruleInstruction528 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_ruleInstruction555 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleNote_in_ruleInstruction582 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleDivider_in_ruleInstruction603 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleReference_in_ruleInstruction630 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleDelay_in_ruleInstruction651 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleSpace_in_ruleInstruction672 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_ruleInstruction693 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleActivate_in_ruleInstruction720 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleDeactivate_in_ruleInstruction747 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_ruleInstruction768 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleBox_in_ruleInstruction795 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrow893 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_ruleArrow909 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrow925 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleArrow944 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArrow955 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_ruleDefinition1042 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_ruleDefinition1084 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_ruleDefinition1126 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_ruleDefinition1168 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_ruleDefinition1210 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_ruleDefinition1252 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1268 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1287 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1301 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1311 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1323 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleDefinition1333 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1345 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1365 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1375 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1387 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleDefinition1397 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1409 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1419 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition1436 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber1487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleAutoNumber1536 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber1552 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle1633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleTitle1671 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle1687 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend1734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleLegend1783 = new BitSet(new long[]{0x0002000008810080L});
    public static final BitSet FOLLOW_Right_in_ruleLegend1797 = new BitSet(new long[]{0x0002000000000080L});
    public static final BitSet FOLLOW_Left_in_ruleLegend1816 = new BitSet(new long[]{0x0002000000000080L});
    public static final BitSet FOLLOW_Center_in_ruleLegend1835 = new BitSet(new long[]{0x0002000000000080L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend1853 = new BitSet(new long[]{0x0022000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend1874 = new BitSet(new long[]{0x0022000000000080L});
    public static final BitSet FOLLOW_Endlegend_in_ruleLegend1896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage1936 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleNewpage1985 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage2001 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse2047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleAltElse2095 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAltElse2106 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAltElse2118 = new BitSet(new long[]{0x0022097FB77EBF70L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleAltElse2138 = new BitSet(new long[]{0x0022097FB77EBF70L});
    public static final BitSet FOLLOW_ruleElse_in_ruleAltElse2160 = new BitSet(new long[]{0x0000000402000000L});
    public static final BitSet FOLLOW_End_in_ruleAltElse2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse2208 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleElse2256 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleElse2267 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleElse2279 = new BitSet(new long[]{0x0022097BB57EBF72L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleElse2299 = new BitSet(new long[]{0x0022097BB57EBF72L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages2335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleGroupingMessages2384 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_Loop_in_ruleGroupingMessages2402 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_Par_in_ruleGroupingMessages2420 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_Break_in_ruleGroupingMessages2438 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_Critical_in_ruleGroupingMessages2456 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_Group_in_ruleGroupingMessages2474 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGroupingMessages2486 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages2498 = new BitSet(new long[]{0x0022097FB57EBF70L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGroupingMessages2518 = new BitSet(new long[]{0x0022097FB57EBF70L});
    public static final BitSet FOLLOW_End_in_ruleGroupingMessages2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote2566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote2576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleNote2614 = new BitSet(new long[]{0x0000000048800000L});
    public static final BitSet FOLLOW_Right_in_ruleNote2628 = new BitSet(new long[]{0x0203040000000000L});
    public static final BitSet FOLLOW_Of_in_ruleNote2641 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2660 = new BitSet(new long[]{0x0203800000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleNote2674 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2693 = new BitSet(new long[]{0x0203800000000000L});
    public static final BitSet FOLLOW_Left_in_ruleNote2718 = new BitSet(new long[]{0x0203040000000000L});
    public static final BitSet FOLLOW_Of_in_ruleNote2731 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2750 = new BitSet(new long[]{0x0203800000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleNote2764 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2783 = new BitSet(new long[]{0x0203800000000000L});
    public static final BitSet FOLLOW_Over_in_ruleNote2808 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2827 = new BitSet(new long[]{0x0203800000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleNote2841 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2860 = new BitSet(new long[]{0x0203800000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleNote2876 = new BitSet(new long[]{0x0203000000000000L});
    public static final BitSet FOLLOW_Colon_in_ruleNote2892 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote2921 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote2932 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote2946 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_End_in_ruleNote2958 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_Note_in_ruleNote2970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider3007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider3018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider3056 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDivider3072 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider3092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference3131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference3141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleReference3179 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Over_in_ruleReference3191 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference3210 = new BitSet(new long[]{0x0003800400000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReference3224 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference3243 = new BitSet(new long[]{0x0003800400000000L});
    public static final BitSet FOLLOW_Colon_in_ruleReference3260 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference3271 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference3292 = new BitSet(new long[]{0x0022000400000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference3303 = new BitSet(new long[]{0x0022000400000000L});
    public static final BitSet FOLLOW_End_in_ruleReference3319 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Ref_in_ruleReference3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay3368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay3417 = new BitSet(new long[]{0x0020000080000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDelay3434 = new BitSet(new long[]{0x0020000080000000L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace3496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace3507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace3565 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpace3580 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace3598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox3639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleHidefootbox3688 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Footbox_in_ruleHidefootbox3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate3740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate3750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleActivate3788 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleActivate3799 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActivate3817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate3857 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate3867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleDeactivate3906 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_Destroy_in_ruleDeactivate3924 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeactivate3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation3980 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation3991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleParticipantCreation4029 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParticipantCreation4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox4088 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleBox4136 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox4148 = new BitSet(new long[]{0x0020100000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBox4159 = new BitSet(new long[]{0x0020100000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox4173 = new BitSet(new long[]{0x0202000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleBox4184 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox4196 = new BitSet(new long[]{0x0002000400141A10L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleBox4217 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox4229 = new BitSet(new long[]{0x0002000400141A10L});
    public static final BitSet FOLLOW_End_in_ruleBox4243 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Box_in_ruleBox4255 = new BitSet(new long[]{0x0000000000000002L});

}