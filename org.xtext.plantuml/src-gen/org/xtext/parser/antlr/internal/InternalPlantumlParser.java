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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ANY_OTHER", "'@startuml'", "'@enduml'", "':'", "'-'", "'>'", "'<'", "'x'", "'\\\\'", "'/'", "'\\\\\\\\'", "'o'", "'|'", "'.'", "'\\''", "'/\\''", "'\\'/'", "'actor'", "'boundary'", "'control'", "'entity'", "'database'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_ID=4;
    public static final int RULE_WS=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalPlantumlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPlantumlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPlantumlParser.tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g"; }



     	private PlantumlGrammarAccess grammarAccess;
     	
        public InternalPlantumlParser(TokenStream input, PlantumlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected PlantumlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:76:1: ruleModel returns [EObject current=null] : ( (lv_diagrams_0_0= ruleDiagram ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_diagrams_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:79:28: ( ( (lv_diagrams_0_0= ruleDiagram ) )* )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:80:1: ( (lv_diagrams_0_0= ruleDiagram ) )*
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:80:1: ( (lv_diagrams_0_0= ruleDiagram ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:81:1: (lv_diagrams_0_0= ruleDiagram )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:81:1: (lv_diagrams_0_0= ruleDiagram )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:82:3: lv_diagrams_0_0= ruleDiagram
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getDiagramsDiagramParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDiagram_in_ruleModel130);
            	    lv_diagrams_0_0=ruleDiagram();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDiagram"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:106:1: entryRuleDiagram returns [EObject current=null] : iv_ruleDiagram= ruleDiagram EOF ;
    public final EObject entryRuleDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiagram = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:107:2: (iv_ruleDiagram= ruleDiagram EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:108:2: iv_ruleDiagram= ruleDiagram EOF
            {
             newCompositeNode(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_ruleDiagram_in_entryRuleDiagram166);
            iv_ruleDiagram=ruleDiagram();

            state._fsp--;

             current =iv_ruleDiagram; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDiagram176); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:115:1: ruleDiagram returns [EObject current=null] : (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_instructions_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:118:28: ( (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:1: (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:1: (otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml' )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:119:3: otherlv_0= '@startuml' ( (lv_instructions_1_0= ruleInstruction ) )* otherlv_2= '@enduml'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleDiagram213); 

                	newLeafNode(otherlv_0, grammarAccess.getDiagramAccess().getStartumlKeyword_0());
                
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:123:1: ( (lv_instructions_1_0= ruleInstruction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID||(LA2_0>=24 && LA2_0<=25)||(LA2_0>=27 && LA2_0<=31)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:124:1: (lv_instructions_1_0= ruleInstruction )
            	    {
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:124:1: (lv_instructions_1_0= ruleInstruction )
            	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:125:3: lv_instructions_1_0= ruleInstruction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleInstruction_in_ruleDiagram234);
            	    lv_instructions_1_0=ruleInstruction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDiagramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"instructions",
            	            		lv_instructions_1_0, 
            	            		"Instruction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleDiagram247); 

                	newLeafNode(otherlv_2, grammarAccess.getDiagramAccess().getEndumlKeyword_2());
                

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:153:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:154:2: (iv_ruleInstruction= ruleInstruction EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:155:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction283);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction293); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:162:1: ruleInstruction returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )? ) | this_Comment_6= ruleComment | this_Definition_7= ruleDefinition ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token this_STRING_4=null;
        EObject this_Comment_5 = null;

        EObject this_Comment_6 = null;

        EObject this_Definition_7 = null;


         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:165:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )? ) | this_Comment_6= ruleComment | this_Definition_7= ruleDefinition ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )? ) | this_Comment_6= ruleComment | this_Definition_7= ruleDefinition )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )? ) | this_Comment_6= ruleComment | this_Definition_7= ruleDefinition )
            int alt5=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 24:
            case 25:
                {
                alt5=2;
                }
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:2: ( ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )? )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:2: ( ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )? )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:3: ( (lv_name_0_0= RULE_ID ) ) ruleSequence ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' this_STRING_4= RULE_STRING )? (this_Comment_5= ruleComment )?
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:166:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:167:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:167:1: (lv_name_0_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:168:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction336); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstructionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getSequenceParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleSequence_in_ruleInstruction357);
                    ruleSequence();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:192:1: ( (lv_name_2_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:193:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:193:1: (lv_name_2_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:194:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstruction373); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getInstructionAccess().getNameIDTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getInstructionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ID");
                    	    

                    }


                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:210:2: (otherlv_3= ':' this_STRING_4= RULE_STRING )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==13) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:210:4: otherlv_3= ':' this_STRING_4= RULE_STRING
                            {
                            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleInstruction391); 

                                	newLeafNode(otherlv_3, grammarAccess.getInstructionAccess().getColonKeyword_0_3_0());
                                
                            this_STRING_4=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleInstruction402); 
                             
                                newLeafNode(this_STRING_4, grammarAccess.getInstructionAccess().getSTRINGTerminalRuleCall_0_3_1()); 
                                

                            }
                            break;

                    }

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:218:3: (this_Comment_5= ruleComment )?
                    int alt4=2;
                    alt4 = dfa4.predict(input);
                    switch (alt4) {
                        case 1 :
                            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:219:5: this_Comment_5= ruleComment
                            {
                             
                                    newCompositeNode(grammarAccess.getInstructionAccess().getCommentParserRuleCall_0_4()); 
                                
                            pushFollow(FOLLOW_ruleComment_in_ruleInstruction426);
                            this_Comment_5=ruleComment();

                            state._fsp--;

                             
                                    current = this_Comment_5; 
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:229:5: this_Comment_6= ruleComment
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleComment_in_ruleInstruction456);
                    this_Comment_6=ruleComment();

                    state._fsp--;

                     
                            current = this_Comment_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:239:5: this_Definition_7= ruleDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDefinition_in_ruleInstruction483);
                    this_Definition_7=ruleDefinition();

                    state._fsp--;

                     
                            current = this_Definition_7; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleSequence"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:255:1: entryRuleSequence returns [String current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final String entryRuleSequence() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSequence = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:256:2: (iv_ruleSequence= ruleSequence EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:257:2: iv_ruleSequence= ruleSequence EOF
            {
             newCompositeNode(grammarAccess.getSequenceRule()); 
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence519);
            iv_ruleSequence=ruleSequence();

            state._fsp--;

             current =iv_ruleSequence.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence530); 

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
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:264:1: ruleSequence returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' ) ;
    public final AntlrDatatypeRuleToken ruleSequence() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:267:28: ( ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:268:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:268:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )
            int alt18=21;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:268:2: ( (kw= '-' )* kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:268:2: ( (kw= '-' )* kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:268:3: (kw= '-' )* kw= '-' kw= '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:268:3: (kw= '-' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==14) ) {
                            int LA6_1 = input.LA(2);

                            if ( (LA6_1==14) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:269:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence570); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence585); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_0_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence598); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:287:6: (kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:287:6: (kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:288:2: kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence619); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_1_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence632); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:299:1: (kw= '-' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:300:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence646); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:306:6: (kw= '-' kw= '>' kw= 'x' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:306:6: (kw= '-' kw= '>' kw= 'x' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:307:2: kw= '-' kw= '>' kw= 'x'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence669); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_2_0()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence682); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_2_1()); 
                        
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSequence695); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getXKeyword_2_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:325:6: (kw= 'x' kw= '<' kw= '-' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:325:6: (kw= 'x' kw= '<' kw= '-' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:326:2: kw= 'x' kw= '<' kw= '-'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleSequence716); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getXKeyword_3_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence729); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_3_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence742); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_3_2()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:344:6: ( (kw= '-' )* kw= '-' kw= '>' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:344:6: ( (kw= '-' )* kw= '-' kw= '>' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:344:7: (kw= '-' )* kw= '-' kw= '>' kw= '>'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:344:7: (kw= '-' )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==14) ) {
                            int LA8_1 = input.LA(2);

                            if ( (LA8_1==14) ) {
                                alt8=1;
                            }


                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:345:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence764); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_4_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence792); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_2()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence805); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_4_3()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:369:6: (kw= '<' kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:369:6: (kw= '<' kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:370:2: kw= '<' kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence826); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence839); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_5_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence852); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:387:1: (kw= '-' )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==14) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:388:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence866); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_5_3()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:6: ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:6: ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:7: (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:394:7: (kw= '-' )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==14) ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1==14) ) {
                                alt10=1;
                            }


                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:395:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence890); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence905); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_6_1()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence918); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_2()); 
                        
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleSequence931); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusKeyword_6_3()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:419:6: (kw= '/' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:419:6: (kw= '/' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:420:2: kw= '/' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence952); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_7_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence965); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:431:1: (kw= '-' )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==14) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:432:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence979); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_7_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:438:6: ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:438:6: ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:438:7: (kw= '-' )* kw= '-' kw= '\\\\\\\\'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:438:7: (kw= '-' )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==14) ) {
                            int LA12_1 = input.LA(2);

                            if ( (LA12_1==14) ) {
                                alt12=1;
                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:439:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1003); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1018); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_8_1()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1031); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_8_2()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:457:6: (kw= '/' kw= '/' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:457:6: (kw= '/' kw= '/' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:458:2: kw= '/' kw= '/' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1052); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_9_0()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1065); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_9_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1078); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:475:1: (kw= '-' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==14) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:476:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1092); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_9_3()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:482:6: ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:482:6: ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:482:7: (kw= '-' )* kw= '-' kw= '>' kw= 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:482:7: (kw= '-' )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==14) ) {
                            int LA14_1 = input.LA(2);

                            if ( (LA14_1==14) ) {
                                alt14=1;
                            }


                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:483:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1116); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1131); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_10_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1144); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_10_2()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1157); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_10_3()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:507:6: (kw= 'o' kw= '<' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:507:6: (kw= 'o' kw= '<' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:508:2: kw= 'o' kw= '<' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1178); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_11_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1191); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_11_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1204); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_2()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:525:1: (kw= '-' )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==14) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:526:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1218); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_11_3()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:532:6: ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:532:6: ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:532:7: (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o'
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:532:7: (kw= '-' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==14) ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1==14) ) {
                                int LA16_2 = input.LA(3);

                                if ( (LA16_2==14) ) {
                                    alt16=1;
                                }


                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:533:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1242); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_0()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1257); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1270); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_12_2()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1283); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_12_3()); 
                        
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleSequence1296); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getSolidusKeyword_12_4()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1309); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_12_5()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:569:6: (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:569:6: (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:570:2: kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )*
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1330); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_13_0()); 
                        
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleSequence1343); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getReverseSolidusReverseSolidusKeyword_13_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1356); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1369); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_3()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:593:1: (kw= '-' )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==14) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:594:2: kw= '-'
                    	    {
                    	    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1383); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_13_4()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:600:6: (kw= '<' kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:600:6: (kw= '<' kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:601:2: kw= '<' kw= '-' kw= '>'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1406); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_14_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1419); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_14_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1432); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_14_2()); 
                        

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:619:6: (kw= '<' kw= '-' kw= '>' kw= 'o' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:619:6: (kw= '<' kw= '-' kw= '>' kw= 'o' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:620:2: kw= '<' kw= '-' kw= '>' kw= 'o'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1453); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_15_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1466); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_15_1()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1479); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_15_2()); 
                        
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1492); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_15_3()); 
                        

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:644:6: (kw= 'o' kw= '<' kw= '-' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:644:6: (kw= 'o' kw= '<' kw= '-' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:645:2: kw= 'o' kw= '<' kw= '-' kw= '>'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleSequence1513); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getOKeyword_16_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1526); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_16_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1539); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_16_2()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1552); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_16_3()); 
                        

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:669:6: (kw= '<' kw= '|' kw= '-' kw= '-' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:669:6: (kw= '<' kw= '|' kw= '-' kw= '-' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:670:2: kw= '<' kw= '|' kw= '-' kw= '-'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleSequence1573); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getLessThanSignKeyword_17_0()); 
                        
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1586); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getVerticalLineKeyword_17_1()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1599); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_2()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1612); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_17_3()); 
                        

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:694:6: (kw= '-' kw= '-' kw= '|' kw= '>' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:694:6: (kw= '-' kw= '-' kw= '|' kw= '>' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:695:2: kw= '-' kw= '-' kw= '|' kw= '>'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1633); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_0()); 
                        
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleSequence1646); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getHyphenMinusKeyword_18_1()); 
                        
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleSequence1659); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getVerticalLineKeyword_18_2()); 
                        
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleSequence1672); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getGreaterThanSignKeyword_18_3()); 
                        

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:719:6: (kw= '.' kw= '.' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:719:6: (kw= '.' kw= '.' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:720:2: kw= '.' kw= '.'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleSequence1693); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_19_0()); 
                        
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleSequence1706); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_19_1()); 
                        

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:733:2: kw= '.'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleSequence1726); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSequenceAccess().getFullStopKeyword_20()); 
                        

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
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleComment"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:746:1: entryRuleComment returns [EObject current=null] : iv_ruleComment= ruleComment EOF ;
    public final EObject entryRuleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComment = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:747:2: (iv_ruleComment= ruleComment EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:748:2: iv_ruleComment= ruleComment EOF
            {
             newCompositeNode(grammarAccess.getCommentRule()); 
            pushFollow(FOLLOW_ruleComment_in_entryRuleComment1766);
            iv_ruleComment=ruleComment();

            state._fsp--;

             current =iv_ruleComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComment1776); 

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
    // $ANTLR end "entryRuleComment"


    // $ANTLR start "ruleComment"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:755:1: ruleComment returns [EObject current=null] : ( (otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\'' ) | (otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/' ) ) ;
    public final EObject ruleComment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_STRING_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_STRING_4=null;
        Token this_WS_5=null;
        Token lv_strings_6_0=null;
        Token this_WS_7=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:758:28: ( ( (otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\'' ) | (otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/' ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:759:1: ( (otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\'' ) | (otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/' ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:759:1: ( (otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\'' ) | (otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==24) ) {
                alt21=1;
            }
            else if ( (LA21_0==25) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:759:2: (otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\'' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:759:2: (otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\'' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:759:4: otherlv_0= '\\'' this_STRING_1= RULE_STRING otherlv_2= '\\''
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleComment1814); 

                        	newLeafNode(otherlv_0, grammarAccess.getCommentAccess().getApostropheKeyword_0_0());
                        
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleComment1825); 
                     
                        newLeafNode(this_STRING_1, grammarAccess.getCommentAccess().getSTRINGTerminalRuleCall_0_1()); 
                        
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleComment1836); 

                        	newLeafNode(otherlv_2, grammarAccess.getCommentAccess().getApostropheKeyword_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:772:6: (otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/' )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:772:6: (otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/' )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:772:8: otherlv_3= '/\\'' this_STRING_4= RULE_STRING (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )* (this_WS_7= RULE_WS )* otherlv_8= '\\'/'
                    {
                    otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleComment1856); 

                        	newLeafNode(otherlv_3, grammarAccess.getCommentAccess().getSolidusApostropheKeyword_1_0());
                        
                    this_STRING_4=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleComment1867); 
                     
                        newLeafNode(this_STRING_4, grammarAccess.getCommentAccess().getSTRINGTerminalRuleCall_1_1()); 
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:780:1: (this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_WS) ) {
                            int LA19_1 = input.LA(2);

                            if ( (LA19_1==RULE_STRING) ) {
                                alt19=1;
                            }


                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:780:2: this_WS_5= RULE_WS ( (lv_strings_6_0= RULE_STRING ) )
                    	    {
                    	    this_WS_5=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleComment1878); 
                    	     
                    	        newLeafNode(this_WS_5, grammarAccess.getCommentAccess().getWSTerminalRuleCall_1_2_0()); 
                    	        
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:784:1: ( (lv_strings_6_0= RULE_STRING ) )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:785:1: (lv_strings_6_0= RULE_STRING )
                    	    {
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:785:1: (lv_strings_6_0= RULE_STRING )
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:786:3: lv_strings_6_0= RULE_STRING
                    	    {
                    	    lv_strings_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleComment1894); 

                    	    			newLeafNode(lv_strings_6_0, grammarAccess.getCommentAccess().getStringsSTRINGTerminalRuleCall_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getCommentRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"strings",
                    	            		lv_strings_6_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:802:4: (this_WS_7= RULE_WS )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_WS) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:802:5: this_WS_7= RULE_WS
                    	    {
                    	    this_WS_7=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleComment1913); 
                    	     
                    	        newLeafNode(this_WS_7, grammarAccess.getCommentAccess().getWSTerminalRuleCall_1_3()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleComment1926); 

                        	newLeafNode(otherlv_8, grammarAccess.getCommentAccess().getApostropheSolidusKeyword_1_4());
                        

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
    // $ANTLR end "ruleComment"


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:818:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:819:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:820:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition1963);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition1973); 

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
    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:827:1: ruleDefinition returns [EObject current=null] : ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) ) ;
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

         enterRule(); 
            
        try {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:830:28: ( ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) ) )
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:831:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) )
            {
            // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:831:1: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ) | (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) ) | (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) ) | (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) ) | (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) ) )
            int alt22=5;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt22=1;
                }
                break;
            case 28:
                {
                alt22=2;
                }
                break;
            case 29:
                {
                alt22=3;
                }
                break;
            case 30:
                {
                alt22=4;
                }
                break;
            case 31:
                {
                alt22=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:831:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:831:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:831:4: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) )
                    {
                    otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleDefinition2011); 

                        	newLeafNode(otherlv_0, grammarAccess.getDefinitionAccess().getActorKeyword_0_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:835:1: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:836:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:836:1: (lv_name_1_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:837:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2028); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:854:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:854:6: (otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:854:8: otherlv_2= 'boundary' ( (lv_name_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleDefinition2053); 

                        	newLeafNode(otherlv_2, grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:858:1: ( (lv_name_3_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:859:1: (lv_name_3_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:859:1: (lv_name_3_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:860:3: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2070); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:877:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:877:6: (otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:877:8: otherlv_4= 'control' ( (lv_name_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,29,FOLLOW_29_in_ruleDefinition2095); 

                        	newLeafNode(otherlv_4, grammarAccess.getDefinitionAccess().getControlKeyword_2_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:881:1: ( (lv_name_5_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:882:1: (lv_name_5_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:882:1: (lv_name_5_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:883:3: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2112); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:900:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:900:6: (otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:900:8: otherlv_6= 'entity' ( (lv_name_7_0= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleDefinition2137); 

                        	newLeafNode(otherlv_6, grammarAccess.getDefinitionAccess().getEntityKeyword_3_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:904:1: ( (lv_name_7_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:905:1: (lv_name_7_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:905:1: (lv_name_7_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:906:3: lv_name_7_0= RULE_ID
                    {
                    lv_name_7_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2154); 

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
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:923:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:923:6: (otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:923:8: otherlv_8= 'database' ( (lv_name_9_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleDefinition2179); 

                        	newLeafNode(otherlv_8, grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0());
                        
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:927:1: ( (lv_name_9_0= RULE_ID ) )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:928:1: (lv_name_9_0= RULE_ID )
                    {
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:928:1: (lv_name_9_0= RULE_ID )
                    // ../org.xtext.plantuml/src-gen/org/xtext/parser/antlr/internal/InternalPlantuml.g:929:3: lv_name_9_0= RULE_ID
                    {
                    lv_name_9_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefinition2196); 

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

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA4_eotS =
        "\13\uffff";
    static final String DFA4_eofS =
        "\1\3\12\uffff";
    static final String DFA4_minS =
        "\1\4\2\5\1\uffff\1\30\1\6\1\uffff\1\5\1\uffff\2\6";
    static final String DFA4_maxS =
        "\1\37\2\5\1\uffff\1\30\1\32\1\uffff\1\32\1\uffff\2\32";
    static final String DFA4_acceptS =
        "\3\uffff\1\2\2\uffff\1\1\1\uffff\1\1\2\uffff";
    static final String DFA4_specialS =
        "\13\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\7\uffff\1\3\13\uffff\1\1\1\2\1\uffff\5\3",
            "\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\7\23\uffff\1\10",
            "",
            "\1\11\1\12\23\uffff\1\10",
            "",
            "\1\7\23\uffff\1\10",
            "\1\12\23\uffff\1\10"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "218:3: (this_Comment_5= ruleComment )?";
        }
    }
    static final String DFA18_eotS =
        "\43\uffff";
    static final String DFA18_eofS =
        "\6\uffff\1\23\1\26\3\uffff\1\35\14\uffff\1\26\3\uffff\1\40\1\uffff"+
        "\1\42\4\uffff";
    static final String DFA18_minS =
        "\3\16\1\uffff\1\16\1\20\2\4\1\16\2\uffff\1\4\4\uffff\1\16\7\uffff"+
        "\1\4\1\uffff\1\16\1\uffff\1\4\1\uffff\1\4\4\uffff";
    static final String DFA18_maxS =
        "\1\27\1\24\1\26\1\uffff\1\23\1\24\1\27\1\25\1\26\2\uffff\1\17\4"+
        "\uffff\1\16\7\uffff\1\25\1\uffff\1\24\1\uffff\1\25\1\uffff\1\17"+
        "\4\uffff";
    static final String DFA18_acceptS =
        "\3\uffff\1\4\5\uffff\1\7\1\11\1\uffff\1\22\1\6\1\10\1\12\1\uffff"+
        "\1\16\1\24\1\25\1\3\1\13\1\1\1\5\1\uffff\1\23\1\uffff\1\15\1\uffff"+
        "\1\2\1\uffff\1\20\1\17\1\21\1\14";
    static final String DFA18_specialS =
        "\43\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\1\uffff\1\2\1\3\1\uffff\1\4\1\uffff\1\5\1\uffff\1\6",
            "\1\10\1\7\2\uffff\1\11\1\uffff\1\12",
            "\1\13\1\uffff\1\15\5\uffff\1\14",
            "",
            "\1\16\4\uffff\1\17",
            "\1\20\3\uffff\1\21",
            "\1\23\22\uffff\1\22",
            "\1\26\12\uffff\1\27\1\uffff\1\24\3\uffff\1\25",
            "\1\32\1\30\2\uffff\1\11\1\33\1\12\1\uffff\1\31",
            "",
            "",
            "\1\35\11\uffff\1\35\1\34",
            "",
            "",
            "",
            "",
            "\1\36",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\26\12\uffff\1\27\5\uffff\1\25",
            "",
            "\1\32\1\30\2\uffff\1\11\1\33\1\12",
            "",
            "\1\40\20\uffff\1\37",
            "",
            "\1\42\11\uffff\1\42\1\41",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "268:1: ( ( (kw= '-' )* kw= '-' kw= '>' ) | (kw= '<' kw= '-' (kw= '-' )* ) | (kw= '-' kw= '>' kw= 'x' ) | (kw= 'x' kw= '<' kw= '-' ) | ( (kw= '-' )* kw= '-' kw= '>' kw= '>' ) | (kw= '<' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\' kw= '\\\\' ) | (kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '\\\\\\\\' ) | (kw= '/' kw= '/' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' (kw= '-' )* ) | ( (kw= '-' )* kw= '-' kw= '-' kw= '/' kw= '/' kw= 'o' ) | (kw= 'o' kw= '\\\\\\\\' kw= '-' kw= '-' (kw= '-' )* ) | (kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '-' kw= '>' kw= 'o' ) | (kw= 'o' kw= '<' kw= '-' kw= '>' ) | (kw= '<' kw= '|' kw= '-' kw= '-' ) | (kw= '-' kw= '-' kw= '|' kw= '>' ) | (kw= '.' kw= '.' ) | kw= '.' )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleDiagram213 = new BitSet(new long[]{0x00000000FB001010L});
    public static final BitSet FOLLOW_ruleInstruction_in_ruleDiagram234 = new BitSet(new long[]{0x00000000FB001010L});
    public static final BitSet FOLLOW_12_in_ruleDiagram247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction336 = new BitSet(new long[]{0x0000000000AB4000L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleInstruction357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstruction373 = new BitSet(new long[]{0x0000000003002002L});
    public static final BitSet FOLLOW_13_in_ruleInstruction391 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleInstruction402 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_ruleComment_in_ruleInstruction426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComment_in_ruleInstruction456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_ruleInstruction483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSequence570 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence585 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence619 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence632 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence646 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence669 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence682 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleSequence695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSequence716 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence729 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSequence764 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence779 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence792 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence826 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence839 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence852 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence866 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence890 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence905 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence918 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSequence931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSequence952 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence965 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence979 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1003 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1018 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSequence1052 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1065 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1078 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1092 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1116 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1131 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1144 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSequence1178 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence1191 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1204 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1218 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1242 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1257 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1270 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1283 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSequence1296 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSequence1330 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSequence1343 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1356 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1369 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1383 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_16_in_ruleSequence1406 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1419 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence1453 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1466 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1479 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleSequence1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSequence1513 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSequence1526 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1539 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSequence1573 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSequence1586 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1599 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSequence1633 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleSequence1646 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSequence1659 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSequence1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSequence1693 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSequence1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSequence1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComment_in_entryRuleComment1766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComment1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleComment1814 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleComment1825 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComment1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleComment1856 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleComment1867 = new BitSet(new long[]{0x0000000004000040L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleComment1878 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleComment1894 = new BitSet(new long[]{0x0000000004000040L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleComment1913 = new BitSet(new long[]{0x0000000004000040L});
    public static final BitSet FOLLOW_26_in_ruleComment1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition1963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleDefinition2011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleDefinition2053 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleDefinition2095 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleDefinition2137 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDefinition2179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition2196 = new BitSet(new long[]{0x0000000000000002L});

}