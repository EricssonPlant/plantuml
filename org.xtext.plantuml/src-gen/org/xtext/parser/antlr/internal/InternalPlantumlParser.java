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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Participant", "Autonumber", "Deactivate", "Endlegend", "Activate", "Boundary", "Critical", "Database", "Control", "Destroy", "Footbox", "Newpage", "Center", "Create", "Entity", "Legend", "Actor", "Break", "Group", "Right", "Title", "Else", "Hide", "Left", "Loop", "Note", "Over", "FullStopFullStopFullStop", "Alt", "Box", "End", "Opt", "Par", "Ref", "VerticalLineVerticalLineVerticalLine", "LessThanSignLessThanSign", "EqualsSignEqualsSign", "GreaterThanSignGreaterThanSign", "Of", "VerticalLineVerticalLine", "QuotationMark", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "HyphenMinus", "FullStop", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "RULE_NEWLINE", "RULE_START", "RULE_END", "RULE_INT", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_SEQUENCE", "RULE_COLOR", "RULE_HEXCODE", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Par=36;
    public static final int Entity=18;
    public static final int Left=27;
    public static final int RULE_SEQUENCE=62;
    public static final int Break=21;
    public static final int Alt=32;
    public static final int Critical=10;
    public static final int FullStopFullStopFullStop=31;
    public static final int LessThanSign=52;
    public static final int Boundary=9;
    public static final int Opt=35;
    public static final int LeftParenthesis=46;
    public static final int Actor=20;
    public static final int VerticalLineVerticalLineVerticalLine=38;
    public static final int Database=11;
    public static final int GreaterThanSign=54;
    public static final int RULE_ID=59;
    public static final int Endlegend=7;
    public static final int RightParenthesis=47;
    public static final int Box=33;
    public static final int EqualsSignEqualsSign=40;
    public static final int Participant=4;
    public static final int Activate=8;
    public static final int RULE_INT=58;
    public static final int Note=29;
    public static final int NumberSign=45;
    public static final int RULE_ML_COMMENT=60;
    public static final int RULE_HEXCODE=64;
    public static final int End=34;
    public static final int LessThanSignLessThanSign=39;
    public static final int Hide=26;
    public static final int Group=22;
    public static final int Legend=19;
    public static final int RULE_END=57;
    public static final int RULE_START=56;
    public static final int VerticalLineVerticalLine=43;
    public static final int RULE_NEWLINE=55;
    public static final int Right=23;
    public static final int Footbox=14;
    public static final int QuotationMark=44;
    public static final int Newpage=15;
    public static final int RULE_SL_COMMENT=61;
    public static final int Over=30;
    public static final int Comma=48;
    public static final int EqualsSign=53;
    public static final int Control=12;
    public static final int HyphenMinus=49;
    public static final int Destroy=13;
    public static final int Create=17;
    public static final int RULE_COLOR=63;
    public static final int Deactivate=6;
    public static final int Colon=51;
    public static final int EOF=-1;
    public static final int Loop=28;
    public static final int FullStop=50;
    public static final int Center=16;
    public static final int RULE_WS=65;
    public static final int Title=24;
    public static final int RULE_ANY_OTHER=66;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:109:1: ruleDiagram returns [EObject current=null] : (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token this_START_0=null;
        Token this_NEWLINE_1=null;
        Token this_END_3=null;
        Token this_NEWLINE_4=null;
        EObject lv_instructions_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:112:28: ( (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:1: (this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:113:2: this_START_0= RULE_START this_NEWLINE_1= RULE_NEWLINE ( (lv_instructions_2_0= ruleInstruction ) )* this_END_3= RULE_END (this_NEWLINE_4= RULE_NEWLINE )*
            {
            this_START_0=(Token)match(input,RULE_START,FOLLOW_RULE_START_in_ruleDiagram203); 
             
                newLeafNode(this_START_0, grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_0()); 
                
            this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram213); 
             
                newLeafNode(this_NEWLINE_1, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:121:1: ( (lv_instructions_2_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=Participant && LA2_0<=Create)||(LA2_0>=Create && LA2_0<=Over)||LA2_0==Hide||(LA2_0>=Loop && LA2_0<=Note)||(LA2_0>=FullStopFullStopFullStop && LA2_0<=VerticalLineVerticalLineVerticalLine)||LA2_0==EqualsSignEqualsSign||(LA2_0>=Of && LA2_0<=VerticalLineVerticalLine)||(LA2_0>=NumberSign && LA2_0<=RULE_NEWLINE)||(LA2_0>=RULE_INT && LA2_0<=RULE_ID)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:122:1: (lv_instructions_2_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:122:1: (lv_instructions_2_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:123:3: lv_instructions_2_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram233);
            	    lv_instructions_2_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDiagramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_2_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            this_END_3=(Token)match(input,RULE_END,FOLLOW_RULE_END_in_ruleDiagram245); 
             
                newLeafNode(this_END_3, grammarAccess.getDiagramAccess().getENDTerminalRuleCall_3()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:143:1: (this_NEWLINE_4= RULE_NEWLINE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:143:2: this_NEWLINE_4= RULE_NEWLINE
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleDiagram256); 
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4()); 
            	        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:155:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:156:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:157:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction292);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction302); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:164:1: ruleInstruction returns [EObject current=null] : ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:167:28: ( ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:1: ( (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )? this_NEWLINE_20= RULE_NEWLINE
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:168:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )?
            int alt5=19;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:169:5: this_Arrow_0= ruleArrow
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleArrow_in_ruleInstruction350);
                    this_Arrow_0=ruleArrow();

                    state._fsp--;


                            current = this_Arrow_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:178:6: (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:178:6: (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:179:5: this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )?
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction378);
                    this_Definition_1=ruleDefinition();

                    state._fsp--;


                            current = this_Definition_1;
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:187:1: (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )?
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
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:187:2: this_COLOR_2= RULE_COLOR
                            {
                            this_COLOR_2=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleInstruction389); 
                             
                                newLeafNode(this_COLOR_2, grammarAccess.getInstructionAccess().getCOLORTerminalRuleCall_0_1_1_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:192:6: this_HEXCODE_3= RULE_HEXCODE
                            {
                            this_HEXCODE_3=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleInstruction405); 
                             
                                newLeafNode(this_HEXCODE_3, grammarAccess.getInstructionAccess().getHEXCODETerminalRuleCall_0_1_1_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:198:5: ruleAutoNumber
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                        
                    pushFollow(FOLLOW_ruleAutoNumber_in_ruleInstruction429);
                    ruleAutoNumber();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:207:5: ruleTitle
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                        
                    pushFollow(FOLLOW_ruleTitle_in_ruleInstruction450);
                    ruleTitle();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:216:5: ruleLegend
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                        
                    pushFollow(FOLLOW_ruleLegend_in_ruleInstruction471);
                    ruleLegend();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:225:5: ruleNewpage
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                        
                    pushFollow(FOLLOW_ruleNewpage_in_ruleInstruction492);
                    ruleNewpage();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:234:5: this_AltElse_8= ruleAltElse
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                        
                    pushFollow(FOLLOW_ruleAltElse_in_ruleInstruction519);
                    this_AltElse_8=ruleAltElse();

                    state._fsp--;


                            current = this_AltElse_8;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:244:5: this_GroupingMessages_9= ruleGroupingMessages
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                        
                    pushFollow(FOLLOW_ruleGroupingMessages_in_ruleInstruction546);
                    this_GroupingMessages_9=ruleGroupingMessages();

                    state._fsp--;


                            current = this_GroupingMessages_9;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:254:5: this_Note_10= ruleNote
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                        
                    pushFollow(FOLLOW_ruleNote_in_ruleInstruction573);
                    this_Note_10=ruleNote();

                    state._fsp--;


                            current = this_Note_10;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:264:5: ruleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                        
                    pushFollow(FOLLOW_ruleDivider_in_ruleInstruction594);
                    ruleDivider();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:273:5: this_Reference_12= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleInstruction621);
                    this_Reference_12=ruleReference();

                    state._fsp--;


                            current = this_Reference_12;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:283:5: ruleDelay
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                        
                    pushFollow(FOLLOW_ruleDelay_in_ruleInstruction642);
                    ruleDelay();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:292:5: ruleSpace
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                        
                    pushFollow(FOLLOW_ruleSpace_in_ruleInstruction663);
                    ruleSpace();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:301:5: ruleHidefootbox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                        
                    pushFollow(FOLLOW_ruleHidefootbox_in_ruleInstruction684);
                    ruleHidefootbox();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:310:5: this_Activate_16= ruleActivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                        
                    pushFollow(FOLLOW_ruleActivate_in_ruleInstruction711);
                    this_Activate_16=ruleActivate();

                    state._fsp--;


                            current = this_Activate_16;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:320:5: this_Deactivate_17= ruleDeactivate
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                        
                    pushFollow(FOLLOW_ruleDeactivate_in_ruleInstruction738);
                    this_Deactivate_17=ruleDeactivate();

                    state._fsp--;


                            current = this_Deactivate_17;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:330:5: ruleParticipantCreation
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                        
                    pushFollow(FOLLOW_ruleParticipantCreation_in_ruleInstruction759);
                    ruleParticipantCreation();

                    state._fsp--;


                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:339:5: this_Box_19= ruleBox
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                        
                    pushFollow(FOLLOW_ruleBox_in_ruleInstruction786);
                    this_Box_19=ruleBox();

                    state._fsp--;


                            current = this_Box_19;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_NEWLINE_20=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleInstruction798); 
             
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:359:1: entryRuleArrow returns [EObject current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final EObject entryRuleArrow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrow = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:360:2: (iv_ruleArrow= ruleArrow EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:361:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow832);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow842); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:368:1: ruleArrow returns [EObject current=null] : ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? ) ;
    public final EObject ruleArrow() throws RecognitionException {
        EObject current = null;

        Token this_SEQUENCE_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_names_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:371:28: ( ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:372:1: ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:372:1: ( ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:372:2: ( (lv_name_0_0= ruleMyID ) ) this_SEQUENCE_1= RULE_SEQUENCE ( (lv_names_2_0= ruleMyID ) ) (otherlv_3= Colon ( ruleMyID )* )?
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:372:2: ( (lv_name_0_0= ruleMyID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:373:1: (lv_name_0_0= ruleMyID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:373:1: (lv_name_0_0= ruleMyID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:374:3: lv_name_0_0= ruleMyID
            {
             
            	        newCompositeNode(grammarAccess.getArrowAccess().getNameMyIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleMyID_in_ruleArrow888);
            lv_name_0_0=ruleMyID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrowRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"MyID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            this_SEQUENCE_1=(Token)match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_ruleArrow899); 
             
                newLeafNode(this_SEQUENCE_1, grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:394:1: ( (lv_names_2_0= ruleMyID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:395:1: (lv_names_2_0= ruleMyID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:395:1: (lv_names_2_0= ruleMyID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:396:3: lv_names_2_0= ruleMyID
            {
             
            	        newCompositeNode(grammarAccess.getArrowAccess().getNamesMyIDParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleMyID_in_ruleArrow919);
            lv_names_2_0=ruleMyID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrowRule());
            	        }
                   		add(
                   			current, 
                   			"names",
                    		lv_names_2_0, 
                    		"MyID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:412:2: (otherlv_3= Colon ( ruleMyID )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:413:2: otherlv_3= Colon ( ruleMyID )*
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleArrow933); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrowAccess().getColonKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:417:1: ( ruleMyID )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=Autonumber && LA6_0<=Activate)||LA6_0==Critical||(LA6_0>=Destroy && LA6_0<=Create)||LA6_0==Legend||(LA6_0>=Break && LA6_0<=Over)||(LA6_0>=Alt && LA6_0<=Ref)||LA6_0==Of||(LA6_0>=NumberSign && LA6_0<=GreaterThanSign)||(LA6_0>=RULE_INT && LA6_0<=RULE_ID)) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:418:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleArrow949);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:433:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:434:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:435:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition987);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition997); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:442:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token this_COLOR_16=null;
        Token this_HEXCODE_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        AntlrDatatypeRuleToken lv_name_7_0 = null;

        AntlrDatatypeRuleToken lv_name_9_0 = null;

        AntlrDatatypeRuleToken lv_name_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:445:28: ( ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:446:1: ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:446:1: ( (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) ) | (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) ) | (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) ) | (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) ) | (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) ) | (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt12=1;
                }
                break;
            case Boundary:
                {
                alt12=2;
                }
                break;
            case Control:
                {
                alt12=3;
                }
                break;
            case Entity:
                {
                alt12=4;
                }
                break;
            case Database:
                {
                alt12=5;
                }
                break;
            case Participant:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:446:2: (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:446:2: (otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:447:2: otherlv_0= Actor ( (lv_name_1_0= ruleMyID ) )
                    {
                    otherlv_0=(Token)match(input,Actor,FOLLOW_Actor_in_ruleDefinition1036); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:451:1: ( (lv_name_1_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:452:1: (lv_name_1_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:452:1: (lv_name_1_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:453:3: lv_name_1_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1056);
                    lv_name_1_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:470:6: (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:470:6: (otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:471:2: otherlv_2= Boundary ( (lv_name_3_0= ruleMyID ) )
                    {
                    otherlv_2=(Token)match(input,Boundary,FOLLOW_Boundary_in_ruleDefinition1077); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:475:1: ( (lv_name_3_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:476:1: (lv_name_3_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:476:1: (lv_name_3_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:477:3: lv_name_3_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1097);
                    lv_name_3_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:494:6: (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:494:6: (otherlv_4= Control ( (lv_name_5_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:495:2: otherlv_4= Control ( (lv_name_5_0= ruleMyID ) )
                    {
                    otherlv_4=(Token)match(input,Control,FOLLOW_Control_in_ruleDefinition1118); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:499:1: ( (lv_name_5_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:500:1: (lv_name_5_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:500:1: (lv_name_5_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:501:3: lv_name_5_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1138);
                    lv_name_5_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:518:6: (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:518:6: (otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:519:2: otherlv_6= Entity ( (lv_name_7_0= ruleMyID ) )
                    {
                    otherlv_6=(Token)match(input,Entity,FOLLOW_Entity_in_ruleDefinition1159); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:523:1: ( (lv_name_7_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:524:1: (lv_name_7_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:524:1: (lv_name_7_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:525:3: lv_name_7_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1179);
                    lv_name_7_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_7_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:542:6: (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:542:6: (otherlv_8= Database ( (lv_name_9_0= ruleMyID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:543:2: otherlv_8= Database ( (lv_name_9_0= ruleMyID ) )
                    {
                    otherlv_8=(Token)match(input,Database,FOLLOW_Database_in_ruleDefinition1200); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:547:1: ( (lv_name_9_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:548:1: (lv_name_9_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:548:1: (lv_name_9_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:549:3: lv_name_9_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1220);
                    lv_name_9_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_9_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:566:6: (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:566:6: (otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:567:2: otherlv_10= Participant ( (lv_name_11_0= ruleMyID ) ) (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )?
                    {
                    otherlv_10=(Token)match(input,Participant,FOLLOW_Participant_in_ruleDefinition1241); 

                        	newLeafNode(otherlv_10, grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:571:1: ( (lv_name_11_0= ruleMyID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:572:1: (lv_name_11_0= ruleMyID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:572:1: (lv_name_11_0= ruleMyID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:573:3: lv_name_11_0= ruleMyID
                    {
                     
                    	        newCompositeNode(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMyID_in_ruleDefinition1261);
                    lv_name_11_0=ruleMyID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_11_0, 
                            		"MyID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:589:2: (otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==LessThanSignLessThanSign) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:590:2: otherlv_12= LessThanSignLessThanSign (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )? ( ruleEndID )* otherlv_20= GreaterThanSignGreaterThanSign
                            {
                            otherlv_12=(Token)match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1275); 

                                	newLeafNode(otherlv_12, grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:594:1: (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )?
                            int alt9=2;
                            alt9 = dfa9.predict(input);
                            switch (alt9) {
                                case 1 :
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:595:2: otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis
                                    {
                                    otherlv_13=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleDefinition1288); 

                                        	newLeafNode(otherlv_13, grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0());
                                        
                                     
                                            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 
                                        
                                    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1303);
                                    ruleEndID();

                                    state._fsp--;


                                            afterParserOrEnumRuleCall();
                                        
                                    otherlv_15=(Token)match(input,Comma,FOLLOW_Comma_in_ruleDefinition1315); 

                                        	newLeafNode(otherlv_15, grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2());
                                        
                                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:612:1: (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE )
                                    int alt8=2;
                                    int LA8_0 = input.LA(1);

                                    if ( (LA8_0==RULE_COLOR) ) {
                                        alt8=1;
                                    }
                                    else if ( (LA8_0==RULE_HEXCODE) ) {
                                        alt8=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 8, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt8) {
                                        case 1 :
                                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:612:2: this_COLOR_16= RULE_COLOR
                                            {
                                            this_COLOR_16=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleDefinition1326); 
                                             
                                                newLeafNode(this_COLOR_16, grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_3_0()); 
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:617:6: this_HEXCODE_17= RULE_HEXCODE
                                            {
                                            this_HEXCODE_17=(Token)match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_ruleDefinition1342); 
                                             
                                                newLeafNode(this_HEXCODE_17, grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_3_1()); 
                                                

                                            }
                                            break;

                                    }

                                    otherlv_18=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleDefinition1355); 

                                        	newLeafNode(otherlv_18, grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_4());
                                        

                                    }
                                    break;

                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:626:3: ( ruleEndID )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( ((LA10_0>=Autonumber && LA10_0<=Activate)||LA10_0==Critical||(LA10_0>=Destroy && LA10_0<=Create)||LA10_0==Legend||(LA10_0>=Break && LA10_0<=Over)||(LA10_0>=Alt && LA10_0<=Box)||(LA10_0>=Opt && LA10_0<=Ref)||LA10_0==Of||(LA10_0>=NumberSign && LA10_0<=GreaterThanSign)||(LA10_0>=RULE_INT && LA10_0<=RULE_ID)) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:627:5: ruleEndID
                            	    {
                            	     
                            	            newCompositeNode(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 
                            	        
                            	    pushFollow(FOLLOW_ruleEndID_in_ruleDefinition1373);
                            	    ruleEndID();

                            	    state._fsp--;


                            	            afterParserOrEnumRuleCall();
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);

                            otherlv_20=(Token)match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1387); 

                                	newLeafNode(otherlv_20, grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3());
                                

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


    // $ANTLR start "entryRuleEndID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:649:1: entryRuleEndID returns [String current=null] : iv_ruleEndID= ruleEndID EOF ;
    public final String entryRuleEndID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEndID = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:650:1: (iv_ruleEndID= ruleEndID EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:651:2: iv_ruleEndID= ruleEndID EOF
            {
             newCompositeNode(grammarAccess.getEndIDRule()); 
            pushFollow(FOLLOW_ruleEndID_in_entryRuleEndID1427);
            iv_ruleEndID=ruleEndID();

            state._fsp--;

             current =iv_ruleEndID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndID1438); 

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
    // $ANTLR end "entryRuleEndID"


    // $ANTLR start "ruleEndID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:658:1: ruleEndID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleEndID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_33=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:662:6: ( (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:663:1: (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:663:1: (this_ID_0= RULE_ID | kw= Create | kw= Autonumber | kw= Title | kw= Legend | kw= Right | kw= Left | kw= Center | kw= Endlegend | kw= Alt | kw= Else | kw= Newpage | kw= Opt | kw= Loop | kw= Par | kw= Break | kw= Critical | kw= Group | kw= Note | kw= Over | kw= Of | kw= Ref | kw= Hide | kw= Footbox | kw= Activate | kw= Deactivate | kw= Destroy | kw= Box | kw= NumberSign | kw= Comma | kw= LeftParenthesis | kw= RightParenthesis | kw= EqualsSign | this_INT_33= RULE_INT | kw= HyphenMinus | kw= FullStop | kw= Colon | kw= GreaterThanSign | kw= LessThanSign )
            int alt13=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt13=1;
                }
                break;
            case Create:
                {
                alt13=2;
                }
                break;
            case Autonumber:
                {
                alt13=3;
                }
                break;
            case Title:
                {
                alt13=4;
                }
                break;
            case Legend:
                {
                alt13=5;
                }
                break;
            case Right:
                {
                alt13=6;
                }
                break;
            case Left:
                {
                alt13=7;
                }
                break;
            case Center:
                {
                alt13=8;
                }
                break;
            case Endlegend:
                {
                alt13=9;
                }
                break;
            case Alt:
                {
                alt13=10;
                }
                break;
            case Else:
                {
                alt13=11;
                }
                break;
            case Newpage:
                {
                alt13=12;
                }
                break;
            case Opt:
                {
                alt13=13;
                }
                break;
            case Loop:
                {
                alt13=14;
                }
                break;
            case Par:
                {
                alt13=15;
                }
                break;
            case Break:
                {
                alt13=16;
                }
                break;
            case Critical:
                {
                alt13=17;
                }
                break;
            case Group:
                {
                alt13=18;
                }
                break;
            case Note:
                {
                alt13=19;
                }
                break;
            case Over:
                {
                alt13=20;
                }
                break;
            case Of:
                {
                alt13=21;
                }
                break;
            case Ref:
                {
                alt13=22;
                }
                break;
            case Hide:
                {
                alt13=23;
                }
                break;
            case Footbox:
                {
                alt13=24;
                }
                break;
            case Activate:
                {
                alt13=25;
                }
                break;
            case Deactivate:
                {
                alt13=26;
                }
                break;
            case Destroy:
                {
                alt13=27;
                }
                break;
            case Box:
                {
                alt13=28;
                }
                break;
            case NumberSign:
                {
                alt13=29;
                }
                break;
            case Comma:
                {
                alt13=30;
                }
                break;
            case LeftParenthesis:
                {
                alt13=31;
                }
                break;
            case RightParenthesis:
                {
                alt13=32;
                }
                break;
            case EqualsSign:
                {
                alt13=33;
                }
                break;
            case RULE_INT:
                {
                alt13=34;
                }
                break;
            case HyphenMinus:
                {
                alt13=35;
                }
                break;
            case FullStop:
                {
                alt13=36;
                }
                break;
            case Colon:
                {
                alt13=37;
                }
                break;
            case GreaterThanSign:
                {
                alt13=38;
                }
                break;
            case LessThanSign:
                {
                alt13=39;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:663:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndID1478); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:672:2: kw= Create
                    {
                    kw=(Token)match(input,Create,FOLLOW_Create_in_ruleEndID1502); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCreateKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:679:2: kw= Autonumber
                    {
                    kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleEndID1521); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:686:2: kw= Title
                    {
                    kw=(Token)match(input,Title,FOLLOW_Title_in_ruleEndID1540); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getTitleKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:693:2: kw= Legend
                    {
                    kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleEndID1559); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLegendKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:700:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleEndID1578); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRightKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:707:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleEndID1597); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLeftKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:714:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleEndID1616); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCenterKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:721:2: kw= Endlegend
                    {
                    kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleEndID1635); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:728:2: kw= Alt
                    {
                    kw=(Token)match(input,Alt,FOLLOW_Alt_in_ruleEndID1654); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getAltKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:735:2: kw= Else
                    {
                    kw=(Token)match(input,Else,FOLLOW_Else_in_ruleEndID1673); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getElseKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:742:2: kw= Newpage
                    {
                    kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleEndID1692); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:749:2: kw= Opt
                    {
                    kw=(Token)match(input,Opt,FOLLOW_Opt_in_ruleEndID1711); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOptKeyword_12()); 
                        

                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:756:2: kw= Loop
                    {
                    kw=(Token)match(input,Loop,FOLLOW_Loop_in_ruleEndID1730); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLoopKeyword_13()); 
                        

                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:763:2: kw= Par
                    {
                    kw=(Token)match(input,Par,FOLLOW_Par_in_ruleEndID1749); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getParKeyword_14()); 
                        

                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:770:2: kw= Break
                    {
                    kw=(Token)match(input,Break,FOLLOW_Break_in_ruleEndID1768); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getBreakKeyword_15()); 
                        

                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:777:2: kw= Critical
                    {
                    kw=(Token)match(input,Critical,FOLLOW_Critical_in_ruleEndID1787); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 
                        

                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:784:2: kw= Group
                    {
                    kw=(Token)match(input,Group,FOLLOW_Group_in_ruleEndID1806); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getGroupKeyword_17()); 
                        

                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:791:2: kw= Note
                    {
                    kw=(Token)match(input,Note,FOLLOW_Note_in_ruleEndID1825); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNoteKeyword_18()); 
                        

                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:798:2: kw= Over
                    {
                    kw=(Token)match(input,Over,FOLLOW_Over_in_ruleEndID1844); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOverKeyword_19()); 
                        

                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:805:2: kw= Of
                    {
                    kw=(Token)match(input,Of,FOLLOW_Of_in_ruleEndID1863); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getOfKeyword_20()); 
                        

                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:812:2: kw= Ref
                    {
                    kw=(Token)match(input,Ref,FOLLOW_Ref_in_ruleEndID1882); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRefKeyword_21()); 
                        

                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:819:2: kw= Hide
                    {
                    kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleEndID1901); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getHideKeyword_22()); 
                        

                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:826:2: kw= Footbox
                    {
                    kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleEndID1920); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 
                        

                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:833:2: kw= Activate
                    {
                    kw=(Token)match(input,Activate,FOLLOW_Activate_in_ruleEndID1939); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getActivateKeyword_24()); 
                        

                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:840:2: kw= Deactivate
                    {
                    kw=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleEndID1958); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 
                        

                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:847:2: kw= Destroy
                    {
                    kw=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleEndID1977); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 
                        

                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:854:2: kw= Box
                    {
                    kw=(Token)match(input,Box,FOLLOW_Box_in_ruleEndID1996); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getBoxKeyword_27()); 
                        

                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:861:2: kw= NumberSign
                    {
                    kw=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleEndID2015); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 
                        

                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:868:2: kw= Comma
                    {
                    kw=(Token)match(input,Comma,FOLLOW_Comma_in_ruleEndID2034); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getCommaKeyword_29()); 
                        

                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:875:2: kw= LeftParenthesis
                    {
                    kw=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleEndID2053); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 
                        

                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:882:2: kw= RightParenthesis
                    {
                    kw=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleEndID2072); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 
                        

                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:889:2: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleEndID2091); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 
                        

                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:895:10: this_INT_33= RULE_INT
                    {
                    this_INT_33=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEndID2112); 

                    		current.merge(this_INT_33);
                        
                     
                        newLeafNode(this_INT_33, grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 
                        

                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:904:2: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_HyphenMinus_in_ruleEndID2136); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 
                        

                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:911:2: kw= FullStop
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleEndID2155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 
                        

                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:918:2: kw= Colon
                    {
                    kw=(Token)match(input,Colon,FOLLOW_Colon_in_ruleEndID2174); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getColonKeyword_36()); 
                        

                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:925:2: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_ruleEndID2193); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 
                        

                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:932:2: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_ruleEndID2212); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEndIDAccess().getLessThanSignKeyword_38()); 
                        

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
    // $ANTLR end "ruleEndID"


    // $ANTLR start "entryRuleMyID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:945:1: entryRuleMyID returns [String current=null] : iv_ruleMyID= ruleMyID EOF ;
    public final String entryRuleMyID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMyID = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:946:1: (iv_ruleMyID= ruleMyID EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:947:2: iv_ruleMyID= ruleMyID EOF
            {
             newCompositeNode(grammarAccess.getMyIDRule()); 
            pushFollow(FOLLOW_ruleMyID_in_entryRuleMyID2252);
            iv_ruleMyID=ruleMyID();

            state._fsp--;

             current =iv_ruleMyID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMyID2263); 

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
    // $ANTLR end "entryRuleMyID"


    // $ANTLR start "ruleMyID"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:954:1: ruleMyID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EndID_0= ruleEndID | kw= End ) ;
    public final AntlrDatatypeRuleToken ruleMyID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EndID_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:958:6: ( (this_EndID_0= ruleEndID | kw= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:959:1: (this_EndID_0= ruleEndID | kw= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:959:1: (this_EndID_0= ruleEndID | kw= End )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=Autonumber && LA14_0<=Activate)||LA14_0==Critical||(LA14_0>=Destroy && LA14_0<=Create)||LA14_0==Legend||(LA14_0>=Break && LA14_0<=Over)||(LA14_0>=Alt && LA14_0<=Box)||(LA14_0>=Opt && LA14_0<=Ref)||LA14_0==Of||(LA14_0>=NumberSign && LA14_0<=GreaterThanSign)||(LA14_0>=RULE_INT && LA14_0<=RULE_ID)) ) {
                alt14=1;
            }
            else if ( (LA14_0==End) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:960:5: this_EndID_0= ruleEndID
                    {
                     
                            newCompositeNode(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEndID_in_ruleMyID2310);
                    this_EndID_0=ruleEndID();

                    state._fsp--;


                    		current.merge(this_EndID_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:972:2: kw= End
                    {
                    kw=(Token)match(input,End,FOLLOW_End_in_ruleMyID2334); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMyIDAccess().getEndKeyword_1()); 
                        

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
    // $ANTLR end "ruleMyID"


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:985:1: entryRuleAutoNumber returns [String current=null] : iv_ruleAutoNumber= ruleAutoNumber EOF ;
    public final String entryRuleAutoNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAutoNumber = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:986:1: (iv_ruleAutoNumber= ruleAutoNumber EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:987:2: iv_ruleAutoNumber= ruleAutoNumber EOF
            {
             newCompositeNode(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2374);
            iv_ruleAutoNumber=ruleAutoNumber();

            state._fsp--;

             current =iv_ruleAutoNumber.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber2385); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:994:1: ruleAutoNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) ;
    public final AntlrDatatypeRuleToken ruleAutoNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:998:6: ( (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:999:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:999:1: (kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1000:2: kw= Autonumber (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            {
            kw=(Token)match(input,Autonumber,FOLLOW_Autonumber_in_ruleAutoNumber2423); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1005:1: (this_INT_1= RULE_INT (this_INT_2= RULE_INT )? )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_INT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1005:6: this_INT_1= RULE_INT (this_INT_2= RULE_INT )?
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2439); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1012:1: (this_INT_2= RULE_INT )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_INT) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1012:6: this_INT_2= RULE_INT
                            {
                            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleAutoNumber2460); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1027:1: entryRuleTitle returns [String current=null] : iv_ruleTitle= ruleTitle EOF ;
    public final String entryRuleTitle() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTitle = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1028:1: (iv_ruleTitle= ruleTitle EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1029:2: iv_ruleTitle= ruleTitle EOF
            {
             newCompositeNode(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle2509);
            iv_ruleTitle=ruleTitle();

            state._fsp--;

             current =iv_ruleTitle.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle2520); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1036:1: ruleTitle returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Title (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleTitle() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1040:6: ( (kw= Title (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1041:1: (kw= Title (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1041:1: (kw= Title (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1042:2: kw= Title (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Title,FOLLOW_Title_in_ruleTitle2558); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTitleAccess().getTitleKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1047:1: (this_ID_1= RULE_ID )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1047:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTitle2574); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            	        

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
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleLegend"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1062:1: entryRuleLegend returns [String current=null] : iv_ruleLegend= ruleLegend EOF ;
    public final String entryRuleLegend() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLegend = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1063:1: (iv_ruleLegend= ruleLegend EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1064:2: iv_ruleLegend= ruleLegend EOF
            {
             newCompositeNode(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend2621);
            iv_ruleLegend=ruleLegend();

            state._fsp--;

             current =iv_ruleLegend.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend2632); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1071:1: ruleLegend returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) ;
    public final AntlrDatatypeRuleToken ruleLegend() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_NEWLINE_4=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1075:6: ( (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1076:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1076:1: (kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1077:2: kw= Legend (kw= Right | kw= Left | kw= Center )? (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )* kw= Endlegend
            {
            kw=(Token)match(input,Legend,FOLLOW_Legend_in_ruleLegend2670); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getLegendAccess().getLegendKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1082:1: (kw= Right | kw= Left | kw= Center )?
            int alt18=4;
            switch ( input.LA(1) ) {
                case Right:
                    {
                    alt18=1;
                    }
                    break;
                case Left:
                    {
                    alt18=2;
                    }
                    break;
                case Center:
                    {
                    alt18=3;
                    }
                    break;
            }

            switch (alt18) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1083:2: kw= Right
                    {
                    kw=(Token)match(input,Right,FOLLOW_Right_in_ruleLegend2684); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1090:2: kw= Left
                    {
                    kw=(Token)match(input,Left,FOLLOW_Left_in_ruleLegend2703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1097:2: kw= Center
                    {
                    kw=(Token)match(input,Center,FOLLOW_Center_in_ruleLegend2722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1102:3: (this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )* )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_NEWLINE) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1102:8: this_NEWLINE_4= RULE_NEWLINE (this_ID_5= RULE_ID )*
            	    {
            	    this_NEWLINE_4=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleLegend2740); 

            	    		current.merge(this_NEWLINE_4);
            	        
            	     
            	        newLeafNode(this_NEWLINE_4, grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1109:1: (this_ID_5= RULE_ID )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==RULE_ID) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1109:6: this_ID_5= RULE_ID
            	    	    {
            	    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLegend2761); 

            	    	    		current.merge(this_ID_5);
            	    	        
            	    	     
            	    	        newLeafNode(this_ID_5, grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop19;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            kw=(Token)match(input,Endlegend,FOLLOW_Endlegend_in_ruleLegend2783); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1130:1: entryRuleNewpage returns [String current=null] : iv_ruleNewpage= ruleNewpage EOF ;
    public final String entryRuleNewpage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNewpage = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1131:1: (iv_ruleNewpage= ruleNewpage EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1132:2: iv_ruleNewpage= ruleNewpage EOF
            {
             newCompositeNode(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage2823);
            iv_ruleNewpage=ruleNewpage();

            state._fsp--;

             current =iv_ruleNewpage.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage2834); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1139:1: ruleNewpage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Newpage (this_ID_1= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNewpage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1143:6: ( (kw= Newpage (this_ID_1= RULE_ID )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1144:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1144:1: (kw= Newpage (this_ID_1= RULE_ID )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1145:2: kw= Newpage (this_ID_1= RULE_ID )*
            {
            kw=(Token)match(input,Newpage,FOLLOW_Newpage_in_ruleNewpage2872); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1150:1: (this_ID_1= RULE_ID )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1150:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNewpage2888); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1165:1: entryRuleAltElse returns [EObject current=null] : iv_ruleAltElse= ruleAltElse EOF ;
    public final EObject entryRuleAltElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAltElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1166:2: (iv_ruleAltElse= ruleAltElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1167:2: iv_ruleAltElse= ruleAltElse EOF
            {
             newCompositeNode(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse2934);
            iv_ruleAltElse=ruleAltElse();

            state._fsp--;

             current =iv_ruleAltElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse2944); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1174:1: ruleAltElse returns [EObject current=null] : (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) ;
    public final EObject ruleAltElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_2=null;
        Token otherlv_5=null;
        EObject lv_instructions_3_0 = null;

        EObject lv_elses_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1177:28: ( (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1178:1: (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1178:1: (otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1179:2: otherlv_0= Alt ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ( (lv_elses_4_0= ruleElse ) )* otherlv_5= End
            {
            otherlv_0=(Token)match(input,Alt,FOLLOW_Alt_in_ruleAltElse2982); 

                	newLeafNode(otherlv_0, grammarAccess.getAltElseAccess().getAltKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1183:1: ( ruleMyID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=Autonumber && LA22_0<=Activate)||LA22_0==Critical||(LA22_0>=Destroy && LA22_0<=Create)||LA22_0==Legend||(LA22_0>=Break && LA22_0<=Over)||(LA22_0>=Alt && LA22_0<=Ref)||LA22_0==Of||(LA22_0>=NumberSign && LA22_0<=GreaterThanSign)||(LA22_0>=RULE_INT && LA22_0<=RULE_ID)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1184:5: ruleMyID
            	    {
            	     
            	            newCompositeNode(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleMyID_in_ruleAltElse2998);
            	    ruleMyID();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleAltElse3010); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1195:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop23:
            do {
                int alt23=2;
                switch ( input.LA(1) ) {
                case Else:
                    {
                    int LA23_1 = input.LA(2);

                    if ( (LA23_1==RULE_SEQUENCE) ) {
                        alt23=1;
                    }


                    }
                    break;
                case End:
                    {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==RULE_SEQUENCE) ) {
                        alt23=1;
                    }


                    }
                    break;
                case Participant:
                case Autonumber:
                case Deactivate:
                case Endlegend:
                case Activate:
                case Boundary:
                case Critical:
                case Database:
                case Control:
                case Destroy:
                case Footbox:
                case Newpage:
                case Center:
                case Create:
                case Entity:
                case Legend:
                case Actor:
                case Break:
                case Group:
                case Right:
                case Title:
                case Hide:
                case Left:
                case Loop:
                case Note:
                case Over:
                case FullStopFullStopFullStop:
                case Alt:
                case Box:
                case Opt:
                case Par:
                case Ref:
                case VerticalLineVerticalLineVerticalLine:
                case EqualsSignEqualsSign:
                case Of:
                case VerticalLineVerticalLine:
                case NumberSign:
                case LeftParenthesis:
                case RightParenthesis:
                case Comma:
                case HyphenMinus:
                case FullStop:
                case Colon:
                case LessThanSign:
                case EqualsSign:
                case GreaterThanSign:
                case RULE_NEWLINE:
                case RULE_INT:
                case RULE_ID:
                    {
                    alt23=1;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1196:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1196:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1197:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleAltElse3030);
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
            	    break loop23;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1213:3: ( (lv_elses_4_0= ruleElse ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==Else) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1214:1: (lv_elses_4_0= ruleElse )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1214:1: (lv_elses_4_0= ruleElse )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1215:3: lv_elses_4_0= ruleElse
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleElse_in_ruleAltElse3052);
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
            	    break loop24;
                }
            } while (true);

            otherlv_5=(Token)match(input,End,FOLLOW_End_in_ruleAltElse3066); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1244:1: entryRuleElse returns [EObject current=null] : iv_ruleElse= ruleElse EOF ;
    public final EObject entryRuleElse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElse = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1245:2: (iv_ruleElse= ruleElse EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1246:2: iv_ruleElse= ruleElse EOF
            {
             newCompositeNode(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse3100);
            iv_ruleElse=ruleElse();

            state._fsp--;

             current =iv_ruleElse; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse3110); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1253:1: ruleElse returns [EObject current=null] : (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) ;
    public final EObject ruleElse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_NEWLINE_2=null;
        EObject lv_instructions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1256:28: ( (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1257:1: (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1257:1: (otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1258:2: otherlv_0= Else ( ruleMyID )* this_NEWLINE_2= RULE_NEWLINE ( (lv_instructions_3_0= ruleInstruction ) )*
            {
            otherlv_0=(Token)match(input,Else,FOLLOW_Else_in_ruleElse3148); 

                	newLeafNode(otherlv_0, grammarAccess.getElseAccess().getElseKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1262:1: ( ruleMyID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=Autonumber && LA25_0<=Activate)||LA25_0==Critical||(LA25_0>=Destroy && LA25_0<=Create)||LA25_0==Legend||(LA25_0>=Break && LA25_0<=Over)||(LA25_0>=Alt && LA25_0<=Ref)||LA25_0==Of||(LA25_0>=NumberSign && LA25_0<=GreaterThanSign)||(LA25_0>=RULE_INT && LA25_0<=RULE_ID)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1263:5: ruleMyID
            	    {
            	     
            	            newCompositeNode(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 
            	        
            	    pushFollow(FOLLOW_ruleMyID_in_ruleElse3164);
            	    ruleMyID();

            	    state._fsp--;


            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleElse3176); 
             
                newLeafNode(this_NEWLINE_2, grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1274:1: ( (lv_instructions_3_0= ruleInstruction ) )*
            loop26:
            do {
                int alt26=2;
                switch ( input.LA(1) ) {
                case End:
                    {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==RULE_SEQUENCE) ) {
                        alt26=1;
                    }


                    }
                    break;
                case Else:
                    {
                    int LA26_2 = input.LA(2);

                    if ( (LA26_2==RULE_SEQUENCE) ) {
                        alt26=1;
                    }


                    }
                    break;
                case Participant:
                case Autonumber:
                case Deactivate:
                case Endlegend:
                case Activate:
                case Boundary:
                case Critical:
                case Database:
                case Control:
                case Destroy:
                case Footbox:
                case Newpage:
                case Center:
                case Create:
                case Entity:
                case Legend:
                case Actor:
                case Break:
                case Group:
                case Right:
                case Title:
                case Hide:
                case Left:
                case Loop:
                case Note:
                case Over:
                case FullStopFullStopFullStop:
                case Alt:
                case Box:
                case Opt:
                case Par:
                case Ref:
                case VerticalLineVerticalLineVerticalLine:
                case EqualsSignEqualsSign:
                case Of:
                case VerticalLineVerticalLine:
                case NumberSign:
                case LeftParenthesis:
                case RightParenthesis:
                case Comma:
                case HyphenMinus:
                case FullStop:
                case Colon:
                case LessThanSign:
                case EqualsSign:
                case GreaterThanSign:
                case RULE_NEWLINE:
                case RULE_INT:
                case RULE_ID:
                    {
                    alt26=1;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1275:1: (lv_instructions_3_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1275:1: (lv_instructions_3_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1276:3: lv_instructions_3_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleElse3196);
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
            	    break loop26;
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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1300:1: entryRuleGroupingMessages returns [EObject current=null] : iv_ruleGroupingMessages= ruleGroupingMessages EOF ;
    public final EObject entryRuleGroupingMessages() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroupingMessages = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1301:2: (iv_ruleGroupingMessages= ruleGroupingMessages EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1302:2: iv_ruleGroupingMessages= ruleGroupingMessages EOF
            {
             newCompositeNode(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages3232);
            iv_ruleGroupingMessages=ruleGroupingMessages();

            state._fsp--;

             current =iv_ruleGroupingMessages; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages3242); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1309:1: ruleGroupingMessages returns [EObject current=null] : ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1312:28: ( ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1313:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1313:1: ( (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1313:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group ) (this_ID_6= RULE_ID )* this_NEWLINE_7= RULE_NEWLINE ( (lv_instructions_8_0= ruleInstruction ) )* otherlv_9= End
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1313:2: (otherlv_0= Opt | otherlv_1= Loop | otherlv_2= Par | otherlv_3= Break | otherlv_4= Critical | otherlv_5= Group )
            int alt27=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt27=1;
                }
                break;
            case Loop:
                {
                alt27=2;
                }
                break;
            case Par:
                {
                alt27=3;
                }
                break;
            case Break:
                {
                alt27=4;
                }
                break;
            case Critical:
                {
                alt27=5;
                }
                break;
            case Group:
                {
                alt27=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1314:2: otherlv_0= Opt
                    {
                    otherlv_0=(Token)match(input,Opt,FOLLOW_Opt_in_ruleGroupingMessages3281); 

                        	newLeafNode(otherlv_0, grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1320:2: otherlv_1= Loop
                    {
                    otherlv_1=(Token)match(input,Loop,FOLLOW_Loop_in_ruleGroupingMessages3299); 

                        	newLeafNode(otherlv_1, grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1326:2: otherlv_2= Par
                    {
                    otherlv_2=(Token)match(input,Par,FOLLOW_Par_in_ruleGroupingMessages3317); 

                        	newLeafNode(otherlv_2, grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2());
                        

                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1332:2: otherlv_3= Break
                    {
                    otherlv_3=(Token)match(input,Break,FOLLOW_Break_in_ruleGroupingMessages3335); 

                        	newLeafNode(otherlv_3, grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3());
                        

                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1338:2: otherlv_4= Critical
                    {
                    otherlv_4=(Token)match(input,Critical,FOLLOW_Critical_in_ruleGroupingMessages3353); 

                        	newLeafNode(otherlv_4, grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4());
                        

                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1344:2: otherlv_5= Group
                    {
                    otherlv_5=(Token)match(input,Group,FOLLOW_Group_in_ruleGroupingMessages3371); 

                        	newLeafNode(otherlv_5, grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1348:2: (this_ID_6= RULE_ID )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1348:3: this_ID_6= RULE_ID
            	    {
            	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGroupingMessages3383); 
            	     
            	        newLeafNode(this_ID_6, grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages3395); 
             
                newLeafNode(this_NEWLINE_7, grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1356:1: ( (lv_instructions_8_0= ruleInstruction ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==End) ) {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1==RULE_SEQUENCE) ) {
                        alt29=1;
                    }


                }
                else if ( ((LA29_0>=Participant && LA29_0<=Box)||(LA29_0>=Opt && LA29_0<=VerticalLineVerticalLineVerticalLine)||LA29_0==EqualsSignEqualsSign||(LA29_0>=Of && LA29_0<=VerticalLineVerticalLine)||(LA29_0>=NumberSign && LA29_0<=RULE_NEWLINE)||(LA29_0>=RULE_INT && LA29_0<=RULE_ID)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1357:1: (lv_instructions_8_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1357:1: (lv_instructions_8_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1358:3: lv_instructions_8_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleGroupingMessages3415);
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
            	    break loop29;
                }
            } while (true);

            otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleGroupingMessages3429); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1387:1: entryRuleNote returns [EObject current=null] : iv_ruleNote= ruleNote EOF ;
    public final EObject entryRuleNote() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNote = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1388:2: (iv_ruleNote= ruleNote EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1389:2: iv_ruleNote= ruleNote EOF
            {
             newCompositeNode(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote3463);
            iv_ruleNote=ruleNote();

            state._fsp--;

             current =iv_ruleNote; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote3473); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1396:1: ruleNote returns [EObject current=null] : (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) ) ;
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
        Token this_NEWLINE_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1399:28: ( (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1400:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1400:1: (otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1401:2: otherlv_0= Note ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) ) (this_COLOR_15= RULE_COLOR )* ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) )
            {
            otherlv_0=(Token)match(input,Note,FOLLOW_Note_in_ruleNote3511); 

                	newLeafNode(otherlv_0, grammarAccess.getNoteAccess().getNoteKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1405:1: ( (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? ) | (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? ) | (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt35=1;
                }
                break;
            case Left:
                {
                alt35=2;
                }
                break;
            case Over:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1405:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1405:2: (otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1406:2: otherlv_1= Right (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    {
                    otherlv_1=(Token)match(input,Right,FOLLOW_Right_in_ruleNote3525); 

                        	newLeafNode(otherlv_1, grammarAccess.getNoteAccess().getRightKeyword_1_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1410:1: (otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==Of) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1411:2: otherlv_2= Of ( (otherlv_3= RULE_ID ) ) (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            {
                            otherlv_2=(Token)match(input,Of,FOLLOW_Of_in_ruleNote3538); 

                                	newLeafNode(otherlv_2, grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1415:1: ( (otherlv_3= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1416:1: (otherlv_3= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1416:1: (otherlv_3= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1417:3: otherlv_3= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3557); 

                            		newLeafNode(otherlv_3, grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1428:2: (otherlv_4= Comma ( (otherlv_5= RULE_ID ) ) )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==Comma) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1429:2: otherlv_4= Comma ( (otherlv_5= RULE_ID ) )
                            	    {
                            	    otherlv_4=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3571); 

                            	        	newLeafNode(otherlv_4, grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1433:1: ( (otherlv_5= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1434:1: (otherlv_5= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1434:1: (otherlv_5= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1435:3: otherlv_5= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3590); 

                            	    		newLeafNode(otherlv_5, grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1447:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1447:6: (otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1448:2: otherlv_6= Left (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    {
                    otherlv_6=(Token)match(input,Left,FOLLOW_Left_in_ruleNote3615); 

                        	newLeafNode(otherlv_6, grammarAccess.getNoteAccess().getLeftKeyword_1_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1452:1: (otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )* )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==Of) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1453:2: otherlv_7= Of ( (otherlv_8= RULE_ID ) ) (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            {
                            otherlv_7=(Token)match(input,Of,FOLLOW_Of_in_ruleNote3628); 

                                	newLeafNode(otherlv_7, grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0());
                                
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1457:1: ( (otherlv_8= RULE_ID ) )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1458:1: (otherlv_8= RULE_ID )
                            {
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1458:1: (otherlv_8= RULE_ID )
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1459:3: otherlv_8= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getNoteRule());
                            	        }
                                    
                            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3647); 

                            		newLeafNode(otherlv_8, grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1470:2: (otherlv_9= Comma ( (otherlv_10= RULE_ID ) ) )*
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==Comma) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1471:2: otherlv_9= Comma ( (otherlv_10= RULE_ID ) )
                            	    {
                            	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3661); 

                            	        	newLeafNode(otherlv_9, grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0());
                            	        
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1475:1: ( (otherlv_10= RULE_ID ) )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1476:1: (otherlv_10= RULE_ID )
                            	    {
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1476:1: (otherlv_10= RULE_ID )
                            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1477:3: otherlv_10= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getNoteRule());
                            	    	        }
                            	            
                            	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3680); 

                            	    		newLeafNode(otherlv_10, grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop32;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1489:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1489:6: (otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1490:2: otherlv_11= Over ( (otherlv_12= RULE_ID ) ) (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    {
                    otherlv_11=(Token)match(input,Over,FOLLOW_Over_in_ruleNote3705); 

                        	newLeafNode(otherlv_11, grammarAccess.getNoteAccess().getOverKeyword_1_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1494:1: ( (otherlv_12= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1495:1: (otherlv_12= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1495:1: (otherlv_12= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1496:3: otherlv_12= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getNoteRule());
                    	        }
                            
                    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3724); 

                    		newLeafNode(otherlv_12, grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
                    	

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1507:2: (otherlv_13= Comma ( (otherlv_14= RULE_ID ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==Comma) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1508:2: otherlv_13= Comma ( (otherlv_14= RULE_ID ) )
                    	    {
                    	    otherlv_13=(Token)match(input,Comma,FOLLOW_Comma_in_ruleNote3738); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0());
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1512:1: ( (otherlv_14= RULE_ID ) )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1513:1: (otherlv_14= RULE_ID )
                    	    {
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1513:1: (otherlv_14= RULE_ID )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1514:3: otherlv_14= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getNoteRule());
                    	    	        }
                    	            
                    	    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNote3757); 

                    	    		newLeafNode(otherlv_14, grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1525:6: (this_COLOR_15= RULE_COLOR )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_COLOR) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1525:7: this_COLOR_15= RULE_COLOR
            	    {
            	    this_COLOR_15=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleNote3773); 
            	     
            	        newLeafNode(this_COLOR_15, grammarAccess.getNoteAccess().getCOLORTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1529:3: ( (otherlv_16= Colon ( ruleMyID )* ) | ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==Colon) ) {
                alt40=1;
            }
            else if ( (LA40_0==End||LA40_0==RULE_NEWLINE) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1529:4: (otherlv_16= Colon ( ruleMyID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1529:4: (otherlv_16= Colon ( ruleMyID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1530:2: otherlv_16= Colon ( ruleMyID )*
                    {
                    otherlv_16=(Token)match(input,Colon,FOLLOW_Colon_in_ruleNote3789); 

                        	newLeafNode(otherlv_16, grammarAccess.getNoteAccess().getColonKeyword_3_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1534:1: ( ruleMyID )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( ((LA37_0>=Autonumber && LA37_0<=Activate)||LA37_0==Critical||(LA37_0>=Destroy && LA37_0<=Create)||LA37_0==Legend||(LA37_0>=Break && LA37_0<=Over)||(LA37_0>=Alt && LA37_0<=Ref)||LA37_0==Of||(LA37_0>=NumberSign && LA37_0<=GreaterThanSign)||(LA37_0>=RULE_INT && LA37_0<=RULE_ID)) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1535:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleNote3805);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1543:6: ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1543:6: ( (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1543:7: (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )* otherlv_20= End otherlv_21= Note
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1543:7: (this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )* )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==RULE_NEWLINE) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1543:8: this_NEWLINE_18= RULE_NEWLINE ( ruleEndID )*
                    	    {
                    	    this_NEWLINE_18=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNote3826); 
                    	     
                    	        newLeafNode(this_NEWLINE_18, grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1547:1: ( ruleEndID )*
                    	    loop38:
                    	    do {
                    	        int alt38=2;
                    	        int LA38_0 = input.LA(1);

                    	        if ( ((LA38_0>=Autonumber && LA38_0<=Activate)||LA38_0==Critical||(LA38_0>=Destroy && LA38_0<=Create)||LA38_0==Legend||(LA38_0>=Break && LA38_0<=Over)||(LA38_0>=Alt && LA38_0<=Box)||(LA38_0>=Opt && LA38_0<=Ref)||LA38_0==Of||(LA38_0>=NumberSign && LA38_0<=GreaterThanSign)||(LA38_0>=RULE_INT && LA38_0<=RULE_ID)) ) {
                    	            alt38=1;
                    	        }


                    	        switch (alt38) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1548:5: ruleEndID
                    	    	    {
                    	    	     
                    	    	            newCompositeNode(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 
                    	    	        
                    	    	    pushFollow(FOLLOW_ruleEndID_in_ruleNote3842);
                    	    	    ruleEndID();

                    	    	    state._fsp--;


                    	    	            afterParserOrEnumRuleCall();
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop38;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,End,FOLLOW_End_in_ruleNote3858); 

                        	newLeafNode(otherlv_20, grammarAccess.getNoteAccess().getEndKeyword_3_1_1());
                        
                    otherlv_21=(Token)match(input,Note,FOLLOW_Note_in_ruleNote3870); 

                        	newLeafNode(otherlv_21, grammarAccess.getNoteAccess().getNoteKeyword_3_1_2());
                        

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1573:1: entryRuleDivider returns [String current=null] : iv_ruleDivider= ruleDivider EOF ;
    public final String entryRuleDivider() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDivider = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1574:1: (iv_ruleDivider= ruleDivider EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1575:2: iv_ruleDivider= ruleDivider EOF
            {
             newCompositeNode(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider3907);
            iv_ruleDivider=ruleDivider();

            state._fsp--;

             current =iv_ruleDivider.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider3918); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1582:1: ruleDivider returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleDivider() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1586:6: ( (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1587:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1587:1: (kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1588:2: kw= EqualsSignEqualsSign (this_ID_1= RULE_ID )* kw= EqualsSignEqualsSign
            {
            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider3956); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1593:1: (this_ID_1= RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1593:6: this_ID_1= RULE_ID
            	    {
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDivider3972); 

            	    		current.merge(this_ID_1);
            	        
            	     
            	        newLeafNode(this_ID_1, grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_ruleDivider3992); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1614:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1615:2: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1616:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference4031);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference4041); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1623:1: ruleReference returns [EObject current=null] : (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_NEWLINE_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1626:28: ( (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1627:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1627:1: (otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1628:2: otherlv_0= Ref otherlv_1= Over ( (otherlv_2= RULE_ID ) ) (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )* ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) )
            {
            otherlv_0=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference4079); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
                
            otherlv_1=(Token)match(input,Over,FOLLOW_Over_in_ruleReference4091); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAccess().getOverKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1637:1: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1638:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1638:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1639:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference4110); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            	

            }


            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1650:2: (otherlv_3= Comma ( (otherlv_4= RULE_ID ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1651:2: otherlv_3= Comma ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReference4124); 

            	        	newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1655:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1656:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1656:1: (otherlv_4= RULE_ID )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1657:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getReferenceRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference4143); 

            	    		newLeafNode(otherlv_4, grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1668:4: ( (otherlv_5= Colon ( ruleMyID )* ) | ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==Colon) ) {
                alt46=1;
            }
            else if ( (LA46_0==End||LA46_0==RULE_NEWLINE) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1668:5: (otherlv_5= Colon ( ruleMyID )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1668:5: (otherlv_5= Colon ( ruleMyID )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1669:2: otherlv_5= Colon ( ruleMyID )*
                    {
                    otherlv_5=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReference4160); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceAccess().getColonKeyword_4_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1673:1: ( ruleMyID )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( ((LA43_0>=Autonumber && LA43_0<=Activate)||LA43_0==Critical||(LA43_0>=Destroy && LA43_0<=Create)||LA43_0==Legend||(LA43_0>=Break && LA43_0<=Over)||(LA43_0>=Alt && LA43_0<=Ref)||LA43_0==Of||(LA43_0>=NumberSign && LA43_0<=GreaterThanSign)||(LA43_0>=RULE_INT && LA43_0<=RULE_ID)) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1674:5: ruleMyID
                    	    {
                    	     
                    	            newCompositeNode(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleMyID_in_ruleReference4176);
                    	    ruleMyID();

                    	    state._fsp--;


                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1682:6: ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1682:6: ( (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1682:7: (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )* otherlv_9= End otherlv_10= Ref
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1682:7: (this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )* )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_NEWLINE) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1682:8: this_NEWLINE_7= RULE_NEWLINE ( ruleEndID )*
                    	    {
                    	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleReference4197); 
                    	     
                    	        newLeafNode(this_NEWLINE_7, grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1686:1: ( ruleEndID )*
                    	    loop44:
                    	    do {
                    	        int alt44=2;
                    	        int LA44_0 = input.LA(1);

                    	        if ( ((LA44_0>=Autonumber && LA44_0<=Activate)||LA44_0==Critical||(LA44_0>=Destroy && LA44_0<=Create)||LA44_0==Legend||(LA44_0>=Break && LA44_0<=Over)||(LA44_0>=Alt && LA44_0<=Box)||(LA44_0>=Opt && LA44_0<=Ref)||LA44_0==Of||(LA44_0>=NumberSign && LA44_0<=GreaterThanSign)||(LA44_0>=RULE_INT && LA44_0<=RULE_ID)) ) {
                    	            alt44=1;
                    	        }


                    	        switch (alt44) {
                    	    	case 1 :
                    	    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1687:5: ruleEndID
                    	    	    {
                    	    	     
                    	    	            newCompositeNode(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 
                    	    	        
                    	    	    pushFollow(FOLLOW_ruleEndID_in_ruleReference4213);
                    	    	    ruleEndID();

                    	    	    state._fsp--;


                    	    	            afterParserOrEnumRuleCall();
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop44;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,End,FOLLOW_End_in_ruleReference4229); 

                        	newLeafNode(otherlv_9, grammarAccess.getReferenceAccess().getEndKeyword_4_1_1());
                        
                    otherlv_10=(Token)match(input,Ref,FOLLOW_Ref_in_ruleReference4241); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1712:1: entryRuleDelay returns [String current=null] : iv_ruleDelay= ruleDelay EOF ;
    public final String entryRuleDelay() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDelay = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1713:1: (iv_ruleDelay= ruleDelay EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1714:2: iv_ruleDelay= ruleDelay EOF
            {
             newCompositeNode(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay4278);
            iv_ruleDelay=ruleDelay();

            state._fsp--;

             current =iv_ruleDelay.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay4289); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1721:1: ruleDelay returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) ;
    public final AntlrDatatypeRuleToken ruleDelay() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1725:6: ( (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1726:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1726:1: (kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )? )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1727:2: kw= FullStopFullStopFullStop ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            {
            kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay4327); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1732:1: ( (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==FullStopFullStopFullStop||LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1732:2: (this_ID_1= RULE_ID )* kw= FullStopFullStopFullStop
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1732:2: (this_ID_1= RULE_ID )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==RULE_ID) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1732:7: this_ID_1= RULE_ID
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDelay4344); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    kw=(Token)match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_ruleDelay4364); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1753:1: entryRuleSpace returns [String current=null] : iv_ruleSpace= ruleSpace EOF ;
    public final String entryRuleSpace() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSpace = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1754:1: (iv_ruleSpace= ruleSpace EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1755:2: iv_ruleSpace= ruleSpace EOF
            {
             newCompositeNode(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace4406);
            iv_ruleSpace=ruleSpace();

            state._fsp--;

             current =iv_ruleSpace.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace4417); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1762:1: ruleSpace returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) ;
    public final AntlrDatatypeRuleToken ruleSpace() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1766:6: ( (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1767:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1767:1: (kw= VerticalLineVerticalLineVerticalLine | (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==VerticalLineVerticalLineVerticalLine) ) {
                alt49=1;
            }
            else if ( (LA49_0==VerticalLineVerticalLine) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1768:2: kw= VerticalLineVerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace4455); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1774:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1774:6: (kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1775:2: kw= VerticalLineVerticalLine this_INT_2= RULE_INT kw= VerticalLineVerticalLine
                    {
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace4475); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
                        
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpace4490); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_ruleSpace4508); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1801:1: entryRuleHidefootbox returns [String current=null] : iv_ruleHidefootbox= ruleHidefootbox EOF ;
    public final String entryRuleHidefootbox() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleHidefootbox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1802:1: (iv_ruleHidefootbox= ruleHidefootbox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1803:2: iv_ruleHidefootbox= ruleHidefootbox EOF
            {
             newCompositeNode(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox4549);
            iv_ruleHidefootbox=ruleHidefootbox();

            state._fsp--;

             current =iv_ruleHidefootbox.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox4560); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1810:1: ruleHidefootbox returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Hide kw= Footbox ) ;
    public final AntlrDatatypeRuleToken ruleHidefootbox() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1814:6: ( (kw= Hide kw= Footbox ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1815:1: (kw= Hide kw= Footbox )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1815:1: (kw= Hide kw= Footbox )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1816:2: kw= Hide kw= Footbox
            {
            kw=(Token)match(input,Hide,FOLLOW_Hide_in_ruleHidefootbox4598); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
                
            kw=(Token)match(input,Footbox,FOLLOW_Footbox_in_ruleHidefootbox4611); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1835:1: entryRuleActivate returns [EObject current=null] : iv_ruleActivate= ruleActivate EOF ;
    public final EObject entryRuleActivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1836:2: (iv_ruleActivate= ruleActivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1837:2: iv_ruleActivate= ruleActivate EOF
            {
             newCompositeNode(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate4650);
            iv_ruleActivate=ruleActivate();

            state._fsp--;

             current =iv_ruleActivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate4660); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1844:1: ruleActivate returns [EObject current=null] : (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleActivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_COLOR_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1847:28: ( (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1848:1: (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1848:1: (otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1849:2: otherlv_0= Activate (this_COLOR_1= RULE_COLOR )? ( (lv_name_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,Activate,FOLLOW_Activate_in_ruleActivate4698); 

                	newLeafNode(otherlv_0, grammarAccess.getActivateAccess().getActivateKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1853:1: (this_COLOR_1= RULE_COLOR )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_COLOR) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1853:2: this_COLOR_1= RULE_COLOR
                    {
                    this_COLOR_1=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleActivate4709); 
                     
                        newLeafNode(this_COLOR_1, grammarAccess.getActivateAccess().getCOLORTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1857:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1858:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1858:1: (lv_name_2_0= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1859:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleActivate4727); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1883:1: entryRuleDeactivate returns [EObject current=null] : iv_ruleDeactivate= ruleDeactivate EOF ;
    public final EObject entryRuleDeactivate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeactivate = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1884:2: (iv_ruleDeactivate= ruleDeactivate EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1885:2: iv_ruleDeactivate= ruleDeactivate EOF
            {
             newCompositeNode(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate4767);
            iv_ruleDeactivate=ruleDeactivate();

            state._fsp--;

             current =iv_ruleDeactivate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate4777); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1892:1: ruleDeactivate returns [EObject current=null] : ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleDeactivate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1895:28: ( ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1896:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1896:1: ( (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1896:2: (otherlv_0= Deactivate | otherlv_1= Destroy ) ( (otherlv_2= RULE_ID ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1896:2: (otherlv_0= Deactivate | otherlv_1= Destroy )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==Deactivate) ) {
                alt51=1;
            }
            else if ( (LA51_0==Destroy) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1897:2: otherlv_0= Deactivate
                    {
                    otherlv_0=(Token)match(input,Deactivate,FOLLOW_Deactivate_in_ruleDeactivate4816); 

                        	newLeafNode(otherlv_0, grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1903:2: otherlv_1= Destroy
                    {
                    otherlv_1=(Token)match(input,Destroy,FOLLOW_Destroy_in_ruleDeactivate4834); 

                        	newLeafNode(otherlv_1, grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1());
                        

                    }
                    break;

            }

            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1907:2: ( (otherlv_2= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1908:1: (otherlv_2= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1908:1: (otherlv_2= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1909:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getDeactivateRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeactivate4854); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1928:1: entryRuleParticipantCreation returns [String current=null] : iv_ruleParticipantCreation= ruleParticipantCreation EOF ;
    public final String entryRuleParticipantCreation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleParticipantCreation = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1929:1: (iv_ruleParticipantCreation= ruleParticipantCreation EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1930:2: iv_ruleParticipantCreation= ruleParticipantCreation EOF
            {
             newCompositeNode(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation4890);
            iv_ruleParticipantCreation=ruleParticipantCreation();

            state._fsp--;

             current =iv_ruleParticipantCreation.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation4901); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1937:1: ruleParticipantCreation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Create this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleParticipantCreation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1941:6: ( (kw= Create this_ID_1= RULE_ID ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1942:1: (kw= Create this_ID_1= RULE_ID )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1942:1: (kw= Create this_ID_1= RULE_ID )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1943:2: kw= Create this_ID_1= RULE_ID
            {
            kw=(Token)match(input,Create,FOLLOW_Create_in_ruleParticipantCreation4939); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
                
            this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParticipantCreation4954); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1963:1: entryRuleBox returns [EObject current=null] : iv_ruleBox= ruleBox EOF ;
    public final EObject entryRuleBox() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBox = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1964:2: (iv_ruleBox= ruleBox EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1965:2: iv_ruleBox= ruleBox EOF
            {
             newCompositeNode(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox4998);
            iv_ruleBox=ruleBox();

            state._fsp--;

             current =iv_ruleBox; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox5008); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1972:1: ruleBox returns [EObject current=null] : (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) ;
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
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1975:28: ( (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1976:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1976:1: (otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1977:2: otherlv_0= Box otherlv_1= QuotationMark (this_ID_2= RULE_ID )* otherlv_3= QuotationMark (this_COLOR_4= RULE_COLOR )? this_NEWLINE_5= RULE_NEWLINE ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )* otherlv_8= End otherlv_9= Box
            {
            otherlv_0=(Token)match(input,Box,FOLLOW_Box_in_ruleBox5046); 

                	newLeafNode(otherlv_0, grammarAccess.getBoxAccess().getBoxKeyword_0());
                
            otherlv_1=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox5058); 

                	newLeafNode(otherlv_1, grammarAccess.getBoxAccess().getQuotationMarkKeyword_1());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1986:1: (this_ID_2= RULE_ID )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1986:2: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBox5069); 
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            otherlv_3=(Token)match(input,QuotationMark,FOLLOW_QuotationMark_in_ruleBox5083); 

                	newLeafNode(otherlv_3, grammarAccess.getBoxAccess().getQuotationMarkKeyword_3());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1995:1: (this_COLOR_4= RULE_COLOR )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==RULE_COLOR) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:1995:2: this_COLOR_4= RULE_COLOR
                    {
                    this_COLOR_4=(Token)match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_ruleBox5094); 
                     
                        newLeafNode(this_COLOR_4, grammarAccess.getBoxAccess().getCOLORTerminalRuleCall_4()); 
                        

                    }
                    break;

            }

            this_NEWLINE_5=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox5106); 
             
                newLeafNode(this_NEWLINE_5, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2003:1: ( ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==Participant||LA55_0==Boundary||(LA55_0>=Database && LA55_0<=Control)||LA55_0==Entity||LA55_0==Actor||LA55_0==RULE_NEWLINE) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2003:2: ( (lv_definitions_6_0= ruleDefinition ) )? this_NEWLINE_7= RULE_NEWLINE
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2003:2: ( (lv_definitions_6_0= ruleDefinition ) )?
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==Participant||LA54_0==Boundary||(LA54_0>=Database && LA54_0<=Control)||LA54_0==Entity||LA54_0==Actor) ) {
            	        alt54=1;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2004:1: (lv_definitions_6_0= ruleDefinition )
            	            {
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2004:1: (lv_definitions_6_0= ruleDefinition )
            	            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantumlParser.g:2005:3: lv_definitions_6_0= ruleDefinition
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDefinition_in_ruleBox5127);
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

            	    this_NEWLINE_7=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleBox5139); 
            	     
            	        newLeafNode(this_NEWLINE_7, grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            otherlv_8=(Token)match(input,End,FOLLOW_End_in_ruleBox5153); 

                	newLeafNode(otherlv_8, grammarAccess.getBoxAccess().getEndKeyword_7());
                
            otherlv_9=(Token)match(input,Box,FOLLOW_Box_in_ruleBox5165); 

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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA5_eotS =
        "\47\uffff";
    static final String DFA5_eofS =
        "\47\uffff";
    static final String DFA5_minS =
        "\1\4\1\uffff\1\73\2\67\1\7\1\5\7\67\1\27\1\36\1\16\3\73\1\54\22"+
        "\uffff";
    static final String DFA5_maxS =
        "\1\73\1\uffff\17\76\1\77\3\76\22\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\23\uffff\1\2\1\12\1\14\1\15\1\23\1\21\1\3\1\4\1\5"+
        "\1\7\1\6\1\10\1\11\1\13\1\16\1\17\1\20\1\22";
    static final String DFA5_specialS =
        "\47\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\25\1\3\1\22\1\1\1\21\1\25\1\14\2\25\1\23\1\1\1\7\1\1\1\2"+
            "\1\25\1\5\1\25\1\13\1\15\1\1\1\4\1\1\1\20\1\1\1\11\1\16\1\1"+
            "\1\27\1\6\1\24\1\1\1\10\1\12\1\17\1\30\1\uffff\1\26\1\uffff"+
            "\1\1\1\30\1\uffff\12\1\1\31\2\uffff\2\1",
            "",
            "\1\32\2\uffff\1\1",
            "\1\33\2\uffff\1\33\3\uffff\1\1",
            "\1\34\3\uffff\1\34\2\uffff\1\1",
            "\1\35\10\uffff\1\35\6\uffff\1\35\3\uffff\1\35\33\uffff\1\35"+
            "\6\uffff\1\1",
            "\4\36\1\uffff\1\36\2\uffff\5\36\1\uffff\1\36\1\uffff\12\36"+
            "\1\uffff\6\36\4\uffff\1\36\2\uffff\13\36\2\uffff\2\36\2\uffff"+
            "\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\1",
            "\1\41\3\uffff\1\41\2\uffff\1\41\37\uffff\1\1",
            "\1\42\37\uffff\1\1",
            "\1\43\57\uffff\1\1",
            "\1\44\2\uffff\1\1\1\44",
            "\1\45\2\uffff\1\1",
            "\1\45\2\uffff\1\1",
            "\1\46\21\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "168:2: (this_Arrow_0= ruleArrow | (this_Definition_1= ruleDefinition (this_COLOR_2= RULE_COLOR | this_HEXCODE_3= RULE_HEXCODE )? ) | ruleAutoNumber | ruleTitle | ruleLegend | ruleNewpage | this_AltElse_8= ruleAltElse | this_GroupingMessages_9= ruleGroupingMessages | this_Note_10= ruleNote | ruleDivider | this_Reference_12= ruleReference | ruleDelay | ruleSpace | ruleHidefootbox | this_Activate_16= ruleActivate | this_Deactivate_17= ruleDeactivate | ruleParticipantCreation | this_Box_19= ruleBox )?";
        }
    }
    static final String DFA9_eotS =
        "\54\uffff";
    static final String DFA9_eofS =
        "\54\uffff";
    static final String DFA9_minS =
        "\2\5\1\uffff\50\5\1\uffff";
    static final String DFA9_maxS =
        "\2\73\1\uffff\47\73\1\100\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\50\uffff\1\1";
    static final String DFA9_specialS =
        "\54\uffff}>";
    static final String[] DFA9_transitionS = {
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\1\2\1\1\10\2\3\uffff\2"+
            "\2",
            "\1\5\1\34\1\13\1\33\1\uffff\1\23\2\uffff\1\35\1\32\1\16\1"+
            "\12\1\4\1\uffff\1\7\1\uffff\1\22\1\24\1\10\1\6\1\15\1\31\1\11"+
            "\1\20\1\25\1\26\1\uffff\1\14\1\36\1\uffff\1\17\1\21\1\30\3\uffff"+
            "\1\2\1\27\2\uffff\1\37\1\41\1\42\1\40\1\45\1\46\1\47\1\51\1"+
            "\43\1\50\3\uffff\1\44\1\3",
            "",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\3\2\1\52\6\2\3\uffff\2"+
            "\2",
            "\4\2\1\uffff\1\2\2\uffff\5\2\1\uffff\1\2\1\uffff\12\2\1\uffff"+
            "\2\2\1\uffff\3\2\3\uffff\2\2\2\uffff\12\2\3\uffff\2\2\3\uffff"+
            "\2\53",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "594:1: (otherlv_13= LeftParenthesis ruleEndID otherlv_15= Comma (this_COLOR_16= RULE_COLOR | this_HEXCODE_17= RULE_HEXCODE ) otherlv_18= RightParenthesis )?";
        }
    }
 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rulePlantuml122 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_ruleDiagram203 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram213 = new BitSet(new long[]{0x0EFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram233 = new BitSet(new long[]{0x0EFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_RULE_END_in_ruleDiagram245 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleDiagram256 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_ruleInstruction350 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction378 = new BitSet(new long[]{0x8080000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleInstruction389 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleInstruction405 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_ruleInstruction429 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleTitle_in_ruleInstruction450 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleLegend_in_ruleInstruction471 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleNewpage_in_ruleInstruction492 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleAltElse_in_ruleInstruction519 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_ruleInstruction546 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleNote_in_ruleInstruction573 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleDivider_in_ruleInstruction594 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleReference_in_ruleInstruction621 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleDelay_in_ruleInstruction642 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSpace_in_ruleInstruction663 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_ruleInstruction684 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleActivate_in_ruleInstruction711 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleDeactivate_in_ruleInstruction738 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_ruleInstruction759 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleBox_in_ruleInstruction786 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleInstruction798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow888 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_ruleArrow899 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow919 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleArrow933 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleArrow949 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_ruleDefinition1036 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_ruleDefinition1077 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_ruleDefinition1118 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_ruleDefinition1159 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_ruleDefinition1200 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_ruleDefinition1241 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleDefinition1261 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_ruleDefinition1275 = new BitSet(new long[]{0x0C7FE63B7FEBE5E0L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleDefinition1288 = new BitSet(new long[]{0x0C7FE43B7FEBE5E0L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1303 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleDefinition1315 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleDefinition1326 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_ruleDefinition1342 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleDefinition1355 = new BitSet(new long[]{0x0C7FE63B7FEBE5E0L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleDefinition1373 = new BitSet(new long[]{0x0C7FE63B7FEBE5E0L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_ruleDefinition1387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_entryRuleEndID1427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndID1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndID1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleEndID1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleEndID1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleEndID1540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleEndID1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_ruleEndID1578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_ruleEndID1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_ruleEndID1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_ruleEndID1635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleEndID1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleEndID1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleEndID1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleEndID1711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_ruleEndID1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_ruleEndID1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_ruleEndID1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_ruleEndID1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_ruleEndID1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleEndID1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_ruleEndID1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_ruleEndID1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleEndID1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleEndID1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_ruleEndID1920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleEndID1939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleEndID1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_ruleEndID1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleEndID1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleEndID2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_ruleEndID2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleEndID2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleEndID2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleEndID2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEndID2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_ruleEndID2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleEndID2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_ruleEndID2174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSign_in_ruleEndID2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSign_in_ruleEndID2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_entryRuleMyID2252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMyID2263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleMyID2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_ruleMyID2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber2374 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber2385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_ruleAutoNumber2423 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2439 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleAutoNumber2460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle2509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_ruleTitle2558 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTitle2574 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend2621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend2632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_ruleLegend2670 = new BitSet(new long[]{0x0080000008810080L});
    public static final BitSet FOLLOW_Right_in_ruleLegend2684 = new BitSet(new long[]{0x0080000000000080L});
    public static final BitSet FOLLOW_Left_in_ruleLegend2703 = new BitSet(new long[]{0x0080000000000080L});
    public static final BitSet FOLLOW_Center_in_ruleLegend2722 = new BitSet(new long[]{0x0080000000000080L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleLegend2740 = new BitSet(new long[]{0x0880000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLegend2761 = new BitSet(new long[]{0x0880000000000080L});
    public static final BitSet FOLLOW_Endlegend_in_ruleLegend2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage2823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_ruleNewpage2872 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNewpage2888 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse2934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse2944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_ruleAltElse2982 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleAltElse2998 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleAltElse3010 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleAltElse3030 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_ruleElse_in_ruleAltElse3052 = new BitSet(new long[]{0x0000000402000000L});
    public static final BitSet FOLLOW_End_in_ruleAltElse3066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse3100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_ruleElse3148 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleElse3164 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleElse3176 = new BitSet(new long[]{0x0CFFED7FFFFFFFF2L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleElse3196 = new BitSet(new long[]{0x0CFFED7FFFFFFFF2L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages3232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_ruleGroupingMessages3281 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_Loop_in_ruleGroupingMessages3299 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_Par_in_ruleGroupingMessages3317 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_Break_in_ruleGroupingMessages3335 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_Critical_in_ruleGroupingMessages3353 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_Group_in_ruleGroupingMessages3371 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGroupingMessages3383 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleGroupingMessages3395 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleGroupingMessages3415 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_End_in_ruleGroupingMessages3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote3463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_ruleNote3511 = new BitSet(new long[]{0x0000000048800000L});
    public static final BitSet FOLLOW_Right_in_ruleNote3525 = new BitSet(new long[]{0x8088040400000000L});
    public static final BitSet FOLLOW_Of_in_ruleNote3538 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3557 = new BitSet(new long[]{0x8089000400000000L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3571 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3590 = new BitSet(new long[]{0x8089000400000000L});
    public static final BitSet FOLLOW_Left_in_ruleNote3615 = new BitSet(new long[]{0x8088040400000000L});
    public static final BitSet FOLLOW_Of_in_ruleNote3628 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3647 = new BitSet(new long[]{0x8089000400000000L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3661 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3680 = new BitSet(new long[]{0x8089000400000000L});
    public static final BitSet FOLLOW_Over_in_ruleNote3705 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3724 = new BitSet(new long[]{0x8089000400000000L});
    public static final BitSet FOLLOW_Comma_in_ruleNote3738 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNote3757 = new BitSet(new long[]{0x8089000400000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleNote3773 = new BitSet(new long[]{0x8088000400000000L});
    public static final BitSet FOLLOW_Colon_in_ruleNote3789 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleNote3805 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNote3826 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleNote3842 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_End_in_ruleNote3858 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_Note_in_ruleNote3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider3907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider3956 = new BitSet(new long[]{0x0800010000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDivider3972 = new BitSet(new long[]{0x0800010000000000L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_ruleDivider3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference4031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference4041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_ruleReference4079 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Over_in_ruleReference4091 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference4110 = new BitSet(new long[]{0x0089000400000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReference4124 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference4143 = new BitSet(new long[]{0x0089000400000000L});
    public static final BitSet FOLLOW_Colon_in_ruleReference4160 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_ruleMyID_in_ruleReference4176 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleReference4197 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_ruleEndID_in_ruleReference4213 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_End_in_ruleReference4229 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Ref_in_ruleReference4241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay4278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay4327 = new BitSet(new long[]{0x0800000080000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDelay4344 = new BitSet(new long[]{0x0800000080000000L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_ruleDelay4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace4406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace4417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_ruleSpace4455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace4475 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpace4490 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_ruleSpace4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox4549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox4560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_ruleHidefootbox4598 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Footbox_in_ruleHidefootbox4611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate4650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate4660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_ruleActivate4698 = new BitSet(new long[]{0x8800000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleActivate4709 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleActivate4727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate4767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate4777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_ruleDeactivate4816 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_Destroy_in_ruleDeactivate4834 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeactivate4854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation4890 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation4901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_ruleParticipantCreation4939 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParticipantCreation4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox4998 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox5008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_ruleBox5046 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox5058 = new BitSet(new long[]{0x0800100000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBox5069 = new BitSet(new long[]{0x0800100000000000L});
    public static final BitSet FOLLOW_QuotationMark_in_ruleBox5083 = new BitSet(new long[]{0x8080000000000000L});
    public static final BitSet FOLLOW_RULE_COLOR_in_ruleBox5094 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox5106 = new BitSet(new long[]{0x0080000400141A10L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleBox5127 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleBox5139 = new BitSet(new long[]{0x0080000400141A10L});
    public static final BitSet FOLLOW_End_in_ruleBox5153 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Box_in_ruleBox5165 = new BitSet(new long[]{0x0000000000000002L});

}