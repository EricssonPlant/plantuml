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
    public String getGrammarFileName() { return "../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g"; }


     
     	private PlantumlGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("QuotationMark", "'\"'");
    		tokenNameToValue.put("LeftParenthesis", "'('");
    		tokenNameToValue.put("RightParenthesis", "')'");
    		tokenNameToValue.put("Comma", "','");
    		tokenNameToValue.put("Colon", "':'");
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:108:1: entryRulePlantuml : rulePlantuml EOF ;
    public final void entryRulePlantuml() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:109:1: ( rulePlantuml EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:110:1: rulePlantuml EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:117:1: rulePlantuml : ( ( rule__Plantuml__DiagramsAssignment )* ) ;
    public final void rulePlantuml() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:121:5: ( ( ( rule__Plantuml__DiagramsAssignment )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:122:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:122:1: ( ( rule__Plantuml__DiagramsAssignment )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:123:1: ( rule__Plantuml__DiagramsAssignment )*
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsAssignment()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:124:1: ( rule__Plantuml__DiagramsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_START) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:124:2: rule__Plantuml__DiagramsAssignment
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:136:1: entryRuleDiagram : ruleDiagram EOF ;
    public final void entryRuleDiagram() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:137:1: ( ruleDiagram EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:138:1: ruleDiagram EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:145:1: ruleDiagram : ( ( rule__Diagram__Group__0 ) ) ;
    public final void ruleDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:149:5: ( ( ( rule__Diagram__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:150:1: ( ( rule__Diagram__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:150:1: ( ( rule__Diagram__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:151:1: ( rule__Diagram__Group__0 )
            {
             before(grammarAccess.getDiagramAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:152:1: ( rule__Diagram__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:152:2: rule__Diagram__Group__0
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:164:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:165:1: ( ruleInstruction EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:166:1: ruleInstruction EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:173:1: ruleInstruction : ( ( rule__Instruction__Group__0 ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:177:5: ( ( ( rule__Instruction__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:178:1: ( ( rule__Instruction__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:178:1: ( ( rule__Instruction__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:179:1: ( rule__Instruction__Group__0 )
            {
             before(grammarAccess.getInstructionAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:180:1: ( rule__Instruction__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:180:2: rule__Instruction__Group__0
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:192:1: entryRuleArrow : ruleArrow EOF ;
    public final void entryRuleArrow() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:193:1: ( ruleArrow EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:194:1: ruleArrow EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:201:1: ruleArrow : ( ( rule__Arrow__Group__0 ) ) ;
    public final void ruleArrow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:205:5: ( ( ( rule__Arrow__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:206:1: ( ( rule__Arrow__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:206:1: ( ( rule__Arrow__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:207:1: ( rule__Arrow__Group__0 )
            {
             before(grammarAccess.getArrowAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:208:1: ( rule__Arrow__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:208:2: rule__Arrow__Group__0
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:220:1: entryRuleDefinition : ruleDefinition EOF ;
    public final void entryRuleDefinition() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:221:1: ( ruleDefinition EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:222:1: ruleDefinition EOF
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:229:1: ruleDefinition : ( ( rule__Definition__Alternatives ) ) ;
    public final void ruleDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:233:5: ( ( ( rule__Definition__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:234:1: ( ( rule__Definition__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:234:1: ( ( rule__Definition__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:235:1: ( rule__Definition__Alternatives )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:236:1: ( rule__Definition__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:236:2: rule__Definition__Alternatives
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


    // $ANTLR start "entryRuleAutoNumber"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:248:1: entryRuleAutoNumber : ruleAutoNumber EOF ;
    public final void entryRuleAutoNumber() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:249:1: ( ruleAutoNumber EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:250:1: ruleAutoNumber EOF
            {
             before(grammarAccess.getAutoNumberRule()); 
            pushFollow(FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber375);
            ruleAutoNumber();

            state._fsp--;

             after(grammarAccess.getAutoNumberRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAutoNumber382); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:257:1: ruleAutoNumber : ( ( rule__AutoNumber__Group__0 ) ) ;
    public final void ruleAutoNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:261:5: ( ( ( rule__AutoNumber__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:262:1: ( ( rule__AutoNumber__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:262:1: ( ( rule__AutoNumber__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:263:1: ( rule__AutoNumber__Group__0 )
            {
             before(grammarAccess.getAutoNumberAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:264:1: ( rule__AutoNumber__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:264:2: rule__AutoNumber__Group__0
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber412);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:276:1: entryRuleTitle : ruleTitle EOF ;
    public final void entryRuleTitle() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:277:1: ( ruleTitle EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:278:1: ruleTitle EOF
            {
             before(grammarAccess.getTitleRule()); 
            pushFollow(FOLLOW_ruleTitle_in_entryRuleTitle439);
            ruleTitle();

            state._fsp--;

             after(grammarAccess.getTitleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTitle446); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:285:1: ruleTitle : ( ( rule__Title__Group__0 ) ) ;
    public final void ruleTitle() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:289:5: ( ( ( rule__Title__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:290:1: ( ( rule__Title__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:290:1: ( ( rule__Title__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:291:1: ( rule__Title__Group__0 )
            {
             before(grammarAccess.getTitleAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:292:1: ( rule__Title__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:292:2: rule__Title__Group__0
            {
            pushFollow(FOLLOW_rule__Title__Group__0_in_ruleTitle476);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:304:1: entryRuleLegend : ruleLegend EOF ;
    public final void entryRuleLegend() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:305:1: ( ruleLegend EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:306:1: ruleLegend EOF
            {
             before(grammarAccess.getLegendRule()); 
            pushFollow(FOLLOW_ruleLegend_in_entryRuleLegend503);
            ruleLegend();

            state._fsp--;

             after(grammarAccess.getLegendRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLegend510); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:313:1: ruleLegend : ( ( rule__Legend__Group__0 ) ) ;
    public final void ruleLegend() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:317:5: ( ( ( rule__Legend__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:318:1: ( ( rule__Legend__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:318:1: ( ( rule__Legend__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:319:1: ( rule__Legend__Group__0 )
            {
             before(grammarAccess.getLegendAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:320:1: ( rule__Legend__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:320:2: rule__Legend__Group__0
            {
            pushFollow(FOLLOW_rule__Legend__Group__0_in_ruleLegend540);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:332:1: entryRuleNewpage : ruleNewpage EOF ;
    public final void entryRuleNewpage() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:333:1: ( ruleNewpage EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:334:1: ruleNewpage EOF
            {
             before(grammarAccess.getNewpageRule()); 
            pushFollow(FOLLOW_ruleNewpage_in_entryRuleNewpage567);
            ruleNewpage();

            state._fsp--;

             after(grammarAccess.getNewpageRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNewpage574); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:341:1: ruleNewpage : ( ( rule__Newpage__Group__0 ) ) ;
    public final void ruleNewpage() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:345:5: ( ( ( rule__Newpage__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:346:1: ( ( rule__Newpage__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:346:1: ( ( rule__Newpage__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:347:1: ( rule__Newpage__Group__0 )
            {
             before(grammarAccess.getNewpageAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:348:1: ( rule__Newpage__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:348:2: rule__Newpage__Group__0
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0_in_ruleNewpage604);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:360:1: entryRuleAltElse : ruleAltElse EOF ;
    public final void entryRuleAltElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:361:1: ( ruleAltElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:362:1: ruleAltElse EOF
            {
             before(grammarAccess.getAltElseRule()); 
            pushFollow(FOLLOW_ruleAltElse_in_entryRuleAltElse631);
            ruleAltElse();

            state._fsp--;

             after(grammarAccess.getAltElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAltElse638); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:369:1: ruleAltElse : ( ( rule__AltElse__Group__0 ) ) ;
    public final void ruleAltElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:373:5: ( ( ( rule__AltElse__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:374:1: ( ( rule__AltElse__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:374:1: ( ( rule__AltElse__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:375:1: ( rule__AltElse__Group__0 )
            {
             before(grammarAccess.getAltElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:376:1: ( rule__AltElse__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:376:2: rule__AltElse__Group__0
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0_in_ruleAltElse668);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:388:1: entryRuleElse : ruleElse EOF ;
    public final void entryRuleElse() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:389:1: ( ruleElse EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:390:1: ruleElse EOF
            {
             before(grammarAccess.getElseRule()); 
            pushFollow(FOLLOW_ruleElse_in_entryRuleElse695);
            ruleElse();

            state._fsp--;

             after(grammarAccess.getElseRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleElse702); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:397:1: ruleElse : ( ( rule__Else__Group__0 ) ) ;
    public final void ruleElse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:401:5: ( ( ( rule__Else__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:402:1: ( ( rule__Else__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:402:1: ( ( rule__Else__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:403:1: ( rule__Else__Group__0 )
            {
             before(grammarAccess.getElseAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:404:1: ( rule__Else__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:404:2: rule__Else__Group__0
            {
            pushFollow(FOLLOW_rule__Else__Group__0_in_ruleElse732);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:416:1: entryRuleGroupingMessages : ruleGroupingMessages EOF ;
    public final void entryRuleGroupingMessages() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:417:1: ( ruleGroupingMessages EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:418:1: ruleGroupingMessages EOF
            {
             before(grammarAccess.getGroupingMessagesRule()); 
            pushFollow(FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages759);
            ruleGroupingMessages();

            state._fsp--;

             after(grammarAccess.getGroupingMessagesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroupingMessages766); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:425:1: ruleGroupingMessages : ( ( rule__GroupingMessages__Group__0 ) ) ;
    public final void ruleGroupingMessages() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:429:5: ( ( ( rule__GroupingMessages__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:430:1: ( ( rule__GroupingMessages__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:430:1: ( ( rule__GroupingMessages__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:431:1: ( rule__GroupingMessages__Group__0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:432:1: ( rule__GroupingMessages__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:432:2: rule__GroupingMessages__Group__0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages796);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:444:1: entryRuleNote : ruleNote EOF ;
    public final void entryRuleNote() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:445:1: ( ruleNote EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:446:1: ruleNote EOF
            {
             before(grammarAccess.getNoteRule()); 
            pushFollow(FOLLOW_ruleNote_in_entryRuleNote823);
            ruleNote();

            state._fsp--;

             after(grammarAccess.getNoteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNote830); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:453:1: ruleNote : ( ( rule__Note__Group__0 ) ) ;
    public final void ruleNote() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:457:5: ( ( ( rule__Note__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:458:1: ( ( rule__Note__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:458:1: ( ( rule__Note__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:459:1: ( rule__Note__Group__0 )
            {
             before(grammarAccess.getNoteAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:460:1: ( rule__Note__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:460:2: rule__Note__Group__0
            {
            pushFollow(FOLLOW_rule__Note__Group__0_in_ruleNote860);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:472:1: entryRuleDivider : ruleDivider EOF ;
    public final void entryRuleDivider() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:473:1: ( ruleDivider EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:474:1: ruleDivider EOF
            {
             before(grammarAccess.getDividerRule()); 
            pushFollow(FOLLOW_ruleDivider_in_entryRuleDivider887);
            ruleDivider();

            state._fsp--;

             after(grammarAccess.getDividerRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDivider894); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:481:1: ruleDivider : ( ( rule__Divider__Group__0 ) ) ;
    public final void ruleDivider() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:485:5: ( ( ( rule__Divider__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:486:1: ( ( rule__Divider__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:486:1: ( ( rule__Divider__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:487:1: ( rule__Divider__Group__0 )
            {
             before(grammarAccess.getDividerAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:488:1: ( rule__Divider__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:488:2: rule__Divider__Group__0
            {
            pushFollow(FOLLOW_rule__Divider__Group__0_in_ruleDivider924);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:500:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:501:1: ( ruleReference EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:502:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference951);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference958); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:509:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:513:5: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:514:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:514:1: ( ( rule__Reference__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:515:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:516:1: ( rule__Reference__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:516:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference988);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:528:1: entryRuleDelay : ruleDelay EOF ;
    public final void entryRuleDelay() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:529:1: ( ruleDelay EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:530:1: ruleDelay EOF
            {
             before(grammarAccess.getDelayRule()); 
            pushFollow(FOLLOW_ruleDelay_in_entryRuleDelay1015);
            ruleDelay();

            state._fsp--;

             after(grammarAccess.getDelayRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDelay1022); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:537:1: ruleDelay : ( ( rule__Delay__Group__0 ) ) ;
    public final void ruleDelay() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:541:5: ( ( ( rule__Delay__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:542:1: ( ( rule__Delay__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:542:1: ( ( rule__Delay__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:543:1: ( rule__Delay__Group__0 )
            {
             before(grammarAccess.getDelayAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:544:1: ( rule__Delay__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:544:2: rule__Delay__Group__0
            {
            pushFollow(FOLLOW_rule__Delay__Group__0_in_ruleDelay1052);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:556:1: entryRuleSpace : ruleSpace EOF ;
    public final void entryRuleSpace() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:557:1: ( ruleSpace EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:558:1: ruleSpace EOF
            {
             before(grammarAccess.getSpaceRule()); 
            pushFollow(FOLLOW_ruleSpace_in_entryRuleSpace1079);
            ruleSpace();

            state._fsp--;

             after(grammarAccess.getSpaceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpace1086); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:565:1: ruleSpace : ( ( rule__Space__Alternatives ) ) ;
    public final void ruleSpace() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:569:5: ( ( ( rule__Space__Alternatives ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:570:1: ( ( rule__Space__Alternatives ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:570:1: ( ( rule__Space__Alternatives ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:571:1: ( rule__Space__Alternatives )
            {
             before(grammarAccess.getSpaceAccess().getAlternatives()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:572:1: ( rule__Space__Alternatives )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:572:2: rule__Space__Alternatives
            {
            pushFollow(FOLLOW_rule__Space__Alternatives_in_ruleSpace1116);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:584:1: entryRuleHidefootbox : ruleHidefootbox EOF ;
    public final void entryRuleHidefootbox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:585:1: ( ruleHidefootbox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:586:1: ruleHidefootbox EOF
            {
             before(grammarAccess.getHidefootboxRule()); 
            pushFollow(FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1143);
            ruleHidefootbox();

            state._fsp--;

             after(grammarAccess.getHidefootboxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHidefootbox1150); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:593:1: ruleHidefootbox : ( ( rule__Hidefootbox__Group__0 ) ) ;
    public final void ruleHidefootbox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:597:5: ( ( ( rule__Hidefootbox__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:598:1: ( ( rule__Hidefootbox__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:598:1: ( ( rule__Hidefootbox__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:599:1: ( rule__Hidefootbox__Group__0 )
            {
             before(grammarAccess.getHidefootboxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:600:1: ( rule__Hidefootbox__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:600:2: rule__Hidefootbox__Group__0
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1180);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:612:1: entryRuleActivate : ruleActivate EOF ;
    public final void entryRuleActivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:613:1: ( ruleActivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:614:1: ruleActivate EOF
            {
             before(grammarAccess.getActivateRule()); 
            pushFollow(FOLLOW_ruleActivate_in_entryRuleActivate1207);
            ruleActivate();

            state._fsp--;

             after(grammarAccess.getActivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleActivate1214); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:621:1: ruleActivate : ( ( rule__Activate__Group__0 ) ) ;
    public final void ruleActivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:625:5: ( ( ( rule__Activate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:626:1: ( ( rule__Activate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:626:1: ( ( rule__Activate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:627:1: ( rule__Activate__Group__0 )
            {
             before(grammarAccess.getActivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:628:1: ( rule__Activate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:628:2: rule__Activate__Group__0
            {
            pushFollow(FOLLOW_rule__Activate__Group__0_in_ruleActivate1244);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:640:1: entryRuleDeactivate : ruleDeactivate EOF ;
    public final void entryRuleDeactivate() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:641:1: ( ruleDeactivate EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:642:1: ruleDeactivate EOF
            {
             before(grammarAccess.getDeactivateRule()); 
            pushFollow(FOLLOW_ruleDeactivate_in_entryRuleDeactivate1271);
            ruleDeactivate();

            state._fsp--;

             after(grammarAccess.getDeactivateRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeactivate1278); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:649:1: ruleDeactivate : ( ( rule__Deactivate__Group__0 ) ) ;
    public final void ruleDeactivate() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:653:5: ( ( ( rule__Deactivate__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:654:1: ( ( rule__Deactivate__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:654:1: ( ( rule__Deactivate__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:655:1: ( rule__Deactivate__Group__0 )
            {
             before(grammarAccess.getDeactivateAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:656:1: ( rule__Deactivate__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:656:2: rule__Deactivate__Group__0
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1308);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:668:1: entryRuleParticipantCreation : ruleParticipantCreation EOF ;
    public final void entryRuleParticipantCreation() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:669:1: ( ruleParticipantCreation EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:670:1: ruleParticipantCreation EOF
            {
             before(grammarAccess.getParticipantCreationRule()); 
            pushFollow(FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1335);
            ruleParticipantCreation();

            state._fsp--;

             after(grammarAccess.getParticipantCreationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParticipantCreation1342); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:677:1: ruleParticipantCreation : ( ( rule__ParticipantCreation__Group__0 ) ) ;
    public final void ruleParticipantCreation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:681:5: ( ( ( rule__ParticipantCreation__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:682:1: ( ( rule__ParticipantCreation__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:682:1: ( ( rule__ParticipantCreation__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:683:1: ( rule__ParticipantCreation__Group__0 )
            {
             before(grammarAccess.getParticipantCreationAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:684:1: ( rule__ParticipantCreation__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:684:2: rule__ParticipantCreation__Group__0
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1372);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:696:1: entryRuleBox : ruleBox EOF ;
    public final void entryRuleBox() throws RecognitionException {
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:697:1: ( ruleBox EOF )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:698:1: ruleBox EOF
            {
             before(grammarAccess.getBoxRule()); 
            pushFollow(FOLLOW_ruleBox_in_entryRuleBox1399);
            ruleBox();

            state._fsp--;

             after(grammarAccess.getBoxRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBox1406); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:705:1: ruleBox : ( ( rule__Box__Group__0 ) ) ;
    public final void ruleBox() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:709:5: ( ( ( rule__Box__Group__0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:710:1: ( ( rule__Box__Group__0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:710:1: ( ( rule__Box__Group__0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:711:1: ( rule__Box__Group__0 )
            {
             before(grammarAccess.getBoxAccess().getGroup()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:712:1: ( rule__Box__Group__0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:712:2: rule__Box__Group__0
            {
            pushFollow(FOLLOW_rule__Box__Group__0_in_ruleBox1436);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:724:1: rule__Instruction__Alternatives_0 : ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) );
    public final void rule__Instruction__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:728:1: ( ( ruleArrow ) | ( ( rule__Instruction__Group_0_1__0 ) ) | ( ruleAutoNumber ) | ( ruleTitle ) | ( ruleLegend ) | ( ruleNewpage ) | ( ruleAltElse ) | ( ruleGroupingMessages ) | ( ruleNote ) | ( ruleDivider ) | ( ruleReference ) | ( ruleDelay ) | ( ruleSpace ) | ( ruleHidefootbox ) | ( ruleActivate ) | ( ruleDeactivate ) | ( ruleParticipantCreation ) | ( ruleBox ) )
            int alt2=18;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt2=1;
                }
                break;
            case Participant:
            case Boundary:
            case Database:
            case Control:
            case Entity:
            case Actor:
                {
                alt2=2;
                }
                break;
            case Autonumber:
                {
                alt2=3;
                }
                break;
            case Title:
                {
                alt2=4;
                }
                break;
            case Legend:
                {
                alt2=5;
                }
                break;
            case Newpage:
                {
                alt2=6;
                }
                break;
            case Alt:
                {
                alt2=7;
                }
                break;
            case Critical:
            case Break:
            case Group:
            case Loop:
            case Opt:
            case Par:
                {
                alt2=8;
                }
                break;
            case Note:
                {
                alt2=9;
                }
                break;
            case EqualsSignEqualsSign:
                {
                alt2=10;
                }
                break;
            case Ref:
                {
                alt2=11;
                }
                break;
            case FullStopFullStopFullStop:
                {
                alt2=12;
                }
                break;
            case VerticalLineVerticalLineVerticalLine:
            case VerticalLineVerticalLine:
                {
                alt2=13;
                }
                break;
            case Hide:
                {
                alt2=14;
                }
                break;
            case Activate:
                {
                alt2=15;
                }
                break;
            case Deactivate:
            case Destroy:
                {
                alt2=16;
                }
                break;
            case Create:
                {
                alt2=17;
                }
                break;
            case Box:
                {
                alt2=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:729:1: ( ruleArrow )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:729:1: ( ruleArrow )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:730:1: ruleArrow
                    {
                     before(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01472);
                    ruleArrow();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getArrowParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:735:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:735:6: ( ( rule__Instruction__Group_0_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:736:1: ( rule__Instruction__Group_0_1__0 )
                    {
                     before(grammarAccess.getInstructionAccess().getGroup_0_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:737:1: ( rule__Instruction__Group_0_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:737:2: rule__Instruction__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01489);
                    rule__Instruction__Group_0_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getInstructionAccess().getGroup_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:741:6: ( ruleAutoNumber )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:741:6: ( ruleAutoNumber )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:742:1: ruleAutoNumber
                    {
                     before(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 
                    pushFollow(FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01507);
                    ruleAutoNumber();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAutoNumberParserRuleCall_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:747:6: ( ruleTitle )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:747:6: ( ruleTitle )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:748:1: ruleTitle
                    {
                     before(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 
                    pushFollow(FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01524);
                    ruleTitle();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getTitleParserRuleCall_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:753:6: ( ruleLegend )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:753:6: ( ruleLegend )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:754:1: ruleLegend
                    {
                     before(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 
                    pushFollow(FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01541);
                    ruleLegend();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getLegendParserRuleCall_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:759:6: ( ruleNewpage )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:759:6: ( ruleNewpage )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:760:1: ruleNewpage
                    {
                     before(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 
                    pushFollow(FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01558);
                    ruleNewpage();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNewpageParserRuleCall_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:765:6: ( ruleAltElse )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:765:6: ( ruleAltElse )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:766:1: ruleAltElse
                    {
                     before(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 
                    pushFollow(FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01575);
                    ruleAltElse();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getAltElseParserRuleCall_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:771:6: ( ruleGroupingMessages )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:771:6: ( ruleGroupingMessages )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:772:1: ruleGroupingMessages
                    {
                     before(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 
                    pushFollow(FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01592);
                    ruleGroupingMessages();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getGroupingMessagesParserRuleCall_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:777:6: ( ruleNote )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:777:6: ( ruleNote )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:778:1: ruleNote
                    {
                     before(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 
                    pushFollow(FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01609);
                    ruleNote();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getNoteParserRuleCall_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:783:6: ( ruleDivider )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:783:6: ( ruleDivider )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:784:1: ruleDivider
                    {
                     before(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 
                    pushFollow(FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01626);
                    ruleDivider();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDividerParserRuleCall_0_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:789:6: ( ruleReference )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:789:6: ( ruleReference )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:790:1: ruleReference
                    {
                     before(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01643);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getReferenceParserRuleCall_0_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:795:6: ( ruleDelay )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:795:6: ( ruleDelay )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:796:1: ruleDelay
                    {
                     before(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 
                    pushFollow(FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01660);
                    ruleDelay();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDelayParserRuleCall_0_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:801:6: ( ruleSpace )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:801:6: ( ruleSpace )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:802:1: ruleSpace
                    {
                     before(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 
                    pushFollow(FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01677);
                    ruleSpace();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getSpaceParserRuleCall_0_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:807:6: ( ruleHidefootbox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:807:6: ( ruleHidefootbox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:808:1: ruleHidefootbox
                    {
                     before(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 
                    pushFollow(FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01694);
                    ruleHidefootbox();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getHidefootboxParserRuleCall_0_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:813:6: ( ruleActivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:813:6: ( ruleActivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:814:1: ruleActivate
                    {
                     before(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 
                    pushFollow(FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01711);
                    ruleActivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getActivateParserRuleCall_0_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:819:6: ( ruleDeactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:819:6: ( ruleDeactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:820:1: ruleDeactivate
                    {
                     before(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 
                    pushFollow(FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01728);
                    ruleDeactivate();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getDeactivateParserRuleCall_0_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:825:6: ( ruleParticipantCreation )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:825:6: ( ruleParticipantCreation )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:826:1: ruleParticipantCreation
                    {
                     before(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 
                    pushFollow(FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_01745);
                    ruleParticipantCreation();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getParticipantCreationParserRuleCall_0_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:831:6: ( ruleBox )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:831:6: ( ruleBox )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:832:1: ruleBox
                    {
                     before(grammarAccess.getInstructionAccess().getBoxParserRuleCall_0_17()); 
                    pushFollow(FOLLOW_ruleBox_in_rule__Instruction__Alternatives_01762);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:842:1: rule__Instruction__Alternatives_0_1_1 : ( ( RULE_COLOR ) | ( RULE_HEXCODE ) );
    public final void rule__Instruction__Alternatives_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:846:1: ( ( RULE_COLOR ) | ( RULE_HEXCODE ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:847:1: ( RULE_COLOR )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:847:1: ( RULE_COLOR )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:848:1: RULE_COLOR
                    {
                     before(grammarAccess.getInstructionAccess().getCOLORTerminalRuleCall_0_1_1_0()); 
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Instruction__Alternatives_0_1_11794); 
                     after(grammarAccess.getInstructionAccess().getCOLORTerminalRuleCall_0_1_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:853:6: ( RULE_HEXCODE )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:853:6: ( RULE_HEXCODE )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:854:1: RULE_HEXCODE
                    {
                     before(grammarAccess.getInstructionAccess().getHEXCODETerminalRuleCall_0_1_1_1()); 
                    match(input,RULE_HEXCODE,FOLLOW_RULE_HEXCODE_in_rule__Instruction__Alternatives_0_1_11811); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:864:1: rule__Definition__Alternatives : ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) );
    public final void rule__Definition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:868:1: ( ( ( rule__Definition__Group_0__0 ) ) | ( ( rule__Definition__Group_1__0 ) ) | ( ( rule__Definition__Group_2__0 ) ) | ( ( rule__Definition__Group_3__0 ) ) | ( ( rule__Definition__Group_4__0 ) ) | ( ( rule__Definition__Group_5__0 ) ) )
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:869:1: ( ( rule__Definition__Group_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:869:1: ( ( rule__Definition__Group_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:870:1: ( rule__Definition__Group_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:871:1: ( rule__Definition__Group_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:871:2: rule__Definition__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1843);
                    rule__Definition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:875:6: ( ( rule__Definition__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:875:6: ( ( rule__Definition__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:876:1: ( rule__Definition__Group_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:877:1: ( rule__Definition__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:877:2: rule__Definition__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1861);
                    rule__Definition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:881:6: ( ( rule__Definition__Group_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:881:6: ( ( rule__Definition__Group_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:882:1: ( rule__Definition__Group_2__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:883:1: ( rule__Definition__Group_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:883:2: rule__Definition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1879);
                    rule__Definition__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:887:6: ( ( rule__Definition__Group_3__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:887:6: ( ( rule__Definition__Group_3__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:888:1: ( rule__Definition__Group_3__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_3()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:889:1: ( rule__Definition__Group_3__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:889:2: rule__Definition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1897);
                    rule__Definition__Group_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:893:6: ( ( rule__Definition__Group_4__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:893:6: ( ( rule__Definition__Group_4__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:894:1: ( rule__Definition__Group_4__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_4()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:895:1: ( rule__Definition__Group_4__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:895:2: rule__Definition__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1915);
                    rule__Definition__Group_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:899:6: ( ( rule__Definition__Group_5__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:899:6: ( ( rule__Definition__Group_5__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:900:1: ( rule__Definition__Group_5__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:901:1: ( rule__Definition__Group_5__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:901:2: rule__Definition__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives1933);
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


    // $ANTLR start "rule__Definition__Alternatives_5_2_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:910:1: rule__Definition__Alternatives_5_2_1 : ( ( ( rule__Definition__Group_5_2_1_0__0 ) ) | ( ( rule__Definition__Group_5_2_1_1__0 ) ) | ( RULE_ID ) );
    public final void rule__Definition__Alternatives_5_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:914:1: ( ( ( rule__Definition__Group_5_2_1_0__0 ) ) | ( ( rule__Definition__Group_5_2_1_1__0 ) ) | ( RULE_ID ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LeftParenthesis) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==Comma) ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==RULE_COLOR) ) {
                            int LA5_5 = input.LA(5);

                            if ( (LA5_5==RightParenthesis) ) {
                                int LA5_6 = input.LA(6);

                                if ( (LA5_6==GreaterThanSignGreaterThanSign) ) {
                                    alt5=1;
                                }
                                else if ( (LA5_6==RULE_ID) ) {
                                    alt5=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 5, 6, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:915:1: ( ( rule__Definition__Group_5_2_1_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:915:1: ( ( rule__Definition__Group_5_2_1_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:916:1: ( rule__Definition__Group_5_2_1_0__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5_2_1_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:917:1: ( rule__Definition__Group_5_2_1_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:917:2: rule__Definition__Group_5_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__0_in_rule__Definition__Alternatives_5_2_11966);
                    rule__Definition__Group_5_2_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_5_2_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:921:6: ( ( rule__Definition__Group_5_2_1_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:921:6: ( ( rule__Definition__Group_5_2_1_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:922:1: ( rule__Definition__Group_5_2_1_1__0 )
                    {
                     before(grammarAccess.getDefinitionAccess().getGroup_5_2_1_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:923:1: ( rule__Definition__Group_5_2_1_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:923:2: rule__Definition__Group_5_2_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__0_in_rule__Definition__Alternatives_5_2_11984);
                    rule__Definition__Group_5_2_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDefinitionAccess().getGroup_5_2_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:927:6: ( RULE_ID )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:927:6: ( RULE_ID )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:928:1: RULE_ID
                    {
                     before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_2()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Alternatives_5_2_12002); 
                     after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_2()); 

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
    // $ANTLR end "rule__Definition__Alternatives_5_2_1"


    // $ANTLR start "rule__Legend__Alternatives_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:938:1: rule__Legend__Alternatives_1 : ( ( Right ) | ( Left ) | ( Center ) );
    public final void rule__Legend__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:942:1: ( ( Right ) | ( Left ) | ( Center ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case Right:
                {
                alt6=1;
                }
                break;
            case Left:
                {
                alt6=2;
                }
                break;
            case Center:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:943:1: ( Right )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:943:1: ( Right )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:944:1: Right
                    {
                     before(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 
                    match(input,Right,FOLLOW_Right_in_rule__Legend__Alternatives_12035); 
                     after(grammarAccess.getLegendAccess().getRightKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:951:6: ( Left )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:951:6: ( Left )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:952:1: Left
                    {
                     before(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 
                    match(input,Left,FOLLOW_Left_in_rule__Legend__Alternatives_12055); 
                     after(grammarAccess.getLegendAccess().getLeftKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:959:6: ( Center )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:959:6: ( Center )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:960:1: Center
                    {
                     before(grammarAccess.getLegendAccess().getCenterKeyword_1_2()); 
                    match(input,Center,FOLLOW_Center_in_rule__Legend__Alternatives_12075); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:972:1: rule__GroupingMessages__Alternatives_0 : ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) );
    public final void rule__GroupingMessages__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:976:1: ( ( Opt ) | ( Loop ) | ( Par ) | ( Break ) | ( Critical ) | ( Group ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case Opt:
                {
                alt7=1;
                }
                break;
            case Loop:
                {
                alt7=2;
                }
                break;
            case Par:
                {
                alt7=3;
                }
                break;
            case Break:
                {
                alt7=4;
                }
                break;
            case Critical:
                {
                alt7=5;
                }
                break;
            case Group:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:977:1: ( Opt )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:977:1: ( Opt )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:978:1: Opt
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 
                    match(input,Opt,FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_02110); 
                     after(grammarAccess.getGroupingMessagesAccess().getOptKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:985:6: ( Loop )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:985:6: ( Loop )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:986:1: Loop
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 
                    match(input,Loop,FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_02130); 
                     after(grammarAccess.getGroupingMessagesAccess().getLoopKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:993:6: ( Par )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:993:6: ( Par )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:994:1: Par
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 
                    match(input,Par,FOLLOW_Par_in_rule__GroupingMessages__Alternatives_02150); 
                     after(grammarAccess.getGroupingMessagesAccess().getParKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1001:6: ( Break )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1001:6: ( Break )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1002:1: Break
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 
                    match(input,Break,FOLLOW_Break_in_rule__GroupingMessages__Alternatives_02170); 
                     after(grammarAccess.getGroupingMessagesAccess().getBreakKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1009:6: ( Critical )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1009:6: ( Critical )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1010:1: Critical
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 
                    match(input,Critical,FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_02190); 
                     after(grammarAccess.getGroupingMessagesAccess().getCriticalKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1017:6: ( Group )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1017:6: ( Group )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1018:1: Group
                    {
                     before(grammarAccess.getGroupingMessagesAccess().getGroupKeyword_0_5()); 
                    match(input,Group,FOLLOW_Group_in_rule__GroupingMessages__Alternatives_02210); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1030:1: rule__Note__Alternatives_1 : ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) );
    public final void rule__Note__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1034:1: ( ( ( rule__Note__Group_1_0__0 ) ) | ( ( rule__Note__Group_1_1__0 ) ) | ( ( rule__Note__Group_1_2__0 ) ) )
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
            case Over:
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
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1035:1: ( ( rule__Note__Group_1_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1035:1: ( ( rule__Note__Group_1_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1036:1: ( rule__Note__Group_1_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1037:1: ( rule__Note__Group_1_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1037:2: rule__Note__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_12244);
                    rule__Note__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1041:6: ( ( rule__Note__Group_1_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1041:6: ( ( rule__Note__Group_1_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1042:1: ( rule__Note__Group_1_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1043:1: ( rule__Note__Group_1_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1043:2: rule__Note__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_12262);
                    rule__Note__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1047:6: ( ( rule__Note__Group_1_2__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1047:6: ( ( rule__Note__Group_1_2__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1048:1: ( rule__Note__Group_1_2__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_1_2()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1049:1: ( rule__Note__Group_1_2__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1049:2: rule__Note__Group_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_12280);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1058:1: rule__Note__Alternatives_3 : ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) );
    public final void rule__Note__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1062:1: ( ( ( rule__Note__Group_3_0__0 ) ) | ( ( rule__Note__Group_3_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Colon) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_NEWLINE) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1063:1: ( ( rule__Note__Group_3_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1063:1: ( ( rule__Note__Group_3_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1064:1: ( rule__Note__Group_3_0__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1065:1: ( rule__Note__Group_3_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1065:2: rule__Note__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_32313);
                    rule__Note__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNoteAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1069:6: ( ( rule__Note__Group_3_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1069:6: ( ( rule__Note__Group_3_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1070:1: ( rule__Note__Group_3_1__0 )
                    {
                     before(grammarAccess.getNoteAccess().getGroup_3_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1071:1: ( rule__Note__Group_3_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1071:2: rule__Note__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_32331);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1080:1: rule__Reference__Alternatives_4 : ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) );
    public final void rule__Reference__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1084:1: ( ( ( rule__Reference__Group_4_0__0 ) ) | ( ( rule__Reference__Group_4_1__0 ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Colon) ) {
                alt10=1;
            }
            else if ( (LA10_0==End||LA10_0==RULE_NEWLINE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1085:1: ( ( rule__Reference__Group_4_0__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1085:1: ( ( rule__Reference__Group_4_0__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1086:1: ( rule__Reference__Group_4_0__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_0()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1087:1: ( rule__Reference__Group_4_0__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1087:2: rule__Reference__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_42364);
                    rule__Reference__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getReferenceAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1091:6: ( ( rule__Reference__Group_4_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1091:6: ( ( rule__Reference__Group_4_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1092:1: ( rule__Reference__Group_4_1__0 )
                    {
                     before(grammarAccess.getReferenceAccess().getGroup_4_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1093:1: ( rule__Reference__Group_4_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1093:2: rule__Reference__Group_4_1__0
                    {
                    pushFollow(FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_42382);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1102:1: rule__Space__Alternatives : ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) );
    public final void rule__Space__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1106:1: ( ( VerticalLineVerticalLineVerticalLine ) | ( ( rule__Space__Group_1__0 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==VerticalLineVerticalLineVerticalLine) ) {
                alt11=1;
            }
            else if ( (LA11_0==VerticalLineVerticalLine) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1107:1: ( VerticalLineVerticalLineVerticalLine )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1107:1: ( VerticalLineVerticalLineVerticalLine )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1108:1: VerticalLineVerticalLineVerticalLine
                    {
                     before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 
                    match(input,VerticalLineVerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives2416); 
                     after(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineVerticalLineKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1115:6: ( ( rule__Space__Group_1__0 ) )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1115:6: ( ( rule__Space__Group_1__0 ) )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1116:1: ( rule__Space__Group_1__0 )
                    {
                     before(grammarAccess.getSpaceAccess().getGroup_1()); 
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1117:1: ( rule__Space__Group_1__0 )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1117:2: rule__Space__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives2435);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1126:1: rule__Deactivate__Alternatives_0 : ( ( Deactivate ) | ( Destroy ) );
    public final void rule__Deactivate__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1130:1: ( ( Deactivate ) | ( Destroy ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Deactivate) ) {
                alt12=1;
            }
            else if ( (LA12_0==Destroy) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1131:1: ( Deactivate )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1131:1: ( Deactivate )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1132:1: Deactivate
                    {
                     before(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 
                    match(input,Deactivate,FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_02469); 
                     after(grammarAccess.getDeactivateAccess().getDeactivateKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1139:6: ( Destroy )
                    {
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1139:6: ( Destroy )
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1140:1: Destroy
                    {
                     before(grammarAccess.getDeactivateAccess().getDestroyKeyword_0_1()); 
                    match(input,Destroy,FOLLOW_Destroy_in_rule__Deactivate__Alternatives_02489); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1154:1: rule__Diagram__Group__0 : rule__Diagram__Group__0__Impl rule__Diagram__Group__1 ;
    public final void rule__Diagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1158:1: ( rule__Diagram__Group__0__Impl rule__Diagram__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1159:2: rule__Diagram__Group__0__Impl rule__Diagram__Group__1
            {
            pushFollow(FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__02521);
            rule__Diagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__02524);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1166:1: rule__Diagram__Group__0__Impl : ( () ) ;
    public final void rule__Diagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1170:1: ( ( () ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1171:1: ( () )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1171:1: ( () )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1172:1: ()
            {
             before(grammarAccess.getDiagramAccess().getDiagramAction_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1173:1: ()
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1175:1: 
            {
            }

             after(grammarAccess.getDiagramAccess().getDiagramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Diagram__Group__0__Impl"


    // $ANTLR start "rule__Diagram__Group__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1185:1: rule__Diagram__Group__1 : rule__Diagram__Group__1__Impl rule__Diagram__Group__2 ;
    public final void rule__Diagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1189:1: ( rule__Diagram__Group__1__Impl rule__Diagram__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1190:2: rule__Diagram__Group__1__Impl rule__Diagram__Group__2
            {
            pushFollow(FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__12582);
            rule__Diagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__12585);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1197:1: rule__Diagram__Group__1__Impl : ( RULE_START ) ;
    public final void rule__Diagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1201:1: ( ( RULE_START ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1202:1: ( RULE_START )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1202:1: ( RULE_START )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1203:1: RULE_START
            {
             before(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_1()); 
            match(input,RULE_START,FOLLOW_RULE_START_in_rule__Diagram__Group__1__Impl2612); 
             after(grammarAccess.getDiagramAccess().getSTARTTerminalRuleCall_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1214:1: rule__Diagram__Group__2 : rule__Diagram__Group__2__Impl rule__Diagram__Group__3 ;
    public final void rule__Diagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1218:1: ( rule__Diagram__Group__2__Impl rule__Diagram__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1219:2: rule__Diagram__Group__2__Impl rule__Diagram__Group__3
            {
            pushFollow(FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__22641);
            rule__Diagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__22644);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1226:1: rule__Diagram__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Diagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1230:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1231:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1231:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1232:1: RULE_NEWLINE
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__2__Impl2671); 
             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_2()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1243:1: rule__Diagram__Group__3 : rule__Diagram__Group__3__Impl rule__Diagram__Group__4 ;
    public final void rule__Diagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1247:1: ( rule__Diagram__Group__3__Impl rule__Diagram__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1248:2: rule__Diagram__Group__3__Impl rule__Diagram__Group__4
            {
            pushFollow(FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__32700);
            rule__Diagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__32703);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1255:1: rule__Diagram__Group__3__Impl : ( ( rule__Diagram__InstructionsAssignment_3 )* ) ;
    public final void rule__Diagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1259:1: ( ( ( rule__Diagram__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1260:1: ( ( rule__Diagram__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1260:1: ( ( rule__Diagram__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1261:1: ( rule__Diagram__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getDiagramAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1262:1: ( rule__Diagram__InstructionsAssignment_3 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=Participant && LA13_0<=Deactivate)||(LA13_0>=Activate && LA13_0<=Destroy)||LA13_0==Newpage||(LA13_0>=Create && LA13_0<=Group)||LA13_0==Title||LA13_0==Hide||(LA13_0>=Loop && LA13_0<=Note)||(LA13_0>=FullStopFullStopFullStop && LA13_0<=Box)||(LA13_0>=Opt && LA13_0<=VerticalLineVerticalLineVerticalLine)||LA13_0==EqualsSignEqualsSign||LA13_0==VerticalLineVerticalLine||LA13_0==RULE_NEWLINE||LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1262:2: rule__Diagram__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Diagram__InstructionsAssignment_3_in_rule__Diagram__Group__3__Impl2730);
            	    rule__Diagram__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getInstructionsAssignment_3()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1272:1: rule__Diagram__Group__4 : rule__Diagram__Group__4__Impl rule__Diagram__Group__5 ;
    public final void rule__Diagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1276:1: ( rule__Diagram__Group__4__Impl rule__Diagram__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1277:2: rule__Diagram__Group__4__Impl rule__Diagram__Group__5
            {
            pushFollow(FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__42761);
            rule__Diagram__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Diagram__Group__5_in_rule__Diagram__Group__42764);
            rule__Diagram__Group__5();

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1284:1: rule__Diagram__Group__4__Impl : ( RULE_END ) ;
    public final void rule__Diagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1288:1: ( ( RULE_END ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1289:1: ( RULE_END )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1289:1: ( RULE_END )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1290:1: RULE_END
            {
             before(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_4()); 
            match(input,RULE_END,FOLLOW_RULE_END_in_rule__Diagram__Group__4__Impl2791); 
             after(grammarAccess.getDiagramAccess().getENDTerminalRuleCall_4()); 

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


    // $ANTLR start "rule__Diagram__Group__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1301:1: rule__Diagram__Group__5 : rule__Diagram__Group__5__Impl ;
    public final void rule__Diagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1305:1: ( rule__Diagram__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1306:2: rule__Diagram__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Diagram__Group__5__Impl_in_rule__Diagram__Group__52820);
            rule__Diagram__Group__5__Impl();

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
    // $ANTLR end "rule__Diagram__Group__5"


    // $ANTLR start "rule__Diagram__Group__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1312:1: rule__Diagram__Group__5__Impl : ( ( RULE_NEWLINE )* ) ;
    public final void rule__Diagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1316:1: ( ( ( RULE_NEWLINE )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1317:1: ( ( RULE_NEWLINE )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1317:1: ( ( RULE_NEWLINE )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1318:1: ( RULE_NEWLINE )*
            {
             before(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_5()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1319:1: ( RULE_NEWLINE )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_NEWLINE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1319:3: RULE_NEWLINE
            	    {
            	    match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__5__Impl2848); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getDiagramAccess().getNEWLINETerminalRuleCall_5()); 

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
    // $ANTLR end "rule__Diagram__Group__5__Impl"


    // $ANTLR start "rule__Instruction__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1341:1: rule__Instruction__Group__0 : rule__Instruction__Group__0__Impl rule__Instruction__Group__1 ;
    public final void rule__Instruction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1345:1: ( rule__Instruction__Group__0__Impl rule__Instruction__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1346:2: rule__Instruction__Group__0__Impl rule__Instruction__Group__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__02891);
            rule__Instruction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__02894);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1353:1: rule__Instruction__Group__0__Impl : ( ( rule__Instruction__Alternatives_0 )? ) ;
    public final void rule__Instruction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1357:1: ( ( ( rule__Instruction__Alternatives_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1358:1: ( ( rule__Instruction__Alternatives_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1358:1: ( ( rule__Instruction__Alternatives_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1359:1: ( rule__Instruction__Alternatives_0 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1360:1: ( rule__Instruction__Alternatives_0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=Participant && LA15_0<=Deactivate)||(LA15_0>=Activate && LA15_0<=Destroy)||LA15_0==Newpage||(LA15_0>=Create && LA15_0<=Group)||LA15_0==Title||LA15_0==Hide||(LA15_0>=Loop && LA15_0<=Note)||(LA15_0>=FullStopFullStopFullStop && LA15_0<=Box)||(LA15_0>=Opt && LA15_0<=VerticalLineVerticalLineVerticalLine)||LA15_0==EqualsSignEqualsSign||LA15_0==VerticalLineVerticalLine||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1360:2: rule__Instruction__Alternatives_0
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl2921);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1370:1: rule__Instruction__Group__1 : rule__Instruction__Group__1__Impl ;
    public final void rule__Instruction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1374:1: ( rule__Instruction__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1375:2: rule__Instruction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__12952);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1381:1: rule__Instruction__Group__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Instruction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1385:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1386:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1386:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1387:1: RULE_NEWLINE
            {
             before(grammarAccess.getInstructionAccess().getNEWLINETerminalRuleCall_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl2979); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1402:1: rule__Instruction__Group_0_1__0 : rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 ;
    public final void rule__Instruction__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1406:1: ( rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1407:2: rule__Instruction__Group_0_1__0__Impl rule__Instruction__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__03012);
            rule__Instruction__Group_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__03015);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1414:1: rule__Instruction__Group_0_1__0__Impl : ( ruleDefinition ) ;
    public final void rule__Instruction__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1418:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1419:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1419:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1420:1: ruleDefinition
            {
             before(grammarAccess.getInstructionAccess().getDefinitionParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl3042);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1431:1: rule__Instruction__Group_0_1__1 : rule__Instruction__Group_0_1__1__Impl ;
    public final void rule__Instruction__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1435:1: ( rule__Instruction__Group_0_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1436:2: rule__Instruction__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__13071);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1442:1: rule__Instruction__Group_0_1__1__Impl : ( ( rule__Instruction__Alternatives_0_1_1 )? ) ;
    public final void rule__Instruction__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1446:1: ( ( ( rule__Instruction__Alternatives_0_1_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1447:1: ( ( rule__Instruction__Alternatives_0_1_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1447:1: ( ( rule__Instruction__Alternatives_0_1_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1448:1: ( rule__Instruction__Alternatives_0_1_1 )?
            {
             before(grammarAccess.getInstructionAccess().getAlternatives_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1449:1: ( rule__Instruction__Alternatives_0_1_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_COLOR && LA16_0<=RULE_HEXCODE)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1449:2: rule__Instruction__Alternatives_0_1_1
                    {
                    pushFollow(FOLLOW_rule__Instruction__Alternatives_0_1_1_in_rule__Instruction__Group_0_1__1__Impl3098);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1463:1: rule__Arrow__Group__0 : rule__Arrow__Group__0__Impl rule__Arrow__Group__1 ;
    public final void rule__Arrow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1467:1: ( rule__Arrow__Group__0__Impl rule__Arrow__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1468:2: rule__Arrow__Group__0__Impl rule__Arrow__Group__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__03133);
            rule__Arrow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__03136);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1475:1: rule__Arrow__Group__0__Impl : ( ( rule__Arrow__NameAssignment_0 ) ) ;
    public final void rule__Arrow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1479:1: ( ( ( rule__Arrow__NameAssignment_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1480:1: ( ( rule__Arrow__NameAssignment_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1480:1: ( ( rule__Arrow__NameAssignment_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1481:1: ( rule__Arrow__NameAssignment_0 )
            {
             before(grammarAccess.getArrowAccess().getNameAssignment_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1482:1: ( rule__Arrow__NameAssignment_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1482:2: rule__Arrow__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl3163);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1492:1: rule__Arrow__Group__1 : rule__Arrow__Group__1__Impl rule__Arrow__Group__2 ;
    public final void rule__Arrow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1496:1: ( rule__Arrow__Group__1__Impl rule__Arrow__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1497:2: rule__Arrow__Group__1__Impl rule__Arrow__Group__2
            {
            pushFollow(FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__13193);
            rule__Arrow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__13196);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1504:1: rule__Arrow__Group__1__Impl : ( RULE_SEQUENCE ) ;
    public final void rule__Arrow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1508:1: ( ( RULE_SEQUENCE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1509:1: ( RULE_SEQUENCE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1509:1: ( RULE_SEQUENCE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1510:1: RULE_SEQUENCE
            {
             before(grammarAccess.getArrowAccess().getSEQUENCETerminalRuleCall_1()); 
            match(input,RULE_SEQUENCE,FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl3223); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1521:1: rule__Arrow__Group__2 : rule__Arrow__Group__2__Impl rule__Arrow__Group__3 ;
    public final void rule__Arrow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1525:1: ( rule__Arrow__Group__2__Impl rule__Arrow__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1526:2: rule__Arrow__Group__2__Impl rule__Arrow__Group__3
            {
            pushFollow(FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__23252);
            rule__Arrow__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__23255);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1533:1: rule__Arrow__Group__2__Impl : ( ( rule__Arrow__NameAssignment_2 ) ) ;
    public final void rule__Arrow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1537:1: ( ( ( rule__Arrow__NameAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1538:1: ( ( rule__Arrow__NameAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1538:1: ( ( rule__Arrow__NameAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1539:1: ( rule__Arrow__NameAssignment_2 )
            {
             before(grammarAccess.getArrowAccess().getNameAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1540:1: ( rule__Arrow__NameAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1540:2: rule__Arrow__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Arrow__NameAssignment_2_in_rule__Arrow__Group__2__Impl3282);
            rule__Arrow__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getArrowAccess().getNameAssignment_2()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1550:1: rule__Arrow__Group__3 : rule__Arrow__Group__3__Impl ;
    public final void rule__Arrow__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1554:1: ( rule__Arrow__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1555:2: rule__Arrow__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__33312);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1561:1: rule__Arrow__Group__3__Impl : ( ( rule__Arrow__Group_3__0 )? ) ;
    public final void rule__Arrow__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1565:1: ( ( ( rule__Arrow__Group_3__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1566:1: ( ( rule__Arrow__Group_3__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1566:1: ( ( rule__Arrow__Group_3__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1567:1: ( rule__Arrow__Group_3__0 )?
            {
             before(grammarAccess.getArrowAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1568:1: ( rule__Arrow__Group_3__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Colon) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1568:2: rule__Arrow__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl3339);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1586:1: rule__Arrow__Group_3__0 : rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 ;
    public final void rule__Arrow__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1590:1: ( rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1591:2: rule__Arrow__Group_3__0__Impl rule__Arrow__Group_3__1
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__03378);
            rule__Arrow__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__03381);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1598:1: rule__Arrow__Group_3__0__Impl : ( Colon ) ;
    public final void rule__Arrow__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1602:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1603:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1603:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1604:1: Colon
            {
             before(grammarAccess.getArrowAccess().getColonKeyword_3_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl3409); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1617:1: rule__Arrow__Group_3__1 : rule__Arrow__Group_3__1__Impl ;
    public final void rule__Arrow__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1621:1: ( rule__Arrow__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1622:2: rule__Arrow__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__13440);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1628:1: rule__Arrow__Group_3__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Arrow__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1632:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1633:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1633:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1634:1: ( RULE_ID )*
            {
             before(grammarAccess.getArrowAccess().getIDTerminalRuleCall_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1635:1: ( RULE_ID )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1635:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Arrow__Group_3__1__Impl3468); 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getArrowAccess().getIDTerminalRuleCall_3_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1649:1: rule__Definition__Group_0__0 : rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 ;
    public final void rule__Definition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1653:1: ( rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1654:2: rule__Definition__Group_0__0__Impl rule__Definition__Group_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__03503);
            rule__Definition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__03506);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1661:1: rule__Definition__Group_0__0__Impl : ( Actor ) ;
    public final void rule__Definition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1665:1: ( ( Actor ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1666:1: ( Actor )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1666:1: ( Actor )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1667:1: Actor
            {
             before(grammarAccess.getDefinitionAccess().getActorKeyword_0_0()); 
            match(input,Actor,FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl3534); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1680:1: rule__Definition__Group_0__1 : rule__Definition__Group_0__1__Impl ;
    public final void rule__Definition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1684:1: ( rule__Definition__Group_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1685:2: rule__Definition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__13565);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1691:1: rule__Definition__Group_0__1__Impl : ( ( rule__Definition__NameAssignment_0_1 ) ) ;
    public final void rule__Definition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1695:1: ( ( ( rule__Definition__NameAssignment_0_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1696:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1696:1: ( ( rule__Definition__NameAssignment_0_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1697:1: ( rule__Definition__NameAssignment_0_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1698:1: ( rule__Definition__NameAssignment_0_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1698:2: rule__Definition__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl3592);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1712:1: rule__Definition__Group_1__0 : rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 ;
    public final void rule__Definition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1716:1: ( rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1717:2: rule__Definition__Group_1__0__Impl rule__Definition__Group_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__03626);
            rule__Definition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__03629);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1724:1: rule__Definition__Group_1__0__Impl : ( Boundary ) ;
    public final void rule__Definition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1728:1: ( ( Boundary ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1729:1: ( Boundary )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1729:1: ( Boundary )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1730:1: Boundary
            {
             before(grammarAccess.getDefinitionAccess().getBoundaryKeyword_1_0()); 
            match(input,Boundary,FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl3657); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1743:1: rule__Definition__Group_1__1 : rule__Definition__Group_1__1__Impl ;
    public final void rule__Definition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1747:1: ( rule__Definition__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1748:2: rule__Definition__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__13688);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1754:1: rule__Definition__Group_1__1__Impl : ( ( rule__Definition__NameAssignment_1_1 ) ) ;
    public final void rule__Definition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1758:1: ( ( ( rule__Definition__NameAssignment_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1759:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1759:1: ( ( rule__Definition__NameAssignment_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1760:1: ( rule__Definition__NameAssignment_1_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1761:1: ( rule__Definition__NameAssignment_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1761:2: rule__Definition__NameAssignment_1_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl3715);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1775:1: rule__Definition__Group_2__0 : rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 ;
    public final void rule__Definition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1779:1: ( rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1780:2: rule__Definition__Group_2__0__Impl rule__Definition__Group_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__03749);
            rule__Definition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__03752);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1787:1: rule__Definition__Group_2__0__Impl : ( Control ) ;
    public final void rule__Definition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1791:1: ( ( Control ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1792:1: ( Control )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1792:1: ( Control )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1793:1: Control
            {
             before(grammarAccess.getDefinitionAccess().getControlKeyword_2_0()); 
            match(input,Control,FOLLOW_Control_in_rule__Definition__Group_2__0__Impl3780); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1806:1: rule__Definition__Group_2__1 : rule__Definition__Group_2__1__Impl ;
    public final void rule__Definition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1810:1: ( rule__Definition__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1811:2: rule__Definition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__13811);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1817:1: rule__Definition__Group_2__1__Impl : ( ( rule__Definition__NameAssignment_2_1 ) ) ;
    public final void rule__Definition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1821:1: ( ( ( rule__Definition__NameAssignment_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1822:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1822:1: ( ( rule__Definition__NameAssignment_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1823:1: ( rule__Definition__NameAssignment_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1824:1: ( rule__Definition__NameAssignment_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1824:2: rule__Definition__NameAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl3838);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1838:1: rule__Definition__Group_3__0 : rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 ;
    public final void rule__Definition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1842:1: ( rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1843:2: rule__Definition__Group_3__0__Impl rule__Definition__Group_3__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__03872);
            rule__Definition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__03875);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1850:1: rule__Definition__Group_3__0__Impl : ( Entity ) ;
    public final void rule__Definition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1854:1: ( ( Entity ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1855:1: ( Entity )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1855:1: ( Entity )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1856:1: Entity
            {
             before(grammarAccess.getDefinitionAccess().getEntityKeyword_3_0()); 
            match(input,Entity,FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl3903); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1869:1: rule__Definition__Group_3__1 : rule__Definition__Group_3__1__Impl ;
    public final void rule__Definition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1873:1: ( rule__Definition__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1874:2: rule__Definition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__13934);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1880:1: rule__Definition__Group_3__1__Impl : ( ( rule__Definition__NameAssignment_3_1 ) ) ;
    public final void rule__Definition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1884:1: ( ( ( rule__Definition__NameAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1885:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1885:1: ( ( rule__Definition__NameAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1886:1: ( rule__Definition__NameAssignment_3_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1887:1: ( rule__Definition__NameAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1887:2: rule__Definition__NameAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl3961);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1901:1: rule__Definition__Group_4__0 : rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 ;
    public final void rule__Definition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1905:1: ( rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1906:2: rule__Definition__Group_4__0__Impl rule__Definition__Group_4__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__03995);
            rule__Definition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__03998);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1913:1: rule__Definition__Group_4__0__Impl : ( Database ) ;
    public final void rule__Definition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1917:1: ( ( Database ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1918:1: ( Database )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1918:1: ( Database )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1919:1: Database
            {
             before(grammarAccess.getDefinitionAccess().getDatabaseKeyword_4_0()); 
            match(input,Database,FOLLOW_Database_in_rule__Definition__Group_4__0__Impl4026); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1932:1: rule__Definition__Group_4__1 : rule__Definition__Group_4__1__Impl ;
    public final void rule__Definition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1936:1: ( rule__Definition__Group_4__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1937:2: rule__Definition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__14057);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1943:1: rule__Definition__Group_4__1__Impl : ( ( rule__Definition__NameAssignment_4_1 ) ) ;
    public final void rule__Definition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1947:1: ( ( ( rule__Definition__NameAssignment_4_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1948:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1948:1: ( ( rule__Definition__NameAssignment_4_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1949:1: ( rule__Definition__NameAssignment_4_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_4_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1950:1: ( rule__Definition__NameAssignment_4_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1950:2: rule__Definition__NameAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl4084);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1964:1: rule__Definition__Group_5__0 : rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 ;
    public final void rule__Definition__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1968:1: ( rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1969:2: rule__Definition__Group_5__0__Impl rule__Definition__Group_5__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__04118);
            rule__Definition__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__04121);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1976:1: rule__Definition__Group_5__0__Impl : ( Participant ) ;
    public final void rule__Definition__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1980:1: ( ( Participant ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1981:1: ( Participant )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1981:1: ( Participant )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1982:1: Participant
            {
             before(grammarAccess.getDefinitionAccess().getParticipantKeyword_5_0()); 
            match(input,Participant,FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl4149); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1995:1: rule__Definition__Group_5__1 : rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 ;
    public final void rule__Definition__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:1999:1: ( rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2000:2: rule__Definition__Group_5__1__Impl rule__Definition__Group_5__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__14180);
            rule__Definition__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__14183);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2007:1: rule__Definition__Group_5__1__Impl : ( ( rule__Definition__NameAssignment_5_1 ) ) ;
    public final void rule__Definition__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2011:1: ( ( ( rule__Definition__NameAssignment_5_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2012:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2012:1: ( ( rule__Definition__NameAssignment_5_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2013:1: ( rule__Definition__NameAssignment_5_1 )
            {
             before(grammarAccess.getDefinitionAccess().getNameAssignment_5_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2014:1: ( rule__Definition__NameAssignment_5_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2014:2: rule__Definition__NameAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl4210);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2024:1: rule__Definition__Group_5__2 : rule__Definition__Group_5__2__Impl ;
    public final void rule__Definition__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2028:1: ( rule__Definition__Group_5__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2029:2: rule__Definition__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__24240);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2035:1: rule__Definition__Group_5__2__Impl : ( ( rule__Definition__Group_5_2__0 )? ) ;
    public final void rule__Definition__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2039:1: ( ( ( rule__Definition__Group_5_2__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2040:1: ( ( rule__Definition__Group_5_2__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2040:1: ( ( rule__Definition__Group_5_2__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2041:1: ( rule__Definition__Group_5_2__0 )?
            {
             before(grammarAccess.getDefinitionAccess().getGroup_5_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2042:1: ( rule__Definition__Group_5_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LessThanSignLessThanSign) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2042:2: rule__Definition__Group_5_2__0
                    {
                    pushFollow(FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl4267);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2058:1: rule__Definition__Group_5_2__0 : rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 ;
    public final void rule__Definition__Group_5_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2062:1: ( rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2063:2: rule__Definition__Group_5_2__0__Impl rule__Definition__Group_5_2__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__04304);
            rule__Definition__Group_5_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__04307);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2070:1: rule__Definition__Group_5_2__0__Impl : ( LessThanSignLessThanSign ) ;
    public final void rule__Definition__Group_5_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2074:1: ( ( LessThanSignLessThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2075:1: ( LessThanSignLessThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2075:1: ( LessThanSignLessThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2076:1: LessThanSignLessThanSign
            {
             before(grammarAccess.getDefinitionAccess().getLessThanSignLessThanSignKeyword_5_2_0()); 
            match(input,LessThanSignLessThanSign,FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl4335); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2089:1: rule__Definition__Group_5_2__1 : rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 ;
    public final void rule__Definition__Group_5_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2093:1: ( rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2094:2: rule__Definition__Group_5_2__1__Impl rule__Definition__Group_5_2__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__14366);
            rule__Definition__Group_5_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__14369);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2101:1: rule__Definition__Group_5_2__1__Impl : ( ( rule__Definition__Alternatives_5_2_1 ) ) ;
    public final void rule__Definition__Group_5_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2105:1: ( ( ( rule__Definition__Alternatives_5_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2106:1: ( ( rule__Definition__Alternatives_5_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2106:1: ( ( rule__Definition__Alternatives_5_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2107:1: ( rule__Definition__Alternatives_5_2_1 )
            {
             before(grammarAccess.getDefinitionAccess().getAlternatives_5_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2108:1: ( rule__Definition__Alternatives_5_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2108:2: rule__Definition__Alternatives_5_2_1
            {
            pushFollow(FOLLOW_rule__Definition__Alternatives_5_2_1_in_rule__Definition__Group_5_2__1__Impl4396);
            rule__Definition__Alternatives_5_2_1();

            state._fsp--;


            }

             after(grammarAccess.getDefinitionAccess().getAlternatives_5_2_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2118:1: rule__Definition__Group_5_2__2 : rule__Definition__Group_5_2__2__Impl ;
    public final void rule__Definition__Group_5_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2122:1: ( rule__Definition__Group_5_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2123:2: rule__Definition__Group_5_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__24426);
            rule__Definition__Group_5_2__2__Impl();

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2129:1: rule__Definition__Group_5_2__2__Impl : ( GreaterThanSignGreaterThanSign ) ;
    public final void rule__Definition__Group_5_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2133:1: ( ( GreaterThanSignGreaterThanSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2134:1: ( GreaterThanSignGreaterThanSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2134:1: ( GreaterThanSignGreaterThanSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2135:1: GreaterThanSignGreaterThanSign
            {
             before(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_2()); 
            match(input,GreaterThanSignGreaterThanSign,FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__2__Impl4454); 
             after(grammarAccess.getDefinitionAccess().getGreaterThanSignGreaterThanSignKeyword_5_2_2()); 

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


    // $ANTLR start "rule__Definition__Group_5_2_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2154:1: rule__Definition__Group_5_2_1_0__0 : rule__Definition__Group_5_2_1_0__0__Impl rule__Definition__Group_5_2_1_0__1 ;
    public final void rule__Definition__Group_5_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2158:1: ( rule__Definition__Group_5_2_1_0__0__Impl rule__Definition__Group_5_2_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2159:2: rule__Definition__Group_5_2_1_0__0__Impl rule__Definition__Group_5_2_1_0__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__0__Impl_in_rule__Definition__Group_5_2_1_0__04491);
            rule__Definition__Group_5_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__1_in_rule__Definition__Group_5_2_1_0__04494);
            rule__Definition__Group_5_2_1_0__1();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__0"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2166:1: rule__Definition__Group_5_2_1_0__0__Impl : ( LeftParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2170:1: ( ( LeftParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2171:1: ( LeftParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2171:1: ( LeftParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2172:1: LeftParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0_0()); 
            match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_0__0__Impl4522); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_0_0()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2185:1: rule__Definition__Group_5_2_1_0__1 : rule__Definition__Group_5_2_1_0__1__Impl rule__Definition__Group_5_2_1_0__2 ;
    public final void rule__Definition__Group_5_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2189:1: ( rule__Definition__Group_5_2_1_0__1__Impl rule__Definition__Group_5_2_1_0__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2190:2: rule__Definition__Group_5_2_1_0__1__Impl rule__Definition__Group_5_2_1_0__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__1__Impl_in_rule__Definition__Group_5_2_1_0__14553);
            rule__Definition__Group_5_2_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__2_in_rule__Definition__Group_5_2_1_0__14556);
            rule__Definition__Group_5_2_1_0__2();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__1"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2197:1: rule__Definition__Group_5_2_1_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Definition__Group_5_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2201:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2202:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2202:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2203:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_0__1__Impl4583); 
             after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_0_1()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2214:1: rule__Definition__Group_5_2_1_0__2 : rule__Definition__Group_5_2_1_0__2__Impl rule__Definition__Group_5_2_1_0__3 ;
    public final void rule__Definition__Group_5_2_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2218:1: ( rule__Definition__Group_5_2_1_0__2__Impl rule__Definition__Group_5_2_1_0__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2219:2: rule__Definition__Group_5_2_1_0__2__Impl rule__Definition__Group_5_2_1_0__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__2__Impl_in_rule__Definition__Group_5_2_1_0__24612);
            rule__Definition__Group_5_2_1_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__3_in_rule__Definition__Group_5_2_1_0__24615);
            rule__Definition__Group_5_2_1_0__3();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__2"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2226:1: rule__Definition__Group_5_2_1_0__2__Impl : ( Comma ) ;
    public final void rule__Definition__Group_5_2_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2230:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2231:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2231:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2232:1: Comma
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_0_2()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Definition__Group_5_2_1_0__2__Impl4643); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_0_2()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2245:1: rule__Definition__Group_5_2_1_0__3 : rule__Definition__Group_5_2_1_0__3__Impl rule__Definition__Group_5_2_1_0__4 ;
    public final void rule__Definition__Group_5_2_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2249:1: ( rule__Definition__Group_5_2_1_0__3__Impl rule__Definition__Group_5_2_1_0__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2250:2: rule__Definition__Group_5_2_1_0__3__Impl rule__Definition__Group_5_2_1_0__4
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__3__Impl_in_rule__Definition__Group_5_2_1_0__34674);
            rule__Definition__Group_5_2_1_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__4_in_rule__Definition__Group_5_2_1_0__34677);
            rule__Definition__Group_5_2_1_0__4();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__3"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2257:1: rule__Definition__Group_5_2_1_0__3__Impl : ( RULE_COLOR ) ;
    public final void rule__Definition__Group_5_2_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2261:1: ( ( RULE_COLOR ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2262:1: ( RULE_COLOR )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2262:1: ( RULE_COLOR )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2263:1: RULE_COLOR
            {
             before(grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_0_3()); 
            match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Definition__Group_5_2_1_0__3__Impl4704); 
             after(grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_0_3()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2274:1: rule__Definition__Group_5_2_1_0__4 : rule__Definition__Group_5_2_1_0__4__Impl ;
    public final void rule__Definition__Group_5_2_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2278:1: ( rule__Definition__Group_5_2_1_0__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2279:2: rule__Definition__Group_5_2_1_0__4__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_0__4__Impl_in_rule__Definition__Group_5_2_1_0__44733);
            rule__Definition__Group_5_2_1_0__4__Impl();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__4"


    // $ANTLR start "rule__Definition__Group_5_2_1_0__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2285:1: rule__Definition__Group_5_2_1_0__4__Impl : ( RightParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2289:1: ( ( RightParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2290:1: ( RightParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2290:1: ( RightParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2291:1: RightParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_0_4()); 
            match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_0__4__Impl4761); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_0_4()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_0__4__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2314:1: rule__Definition__Group_5_2_1_1__0 : rule__Definition__Group_5_2_1_1__0__Impl rule__Definition__Group_5_2_1_1__1 ;
    public final void rule__Definition__Group_5_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2318:1: ( rule__Definition__Group_5_2_1_1__0__Impl rule__Definition__Group_5_2_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2319:2: rule__Definition__Group_5_2_1_1__0__Impl rule__Definition__Group_5_2_1_1__1
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__0__Impl_in_rule__Definition__Group_5_2_1_1__04802);
            rule__Definition__Group_5_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__1_in_rule__Definition__Group_5_2_1_1__04805);
            rule__Definition__Group_5_2_1_1__1();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__0"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__0__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2326:1: rule__Definition__Group_5_2_1_1__0__Impl : ( LeftParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2330:1: ( ( LeftParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2331:1: ( LeftParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2331:1: ( LeftParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2332:1: LeftParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_1_0()); 
            match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_1__0__Impl4833); 
             after(grammarAccess.getDefinitionAccess().getLeftParenthesisKeyword_5_2_1_1_0()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__0__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2345:1: rule__Definition__Group_5_2_1_1__1 : rule__Definition__Group_5_2_1_1__1__Impl rule__Definition__Group_5_2_1_1__2 ;
    public final void rule__Definition__Group_5_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2349:1: ( rule__Definition__Group_5_2_1_1__1__Impl rule__Definition__Group_5_2_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2350:2: rule__Definition__Group_5_2_1_1__1__Impl rule__Definition__Group_5_2_1_1__2
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__1__Impl_in_rule__Definition__Group_5_2_1_1__14864);
            rule__Definition__Group_5_2_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__2_in_rule__Definition__Group_5_2_1_1__14867);
            rule__Definition__Group_5_2_1_1__2();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__1"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__1__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2357:1: rule__Definition__Group_5_2_1_1__1__Impl : ( RULE_ID ) ;
    public final void rule__Definition__Group_5_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2361:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2362:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2362:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2363:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__1__Impl4894); 
             after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_1()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__1__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2374:1: rule__Definition__Group_5_2_1_1__2 : rule__Definition__Group_5_2_1_1__2__Impl rule__Definition__Group_5_2_1_1__3 ;
    public final void rule__Definition__Group_5_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2378:1: ( rule__Definition__Group_5_2_1_1__2__Impl rule__Definition__Group_5_2_1_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2379:2: rule__Definition__Group_5_2_1_1__2__Impl rule__Definition__Group_5_2_1_1__3
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__2__Impl_in_rule__Definition__Group_5_2_1_1__24923);
            rule__Definition__Group_5_2_1_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__3_in_rule__Definition__Group_5_2_1_1__24926);
            rule__Definition__Group_5_2_1_1__3();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__2"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__2__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2386:1: rule__Definition__Group_5_2_1_1__2__Impl : ( Comma ) ;
    public final void rule__Definition__Group_5_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2390:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2391:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2391:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2392:1: Comma
            {
             before(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_1_2()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Definition__Group_5_2_1_1__2__Impl4954); 
             after(grammarAccess.getDefinitionAccess().getCommaKeyword_5_2_1_1_2()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__2__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2405:1: rule__Definition__Group_5_2_1_1__3 : rule__Definition__Group_5_2_1_1__3__Impl rule__Definition__Group_5_2_1_1__4 ;
    public final void rule__Definition__Group_5_2_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2409:1: ( rule__Definition__Group_5_2_1_1__3__Impl rule__Definition__Group_5_2_1_1__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2410:2: rule__Definition__Group_5_2_1_1__3__Impl rule__Definition__Group_5_2_1_1__4
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__3__Impl_in_rule__Definition__Group_5_2_1_1__34985);
            rule__Definition__Group_5_2_1_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__4_in_rule__Definition__Group_5_2_1_1__34988);
            rule__Definition__Group_5_2_1_1__4();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__3"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2417:1: rule__Definition__Group_5_2_1_1__3__Impl : ( RULE_COLOR ) ;
    public final void rule__Definition__Group_5_2_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2421:1: ( ( RULE_COLOR ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2422:1: ( RULE_COLOR )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2422:1: ( RULE_COLOR )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2423:1: RULE_COLOR
            {
             before(grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_1_3()); 
            match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Definition__Group_5_2_1_1__3__Impl5015); 
             after(grammarAccess.getDefinitionAccess().getCOLORTerminalRuleCall_5_2_1_1_3()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__3__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__4"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2434:1: rule__Definition__Group_5_2_1_1__4 : rule__Definition__Group_5_2_1_1__4__Impl rule__Definition__Group_5_2_1_1__5 ;
    public final void rule__Definition__Group_5_2_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2438:1: ( rule__Definition__Group_5_2_1_1__4__Impl rule__Definition__Group_5_2_1_1__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2439:2: rule__Definition__Group_5_2_1_1__4__Impl rule__Definition__Group_5_2_1_1__5
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__4__Impl_in_rule__Definition__Group_5_2_1_1__45044);
            rule__Definition__Group_5_2_1_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__5_in_rule__Definition__Group_5_2_1_1__45047);
            rule__Definition__Group_5_2_1_1__5();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__4"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__4__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2446:1: rule__Definition__Group_5_2_1_1__4__Impl : ( RightParenthesis ) ;
    public final void rule__Definition__Group_5_2_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2450:1: ( ( RightParenthesis ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2451:1: ( RightParenthesis )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2451:1: ( RightParenthesis )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2452:1: RightParenthesis
            {
             before(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_1_4()); 
            match(input,RightParenthesis,FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_1__4__Impl5075); 
             after(grammarAccess.getDefinitionAccess().getRightParenthesisKeyword_5_2_1_1_4()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__4__Impl"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__5"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2465:1: rule__Definition__Group_5_2_1_1__5 : rule__Definition__Group_5_2_1_1__5__Impl ;
    public final void rule__Definition__Group_5_2_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2469:1: ( rule__Definition__Group_5_2_1_1__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2470:2: rule__Definition__Group_5_2_1_1__5__Impl
            {
            pushFollow(FOLLOW_rule__Definition__Group_5_2_1_1__5__Impl_in_rule__Definition__Group_5_2_1_1__55106);
            rule__Definition__Group_5_2_1_1__5__Impl();

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__5"


    // $ANTLR start "rule__Definition__Group_5_2_1_1__5__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2476:1: rule__Definition__Group_5_2_1_1__5__Impl : ( RULE_ID ) ;
    public final void rule__Definition__Group_5_2_1_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2480:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2481:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2481:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2482:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_5()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__5__Impl5133); 
             after(grammarAccess.getDefinitionAccess().getIDTerminalRuleCall_5_2_1_1_5()); 

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
    // $ANTLR end "rule__Definition__Group_5_2_1_1__5__Impl"


    // $ANTLR start "rule__AutoNumber__Group__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2505:1: rule__AutoNumber__Group__0 : rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 ;
    public final void rule__AutoNumber__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2509:1: ( rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2510:2: rule__AutoNumber__Group__0__Impl rule__AutoNumber__Group__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__05174);
            rule__AutoNumber__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__05177);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2517:1: rule__AutoNumber__Group__0__Impl : ( Autonumber ) ;
    public final void rule__AutoNumber__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2521:1: ( ( Autonumber ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2522:1: ( Autonumber )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2522:1: ( Autonumber )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2523:1: Autonumber
            {
             before(grammarAccess.getAutoNumberAccess().getAutonumberKeyword_0()); 
            match(input,Autonumber,FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl5205); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2536:1: rule__AutoNumber__Group__1 : rule__AutoNumber__Group__1__Impl ;
    public final void rule__AutoNumber__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2540:1: ( rule__AutoNumber__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2541:2: rule__AutoNumber__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__15236);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2547:1: rule__AutoNumber__Group__1__Impl : ( ( rule__AutoNumber__Group_1__0 )? ) ;
    public final void rule__AutoNumber__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2551:1: ( ( ( rule__AutoNumber__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2552:1: ( ( rule__AutoNumber__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2552:1: ( ( rule__AutoNumber__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2553:1: ( rule__AutoNumber__Group_1__0 )?
            {
             before(grammarAccess.getAutoNumberAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2554:1: ( rule__AutoNumber__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2554:2: rule__AutoNumber__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl5263);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2568:1: rule__AutoNumber__Group_1__0 : rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 ;
    public final void rule__AutoNumber__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2572:1: ( rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2573:2: rule__AutoNumber__Group_1__0__Impl rule__AutoNumber__Group_1__1
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__05298);
            rule__AutoNumber__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__05301);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2580:1: rule__AutoNumber__Group_1__0__Impl : ( RULE_INT ) ;
    public final void rule__AutoNumber__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2584:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2585:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2585:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2586:1: RULE_INT
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_0()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl5328); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2597:1: rule__AutoNumber__Group_1__1 : rule__AutoNumber__Group_1__1__Impl ;
    public final void rule__AutoNumber__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2601:1: ( rule__AutoNumber__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2602:2: rule__AutoNumber__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__15357);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2608:1: rule__AutoNumber__Group_1__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__AutoNumber__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2612:1: ( ( ( RULE_INT )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2613:1: ( ( RULE_INT )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2613:1: ( ( RULE_INT )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2614:1: ( RULE_INT )?
            {
             before(grammarAccess.getAutoNumberAccess().getINTTerminalRuleCall_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2615:1: ( RULE_INT )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2615:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl5385); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2629:1: rule__Title__Group__0 : rule__Title__Group__0__Impl rule__Title__Group__1 ;
    public final void rule__Title__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2633:1: ( rule__Title__Group__0__Impl rule__Title__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2634:2: rule__Title__Group__0__Impl rule__Title__Group__1
            {
            pushFollow(FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__05420);
            rule__Title__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Title__Group__1_in_rule__Title__Group__05423);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2641:1: rule__Title__Group__0__Impl : ( Title ) ;
    public final void rule__Title__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2645:1: ( ( Title ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2646:1: ( Title )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2646:1: ( Title )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2647:1: Title
            {
             before(grammarAccess.getTitleAccess().getTitleKeyword_0()); 
            match(input,Title,FOLLOW_Title_in_rule__Title__Group__0__Impl5451); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2660:1: rule__Title__Group__1 : rule__Title__Group__1__Impl ;
    public final void rule__Title__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2664:1: ( rule__Title__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2665:2: rule__Title__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__15482);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2671:1: rule__Title__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Title__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2675:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2676:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2676:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2677:1: ( RULE_ID )*
            {
             before(grammarAccess.getTitleAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2678:1: ( RULE_ID )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2678:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl5510); 

            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2692:1: rule__Legend__Group__0 : rule__Legend__Group__0__Impl rule__Legend__Group__1 ;
    public final void rule__Legend__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2696:1: ( rule__Legend__Group__0__Impl rule__Legend__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2697:2: rule__Legend__Group__0__Impl rule__Legend__Group__1
            {
            pushFollow(FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__05545);
            rule__Legend__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__05548);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2704:1: rule__Legend__Group__0__Impl : ( Legend ) ;
    public final void rule__Legend__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2708:1: ( ( Legend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2709:1: ( Legend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2709:1: ( Legend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2710:1: Legend
            {
             before(grammarAccess.getLegendAccess().getLegendKeyword_0()); 
            match(input,Legend,FOLLOW_Legend_in_rule__Legend__Group__0__Impl5576); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2723:1: rule__Legend__Group__1 : rule__Legend__Group__1__Impl rule__Legend__Group__2 ;
    public final void rule__Legend__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2727:1: ( rule__Legend__Group__1__Impl rule__Legend__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2728:2: rule__Legend__Group__1__Impl rule__Legend__Group__2
            {
            pushFollow(FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__15607);
            rule__Legend__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__15610);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2735:1: rule__Legend__Group__1__Impl : ( ( rule__Legend__Alternatives_1 )? ) ;
    public final void rule__Legend__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2739:1: ( ( ( rule__Legend__Alternatives_1 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2740:1: ( ( rule__Legend__Alternatives_1 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2740:1: ( ( rule__Legend__Alternatives_1 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2741:1: ( rule__Legend__Alternatives_1 )?
            {
             before(grammarAccess.getLegendAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2742:1: ( rule__Legend__Alternatives_1 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Center||LA23_0==Right||LA23_0==Left) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2742:2: rule__Legend__Alternatives_1
                    {
                    pushFollow(FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl5637);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2752:1: rule__Legend__Group__2 : rule__Legend__Group__2__Impl rule__Legend__Group__3 ;
    public final void rule__Legend__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2756:1: ( rule__Legend__Group__2__Impl rule__Legend__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2757:2: rule__Legend__Group__2__Impl rule__Legend__Group__3
            {
            pushFollow(FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__25668);
            rule__Legend__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__25671);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2764:1: rule__Legend__Group__2__Impl : ( ( rule__Legend__Group_2__0 )* ) ;
    public final void rule__Legend__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2768:1: ( ( ( rule__Legend__Group_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2769:1: ( ( rule__Legend__Group_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2769:1: ( ( rule__Legend__Group_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2770:1: ( rule__Legend__Group_2__0 )*
            {
             before(grammarAccess.getLegendAccess().getGroup_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2771:1: ( rule__Legend__Group_2__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_NEWLINE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2771:2: rule__Legend__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl5698);
            	    rule__Legend__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2781:1: rule__Legend__Group__3 : rule__Legend__Group__3__Impl ;
    public final void rule__Legend__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2785:1: ( rule__Legend__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2786:2: rule__Legend__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__35729);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2792:1: rule__Legend__Group__3__Impl : ( Endlegend ) ;
    public final void rule__Legend__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2796:1: ( ( Endlegend ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2797:1: ( Endlegend )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2797:1: ( Endlegend )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2798:1: Endlegend
            {
             before(grammarAccess.getLegendAccess().getEndlegendKeyword_3()); 
            match(input,Endlegend,FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl5757); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2819:1: rule__Legend__Group_2__0 : rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 ;
    public final void rule__Legend__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2823:1: ( rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2824:2: rule__Legend__Group_2__0__Impl rule__Legend__Group_2__1
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__05796);
            rule__Legend__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__05799);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2831:1: rule__Legend__Group_2__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Legend__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2835:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2836:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2836:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2837:1: RULE_NEWLINE
            {
             before(grammarAccess.getLegendAccess().getNEWLINETerminalRuleCall_2_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl5826); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2848:1: rule__Legend__Group_2__1 : rule__Legend__Group_2__1__Impl ;
    public final void rule__Legend__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2852:1: ( rule__Legend__Group_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2853:2: rule__Legend__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__15855);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2859:1: rule__Legend__Group_2__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Legend__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2863:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2864:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2864:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2865:1: ( RULE_ID )*
            {
             before(grammarAccess.getLegendAccess().getIDTerminalRuleCall_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2866:1: ( RULE_ID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2866:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl5883); 

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2880:1: rule__Newpage__Group__0 : rule__Newpage__Group__0__Impl rule__Newpage__Group__1 ;
    public final void rule__Newpage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2884:1: ( rule__Newpage__Group__0__Impl rule__Newpage__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2885:2: rule__Newpage__Group__0__Impl rule__Newpage__Group__1
            {
            pushFollow(FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__05918);
            rule__Newpage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__05921);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2892:1: rule__Newpage__Group__0__Impl : ( Newpage ) ;
    public final void rule__Newpage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2896:1: ( ( Newpage ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2897:1: ( Newpage )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2897:1: ( Newpage )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2898:1: Newpage
            {
             before(grammarAccess.getNewpageAccess().getNewpageKeyword_0()); 
            match(input,Newpage,FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl5949); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2911:1: rule__Newpage__Group__1 : rule__Newpage__Group__1__Impl ;
    public final void rule__Newpage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2915:1: ( rule__Newpage__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2916:2: rule__Newpage__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__15980);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2922:1: rule__Newpage__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Newpage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2926:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2927:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2927:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2928:1: ( RULE_ID )*
            {
             before(grammarAccess.getNewpageAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2929:1: ( RULE_ID )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2929:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl6008); 

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2943:1: rule__AltElse__Group__0 : rule__AltElse__Group__0__Impl rule__AltElse__Group__1 ;
    public final void rule__AltElse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2947:1: ( rule__AltElse__Group__0__Impl rule__AltElse__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2948:2: rule__AltElse__Group__0__Impl rule__AltElse__Group__1
            {
            pushFollow(FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__06043);
            rule__AltElse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__06046);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2955:1: rule__AltElse__Group__0__Impl : ( Alt ) ;
    public final void rule__AltElse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2959:1: ( ( Alt ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2960:1: ( Alt )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2960:1: ( Alt )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2961:1: Alt
            {
             before(grammarAccess.getAltElseAccess().getAltKeyword_0()); 
            match(input,Alt,FOLLOW_Alt_in_rule__AltElse__Group__0__Impl6074); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2974:1: rule__AltElse__Group__1 : rule__AltElse__Group__1__Impl rule__AltElse__Group__2 ;
    public final void rule__AltElse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2978:1: ( rule__AltElse__Group__1__Impl rule__AltElse__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2979:2: rule__AltElse__Group__1__Impl rule__AltElse__Group__2
            {
            pushFollow(FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__16105);
            rule__AltElse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__16108);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2986:1: rule__AltElse__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__AltElse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2990:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2991:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2991:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2992:1: ( RULE_ID )*
            {
             before(grammarAccess.getAltElseAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2993:1: ( RULE_ID )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:2993:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__AltElse__Group__1__Impl6136); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getAltElseAccess().getIDTerminalRuleCall_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3003:1: rule__AltElse__Group__2 : rule__AltElse__Group__2__Impl rule__AltElse__Group__3 ;
    public final void rule__AltElse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3007:1: ( rule__AltElse__Group__2__Impl rule__AltElse__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3008:2: rule__AltElse__Group__2__Impl rule__AltElse__Group__3
            {
            pushFollow(FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__26167);
            rule__AltElse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__26170);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3015:1: rule__AltElse__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__AltElse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3019:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3020:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3020:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3021:1: RULE_NEWLINE
            {
             before(grammarAccess.getAltElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl6197); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3032:1: rule__AltElse__Group__3 : rule__AltElse__Group__3__Impl rule__AltElse__Group__4 ;
    public final void rule__AltElse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3036:1: ( rule__AltElse__Group__3__Impl rule__AltElse__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3037:2: rule__AltElse__Group__3__Impl rule__AltElse__Group__4
            {
            pushFollow(FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__36226);
            rule__AltElse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__36229);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3044:1: rule__AltElse__Group__3__Impl : ( ( rule__AltElse__InstructionsAssignment_3 )* ) ;
    public final void rule__AltElse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3048:1: ( ( ( rule__AltElse__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3049:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3049:1: ( ( rule__AltElse__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3050:1: ( rule__AltElse__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getAltElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3051:1: ( rule__AltElse__InstructionsAssignment_3 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=Participant && LA28_0<=Deactivate)||(LA28_0>=Activate && LA28_0<=Destroy)||LA28_0==Newpage||(LA28_0>=Create && LA28_0<=Group)||LA28_0==Title||LA28_0==Hide||(LA28_0>=Loop && LA28_0<=Note)||(LA28_0>=FullStopFullStopFullStop && LA28_0<=Box)||(LA28_0>=Opt && LA28_0<=VerticalLineVerticalLineVerticalLine)||LA28_0==EqualsSignEqualsSign||LA28_0==VerticalLineVerticalLine||LA28_0==RULE_NEWLINE||LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3051:2: rule__AltElse__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl6256);
            	    rule__AltElse__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3061:1: rule__AltElse__Group__4 : rule__AltElse__Group__4__Impl rule__AltElse__Group__5 ;
    public final void rule__AltElse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3065:1: ( rule__AltElse__Group__4__Impl rule__AltElse__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3066:2: rule__AltElse__Group__4__Impl rule__AltElse__Group__5
            {
            pushFollow(FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__46287);
            rule__AltElse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__46290);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3073:1: rule__AltElse__Group__4__Impl : ( ( rule__AltElse__ElsesAssignment_4 )* ) ;
    public final void rule__AltElse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3077:1: ( ( ( rule__AltElse__ElsesAssignment_4 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3078:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3078:1: ( ( rule__AltElse__ElsesAssignment_4 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3079:1: ( rule__AltElse__ElsesAssignment_4 )*
            {
             before(grammarAccess.getAltElseAccess().getElsesAssignment_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3080:1: ( rule__AltElse__ElsesAssignment_4 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==Else) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3080:2: rule__AltElse__ElsesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl6317);
            	    rule__AltElse__ElsesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3090:1: rule__AltElse__Group__5 : rule__AltElse__Group__5__Impl ;
    public final void rule__AltElse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3094:1: ( rule__AltElse__Group__5__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3095:2: rule__AltElse__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__56348);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3101:1: rule__AltElse__Group__5__Impl : ( End ) ;
    public final void rule__AltElse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3105:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3106:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3106:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3107:1: End
            {
             before(grammarAccess.getAltElseAccess().getEndKeyword_5()); 
            match(input,End,FOLLOW_End_in_rule__AltElse__Group__5__Impl6376); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3132:1: rule__Else__Group__0 : rule__Else__Group__0__Impl rule__Else__Group__1 ;
    public final void rule__Else__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3136:1: ( rule__Else__Group__0__Impl rule__Else__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3137:2: rule__Else__Group__0__Impl rule__Else__Group__1
            {
            pushFollow(FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__06419);
            rule__Else__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__1_in_rule__Else__Group__06422);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3144:1: rule__Else__Group__0__Impl : ( Else ) ;
    public final void rule__Else__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3148:1: ( ( Else ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3149:1: ( Else )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3149:1: ( Else )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3150:1: Else
            {
             before(grammarAccess.getElseAccess().getElseKeyword_0()); 
            match(input,Else,FOLLOW_Else_in_rule__Else__Group__0__Impl6450); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3163:1: rule__Else__Group__1 : rule__Else__Group__1__Impl rule__Else__Group__2 ;
    public final void rule__Else__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3167:1: ( rule__Else__Group__1__Impl rule__Else__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3168:2: rule__Else__Group__1__Impl rule__Else__Group__2
            {
            pushFollow(FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__16481);
            rule__Else__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__2_in_rule__Else__Group__16484);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3175:1: rule__Else__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Else__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3179:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3180:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3180:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3181:1: ( RULE_ID )*
            {
             before(grammarAccess.getElseAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3182:1: ( RULE_ID )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3182:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Else__Group__1__Impl6512); 

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getElseAccess().getIDTerminalRuleCall_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3192:1: rule__Else__Group__2 : rule__Else__Group__2__Impl rule__Else__Group__3 ;
    public final void rule__Else__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3196:1: ( rule__Else__Group__2__Impl rule__Else__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3197:2: rule__Else__Group__2__Impl rule__Else__Group__3
            {
            pushFollow(FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__26543);
            rule__Else__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Else__Group__3_in_rule__Else__Group__26546);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3204:1: rule__Else__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Else__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3208:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3209:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3209:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3210:1: RULE_NEWLINE
            {
             before(grammarAccess.getElseAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl6573); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3221:1: rule__Else__Group__3 : rule__Else__Group__3__Impl ;
    public final void rule__Else__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3225:1: ( rule__Else__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3226:2: rule__Else__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__36602);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3232:1: rule__Else__Group__3__Impl : ( ( rule__Else__InstructionsAssignment_3 )* ) ;
    public final void rule__Else__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3236:1: ( ( ( rule__Else__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3237:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3237:1: ( ( rule__Else__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3238:1: ( rule__Else__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getElseAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3239:1: ( rule__Else__InstructionsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=Participant && LA31_0<=Deactivate)||(LA31_0>=Activate && LA31_0<=Destroy)||LA31_0==Newpage||(LA31_0>=Create && LA31_0<=Group)||LA31_0==Title||LA31_0==Hide||(LA31_0>=Loop && LA31_0<=Note)||(LA31_0>=FullStopFullStopFullStop && LA31_0<=Box)||(LA31_0>=Opt && LA31_0<=VerticalLineVerticalLineVerticalLine)||LA31_0==EqualsSignEqualsSign||LA31_0==VerticalLineVerticalLine||LA31_0==RULE_NEWLINE||LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3239:2: rule__Else__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl6629);
            	    rule__Else__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3257:1: rule__GroupingMessages__Group__0 : rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 ;
    public final void rule__GroupingMessages__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3261:1: ( rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3262:2: rule__GroupingMessages__Group__0__Impl rule__GroupingMessages__Group__1
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__06668);
            rule__GroupingMessages__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__06671);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3269:1: rule__GroupingMessages__Group__0__Impl : ( ( rule__GroupingMessages__Alternatives_0 ) ) ;
    public final void rule__GroupingMessages__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3273:1: ( ( ( rule__GroupingMessages__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3274:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3274:1: ( ( rule__GroupingMessages__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3275:1: ( rule__GroupingMessages__Alternatives_0 )
            {
             before(grammarAccess.getGroupingMessagesAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3276:1: ( rule__GroupingMessages__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3276:2: rule__GroupingMessages__Alternatives_0
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl6698);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3286:1: rule__GroupingMessages__Group__1 : rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 ;
    public final void rule__GroupingMessages__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3290:1: ( rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3291:2: rule__GroupingMessages__Group__1__Impl rule__GroupingMessages__Group__2
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__16728);
            rule__GroupingMessages__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__16731);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3298:1: rule__GroupingMessages__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__GroupingMessages__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3302:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3303:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3303:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3304:1: ( RULE_ID )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3305:1: ( RULE_ID )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3305:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl6759); 

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3315:1: rule__GroupingMessages__Group__2 : rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 ;
    public final void rule__GroupingMessages__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3319:1: ( rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3320:2: rule__GroupingMessages__Group__2__Impl rule__GroupingMessages__Group__3
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__26790);
            rule__GroupingMessages__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__26793);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3327:1: rule__GroupingMessages__Group__2__Impl : ( RULE_NEWLINE ) ;
    public final void rule__GroupingMessages__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3331:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3332:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3332:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3333:1: RULE_NEWLINE
            {
             before(grammarAccess.getGroupingMessagesAccess().getNEWLINETerminalRuleCall_2()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl6820); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3344:1: rule__GroupingMessages__Group__3 : rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 ;
    public final void rule__GroupingMessages__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3348:1: ( rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3349:2: rule__GroupingMessages__Group__3__Impl rule__GroupingMessages__Group__4
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__36849);
            rule__GroupingMessages__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__36852);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3356:1: rule__GroupingMessages__Group__3__Impl : ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) ;
    public final void rule__GroupingMessages__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3360:1: ( ( ( rule__GroupingMessages__InstructionsAssignment_3 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3361:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3361:1: ( ( rule__GroupingMessages__InstructionsAssignment_3 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3362:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsAssignment_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3363:1: ( rule__GroupingMessages__InstructionsAssignment_3 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=Participant && LA33_0<=Deactivate)||(LA33_0>=Activate && LA33_0<=Destroy)||LA33_0==Newpage||(LA33_0>=Create && LA33_0<=Group)||LA33_0==Title||LA33_0==Hide||(LA33_0>=Loop && LA33_0<=Note)||(LA33_0>=FullStopFullStopFullStop && LA33_0<=Box)||(LA33_0>=Opt && LA33_0<=VerticalLineVerticalLineVerticalLine)||LA33_0==EqualsSignEqualsSign||LA33_0==VerticalLineVerticalLine||LA33_0==RULE_NEWLINE||LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3363:2: rule__GroupingMessages__InstructionsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl6879);
            	    rule__GroupingMessages__InstructionsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3373:1: rule__GroupingMessages__Group__4 : rule__GroupingMessages__Group__4__Impl ;
    public final void rule__GroupingMessages__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3377:1: ( rule__GroupingMessages__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3378:2: rule__GroupingMessages__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__46910);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3384:1: rule__GroupingMessages__Group__4__Impl : ( End ) ;
    public final void rule__GroupingMessages__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3388:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3389:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3389:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3390:1: End
            {
             before(grammarAccess.getGroupingMessagesAccess().getEndKeyword_4()); 
            match(input,End,FOLLOW_End_in_rule__GroupingMessages__Group__4__Impl6938); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3413:1: rule__Note__Group__0 : rule__Note__Group__0__Impl rule__Note__Group__1 ;
    public final void rule__Note__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3417:1: ( rule__Note__Group__0__Impl rule__Note__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3418:2: rule__Note__Group__0__Impl rule__Note__Group__1
            {
            pushFollow(FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__06979);
            rule__Note__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__1_in_rule__Note__Group__06982);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3425:1: rule__Note__Group__0__Impl : ( Note ) ;
    public final void rule__Note__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3429:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3430:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3430:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3431:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_0()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group__0__Impl7010); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3444:1: rule__Note__Group__1 : rule__Note__Group__1__Impl rule__Note__Group__2 ;
    public final void rule__Note__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3448:1: ( rule__Note__Group__1__Impl rule__Note__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3449:2: rule__Note__Group__1__Impl rule__Note__Group__2
            {
            pushFollow(FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__17041);
            rule__Note__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__2_in_rule__Note__Group__17044);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3456:1: rule__Note__Group__1__Impl : ( ( rule__Note__Alternatives_1 ) ) ;
    public final void rule__Note__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3460:1: ( ( ( rule__Note__Alternatives_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3461:1: ( ( rule__Note__Alternatives_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3461:1: ( ( rule__Note__Alternatives_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3462:1: ( rule__Note__Alternatives_1 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3463:1: ( rule__Note__Alternatives_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3463:2: rule__Note__Alternatives_1
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl7071);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3473:1: rule__Note__Group__2 : rule__Note__Group__2__Impl rule__Note__Group__3 ;
    public final void rule__Note__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3477:1: ( rule__Note__Group__2__Impl rule__Note__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3478:2: rule__Note__Group__2__Impl rule__Note__Group__3
            {
            pushFollow(FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__27101);
            rule__Note__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group__3_in_rule__Note__Group__27104);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3485:1: rule__Note__Group__2__Impl : ( ( RULE_COLOR )* ) ;
    public final void rule__Note__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3489:1: ( ( ( RULE_COLOR )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3490:1: ( ( RULE_COLOR )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3490:1: ( ( RULE_COLOR )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3491:1: ( RULE_COLOR )*
            {
             before(grammarAccess.getNoteAccess().getCOLORTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3492:1: ( RULE_COLOR )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_COLOR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3492:3: RULE_COLOR
            	    {
            	    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Note__Group__2__Impl7132); 

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3502:1: rule__Note__Group__3 : rule__Note__Group__3__Impl ;
    public final void rule__Note__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3506:1: ( rule__Note__Group__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3507:2: rule__Note__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__37163);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3513:1: rule__Note__Group__3__Impl : ( ( rule__Note__Alternatives_3 ) ) ;
    public final void rule__Note__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3517:1: ( ( ( rule__Note__Alternatives_3 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3518:1: ( ( rule__Note__Alternatives_3 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3518:1: ( ( rule__Note__Alternatives_3 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3519:1: ( rule__Note__Alternatives_3 )
            {
             before(grammarAccess.getNoteAccess().getAlternatives_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3520:1: ( rule__Note__Alternatives_3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3520:2: rule__Note__Alternatives_3
            {
            pushFollow(FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl7190);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3538:1: rule__Note__Group_1_0__0 : rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 ;
    public final void rule__Note__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3542:1: ( rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3543:2: rule__Note__Group_1_0__0__Impl rule__Note__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__07228);
            rule__Note__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__07231);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3550:1: rule__Note__Group_1_0__0__Impl : ( Right ) ;
    public final void rule__Note__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3554:1: ( ( Right ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3555:1: ( Right )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3555:1: ( Right )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3556:1: Right
            {
             before(grammarAccess.getNoteAccess().getRightKeyword_1_0_0()); 
            match(input,Right,FOLLOW_Right_in_rule__Note__Group_1_0__0__Impl7259); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3569:1: rule__Note__Group_1_0__1 : rule__Note__Group_1_0__1__Impl ;
    public final void rule__Note__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3573:1: ( rule__Note__Group_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3574:2: rule__Note__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__17290);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3580:1: rule__Note__Group_1_0__1__Impl : ( ( rule__Note__Group_1_0_1__0 )? ) ;
    public final void rule__Note__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3584:1: ( ( ( rule__Note__Group_1_0_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3585:1: ( ( rule__Note__Group_1_0_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3585:1: ( ( rule__Note__Group_1_0_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3586:1: ( rule__Note__Group_1_0_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3587:1: ( rule__Note__Group_1_0_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Of) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3587:2: rule__Note__Group_1_0_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl7317);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3601:1: rule__Note__Group_1_0_1__0 : rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 ;
    public final void rule__Note__Group_1_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3605:1: ( rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3606:2: rule__Note__Group_1_0_1__0__Impl rule__Note__Group_1_0_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__07352);
            rule__Note__Group_1_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__07355);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3613:1: rule__Note__Group_1_0_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_1_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3617:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3618:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3618:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3619:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_0_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_1_0_1__0__Impl7383); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3632:1: rule__Note__Group_1_0_1__1 : rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 ;
    public final void rule__Note__Group_1_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3636:1: ( rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3637:2: rule__Note__Group_1_0_1__1__Impl rule__Note__Group_1_0_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__17414);
            rule__Note__Group_1_0_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__17417);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3644:1: rule__Note__Group_1_0_1__1__Impl : ( ( rule__Note__RidAssignment_1_0_1_1 ) ) ;
    public final void rule__Note__Group_1_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3648:1: ( ( ( rule__Note__RidAssignment_1_0_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3649:1: ( ( rule__Note__RidAssignment_1_0_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3649:1: ( ( rule__Note__RidAssignment_1_0_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3650:1: ( rule__Note__RidAssignment_1_0_1_1 )
            {
             before(grammarAccess.getNoteAccess().getRidAssignment_1_0_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3651:1: ( rule__Note__RidAssignment_1_0_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3651:2: rule__Note__RidAssignment_1_0_1_1
            {
            pushFollow(FOLLOW_rule__Note__RidAssignment_1_0_1_1_in_rule__Note__Group_1_0_1__1__Impl7444);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3661:1: rule__Note__Group_1_0_1__2 : rule__Note__Group_1_0_1__2__Impl ;
    public final void rule__Note__Group_1_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3665:1: ( rule__Note__Group_1_0_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3666:2: rule__Note__Group_1_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__27474);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3672:1: rule__Note__Group_1_0_1__2__Impl : ( ( rule__Note__Group_1_0_1_2__0 )* ) ;
    public final void rule__Note__Group_1_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3676:1: ( ( ( rule__Note__Group_1_0_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3677:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3677:1: ( ( rule__Note__Group_1_0_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3678:1: ( rule__Note__Group_1_0_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_0_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3679:1: ( rule__Note__Group_1_0_1_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Comma) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3679:2: rule__Note__Group_1_0_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl7501);
            	    rule__Note__Group_1_0_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3695:1: rule__Note__Group_1_0_1_2__0 : rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 ;
    public final void rule__Note__Group_1_0_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3699:1: ( rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3700:2: rule__Note__Group_1_0_1_2__0__Impl rule__Note__Group_1_0_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__07538);
            rule__Note__Group_1_0_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__07541);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3707:1: rule__Note__Group_1_0_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_0_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3711:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3712:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3712:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3713:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_0_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_0_1_2__0__Impl7569); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3726:1: rule__Note__Group_1_0_1_2__1 : rule__Note__Group_1_0_1_2__1__Impl ;
    public final void rule__Note__Group_1_0_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3730:1: ( rule__Note__Group_1_0_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3731:2: rule__Note__Group_1_0_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__17600);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3737:1: rule__Note__Group_1_0_1_2__1__Impl : ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) ) ;
    public final void rule__Note__Group_1_0_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3741:1: ( ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3742:1: ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3742:1: ( ( rule__Note__RidsAssignment_1_0_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3743:1: ( rule__Note__RidsAssignment_1_0_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getRidsAssignment_1_0_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3744:1: ( rule__Note__RidsAssignment_1_0_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3744:2: rule__Note__RidsAssignment_1_0_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__RidsAssignment_1_0_1_2_1_in_rule__Note__Group_1_0_1_2__1__Impl7627);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3758:1: rule__Note__Group_1_1__0 : rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 ;
    public final void rule__Note__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3762:1: ( rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3763:2: rule__Note__Group_1_1__0__Impl rule__Note__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__07661);
            rule__Note__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__07664);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3770:1: rule__Note__Group_1_1__0__Impl : ( Left ) ;
    public final void rule__Note__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3774:1: ( ( Left ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3775:1: ( Left )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3775:1: ( Left )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3776:1: Left
            {
             before(grammarAccess.getNoteAccess().getLeftKeyword_1_1_0()); 
            match(input,Left,FOLLOW_Left_in_rule__Note__Group_1_1__0__Impl7692); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3789:1: rule__Note__Group_1_1__1 : rule__Note__Group_1_1__1__Impl ;
    public final void rule__Note__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3793:1: ( rule__Note__Group_1_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3794:2: rule__Note__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__17723);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3800:1: rule__Note__Group_1_1__1__Impl : ( ( rule__Note__Group_1_1_1__0 )? ) ;
    public final void rule__Note__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3804:1: ( ( ( rule__Note__Group_1_1_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3805:1: ( ( rule__Note__Group_1_1_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3805:1: ( ( rule__Note__Group_1_1_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3806:1: ( rule__Note__Group_1_1_1__0 )?
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3807:1: ( rule__Note__Group_1_1_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Of) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3807:2: rule__Note__Group_1_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl7750);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3821:1: rule__Note__Group_1_1_1__0 : rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 ;
    public final void rule__Note__Group_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3825:1: ( rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3826:2: rule__Note__Group_1_1_1__0__Impl rule__Note__Group_1_1_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__07785);
            rule__Note__Group_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__07788);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3833:1: rule__Note__Group_1_1_1__0__Impl : ( Of ) ;
    public final void rule__Note__Group_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3837:1: ( ( Of ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3838:1: ( Of )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3838:1: ( Of )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3839:1: Of
            {
             before(grammarAccess.getNoteAccess().getOfKeyword_1_1_1_0()); 
            match(input,Of,FOLLOW_Of_in_rule__Note__Group_1_1_1__0__Impl7816); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3852:1: rule__Note__Group_1_1_1__1 : rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 ;
    public final void rule__Note__Group_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3856:1: ( rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3857:2: rule__Note__Group_1_1_1__1__Impl rule__Note__Group_1_1_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__17847);
            rule__Note__Group_1_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__17850);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3864:1: rule__Note__Group_1_1_1__1__Impl : ( ( rule__Note__LidAssignment_1_1_1_1 ) ) ;
    public final void rule__Note__Group_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3868:1: ( ( ( rule__Note__LidAssignment_1_1_1_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3869:1: ( ( rule__Note__LidAssignment_1_1_1_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3869:1: ( ( rule__Note__LidAssignment_1_1_1_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3870:1: ( rule__Note__LidAssignment_1_1_1_1 )
            {
             before(grammarAccess.getNoteAccess().getLidAssignment_1_1_1_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3871:1: ( rule__Note__LidAssignment_1_1_1_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3871:2: rule__Note__LidAssignment_1_1_1_1
            {
            pushFollow(FOLLOW_rule__Note__LidAssignment_1_1_1_1_in_rule__Note__Group_1_1_1__1__Impl7877);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3881:1: rule__Note__Group_1_1_1__2 : rule__Note__Group_1_1_1__2__Impl ;
    public final void rule__Note__Group_1_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3885:1: ( rule__Note__Group_1_1_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3886:2: rule__Note__Group_1_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__27907);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3892:1: rule__Note__Group_1_1_1__2__Impl : ( ( rule__Note__Group_1_1_1_2__0 )* ) ;
    public final void rule__Note__Group_1_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3896:1: ( ( ( rule__Note__Group_1_1_1_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3897:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3897:1: ( ( rule__Note__Group_1_1_1_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3898:1: ( rule__Note__Group_1_1_1_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_1_1_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3899:1: ( rule__Note__Group_1_1_1_2__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==Comma) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3899:2: rule__Note__Group_1_1_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl7934);
            	    rule__Note__Group_1_1_1_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3915:1: rule__Note__Group_1_1_1_2__0 : rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 ;
    public final void rule__Note__Group_1_1_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3919:1: ( rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3920:2: rule__Note__Group_1_1_1_2__0__Impl rule__Note__Group_1_1_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__07971);
            rule__Note__Group_1_1_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__07974);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3927:1: rule__Note__Group_1_1_1_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_1_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3931:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3932:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3932:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3933:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_1_1_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_1_1_2__0__Impl8002); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3946:1: rule__Note__Group_1_1_1_2__1 : rule__Note__Group_1_1_1_2__1__Impl ;
    public final void rule__Note__Group_1_1_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3950:1: ( rule__Note__Group_1_1_1_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3951:2: rule__Note__Group_1_1_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__18033);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3957:1: rule__Note__Group_1_1_1_2__1__Impl : ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) ) ;
    public final void rule__Note__Group_1_1_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3961:1: ( ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3962:1: ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3962:1: ( ( rule__Note__LidsAssignment_1_1_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3963:1: ( rule__Note__LidsAssignment_1_1_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getLidsAssignment_1_1_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3964:1: ( rule__Note__LidsAssignment_1_1_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3964:2: rule__Note__LidsAssignment_1_1_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__LidsAssignment_1_1_1_2_1_in_rule__Note__Group_1_1_1_2__1__Impl8060);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3978:1: rule__Note__Group_1_2__0 : rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 ;
    public final void rule__Note__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3982:1: ( rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3983:2: rule__Note__Group_1_2__0__Impl rule__Note__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__08094);
            rule__Note__Group_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__08097);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3990:1: rule__Note__Group_1_2__0__Impl : ( Over ) ;
    public final void rule__Note__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3994:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3995:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3995:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:3996:1: Over
            {
             before(grammarAccess.getNoteAccess().getOverKeyword_1_2_0()); 
            match(input,Over,FOLLOW_Over_in_rule__Note__Group_1_2__0__Impl8125); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4009:1: rule__Note__Group_1_2__1 : rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 ;
    public final void rule__Note__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4013:1: ( rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4014:2: rule__Note__Group_1_2__1__Impl rule__Note__Group_1_2__2
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__18156);
            rule__Note__Group_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__18159);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4021:1: rule__Note__Group_1_2__1__Impl : ( ( rule__Note__OidAssignment_1_2_1 ) ) ;
    public final void rule__Note__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4025:1: ( ( ( rule__Note__OidAssignment_1_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4026:1: ( ( rule__Note__OidAssignment_1_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4026:1: ( ( rule__Note__OidAssignment_1_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4027:1: ( rule__Note__OidAssignment_1_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidAssignment_1_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4028:1: ( rule__Note__OidAssignment_1_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4028:2: rule__Note__OidAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidAssignment_1_2_1_in_rule__Note__Group_1_2__1__Impl8186);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4038:1: rule__Note__Group_1_2__2 : rule__Note__Group_1_2__2__Impl ;
    public final void rule__Note__Group_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4042:1: ( rule__Note__Group_1_2__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4043:2: rule__Note__Group_1_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__28216);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4049:1: rule__Note__Group_1_2__2__Impl : ( ( rule__Note__Group_1_2_2__0 )* ) ;
    public final void rule__Note__Group_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4053:1: ( ( ( rule__Note__Group_1_2_2__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4054:1: ( ( rule__Note__Group_1_2_2__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4054:1: ( ( rule__Note__Group_1_2_2__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4055:1: ( rule__Note__Group_1_2_2__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_1_2_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4056:1: ( rule__Note__Group_1_2_2__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==Comma) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4056:2: rule__Note__Group_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl8243);
            	    rule__Note__Group_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4072:1: rule__Note__Group_1_2_2__0 : rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 ;
    public final void rule__Note__Group_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4076:1: ( rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4077:2: rule__Note__Group_1_2_2__0__Impl rule__Note__Group_1_2_2__1
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__08280);
            rule__Note__Group_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__08283);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4084:1: rule__Note__Group_1_2_2__0__Impl : ( Comma ) ;
    public final void rule__Note__Group_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4088:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4089:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4089:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4090:1: Comma
            {
             before(grammarAccess.getNoteAccess().getCommaKeyword_1_2_2_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Note__Group_1_2_2__0__Impl8311); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4103:1: rule__Note__Group_1_2_2__1 : rule__Note__Group_1_2_2__1__Impl ;
    public final void rule__Note__Group_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4107:1: ( rule__Note__Group_1_2_2__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4108:2: rule__Note__Group_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__18342);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4114:1: rule__Note__Group_1_2_2__1__Impl : ( ( rule__Note__OidsAssignment_1_2_2_1 ) ) ;
    public final void rule__Note__Group_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4118:1: ( ( ( rule__Note__OidsAssignment_1_2_2_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4119:1: ( ( rule__Note__OidsAssignment_1_2_2_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4119:1: ( ( rule__Note__OidsAssignment_1_2_2_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4120:1: ( rule__Note__OidsAssignment_1_2_2_1 )
            {
             before(grammarAccess.getNoteAccess().getOidsAssignment_1_2_2_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4121:1: ( rule__Note__OidsAssignment_1_2_2_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4121:2: rule__Note__OidsAssignment_1_2_2_1
            {
            pushFollow(FOLLOW_rule__Note__OidsAssignment_1_2_2_1_in_rule__Note__Group_1_2_2__1__Impl8369);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4135:1: rule__Note__Group_3_0__0 : rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 ;
    public final void rule__Note__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4139:1: ( rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4140:2: rule__Note__Group_3_0__0__Impl rule__Note__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__08403);
            rule__Note__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__08406);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4147:1: rule__Note__Group_3_0__0__Impl : ( Colon ) ;
    public final void rule__Note__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4151:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4152:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4152:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4153:1: Colon
            {
             before(grammarAccess.getNoteAccess().getColonKeyword_3_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Note__Group_3_0__0__Impl8434); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4166:1: rule__Note__Group_3_0__1 : rule__Note__Group_3_0__1__Impl ;
    public final void rule__Note__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4170:1: ( rule__Note__Group_3_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4171:2: rule__Note__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__18465);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4177:1: rule__Note__Group_3_0__1__Impl : ( RULE_ID ) ;
    public final void rule__Note__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4181:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4182:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4182:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4183:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_3_0__1__Impl8492); 
             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_0_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4198:1: rule__Note__Group_3_1__0 : rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 ;
    public final void rule__Note__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4202:1: ( rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4203:2: rule__Note__Group_3_1__0__Impl rule__Note__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__08525);
            rule__Note__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__08528);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4210:1: rule__Note__Group_3_1__0__Impl : ( ( rule__Note__Group_3_1_0__0 )* ) ;
    public final void rule__Note__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4214:1: ( ( ( rule__Note__Group_3_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4215:1: ( ( rule__Note__Group_3_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4215:1: ( ( rule__Note__Group_3_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4216:1: ( rule__Note__Group_3_1_0__0 )*
            {
             before(grammarAccess.getNoteAccess().getGroup_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4217:1: ( rule__Note__Group_3_1_0__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_NEWLINE) ) {
                    int LA40_1 = input.LA(2);

                    if ( (LA40_1==RULE_NEWLINE||LA40_1==RULE_ID) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4217:2: rule__Note__Group_3_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl8555);
            	    rule__Note__Group_3_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4227:1: rule__Note__Group_3_1__1 : rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 ;
    public final void rule__Note__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4231:1: ( rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4232:2: rule__Note__Group_3_1__1__Impl rule__Note__Group_3_1__2
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__18586);
            rule__Note__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__18589);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4239:1: rule__Note__Group_3_1__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4243:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4244:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4244:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4245:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1__1__Impl8616); 
             after(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4256:1: rule__Note__Group_3_1__2 : rule__Note__Group_3_1__2__Impl rule__Note__Group_3_1__3 ;
    public final void rule__Note__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4260:1: ( rule__Note__Group_3_1__2__Impl rule__Note__Group_3_1__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4261:2: rule__Note__Group_3_1__2__Impl rule__Note__Group_3_1__3
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__28645);
            rule__Note__Group_3_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1__3_in_rule__Note__Group_3_1__28648);
            rule__Note__Group_3_1__3();

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4268:1: rule__Note__Group_3_1__2__Impl : ( End ) ;
    public final void rule__Note__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4272:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4273:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4273:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4274:1: End
            {
             before(grammarAccess.getNoteAccess().getEndKeyword_3_1_2()); 
            match(input,End,FOLLOW_End_in_rule__Note__Group_3_1__2__Impl8676); 
             after(grammarAccess.getNoteAccess().getEndKeyword_3_1_2()); 

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


    // $ANTLR start "rule__Note__Group_3_1__3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4287:1: rule__Note__Group_3_1__3 : rule__Note__Group_3_1__3__Impl ;
    public final void rule__Note__Group_3_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4291:1: ( rule__Note__Group_3_1__3__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4292:2: rule__Note__Group_3_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1__3__Impl_in_rule__Note__Group_3_1__38707);
            rule__Note__Group_3_1__3__Impl();

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
    // $ANTLR end "rule__Note__Group_3_1__3"


    // $ANTLR start "rule__Note__Group_3_1__3__Impl"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4298:1: rule__Note__Group_3_1__3__Impl : ( Note ) ;
    public final void rule__Note__Group_3_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4302:1: ( ( Note ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4303:1: ( Note )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4303:1: ( Note )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4304:1: Note
            {
             before(grammarAccess.getNoteAccess().getNoteKeyword_3_1_3()); 
            match(input,Note,FOLLOW_Note_in_rule__Note__Group_3_1__3__Impl8735); 
             after(grammarAccess.getNoteAccess().getNoteKeyword_3_1_3()); 

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
    // $ANTLR end "rule__Note__Group_3_1__3__Impl"


    // $ANTLR start "rule__Note__Group_3_1_0__0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4325:1: rule__Note__Group_3_1_0__0 : rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 ;
    public final void rule__Note__Group_3_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4329:1: ( rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4330:2: rule__Note__Group_3_1_0__0__Impl rule__Note__Group_3_1_0__1
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__08774);
            rule__Note__Group_3_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__08777);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4337:1: rule__Note__Group_3_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Note__Group_3_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4341:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4342:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4342:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4343:1: RULE_NEWLINE
            {
             before(grammarAccess.getNoteAccess().getNEWLINETerminalRuleCall_3_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl8804); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4354:1: rule__Note__Group_3_1_0__1 : rule__Note__Group_3_1_0__1__Impl ;
    public final void rule__Note__Group_3_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4358:1: ( rule__Note__Group_3_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4359:2: rule__Note__Group_3_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__18833);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4365:1: rule__Note__Group_3_1_0__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Note__Group_3_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4369:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4370:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4370:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4371:1: ( RULE_ID )*
            {
             before(grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4372:1: ( RULE_ID )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4372:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__Group_3_1_0__1__Impl8861); 

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getNoteAccess().getIDTerminalRuleCall_3_1_0_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4386:1: rule__Divider__Group__0 : rule__Divider__Group__0__Impl rule__Divider__Group__1 ;
    public final void rule__Divider__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4390:1: ( rule__Divider__Group__0__Impl rule__Divider__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4391:2: rule__Divider__Group__0__Impl rule__Divider__Group__1
            {
            pushFollow(FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__08896);
            rule__Divider__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__08899);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4398:1: rule__Divider__Group__0__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4402:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4403:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4403:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4404:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_0()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl8927); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4417:1: rule__Divider__Group__1 : rule__Divider__Group__1__Impl rule__Divider__Group__2 ;
    public final void rule__Divider__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4421:1: ( rule__Divider__Group__1__Impl rule__Divider__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4422:2: rule__Divider__Group__1__Impl rule__Divider__Group__2
            {
            pushFollow(FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__18958);
            rule__Divider__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__18961);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4429:1: rule__Divider__Group__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Divider__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4433:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4434:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4434:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4435:1: ( RULE_ID )*
            {
             before(grammarAccess.getDividerAccess().getIDTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4436:1: ( RULE_ID )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4436:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl8989); 

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4446:1: rule__Divider__Group__2 : rule__Divider__Group__2__Impl ;
    public final void rule__Divider__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4450:1: ( rule__Divider__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4451:2: rule__Divider__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__29020);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4457:1: rule__Divider__Group__2__Impl : ( EqualsSignEqualsSign ) ;
    public final void rule__Divider__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4461:1: ( ( EqualsSignEqualsSign ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4462:1: ( EqualsSignEqualsSign )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4462:1: ( EqualsSignEqualsSign )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4463:1: EqualsSignEqualsSign
            {
             before(grammarAccess.getDividerAccess().getEqualsSignEqualsSignKeyword_2()); 
            match(input,EqualsSignEqualsSign,FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl9048); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4482:1: rule__Reference__Group__0 : rule__Reference__Group__0__Impl rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4486:1: ( rule__Reference__Group__0__Impl rule__Reference__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4487:2: rule__Reference__Group__0__Impl rule__Reference__Group__1
            {
            pushFollow(FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__09085);
            rule__Reference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__09088);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4494:1: rule__Reference__Group__0__Impl : ( Ref ) ;
    public final void rule__Reference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4498:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4499:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4499:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4500:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_0()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group__0__Impl9116); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4513:1: rule__Reference__Group__1 : rule__Reference__Group__1__Impl rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4517:1: ( rule__Reference__Group__1__Impl rule__Reference__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4518:2: rule__Reference__Group__1__Impl rule__Reference__Group__2
            {
            pushFollow(FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__19147);
            rule__Reference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__19150);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4525:1: rule__Reference__Group__1__Impl : ( Over ) ;
    public final void rule__Reference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4529:1: ( ( Over ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4530:1: ( Over )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4530:1: ( Over )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4531:1: Over
            {
             before(grammarAccess.getReferenceAccess().getOverKeyword_1()); 
            match(input,Over,FOLLOW_Over_in_rule__Reference__Group__1__Impl9178); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4544:1: rule__Reference__Group__2 : rule__Reference__Group__2__Impl rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4548:1: ( rule__Reference__Group__2__Impl rule__Reference__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4549:2: rule__Reference__Group__2__Impl rule__Reference__Group__3
            {
            pushFollow(FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__29209);
            rule__Reference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__29212);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4556:1: rule__Reference__Group__2__Impl : ( ( rule__Reference__IdAssignment_2 ) ) ;
    public final void rule__Reference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4560:1: ( ( ( rule__Reference__IdAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4561:1: ( ( rule__Reference__IdAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4561:1: ( ( rule__Reference__IdAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4562:1: ( rule__Reference__IdAssignment_2 )
            {
             before(grammarAccess.getReferenceAccess().getIdAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4563:1: ( rule__Reference__IdAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4563:2: rule__Reference__IdAssignment_2
            {
            pushFollow(FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl9239);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4573:1: rule__Reference__Group__3 : rule__Reference__Group__3__Impl rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4577:1: ( rule__Reference__Group__3__Impl rule__Reference__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4578:2: rule__Reference__Group__3__Impl rule__Reference__Group__4
            {
            pushFollow(FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__39269);
            rule__Reference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__39272);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4585:1: rule__Reference__Group__3__Impl : ( ( rule__Reference__Group_3__0 )* ) ;
    public final void rule__Reference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4589:1: ( ( ( rule__Reference__Group_3__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4590:1: ( ( rule__Reference__Group_3__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4590:1: ( ( rule__Reference__Group_3__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4591:1: ( rule__Reference__Group_3__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_3()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4592:1: ( rule__Reference__Group_3__0 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==Comma) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4592:2: rule__Reference__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl9299);
            	    rule__Reference__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4602:1: rule__Reference__Group__4 : rule__Reference__Group__4__Impl ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4606:1: ( rule__Reference__Group__4__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4607:2: rule__Reference__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__49330);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4613:1: rule__Reference__Group__4__Impl : ( ( rule__Reference__Alternatives_4 ) ) ;
    public final void rule__Reference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4617:1: ( ( ( rule__Reference__Alternatives_4 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4618:1: ( ( rule__Reference__Alternatives_4 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4618:1: ( ( rule__Reference__Alternatives_4 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4619:1: ( rule__Reference__Alternatives_4 )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4620:1: ( rule__Reference__Alternatives_4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4620:2: rule__Reference__Alternatives_4
            {
            pushFollow(FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl9357);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4640:1: rule__Reference__Group_3__0 : rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 ;
    public final void rule__Reference__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4644:1: ( rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4645:2: rule__Reference__Group_3__0__Impl rule__Reference__Group_3__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__09397);
            rule__Reference__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__09400);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4652:1: rule__Reference__Group_3__0__Impl : ( Comma ) ;
    public final void rule__Reference__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4656:1: ( ( Comma ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4657:1: ( Comma )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4657:1: ( Comma )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4658:1: Comma
            {
             before(grammarAccess.getReferenceAccess().getCommaKeyword_3_0()); 
            match(input,Comma,FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl9428); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4671:1: rule__Reference__Group_3__1 : rule__Reference__Group_3__1__Impl ;
    public final void rule__Reference__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4675:1: ( rule__Reference__Group_3__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4676:2: rule__Reference__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__19459);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4682:1: rule__Reference__Group_3__1__Impl : ( ( rule__Reference__IdsAssignment_3_1 ) ) ;
    public final void rule__Reference__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4686:1: ( ( ( rule__Reference__IdsAssignment_3_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4687:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4687:1: ( ( rule__Reference__IdsAssignment_3_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4688:1: ( rule__Reference__IdsAssignment_3_1 )
            {
             before(grammarAccess.getReferenceAccess().getIdsAssignment_3_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4689:1: ( rule__Reference__IdsAssignment_3_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4689:2: rule__Reference__IdsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl9486);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4703:1: rule__Reference__Group_4_0__0 : rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 ;
    public final void rule__Reference__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4707:1: ( rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4708:2: rule__Reference__Group_4_0__0__Impl rule__Reference__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__09520);
            rule__Reference__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__09523);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4715:1: rule__Reference__Group_4_0__0__Impl : ( Colon ) ;
    public final void rule__Reference__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4719:1: ( ( Colon ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4720:1: ( Colon )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4720:1: ( Colon )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4721:1: Colon
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_4_0_0()); 
            match(input,Colon,FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl9551); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4734:1: rule__Reference__Group_4_0__1 : rule__Reference__Group_4_0__1__Impl ;
    public final void rule__Reference__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4738:1: ( rule__Reference__Group_4_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4739:2: rule__Reference__Group_4_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__19582);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4745:1: rule__Reference__Group_4_0__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Reference__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4749:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4750:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4750:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4751:1: ( RULE_ID )*
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4752:1: ( RULE_ID )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_ID) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4752:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_4_0__1__Impl9610); 

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_0_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4766:1: rule__Reference__Group_4_1__0 : rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 ;
    public final void rule__Reference__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4770:1: ( rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4771:2: rule__Reference__Group_4_1__0__Impl rule__Reference__Group_4_1__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__09645);
            rule__Reference__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__09648);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4778:1: rule__Reference__Group_4_1__0__Impl : ( ( rule__Reference__Group_4_1_0__0 )* ) ;
    public final void rule__Reference__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4782:1: ( ( ( rule__Reference__Group_4_1_0__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4783:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4783:1: ( ( rule__Reference__Group_4_1_0__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4784:1: ( rule__Reference__Group_4_1_0__0 )*
            {
             before(grammarAccess.getReferenceAccess().getGroup_4_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4785:1: ( rule__Reference__Group_4_1_0__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_NEWLINE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4785:2: rule__Reference__Group_4_1_0__0
            	    {
            	    pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl9675);
            	    rule__Reference__Group_4_1_0__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4795:1: rule__Reference__Group_4_1__1 : rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 ;
    public final void rule__Reference__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4799:1: ( rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4800:2: rule__Reference__Group_4_1__1__Impl rule__Reference__Group_4_1__2
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__19706);
            rule__Reference__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__19709);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4807:1: rule__Reference__Group_4_1__1__Impl : ( End ) ;
    public final void rule__Reference__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4811:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4812:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4812:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4813:1: End
            {
             before(grammarAccess.getReferenceAccess().getEndKeyword_4_1_1()); 
            match(input,End,FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl9737); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4826:1: rule__Reference__Group_4_1__2 : rule__Reference__Group_4_1__2__Impl ;
    public final void rule__Reference__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4830:1: ( rule__Reference__Group_4_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4831:2: rule__Reference__Group_4_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__29768);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4837:1: rule__Reference__Group_4_1__2__Impl : ( Ref ) ;
    public final void rule__Reference__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4841:1: ( ( Ref ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4842:1: ( Ref )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4842:1: ( Ref )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4843:1: Ref
            {
             before(grammarAccess.getReferenceAccess().getRefKeyword_4_1_2()); 
            match(input,Ref,FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl9796); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4862:1: rule__Reference__Group_4_1_0__0 : rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 ;
    public final void rule__Reference__Group_4_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4866:1: ( rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4867:2: rule__Reference__Group_4_1_0__0__Impl rule__Reference__Group_4_1_0__1
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__09833);
            rule__Reference__Group_4_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__09836);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4874:1: rule__Reference__Group_4_1_0__0__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Reference__Group_4_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4878:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4879:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4879:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4880:1: RULE_NEWLINE
            {
             before(grammarAccess.getReferenceAccess().getNEWLINETerminalRuleCall_4_1_0_0()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl9863); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4891:1: rule__Reference__Group_4_1_0__1 : rule__Reference__Group_4_1_0__1__Impl ;
    public final void rule__Reference__Group_4_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4895:1: ( rule__Reference__Group_4_1_0__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4896:2: rule__Reference__Group_4_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__19892);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4902:1: rule__Reference__Group_4_1_0__1__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Reference__Group_4_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4906:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4907:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4907:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4908:1: ( RULE_ID )*
            {
             before(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_1_0_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4909:1: ( RULE_ID )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4909:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__Group_4_1_0__1__Impl9920); 

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getReferenceAccess().getIDTerminalRuleCall_4_1_0_1()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4923:1: rule__Delay__Group__0 : rule__Delay__Group__0__Impl rule__Delay__Group__1 ;
    public final void rule__Delay__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4927:1: ( rule__Delay__Group__0__Impl rule__Delay__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4928:2: rule__Delay__Group__0__Impl rule__Delay__Group__1
            {
            pushFollow(FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__09955);
            rule__Delay__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__09958);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4935:1: rule__Delay__Group__0__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4939:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4940:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4940:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4941:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_0()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl9986); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4954:1: rule__Delay__Group__1 : rule__Delay__Group__1__Impl ;
    public final void rule__Delay__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4958:1: ( rule__Delay__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4959:2: rule__Delay__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__110017);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4965:1: rule__Delay__Group__1__Impl : ( ( rule__Delay__Group_1__0 )? ) ;
    public final void rule__Delay__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4969:1: ( ( ( rule__Delay__Group_1__0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4970:1: ( ( rule__Delay__Group_1__0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4970:1: ( ( rule__Delay__Group_1__0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4971:1: ( rule__Delay__Group_1__0 )?
            {
             before(grammarAccess.getDelayAccess().getGroup_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4972:1: ( rule__Delay__Group_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FullStopFullStopFullStop||LA47_0==RULE_ID) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4972:2: rule__Delay__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl10044);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4986:1: rule__Delay__Group_1__0 : rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 ;
    public final void rule__Delay__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4990:1: ( rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4991:2: rule__Delay__Group_1__0__Impl rule__Delay__Group_1__1
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__010079);
            rule__Delay__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__010082);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:4998:1: rule__Delay__Group_1__0__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Delay__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5002:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5003:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5003:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5004:1: ( RULE_ID )*
            {
             before(grammarAccess.getDelayAccess().getIDTerminalRuleCall_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5005:1: ( RULE_ID )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5005:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl10110); 

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5015:1: rule__Delay__Group_1__1 : rule__Delay__Group_1__1__Impl ;
    public final void rule__Delay__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5019:1: ( rule__Delay__Group_1__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5020:2: rule__Delay__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__110141);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5026:1: rule__Delay__Group_1__1__Impl : ( FullStopFullStopFullStop ) ;
    public final void rule__Delay__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5030:1: ( ( FullStopFullStopFullStop ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5031:1: ( FullStopFullStopFullStop )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5031:1: ( FullStopFullStopFullStop )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5032:1: FullStopFullStopFullStop
            {
             before(grammarAccess.getDelayAccess().getFullStopFullStopFullStopKeyword_1_1()); 
            match(input,FullStopFullStopFullStop,FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl10169); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5049:1: rule__Space__Group_1__0 : rule__Space__Group_1__0__Impl rule__Space__Group_1__1 ;
    public final void rule__Space__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5053:1: ( rule__Space__Group_1__0__Impl rule__Space__Group_1__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5054:2: rule__Space__Group_1__0__Impl rule__Space__Group_1__1
            {
            pushFollow(FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__010204);
            rule__Space__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__010207);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5061:1: rule__Space__Group_1__0__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5065:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5066:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5066:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5067:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_0()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl10235); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5080:1: rule__Space__Group_1__1 : rule__Space__Group_1__1__Impl rule__Space__Group_1__2 ;
    public final void rule__Space__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5084:1: ( rule__Space__Group_1__1__Impl rule__Space__Group_1__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5085:2: rule__Space__Group_1__1__Impl rule__Space__Group_1__2
            {
            pushFollow(FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__110266);
            rule__Space__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__110269);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5092:1: rule__Space__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__Space__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5096:1: ( ( RULE_INT ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5097:1: ( RULE_INT )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5097:1: ( RULE_INT )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5098:1: RULE_INT
            {
             before(grammarAccess.getSpaceAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl10296); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5109:1: rule__Space__Group_1__2 : rule__Space__Group_1__2__Impl ;
    public final void rule__Space__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5113:1: ( rule__Space__Group_1__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5114:2: rule__Space__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__210325);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5120:1: rule__Space__Group_1__2__Impl : ( VerticalLineVerticalLine ) ;
    public final void rule__Space__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5124:1: ( ( VerticalLineVerticalLine ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5125:1: ( VerticalLineVerticalLine )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5125:1: ( VerticalLineVerticalLine )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5126:1: VerticalLineVerticalLine
            {
             before(grammarAccess.getSpaceAccess().getVerticalLineVerticalLineKeyword_1_2()); 
            match(input,VerticalLineVerticalLine,FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl10353); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5145:1: rule__Hidefootbox__Group__0 : rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 ;
    public final void rule__Hidefootbox__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5149:1: ( rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5150:2: rule__Hidefootbox__Group__0__Impl rule__Hidefootbox__Group__1
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__010390);
            rule__Hidefootbox__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__010393);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5157:1: rule__Hidefootbox__Group__0__Impl : ( Hide ) ;
    public final void rule__Hidefootbox__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5161:1: ( ( Hide ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5162:1: ( Hide )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5162:1: ( Hide )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5163:1: Hide
            {
             before(grammarAccess.getHidefootboxAccess().getHideKeyword_0()); 
            match(input,Hide,FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl10421); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5176:1: rule__Hidefootbox__Group__1 : rule__Hidefootbox__Group__1__Impl ;
    public final void rule__Hidefootbox__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5180:1: ( rule__Hidefootbox__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5181:2: rule__Hidefootbox__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__110452);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5187:1: rule__Hidefootbox__Group__1__Impl : ( Footbox ) ;
    public final void rule__Hidefootbox__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5191:1: ( ( Footbox ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5192:1: ( Footbox )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5192:1: ( Footbox )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5193:1: Footbox
            {
             before(grammarAccess.getHidefootboxAccess().getFootboxKeyword_1()); 
            match(input,Footbox,FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl10480); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5210:1: rule__Activate__Group__0 : rule__Activate__Group__0__Impl rule__Activate__Group__1 ;
    public final void rule__Activate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5214:1: ( rule__Activate__Group__0__Impl rule__Activate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5215:2: rule__Activate__Group__0__Impl rule__Activate__Group__1
            {
            pushFollow(FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__010515);
            rule__Activate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__010518);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5222:1: rule__Activate__Group__0__Impl : ( Activate ) ;
    public final void rule__Activate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5226:1: ( ( Activate ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5227:1: ( Activate )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5227:1: ( Activate )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5228:1: Activate
            {
             before(grammarAccess.getActivateAccess().getActivateKeyword_0()); 
            match(input,Activate,FOLLOW_Activate_in_rule__Activate__Group__0__Impl10546); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5241:1: rule__Activate__Group__1 : rule__Activate__Group__1__Impl rule__Activate__Group__2 ;
    public final void rule__Activate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5245:1: ( rule__Activate__Group__1__Impl rule__Activate__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5246:2: rule__Activate__Group__1__Impl rule__Activate__Group__2
            {
            pushFollow(FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__110577);
            rule__Activate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__110580);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5253:1: rule__Activate__Group__1__Impl : ( ( RULE_COLOR )? ) ;
    public final void rule__Activate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5257:1: ( ( ( RULE_COLOR )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5258:1: ( ( RULE_COLOR )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5258:1: ( ( RULE_COLOR )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5259:1: ( RULE_COLOR )?
            {
             before(grammarAccess.getActivateAccess().getCOLORTerminalRuleCall_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5260:1: ( RULE_COLOR )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_COLOR) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5260:3: RULE_COLOR
                    {
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Activate__Group__1__Impl10608); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5270:1: rule__Activate__Group__2 : rule__Activate__Group__2__Impl ;
    public final void rule__Activate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5274:1: ( rule__Activate__Group__2__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5275:2: rule__Activate__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__210639);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5281:1: rule__Activate__Group__2__Impl : ( ( rule__Activate__NameAssignment_2 ) ) ;
    public final void rule__Activate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5285:1: ( ( ( rule__Activate__NameAssignment_2 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5286:1: ( ( rule__Activate__NameAssignment_2 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5286:1: ( ( rule__Activate__NameAssignment_2 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5287:1: ( rule__Activate__NameAssignment_2 )
            {
             before(grammarAccess.getActivateAccess().getNameAssignment_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5288:1: ( rule__Activate__NameAssignment_2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5288:2: rule__Activate__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl10666);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5304:1: rule__Deactivate__Group__0 : rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 ;
    public final void rule__Deactivate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5308:1: ( rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5309:2: rule__Deactivate__Group__0__Impl rule__Deactivate__Group__1
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__010702);
            rule__Deactivate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__010705);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5316:1: rule__Deactivate__Group__0__Impl : ( ( rule__Deactivate__Alternatives_0 ) ) ;
    public final void rule__Deactivate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5320:1: ( ( ( rule__Deactivate__Alternatives_0 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5321:1: ( ( rule__Deactivate__Alternatives_0 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5321:1: ( ( rule__Deactivate__Alternatives_0 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5322:1: ( rule__Deactivate__Alternatives_0 )
            {
             before(grammarAccess.getDeactivateAccess().getAlternatives_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5323:1: ( rule__Deactivate__Alternatives_0 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5323:2: rule__Deactivate__Alternatives_0
            {
            pushFollow(FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl10732);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5333:1: rule__Deactivate__Group__1 : rule__Deactivate__Group__1__Impl ;
    public final void rule__Deactivate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5337:1: ( rule__Deactivate__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5338:2: rule__Deactivate__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__110762);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5344:1: rule__Deactivate__Group__1__Impl : ( ( rule__Deactivate__IdAssignment_1 ) ) ;
    public final void rule__Deactivate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5348:1: ( ( ( rule__Deactivate__IdAssignment_1 ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5349:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5349:1: ( ( rule__Deactivate__IdAssignment_1 ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5350:1: ( rule__Deactivate__IdAssignment_1 )
            {
             before(grammarAccess.getDeactivateAccess().getIdAssignment_1()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5351:1: ( rule__Deactivate__IdAssignment_1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5351:2: rule__Deactivate__IdAssignment_1
            {
            pushFollow(FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl10789);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5365:1: rule__ParticipantCreation__Group__0 : rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 ;
    public final void rule__ParticipantCreation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5369:1: ( rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5370:2: rule__ParticipantCreation__Group__0__Impl rule__ParticipantCreation__Group__1
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__010823);
            rule__ParticipantCreation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__010826);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5377:1: rule__ParticipantCreation__Group__0__Impl : ( Create ) ;
    public final void rule__ParticipantCreation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5381:1: ( ( Create ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5382:1: ( Create )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5382:1: ( Create )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5383:1: Create
            {
             before(grammarAccess.getParticipantCreationAccess().getCreateKeyword_0()); 
            match(input,Create,FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl10854); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5396:1: rule__ParticipantCreation__Group__1 : rule__ParticipantCreation__Group__1__Impl ;
    public final void rule__ParticipantCreation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5400:1: ( rule__ParticipantCreation__Group__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5401:2: rule__ParticipantCreation__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__110885);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5407:1: rule__ParticipantCreation__Group__1__Impl : ( RULE_ID ) ;
    public final void rule__ParticipantCreation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5411:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5412:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5412:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5413:1: RULE_ID
            {
             before(grammarAccess.getParticipantCreationAccess().getIDTerminalRuleCall_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl10912); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5428:1: rule__Box__Group__0 : rule__Box__Group__0__Impl rule__Box__Group__1 ;
    public final void rule__Box__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5432:1: ( rule__Box__Group__0__Impl rule__Box__Group__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5433:2: rule__Box__Group__0__Impl rule__Box__Group__1
            {
            pushFollow(FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__010945);
            rule__Box__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__1_in_rule__Box__Group__010948);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5440:1: rule__Box__Group__0__Impl : ( Box ) ;
    public final void rule__Box__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5444:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5445:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5445:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5446:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_0()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__0__Impl10976); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5459:1: rule__Box__Group__1 : rule__Box__Group__1__Impl rule__Box__Group__2 ;
    public final void rule__Box__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5463:1: ( rule__Box__Group__1__Impl rule__Box__Group__2 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5464:2: rule__Box__Group__1__Impl rule__Box__Group__2
            {
            pushFollow(FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__111007);
            rule__Box__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__2_in_rule__Box__Group__111010);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5471:1: rule__Box__Group__1__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5475:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5476:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5476:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5477:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_1()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__1__Impl11038); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5490:1: rule__Box__Group__2 : rule__Box__Group__2__Impl rule__Box__Group__3 ;
    public final void rule__Box__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5494:1: ( rule__Box__Group__2__Impl rule__Box__Group__3 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5495:2: rule__Box__Group__2__Impl rule__Box__Group__3
            {
            pushFollow(FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__211069);
            rule__Box__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__3_in_rule__Box__Group__211072);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5502:1: rule__Box__Group__2__Impl : ( ( RULE_ID )* ) ;
    public final void rule__Box__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5506:1: ( ( ( RULE_ID )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5507:1: ( ( RULE_ID )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5507:1: ( ( RULE_ID )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5508:1: ( RULE_ID )*
            {
             before(grammarAccess.getBoxAccess().getIDTerminalRuleCall_2()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5509:1: ( RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5509:3: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Box__Group__2__Impl11100); 

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5519:1: rule__Box__Group__3 : rule__Box__Group__3__Impl rule__Box__Group__4 ;
    public final void rule__Box__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5523:1: ( rule__Box__Group__3__Impl rule__Box__Group__4 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5524:2: rule__Box__Group__3__Impl rule__Box__Group__4
            {
            pushFollow(FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__311131);
            rule__Box__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__4_in_rule__Box__Group__311134);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5531:1: rule__Box__Group__3__Impl : ( QuotationMark ) ;
    public final void rule__Box__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5535:1: ( ( QuotationMark ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5536:1: ( QuotationMark )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5536:1: ( QuotationMark )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5537:1: QuotationMark
            {
             before(grammarAccess.getBoxAccess().getQuotationMarkKeyword_3()); 
            match(input,QuotationMark,FOLLOW_QuotationMark_in_rule__Box__Group__3__Impl11162); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5550:1: rule__Box__Group__4 : rule__Box__Group__4__Impl rule__Box__Group__5 ;
    public final void rule__Box__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5554:1: ( rule__Box__Group__4__Impl rule__Box__Group__5 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5555:2: rule__Box__Group__4__Impl rule__Box__Group__5
            {
            pushFollow(FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__411193);
            rule__Box__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__5_in_rule__Box__Group__411196);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5562:1: rule__Box__Group__4__Impl : ( ( RULE_COLOR )? ) ;
    public final void rule__Box__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5566:1: ( ( ( RULE_COLOR )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5567:1: ( ( RULE_COLOR )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5567:1: ( ( RULE_COLOR )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5568:1: ( RULE_COLOR )?
            {
             before(grammarAccess.getBoxAccess().getCOLORTerminalRuleCall_4()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5569:1: ( RULE_COLOR )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_COLOR) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5569:3: RULE_COLOR
                    {
                    match(input,RULE_COLOR,FOLLOW_RULE_COLOR_in_rule__Box__Group__4__Impl11224); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5579:1: rule__Box__Group__5 : rule__Box__Group__5__Impl rule__Box__Group__6 ;
    public final void rule__Box__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5583:1: ( rule__Box__Group__5__Impl rule__Box__Group__6 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5584:2: rule__Box__Group__5__Impl rule__Box__Group__6
            {
            pushFollow(FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__511255);
            rule__Box__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__6_in_rule__Box__Group__511258);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5591:1: rule__Box__Group__5__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5595:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5596:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5596:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5597:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_5()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group__5__Impl11285); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5608:1: rule__Box__Group__6 : rule__Box__Group__6__Impl rule__Box__Group__7 ;
    public final void rule__Box__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5612:1: ( rule__Box__Group__6__Impl rule__Box__Group__7 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5613:2: rule__Box__Group__6__Impl rule__Box__Group__7
            {
            pushFollow(FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__611314);
            rule__Box__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__7_in_rule__Box__Group__611317);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5620:1: rule__Box__Group__6__Impl : ( ( rule__Box__Group_6__0 )* ) ;
    public final void rule__Box__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5624:1: ( ( ( rule__Box__Group_6__0 )* ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5625:1: ( ( rule__Box__Group_6__0 )* )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5625:1: ( ( rule__Box__Group_6__0 )* )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5626:1: ( rule__Box__Group_6__0 )*
            {
             before(grammarAccess.getBoxAccess().getGroup_6()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5627:1: ( rule__Box__Group_6__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==Participant||LA52_0==Boundary||(LA52_0>=Database && LA52_0<=Control)||LA52_0==Entity||LA52_0==Actor||LA52_0==RULE_NEWLINE) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5627:2: rule__Box__Group_6__0
            	    {
            	    pushFollow(FOLLOW_rule__Box__Group_6__0_in_rule__Box__Group__6__Impl11344);
            	    rule__Box__Group_6__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5637:1: rule__Box__Group__7 : rule__Box__Group__7__Impl rule__Box__Group__8 ;
    public final void rule__Box__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5641:1: ( rule__Box__Group__7__Impl rule__Box__Group__8 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5642:2: rule__Box__Group__7__Impl rule__Box__Group__8
            {
            pushFollow(FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__711375);
            rule__Box__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group__8_in_rule__Box__Group__711378);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5649:1: rule__Box__Group__7__Impl : ( End ) ;
    public final void rule__Box__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5653:1: ( ( End ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5654:1: ( End )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5654:1: ( End )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5655:1: End
            {
             before(grammarAccess.getBoxAccess().getEndKeyword_7()); 
            match(input,End,FOLLOW_End_in_rule__Box__Group__7__Impl11406); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5668:1: rule__Box__Group__8 : rule__Box__Group__8__Impl ;
    public final void rule__Box__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5672:1: ( rule__Box__Group__8__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5673:2: rule__Box__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__811437);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5679:1: rule__Box__Group__8__Impl : ( Box ) ;
    public final void rule__Box__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5683:1: ( ( Box ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5684:1: ( Box )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5684:1: ( Box )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5685:1: Box
            {
             before(grammarAccess.getBoxAccess().getBoxKeyword_8()); 
            match(input,Box,FOLLOW_Box_in_rule__Box__Group__8__Impl11465); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5716:1: rule__Box__Group_6__0 : rule__Box__Group_6__0__Impl rule__Box__Group_6__1 ;
    public final void rule__Box__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5720:1: ( rule__Box__Group_6__0__Impl rule__Box__Group_6__1 )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5721:2: rule__Box__Group_6__0__Impl rule__Box__Group_6__1
            {
            pushFollow(FOLLOW_rule__Box__Group_6__0__Impl_in_rule__Box__Group_6__011514);
            rule__Box__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Box__Group_6__1_in_rule__Box__Group_6__011517);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5728:1: rule__Box__Group_6__0__Impl : ( ( rule__Box__DefinitionsAssignment_6_0 )? ) ;
    public final void rule__Box__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5732:1: ( ( ( rule__Box__DefinitionsAssignment_6_0 )? ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5733:1: ( ( rule__Box__DefinitionsAssignment_6_0 )? )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5733:1: ( ( rule__Box__DefinitionsAssignment_6_0 )? )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5734:1: ( rule__Box__DefinitionsAssignment_6_0 )?
            {
             before(grammarAccess.getBoxAccess().getDefinitionsAssignment_6_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5735:1: ( rule__Box__DefinitionsAssignment_6_0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==Participant||LA53_0==Boundary||(LA53_0>=Database && LA53_0<=Control)||LA53_0==Entity||LA53_0==Actor) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5735:2: rule__Box__DefinitionsAssignment_6_0
                    {
                    pushFollow(FOLLOW_rule__Box__DefinitionsAssignment_6_0_in_rule__Box__Group_6__0__Impl11544);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5745:1: rule__Box__Group_6__1 : rule__Box__Group_6__1__Impl ;
    public final void rule__Box__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5749:1: ( rule__Box__Group_6__1__Impl )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5750:2: rule__Box__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__Box__Group_6__1__Impl_in_rule__Box__Group_6__111575);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5756:1: rule__Box__Group_6__1__Impl : ( RULE_NEWLINE ) ;
    public final void rule__Box__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5760:1: ( ( RULE_NEWLINE ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5761:1: ( RULE_NEWLINE )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5761:1: ( RULE_NEWLINE )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5762:1: RULE_NEWLINE
            {
             before(grammarAccess.getBoxAccess().getNEWLINETerminalRuleCall_6_1()); 
            match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rule__Box__Group_6__1__Impl11602); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5778:1: rule__Plantuml__DiagramsAssignment : ( ruleDiagram ) ;
    public final void rule__Plantuml__DiagramsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5782:1: ( ( ruleDiagram ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5783:1: ( ruleDiagram )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5783:1: ( ruleDiagram )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5784:1: ruleDiagram
            {
             before(grammarAccess.getPlantumlAccess().getDiagramsDiagramParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment11640);
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


    // $ANTLR start "rule__Diagram__InstructionsAssignment_3"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5793:1: rule__Diagram__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Diagram__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5797:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5798:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5798:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5799:1: ruleInstruction
            {
             before(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_311671);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getDiagramAccess().getInstructionsInstructionParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Diagram__InstructionsAssignment_3"


    // $ANTLR start "rule__Arrow__NameAssignment_0"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5808:1: rule__Arrow__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Arrow__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5812:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5813:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5813:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5814:1: RULE_ID
            {
             before(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_011702); 
             after(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_0_0()); 

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


    // $ANTLR start "rule__Arrow__NameAssignment_2"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5823:1: rule__Arrow__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Arrow__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5827:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5828:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5828:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5829:1: RULE_ID
            {
             before(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_211733); 
             after(grammarAccess.getArrowAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__Arrow__NameAssignment_2"


    // $ANTLR start "rule__Definition__NameAssignment_0_1"
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5838:1: rule__Definition__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5842:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5843:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5843:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5844:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111764); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_0_1_0()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5853:1: rule__Definition__NameAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5857:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5858:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5858:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5859:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111795); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_1_0()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5868:1: rule__Definition__NameAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5872:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5873:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5873:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5874:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111826); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_2_1_0()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5883:1: rule__Definition__NameAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5887:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5888:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5888:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5889:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111857); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_3_1_0()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5898:1: rule__Definition__NameAssignment_4_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5902:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5903:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5903:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5904:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111888); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_4_1_0()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5913:1: rule__Definition__NameAssignment_5_1 : ( RULE_ID ) ;
    public final void rule__Definition__NameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5917:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5918:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5918:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5919:1: RULE_ID
            {
             before(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_5_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_5_111919); 
             after(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_5_1_0()); 

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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5928:1: rule__AltElse__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__AltElse__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5932:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5933:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5933:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5934:1: ruleInstruction
            {
             before(grammarAccess.getAltElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_311950);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5943:1: rule__AltElse__ElsesAssignment_4 : ( ruleElse ) ;
    public final void rule__AltElse__ElsesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5947:1: ( ( ruleElse ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5948:1: ( ruleElse )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5948:1: ( ruleElse )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5949:1: ruleElse
            {
             before(grammarAccess.getAltElseAccess().getElsesElseParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_411981);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5958:1: rule__Else__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__Else__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5962:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5963:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5963:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5964:1: ruleInstruction
            {
             before(grammarAccess.getElseAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312012);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5973:1: rule__GroupingMessages__InstructionsAssignment_3 : ( ruleInstruction ) ;
    public final void rule__GroupingMessages__InstructionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5977:1: ( ( ruleInstruction ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5978:1: ( ruleInstruction )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5978:1: ( ruleInstruction )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5979:1: ruleInstruction
            {
             before(grammarAccess.getGroupingMessagesAccess().getInstructionsInstructionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_312043);
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5988:1: rule__Note__RidAssignment_1_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidAssignment_1_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5992:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5993:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5993:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5994:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionCrossReference_1_0_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5995:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:5996:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidDefinitionIDTerminalRuleCall_1_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidAssignment_1_0_1_112078); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6007:1: rule__Note__RidsAssignment_1_0_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__RidsAssignment_1_0_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6011:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6012:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6012:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6013:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionCrossReference_1_0_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6014:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6015:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getRidsDefinitionIDTerminalRuleCall_1_0_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_1_0_1_2_112117); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6026:1: rule__Note__LidAssignment_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidAssignment_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6030:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6031:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6031:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6032:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionCrossReference_1_1_1_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6033:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6034:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidDefinitionIDTerminalRuleCall_1_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidAssignment_1_1_1_112156); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6045:1: rule__Note__LidsAssignment_1_1_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__LidsAssignment_1_1_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6049:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6050:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6050:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6051:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionCrossReference_1_1_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6052:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6053:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getLidsDefinitionIDTerminalRuleCall_1_1_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_1_1_1_2_112195); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6064:1: rule__Note__OidAssignment_1_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6068:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6069:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6069:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6070:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionCrossReference_1_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6071:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6072:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidDefinitionIDTerminalRuleCall_1_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidAssignment_1_2_112234); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6083:1: rule__Note__OidsAssignment_1_2_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Note__OidsAssignment_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6087:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6088:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6088:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6089:1: ( RULE_ID )
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionCrossReference_1_2_2_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6090:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6091:1: RULE_ID
            {
             before(grammarAccess.getNoteAccess().getOidsDefinitionIDTerminalRuleCall_1_2_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_1_2_2_112273); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6102:1: rule__Reference__IdAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6106:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6107:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6107:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6108:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionCrossReference_2_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6109:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6110:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdDefinitionIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_212312); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6121:1: rule__Reference__IdsAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__IdsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6125:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6126:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6126:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6127:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionCrossReference_3_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6128:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6129:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getIdsDefinitionIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_112351); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6140:1: rule__Activate__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Activate__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6144:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6145:1: ( RULE_ID )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6145:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6146:1: RULE_ID
            {
             before(grammarAccess.getActivateAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_212386); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6155:1: rule__Deactivate__IdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Deactivate__IdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6159:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6160:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6160:1: ( ( RULE_ID ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6161:1: ( RULE_ID )
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateCrossReference_1_0()); 
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6162:1: ( RULE_ID )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6163:1: RULE_ID
            {
             before(grammarAccess.getDeactivateAccess().getIdActivateIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_112421); 
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
    // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6174:1: rule__Box__DefinitionsAssignment_6_0 : ( ruleDefinition ) ;
    public final void rule__Box__DefinitionsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6178:1: ( ( ruleDefinition ) )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6179:1: ( ruleDefinition )
            {
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6179:1: ( ruleDefinition )
            // ../org.xtext.plantuml.ui/src-gen/org/xtext/ui/contentassist/antlr/internal/InternalPlantumlParser.g:6180:1: ruleDefinition
            {
             before(grammarAccess.getBoxAccess().getDefinitionsDefinitionParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_6_012456);
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


 

    public static final BitSet FOLLOW_rulePlantuml_in_entryRulePlantuml54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlantuml61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Plantuml__DiagramsAssignment_in_rulePlantuml91 = new BitSet(new long[]{0x0004000000000002L});
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
    public static final BitSet FOLLOW_ruleAutoNumber_in_entryRuleAutoNumber375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAutoNumber382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0_in_ruleAutoNumber412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_entryRuleTitle439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTitle446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0_in_ruleTitle476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_entryRuleLegend503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLegend510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0_in_ruleLegend540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_entryRuleNewpage567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNewpage574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0_in_ruleNewpage604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_entryRuleAltElse631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAltElse638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0_in_ruleAltElse668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_entryRuleElse695 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleElse702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0_in_ruleElse732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_entryRuleGroupingMessages759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroupingMessages766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0_in_ruleGroupingMessages796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_entryRuleNote823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNote830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0_in_ruleNote860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_entryRuleDivider887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDivider894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0_in_ruleDivider924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_entryRuleDelay1015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDelay1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0_in_ruleDelay1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_entryRuleSpace1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpace1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Alternatives_in_ruleSpace1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_entryRuleHidefootbox1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHidefootbox1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0_in_ruleHidefootbox1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_entryRuleActivate1207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleActivate1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0_in_ruleActivate1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_entryRuleDeactivate1271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeactivate1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0_in_ruleDeactivate1308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_entryRuleParticipantCreation1335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParticipantCreation1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0_in_ruleParticipantCreation1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_entryRuleBox1399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBox1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0_in_ruleBox1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrow_in_rule__Instruction__Alternatives_01472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0_in_rule__Instruction__Alternatives_01489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAutoNumber_in_rule__Instruction__Alternatives_01507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTitle_in_rule__Instruction__Alternatives_01524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLegend_in_rule__Instruction__Alternatives_01541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNewpage_in_rule__Instruction__Alternatives_01558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAltElse_in_rule__Instruction__Alternatives_01575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupingMessages_in_rule__Instruction__Alternatives_01592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNote_in_rule__Instruction__Alternatives_01609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDivider_in_rule__Instruction__Alternatives_01626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Instruction__Alternatives_01643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDelay_in_rule__Instruction__Alternatives_01660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpace_in_rule__Instruction__Alternatives_01677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHidefootbox_in_rule__Instruction__Alternatives_01694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleActivate_in_rule__Instruction__Alternatives_01711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeactivate_in_rule__Instruction__Alternatives_01728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParticipantCreation_in_rule__Instruction__Alternatives_01745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBox_in_rule__Instruction__Alternatives_01762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Instruction__Alternatives_0_1_11794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_HEXCODE_in_rule__Instruction__Alternatives_0_1_11811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0_in_rule__Definition__Alternatives1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0_in_rule__Definition__Alternatives1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0_in_rule__Definition__Alternatives1879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0_in_rule__Definition__Alternatives1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0_in_rule__Definition__Alternatives1915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0_in_rule__Definition__Alternatives1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__0_in_rule__Definition__Alternatives_5_2_11966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__0_in_rule__Definition__Alternatives_5_2_11984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Alternatives_5_2_12002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Legend__Alternatives_12035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Legend__Alternatives_12055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Center_in_rule__Legend__Alternatives_12075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Opt_in_rule__GroupingMessages__Alternatives_02110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Loop_in_rule__GroupingMessages__Alternatives_02130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Par_in_rule__GroupingMessages__Alternatives_02150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Break_in_rule__GroupingMessages__Alternatives_02170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Critical_in_rule__GroupingMessages__Alternatives_02190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Group_in_rule__GroupingMessages__Alternatives_02210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0_in_rule__Note__Alternatives_12244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0_in_rule__Note__Alternatives_12262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0_in_rule__Note__Alternatives_12280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0_in_rule__Note__Alternatives_32313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0_in_rule__Note__Alternatives_32331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0_in_rule__Reference__Alternatives_42364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0_in_rule__Reference__Alternatives_42382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLineVerticalLine_in_rule__Space__Alternatives2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0_in_rule__Space__Alternatives2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Deactivate_in_rule__Deactivate__Alternatives_02469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Destroy_in_rule__Deactivate__Alternatives_02489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__0__Impl_in_rule__Diagram__Group__02521 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1_in_rule__Diagram__Group__02524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__1__Impl_in_rule__Diagram__Group__12582 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2_in_rule__Diagram__Group__12585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_START_in_rule__Diagram__Group__1__Impl2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__2__Impl_in_rule__Diagram__Group__22641 = new BitSet(new long[]{0x002A097BB57EBF70L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3_in_rule__Diagram__Group__22644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__2__Impl2671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__3__Impl_in_rule__Diagram__Group__32700 = new BitSet(new long[]{0x002A097BB57EBF70L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4_in_rule__Diagram__Group__32703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__InstructionsAssignment_3_in_rule__Diagram__Group__3__Impl2730 = new BitSet(new long[]{0x0022097BB57EBF72L});
    public static final BitSet FOLLOW_rule__Diagram__Group__4__Impl_in_rule__Diagram__Group__42761 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_rule__Diagram__Group__5_in_rule__Diagram__Group__42764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_END_in_rule__Diagram__Group__4__Impl2791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Diagram__Group__5__Impl_in_rule__Diagram__Group__52820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Diagram__Group__5__Impl2848 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__0__Impl_in_rule__Instruction__Group__02891 = new BitSet(new long[]{0x0022097BB57EBF70L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1_in_rule__Instruction__Group__02894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_in_rule__Instruction__Group__0__Impl2921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group__1__Impl_in_rule__Instruction__Group__12952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Instruction__Group__1__Impl2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__0__Impl_in_rule__Instruction__Group_0_1__03012 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1_in_rule__Instruction__Group_0_1__03015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Instruction__Group_0_1__0__Impl3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Group_0_1__1__Impl_in_rule__Instruction__Group_0_1__13071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Instruction__Alternatives_0_1_1_in_rule__Instruction__Group_0_1__1__Impl3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__0__Impl_in_rule__Arrow__Group__03133 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1_in_rule__Arrow__Group__03136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NameAssignment_0_in_rule__Arrow__Group__0__Impl3163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__1__Impl_in_rule__Arrow__Group__13193 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2_in_rule__Arrow__Group__13196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SEQUENCE_in_rule__Arrow__Group__1__Impl3223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__2__Impl_in_rule__Arrow__Group__23252 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3_in_rule__Arrow__Group__23255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__NameAssignment_2_in_rule__Arrow__Group__2__Impl3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group__3__Impl_in_rule__Arrow__Group__33312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0_in_rule__Arrow__Group__3__Impl3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__0__Impl_in_rule__Arrow__Group_3__03378 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1_in_rule__Arrow__Group_3__03381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Arrow__Group_3__0__Impl3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Arrow__Group_3__1__Impl_in_rule__Arrow__Group_3__13440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Arrow__Group_3__1__Impl3468 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__0__Impl_in_rule__Definition__Group_0__03503 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1_in_rule__Definition__Group_0__03506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Actor_in_rule__Definition__Group_0__0__Impl3534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_0__1__Impl_in_rule__Definition__Group_0__13565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_0_1_in_rule__Definition__Group_0__1__Impl3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__0__Impl_in_rule__Definition__Group_1__03626 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1_in_rule__Definition__Group_1__03629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boundary_in_rule__Definition__Group_1__0__Impl3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_1__1__Impl_in_rule__Definition__Group_1__13688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_1_1_in_rule__Definition__Group_1__1__Impl3715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__0__Impl_in_rule__Definition__Group_2__03749 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1_in_rule__Definition__Group_2__03752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Control_in_rule__Definition__Group_2__0__Impl3780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_2__1__Impl_in_rule__Definition__Group_2__13811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_2_1_in_rule__Definition__Group_2__1__Impl3838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__0__Impl_in_rule__Definition__Group_3__03872 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1_in_rule__Definition__Group_3__03875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Entity_in_rule__Definition__Group_3__0__Impl3903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_3__1__Impl_in_rule__Definition__Group_3__13934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_3_1_in_rule__Definition__Group_3__1__Impl3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__0__Impl_in_rule__Definition__Group_4__03995 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1_in_rule__Definition__Group_4__03998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Database_in_rule__Definition__Group_4__0__Impl4026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_4__1__Impl_in_rule__Definition__Group_4__14057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_4_1_in_rule__Definition__Group_4__1__Impl4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__0__Impl_in_rule__Definition__Group_5__04118 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1_in_rule__Definition__Group_5__04121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Participant_in_rule__Definition__Group_5__0__Impl4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__1__Impl_in_rule__Definition__Group_5__14180 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2_in_rule__Definition__Group_5__14183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__NameAssignment_5_1_in_rule__Definition__Group_5__1__Impl4210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5__2__Impl_in_rule__Definition__Group_5__24240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0_in_rule__Definition__Group_5__2__Impl4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__0__Impl_in_rule__Definition__Group_5_2__04304 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1_in_rule__Definition__Group_5_2__04307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LessThanSignLessThanSign_in_rule__Definition__Group_5_2__0__Impl4335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__1__Impl_in_rule__Definition__Group_5_2__14366 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2_in_rule__Definition__Group_5_2__14369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Alternatives_5_2_1_in_rule__Definition__Group_5_2__1__Impl4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2__2__Impl_in_rule__Definition__Group_5_2__24426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GreaterThanSignGreaterThanSign_in_rule__Definition__Group_5_2__2__Impl4454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__0__Impl_in_rule__Definition__Group_5_2_1_0__04491 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__1_in_rule__Definition__Group_5_2_1_0__04494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_0__0__Impl4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__1__Impl_in_rule__Definition__Group_5_2_1_0__14553 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__2_in_rule__Definition__Group_5_2_1_0__14556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_0__1__Impl4583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__2__Impl_in_rule__Definition__Group_5_2_1_0__24612 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__3_in_rule__Definition__Group_5_2_1_0__24615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Definition__Group_5_2_1_0__2__Impl4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__3__Impl_in_rule__Definition__Group_5_2_1_0__34674 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__4_in_rule__Definition__Group_5_2_1_0__34677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Definition__Group_5_2_1_0__3__Impl4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_0__4__Impl_in_rule__Definition__Group_5_2_1_0__44733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_0__4__Impl4761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__0__Impl_in_rule__Definition__Group_5_2_1_1__04802 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__1_in_rule__Definition__Group_5_2_1_1__04805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_rule__Definition__Group_5_2_1_1__0__Impl4833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__1__Impl_in_rule__Definition__Group_5_2_1_1__14864 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__2_in_rule__Definition__Group_5_2_1_1__14867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__1__Impl4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__2__Impl_in_rule__Definition__Group_5_2_1_1__24923 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__3_in_rule__Definition__Group_5_2_1_1__24926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Definition__Group_5_2_1_1__2__Impl4954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__3__Impl_in_rule__Definition__Group_5_2_1_1__34985 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__4_in_rule__Definition__Group_5_2_1_1__34988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Definition__Group_5_2_1_1__3__Impl5015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__4__Impl_in_rule__Definition__Group_5_2_1_1__45044 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__5_in_rule__Definition__Group_5_2_1_1__45047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightParenthesis_in_rule__Definition__Group_5_2_1_1__4__Impl5075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Definition__Group_5_2_1_1__5__Impl_in_rule__Definition__Group_5_2_1_1__55106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__Group_5_2_1_1__5__Impl5133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__0__Impl_in_rule__AutoNumber__Group__05174 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1_in_rule__AutoNumber__Group__05177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Autonumber_in_rule__AutoNumber__Group__0__Impl5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group__1__Impl_in_rule__AutoNumber__Group__15236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0_in_rule__AutoNumber__Group__1__Impl5263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__0__Impl_in_rule__AutoNumber__Group_1__05298 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1_in_rule__AutoNumber__Group_1__05301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__0__Impl5328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AutoNumber__Group_1__1__Impl_in_rule__AutoNumber__Group_1__15357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__AutoNumber__Group_1__1__Impl5385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__0__Impl_in_rule__Title__Group__05420 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Title__Group__1_in_rule__Title__Group__05423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__Title__Group__0__Impl5451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Title__Group__1__Impl_in_rule__Title__Group__15482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Title__Group__1__Impl5510 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__0__Impl_in_rule__Legend__Group__05545 = new BitSet(new long[]{0x0002000008810080L});
    public static final BitSet FOLLOW_rule__Legend__Group__1_in_rule__Legend__Group__05548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Legend_in_rule__Legend__Group__0__Impl5576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__1__Impl_in_rule__Legend__Group__15607 = new BitSet(new long[]{0x0002000008810080L});
    public static final BitSet FOLLOW_rule__Legend__Group__2_in_rule__Legend__Group__15610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Alternatives_1_in_rule__Legend__Group__1__Impl5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__2__Impl_in_rule__Legend__Group__25668 = new BitSet(new long[]{0x0002000008810080L});
    public static final BitSet FOLLOW_rule__Legend__Group__3_in_rule__Legend__Group__25671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0_in_rule__Legend__Group__2__Impl5698 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group__3__Impl_in_rule__Legend__Group__35729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Endlegend_in_rule__Legend__Group__3__Impl5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__0__Impl_in_rule__Legend__Group_2__05796 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1_in_rule__Legend__Group_2__05799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Legend__Group_2__0__Impl5826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Legend__Group_2__1__Impl_in_rule__Legend__Group_2__15855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Legend__Group_2__1__Impl5883 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__0__Impl_in_rule__Newpage__Group__05918 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1_in_rule__Newpage__Group__05921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Newpage_in_rule__Newpage__Group__0__Impl5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Newpage__Group__1__Impl_in_rule__Newpage__Group__15980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Newpage__Group__1__Impl6008 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__0__Impl_in_rule__AltElse__Group__06043 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1_in_rule__AltElse__Group__06046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Alt_in_rule__AltElse__Group__0__Impl6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__1__Impl_in_rule__AltElse__Group__16105 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2_in_rule__AltElse__Group__16108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__AltElse__Group__1__Impl6136 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__2__Impl_in_rule__AltElse__Group__26167 = new BitSet(new long[]{0x0022097FB77EBF70L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3_in_rule__AltElse__Group__26170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__AltElse__Group__2__Impl6197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__3__Impl_in_rule__AltElse__Group__36226 = new BitSet(new long[]{0x0022097FB77EBF70L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4_in_rule__AltElse__Group__36229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__InstructionsAssignment_3_in_rule__AltElse__Group__3__Impl6256 = new BitSet(new long[]{0x0022097BB57EBF72L});
    public static final BitSet FOLLOW_rule__AltElse__Group__4__Impl_in_rule__AltElse__Group__46287 = new BitSet(new long[]{0x0022097FB77EBF70L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5_in_rule__AltElse__Group__46290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AltElse__ElsesAssignment_4_in_rule__AltElse__Group__4__Impl6317 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_rule__AltElse__Group__5__Impl_in_rule__AltElse__Group__56348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__AltElse__Group__5__Impl6376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__0__Impl_in_rule__Else__Group__06419 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_rule__Else__Group__1_in_rule__Else__Group__06422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Else_in_rule__Else__Group__0__Impl6450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__1__Impl_in_rule__Else__Group__16481 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_rule__Else__Group__2_in_rule__Else__Group__16484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Else__Group__1__Impl6512 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__2__Impl_in_rule__Else__Group__26543 = new BitSet(new long[]{0x0022097BB57EBF70L});
    public static final BitSet FOLLOW_rule__Else__Group__3_in_rule__Else__Group__26546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Else__Group__2__Impl6573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__Group__3__Impl_in_rule__Else__Group__36602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Else__InstructionsAssignment_3_in_rule__Else__Group__3__Impl6629 = new BitSet(new long[]{0x0022097BB57EBF72L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__0__Impl_in_rule__GroupingMessages__Group__06668 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1_in_rule__GroupingMessages__Group__06671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Alternatives_0_in_rule__GroupingMessages__Group__0__Impl6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__1__Impl_in_rule__GroupingMessages__Group__16728 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2_in_rule__GroupingMessages__Group__16731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__GroupingMessages__Group__1__Impl6759 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__2__Impl_in_rule__GroupingMessages__Group__26790 = new BitSet(new long[]{0x0022097FB57EBF70L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3_in_rule__GroupingMessages__Group__26793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__GroupingMessages__Group__2__Impl6820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__3__Impl_in_rule__GroupingMessages__Group__36849 = new BitSet(new long[]{0x0022097FB57EBF70L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4_in_rule__GroupingMessages__Group__36852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__GroupingMessages__InstructionsAssignment_3_in_rule__GroupingMessages__Group__3__Impl6879 = new BitSet(new long[]{0x0022097BB57EBF72L});
    public static final BitSet FOLLOW_rule__GroupingMessages__Group__4__Impl_in_rule__GroupingMessages__Group__46910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__GroupingMessages__Group__4__Impl6938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__0__Impl_in_rule__Note__Group__06979 = new BitSet(new long[]{0x0000000048800000L});
    public static final BitSet FOLLOW_rule__Note__Group__1_in_rule__Note__Group__06982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group__0__Impl7010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__1__Impl_in_rule__Note__Group__17041 = new BitSet(new long[]{0x0203000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__2_in_rule__Note__Group__17044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_1_in_rule__Note__Group__1__Impl7071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__2__Impl_in_rule__Note__Group__27101 = new BitSet(new long[]{0x0203000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group__3_in_rule__Note__Group__27104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Note__Group__2__Impl7132 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group__3__Impl_in_rule__Note__Group__37163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Alternatives_3_in_rule__Note__Group__3__Impl7190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__0__Impl_in_rule__Note__Group_1_0__07228 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1_in_rule__Note__Group_1_0__07231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Right_in_rule__Note__Group_1_0__0__Impl7259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0__1__Impl_in_rule__Note__Group_1_0__17290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0_in_rule__Note__Group_1_0__1__Impl7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__0__Impl_in_rule__Note__Group_1_0_1__07352 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1_in_rule__Note__Group_1_0_1__07355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_1_0_1__0__Impl7383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__1__Impl_in_rule__Note__Group_1_0_1__17414 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2_in_rule__Note__Group_1_0_1__17417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidAssignment_1_0_1_1_in_rule__Note__Group_1_0_1__1__Impl7444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1__2__Impl_in_rule__Note__Group_1_0_1__27474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0_in_rule__Note__Group_1_0_1__2__Impl7501 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__0__Impl_in_rule__Note__Group_1_0_1_2__07538 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1_in_rule__Note__Group_1_0_1_2__07541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_0_1_2__0__Impl7569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_0_1_2__1__Impl_in_rule__Note__Group_1_0_1_2__17600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__RidsAssignment_1_0_1_2_1_in_rule__Note__Group_1_0_1_2__1__Impl7627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__0__Impl_in_rule__Note__Group_1_1__07661 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1_in_rule__Note__Group_1_1__07664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Left_in_rule__Note__Group_1_1__0__Impl7692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1__1__Impl_in_rule__Note__Group_1_1__17723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0_in_rule__Note__Group_1_1__1__Impl7750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__0__Impl_in_rule__Note__Group_1_1_1__07785 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1_in_rule__Note__Group_1_1_1__07788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Of_in_rule__Note__Group_1_1_1__0__Impl7816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__1__Impl_in_rule__Note__Group_1_1_1__17847 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2_in_rule__Note__Group_1_1_1__17850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidAssignment_1_1_1_1_in_rule__Note__Group_1_1_1__1__Impl7877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1__2__Impl_in_rule__Note__Group_1_1_1__27907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0_in_rule__Note__Group_1_1_1__2__Impl7934 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__0__Impl_in_rule__Note__Group_1_1_1_2__07971 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1_in_rule__Note__Group_1_1_1_2__07974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_1_1_2__0__Impl8002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_1_1_2__1__Impl_in_rule__Note__Group_1_1_1_2__18033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__LidsAssignment_1_1_1_2_1_in_rule__Note__Group_1_1_1_2__1__Impl8060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__0__Impl_in_rule__Note__Group_1_2__08094 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1_in_rule__Note__Group_1_2__08097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Note__Group_1_2__0__Impl8125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__1__Impl_in_rule__Note__Group_1_2__18156 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2_in_rule__Note__Group_1_2__18159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidAssignment_1_2_1_in_rule__Note__Group_1_2__1__Impl8186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2__2__Impl_in_rule__Note__Group_1_2__28216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0_in_rule__Note__Group_1_2__2__Impl8243 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__0__Impl_in_rule__Note__Group_1_2_2__08280 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1_in_rule__Note__Group_1_2_2__08283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Note__Group_1_2_2__0__Impl8311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_1_2_2__1__Impl_in_rule__Note__Group_1_2_2__18342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__OidsAssignment_1_2_2_1_in_rule__Note__Group_1_2_2__1__Impl8369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__0__Impl_in_rule__Note__Group_3_0__08403 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1_in_rule__Note__Group_3_0__08406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Note__Group_3_0__0__Impl8434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_0__1__Impl_in_rule__Note__Group_3_0__18465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_3_0__1__Impl8492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__0__Impl_in_rule__Note__Group_3_1__08525 = new BitSet(new long[]{0x0203000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1_in_rule__Note__Group_3_1__08528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0_in_rule__Note__Group_3_1__0__Impl8555 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__1__Impl_in_rule__Note__Group_3_1__18586 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2_in_rule__Note__Group_3_1__18589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1__1__Impl8616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__2__Impl_in_rule__Note__Group_3_1__28645 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__3_in_rule__Note__Group_3_1__28648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Note__Group_3_1__2__Impl8676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1__3__Impl_in_rule__Note__Group_3_1__38707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Note_in_rule__Note__Group_3_1__3__Impl8735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__0__Impl_in_rule__Note__Group_3_1_0__08774 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1_in_rule__Note__Group_3_1_0__08777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Note__Group_3_1_0__0__Impl8804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Note__Group_3_1_0__1__Impl_in_rule__Note__Group_3_1_0__18833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__Group_3_1_0__1__Impl8861 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__0__Impl_in_rule__Divider__Group__08896 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_rule__Divider__Group__1_in_rule__Divider__Group__08899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__0__Impl8927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__1__Impl_in_rule__Divider__Group__18958 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_rule__Divider__Group__2_in_rule__Divider__Group__18961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Divider__Group__1__Impl8989 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Divider__Group__2__Impl_in_rule__Divider__Group__29020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EqualsSignEqualsSign_in_rule__Divider__Group__2__Impl9048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0__Impl_in_rule__Reference__Group__09085 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__09088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group__0__Impl9116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__1__Impl_in_rule__Reference__Group__19147 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__19150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Over_in_rule__Reference__Group__1__Impl9178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__2__Impl_in_rule__Reference__Group__29209 = new BitSet(new long[]{0x0003800400000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__29212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdAssignment_2_in_rule__Reference__Group__2__Impl9239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__3__Impl_in_rule__Reference__Group__39269 = new BitSet(new long[]{0x0003800400000000L});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__39272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0_in_rule__Reference__Group__3__Impl9299 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4__Impl_in_rule__Reference__Group__49330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Alternatives_4_in_rule__Reference__Group__4__Impl9357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__0__Impl_in_rule__Reference__Group_3__09397 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1_in_rule__Reference__Group_3__09400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_rule__Reference__Group_3__0__Impl9428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_3__1__Impl_in_rule__Reference__Group_3__19459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__IdsAssignment_3_1_in_rule__Reference__Group_3__1__Impl9486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__0__Impl_in_rule__Reference__Group_4_0__09520 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1_in_rule__Reference__Group_4_0__09523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Colon_in_rule__Reference__Group_4_0__0__Impl9551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_0__1__Impl_in_rule__Reference__Group_4_0__19582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_4_0__1__Impl9610 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__0__Impl_in_rule__Reference__Group_4_1__09645 = new BitSet(new long[]{0x0003800400000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1_in_rule__Reference__Group_4_1__09648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0_in_rule__Reference__Group_4_1__0__Impl9675 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__1__Impl_in_rule__Reference__Group_4_1__19706 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2_in_rule__Reference__Group_4_1__19709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Reference__Group_4_1__1__Impl9737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1__2__Impl_in_rule__Reference__Group_4_1__29768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ref_in_rule__Reference__Group_4_1__2__Impl9796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__0__Impl_in_rule__Reference__Group_4_1_0__09833 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1_in_rule__Reference__Group_4_1_0__09836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Reference__Group_4_1_0__0__Impl9863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group_4_1_0__1__Impl_in_rule__Reference__Group_4_1_0__19892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__Group_4_1_0__1__Impl9920 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__0__Impl_in_rule__Delay__Group__09955 = new BitSet(new long[]{0x0020000080000000L});
    public static final BitSet FOLLOW_rule__Delay__Group__1_in_rule__Delay__Group__09958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group__0__Impl9986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group__1__Impl_in_rule__Delay__Group__110017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0_in_rule__Delay__Group__1__Impl10044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__0__Impl_in_rule__Delay__Group_1__010079 = new BitSet(new long[]{0x0020000080000000L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1_in_rule__Delay__Group_1__010082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Delay__Group_1__0__Impl10110 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Delay__Group_1__1__Impl_in_rule__Delay__Group_1__110141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStopFullStopFullStop_in_rule__Delay__Group_1__1__Impl10169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__0__Impl_in_rule__Space__Group_1__010204 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1_in_rule__Space__Group_1__010207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__0__Impl10235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__1__Impl_in_rule__Space__Group_1__110266 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2_in_rule__Space__Group_1__110269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__Space__Group_1__1__Impl10296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Space__Group_1__2__Impl_in_rule__Space__Group_1__210325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VerticalLineVerticalLine_in_rule__Space__Group_1__2__Impl10353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__0__Impl_in_rule__Hidefootbox__Group__010390 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1_in_rule__Hidefootbox__Group__010393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hide_in_rule__Hidefootbox__Group__0__Impl10421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Hidefootbox__Group__1__Impl_in_rule__Hidefootbox__Group__110452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Footbox_in_rule__Hidefootbox__Group__1__Impl10480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__0__Impl_in_rule__Activate__Group__010515 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_rule__Activate__Group__1_in_rule__Activate__Group__010518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Activate_in_rule__Activate__Group__0__Impl10546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__1__Impl_in_rule__Activate__Group__110577 = new BitSet(new long[]{0x0220000000000000L});
    public static final BitSet FOLLOW_rule__Activate__Group__2_in_rule__Activate__Group__110580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Activate__Group__1__Impl10608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__Group__2__Impl_in_rule__Activate__Group__210639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Activate__NameAssignment_2_in_rule__Activate__Group__2__Impl10666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__0__Impl_in_rule__Deactivate__Group__010702 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1_in_rule__Deactivate__Group__010705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Alternatives_0_in_rule__Deactivate__Group__0__Impl10732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__Group__1__Impl_in_rule__Deactivate__Group__110762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Deactivate__IdAssignment_1_in_rule__Deactivate__Group__1__Impl10789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__0__Impl_in_rule__ParticipantCreation__Group__010823 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1_in_rule__ParticipantCreation__Group__010826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Create_in_rule__ParticipantCreation__Group__0__Impl10854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParticipantCreation__Group__1__Impl_in_rule__ParticipantCreation__Group__110885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ParticipantCreation__Group__1__Impl10912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__0__Impl_in_rule__Box__Group__010945 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__1_in_rule__Box__Group__010948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__0__Impl10976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__1__Impl_in_rule__Box__Group__111007 = new BitSet(new long[]{0x0020100000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__2_in_rule__Box__Group__111010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__1__Impl11038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__2__Impl_in_rule__Box__Group__211069 = new BitSet(new long[]{0x0020100000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__3_in_rule__Box__Group__211072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Box__Group__2__Impl11100 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__3__Impl_in_rule__Box__Group__311131 = new BitSet(new long[]{0x0202000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__4_in_rule__Box__Group__311134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QuotationMark_in_rule__Box__Group__3__Impl11162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__4__Impl_in_rule__Box__Group__411193 = new BitSet(new long[]{0x0202000000000000L});
    public static final BitSet FOLLOW_rule__Box__Group__5_in_rule__Box__Group__411196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COLOR_in_rule__Box__Group__4__Impl11224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__5__Impl_in_rule__Box__Group__511255 = new BitSet(new long[]{0x0002000400141A10L});
    public static final BitSet FOLLOW_rule__Box__Group__6_in_rule__Box__Group__511258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group__5__Impl11285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__6__Impl_in_rule__Box__Group__611314 = new BitSet(new long[]{0x0002000400141A10L});
    public static final BitSet FOLLOW_rule__Box__Group__7_in_rule__Box__Group__611317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__0_in_rule__Box__Group__6__Impl11344 = new BitSet(new long[]{0x0002000000141A12L});
    public static final BitSet FOLLOW_rule__Box__Group__7__Impl_in_rule__Box__Group__711375 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Box__Group__8_in_rule__Box__Group__711378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_End_in_rule__Box__Group__7__Impl11406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group__8__Impl_in_rule__Box__Group__811437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Box_in_rule__Box__Group__8__Impl11465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__0__Impl_in_rule__Box__Group_6__011514 = new BitSet(new long[]{0x0002000000141A10L});
    public static final BitSet FOLLOW_rule__Box__Group_6__1_in_rule__Box__Group_6__011517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__DefinitionsAssignment_6_0_in_rule__Box__Group_6__0__Impl11544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Box__Group_6__1__Impl_in_rule__Box__Group_6__111575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_rule__Box__Group_6__1__Impl11602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDiagram_in_rule__Plantuml__DiagramsAssignment11640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Diagram__InstructionsAssignment_311671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_011702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Arrow__NameAssignment_211733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_0_111764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_1_111795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_2_111826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_3_111857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_4_111888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Definition__NameAssignment_5_111919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__AltElse__InstructionsAssignment_311950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleElse_in_rule__AltElse__ElsesAssignment_411981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__Else__InstructionsAssignment_312012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstruction_in_rule__GroupingMessages__InstructionsAssignment_312043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidAssignment_1_0_1_112078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__RidsAssignment_1_0_1_2_112117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidAssignment_1_1_1_112156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__LidsAssignment_1_1_1_2_112195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidAssignment_1_2_112234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Note__OidsAssignment_1_2_2_112273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdAssignment_212312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__IdsAssignment_3_112351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Activate__NameAssignment_212386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Deactivate__IdAssignment_112421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefinition_in_rule__Box__DefinitionsAssignment_6_012456 = new BitSet(new long[]{0x0000000000000002L});

}