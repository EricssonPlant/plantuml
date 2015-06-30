package org.xtext.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.xtext.services.PlantumlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPlantumlParser extends AbstractInternalContentAssistParser {
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
    public String getGrammarFileName() { return "../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g"; }


     
     	private PlantumlGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("QuotationMark", "'\"'");
    		tokenNameToValue.put("NumberSign", "'#'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("HyphenMinus", "'-'");
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("Colon", "':'");
    		tokenNameToValue.put("LessThanSign", "'<'");
    		tokenNameToValue.put("EqualsSign", "'='");
    		tokenNameToValue.put("GreaterThanSign", "'>'");
    		tokenNameToValue.put("LessThanSignLessThanSign", "'<<'");
    		tokenNameToValue.put("EqualsSignEqualsSign", "'=='");
    		tokenNameToValue.put("GreaterThanSignGreaterThanSign", "'>>'");
    		tokenNameToValue.put("Of", "'of'");
    		tokenNameToValue.put("VerticalLineVerticalLine", "'||'");
    		tokenNameToValue.put("FullStopFullStopFullStop", "'...'");
    		tokenNameToValue.put("Alt", "'alt'");
    		tokenNameToValue.put("Box", "'box'");
    		tokenNameToValue.put("End", "'end'");
    		tokenNameToValue.put("Opt", "'opt'");
    		tokenNameToValue.put("Par", "'par'");
    		tokenNameToValue.put("Ref", "'ref'");
    		tokenNameToValue.put("VerticalLineVerticalLineVerticalLine", "'|||'");
    		tokenNameToValue.put("Else", "'else'");
    		tokenNameToValue.put("Hide", "'hide'");
    		tokenNameToValue.put("Left", "'left'");
    		tokenNameToValue.put("Loop", "'loop'");
    		tokenNameToValue.put("Note", "'note'");
    		tokenNameToValue.put("Over", "'over'");
    		tokenNameToValue.put("Actor", "'actor'");
    		tokenNameToValue.put("Break", "'break'");
    		tokenNameToValue.put("Group", "'group'");
    		tokenNameToValue.put("Right", "'right'");
    		tokenNameToValue.put("Title", "'title'");
    		tokenNameToValue.put("Center", "'center'");
    		tokenNameToValue.put("Create", "'create'");
    		tokenNameToValue.put("Entity", "'entity'");
    		tokenNameToValue.put("Legend", "'legend'");
    		tokenNameToValue.put("Control", "'control'");
    		tokenNameToValue.put("Destroy", "'destroy'");
    		tokenNameToValue.put("Footbox", "'footbox'");
    		tokenNameToValue.put("Newpage", "'newpage'");
    		tokenNameToValue.put("Activate", "'activate'");
    		tokenNameToValue.put("Boundary", "'boundary'");
    		tokenNameToValue.put("Critical", "'critical'");
    		tokenNameToValue.put("Database", "'database'");
    		tokenNameToValue.put("Endlegend", "'endlegend'");
    		tokenNameToValue.put("Autonumber", "'autonumber'");
    		tokenNameToValue.put("Deactivate", "'deactivate'");
    		tokenNameToValue.put("Participant", "'participant'");
     	}
     	
        public void setGrammarAccess(PlantumlGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRulePlantuml"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:114:1: entryRulePlantuml : rulePlantuml EOF ;
    public final void entryRulePlantuml() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:115:1: ( rulePlantuml EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:116:1: rulePlantuml EOF
            {
             before(grammarAccess.getPlantumlRule()); 
            pushFollow(FOLLOW_rulePlantuml_in_entryRulePlantuml54);
            rulePlantuml();

            state._fsp--;

             after(grammarAccess.getPlantumlRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlantuml61); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePlantuml"


    // $ANTLR start "rulePlantuml"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:123:1: rulePlantuml : ( ( rule__Plantuml__DiagramsAssignment )* ) ;
    public final void rulePlantuml() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:127:5: ( ( ( rule__Plantuml__DiagramsAssignment )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:128:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:128:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:129:1: ( rule__Plantuml__DiagramsAssignment )*
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsAssignment()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:130:1: ( rule__Plantuml__DiagramsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_START) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:130:2: rule__Plantuml__DiagramsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Plantuml__DiagramsAssignment_in_rulePlantuml91);
            	    rule__Plantuml__DiagramsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getPlantumlAccess().getDiagramsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePlantuml"


    // $ANTLR start "entryRuleDiagram"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:142:1: entryRuleDiagram : ruleDiagram EOF ;
    public final void entryRuleDiagram() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:143:1: ( ruleDiagram EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:144:1: ruleDiagram EOF
            {
             before(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_ruleDiagram_in_entryRuleDiagram119);
            ruleDiagram();

            state._fsp--;

             after(grammarAccess.getDiagramRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDiagram126); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDiagram"


    // $ANTLR start "ruleDiagram"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:151:1: ruleDiagram : ( ( rule__Diagram__Group__0 ) ) ;
    public final void ruleDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:155:5: ( ( ( rule__Diagram__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:156:1: ( ( rule__Diagram__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:156:1: ( ( rule__Diagram__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:157:1: ( rule__Diagram__Group__0 )
            {
             before(grammarAccess.getDiagramAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:158:1: ( rule__Diagram__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:158:2: rule__Diagram__Group__0
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0_in_ruleDiagram156);
            rule__Diagram__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDiagramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDiagram"


    // $ANTLR start "entryRuleInstruction"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:170:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:171:1: ( ruleInstruction EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:172:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_ruleInstruction_in_entryRuleInstruction183);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstruction190); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:179:1: ruleInstruction : ( ( rule__Instruction__Group__0 ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:183:5: ( ( ( rule__Instruction__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:184:1: ( ( rule__Instruction__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:184:1: ( ( rule__Instruction__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:185:1: ( rule__Instruction__Group__0 )
            {
             before(grammarAccess.getInstructionAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:186:1: ( rule__Instruction__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:186:2: rule__Instruction__Group__0
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0_in_ruleInstruction220);
            rule__Instruction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleArrow"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:198:1: entryRuleArrow : ruleArrow EOF ;
    public final void entryRuleArrow() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:199:1: ( ruleArrow EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:200:1: ruleArrow EOF
            {
             before(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_ruleArrow_in_entryRuleArrow247);
            ruleArrow();

            state._fsp--;

             after(grammarAccess.getArrowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrow254); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:207:1: ruleArrow : ( ( rule__Arrow__Group__0 ) ) ;
    public final void ruleArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:211:5: ( ( ( rule__Arrow__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:212:1: ( ( rule__Arrow__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:212:1: ( ( rule__Arrow__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:213:1: ( rule__Arrow__Group__0 )
            {
             before(grammarAccess.getArrowAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:214:1: ( rule__Arrow__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:214:2: rule__Arrow__Group__0
            {
            pushFollow(FOLLOW_rule__Arrow__Group__0_in_ruleArrow284);
            rule__Arrow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRuleDefinition"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:226:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:227:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:228:1: ruleDefinition EOF
            {
             before(grammarAccess.getDefinitionRule()); 
            pushFollow(FOLLOW_ruleDefinition_in_entryRuleDefinition311);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefinition318); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:235:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:239:5: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:240:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:240:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:241:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:242:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:242:2: rule__Definition__Alternatives
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_in_ruleDefinition348);
            rule__Definition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleEndID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:256:1: entryRuleEndID : ruleEndID EOF ;
    public final void entryRuleEndID() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:257:1: ( ruleEndID EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:258:1: ruleEndID EOF
            {
             before(grammarAccess.getEndIDRule()); 
            pushFollow(FOLLOW_ruleEndID_in_entryRuleEndID377);
            ruleEndID();

            state._fsp--;

             after(grammarAccess.getEndIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndID384); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEndID"


    // $ANTLR start "ruleEndID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:265:1: ruleEndID : ( ( rule__EndID__Alternatives ) ) ;
    public final void ruleEndID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:269:5: ( ( ( rule__EndID__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:270:1: ( ( rule__EndID__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:270:1: ( ( rule__EndID__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:271:1: ( rule__EndID__Alternatives )
            {
             before(grammarAccess.getEndIDAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:272:1: ( rule__EndID__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:272:2: rule__EndID__Alternatives
            {
            pushFollow(FOLLOW_rule__EndID__Alternatives_in_ruleEndID414);
            rule__EndID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEndIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEndID"


    // $ANTLR start "entryRuleMyID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:284:1: entryRuleMyID : ruleMyID EOF ;
    public final void entryRuleMyID() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:285:1: ( ruleMyID EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:286:1: ruleMyID EOF
            {
             before(grammarAccess.getMyIDRule()); 
            pushFollow(FOLLOW_ruleMyID_in_entryRuleMyID441);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getMyIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMyID448); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMyID"


    // $ANTLR start "ruleMyID"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:293:1: ruleMyID : ( ( rule__MyID__Alternatives ) ) ;
    public final void ruleMyID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:297:5: ( ( ( rule__MyID__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:298:1: ( ( rule__MyID__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:298:1: ( ( rule__MyID__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:299:1: ( rule__MyID__Alternatives )
            {
             before(grammarAccess.getMyIDAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:300:1: ( rule__MyID__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:300:2: rule__MyID__Alternatives
            {
            pushFollow(FOLLOW_rule__MyID__Alternatives_in_ruleMyID478);
            rule__MyID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMyIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMyID"


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:312:1: entryRuleAutoNumber : ruleAutoNumber EOF ;
    public final void entryRuleAutoNumber() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:313:1: ( ruleAutoNumber EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:314:1: ruleAutoNumber EOF
            {
             before(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber505);
            ruleAutoNumber();

            state._fsp--;

             after(grammarAccess.getAutoNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber512); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAutoNumber"


    // $ANTLR start "ruleAutoNumber"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:321:1: ruleAutoNumber : ( ( rule__AutoNumber__Group__0 ) ) ;
    public final void ruleAutoNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:325:5: ( ( ( rule__AutoNumber__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:326:1: ( ( rule__AutoNumber__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:326:1: ( ( rule__AutoNumber__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:327:1: ( rule__AutoNumber__Group__0 )
            {
             before(grammarAccess.getAutoNumberAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:328:1: ( rule__AutoNumber__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:328:2: rule__AutoNumber__Group__0
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber542);
            rule__AutoNumber__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAutoNumberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAutoNumber"


    // $ANTLR start "entryRuleTitle"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:340:1: entryRuleTitle : ruleTitle EOF ;
    public final void entryRuleTitle() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:341:1: ( ruleTitle EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:342:1: ruleTitle EOF
            {
             before(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle569);
            ruleTitle();

            state._fsp--;

             after(grammarAccess.getTitleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle576); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTitle"


    // $ANTLR start "ruleTitle"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:349:1: ruleTitle : ( ( rule__Title__Group__0 ) ) ;
    public final void ruleTitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:353:5: ( ( ( rule__Title__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:354:1: ( ( rule__Title__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:354:1: ( ( rule__Title__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:355:1: ( rule__Title__Group__0 )
            {
             before(grammarAccess.getTitleAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:356:1: ( rule__Title__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:356:2: rule__Title__Group__0
            {
            pushFollow(FOLLOW_rule__Title__Group__0_in_ruleTitle606);
            rule__Title__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTitleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTitle"


    // $ANTLR start "entryRuleLegend"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:368:1: entryRuleLegend : ruleLegend EOF ;
    public final void entryRuleLegend() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:369:1: ( ruleLegend EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:370:1: ruleLegend EOF
            {
             before(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend633);
            ruleLegend();

            state._fsp--;

             after(grammarAccess.getLegendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend640); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLegend"


    // $ANTLR start "ruleLegend"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:377:1: ruleLegend : ( ( rule__Legend__Group__0 ) ) ;
    public final void ruleLegend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:381:5: ( ( ( rule__Legend__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:382:1: ( ( rule__Legend__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:382:1: ( ( rule__Legend__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:383:1: ( rule__Legend__Group__0 )
            {
             before(grammarAccess.getLegendAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:384:1: ( rule__Legend__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:384:2: rule__Legend__Group__0
            {
            pushFollow(FOLLOW_rule__Legend__Group__0_in_ruleLegend670);
            rule__Legend__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLegendAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLegend"


    // $ANTLR start "entryRuleNewpage"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:396:1: entryRuleNewpage : ruleNewpage EOF ;
    public final void entryRuleNewpage() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:397:1: ( ruleNewpage EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:398:1: ruleNewpage EOF
            {
             before(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage697);
            ruleNewpage();

            state._fsp--;

             after(grammarAccess.getNewpageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage704); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNewpage"


    // $ANTLR start "ruleNewpage"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:405:1: ruleNewpage : ( ( rule__Newpage__Group__0 ) ) ;
    public final void ruleNewpage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:409:5: ( ( ( rule__Newpage__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:410:1: ( ( rule__Newpage__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:410:1: ( ( rule__Newpage__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:411:1: ( rule__Newpage__Group__0 )
            {
             before(grammarAccess.getNewpageAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:412:1: ( rule__Newpage__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:412:2: rule__Newpage__Group__0
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0_in_ruleNewpage734);
            rule__Newpage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNewpageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNewpage"


    // $ANTLR start "entryRuleAltElse"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:424:1: entryRuleAltElse : ruleAltElse EOF ;
    public final void entryRuleAltElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:425:1: ( ruleAltElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:426:1: ruleAltElse EOF
            {
             before(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse761);
            ruleAltElse();

            state._fsp--;

             after(grammarAccess.getAltElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse768); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAltElse"


    // $ANTLR start "ruleAltElse"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:433:1: ruleAltElse : ( ( rule__AltElse__Group__0 ) ) ;
    public final void ruleAltElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:437:5: ( ( ( rule__AltElse__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:438:1: ( ( rule__AltElse__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:438:1: ( ( rule__AltElse__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:439:1: ( rule__AltElse__Group__0 )
            {
             before(grammarAccess.getAltElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:440:1: ( rule__AltElse__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:440:2: rule__AltElse__Group__0
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0_in_ruleAltElse798);
            rule__AltElse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAltElseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAltElse"


    // $ANTLR start "entryRuleElse"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:452:1: entryRuleElse : ruleElse EOF ;
    public final void entryRuleElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:453:1: ( ruleElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:454:1: ruleElse EOF
            {
             before(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse825);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse832); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElse"


    // $ANTLR start "ruleElse"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:461:1: ruleElse : ( ( rule__Else__Group__0 ) ) ;
    public final void ruleElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:465:5: ( ( ( rule__Else__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:466:1: ( ( rule__Else__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:466:1: ( ( rule__Else__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:467:1: ( rule__Else__Group__0 )
            {
             before(grammarAccess.getElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:468:1: ( rule__Else__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:468:2: rule__Else__Group__0
            {
            pushFollow(FOLLOW_rule__Else__Group__0_in_ruleElse862);
            rule__Else__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElse"


    // $ANTLR start "entryRuleGroupingMessages"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:480:1: entryRuleGroupingMessages : ruleGroupingMessages EOF ;
    public final void entryRuleGroupingMessages() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:481:1: ( ruleGroupingMessages EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:482:1: ruleGroupingMessages EOF
            {
             before(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages889);
            ruleGroupingMessages();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages896); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGroupingMessages"


    // $ANTLR start "ruleGroupingMessages"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:489:1: ruleGroupingMessages : ( ( rule__GroupingMessages__Group__0 ) ) ;
    public final void ruleGroupingMessages() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:493:5: ( ( ( rule__GroupingMessages__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:494:1: ( ( rule__GroupingMessages__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:494:1: ( ( rule__GroupingMessages__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:495:1: ( rule__GroupingMessages__Group__0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:496:1: ( rule__GroupingMessages__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:496:2: rule__GroupingMessages__Group__0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages926);
            rule__GroupingMessages__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGroupingMessagesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGroupingMessages"


    // $ANTLR start "entryRuleNote"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:508:1: entryRuleNote : ruleNote EOF ;
    public final void entryRuleNote() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:509:1: ( ruleNote EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:510:1: ruleNote EOF
            {
             before(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote953);
            ruleNote();

            state._fsp--;

             after(grammarAccess.getNoteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote960); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNote"


    // $ANTLR start "ruleNote"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:517:1: ruleNote : ( ( rule__Note__Group__0 ) ) ;
    public final void ruleNote() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:521:5: ( ( ( rule__Note__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:522:1: ( ( rule__Note__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:522:1: ( ( rule__Note__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:523:1: ( rule__Note__Group__0 )
            {
             before(grammarAccess.getNoteAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:524:1: ( rule__Note__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:524:2: rule__Note__Group__0
            {
            pushFollow(FOLLOW_rule__Note__Group__0_in_ruleNote990);
            rule__Note__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNote"


    // $ANTLR start "entryRuleDivider"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:536:1: entryRuleDivider : ruleDivider EOF ;
    public final void entryRuleDivider() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:537:1: ( ruleDivider EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:538:1: ruleDivider EOF
            {
             before(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider1017);
            ruleDivider();

            state._fsp--;

             after(grammarAccess.getDividerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider1024); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDivider"


    // $ANTLR start "ruleDivider"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:545:1: ruleDivider : ( ( rule__Divider__Group__0 ) ) ;
    public final void ruleDivider() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:549:5: ( ( ( rule__Divider__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:550:1: ( ( rule__Divider__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:550:1: ( ( rule__Divider__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:551:1: ( rule__Divider__Group__0 )
            {
             before(grammarAccess.getDividerAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:552:1: ( rule__Divider__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:552:2: rule__Divider__Group__0
            {
            pushFollow(FOLLOW_rule__Divider__Group__0_in_ruleDivider1054);
            rule__Divider__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDividerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDivider"


    // $ANTLR start "entryRuleReference"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:564:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:565:1: ( ruleReference EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:566:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1081);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1088); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:573:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:577:5: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:578:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:578:1: ( ( rule__Reference__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:579:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:580:1: ( rule__Reference__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:580:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference1118);
            rule__Reference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleDelay"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:592:1: entryRuleDelay : ruleDelay EOF ;
    public final void entryRuleDelay() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:593:1: ( ruleDelay EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:594:1: ruleDelay EOF
            {
             before(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay1145);
            ruleDelay();

            state._fsp--;

             after(grammarAccess.getDelayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay1152); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDelay"


    // $ANTLR start "ruleDelay"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:601:1: ruleDelay : ( ( rule__Delay__Group__0 ) ) ;
    public final void ruleDelay() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:605:5: ( ( ( rule__Delay__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:606:1: ( ( rule__Delay__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:606:1: ( ( rule__Delay__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:607:1: ( rule__Delay__Group__0 )
            {
             before(grammarAccess.getDelayAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:608:1: ( rule__Delay__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:608:2: rule__Delay__Group__0
            {
            pushFollow(FOLLOW_rule__Delay__Group__0_in_ruleDelay1182);
            rule__Delay__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDelayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDelay"


    // $ANTLR start "entryRuleSpace"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:620:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:621:1: ( ruleSpace EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:622:1: ruleSpace EOF
            {
             before(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace1209);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getSpaceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace1216); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSpace"


    // $ANTLR start "ruleSpace"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:629:1: ruleSpace : ( ( rule__Space__Alternatives ) ) ;
    public final void ruleSpace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:633:5: ( ( ( rule__Space__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:634:1: ( ( rule__Space__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:634:1: ( ( rule__Space__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:635:1: ( rule__Space__Alternatives )
            {
             before(grammarAccess.getSpaceAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:636:1: ( rule__Space__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:636:2: rule__Space__Alternatives
            {
            pushFollow(FOLLOW_rule__Space__Alternatives_in_ruleSpace1246);
            rule__Space__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSpaceAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSpace"


    // $ANTLR start "entryRuleHidefootbox"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:648:1: entryRuleHidefootbox : ruleHidefootbox EOF ;
    public final void entryRuleHidefootbox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:649:1: ( ruleHidefootbox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:650:1: ruleHidefootbox EOF
            {
             before(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1273);
            ruleHidefootbox();

            state._fsp--;

             after(grammarAccess.getHidefootboxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox1280); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleHidefootbox"


    // $ANTLR start "ruleHidefootbox"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:657:1: ruleHidefootbox : ( ( rule__Hidefootbox__Group__0 ) ) ;
    public final void ruleHidefootbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:661:5: ( ( ( rule__Hidefootbox__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:662:1: ( ( rule__Hidefootbox__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:662:1: ( ( rule__Hidefootbox__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:663:1: ( rule__Hidefootbox__Group__0 )
            {
             before(grammarAccess.getHidefootboxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:664:1: ( rule__Hidefootbox__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:664:2: rule__Hidefootbox__Group__0
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1310);
            rule__Hidefootbox__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getHidefootboxAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleHidefootbox"


    // $ANTLR start "entryRuleActivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:676:1: entryRuleActivate : ruleActivate EOF ;
    public final void entryRuleActivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:677:1: ( ruleActivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:678:1: ruleActivate EOF
            {
             before(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate1337);
            ruleActivate();

            state._fsp--;

             after(grammarAccess.getActivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate1344); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleActivate"


    // $ANTLR start "ruleActivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:685:1: ruleActivate : ( ( rule__Activate__Group__0 ) ) ;
    public final void ruleActivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:689:5: ( ( ( rule__Activate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:690:1: ( ( rule__Activate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:690:1: ( ( rule__Activate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:691:1: ( rule__Activate__Group__0 )
            {
             before(grammarAccess.getActivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:692:1: ( rule__Activate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:692:2: rule__Activate__Group__0
            {
            pushFollow(FOLLOW_rule__Activate__Group__0_in_ruleActivate1374);
            rule__Activate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getActivateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleActivate"


    // $ANTLR start "entryRuleDeactivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:704:1: entryRuleDeactivate : ruleDeactivate EOF ;
    public final void entryRuleDeactivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:705:1: ( ruleDeactivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:706:1: ruleDeactivate EOF
            {
             before(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate1401);
            ruleDeactivate();

            state._fsp--;

             after(grammarAccess.getDeactivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate1408); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeactivate"


    // $ANTLR start "ruleDeactivate"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:713:1: ruleDeactivate : ( ( rule__Deactivate__Group__0 ) ) ;
    public final void ruleDeactivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:717:5: ( ( ( rule__Deactivate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:718:1: ( ( rule__Deactivate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:718:1: ( ( rule__Deactivate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:719:1: ( rule__Deactivate__Group__0 )
            {
             before(grammarAccess.getDeactivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:720:1: ( rule__Deactivate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:720:2: rule__Deactivate__Group__0
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1438);
            rule__Deactivate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeactivateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeactivate"


    // $ANTLR start "entryRuleParticipantCreation"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:732:1: entryRuleParticipantCreation : ruleParticipantCreation EOF ;
    public final void entryRuleParticipantCreation() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:733:1: ( ruleParticipantCreation EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:734:1: ruleParticipantCreation EOF
            {
             before(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1465);
            ruleParticipantCreation();

            state._fsp--;

             after(grammarAccess.getParticipantCreationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation1472); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParticipantCreation"


    // $ANTLR start "ruleParticipantCreation"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:741:1: ruleParticipantCreation : ( ( rule__ParticipantCreation__Group__0 ) ) ;
    public final void ruleParticipantCreation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:745:5: ( ( ( rule__ParticipantCreation__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:746:1: ( ( rule__ParticipantCreation__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:746:1: ( ( rule__ParticipantCreation__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:747:1: ( rule__ParticipantCreation__Group__0 )
            {
             before(grammarAccess.getParticipantCreationAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:748:1: ( rule__ParticipantCreation__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:748:2: rule__ParticipantCreation__Group__0
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1502);
            rule__ParticipantCreation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParticipantCreationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParticipantCreation"


    // $ANTLR start "entryRuleBox"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:760:1: entryRuleBox : ruleBox EOF ;
    public final void entryRuleBox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:761:1: ( ruleBox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:762:1: ruleBox EOF
            {
             before(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox1529);
            ruleBox();

            state._fsp--;

             after(grammarAccess.getBoxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox1536); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBox"


    // $ANTLR start "ruleBox"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:769:1: ruleBox : ( ( rule__Box__Group__0 ) ) ;
    public final void ruleBox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:773:5: ( ( ( rule__Box__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:774:1: ( ( rule__Box__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:774:1: ( ( rule__Box__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:775:1: ( rule__Box__Group__0 )
            {
             before(grammarAccess.getBoxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:776:1: ( rule__Box__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:776:2: rule__Box__Group__0
            {
            pushFollow(FOLLOW_rule__Box__Group__0_in_ruleBox1566);
            rule__Box__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBoxAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBox"


    // $ANTLR start "rule__Instruction__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:788:1: rule__Instruction__Alternatives_0 : ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:792:1: ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) )
            int alt2=18;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:793:1: ( ruleArrow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:793:1: ( ruleArrow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:794:1: ruleArrow
                    {
                     before(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01602);
                    ruleArrow();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:799:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:799:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:800:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:801:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:801:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01619);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:805:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:805:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:806:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01637);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:811:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:811:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:812:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01654);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:817:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:817:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:818:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01671);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:823:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:823:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:824:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01688);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:829:6: ( ruleAltElse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:829:6: ( ruleAltElse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:830:1: ruleAltElse
                    {
                     before(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01705);
                    ruleAltElse();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:835:6: ( ruleGroupingMessages )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:835:6: ( ruleGroupingMessages )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:836:1: ruleGroupingMessages
                    {
                     before(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01722);
                    ruleGroupingMessages();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:841:6: ( ruleNote )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:841:6: ( ruleNote )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:842:1: ruleNote
                    {
                     before(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01739);
                    ruleNote();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:847:6: ( ruleDivider )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:847:6: ( ruleDivider )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:848:1: ruleDivider
                    {
                     before(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01756);
                    ruleDivider();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:853:6: ( ruleReference )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:853:6: ( ruleReference )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:854:1: ruleReference
                    {
                     before(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01773);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:859:6: ( ruleDelay )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:859:6: ( ruleDelay )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:860:1: ruleDelay
                    {
                     before(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01790);
                    ruleDelay();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:865:6: ( ruleSpace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:865:6: ( ruleSpace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:866:1: ruleSpace
                    {
                     before(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01807);
                    ruleSpace();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:871:6: ( ruleHidefootbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:871:6: ( ruleHidefootbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:872:1: ruleHidefootbox
                    {
                     before(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01824);
                    ruleHidefootbox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:877:6: ( ruleActivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:877:6: ( ruleActivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:878:1: ruleActivate
                    {
                     before(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                    pushFollow(FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01841);
                    ruleActivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:883:6: ( ruleDeactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:883:6: ( ruleDeactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:884:1: ruleDeactivate
                    {
                     before(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                    pushFollow(FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01858);
                    ruleDeactivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:889:6: ( ruleParticipantCreation )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:889:6: ( ruleParticipantCreation )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:890:1: ruleParticipantCreation
                    {
                     before(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                    pushFollow(FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_01875);
                    ruleParticipantCreation();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:895:6: ( ruleBox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:895:6: ( ruleBox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:896:1: ruleBox
                    {
                     before(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                    pushFollow(FOLLOW_ruleBox_in_rule__Instruction__Alternatives_01892);
                    ruleBox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Alternatives_0"


    // $ANTLR start "rule__Instruction__Alternatives_0_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:906:1: rule__Instruction__Alternatives_0_1_1 : ( ( RULE_COLOR ) | ( RULE_HEXCODE ) );
    public final void rule__Instruction__Alternatives_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:910:1: ( ( RULE_COLOR ) | ( RULE_HEXCODE ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_COLOR) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_HEXCODE) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:911:1: ( RULE_COLOR )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:911:1: ( RULE_COLOR )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:912:1: RULE_COLOR
                    {
                     before(grammarAccess.getInstructionAccess().getCOLORTerminalRuleCall_0_1_1_0()); 
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Instruction__Alternatives_0_1_11924); 
                     after(grammarAccess.getInstructionAccess().getCOLORTerminalRuleCall_0_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:917:6: ( RULE_HEXCODE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:917:6: ( RULE_HEXCODE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:918:1: RULE_HEXCODE
                    {
                     before(grammarAccess.getInstructionAccess().getHEXCODETerminalRuleCall_0_1_1_1()); 
                    match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_rule__Instruction__Alternatives_0_1_11941); 
                     after(grammarAccess.getInstructionAccess().getHEXCODETerminalRuleCall_0_1_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Alternatives_0_1_1"


    // $ANTLR start "rule__Definition__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:928:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:932:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case Actor:
                {
                alt4=1;
                }
                break;
            case Boundary:
                {
                alt4=2;
                }
                break;
            case Control:
                {
                alt4=3;
                }
                break;
            case Entity:
                {
                alt4=4;
                }
                break;
            case Database:
                {
                alt4=5;
                }
                break;
            case Participant:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:933:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:933:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:934:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:935:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:935:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1973);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:939:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:939:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:940:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:941:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:941:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1991);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:945:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:945:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:946:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:947:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:947:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives2009);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:951:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:951:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:952:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:953:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:953:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives2027);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:957:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:957:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:958:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:959:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:959:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives2045);
                    rule__Definition__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:963:6: ( ( rule__Definition__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:963:6: ( ( rule__Definition__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:964:1: ( rule__Definition__Group_5__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:965:1: ( rule__Definition__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:965:2: rule__Definition__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives2063);
                    rule__Definition__Group_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Alternatives"


    // $ANTLR start "rule__Definition__Alternatives_5_2_1_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:974:1: rule__Definition__Alternatives_5_2_1_3 : ( ( RULE_COLOR ) | ( RULE_HEXCODE ) );
    public final void rule__Definition__Alternatives_5_2_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:978:1: ( ( RULE_COLOR ) | ( RULE_HEXCODE ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_COLOR) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_HEXCODE) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:979:1: ( RULE_COLOR )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:979:1: ( RULE_COLOR )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:980:1: RULE_COLOR
                    {
                     before(grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_3_0()); 
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Definition__Alternatives_5_2_1_32096); 
                     after(grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:985:6: ( RULE_HEXCODE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:985:6: ( RULE_HEXCODE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:986:1: RULE_HEXCODE
                    {
                     before(grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_3_1()); 
                    match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_rule__Definition__Alternatives_5_2_1_32113); 
                     after(grammarAccess.getDefinitionAccess().getHEXCODETerminalRuleCall_5_2_1_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Alternatives_5_2_1_3"


    // $ANTLR start "rule__EndID__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:997:1: rule__EndID__Alternatives : ( ( RULE_ID ) | ( Create ) | ( Autonumber ) | ( Title ) | ( Legend ) | ( Right ) | ( Left ) | ( Center ) | ( Endlegend ) | ( Alt ) | ( Else ) | ( Newpage ) | ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) | ( Note ) | ( Over ) | ( Of ) | ( Ref ) | ( Hide ) | ( Footbox ) | ( Activate ) | ( Deactivate ) | ( Destroy ) | ( Box ) | ( NumberSign ) | ( Comma ) | ( LeftParenthesis ) | ( RightParenthesis ) | ( EqualsSign ) | ( RULE_INT ) | ( HyphenMinus ) | ( FullStop ) | ( Colon ) | ( GreaterThanSign ) | ( LessThanSign ) );
    public final void rule__EndID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1001:1: ( ( RULE_ID ) | ( Create ) | ( Autonumber ) | ( Title ) | ( Legend ) | ( Right ) | ( Left ) | ( Center ) | ( Endlegend ) | ( Alt ) | ( Else ) | ( Newpage ) | ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) | ( Note ) | ( Over ) | ( Of ) | ( Ref ) | ( Hide ) | ( Footbox ) | ( Activate ) | ( Deactivate ) | ( Destroy ) | ( Box ) | ( NumberSign ) | ( Comma ) | ( LeftParenthesis ) | ( RightParenthesis ) | ( EqualsSign ) | ( RULE_INT ) | ( HyphenMinus ) | ( FullStop ) | ( Colon ) | ( GreaterThanSign ) | ( LessThanSign ) )
            int alt6=39;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt6=1;
                }
                break;
            case Create:
                {
                alt6=2;
                }
                break;
            case Autonumber:
                {
                alt6=3;
                }
                break;
            case Title:
                {
                alt6=4;
                }
                break;
            case Legend:
                {
                alt6=5;
                }
                break;
            case Right:
                {
                alt6=6;
                }
                break;
            case Left:
                {
                alt6=7;
                }
                break;
            case Center:
                {
                alt6=8;
                }
                break;
            case Endlegend:
                {
                alt6=9;
                }
                break;
            case Alt:
                {
                alt6=10;
                }
                break;
            case Else:
                {
                alt6=11;
                }
                break;
            case Newpage:
                {
                alt6=12;
                }
                break;
            case Opt:
                {
                alt6=13;
                }
                break;
            case Loop:
                {
                alt6=14;
                }
                break;
            case Par:
                {
                alt6=15;
                }
                break;
            case Break:
                {
                alt6=16;
                }
                break;
            case Critical:
                {
                alt6=17;
                }
                break;
            case Group:
                {
                alt6=18;
                }
                break;
            case Note:
                {
                alt6=19;
                }
                break;
            case Over:
                {
                alt6=20;
                }
                break;
            case Of:
                {
                alt6=21;
                }
                break;
            case Ref:
                {
                alt6=22;
                }
                break;
            case Hide:
                {
                alt6=23;
                }
                break;
            case Footbox:
                {
                alt6=24;
                }
                break;
            case Activate:
                {
                alt6=25;
                }
                break;
            case Deactivate:
                {
                alt6=26;
                }
                break;
            case Destroy:
                {
                alt6=27;
                }
                break;
            case Box:
                {
                alt6=28;
                }
                break;
            case NumberSign:
                {
                alt6=29;
                }
                break;
            case Comma:
                {
                alt6=30;
                }
                break;
            case LeftParenthesis:
                {
                alt6=31;
                }
                break;
            case RightParenthesis:
                {
                alt6=32;
                }
                break;
            case EqualsSign:
                {
                alt6=33;
                }
                break;
            case RULE_INT:
                {
                alt6=34;
                }
                break;
            case HyphenMinus:
                {
                alt6=35;
                }
                break;
            case FullStop:
                {
                alt6=36;
                }
                break;
            case Colon:
                {
                alt6=37;
                }
                break;
            case GreaterThanSign:
                {
                alt6=38;
                }
                break;
            case LessThanSign:
                {
                alt6=39;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1002:1: ( RULE_ID )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1002:1: ( RULE_ID )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1003:1: RULE_ID
                    {
                     before(grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EndID__Alternatives2146); 
                     after(grammarAccess.getEndIDAccess().getIDTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1008:6: ( Create )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1008:6: ( Create )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1009:1: Create
                    {
                     before(grammarAccess.getEndIDAccess().getCreateKeyword_1()); 
                    match(input,Create,FOLLOW_Create_in_rule__EndID__Alternatives2164); 
                     after(grammarAccess.getEndIDAccess().getCreateKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1016:6: ( Autonumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1016:6: ( Autonumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1017:1: Autonumber
                    {
                     before(grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 
                    match(input,Autonumber,FOLLOW_Autonumber_in_rule__EndID__Alternatives2184); 
                     after(grammarAccess.getEndIDAccess().getAutonumberKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1024:6: ( Title )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1024:6: ( Title )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1025:1: Title
                    {
                     before(grammarAccess.getEndIDAccess().getTitleKeyword_3()); 
                    match(input,Title,FOLLOW_Title_in_rule__EndID__Alternatives2204); 
                     after(grammarAccess.getEndIDAccess().getTitleKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1032:6: ( Legend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1032:6: ( Legend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1033:1: Legend
                    {
                     before(grammarAccess.getEndIDAccess().getLegendKeyword_4()); 
                    match(input,Legend,FOLLOW_Legend_in_rule__EndID__Alternatives2224); 
                     after(grammarAccess.getEndIDAccess().getLegendKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1040:6: ( Right )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1040:6: ( Right )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1041:1: Right
                    {
                     before(grammarAccess.getEndIDAccess().getRightKeyword_5()); 
                    match(input,Right,FOLLOW_Right_in_rule__EndID__Alternatives2244); 
                     after(grammarAccess.getEndIDAccess().getRightKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1048:6: ( Left )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1048:6: ( Left )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1049:1: Left
                    {
                     before(grammarAccess.getEndIDAccess().getLeftKeyword_6()); 
                    match(input,Left,FOLLOW_Left_in_rule__EndID__Alternatives2264); 
                     after(grammarAccess.getEndIDAccess().getLeftKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1056:6: ( Center )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1056:6: ( Center )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1057:1: Center
                    {
                     before(grammarAccess.getEndIDAccess().getCenterKeyword_7()); 
                    match(input,Center,FOLLOW_Center_in_rule__EndID__Alternatives2284); 
                     after(grammarAccess.getEndIDAccess().getCenterKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1064:6: ( Endlegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1064:6: ( Endlegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1065:1: Endlegend
                    {
                     before(grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 
                    match(input,Endlegend,FOLLOW_Endlegend_in_rule__EndID__Alternatives2304); 
                     after(grammarAccess.getEndIDAccess().getEndlegendKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1072:6: ( Alt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1072:6: ( Alt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1073:1: Alt
                    {
                     before(grammarAccess.getEndIDAccess().getAltKeyword_9()); 
                    match(input,Alt,FOLLOW_Alt_in_rule__EndID__Alternatives2324); 
                     after(grammarAccess.getEndIDAccess().getAltKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1080:6: ( Else )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1080:6: ( Else )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1081:1: Else
                    {
                     before(grammarAccess.getEndIDAccess().getElseKeyword_10()); 
                    match(input,Else,FOLLOW_Else_in_rule__EndID__Alternatives2344); 
                     after(grammarAccess.getEndIDAccess().getElseKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1088:6: ( Newpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1088:6: ( Newpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1089:1: Newpage
                    {
                     before(grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 
                    match(input,Newpage,FOLLOW_Newpage_in_rule__EndID__Alternatives2364); 
                     after(grammarAccess.getEndIDAccess().getNewpageKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1096:6: ( Opt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1096:6: ( Opt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1097:1: Opt
                    {
                     before(grammarAccess.getEndIDAccess().getOptKeyword_12()); 
                    match(input,Opt,FOLLOW_Opt_in_rule__EndID__Alternatives2384); 
                     after(grammarAccess.getEndIDAccess().getOptKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1104:6: ( Loop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1104:6: ( Loop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1105:1: Loop
                    {
                     before(grammarAccess.getEndIDAccess().getLoopKeyword_13()); 
                    match(input,Loop,FOLLOW_Loop_in_rule__EndID__Alternatives2404); 
                     after(grammarAccess.getEndIDAccess().getLoopKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1112:6: ( Par )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1112:6: ( Par )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1113:1: Par
                    {
                     before(grammarAccess.getEndIDAccess().getParKeyword_14()); 
                    match(input,Par,FOLLOW_Par_in_rule__EndID__Alternatives2424); 
                     after(grammarAccess.getEndIDAccess().getParKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1120:6: ( Break )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1120:6: ( Break )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1121:1: Break
                    {
                     before(grammarAccess.getEndIDAccess().getBreakKeyword_15()); 
                    match(input,Break,FOLLOW_Break_in_rule__EndID__Alternatives2444); 
                     after(grammarAccess.getEndIDAccess().getBreakKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1128:6: ( Critical )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1128:6: ( Critical )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1129:1: Critical
                    {
                     before(grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 
                    match(input,Critical,FOLLOW_Critical_in_rule__EndID__Alternatives2464); 
                     after(grammarAccess.getEndIDAccess().getCriticalKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1136:6: ( Group )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1136:6: ( Group )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1137:1: Group
                    {
                     before(grammarAccess.getEndIDAccess().getGroupKeyword_17()); 
                    match(input,Group,FOLLOW_Group_in_rule__EndID__Alternatives2484); 
                     after(grammarAccess.getEndIDAccess().getGroupKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1144:6: ( Note )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1144:6: ( Note )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1145:1: Note
                    {
                     before(grammarAccess.getEndIDAccess().getNoteKeyword_18()); 
                    match(input,Note,FOLLOW_Note_in_rule__EndID__Alternatives2504); 
                     after(grammarAccess.getEndIDAccess().getNoteKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1152:6: ( Over )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1152:6: ( Over )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1153:1: Over
                    {
                     before(grammarAccess.getEndIDAccess().getOverKeyword_19()); 
                    match(input,Over,FOLLOW_Over_in_rule__EndID__Alternatives2524); 
                     after(grammarAccess.getEndIDAccess().getOverKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1160:6: ( Of )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1160:6: ( Of )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1161:1: Of
                    {
                     before(grammarAccess.getEndIDAccess().getOfKeyword_20()); 
                    match(input,Of,FOLLOW_Of_in_rule__EndID__Alternatives2544); 
                     after(grammarAccess.getEndIDAccess().getOfKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1168:6: ( Ref )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1168:6: ( Ref )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1169:1: Ref
                    {
                     before(grammarAccess.getEndIDAccess().getRefKeyword_21()); 
                    match(input,Ref,FOLLOW_Ref_in_rule__EndID__Alternatives2564); 
                     after(grammarAccess.getEndIDAccess().getRefKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1176:6: ( Hide )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1176:6: ( Hide )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1177:1: Hide
                    {
                     before(grammarAccess.getEndIDAccess().getHideKeyword_22()); 
                    match(input,Hide,FOLLOW_Hide_in_rule__EndID__Alternatives2584); 
                     after(grammarAccess.getEndIDAccess().getHideKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1184:6: ( Footbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1184:6: ( Footbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1185:1: Footbox
                    {
                     before(grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 
                    match(input,Footbox,FOLLOW_Footbox_in_rule__EndID__Alternatives2604); 
                     after(grammarAccess.getEndIDAccess().getFootboxKeyword_23()); 

                    }


                    }
                    break;
                case 25 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1192:6: ( Activate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1192:6: ( Activate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1193:1: Activate
                    {
                     before(grammarAccess.getEndIDAccess().getActivateKeyword_24()); 
                    match(input,Activate,FOLLOW_Activate_in_rule__EndID__Alternatives2624); 
                     after(grammarAccess.getEndIDAccess().getActivateKeyword_24()); 

                    }


                    }
                    break;
                case 26 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1200:6: ( Deactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1200:6: ( Deactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1201:1: Deactivate
                    {
                     before(grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 
                    match(input,Deactivate,FOLLOW_Deactivate_in_rule__EndID__Alternatives2644); 
                     after(grammarAccess.getEndIDAccess().getDeactivateKeyword_25()); 

                    }


                    }
                    break;
                case 27 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1208:6: ( Destroy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1208:6: ( Destroy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1209:1: Destroy
                    {
                     before(grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 
                    match(input,Destroy,FOLLOW_Destroy_in_rule__EndID__Alternatives2664); 
                     after(grammarAccess.getEndIDAccess().getDestroyKeyword_26()); 

                    }


                    }
                    break;
                case 28 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1216:6: ( Box )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1216:6: ( Box )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1217:1: Box
                    {
                     before(grammarAccess.getEndIDAccess().getBoxKeyword_27()); 
                    match(input,Box,FOLLOW_Box_in_rule__EndID__Alternatives2684); 
                     after(grammarAccess.getEndIDAccess().getBoxKeyword_27()); 

                    }


                    }
                    break;
                case 29 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1224:6: ( NumberSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1224:6: ( NumberSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1225:1: NumberSign
                    {
                     before(grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 
                    match(input,NumberSign,FOLLOW_NumberSign_in_rule__EndID__Alternatives2704); 
                     after(grammarAccess.getEndIDAccess().getNumberSignKeyword_28()); 

                    }


                    }
                    break;
                case 30 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1232:6: ( Comma )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1232:6: ( Comma )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1233:1: Comma
                    {
                     before(grammarAccess.getEndIDAccess().getCommaKeyword_29()); 
                    match(input,Comma,FOLLOW_Comma_in_rule__EndID__Alternatives2724); 
                     after(grammarAccess.getEndIDAccess().getCommaKeyword_29()); 

                    }


                    }
                    break;
                case 31 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1240:6: ( LeftParenthesis )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1240:6: ( LeftParenthesis )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1241:1: LeftParenthesis
                    {
                     before(grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 
                    match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__EndID__Alternatives2744); 
                     after(grammarAccess.getEndIDAccess().getLeftParenthesisKeyword_30()); 

                    }


                    }
                    break;
                case 32 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1248:6: ( RightParenthesis )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1248:6: ( RightParenthesis )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1249:1: RightParenthesis
                    {
                     before(grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 
                    match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__EndID__Alternatives2764); 
                     after(grammarAccess.getEndIDAccess().getRightParenthesisKeyword_31()); 

                    }


                    }
                    break;
                case 33 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1256:6: ( EqualsSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1256:6: ( EqualsSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1257:1: EqualsSign
                    {
                     before(grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 
                    match(input,EqualsSign,FOLLOW_EqualsSign_in_rule__EndID__Alternatives2784); 
                     after(grammarAccess.getEndIDAccess().getEqualsSignKeyword_32()); 

                    }


                    }
                    break;
                case 34 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1264:6: ( RULE_INT )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1264:6: ( RULE_INT )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1265:1: RULE_INT
                    {
                     before(grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EndID__Alternatives2803); 
                     after(grammarAccess.getEndIDAccess().getINTTerminalRuleCall_33()); 

                    }


                    }
                    break;
                case 35 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1270:6: ( HyphenMinus )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1270:6: ( HyphenMinus )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1271:1: HyphenMinus
                    {
                     before(grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 
                    match(input,HyphenMinus,FOLLOW_HyphenMinus_in_rule__EndID__Alternatives2821); 
                     after(grammarAccess.getEndIDAccess().getHyphenMinusKeyword_34()); 

                    }


                    }
                    break;
                case 36 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1278:6: ( FullStop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1278:6: ( FullStop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1279:1: FullStop
                    {
                     before(grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 
                    match(input,FullStop,FOLLOW_FullStop_in_rule__EndID__Alternatives2841); 
                     after(grammarAccess.getEndIDAccess().getFullStopKeyword_35()); 

                    }


                    }
                    break;
                case 37 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1286:6: ( Colon )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1286:6: ( Colon )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1287:1: Colon
                    {
                     before(grammarAccess.getEndIDAccess().getColonKeyword_36()); 
                    match(input,Colon,FOLLOW_Colon_in_rule__EndID__Alternatives2861); 
                     after(grammarAccess.getEndIDAccess().getColonKeyword_36()); 

                    }


                    }
                    break;
                case 38 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1294:6: ( GreaterThanSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1294:6: ( GreaterThanSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1295:1: GreaterThanSign
                    {
                     before(grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 
                    match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rule__EndID__Alternatives2881); 
                     after(grammarAccess.getEndIDAccess().getGreaterThanSignKeyword_37()); 

                    }


                    }
                    break;
                case 39 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1302:6: ( LessThanSign )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1302:6: ( LessThanSign )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1303:1: LessThanSign
                    {
                     before(grammarAccess.getEndIDAccess().getLessThanSignKeyword_38()); 
                    match(input,LessThanSign,FOLLOW_LessThanSign_in_rule__EndID__Alternatives2901); 
                     after(grammarAccess.getEndIDAccess().getLessThanSignKeyword_38()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EndID__Alternatives"


    // $ANTLR start "rule__MyID__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1315:1: rule__MyID__Alternatives : ( ( ruleEndID ) | ( End ) );
    public final void rule__MyID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1319:1: ( ( ruleEndID ) | ( End ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=Autonumber && LA7_0<=Activate)||LA7_0==Critical||(LA7_0>=Destroy && LA7_0<=Create)||LA7_0==Legend||(LA7_0>=Break && LA7_0<=Over)||(LA7_0>=Alt && LA7_0<=Box)||(LA7_0>=Opt && LA7_0<=Ref)||LA7_0==Of||(LA7_0>=NumberSign && LA7_0<=GreaterThanSign)||(LA7_0>=RULE_INT && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            else if ( (LA7_0==End) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1320:1: ( ruleEndID )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1320:1: ( ruleEndID )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1321:1: ruleEndID
                    {
                     before(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleEndID_in_rule__MyID__Alternatives2935);
                    ruleEndID();

                    state._fsp--;

                     after(grammarAccess.getMyIDAccess().getEndIDParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1326:6: ( End )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1326:6: ( End )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1327:1: End
                    {
                     before(grammarAccess.getMyIDAccess().getEndKeyword_1()); 
                    match(input,End,FOLLOW_End_in_rule__MyID__Alternatives2953); 
                     after(grammarAccess.getMyIDAccess().getEndKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MyID__Alternatives"


    // $ANTLR start "rule__Legend__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1339:1: rule__Legend__Alternatives_1 : ( ( Right ) | ( Left ) | ( Center ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1343:1: ( ( Right ) | ( Left ) | ( Center ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt8=1;
                }
                break;
            case Left:
                {
                alt8=2;
                }
                break;
            case Center:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1344:1: ( Right )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1344:1: ( Right )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1345:1: Right
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,Right,FOLLOW_Right_in_rule__Legend__Alternatives_12988); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1352:6: ( Left )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1352:6: ( Left )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1353:1: Left
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,Left,FOLLOW_Left_in_rule__Legend__Alternatives_13008); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1360:6: ( Center )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1360:6: ( Center )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1361:1: Center
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,Center,FOLLOW_Center_in_rule__Legend__Alternatives_13028); 
                     after(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Alternatives_1"


    // $ANTLR start "rule__GroupingMessages__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1373:1: rule__GroupingMessages__Alternatives_0 : ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) );
    public final void rule__GroupingMessages__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1377:1: ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) )
            int alt9=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt9=1;
                }
                break;
            case Loop:
                {
                alt9=2;
                }
                break;
            case Par:
                {
                alt9=3;
                }
                break;
            case Break:
                {
                alt9=4;
                }
                break;
            case Critical:
                {
                alt9=5;
                }
                break;
            case Group:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1378:1: ( Opt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1378:1: ( Opt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1379:1: Opt
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 
                    match(input,Opt,FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_03063); 
                     after(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1386:6: ( Loop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1386:6: ( Loop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1387:1: Loop
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 
                    match(input,Loop,FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_03083); 
                     after(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1394:6: ( Par )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1394:6: ( Par )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1395:1: Par
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 
                    match(input,Par,FOLLOW_Par_in_rule__GroupingMessages__Alternatives_03103); 
                     after(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1402:6: ( Break )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1402:6: ( Break )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1403:1: Break
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 
                    match(input,Break,FOLLOW_Break_in_rule__GroupingMessages__Alternatives_03123); 
                     after(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1410:6: ( Critical )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1410:6: ( Critical )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1411:1: Critical
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 
                    match(input,Critical,FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_03143); 
                     after(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1418:6: ( Group )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1418:6: ( Group )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1419:1: Group
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5()); 
                    match(input,Group,FOLLOW_Group_in_rule__GroupingMessages__Alternatives_03163); 
                     after(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Alternatives_0"


    // $ANTLR start "rule__Note__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1431:1: rule__Note__Alternatives_1 : ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) );
    public final void rule__Note__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1435:1: ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt10=1;
                }
                break;
            case Left:
                {
                alt10=2;
                }
                break;
            case Over:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1436:1: ( ( rule__Note__Group_1_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1436:1: ( ( rule__Note__Group_1_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1437:1: ( rule__Note__Group_1_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1438:1: ( rule__Note__Group_1_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1438:2: rule__Note__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_13197);
                    rule__Note__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1442:6: ( ( rule__Note__Group_1_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1442:6: ( ( rule__Note__Group_1_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1443:1: ( rule__Note__Group_1_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1444:1: ( rule__Note__Group_1_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1444:2: rule__Note__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_13215);
                    rule__Note__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1448:6: ( ( rule__Note__Group_1_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1448:6: ( ( rule__Note__Group_1_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1449:1: ( rule__Note__Group_1_2__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1450:1: ( rule__Note__Group_1_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1450:2: rule__Note__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_13233);
                    rule__Note__Group_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Alternatives_1"


    // $ANTLR start "rule__Note__Alternatives_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1459:1: rule__Note__Alternatives_3 : ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) );
    public final void rule__Note__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1463:1: ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Colon) ) {
                alt11=1;
            }
            else if ( (LA11_0==End||LA11_0==RULE_NEWLINE) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1464:1: ( ( rule__Note__Group_3_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1464:1: ( ( rule__Note__Group_3_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1465:1: ( rule__Note__Group_3_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1466:1: ( rule__Note__Group_3_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1466:2: rule__Note__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_33266);
                    rule__Note__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1470:6: ( ( rule__Note__Group_3_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1470:6: ( ( rule__Note__Group_3_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1471:1: ( rule__Note__Group_3_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1472:1: ( rule__Note__Group_3_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1472:2: rule__Note__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_33284);
                    rule__Note__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_3_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Alternatives_3"


    // $ANTLR start "rule__Reference__Alternatives_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1481:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1485:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            else if ( (LA12_0==End||LA12_0==RULE_NEWLINE) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1486:1: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1486:1: ( ( rule__Reference__Group_4_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1487:1: ( rule__Reference__Group_4_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1488:1: ( rule__Reference__Group_4_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1488:2: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_43317);
                    rule__Reference__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1492:6: ( ( rule__Reference__Group_4_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1492:6: ( ( rule__Reference__Group_4_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1493:1: ( rule__Reference__Group_4_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1494:1: ( rule__Reference__Group_4_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1494:2: rule__Reference__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_43335);
                    rule__Reference__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Alternatives_4"


    // $ANTLR start "rule__Space__Alternatives"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1503:1: rule__Space__Alternatives : ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) );
    public final void rule__Space__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1507:1: ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==VerticalLineVerticalLineVerticalLine) ) {
                alt13=1;
            }
            else if ( (LA13_0==VerticalLineVerticalLine) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1508:1: ( VerticalLineVerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1508:1: ( VerticalLineVerticalLineVerticalLine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1509:1: VerticalLineVerticalLineVerticalLine
                    {
                     before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                    match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives3369); 
                     after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1516:6: ( ( rule__Space__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1516:6: ( ( rule__Space__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1517:1: ( rule__Space__Group_1__0 )
                    {
                     before(grammarAccess.getSpaceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1518:1: ( rule__Space__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1518:2: rule__Space__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives3388);
                    rule__Space__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSpaceAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Alternatives"


    // $ANTLR start "rule__Deactivate__Alternatives_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1527:1: rule__Deactivate__Alternatives_0 : ( ( Deactivate ) | ( Destroy ) );
    public final void rule__Deactivate__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1531:1: ( ( Deactivate ) | ( Destroy ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Deactivate) ) {
                alt14=1;
            }
            else if ( (LA14_0==Destroy) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1532:1: ( Deactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1532:1: ( Deactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1533:1: Deactivate
                    {
                     before(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 
                    match(input,Deactivate,FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_03422); 
                     after(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1540:6: ( Destroy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1540:6: ( Destroy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1541:1: Destroy
                    {
                     before(grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()); 
                    match(input,Destroy,FOLLOW_Destroy_in_rule__Deactivate__Alternatives_03442); 
                     after(grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Alternatives_0"


    // $ANTLR start "rule__Diagram__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1555:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1559:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1560:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__03474);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__03477);
            rule__Diagram__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__0"


    // $ANTLR start "rule__Diagram__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1567:1: rule__Diagram__Group__0__Impl : ( RULE_START ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1571:1: ( ( RULE_START ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1572:1: ( RULE_START )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1572:1: ( RULE_START )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1573:1: RULE_START
            {
             before(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_0()); 
            match(input,RULE_START,FOLLOW_RULE_START_in_rule__Diagram__Group__0__Impl3504); 
             after(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__0__Impl"


    // $ANTLR start "rule__Diagram__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1584:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1588:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1589:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__13533);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__13536);
            rule__Diagram__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__1"


    // $ANTLR start "rule__Diagram__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1596:1: rule__Diagram__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1600:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1601:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1601:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1602:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl3563); 
             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__1__Impl"


    // $ANTLR start "rule__Diagram__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1613:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1617:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1618:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__23592);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__23595);
            rule__Diagram__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__2"


    // $ANTLR start "rule__Diagram__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1625:1: rule__Diagram__Group__2__Impl : ( ( rule__Diagram__InstructionsAssignment_2 )* ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1629:1: ( ( ( rule__Diagram__InstructionsAssignment_2 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1630:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1630:1: ( ( rule__Diagram__InstructionsAssignment_2 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1631:1: ( rule__Diagram__InstructionsAssignment_2 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1632:1: ( rule__Diagram__InstructionsAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=Participant && LA15_0<=VerticalLineVerticalLineVerticalLine)||LA15_0==EqualsSignEqualsSign||(LA15_0>=Of && LA15_0<=VerticalLineVerticalLine)||(LA15_0>=NumberSign && LA15_0<=RULE_NEWLINE)||(LA15_0>=RULE_INT && LA15_0<=RULE_ID)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1632:2: rule__Diagram__InstructionsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl3622);
            	    rule__Diagram__InstructionsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getInstructionsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__2__Impl"


    // $ANTLR start "rule__Diagram__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1642:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl rule__Diagram__Group__4 ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1646:1: ( rule__Diagram__Group__3__Impl rule__Diagram__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1647:2: rule__Diagram__Group__3__Impl rule__Diagram__Group__4
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__33653);
            rule__Diagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__33656);
            rule__Diagram__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__3"


    // $ANTLR start "rule__Diagram__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1654:1: rule__Diagram__Group__3__Impl : ( RULE_END ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1658:1: ( ( RULE_END ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1659:1: ( RULE_END )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1659:1: ( RULE_END )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1660:1: RULE_END
            {
             before(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_3()); 
            match(input,RULE_END,FOLLOW_RULE_END_in_rule__Diagram__Group__3__Impl3683); 
             after(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__3__Impl"


    // $ANTLR start "rule__Diagram__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1671:1: rule__Diagram__Group__4 : rule__Diagram__Group__4__Impl ;
    public final void rule__Diagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1675:1: ( rule__Diagram__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1676:2: rule__Diagram__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__43712);
            rule__Diagram__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__4"


    // $ANTLR start "rule__Diagram__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1682:1: rule__Diagram__Group__4__Impl : ( ( RULE_NEWLINE )* ) ;
    public final void rule__Diagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1686:1: ( ( ( RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1687:1: ( ( RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1687:1: ( ( RULE_NEWLINE )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1688:1: ( RULE_NEWLINE )*
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1689:1: ( RULE_NEWLINE )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_NEWLINE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1689:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__4__Impl3740); 

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__4__Impl"


    // $ANTLR start "rule__Instruction__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1709:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1713:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1714:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__03781);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__03784);
            rule__Instruction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group__0"


    // $ANTLR start "rule__Instruction__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1721:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1725:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1726:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1726:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1727:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1728:1: ( rule__Instruction__Alternatives_0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=Participant && LA17_0<=Create)||(LA17_0>=Create && LA17_0<=Over)||LA17_0==Hide||(LA17_0>=Loop && LA17_0<=Note)||(LA17_0>=FullStopFullStopFullStop && LA17_0<=VerticalLineVerticalLineVerticalLine)||LA17_0==EqualsSignEqualsSign||(LA17_0>=Of && LA17_0<=VerticalLineVerticalLine)||(LA17_0>=NumberSign && LA17_0<=GreaterThanSign)||(LA17_0>=RULE_INT && LA17_0<=RULE_ID)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1728:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl3811);
                    rule__Instruction__Alternatives_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group__0__Impl"


    // $ANTLR start "rule__Instruction__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1738:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1742:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1743:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__13842);
            rule__Instruction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group__1"


    // $ANTLR start "rule__Instruction__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1749:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1753:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1754:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1754:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1755:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl3869); 
             after(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group__1__Impl"


    // $ANTLR start "rule__Instruction__Group_0_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1770:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1774:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1775:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__03902);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__03905);
            rule__Instruction__Group_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_1__0"


    // $ANTLR start "rule__Instruction__Group_0_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1782:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1786:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1787:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1787:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1788:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl3932);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_1__0__Impl"


    // $ANTLR start "rule__Instruction__Group_0_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1799:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1803:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1804:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__13961);
            rule__Instruction__Group_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_1__1"


    // $ANTLR start "rule__Instruction__Group_0_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1810:1: rule__Instruction__Group_0_1__1__Impl : ( ( rule__Instruction__Alternatives_0_1_1 )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1814:1: ( ( ( rule__Instruction__Alternatives_0_1_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1815:1: ( ( rule__Instruction__Alternatives_0_1_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1815:1: ( ( rule__Instruction__Alternatives_0_1_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1816:1: ( rule__Instruction__Alternatives_0_1_1 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1817:1: ( rule__Instruction__Alternatives_0_1_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_COLOR && LA18_0<=RULE_HEXCODE)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1817:2: rule__Instruction__Alternatives_0_1_1
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_1_1_in_rule__Instruction__Group_0_1__1__Impl3988);
                    rule__Instruction__Alternatives_0_1_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInstructionAccess().getAlternatives_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Group_0_1__1__Impl"


    // $ANTLR start "rule__Arrow__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1831:1: rule__Arrow__Group__0 : rule__Arrow__Group__0__Impl rule__Arrow__Group__1 ;
    public final void rule__Arrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1835:1: ( rule__Arrow__Group__0__Impl rule__Arrow__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1836:2: rule__Arrow__Group__0__Impl rule__Arrow__Group__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__04023);
            rule__Arrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__04026);
            rule__Arrow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__0"


    // $ANTLR start "rule__Arrow__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1843:1: rule__Arrow__Group__0__Impl : ( ( rule__Arrow__NameAssignment_0 ) ) ;
    public final void rule__Arrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1847:1: ( ( ( rule__Arrow__NameAssignment_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1848:1: ( ( rule__Arrow__NameAssignment_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1848:1: ( ( rule__Arrow__NameAssignment_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1849:1: ( rule__Arrow__NameAssignment_0 )
            {
             before(grammarAccess.getArrowAccess().getNameAssignment_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1850:1: ( rule__Arrow__NameAssignment_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1850:2: rule__Arrow__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl4053);
            rule__Arrow__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__0__Impl"


    // $ANTLR start "rule__Arrow__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1860:1: rule__Arrow__Group__1 : rule__Arrow__Group__1__Impl rule__Arrow__Group__2 ;
    public final void rule__Arrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1864:1: ( rule__Arrow__Group__1__Impl rule__Arrow__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1865:2: rule__Arrow__Group__1__Impl rule__Arrow__Group__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__14083);
            rule__Arrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__14086);
            rule__Arrow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__1"


    // $ANTLR start "rule__Arrow__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1872:1: rule__Arrow__Group__1__Impl : ( RULE_SEQUENCE ) ;
    public final void rule__Arrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1876:1: ( ( RULE_SEQUENCE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1877:1: ( RULE_SEQUENCE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1877:1: ( RULE_SEQUENCE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1878:1: RULE_SEQUENCE
            {
             before(grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
            match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl4113); 
             after(grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__1__Impl"


    // $ANTLR start "rule__Arrow__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1889:1: rule__Arrow__Group__2 : rule__Arrow__Group__2__Impl rule__Arrow__Group__3 ;
    public final void rule__Arrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1893:1: ( rule__Arrow__Group__2__Impl rule__Arrow__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1894:2: rule__Arrow__Group__2__Impl rule__Arrow__Group__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__24142);
            rule__Arrow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__24145);
            rule__Arrow__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__2"


    // $ANTLR start "rule__Arrow__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1901:1: rule__Arrow__Group__2__Impl : ( ( rule__Arrow__NamesAssignment_2 ) ) ;
    public final void rule__Arrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1905:1: ( ( ( rule__Arrow__NamesAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1906:1: ( ( rule__Arrow__NamesAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1906:1: ( ( rule__Arrow__NamesAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1907:1: ( rule__Arrow__NamesAssignment_2 )
            {
             before(grammarAccess.getArrowAccess().getNamesAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1908:1: ( rule__Arrow__NamesAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1908:2: rule__Arrow__NamesAssignment_2
            {
            pushFollow(FOLLOW_rule__Arrow__NamesAssignment_2_in_rule__Arrow__Group__2__Impl4172);
            rule__Arrow__NamesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getNamesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__2__Impl"


    // $ANTLR start "rule__Arrow__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1918:1: rule__Arrow__Group__3 : rule__Arrow__Group__3__Impl ;
    public final void rule__Arrow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1922:1: ( rule__Arrow__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1923:2: rule__Arrow__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__34202);
            rule__Arrow__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__3"


    // $ANTLR start "rule__Arrow__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1929:1: rule__Arrow__Group__3__Impl : ( ( rule__Arrow__Group_3__0 )? ) ;
    public final void rule__Arrow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1933:1: ( ( ( rule__Arrow__Group_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1934:1: ( ( rule__Arrow__Group_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1934:1: ( ( rule__Arrow__Group_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1935:1: ( rule__Arrow__Group_3__0 )?
            {
             before(grammarAccess.getArrowAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1936:1: ( rule__Arrow__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Colon) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1936:2: rule__Arrow__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl4229);
                    rule__Arrow__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getArrowAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group__3__Impl"


    // $ANTLR start "rule__Arrow__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1954:1: rule__Arrow__Group_3__0 : rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 ;
    public final void rule__Arrow__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1958:1: ( rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1959:2: rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__04268);
            rule__Arrow__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__04271);
            rule__Arrow__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__0"


    // $ANTLR start "rule__Arrow__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1966:1: rule__Arrow__Group_3__0__Impl : ( Colon ) ;
    public final void rule__Arrow__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1970:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1971:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1971:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1972:1: Colon
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_3_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl4299); 
             after(grammarAccess.getArrowAccess().getColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__0__Impl"


    // $ANTLR start "rule__Arrow__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1985:1: rule__Arrow__Group_3__1 : rule__Arrow__Group_3__1__Impl ;
    public final void rule__Arrow__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1989:1: ( rule__Arrow__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1990:2: rule__Arrow__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__14330);
            rule__Arrow__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__1"


    // $ANTLR start "rule__Arrow__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1996:1: rule__Arrow__Group_3__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Arrow__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2000:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2001:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2001:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2002:1: ( ruleMyID )*
            {
             before(grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2003:1: ( ruleMyID )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=Autonumber && LA20_0<=Activate)||LA20_0==Critical||(LA20_0>=Destroy && LA20_0<=Create)||LA20_0==Legend||(LA20_0>=Break && LA20_0<=Over)||(LA20_0>=Alt && LA20_0<=Ref)||LA20_0==Of||(LA20_0>=NumberSign && LA20_0<=GreaterThanSign)||(LA20_0>=RULE_INT && LA20_0<=RULE_ID)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2003:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Arrow__Group_3__1__Impl4358);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getArrowAccess().getMyIDParserRuleCall_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__Group_3__1__Impl"


    // $ANTLR start "rule__Definition__Group_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2017:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2021:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2022:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__04393);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__04396);
            rule__Definition__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_0__0"


    // $ANTLR start "rule__Definition__Group_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2029:1: rule__Definition__Group_0__0__Impl : ( Actor ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2033:1: ( ( Actor ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2034:1: ( Actor )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2034:1: ( Actor )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2035:1: Actor
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,Actor,FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl4424); 
             after(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_0__0__Impl"


    // $ANTLR start "rule__Definition__Group_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2048:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2052:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2053:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__14455);
            rule__Definition__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_0__1"


    // $ANTLR start "rule__Definition__Group_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2059:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2063:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2064:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2064:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2065:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2066:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2066:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl4482);
            rule__Definition__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_0__1__Impl"


    // $ANTLR start "rule__Definition__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2080:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2084:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2085:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__04516);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__04519);
            rule__Definition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__0"


    // $ANTLR start "rule__Definition__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2092:1: rule__Definition__Group_1__0__Impl : ( Boundary ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2096:1: ( ( Boundary ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2097:1: ( Boundary )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2097:1: ( Boundary )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2098:1: Boundary
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,Boundary,FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl4547); 
             after(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__0__Impl"


    // $ANTLR start "rule__Definition__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2111:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2115:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2116:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__14578);
            rule__Definition__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__1"


    // $ANTLR start "rule__Definition__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2122:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2126:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2127:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2127:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2128:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2129:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2129:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl4605);
            rule__Definition__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_1__1__Impl"


    // $ANTLR start "rule__Definition__Group_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2143:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2147:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2148:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__04639);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__04642);
            rule__Definition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__0"


    // $ANTLR start "rule__Definition__Group_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2155:1: rule__Definition__Group_2__0__Impl : ( Control ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2159:1: ( ( Control ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2160:1: ( Control )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2160:1: ( Control )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2161:1: Control
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,Control,FOLLOW_Control_in_rule__Definition__Group_2__0__Impl4670); 
             after(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__0__Impl"


    // $ANTLR start "rule__Definition__Group_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2174:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2178:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2179:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__14701);
            rule__Definition__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__1"


    // $ANTLR start "rule__Definition__Group_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2185:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2189:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2190:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2190:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2191:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2192:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2192:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl4728);
            rule__Definition__NameAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_2__1__Impl"


    // $ANTLR start "rule__Definition__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2206:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2210:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2211:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__04762);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__04765);
            rule__Definition__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_3__0"


    // $ANTLR start "rule__Definition__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2218:1: rule__Definition__Group_3__0__Impl : ( Entity ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2222:1: ( ( Entity ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2223:1: ( Entity )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2223:1: ( Entity )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2224:1: Entity
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,Entity,FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl4793); 
             after(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_3__0__Impl"


    // $ANTLR start "rule__Definition__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2237:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2241:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2242:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__14824);
            rule__Definition__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_3__1"


    // $ANTLR start "rule__Definition__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2248:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2252:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2253:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2253:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2254:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2255:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2255:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl4851);
            rule__Definition__NameAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_3__1__Impl"


    // $ANTLR start "rule__Definition__Group_4__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2269:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2273:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2274:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__04885);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__04888);
            rule__Definition__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_4__0"


    // $ANTLR start "rule__Definition__Group_4__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2281:1: rule__Definition__Group_4__0__Impl : ( Database ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2285:1: ( ( Database ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2286:1: ( Database )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2286:1: ( Database )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2287:1: Database
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,Database,FOLLOW_Database_in_rule__Definition__Group_4__0__Impl4916); 
             after(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_4__0__Impl"


    // $ANTLR start "rule__Definition__Group_4__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2300:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2304:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2305:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__14947);
            rule__Definition__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_4__1"


    // $ANTLR start "rule__Definition__Group_4__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2311:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2315:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2316:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2316:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2317:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2318:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2318:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl4974);
            rule__Definition__NameAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_4__1__Impl"


    // $ANTLR start "rule__Definition__Group_5__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2332:1: rule__Definition__Group_5__0 : rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 ;
    public final void rule__Definition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2336:1: ( rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2337:2: rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__05008);
            rule__Definition__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__05011);
            rule__Definition__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__0"


    // $ANTLR start "rule__Definition__Group_5__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2344:1: rule__Definition__Group_5__0__Impl : ( Participant ) ;
    public final void rule__Definition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2348:1: ( ( Participant ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2349:1: ( Participant )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2349:1: ( Participant )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2350:1: Participant
            {
             before(grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0()); 
            match(input,Participant,FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl5039); 
             after(grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__0__Impl"


    // $ANTLR start "rule__Definition__Group_5__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2363:1: rule__Definition__Group_5__1 : rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 ;
    public final void rule__Definition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2367:1: ( rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2368:2: rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__15070);
            rule__Definition__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__15073);
            rule__Definition__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__1"


    // $ANTLR start "rule__Definition__Group_5__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2375:1: rule__Definition__Group_5__1__Impl : ( ( rule__Definition__NameAssignment_5_1 ) ) ;
    public final void rule__Definition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2379:1: ( ( ( rule__Definition__NameAssignment_5_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2380:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2380:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2381:1: ( rule__Definition__NameAssignment_5_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_5_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2382:1: ( rule__Definition__NameAssignment_5_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2382:2: rule__Definition__NameAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl5100);
            rule__Definition__NameAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getNameAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__1__Impl"


    // $ANTLR start "rule__Definition__Group_5__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2392:1: rule__Definition__Group_5__2 : rule__Definition__Group_5__2__Impl ;
    public final void rule__Definition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2396:1: ( rule__Definition__Group_5__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2397:2: rule__Definition__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__25130);
            rule__Definition__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__2"


    // $ANTLR start "rule__Definition__Group_5__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2403:1: rule__Definition__Group_5__2__Impl : ( ( rule__Definition__Group_5_2__0 )? ) ;
    public final void rule__Definition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2407:1: ( ( ( rule__Definition__Group_5_2__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2408:1: ( ( rule__Definition__Group_5_2__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2408:1: ( ( rule__Definition__Group_5_2__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2409:1: ( rule__Definition__Group_5_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_5_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2410:1: ( rule__Definition__Group_5_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LessThanSignLessThanSign) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2410:2: rule__Definition__Group_5_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl5157);
                    rule__Definition__Group_5_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDefinitionAccess().getGroup_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2426:1: rule__Definition__Group_5_2__0 : rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 ;
    public final void rule__Definition__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2430:1: ( rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2431:2: rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__05194);
            rule__Definition__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__05197);
            rule__Definition__Group_5_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__0"


    // $ANTLR start "rule__Definition__Group_5_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2438:1: rule__Definition__Group_5_2__0__Impl : ( LessThanSignLessThanSign ) ;
    public final void rule__Definition__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2442:1: ( ( LessThanSignLessThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2443:1: ( LessThanSignLessThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2443:1: ( LessThanSignLessThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2444:1: LessThanSignLessThanSign
            {
             before(grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()); 
            match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl5225); 
             after(grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2457:1: rule__Definition__Group_5_2__1 : rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 ;
    public final void rule__Definition__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2461:1: ( rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2462:2: rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__15256);
            rule__Definition__Group_5_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__15259);
            rule__Definition__Group_5_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__1"


    // $ANTLR start "rule__Definition__Group_5_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2469:1: rule__Definition__Group_5_2__1__Impl : ( ( rule__Definition__Group_5_2_1__0 )? ) ;
    public final void rule__Definition__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2473:1: ( ( ( rule__Definition__Group_5_2_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2474:1: ( ( rule__Definition__Group_5_2_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2474:1: ( ( rule__Definition__Group_5_2_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2475:1: ( rule__Definition__Group_5_2_1__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_5_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2476:1: ( rule__Definition__Group_5_2_1__0 )?
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2476:2: rule__Definition__Group_5_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2_1__0_in_rule__Definition__Group_5_2__1__Impl5286);
                    rule__Definition__Group_5_2_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDefinitionAccess().getGroup_5_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2486:1: rule__Definition__Group_5_2__2 : rule__Definition__Group_5_2__2__Impl rule__Definition__Group_5_2__3 ;
    public final void rule__Definition__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2490:1: ( rule__Definition__Group_5_2__2__Impl rule__Definition__Group_5_2__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2491:2: rule__Definition__Group_5_2__2__Impl rule__Definition__Group_5_2__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__25317);
            rule__Definition__Group_5_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__3_in_rule__Definition__Group_5_2__25320);
            rule__Definition__Group_5_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__2"


    // $ANTLR start "rule__Definition__Group_5_2__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2498:1: rule__Definition__Group_5_2__2__Impl : ( ( ruleEndID )* ) ;
    public final void rule__Definition__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2502:1: ( ( ( ruleEndID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2503:1: ( ( ruleEndID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2503:1: ( ( ruleEndID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2504:1: ( ruleEndID )*
            {
             before(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2505:1: ( ruleEndID )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=Autonumber && LA23_0<=Activate)||LA23_0==Critical||(LA23_0>=Destroy && LA23_0<=Create)||LA23_0==Legend||(LA23_0>=Break && LA23_0<=Over)||(LA23_0>=Alt && LA23_0<=Box)||(LA23_0>=Opt && LA23_0<=Ref)||LA23_0==Of||(LA23_0>=NumberSign && LA23_0<=GreaterThanSign)||(LA23_0>=RULE_INT && LA23_0<=RULE_ID)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2505:3: ruleEndID
            	    {
            	    pushFollow(FOLLOW_ruleEndID_in_rule__Definition__Group_5_2__2__Impl5348);
            	    ruleEndID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2515:1: rule__Definition__Group_5_2__3 : rule__Definition__Group_5_2__3__Impl ;
    public final void rule__Definition__Group_5_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2519:1: ( rule__Definition__Group_5_2__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2520:2: rule__Definition__Group_5_2__3__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__3__Impl_in_rule__Definition__Group_5_2__35379);
            rule__Definition__Group_5_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__3"


    // $ANTLR start "rule__Definition__Group_5_2__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2526:1: rule__Definition__Group_5_2__3__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__Definition__Group_5_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2530:1: ( ( GreaterThanSignGreaterThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2531:1: ( GreaterThanSignGreaterThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2531:1: ( GreaterThanSignGreaterThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2532:1: GreaterThanSignGreaterThanSign
            {
             before(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3()); 
            match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__3__Impl5407); 
             after(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2553:1: rule__Definition__Group_5_2_1__0 : rule__Definition__Group_5_2_1__0__Impl rule__Definition__Group_5_2_1__1 ;
    public final void rule__Definition__Group_5_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2557:1: ( rule__Definition__Group_5_2_1__0__Impl rule__Definition__Group_5_2_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2558:2: rule__Definition__Group_5_2_1__0__Impl rule__Definition__Group_5_2_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__0__Impl_in_rule__Definition__Group_5_2_1__05446);
            rule__Definition__Group_5_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__1_in_rule__Definition__Group_5_2_1__05449);
            rule__Definition__Group_5_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__0"


    // $ANTLR start "rule__Definition__Group_5_2_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2565:1: rule__Definition__Group_5_2_1__0__Impl : ( LeftParenthesis ) ;
    public final void rule__Definition__Group_5_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2569:1: ( ( LeftParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2570:1: ( LeftParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2570:1: ( LeftParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2571:1: LeftParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0()); 
            match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1__0__Impl5477); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2584:1: rule__Definition__Group_5_2_1__1 : rule__Definition__Group_5_2_1__1__Impl rule__Definition__Group_5_2_1__2 ;
    public final void rule__Definition__Group_5_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2588:1: ( rule__Definition__Group_5_2_1__1__Impl rule__Definition__Group_5_2_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2589:2: rule__Definition__Group_5_2_1__1__Impl rule__Definition__Group_5_2_1__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__1__Impl_in_rule__Definition__Group_5_2_1__15508);
            rule__Definition__Group_5_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__2_in_rule__Definition__Group_5_2_1__15511);
            rule__Definition__Group_5_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__1"


    // $ANTLR start "rule__Definition__Group_5_2_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2596:1: rule__Definition__Group_5_2_1__1__Impl : ( ruleEndID ) ;
    public final void rule__Definition__Group_5_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2600:1: ( ( ruleEndID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2601:1: ( ruleEndID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2601:1: ( ruleEndID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2602:1: ruleEndID
            {
             before(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 
            pushFollow(FOLLOW_ruleEndID_in_rule__Definition__Group_5_2_1__1__Impl5538);
            ruleEndID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getEndIDParserRuleCall_5_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2613:1: rule__Definition__Group_5_2_1__2 : rule__Definition__Group_5_2_1__2__Impl rule__Definition__Group_5_2_1__3 ;
    public final void rule__Definition__Group_5_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2617:1: ( rule__Definition__Group_5_2_1__2__Impl rule__Definition__Group_5_2_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2618:2: rule__Definition__Group_5_2_1__2__Impl rule__Definition__Group_5_2_1__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__2__Impl_in_rule__Definition__Group_5_2_1__25567);
            rule__Definition__Group_5_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__3_in_rule__Definition__Group_5_2_1__25570);
            rule__Definition__Group_5_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__2"


    // $ANTLR start "rule__Definition__Group_5_2_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2625:1: rule__Definition__Group_5_2_1__2__Impl : ( Comma ) ;
    public final void rule__Definition__Group_5_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2629:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2630:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2630:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2631:1: Comma
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Definition__Group_5_2_1__2__Impl5598); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2644:1: rule__Definition__Group_5_2_1__3 : rule__Definition__Group_5_2_1__3__Impl rule__Definition__Group_5_2_1__4 ;
    public final void rule__Definition__Group_5_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2648:1: ( rule__Definition__Group_5_2_1__3__Impl rule__Definition__Group_5_2_1__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2649:2: rule__Definition__Group_5_2_1__3__Impl rule__Definition__Group_5_2_1__4
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__3__Impl_in_rule__Definition__Group_5_2_1__35629);
            rule__Definition__Group_5_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__4_in_rule__Definition__Group_5_2_1__35632);
            rule__Definition__Group_5_2_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__3"


    // $ANTLR start "rule__Definition__Group_5_2_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2656:1: rule__Definition__Group_5_2_1__3__Impl : ( ( rule__Definition__Alternatives_5_2_1_3 ) ) ;
    public final void rule__Definition__Group_5_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2660:1: ( ( ( rule__Definition__Alternatives_5_2_1_3 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2661:1: ( ( rule__Definition__Alternatives_5_2_1_3 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2661:1: ( ( rule__Definition__Alternatives_5_2_1_3 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2662:1: ( rule__Definition__Alternatives_5_2_1_3 )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives_5_2_1_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2663:1: ( rule__Definition__Alternatives_5_2_1_3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2663:2: rule__Definition__Alternatives_5_2_1_3
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_5_2_1_3_in_rule__Definition__Group_5_2_1__3__Impl5659);
            rule__Definition__Alternatives_5_2_1_3();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getAlternatives_5_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2673:1: rule__Definition__Group_5_2_1__4 : rule__Definition__Group_5_2_1__4__Impl ;
    public final void rule__Definition__Group_5_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2677:1: ( rule__Definition__Group_5_2_1__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2678:2: rule__Definition__Group_5_2_1__4__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1__4__Impl_in_rule__Definition__Group_5_2_1__45689);
            rule__Definition__Group_5_2_1__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__4"


    // $ANTLR start "rule__Definition__Group_5_2_1__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2684:1: rule__Definition__Group_5_2_1__4__Impl : ( RightParenthesis ) ;
    public final void rule__Definition__Group_5_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2688:1: ( ( RightParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2689:1: ( RightParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2689:1: ( RightParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2690:1: RightParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_4()); 
            match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1__4__Impl5717); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__Group_5_2_1__4__Impl"


    // $ANTLR start "rule__AutoNumber__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2713:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2717:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2718:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__05758);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__05761);
            rule__AutoNumber__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group__0"


    // $ANTLR start "rule__AutoNumber__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2725:1: rule__AutoNumber__Group__0__Impl : ( Autonumber ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2729:1: ( ( Autonumber ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2730:1: ( Autonumber )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2730:1: ( Autonumber )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2731:1: Autonumber
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,Autonumber,FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl5789); 
             after(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group__0__Impl"


    // $ANTLR start "rule__AutoNumber__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2744:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2748:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2749:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__15820);
            rule__AutoNumber__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group__1"


    // $ANTLR start "rule__AutoNumber__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2755:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2759:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2760:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2760:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2761:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2762:1: ( rule__AutoNumber__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_INT) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2762:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl5847);
                    rule__AutoNumber__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAutoNumberAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group__1__Impl"


    // $ANTLR start "rule__AutoNumber__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2776:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2780:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2781:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__05882);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__05885);
            rule__AutoNumber__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group_1__0"


    // $ANTLR start "rule__AutoNumber__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2788:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2792:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2793:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2793:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2794:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl5912); 
             after(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group_1__0__Impl"


    // $ANTLR start "rule__AutoNumber__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2805:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2809:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2810:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__15941);
            rule__AutoNumber__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group_1__1"


    // $ANTLR start "rule__AutoNumber__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2816:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2820:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2821:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2821:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2822:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2823:1: ( RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2823:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl5969); 

                    }
                    break;

            }

             after(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AutoNumber__Group_1__1__Impl"


    // $ANTLR start "rule__Title__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2837:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2841:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2842:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__06004);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__06007);
            rule__Title__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Title__Group__0"


    // $ANTLR start "rule__Title__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2849:1: rule__Title__Group__0__Impl : ( Title ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2853:1: ( ( Title ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2854:1: ( Title )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2854:1: ( Title )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2855:1: Title
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,Title,FOLLOW_Title_in_rule__Title__Group__0__Impl6035); 
             after(grammarAccess.getTitleAccess().getTitleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Title__Group__0__Impl"


    // $ANTLR start "rule__Title__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2868:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2872:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2873:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__16066);
            rule__Title__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Title__Group__1"


    // $ANTLR start "rule__Title__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2879:1: rule__Title__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2883:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2884:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2884:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2885:1: ( RULE_ID )*
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2886:1: ( RULE_ID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2886:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl6094); 

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Title__Group__1__Impl"


    // $ANTLR start "rule__Legend__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2900:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2904:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2905:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__06129);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__06132);
            rule__Legend__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__0"


    // $ANTLR start "rule__Legend__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2912:1: rule__Legend__Group__0__Impl : ( Legend ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2916:1: ( ( Legend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2917:1: ( Legend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2917:1: ( Legend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2918:1: Legend
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,Legend,FOLLOW_Legend_in_rule__Legend__Group__0__Impl6160); 
             after(grammarAccess.getLegendAccess().getLegendKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__0__Impl"


    // $ANTLR start "rule__Legend__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2931:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2935:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2936:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__16191);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__16194);
            rule__Legend__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__1"


    // $ANTLR start "rule__Legend__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2943:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2947:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2948:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2948:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2949:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2950:1: ( rule__Legend__Alternatives_1 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Center||LA27_0==Right||LA27_0==Left) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2950:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl6221);
                    rule__Legend__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLegendAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__1__Impl"


    // $ANTLR start "rule__Legend__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2960:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2964:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2965:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__26252);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__26255);
            rule__Legend__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__2"


    // $ANTLR start "rule__Legend__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2972:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Group_2__0 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2976:1: ( ( ( rule__Legend__Group_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2977:1: ( ( rule__Legend__Group_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2977:1: ( ( rule__Legend__Group_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2978:1: ( rule__Legend__Group_2__0 )*
            {
             before(grammarAccess.getLegendAccess().getGroup_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2979:1: ( rule__Legend__Group_2__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_NEWLINE) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2979:2: rule__Legend__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl6282);
            	    rule__Legend__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getLegendAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__2__Impl"


    // $ANTLR start "rule__Legend__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2989:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2993:1: ( rule__Legend__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2994:2: rule__Legend__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__36313);
            rule__Legend__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__3"


    // $ANTLR start "rule__Legend__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3000:1: rule__Legend__Group__3__Impl : ( Endlegend ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3004:1: ( ( Endlegend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3005:1: ( Endlegend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3005:1: ( Endlegend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3006:1: Endlegend
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
            match(input,Endlegend,FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl6341); 
             after(grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group__3__Impl"


    // $ANTLR start "rule__Legend__Group_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3027:1: rule__Legend__Group_2__0 : rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 ;
    public final void rule__Legend__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3031:1: ( rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3032:2: rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__06380);
            rule__Legend__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__06383);
            rule__Legend__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__0"


    // $ANTLR start "rule__Legend__Group_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3039:1: rule__Legend__Group_2__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3043:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3044:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3044:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3045:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl6410); 
             after(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__0__Impl"


    // $ANTLR start "rule__Legend__Group_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3056:1: rule__Legend__Group_2__1 : rule__Legend__Group_2__1__Impl ;
    public final void rule__Legend__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3060:1: ( rule__Legend__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3061:2: rule__Legend__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__16439);
            rule__Legend__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__1"


    // $ANTLR start "rule__Legend__Group_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3067:1: rule__Legend__Group_2__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Legend__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3071:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3072:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3072:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3073:1: ( RULE_ID )*
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3074:1: ( RULE_ID )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3074:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl6467); 

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Legend__Group_2__1__Impl"


    // $ANTLR start "rule__Newpage__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3088:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3092:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3093:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__06502);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__06505);
            rule__Newpage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Newpage__Group__0"


    // $ANTLR start "rule__Newpage__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3100:1: rule__Newpage__Group__0__Impl : ( Newpage ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3104:1: ( ( Newpage ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3105:1: ( Newpage )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3105:1: ( Newpage )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3106:1: Newpage
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,Newpage,FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl6533); 
             after(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Newpage__Group__0__Impl"


    // $ANTLR start "rule__Newpage__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3119:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3123:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3124:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__16564);
            rule__Newpage__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Newpage__Group__1"


    // $ANTLR start "rule__Newpage__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3130:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3134:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3135:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3135:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3136:1: ( RULE_ID )*
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3137:1: ( RULE_ID )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3137:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl6592); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Newpage__Group__1__Impl"


    // $ANTLR start "rule__AltElse__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3151:1: rule__AltElse__Group__0 : rule__AltElse__Group__0__Impl rule__AltElse__Group__1 ;
    public final void rule__AltElse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3155:1: ( rule__AltElse__Group__0__Impl rule__AltElse__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3156:2: rule__AltElse__Group__0__Impl rule__AltElse__Group__1
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__06627);
            rule__AltElse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__06630);
            rule__AltElse__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__0"


    // $ANTLR start "rule__AltElse__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3163:1: rule__AltElse__Group__0__Impl : ( Alt ) ;
    public final void rule__AltElse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3167:1: ( ( Alt ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3168:1: ( Alt )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3168:1: ( Alt )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3169:1: Alt
            {
             before(grammarAccess.getAltElseAccess().getAltKeyword_0()); 
            match(input,Alt,FOLLOW_Alt_in_rule__AltElse__Group__0__Impl6658); 
             after(grammarAccess.getAltElseAccess().getAltKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__0__Impl"


    // $ANTLR start "rule__AltElse__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3182:1: rule__AltElse__Group__1 : rule__AltElse__Group__1__Impl rule__AltElse__Group__2 ;
    public final void rule__AltElse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3186:1: ( rule__AltElse__Group__1__Impl rule__AltElse__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3187:2: rule__AltElse__Group__1__Impl rule__AltElse__Group__2
            {
            pushFollow(FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__16689);
            rule__AltElse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__16692);
            rule__AltElse__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__1"


    // $ANTLR start "rule__AltElse__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3194:1: rule__AltElse__Group__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__AltElse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3198:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3199:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3199:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3200:1: ( ruleMyID )*
            {
             before(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3201:1: ( ruleMyID )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=Autonumber && LA31_0<=Activate)||LA31_0==Critical||(LA31_0>=Destroy && LA31_0<=Create)||LA31_0==Legend||(LA31_0>=Break && LA31_0<=Over)||(LA31_0>=Alt && LA31_0<=Ref)||LA31_0==Of||(LA31_0>=NumberSign && LA31_0<=GreaterThanSign)||(LA31_0>=RULE_INT && LA31_0<=RULE_ID)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3201:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__AltElse__Group__1__Impl6720);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getMyIDParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__1__Impl"


    // $ANTLR start "rule__AltElse__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3211:1: rule__AltElse__Group__2 : rule__AltElse__Group__2__Impl rule__AltElse__Group__3 ;
    public final void rule__AltElse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3215:1: ( rule__AltElse__Group__2__Impl rule__AltElse__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3216:2: rule__AltElse__Group__2__Impl rule__AltElse__Group__3
            {
            pushFollow(FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__26751);
            rule__AltElse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__26754);
            rule__AltElse__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__2"


    // $ANTLR start "rule__AltElse__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3223:1: rule__AltElse__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__AltElse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3227:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3228:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3228:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3229:1: RULE_NEWLINE
            {
             before(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl6781); 
             after(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__2__Impl"


    // $ANTLR start "rule__AltElse__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3240:1: rule__AltElse__Group__3 : rule__AltElse__Group__3__Impl rule__AltElse__Group__4 ;
    public final void rule__AltElse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3244:1: ( rule__AltElse__Group__3__Impl rule__AltElse__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3245:2: rule__AltElse__Group__3__Impl rule__AltElse__Group__4
            {
            pushFollow(FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__36810);
            rule__AltElse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__36813);
            rule__AltElse__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__3"


    // $ANTLR start "rule__AltElse__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3252:1: rule__AltElse__Group__3__Impl : ( ( rule__AltElse__InstructionsAssignment_3 )* ) ;
    public final void rule__AltElse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3256:1: ( ( ( rule__AltElse__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3257:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3257:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3258:1: ( rule__AltElse__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getAltElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3259:1: ( rule__AltElse__InstructionsAssignment_3 )*
            loop32:
            do {
                int alt32=2;
                switch ( input.LA(1) ) {
                case Else:
                    {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==RULE_SEQUENCE) ) {
                        alt32=1;
                    }


                    }
                    break;
                case End:
                    {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==RULE_SEQUENCE) ) {
                        alt32=1;
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
                    alt32=1;
                    }
                    break;

                }

                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3259:2: rule__AltElse__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl6840);
            	    rule__AltElse__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getInstructionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__3__Impl"


    // $ANTLR start "rule__AltElse__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3269:1: rule__AltElse__Group__4 : rule__AltElse__Group__4__Impl rule__AltElse__Group__5 ;
    public final void rule__AltElse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3273:1: ( rule__AltElse__Group__4__Impl rule__AltElse__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3274:2: rule__AltElse__Group__4__Impl rule__AltElse__Group__5
            {
            pushFollow(FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__46871);
            rule__AltElse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__46874);
            rule__AltElse__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__4"


    // $ANTLR start "rule__AltElse__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3281:1: rule__AltElse__Group__4__Impl : ( ( rule__AltElse__ElsesAssignment_4 )* ) ;
    public final void rule__AltElse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3285:1: ( ( ( rule__AltElse__ElsesAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3286:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3286:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3287:1: ( rule__AltElse__ElsesAssignment_4 )*
            {
             before(grammarAccess.getAltElseAccess().getElsesAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3288:1: ( rule__AltElse__ElsesAssignment_4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==Else) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3288:2: rule__AltElse__ElsesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl6901);
            	    rule__AltElse__ElsesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getElsesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__4__Impl"


    // $ANTLR start "rule__AltElse__Group__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3298:1: rule__AltElse__Group__5 : rule__AltElse__Group__5__Impl ;
    public final void rule__AltElse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3302:1: ( rule__AltElse__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3303:2: rule__AltElse__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__56932);
            rule__AltElse__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__5"


    // $ANTLR start "rule__AltElse__Group__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3309:1: rule__AltElse__Group__5__Impl : ( End ) ;
    public final void rule__AltElse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3313:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3314:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3314:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3315:1: End
            {
             before(grammarAccess.getAltElseAccess().getEndKeyword_5()); 
            match(input,End,FOLLOW_End_in_rule__AltElse__Group__5__Impl6960); 
             after(grammarAccess.getAltElseAccess().getEndKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__Group__5__Impl"


    // $ANTLR start "rule__Else__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3340:1: rule__Else__Group__0 : rule__Else__Group__0__Impl rule__Else__Group__1 ;
    public final void rule__Else__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3344:1: ( rule__Else__Group__0__Impl rule__Else__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3345:2: rule__Else__Group__0__Impl rule__Else__Group__1
            {
            pushFollow(FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__07003);
            rule__Else__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__1_in_rule__Else__Group__07006);
            rule__Else__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__0"


    // $ANTLR start "rule__Else__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3352:1: rule__Else__Group__0__Impl : ( Else ) ;
    public final void rule__Else__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3356:1: ( ( Else ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3357:1: ( Else )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3357:1: ( Else )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3358:1: Else
            {
             before(grammarAccess.getElseAccess().getElseKeyword_0()); 
            match(input,Else,FOLLOW_Else_in_rule__Else__Group__0__Impl7034); 
             after(grammarAccess.getElseAccess().getElseKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__0__Impl"


    // $ANTLR start "rule__Else__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3371:1: rule__Else__Group__1 : rule__Else__Group__1__Impl rule__Else__Group__2 ;
    public final void rule__Else__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3375:1: ( rule__Else__Group__1__Impl rule__Else__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3376:2: rule__Else__Group__1__Impl rule__Else__Group__2
            {
            pushFollow(FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__17065);
            rule__Else__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__2_in_rule__Else__Group__17068);
            rule__Else__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__1"


    // $ANTLR start "rule__Else__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3383:1: rule__Else__Group__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Else__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3387:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3388:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3388:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3389:1: ( ruleMyID )*
            {
             before(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3390:1: ( ruleMyID )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=Autonumber && LA34_0<=Activate)||LA34_0==Critical||(LA34_0>=Destroy && LA34_0<=Create)||LA34_0==Legend||(LA34_0>=Break && LA34_0<=Over)||(LA34_0>=Alt && LA34_0<=Ref)||LA34_0==Of||(LA34_0>=NumberSign && LA34_0<=GreaterThanSign)||(LA34_0>=RULE_INT && LA34_0<=RULE_ID)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3390:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Else__Group__1__Impl7096);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getElseAccess().getMyIDParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__1__Impl"


    // $ANTLR start "rule__Else__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3400:1: rule__Else__Group__2 : rule__Else__Group__2__Impl rule__Else__Group__3 ;
    public final void rule__Else__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3404:1: ( rule__Else__Group__2__Impl rule__Else__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3405:2: rule__Else__Group__2__Impl rule__Else__Group__3
            {
            pushFollow(FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__27127);
            rule__Else__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__3_in_rule__Else__Group__27130);
            rule__Else__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__2"


    // $ANTLR start "rule__Else__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3412:1: rule__Else__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Else__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3416:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3417:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3417:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3418:1: RULE_NEWLINE
            {
             before(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl7157); 
             after(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__2__Impl"


    // $ANTLR start "rule__Else__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3429:1: rule__Else__Group__3 : rule__Else__Group__3__Impl ;
    public final void rule__Else__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3433:1: ( rule__Else__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3434:2: rule__Else__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__37186);
            rule__Else__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__3"


    // $ANTLR start "rule__Else__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3440:1: rule__Else__Group__3__Impl : ( ( rule__Else__InstructionsAssignment_3 )* ) ;
    public final void rule__Else__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3444:1: ( ( ( rule__Else__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3445:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3445:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3446:1: ( rule__Else__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3447:1: ( rule__Else__InstructionsAssignment_3 )*
            loop35:
            do {
                int alt35=2;
                switch ( input.LA(1) ) {
                case End:
                    {
                    int LA35_2 = input.LA(2);

                    if ( (LA35_2==RULE_SEQUENCE) ) {
                        alt35=1;
                    }


                    }
                    break;
                case Else:
                    {
                    int LA35_3 = input.LA(2);

                    if ( (LA35_3==RULE_SEQUENCE) ) {
                        alt35=1;
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
                    alt35=1;
                    }
                    break;

                }

                switch (alt35) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3447:2: rule__Else__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl7213);
            	    rule__Else__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getElseAccess().getInstructionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__Group__3__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3465:1: rule__GroupingMessages__Group__0 : rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 ;
    public final void rule__GroupingMessages__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3469:1: ( rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3470:2: rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__07252);
            rule__GroupingMessages__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__07255);
            rule__GroupingMessages__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__0"


    // $ANTLR start "rule__GroupingMessages__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3477:1: rule__GroupingMessages__Group__0__Impl : ( ( rule__GroupingMessages__Alternatives_0 ) ) ;
    public final void rule__GroupingMessages__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3481:1: ( ( ( rule__GroupingMessages__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3482:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3482:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3483:1: ( rule__GroupingMessages__Alternatives_0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3484:1: ( rule__GroupingMessages__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3484:2: rule__GroupingMessages__Alternatives_0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl7282);
            rule__GroupingMessages__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getGroupingMessagesAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__0__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3494:1: rule__GroupingMessages__Group__1 : rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 ;
    public final void rule__GroupingMessages__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3498:1: ( rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3499:2: rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__17312);
            rule__GroupingMessages__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__17315);
            rule__GroupingMessages__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__1"


    // $ANTLR start "rule__GroupingMessages__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3506:1: rule__GroupingMessages__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__GroupingMessages__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3510:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3511:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3511:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3512:1: ( RULE_ID )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3513:1: ( RULE_ID )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3513:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl7343); 

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__1__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3523:1: rule__GroupingMessages__Group__2 : rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 ;
    public final void rule__GroupingMessages__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3527:1: ( rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3528:2: rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__27374);
            rule__GroupingMessages__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__27377);
            rule__GroupingMessages__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__2"


    // $ANTLR start "rule__GroupingMessages__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3535:1: rule__GroupingMessages__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__GroupingMessages__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3539:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3540:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3540:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3541:1: RULE_NEWLINE
            {
             before(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl7404); 
             after(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__2__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3552:1: rule__GroupingMessages__Group__3 : rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 ;
    public final void rule__GroupingMessages__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3556:1: ( rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3557:2: rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__37433);
            rule__GroupingMessages__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__37436);
            rule__GroupingMessages__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__3"


    // $ANTLR start "rule__GroupingMessages__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3564:1: rule__GroupingMessages__Group__3__Impl : ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) ;
    public final void rule__GroupingMessages__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3568:1: ( ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3569:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3569:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3570:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3571:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==End) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==RULE_SEQUENCE) ) {
                        alt37=1;
                    }


                }
                else if ( ((LA37_0>=Participant && LA37_0<=Box)||(LA37_0>=Opt && LA37_0<=VerticalLineVerticalLineVerticalLine)||LA37_0==EqualsSignEqualsSign||(LA37_0>=Of && LA37_0<=VerticalLineVerticalLine)||(LA37_0>=NumberSign && LA37_0<=RULE_NEWLINE)||(LA37_0>=RULE_INT && LA37_0<=RULE_ID)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3571:2: rule__GroupingMessages__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl7463);
            	    rule__GroupingMessages__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__3__Impl"


    // $ANTLR start "rule__GroupingMessages__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3581:1: rule__GroupingMessages__Group__4 : rule__GroupingMessages__Group__4__Impl ;
    public final void rule__GroupingMessages__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3585:1: ( rule__GroupingMessages__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3586:2: rule__GroupingMessages__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__47494);
            rule__GroupingMessages__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__4"


    // $ANTLR start "rule__GroupingMessages__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3592:1: rule__GroupingMessages__Group__4__Impl : ( End ) ;
    public final void rule__GroupingMessages__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3596:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3597:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3597:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3598:1: End
            {
             before(grammarAccess.getGroupingMessagesAccess().getEndKeyword_4()); 
            match(input,End,FOLLOW_End_in_rule__GroupingMessages__Group__4__Impl7522); 
             after(grammarAccess.getGroupingMessagesAccess().getEndKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__Group__4__Impl"


    // $ANTLR start "rule__Note__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3621:1: rule__Note__Group__0 : rule__Note__Group__0__Impl rule__Note__Group__1 ;
    public final void rule__Note__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3625:1: ( rule__Note__Group__0__Impl rule__Note__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3626:2: rule__Note__Group__0__Impl rule__Note__Group__1
            {
            pushFollow(FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__07563);
            rule__Note__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__1_in_rule__Note__Group__07566);
            rule__Note__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__0"


    // $ANTLR start "rule__Note__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3633:1: rule__Note__Group__0__Impl : ( Note ) ;
    public final void rule__Note__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3637:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3638:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3638:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3639:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_0()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group__0__Impl7594); 
             after(grammarAccess.getNoteAccess().getNoteKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__0__Impl"


    // $ANTLR start "rule__Note__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3652:1: rule__Note__Group__1 : rule__Note__Group__1__Impl rule__Note__Group__2 ;
    public final void rule__Note__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3656:1: ( rule__Note__Group__1__Impl rule__Note__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3657:2: rule__Note__Group__1__Impl rule__Note__Group__2
            {
            pushFollow(FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__17625);
            rule__Note__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__2_in_rule__Note__Group__17628);
            rule__Note__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__1"


    // $ANTLR start "rule__Note__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3664:1: rule__Note__Group__1__Impl : ( ( rule__Note__Alternatives_1 ) ) ;
    public final void rule__Note__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3668:1: ( ( ( rule__Note__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3669:1: ( ( rule__Note__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3669:1: ( ( rule__Note__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3670:1: ( rule__Note__Alternatives_1 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3671:1: ( rule__Note__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3671:2: rule__Note__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl7655);
            rule__Note__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__1__Impl"


    // $ANTLR start "rule__Note__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3681:1: rule__Note__Group__2 : rule__Note__Group__2__Impl rule__Note__Group__3 ;
    public final void rule__Note__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3685:1: ( rule__Note__Group__2__Impl rule__Note__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3686:2: rule__Note__Group__2__Impl rule__Note__Group__3
            {
            pushFollow(FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__27685);
            rule__Note__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__3_in_rule__Note__Group__27688);
            rule__Note__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__2"


    // $ANTLR start "rule__Note__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3693:1: rule__Note__Group__2__Impl : ( ( RULE_COLOR )* ) ;
    public final void rule__Note__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3697:1: ( ( ( RULE_COLOR )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3698:1: ( ( RULE_COLOR )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3698:1: ( ( RULE_COLOR )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3699:1: ( RULE_COLOR )*
            {
             before(grammarAccess.getNoteAccess().getCOLORTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3700:1: ( RULE_COLOR )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_COLOR) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3700:3: RULE_COLOR
            	    {
            	    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Note__Group__2__Impl7716); 

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getCOLORTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__2__Impl"


    // $ANTLR start "rule__Note__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3710:1: rule__Note__Group__3 : rule__Note__Group__3__Impl ;
    public final void rule__Note__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3714:1: ( rule__Note__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3715:2: rule__Note__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__37747);
            rule__Note__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__3"


    // $ANTLR start "rule__Note__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3721:1: rule__Note__Group__3__Impl : ( ( rule__Note__Alternatives_3 ) ) ;
    public final void rule__Note__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3725:1: ( ( ( rule__Note__Alternatives_3 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3726:1: ( ( rule__Note__Alternatives_3 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3726:1: ( ( rule__Note__Alternatives_3 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3727:1: ( rule__Note__Alternatives_3 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3728:1: ( rule__Note__Alternatives_3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3728:2: rule__Note__Alternatives_3
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl7774);
            rule__Note__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group__3__Impl"


    // $ANTLR start "rule__Note__Group_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3746:1: rule__Note__Group_1_0__0 : rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 ;
    public final void rule__Note__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3750:1: ( rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3751:2: rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__07812);
            rule__Note__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__07815);
            rule__Note__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0__0"


    // $ANTLR start "rule__Note__Group_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3758:1: rule__Note__Group_1_0__0__Impl : ( Right ) ;
    public final void rule__Note__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3762:1: ( ( Right ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3763:1: ( Right )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3763:1: ( Right )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3764:1: Right
            {
             before(grammarAccess.getNoteAccess().getRightKeyword_1_0_0()); 
            match(input,Right,FOLLOW_Right_in_rule__Note__Group_1_0__0__Impl7843); 
             after(grammarAccess.getNoteAccess().getRightKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0__0__Impl"


    // $ANTLR start "rule__Note__Group_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3777:1: rule__Note__Group_1_0__1 : rule__Note__Group_1_0__1__Impl ;
    public final void rule__Note__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3781:1: ( rule__Note__Group_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3782:2: rule__Note__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__17874);
            rule__Note__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0__1"


    // $ANTLR start "rule__Note__Group_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3788:1: rule__Note__Group_1_0__1__Impl : ( ( rule__Note__Group_1_0_1__0 )? ) ;
    public final void rule__Note__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3792:1: ( ( ( rule__Note__Group_1_0_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3793:1: ( ( rule__Note__Group_1_0_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3793:1: ( ( rule__Note__Group_1_0_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3794:1: ( rule__Note__Group_1_0_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3795:1: ( rule__Note__Group_1_0_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==Of) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3795:2: rule__Note__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl7901);
                    rule__Note__Group_1_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNoteAccess().getGroup_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0__1__Impl"


    // $ANTLR start "rule__Note__Group_1_0_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3809:1: rule__Note__Group_1_0_1__0 : rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 ;
    public final void rule__Note__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3813:1: ( rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3814:2: rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__07936);
            rule__Note__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__07939);
            rule__Note__Group_1_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1__0"


    // $ANTLR start "rule__Note__Group_1_0_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3821:1: rule__Note__Group_1_0_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3825:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3826:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3826:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3827:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_1_0_1__0__Impl7967); 
             after(grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1__0__Impl"


    // $ANTLR start "rule__Note__Group_1_0_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3840:1: rule__Note__Group_1_0_1__1 : rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 ;
    public final void rule__Note__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3844:1: ( rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3845:2: rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__17998);
            rule__Note__Group_1_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__18001);
            rule__Note__Group_1_0_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1__1"


    // $ANTLR start "rule__Note__Group_1_0_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3852:1: rule__Note__Group_1_0_1__1__Impl : ( ( rule__Note__RidAssignment_1_0_1_1 ) ) ;
    public final void rule__Note__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3856:1: ( ( ( rule__Note__RidAssignment_1_0_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3857:1: ( ( rule__Note__RidAssignment_1_0_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3857:1: ( ( rule__Note__RidAssignment_1_0_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3858:1: ( rule__Note__RidAssignment_1_0_1_1 )
            {
             before(grammarAccess.getNoteAccess().getRidAssignment_1_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3859:1: ( rule__Note__RidAssignment_1_0_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3859:2: rule__Note__RidAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_rule__Note__RidAssignment_1_0_1_1_in_rule__Note__Group_1_0_1__1__Impl8028);
            rule__Note__RidAssignment_1_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getRidAssignment_1_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1__1__Impl"


    // $ANTLR start "rule__Note__Group_1_0_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3869:1: rule__Note__Group_1_0_1__2 : rule__Note__Group_1_0_1__2__Impl ;
    public final void rule__Note__Group_1_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3873:1: ( rule__Note__Group_1_0_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3874:2: rule__Note__Group_1_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__28058);
            rule__Note__Group_1_0_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1__2"


    // $ANTLR start "rule__Note__Group_1_0_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3880:1: rule__Note__Group_1_0_1__2__Impl : ( ( rule__Note__Group_1_0_1_2__0 )* ) ;
    public final void rule__Note__Group_1_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3884:1: ( ( ( rule__Note__Group_1_0_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3885:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3885:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3886:1: ( rule__Note__Group_1_0_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3887:1: ( rule__Note__Group_1_0_1_2__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==Comma) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3887:2: rule__Note__Group_1_0_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl8085);
            	    rule__Note__Group_1_0_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_1_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1__2__Impl"


    // $ANTLR start "rule__Note__Group_1_0_1_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3903:1: rule__Note__Group_1_0_1_2__0 : rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 ;
    public final void rule__Note__Group_1_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3907:1: ( rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3908:2: rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__08122);
            rule__Note__Group_1_0_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__08125);
            rule__Note__Group_1_0_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1_2__0"


    // $ANTLR start "rule__Note__Group_1_0_1_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3915:1: rule__Note__Group_1_0_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3919:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3920:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3920:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3921:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_0_1_2__0__Impl8153); 
             after(grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1_2__0__Impl"


    // $ANTLR start "rule__Note__Group_1_0_1_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3934:1: rule__Note__Group_1_0_1_2__1 : rule__Note__Group_1_0_1_2__1__Impl ;
    public final void rule__Note__Group_1_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3938:1: ( rule__Note__Group_1_0_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3939:2: rule__Note__Group_1_0_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__18184);
            rule__Note__Group_1_0_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1_2__1"


    // $ANTLR start "rule__Note__Group_1_0_1_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3945:1: rule__Note__Group_1_0_1_2__1__Impl : ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) ) ;
    public final void rule__Note__Group_1_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3949:1: ( ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3950:1: ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3950:1: ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3951:1: ( rule__Note__RidsAssignment_1_0_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getRidsAssignment_1_0_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3952:1: ( rule__Note__RidsAssignment_1_0_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3952:2: rule__Note__RidsAssignment_1_0_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__RidsAssignment_1_0_1_2_1_in_rule__Note__Group_1_0_1_2__1__Impl8211);
            rule__Note__RidsAssignment_1_0_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getRidsAssignment_1_0_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_0_1_2__1__Impl"


    // $ANTLR start "rule__Note__Group_1_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3966:1: rule__Note__Group_1_1__0 : rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 ;
    public final void rule__Note__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3970:1: ( rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3971:2: rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__08245);
            rule__Note__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__08248);
            rule__Note__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1__0"


    // $ANTLR start "rule__Note__Group_1_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3978:1: rule__Note__Group_1_1__0__Impl : ( Left ) ;
    public final void rule__Note__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3982:1: ( ( Left ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3983:1: ( Left )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3983:1: ( Left )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3984:1: Left
            {
             before(grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()); 
            match(input,Left,FOLLOW_Left_in_rule__Note__Group_1_1__0__Impl8276); 
             after(grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1__0__Impl"


    // $ANTLR start "rule__Note__Group_1_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3997:1: rule__Note__Group_1_1__1 : rule__Note__Group_1_1__1__Impl ;
    public final void rule__Note__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4001:1: ( rule__Note__Group_1_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4002:2: rule__Note__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__18307);
            rule__Note__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1__1"


    // $ANTLR start "rule__Note__Group_1_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4008:1: rule__Note__Group_1_1__1__Impl : ( ( rule__Note__Group_1_1_1__0 )? ) ;
    public final void rule__Note__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4012:1: ( ( ( rule__Note__Group_1_1_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4013:1: ( ( rule__Note__Group_1_1_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4013:1: ( ( rule__Note__Group_1_1_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4014:1: ( rule__Note__Group_1_1_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4015:1: ( rule__Note__Group_1_1_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==Of) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4015:2: rule__Note__Group_1_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl8334);
                    rule__Note__Group_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNoteAccess().getGroup_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1__1__Impl"


    // $ANTLR start "rule__Note__Group_1_1_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4029:1: rule__Note__Group_1_1_1__0 : rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 ;
    public final void rule__Note__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4033:1: ( rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4034:2: rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__08369);
            rule__Note__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__08372);
            rule__Note__Group_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1__0"


    // $ANTLR start "rule__Note__Group_1_1_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4041:1: rule__Note__Group_1_1_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4045:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4046:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4046:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4047:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_1_1_1__0__Impl8400); 
             after(grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1__0__Impl"


    // $ANTLR start "rule__Note__Group_1_1_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4060:1: rule__Note__Group_1_1_1__1 : rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 ;
    public final void rule__Note__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4064:1: ( rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4065:2: rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__18431);
            rule__Note__Group_1_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__18434);
            rule__Note__Group_1_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1__1"


    // $ANTLR start "rule__Note__Group_1_1_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4072:1: rule__Note__Group_1_1_1__1__Impl : ( ( rule__Note__LidAssignment_1_1_1_1 ) ) ;
    public final void rule__Note__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4076:1: ( ( ( rule__Note__LidAssignment_1_1_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4077:1: ( ( rule__Note__LidAssignment_1_1_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4077:1: ( ( rule__Note__LidAssignment_1_1_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4078:1: ( rule__Note__LidAssignment_1_1_1_1 )
            {
             before(grammarAccess.getNoteAccess().getLidAssignment_1_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4079:1: ( rule__Note__LidAssignment_1_1_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4079:2: rule__Note__LidAssignment_1_1_1_1
            {
            pushFollow(FOLLOW_rule__Note__LidAssignment_1_1_1_1_in_rule__Note__Group_1_1_1__1__Impl8461);
            rule__Note__LidAssignment_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getLidAssignment_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1__1__Impl"


    // $ANTLR start "rule__Note__Group_1_1_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4089:1: rule__Note__Group_1_1_1__2 : rule__Note__Group_1_1_1__2__Impl ;
    public final void rule__Note__Group_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4093:1: ( rule__Note__Group_1_1_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4094:2: rule__Note__Group_1_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__28491);
            rule__Note__Group_1_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1__2"


    // $ANTLR start "rule__Note__Group_1_1_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4100:1: rule__Note__Group_1_1_1__2__Impl : ( ( rule__Note__Group_1_1_1_2__0 )* ) ;
    public final void rule__Note__Group_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4104:1: ( ( ( rule__Note__Group_1_1_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4105:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4105:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4106:1: ( rule__Note__Group_1_1_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4107:1: ( rule__Note__Group_1_1_1_2__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==Comma) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4107:2: rule__Note__Group_1_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl8518);
            	    rule__Note__Group_1_1_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_1_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1__2__Impl"


    // $ANTLR start "rule__Note__Group_1_1_1_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4123:1: rule__Note__Group_1_1_1_2__0 : rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 ;
    public final void rule__Note__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4127:1: ( rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4128:2: rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__08555);
            rule__Note__Group_1_1_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__08558);
            rule__Note__Group_1_1_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1_2__0"


    // $ANTLR start "rule__Note__Group_1_1_1_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4135:1: rule__Note__Group_1_1_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4139:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4140:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4140:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4141:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_1_1_2__0__Impl8586); 
             after(grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1_2__0__Impl"


    // $ANTLR start "rule__Note__Group_1_1_1_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4154:1: rule__Note__Group_1_1_1_2__1 : rule__Note__Group_1_1_1_2__1__Impl ;
    public final void rule__Note__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4158:1: ( rule__Note__Group_1_1_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4159:2: rule__Note__Group_1_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__18617);
            rule__Note__Group_1_1_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1_2__1"


    // $ANTLR start "rule__Note__Group_1_1_1_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4165:1: rule__Note__Group_1_1_1_2__1__Impl : ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) ) ;
    public final void rule__Note__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4169:1: ( ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4170:1: ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4170:1: ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4171:1: ( rule__Note__LidsAssignment_1_1_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getLidsAssignment_1_1_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4172:1: ( rule__Note__LidsAssignment_1_1_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4172:2: rule__Note__LidsAssignment_1_1_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__LidsAssignment_1_1_1_2_1_in_rule__Note__Group_1_1_1_2__1__Impl8644);
            rule__Note__LidsAssignment_1_1_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getLidsAssignment_1_1_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_1_1_2__1__Impl"


    // $ANTLR start "rule__Note__Group_1_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4186:1: rule__Note__Group_1_2__0 : rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 ;
    public final void rule__Note__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4190:1: ( rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4191:2: rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__08678);
            rule__Note__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__08681);
            rule__Note__Group_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2__0"


    // $ANTLR start "rule__Note__Group_1_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4198:1: rule__Note__Group_1_2__0__Impl : ( Over ) ;
    public final void rule__Note__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4202:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4203:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4203:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4204:1: Over
            {
             before(grammarAccess.getNoteAccess().getOverKeyword_1_2_0()); 
            match(input,Over,FOLLOW_Over_in_rule__Note__Group_1_2__0__Impl8709); 
             after(grammarAccess.getNoteAccess().getOverKeyword_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2__0__Impl"


    // $ANTLR start "rule__Note__Group_1_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4217:1: rule__Note__Group_1_2__1 : rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 ;
    public final void rule__Note__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4221:1: ( rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4222:2: rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__18740);
            rule__Note__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__18743);
            rule__Note__Group_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2__1"


    // $ANTLR start "rule__Note__Group_1_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4229:1: rule__Note__Group_1_2__1__Impl : ( ( rule__Note__OidAssignment_1_2_1 ) ) ;
    public final void rule__Note__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4233:1: ( ( ( rule__Note__OidAssignment_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4234:1: ( ( rule__Note__OidAssignment_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4234:1: ( ( rule__Note__OidAssignment_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4235:1: ( rule__Note__OidAssignment_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidAssignment_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4236:1: ( rule__Note__OidAssignment_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4236:2: rule__Note__OidAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidAssignment_1_2_1_in_rule__Note__Group_1_2__1__Impl8770);
            rule__Note__OidAssignment_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getOidAssignment_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2__1__Impl"


    // $ANTLR start "rule__Note__Group_1_2__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4246:1: rule__Note__Group_1_2__2 : rule__Note__Group_1_2__2__Impl ;
    public final void rule__Note__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4250:1: ( rule__Note__Group_1_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4251:2: rule__Note__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__28800);
            rule__Note__Group_1_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2__2"


    // $ANTLR start "rule__Note__Group_1_2__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4257:1: rule__Note__Group_1_2__2__Impl : ( ( rule__Note__Group_1_2_2__0 )* ) ;
    public final void rule__Note__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4261:1: ( ( ( rule__Note__Group_1_2_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4262:1: ( ( rule__Note__Group_1_2_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4262:1: ( ( rule__Note__Group_1_2_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4263:1: ( rule__Note__Group_1_2_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4264:1: ( rule__Note__Group_1_2_2__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==Comma) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4264:2: rule__Note__Group_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl8827);
            	    rule__Note__Group_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2__2__Impl"


    // $ANTLR start "rule__Note__Group_1_2_2__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4280:1: rule__Note__Group_1_2_2__0 : rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 ;
    public final void rule__Note__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4284:1: ( rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4285:2: rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__08864);
            rule__Note__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__08867);
            rule__Note__Group_1_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2_2__0"


    // $ANTLR start "rule__Note__Group_1_2_2__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4292:1: rule__Note__Group_1_2_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4296:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4297:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4297:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4298:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_2_2__0__Impl8895); 
             after(grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2_2__0__Impl"


    // $ANTLR start "rule__Note__Group_1_2_2__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4311:1: rule__Note__Group_1_2_2__1 : rule__Note__Group_1_2_2__1__Impl ;
    public final void rule__Note__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4315:1: ( rule__Note__Group_1_2_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4316:2: rule__Note__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__18926);
            rule__Note__Group_1_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2_2__1"


    // $ANTLR start "rule__Note__Group_1_2_2__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4322:1: rule__Note__Group_1_2_2__1__Impl : ( ( rule__Note__OidsAssignment_1_2_2_1 ) ) ;
    public final void rule__Note__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4326:1: ( ( ( rule__Note__OidsAssignment_1_2_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4327:1: ( ( rule__Note__OidsAssignment_1_2_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4327:1: ( ( rule__Note__OidsAssignment_1_2_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4328:1: ( rule__Note__OidsAssignment_1_2_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidsAssignment_1_2_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4329:1: ( rule__Note__OidsAssignment_1_2_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4329:2: rule__Note__OidsAssignment_1_2_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidsAssignment_1_2_2_1_in_rule__Note__Group_1_2_2__1__Impl8953);
            rule__Note__OidsAssignment_1_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNoteAccess().getOidsAssignment_1_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_1_2_2__1__Impl"


    // $ANTLR start "rule__Note__Group_3_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4343:1: rule__Note__Group_3_0__0 : rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 ;
    public final void rule__Note__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4347:1: ( rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4348:2: rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__08987);
            rule__Note__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__08990);
            rule__Note__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_0__0"


    // $ANTLR start "rule__Note__Group_3_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4355:1: rule__Note__Group_3_0__0__Impl : ( Colon ) ;
    public final void rule__Note__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4359:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4360:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4360:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4361:1: Colon
            {
             before(grammarAccess.getNoteAccess().getColonKeyword_3_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Note__Group_3_0__0__Impl9018); 
             after(grammarAccess.getNoteAccess().getColonKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_0__0__Impl"


    // $ANTLR start "rule__Note__Group_3_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4374:1: rule__Note__Group_3_0__1 : rule__Note__Group_3_0__1__Impl ;
    public final void rule__Note__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4378:1: ( rule__Note__Group_3_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4379:2: rule__Note__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__19049);
            rule__Note__Group_3_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_0__1"


    // $ANTLR start "rule__Note__Group_3_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4385:1: rule__Note__Group_3_0__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Note__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4389:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4390:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4390:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4391:1: ( ruleMyID )*
            {
             before(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4392:1: ( ruleMyID )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=Autonumber && LA44_0<=Activate)||LA44_0==Critical||(LA44_0>=Destroy && LA44_0<=Create)||LA44_0==Legend||(LA44_0>=Break && LA44_0<=Over)||(LA44_0>=Alt && LA44_0<=Ref)||LA44_0==Of||(LA44_0>=NumberSign && LA44_0<=GreaterThanSign)||(LA44_0>=RULE_INT && LA44_0<=RULE_ID)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4392:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Note__Group_3_0__1__Impl9077);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getMyIDParserRuleCall_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_0__1__Impl"


    // $ANTLR start "rule__Note__Group_3_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4406:1: rule__Note__Group_3_1__0 : rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 ;
    public final void rule__Note__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4410:1: ( rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4411:2: rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__09112);
            rule__Note__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__09115);
            rule__Note__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1__0"


    // $ANTLR start "rule__Note__Group_3_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4418:1: rule__Note__Group_3_1__0__Impl : ( ( rule__Note__Group_3_1_0__0 )* ) ;
    public final void rule__Note__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4422:1: ( ( ( rule__Note__Group_3_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4423:1: ( ( rule__Note__Group_3_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4423:1: ( ( rule__Note__Group_3_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4424:1: ( rule__Note__Group_3_1_0__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4425:1: ( rule__Note__Group_3_1_0__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NEWLINE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4425:2: rule__Note__Group_3_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl9142);
            	    rule__Note__Group_3_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getGroup_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1__0__Impl"


    // $ANTLR start "rule__Note__Group_3_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4435:1: rule__Note__Group_3_1__1 : rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 ;
    public final void rule__Note__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4439:1: ( rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4440:2: rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__19173);
            rule__Note__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__19176);
            rule__Note__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1__1"


    // $ANTLR start "rule__Note__Group_3_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4447:1: rule__Note__Group_3_1__1__Impl : ( End ) ;
    public final void rule__Note__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4451:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4452:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4452:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4453:1: End
            {
             before(grammarAccess.getNoteAccess().getEndKeyword_3_1_1()); 
            match(input,End,FOLLOW_End_in_rule__Note__Group_3_1__1__Impl9204); 
             after(grammarAccess.getNoteAccess().getEndKeyword_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1__1__Impl"


    // $ANTLR start "rule__Note__Group_3_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4466:1: rule__Note__Group_3_1__2 : rule__Note__Group_3_1__2__Impl ;
    public final void rule__Note__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4470:1: ( rule__Note__Group_3_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4471:2: rule__Note__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__29235);
            rule__Note__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1__2"


    // $ANTLR start "rule__Note__Group_3_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4477:1: rule__Note__Group_3_1__2__Impl : ( Note ) ;
    public final void rule__Note__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4481:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4482:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4482:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4483:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_3_1_2()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group_3_1__2__Impl9263); 
             after(grammarAccess.getNoteAccess().getNoteKeyword_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1__2__Impl"


    // $ANTLR start "rule__Note__Group_3_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4502:1: rule__Note__Group_3_1_0__0 : rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 ;
    public final void rule__Note__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4506:1: ( rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4507:2: rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__09300);
            rule__Note__Group_3_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__09303);
            rule__Note__Group_3_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1_0__0"


    // $ANTLR start "rule__Note__Group_3_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4514:1: rule__Note__Group_3_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4518:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4519:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4519:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4520:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl9330); 
             after(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1_0__0__Impl"


    // $ANTLR start "rule__Note__Group_3_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4531:1: rule__Note__Group_3_1_0__1 : rule__Note__Group_3_1_0__1__Impl ;
    public final void rule__Note__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4535:1: ( rule__Note__Group_3_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4536:2: rule__Note__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__19359);
            rule__Note__Group_3_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1_0__1"


    // $ANTLR start "rule__Note__Group_3_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4542:1: rule__Note__Group_3_1_0__1__Impl : ( ( ruleEndID )* ) ;
    public final void rule__Note__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4546:1: ( ( ( ruleEndID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4547:1: ( ( ruleEndID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4547:1: ( ( ruleEndID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4548:1: ( ruleEndID )*
            {
             before(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4549:1: ( ruleEndID )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=Autonumber && LA46_0<=Activate)||LA46_0==Critical||(LA46_0>=Destroy && LA46_0<=Create)||LA46_0==Legend||(LA46_0>=Break && LA46_0<=Over)||(LA46_0>=Alt && LA46_0<=Box)||(LA46_0>=Opt && LA46_0<=Ref)||LA46_0==Of||(LA46_0>=NumberSign && LA46_0<=GreaterThanSign)||(LA46_0>=RULE_INT && LA46_0<=RULE_ID)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4549:3: ruleEndID
            	    {
            	    pushFollow(FOLLOW_ruleEndID_in_rule__Note__Group_3_1_0__1__Impl9387);
            	    ruleEndID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getEndIDParserRuleCall_3_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__Group_3_1_0__1__Impl"


    // $ANTLR start "rule__Divider__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4563:1: rule__Divider__Group__0 : rule__Divider__Group__0__Impl rule__Divider__Group__1 ;
    public final void rule__Divider__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4567:1: ( rule__Divider__Group__0__Impl rule__Divider__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4568:2: rule__Divider__Group__0__Impl rule__Divider__Group__1
            {
            pushFollow(FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__09422);
            rule__Divider__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__09425);
            rule__Divider__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Divider__Group__0"


    // $ANTLR start "rule__Divider__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4575:1: rule__Divider__Group__0__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4579:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4580:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4580:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4581:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl9453); 
             after(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Divider__Group__0__Impl"


    // $ANTLR start "rule__Divider__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4594:1: rule__Divider__Group__1 : rule__Divider__Group__1__Impl rule__Divider__Group__2 ;
    public final void rule__Divider__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4598:1: ( rule__Divider__Group__1__Impl rule__Divider__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4599:2: rule__Divider__Group__1__Impl rule__Divider__Group__2
            {
            pushFollow(FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__19484);
            rule__Divider__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__19487);
            rule__Divider__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Divider__Group__1"


    // $ANTLR start "rule__Divider__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4606:1: rule__Divider__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Divider__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4610:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4611:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4611:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4612:1: ( RULE_ID )*
            {
             before(grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4613:1: ( RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_ID) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4613:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl9515); 

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Divider__Group__1__Impl"


    // $ANTLR start "rule__Divider__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4623:1: rule__Divider__Group__2 : rule__Divider__Group__2__Impl ;
    public final void rule__Divider__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4627:1: ( rule__Divider__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4628:2: rule__Divider__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__29546);
            rule__Divider__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Divider__Group__2"


    // $ANTLR start "rule__Divider__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4634:1: rule__Divider__Group__2__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4638:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4639:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4639:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4640:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl9574); 
             after(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Divider__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4659:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4663:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4664:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__09611);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__09614);
            rule__Reference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0"


    // $ANTLR start "rule__Reference__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4671:1: rule__Reference__Group__0__Impl : ( Ref ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4675:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4676:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4676:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4677:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group__0__Impl9642); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__0__Impl"


    // $ANTLR start "rule__Reference__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4690:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4694:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4695:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__19673);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__19676);
            rule__Reference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1"


    // $ANTLR start "rule__Reference__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4702:1: rule__Reference__Group__1__Impl : ( Over ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4706:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4707:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4707:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4708:1: Over
            {
             before(grammarAccess.getReferenceAccess().getOverKeyword_1()); 
            match(input,Over,FOLLOW_Over_in_rule__Reference__Group__1__Impl9704); 
             after(grammarAccess.getReferenceAccess().getOverKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__1__Impl"


    // $ANTLR start "rule__Reference__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4721:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4725:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4726:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__29735);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__29738);
            rule__Reference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2"


    // $ANTLR start "rule__Reference__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4733:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__IdAssignment_2 ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4737:1: ( ( ( rule__Reference__IdAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4738:1: ( ( rule__Reference__IdAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4738:1: ( ( rule__Reference__IdAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4739:1: ( rule__Reference__IdAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getIdAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4740:1: ( rule__Reference__IdAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4740:2: rule__Reference__IdAssignment_2
            {
            pushFollow(FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl9765);
            rule__Reference__IdAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getIdAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__2__Impl"


    // $ANTLR start "rule__Reference__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4750:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4754:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4755:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__39795);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__39798);
            rule__Reference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3"


    // $ANTLR start "rule__Reference__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4762:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__Group_3__0 )* ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4766:1: ( ( ( rule__Reference__Group_3__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4767:1: ( ( rule__Reference__Group_3__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4767:1: ( ( rule__Reference__Group_3__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4768:1: ( rule__Reference__Group_3__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4769:1: ( rule__Reference__Group_3__0 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==Comma) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4769:2: rule__Reference__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl9825);
            	    rule__Reference__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__3__Impl"


    // $ANTLR start "rule__Reference__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4779:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4783:1: ( rule__Reference__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4784:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__49856);
            rule__Reference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4"


    // $ANTLR start "rule__Reference__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4790:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4794:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4795:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4795:1: ( ( rule__Reference__Alternatives_4 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4796:1: ( rule__Reference__Alternatives_4 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4797:1: ( rule__Reference__Alternatives_4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4797:2: rule__Reference__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl9883);
            rule__Reference__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group__4__Impl"


    // $ANTLR start "rule__Reference__Group_3__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4817:1: rule__Reference__Group_3__0 : rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 ;
    public final void rule__Reference__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4821:1: ( rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4822:2: rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__09923);
            rule__Reference__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__09926);
            rule__Reference__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__0"


    // $ANTLR start "rule__Reference__Group_3__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4829:1: rule__Reference__Group_3__0__Impl : ( Comma ) ;
    public final void rule__Reference__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4833:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4834:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4834:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4835:1: Comma
            {
             before(grammarAccess.getReferenceAccess().getCommaKeyword_3_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl9954); 
             after(grammarAccess.getReferenceAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__0__Impl"


    // $ANTLR start "rule__Reference__Group_3__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4848:1: rule__Reference__Group_3__1 : rule__Reference__Group_3__1__Impl ;
    public final void rule__Reference__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4852:1: ( rule__Reference__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4853:2: rule__Reference__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__19985);
            rule__Reference__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__1"


    // $ANTLR start "rule__Reference__Group_3__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4859:1: rule__Reference__Group_3__1__Impl : ( ( rule__Reference__IdsAssignment_3_1 ) ) ;
    public final void rule__Reference__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4863:1: ( ( ( rule__Reference__IdsAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4864:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4864:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4865:1: ( rule__Reference__IdsAssignment_3_1 )
            {
             before(grammarAccess.getReferenceAccess().getIdsAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4866:1: ( rule__Reference__IdsAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4866:2: rule__Reference__IdsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl10012);
            rule__Reference__IdsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getIdsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_3__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4880:1: rule__Reference__Group_4_0__0 : rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4884:1: ( rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4885:2: rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__010046);
            rule__Reference__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__010049);
            rule__Reference__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0"


    // $ANTLR start "rule__Reference__Group_4_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4892:1: rule__Reference__Group_4_0__0__Impl : ( Colon ) ;
    public final void rule__Reference__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4896:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4897:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4897:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4898:1: Colon
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl10077); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4911:1: rule__Reference__Group_4_0__1 : rule__Reference__Group_4_0__1__Impl ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4915:1: ( rule__Reference__Group_4_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4916:2: rule__Reference__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__110108);
            rule__Reference__Group_4_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1"


    // $ANTLR start "rule__Reference__Group_4_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4922:1: rule__Reference__Group_4_0__1__Impl : ( ( ruleMyID )* ) ;
    public final void rule__Reference__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4926:1: ( ( ( ruleMyID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4927:1: ( ( ruleMyID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4927:1: ( ( ruleMyID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4928:1: ( ruleMyID )*
            {
             before(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4929:1: ( ruleMyID )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=Autonumber && LA49_0<=Activate)||LA49_0==Critical||(LA49_0>=Destroy && LA49_0<=Create)||LA49_0==Legend||(LA49_0>=Break && LA49_0<=Over)||(LA49_0>=Alt && LA49_0<=Ref)||LA49_0==Of||(LA49_0>=NumberSign && LA49_0<=GreaterThanSign)||(LA49_0>=RULE_INT && LA49_0<=RULE_ID)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4929:3: ruleMyID
            	    {
            	    pushFollow(FOLLOW_ruleMyID_in_rule__Reference__Group_4_0__1__Impl10136);
            	    ruleMyID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getMyIDParserRuleCall_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_0__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4943:1: rule__Reference__Group_4_1__0 : rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 ;
    public final void rule__Reference__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4947:1: ( rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4948:2: rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__010171);
            rule__Reference__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__010174);
            rule__Reference__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__0"


    // $ANTLR start "rule__Reference__Group_4_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4955:1: rule__Reference__Group_4_1__0__Impl : ( ( rule__Reference__Group_4_1_0__0 )* ) ;
    public final void rule__Reference__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4959:1: ( ( ( rule__Reference__Group_4_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4960:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4960:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4961:1: ( rule__Reference__Group_4_1_0__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_4_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4962:1: ( rule__Reference__Group_4_1_0__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_NEWLINE) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4962:2: rule__Reference__Group_4_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl10201);
            	    rule__Reference__Group_4_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getGroup_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4972:1: rule__Reference__Group_4_1__1 : rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 ;
    public final void rule__Reference__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4976:1: ( rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4977:2: rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__110232);
            rule__Reference__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__110235);
            rule__Reference__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__1"


    // $ANTLR start "rule__Reference__Group_4_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4984:1: rule__Reference__Group_4_1__1__Impl : ( End ) ;
    public final void rule__Reference__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4988:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4989:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4989:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4990:1: End
            {
             before(grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()); 
            match(input,End,FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl10263); 
             after(grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__1__Impl"


    // $ANTLR start "rule__Reference__Group_4_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5003:1: rule__Reference__Group_4_1__2 : rule__Reference__Group_4_1__2__Impl ;
    public final void rule__Reference__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5007:1: ( rule__Reference__Group_4_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5008:2: rule__Reference__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__210294);
            rule__Reference__Group_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__2"


    // $ANTLR start "rule__Reference__Group_4_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5014:1: rule__Reference__Group_4_1__2__Impl : ( Ref ) ;
    public final void rule__Reference__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5018:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5019:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5019:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5020:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_4_1_2()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl10322); 
             after(grammarAccess.getReferenceAccess().getRefKeyword_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1__2__Impl"


    // $ANTLR start "rule__Reference__Group_4_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5039:1: rule__Reference__Group_4_1_0__0 : rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 ;
    public final void rule__Reference__Group_4_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5043:1: ( rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5044:2: rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__010359);
            rule__Reference__Group_4_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__010362);
            rule__Reference__Group_4_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__0"


    // $ANTLR start "rule__Reference__Group_4_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5051:1: rule__Reference__Group_4_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Reference__Group_4_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5055:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5056:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5056:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5057:1: RULE_NEWLINE
            {
             before(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl10389); 
             after(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__0__Impl"


    // $ANTLR start "rule__Reference__Group_4_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5068:1: rule__Reference__Group_4_1_0__1 : rule__Reference__Group_4_1_0__1__Impl ;
    public final void rule__Reference__Group_4_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5072:1: ( rule__Reference__Group_4_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5073:2: rule__Reference__Group_4_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__110418);
            rule__Reference__Group_4_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__1"


    // $ANTLR start "rule__Reference__Group_4_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5079:1: rule__Reference__Group_4_1_0__1__Impl : ( ( ruleEndID )* ) ;
    public final void rule__Reference__Group_4_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5083:1: ( ( ( ruleEndID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5084:1: ( ( ruleEndID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5084:1: ( ( ruleEndID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5085:1: ( ruleEndID )*
            {
             before(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5086:1: ( ruleEndID )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=Autonumber && LA51_0<=Activate)||LA51_0==Critical||(LA51_0>=Destroy && LA51_0<=Create)||LA51_0==Legend||(LA51_0>=Break && LA51_0<=Over)||(LA51_0>=Alt && LA51_0<=Box)||(LA51_0>=Opt && LA51_0<=Ref)||LA51_0==Of||(LA51_0>=NumberSign && LA51_0<=GreaterThanSign)||(LA51_0>=RULE_INT && LA51_0<=RULE_ID)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5086:3: ruleEndID
            	    {
            	    pushFollow(FOLLOW_ruleEndID_in_rule__Reference__Group_4_1_0__1__Impl10446);
            	    ruleEndID();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getEndIDParserRuleCall_4_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Group_4_1_0__1__Impl"


    // $ANTLR start "rule__Delay__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5100:1: rule__Delay__Group__0 : rule__Delay__Group__0__Impl rule__Delay__Group__1 ;
    public final void rule__Delay__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5104:1: ( rule__Delay__Group__0__Impl rule__Delay__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5105:2: rule__Delay__Group__0__Impl rule__Delay__Group__1
            {
            pushFollow(FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__010481);
            rule__Delay__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__010484);
            rule__Delay__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group__0"


    // $ANTLR start "rule__Delay__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5112:1: rule__Delay__Group__0__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5116:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5117:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5117:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5118:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl10512); 
             after(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group__0__Impl"


    // $ANTLR start "rule__Delay__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5131:1: rule__Delay__Group__1 : rule__Delay__Group__1__Impl ;
    public final void rule__Delay__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5135:1: ( rule__Delay__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5136:2: rule__Delay__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__110543);
            rule__Delay__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group__1"


    // $ANTLR start "rule__Delay__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5142:1: rule__Delay__Group__1__Impl : ( ( rule__Delay__Group_1__0 )? ) ;
    public final void rule__Delay__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5146:1: ( ( ( rule__Delay__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5147:1: ( ( rule__Delay__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5147:1: ( ( rule__Delay__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5148:1: ( rule__Delay__Group_1__0 )?
            {
             before(grammarAccess.getDelayAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5149:1: ( rule__Delay__Group_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==FullStopFullStopFullStop||LA52_0==RULE_ID) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5149:2: rule__Delay__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl10570);
                    rule__Delay__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDelayAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group__1__Impl"


    // $ANTLR start "rule__Delay__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5163:1: rule__Delay__Group_1__0 : rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 ;
    public final void rule__Delay__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5167:1: ( rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5168:2: rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__010605);
            rule__Delay__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__010608);
            rule__Delay__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__0"


    // $ANTLR start "rule__Delay__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5175:1: rule__Delay__Group_1__0__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Delay__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5179:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5180:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5180:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5181:1: ( RULE_ID )*
            {
             before(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5182:1: ( RULE_ID )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5182:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl10636); 

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__0__Impl"


    // $ANTLR start "rule__Delay__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5192:1: rule__Delay__Group_1__1 : rule__Delay__Group_1__1__Impl ;
    public final void rule__Delay__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5196:1: ( rule__Delay__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5197:2: rule__Delay__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__110667);
            rule__Delay__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__1"


    // $ANTLR start "rule__Delay__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5203:1: rule__Delay__Group_1__1__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5207:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5208:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5208:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5209:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl10695); 
             after(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Delay__Group_1__1__Impl"


    // $ANTLR start "rule__Space__Group_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5226:1: rule__Space__Group_1__0 : rule__Space__Group_1__0__Impl rule__Space__Group_1__1 ;
    public final void rule__Space__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5230:1: ( rule__Space__Group_1__0__Impl rule__Space__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5231:2: rule__Space__Group_1__0__Impl rule__Space__Group_1__1
            {
            pushFollow(FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__010730);
            rule__Space__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__010733);
            rule__Space__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group_1__0"


    // $ANTLR start "rule__Space__Group_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5238:1: rule__Space__Group_1__0__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5242:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5243:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5243:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5244:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl10761); 
             after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group_1__0__Impl"


    // $ANTLR start "rule__Space__Group_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5257:1: rule__Space__Group_1__1 : rule__Space__Group_1__1__Impl rule__Space__Group_1__2 ;
    public final void rule__Space__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5261:1: ( rule__Space__Group_1__1__Impl rule__Space__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5262:2: rule__Space__Group_1__1__Impl rule__Space__Group_1__2
            {
            pushFollow(FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__110792);
            rule__Space__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__110795);
            rule__Space__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group_1__1"


    // $ANTLR start "rule__Space__Group_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5269:1: rule__Space__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Space__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5273:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5274:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5274:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5275:1: RULE_INT
            {
             before(grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl10822); 
             after(grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group_1__1__Impl"


    // $ANTLR start "rule__Space__Group_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5286:1: rule__Space__Group_1__2 : rule__Space__Group_1__2__Impl ;
    public final void rule__Space__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5290:1: ( rule__Space__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5291:2: rule__Space__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__210851);
            rule__Space__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group_1__2"


    // $ANTLR start "rule__Space__Group_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5297:1: rule__Space__Group_1__2__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5301:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5302:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5302:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5303:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl10879); 
             after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Space__Group_1__2__Impl"


    // $ANTLR start "rule__Hidefootbox__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5322:1: rule__Hidefootbox__Group__0 : rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 ;
    public final void rule__Hidefootbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5326:1: ( rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5327:2: rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__010916);
            rule__Hidefootbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__010919);
            rule__Hidefootbox__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__0"


    // $ANTLR start "rule__Hidefootbox__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5334:1: rule__Hidefootbox__Group__0__Impl : ( Hide ) ;
    public final void rule__Hidefootbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5338:1: ( ( Hide ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5339:1: ( Hide )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5339:1: ( Hide )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5340:1: Hide
            {
             before(grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
            match(input,Hide,FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl10947); 
             after(grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__0__Impl"


    // $ANTLR start "rule__Hidefootbox__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5353:1: rule__Hidefootbox__Group__1 : rule__Hidefootbox__Group__1__Impl ;
    public final void rule__Hidefootbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5357:1: ( rule__Hidefootbox__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5358:2: rule__Hidefootbox__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__110978);
            rule__Hidefootbox__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__1"


    // $ANTLR start "rule__Hidefootbox__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5364:1: rule__Hidefootbox__Group__1__Impl : ( Footbox ) ;
    public final void rule__Hidefootbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5368:1: ( ( Footbox ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5369:1: ( Footbox )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5369:1: ( Footbox )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5370:1: Footbox
            {
             before(grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 
            match(input,Footbox,FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl11006); 
             after(grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Hidefootbox__Group__1__Impl"


    // $ANTLR start "rule__Activate__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5387:1: rule__Activate__Group__0 : rule__Activate__Group__0__Impl rule__Activate__Group__1 ;
    public final void rule__Activate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5391:1: ( rule__Activate__Group__0__Impl rule__Activate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5392:2: rule__Activate__Group__0__Impl rule__Activate__Group__1
            {
            pushFollow(FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__011041);
            rule__Activate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__011044);
            rule__Activate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__0"


    // $ANTLR start "rule__Activate__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5399:1: rule__Activate__Group__0__Impl : ( Activate ) ;
    public final void rule__Activate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5403:1: ( ( Activate ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5404:1: ( Activate )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5404:1: ( Activate )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5405:1: Activate
            {
             before(grammarAccess.getActivateAccess().getActivateKeyword_0()); 
            match(input,Activate,FOLLOW_Activate_in_rule__Activate__Group__0__Impl11072); 
             after(grammarAccess.getActivateAccess().getActivateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__0__Impl"


    // $ANTLR start "rule__Activate__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5418:1: rule__Activate__Group__1 : rule__Activate__Group__1__Impl rule__Activate__Group__2 ;
    public final void rule__Activate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5422:1: ( rule__Activate__Group__1__Impl rule__Activate__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5423:2: rule__Activate__Group__1__Impl rule__Activate__Group__2
            {
            pushFollow(FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__111103);
            rule__Activate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__111106);
            rule__Activate__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__1"


    // $ANTLR start "rule__Activate__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5430:1: rule__Activate__Group__1__Impl : ( ( RULE_COLOR )? ) ;
    public final void rule__Activate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5434:1: ( ( ( RULE_COLOR )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5435:1: ( ( RULE_COLOR )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5435:1: ( ( RULE_COLOR )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5436:1: ( RULE_COLOR )?
            {
             before(grammarAccess.getActivateAccess().getCOLORTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5437:1: ( RULE_COLOR )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_COLOR) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5437:3: RULE_COLOR
                    {
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Activate__Group__1__Impl11134); 

                    }
                    break;

            }

             after(grammarAccess.getActivateAccess().getCOLORTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__1__Impl"


    // $ANTLR start "rule__Activate__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5447:1: rule__Activate__Group__2 : rule__Activate__Group__2__Impl ;
    public final void rule__Activate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5451:1: ( rule__Activate__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5452:2: rule__Activate__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__211165);
            rule__Activate__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__2"


    // $ANTLR start "rule__Activate__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5458:1: rule__Activate__Group__2__Impl : ( ( rule__Activate__NameAssignment_2 ) ) ;
    public final void rule__Activate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5462:1: ( ( ( rule__Activate__NameAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5463:1: ( ( rule__Activate__NameAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5463:1: ( ( rule__Activate__NameAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5464:1: ( rule__Activate__NameAssignment_2 )
            {
             before(grammarAccess.getActivateAccess().getNameAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5465:1: ( rule__Activate__NameAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5465:2: rule__Activate__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl11192);
            rule__Activate__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getActivateAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__Group__2__Impl"


    // $ANTLR start "rule__Deactivate__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5481:1: rule__Deactivate__Group__0 : rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 ;
    public final void rule__Deactivate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5485:1: ( rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5486:2: rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__011228);
            rule__Deactivate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__011231);
            rule__Deactivate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__0"


    // $ANTLR start "rule__Deactivate__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5493:1: rule__Deactivate__Group__0__Impl : ( ( rule__Deactivate__Alternatives_0 ) ) ;
    public final void rule__Deactivate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5497:1: ( ( ( rule__Deactivate__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5498:1: ( ( rule__Deactivate__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5498:1: ( ( rule__Deactivate__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5499:1: ( rule__Deactivate__Alternatives_0 )
            {
             before(grammarAccess.getDeactivateAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5500:1: ( rule__Deactivate__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5500:2: rule__Deactivate__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl11258);
            rule__Deactivate__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getDeactivateAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__0__Impl"


    // $ANTLR start "rule__Deactivate__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5510:1: rule__Deactivate__Group__1 : rule__Deactivate__Group__1__Impl ;
    public final void rule__Deactivate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5514:1: ( rule__Deactivate__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5515:2: rule__Deactivate__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__111288);
            rule__Deactivate__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__1"


    // $ANTLR start "rule__Deactivate__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5521:1: rule__Deactivate__Group__1__Impl : ( ( rule__Deactivate__IdAssignment_1 ) ) ;
    public final void rule__Deactivate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5525:1: ( ( ( rule__Deactivate__IdAssignment_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5526:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5526:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5527:1: ( rule__Deactivate__IdAssignment_1 )
            {
             before(grammarAccess.getDeactivateAccess().getIdAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5528:1: ( rule__Deactivate__IdAssignment_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5528:2: rule__Deactivate__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl11315);
            rule__Deactivate__IdAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeactivateAccess().getIdAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__Group__1__Impl"


    // $ANTLR start "rule__ParticipantCreation__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5542:1: rule__ParticipantCreation__Group__0 : rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 ;
    public final void rule__ParticipantCreation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5546:1: ( rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5547:2: rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__011349);
            rule__ParticipantCreation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__011352);
            rule__ParticipantCreation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__0"


    // $ANTLR start "rule__ParticipantCreation__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5554:1: rule__ParticipantCreation__Group__0__Impl : ( Create ) ;
    public final void rule__ParticipantCreation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5558:1: ( ( Create ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5559:1: ( Create )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5559:1: ( Create )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5560:1: Create
            {
             before(grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl11380); 
             after(grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__0__Impl"


    // $ANTLR start "rule__ParticipantCreation__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5573:1: rule__ParticipantCreation__Group__1 : rule__ParticipantCreation__Group__1__Impl ;
    public final void rule__ParticipantCreation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5577:1: ( rule__ParticipantCreation__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5578:2: rule__ParticipantCreation__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__111411);
            rule__ParticipantCreation__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__1"


    // $ANTLR start "rule__ParticipantCreation__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5584:1: rule__ParticipantCreation__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__ParticipantCreation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5588:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5589:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5589:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5590:1: RULE_ID
            {
             before(grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl11438); 
             after(grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParticipantCreation__Group__1__Impl"


    // $ANTLR start "rule__Box__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5605:1: rule__Box__Group__0 : rule__Box__Group__0__Impl rule__Box__Group__1 ;
    public final void rule__Box__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5609:1: ( rule__Box__Group__0__Impl rule__Box__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5610:2: rule__Box__Group__0__Impl rule__Box__Group__1
            {
            pushFollow(FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__011471);
            rule__Box__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__1_in_rule__Box__Group__011474);
            rule__Box__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__0"


    // $ANTLR start "rule__Box__Group__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5617:1: rule__Box__Group__0__Impl : ( Box ) ;
    public final void rule__Box__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5621:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5622:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5622:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5623:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_0()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__0__Impl11502); 
             after(grammarAccess.getBoxAccess().getBoxKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__0__Impl"


    // $ANTLR start "rule__Box__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5636:1: rule__Box__Group__1 : rule__Box__Group__1__Impl rule__Box__Group__2 ;
    public final void rule__Box__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5640:1: ( rule__Box__Group__1__Impl rule__Box__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5641:2: rule__Box__Group__1__Impl rule__Box__Group__2
            {
            pushFollow(FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__111533);
            rule__Box__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__2_in_rule__Box__Group__111536);
            rule__Box__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__1"


    // $ANTLR start "rule__Box__Group__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5648:1: rule__Box__Group__1__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5652:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5653:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5653:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5654:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_1()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__1__Impl11564); 
             after(grammarAccess.getBoxAccess().getQuotationMarkKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__1__Impl"


    // $ANTLR start "rule__Box__Group__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5667:1: rule__Box__Group__2 : rule__Box__Group__2__Impl rule__Box__Group__3 ;
    public final void rule__Box__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5671:1: ( rule__Box__Group__2__Impl rule__Box__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5672:2: rule__Box__Group__2__Impl rule__Box__Group__3
            {
            pushFollow(FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__211595);
            rule__Box__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__3_in_rule__Box__Group__211598);
            rule__Box__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__2"


    // $ANTLR start "rule__Box__Group__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5679:1: rule__Box__Group__2__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Box__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5683:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5684:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5684:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5685:1: ( RULE_ID )*
            {
             before(grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5686:1: ( RULE_ID )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5686:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Box__Group__2__Impl11626); 

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

             after(grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__2__Impl"


    // $ANTLR start "rule__Box__Group__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5696:1: rule__Box__Group__3 : rule__Box__Group__3__Impl rule__Box__Group__4 ;
    public final void rule__Box__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5700:1: ( rule__Box__Group__3__Impl rule__Box__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5701:2: rule__Box__Group__3__Impl rule__Box__Group__4
            {
            pushFollow(FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__311657);
            rule__Box__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__4_in_rule__Box__Group__311660);
            rule__Box__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__3"


    // $ANTLR start "rule__Box__Group__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5708:1: rule__Box__Group__3__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5712:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5713:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5713:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5714:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_3()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__3__Impl11688); 
             after(grammarAccess.getBoxAccess().getQuotationMarkKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__3__Impl"


    // $ANTLR start "rule__Box__Group__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5727:1: rule__Box__Group__4 : rule__Box__Group__4__Impl rule__Box__Group__5 ;
    public final void rule__Box__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5731:1: ( rule__Box__Group__4__Impl rule__Box__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5732:2: rule__Box__Group__4__Impl rule__Box__Group__5
            {
            pushFollow(FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__411719);
            rule__Box__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__5_in_rule__Box__Group__411722);
            rule__Box__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__4"


    // $ANTLR start "rule__Box__Group__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5739:1: rule__Box__Group__4__Impl : ( ( RULE_COLOR )? ) ;
    public final void rule__Box__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5743:1: ( ( ( RULE_COLOR )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5744:1: ( ( RULE_COLOR )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5744:1: ( ( RULE_COLOR )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5745:1: ( RULE_COLOR )?
            {
             before(grammarAccess.getBoxAccess().getCOLORTerminalRuleCall_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5746:1: ( RULE_COLOR )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_COLOR) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5746:3: RULE_COLOR
                    {
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Box__Group__4__Impl11750); 

                    }
                    break;

            }

             after(grammarAccess.getBoxAccess().getCOLORTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__4__Impl"


    // $ANTLR start "rule__Box__Group__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5756:1: rule__Box__Group__5 : rule__Box__Group__5__Impl rule__Box__Group__6 ;
    public final void rule__Box__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5760:1: ( rule__Box__Group__5__Impl rule__Box__Group__6 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5761:2: rule__Box__Group__5__Impl rule__Box__Group__6
            {
            pushFollow(FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__511781);
            rule__Box__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__6_in_rule__Box__Group__511784);
            rule__Box__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__5"


    // $ANTLR start "rule__Box__Group__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5768:1: rule__Box__Group__5__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5772:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5773:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5773:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5774:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group__5__Impl11811); 
             after(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__5__Impl"


    // $ANTLR start "rule__Box__Group__6"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5785:1: rule__Box__Group__6 : rule__Box__Group__6__Impl rule__Box__Group__7 ;
    public final void rule__Box__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5789:1: ( rule__Box__Group__6__Impl rule__Box__Group__7 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5790:2: rule__Box__Group__6__Impl rule__Box__Group__7
            {
            pushFollow(FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__611840);
            rule__Box__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__7_in_rule__Box__Group__611843);
            rule__Box__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__6"


    // $ANTLR start "rule__Box__Group__6__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5797:1: rule__Box__Group__6__Impl : ( ( rule__Box__Group_6__0 )* ) ;
    public final void rule__Box__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5801:1: ( ( ( rule__Box__Group_6__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5802:1: ( ( rule__Box__Group_6__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5802:1: ( ( rule__Box__Group_6__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5803:1: ( rule__Box__Group_6__0 )*
            {
             before(grammarAccess.getBoxAccess().getGroup_6()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5804:1: ( rule__Box__Group_6__0 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==Participant||LA57_0==Boundary||(LA57_0>=Database && LA57_0<=Control)||LA57_0==Entity||LA57_0==Actor||LA57_0==RULE_NEWLINE) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5804:2: rule__Box__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__Box__Group_6__0_in_rule__Box__Group__6__Impl11870);
            	    rule__Box__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getBoxAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__6__Impl"


    // $ANTLR start "rule__Box__Group__7"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5814:1: rule__Box__Group__7 : rule__Box__Group__7__Impl rule__Box__Group__8 ;
    public final void rule__Box__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5818:1: ( rule__Box__Group__7__Impl rule__Box__Group__8 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5819:2: rule__Box__Group__7__Impl rule__Box__Group__8
            {
            pushFollow(FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__711901);
            rule__Box__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__8_in_rule__Box__Group__711904);
            rule__Box__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__7"


    // $ANTLR start "rule__Box__Group__7__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5826:1: rule__Box__Group__7__Impl : ( End ) ;
    public final void rule__Box__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5830:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5831:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5831:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5832:1: End
            {
             before(grammarAccess.getBoxAccess().getEndKeyword_7()); 
            match(input,End,FOLLOW_End_in_rule__Box__Group__7__Impl11932); 
             after(grammarAccess.getBoxAccess().getEndKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__7__Impl"


    // $ANTLR start "rule__Box__Group__8"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5845:1: rule__Box__Group__8 : rule__Box__Group__8__Impl ;
    public final void rule__Box__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5849:1: ( rule__Box__Group__8__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5850:2: rule__Box__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__811963);
            rule__Box__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__8"


    // $ANTLR start "rule__Box__Group__8__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5856:1: rule__Box__Group__8__Impl : ( Box ) ;
    public final void rule__Box__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5860:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5861:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5861:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5862:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_8()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__8__Impl11991); 
             after(grammarAccess.getBoxAccess().getBoxKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group__8__Impl"


    // $ANTLR start "rule__Box__Group_6__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5893:1: rule__Box__Group_6__0 : rule__Box__Group_6__0__Impl rule__Box__Group_6__1 ;
    public final void rule__Box__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5897:1: ( rule__Box__Group_6__0__Impl rule__Box__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5898:2: rule__Box__Group_6__0__Impl rule__Box__Group_6__1
            {
            pushFollow(FOLLOW_rule__Box__Group_6__0__Impl_in_rule__Box__Group_6__012040);
            rule__Box__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group_6__1_in_rule__Box__Group_6__012043);
            rule__Box__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__0"


    // $ANTLR start "rule__Box__Group_6__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5905:1: rule__Box__Group_6__0__Impl : ( ( rule__Box__DefinitionsAssignment_6_0 )? ) ;
    public final void rule__Box__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5909:1: ( ( ( rule__Box__DefinitionsAssignment_6_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5910:1: ( ( rule__Box__DefinitionsAssignment_6_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5910:1: ( ( rule__Box__DefinitionsAssignment_6_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5911:1: ( rule__Box__DefinitionsAssignment_6_0 )?
            {
             before(grammarAccess.getBoxAccess().getDefinitionsAssignment_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5912:1: ( rule__Box__DefinitionsAssignment_6_0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==Participant||LA58_0==Boundary||(LA58_0>=Database && LA58_0<=Control)||LA58_0==Entity||LA58_0==Actor) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5912:2: rule__Box__DefinitionsAssignment_6_0
                    {
                    pushFollow(FOLLOW_rule__Box__DefinitionsAssignment_6_0_in_rule__Box__Group_6__0__Impl12070);
                    rule__Box__DefinitionsAssignment_6_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBoxAccess().getDefinitionsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__0__Impl"


    // $ANTLR start "rule__Box__Group_6__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5922:1: rule__Box__Group_6__1 : rule__Box__Group_6__1__Impl ;
    public final void rule__Box__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5926:1: ( rule__Box__Group_6__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5927:2: rule__Box__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group_6__1__Impl_in_rule__Box__Group_6__112101);
            rule__Box__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__1"


    // $ANTLR start "rule__Box__Group_6__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5933:1: rule__Box__Group_6__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5937:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5938:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5938:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5939:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group_6__1__Impl12128); 
             after(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__Group_6__1__Impl"


    // $ANTLR start "rule__Plantuml__DiagramsAssignment"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5955:1: rule__Plantuml__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Plantuml__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5959:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5960:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5960:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5961:1: ruleDiagram
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment12166);
            ruleDiagram();

            state._fsp--;

             after(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Plantuml__DiagramsAssignment"


    // $ANTLR start "rule__Diagram__InstructionsAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5970:1: rule__Diagram__InstructionsAssignment_2 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5974:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5975:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5975:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5976:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_212197);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__InstructionsAssignment_2"


    // $ANTLR start "rule__Arrow__NameAssignment_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5985:1: rule__Arrow__NameAssignment_0 : ( ruleMyID ) ;
    public final void rule__Arrow__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5989:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5990:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5990:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5991:1: ruleMyID
            {
             before(grammarAccess.getArrowAccess().getNameMyIDParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Arrow__NameAssignment_012228);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getNameMyIDParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__NameAssignment_0"


    // $ANTLR start "rule__Arrow__NamesAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6000:1: rule__Arrow__NamesAssignment_2 : ( ruleMyID ) ;
    public final void rule__Arrow__NamesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6004:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6005:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6005:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6006:1: ruleMyID
            {
             before(grammarAccess.getArrowAccess().getNamesMyIDParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Arrow__NamesAssignment_212259);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getArrowAccess().getNamesMyIDParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Arrow__NamesAssignment_2"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6015:1: rule__Definition__NameAssignment_0_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6019:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6020:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6020:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6021:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_0_112290);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__NameAssignment_0_1"


    // $ANTLR start "rule__Definition__NameAssignment_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6030:1: rule__Definition__NameAssignment_1_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6034:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6035:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6035:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6036:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_1_112321);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__NameAssignment_1_1"


    // $ANTLR start "rule__Definition__NameAssignment_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6045:1: rule__Definition__NameAssignment_2_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6049:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6050:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6050:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6051:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_2_112352);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__NameAssignment_2_1"


    // $ANTLR start "rule__Definition__NameAssignment_3_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6060:1: rule__Definition__NameAssignment_3_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6064:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6065:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6065:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6066:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_3_112383);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__NameAssignment_3_1"


    // $ANTLR start "rule__Definition__NameAssignment_4_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6075:1: rule__Definition__NameAssignment_4_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6079:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6080:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6080:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6081:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_4_112414);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__NameAssignment_4_1"


    // $ANTLR start "rule__Definition__NameAssignment_5_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6090:1: rule__Definition__NameAssignment_5_1 : ( ruleMyID ) ;
    public final void rule__Definition__NameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6094:1: ( ( ruleMyID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6095:1: ( ruleMyID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6095:1: ( ruleMyID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6096:1: ruleMyID
            {
             before(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_5_112445);
            ruleMyID();

            state._fsp--;

             after(grammarAccess.getDefinitionAccess().getNameMyIDParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Definition__NameAssignment_5_1"


    // $ANTLR start "rule__AltElse__InstructionsAssignment_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6105:1: rule__AltElse__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__AltElse__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6109:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6110:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6110:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6111:1: ruleInstruction
            {
             before(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_312476);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__InstructionsAssignment_3"


    // $ANTLR start "rule__AltElse__ElsesAssignment_4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6120:1: rule__AltElse__ElsesAssignment_4 : ( ruleElse ) ;
    public final void rule__AltElse__ElsesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6124:1: ( ( ruleElse ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6125:1: ( ruleElse )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6125:1: ( ruleElse )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6126:1: ruleElse
            {
             before(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_412507);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AltElse__ElsesAssignment_4"


    // $ANTLR start "rule__Else__InstructionsAssignment_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6135:1: rule__Else__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Else__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6139:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6140:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6140:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6141:1: ruleInstruction
            {
             before(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312538);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Else__InstructionsAssignment_3"


    // $ANTLR start "rule__GroupingMessages__InstructionsAssignment_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6150:1: rule__GroupingMessages__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__GroupingMessages__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6154:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6155:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6155:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6156:1: ruleInstruction
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_312569);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GroupingMessages__InstructionsAssignment_3"


    // $ANTLR start "rule__Note__RidAssignment_1_0_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6165:1: rule__Note__RidAssignment_1_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6169:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6170:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6170:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6171:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6172:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6173:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_1_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidAssignment_1_0_1_112604); 
             after(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_1_0_1_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__RidAssignment_1_0_1_1"


    // $ANTLR start "rule__Note__RidsAssignment_1_0_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6184:1: rule__Note__RidsAssignment_1_0_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidsAssignment_1_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6188:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6189:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6189:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6190:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6191:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6192:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_1_0_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_1_0_1_2_112643); 
             after(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_1_0_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__RidsAssignment_1_0_1_2_1"


    // $ANTLR start "rule__Note__LidAssignment_1_1_1_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6203:1: rule__Note__LidAssignment_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6207:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6208:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6208:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6209:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6210:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6211:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_1_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidAssignment_1_1_1_112682); 
             after(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__LidAssignment_1_1_1_1"


    // $ANTLR start "rule__Note__LidsAssignment_1_1_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6222:1: rule__Note__LidsAssignment_1_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidsAssignment_1_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6226:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6227:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6227:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6228:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6229:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6230:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_1_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_1_1_1_2_112721); 
             after(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_1_1_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__LidsAssignment_1_1_1_2_1"


    // $ANTLR start "rule__Note__OidAssignment_1_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6241:1: rule__Note__OidAssignment_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6245:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6246:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6246:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6247:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6248:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6249:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidAssignment_1_2_112760); 
             after(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_1_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__OidAssignment_1_2_1"


    // $ANTLR start "rule__Note__OidsAssignment_1_2_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6260:1: rule__Note__OidsAssignment_1_2_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidsAssignment_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6264:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6265:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6265:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6266:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6267:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6268:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_1_2_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_1_2_2_112799); 
             after(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_1_2_2_1_0_1()); 

            }

             after(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Note__OidsAssignment_1_2_2_1"


    // $ANTLR start "rule__Reference__IdAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6279:1: rule__Reference__IdAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6283:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6284:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6284:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6285:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6286:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6287:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_212838); 
             after(grammarAccess.getReferenceAccess().getIdDefinitionIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__IdAssignment_2"


    // $ANTLR start "rule__Reference__IdsAssignment_3_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6298:1: rule__Reference__IdsAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6302:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6303:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6303:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6304:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6305:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6306:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_112877); 
             after(grammarAccess.getReferenceAccess().getIdsDefinitionIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__IdsAssignment_3_1"


    // $ANTLR start "rule__Activate__NameAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6317:1: rule__Activate__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Activate__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6321:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6322:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6322:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6323:1: RULE_ID
            {
             before(grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_212912); 
             after(grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Activate__NameAssignment_2"


    // $ANTLR start "rule__Deactivate__IdAssignment_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6332:1: rule__Deactivate__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Deactivate__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6336:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6337:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6337:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6338:1: ( RULE_ID )
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6339:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6340:1: RULE_ID
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_112947); 
             after(grammarAccess.getDeactivateAccess().getIdActivateIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Deactivate__IdAssignment_1"


    // $ANTLR start "rule__Box__DefinitionsAssignment_6_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6351:1: rule__Box__DefinitionsAssignment_6_0 : ( ruleDefinition ) ;
    public final void rule__Box__DefinitionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6355:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6356:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6356:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6357:1: ruleDefinition
            {
             before(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_6_012982);
            ruleDefinition();

            state._fsp--;

             after(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Box__DefinitionsAssignment_6_0"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA2_eotS =
        "\46\uffff";
    static final String DFA2_eofS =
        "\46\uffff";
    static final String DFA2_minS =
        "\1\4\1\uffff\1\73\2\67\1\7\1\5\7\67\1\27\1\36\1\16\3\73\1\54\21"+
        "\uffff";
    static final String DFA2_maxS =
        "\1\73\1\uffff\17\76\1\77\3\76\21\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\23\uffff\1\2\1\12\1\14\1\15\1\21\1\3\1\4\1\5\1\7\1"+
        "\6\1\10\1\11\1\13\1\16\1\17\1\20\1\22";
    static final String DFA2_specialS =
        "\46\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\25\1\3\1\22\1\1\1\21\1\25\1\14\2\25\1\23\1\1\1\7\1\1\1\2"+
            "\1\25\1\5\1\25\1\13\1\15\1\1\1\4\1\1\1\20\1\1\1\11\1\16\1\1"+
            "\1\27\1\6\1\24\1\1\1\10\1\12\1\17\1\30\1\uffff\1\26\1\uffff"+
            "\1\1\1\30\1\uffff\12\1\3\uffff\2\1",
            "",
            "\1\31\2\uffff\1\1",
            "\1\32\2\uffff\1\32\3\uffff\1\1",
            "\1\33\3\uffff\1\33\2\uffff\1\1",
            "\1\34\10\uffff\1\34\6\uffff\1\34\3\uffff\1\34\33\uffff\1\34"+
            "\6\uffff\1\1",
            "\4\35\1\uffff\1\35\2\uffff\5\35\1\uffff\1\35\1\uffff\12\35"+
            "\1\uffff\6\35\4\uffff\1\35\2\uffff\13\35\2\uffff\2\35\2\uffff"+
            "\1\1",
            "\1\36\3\uffff\1\36\2\uffff\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\37\3\uffff\1\37\2\uffff\1\1",
            "\1\40\3\uffff\1\40\2\uffff\1\40\37\uffff\1\1",
            "\1\41\37\uffff\1\1",
            "\1\42\57\uffff\1\1",
            "\1\43\2\uffff\1\1\1\43",
            "\1\44\2\uffff\1\1",
            "\1\44\2\uffff\1\1",
            "\1\45\21\uffff\1\1",
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

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "788:1: rule__Instruction__Alternatives_0 : ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) );";
        }
    }
    static final String DFA22_eotS =
        "\54\uffff";
    static final String DFA22_eofS =
        "\54\uffff";
    static final String DFA22_minS =
        "\2\5\1\uffff\50\5\1\uffff";
    static final String DFA22_maxS =
        "\2\73\1\uffff\47\73\1\100\1\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\2\50\uffff\1\1";
    static final String DFA22_specialS =
        "\54\uffff}>";
    static final String[] DFA22_transitionS = {
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

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "2476:1: ( rule__Definition__Group_5_2_1__0 )?";
        }
    }
 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Plantuml__DiagramsAssignment_in_rulePlantuml91 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_entryRuleDiagram119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDiagram126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0_in_ruleDiagram156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_entryRuleInstruction183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstruction190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0_in_ruleInstruction220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_entryRuleArrow247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrow254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__0_in_ruleArrow284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefinition318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_in_ruleDefinition348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_entryRuleEndID377 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndID384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EndID__Alternatives_in_ruleEndID414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_entryRuleMyID441 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMyID448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MyID__Alternatives_in_ruleMyID478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0_in_ruleTitle606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0_in_ruleLegend670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0_in_ruleNewpage734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0_in_ruleAltElse798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0_in_ruleElse862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0_in_ruleNote990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider1017 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0_in_ruleDivider1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference1118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay1145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0_in_ruleDelay1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Alternatives_in_ruleSpace1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate1337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0_in_ruleActivate1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate1401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate1408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1465 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox1529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0_in_ruleBox1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_01875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_rule__Instruction__Alternatives_01892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Instruction__Alternatives_0_1_11924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_rule__Instruction__Alternatives_0_1_11941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Definition__Alternatives_5_2_1_32096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_rule__Definition__Alternatives_5_2_1_32113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EndID__Alternatives2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__EndID__Alternatives2164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_rule__EndID__Alternatives2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__EndID__Alternatives2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_rule__EndID__Alternatives2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__EndID__Alternatives2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__EndID__Alternatives2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_rule__EndID__Alternatives2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_rule__EndID__Alternatives2304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_rule__EndID__Alternatives2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_rule__EndID__Alternatives2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_rule__EndID__Alternatives2364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_rule__EndID__Alternatives2384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_rule__EndID__Alternatives2404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_rule__EndID__Alternatives2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_rule__EndID__Alternatives2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_rule__EndID__Alternatives2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_rule__EndID__Alternatives2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__EndID__Alternatives2504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__EndID__Alternatives2524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__EndID__Alternatives2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__EndID__Alternatives2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_rule__EndID__Alternatives2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_rule__EndID__Alternatives2604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_rule__EndID__Alternatives2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_rule__EndID__Alternatives2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_rule__EndID__Alternatives2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__EndID__Alternatives2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NumberSign_in_rule__EndID__Alternatives2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__EndID__Alternatives2724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__EndID__Alternatives2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__EndID__Alternatives2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSign_in_rule__EndID__Alternatives2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EndID__Alternatives2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HyphenMinus_in_rule__EndID__Alternatives2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_rule__EndID__Alternatives2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__EndID__Alternatives2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rule__EndID__Alternatives2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSign_in_rule__EndID__Alternatives2901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__MyID__Alternatives2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__MyID__Alternatives2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Legend__Alternatives_12988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Legend__Alternatives_13008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_rule__Legend__Alternatives_13028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_03063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_03083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_rule__GroupingMessages__Alternatives_03103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_rule__GroupingMessages__Alternatives_03123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_03143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_rule__GroupingMessages__Alternatives_03163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_13197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_13215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_13233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_33266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_33284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_43317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_43335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives3369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_03422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_rule__Deactivate__Alternatives_03442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__03474 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__03477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_rule__Diagram__Group__0__Impl3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__13533 = new BitSet(new long[]{0x0EFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__13536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__1__Impl3563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__23592 = new BitSet(new long[]{0x0EFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__23595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_2_in_rule__Diagram__Group__2__Impl3622 = new BitSet(new long[]{0x0CFFED7FFFFFFFF2L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__33653 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__33656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_END_in_rule__Diagram__Group__3__Impl3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__43712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__4__Impl3740 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__03781 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__03784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl3811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__13842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__03902 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__03905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__13961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_1_1_in_rule__Instruction__Group_0_1__1__Impl3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__04023 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__04026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__14083 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__14086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__24142 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__24145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NamesAssignment_2_in_rule__Arrow__Group__2__Impl4172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__34202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__04268 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__04271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl4299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__14330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Arrow__Group_3__1__Impl4358 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__04393 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__04396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl4424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__14455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl4482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__04516 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__04519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl4547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__14578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__04639 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__04642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_rule__Definition__Group_2__0__Impl4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__14701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl4728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__04762 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__04765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl4793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__14824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl4851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__04885 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__04888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_rule__Definition__Group_4__0__Impl4916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__14947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__05008 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__05011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl5039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__15070 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__15073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__25130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl5157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__05194 = new BitSet(new long[]{0x0C7FE63B7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__05197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl5225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__15256 = new BitSet(new long[]{0x0C7FE63B7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__15259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__0_in_rule__Definition__Group_5_2__1__Impl5286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__25317 = new BitSet(new long[]{0x0C7FE63B7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__3_in_rule__Definition__Group_5_2__25320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Definition__Group_5_2__2__Impl5348 = new BitSet(new long[]{0x0C7FE43B7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__3__Impl_in_rule__Definition__Group_5_2__35379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__3__Impl5407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__0__Impl_in_rule__Definition__Group_5_2_1__05446 = new BitSet(new long[]{0x0C7FE43B7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__1_in_rule__Definition__Group_5_2_1__05449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1__0__Impl5477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__1__Impl_in_rule__Definition__Group_5_2_1__15508 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__2_in_rule__Definition__Group_5_2_1__15511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Definition__Group_5_2_1__1__Impl5538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__2__Impl_in_rule__Definition__Group_5_2_1__25567 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__3_in_rule__Definition__Group_5_2_1__25570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Definition__Group_5_2_1__2__Impl5598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__3__Impl_in_rule__Definition__Group_5_2_1__35629 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__4_in_rule__Definition__Group_5_2_1__35632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_5_2_1_3_in_rule__Definition__Group_5_2_1__3__Impl5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1__4__Impl_in_rule__Definition__Group_5_2_1__45689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1__4__Impl5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__05758 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__05761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl5789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__15820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl5847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__05882 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__05885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl5912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__15941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl5969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__06004 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__06007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__Title__Group__0__Impl6035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__16066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl6094 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__06129 = new BitSet(new long[]{0x0080000008810080L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__06132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_rule__Legend__Group__0__Impl6160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__16191 = new BitSet(new long[]{0x0080000008810080L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__16194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl6221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__26252 = new BitSet(new long[]{0x0080000008810080L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__26255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl6282 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__36313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__06380 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__06383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl6410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__16439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl6467 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__06502 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__06505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__16564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl6592 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__06627 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__06630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_rule__AltElse__Group__0__Impl6658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__16689 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__16692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__AltElse__Group__1__Impl6720 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__26751 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__26754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl6781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__36810 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__36813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl6840 = new BitSet(new long[]{0x0CFFED7FFFFFFFF2L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__46871 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__46874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl6901 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__56932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__AltElse__Group__5__Impl6960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__07003 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Else__Group__1_in_rule__Else__Group__07006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_rule__Else__Group__0__Impl7034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__17065 = new BitSet(new long[]{0x0CFFE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Else__Group__2_in_rule__Else__Group__17068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Else__Group__1__Impl7096 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__27127 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__Else__Group__3_in_rule__Else__Group__27130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl7157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__37186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl7213 = new BitSet(new long[]{0x0CFFED7FFFFFFFF2L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__07252 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__07255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl7282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__17312 = new BitSet(new long[]{0x0880000000000000L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__17315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl7343 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__27374 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__27377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl7404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__37433 = new BitSet(new long[]{0x0CFFED7FFFFFFFF0L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__37436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl7463 = new BitSet(new long[]{0x0CFFED7FFFFFFFF2L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__47494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__GroupingMessages__Group__4__Impl7522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__07563 = new BitSet(new long[]{0x0000000048800000L});
    public static final BitSet FOLLOW_rule__Note__Group__1_in_rule__Note__Group__07566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group__0__Impl7594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__17625 = new BitSet(new long[]{0x8088000400000000L});
    public static final BitSet FOLLOW_rule__Note__Group__2_in_rule__Note__Group__17628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl7655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__27685 = new BitSet(new long[]{0x8088000400000000L});
    public static final BitSet FOLLOW_rule__Note__Group__3_in_rule__Note__Group__27688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Note__Group__2__Impl7716 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__37747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl7774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__07812 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__07815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Note__Group_1_0__0__Impl7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__17874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl7901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__07936 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__07939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_1_0_1__0__Impl7967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__17998 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__18001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidAssignment_1_0_1_1_in_rule__Note__Group_1_0_1__1__Impl8028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__28058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl8085 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__08122 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__08125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_0_1_2__0__Impl8153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__18184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidsAssignment_1_0_1_2_1_in_rule__Note__Group_1_0_1_2__1__Impl8211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__08245 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__08248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Note__Group_1_1__0__Impl8276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__18307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl8334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__08369 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__08372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_1_1_1__0__Impl8400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__18431 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__18434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidAssignment_1_1_1_1_in_rule__Note__Group_1_1_1__1__Impl8461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__28491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl8518 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__08555 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__08558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_1_1_2__0__Impl8586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__18617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidsAssignment_1_1_1_2_1_in_rule__Note__Group_1_1_1_2__1__Impl8644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__08678 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__08681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Note__Group_1_2__0__Impl8709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__18740 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__18743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidAssignment_1_2_1_in_rule__Note__Group_1_2__1__Impl8770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__28800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl8827 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__08864 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__08867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_2_2__0__Impl8895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__18926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidsAssignment_1_2_2_1_in_rule__Note__Group_1_2_2__1__Impl8953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__08987 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__08990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Note__Group_3_0__0__Impl9018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__19049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Note__Group_3_0__1__Impl9077 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__09112 = new BitSet(new long[]{0x8088000400000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__09115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl9142 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__19173 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__19176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Note__Group_3_1__1__Impl9204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__29235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group_3_1__2__Impl9263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__09300 = new BitSet(new long[]{0x0C7FE43B7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__09303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl9330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__19359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Note__Group_3_1_0__1__Impl9387 = new BitSet(new long[]{0x0C7FE43B7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__09422 = new BitSet(new long[]{0x0800010000000000L});
    public static final BitSet FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__09425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl9453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__19484 = new BitSet(new long[]{0x0800010000000000L});
    public static final BitSet FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__19487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl9515 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__29546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl9574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__09611 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__09614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group__0__Impl9642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__19673 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__19676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Reference__Group__1__Impl9704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__29735 = new BitSet(new long[]{0x0089000400000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__29738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl9765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__39795 = new BitSet(new long[]{0x0089000400000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__39798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl9825 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__49856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl9883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__09923 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__09926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl9954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__19985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl10012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__010046 = new BitSet(new long[]{0x0C7FE43F7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__010049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl10077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__110108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Reference__Group_4_0__1__Impl10136 = new BitSet(new long[]{0x0C7FE43F7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__010171 = new BitSet(new long[]{0x0089000400000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__010174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl10201 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__110232 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__110235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__210294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl10322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__010359 = new BitSet(new long[]{0x0C7FE43B7FEBE5E0L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__010362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl10389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__110418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndID_in_rule__Reference__Group_4_1_0__1__Impl10446 = new BitSet(new long[]{0x0C7FE43B7FEBE5E2L});
    public static final BitSet FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__010481 = new BitSet(new long[]{0x0800000080000000L});
    public static final BitSet FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__010484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl10512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__110543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl10570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__010605 = new BitSet(new long[]{0x0800000080000000L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__010608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl10636 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__110667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl10695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__010730 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__010733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl10761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__110792 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__110795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl10822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__210851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl10879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__010916 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__010919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl10947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__110978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl11006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__011041 = new BitSet(new long[]{0x8800000000000000L});
    public static final BitSet FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__011044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_rule__Activate__Group__0__Impl11072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__111103 = new BitSet(new long[]{0x8800000000000000L});
    public static final BitSet FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__111106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Activate__Group__1__Impl11134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__211165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl11192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__011228 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__011231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl11258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__111288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl11315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__011349 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__011352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl11380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__111411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl11438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__011471 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__1_in_rule__Box__Group__011474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__0__Impl11502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__111533 = new BitSet(new long[]{0x0800100000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__2_in_rule__Box__Group__111536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__1__Impl11564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__211595 = new BitSet(new long[]{0x0800100000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__3_in_rule__Box__Group__211598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Box__Group__2__Impl11626 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__311657 = new BitSet(new long[]{0x8080000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__4_in_rule__Box__Group__311660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__3__Impl11688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__411719 = new BitSet(new long[]{0x8080000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__5_in_rule__Box__Group__411722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Box__Group__4__Impl11750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__511781 = new BitSet(new long[]{0x0080000400141A10L});
    public static final BitSet FOLLOW_rule__Box__Group__6_in_rule__Box__Group__511784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group__5__Impl11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__611840 = new BitSet(new long[]{0x0080000400141A10L});
    public static final BitSet FOLLOW_rule__Box__Group__7_in_rule__Box__Group__611843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__0_in_rule__Box__Group__6__Impl11870 = new BitSet(new long[]{0x0080000000141A12L});
    public static final BitSet FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__711901 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Box__Group__8_in_rule__Box__Group__711904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Box__Group__7__Impl11932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__811963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__8__Impl11991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__0__Impl_in_rule__Box__Group_6__012040 = new BitSet(new long[]{0x0080000000141A10L});
    public static final BitSet FOLLOW_rule__Box__Group_6__1_in_rule__Box__Group_6__012043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__DefinitionsAssignment_6_0_in_rule__Box__Group_6__0__Impl12070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__1__Impl_in_rule__Box__Group_6__112101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group_6__1__Impl12128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment12166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_212197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Arrow__NameAssignment_012228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Arrow__NamesAssignment_212259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_0_112290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_1_112321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_2_112352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_3_112383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_4_112414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMyID_in_rule__Definition__NameAssignment_5_112445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_312476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_412507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_312569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidAssignment_1_0_1_112604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_1_0_1_2_112643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidAssignment_1_1_1_112682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_1_1_1_2_112721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidAssignment_1_2_112760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_1_2_2_112799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_212838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_112877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_212912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_112947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_6_012982 = new BitSet(new long[]{0x0000000000000002L});

}